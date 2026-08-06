package com.bytedance.android.monitorV2.settings;

import androidx.exifinterface.media.ExifInterface;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingsProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u00020\b\"\u0004\b\u0000\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u0005J!\u0010\u000b\u001a\u0004\u0018\u0001H\t\"\u0004\b\u0000\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u0005¢\u0006\u0002\u0010\fJ)\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u00052\b\u0010\u000f\u001a\u0004\u0018\u0001H\t¢\u0006\u0002\u0010\u0010J(\u0010\u0011\u001a\u00020\u000e\"\u0004\b\u0000\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\t0\u0006J\u0006\u0010\u0013\u001a\u00020\u000eJ\u001a\u0010\u0014\u001a\u00020\u000e\"\u0004\b\u0000\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u0005R\"\u0010\u0003\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/monitorV2/settings/SettingsProvider;", "", "()V", "providers", "", "Ljava/lang/Class;", "Lcom/bytedance/android/monitorV2/settings/IProvider;", "has", "", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "provideInstance", "(Ljava/lang/Class;)Ljava/lang/Object;", "registerHolder", "", "item", "(Ljava/lang/Class;Ljava/lang/Object;)V", "registerProvider", "provider", "removeAll", "removeProvider", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class SettingsProvider {
    private final Map<Class<?>, IProvider<?>> providers = new ConcurrentHashMap();

    public final <T> boolean has(Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return this.providers.containsKey(clazz);
    }

    public final <T> void registerProvider(Class<T> clazz, IProvider<? extends T> provider) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(provider, "provider");
        IProvider<? extends T> iProvider = (IProvider) this.providers.get(clazz);
        if (iProvider != null) {
            if (iProvider == provider) {
                iProvider = null;
            }
            if (iProvider != null) {
                iProvider.release();
            }
        }
        this.providers.put(clazz, provider);
    }

    public final <T> void registerHolder(Class<T> clazz, T item) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        registerProvider(clazz, new Holder(item));
    }

    public final <T> T provideInstance(Class<T> clazz) {
        Object provideInstance;
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        IProvider<?> iProvider = this.providers.get(clazz);
        if (iProvider == null || (provideInstance = iProvider.provideInstance()) == null) {
            return null;
        }
        if (!clazz.isAssignableFrom(provideInstance.getClass())) {
            provideInstance = null;
        }
        if (provideInstance != null) {
            return (T) provideInstance;
        }
        return null;
    }

    public final <T> void removeProvider(Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        IProvider<?> iProvider = this.providers.get(clazz);
        if (iProvider != null) {
            iProvider.release();
        }
        this.providers.remove(clazz);
    }

    public final void removeAll() {
        this.providers.clear();
    }
}
