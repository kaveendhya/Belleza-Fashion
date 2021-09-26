package com.example.bellezafashion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class AdminItemCategory extends AppCompatActivity {
    private ImageView in_athletic,in_bathik,in_dresse,in_hoody,in_jacket,in_jumpsuit,in_office_attire,in_pant,in_saree,in_skirt,in_swimwear,in_top;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_item_category);
        in_athletic=(ImageView)findViewById(R.id.in_athletic);
        in_bathik=(ImageView)findViewById(R.id.in_bathik);
        in_dresse=(ImageView)findViewById(R.id.in_dresses);
        in_hoody=(ImageView)findViewById(R.id.in_hoodies);
        in_jacket=(ImageView)findViewById(R.id.in_jackets);
        in_jumpsuit=(ImageView)findViewById(R.id.in_jump_suit);
        in_office_attire=(ImageView)findViewById(R.id.in_office_attire);
        in_pant=(ImageView)findViewById(R.id.in_pants);
        in_saree=(ImageView)findViewById(R.id.in_saree);
        in_skirt=(ImageView)findViewById(R.id.in_skirt);
        in_swimwear=(ImageView)findViewById(R.id.in_swimwear);
        in_top=(ImageView)findViewById(R.id.in_top);


        in_athletic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminItemCategory.this,AdminAddProducts.class);
                intent.putExtra("category","n_athletic");
                startActivity(intent);

            }
        });
        in_bathik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminItemCategory.this,AdminAddProducts.class);
                intent.putExtra("category","n_bathik");
                startActivity(intent);
            }
        });
        in_dresse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminItemCategory.this,AdminAddProducts.class);
                intent.putExtra("category","n_dresse");
                startActivity(intent);
            }
        });
        in_hoody.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminItemCategory.this,AdminAddProducts.class);
                intent.putExtra("category","n_hoody");
                startActivity(intent);
            }
        });

       in_jacket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminItemCategory.this,AdminAddProducts.class);
                intent.putExtra("category","n_jacket");
                startActivity(intent);
            }
        });
        in_jumpsuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminItemCategory.this,AdminAddProducts.class);
                intent.putExtra("category","n_jumpsuit");
                startActivity(intent);
            }
        });

        in_office_attire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminItemCategory.this,AdminAddProducts.class);
                intent.putExtra("category","n_office_attire");
                startActivity(intent);
            }
        });
        in_pant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminItemCategory.this,AdminAddProducts.class);
                intent.putExtra("category","n_pant");
                startActivity(intent);
            }
        });
        in_saree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminItemCategory.this,AdminAddProducts.class);
                intent.putExtra("category","n_saree");
                startActivity(intent);
            }
        });
        in_skirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminItemCategory.this,AdminAddProducts.class);
                intent.putExtra("category","n_skirt");
                startActivity(intent);
            }
        });
        in_swimwear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminItemCategory.this,AdminAddProducts.class);
                intent.putExtra("category","n_swimwear");
                startActivity(intent);
            }
        });
        in_top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminItemCategory.this,AdminAddProducts.class);
                intent.putExtra("category","n_top");
                startActivity(intent);
            }
        });
    }


}