package com.android.climatechange;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Webview3 extends AppCompatActivity {
    public WebView browser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview3);


        browser = (WebView) findViewById(R.id.webview);
        browser.setWebViewClient(new WebViewClient());
        browser.loadUrl(" https://theintercept.com/2020/04/19/africa-plastic-waste-kenya-ethiopia/");

        WebSettings webSettings = browser.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }

    @Override
    public void onBackPressed() {
        if(browser.canGoBack()){
            browser.goBack();
        }else {
            super.onBackPressed();
        }
    }
}