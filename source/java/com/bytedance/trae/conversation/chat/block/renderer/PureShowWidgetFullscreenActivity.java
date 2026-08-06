package com.bytedance.trae.conversation.chat.block.renderer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.bytedance.trae.common.activity.TraeCommonAppCompatActivity;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* compiled from: PureShowWidgetFullscreenActivity.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\b\u0010\f\u001a\u00020\tH\u0014J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity;", "Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;", "<init>", "()V", "titleBar", "Lcom/bytedance/trae/common/widget/TraeTitleBar;", "webView", "Landroid/webkit/WebView;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "setupWebView", "currentWebView", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class PureShowWidgetFullscreenActivity extends TraeCommonAppCompatActivity {
    private static final String EXTRA_PAYLOAD_KEY = "extra_payload_key";
    private static final int PAYLOAD_CACHE_LIMIT = 5;
    private static final String TAG = "PureShowWidget";
    private TraeTitleBar titleBar;
    private WebView webView;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final PureShowWidgetFullscreenActivity$Companion$payloadCache$1 payloadCache = new PureShowWidgetFullscreenActivity$Companion$payloadCache$1();

    /* renamed from: com_bytedance_trae_conversation_chat_block_renderer_PureShowWidgetFullscreenActivity__onStop$___twin___ */
    public void m824x3d7b4d04() {
        super.onStop();
    }

    protected void onStop() {
        m823x5907f777(this);
    }

    /* compiled from: PureShowWidgetFullscreenActivity.kt */
    @Metadata(d1 = {"\u0000=\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0012J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0005H\u0002J\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity$Companion;", "", "<init>", "()V", "TAG", "", "EXTRA_PAYLOAD_KEY", "PAYLOAD_CACHE_LIMIT", "", "payloadCache", "com/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity$Companion$payloadCache$1", "Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity$Companion$payloadCache$1;", "start", "", "context", "Landroid/content/Context;", "payload", "Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPayload;", "start$conversation_mainlandRelease", "buildPayloadKey", "widgetCode", "consumePayload", "Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenPayload;", "key", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void start$conversation_mainlandRelease(Context context, PureShowWidgetPayload payload) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(payload, "payload");
            String widgetCode = payload.getWidgetCode();
            if (!(!StringsKt.isBlank(widgetCode))) {
                widgetCode = null;
            }
            if (widgetCode == null) {
                return;
            }
            String buildPayloadKey = buildPayloadKey(payload, widgetCode);
            synchronized (PureShowWidgetFullscreenActivity.payloadCache) {
                PureShowWidgetFullscreenActivity.payloadCache.put(buildPayloadKey, new PureShowWidgetFullscreenPayload(widgetCode, payload.getTitle()));
                Unit unit = Unit.INSTANCE;
            }
            Intent putExtra = new Intent(context, (Class<?>) PureShowWidgetFullscreenActivity.class).putExtra(PureShowWidgetFullscreenActivity.EXTRA_PAYLOAD_KEY, buildPayloadKey);
            Intrinsics.checkNotNullExpressionValue(putExtra, "putExtra(...)");
            if (!(context instanceof Activity)) {
                putExtra.addFlags(268435456);
            }
            context.startActivity(putExtra);
        }

        private final String buildPayloadKey(PureShowWidgetPayload payload, String widgetCode) {
            StringBuilder sb = new StringBuilder();
            String widgetId = payload.getWidgetId();
            if (widgetId == null) {
                widgetId = "widget";
            }
            sb.append(widgetId);
            sb.append(':');
            sb.append(widgetCode.length());
            sb.append(':');
            sb.append(widgetCode.hashCode());
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final PureShowWidgetFullscreenPayload consumePayload(String key) {
            PureShowWidgetFullscreenPayload pureShowWidgetFullscreenPayload;
            String str = key;
            if (str == null || StringsKt.isBlank(str)) {
                return null;
            }
            synchronized (PureShowWidgetFullscreenActivity.payloadCache) {
                pureShowWidgetFullscreenPayload = (PureShowWidgetFullscreenPayload) PureShowWidgetFullscreenActivity.payloadCache.get((Object) key);
            }
            return pureShowWidgetFullscreenPayload;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0057, code lost:
    
        if (r4 == null) goto L16;
     */
    @Override // com.bytedance.trae.common.activity.TraeCommonAppCompatActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0637R.layout.trae_activity_pure_show_widget_fullscreen);
        View findViewById = findViewById(C0637R.id.title_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.titleBar = (TraeTitleBar) findViewById;
        WebView webView = (WebView) findViewById(C0637R.id.webview);
        this.webView = webView;
        PureShowWidgetFullscreenPayload consumePayload = INSTANCE.consumePayload(getIntent().getStringExtra(EXTRA_PAYLOAD_KEY));
        if (consumePayload == null) {
            finish();
            return;
        }
        TraeTitleBar traeTitleBar = this.titleBar;
        TraeTitleBar traeTitleBar2 = null;
        if (traeTitleBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
            traeTitleBar = null;
        }
        String title = consumePayload.getTitle();
        if (title != null) {
            if (!(!StringsKt.isBlank(title))) {
                title = null;
            }
        }
        title = getString(C0637R.string.trae_chat_artifact_preview_web);
        Intrinsics.checkNotNullExpressionValue(title, "getString(...)");
        traeTitleBar.setTitle(title);
        TraeTitleBar traeTitleBar3 = this.titleBar;
        if (traeTitleBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        } else {
            traeTitleBar2 = traeTitleBar3;
        }
        traeTitleBar2.setOnLeftActionClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetFullscreenActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PureShowWidgetFullscreenActivity.this.finish();
            }
        });
        Intrinsics.checkNotNull(webView);
        setupWebView(webView);
        webView.loadDataWithBaseURL(PureShowWidgetHtml.WIDGET_BASE_URL, PureShowWidgetHtml.INSTANCE.build(consumePayload.getWidgetCode(), true), PureShowWidgetHtml.MIME_TYPE, "UTF-8", null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.trae.common.activity.TraeCommonAppCompatActivity
    public void onDestroy() {
        WebView webView = this.webView;
        this.webView = null;
        if (webView != null) {
            ViewParent parent = webView.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(webView);
            }
            webView.stopLoading();
            webView.removeAllViews();
            webView.destroy();
        }
        super.onDestroy();
    }

    private final void setupWebView(WebView currentWebView) {
        currentWebView.setBackgroundColor(0);
        currentWebView.setWebViewClient(new WebViewClient() { // from class: com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetFullscreenActivity$setupWebView$1
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return true;
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return true;
            }

            @Override // android.webkit.WebViewClient
            public boolean onRenderProcessGone(WebView view, RenderProcessGoneDetail detail) {
                WebView webView;
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(detail, "detail");
                TraeLogUtil.INSTANCE.e(PureShowWidgetInlineView.TAG, "[Fullscreen] WebView render process gone, didCrash=" + detail.didCrash());
                webView = PureShowWidgetFullscreenActivity.this.webView;
                if (view == webView) {
                    PureShowWidgetFullscreenActivity.this.webView = null;
                }
                ViewParent parent = view.getParent();
                ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                if (viewGroup != null) {
                    viewGroup.removeView(view);
                }
                view.destroy();
                PureShowWidgetFullscreenActivity.this.finish();
                return true;
            }
        });
        WebSettings settings = currentWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setDefaultTextEncodingName("UTF-8");
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(false);
        settings.setMixedContentMode(1);
        settings.setSupportZoom(false);
        settings.setBuiltInZoomControls(false);
        settings.setDisplayZoomControls(false);
        settings.setAllowFileAccess(false);
        settings.setAllowContentAccess(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(false);
        settings.setMediaPlaybackRequiresUserGesture(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_bytedance_trae_conversation_chat_block_renderer_PureShowWidgetFullscreenActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m823x5907f777(PureShowWidgetFullscreenActivity pureShowWidgetFullscreenActivity) {
        pureShowWidgetFullscreenActivity.m824x3d7b4d04();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                ((Activity) pureShowWidgetFullscreenActivity).getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
