package com.uwrf.swyrick.brewmaps;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_register);
    
    
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
    final FloatingActionButton registerButton = (FloatingActionButton) findViewById(R.id.RegisterButton);
    
    //confirmations
    final EditText passwordVerEditText = (EditText) findViewById(R.id.PasswordVerEditText);
    final EditText emailVerEditText = (EditText) findViewById(R.id.EmailVerEditTExt);
    
    
    registerButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            
            
            //testing design
            final String first_name = firstNameEditText.getText().toString().trim();
            final String last_name = lastNameEditText.getText().toString().trim();
            final String username = usernameEditText.getText().toString().trim();
            final String email = emailEditText.getText().toString().trim();
            final String password = passwordEditText.getText().toString().trim();
            
            final String passwordVer = passwordVerEditText.getText().toString().trim();
            final String emailVer = emailVerEditText.getText().toString().trim();
            //TODO: add a regex for better passwords, 14:00 -> https://www.youtube.com/watch?v=keTVMp0gJko
            
            //System.out.print("Testing string variables \n" + first_name + "\n" + last_name + "\n" + username + "\n" + email + "\n" + password);
            
            
            //check for missing fields
            if(first_name.equals("") || last_name.equals("") || username.equals("") || email.equals("") || password.equals("")) {
                
                Toast.makeText(RegisterActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();//TODO: Use a special animation to alert users!
                
            } else {
                if(!email.equals(emailVer) || !password.equals(passwordVer)) {
                    Toast.makeText(RegisterActivity.this, "E-mails or passwords do not match.", Toast.LENGTH_SHORT).show();
                } else {
                    
                    if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                        Toast.makeText(RegisterActivity.this, "E-mail is not valid.", Toast.LENGTH_SHORT).show();
                        
                    } else {
                        //registerButton.setVisibility(View.GONE);
                        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.REGISTER_URL, new Response.Listener<String>() {
                            
                            @Override
                            public void onResponse(String response) {
                                if(response.contains("Please check your email.") || response.contains("Email already in use.")) {
                                    /** This section is having issues. I believe it has something to do with
                                     * the fact that we're using activities instead of fragments. It might
                                     * be worth it to convert everything to fragments within a login activity.*/
                                    /*final FragmentManager fm = getActivity().getSupportFragmentManager();
                                    fm.beginTransaction().replace(R.id.content, new LoginFragment()).commit();*/
                                }
                                Toast.makeText(RegisterActivity.this, response.trim(), Toast.LENGTH_SHORT).show();
                            }
                            
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                System.out.print("RegisterActivity: onErrorResponse - Error: " + error);
                                //removed boolean e = true; if (e){...]
                            }
                            
                        }) {
                            @Override
                            protected Map<String, String> getParams() {
                                Map<String, String> params = new HashMap<String, String>();
                                params.put(Constants.KEY_FIRST_NAME, first_name);
                                params.put(Constants.KEY_LAST_NAME, last_name);
                                params.put(Constants.KEY_USERNAME, username);
                                params.put(Constants.KEY_EMAIL, email);
                                params.put(Constants.KEY_PASSWORD, password);
                                
                                
                                return params;
                            }
                            
                            @Override
                            public Map<String, String> getHeaders() throws AuthFailureError {
                                Map<String, String> headers = new HashMap<String, String>();
                                headers.put("User-Agent", "brewMaps");
                                return headers;
                            }
                            
                            
                        };
                        
                        
                        MySingleton.getInstance(RegisterActivity.this).addToRequestQueue(stringRequest);
                        Intent returnToLogin = new Intent(RegisterActivity.this, LoginActivity.class);
                        RegisterActivity.this.startActivity(returnToLogin);
                    }
                }    //TODO: Continue work - https://www.youtube.com/watch?v=w3Nyz6OmBWE
            }
        }
    });
}//End: OnCreate(){}
}//end of RegisterActivity{}
