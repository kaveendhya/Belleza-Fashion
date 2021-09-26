package com.example.bellezafashion;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bellezafashion.Model.Product;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class SearchPriducts extends AppCompatActivity {
    private Button in_product_search;
    private EditText in_search_product_name;
    RecyclerView in_product_searched_list;
    String searchInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_priducts);

        in_product_search = findViewById(R.id.in_product_search);
        in_search_product_name =  findViewById(R.id.in_search_product_name);
        in_product_searched_list = findViewById(R.id.in_product_searched_list);
        in_product_searched_list.setLayoutManager(new LinearLayoutManager(SearchPriducts.this));

        in_product_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchInput = in_search_product_name.getText().toString();
                onStart();
            }
        });
    }

    protected  void  onStart(){
        super.onStart();

        DatabaseReference reference1 = FirebaseDatabase.getInstance().getReference().child("Products");
        FirebaseRecyclerOptions<Product> options = new FirebaseRecyclerOptions.Builder<Product>()
                .setQuery(reference1.orderByChild("name").startAt(searchInput),Product.class)
                .build();

        FirebaseRecyclerAdapter<Product, ProductAdapter.ProductViewHolder> adapter =
                new FirebaseRecyclerAdapter<Product, ProductAdapter.ProductViewHolder>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull ProductAdapter.ProductViewHolder holder, int position, Product model) {

                        holder.in_txt_name.setText(model.getName());
                        holder.in_txt_price.setText(model.getPrice());
                        holder.in_txt_designer.setText(model.getDesigner());
                        holder.in_txt_description.setText(model.getDescription());
                        Picasso.get().load(model.getImage()).into(holder.in_txt_image);


                        holder.cardView_list.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(SearchPriducts.this,ProductDetail.class);

                                intent.putExtra("pid",model.getPid());

                               startActivity(intent);

                            }
                        });
                    }

                    @NonNull

                    @Override
                    public ProductAdapter.ProductViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
                        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list,parent,false);

                        return new ProductAdapter.ProductViewHolder(view);
                    }
                };
                in_product_searched_list.setAdapter(adapter);
                adapter.startListening();
    }

}