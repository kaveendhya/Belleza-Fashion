package com.example.bellezafashion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class deliveryhome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deliveryhome);
        Button deliverydetails = (Button) findViewById(R.id.deliverydetails);
        deliverydetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(deliveryhome.this, newdeliverydetails.class);
                startActivity(intent1);
            }

        });
        Button fee = (Button) findViewById(R.id.fee);
        fee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(deliveryhome.this, deliveryfee.class);
                startActivity(intent2);
            }

        });
        Button policy = (Button) findViewById(R.id.policy);
        policy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(deliveryhome.this, dpolicy.class);
                startActivity(intent3);
            }

        });
    }
}