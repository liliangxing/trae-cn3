package com.bytedance.trae.conversation.plugin.authorization;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import androidx.activity.OnBackPressedCallback;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.bytedance.timonbase.scene.PageDataManager;
import com.bytedance.trae.common.activity.TraeCommonAppCompatActivity;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.network.HostResolver;
import com.bytedance.trae.network.HostType;
import com.bytedance.trae.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONObject;

/* compiled from: PluginAuthWebViewActivity.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0015J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0003J\u001a\u0010\u0013\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u0011H\u0002J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0017\u001a\u00020\u0011H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001f\u001a\u00020\fH\u0002J\b\u0010 \u001a\u00020\fH\u0002J\b\u0010!\u001a\u00020\fH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;", "Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;", "<init>", "()V", "webView", "Landroid/webkit/WebView;", "childWebView", "webViewContainer", "Landroid/widget/FrameLayout;", "getDecorViewBackgroundColor", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "injectCookies", IWeixinService.ResponseConstants.URL, "", "setupWebView", "injectBytecloudLocalStorage", "view", "pageUrl", "extractJwtExpiration", "token", "createParentChromeClient", "Landroid/webkit/WebChromeClient;", "handleUri", "", "uri", "Landroid/net/Uri;", "parseOAuthResultStatus", "destroyChildWebView", "handleUserCancel", "onDestroy", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class PluginAuthWebViewActivity extends TraeCommonAppCompatActivity {
    private static final String CLOUDIDE_SESSION_COOKIE_NAME = "X-Cloudide-Session";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_PROVIDER = "extra_provider";
    private static final String EXTRA_URL = "extra_url";
    private static final String SCHEME_CN = "traecn";
    private static final String SCHEME_OVERSEA = "traei18n";
    private static final String TAG = "PluginAuthWebView";
    private WebView childWebView;
    private WebView webView;
    private FrameLayout webViewContainer;

    /* renamed from: com_bytedance_trae_conversation_plugin_authorization_PluginAuthWebViewActivity__onStop$___twin___ */
    public void m836xdb4adacf() {
        super.onStop();
    }

    protected void onStop() {
        m835x2d5ebc8c(this);
    }

    /* compiled from: PluginAuthWebViewActivity.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity$Companion;", "", "<init>", "()V", "TAG", "", "EXTRA_URL", "EXTRA_PROVIDER", "SCHEME_CN", "SCHEME_OVERSEA", "CLOUDIDE_SESSION_COOKIE_NAME", "start", "", "context", "Landroid/content/Context;", IWeixinService.ResponseConstants.URL, "provider", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void start(Context context, String url, String provider) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(url, IWeixinService.ResponseConstants.URL);
            Intrinsics.checkNotNullParameter(provider, "provider");
            Intent intent = new Intent(context, (Class<?>) PluginAuthWebViewActivity.class);
            intent.putExtra(PluginAuthWebViewActivity.EXTRA_URL, url);
            intent.putExtra(PluginAuthWebViewActivity.EXTRA_PROVIDER, provider);
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    @Override // com.bytedance.trae.common.activity.TraeCommonAppCompatActivity
    public int getDecorViewBackgroundColor() {
        return getColor(C0591R.color.trae_bg_bg_base_default);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.trae.common.activity.TraeCommonAppCompatActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0591R.layout.trae_activity_simple_webview);
        View findViewById = findViewById(C0591R.id.webview);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        WebView webView = (WebView) findViewById;
        this.webView = webView;
        WebView webView2 = null;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView = null;
        }
        webView.setBackgroundColor(getDecorViewBackgroundColor());
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
            int indexOfChild = viewGroup.indexOfChild(webView4);
            WebView webView5 = this.webView;
            if (webView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
                webView5 = null;
            }
            ViewGroup.LayoutParams layoutParams = webView5.getLayoutParams();
            WebView webView6 = this.webView;
            if (webView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
                webView6 = null;
            }
            viewGroup.removeView(webView6);
            FrameLayout frameLayout = new FrameLayout((Context) this);
            frameLayout.setLayoutParams(layoutParams);
            WebView webView7 = this.webView;
            if (webView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
                webView7 = null;
            }
            frameLayout.addView(webView7, new FrameLayout.LayoutParams(-1, -1));
            viewGroup.addView(frameLayout, indexOfChild);
            this.webViewContainer = frameLayout;
        }
        ((TraeTitleBar) findViewById(C0591R.id.title_bar)).setOnLeftActionClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.plugin.authorization.PluginAuthWebViewActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PluginAuthWebViewActivity.this.handleUserCancel();
            }
        });
        String stringExtra = getIntent().getStringExtra(EXTRA_URL);
        if (stringExtra == null) {
            stringExtra = "";
        }
        if (stringExtra.length() == 0) {
            finish();
            return;
        }
        injectCookies(stringExtra);
        setupWebView(stringExtra);
        WebView webView8 = this.webView;
        if (webView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        } else {
            webView2 = webView8;
        }
        webView2.loadUrl(stringExtra);
        getOnBackPressedDispatcher().addCallback((LifecycleOwner) this, new OnBackPressedCallback() { // from class: com.bytedance.trae.conversation.plugin.authorization.PluginAuthWebViewActivity$onCreate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(true);
            }

            public void handleOnBackPressed() {
                WebView webView9;
                WebView webView10;
                WebView webView11;
                webView9 = PluginAuthWebViewActivity.this.childWebView;
                if (webView9 != null) {
                    PluginAuthWebViewActivity.this.destroyChildWebView();
                    return;
                }
                webView10 = PluginAuthWebViewActivity.this.webView;
                WebView webView12 = null;
                if (webView10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("webView");
                    webView10 = null;
                }
                if (webView10.canGoBack()) {
                    webView11 = PluginAuthWebViewActivity.this.webView;
                    if (webView11 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("webView");
                    } else {
                        webView12 = webView11;
                    }
                    webView12.goBack();
                    return;
                }
                PluginAuthWebViewActivity.this.handleUserCancel();
            }
        });
    }

    private final void injectCookies(String url) {
        String host = Uri.parse(url).getHost();
        if (host == null) {
            return;
        }
        String host2 = HostResolver.INSTANCE.getHost(HostType.PLUGIN_WEB);
        if (!Intrinsics.areEqual(host, host2)) {
            FLogger.INSTANCE.w(TAG, "skip cookie injection: host " + host + " != expected " + host2);
            return;
        }
        String joinToString$default = CollectionsKt.joinToString$default(CollectionsKt.takeLast(StringsKt.split$default(host, new String[]{"."}, false, 0, 6, (Object) null), 2), ".", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        cookieManager.setCookie("https://" + joinToString$default, "X-Cloudide-Session=; path=/; Max-Age=0; Expires=Thu, 01 Jan 1970 00:00:00 GMT; domain=." + joinToString$default);
        cookieManager.setCookie("https://" + host, "X-Cloudide-Session=; path=/; Max-Age=0; Expires=Thu, 01 Jan 1970 00:00:00 GMT");
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        String cloudideSession = iLoginService != null ? iLoginService.getCloudideSession() : null;
        if (cloudideSession == null) {
            cloudideSession = "";
        }
        if (cloudideSession.length() == 0) {
            FLogger.INSTANCE.w(TAG, "cloudideSession is empty, skip cookie injection");
            cookieManager.flush();
            return;
        }
        String str = "X-Cloudide-Session=" + cloudideSession + "; domain=." + joinToString$default + "; path=/; Secure; HttpOnly; SameSite=Lax";
        cookieManager.setCookie("https://" + joinToString$default, str);
        cookieManager.setCookie("https://" + host, str);
        cookieManager.flush();
        FLogger.INSTANCE.i(TAG, "injected cloudideSession cookie for " + host);
    }

    private final void setupWebView(final String url) {
        CookieManager cookieManager = CookieManager.getInstance();
        WebView webView = this.webView;
        WebView webView2 = null;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView = null;
        }
        cookieManager.setAcceptThirdPartyCookies(webView, true);
        WebView webView3 = this.webView;
        if (webView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView3 = null;
        }
        WebSettings settings = webView3.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        WebView webView4 = this.webView;
        if (webView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView4 = null;
        }
        webView4.setWebViewClient(new WebViewClient() { // from class: com.bytedance.trae.conversation.plugin.authorization.PluginAuthWebViewActivity$setupWebView$2
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                Uri url2;
                boolean handleUri;
                if (request == null || (url2 = request.getUrl()) == null) {
                    return false;
                }
                handleUri = PluginAuthWebViewActivity.this.handleUri(url2);
                return handleUri;
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView view, String loadedUrl) {
                super.onPageFinished(view, loadedUrl);
                if (Intrinsics.areEqual(loadedUrl, url)) {
                    PluginAuthWebViewActivity.this.injectBytecloudLocalStorage(view, url);
                }
            }
        });
        WebView webView5 = this.webView;
        if (webView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        } else {
            webView2 = webView5;
        }
        webView2.setWebChromeClient(createParentChromeClient());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void injectBytecloudLocalStorage(WebView view, String pageUrl) {
        String extractJwtExpiration;
        if (HostResolver.INSTANCE.isBytecloudLogin()) {
            ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
            String xTToken = iLoginService != null ? iLoginService.getXTToken() : null;
            if (xTToken == null) {
                xTToken = "";
            }
            if (StringsKt.isBlank(xTToken) || (extractJwtExpiration = extractJwtExpiration(xTToken)) == null) {
                return;
            }
            Uri parse = Uri.parse(pageUrl);
            String str = parse.getScheme() + "://" + parse.getHost();
            String trimIndent = StringsKt.trimIndent("\n            (function() {\n                if (window.location.origin === " + JSONObject.quote(str) + ") {\n                    window.localStorage.setItem(\"bytecloud_ide_token\", " + JSONObject.quote(xTToken) + ");\n                    window.localStorage.setItem(\"bytecloud_ide_token_expired_at\", " + JSONObject.quote(extractJwtExpiration) + ");\n                }\n            })();\n        ");
            if (view != null) {
                view.evaluateJavascript(trimIndent, null);
            }
            FLogger.INSTANCE.i(TAG, "injected bytecloud localStorage for " + str);
        }
    }

    private final String extractJwtExpiration(String token) {
        List split$default = StringsKt.split$default(token, new String[]{"."}, false, 0, 6, (Object) null);
        if (split$default.size() < 2) {
            return null;
        }
        try {
            byte[] decode = Base64.decode((String) split$default.get(1), 11);
            Intrinsics.checkNotNull(decode);
            long optLong = new JSONObject(new String(decode, Charsets.UTF_8)).optLong(OnekeyLoginConstants.CU_KEY_TOKEN_EXPIRES, 0L);
            if (optLong == 0) {
                return null;
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
            return simpleDateFormat.format(new Date(optLong * 1000));
        } catch (Exception e) {
            FLogger.INSTANCE.e(TAG, "failed to parse JWT exp", e);
            return null;
        }
    }

    private final WebChromeClient createParentChromeClient() {
        return new WebChromeClient() { // from class: com.bytedance.trae.conversation.plugin.authorization.PluginAuthWebViewActivity$createParentChromeClient$1
            @Override // android.webkit.WebChromeClient
            public boolean onCreateWindow(WebView view, boolean isDialog, boolean isUserGesture, Message resultMsg) {
                FrameLayout frameLayout;
                WebView webView = new WebView((Context) PluginAuthWebViewActivity.this);
                webView.setBackgroundColor(PluginAuthWebViewActivity.this.getDecorViewBackgroundColor());
                CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true);
                WebSettings settings = webView.getSettings();
                settings.setJavaScriptEnabled(true);
                settings.setDomStorageEnabled(true);
                settings.setSupportMultipleWindows(true);
                settings.setJavaScriptCanOpenWindowsAutomatically(true);
                final PluginAuthWebViewActivity pluginAuthWebViewActivity = PluginAuthWebViewActivity.this;
                webView.setWebViewClient(new WebViewClient() { // from class: com.bytedance.trae.conversation.plugin.authorization.PluginAuthWebViewActivity$createParentChromeClient$1$onCreateWindow$2
                    @Override // android.webkit.WebViewClient
                    public boolean shouldOverrideUrlLoading(WebView view2, WebResourceRequest request) {
                        Uri url;
                        boolean handleUri;
                        if (request == null || (url = request.getUrl()) == null) {
                            return false;
                        }
                        handleUri = PluginAuthWebViewActivity.this.handleUri(url);
                        return handleUri;
                    }
                });
                final PluginAuthWebViewActivity pluginAuthWebViewActivity2 = PluginAuthWebViewActivity.this;
                webView.setWebChromeClient(new WebChromeClient() { // from class: com.bytedance.trae.conversation.plugin.authorization.PluginAuthWebViewActivity$createParentChromeClient$1$onCreateWindow$3
                    @Override // android.webkit.WebChromeClient
                    public void onCloseWindow(WebView window) {
                        PluginAuthWebViewActivity.this.destroyChildWebView();
                    }
                });
                PluginAuthWebViewActivity.this.childWebView = webView;
                frameLayout = PluginAuthWebViewActivity.this.webViewContainer;
                if (frameLayout != null) {
                    frameLayout.addView(webView, new FrameLayout.LayoutParams(-1, -1));
                }
                Object obj = resultMsg != null ? resultMsg.obj : null;
                WebView.WebViewTransport webViewTransport = obj instanceof WebView.WebViewTransport ? (WebView.WebViewTransport) obj : null;
                if (webViewTransport != null) {
                    webViewTransport.setWebView(webView);
                }
                if (resultMsg != null) {
                    resultMsg.sendToTarget();
                }
                FLogger.INSTANCE.i("PluginAuthWebView", "onCreateWindow: child WebView created and attached");
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public void onCloseWindow(WebView window) {
                WebView webView;
                webView = PluginAuthWebViewActivity.this.childWebView;
                if (Intrinsics.areEqual(window, webView)) {
                    PluginAuthWebViewActivity.this.destroyChildWebView();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean handleUri(Uri uri) {
        String scheme = uri.getScheme();
        if (scheme == null) {
            return false;
        }
        if (Intrinsics.areEqual(scheme, SCHEME_CN) || Intrinsics.areEqual(scheme, SCHEME_OVERSEA)) {
            String host = uri.getHost();
            String path = uri.getPath();
            if (Intrinsics.areEqual(host, "oauth") && (Intrinsics.areEqual(path, "/lark/callback") || Intrinsics.areEqual(path, "/plugin-connector/callback"))) {
                FLogger.INSTANCE.i(TAG, "OAuth callback received: " + uri);
                String parseOAuthResultStatus = parseOAuthResultStatus(uri);
                String stringExtra = getIntent().getStringExtra(EXTRA_PROVIDER);
                if (stringExtra == null) {
                    stringExtra = "";
                }
                if (PluginConnectorOAuthManager.INSTANCE.reportWebViewAuthResult(stringExtra, parseOAuthResultStatus, uri.getQueryParameter("auth_request_id"))) {
                    finish();
                }
                return true;
            }
        }
        if (Intrinsics.areEqual(scheme, "http") || Intrinsics.areEqual(scheme, "https")) {
            return false;
        }
        try {
            startActivity(new Intent("android.intent.action.VIEW", uri));
        } catch (Exception unused) {
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0066 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String parseOAuthResultStatus(Uri uri) {
        String str;
        String str2;
        List split$default;
        Object obj;
        String substringAfter$default;
        String queryParameter = uri.getQueryParameter("oauth_result");
        if (queryParameter == null) {
            String fragment = uri.getFragment();
            if (fragment != null && (split$default = StringsKt.split$default(fragment, new String[]{"&"}, false, 0, 6, (Object) null)) != null) {
                Iterator it = split$default.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (StringsKt.startsWith$default((String) obj, "oauth_result=", false, 2, (Object) null)) {
                        break;
                    }
                }
                String str3 = (String) obj;
                if (str3 != null && (substringAfter$default = StringsKt.substringAfter$default(str3, "oauth_result=", (String) null, 2, (Object) null)) != null) {
                    queryParameter = Uri.decode(substringAfter$default);
                }
            }
            str = null;
            str2 = str;
            if (!(str2 != null || StringsKt.isBlank(str2))) {
                return "success";
            }
            try {
                byte[] decode = Base64.decode(StringsKt.replace$default(StringsKt.replace$default(str, '-', '+', false, 4, (Object) null), '_', '/', false, 4, (Object) null), 2);
                Intrinsics.checkNotNull(decode);
                String optString = new JSONObject(new String(decode, Charsets.UTF_8)).optString(PageDataManager.EXTRA_STATUS, "success");
                Intrinsics.checkNotNull(optString);
                return StringsKt.isBlank(optString) ? "success" : optString;
            } catch (Exception e) {
                FLogger.INSTANCE.e(TAG, "failed to parse oauth_result", e);
                return "success";
            }
        }
        str = queryParameter;
        str2 = str;
        if (!(str2 != null || StringsKt.isBlank(str2))) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void destroyChildWebView() {
        WebView webView = this.childWebView;
        if (webView == null) {
            return;
        }
        FrameLayout frameLayout = this.webViewContainer;
        if (frameLayout != null) {
            frameLayout.removeView(webView);
        }
        webView.destroy();
        this.childWebView = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleUserCancel() {
        PluginConnectorOAuthManager.INSTANCE.cancelWebViewAuth();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.trae.common.activity.TraeCommonAppCompatActivity
    public void onDestroy() {
        destroyChildWebView();
        FrameLayout frameLayout = this.webViewContainer;
        WebView webView = null;
        if (frameLayout != null) {
            WebView webView2 = this.webView;
            if (webView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
                webView2 = null;
            }
            frameLayout.removeView(webView2);
        }
        WebView webView3 = this.webView;
        if (webView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        } else {
            webView = webView3;
        }
        webView.destroy();
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_bytedance_trae_conversation_plugin_authorization_PluginAuthWebViewActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m835x2d5ebc8c(PluginAuthWebViewActivity pluginAuthWebViewActivity) {
        pluginAuthWebViewActivity.m836xdb4adacf();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                ((Activity) pluginAuthWebViewActivity).getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
