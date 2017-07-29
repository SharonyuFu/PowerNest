package com.codepath.powernest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    Button loginBtn;
    TextView singInTab;
    TextView singUpTab;
    Boolean isSignUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        singInTab = (TextView)findViewById(R.id.signIn);
        singUpTab = (TextView)findViewById(R.id.signUp);

        loginBtn = (Button) findViewById(R.id.signInBtn);
        login();





    }

    public void signUp(View v){




    }

    public void login(){

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.rounded_button_clicked));
                Intent i = new Intent(LoginActivity.this, HomeEventActivity.class);
                startActivity(i); // brings up the second activity
            }
        });
    }



}
