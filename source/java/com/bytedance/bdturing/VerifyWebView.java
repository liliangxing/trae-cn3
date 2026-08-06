package com.bytedance.bdturing;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
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

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class VerifyWebView extends WebView {
    private static final int MAX_RETRY_COUNT = 3;
    private static final long RETRY_TIME_DELAY = 500;
    private static final String TAG = "VerifyWebView";
    private int mCacheSate;
    private VerifyWebViewListener mCallback;
    private WebChromeClient mChromClient;
    private boolean mIsLoadFail;
    protected boolean mIsPageFinished;
    private OnTouchReportListener mOnTouchListener;
    private boolean mRefreshCancel;
    private Runnable mRefreshWebPageTask;
    private long mTimeAttached;
    private UrlInterceptor mUrlInterceptor;
    private WebViewClient mWebClient;
    private int retryTime;

    public static Context getFixedContext(Context context) {
        return context;
    }

    public VerifyWebView(Context context) {
        super(getFixedContext(context), null);
        this.mIsLoadFail = false;
        this.mIsPageFinished = false;
        this.retryTime = 0;
        this.mRefreshCancel = false;
        this.mUrlInterceptor = null;
        this.mCacheSate = 0;
        this.mChromClient = new WebChromeClient() { // from class: com.bytedance.bdturing.VerifyWebView.3
            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                LogUtil.m162i(VerifyWebView.TAG, "onConsoleMessage:" + (consoleMessage != null ? consoleMessage.message() : ""));
                return super.onConsoleMessage(consoleMessage);
            }
        };
        this.mWebClient = new WebViewClient() { // from class: com.bytedance.bdturing.VerifyWebView.4
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                LogUtil.m162i(VerifyWebView.TAG, "onPageStarted");
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                LogUtil.m162i(VerifyWebView.TAG, "onPageFinished:mIsLoadFail=" + VerifyWebView.this.mIsLoadFail + ":mIsPageFinished=" + VerifyWebView.this.mIsPageFinished);
                if (!VerifyWebView.this.mIsLoadFail && !VerifyWebView.this.mIsPageFinished) {
                    VerifyWebView.this.onLoadSuccess();
                }
                super.onPageFinished(webView, str);
            }

            @Override // android.webkit.WebViewClient
            public void onLoadResource(WebView webView, String str) {
                super.onLoadResource(webView, str);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                LogUtil.m162i(VerifyWebView.TAG, i + " onReceivedError " + str);
                VerifyWebView.this.onLoadFailed(i, str2, !TextUtils.isEmpty(str) ? str : "onReceivedError");
                super.onReceivedError(webView, i, str, str2);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                VerifyWebView.this.onLoadFailed(sslError != null ? sslError.getPrimaryError() : -1, sslError != null ? sslError.getUrl() : "", (sslError == null || sslError.getCertificate() == null) ? "onReceivedSslError" : sslError.getCertificate().toString());
                LogUtil.m162i(VerifyWebView.TAG, "onReceivedSslError:" + sslError + ":" + Thread.currentThread().getName());
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
                int statusCode = webResourceResponse != null ? webResourceResponse.getStatusCode() : -1;
                String reasonPhrase = webResourceResponse != null ? webResourceResponse.getReasonPhrase() : "onReceivedHttpError";
                String uri = webResourceRequest != null ? webResourceRequest.getUrl().toString() : "";
                LogUtil.m162i(VerifyWebView.TAG, "onReceivedHttpError:" + statusCode + "::" + webResourceRequest.isForMainFrame() + ":" + reasonPhrase + ":" + uri);
                VerifyWebView.this.onLoadFailed(statusCode, uri, reasonPhrase);
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
                if (VerifyWebView.this.mUrlInterceptor != null && (intercept = VerifyWebView.this.mUrlInterceptor.intercept(str)) != null) {
                    VerifyWebView.this.mCacheSate = 1;
                    return intercept;
                }
                return super.shouldInterceptRequest(webView, str);
            }
        };
        this.mRefreshWebPageTask = new Runnable() { // from class: com.bytedance.bdturing.VerifyWebView.8
            @Override // java.lang.Runnable
            public void run() {
                if (VerifyWebView.this.mRefreshCancel) {
                    return;
                }
                VerifyWebView.this.post(new Runnable() { // from class: com.bytedance.bdturing.VerifyWebView.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        VerifyWebView.this.reload();
                    }
                });
            }
        };
    }

    public VerifyWebView(Context context, AttributeSet attributeSet) {
        super(getFixedContext(context), attributeSet);
        this.mIsLoadFail = false;
        this.mIsPageFinished = false;
        this.retryTime = 0;
        this.mRefreshCancel = false;
        this.mUrlInterceptor = null;
        this.mCacheSate = 0;
        this.mChromClient = new WebChromeClient() { // from class: com.bytedance.bdturing.VerifyWebView.3
            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                LogUtil.m162i(VerifyWebView.TAG, "onConsoleMessage:" + (consoleMessage != null ? consoleMessage.message() : ""));
                return super.onConsoleMessage(consoleMessage);
            }
        };
        this.mWebClient = new WebViewClient() { // from class: com.bytedance.bdturing.VerifyWebView.4
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                LogUtil.m162i(VerifyWebView.TAG, "onPageStarted");
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                LogUtil.m162i(VerifyWebView.TAG, "onPageFinished:mIsLoadFail=" + VerifyWebView.this.mIsLoadFail + ":mIsPageFinished=" + VerifyWebView.this.mIsPageFinished);
                if (!VerifyWebView.this.mIsLoadFail && !VerifyWebView.this.mIsPageFinished) {
                    VerifyWebView.this.onLoadSuccess();
                }
                super.onPageFinished(webView, str);
            }

            @Override // android.webkit.WebViewClient
            public void onLoadResource(WebView webView, String str) {
                super.onLoadResource(webView, str);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                LogUtil.m162i(VerifyWebView.TAG, i + " onReceivedError " + str);
                VerifyWebView.this.onLoadFailed(i, str2, !TextUtils.isEmpty(str) ? str : "onReceivedError");
                super.onReceivedError(webView, i, str, str2);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                VerifyWebView.this.onLoadFailed(sslError != null ? sslError.getPrimaryError() : -1, sslError != null ? sslError.getUrl() : "", (sslError == null || sslError.getCertificate() == null) ? "onReceivedSslError" : sslError.getCertificate().toString());
                LogUtil.m162i(VerifyWebView.TAG, "onReceivedSslError:" + sslError + ":" + Thread.currentThread().getName());
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
                int statusCode = webResourceResponse != null ? webResourceResponse.getStatusCode() : -1;
                String reasonPhrase = webResourceResponse != null ? webResourceResponse.getReasonPhrase() : "onReceivedHttpError";
                String uri = webResourceRequest != null ? webResourceRequest.getUrl().toString() : "";
                LogUtil.m162i(VerifyWebView.TAG, "onReceivedHttpError:" + statusCode + "::" + webResourceRequest.isForMainFrame() + ":" + reasonPhrase + ":" + uri);
                VerifyWebView.this.onLoadFailed(statusCode, uri, reasonPhrase);
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
                if (VerifyWebView.this.mUrlInterceptor != null && (intercept = VerifyWebView.this.mUrlInterceptor.intercept(str)) != null) {
                    VerifyWebView.this.mCacheSate = 1;
                    return intercept;
                }
                return super.shouldInterceptRequest(webView, str);
            }
        };
        this.mRefreshWebPageTask = new Runnable() { // from class: com.bytedance.bdturing.VerifyWebView.8
            @Override // java.lang.Runnable
            public void run() {
                if (VerifyWebView.this.mRefreshCancel) {
                    return;
                }
                VerifyWebView.this.post(new Runnable() { // from class: com.bytedance.bdturing.VerifyWebView.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        VerifyWebView.this.reload();
                    }
                });
            }
        };
    }

    public VerifyWebView(Context context, AttributeSet attributeSet, int i) {
        super(getFixedContext(context), attributeSet, i);
        this.mIsLoadFail = false;
        this.mIsPageFinished = false;
        this.retryTime = 0;
        this.mRefreshCancel = false;
        this.mUrlInterceptor = null;
        this.mCacheSate = 0;
        this.mChromClient = new WebChromeClient() { // from class: com.bytedance.bdturing.VerifyWebView.3
            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                LogUtil.m162i(VerifyWebView.TAG, "onConsoleMessage:" + (consoleMessage != null ? consoleMessage.message() : ""));
                return super.onConsoleMessage(consoleMessage);
            }
        };
        this.mWebClient = new WebViewClient() { // from class: com.bytedance.bdturing.VerifyWebView.4
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                LogUtil.m162i(VerifyWebView.TAG, "onPageStarted");
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                LogUtil.m162i(VerifyWebView.TAG, "onPageFinished:mIsLoadFail=" + VerifyWebView.this.mIsLoadFail + ":mIsPageFinished=" + VerifyWebView.this.mIsPageFinished);
                if (!VerifyWebView.this.mIsLoadFail && !VerifyWebView.this.mIsPageFinished) {
                    VerifyWebView.this.onLoadSuccess();
                }
                super.onPageFinished(webView, str);
            }

            @Override // android.webkit.WebViewClient
            public void onLoadResource(WebView webView, String str) {
                super.onLoadResource(webView, str);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i2, String str, String str2) {
                LogUtil.m162i(VerifyWebView.TAG, i2 + " onReceivedError " + str);
                VerifyWebView.this.onLoadFailed(i2, str2, !TextUtils.isEmpty(str) ? str : "onReceivedError");
                super.onReceivedError(webView, i2, str, str2);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                VerifyWebView.this.onLoadFailed(sslError != null ? sslError.getPrimaryError() : -1, sslError != null ? sslError.getUrl() : "", (sslError == null || sslError.getCertificate() == null) ? "onReceivedSslError" : sslError.getCertificate().toString());
                LogUtil.m162i(VerifyWebView.TAG, "onReceivedSslError:" + sslError + ":" + Thread.currentThread().getName());
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
                int statusCode = webResourceResponse != null ? webResourceResponse.getStatusCode() : -1;
                String reasonPhrase = webResourceResponse != null ? webResourceResponse.getReasonPhrase() : "onReceivedHttpError";
                String uri = webResourceRequest != null ? webResourceRequest.getUrl().toString() : "";
                LogUtil.m162i(VerifyWebView.TAG, "onReceivedHttpError:" + statusCode + "::" + webResourceRequest.isForMainFrame() + ":" + reasonPhrase + ":" + uri);
                VerifyWebView.this.onLoadFailed(statusCode, uri, reasonPhrase);
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
                if (VerifyWebView.this.mUrlInterceptor != null && (intercept = VerifyWebView.this.mUrlInterceptor.intercept(str)) != null) {
                    VerifyWebView.this.mCacheSate = 1;
                    return intercept;
                }
                return super.shouldInterceptRequest(webView, str);
            }
        };
        this.mRefreshWebPageTask = new Runnable() { // from class: com.bytedance.bdturing.VerifyWebView.8
            @Override // java.lang.Runnable
            public void run() {
                if (VerifyWebView.this.mRefreshCancel) {
                    return;
                }
                VerifyWebView.this.post(new Runnable() { // from class: com.bytedance.bdturing.VerifyWebView.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        VerifyWebView.this.reload();
                    }
                });
            }
        };
    }

    public VerifyWebView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(getFixedContext(context), attributeSet, i, i2);
        this.mIsLoadFail = false;
        this.mIsPageFinished = false;
        this.retryTime = 0;
        this.mRefreshCancel = false;
        this.mUrlInterceptor = null;
        this.mCacheSate = 0;
        this.mChromClient = new WebChromeClient() { // from class: com.bytedance.bdturing.VerifyWebView.3
            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                LogUtil.m162i(VerifyWebView.TAG, "onConsoleMessage:" + (consoleMessage != null ? consoleMessage.message() : ""));
                return super.onConsoleMessage(consoleMessage);
            }
        };
        this.mWebClient = new WebViewClient() { // from class: com.bytedance.bdturing.VerifyWebView.4
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                LogUtil.m162i(VerifyWebView.TAG, "onPageStarted");
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                LogUtil.m162i(VerifyWebView.TAG, "onPageFinished:mIsLoadFail=" + VerifyWebView.this.mIsLoadFail + ":mIsPageFinished=" + VerifyWebView.this.mIsPageFinished);
                if (!VerifyWebView.this.mIsLoadFail && !VerifyWebView.this.mIsPageFinished) {
                    VerifyWebView.this.onLoadSuccess();
                }
                super.onPageFinished(webView, str);
            }

            @Override // android.webkit.WebViewClient
            public void onLoadResource(WebView webView, String str) {
                super.onLoadResource(webView, str);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i22, String str, String str2) {
                LogUtil.m162i(VerifyWebView.TAG, i22 + " onReceivedError " + str);
                VerifyWebView.this.onLoadFailed(i22, str2, !TextUtils.isEmpty(str) ? str : "onReceivedError");
                super.onReceivedError(webView, i22, str, str2);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                VerifyWebView.this.onLoadFailed(sslError != null ? sslError.getPrimaryError() : -1, sslError != null ? sslError.getUrl() : "", (sslError == null || sslError.getCertificate() == null) ? "onReceivedSslError" : sslError.getCertificate().toString());
                LogUtil.m162i(VerifyWebView.TAG, "onReceivedSslError:" + sslError + ":" + Thread.currentThread().getName());
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
                int statusCode = webResourceResponse != null ? webResourceResponse.getStatusCode() : -1;
                String reasonPhrase = webResourceResponse != null ? webResourceResponse.getReasonPhrase() : "onReceivedHttpError";
                String uri = webResourceRequest != null ? webResourceRequest.getUrl().toString() : "";
                LogUtil.m162i(VerifyWebView.TAG, "onReceivedHttpError:" + statusCode + "::" + webResourceRequest.isForMainFrame() + ":" + reasonPhrase + ":" + uri);
                VerifyWebView.this.onLoadFailed(statusCode, uri, reasonPhrase);
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
                if (VerifyWebView.this.mUrlInterceptor != null && (intercept = VerifyWebView.this.mUrlInterceptor.intercept(str)) != null) {
                    VerifyWebView.this.mCacheSate = 1;
                    return intercept;
                }
                return super.shouldInterceptRequest(webView, str);
            }
        };
        this.mRefreshWebPageTask = new Runnable() { // from class: com.bytedance.bdturing.VerifyWebView.8
            @Override // java.lang.Runnable
            public void run() {
                if (VerifyWebView.this.mRefreshCancel) {
                    return;
                }
                VerifyWebView.this.post(new Runnable() { // from class: com.bytedance.bdturing.VerifyWebView.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        VerifyWebView.this.reload();
                    }
                });
            }
        };
    }

    public void init(VerifyWebViewListener verifyWebViewListener) {
        this.mCallback = verifyWebViewListener;
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
        if (isBoe()) {
            settings.setMixedContentMode(0);
        }
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
        ValueAnimator ofObject = ValueAnimator.ofObject(new TypeEvaluator<int[]>() { // from class: com.bytedance.bdturing.VerifyWebView.1
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
        ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.bdturing.VerifyWebView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewGroup.LayoutParams layoutParams = VerifyWebView.this.getLayoutParams();
                int[] iArr = (int[]) valueAnimator.getAnimatedValue();
                layoutParams.width = iArr[0];
                layoutParams.height = iArr[1];
                VerifyWebView.this.setLayoutParams(layoutParams);
            }
        });
        ofObject.setDuration(300L).start();
    }

    public void setUrlInterceptor(UrlInterceptor urlInterceptor) {
        this.mUrlInterceptor = urlInterceptor;
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        super.loadUrl(str);
        UrlInterceptor urlInterceptor = this.mUrlInterceptor;
        if (urlInterceptor != null) {
            urlInterceptor.loadUrl(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoadSuccess() {
        LogUtil.m162i(TAG, "onLoadSuccess");
        EventReport.statisticLoadPage(0, "success", this.mCacheSate, null);
        this.mIsPageFinished = true;
        if (this.mCallback != null) {
            post(new Runnable() { // from class: com.bytedance.bdturing.VerifyWebView.5
                @Override // java.lang.Runnable
                public void run() {
                    if (VerifyWebView.this.mCallback != null) {
                        VerifyWebView.this.mCallback.onLoadPageSuccess();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoadFailed(final int i, final String str, final String str2) {
        this.mIsLoadFail = true;
        EventReport.statisticLoadPage(i, str2 + "|" + str, this.mCacheSate, null);
        if (this.mCallback != null) {
            post(new Runnable() { // from class: com.bytedance.bdturing.VerifyWebView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (VerifyWebView.this.mCallback != null) {
                        VerifyWebView.this.mCallback.onReceivedError(i, str, str2);
                    }
                }
            });
        }
        int i2 = this.retryTime;
        if (i2 < 3) {
            this.retryTime = i2 + 1;
            VerifyTaskHandler.getInstance().postRunnableDelay(this.mRefreshWebPageTask, 500L);
        } else if (this.mCallback != null) {
            post(new Runnable() { // from class: com.bytedance.bdturing.VerifyWebView.7
                @Override // java.lang.Runnable
                public void run() {
                    if (VerifyWebView.this.mCallback != null) {
                        VerifyWebView.this.mCallback.onLoadPageFail(i, str2);
                    }
                }
            });
        }
    }

    @Override // android.webkit.WebView
    public void reload() {
        LogUtil.m162i(TAG, "reload called:");
        this.mIsPageFinished = false;
        this.mIsLoadFail = false;
        super.reload();
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        EventReport.webViewOnAttachedToWindow(null);
        this.mTimeAttached = System.currentTimeMillis();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        LogUtil.m162i(TAG, "onDetachedFromWindow:");
        EventReport.webViewDetachedFromWindow(this.mIsPageFinished, this.mIsLoadFail, System.currentTimeMillis() - this.mTimeAttached, null);
        this.mRefreshCancel = true;
        VerifyTaskHandler.getInstance().removeRunnable(this.mRefreshWebPageTask);
    }
}
