package com.example.mmtou.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity implements OnClickListener {
    private Intent registerIntent;
    private Button bRegister;
    private EditText etusername,etemail,etpassword;
    private DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DbHelper(this);
        final TextView welcome = (TextView) findViewById(R.id.welcome);
        etusername = (EditText) findViewById(R.id.Username);
        etemail = (EditText) findViewById(R.id.Email);
        etpassword = (EditText) findViewById(R.id.Password);
        bRegister = (Button) findViewById(R.id.BRegister);
        bRegister.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v.getId()==R.id.BRegister){
            register();
        }
    }

    private void register(){
        String email = etemail.getText().toString();
        String password = etpassword.getText().toString();
        String username = etusername.getText().toString();
        if (email.isEmpty() || password.isEmpty() || username.isEmpty()){
            displayToast("Username/Email/Password field is empty");
        }
        else {
            db.addUser(email, username,password);
            displayToast("User registered");
            startActivity(new Intent(RegisterActivity.this,UserAreaActivity.class));
            finish();;
        }
    }

    private void displayToast(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }

}