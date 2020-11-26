package com.example.techblog;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

public class DetailActivity extends AppCompatActivity {
ProgressBar progressBar;
Toolbar toolbar;
WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
       progressBar=findViewById(R.id.progressBar);
       toolbar=findViewById(R.id.toolbar);
       webView=findViewById(R.id.detailView);
       setSupportActionBar(toolbar);


//
       webView.setVisibility(View.INVISIBLE);
       webView.getSettings().setJavaScriptEnabled(true);
//       set chrome client
     webView.setWebChromeClient(new WebChromeClient());
//     event of webview for when page started ,finished etc
     webView.setWebViewClient(new WebViewClient(){
//         @Override
//         public void onPageStarted(WebView view, String url, Bitmap favicon) {
//             super.onPageStarted(view, url, favicon);
//
//              }

         @Override
         public void onPageFinished(WebView view, String url) {
             super.onPageFinished(view, url);
             //         after the progress bar loaded then hide the progress bar
             progressBar.setVisibility(View.GONE);
             webView.setVisibility(View.VISIBLE);

         }


     });
     webView.loadUrl(getIntent().getStringExtra("url"));
      {

      }

        }

    }
