package jacobmarsnik.geotest;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    boolean loginBool = false;

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

        // StringRequest to get/check credentials from server
        StringRequest sr = new StringRequest(Request.Method.POST, Constants.LOGIN_URL, new Response.Listener<String>() {

            /**The String request, using Constants.LOGIN_URL should get the entirety of the database
             * fields. Below it will be parsed to get only the username and password*/
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject dataObject = new JSONObject(response);

                    // If no error in response
                    if(!dataObject.getBoolean("error")) {
                        Toast.makeText(getApplicationContext(), dataObject.getString("message"),Toast.LENGTH_SHORT).show();

                        // Get the username
                        JSONObject userJson = dataObject.getJSONObject("user");
                        if(userJson.getString("username").equals(usernameEditText.getText().toString())
                        && userJson.getString("password").equals(passwordEditText.getText().toString())) {
                            loginBool = true;
                        }


                    }

                } catch (JSONException je) {
                    je.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        // Queue up and execute the StringRequest
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(sr);

        // TODO: getting information from the server doesn't seem to work
        //  fix if have time
        //  Confirmed it doesn't have anything to do with email verification

        //if(loginBool) {
            loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent mainActivityIntent = new Intent(LoginActivity.this, MainActivity.class);
                    LoginActivity.this.startActivity(mainActivityIntent);
                    //Toast.makeText(LoginActivity.this, "Logging In", Toast.LENGTH_SHORT).show();
                }
            });
        //}
    }
}
