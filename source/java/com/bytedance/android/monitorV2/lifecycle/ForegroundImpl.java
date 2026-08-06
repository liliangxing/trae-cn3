package com.bytedance.android.monitorV2.lifecycle;

import android.app.Activity;
import com.bytedance.android.monitorV2.util.ExceptionUtil;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ForegroundImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\u0010\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0010\u0010\u0014\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0007H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/monitorV2/lifecycle/ForegroundImpl;", "Lcom/bytedance/android/monitorV2/lifecycle/IForegroundListener;", "()V", "backgroundListeners", "", "Lcom/bytedance/android/monitorV2/lifecycle/OnApplicationBackgroundListener;", "foregroundListeners", "Lcom/bytedance/android/monitorV2/lifecycle/OnApplicationForegroundListener;", "isApplicationBackgrounded", "", "()Z", "setApplicationBackgrounded", "(Z)V", "addOnApplicationBackgroundListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "addOnApplicationForegroundListener", "notifyAppBackgrounded", "activity", "Landroid/app/Activity;", "notifyAppForegrounded", "removeOnApplicationBackgroundListener", "removeOnApplicationForegroundListener", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class ForegroundImpl implements IForegroundListener {
    private boolean isApplicationBackgrounded;
    private final List<OnApplicationForegroundListener> foregroundListeners = new ArrayList();
    private final List<OnApplicationBackgroundListener> backgroundListeners = new ArrayList();

    @Override // com.bytedance.android.monitorV2.lifecycle.IForegroundListener
    /* renamed from: isApplicationBackgrounded, reason: from getter */
    public boolean getIsApplicationBackgrounded() {
        return this.isApplicationBackgrounded;
    }

    public void setApplicationBackgrounded(boolean z) {
        this.isApplicationBackgrounded = z;
    }

    @Override // com.bytedance.android.monitorV2.lifecycle.IForegroundListener
    public void addOnApplicationForegroundListener(OnApplicationForegroundListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.foregroundListeners.add(listener);
    }

    @Override // com.bytedance.android.monitorV2.lifecycle.IForegroundListener
    public boolean removeOnApplicationForegroundListener(OnApplicationForegroundListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return this.foregroundListeners.remove(listener);
    }

    @Override // com.bytedance.android.monitorV2.lifecycle.IForegroundListener
    public void addOnApplicationBackgroundListener(OnApplicationBackgroundListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.backgroundListeners.add(listener);
    }

    @Override // com.bytedance.android.monitorV2.lifecycle.IForegroundListener
    public boolean removeOnApplicationBackgroundListener(OnApplicationBackgroundListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return this.backgroundListeners.remove(listener);
    }

    public final void notifyAppForegrounded(Activity activity) {
        try {
            Iterator<OnApplicationForegroundListener> it = this.foregroundListeners.iterator();
            while (it.hasNext()) {
                it.next().onApplicationForeground(activity != null ? activity.getApplicationContext() : null);
            }
        } catch (Throwable th) {
            ExceptionUtil.handleException(th);
        }
    }

    public final void notifyAppBackgrounded(Activity activity) {
        try {
            Iterator<OnApplicationBackgroundListener> it = this.backgroundListeners.iterator();
            while (it.hasNext()) {
                it.next().onApplicationBackground(activity != null ? activity.getApplicationContext() : null);
            }
        } catch (Throwable th) {
            ExceptionUtil.handleException(th);
        }
    }
}
