package com.example.chatbotwebview

// MainActivity.kt
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webView)
        setupWebView()
        loadChatHtml()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setupWebView() {
        webView.settings.javaScriptEnabled = true
        webView.webChromeClient = WebChromeClient()
        webView.webViewClient = object : WebViewClient() {
            override fun onReceivedError(
                view: WebView?,
                errorCode: Int,
                description: String?,
                failingUrl: String?
            ) {
                super.onReceivedError(view, errorCode, description, failingUrl)
                // Handle errors, including ERR_CLEARTEXT_NOT_PERMITTED
                Toast.makeText(
                    this@MainActivity,
                    "Error loading page: $description",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun loadChatHtml() {
        // Load the HTML file containing the chat interface from the assets directory
        webView.loadUrl("file:///android_asset/chat.html")
    }
}
