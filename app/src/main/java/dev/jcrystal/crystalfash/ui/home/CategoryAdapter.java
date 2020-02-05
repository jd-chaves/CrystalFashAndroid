package dev.jcrystal.crystalfash.ui.home;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dev.jcrystal.crystalfash.R;
import jcrystal.mobile.entities.ProductNormal;
import jcrystal.mobile.entities.enums.Categories;
import jcrystal.mobile.net.controllers.ManagerProduct;
import jcrystal.mobile.net.utils.On1SuccessListener;
import jcrystal.mobile.net.utils.OnErrorListener;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {
    private Context mContext ;
    private List<String> mData ;
    private HomeFragment homeFragment;

    public CategoryAdapter(Context mContext, List<String> mData, HomeFragment homeFragment) {
        this.mContext = mContext;
        this.mData = mData;
        this.homeFragment = homeFragment;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_category,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CategoryAdapter.MyViewHolder holder, int position) {
        holder.txtCategory.setText(mData.get(position));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ManagerProduct.filterProductsByCategory((Activity) mContext, Categories.valueOf(mData.get(position)),(On1SuccessListener<List<ProductNormal>>) homeFragment, (OnErrorListener) homeFragment);
                Toast.makeText(mContext,  holder.txtCategory.getText(), Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtCategory;
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);

            txtCategory = (TextView) itemView.findViewById(R.id.txt_category) ;
            cardView = (CardView) itemView.findViewById(R.id.cardview_category_id);


        }
    }
}
