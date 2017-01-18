package com.example.mmtou.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements OnClickListener {
    private EditText Username,Password;
    private Button blogin;
    private DbHelper db;
    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DbHelper(this);
        session = new Session(this);
        final TextView welcome = (TextView) findViewById(R.id.welcome);
        Username = (EditText) findViewById(R.id.Username);
        Password = (EditText) findViewById(R.id.Password);
        blogin = (Button) findViewById(R.id.login);
        final TextView registerLink = (TextView) findViewById(R.id.registerHere);

        if (session.log()){
            startActivity(new Intent(LoginActivity.this,UserAreaActivity.class));
            finish();
        }

        registerLink.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent registerIntent = new Intent(LoginActivity.this,RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }
        });
        blogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.login){
            login();
        }
    }

    private void login(){
        String username = Username.getText().toString();
        String password = Password.getText().toString();
        if (db.getUser(username,password)){
            session.setLoggedIn(true);
            startActivity(new Intent(LoginActivity.this,UserAreaActivity.class));
            finish();
        }
        else {
            Toast.makeText(getApplicationContext(),"Wrong email or password",Toast.LENGTH_SHORT).show();
        }
    }

}
