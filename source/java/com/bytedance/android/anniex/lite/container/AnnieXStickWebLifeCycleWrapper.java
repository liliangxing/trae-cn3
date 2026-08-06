package com.bytedance.android.anniex.lite.container;

import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import com.bytedance.android.anniex.base.container.IContainer;
import com.bytedance.android.anniex.base.lifecycle.AbsAnnieXLifecycle;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.StreamTrafficObservable;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXWebEngineProxy.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J$\u0010\u0013\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u001c\u0010\u0019\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001c\u0010\u001a\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001c\u0010\u001b\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J&\u0010\u001c\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\rH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/bytedance/android/anniex/lite/container/AnnieXStickWebLifeCycleWrapper;", "Lcom/bytedance/android/anniex/lite/container/IStickWebLifeCycle;", StrategyConstants.SCHEMA, "", "(Ljava/lang/String;)V", "flushEnd", "", "handler", "Landroid/os/Handler;", "iContainer", "Lcom/bytedance/android/anniex/base/container/IContainer;", "mStickyClientEvent", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Ljava/lang/Runnable;", "originLifeCycle", "Lcom/bytedance/android/anniex/base/lifecycle/AbsAnnieXLifecycle;", "flushStickLifeCycle", "", "lifecycle", "onLoadFail", StreamTrafficObservable.STREAM_URL, "webView", "Landroid/webkit/WebView;", "e", "", "onLoadStart", "onLoadUriSuccess", "onRuntimeReady", "onViewDestroy", "throwable", "postClientEvent", "runnable", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXStickWebLifeCycleWrapper implements IStickWebLifeCycle {
    private volatile boolean flushEnd;
    private final Handler handler;
    private IContainer iContainer;
    private final ConcurrentLinkedQueue<Runnable> mStickyClientEvent;
    private AbsAnnieXLifecycle originLifeCycle;
    private final String schema;

    public AnnieXStickWebLifeCycleWrapper(String str) {
        Intrinsics.checkNotNullParameter(str, StrategyConstants.SCHEMA);
        this.schema = str;
        this.mStickyClientEvent = new ConcurrentLinkedQueue<>();
        Looper myLooper = Looper.myLooper();
        this.handler = new Handler(myLooper == null ? Looper.getMainLooper() : myLooper);
    }

    private final void postClientEvent(Runnable runnable) {
        synchronized (this) {
            if (this.flushEnd) {
                runnable.run();
            } else {
                this.mStickyClientEvent.add(runnable);
            }
        }
    }

    @Override // com.bytedance.android.anniex.lite.container.IStickWebLifeCycle
    public void flushStickLifeCycle(IContainer iContainer, AbsAnnieXLifecycle lifecycle) {
        Intrinsics.checkNotNullParameter(iContainer, "iContainer");
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        this.originLifeCycle = lifecycle;
        this.iContainer = iContainer;
        synchronized (this) {
            this.flushEnd = true;
            for (Runnable runnable : this.mStickyClientEvent) {
                if (Intrinsics.areEqual(this.handler.getLooper(), Looper.myLooper())) {
                    runnable.run();
                } else {
                    this.handler.post(runnable);
                }
            }
            this.mStickyClientEvent.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.bytedance.android.anniex.web.api.IAnnieXWebLifecycle
    public void onLoadStart(final String url, WebView webView) {
        postClientEvent(new Runnable() { // from class: com.bytedance.android.anniex.lite.container.AnnieXStickWebLifeCycleWrapper$onLoadStart$1
            @Override // java.lang.Runnable
            public final void run() {
                IContainer iContainer;
                AbsAnnieXLifecycle absAnnieXLifecycle;
                iContainer = AnnieXStickWebLifeCycleWrapper.this.iContainer;
                if (iContainer != null) {
                    AnnieXStickWebLifeCycleWrapper annieXStickWebLifeCycleWrapper = AnnieXStickWebLifeCycleWrapper.this;
                    String str = url;
                    absAnnieXLifecycle = annieXStickWebLifeCycleWrapper.originLifeCycle;
                    if (absAnnieXLifecycle != null) {
                        if (str == null) {
                            str = annieXStickWebLifeCycleWrapper.schema;
                        }
                        absAnnieXLifecycle.onLoadStart(str, iContainer);
                    }
                }
            }
        });
    }

    @Override // com.bytedance.android.anniex.web.api.IAnnieXWebLifecycle
    public void onLoadFail(final String url, WebView webView, final Throwable e) {
        Intrinsics.checkNotNullParameter(e, "e");
        postClientEvent(new Runnable() { // from class: com.bytedance.android.anniex.lite.container.AnnieXStickWebLifeCycleWrapper$onLoadFail$1
            @Override // java.lang.Runnable
            public final void run() {
                IContainer iContainer;
                AbsAnnieXLifecycle absAnnieXLifecycle;
                iContainer = AnnieXStickWebLifeCycleWrapper.this.iContainer;
                if (iContainer != null) {
                    AnnieXStickWebLifeCycleWrapper annieXStickWebLifeCycleWrapper = AnnieXStickWebLifeCycleWrapper.this;
                    String str = url;
                    Throwable th = e;
                    absAnnieXLifecycle = annieXStickWebLifeCycleWrapper.originLifeCycle;
                    if (absAnnieXLifecycle != null) {
                        if (str == null) {
                            str = annieXStickWebLifeCycleWrapper.schema;
                        }
                        absAnnieXLifecycle.onLoadFail(str, iContainer, th);
                    }
                }
            }
        });
    }

    @Override // com.bytedance.android.anniex.web.api.IAnnieXWebLifecycle
    public void onRuntimeReady(final String url, WebView webView) {
        postClientEvent(new Runnable() { // from class: com.bytedance.android.anniex.lite.container.AnnieXStickWebLifeCycleWrapper$onRuntimeReady$1
            @Override // java.lang.Runnable
            public final void run() {
                IContainer iContainer;
                AbsAnnieXLifecycle absAnnieXLifecycle;
                iContainer = AnnieXStickWebLifeCycleWrapper.this.iContainer;
                if (iContainer != null) {
                    AnnieXStickWebLifeCycleWrapper annieXStickWebLifeCycleWrapper = AnnieXStickWebLifeCycleWrapper.this;
                    String str = url;
                    absAnnieXLifecycle = annieXStickWebLifeCycleWrapper.originLifeCycle;
                    if (absAnnieXLifecycle != null) {
                        if (str == null) {
                            str = annieXStickWebLifeCycleWrapper.schema;
                        }
                        absAnnieXLifecycle.onRuntimeReady(str, iContainer);
                    }
                }
            }
        });
    }

    @Override // com.bytedance.android.anniex.web.api.IAnnieXWebLifecycle
    public void onViewDestroy(final String url, WebView webView, Throwable throwable) {
        postClientEvent(new Runnable() { // from class: com.bytedance.android.anniex.lite.container.AnnieXStickWebLifeCycleWrapper$onViewDestroy$1
            @Override // java.lang.Runnable
            public final void run() {
                AbsAnnieXLifecycle absAnnieXLifecycle;
                absAnnieXLifecycle = AnnieXStickWebLifeCycleWrapper.this.originLifeCycle;
                if (absAnnieXLifecycle != null) {
                    String str = url;
                    if (str == null) {
                        str = AnnieXStickWebLifeCycleWrapper.this.schema;
                    }
                    absAnnieXLifecycle.onRelease(str);
                }
            }
        });
    }

    @Override // com.bytedance.android.anniex.web.api.IAnnieXWebLifecycle
    public void onLoadUriSuccess(final String url, WebView webView) {
        postClientEvent(new Runnable() { // from class: com.bytedance.android.anniex.lite.container.AnnieXStickWebLifeCycleWrapper$onLoadUriSuccess$1
            @Override // java.lang.Runnable
            public final void run() {
                IContainer iContainer;
                AbsAnnieXLifecycle absAnnieXLifecycle;
                iContainer = AnnieXStickWebLifeCycleWrapper.this.iContainer;
                if (iContainer != null) {
                    AnnieXStickWebLifeCycleWrapper annieXStickWebLifeCycleWrapper = AnnieXStickWebLifeCycleWrapper.this;
                    String str = url;
                    absAnnieXLifecycle = annieXStickWebLifeCycleWrapper.originLifeCycle;
                    if (absAnnieXLifecycle != null) {
                        if (str == null) {
                            str = annieXStickWebLifeCycleWrapper.schema;
                        }
                        absAnnieXLifecycle.onLoadSuccess(str, iContainer);
                    }
                }
            }
        });
    }
}
