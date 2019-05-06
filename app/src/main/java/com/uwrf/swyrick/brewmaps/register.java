package com.uwrf.swyrick.brewmaps;

import android.os.Bundle;
import android.widget.Button;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;


public class register extends AppCompatActivity {

    /* activity_register fields and button variables  */

    //First and Last names
    final EditText firstNameEditText = (EditText) findViewById(R.id.FirstNameEditText);
    final EditText lastNameEditText = (EditText) findViewById(R.id.LastNameEditText);

    //Username
    final EditText usernameEditText = (EditText) findViewById(R.id.UsernameEditText);

    //Password
    final EditText passwordEditText = (EditText) findViewById(R.id.PasswordEditText);

    //Email
    final EditText emailEditText = (EditText) findViewById(R.id.EmailEditText);

    //Register button
    final Button registerButton = findViewById(R.id.RegisterButton);

    //confirmations
    final EditText passwordVerEditText = (EditText) findViewById(R.id.PasswordVerEditText);
    final EditText emailVerEditText = (EditText) findViewById(R.id.EmailVerEditText);
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
    }
}
