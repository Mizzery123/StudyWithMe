package sg.edu.rp.c346.studywithme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebPage extends AppCompatActivity {

    WebView wvRPPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_page);

        wvRPPage = findViewById(R.id.WebViewLogin);
        wvRPPage.setWebViewClient(new WebViewClient());



        Intent intentReceived = getIntent();
        String strURL = intentReceived.getStringExtra("URL");
        wvRPPage.loadUrl(strURL);
    }
}
