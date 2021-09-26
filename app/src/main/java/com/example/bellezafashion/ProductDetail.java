package com.example.bellezafashion;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bellezafashion.Model.Product;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class ProductDetail extends AppCompatActivity {

    private TextView in_product_detail_price,in_product_detail_designer,in_product_detail_description,in_product_detail_name;
    private ImageView in_product_image_detail;
    private Button in_product_add_to_cart;
  //  ElegantNumberButton in_number_BTN;
    private Product product;
    private String productID="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        productID = getIntent().getStringExtra("pid");

        in_product_detail_name = (TextView)findViewById(R.id.in_product_detail_name);
        in_product_detail_price = (TextView)findViewById(R.id.in_product_detail_price);
        in_product_detail_designer = (TextView)findViewById(R.id.in_product_detail_designer);
        in_product_detail_description = (TextView)findViewById(R.id.in_product_detail_description);
        in_product_image_detail = (ImageView)findViewById(R.id.in_product_image_detail);
        in_product_add_to_cart = (Button)findViewById(R.id.in_product_add_to_cart);
       // in_number_BTN = (ElegantNumberButton)findViewById(R.id.in_number_BTN);


        getProductInfo(productID);

    }

    private void getProductInfo(String productID) {

        DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("Products");


        dbRef.child(productID).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot snapshot) {
                if(snapshot.exists()){

                        Product product = snapshot.getValue(Product.class);
                        in_product_detail_name.setText(product.getName());
                        in_product_detail_price.setText(product.getPrice());
                        in_product_detail_designer.setText(product.getDesigner());
                        in_product_detail_description.setText(product.getDescription());
                        Picasso.get().load(product.getImage()).into(in_product_image_detail);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


}