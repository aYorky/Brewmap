package com.uwrf.swyrick.brewmaps;

import android.os.Bundle;
import android.widget.Button;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;


public class register extends AppCompatActivity {

    /* activity_register fields and button variables  */

    //First and Last names
    final EditText firstNameEditText = findViewById(R.id.FirstNameEditText);
    final EditText lastNameEditText =  findViewById(R.id.LastNameEditText);

    //Username
    final EditText usernameEditText =  findViewById(R.id.UsernameEditText);

    //Password
    final EditText passwordEditText = findViewById(R.id.PasswordEditText);

    //Email
    final EditText emailEditText =  findViewById(R.id.EmailEditText);

    //Register button
    final Button registerButton = findViewById(R.id.RegisterButton);

    //confirmations
    final EditText passwordVerEditText = findViewById(R.id.PasswordVerEditText);
    final EditText emailVerEditText = findViewById(R.id.EmailVerEditText);
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        final String first_name = firstNameEditText.getText().toString().trim();
        final String last_name = lastNameEditText.getText().toString().trim();
        final String username = usernameEditText.getText().toString().trim();
        final String email = emailEditText.getText().toString().trim();
        final String password = passwordEditText.getText().toString().trim();

        final String passwordVer = passwordVerEditText.getText().toString().trim();
        final String emailVer = emailVerEditText.getText().toString().trim();

        
    }
}
