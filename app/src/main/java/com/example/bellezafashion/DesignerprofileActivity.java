package com.example.bellezafashion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DesignerprofileActivity extends AppCompatActivity {

    private static final String TAG = "DesignerprofileActivity";
    String desID;
    DatabaseReference dbRef;
    Designer desgn;

    EditText et_profileID,et_profileName,et_profileOcc,et_prEmail,et_profilephone,et_profilecost;
    Button btn_Update,btn_Delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_designerprofile);

        Intent intent =getIntent();
        desID=intent.getStringExtra(currentDesignActivity.desID);

        final DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("Designer").child(desID);

        et_profileID =findViewById(R.id.et_profileID);
        et_profileName=findViewById(R.id.et_profileName);
        et_profileOcc = findViewById(R.id.et_profileOcc);
        et_prEmail = findViewById(R.id.et_prEmail);
        et_profilephone = findViewById(R.id.et_profilephone);
        et_profilecost = findViewById(R.id.et_profilecost);
        btn_Update =findViewById(R.id.btn_Update);
        btn_Delete =findViewById(R.id.btn_Delete);

        desgn = new Designer();


        readRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull  DataSnapshot dataSnapshot) {

                if(dataSnapshot.hasChildren()){

                    desgn.setDesignerID(dataSnapshot.child("designerID").getValue().toString());
                    desgn.setDesignerName(dataSnapshot.child("designerName").getValue().toString());
                    desgn.setOccupation(dataSnapshot.child("occupation").getValue().toString());
                    desgn.setEmail(dataSnapshot.child("email").getValue().toString());
                    desgn.setPhone(Integer.parseInt(dataSnapshot.child("phone").getValue().toString()));
                    desgn.setCost(Integer.parseInt(dataSnapshot.child("cost").getValue().toString()));

                    et_profileID.setText(desgn.getDesignerID());
                    et_profileName.setText(desgn.getDesignerName());
                    et_profileOcc.setText(desgn.getOccupation());
                    et_prEmail.setText(desgn.getEmail());
                    et_profilephone.setText(desgn.getPhone().toString());
                    et_profilecost.setText(desgn.getCost().toString());


                }else{
                    Toast.makeText(getApplicationContext(), "No source to desplay",Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void UpdateDes(View view){
        DatabaseReference updRef = FirebaseDatabase.getInstance().getReference().child("Designer");
        updRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull  DataSnapshot dataSnapshot) {

                if(dataSnapshot.hasChildren()){
                    try{
                        desgn.setDesignerID(et_profileID.getText().toString().trim());
                        desgn.setDesignerName(et_profileName.getText().toString().trim());
                        desgn.setOccupation(et_profileOcc.getText().toString().trim());
                        desgn.setEmail(et_prEmail.getText().toString().trim());
                        desgn.setPhone(Integer.parseInt(et_profilephone.getText().toString().trim()));
                        desgn.setCost(Integer.parseInt(et_profilecost.getText().toString().trim()));

                        DatabaseReference uppdRef = FirebaseDatabase.getInstance().getReference().child("Designer").child(desID);
                        uppdRef.setValue(desgn);

                        Toast.makeText(getApplicationContext(),"Data updated successfully",Toast.LENGTH_SHORT).show();

                    }catch (NumberFormatException e){
                        Toast.makeText(getApplicationContext(),"Invalid contact or cost",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(getApplicationContext(), "No source to update",Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(@NonNull  DatabaseError databaseError) {

            }
        });
    }

    public void Deletedes(View view){
        DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("Designer");
        readRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull  DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChildren()){
                    DatabaseReference delRef = FirebaseDatabase.getInstance().getReference().child("Designer").child(desID);
                    delRef.removeValue();
                    Clearcontrol();

                    Toast.makeText(getApplicationContext(), "Deleted succussfully",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "No source to delete",Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(@NonNull  DatabaseError databaseError) {

            }
        });
    }
    public void Clearcontrol(){
        et_profileID.setText("");
        et_profileName.setText("");
        et_profileOcc.setText("");
        et_prEmail.setText("");
        et_profilephone.setText("");
        et_profilecost.setText("");
    }
}