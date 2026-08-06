package com.bytedance.android.anniex.base.builder;

import android.content.Context;
import com.bytedance.android.anniex.base.container.listener.AnnieXViewListener;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewBuilder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nR\u001a\u0010\u0003\u001a\u00020\u0004X\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/anniex/base/builder/ViewBuilder;", "Lcom/bytedance/android/anniex/base/builder/UIComponentBuilder;", "()V", "context", "Landroid/content/Context;", "getContext$anniex_release", "()Landroid/content/Context;", "setContext$anniex_release", "(Landroid/content/Context;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/bytedance/android/anniex/base/container/listener/AnnieXViewListener;", "getListener$anniex_release", "()Lcom/bytedance/android/anniex/base/container/listener/AnnieXViewListener;", "setListener$anniex_release", "(Lcom/bytedance/android/anniex/base/container/listener/AnnieXViewListener;)V", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final class ViewBuilder extends UIComponentBuilder {
    public Context context;
    private AnnieXViewListener listener;

    public final Context getContext$anniex_release() {
        Context context = this.context;
        if (context != null) {
            return context;
        }
        Intrinsics.throwUninitializedPropertyAccessException("context");
        return null;
    }

    public final void setContext$anniex_release(Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.context = context;
    }

    /* renamed from: getListener$anniex_release, reason: from getter */
    public final AnnieXViewListener getListener() {
        return this.listener;
    }

    public final void setListener$anniex_release(AnnieXViewListener annieXViewListener) {
        this.listener = annieXViewListener;
    }

    public final void context(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        setContext$anniex_release(context);
        setSystemContext$anniex_release(context);
    }

    public final void listener(AnnieXViewListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }
}
