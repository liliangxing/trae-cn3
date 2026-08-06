package com.bytedance.trae.home.privacy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import androidx.activity.OnBackPressedCallback;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.bytedance.trae.common.activity.TraeCommonAppCompatActivity;
import com.bytedance.trae.home.C0820R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* compiled from: PrivacyWebViewActivity.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0015J\b\u0010\n\u001a\u00020\u0007H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/home/privacy/PrivacyWebViewActivity;", "Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;", "<init>", "()V", "webView", "Landroid/webkit/WebView;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class PrivacyWebViewActivity extends TraeCommonAppCompatActivity {
    private static final String EXTRA_URL = "extra_url";
    private WebView webView;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* renamed from: com_bytedance_trae_home_privacy_PrivacyWebViewActivity__onStop$___twin___ */
    public void m875x194fbb2f() {
        super.onStop();
    }

    protected void onStop() {
        m874xe9e0982c(this);
    }

    /* compiled from: PrivacyWebViewActivity.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/home/privacy/PrivacyWebViewActivity$Companion;", "", "<init>", "()V", "EXTRA_URL", "", "start", "", "context", "Landroid/content/Context;", IWeixinService.ResponseConstants.URL, "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void start(Context context, String url) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(url, IWeixinService.ResponseConstants.URL);
            Intent intent = new Intent(context, (Class<?>) PrivacyWebViewActivity.class);
            intent.putExtra(PrivacyWebViewActivity.EXTRA_URL, url);
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.trae.common.activity.TraeCommonAppCompatActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0820R.layout.activity_privacy_webview);
        View findViewById = findViewById(C0820R.id.webview);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.webView = (WebView) findViewById;
        ((ImageView) findViewById(C0820R.id.btn_back)).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.privacy.PrivacyWebViewActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PrivacyWebViewActivity.this.finish();
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
        WebView webView = this.webView;
        WebView webView2 = null;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView = null;
        }
        webView.getSettings().setJavaScriptEnabled(true);
        WebView webView3 = this.webView;
        if (webView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView3 = null;
        }
        webView3.getSettings().setDomStorageEnabled(true);
        WebView webView4 = this.webView;
        if (webView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView4 = null;
        }
        webView4.setWebViewClient(new WebViewClient());
        WebView webView5 = this.webView;
        if (webView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView5 = null;
        }
        webView5.setWebChromeClient(new WebChromeClient());
        WebView webView6 = this.webView;
        if (webView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        } else {
            webView2 = webView6;
        }
        webView2.loadUrl(stringExtra);
        getOnBackPressedDispatcher().addCallback((LifecycleOwner) this, new OnBackPressedCallback() { // from class: com.bytedance.trae.home.privacy.PrivacyWebViewActivity$onCreate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(true);
            }

            public void handleOnBackPressed() {
                WebView webView7;
                WebView webView8;
                webView7 = PrivacyWebViewActivity.this.webView;
                WebView webView9 = null;
                if (webView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("webView");
                    webView7 = null;
                }
                if (webView7.canGoBack()) {
                    webView8 = PrivacyWebViewActivity.this.webView;
                    if (webView8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("webView");
                    } else {
                        webView9 = webView8;
                    }
                    webView9.goBack();
                    return;
                }
                setEnabled(false);
                PrivacyWebViewActivity.this.getOnBackPressedDispatcher().onBackPressed();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.trae.common.activity.TraeCommonAppCompatActivity
    public void onDestroy() {
        WebView webView = this.webView;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView = null;
        }
        webView.destroy();
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_bytedance_trae_home_privacy_PrivacyWebViewActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m874xe9e0982c(PrivacyWebViewActivity privacyWebViewActivity) {
        privacyWebViewActivity.m875x194fbb2f();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                ((Activity) privacyWebViewActivity).getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
