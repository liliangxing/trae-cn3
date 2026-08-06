package com.bytedance.android.anniex.base.lifecycle;

import android.view.View;
import com.bytedance.android.anniex.base.container.IContainer;
import com.lynx.animax.monitor.AnimaXMonitorUtil;
import com.lynx.tasm.LynxError;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AbsAnnieXLifecycle.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\"\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J \u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0017J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J \u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/anniex/base/lifecycle/AbsAnnieXLifecycle;", "", "()V", "onAttachView", "", "schema", "", "container", "Lcom/bytedance/android/anniex/base/container/IContainer;", "onContainerError", "view", "Landroid/view/View;", "errorCode", "", "errorMessage", "onFallback", LynxError.LYNX_THROWABLE, "", "onFirstScreen", "onKitViewCreate", "onKitViewDestroy", "onLoadFail", "onLoadStart", "onLoadSuccess", AnimaXMonitorUtil.TRIGGER_ON_RELEASE, "onRuntimeReady", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public abstract class AbsAnnieXLifecycle {
    public void onAttachView(String schema, IContainer container) {
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(container, "container");
    }

    public void onContainerError(View view, int errorCode, String errorMessage) {
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
    }

    public void onFallback(String schema, IContainer container, Throwable throwable) {
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
    }

    @Deprecated(message = "This function will be deleted in future")
    public void onFirstScreen(String schema, IContainer container) {
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(container, "container");
    }

    public void onKitViewCreate(String schema, IContainer container) {
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(container, "container");
    }

    public void onKitViewDestroy(String schema, IContainer container) {
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(container, "container");
    }

    public void onLoadFail(String schema, IContainer container, Throwable throwable) {
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
    }

    public void onLoadStart(String schema, IContainer container) {
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(container, "container");
    }

    public void onLoadSuccess(String schema, IContainer container) {
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(container, "container");
    }

    public void onRelease(String schema) {
        Intrinsics.checkNotNullParameter(schema, "schema");
    }

    public void onRuntimeReady(String schema, IContainer container) {
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(container, "container");
    }
}
