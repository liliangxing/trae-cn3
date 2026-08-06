package com.bytedance.android.anniex.engine;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.anniex.p026ui.AnnieXDefaultLynxViewClient;
import com.bytedance.android.anniex.p026ui.AnnieXLynxView;
import com.bytedance.android.anniex.p026ui.IAnnieXLifeCycle;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.android.monitorV2.executor.HybridMonitorExecutor;
import com.bytedance.android.monitorV2.lynx.LynxViewMonitor;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.StreamTrafficObservable;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.LynxPerfMetric;
import com.lynx.tasm.LynxViewClient;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.behavior.ImageInterceptor;
import com.lynx.tasm.event.LynxEventDetail;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.xml.transform.Transformer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXDefaultLynxEngineClient.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 Z2\u00020\u0001:\u0002Z[B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0010\u001a\u00020\u0011JF\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0016\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0003J\b\u0010!\u001a\u00020\u0011H\u0016J\b\u0010\"\u001a\u00020\u0011H\u0016J\u0010\u0010#\u001a\u00020\u00112\b\u0010$\u001a\u0004\u0018\u00010\u0003J\u0012\u0010%\u001a\u00020\u00112\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010(\u001a\u00020\u0011H\u0016J\u0012\u0010)\u001a\u00020\u00112\b\u0010*\u001a\u0004\u0018\u00010\u0003H\u0016J\u000e\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020-J\b\u0010.\u001a\u00020\u0011H\u0016J\u0012\u0010/\u001a\u00020\u00112\b\u00100\u001a\u0004\u0018\u000101H\u0016J$\u00102\u001a\u00020\u00112\b\u00103\u001a\u0004\u0018\u00010\u00032\b\u00104\u001a\u0004\u0018\u00010\u00032\u0006\u00105\u001a\u000206H\u0016J\u0012\u00107\u001a\u00020\u00112\b\u00108\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u00109\u001a\u00020\u0011H\u0016J\u0012\u0010:\u001a\u00020\u00112\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\u0012\u0010:\u001a\u00020\u00112\b\u0010=\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010>\u001a\u00020\u0011H\u0016J\u0012\u0010?\u001a\u00020\u00112\b\u0010=\u001a\u0004\u0018\u00010@H\u0016J\u0012\u0010A\u001a\u00020\u00112\b\u0010=\u001a\u0004\u0018\u00010@H\u0016J\u0010\u0010B\u001a\u00020\u00112\u0006\u0010C\u001a\u00020DH\u0016J\u0016\u0010E\u001a\u00020\u00112\u0006\u0010F\u001a\u00020\u00032\u0006\u0010G\u001a\u00020\fJ\u001e\u0010H\u001a\u00020\u00112\u0014\u0010I\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020K\u0018\u00010JH\u0016J>\u0010L\u001a\u00020\u00112\u0014\u0010I\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020K\u0018\u00010J2\u0014\u0010M\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020N\u0018\u00010J2\b\u0010O\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010P\u001a\u00020\u00112\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u000e\u0010Q\u001a\u00020\u00112\u0006\u0010R\u001a\u00020SJ\u000e\u0010T\u001a\u00020\u00112\u0006\u0010U\u001a\u00020\fJ\u0010\u0010V\u001a\u00020\u00112\b\u0010W\u001a\u0004\u0018\u00010\nJ\u0010\u0010X\u001a\u00020\u00112\b\u0010Y\u001a\u0004\u0018\u00010\bR\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\\"}, d2 = {"Lcom/bytedance/android/anniex/engine/AnnieXDefaultLynxEngineClient;", "Lcom/bytedance/android/anniex/ui/AnnieXDefaultLynxViewClient;", "bid", "", "sessionId", "(Ljava/lang/String;Ljava/lang/String;)V", "annieXLynxViewRef", "Ljava/lang/ref/WeakReference;", "Lcom/bytedance/android/anniex/ui/AnnieXLynxView;", "currentLifeCycleRef", "Lcom/bytedance/android/anniex/ui/IAnnieXLifeCycle;", "mEnableSticky", "", "mStickyClientEvent", "Ljava/util/Queue;", "Lcom/bytedance/android/anniex/engine/AnnieXDefaultLynxEngineClient$StickyClientEvent;", "flushAllStickyEvent", "", "loadImage", "context", "Landroid/content/Context;", "cacheKey", "src", "width", "", "height", "transformer", "Ljavax/xml/transform/Transformer;", "handler", "Lcom/lynx/tasm/behavior/ImageInterceptor$CompletionHandler;", "lynxViewMonitorAddContext", "key", StrategyConstants.VALUE, "onDataUpdated", "onDestroy", "onEngineLoadFailed", "errorMsg", "onFirstLoadPerfReady", "metric", "Lcom/lynx/tasm/LynxPerfMetric;", "onFirstScreen", "onLoadFailed", "message", "onLoadStart", "uri", "Landroid/net/Uri;", "onLoadSuccess", "onLynxEvent", "detail", "Lcom/lynx/tasm/event/LynxEventDetail;", "onModuleMethodInvoked", "module", "method", "error_code", "", "onPageStart", StreamTrafficObservable.STREAM_URL, "onPageUpdate", "onReceivedError", "error", "Lcom/lynx/tasm/LynxError;", "info", "onRuntimeReady", "onScrollStart", "Lcom/lynx/tasm/LynxViewClient$ScrollInfo;", "onScrollStop", "onTemplateBundleReady", "bundle", "Lcom/lynx/tasm/TemplateBundle;", "onTemplateReady", "resFrom", "isFromMemory", "onTimingSetup", "timingInfo", "", "", "onTimingUpdate", "updateTiming", "", "flag", "onUpdatePerfReady", "postClientEvent", "runnable", "Ljava/lang/Runnable;", "setEnableSticky", "enableSticky", "setLifeCycle", "annieXLifeCycle", "setLynxView", "annieXLynxView", "Companion", "StickyClientEvent", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXDefaultLynxEngineClient extends AnnieXDefaultLynxViewClient {
    private static final String TAG = "AnnieXDefaultLynxEngineClient";
    private WeakReference<AnnieXLynxView> annieXLynxViewRef;
    private WeakReference<IAnnieXLifeCycle> currentLifeCycleRef;
    private volatile boolean mEnableSticky;
    private final Queue<StickyClientEvent> mStickyClientEvent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnnieXDefaultLynxEngineClient(String str, String str2) {
        super(null, str2, str);
        Intrinsics.checkNotNullParameter(str, "bid");
        Intrinsics.checkNotNullParameter(str2, "sessionId");
        this.mStickyClientEvent = new ConcurrentLinkedQueue();
    }

    public final void setLifeCycle(IAnnieXLifeCycle annieXLifeCycle) {
        WeakReference<IAnnieXLifeCycle> weakReference = this.currentLifeCycleRef;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.currentLifeCycleRef = annieXLifeCycle == null ? null : new WeakReference<>(annieXLifeCycle);
        super.setCurrentLifeCycle(annieXLifeCycle);
    }

    public final void setLynxView(AnnieXLynxView annieXLynxView) {
        WeakReference<AnnieXLynxView> weakReference = this.annieXLynxViewRef;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.annieXLynxViewRef = annieXLynxView == null ? null : new WeakReference<>(annieXLynxView);
        super.setAnnieXLynxView(annieXLynxView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AnnieXDefaultLynxEngineClient.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/anniex/engine/AnnieXDefaultLynxEngineClient$StickyClientEvent;", "", "handler", "Landroid/os/Handler;", "runnable", "Ljava/lang/Runnable;", "(Landroid/os/Handler;Ljava/lang/Runnable;)V", "getHandler", "()Landroid/os/Handler;", "setHandler", "(Landroid/os/Handler;)V", "getRunnable", "()Ljava/lang/Runnable;", "setRunnable", "(Ljava/lang/Runnable;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class StickyClientEvent {
        private Handler handler;
        private Runnable runnable;

        public StickyClientEvent(Handler handler, Runnable runnable) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            this.handler = handler;
            this.runnable = runnable;
        }

        public final Handler getHandler() {
            return this.handler;
        }

        public final void setHandler(Handler handler) {
            Intrinsics.checkNotNullParameter(handler, "<set-?>");
            this.handler = handler;
        }

        public final Runnable getRunnable() {
            return this.runnable;
        }

        public final void setRunnable(Runnable runnable) {
            Intrinsics.checkNotNullParameter(runnable, "<set-?>");
            this.runnable = runnable;
        }
    }

    public final void setEnableSticky(boolean enableSticky) {
        this.mEnableSticky = enableSticky;
    }

    public final void postClientEvent(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        if (this.mEnableSticky) {
            synchronized (this) {
                if (this.mEnableSticky) {
                    Looper myLooper = Looper.myLooper();
                    if (myLooper == null) {
                        myLooper = Looper.getMainLooper();
                    }
                    this.mStickyClientEvent.add(new StickyClientEvent(new Handler(myLooper), runnable));
                    return;
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        runnable.run();
    }

    public final void flushAllStickyEvent() {
        synchronized (this) {
            this.mEnableSticky = false;
            while (!this.mStickyClientEvent.isEmpty()) {
                StickyClientEvent poll = this.mStickyClientEvent.poll();
                if (poll != null) {
                    if (Intrinsics.areEqual(poll.getHandler().getLooper(), Looper.myLooper())) {
                        poll.getRunnable().run();
                    } else {
                        poll.getHandler().post(poll.getRunnable());
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.bytedance.android.anniex.p026ui.AnnieXDefaultLynxViewClient
    public void loadImage(final Context context, final String cacheKey, final String src, final float width, final float height, final Transformer transformer, final ImageInterceptor.CompletionHandler handler) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(handler, "handler");
        postClientEvent(new Runnable() { // from class: com.bytedance.android.anniex.engine.AnnieXDefaultLynxEngineClient$loadImage$1
            @Override // java.lang.Runnable
            public final void run() {
                super/*com.bytedance.android.anniex.ui.AnnieXDefaultLynxViewClient*/.loadImage(context, cacheKey, src, width, height, transformer, handler);
            }
        });
    }

    @Override // com.bytedance.android.anniex.p026ui.AnnieXDefaultLynxViewClient
    public void onModuleMethodInvoked(final String module, final String method, final int error_code) {
        postClientEvent(new Runnable() { // from class: com.bytedance.android.anniex.engine.AnnieXDefaultLynxEngineClient$onModuleMethodInvoked$1
            @Override // java.lang.Runnable
            public final void run() {
                super/*com.bytedance.android.anniex.ui.AnnieXDefaultLynxViewClient*/.onModuleMethodInvoked(module, method, error_code);
            }
        });
    }

    @Override // com.bytedance.android.anniex.p026ui.AnnieXDefaultLynxViewClient
    public void onPageStart(final String url) {
        postClientEvent(new Runnable() { // from class: com.bytedance.android.anniex.engine.AnnieXDefaultLynxEngineClient$onPageStart$1
            @Override // java.lang.Runnable
            public final void run() {
                super/*com.bytedance.android.anniex.ui.AnnieXDefaultLynxViewClient*/.onPageStart(url);
            }
        });
    }

    @Override // com.bytedance.android.anniex.p026ui.AnnieXDefaultLynxViewClient
    public void onLoadSuccess() {
        postClientEvent(new Runnable() { // from class: com.bytedance.android.anniex.engine.AnnieXDefaultLynxEngineClient$onLoadSuccess$1
            @Override // java.lang.Runnable
            public final void run() {
                super/*com.bytedance.android.anniex.ui.AnnieXDefaultLynxViewClient*/.onLoadSuccess();
            }
        });
    }

    @Override // com.bytedance.android.anniex.p026ui.AnnieXDefaultLynxViewClient
    public void onFirstScreen() {
        postClientEvent(new Runnable() { // from class: com.bytedance.android.anniex.engine.AnnieXDefaultLynxEngineClient$onFirstScreen$1
            @Override // java.lang.Runnable
            public final void run() {
                super/*com.bytedance.android.anniex.ui.AnnieXDefaultLynxViewClient*/.onFirstScreen();
            }
        });
    }

    @Override // com.bytedance.android.anniex.p026ui.AnnieXDefaultLynxViewClient
    public void onPageUpdate() {
        postClientEvent(new Runnable() { // from class: com.bytedance.android.anniex.engine.AnnieXDefaultLynxEngineClient$onPageUpdate$1
            @Override // java.lang.Runnable
            public final void run() {
                super/*com.bytedance.android.anniex.ui.AnnieXDefaultLynxViewClient*/.onPageUpdate();
            }
        });
    }

    @Override // com.bytedance.android.anniex.p026ui.AnnieXDefaultLynxViewClient
    public void onDataUpdated() {
        postClientEvent(new Runnable() { // from class: com.bytedance.android.anniex.engine.AnnieXDefaultLynxEngineClient$onDataUpdated$1
            @Override // java.lang.Runnable
            public final void run() {
                super/*com.bytedance.android.anniex.ui.AnnieXDefaultLynxViewClient*/.onDataUpdated();
            }
        });
    }

    @Override // com.bytedance.android.anniex.p026ui.AnnieXDefaultLynxViewClient
    public void onLoadFailed(final String message) {
        postClientEvent(new Runnable() { // from class: com.bytedance.android.anniex.engine.AnnieXDefaultLynxEngineClient$onLoadFailed$1
            @Override // java.lang.Runnable
            public final void run() {
                super/*com.bytedance.android.anniex.ui.AnnieXDefaultLynxViewClient*/.onLoadFailed(message);
            }
        });
    }

    @Override // com.bytedance.android.anniex.p026ui.AnnieXDefaultLynxViewClient
    public void onRuntimeReady() {
        postClientEvent(new Runnable() { // from class: com.bytedance.android.anniex.engine.AnnieXDefaultLynxEngineClient$onRuntimeReady$1
            @Override // java.lang.Runnable
            public final void run() {
                super/*com.bytedance.android.anniex.ui.AnnieXDefaultLynxViewClient*/.onRuntimeReady();
            }
        });
    }

    @Override // com.bytedance.android.anniex.p026ui.AnnieXDefaultLynxViewClient
    public void onReceivedError(final String info) {
        postClientEvent(new Runnable() { // from class: com.bytedance.android.anniex.engine.AnnieXDefaultLynxEngineClient$onReceivedError$1
            @Override // java.lang.Runnable
            public final void run() {
                super/*com.bytedance.android.anniex.ui.AnnieXDefaultLynxViewClient*/.onReceivedError(info);
            }
        });
    }

    @Override // com.bytedance.android.anniex.p026ui.AnnieXDefaultLynxViewClient
    public void onReceivedError(final LynxError error) {
        postClientEvent(new Runnable() { // from class: com.bytedance.android.anniex.engine.AnnieXDefaultLynxEngineClient$onReceivedError$2
            @Override // java.lang.Runnable
            public final void run() {
                super/*com.bytedance.android.anniex.ui.AnnieXDefaultLynxViewClient*/.onReceivedError(error);
            }
        });
    }

    @Override // com.bytedance.android.anniex.p026ui.AnnieXDefaultLynxViewClient
    public void onFirstLoadPerfReady(final LynxPerfMetric metric) {
        postClientEvent(new Runnable() { // from class: com.bytedance.android.anniex.engine.AnnieXDefaultLynxEngineClient$onFirstLoadPerfReady$1
            @Override // java.lang.Runnable
            public final void run() {
                super/*com.bytedance.android.anniex.ui.AnnieXDefaultLynxViewClient*/.onFirstLoadPerfReady(metric);
            }
        });
    }

    @Override // com.bytedance.android.anniex.p026ui.AnnieXDefaultLynxViewClient
    public void onUpdatePerfReady(final LynxPerfMetric metric) {
        postClientEvent(new Runnable() { // from class: com.bytedance.android.anniex.engine.AnnieXDefaultLynxEngineClient$onUpdatePerfReady$1
            @Override // java.lang.Runnable
            public final void run() {
                super/*com.bytedance.android.anniex.ui.AnnieXDefaultLynxViewClient*/.onUpdatePerfReady(metric);
            }
        });
    }

    @Override // com.bytedance.android.anniex.p026ui.AnnieXDefaultLynxViewClient
    public void onScrollStart(final LynxViewClient.ScrollInfo info) {
        postClientEvent(new Runnable() { // from class: com.bytedance.android.anniex.engine.AnnieXDefaultLynxEngineClient$onScrollStart$1
            @Override // java.lang.Runnable
            public final void run() {
                super/*com.bytedance.android.anniex.ui.AnnieXDefaultLynxViewClient*/.onScrollStart(info);
            }
        });
    }

    @Override // com.bytedance.android.anniex.p026ui.AnnieXDefaultLynxViewClient
    public void onScrollStop(final LynxViewClient.ScrollInfo info) {
        postClientEvent(new Runnable() { // from class: com.bytedance.android.anniex.engine.AnnieXDefaultLynxEngineClient$onScrollStop$1
            @Override // java.lang.Runnable
            public final void run() {
                super/*com.bytedance.android.anniex.ui.AnnieXDefaultLynxViewClient*/.onScrollStop(info);
            }
        });
    }

    @Override // com.bytedance.android.anniex.p026ui.AnnieXDefaultLynxViewClient
    public void onTimingSetup(final Map<String, Object> timingInfo) {
        postClientEvent(new Runnable() { // from class: com.bytedance.android.anniex.engine.AnnieXDefaultLynxEngineClient$onTimingSetup$1
            @Override // java.lang.Runnable
            public final void run() {
                super/*com.bytedance.android.anniex.ui.AnnieXDefaultLynxViewClient*/.onTimingSetup(timingInfo);
            }
        });
    }

    @Override // com.bytedance.android.anniex.p026ui.AnnieXDefaultLynxViewClient
    public void onTimingUpdate(final Map<String, Object> timingInfo, final Map<String, Long> updateTiming, final String flag) {
        postClientEvent(new Runnable() { // from class: com.bytedance.android.anniex.engine.AnnieXDefaultLynxEngineClient$onTimingUpdate$1
            @Override // java.lang.Runnable
            public final void run() {
                super/*com.bytedance.android.anniex.ui.AnnieXDefaultLynxViewClient*/.onTimingUpdate(timingInfo, updateTiming, flag);
            }
        });
    }

    @Override // com.bytedance.android.anniex.p026ui.AnnieXDefaultLynxViewClient
    public void onLynxEvent(final LynxEventDetail detail) {
        postClientEvent(new Runnable() { // from class: com.bytedance.android.anniex.engine.AnnieXDefaultLynxEngineClient$onLynxEvent$1
            @Override // java.lang.Runnable
            public final void run() {
                super/*com.bytedance.android.anniex.ui.AnnieXDefaultLynxViewClient*/.onLynxEvent(detail);
            }
        });
    }

    @Override // com.bytedance.android.anniex.p026ui.AnnieXDefaultLynxViewClient
    public void onTemplateBundleReady(final TemplateBundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        postClientEvent(new Runnable() { // from class: com.bytedance.android.anniex.engine.AnnieXDefaultLynxEngineClient$onTemplateBundleReady$1
            @Override // java.lang.Runnable
            public final void run() {
                super/*com.bytedance.android.anniex.ui.AnnieXDefaultLynxViewClient*/.onTemplateBundleReady(bundle);
            }
        });
    }

    @Override // com.bytedance.android.anniex.p026ui.AnnieXDefaultLynxViewClient
    public void onDestroy() {
        postClientEvent(new Runnable() { // from class: com.bytedance.android.anniex.engine.AnnieXDefaultLynxEngineClient$onDestroy$1
            @Override // java.lang.Runnable
            public final void run() {
                super/*com.bytedance.android.anniex.ui.AnnieXDefaultLynxViewClient*/.onDestroy();
            }
        });
    }

    public final void onLoadStart(final Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        postClientEvent(new Runnable() { // from class: com.bytedance.android.anniex.engine.AnnieXDefaultLynxEngineClient$onLoadStart$1
            @Override // java.lang.Runnable
            public final void run() {
                WeakReference weakReference;
                IAnnieXLifeCycle iAnnieXLifeCycle;
                WeakReference weakReference2;
                weakReference = AnnieXDefaultLynxEngineClient.this.currentLifeCycleRef;
                if (weakReference == null || (iAnnieXLifeCycle = (IAnnieXLifeCycle) weakReference.get()) == null) {
                    return;
                }
                Uri uri2 = uri;
                weakReference2 = AnnieXDefaultLynxEngineClient.this.annieXLynxViewRef;
                iAnnieXLifeCycle.onLoadStart(uri2, weakReference2 != null ? (AnnieXLynxView) weakReference2.get() : null);
            }
        });
    }

    public final void onTemplateReady(final String resFrom, final boolean isFromMemory) {
        Intrinsics.checkNotNullParameter(resFrom, "resFrom");
        postClientEvent(new Runnable() { // from class: com.bytedance.android.anniex.engine.AnnieXDefaultLynxEngineClient$onTemplateReady$1
            @Override // java.lang.Runnable
            public final void run() {
                WeakReference weakReference;
                IAnnieXLifeCycle iAnnieXLifeCycle;
                weakReference = AnnieXDefaultLynxEngineClient.this.currentLifeCycleRef;
                if (weakReference == null || (iAnnieXLifeCycle = (IAnnieXLifeCycle) weakReference.get()) == null) {
                    return;
                }
                iAnnieXLifeCycle.onTemplateReady(resFrom, isFromMemory);
            }
        });
    }

    public final void onEngineLoadFailed(final String errorMsg) {
        postClientEvent(new Runnable() { // from class: com.bytedance.android.anniex.engine.AnnieXDefaultLynxEngineClient$onEngineLoadFailed$1
            @Override // java.lang.Runnable
            public final void run() {
                HybridMonitorExecutor hybridMonitorExecutor = HybridMonitorExecutor.INSTANCE;
                final AnnieXDefaultLynxEngineClient annieXDefaultLynxEngineClient = AnnieXDefaultLynxEngineClient.this;
                final String str = errorMsg;
                hybridMonitorExecutor.runOnUiThread(new Function0<Unit>() { // from class: com.bytedance.android.anniex.engine.AnnieXDefaultLynxEngineClient$onEngineLoadFailed$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m3335invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m3335invoke() {
                        WeakReference weakReference;
                        IAnnieXLifeCycle iAnnieXLifeCycle;
                        WeakReference weakReference2;
                        weakReference = AnnieXDefaultLynxEngineClient.this.currentLifeCycleRef;
                        if (weakReference == null || (iAnnieXLifeCycle = (IAnnieXLifeCycle) weakReference.get()) == null) {
                            return;
                        }
                        weakReference2 = AnnieXDefaultLynxEngineClient.this.annieXLynxViewRef;
                        iAnnieXLifeCycle.onLoadFailed(weakReference2 != null ? (AnnieXLynxView) weakReference2.get() : null, str);
                    }
                });
            }
        });
    }

    public final void lynxViewMonitorAddContext(final String key, final String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, StrategyConstants.VALUE);
        postClientEvent(new Runnable() { // from class: com.bytedance.android.anniex.engine.AnnieXDefaultLynxEngineClient$lynxViewMonitorAddContext$1
            @Override // java.lang.Runnable
            public final void run() {
                WeakReference weakReference;
                Unit unit;
                AnnieXLynxView annieXLynxView;
                weakReference = AnnieXDefaultLynxEngineClient.this.annieXLynxViewRef;
                if (weakReference == null || (annieXLynxView = (AnnieXLynxView) weakReference.get()) == null) {
                    unit = null;
                } else {
                    LynxViewMonitor.Companion.getINSTANCE().addContext(annieXLynxView, key, value);
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    HybridLogger.e$default(HybridLogger.INSTANCE, "AnnieXDefaultLynxEngineClient", "annieXLynxViewRef is null", (Map) null, (LoggerContext) null, 12, (Object) null);
                }
            }
        });
    }
}
