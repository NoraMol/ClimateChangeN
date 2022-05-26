package com.android.climatechange;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Webview1 extends AppCompatActivity {
    public WebView browser;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview1);



        browser = (WebView) findViewById(R.id.webview);
       browser.setWebViewClient(new WebViewClient());
       browser.loadUrl(" https://www.vanguardngr.com/2020/06/kenya-bans-single-use-plastics-in-fight-against-environmental-pollution");

      WebSettings webSettings = browser.getSettings();
      webSettings.setJavaScriptEnabled(true);




    }

    @Override
    public void onBackPressed() {
        if (browser.canGoBack()){
            browser.goBack();
        }
        else {
            super.onBackPressed();

        }

    }
}