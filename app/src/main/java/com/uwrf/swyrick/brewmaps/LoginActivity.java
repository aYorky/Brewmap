package com.uwrf.swyrick.brewmaps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /* activity_login fields and button variables  */

        //Username
        final EditText usernameEditText = ( EditText ) findViewById(R.id.UsernameEditText);

        //Password
        final EditText passwordEditText = ( EditText ) findViewById(R.id.PasswordEditText);

        //Register button
        final Button loginButton = ( Button ) findViewById(R.id.LoginButton);

        //Register Link
        final TextView registerLinkEditText = ( TextView ) findViewById(R.id.RegisterHereTextView);


        /* Register link listener */
        registerLinkEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerHereIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerHereIntent);

            }
        });

    }
}
