package com.bytedance.bdturing.methods;

import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.bytedance.bdturing.LogUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class JsBridgeModule {
    private static final String CALL_BACK_ID = "__callback_id";
    private static final String PARAMS = "__params";
    private static final String TAG = "JsBridgeModule";
    private Handler mUiHandler;
    private WebView mWebView;

    /* loaded from: classes3.dex */
    private class AndroidJsInterface {
        private IVerifyInnerHandler mVerifyHandler;

        public AndroidJsInterface(IVerifyInnerHandler iVerifyInnerHandler) {
            this.mVerifyHandler = iVerifyInnerHandler;
        }

        @JavascriptInterface
        public void callMethodParams(final String str) {
            LogUtil.d(JsBridgeModule.TAG, "JS called method ======= callMethodParams(" + str + ")");
            if (JsBridgeModule.this.mUiHandler != null) {
                JsBridgeModule.this.mUiHandler.post(new Runnable() { // from class: com.bytedance.bdturing.methods.JsBridgeModule.AndroidJsInterface.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AndroidJsInterface.this.mVerifyHandler.handle(new JsCallParser(JsBridgeModule.this, str));
                    }
                });
            } else {
                LogUtil.i(JsBridgeModule.TAG, "uihandler is null");
            }
        }

        @JavascriptInterface
        public void onMethodParams(String str) {
            LogUtil.d(JsBridgeModule.TAG, "JS called method ======= onMethodParams(" + str + ")");
            try {
                new JSONObject(str).getString(JsBridgeModule.CALL_BACK_ID);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @JavascriptInterface
        public void offMethodParams(String str) {
            LogUtil.d(JsBridgeModule.TAG, "JS called method ======= offMethodParams(" + str + ")");
        }
    }

    /* loaded from: classes3.dex */
    public class JS2NativeInterface {
        private IVerifyInnerHandler mVerifyHandler;

        public JS2NativeInterface(IVerifyInnerHandler iVerifyInnerHandler) {
            this.mVerifyHandler = iVerifyInnerHandler;
        }

        @JavascriptInterface
        public String _invokeMethod(final String str) {
            LogUtil.d(JsBridgeModule.TAG, "JS called method ======= _invokeMethod(" + str + ")");
            if (JsBridgeModule.this.mUiHandler != null) {
                JsBridgeModule.this.mUiHandler.post(new Runnable() { // from class: com.bytedance.bdturing.methods.JsBridgeModule.JS2NativeInterface.1
                    @Override // java.lang.Runnable
                    public void run() {
                        JS2NativeInterface.this.mVerifyHandler.handle(new JsCallParser(JsBridgeModule.this, str));
                    }
                });
                return null;
            }
            LogUtil.i(JsBridgeModule.TAG, "uihandler is null");
            return null;
        }
    }

    public JsBridgeModule(IVerifyInnerHandler iVerifyInnerHandler, WebView webView) {
        this.mUiHandler = null;
        this.mWebView = webView;
        if (webView == null) {
            return;
        }
        webView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.addJavascriptInterface(new AndroidJsInterface(iVerifyInnerHandler), "androidJsBridge");
        this.mUiHandler = new Handler(Looper.getMainLooper());
    }

    public void callJsCode(final String str) {
        Handler handler;
        if (str == null || this.mWebView == null || (handler = this.mUiHandler) == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.bytedance.bdturing.methods.JsBridgeModule.1
            WebView webView;

            {
                this.webView = JsBridgeModule.this.mWebView;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.webView != null) {
                    this.webView.evaluateJavascript("javascript:window.Native2JSBridge._handleMessageFromApp(" + str + ")", null);
                    LogUtil.w(JsBridgeModule.TAG, "callJsCode ====== " + str);
                }
            }
        });
        LogUtil.d(TAG, "callJsCode ====== " + str);
    }

    public void clearJsBridgeResources() {
        if (this.mWebView == null) {
            return;
        }
        this.mUiHandler.post(new Runnable() { // from class: com.bytedance.bdturing.methods.JsBridgeModule.2
            WebView webView;

            {
                this.webView = JsBridgeModule.this.mWebView;
            }

            @Override // java.lang.Runnable
            public void run() {
                WebView webView = this.webView;
                if (webView != null) {
                    webView.stopLoading();
                    this.webView.loadUrl("about:blank");
                    this.webView.clearCache(true);
                    this.webView.clearHistory();
                    ViewParent parent = this.webView.getParent();
                    if (parent != null && (parent instanceof ViewGroup)) {
                        ((ViewGroup) parent).removeView(this.webView);
                    }
                    this.webView.destroy();
                }
            }
        });
        this.mUiHandler = null;
        this.mWebView = null;
    }
}
