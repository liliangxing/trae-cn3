package com.bytedance.ies.bullet.core;

import android.net.Uri;
import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BulletLifeCycleManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005J\u0016\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000f\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ies/bullet/core/BulletLifeCycleManager;", "", "()V", "mOnGlobalLifeCycleListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/bytedance/ies/bullet/core/OnGlobalLifeCycleListener;", "addOnGlobalLifeCycleListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "dispatchOnLoadUriFail", "uri", "Landroid/net/Uri;", "view", "Landroid/view/View;", "dispatchOnLoadUriSuccess", "removeOnGlobalLifeCycleListener", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class BulletLifeCycleManager {
    public static final BulletLifeCycleManager INSTANCE = new BulletLifeCycleManager();
    private static final CopyOnWriteArrayList<OnGlobalLifeCycleListener> mOnGlobalLifeCycleListeners = new CopyOnWriteArrayList<>();

    private BulletLifeCycleManager() {
    }

    public final void addOnGlobalLifeCycleListener(OnGlobalLifeCycleListener listener) {
        if (listener != null) {
            CopyOnWriteArrayList<OnGlobalLifeCycleListener> copyOnWriteArrayList = mOnGlobalLifeCycleListeners;
            if (copyOnWriteArrayList.contains(listener)) {
                return;
            }
            copyOnWriteArrayList.add(listener);
        }
    }

    public final void removeOnGlobalLifeCycleListener(OnGlobalLifeCycleListener listener) {
        if (listener == null) {
            return;
        }
        mOnGlobalLifeCycleListeners.remove(listener);
    }

    public final void dispatchOnLoadUriSuccess(Uri uri, View view) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(view, "view");
        CopyOnWriteArrayList<OnGlobalLifeCycleListener> copyOnWriteArrayList = mOnGlobalLifeCycleListeners;
        if (copyOnWriteArrayList.size() > 0) {
            Iterator<OnGlobalLifeCycleListener> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                it.next().onLoadUriSuccess(uri, view);
            }
        }
    }

    public final void dispatchOnLoadUriFail(Uri uri, View view) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(view, "view");
        CopyOnWriteArrayList<OnGlobalLifeCycleListener> copyOnWriteArrayList = mOnGlobalLifeCycleListeners;
        if (copyOnWriteArrayList.size() > 0) {
            Iterator<OnGlobalLifeCycleListener> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                it.next().onLoadUriFail(uri, view);
            }
        }
    }
}
