package jacobmarsnik.geotest;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        /* activity_register fields and button variables  */

        //First and Last names
        final EditText firstNameEditText = ( EditText ) findViewById(R.id.FirstNameEditText);
        final EditText lastNameEditText = ( EditText ) findViewById(R.id.LastNameEditText);

        //Username
        final EditText usernameEditText = ( EditText ) findViewById(R.id.UsernameEditText);

        //Welcome Message
        final TextView WelcomeMessageTextView = ( TextView )findViewById(R.id.WelcomeMessageTextView);
    }
}
