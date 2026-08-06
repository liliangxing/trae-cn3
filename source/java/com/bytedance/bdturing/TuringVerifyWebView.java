package com.bytedance.bdturing;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.net.http.SslError;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.bdturing.cache.UrlInterceptor;
import com.bytedance.bdturing.setting.SettingsManager;
import com.bytedance.bdturing.verify.request.AbstractRequest;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class TuringVerifyWebView extends WebView {
    private static final int MAX_RETRY_COUNT = 3;
    private static final String TAG = "TuringVerifyWebView";
    private static final long TIMEOUT = 8000;
    private boolean mAutoRetryEnable;
    private int mCacheSate;
    private VerifyWebViewListener mCallback;
    private WebChromeClient mChromClient;
    private boolean mIsLoadFail;
    protected boolean mIsPageLoadSuccess;
    private OnTouchReportListener mOnTouchListener;
    private boolean mReceiveError;
    private boolean mRefreshCancel;
    private Runnable mRefreshWebPageTask;
    private AbstractRequest mRequest;
    private long mTimeAttached;
    private UrlInterceptor mUrlInterceptor;
    private WebViewClient mWebClient;
    private int retryTime;

    public static Context getFixedContext(Context context) {
        return context;
    }

    public TuringVerifyWebView(Context context) {
        super(getFixedContext(context), null);
        this.mAutoRetryEnable = true;
        this.mIsLoadFail = false;
        this.mIsPageLoadSuccess = false;
        this.retryTime = 0;
        this.mRefreshCancel = false;
        this.mReceiveError = false;
        this.mUrlInterceptor = null;
        this.mCacheSate = 0;
        this.mChromClient = new WebChromeClient() { // from class: com.bytedance.bdturing.TuringVerifyWebView.3
            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                LogUtil.m162i(TuringVerifyWebView.TAG, "onConsoleMessage:" + (consoleMessage != null ? consoleMessage.message() : ""));
                return super.onConsoleMessage(consoleMessage);
            }
        };
        this.mWebClient = new WebViewClient() { // from class: com.bytedance.bdturing.TuringVerifyWebView.4
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                LogUtil.m162i(TuringVerifyWebView.TAG, "onPageFinished:mIsLoadFail=" + TuringVerifyWebView.this.mIsLoadFail + ":mIsPageLoadSuccess=" + TuringVerifyWebView.this.mIsPageLoadSuccess + ":mReceiveError=" + TuringVerifyWebView.this.mReceiveError);
                if (!TuringVerifyWebView.this.mAutoRetryEnable) {
                    TuringVerifyWebView.this.onH5Available();
                }
                EventReport.webViewLoadFinish(TuringVerifyWebView.this.mReceiveError, TuringVerifyWebView.this.mRequest);
                super.onPageFinished(webView, str);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                LogUtil.m162i(TuringVerifyWebView.TAG, i + " onReceivedError " + str);
                String str3 = !TextUtils.isEmpty(str) ? str : "onReceivedError";
                TuringVerifyWebView.this.mReceiveError = true;
                TuringVerifyWebView.this.onLoadFailed(i, str2, str3);
                super.onReceivedError(webView, i, str, str2);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                TuringVerifyWebView.this.onLoadFailed(sslError != null ? sslError.getPrimaryError() : -1, sslError != null ? sslError.getUrl() : "", (sslError == null || sslError.getCertificate() == null) ? "onReceivedSslError" : sslError.getCertificate().toString());
                TuringVerifyWebView.this.mReceiveError = true;
                LogUtil.m162i(TuringVerifyWebView.TAG, "onReceivedSslError:" + sslError + ":" + Thread.currentThread().getName());
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                try {
                    if (webResourceRequest.getUrl().toString().toLowerCase().contains("/favicon.ico")) {
                        return;
                    }
                } catch (Exception e) {
                    LogUtil.printException(e);
                }
                TuringVerifyWebView.this.mReceiveError = true;
                int statusCode = webResourceResponse != null ? webResourceResponse.getStatusCode() : -1;
                String reasonPhrase = webResourceResponse != null ? webResourceResponse.getReasonPhrase() : "onReceivedHttpError";
                String uri = webResourceRequest != null ? webResourceRequest.getUrl().toString() : "";
                LogUtil.m162i(TuringVerifyWebView.TAG, "onReceivedHttpError:" + statusCode + "::" + webResourceRequest.isForMainFrame() + ":" + reasonPhrase + ":" + uri);
                TuringVerifyWebView.this.onLoadFailed(statusCode, uri, reasonPhrase);
            }

            @Override // android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                WebResourceResponse intercept;
                if (str.toLowerCase().contains("/favicon.ico")) {
                    try {
                        return new WebResourceResponse("image/png", null, null);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (TuringVerifyWebView.this.mUrlInterceptor != null && (intercept = TuringVerifyWebView.this.mUrlInterceptor.intercept(str)) != null) {
                    LogUtil.m160d(TuringVerifyWebView.TAG, "=====>getResource from local: timeUse=" + (System.currentTimeMillis() - currentTimeMillis) + ":url=" + str);
                    TuringVerifyWebView.this.mCacheSate = 1;
                    return intercept;
                }
                return super.shouldInterceptRequest(webView, str);
            }
        };
        this.mRefreshWebPageTask = new Runnable() { // from class: com.bytedance.bdturing.TuringVerifyWebView.7
            @Override // java.lang.Runnable
            public void run() {
                if (TuringVerifyWebView.this.mRefreshCancel) {
                    return;
                }
                TuringVerifyWebView.this.post(new Runnable() { // from class: com.bytedance.bdturing.TuringVerifyWebView.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TuringVerifyWebView.this.doRefresh();
                    }
                });
            }
        };
    }

    public TuringVerifyWebView(Context context, AttributeSet attributeSet) {
        super(getFixedContext(context), attributeSet);
        this.mAutoRetryEnable = true;
        this.mIsLoadFail = false;
        this.mIsPageLoadSuccess = false;
        this.retryTime = 0;
        this.mRefreshCancel = false;
        this.mReceiveError = false;
        this.mUrlInterceptor = null;
        this.mCacheSate = 0;
        this.mChromClient = new WebChromeClient() { // from class: com.bytedance.bdturing.TuringVerifyWebView.3
            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                LogUtil.m162i(TuringVerifyWebView.TAG, "onConsoleMessage:" + (consoleMessage != null ? consoleMessage.message() : ""));
                return super.onConsoleMessage(consoleMessage);
            }
        };
        this.mWebClient = new WebViewClient() { // from class: com.bytedance.bdturing.TuringVerifyWebView.4
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                LogUtil.m162i(TuringVerifyWebView.TAG, "onPageFinished:mIsLoadFail=" + TuringVerifyWebView.this.mIsLoadFail + ":mIsPageLoadSuccess=" + TuringVerifyWebView.this.mIsPageLoadSuccess + ":mReceiveError=" + TuringVerifyWebView.this.mReceiveError);
                if (!TuringVerifyWebView.this.mAutoRetryEnable) {
                    TuringVerifyWebView.this.onH5Available();
                }
                EventReport.webViewLoadFinish(TuringVerifyWebView.this.mReceiveError, TuringVerifyWebView.this.mRequest);
                super.onPageFinished(webView, str);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                LogUtil.m162i(TuringVerifyWebView.TAG, i + " onReceivedError " + str);
                String str3 = !TextUtils.isEmpty(str) ? str : "onReceivedError";
                TuringVerifyWebView.this.mReceiveError = true;
                TuringVerifyWebView.this.onLoadFailed(i, str2, str3);
                super.onReceivedError(webView, i, str, str2);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                TuringVerifyWebView.this.onLoadFailed(sslError != null ? sslError.getPrimaryError() : -1, sslError != null ? sslError.getUrl() : "", (sslError == null || sslError.getCertificate() == null) ? "onReceivedSslError" : sslError.getCertificate().toString());
                TuringVerifyWebView.this.mReceiveError = true;
                LogUtil.m162i(TuringVerifyWebView.TAG, "onReceivedSslError:" + sslError + ":" + Thread.currentThread().getName());
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                try {
                    if (webResourceRequest.getUrl().toString().toLowerCase().contains("/favicon.ico")) {
                        return;
                    }
                } catch (Exception e) {
                    LogUtil.printException(e);
                }
                TuringVerifyWebView.this.mReceiveError = true;
                int statusCode = webResourceResponse != null ? webResourceResponse.getStatusCode() : -1;
                String reasonPhrase = webResourceResponse != null ? webResourceResponse.getReasonPhrase() : "onReceivedHttpError";
                String uri = webResourceRequest != null ? webResourceRequest.getUrl().toString() : "";
                LogUtil.m162i(TuringVerifyWebView.TAG, "onReceivedHttpError:" + statusCode + "::" + webResourceRequest.isForMainFrame() + ":" + reasonPhrase + ":" + uri);
                TuringVerifyWebView.this.onLoadFailed(statusCode, uri, reasonPhrase);
            }

            @Override // android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                WebResourceResponse intercept;
                if (str.toLowerCase().contains("/favicon.ico")) {
                    try {
                        return new WebResourceResponse("image/png", null, null);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (TuringVerifyWebView.this.mUrlInterceptor != null && (intercept = TuringVerifyWebView.this.mUrlInterceptor.intercept(str)) != null) {
                    LogUtil.m160d(TuringVerifyWebView.TAG, "=====>getResource from local: timeUse=" + (System.currentTimeMillis() - currentTimeMillis) + ":url=" + str);
                    TuringVerifyWebView.this.mCacheSate = 1;
                    return intercept;
                }
                return super.shouldInterceptRequest(webView, str);
            }
        };
        this.mRefreshWebPageTask = new Runnable() { // from class: com.bytedance.bdturing.TuringVerifyWebView.7
            @Override // java.lang.Runnable
            public void run() {
                if (TuringVerifyWebView.this.mRefreshCancel) {
                    return;
                }
                TuringVerifyWebView.this.post(new Runnable() { // from class: com.bytedance.bdturing.TuringVerifyWebView.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TuringVerifyWebView.this.doRefresh();
                    }
                });
            }
        };
    }

    public TuringVerifyWebView(Context context, AttributeSet attributeSet, int i) {
        super(getFixedContext(context), attributeSet, i);
        this.mAutoRetryEnable = true;
        this.mIsLoadFail = false;
        this.mIsPageLoadSuccess = false;
        this.retryTime = 0;
        this.mRefreshCancel = false;
        this.mReceiveError = false;
        this.mUrlInterceptor = null;
        this.mCacheSate = 0;
        this.mChromClient = new WebChromeClient() { // from class: com.bytedance.bdturing.TuringVerifyWebView.3
            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                LogUtil.m162i(TuringVerifyWebView.TAG, "onConsoleMessage:" + (consoleMessage != null ? consoleMessage.message() : ""));
                return super.onConsoleMessage(consoleMessage);
            }
        };
        this.mWebClient = new WebViewClient() { // from class: com.bytedance.bdturing.TuringVerifyWebView.4
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                LogUtil.m162i(TuringVerifyWebView.TAG, "onPageFinished:mIsLoadFail=" + TuringVerifyWebView.this.mIsLoadFail + ":mIsPageLoadSuccess=" + TuringVerifyWebView.this.mIsPageLoadSuccess + ":mReceiveError=" + TuringVerifyWebView.this.mReceiveError);
                if (!TuringVerifyWebView.this.mAutoRetryEnable) {
                    TuringVerifyWebView.this.onH5Available();
                }
                EventReport.webViewLoadFinish(TuringVerifyWebView.this.mReceiveError, TuringVerifyWebView.this.mRequest);
                super.onPageFinished(webView, str);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i2, String str, String str2) {
                LogUtil.m162i(TuringVerifyWebView.TAG, i2 + " onReceivedError " + str);
                String str3 = !TextUtils.isEmpty(str) ? str : "onReceivedError";
                TuringVerifyWebView.this.mReceiveError = true;
                TuringVerifyWebView.this.onLoadFailed(i2, str2, str3);
                super.onReceivedError(webView, i2, str, str2);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                TuringVerifyWebView.this.onLoadFailed(sslError != null ? sslError.getPrimaryError() : -1, sslError != null ? sslError.getUrl() : "", (sslError == null || sslError.getCertificate() == null) ? "onReceivedSslError" : sslError.getCertificate().toString());
                TuringVerifyWebView.this.mReceiveError = true;
                LogUtil.m162i(TuringVerifyWebView.TAG, "onReceivedSslError:" + sslError + ":" + Thread.currentThread().getName());
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                try {
                    if (webResourceRequest.getUrl().toString().toLowerCase().contains("/favicon.ico")) {
                        return;
                    }
                } catch (Exception e) {
                    LogUtil.printException(e);
                }
                TuringVerifyWebView.this.mReceiveError = true;
                int statusCode = webResourceResponse != null ? webResourceResponse.getStatusCode() : -1;
                String reasonPhrase = webResourceResponse != null ? webResourceResponse.getReasonPhrase() : "onReceivedHttpError";
                String uri = webResourceRequest != null ? webResourceRequest.getUrl().toString() : "";
                LogUtil.m162i(TuringVerifyWebView.TAG, "onReceivedHttpError:" + statusCode + "::" + webResourceRequest.isForMainFrame() + ":" + reasonPhrase + ":" + uri);
                TuringVerifyWebView.this.onLoadFailed(statusCode, uri, reasonPhrase);
            }

            @Override // android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                WebResourceResponse intercept;
                if (str.toLowerCase().contains("/favicon.ico")) {
                    try {
                        return new WebResourceResponse("image/png", null, null);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (TuringVerifyWebView.this.mUrlInterceptor != null && (intercept = TuringVerifyWebView.this.mUrlInterceptor.intercept(str)) != null) {
                    LogUtil.m160d(TuringVerifyWebView.TAG, "=====>getResource from local: timeUse=" + (System.currentTimeMillis() - currentTimeMillis) + ":url=" + str);
                    TuringVerifyWebView.this.mCacheSate = 1;
                    return intercept;
                }
                return super.shouldInterceptRequest(webView, str);
            }
        };
        this.mRefreshWebPageTask = new Runnable() { // from class: com.bytedance.bdturing.TuringVerifyWebView.7
            @Override // java.lang.Runnable
            public void run() {
                if (TuringVerifyWebView.this.mRefreshCancel) {
                    return;
                }
                TuringVerifyWebView.this.post(new Runnable() { // from class: com.bytedance.bdturing.TuringVerifyWebView.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TuringVerifyWebView.this.doRefresh();
                    }
                });
            }
        };
    }

    public TuringVerifyWebView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(getFixedContext(context), attributeSet, i, i2);
        this.mAutoRetryEnable = true;
        this.mIsLoadFail = false;
        this.mIsPageLoadSuccess = false;
        this.retryTime = 0;
        this.mRefreshCancel = false;
        this.mReceiveError = false;
        this.mUrlInterceptor = null;
        this.mCacheSate = 0;
        this.mChromClient = new WebChromeClient() { // from class: com.bytedance.bdturing.TuringVerifyWebView.3
            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                LogUtil.m162i(TuringVerifyWebView.TAG, "onConsoleMessage:" + (consoleMessage != null ? consoleMessage.message() : ""));
                return super.onConsoleMessage(consoleMessage);
            }
        };
        this.mWebClient = new WebViewClient() { // from class: com.bytedance.bdturing.TuringVerifyWebView.4
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                LogUtil.m162i(TuringVerifyWebView.TAG, "onPageFinished:mIsLoadFail=" + TuringVerifyWebView.this.mIsLoadFail + ":mIsPageLoadSuccess=" + TuringVerifyWebView.this.mIsPageLoadSuccess + ":mReceiveError=" + TuringVerifyWebView.this.mReceiveError);
                if (!TuringVerifyWebView.this.mAutoRetryEnable) {
                    TuringVerifyWebView.this.onH5Available();
                }
                EventReport.webViewLoadFinish(TuringVerifyWebView.this.mReceiveError, TuringVerifyWebView.this.mRequest);
                super.onPageFinished(webView, str);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i22, String str, String str2) {
                LogUtil.m162i(TuringVerifyWebView.TAG, i22 + " onReceivedError " + str);
                String str3 = !TextUtils.isEmpty(str) ? str : "onReceivedError";
                TuringVerifyWebView.this.mReceiveError = true;
                TuringVerifyWebView.this.onLoadFailed(i22, str2, str3);
                super.onReceivedError(webView, i22, str, str2);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                TuringVerifyWebView.this.onLoadFailed(sslError != null ? sslError.getPrimaryError() : -1, sslError != null ? sslError.getUrl() : "", (sslError == null || sslError.getCertificate() == null) ? "onReceivedSslError" : sslError.getCertificate().toString());
                TuringVerifyWebView.this.mReceiveError = true;
                LogUtil.m162i(TuringVerifyWebView.TAG, "onReceivedSslError:" + sslError + ":" + Thread.currentThread().getName());
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                try {
                    if (webResourceRequest.getUrl().toString().toLowerCase().contains("/favicon.ico")) {
                        return;
                    }
                } catch (Exception e) {
                    LogUtil.printException(e);
                }
                TuringVerifyWebView.this.mReceiveError = true;
                int statusCode = webResourceResponse != null ? webResourceResponse.getStatusCode() : -1;
                String reasonPhrase = webResourceResponse != null ? webResourceResponse.getReasonPhrase() : "onReceivedHttpError";
                String uri = webResourceRequest != null ? webResourceRequest.getUrl().toString() : "";
                LogUtil.m162i(TuringVerifyWebView.TAG, "onReceivedHttpError:" + statusCode + "::" + webResourceRequest.isForMainFrame() + ":" + reasonPhrase + ":" + uri);
                TuringVerifyWebView.this.onLoadFailed(statusCode, uri, reasonPhrase);
            }

            @Override // android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                WebResourceResponse intercept;
                if (str.toLowerCase().contains("/favicon.ico")) {
                    try {
                        return new WebResourceResponse("image/png", null, null);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (TuringVerifyWebView.this.mUrlInterceptor != null && (intercept = TuringVerifyWebView.this.mUrlInterceptor.intercept(str)) != null) {
                    LogUtil.m160d(TuringVerifyWebView.TAG, "=====>getResource from local: timeUse=" + (System.currentTimeMillis() - currentTimeMillis) + ":url=" + str);
                    TuringVerifyWebView.this.mCacheSate = 1;
                    return intercept;
                }
                return super.shouldInterceptRequest(webView, str);
            }
        };
        this.mRefreshWebPageTask = new Runnable() { // from class: com.bytedance.bdturing.TuringVerifyWebView.7
            @Override // java.lang.Runnable
            public void run() {
                if (TuringVerifyWebView.this.mRefreshCancel) {
                    return;
                }
                TuringVerifyWebView.this.post(new Runnable() { // from class: com.bytedance.bdturing.TuringVerifyWebView.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TuringVerifyWebView.this.doRefresh();
                    }
                });
            }
        };
    }

    public void init(VerifyWebViewListener verifyWebViewListener, boolean z, AbstractRequest abstractRequest) {
        this.mAutoRetryEnable = z;
        this.mCallback = verifyWebViewListener;
        this.mRequest = abstractRequest;
        WebSettings settings = getSettings();
        settings.setLoadWithOverviewMode(true);
        settings.setDomStorageEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setSupportZoom(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowFileAccess(false);
        settings.setLoadsImagesAutomatically(true);
        settings.setDefaultTextEncodingName("utf-8");
        settings.setCacheMode(2);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setTextZoom(100);
        try {
            setOverScrollMode(2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        setScrollContainer(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        if (LogUtil.isDebug()) {
            setWebChromeClient(this.mChromClient);
        }
        setWebViewClient(this.mWebClient);
    }

    public void init(VerifyWebViewListener verifyWebViewListener, AbstractRequest abstractRequest) {
        init(verifyWebViewListener, true, abstractRequest);
    }

    private boolean isBoe() {
        BdTuringConfig config = BdTuring.getInstance().getConfig();
        return config != null && config.getRegionType() == BdTuringConfig.RegionType.REGION_BOE;
    }

    public void setOnTouchListener(OnTouchReportListener onTouchReportListener) {
        this.mOnTouchListener = onTouchReportListener;
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        OnTouchReportListener onTouchReportListener = this.mOnTouchListener;
        if (onTouchReportListener != null) {
            onTouchReportListener.onTouch(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void startOrientationChangeAnimation(int i, int i2, int i3, int i4) {
        ValueAnimator ofObject = ValueAnimator.ofObject(new TypeEvaluator<int[]>() { // from class: com.bytedance.bdturing.TuringVerifyWebView.1
            @Override // android.animation.TypeEvaluator
            public int[] evaluate(float f, int[] iArr, int[] iArr2) {
                int length = iArr.length;
                int[] iArr3 = new int[length];
                for (int i5 = 0; i5 < length; i5++) {
                    iArr3[i5] = (int) (iArr[i5] + ((iArr2[i5] - r3) * f));
                }
                return iArr3;
            }
        }, new int[]{i3, i4}, new int[]{i, i2});
        ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.bdturing.TuringVerifyWebView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewGroup.LayoutParams layoutParams = TuringVerifyWebView.this.getLayoutParams();
                int[] iArr = (int[]) valueAnimator.getAnimatedValue();
                layoutParams.width = iArr[0];
                layoutParams.height = iArr[1];
                TuringVerifyWebView.this.setLayoutParams(layoutParams);
            }
        });
        ofObject.setDuration(300L).start();
    }

    private void onLoadSuccess() {
        LogUtil.m162i(TAG, "onLoadSuccess");
        EventReport.statisticLoadPage(0, "success", this.mCacheSate, this.mRequest);
        this.mIsPageLoadSuccess = true;
        if (this.mCallback != null) {
            post(new Runnable() { // from class: com.bytedance.bdturing.TuringVerifyWebView.5
                @Override // java.lang.Runnable
                public void run() {
                    if (TuringVerifyWebView.this.mCallback != null) {
                        TuringVerifyWebView.this.mCallback.onLoadPageSuccess();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoadFailed(final int i, final String str, final String str2) {
        EventReport.statisticLoadPage(i, str2 + "|" + str, this.mCacheSate, this.mRequest);
        if (this.mCallback != null) {
            post(new Runnable() { // from class: com.bytedance.bdturing.TuringVerifyWebView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (TuringVerifyWebView.this.mCallback != null) {
                        TuringVerifyWebView.this.mCallback.onReceivedError(i, str, str2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doRefresh() {
        if (this.mRefreshCancel) {
            return;
        }
        int i = this.retryTime + 1;
        this.retryTime = i;
        if (i < 3) {
            this.mIsPageLoadSuccess = false;
            this.mIsLoadFail = false;
            this.mReceiveError = false;
            LogUtil.m162i(TAG, "doRefresh retryTime = " + this.retryTime);
            reload();
            VerifyTaskHandler.getInstance().postRunnableDelay(this.mRefreshWebPageTask, getTimeOut());
            return;
        }
        this.mIsPageLoadSuccess = false;
        this.mIsLoadFail = true;
        post(new Runnable() { // from class: com.bytedance.bdturing.TuringVerifyWebView.8
            @Override // java.lang.Runnable
            public void run() {
                LogUtil.m162i(TuringVerifyWebView.TAG, "h5 load failed after retry ");
                EventReport.statisticLoadPage(-10001, "h5 load failed after retry", TuringVerifyWebView.this.mCacheSate, TuringVerifyWebView.this.mRequest);
                if (TuringVerifyWebView.this.mCallback != null) {
                    TuringVerifyWebView.this.mCallback.onLoadPageFail(-10001, "h5 load failed");
                }
            }
        });
    }

    private long getTimeOut() {
        return Math.max(SettingsManager.INSTANCE.getH5LoadTimeOut(), TIMEOUT);
    }

    public void onH5Available() {
        this.mRefreshCancel = true;
        this.mIsLoadFail = false;
        this.retryTime = 0;
        VerifyTaskHandler.getInstance().removeRunnable(this.mRefreshWebPageTask);
        onLoadSuccess();
    }

    public void setInterceptor(UrlInterceptor urlInterceptor) {
        this.mUrlInterceptor = urlInterceptor;
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        super.loadUrl(str);
        LogUtil.m162i(TAG, "loadUrl");
        if ("about:blank".equals(str) || TextUtils.isEmpty(str)) {
            return;
        }
        UrlInterceptor urlInterceptor = this.mUrlInterceptor;
        if (urlInterceptor != null) {
            urlInterceptor.loadUrl(str);
        }
        this.mReceiveError = false;
        this.mIsPageLoadSuccess = false;
        this.mIsLoadFail = false;
        this.retryTime = 0;
        if (this.mAutoRetryEnable) {
            VerifyTaskHandler.getInstance().postRunnableDelay(this.mRefreshWebPageTask, getTimeOut());
        }
    }

    @Override // android.webkit.WebView
    public void reload() {
        LogUtil.m162i(TAG, "reload called:");
        super.reload();
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        EventReport.webViewOnAttachedToWindow(this.mRequest);
        this.mTimeAttached = System.currentTimeMillis();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        EventReport.webViewDetachedFromWindow(this.mIsPageLoadSuccess, this.mIsLoadFail, System.currentTimeMillis() - this.mTimeAttached, this.mRequest);
        this.mRefreshCancel = true;
        VerifyTaskHandler.getInstance().removeRunnable(this.mRefreshWebPageTask);
    }
}
