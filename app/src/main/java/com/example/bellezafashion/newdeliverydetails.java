package com.example.bellezafashion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class newdeliverydetails extends AppCompatActivity {
    EditText name, number, address, pref, note, sendas;
    Button save, view, update, delete;
    Delivery dvery;
    DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newdeliverydetails);
        name = findViewById(R.id.name);
        number = findViewById(R.id.number);
        address = findViewById(R.id.address);
        pref = findViewById(R.id.pref);
        note = findViewById(R.id.note);
        sendas = findViewById(R.id.sendas);
        save = findViewById(R.id.save);
        view = findViewById(R.id.update);
        update = findViewById(R.id.view);
        delete = findViewById(R.id.delete);

        dvery = new Delivery();

        Button nfee = (Button) findViewById(R.id.nfee);
        nfee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(newdeliverydetails.this, deliveryfee.class);
                startActivity(intent4);
            }

        });
    }

    public void ClearControl() {

        name.setText("");
        number.setText("");
        address.setText("");
        pref.setText("");
        note.setText("");
        sendas.setText("");

    }

    public void Createdata(View view) {

        dbRef = FirebaseDatabase.getInstance().getReference().child("Delivery");
        try {
            if (TextUtils.isEmpty(name.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please enter a Name", Toast.LENGTH_SHORT).show();
            else if (TextUtils.isEmpty(number.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please enter phone number", Toast.LENGTH_SHORT).show();
            else if ( number.length()<10 || number.length()>10)
                Toast.makeText(getApplicationContext(), "Please enter valid a number", Toast.LENGTH_SHORT).show();
            else if (TextUtils.isEmpty(address.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please enter a Address", Toast.LENGTH_SHORT).show();
            else if (TextUtils.isEmpty(pref.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please enter a pref", Toast.LENGTH_SHORT).show();
            else if (TextUtils.isEmpty(note.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please enter a note", Toast.LENGTH_SHORT).show();
            else if (TextUtils.isEmpty(sendas.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please enter a sendas", Toast.LENGTH_SHORT).show();

            else {

                dvery.setName(name.getText().toString().trim());
                dvery.setNumber(Integer.parseInt(number.getText().toString().trim()));
                dvery.setAddress(address.getText().toString().trim());
                dvery.setPref(pref.getText().toString().trim());
                dvery.setNote(note.getText().toString().trim());
                dvery.setSendas(sendas.getText().toString().trim());


                //dbRef.push().setValue(dvery);
                dbRef.child("d1").setValue(dvery);

                Toast.makeText(getApplicationContext(), "Data insert successfully", Toast.LENGTH_SHORT).show();
                //ClearControl();
            }
        } catch (NumberFormatException e) {
            Toast.makeText(getApplicationContext(), "Invalid Contact Number", Toast.LENGTH_SHORT).show();
        }
    }
    public void Showdata(View view){
        dbRef = FirebaseDatabase.getInstance().getReference().child("Delivery").child("d1");
        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChildren()) {
                    name.setText(dataSnapshot.child("name").getValue().toString());
                    number.setText(dataSnapshot.child("number").getValue().toString());
                    address.setText(dataSnapshot.child("address").getValue().toString());
                    pref.setText(dataSnapshot.child("pref").getValue().toString());
                    note.setText(dataSnapshot.child("note").getValue().toString());
                    sendas.setText(dataSnapshot.child("sendas").getValue().toString());
                }else {
                    Toast.makeText(getApplicationContext(), "No source to display", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });
    }
    public void Updatedata(View view){
        DatabaseReference updRef = FirebaseDatabase.getInstance().getReference().child("Delivery");
        updRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChild("d1")) {
                    try{

                        dvery.setName(name.getText().toString().trim());
                        dvery.setNumber(Integer.parseInt(number.getText().toString().trim()));
                        dvery.setAddress(address.getText().toString().trim());
                        dvery.setPref(pref.getText().toString().trim());
                        dvery.setNote(note.getText().toString().trim());
                        dvery.setSendas(sendas.getText().toString().trim());


                        dbRef = FirebaseDatabase.getInstance().getReference().child("Delivery").child("d1");
                        dbRef.setValue(dvery);
                        //ClearControl();

                        Toast.makeText(getApplicationContext(), "Data Updated successfully", Toast.LENGTH_SHORT).show();
                    }
                    catch (NumberFormatException e){
                        Toast.makeText(getApplicationContext(), "Invalid contact number",Toast.LENGTH_SHORT).show();
                    }
                }else
                    Toast.makeText(getApplicationContext(), "No source to Update", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull  DatabaseError error) {

            }
        });
    }
    public  void Deletedata(View view){
        DatabaseReference delRef = FirebaseDatabase.getInstance().getReference().child("Delivery");
        delRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull  DataSnapshot datasnapshot) {
                if(datasnapshot.hasChild("d1")){
                    dbRef = FirebaseDatabase.getInstance().getReference().child("Delivery").child("d1");
                    dbRef.removeValue();
                    ClearControl();
                    Toast.makeText(getApplicationContext(), "Data Deleted successfully", Toast.LENGTH_SHORT).show();

                }else
                    Toast.makeText(getApplicationContext(),"No Source to Delete", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}