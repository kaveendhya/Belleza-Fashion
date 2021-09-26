package com.example.bellezafashion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Designercalculation extends AppCompatActivity {

    public static final String TAG ="Designercalculation";
    public static String dessID;


    Button btn_Desprod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_designercalculation);

        Intent intent = getIntent();

        btn_Desprod = findViewById(R.id.btn_Desprod);
    }

    public void DesignPrice(View view){
        Intent intent = new Intent(this, DesignerCalculation2.class);
        EditText et_DesCostID =(EditText) findViewById(R.id.et_DesCostID);
        String Diid = et_DesCostID.getText().toString();
        intent.putExtra(dessID,Diid);
        startActivity(intent);

    }
}