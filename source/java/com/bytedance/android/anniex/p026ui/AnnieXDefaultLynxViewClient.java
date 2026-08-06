package com.bytedance.android.anniex.p026ui;

import android.content.Context;
import android.net.Uri;
import androidx.webkit.ProxyConfig;
import bolts.Task;
import coil3.util.Utils_commonKt;
import com.bytedance.android.anniex.monitor.MonitorManager;
import com.bytedance.android.anniex.p026ui.IAnnieXLifeCycle;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.forest.Forest;
import com.bytedance.forest.chain.fetchers.GeckoXAdapter;
import com.bytedance.forest.model.RequestParams;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Scene;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.StreamTrafficObservable;
import com.bytedance.framwork.core.sdklib.apm6.Constants;
import com.bytedance.ies.bullet.forest.ForestLoader;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoader;
import com.bytedance.ies.bullet.preloadv2.redirect.RedirectManager;
import com.bytedance.ies.bullet.preloadv2.utils.PreloadLogger;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.LynxPerfMetric;
import com.lynx.tasm.LynxViewClient;
import com.lynx.tasm.LynxViewClientGroup;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.behavior.ImageInterceptor;
import com.lynx.tasm.event.LynxEventDetail;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.xml.transform.Transformer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: AnnieXDefaultLynxViewClient.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\b\u0010\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002JF\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u0015H\u0016J\b\u0010%\u001a\u00020\u0015H\u0016J\u0012\u0010&\u001a\u00020\u00152\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020\u0015H\u0016J\u0012\u0010*\u001a\u00020\u00152\b\u0010+\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010,\u001a\u00020\u0015H\u0016J\u0012\u0010-\u001a\u00020\u00152\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J$\u00100\u001a\u00020\u00152\b\u00101\u001a\u0004\u0018\u00010\u00052\b\u00102\u001a\u0004\u0018\u00010\u00052\u0006\u00103\u001a\u000204H\u0016J\u0012\u00105\u001a\u00020\u00152\b\u00106\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u00107\u001a\u00020\u0015H\u0016J\u0012\u00108\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u00108\u001a\u00020\u00152\b\u00109\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010:\u001a\u00020\u0015H\u0016J\u0012\u0010;\u001a\u00020\u00152\b\u00109\u001a\u0004\u0018\u00010<H\u0016J\u0012\u0010=\u001a\u00020\u00152\b\u00109\u001a\u0004\u0018\u00010<H\u0016J\u0010\u0010>\u001a\u00020\u00152\u0006\u0010?\u001a\u00020@H\u0016J\u001e\u0010A\u001a\u00020\u00152\u0014\u0010B\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020D\u0018\u00010CH\u0016J>\u0010E\u001a\u00020\u00152\u0014\u0010B\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020D\u0018\u00010C2\u0014\u0010F\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020G\u0018\u00010C2\b\u0010H\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010I\u001a\u00020\u00152\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0014\u0010J\u001a\u0004\u0018\u00010\u00052\b\u00106\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010K\u001a\u00020\u00152\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003J\u0010\u0010L\u001a\u00020\u00152\b\u0010M\u001a\u0004\u0018\u00010\u000fJ\u0014\u0010N\u001a\u0004\u0018\u00010\u00052\b\u00106\u001a\u0004\u0018\u00010\u0005H\u0016R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\r¨\u0006O"}, d2 = {"Lcom/bytedance/android/anniex/ui/AnnieXDefaultLynxViewClient;", "Lcom/lynx/tasm/LynxViewClientGroup;", "annieXLynxView", "Lcom/bytedance/android/anniex/ui/AnnieXLynxView;", "sessionId", "", "bid", "(Lcom/bytedance/android/anniex/ui/AnnieXLynxView;Ljava/lang/String;Ljava/lang/String;)V", "annieXLynxViewRef", "Ljava/lang/ref/WeakReference;", "getBid", "()Ljava/lang/String;", "setBid", "(Ljava/lang/String;)V", "currentLifeCycleRef", "Lcom/bytedance/android/anniex/ui/IAnnieXLifeCycle;", "currentUri", "Landroid/net/Uri;", "getSessionId", "setSessionId", "deleteResourceWhen100Error", "", "error", "Lcom/lynx/tasm/LynxError;", "loadImage", "context", "Landroid/content/Context;", "cacheKey", "src", "width", "", "height", "transformer", "Ljavax/xml/transform/Transformer;", "handler", "Lcom/lynx/tasm/behavior/ImageInterceptor$CompletionHandler;", "onDataUpdated", "onDestroy", "onFirstLoadPerfReady", "metric", "Lcom/lynx/tasm/LynxPerfMetric;", "onFirstScreen", "onLoadFailed", "message", "onLoadSuccess", "onLynxEvent", "detail", "Lcom/lynx/tasm/event/LynxEventDetail;", "onModuleMethodInvoked", "module", "method", "error_code", "", "onPageStart", StreamTrafficObservable.STREAM_URL, "onPageUpdate", "onReceivedError", "info", "onRuntimeReady", "onScrollStart", "Lcom/lynx/tasm/LynxViewClient$ScrollInfo;", "onScrollStop", "onTemplateBundleReady", "bundle", "Lcom/lynx/tasm/TemplateBundle;", "onTimingSetup", "timingInfo", "", "", "onTimingUpdate", "updateTiming", "", "flag", "onUpdatePerfReady", "redirectWithPipeline", "setAnnieXLynxView", "setCurrentLifeCycle", "annieXLifeCycle", "shouldRedirectImageUrl", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class AnnieXDefaultLynxViewClient extends LynxViewClientGroup {
    private WeakReference<AnnieXLynxView> annieXLynxViewRef;
    private String bid;
    private WeakReference<IAnnieXLifeCycle> currentLifeCycleRef;
    private Uri currentUri;
    private String sessionId;

    public AnnieXDefaultLynxViewClient(AnnieXLynxView annieXLynxView, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "sessionId");
        Intrinsics.checkNotNullParameter(str2, "bid");
        this.sessionId = str;
        this.bid = str2;
        this.annieXLynxViewRef = annieXLynxView != null ? new WeakReference<>(annieXLynxView) : null;
    }

    public final String getBid() {
        return this.bid;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final void setBid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bid = str;
    }

    public final void setSessionId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sessionId = str;
    }

    public final void setCurrentLifeCycle(IAnnieXLifeCycle annieXLifeCycle) {
        WeakReference<IAnnieXLifeCycle> weakReference = this.currentLifeCycleRef;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.currentLifeCycleRef = annieXLifeCycle == null ? null : new WeakReference<>(annieXLifeCycle);
    }

    public final void setAnnieXLynxView(AnnieXLynxView annieXLynxView) {
        WeakReference<AnnieXLynxView> weakReference = this.annieXLynxViewRef;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.annieXLynxViewRef = annieXLynxView == null ? null : new WeakReference<>(annieXLynxView);
    }

    public String shouldRedirectImageUrl(String url) {
        IAnnieXLifeCycle iAnnieXLifeCycle;
        String shouldRedirectImageUrl;
        WeakReference<IAnnieXLifeCycle> weakReference = this.currentLifeCycleRef;
        if (weakReference != null && (iAnnieXLifeCycle = weakReference.get()) != null && (shouldRedirectImageUrl = iAnnieXLifeCycle.shouldRedirectImageUrl(url)) != null) {
            return shouldRedirectImageUrl;
        }
        Uri parse = Uri.parse(url);
        String redirectWithPipeline = redirectWithPipeline(url);
        boolean z = true;
        if (redirectWithPipeline != null) {
            if (!(!equals(url))) {
                redirectWithPipeline = null;
            }
            if (redirectWithPipeline != null) {
                return redirectWithPipeline;
            }
        }
        String str = url;
        if (str != null && str.length() != 0) {
            z = false;
        }
        if (z) {
            return null;
        }
        List listOf = CollectionsKt.listOf(new String[]{"http", ProxyConfig.MATCH_HTTPS, Utils_commonKt.SCHEME_FILE, StrategyConstants.CONTENT, "res", Constants.KEY_DATA});
        String scheme = parse.getScheme();
        if (scheme == null) {
            scheme = "";
        }
        return listOf.contains(scheme) ? url : (Intrinsics.areEqual(parse.getScheme(), "bundle") || Intrinsics.areEqual(parse.getScheme(), "relative")) ? parse.getPath() : url;
    }

    public void loadImage(Context context, String cacheKey, String src, float width, float height, Transformer transformer, ImageInterceptor.CompletionHandler handler) {
        IAnnieXLifeCycle iAnnieXLifeCycle;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(handler, "handler");
        super.loadImage(context, cacheKey, src, width, height, transformer, handler);
        WeakReference<IAnnieXLifeCycle> weakReference = this.currentLifeCycleRef;
        if (weakReference == null || (iAnnieXLifeCycle = weakReference.get()) == null) {
            return;
        }
        iAnnieXLifeCycle.loadImage(context, cacheKey, src, width, height, transformer, handler);
    }

    public void onModuleMethodInvoked(String module, String method, int error_code) {
        IAnnieXLifeCycle iAnnieXLifeCycle;
        super.onModuleMethodInvoked(module, method, error_code);
        WeakReference<IAnnieXLifeCycle> weakReference = this.currentLifeCycleRef;
        if (weakReference == null || (iAnnieXLifeCycle = weakReference.get()) == null) {
            return;
        }
        iAnnieXLifeCycle.onModuleMethodInvoked(module, method, error_code);
    }

    public void onPageStart(String url) {
        IAnnieXLifeCycle iAnnieXLifeCycle;
        super.onPageStart(url);
        WeakReference<IAnnieXLifeCycle> weakReference = this.currentLifeCycleRef;
        if (weakReference != null && (iAnnieXLifeCycle = weakReference.get()) != null) {
            WeakReference<AnnieXLynxView> weakReference2 = this.annieXLynxViewRef;
            iAnnieXLifeCycle.onPageStart(weakReference2 != null ? weakReference2.get() : null, url);
        }
        if (url != null) {
            this.currentUri = Uri.parse(url);
        }
        MonitorManager.INSTANCE.onPageStart(this.sessionId);
    }

    public void onLoadSuccess() {
        IAnnieXLifeCycle iAnnieXLifeCycle;
        AnnieXLynxView annieXLynxView;
        super.onLoadSuccess();
        WeakReference<AnnieXLynxView> weakReference = this.annieXLynxViewRef;
        if (weakReference != null && (annieXLynxView = weakReference.get()) != null) {
            annieXLynxView.addTagView(this.bid);
        }
        WeakReference<IAnnieXLifeCycle> weakReference2 = this.currentLifeCycleRef;
        if (weakReference2 != null && (iAnnieXLifeCycle = weakReference2.get()) != null) {
            Uri uri = this.currentUri;
            WeakReference<AnnieXLynxView> weakReference3 = this.annieXLynxViewRef;
            iAnnieXLifeCycle.onLoadUriSuccess(uri, weakReference3 != null ? weakReference3.get() : null);
        }
        MonitorManager.INSTANCE.onLoadSuccess(this.sessionId);
    }

    public void onFirstScreen() {
        IAnnieXLifeCycle iAnnieXLifeCycle;
        super.onFirstScreen();
        WeakReference<IAnnieXLifeCycle> weakReference = this.currentLifeCycleRef;
        if (weakReference != null && (iAnnieXLifeCycle = weakReference.get()) != null) {
            WeakReference<AnnieXLynxView> weakReference2 = this.annieXLynxViewRef;
            iAnnieXLifeCycle.onFirstScreen(weakReference2 != null ? weakReference2.get() : null);
        }
        MonitorManager.INSTANCE.onFirstScreen(this.sessionId);
    }

    public void onPageUpdate() {
        IAnnieXLifeCycle iAnnieXLifeCycle;
        super.onPageUpdate();
        WeakReference<IAnnieXLifeCycle> weakReference = this.currentLifeCycleRef;
        if (weakReference == null || (iAnnieXLifeCycle = weakReference.get()) == null) {
            return;
        }
        WeakReference<AnnieXLynxView> weakReference2 = this.annieXLynxViewRef;
        iAnnieXLifeCycle.onPageUpdate(weakReference2 != null ? weakReference2.get() : null);
    }

    public void onDataUpdated() {
        IAnnieXLifeCycle iAnnieXLifeCycle;
        super.onDataUpdated();
        WeakReference<IAnnieXLifeCycle> weakReference = this.currentLifeCycleRef;
        if (weakReference == null || (iAnnieXLifeCycle = weakReference.get()) == null) {
            return;
        }
        WeakReference<AnnieXLynxView> weakReference2 = this.annieXLynxViewRef;
        iAnnieXLifeCycle.onDataUpdated(weakReference2 != null ? weakReference2.get() : null);
    }

    public void onLoadFailed(String message) {
        IAnnieXLifeCycle iAnnieXLifeCycle;
        super.onLoadFailed(message);
        WeakReference<IAnnieXLifeCycle> weakReference = this.currentLifeCycleRef;
        if (weakReference == null || (iAnnieXLifeCycle = weakReference.get()) == null) {
            return;
        }
        WeakReference<AnnieXLynxView> weakReference2 = this.annieXLynxViewRef;
        iAnnieXLifeCycle.onLoadFailed(weakReference2 != null ? weakReference2.get() : null, message);
    }

    public void onRuntimeReady() {
        IAnnieXLifeCycle iAnnieXLifeCycle;
        super.onRuntimeReady();
        WeakReference<IAnnieXLifeCycle> weakReference = this.currentLifeCycleRef;
        if (weakReference == null || (iAnnieXLifeCycle = weakReference.get()) == null) {
            return;
        }
        WeakReference<AnnieXLynxView> weakReference2 = this.annieXLynxViewRef;
        iAnnieXLifeCycle.onRuntimeReady(weakReference2 != null ? weakReference2.get() : null);
    }

    public void onReceivedError(String info) {
        IAnnieXLifeCycle iAnnieXLifeCycle;
        super.onReceivedError(info);
        WeakReference<IAnnieXLifeCycle> weakReference = this.currentLifeCycleRef;
        if (weakReference == null || (iAnnieXLifeCycle = weakReference.get()) == null) {
            return;
        }
        WeakReference<AnnieXLynxView> weakReference2 = this.annieXLynxViewRef;
        iAnnieXLifeCycle.onReceivedError(weakReference2 != null ? weakReference2.get() : null, info);
    }

    public void onReceivedError(LynxError error) {
        IAnnieXLifeCycle iAnnieXLifeCycle;
        IAnnieXLifeCycle iAnnieXLifeCycle2;
        super.onReceivedError(error);
        WeakReference<IAnnieXLifeCycle> weakReference = this.currentLifeCycleRef;
        if (weakReference != null && (iAnnieXLifeCycle2 = weakReference.get()) != null) {
            WeakReference<AnnieXLynxView> weakReference2 = this.annieXLynxViewRef;
            iAnnieXLifeCycle2.onReceivedError(weakReference2 != null ? weakReference2.get() : null, error);
        }
        if (IConditionCallKt.enableLynx100ErrorFix()) {
            deleteResourceWhen100Error(error);
        }
        boolean z = false;
        if (error != null && error.isFatal()) {
            z = true;
        }
        if (!z || this.currentUri == null) {
            return;
        }
        WeakReference<IAnnieXLifeCycle> weakReference3 = this.currentLifeCycleRef;
        if (weakReference3 != null && (iAnnieXLifeCycle = weakReference3.get()) != null) {
            Uri uri = this.currentUri;
            Intrinsics.checkNotNull(uri);
            iAnnieXLifeCycle.onLoadFail(uri, new Throwable(error.toString()));
        }
        WeakReference<IAnnieXLifeCycle> weakReference4 = this.currentLifeCycleRef;
        IAnnieXLifeCycle iAnnieXLifeCycle3 = weakReference4 != null ? weakReference4.get() : null;
        IAnnieXLifeCycle.AnnieXLynxLifeCycle annieXLynxLifeCycle = iAnnieXLifeCycle3 instanceof IAnnieXLifeCycle.AnnieXLynxLifeCycle ? (IAnnieXLifeCycle.AnnieXLynxLifeCycle) iAnnieXLifeCycle3 : null;
        if (annieXLynxLifeCycle != null) {
            WeakReference<AnnieXLynxView> weakReference5 = this.annieXLynxViewRef;
            annieXLynxLifeCycle.onLoadFailed(weakReference5 != null ? weakReference5.get() : null, error.getErrorCode(), error.getMsg());
        }
        MonitorManager monitorManager = MonitorManager.INSTANCE;
        String str = this.bid;
        String str2 = this.sessionId;
        AbsBulletMonitorCallback.ErrStage errStage = AbsBulletMonitorCallback.ErrStage.Engine;
        String msg = error.getMsg();
        if (msg == null) {
            msg = "";
        }
        String str3 = msg;
        WeakReference<AnnieXLynxView> weakReference6 = this.annieXLynxViewRef;
        monitorManager.onLoadFail(str, str2, errStage, str3, weakReference6 != null ? weakReference6.get() : null);
    }

    public void onFirstLoadPerfReady(LynxPerfMetric metric) {
        IAnnieXLifeCycle iAnnieXLifeCycle;
        super.onFirstLoadPerfReady(metric);
        WeakReference<IAnnieXLifeCycle> weakReference = this.currentLifeCycleRef;
        if (weakReference == null || (iAnnieXLifeCycle = weakReference.get()) == null) {
            return;
        }
        WeakReference<AnnieXLynxView> weakReference2 = this.annieXLynxViewRef;
        iAnnieXLifeCycle.onFirstLoadPerfReady(weakReference2 != null ? weakReference2.get() : null, metric != null ? metric.toJSONObject() : null);
    }

    public void onUpdatePerfReady(LynxPerfMetric metric) {
        IAnnieXLifeCycle iAnnieXLifeCycle;
        super.onUpdatePerfReady(metric);
        WeakReference<IAnnieXLifeCycle> weakReference = this.currentLifeCycleRef;
        if (weakReference == null || (iAnnieXLifeCycle = weakReference.get()) == null) {
            return;
        }
        WeakReference<AnnieXLynxView> weakReference2 = this.annieXLynxViewRef;
        iAnnieXLifeCycle.onUpdatePerfReady(weakReference2 != null ? weakReference2.get() : null, metric != null ? metric.toJSONObject() : null);
    }

    public void onScrollStart(LynxViewClient.ScrollInfo info) {
        IAnnieXLifeCycle iAnnieXLifeCycle;
        super.onScrollStart(info);
        WeakReference<IAnnieXLifeCycle> weakReference = this.currentLifeCycleRef;
        if (weakReference == null || (iAnnieXLifeCycle = weakReference.get()) == null) {
            return;
        }
        iAnnieXLifeCycle.onScrollStop(info);
    }

    public void onScrollStop(LynxViewClient.ScrollInfo info) {
        IAnnieXLifeCycle iAnnieXLifeCycle;
        super.onScrollStop(info);
        WeakReference<IAnnieXLifeCycle> weakReference = this.currentLifeCycleRef;
        if (weakReference == null || (iAnnieXLifeCycle = weakReference.get()) == null) {
            return;
        }
        iAnnieXLifeCycle.onScrollStop(info);
    }

    public void onTimingSetup(Map<String, Object> timingInfo) {
        AnnieXLynxView annieXLynxView;
        IAnnieXLifeCycle iAnnieXLifeCycle;
        super.onTimingSetup(timingInfo);
        WeakReference<IAnnieXLifeCycle> weakReference = this.currentLifeCycleRef;
        if (weakReference != null && (iAnnieXLifeCycle = weakReference.get()) != null) {
            iAnnieXLifeCycle.onTimingSetup(timingInfo);
        }
        MonitorManager monitorManager = MonitorManager.INSTANCE;
        String str = this.sessionId;
        WeakReference<AnnieXLynxView> weakReference2 = this.annieXLynxViewRef;
        monitorManager.onTimingSetup(str, timingInfo, (weakReference2 == null || (annieXLynxView = weakReference2.get()) == null) ? null : annieXLynxView.lynxDevTool());
    }

    public void onTimingUpdate(Map<String, Object> timingInfo, Map<String, Long> updateTiming, String flag) {
        IAnnieXLifeCycle iAnnieXLifeCycle;
        super.onTimingUpdate(timingInfo, updateTiming, flag);
        WeakReference<IAnnieXLifeCycle> weakReference = this.currentLifeCycleRef;
        if (weakReference != null && (iAnnieXLifeCycle = weakReference.get()) != null) {
            iAnnieXLifeCycle.onTimingUpdate(timingInfo, updateTiming, flag);
        }
        MonitorManager.INSTANCE.onTimingUpdate(this.sessionId, timingInfo, updateTiming, flag);
    }

    public void onLynxEvent(LynxEventDetail detail) {
        super.onLynxEvent(detail);
    }

    public void onTemplateBundleReady(TemplateBundle bundle) {
        IAnnieXLifeCycle iAnnieXLifeCycle;
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        WeakReference<IAnnieXLifeCycle> weakReference = this.currentLifeCycleRef;
        if (weakReference == null || (iAnnieXLifeCycle = weakReference.get()) == null) {
            return;
        }
        iAnnieXLifeCycle.onTemplateBundleReady(bundle);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String redirectWithPipeline(String url) {
        String str;
        String str2;
        long currentTimeMillis = System.currentTimeMillis();
        PreloadLogger.INSTANCE.i("redirectWithPipeline URL:" + url + ",defaultCache:" + RedirectManager.INSTANCE.getDefaultCache());
        String str3 = url;
        boolean z = true;
        if ((str3 == null || str3.length() == 0) || StringsKt.startsWith$default(url, "file://", false, 2, (Object) null) || StringsKt.startsWith$default(url, "data:", false, 2, (Object) null)) {
            return url;
        }
        String redirectPath = RedirectManager.INSTANCE.getRedirectPath(url);
        if (redirectPath != null) {
            RedirectManager.INSTANCE.reportRedirect(this.bid, url, redirectPath, true, System.currentTimeMillis() - currentTimeMillis);
            return redirectPath;
        }
        if (!StringsKt.startsWith$default(url, "base64:", false, 2, (Object) null)) {
            ForestLoader forestLoader = ForestLoader.INSTANCE;
            Scene scene = Scene.LYNX_IMAGE;
            String str4 = this.sessionId;
            TaskConfig taskConfig = new TaskConfig((String) null, 1, (DefaultConstructorMarker) null);
            taskConfig.setBid(this.bid);
            Unit unit = Unit.INSTANCE;
            Response loadSync$default = ForestLoader.loadSync$default(forestLoader, (Forest) null, url, (String) null, scene, str4, taskConfig, new Function1<RequestParams, Unit>() { // from class: com.bytedance.android.anniex.ui.AnnieXDefaultLynxViewClient$redirectWithPipeline$3
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((RequestParams) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(RequestParams requestParams) {
                    Intrinsics.checkNotNullParameter(requestParams, "requestParams");
                    requestParams.setDisableCdn(true);
                    requestParams.setCheckGeckoFileAvailable(false);
                }
            }, 5, (Object) null);
            if (loadSync$default != null) {
                String filePath = loadSync$default.getFilePath();
                if (filePath != null) {
                    if (!(!StringsKt.isBlank(filePath))) {
                        filePath = null;
                    }
                    if (filePath != null) {
                        str = "file://" + filePath;
                        str2 = str;
                        if (str2 != null && str2.length() != 0) {
                            z = false;
                        }
                        if ((!z || Intrinsics.areEqual(str, url)) && GeckoXAdapter.Companion.isCDNMultiVersionResource(url)) {
                            str = GeckoXAdapter.Companion.addCommonParamsForCDNMultiVersionURL(url);
                        }
                        if (RedirectManager.INSTANCE.getDefaultCache()) {
                            PreloadLogger.INSTANCE.i("redirectWithPipeline putRedirectPath URL:" + url + ",redirectUrl:" + str);
                            RedirectManager.INSTANCE.putRedirectPath(url, str);
                        }
                        RedirectManager.INSTANCE.reportRedirect(this.bid, url, str, false, System.currentTimeMillis() - currentTimeMillis);
                        return str;
                    }
                }
                str = null;
                str2 = str;
                if (str2 != null) {
                    z = false;
                }
                if (!z) {
                }
                str = GeckoXAdapter.Companion.addCommonParamsForCDNMultiVersionURL(url);
                if (RedirectManager.INSTANCE.getDefaultCache()) {
                }
                RedirectManager.INSTANCE.reportRedirect(this.bid, url, str, false, System.currentTimeMillis() - currentTimeMillis);
                return str;
            }
        }
        str = url;
        str2 = str;
        if (str2 != null) {
        }
        if (!z) {
        }
        str = GeckoXAdapter.Companion.addCommonParamsForCDNMultiVersionURL(url);
        if (RedirectManager.INSTANCE.getDefaultCache()) {
        }
        RedirectManager.INSTANCE.reportRedirect(this.bid, url, str, false, System.currentTimeMillis() - currentTimeMillis);
        return str;
    }

    private final void deleteResourceWhen100Error(LynxError error) {
        AnnieXLynxView annieXLynxView;
        if (error != null) {
            WeakReference<AnnieXLynxView> weakReference = this.annieXLynxViewRef;
            final ResourceInfo resourceInfo = (weakReference == null || (annieXLynxView = weakReference.get()) == null) ? null : annieXLynxView.getResourceInfo();
            if (error.getErrorCode() != 102 || resourceInfo == null) {
                return;
            }
            Task.call(new Callable() { // from class: com.bytedance.android.anniex.ui.AnnieXDefaultLynxViewClient$deleteResourceWhen100Error$1$1
                @Override // java.util.concurrent.Callable
                public /* bridge */ /* synthetic */ Object call() {
                    call();
                    return Unit.INSTANCE;
                }

                @Override // java.util.concurrent.Callable
                public final void call() {
                    WeakReference weakReference2;
                    AnnieXLynxView annieXLynxView2;
                    InputStream provideInputStream = resourceInfo.provideInputStream();
                    if (provideInputStream != null) {
                        try {
                            provideInputStream.reset();
                        } catch (Throwable th) {
                            BulletLogger.printLog$default(BulletLogger.INSTANCE, "lynx error, read file failed " + th.getMessage(), (LogLevel) null, "XLynxKit", 2, (Object) null);
                        }
                    }
                    BulletLogger.printLog$default(BulletLogger.INSTANCE, "lynx error, 100 error,delete local resource url=" + resourceInfo.getSrcUri(), (LogLevel) null, "XLynxKit", 2, (Object) null);
                    ResourceLoader resourceLoader = ResourceLoader.INSTANCE;
                    weakReference2 = this.annieXLynxViewRef;
                    ResourceLoader.with$default(resourceLoader, (weakReference2 == null || (annieXLynxView2 = (AnnieXLynxView) weakReference2.get()) == null) ? null : annieXLynxView2.getBid(), (String) null, 2, (Object) null).deleteResource(resourceInfo);
                }
            }, Task.BACKGROUND_EXECUTOR);
        }
    }

    public void onDestroy() {
        WeakReference<IAnnieXLifeCycle> weakReference = this.currentLifeCycleRef;
        Object obj = weakReference != null ? (IAnnieXLifeCycle) weakReference.get() : null;
        IAnnieXLifeCycle.AnnieXLynxLifeCycle annieXLynxLifeCycle = obj instanceof IAnnieXLifeCycle.AnnieXLynxLifeCycle ? (IAnnieXLifeCycle.AnnieXLynxLifeCycle) obj : null;
        if (annieXLynxLifeCycle != null) {
            annieXLynxLifeCycle.onDestroy();
        }
    }
}
