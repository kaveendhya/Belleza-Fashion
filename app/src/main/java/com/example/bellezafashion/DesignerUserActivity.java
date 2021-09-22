package com.example.bellezafashion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DesignerUserActivity extends AppCompatActivity {

    Button btn_DesiList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_designer_user);

        Intent intent = getIntent();

        btn_DesiList = findViewById(R.id.btn_DesiList);
    }
    public void DesignList(View view){
        Intent intent = new Intent(this, Designerlist.class);
        startActivity(intent);

    }
}