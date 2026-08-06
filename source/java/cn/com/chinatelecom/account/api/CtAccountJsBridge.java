package cn.com.chinatelecom.account.api;

import android.os.Handler;
import android.os.Looper;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import cn.com.chinatelecom.account.api.p007b.InterfaceC0679a;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class CtAccountJsBridge implements InterfaceC0679a {
    private static final String TAG = "CtAccountJsBridge";
    public static Handler mHandler = new Handler(Looper.getMainLooper());
    private InterfaceC0671a callback;
    private WebView mWebView;

    /* renamed from: cn.com.chinatelecom.account.api.CtAccountJsBridge$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public interface InterfaceC0671a {
        /* renamed from: a */
        void m181a(String str);
    }

    public CtAccountJsBridge(WebView webView) {
        this.mWebView = webView;
    }

    public CtAccountJsBridge(InterfaceC0671a interfaceC0671a) {
        this.callback = interfaceC0671a;
    }

    @Override // cn.com.chinatelecom.account.api.p007b.InterfaceC0679a
    public void callbackPreCode(final String str) {
        CtAuth.info(TAG, "callbackPreCode:" + str);
        mHandler.post(new Runnable() { // from class: cn.com.chinatelecom.account.api.CtAccountJsBridge.1
            @Override // java.lang.Runnable
            public void run() {
                if (CtAccountJsBridge.this.mWebView != null) {
                    CtAccountJsBridge.this.mWebView.loadUrl("javascript:ejsBridge.callbackPreCode('" + str + "')");
                } else if (CtAccountJsBridge.this.callback != null) {
                    CtAccountJsBridge.this.callback.m181a("javascript:ejsBridge.callbackPreCode('" + str + "')");
                }
            }
        });
    }

    @Override // cn.com.chinatelecom.account.api.p007b.InterfaceC0679a
    public void callbackPreCodeParams(final String str) {
        CtAuth.info(TAG, "callbackPreCodeParams:" + str);
        mHandler.post(new Runnable() { // from class: cn.com.chinatelecom.account.api.CtAccountJsBridge.2
            @Override // java.lang.Runnable
            public void run() {
                if (CtAccountJsBridge.this.mWebView != null) {
                    CtAccountJsBridge.this.mWebView.loadUrl("javascript:ejsBridge.callbackPreCodeParams('" + str + "')");
                } else if (CtAccountJsBridge.this.callback != null) {
                    CtAccountJsBridge.this.callback.m181a("javascript:ejsBridge.callbackPreCodeParams('" + str + "')");
                }
            }
        });
    }

    @JavascriptInterface
    public void getPreCodeParams(String str) {
        CtAuth.info(TAG, "getPreCodeParams:" + str);
        CtAuth.getInstance().getPreCodeParamsByJs(str, this);
    }

    @JavascriptInterface
    public void requestPreCode(String str) {
        CtAuth.info(TAG, "requestPreCode:" + str);
        CtAuth.getInstance().requestPreCodeByJs(str, this);
    }
}
