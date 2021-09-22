package com.example.bellezafashion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DesignerActivity2 extends AppCompatActivity {

    Button btn_addDesigner,btn_Current;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_designer2);

        btn_addDesigner = findViewById(R.id.btn_addDesigner);
        btn_Current = findViewById(R.id.btn_Current);

        Intent intent = getIntent();

    }

    public void Designerset(View view){
        Intent intent = new Intent(this, DesignerActivity3.class);
        startActivity(intent);
    }

    public void CurrentDes(View view){
        Intent intent = new Intent(this, currentDesignActivity.class);
        startActivity(intent);
    }
}