package com.bytedance.ies.bullet.core.model.context;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.ies.bullet.service.context.IContextProviderFactory;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContextProviderFactory.kt */
@Deprecated(level = DeprecationLevel.WARNING, message = "only for transmit data,not recommend for control bullet load")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\u0000J\"\u0010\b\u001a\n\u0012\u0004\u0012\u0002H\t\u0018\u00010\u0006\"\u0004\b\u0000\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u0005J\u001a\u0010\u000b\u001a\u00020\f\"\u0004\b\u0000\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u0005J\u0010\u0010\r\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u000eJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0000J!\u0010\u0012\u001a\u0004\u0018\u0001H\t\"\u0004\b\u0000\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u0005¢\u0006\u0002\u0010\u0013J)\u0010\u0014\u001a\u00020\u0010\"\u0004\b\u0000\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u00052\b\u0010\u0015\u001a\u0004\u0018\u0001H\t¢\u0006\u0002\u0010\u0016J*\u0010\u0017\u001a\u00020\u0010\"\u0004\b\u0000\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u00052\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\t0\u0019J(\u0010\u0017\u001a\u00020\u0010\"\u0004\b\u0000\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u00052\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\t0\u0006J)\u0010\u001a\u001a\u00020\u0010\"\u0004\b\u0000\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u00052\b\u0010\u0015\u001a\u0004\u0018\u0001H\t¢\u0006\u0002\u0010\u0016J\u0006\u0010\u001b\u001a\u00020\u0010J\u001a\u0010\u001c\u001a\u00020\u0010\"\u0004\b\u0000\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u0005R\"\u0010\u0003\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "Lcom/bytedance/ies/bullet/service/context/IContextProviderFactory;", "()V", "providers", "", "Ljava/lang/Class;", "Lcom/bytedance/ies/bullet/core/model/context/IContextProvider;", "copy", "getProvider", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "has", "", "keys", "", "merge", "", PreloadConfig.KEY_OTHER, "provideInstance", "(Ljava/lang/Class;)Ljava/lang/Object;", "registerHolder", "item", "(Ljava/lang/Class;Ljava/lang/Object;)V", "registerProvider", "provider", "Lkotlin/Function0;", "registerWeakHolder", "removeAll", "removeProvider", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class ContextProviderFactory implements IContextProviderFactory {
    private final Map<Class<?>, IContextProvider<?>> providers = new ConcurrentHashMap();

    public final <T> boolean has(Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return this.providers.containsKey(clazz);
    }

    public final <T> void registerProvider(Class<T> clazz, final Function0<? extends T> provider) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(provider, "provider");
        IContextProvider<?> iContextProvider = this.providers.get(clazz);
        if (iContextProvider != null) {
            iContextProvider.release();
        }
        this.providers.put(clazz, new IContextProvider<T>() { // from class: com.bytedance.ies.bullet.core.model.context.ContextProviderFactory$registerProvider$1
            @Override // com.bytedance.ies.bullet.service.base.IReleasable
            public void release() {
            }

            @Override // com.bytedance.ies.bullet.core.model.context.IContextProvider
            public T provideInstance() {
                return provider.invoke();
            }
        });
    }

    public final <T> void registerProvider(Class<T> clazz, IContextProvider<? extends T> provider) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(provider, "provider");
        IContextProvider<? extends T> iContextProvider = (IContextProvider) this.providers.get(clazz);
        if (iContextProvider != null) {
            if (iContextProvider == provider) {
                iContextProvider = null;
            }
            if (iContextProvider != null) {
                iContextProvider.release();
            }
        }
        this.providers.put(clazz, provider);
    }

    public final <T> void registerWeakHolder(Class<T> clazz, T item) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        registerProvider(clazz, new WeakContextHolder(item));
    }

    public final <T> void registerHolder(Class<T> clazz, T item) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        registerProvider(clazz, new ContextHolder(item));
    }

    public final <T> void removeProvider(Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        IContextProvider<?> iContextProvider = this.providers.get(clazz);
        if (iContextProvider != null) {
            iContextProvider.release();
        }
        this.providers.remove(clazz);
    }

    public final void removeAll() {
        this.providers.clear();
    }

    public final <T> IContextProvider<T> getProvider(Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        IContextProvider<T> iContextProvider = (IContextProvider) this.providers.get(clazz);
        if (iContextProvider != null) {
            return iContextProvider;
        }
        return null;
    }

    public final <T> T provideInstance(Class<T> clazz) {
        Object provideInstance;
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        IContextProvider<?> iContextProvider = this.providers.get(clazz);
        if (iContextProvider == null || (provideInstance = iContextProvider.provideInstance()) == null) {
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

    public final Iterable<Class<?>> keys() {
        return this.providers.keySet();
    }

    public final void merge(ContextProviderFactory other) {
        Intrinsics.checkNotNullParameter(other, "other");
        this.providers.putAll(other.providers);
    }

    public final ContextProviderFactory copy() {
        ContextProviderFactory contextProviderFactory = new ContextProviderFactory();
        contextProviderFactory.merge(this);
        return contextProviderFactory;
    }
}
