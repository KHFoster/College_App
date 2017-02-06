package com.example.csaper6.collegeapp.Presenter;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.example.csaper6.collegeapp.R;

/**
 * Created by csaper6 on 12/19/16.
 */
public class CreateAccountActivity extends AppCompatActivity {
    private EditText firstName;
    private EditText lastName;
    private EditText email;
    private EditText password, passwordConfirm;
    private Button createButton;
    private EditText username;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        //provide for up navigation
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        firstName = (EditText) findViewById(R.id.createFirstName);
        lastName = (EditText) findViewById(R.id.createLastName);
        email = (EditText) findViewById(R.id.createEmail);
        password = (EditText) findViewById(R.id.createPassword);
        passwordConfirm = (EditText) findViewById(R.id.createConfirmPassword);
        createButton = (Button) findViewById(R.id.buttonCreateAccount);
        username = (EditText)findViewById(R.id.createUserName);



        //Dont forget to remove
        Backendless.initApp(this, "E3B7D26A-8E5A-0934-FFDE-F9FBDE7D0A00", "5081F355-5C2B-E257-FF99-6A7415463F00", "v1" );




        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {







                if (firstName.length() == 0
                        || lastName.length()==0
                        || password.length()==0
                        || email.length()==0
                        || username.length()==0)
                {
                    Toast.makeText(CreateAccountActivity.this, "Please make sure all fields are filled out.", Toast.LENGTH_SHORT).show();
                }
                BackendlessUser user = new BackendlessUser();
                user.setEmail(email.getText().toString());
                user.setPassword(password.getText().toString());
                user.setProperty("first_name",firstName.getText().toString());
                user.setProperty("last_name",lastName.getText().toString());
                user.setProperty("username",username.getText().toString());

                Backendless.UserService.register(user,createUserRegCallback());



//                Intent intent = new Intent(CreateAccountActivity.this, CreateAccountActivity.class);
//                startActivity(intent);


            }
        });
    }

    private AsyncCallback<BackendlessUser> createUserRegCallback() {
        return new AsyncCallback<BackendlessUser>() {
            @Override
            public void handleResponse(BackendlessUser response) {
                Toast.makeText(CreateAccountActivity.this, "REGISTRATION SUCCESS", Toast.LENGTH_SHORT).show();

                Intent resultIntent = new Intent();
                resultIntent.putExtra("USERNAME",username.getText().toString() );
                setResult(RESULT_OK, resultIntent);
                finish();
            }

            @Override
            public void handleFault(BackendlessFault fault) {
                Toast.makeText(CreateAccountActivity.this, ""+fault.getMessage(), Toast.LENGTH_SHORT).show();
            }
        };
    }

}