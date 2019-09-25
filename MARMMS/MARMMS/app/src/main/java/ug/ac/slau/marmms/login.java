package ug.ac.slau.marmms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    private static final String login_email = "";
    private static final String login_password = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void Login(View view) {
        Intent main_intent = new Intent(this, MainActivity.class);

        EditText email_obj = (EditText) findViewById(R.id.login_email);
        String email = email_obj.getText().toString();

        EditText password_obj = (EditText) findViewById(R.id.login_password);
        String password = password_obj.getText().toString();

        if(!email.matches(login_email) || !password.matches(login_password)){
            Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
        } else if (email.matches(login_email) && password.matches(login_password)) {
            main_intent.putExtra("EMAIL", email);
            startActivity(main_intent);

            Toast.makeText(getApplicationContext(), "Welcome " + email, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Login Failed " + email, Toast.LENGTH_SHORT).show();
        }
    }
}
