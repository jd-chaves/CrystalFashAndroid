package dev.jcrystal.crystalfash.ui.home;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import dev.jcrystal.crystalfash.R;
import dev.jcrystal.crystalfash.models.Product;
import jcrystal.mobile.entities.ProductNormal;
import jcrystal.mobile.entities.enums.Categories;
import jcrystal.mobile.net.controllers.ManagerCart;
import jcrystal.mobile.net.controllers.ManagerProduct;
import jcrystal.mobile.net.utils.On1SuccessListener;
import jcrystal.mobile.net.utils.On2SuccessListener;
import jcrystal.mobile.net.utils.OnErrorListener;
import jcrystal.mobile.net.utils.RequestError;

public class HomeFragment extends Fragment implements On1SuccessListener {

    private List<Product> lstProducts = new ArrayList<>();

    private List<String> categories = new ArrayList<>();

    private CategoryAdapter categoryAdapter;

    private ProductAdapter myAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        lstProducts = new ArrayList<>();
        ManagerProduct.getProducts( this, this,  (OnErrorListener) this.getActivity());


        View root = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView myrv = (RecyclerView) root.findViewById(R.id.recyclerview_id);
        myAdapter = new ProductAdapter(getContext(),lstProducts);
        myrv.setLayoutManager(new GridLayoutManager(getContext(),2));
        myrv.setAdapter(myAdapter);

        ManagerProduct.getCategories(this,  this, (OnErrorListener) this.getActivity() );


        RecyclerView rv_category = (RecyclerView) root.findViewById(R.id.recyclerview_category_id);
        categoryAdapter = new CategoryAdapter(getActivity(),categories, this);
        rv_category.setLayoutManager(new GridLayoutManager(getContext(),3));
        rv_category.setAdapter(categoryAdapter);

        return root;
    }

    @Override
    public void onSuccess(Object o) {
        if(o == null)
            return;
        ArrayList temp = (ArrayList) o;
        if( temp.size()==0)
            return;
        if(temp.get(0) instanceof ProductNormal){
        ProductNormal temp1;
        for(int i=0;i<temp.size();i++){
            temp1 = (ProductNormal) temp.get(i);
            lstProducts.add(new Product(temp1.name(), temp1.category().getName(), temp1.description(), temp1.image(), temp1.price(), temp1.oldPrice()));
        }
        myAdapter.notifyDataSetChanged();
        }
        else{
            categories = temp;
            categoryAdapter.notifyDataSetChanged();
        }
    }


}