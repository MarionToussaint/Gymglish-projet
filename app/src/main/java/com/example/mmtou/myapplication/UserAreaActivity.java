package com.example.mmtou.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserAreaActivity extends AppCompatActivity {
    private Button btnLogout;
    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

        btnLogout = (Button) findViewById(R.id.Logout);
        final TextView welcomeText = (TextView) findViewById(R.id.editText2);
        final TextView gymglish = (TextView) findViewById(R.id.Gymglish);
        final TextView frantastique = (TextView) findViewById(R.id.Frantastique);
        final TextView vatefaireocnjuguer = (TextView) findViewById(R.id.Vatefaireconjuguer);
        final TextView rich = (TextView) findViewById(R.id.Rich);
        final TextView word = (TextView) findViewById(R.id.The_word);
        final TextView verbes = (TextView) findViewById(R.id.verbe);
        final TextView CPF = (TextView) findViewById(R.id.CPF);
        final TextView delavigne = (TextView) findViewById(R.id.Delavigne);
        final TextView worksweet = (TextView) findViewById(R.id.Worksweet);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
        gymglish.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.gymglish.com"));
                UserAreaActivity.this.startActivity(browserIntent);
            }
        });

        frantastique.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.frantastique.com"));
                UserAreaActivity.this.startActivity(browserIntent);
            }
        });

        vatefaireocnjuguer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.vatefaireconjuguer.com"));
                UserAreaActivity.this.startActivity(browserIntent);
            }
        });

        rich.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.richmorning.com"));
                UserAreaActivity.this.startActivity(browserIntent);
            }
        });

        word.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.thewordofthemonth.com"));
                UserAreaActivity.this.startActivity(browserIntent);
            }
        });

        verbes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.anglais-conjugaison.com/verbe-irregulier"));
                UserAreaActivity.this.startActivity(browserIntent);
            }
        });

        CPF.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.anglais-cpf.fr"));
                UserAreaActivity.this.startActivity(browserIntent);
            }
        });

        delavigne.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.delavignecorp.com"));
                UserAreaActivity.this.startActivity(browserIntent);
            }
        });

        worksweet.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://worksweetwork.com"));
                UserAreaActivity.this.startActivity(browserIntent);
            }
        });

        session = new Session(this);
        if (!session.log()){
            logout();
        }
    }

    private void logout(){
        session.setLoggedIn(false);
        finish();
        startActivity(new Intent(UserAreaActivity.this,LoginActivity.class));
    }
}
