package com.bytedance.lynx.service.security;

import androidx.exifinterface.media.ExifInterface;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LynxSecurityDelegateRegistry.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0004J\u0017\u0010\n\u001a\u0004\u0018\u00018\u00012\b\u0010\u000b\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\fJ\u001b\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00028\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u0001¢\u0006\u0002\u0010\u0012R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00018\u0001X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\t\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/lynx/service/security/LynxSecurityDelegateRegistry;", "K", "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "()V", "delegateMap", "Ljava/util/WeakHashMap;", "globalDelegate", "Ljava/lang/Object;", "lock", "resolveDelegate", "key", "(Ljava/lang/Object;)Ljava/lang/Object;", "setDelegateForKey", "", "delegate", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "setGlobalDelegate", "(Ljava/lang/Object;)Z", "LynxSecurityService_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LynxSecurityDelegateRegistry<K, V> {
    private V globalDelegate;
    private final Object lock = new Object();
    private final WeakHashMap<K, V> delegateMap = new WeakHashMap<>();

    public final boolean setGlobalDelegate(V delegate) {
        boolean z;
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        synchronized (this.lock) {
            if (this.globalDelegate != null) {
                z = false;
            } else {
                this.globalDelegate = delegate;
                z = true;
            }
        }
        return z;
    }

    public final boolean setDelegateForKey(K key, V delegate) {
        boolean z;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        synchronized (this.lock) {
            if (this.delegateMap.containsKey(key)) {
                z = false;
            } else {
                this.delegateMap.put(key, delegate);
                z = true;
            }
        }
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x000b, code lost:
    
        if (r3 == null) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final V resolveDelegate(K key) {
        V v;
        synchronized (this.lock) {
            if (key != null) {
                v = this.delegateMap.get(key);
            }
            v = this.globalDelegate;
        }
        return v;
    }
}
