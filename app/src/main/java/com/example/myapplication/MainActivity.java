package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


      }

    public void onClick_Login(View view) {
EditText editText=findViewById(R.id.mainActivity_editText_Email);

        Intent goToProfile=new Intent(this,Profile_Activity.class);

        goToProfile.putExtra("Email",editText.getText().toString());

        startActivity(goToProfile);



    }
}