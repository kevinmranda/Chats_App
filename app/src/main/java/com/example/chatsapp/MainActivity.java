package com.example.chatsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public EditText email, password;
    public Button submit;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email  = (EditText) findViewById(R.id.email);
        password  = (EditText) findViewById(R.id.password);
        submit  = (Button) findViewById(R.id.login);

        submit.setOnClickListener(this::onClick);

    }

    @Override
    public void onClick(View v) {
        login();
    }

    private void login() {
        String usernameInput = email.getText().toString().trim();
        String passwordInput = password.getText().toString().trim();

        if (usernameInput.equals("emma") && passwordInput.equals("123")) {
            String message = "Welcome, " + usernameInput + "!";
            Intent intent = new Intent(this, ChatsActivity.class);
            intent.putExtra("welcome_message", message);
            startActivity(intent);
            this.finish();
        } else {
            String message = "Wrong username or password! Username: " + usernameInput + ", Password: " + passwordInput;
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        }
    }

}