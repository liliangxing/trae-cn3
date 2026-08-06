package com.bytedance.ies.bullet.service.base.impl;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ies.bullet.service.base.api.IDependencyProvider;
import com.bytedance.ies.bullet.service.base.api.IInstanceProvider;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultDependencyProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J#\u0010\u0007\u001a\u0004\u0018\u0001H\b\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u0005H\u0016¢\u0006\u0002\u0010\nJ\u001a\u0010\u000b\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0006\u0012\u0004\u0018\u00010\r0\fH\u0016J+\u0010\u000e\u001a\u00020\u000f\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u00052\b\u0010\u0010\u001a\u0004\u0018\u0001H\bH\u0016¢\u0006\u0002\u0010\u0011R\"\u0010\u0003\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/impl/DefaultDependencyProvider;", "Lcom/bytedance/ies/bullet/service/base/api/IDependencyProvider;", "()V", "providers", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/lang/Class;", "Lcom/bytedance/ies/bullet/service/base/api/IInstanceProvider;", "get", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "(Ljava/lang/Class;)Ljava/lang/Object;", "getAll", "", "", "put", "", "instance", "(Ljava/lang/Class;Ljava/lang/Object;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class DefaultDependencyProvider implements IDependencyProvider {
    private final ConcurrentHashMap<Class<?>, IInstanceProvider<?>> providers = new ConcurrentHashMap<>();

    @Override // com.bytedance.ies.bullet.service.base.api.IDependencyProvider
    public <T> void put(Class<T> clazz, T instance) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        if (instance != null) {
            this.providers.put(clazz, new DefaultInstanceProvider(instance));
        }
    }

    @Override // com.bytedance.ies.bullet.service.base.api.IDependencyProvider
    public <T> T get(Class<T> clazz) {
        Object provideInstance;
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        IInstanceProvider<?> iInstanceProvider = this.providers.get(clazz);
        if (iInstanceProvider == null || (provideInstance = iInstanceProvider.provideInstance()) == null) {
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

    @Override // com.bytedance.ies.bullet.service.base.api.IDependencyProvider
    public Map<Class<?>, Object> getAll() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (Map.Entry<Class<?>, IInstanceProvider<?>> entry : this.providers.entrySet()) {
            concurrentHashMap.put(entry.getKey(), entry.getValue().provideInstance());
        }
        return concurrentHashMap;
    }
}
