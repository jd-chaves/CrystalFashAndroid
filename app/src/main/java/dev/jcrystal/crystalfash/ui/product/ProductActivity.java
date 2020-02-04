package dev.jcrystal.crystalfash.ui.product;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

import dev.jcrystal.crystalfash.R;
import dev.jcrystal.crystalfash.models.Product;
import jcrystal.mobile.entities.ProductNormal;
import jcrystal.mobile.net.controllers.ManagerProduct;
import jcrystal.mobile.net.utils.On1SuccessListener;
import jcrystal.mobile.net.utils.OnErrorListener;
import jcrystal.mobile.net.utils.RequestError;

public class ProductActivity extends AppCompatActivity implements On1SuccessListener<ProductNormal>, OnErrorListener {
    private TextView txtName,txtDescription,txtCategory, txtPrice, txtOldPrice;
    private ImageView img;
    Button btnAdd2Cart;
    private Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        txtName = (TextView) findViewById(R.id.product_detail_name);
        txtDescription = (TextView) findViewById(R.id.product_detail_desc);
        txtCategory = (TextView) findViewById(R.id.product_detail_category);
        img = (ImageView) findViewById(R.id.product_detail_img);
        txtPrice = (TextView) findViewById(R.id.product_detail_price);
        txtOldPrice = (TextView) findViewById(R.id.product_detail_old_price);
        btnAdd2Cart = findViewById(R.id.button_add_cart);

        // Recieve data
        Intent intent = getIntent();
        long idProduct = intent.getExtras().getLong("idProduct");

        ManagerProduct.getProductById(this, idProduct,  this);

        // Setting values



        btnAdd2Cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO
                Toast.makeText(getApplicationContext(), "Item has been added to your cart", Toast.LENGTH_LONG).show();
                finish();
            }
        });

    }

    @Override
    public void onSuccess(ProductNormal productNormal) {
        product = new Product( productNormal.name(), productNormal.category().getName(), productNormal.description(),productNormal.image(), product.getPrice(), product.getOldPrice());
        txtName.setText(product.getName());
        txtDescription.setText(product.getDescription());
        txtCategory.setText(product.getCategory());
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        txtPrice.setText(formatter.format(product.getPrice()));
        txtOldPrice.setText(formatter.format(product.getOldPrice()));
        Picasso.get().load(product.getImage()).into(img);
    }

    @Override
    public void onError(RequestError error) {
        Toast.makeText(this, error.mensaje, Toast.LENGTH_SHORT);
    }
}
