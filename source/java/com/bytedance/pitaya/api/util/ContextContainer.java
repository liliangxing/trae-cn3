package com.bytedance.pitaya.api.util;

import android.app.Application;
import android.content.Context;
import com.bytedance.bdturing.methods.JsCallParser;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContextContainer.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/pitaya/api/util/ContextContainer;", "", "()V", JsCallParser.VALUE_CALLBACK, "Lcom/bytedance/pitaya/api/util/ContextCallback;", "container", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "getContext", "setContext", "", "context", "setContextCallback", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class ContextContainer {
    public static final ContextContainer INSTANCE = new ContextContainer();
    private static ContextCallback callback;
    private static WeakReference<Context> container;

    private ContextContainer() {
    }

    public final void setContext(Context context) {
        WeakReference<Context> weakReference;
        Intrinsics.checkNotNullParameter(context, "context");
        WeakReference<Context> weakReference2 = container;
        if (weakReference2 != null) {
            if ((weakReference2 != null ? weakReference2.get() : null) != null) {
                return;
            }
        }
        if (context instanceof Application) {
            weakReference = new WeakReference<>(((Application) context).getBaseContext());
        } else {
            weakReference = new WeakReference<>(context);
        }
        container = weakReference;
    }

    public final Context getContext() {
        Context context;
        WeakReference<Context> weakReference = container;
        if (weakReference != null) {
            if ((weakReference != null ? weakReference.get() : null) != null) {
                WeakReference<Context> weakReference2 = container;
                if (weakReference2 != null) {
                    return weakReference2.get();
                }
                return null;
            }
        }
        ContextCallback contextCallback = callback;
        if (contextCallback == null || (context = contextCallback.getContext()) == null) {
            return null;
        }
        INSTANCE.setContext(context);
        return context;
    }

    public final void setContextCallback(ContextCallback callback2) {
        Intrinsics.checkNotNullParameter(callback2, "callback");
        callback = callback2;
    }
}
