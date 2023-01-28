package com.example.myapplication;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;

public class Profile_Activity extends AppCompatActivity {
EditText editText_Email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent fromMain = getIntent();
        String Email=fromMain.getStringExtra("Email");

        Log.i("email = > ", "onCreate:  " + Email);

        editText_Email=findViewById(R.id.ProfileActivity_editText_Email);
        editText_Email.setText(Email);





    }



    ActivityResultLauncher<Intent> myPictureTakerLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult() ,
            new ActivityResultCallback<ActivityResult>() {
                @Override public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData(); Bitmap imgbitmap = (Bitmap) data.getExtras().get("data");



                    ImageView imageView=findViewById(R.id.imgView);
                    imageView.setImageBitmap(imgbitmap);



                    } else if(result.getResultCode() == Activity.RESULT_CANCELED)
                        Log.i("", "User refused to capture a picture.");
                }
            }
    );


    public void onClick_Login(View view) {


dispatchTakePictureIntent();

    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            myPictureTakerLauncher.launch(takePictureIntent);
        }
    }


    }






    
