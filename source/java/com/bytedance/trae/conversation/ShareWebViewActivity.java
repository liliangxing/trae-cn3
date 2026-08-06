package com.bytedance.trae.conversation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.CookieManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.anniex.assemble.AnnieX;
import com.bytedance.android.anniex.base.builder.PageBuilder;
import com.bytedance.android.anniex.base.container.holder.IFragmentHolder;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.bytedance.timonbase.pipeline.TimonPipeline;
import com.bytedance.trae.common.activity.TraeCommonAppCompatActivity;
import com.bytedance.trae.conversation.chat.track.CustomActivityTracker;
import com.bytedance.trae.conversation.share.ShareUtils;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.utils.TrustedDomainUtils;
import com.bytedance.ug.sdk.share.ShareSdk;
import com.bytedance.ug.sdk.share.api.callback.IExecuteListener;
import com.bytedance.ug.sdk.share.api.callback.OnPanelActionCallback;
import com.bytedance.ug.sdk.share.api.callback.PanelItemsCallback;
import com.bytedance.ug.sdk.share.api.callback.ShareEventCallback;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.entity.ShareResult;
import com.bytedance.ug.sdk.share.api.panel.IPanelItem;
import com.bytedance.ug.sdk.share.api.panel.PanelContent;
import com.bytedance.ug.sdk.share.impl.model.ShareTokenType;
import com.bytedance.ug.sdk.share.impl.ui.panel.ISharePanel;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* compiled from: ShareWebViewActivity.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\fH\u0003J\b\u0010\u0013\u001a\u00020\u000eH\u0017J\b\u0010\u0014\u001a\u00020\u000eH\u0014J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\fH\u0002J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\fH\u0002J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\fH\u0002J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\fH\u0002J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/bytedance/trae/conversation/ShareWebViewActivity;", "Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;", "<init>", "()V", "btnBack", "Landroid/widget/ImageView;", "btnShare", "tvTitle", "Landroid/widget/TextView;", "webView", "Landroid/webkit/WebView;", "syncedCookieUrl", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "loadWithNativeWebView", IWeixinService.ResponseConstants.URL, "onBackPressed", "onDestroy", "openInSystemBrowser", "clearCloudideSessionCookie", "syncCloudideSessionCookie", "showSharePanelWithSystem", "showSharePanel", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ShareWebViewActivity extends TraeCommonAppCompatActivity {
    private static final String CLOUDIDE_SESSION_COOKIE_NAME = "X-Cloudide-Session";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_MODE = "extra_mode";
    private static final String EXTRA_POST_URL = "extra_post_url";
    private static final String EXTRA_SHARE_URL = "extra_share_url";
    private static final String EXTRA_SOURCE = "extra_source";
    private static final String EXTRA_TITLE = "extra_title";
    private static final String EXTRA_URL = "extra_url";
    public static final int MODE_OPEN_IN_BROWSER = 1;
    public static final int MODE_SHARE = 0;
    private ImageView btnBack;
    private ImageView btnShare;
    private String syncedCookieUrl;
    private TextView tvTitle;
    private WebView webView;

    /* renamed from: com_bytedance_trae_conversation_ShareWebViewActivity__onStop$___twin___ */
    public void m816x57381421() {
        super.onStop();
    }

    protected void onStop() {
        m815x22e74e7a(this);
    }

    /* compiled from: ShareWebViewActivity.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JD\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u0005J:\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/trae/conversation/ShareWebViewActivity$Companion;", "", "<init>", "()V", "EXTRA_URL", "", "EXTRA_TITLE", "EXTRA_SOURCE", "EXTRA_MODE", "EXTRA_SHARE_URL", "EXTRA_POST_URL", "CLOUDIDE_SESSION_COOKIE_NAME", "MODE_SHARE", "", "MODE_OPEN_IN_BROWSER", "start", "", "context", "Landroid/content/Context;", IWeixinService.ResponseConstants.URL, "title", "shareUrl", "postUrl", TimonPipeline.KEY_SOURCE, "startWithBrowser", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void start(Context context, String url, String title, String shareUrl, String postUrl, String source) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(url, IWeixinService.ResponseConstants.URL);
            Intrinsics.checkNotNullParameter(source, TimonPipeline.KEY_SOURCE);
            Intent intent = new Intent(context, (Class<?>) ShareWebViewActivity.class);
            intent.putExtra(ShareWebViewActivity.EXTRA_URL, url);
            intent.putExtra(ShareWebViewActivity.EXTRA_TITLE, title);
            intent.putExtra(ShareWebViewActivity.EXTRA_SOURCE, source);
            intent.putExtra(ShareWebViewActivity.EXTRA_SHARE_URL, shareUrl);
            intent.putExtra(ShareWebViewActivity.EXTRA_POST_URL, postUrl);
            context.startActivity(intent);
        }

        public final void startWithBrowser(Context context, String url, String title, String shareUrl, String postUrl) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(url, IWeixinService.ResponseConstants.URL);
            Intent intent = new Intent(context, (Class<?>) ShareWebViewActivity.class);
            intent.putExtra(ShareWebViewActivity.EXTRA_URL, url);
            intent.putExtra(ShareWebViewActivity.EXTRA_TITLE, title);
            intent.putExtra("extra_mode", 1);
            intent.putExtra(ShareWebViewActivity.EXTRA_SHARE_URL, shareUrl);
            intent.putExtra(ShareWebViewActivity.EXTRA_POST_URL, postUrl);
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.trae.common.activity.TraeCommonAppCompatActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0637R.layout.trae_activity_webview);
        View findViewById = findViewById(C0637R.id.btn_back);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.btnBack = (ImageView) findViewById;
        View findViewById2 = findViewById(C0637R.id.btn_share);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.btnShare = (ImageView) findViewById2;
        View findViewById3 = findViewById(C0637R.id.tv_title);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.tvTitle = (TextView) findViewById3;
        final String stringExtra = getIntent().getStringExtra(EXTRA_URL);
        if (stringExtra == null) {
            stringExtra = "";
        }
        if (stringExtra.length() == 0) {
            finish();
            return;
        }
        final String stringExtra2 = getIntent().getStringExtra(EXTRA_SHARE_URL);
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        TextView textView = this.tvTitle;
        ImageView imageView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
            textView = null;
        }
        String stringExtra3 = getIntent().getStringExtra(EXTRA_TITLE);
        textView.setText(stringExtra3 != null ? stringExtra3 : "");
        ImageView imageView2 = this.btnBack;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnBack");
            imageView2 = null;
        }
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.ShareWebViewActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShareWebViewActivity.this.finish();
            }
        });
        int intExtra = getIntent().getIntExtra("extra_mode", 0);
        if (intExtra == 1) {
            ImageView imageView3 = this.btnShare;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnShare");
                imageView3 = null;
            }
            imageView3.setImageResource(C0637R.drawable.ic_open_in_browser);
            ImageView imageView4 = this.btnShare;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnShare");
            } else {
                imageView = imageView4;
            }
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.ShareWebViewActivity$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ShareWebViewActivity.this.openInSystemBrowser(stringExtra);
                }
            });
        } else if (!TextUtils.isEmpty(stringExtra2)) {
            ImageView imageView5 = this.btnShare;
            if (imageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnShare");
                imageView5 = null;
            }
            imageView5.setVisibility(0);
            ImageView imageView6 = this.btnShare;
            if (imageView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnShare");
            } else {
                imageView = imageView6;
            }
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.ShareWebViewActivity$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ShareWebViewActivity.onCreate$lambda$2(ShareWebViewActivity.this, stringExtra2, view);
                }
            });
        } else {
            ImageView imageView7 = this.btnShare;
            if (imageView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnShare");
            } else {
                imageView = imageView7;
            }
            imageView.setVisibility(8);
        }
        String encode = Uri.encode(stringExtra, ":/?#[]@!$&'()*+,;=-._~%");
        if (intExtra == 1) {
            if (!TrustedDomainUtils.INSTANCE.isTrustedUrl(stringExtra)) {
                openInSystemBrowser(stringExtra);
                finish();
                return;
            } else {
                clearCloudideSessionCookie(stringExtra);
                loadWithNativeWebView(stringExtra);
                return;
            }
        }
        syncCloudideSessionCookie(stringExtra);
        String str = "sslocal://webview?hide_nav_bar=1&url=" + encode;
        try {
            IFragmentHolder createFragmentHolder = AnnieX.INSTANCE.createFragmentHolder(new Function1() { // from class: com.bytedance.trae.conversation.ShareWebViewActivity$$ExternalSyntheticLambda3
                public final Object invoke(Object obj) {
                    Unit onCreate$lambda$3;
                    onCreate$lambda$3 = ShareWebViewActivity.onCreate$lambda$3(ShareWebViewActivity.this, (PageBuilder) obj);
                    return onCreate$lambda$3;
                }
            });
            createFragmentHolder.loadSchema(str);
            Integer.valueOf(getSupportFragmentManager().beginTransaction().replace(C0637R.id.fragment_container, createFragmentHolder.getFragment()).commit());
        } catch (Exception e) {
            Log.e("ShareWebViewActivity", "AnnieX loadSchema failed, fallback to system browser", e);
            openInSystemBrowser(stringExtra);
            finish();
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(ShareWebViewActivity shareWebViewActivity, String str, View view) {
        String stringExtra = shareWebViewActivity.getIntent().getStringExtra(EXTRA_SOURCE);
        if (stringExtra == null) {
            stringExtra = "inside";
        }
        CustomActivityTracker.trackShareButtonClick(stringExtra, str);
        shareWebViewActivity.showSharePanelWithSystem(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit onCreate$lambda$3(ShareWebViewActivity shareWebViewActivity, PageBuilder pageBuilder) {
        Intrinsics.checkNotNullParameter(pageBuilder, "$this$createFragmentHolder");
        pageBuilder.activity((Activity) shareWebViewActivity);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void loadWithNativeWebView(String url) {
        WebView webView = new WebView((Context) this);
        this.webView = webView;
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setMixedContentMode(1);
        webView.setWebViewClient(new WebViewClient() { // from class: com.bytedance.trae.conversation.ShareWebViewActivity$loadWithNativeWebView$2
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                Uri url2;
                if (request == null || (url2 = request.getUrl()) == null || TrustedDomainUtils.INSTANCE.isTrustedUrl(url2.toString())) {
                    return false;
                }
                ShareWebViewActivity shareWebViewActivity = ShareWebViewActivity.this;
                String uri = url2.toString();
                Intrinsics.checkNotNullExpressionValue(uri, "toString(...)");
                shareWebViewActivity.openInSystemBrowser(uri);
                return true;
            }
        });
        ((FrameLayout) findViewById(C0637R.id.fragment_container)).addView(webView, new FrameLayout.LayoutParams(-1, -1));
        webView.loadUrl(url);
    }

    @Deprecated(message = "Deprecated in Java")
    public void onBackPressed() {
        WebView webView = this.webView;
        if (webView != null && webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.trae.common.activity.TraeCommonAppCompatActivity
    public void onDestroy() {
        String str = this.syncedCookieUrl;
        if (str != null) {
            clearCloudideSessionCookie(str);
        }
        this.syncedCookieUrl = null;
        WebView webView = this.webView;
        if (webView != null) {
            webView.stopLoading();
            ViewParent parent = webView.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(webView);
            }
            webView.destroy();
        }
        this.webView = null;
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openInSystemBrowser(String url) {
        try {
            Result.Companion companion = Result.Companion;
            ShareWebViewActivity shareWebViewActivity = this;
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    private final void clearCloudideSessionCookie(String url) {
        try {
            String host = Uri.parse(url).getHost();
            if (host == null) {
                return;
            }
            String joinToString$default = CollectionsKt.joinToString$default(CollectionsKt.takeLast(StringsKt.split$default(host, new String[]{"."}, false, 0, 6, (Object) null), 2), ".", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.setCookie("https://" + joinToString$default, "X-Cloudide-Session=; path=/; Max-Age=0; Expires=Thu, 01 Jan 1970 00:00:00 GMT; domain=." + joinToString$default);
            cookieManager.setCookie("https://" + host, "X-Cloudide-Session=; path=/; Max-Age=0; Expires=Thu, 01 Jan 1970 00:00:00 GMT; domain=" + host);
            cookieManager.setCookie("https://" + host, "X-Cloudide-Session=; path=/; Max-Age=0; Expires=Thu, 01 Jan 1970 00:00:00 GMT");
            cookieManager.flush();
        } catch (Exception unused) {
        }
    }

    private final void syncCloudideSessionCookie(String url) {
        String host;
        try {
            if (TrustedDomainUtils.INSTANCE.isTrustedUrl(url)) {
                ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
                String cloudideSession = iLoginService != null ? iLoginService.getCloudideSession() : null;
                if (cloudideSession == null) {
                    cloudideSession = "";
                }
                if ((cloudideSession.length() == 0) || (host = Uri.parse(url).getHost()) == null) {
                    return;
                }
                String joinToString$default = CollectionsKt.joinToString$default(CollectionsKt.takeLast(StringsKt.split$default(host, new String[]{"."}, false, 0, 6, (Object) null), 2), ".", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
                CookieManager cookieManager = CookieManager.getInstance();
                cookieManager.setAcceptCookie(true);
                String str = "X-Cloudide-Session=" + cloudideSession + "; domain=." + joinToString$default + "; path=/; Secure; HttpOnly; SameSite=Lax";
                cookieManager.setCookie("https://" + joinToString$default, str);
                cookieManager.setCookie("https://" + host, str);
                cookieManager.flush();
                try {
                    this.syncedCookieUrl = url;
                } catch (Exception unused) {
                }
            }
        } catch (Exception unused2) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void showSharePanelWithSystem(String url) {
        try {
            ShareUtils.INSTANCE.shareLink((Context) this, url, (r13 & 4) != 0 ? null : "", (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? null : null);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void showSharePanel(String url) {
        String string = getString(com.bytedance.trae.multilanguage.R.string.trae_share_webview_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getString(com.bytedance.trae.multilanguage.R.string.trae_share_webview_content);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        ShareSdk.showPanel(new PanelContent.PanelContentBuilder((Activity) this).withPanelId("943841_xbk_android_1").withCancelBtnText("取消").withShareContent(new ShareContent.Builder().setTitle(string).setText(string2).setTargetUrl(url).setEventCallBack(new ShareEventCallback.EmptyShareEventCallBack() { // from class: com.bytedance.trae.conversation.ShareWebViewActivity$showSharePanel$shareModel$1
            public final void onPermissionDeniedEvent(ShareContent shareContent, String permission) {
            }

            public final void onPermissionGrantedEvent(ShareContent shareContent, String permission) {
            }

            public final void onPermissionShow(ShareContent shareContent, String permission) {
            }

            public void onShareResultEvent(ShareResult result) {
            }

            public final void onTokenDialogBtnClick(ShareTokenType type, ShareContent shareContent) {
            }

            public final void onTokenDialogDismiss(ShareTokenType type, ShareContent shareContent) {
            }

            public final void onTokenDialogShow(ShareTokenType type, ShareContent shareContent) {
            }

            public final void onTokenGuideDialogBtnClick(ShareTokenType type, ShareContent shareContent) {
            }

            public final void onTokenGuideDialogDismiss(ShareTokenType type, ShareContent shareContent) {
            }

            public final void onTokenGuideDialogShow(ShareTokenType type, ShareContent shareContent) {
            }
        }).build()).withDisableGetShreInfo(false).withPanelActionCallback(new OnPanelActionCallback.EmptyPanelActionCallback() { // from class: com.bytedance.trae.conversation.ShareWebViewActivity$showSharePanel$panelContent$1
            public boolean interceptPanelClick(IPanelItem panelItem, ShareContent shareModel, IExecuteListener listener) {
                return false;
            }

            public void onPanelClick(IPanelItem panelItem) {
            }

            public void onPanelDismiss(boolean itemClicked) {
            }

            public void onPanelShow() {
            }
        }).withPanelItemsCallback(new PanelItemsCallback.EmptySharePanelItemsCallback() { // from class: com.bytedance.trae.conversation.ShareWebViewActivity$showSharePanel$panelContent$2
            public void resetPanelItem(ISharePanel panel, List<List<IPanelItem>> panelRows) {
            }

            public void resetPanelItemOriginalData(ShareContent shareModel) {
            }

            public void resetPanelItemServerData(ShareContent shareModel) {
            }
        }).build());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_bytedance_trae_conversation_ShareWebViewActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m815x22e74e7a(ShareWebViewActivity shareWebViewActivity) {
        shareWebViewActivity.m816x57381421();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                ((Activity) shareWebViewActivity).getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
