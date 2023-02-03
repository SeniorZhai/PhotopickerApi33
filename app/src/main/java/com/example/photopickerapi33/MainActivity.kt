package com.example.photopickerapi33

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.webkit.ValueCallback
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val wrapper = NewPhotoPickerWrapper(this, 2)

    // private val button: Button by lazy {
    //     findViewById(R.id.button)
    // }

    private val webView: WebView by lazy {
        findViewById(R.id.webview)
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webSettings.javaScriptCanOpenWindowsAutomatically = true
        webSettings.allowFileAccessFromFileURLs = true
        webSettings.allowUniversalAccessFromFileURLs = true
        webView.webChromeClient = object : WebChromeClient() {
            override fun onShowFileChooser(
                webView: WebView?,
                filePathCallback: ValueCallback<Array<Uri>>?,
                fileChooserParams: FileChooserParams?
            ): Boolean {
                uploadMessage?.onReceiveValue(null)
                uploadMessage = filePathCallback
                wrapper.singleImage(
                    onSingle = { uri ->
                        uploadMessage?.onReceiveValue(arrayOf(uri))
                        uploadMessage = null
                    },
                    onEmpty = {
                        uploadMessage?.onReceiveValue(null)
                        uploadMessage = null
                    }
                )
                return true
            }
        }
        webView.loadDataWithBaseURL(null, Content.content, "text/html", "UTF-8", null);
    }
    var uploadMessage: ValueCallback<Array<Uri>>? = null
}