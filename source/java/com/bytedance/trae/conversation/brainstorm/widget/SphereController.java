package com.bytedance.trae.conversation.brainstorm.widget;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: SphereController.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0019\u001a\u00020\u0018H\u0007J\u0006\u0010\u001a\u001a\u00020\u0018J\u0006\u0010\u001b\u001a\u00020\u0018J\u0010\u0010\u001c\u001a\u00020\u00182\b\b\u0002\u0010\u001d\u001a\u00020\u0007J\u0010\u0010\u001e\u001a\u00020\u00182\b\b\u0002\u0010\u001d\u001a\u00020\u0007J\u000e\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u0014J\u0006\u0010$\u001a\u00020\u0018J\u0016\u0010%\u001a\u00020\u00182\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002J\u0010\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020!H\u0002J\f\u0010)\u001a\u00020!*\u00020!H\u0002J\b\u0010*\u001a\u00020\u0018H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;", "", "webView", "Landroid/webkit/WebView;", "<init>", "(Landroid/webkit/WebView;)V", "performanceLevel", "", "getPerformanceLevel", "()I", "setPerformanceLevel", "(I)V", "sphereRatio", "", "getSphereRatio", "()Ljava/lang/Float;", "setSphereRatio", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "pageLoaded", "", "pendingActions", "", "Lkotlin/Function0;", "", "init", "start", "stop", "intro", "durationMs", "outro", "setState", "state", "", "setTaskRunning", "running", "destroy", "runWhenReady", "action", "js", "script", "escapeJsString", "applySphereRatioIfNeeded", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SphereController {
    private boolean pageLoaded;
    private final List<Function0<Unit>> pendingActions;
    private int performanceLevel;
    private Float sphereRatio;
    private final WebView webView;

    public SphereController(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        this.webView = webView;
        this.performanceLevel = 3;
        this.pendingActions = new ArrayList();
    }

    public final int getPerformanceLevel() {
        return this.performanceLevel;
    }

    public final void setPerformanceLevel(int i) {
        this.performanceLevel = i;
    }

    public final Float getSphereRatio() {
        return this.sphereRatio;
    }

    public final void setSphereRatio(Float f) {
        this.sphereRatio = f;
    }

    public final void init() {
        this.webView.getSettings().setJavaScriptEnabled(true);
        this.webView.getSettings().setDomStorageEnabled(true);
        this.webView.setBackgroundColor(0);
        this.webView.setWebViewClient(new WebViewClient() { // from class: com.bytedance.trae.conversation.brainstorm.widget.SphereController$init$1
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                SphereController.this.pageLoaded = false;
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView view, String url) {
                List list;
                List list2;
                super.onPageFinished(view, url);
                SphereController.this.pageLoaded = true;
                list = SphereController.this.pendingActions;
                List list3 = CollectionsKt.toList(list);
                list2 = SphereController.this.pendingActions;
                list2.clear();
                Iterator it = list3.iterator();
                while (it.hasNext()) {
                    ((Function0) it.next()).invoke();
                }
            }
        });
        this.webView.loadUrl("file:///android_asset/brainstorm/hollow_sphere.html");
    }

    public final void start() {
        runWhenReady(new Function0() { // from class: com.bytedance.trae.conversation.brainstorm.widget.SphereController$$ExternalSyntheticLambda2
            public final Object invoke() {
                Unit start$lambda$0;
                start$lambda$0 = SphereController.start$lambda$0(SphereController.this);
                return start$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit start$lambda$0(SphereController sphereController) {
        sphereController.applySphereRatioIfNeeded();
        sphereController.m820js("SphereAPI.setPerformanceLevel(" + sphereController.performanceLevel + ')');
        sphereController.m820js("SphereAPI.start()");
        return Unit.INSTANCE;
    }

    public final void stop() {
        m820js("SphereAPI.stop()");
    }

    public static /* synthetic */ void intro$default(SphereController sphereController, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = FConstants.URI_FAIL_CODE;
        }
        sphereController.intro(i);
    }

    public final void intro(final int durationMs) {
        runWhenReady(new Function0() { // from class: com.bytedance.trae.conversation.brainstorm.widget.SphereController$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit intro$lambda$1;
                intro$lambda$1 = SphereController.intro$lambda$1(SphereController.this, durationMs);
                return intro$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit intro$lambda$1(SphereController sphereController, int i) {
        sphereController.applySphereRatioIfNeeded();
        sphereController.m820js("SphereAPI.setPerformanceLevel(" + sphereController.performanceLevel + ')');
        sphereController.m820js("SphereAPI.intro(" + i + ')');
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void outro$default(SphereController sphereController, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = FConstants.DOWNLOAD_FAIL_CODE;
        }
        sphereController.outro(i);
    }

    public final void outro(int durationMs) {
        m820js("SphereAPI.outro(" + durationMs + ')');
    }

    public final void setState(final String state) {
        Intrinsics.checkNotNullParameter(state, "state");
        runWhenReady(new Function0() { // from class: com.bytedance.trae.conversation.brainstorm.widget.SphereController$$ExternalSyntheticLambda1
            public final Object invoke() {
                Unit state$lambda$2;
                state$lambda$2 = SphereController.setState$lambda$2(SphereController.this, state);
                return state$lambda$2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setState$lambda$2(SphereController sphereController, String str) {
        sphereController.m820js("SphereAPI.setState('" + sphereController.escapeJsString(str) + "')");
        return Unit.INSTANCE;
    }

    public final void setTaskRunning(boolean running) {
        setState(running ? "processing" : "idle");
    }

    public final void destroy() {
        this.webView.destroy();
    }

    private final void runWhenReady(Function0<Unit> action) {
        if (this.pageLoaded) {
            action.invoke();
        } else {
            this.pendingActions.add(action);
        }
    }

    /* renamed from: js */
    private final void m820js(String script) {
        this.webView.evaluateJavascript(script, null);
    }

    private final String escapeJsString(String str) {
        return StringsKt.replace$default(StringsKt.replace$default(str, "\\", "\\\\", false, 4, (Object) null), "'", "\\'", false, 4, (Object) null);
    }

    private final void applySphereRatioIfNeeded() {
        Float f = this.sphereRatio;
        if (f != null) {
            m820js("SphereAPI.setSphereRatio(" + f.floatValue() + ')');
        }
    }
}
