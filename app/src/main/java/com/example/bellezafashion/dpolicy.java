package com.example.bellezafashion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;


public class dpolicy extends AppCompatActivity {
    CheckBox chkbox;
    Button confirmpolicy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dpolicy);

        Button calender = (Button) findViewById(R.id.calender);
        calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent6 = new Intent(dpolicy.this, deliveryview.class);
                startActivity(intent6);
            }

        });

        confirmpolicy = (Button) findViewById(R.id.confirmpolicy);
        chkbox = (CheckBox) findViewById(R.id.agree);

        confirmpolicy.setOnClickListener(new View.OnClickListener() {


        @Override
        public void onClick(View v) {
            if(chkbox.isChecked()){
                //do some validation
                Toast.makeText(dpolicy.this, "Order Confirmed", Toast.LENGTH_SHORT).show();
            }
            else
            {
                chkbox.requestFocus();
                chkbox.setError("You Must Agree to Confirm!");
            }
        }
    });
}
}