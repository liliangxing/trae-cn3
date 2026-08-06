package com.bytedance.trae.login.enterprise;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.bytedance.trae.common.activity.TraeCommonAppCompatActivity;
import com.bytedance.trae.login.C0820R;
import com.bytedance.trae.login.enterprise.EnterpriseAuthManager;
import com.bytedance.trae.login.traeauth.TraeAuthManager;
import com.bytedance.trae.multilanguage.C0882R;
import com.bytedance.trae.utils.logger.FLogger;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* compiled from: EnterpriseSsoWebViewActivity.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0015J\b\u0010\u0010\u001a\u00020\rH\u0003J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\rH\u0002J\n\u0010\u0015\u001a\u0004\u0018\u00010\tH\u0002J\u001c\u0010\u0016\u001a\u0004\u0018\u00010\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0018\u001a\u00020\tH\u0002J\b\u0010\u0019\u001a\u00020\rH\u0002J\b\u0010\u001a\u001a\u00020\rH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;", "Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;", "<init>", "()V", "webView", "Landroid/webkit/WebView;", "pbLoading", "Landroid/widget/ProgressBar;", "email", "", "isHandlingCallback", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setupWebView", "isSsoCallback", "uri", "Landroid/net/Uri;", "handleSsoCallback", "extractSessionFromCookies", "extractCookieValue", "cookies", "cookieName", "navigateToMain", "onDestroy", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class EnterpriseSsoWebViewActivity extends TraeCommonAppCompatActivity {
    private static final String CALLBACK_HOST = "oauth";
    private static final String CALLBACK_PATH = "/saas/callback";
    private static final String CALLBACK_SCHEME = "traecn";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_EMAIL = "email";
    private static final String EXTRA_SSO_URL = "sso_url";
    private static final String MAIN_ACTIVITY_CLASS = "com.bytedance.trae.home.MainActivity";
    private static final String TAG = "EnterpriseSsoWebView";
    private static final String TOB_SESSION_COOKIE_NAME = "X-Cloudide-Tob-Session";
    private String email = "";
    private boolean isHandlingCallback;
    private ProgressBar pbLoading;
    private WebView webView;

    /* renamed from: com_bytedance_trae_login_enterprise_EnterpriseSsoWebViewActivity__onStop$___twin___ */
    public void m410x1196f864() {
        super.onStop();
    }

    protected void onStop() {
        m409x3765e817(this);
    }

    /* compiled from: EnterpriseSsoWebViewActivity.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity$Companion;", "", "<init>", "()V", "TAG", "", "EXTRA_SSO_URL", "EXTRA_EMAIL", "CALLBACK_SCHEME", "CALLBACK_HOST", "CALLBACK_PATH", "TOB_SESSION_COOKIE_NAME", "MAIN_ACTIVITY_CLASS", TraeAuthManager.STAGE_START, "", "context", "Landroid/content/Context;", "ssoUrl", "email", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void start(Context context, String ssoUrl, String email) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(ssoUrl, "ssoUrl");
            Intrinsics.checkNotNullParameter(email, "email");
            Intent intent = new Intent(context, (Class<?>) EnterpriseSsoWebViewActivity.class);
            intent.putExtra(EnterpriseSsoWebViewActivity.EXTRA_SSO_URL, ssoUrl);
            intent.putExtra("email", email);
            context.startActivity(intent);
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0820R.layout.trae_activity_enterprise_sso_webview);
        String stringExtra = getIntent().getStringExtra(EXTRA_SSO_URL);
        String stringExtra2 = getIntent().getStringExtra("email");
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        this.email = stringExtra2;
        String str = stringExtra;
        if (str == null || str.length() == 0) {
            FLogger.INSTANCE.mo426e(TAG, "SSO URL is empty");
            finish();
            return;
        }
        View findViewById = findViewById(C0820R.id.pb_loading);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.pbLoading = (ProgressBar) findViewById;
        findViewById(C0820R.id.btn_back).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.login.enterprise.EnterpriseSsoWebViewActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EnterpriseSsoWebViewActivity.this.finish();
            }
        });
        View findViewById2 = findViewById(C0820R.id.webview);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.webView = (WebView) findViewById2;
        setupWebView();
        CookieManager.getInstance().setAcceptCookie(true);
        CookieManager cookieManager = CookieManager.getInstance();
        WebView webView = this.webView;
        WebView webView2 = null;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView = null;
        }
        cookieManager.setAcceptThirdPartyCookies(webView, true);
        FLogger.INSTANCE.mo428i(TAG, "Loading SSO URL");
        WebView webView3 = this.webView;
        if (webView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        } else {
            webView2 = webView3;
        }
        webView2.loadUrl(stringExtra);
    }

    private final void setupWebView() {
        WebView webView = this.webView;
        WebView webView2 = null;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView = null;
        }
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        WebView webView3 = this.webView;
        if (webView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView3 = null;
        }
        webView3.setWebViewClient(new WebViewClient() { // from class: com.bytedance.trae.login.enterprise.EnterpriseSsoWebViewActivity$setupWebView$2
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                Uri url;
                boolean isSsoCallback;
                if (request != null && (url = request.getUrl()) != null) {
                    isSsoCallback = EnterpriseSsoWebViewActivity.this.isSsoCallback(url);
                    if (isSsoCallback) {
                        EnterpriseSsoWebViewActivity.this.handleSsoCallback();
                        return true;
                    }
                    String scheme = url.getScheme();
                    if (scheme != null && !Intrinsics.areEqual(scheme, "http") && !Intrinsics.areEqual(scheme, "https")) {
                        try {
                            EnterpriseSsoWebViewActivity.this.startActivity(new Intent("android.intent.action.VIEW", url));
                        } catch (ActivityNotFoundException unused) {
                        }
                        return true;
                    }
                }
                return false;
            }

            @Override // android.webkit.WebViewClient
            @Deprecated(message = "Deprecated in Java")
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Uri parse;
                boolean isSsoCallback;
                if (url != null && (parse = Uri.parse(url)) != null) {
                    isSsoCallback = EnterpriseSsoWebViewActivity.this.isSsoCallback(parse);
                    if (isSsoCallback) {
                        EnterpriseSsoWebViewActivity.this.handleSsoCallback();
                        return true;
                    }
                    String scheme = parse.getScheme();
                    if (scheme != null && !Intrinsics.areEqual(scheme, "http") && !Intrinsics.areEqual(scheme, "https")) {
                        try {
                            EnterpriseSsoWebViewActivity.this.startActivity(new Intent("android.intent.action.VIEW", parse));
                        } catch (ActivityNotFoundException unused) {
                        }
                        return true;
                    }
                }
                return false;
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                Uri parse;
                boolean isSsoCallback;
                if (url == null || (parse = Uri.parse(url)) == null) {
                    return;
                }
                isSsoCallback = EnterpriseSsoWebViewActivity.this.isSsoCallback(parse);
                if (isSsoCallback) {
                    if (view != null) {
                        view.stopLoading();
                    }
                    EnterpriseSsoWebViewActivity.this.handleSsoCallback();
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                Uri url;
                boolean isSsoCallback;
                if (request == null || (url = request.getUrl()) == null) {
                    return;
                }
                isSsoCallback = EnterpriseSsoWebViewActivity.this.isSsoCallback(url);
                if (isSsoCallback) {
                    EnterpriseSsoWebViewActivity.this.handleSsoCallback();
                }
            }
        });
        WebView webView4 = this.webView;
        if (webView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        } else {
            webView2 = webView4;
        }
        webView2.setWebChromeClient(new WebChromeClient() { // from class: com.bytedance.trae.login.enterprise.EnterpriseSsoWebViewActivity$setupWebView$3
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView view, int newProgress) {
                ProgressBar progressBar;
                ProgressBar progressBar2;
                progressBar = EnterpriseSsoWebViewActivity.this.pbLoading;
                ProgressBar progressBar3 = null;
                if (progressBar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pbLoading");
                    progressBar = null;
                }
                progressBar.setProgress(newProgress);
                progressBar2 = EnterpriseSsoWebViewActivity.this.pbLoading;
                if (progressBar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pbLoading");
                } else {
                    progressBar3 = progressBar2;
                }
                progressBar3.setVisibility(newProgress < 100 ? 0 : 8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isSsoCallback(Uri uri) {
        if (StringsKt.equals(uri.getScheme(), CALLBACK_SCHEME, true) && StringsKt.equals(uri.getHost(), CALLBACK_HOST, true)) {
            String path = uri.getPath();
            if (path != null && StringsKt.startsWith$default(path, CALLBACK_PATH, false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void handleSsoCallback() {
        if (this.isHandlingCallback) {
            return;
        }
        boolean z = true;
        this.isHandlingCallback = true;
        FLogger.INSTANCE.mo428i(TAG, "SSO callback intercepted, extracting session cookie");
        String extractSessionFromCookies = extractSessionFromCookies();
        String str = extractSessionFromCookies;
        if (str != null && str.length() != 0) {
            z = false;
        }
        if (z) {
            FLogger.INSTANCE.mo426e(TAG, "Failed to extract X-Cloudide-Tob-Session from cookies");
            TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_ENTERPRISE_SSO_SESSION_FAIL, "enterprise", null, null, null, "cookie_extraction_failed", null, null, null, null, null, 2012, null);
            Toast.makeText((Context) this, getString(C0882R.string.trae_enterprise_sso_login_failed), 0).show();
            finish();
            return;
        }
        FLogger.INSTANCE.mo428i(TAG, "Session cookie extracted, starting token flow");
        TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_ENTERPRISE_SSO_CALLBACK, "enterprise", null, null, null, null, null, null, null, null, null, 2044, null);
        EnterpriseAuthManager.INSTANCE.loginWithSsoSession((CoroutineScope) LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), this.email, extractSessionFromCookies, new EnterpriseAuthManager.Callback() { // from class: com.bytedance.trae.login.enterprise.EnterpriseSsoWebViewActivity$handleSsoCallback$1
            @Override // com.bytedance.trae.login.enterprise.EnterpriseAuthManager.Callback
            public void onSuccess() {
                FLogger.INSTANCE.mo428i("EnterpriseSsoWebView", "SSO login completed successfully");
                EnterpriseSsoWebViewActivity.this.navigateToMain();
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.bytedance.trae.login.enterprise.EnterpriseAuthManager.Callback
            public void onFailure(String errorMessage) {
                FLogger.INSTANCE.mo426e("EnterpriseSsoWebView", "SSO login failed: " + errorMessage);
                EnterpriseSsoWebViewActivity enterpriseSsoWebViewActivity = EnterpriseSsoWebViewActivity.this;
                Context context = (Context) enterpriseSsoWebViewActivity;
                if (errorMessage == null) {
                    errorMessage = enterpriseSsoWebViewActivity.getString(C0882R.string.trae_enterprise_sso_login_failed);
                    Intrinsics.checkNotNullExpressionValue(errorMessage, "getString(...)");
                }
                Toast.makeText(context, errorMessage, 0).show();
                EnterpriseSsoWebViewActivity.this.finish();
            }
        });
    }

    private final String extractSessionFromCookies() {
        String extractCookieValue;
        String extractCookieValue2;
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.flush();
        String baseUrl = EnterpriseLoginConfig.INSTANCE.getBaseUrl();
        String extractCookieValue3 = extractCookieValue(cookieManager.getCookie(baseUrl), TOB_SESSION_COOKIE_NAME);
        if (extractCookieValue3 != null) {
            return extractCookieValue3;
        }
        WebView webView = this.webView;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView = null;
        }
        String url = webView.getUrl();
        String str = url;
        if (!(str == null || str.length() == 0) && !Intrinsics.areEqual(url, baseUrl) && (extractCookieValue2 = extractCookieValue(cookieManager.getCookie(url), TOB_SESSION_COOKIE_NAME)) != null) {
            return extractCookieValue2;
        }
        Uri parse = Uri.parse(baseUrl);
        String host = parse.getHost();
        if (host == null) {
            return null;
        }
        String str2 = parse.getScheme() + "://" + host;
        if (Intrinsics.areEqual(str2, baseUrl) || (extractCookieValue = extractCookieValue(cookieManager.getCookie(str2), TOB_SESSION_COOKIE_NAME)) == null) {
            return null;
        }
        return extractCookieValue;
    }

    private final String extractCookieValue(String cookies, String cookieName) {
        String str = cookies;
        if (str == null || str.length() == 0) {
            return null;
        }
        Iterator it = StringsKt.split$default(str, new String[]{";"}, false, 0, 6, (Object) null).iterator();
        while (it.hasNext()) {
            String obj = StringsKt.trim((String) it.next()).toString();
            if (StringsKt.startsWith(obj, cookieName + '=', true)) {
                String substringAfter = StringsKt.substringAfter(obj, "=", "");
                if (substringAfter.length() > 0) {
                    return substringAfter;
                }
                return null;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void navigateToMain() {
        Intent intent = new Intent();
        intent.setClassName((Context) this, MAIN_ACTIVITY_CLASS);
        intent.setFlags(268468224);
        startActivity(intent);
        finish();
    }

    protected void onDestroy() {
        WebView webView = this.webView;
        WebView webView2 = null;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView = null;
        }
        webView.stopLoading();
        WebView webView3 = this.webView;
        if (webView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView3 = null;
        }
        ViewParent parent = webView3.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            WebView webView4 = this.webView;
            if (webView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
                webView4 = null;
            }
            viewGroup.removeView(webView4);
        }
        WebView webView5 = this.webView;
        if (webView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        } else {
            webView2 = webView5;
        }
        webView2.destroy();
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_bytedance_trae_login_enterprise_EnterpriseSsoWebViewActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m409x3765e817(EnterpriseSsoWebViewActivity enterpriseSsoWebViewActivity) {
        enterpriseSsoWebViewActivity.m410x1196f864();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                ((Activity) enterpriseSsoWebViewActivity).getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
