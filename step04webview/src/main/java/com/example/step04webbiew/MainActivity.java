package com.example.step04webbiew;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //WebView 의 참조값 얻어오기
        WebView webView=findViewById(R.id.webView);
        WebSettings ws=webView.getSettings();
        ws.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());

        //시작 url 로딩 시키기
        webView.loadUrl("http://192.168.0.9:8888/spring05/");
    }
}
