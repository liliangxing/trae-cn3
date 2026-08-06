package com.bytedance.pitaya.api.mutilinstance;

import android.util.Log;
import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HostSetupWatcher.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\nJ\b\u0010\u000b\u001a\u00020\fH\u0002J\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\tJ\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/pitaya/api/mutilinstance/HostSetupWatcher;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "()V", "TAG", "", "isHostSetup", "Ljava/util/concurrent/atomic/AtomicBoolean;", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/bytedance/pitaya/api/mutilinstance/HostSetupListener;", "", "notifyAllListener", "", "onHostSetup", "registerHostSetupListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "unregisterHostSetupListener", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class HostSetupWatcher implements ReflectionCall {
    private static final String TAG = "PTY-HostSetupWatcher";
    public static final HostSetupWatcher INSTANCE = new HostSetupWatcher();
    private static final CopyOnWriteArrayList<HostSetupListener> listeners = new CopyOnWriteArrayList<>();
    private static final AtomicBoolean isHostSetup = new AtomicBoolean(false);

    private HostSetupWatcher() {
    }

    public final boolean isHostSetup() {
        return isHostSetup.get();
    }

    public final void registerHostSetupListener(HostSetupListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        CopyOnWriteArrayList<HostSetupListener> copyOnWriteArrayList = listeners;
        synchronized (copyOnWriteArrayList) {
            if (isHostSetup.get()) {
                listener.onHostSetup(true);
            } else {
                copyOnWriteArrayList.add(listener);
            }
        }
    }

    public final void unregisterHostSetupListener(HostSetupListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        CopyOnWriteArrayList<HostSetupListener> copyOnWriteArrayList = listeners;
        synchronized (copyOnWriteArrayList) {
            copyOnWriteArrayList.remove(listener);
        }
    }

    public final void onHostSetup() {
        synchronized (listeners) {
            isHostSetup.set(true);
            INSTANCE.notifyAllListener();
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void notifyAllListener() {
        CopyOnWriteArrayList<HostSetupListener> copyOnWriteArrayList = listeners;
        synchronized (copyOnWriteArrayList) {
            Iterator<T> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                try {
                    ((HostSetupListener) it.next()).onHostSetup(true);
                } catch (Throwable th) {
                    Log.e(TAG, Log.getStackTraceString(th));
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
