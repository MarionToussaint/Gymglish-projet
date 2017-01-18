package com.example.mmtou.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by mmtou on 18/01/2017.
 */

public class WebViewGymglish extends AppCompatActivity {
    private WebView webG;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gymglish);

        webG = (WebView) findViewById(R.id.webG);
        webG.setWebViewClient(new WebViewClient());
        webG.loadUrl(UserAreaActivity.url);
        webG.getSettings().setJavaScriptEnabled(true);



    }
}
