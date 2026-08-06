package com.bytedance.trae.keva;

import androidx.exifinterface.media.ExifInterface;
import java.util.HashSet;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Unit;

/* compiled from: SyncWeakListenerRegister.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\fJ\u0015\u0010\r\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\fJ\u001d\u0010\u000e\u001a\u0016\u0012\u000e\u0012\f\b\u0002 \u0010*\u0004\u0018\u00018\u00008\u00000\u000fj\u0002`\u0011ø\u0001\u0000J\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0013H\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b9¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/keva/SyncWeakListenerRegister;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "lock", "", "listeners", "Ljava/util/WeakHashMap;", "registerListener", "", "l", "(Ljava/lang/Object;)V", "unregisterListener", "getListeners", "Ljava/util/HashSet;", "kotlin.jvm.PlatformType", "Lkotlin/collections/HashSet;", "getListenerSize", "", "onListenerCountChanged", "size", "keva_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class SyncWeakListenerRegister<T> {
    private final byte[] lock = new byte[0];
    private final WeakHashMap<T, Object> listeners = new WeakHashMap<>();

    protected void onListenerCountChanged(int size) {
    }

    public final void registerListener(T l) {
        if (l != null) {
            synchronized (this.lock) {
                if (this.listeners.put(l, this.lock) == null) {
                    onListenerCountChanged(this.listeners.size());
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void unregisterListener(T l) {
        if (l != null) {
            synchronized (this.lock) {
                this.listeners.remove(l, this.lock);
                onListenerCountChanged(this.listeners.size());
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final HashSet<T> getListeners() {
        HashSet<T> hashSet;
        synchronized (this.lock) {
            hashSet = new HashSet<>(this.listeners.keySet());
        }
        return hashSet;
    }

    public final int getListenerSize() {
        int size;
        synchronized (this.lock) {
            size = this.listeners.size();
        }
        return size;
    }
}
