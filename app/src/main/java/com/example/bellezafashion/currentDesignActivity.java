package com.example.bellezafashion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class currentDesignActivity extends AppCompatActivity {
    public static final String TAG = "currentDesignActivity";
    public static String desID;
   // EditText et_search;
    Button btn_Search;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_design);

        btn_Search = findViewById(R.id.btn_Search);

        Intent intent = getIntent();
    }

    public void UpPage(View view){
        Intent intent = new Intent(this, DesignerprofileActivity.class);
        EditText et_search =(EditText) findViewById(R.id.et_search);
        String Did = et_search.getText().toString();
        intent.putExtra(desID,Did);
        startActivity(intent);
    }
}