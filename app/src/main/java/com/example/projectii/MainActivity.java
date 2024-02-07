package com.example.projectii;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    CardView cardView;
    Button loginButton;
    Button signUpButton;
    EditText  userName;
    EditText  password;
    TextView  forgotPassword;
    public  void dashboard(){
        Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = findViewById(R.id.userName);
        password= findViewById(R.id.password);
        cardView =findViewById(R.id.cardView);
        cardView.setBackgroundResource(R.drawable.cardview);
        loginButton = findViewById(R.id.loginButton);
        signUpButton = findViewById(R.id.signUpButton);
        forgotPassword = findViewById(R.id.forgotPassword);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userName.getText().toString().matches("") || password.getText().toString().matches("")) {
                    Toast.makeText(MainActivity.this, "Enter username and password", Toast.LENGTH_SHORT).show();
                } else {
                    dashboard();
                    cardView.setVisibility(View.INVISIBLE);
                }
            }
        });
       View.OnClickListener onClickListener = new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (v.getId()==R.id.signUpButton){
                   Toast.makeText(MainActivity.this, "SignUp clicked", Toast.LENGTH_SHORT).show();
               } else {
                   Toast.makeText(MainActivity.this, "Forgot Password Clicked", Toast.LENGTH_SHORT).show();
               }
           }
       };
       signUpButton.setOnClickListener(onClickListener);
       forgotPassword.setOnClickListener(onClickListener);
    }
}

