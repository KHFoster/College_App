package com.example.csaper6.collegeapp.Presenter;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
public class LoginActivity extends AppCompatActivity{
    private EditText username;
    private EditText password;
    private Button createAccount;
    private Button login;
    private ProgressDialog progressDialog;







    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Backendless.initApp( this, "E3B7D26A-8E5A-0934-FFDE-F9FBDE7D0A00", "5081F355-5C2B-E257-FF99-6A7415463F00", "v1"  ); // where to get the argument values for this call
        username = (EditText)findViewById(R.id.login_name);
        password = (EditText)findViewById(R.id.login_password);
        createAccount = (Button)findViewById(R.id.button_create);
        login = (Button)findViewById(R.id.button_login);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        
        createAccount.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, CreateAccountActivity.class);
                        startActivityForResult(intent,123);


            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressDialog.show();


                Backendless.UserService.login( username.getText().toString(), password.getText().toString(), new AsyncCallback<BackendlessUser>()
                {
                    public void handleResponse( BackendlessUser user )
                    {
                        progressDialog.cancel();
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);

                    }

                    public void handleFault( BackendlessFault fault )
                    {
                        try{
                            Thread.sleep(4000);
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        progressDialog.cancel();
                        Toast.makeText(LoginActivity.this, "Incorrect Login Information", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 123&&resultCode== Activity.RESULT_OK){
        String usernameText = data.getStringExtra("USERNAME");
        username.setText(usernameText);}

    }

}


