package com.example.bellezafashion;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;


public class AdminAddProducts extends AppCompatActivity {

    private String in_CategoryName,in_description,in_price,in_name,in_designers,in_saveCurrentTime,in_saveCurrentDate,in_code;
    private ImageView in_image_select;
    private Button in_add_product;
    private EditText in_it_name,in_it_price,in_it_designer,in_it_description,in_it_code;
    private String productRandomKey,downloadImageUrl;
    private Uri ImageUri;
    private static final int GalleryPick =1;
    private StorageReference ProductImagesRef;
    private DatabaseReference productsRef;
    private ProgressDialog loadingBar;
    private String codePattern = "[b][0-9]{3}";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_products);

        in_CategoryName = getIntent().getExtras().get("category").toString();
        ProductImagesRef = FirebaseStorage.getInstance().getReference().child("product Images");
        productsRef = FirebaseDatabase.getInstance().getReference().child("Products");

        in_image_select=(ImageView)findViewById(R.id.in_select_item_image);
        in_add_product=(Button)findViewById(R.id.in_design_add_btn);
        in_it_name=(EditText)findViewById(R.id.in_item_name);
        in_it_price=(EditText)findViewById(R.id.in_item_price);
        in_it_designer=(EditText)findViewById(R.id.in_item_designer);
        in_it_description=(EditText)findViewById(R.id.in_item_Description);
        in_it_code=(EditText)findViewById(R.id.in_item_code);
        loadingBar = new ProgressDialog(this);


        in_image_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenGallery();

            }
        });

        in_add_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validateProductData();
            }
        });

    }
    private void OpenGallery() {
        Intent galleryIntent = new Intent();
        galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
        galleryIntent.setType("image/*");
        startActivityForResult(galleryIntent,GalleryPick);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==GalleryPick && resultCode==RESULT_OK && data!=null){
            ImageUri =data.getData();
            in_image_select.setImageURI(ImageUri);
        }
    }

    private void validateProductData(){


        in_name = in_it_name.getText().toString();
        in_code = in_it_code.getText().toString();
        in_designers = in_it_designer.getText().toString();
        in_price = in_it_price.getText().toString();
        in_description = in_it_description.getText().toString();

        if(ImageUri == null){
            Toast.makeText(getApplicationContext(),"Product Image is mandatory..",Toast.LENGTH_SHORT).show();

        }else if(TextUtils.isEmpty(in_name)){
            Toast.makeText(getApplicationContext(),"Please write the product name", Toast.LENGTH_SHORT).show();

        }else if(TextUtils.isEmpty(in_code)){
            Toast.makeText(getApplicationContext(),"Please write the product name", Toast.LENGTH_SHORT).show();

        }else if(TextUtils.isEmpty(in_price)){
            Toast.makeText(getApplicationContext(),"Please write the product price", Toast.LENGTH_SHORT).show();

        }else if(TextUtils.isEmpty(in_designers)){
            Toast.makeText(getApplicationContext(),"Please write Designer name", Toast.LENGTH_SHORT).show();

        }else if(TextUtils.isEmpty(in_description)){
            Toast.makeText(getApplicationContext(),"Please write the product description", Toast.LENGTH_SHORT).show();

        }else if((in_code.length() > 4) || (!in_code.matches(codePattern))){
            Toast.makeText(getApplicationContext(), "Invalid code", Toast.LENGTH_SHORT).show();
        } else{

            StoreProductInformation();

        }

    }
    private void StoreProductInformation() {

        loadingBar.setTitle("Add New Product");
        loadingBar.setMessage("Dear Admin, Please wait, we are adding new product");
        loadingBar.setCanceledOnTouchOutside(false);
        loadingBar.show();

        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat currentDate = new SimpleDateFormat("MMM dd, yyyy");
        in_saveCurrentDate = currentDate.format(calendar.getTime());

        SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss a");
        in_saveCurrentTime = currentTime.format(calendar.getTime());

        productRandomKey = in_saveCurrentDate + in_saveCurrentTime;


        StorageReference filePath = ProductImagesRef.child(ImageUri.getLastPathSegment() + productRandomKey + ".jpg");

        final UploadTask uploadTask = filePath.putFile(ImageUri);

        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull  Exception e) {

                String message = e.toString();
                Toast.makeText(AdminAddProducts.this, "Error: "+message, Toast.LENGTH_SHORT).show();
                loadingBar.dismiss();
            }

        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                Toast.makeText(AdminAddProducts.this, "Image uploaded Successfully", Toast.LENGTH_SHORT).show();

                Task<Uri> urlTask = uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot,Task<Uri>>() {
                    @Override
                    public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {

                        if(!task.isSuccessful()){
                            //Toast.makeText(AdminAddProducts.this, "Error:"+task.getException(), Toast.LENGTH_SHORT).show();
                            throw task.getException();

                        }
                        //get the image url
                        downloadImageUrl = filePath.getDownloadUrl().toString();

                        return filePath.getDownloadUrl();
                    }
                }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                    @Override
                    public void onComplete(@NonNull Task<Uri> task) {

                        if(task.isSuccessful()){

                            downloadImageUrl = task.getResult().toString();

                            Toast.makeText(AdminAddProducts.this, "got the Product Image url to database successfully", Toast.LENGTH_SHORT).show();

                            saveProductInfoToDatabase();
                        }
                    }
                });
            }
        });
    }

    private void saveProductInfoToDatabase() {
        HashMap<String,Object> productMap = new HashMap<>();
        productMap.put("pid",productRandomKey);
        productMap.put("date",in_saveCurrentDate);
        productMap.put("time",in_saveCurrentTime);
        productMap.put("name",in_name);
        productMap.put("designer",in_designers);
        productMap.put("price",in_price);
        productMap.put("description",in_description);
        productMap.put("image",downloadImageUrl);
        productMap.put("category",in_CategoryName);

        productsRef.child(productRandomKey).updateChildren(productMap)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Intent intent = new Intent(AdminAddProducts.this,AdminItemCategory.class);
                            startActivity(intent);

                            loadingBar.dismiss();
                            Toast.makeText(AdminAddProducts.this, "product is add Successfully", Toast.LENGTH_SHORT).show();

                        }else{

                            loadingBar.dismiss();
                            String message = task.getException().toString();
                            Toast.makeText(AdminAddProducts.this, "Error: "+message, Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }


}