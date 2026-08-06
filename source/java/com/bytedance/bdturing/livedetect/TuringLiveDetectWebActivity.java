package com.bytedance.bdturing.livedetect;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.bytedance.bdturing.C0603R;
import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.LogUtil;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class TuringLiveDetectWebActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String AGREEMENT_LOAD_SUCCESS_MSG = "loadProtocolSuc";
    private static final String KEY_TITLE = "title";
    private static final String KEY_URL = "url";
    private static final String TAG = "LiveDetectWebActivity";
    private boolean isLoadSuccess;
    private ImageView ivBack;
    private long mDuration;
    private long mTimeStart;
    private String mUrl;
    private String title;
    private TextView tvTitle;
    private WebView mWebView = null;
    private WebChromeClient mWebChromeClient = new WebChromeClient() { // from class: com.bytedance.bdturing.livedetect.TuringLiveDetectWebActivity.1
        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            if (TuringLiveDetectWebActivity.this.isAgreementPage() && !TuringLiveDetectWebActivity.this.isLoadSuccess) {
                TuringLiveDetectWebActivity.this.mDuration = System.currentTimeMillis() - TuringLiveDetectWebActivity.this.mTimeStart;
                TuringLiveDetectWebActivity.this.isLoadSuccess = TuringLiveDetectWebActivity.AGREEMENT_LOAD_SUCCESS_MSG.equals(consoleMessage != null ? consoleMessage.message() : "");
            }
            return super.onConsoleMessage(consoleMessage);
        }
    };
    private WebViewClient mClient = new WebViewClient() { // from class: com.bytedance.bdturing.livedetect.TuringLiveDetectWebActivity.2
        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (!TuringLiveDetectWebActivity.this.isAgreementPage() && !TuringLiveDetectWebActivity.this.isLoadSuccess) {
                TuringLiveDetectWebActivity.this.isLoadSuccess = true;
                TuringLiveDetectWebActivity.this.mDuration = System.currentTimeMillis() - TuringLiveDetectWebActivity.this.mTimeStart;
            }
            LogUtil.m162i(TuringLiveDetectWebActivity.TAG, "onPageFinished");
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView webView, String str) {
            LogUtil.m162i(TuringLiveDetectWebActivity.TAG, "onLoadResource:" + str);
            super.onLoadResource(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            if (str.toLowerCase().contains("/favicon.ico")) {
                try {
                    return new WebResourceResponse("image/png", null, null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return super.shouldInterceptRequest(webView, str);
        }
    };

    /* renamed from: com_bytedance_bdturing_livedetect_TuringLiveDetectWebActivity__onStop$___twin___ */
    public void m176x7d4a246e() {
        super.onStop();
    }

    protected void onStop() {
        m175x2fb85a4d(this);
    }

    public static void startActivity(Activity activity, String str, String str2) {
        Intent intent = new Intent(activity, (Class<?>) TuringLiveDetectWebActivity.class);
        intent.putExtra("url", str);
        intent.putExtra(KEY_TITLE, str2);
        activity.startActivity(intent);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0603R.layout.activity_turing_live_detect_web);
        initView();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initView() {
        this.isLoadSuccess = false;
        ImageView imageView = (ImageView) findViewById(C0603R.id.iv_back);
        this.ivBack = imageView;
        imageView.setOnClickListener(this);
        this.tvTitle = (TextView) findViewById(C0603R.id.tv_title);
        WebView webView = (WebView) findViewById(C0603R.id.wb_live_detect);
        this.mWebView = webView;
        WebSettings settings = webView.getSettings();
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setSupportZoom(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowFileAccess(false);
        settings.setLoadsImagesAutomatically(true);
        settings.setJavaScriptEnabled(true);
        settings.setDefaultTextEncodingName("utf-8");
        settings.setCacheMode(2);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setTextZoom(100);
        try {
            this.mWebView.setOverScrollMode(2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.mWebView.setScrollContainer(false);
        this.mWebView.setHorizontalScrollBarEnabled(false);
        this.mWebView.setVerticalScrollBarEnabled(false);
        this.mWebView.setWebViewClient(this.mClient);
        this.mWebView.setWebChromeClient(this.mWebChromeClient);
        this.mUrl = getIntent().getStringExtra("url");
        String stringExtra = getIntent().getStringExtra(KEY_TITLE);
        this.title = stringExtra;
        this.tvTitle.setText(stringExtra);
        if (checkUrlSafe(this.mUrl)) {
            this.mTimeStart = System.currentTimeMillis();
            this.mWebView.loadUrl(this.mUrl);
        } else {
            Toast.makeText((Context) this, (CharSequence) "illegal params error", 0).show();
            finish();
        }
    }

    private boolean checkUrlSafe(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return LiveAuthConfig.getAgreementH5Url().equals(str) || LiveAuthConfig.getHelpH5Url().equals(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == C0603R.id.iv_back) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isAgreementPage() {
        return LiveAuthConfig.getAgreementH5Url().equals(this.mUrl);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (isAgreementPage()) {
            EventReport.agreementPageLoadResult(this.isLoadSuccess, this.mDuration, LiveDetectService.getInstance().getRequest());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_bytedance_bdturing_livedetect_TuringLiveDetectWebActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m175x2fb85a4d(TuringLiveDetectWebActivity turingLiveDetectWebActivity) {
        turingLiveDetectWebActivity.m176x7d4a246e();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                ((Activity) turingLiveDetectWebActivity).getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
