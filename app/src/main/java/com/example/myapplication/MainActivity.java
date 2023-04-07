package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView username= (TextView) findViewById(R.id.Username);
        TextView password = (TextView) findViewById(R.id.Password);

        MaterialButton loginbtn = (MaterialButton) findViewById(R.id.LoginBtn);


        // admin and admin

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin"))
                {
                    //correct
                    Toast.makeText(MainActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(MainActivity.this,Home.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(MainActivity.this, "Login Faile", Toast.LENGTH_SHORT).show();
            }
        });

    }
}