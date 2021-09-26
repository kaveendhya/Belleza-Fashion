package com.example.bellezafashion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;


public class deliveryfee extends AppCompatActivity {


    ArrayList<Double> totalcharge = new ArrayList<Double>();

    double in1 = 290, i2 = 200, i3 = 300;

    TextView display1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deliveryfee);

        display1 = (TextView) findViewById(R.id.display1);
        display1.setEnabled(false);

        Button next = (Button) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(deliveryfee.this, dpolicy.class);
                startActivity(intent5);
            }

        });
    }
    public void selectItem(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.fastdelivery:

                if (checked) {
                    totalcharge.add(in1 + i2);
                } else {
                    //totalcharge.remove("fastdeliver");
                    totalcharge.remove(in1 + i2);

                }
                break;


            case R.id.packaging:

                if (checked) {
                    totalcharge.add(in1 + i3);
                } else {
                    //totalcharge.remove("packaging");
                    totalcharge.remove(in1 + i3);
                }
                break;


        }
    }


    public void FinalCharge(View view){

        String finaldelcharge ="RS:" + totalcharge + "0";
        //for (double totalcharges: totalcharge) {
        //finaldelcharge += totalcharge;
        //}
        display1.setText(finaldelcharge.replace("[","").replace("]",""));
        display1.setEnabled(true);



    }

}