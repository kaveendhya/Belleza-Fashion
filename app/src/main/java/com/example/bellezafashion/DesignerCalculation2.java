package com.example.bellezafashion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DesignerCalculation2 extends AppCompatActivity {

    private static final String TAG ="DesignerCalculation2";
    String dessID;
    DatabaseReference dbReff;
    Designer desss;

    EditText et_desCost;
    TextView tv_desBasicp,Tv_desMet,tv_desTypep;
    ImageButton Ibtn_desDress,Ibtn_jump,Img_desSaree,ing_skirtDes;
    Button btn_desSilk,btn_desbathik,btn_desCotton,btn_desLinon,btn_desCasual,btn_desParty,btn_Resetdes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_designer_calculation2);

        Intent intent = getIntent();
        dessID= intent.getStringExtra(Designercalculation.dessID);

        final DatabaseReference readReff = FirebaseDatabase.getInstance().getReference().child("Designer").child(dessID);

        et_desCost = findViewById(R.id.et_desCost);
        tv_desBasicp =findViewById(R.id.tv_desBasicp);
        Tv_desMet = findViewById(R.id.Tv_desMet);
        tv_desTypep =findViewById(R.id.tv_desTypep);
        Ibtn_desDress=findViewById(R.id.Ibtn_desDress);
        Ibtn_jump= findViewById(R.id.Ibtn_jump);
        Img_desSaree = findViewById(R.id.Img_desSaree);
        ing_skirtDes = findViewById(R.id.ing_skirtDes);
        btn_desSilk = findViewById(R.id.btn_desSilk);
        btn_desbathik=findViewById(R.id.btn_desbathik);
        btn_desCotton = findViewById(R.id.btn_desCotton);
        btn_desLinon =findViewById(R.id.btn_desLinon);
        btn_desCasual=findViewById(R.id.btn_desCasual);
        btn_desParty =findViewById(R.id.btn_desParty);
        btn_Resetdes =findViewById(R.id.btn_Resetdes);
        desss = new Designer();


        readReff.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull  DataSnapshot dataSnapshot) {

                if(dataSnapshot.hasChildren()){

                    desss.setCost(Integer.parseInt(dataSnapshot.child("cost").getValue().toString()));

                    et_desCost.setText(desss.getCost().toString());
                }else {
                    Toast.makeText(getApplicationContext(), "Invalid Desiner ID",Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(@NonNull  DatabaseError databaseError) {

            }
        });

    }

    public void saree(View view){

        int num1 = Integer.parseInt(et_desCost.getText().toString());

        int saree = num1 +4000;
        tv_desBasicp.setText(Integer.toString(saree));
    }

    public void dress(View view){

        int num2 = Integer.parseInt(et_desCost.getText().toString());

        int dress = num2 +3000;
        tv_desBasicp.setText(Integer.toString(dress));
    }

    public void Skirt(View view){

        int num3 = Integer.parseInt(et_desCost.getText().toString());

        int Skirt = num3 +3500;
        tv_desBasicp.setText(Integer.toString(Skirt));
    }

    public void jumper(View view){

        int num3 = Integer.parseInt(et_desCost.getText().toString());

        int jumper = num3 +3600;
        tv_desBasicp.setText(Integer.toString(jumper));
    }

    public void Cotton(View view){

        if(TextUtils.isEmpty(tv_desBasicp.getText().toString())){
            Toast.makeText(getApplicationContext(), "Please choose category first",Toast.LENGTH_SHORT).show();
        } else {
            int num4 = Integer.parseInt(tv_desBasicp.getText().toString());


            int Cotton = num4 + 2000;
            Tv_desMet.setText(Integer.toString(Cotton));
        }
    }

    public void Silk(View view){

        if(TextUtils.isEmpty(tv_desBasicp.getText().toString())){
            Toast.makeText(getApplicationContext(), "Please choose category first",Toast.LENGTH_SHORT).show();
        } else {
            int num5 = Integer.parseInt(tv_desBasicp.getText().toString());


            int Silk = num5 + 2500;
            Tv_desMet.setText(Integer.toString(Silk));
        }
    }

    public void Bathik(View view){

        if(TextUtils.isEmpty(tv_desBasicp.getText().toString())){
            Toast.makeText(getApplicationContext(), "Please choose category first",Toast.LENGTH_SHORT).show();
        } else {
            int num6 = Integer.parseInt(tv_desBasicp.getText().toString());


            int Bathik = num6 + 4500;
            Tv_desMet.setText(Integer.toString(Bathik));
        }
    }

    public void Linen(View view){

        if(TextUtils.isEmpty(tv_desBasicp.getText().toString())){
            Toast.makeText(getApplicationContext(), "Please choose category first",Toast.LENGTH_SHORT).show();
        } else {
            int num6 = Integer.parseInt(tv_desBasicp.getText().toString());


            int Linen = num6 + 4000;
            Tv_desMet.setText(Integer.toString(Linen));
        }
    }

    public void Casual(View view){

        if(TextUtils.isEmpty(Tv_desMet.getText().toString())){

            if(TextUtils.isEmpty(tv_desBasicp.getText().toString())) {
                Toast.makeText(getApplicationContext(), "Please choose category first", Toast.LENGTH_SHORT).show();
            }else{
                int num6 = Integer.parseInt(tv_desBasicp.getText().toString());
                int Casual = num6 + 1000;
                tv_desTypep.setText(Integer.toString(Casual));

            }
        } else {
            int num6 = Integer.parseInt(Tv_desMet.getText().toString());


            int Casual = num6 + 1000;
            tv_desTypep.setText(Integer.toString(Casual));
        }
    }


    public void Party(View view){

        if(TextUtils.isEmpty(Tv_desMet.getText().toString())){

            if(TextUtils.isEmpty(tv_desBasicp.getText().toString())) {
                Toast.makeText(getApplicationContext(), "Please choose category first", Toast.LENGTH_SHORT).show();
            }else{
                int num6 = Integer.parseInt(tv_desBasicp.getText().toString());
                int Party = num6 + 4000;
                tv_desTypep.setText(Integer.toString(Party));

            }
        } else {
            int num6 = Integer.parseInt(Tv_desMet.getText().toString());


            int Party = num6 + 4000;
            tv_desTypep.setText(Integer.toString(Party));
        }
    }

    public void reset(View view){
        tv_desBasicp.setText("");
        Tv_desMet.setText("");
        tv_desTypep.setText("");

    }

}