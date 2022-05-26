package com.android.climatechange;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Webview2 extends AppCompatActivity {

    public WebView browser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview2);

        browser = (WebView) findViewById(R.id.webview);
        browser.setWebViewClient(new WebViewClient());
        browser.loadUrl(" https://www.mdpi.com/2071-1050/10/5/1664/htm");

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