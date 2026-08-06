package com.bytedance.android.anniex.container;

import android.view.View;
import com.bytedance.android.anniex.base.container.IContainer;
import com.bytedance.android.anniex.base.lifecycle.AbsAnnieXLifecycle;
import com.bytedance.android.anniex.base.lifecycle.CompleteLifecycle;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXLifecycleDispatcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0001J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\"\u0010\u0010\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\rH\u0016J \u0010\u0016\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u001a\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u001b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010\u001c\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u001d\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u001e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u001f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010 \u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/bytedance/android/anniex/container/AnnieXLifecycleDispatcher;", "Lcom/bytedance/android/anniex/base/lifecycle/CompleteLifecycle;", "()V", "completeLifecycles", "Ljava/util/concurrent/CopyOnWriteArrayList;", "lifecycles", "Lcom/bytedance/android/anniex/base/lifecycle/AbsAnnieXLifecycle;", "addCompleteLifecycle", "", "lifecycle", "addLifecycle", "onAttachView", StrategyConstants.SCHEMA, "", "container", "Lcom/bytedance/android/anniex/base/container/IContainer;", "onContainerError", "view", "Landroid/view/View;", "errorCode", "", "errorMessage", "onFallback", "throwable", "", "onFirstScreen", "onKitViewCreate", "onKitViewDestroy", "onLoadFail", "onLoadStart", "onLoadSuccess", "onRelease", "onRuntimeReady", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXLifecycleDispatcher extends CompleteLifecycle {
    private final CopyOnWriteArrayList<AbsAnnieXLifecycle> lifecycles = new CopyOnWriteArrayList<>();
    private final CopyOnWriteArrayList<CompleteLifecycle> completeLifecycles = new CopyOnWriteArrayList<>();

    public final void addLifecycle(AbsAnnieXLifecycle lifecycle) {
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        this.lifecycles.add(lifecycle);
    }

    public final void addCompleteLifecycle(CompleteLifecycle lifecycle) {
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        this.completeLifecycles.add(lifecycle);
    }

    @Override // com.bytedance.android.anniex.base.lifecycle.AbsAnnieXLifecycle
    public void onKitViewCreate(String schema, IContainer container) {
        Intrinsics.checkNotNullParameter(schema, StrategyConstants.SCHEMA);
        Intrinsics.checkNotNullParameter(container, "container");
        Iterator<T> it = this.completeLifecycles.iterator();
        while (it.hasNext()) {
            ((CompleteLifecycle) it.next()).onKitViewCreate(schema, container);
        }
        Iterator<T> it2 = this.lifecycles.iterator();
        while (it2.hasNext()) {
            ((AbsAnnieXLifecycle) it2.next()).onKitViewCreate(schema, container);
        }
    }

    @Override // com.bytedance.android.anniex.base.lifecycle.AbsAnnieXLifecycle
    public void onKitViewDestroy(String schema, IContainer container) {
        Intrinsics.checkNotNullParameter(schema, StrategyConstants.SCHEMA);
        Intrinsics.checkNotNullParameter(container, "container");
        Iterator<T> it = this.completeLifecycles.iterator();
        while (it.hasNext()) {
            ((CompleteLifecycle) it.next()).onKitViewDestroy(schema, container);
        }
        Iterator<T> it2 = this.lifecycles.iterator();
        while (it2.hasNext()) {
            ((AbsAnnieXLifecycle) it2.next()).onKitViewDestroy(schema, container);
        }
    }

    @Override // com.bytedance.android.anniex.base.lifecycle.AbsAnnieXLifecycle
    public void onLoadSuccess(String schema, IContainer container) {
        Intrinsics.checkNotNullParameter(schema, StrategyConstants.SCHEMA);
        Intrinsics.checkNotNullParameter(container, "container");
        Iterator<T> it = this.completeLifecycles.iterator();
        while (it.hasNext()) {
            ((CompleteLifecycle) it.next()).onLoadSuccess(schema, container);
        }
        Iterator<T> it2 = this.lifecycles.iterator();
        while (it2.hasNext()) {
            ((AbsAnnieXLifecycle) it2.next()).onLoadSuccess(schema, container);
        }
    }

    @Override // com.bytedance.android.anniex.base.lifecycle.AbsAnnieXLifecycle
    public void onLoadFail(String schema, IContainer container, Throwable throwable) {
        Intrinsics.checkNotNullParameter(schema, StrategyConstants.SCHEMA);
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Iterator<T> it = this.completeLifecycles.iterator();
        while (it.hasNext()) {
            ((CompleteLifecycle) it.next()).onLoadFail(schema, container, throwable);
        }
        Iterator<T> it2 = this.lifecycles.iterator();
        while (it2.hasNext()) {
            ((AbsAnnieXLifecycle) it2.next()).onLoadFail(schema, container, throwable);
        }
    }

    @Override // com.bytedance.android.anniex.base.lifecycle.AbsAnnieXLifecycle
    public void onLoadStart(String schema, IContainer container) {
        Intrinsics.checkNotNullParameter(schema, StrategyConstants.SCHEMA);
        Intrinsics.checkNotNullParameter(container, "container");
        Iterator<T> it = this.completeLifecycles.iterator();
        while (it.hasNext()) {
            ((CompleteLifecycle) it.next()).onLoadStart(schema, container);
        }
        Iterator<T> it2 = this.lifecycles.iterator();
        while (it2.hasNext()) {
            ((AbsAnnieXLifecycle) it2.next()).onLoadStart(schema, container);
        }
    }

    @Override // com.bytedance.android.anniex.base.lifecycle.AbsAnnieXLifecycle
    public void onAttachView(String schema, IContainer container) {
        Intrinsics.checkNotNullParameter(schema, StrategyConstants.SCHEMA);
        Intrinsics.checkNotNullParameter(container, "container");
        Iterator<T> it = this.completeLifecycles.iterator();
        while (it.hasNext()) {
            ((CompleteLifecycle) it.next()).onAttachView(schema, container);
        }
        Iterator<T> it2 = this.lifecycles.iterator();
        while (it2.hasNext()) {
            ((AbsAnnieXLifecycle) it2.next()).onAttachView(schema, container);
        }
    }

    @Override // com.bytedance.android.anniex.base.lifecycle.AbsAnnieXLifecycle
    public void onFallback(String schema, IContainer container, Throwable throwable) {
        Intrinsics.checkNotNullParameter(schema, StrategyConstants.SCHEMA);
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Iterator<T> it = this.completeLifecycles.iterator();
        while (it.hasNext()) {
            ((CompleteLifecycle) it.next()).onFallback(schema, container, throwable);
        }
        Iterator<T> it2 = this.lifecycles.iterator();
        while (it2.hasNext()) {
            ((AbsAnnieXLifecycle) it2.next()).onFallback(schema, container, throwable);
        }
    }

    @Override // com.bytedance.android.anniex.base.lifecycle.AbsAnnieXLifecycle
    public void onRuntimeReady(String schema, IContainer container) {
        Intrinsics.checkNotNullParameter(schema, StrategyConstants.SCHEMA);
        Intrinsics.checkNotNullParameter(container, "container");
        Iterator<T> it = this.completeLifecycles.iterator();
        while (it.hasNext()) {
            ((CompleteLifecycle) it.next()).onRuntimeReady(schema, container);
        }
        Iterator<T> it2 = this.lifecycles.iterator();
        while (it2.hasNext()) {
            ((AbsAnnieXLifecycle) it2.next()).onRuntimeReady(schema, container);
        }
    }

    @Override // com.bytedance.android.anniex.base.lifecycle.AbsAnnieXLifecycle
    public void onRelease(String schema) {
        Intrinsics.checkNotNullParameter(schema, StrategyConstants.SCHEMA);
        Iterator<T> it = this.completeLifecycles.iterator();
        while (it.hasNext()) {
            ((CompleteLifecycle) it.next()).onRelease(schema);
        }
        Iterator<T> it2 = this.lifecycles.iterator();
        while (it2.hasNext()) {
            ((AbsAnnieXLifecycle) it2.next()).onRelease(schema);
        }
    }

    @Override // com.bytedance.android.anniex.base.lifecycle.AbsAnnieXLifecycle
    public void onContainerError(View view, int errorCode, String errorMessage) {
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        super.onContainerError(view, errorCode, errorMessage);
        Iterator<T> it = this.completeLifecycles.iterator();
        while (it.hasNext()) {
            ((CompleteLifecycle) it.next()).onContainerError(view, errorCode, errorMessage);
        }
        Iterator<T> it2 = this.lifecycles.iterator();
        while (it2.hasNext()) {
            ((AbsAnnieXLifecycle) it2.next()).onContainerError(view, errorCode, errorMessage);
        }
    }

    @Override // com.bytedance.android.anniex.base.lifecycle.AbsAnnieXLifecycle
    public void onFirstScreen(String schema, IContainer container) {
        Intrinsics.checkNotNullParameter(schema, StrategyConstants.SCHEMA);
        Intrinsics.checkNotNullParameter(container, "container");
        Iterator<T> it = this.completeLifecycles.iterator();
        while (it.hasNext()) {
            ((CompleteLifecycle) it.next()).onFirstScreen(schema, container);
        }
        Iterator<T> it2 = this.lifecycles.iterator();
        while (it2.hasNext()) {
            ((AbsAnnieXLifecycle) it2.next()).onFirstScreen(schema, container);
        }
    }
}
