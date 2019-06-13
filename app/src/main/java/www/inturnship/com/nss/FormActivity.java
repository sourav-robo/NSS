package www.inturnship.com.nss;

import android.graphics.Bitmap;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;


public class FormActivity extends AppCompatActivity {
    WebView webView;
    ProgressBar progress_bar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        if(Build.VERSION.SDK_INT>=21){
            Window window=this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.header));
        }
        progress_bar=findViewById(R.id.progress_bar);
        webView=findViewById(R.id.webView);
        progress_bar.setProgress(0);
        progress_bar.setMax(100);
        WebSettings webSettings = webView.getSettings();
                webSettings.setJavaScriptEnabled(true);
                webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
                webView.loadUrl("https://goo.gl/forms/mb9Cu4C3lmk9AzdX2");
                webView.setWebViewClient(new MyWebClient());
                webView.setWebChromeClient(new WebChromeClient());

    }

    private class MyWebClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

                view.loadUrl(url);
            return true;

        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            progress_bar.setVisibility(view.VISIBLE);
            progress_bar.setProgress(0);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progress_bar.setVisibility(view.GONE);
            progress_bar.setProgress(100);

        }
    }

    private class WebChromeClient extends android.webkit.WebChromeClient{
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            progress_bar.setProgress(newProgress);
        }
    }




}
