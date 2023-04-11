package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;




public class Contact extends AppCompatActivity {


    private TextView mNameTextView;
    private ImageView mPhotoImageView;
    private TextView mSpecialityTextView;
    private TextView mPhoneNumberTextView;
    private TextView mEmailTextView;
    private Button contactUs;
    Intent i;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

//        // Get the doctor information from the intent
//        Intent intent = getIntent();
//        Doctor doctor = (Doctor) intent.getSerializableExtra("doctor");
//
//        // Set up the views
//        mNameTextView = findViewById(R.id.doctor_name);
//        mPhotoImageView = findViewById(R.id.doctor_photo);
//        mSpecialityTextView = findViewById(R.id.doctor_specialty);
//        mPhoneNumberTextView = findViewById(R.id.doctor_phone);
//        mEmailTextView = findViewById(R.id.doctor_email);
//
//        // Set the values of the views with the doctor information
//        mNameTextView.setText(doctor.getName());
//        mSpecialityTextView.setText(doctor.getSpecialty());
//        mPhoneNumberTextView.setText(doctor.getPhone());
//        mEmailTextView.setText(doctor.getEmail());
//        Picasso.get().load(doctor.getPhotoUrl()).into(mPhotoImageView);
//
//        // Set up the click listener for the phone number TextView
//        mPhoneNumberTextView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String phoneNumber = doctor.getPhone();
//                Intent intent = new Intent(Intent.ACTION_DIAL);
//                intent.setData(Uri.parse("tel:" + phoneNumber));
//                startActivity(intent);
//            }
//        });
//
//        // Set up the click listener for the email TextView
//        mEmailTextView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String email = doctor.getEmail();
//                Intent intent = new Intent(Intent.ACTION_SENDTO);
//                intent.setData(Uri.parse("mailto:" + email));
//                startActivity(Intent.createChooser(intent, "Send Email"));
//            }
//        });
        contactUs = (Button) findViewById(R.id.button2);
        contactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(Contact.this, ContactUs.class);
                startActivity(i);
            }
        });
    }
}