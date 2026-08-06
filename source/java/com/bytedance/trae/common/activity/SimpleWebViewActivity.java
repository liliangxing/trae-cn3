package com.bytedance.trae.common.activity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.PopupMenu;
import androidx.activity.OnBackPressedCallback;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.common_ui.C0591R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* compiled from: SimpleWebViewActivity.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0015J\b\u0010\f\u001a\u00020\tH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;", "Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;", "<init>", "()V", "webView", "Landroid/webkit/WebView;", "getDecorViewBackgroundColor", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SimpleWebViewActivity extends TraeCommonAppCompatActivity {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_SHOW_MORE_MENU = "extra_show_more_menu";
    private static final String EXTRA_URL = "extra_url";
    private WebView webView;

    /* renamed from: com_bytedance_trae_common_activity_SimpleWebViewActivity__onStop$___twin___ */
    public void m810x5bd1dd8c() {
        super.onStop();
    }

    protected void onStop() {
        m809xc46e9bef(this);
    }

    /* compiled from: SimpleWebViewActivity.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/trae/common/activity/SimpleWebViewActivity$Companion;", "", "<init>", "()V", "EXTRA_URL", "", "EXTRA_SHOW_MORE_MENU", "start", "", "context", "Landroid/content/Context;", IWeixinService.ResponseConstants.URL, "showMoreMenu", "", "common-ui_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ void start$default(Companion companion, Context context, String str, boolean z, int i, Object obj) {
            if ((i & 4) != 0) {
                z = false;
            }
            companion.start(context, str, z);
        }

        public final void start(Context context, String r4, boolean showMoreMenu) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(r4, IWeixinService.ResponseConstants.URL);
            Intent intent = new Intent(context, (Class<?>) SimpleWebViewActivity.class);
            intent.putExtra(SimpleWebViewActivity.EXTRA_URL, r4);
            intent.putExtra(SimpleWebViewActivity.EXTRA_SHOW_MORE_MENU, showMoreMenu);
            context.startActivity(intent);
        }
    }

    @Override // com.bytedance.trae.common.activity.TraeCommonAppCompatActivity
    public int getDecorViewBackgroundColor() {
        return getColor(C0591R.color.trae_bg_bg_base_default);
    }

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
        TraeTitleBar traeTitleBar = (TraeTitleBar) findViewById(C0591R.id.title_bar);
        traeTitleBar.setOnLeftActionClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.common.activity.SimpleWebViewActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SimpleWebViewActivity.this.finish();
            }
        });
        final String stringExtra = getIntent().getStringExtra(EXTRA_URL);
        if (stringExtra == null) {
            stringExtra = "";
        }
        if (stringExtra.length() == 0) {
            finish();
            return;
        }
        if (getIntent().getBooleanExtra(EXTRA_SHOW_MORE_MENU, false)) {
            traeTitleBar.setRightAction(TraeTitleBar.Action.MORE);
            traeTitleBar.setOnRightActionClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.common.activity.SimpleWebViewActivity$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SimpleWebViewActivity.onCreate$lambda$3(SimpleWebViewActivity.this, stringExtra, view);
                }
            });
        }
        WebView webView3 = this.webView;
        if (webView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView3 = null;
        }
        webView3.getSettings().setJavaScriptEnabled(true);
        WebView webView4 = this.webView;
        if (webView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView4 = null;
        }
        webView4.getSettings().setDomStorageEnabled(true);
        WebView webView5 = this.webView;
        if (webView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView5 = null;
        }
        webView5.setWebViewClient(new WebViewClient() { // from class: com.bytedance.trae.common.activity.SimpleWebViewActivity$onCreate$3
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                Uri url;
                String scheme;
                if (request == null || (url = request.getUrl()) == null || (scheme = url.getScheme()) == null || Intrinsics.areEqual(scheme, "http") || Intrinsics.areEqual(scheme, "https")) {
                    return false;
                }
                try {
                    SimpleWebViewActivity.this.startActivity(new Intent("android.intent.action.VIEW", url));
                } catch (ActivityNotFoundException unused) {
                }
                return true;
            }
        });
        WebView webView6 = this.webView;
        if (webView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView6 = null;
        }
        webView6.setWebChromeClient(new WebChromeClient());
        WebView webView7 = this.webView;
        if (webView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        } else {
            webView2 = webView7;
        }
        webView2.loadUrl(stringExtra);
        getOnBackPressedDispatcher().addCallback((LifecycleOwner) this, new OnBackPressedCallback() { // from class: com.bytedance.trae.common.activity.SimpleWebViewActivity$onCreate$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(true);
            }

            public void handleOnBackPressed() {
                WebView webView8;
                WebView webView9;
                webView8 = SimpleWebViewActivity.this.webView;
                WebView webView10 = null;
                if (webView8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("webView");
                    webView8 = null;
                }
                if (webView8.canGoBack()) {
                    webView9 = SimpleWebViewActivity.this.webView;
                    if (webView9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("webView");
                    } else {
                        webView10 = webView9;
                    }
                    webView10.goBack();
                    return;
                }
                setEnabled(false);
                SimpleWebViewActivity.this.getOnBackPressedDispatcher().onBackPressed();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void onCreate$lambda$3(SimpleWebViewActivity simpleWebViewActivity, final String str, View view) {
        PopupMenu popupMenu = new PopupMenu((Context) simpleWebViewActivity, view);
        popupMenu.getMenu().add(0, 1, 0, C0591R.string.trae_webview_open_in_browser);
        popupMenu.getMenu().add(0, 2, 1, C0591R.string.trae_webview_share_link);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.bytedance.trae.common.activity.SimpleWebViewActivity$$ExternalSyntheticLambda0
            @Override // android.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                boolean onCreate$lambda$3$lambda$2;
                onCreate$lambda$3$lambda$2 = SimpleWebViewActivity.onCreate$lambda$3$lambda$2(SimpleWebViewActivity.this, str, menuItem);
                return onCreate$lambda$3$lambda$2;
            }
        });
        popupMenu.show();
    }

    public static final boolean onCreate$lambda$3$lambda$2(SimpleWebViewActivity simpleWebViewActivity, String str, MenuItem menuItem) {
        WebView webView = simpleWebViewActivity.webView;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView = null;
        }
        String url = webView.getUrl();
        if (url != null) {
            str = url;
        }
        int itemId = menuItem.getItemId();
        if (itemId == 1) {
            try {
                simpleWebViewActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                return true;
            } catch (ActivityNotFoundException unused) {
                return true;
            }
        }
        if (itemId != 2) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", str);
        simpleWebViewActivity.startActivity(Intent.createChooser(intent, null));
        return true;
    }

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
    /* renamed from: com_bytedance_trae_common_activity_SimpleWebViewActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m809xc46e9bef(SimpleWebViewActivity simpleWebViewActivity) {
        simpleWebViewActivity.m810x5bd1dd8c();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                ((Activity) simpleWebViewActivity).getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
