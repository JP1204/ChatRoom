package com.example.chatroom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize user database
        final Users users = new Users();

        // create editTexts for home page
        final EditText usernameEditText = findViewById(R.id.usernameEditText);
        final EditText passwordEditText = findViewById(R.id.passwordEditText);

        // create buttons for home page
        Button createAccountButton = findViewById(R.id.createAccountButton);
        Button loginButton = findViewById(R.id.loginButton);

        createAccountButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                // create account
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // check for invalid username or password
                if(username == "" || password == ""){
                    Toast toast = Toast.makeText(getApplicationContext(), "Forget username or password", Toast.LENGTH_LONG);
                    toast.show();
                    return;
                }

                // add user to database
                users.addUser(username, password);

                // display success message
                Toast toast = Toast.makeText(getApplicationContext(), "User successfully added", Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
}
