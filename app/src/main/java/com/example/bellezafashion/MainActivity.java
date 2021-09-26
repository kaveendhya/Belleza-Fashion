package com.example.bellezafashion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_designer,btn_List;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_designer = findViewById(R.id.btn_designer);
        btn_List = findViewById(R.id.btn_List);


    }

    public void Designer(View view){
        Intent intent = new Intent(this, DesignerActivity2.class);
        startActivity(intent);

    }
    public void List(View view){
        Intent intent = new Intent(this, DesignerUserActivity.class);
        startActivity(intent);

    }
}