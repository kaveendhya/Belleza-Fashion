package com.example.bellezafashion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



public class DesignerActivity3 extends AppCompatActivity {

    EditText et_DesignerID,et_designerN,et_designerOcc,et_email,et_phone,et_cost;
    Button btn_add;
    Designer Desg;
    DatabaseReference debRef;
    String regexStr = "[0][1,7][0-9]{9}";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_designer3);

        Intent intent = getIntent();

        et_DesignerID = findViewById(R.id.et_DesignerID);
        et_designerN = findViewById(R.id.et_designerN);
        et_designerOcc = findViewById(R.id.et_designerOcc);
        et_email = findViewById(R.id.et_email);
        et_phone = findViewById(R.id.et_phone);
        et_cost = findViewById(R.id.et_cost);
        btn_add = findViewById(R.id.btn_add);


        Desg = new Designer();
    }

    public void Clearcontrol(){
        et_DesignerID.setText("");
        et_designerN.setText("");
        et_designerOcc.setText("");
        et_email.setText("");
        et_phone.setText("");
        et_cost.setText("");

    }

    public void CreateDesigner(View view){

        debRef = FirebaseDatabase.getInstance().getReference().child("Designer");

        try{
            if(TextUtils.isEmpty(et_DesignerID.getText().toString()))
                Toast.makeText(getApplicationContext(), "please enter Designer ID", Toast.LENGTH_SHORT).show();
            else if(TextUtils.isEmpty(et_designerN.getText().toString()))
                Toast.makeText(getApplicationContext(),"Please enter Designer name", Toast.LENGTH_SHORT).show();
            else if(TextUtils.isEmpty(et_designerOcc.getText().toString()))
                Toast.makeText(getApplicationContext(),"Please enter address", Toast.LENGTH_SHORT).show();
            else if(TextUtils.isEmpty(et_email.getText().toString()))
                Toast.makeText(getApplicationContext(),"Please enter email", Toast.LENGTH_SHORT).show();
            else if(TextUtils.isEmpty(et_phone.getText().toString()))
                Toast.makeText(getApplicationContext(),"Please enter phone number", Toast.LENGTH_SHORT).show();
            else if(TextUtils.isEmpty(et_cost.getText().toString()))
                Toast.makeText(getApplicationContext(),"Please enter design cost", Toast.LENGTH_SHORT).show();
            else if (!Patterns.EMAIL_ADDRESS.matcher(et_email.getText().toString()).matches())
                Toast.makeText(getApplicationContext(),"invalid Email address", Toast.LENGTH_SHORT).show();
            else if ((et_phone.getText().toString().length()> 10) || !et_phone.getText().toString().matches(regexStr)){
                    Toast.makeText(getApplicationContext(),"invalid Email address", Toast.LENGTH_SHORT).show();
            //else if ()

            } else{
                Desg.setDesignerID(et_DesignerID.getText().toString().trim());
                Desg.setDesignerName(et_designerN.getText().toString().trim());
                Desg.setOccupation(et_designerOcc.getText().toString().trim());
                Desg.setEmail(et_email.getText().toString().trim());
                Desg.setPhone(Integer.parseInt(et_phone.getText().toString().trim()));
                Desg.setCost(Integer.parseInt(et_cost.getText().toString().trim()));

                debRef.child(et_DesignerID.getText().toString()).setValue(Desg);

                Toast.makeText(getApplicationContext(), "Data inserted successfully",Toast.LENGTH_SHORT).show();
                Clearcontrol();

            }

        }catch (NumberFormatException e){
            Toast.makeText(getApplicationContext(), "Invalid contact number or cost",Toast.LENGTH_SHORT).show();
        }

    }


}