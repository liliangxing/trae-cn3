package com.bytedance.sdk.xbridge.cn.registry.core;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MethodRepository.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010\r\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tJ\u001e\u0010\u0010\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u00110\u0011J\u0018\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R&\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/registry/core/MethodRepository;", "", "initialCapacity", "", "(I)V", "getInitialCapacity", "()I", "instanceCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod;", "clear", "", "get", "bizId", "methodName", "getAllMethods", "", "put", "method", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public class MethodRepository {
    private final int initialCapacity;
    private final ConcurrentHashMap<String, ConcurrentHashMap<String, IDLXBridgeMethod>> instanceCache = new ConcurrentHashMap<>();

    public MethodRepository(int i) {
        this.initialCapacity = i;
    }

    public final int getInitialCapacity() {
        return this.initialCapacity;
    }

    public static /* synthetic */ void put$default(MethodRepository methodRepository, String str, IDLXBridgeMethod iDLXBridgeMethod, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: put");
        }
        if ((i & 1) != 0) {
            str = "";
        }
        methodRepository.put(str, iDLXBridgeMethod);
    }

    public final void put(String bizId, IDLXBridgeMethod method) {
        Intrinsics.checkNotNullParameter(bizId, "bizId");
        Intrinsics.checkNotNullParameter(method, "method");
        String name = method.getName();
        ConcurrentHashMap<String, IDLXBridgeMethod> concurrentHashMap = this.instanceCache.get(bizId);
        boolean z = false;
        if (concurrentHashMap != null && concurrentHashMap.containsKey(name)) {
            z = true;
        }
        if (z) {
            return;
        }
        if (!method.getCompatibility().getValue()) {
            XBridgeAnnotationCache.cacheBridgeAnnotation(method.getClass());
        }
        if (concurrentHashMap == null) {
            this.instanceCache.put(bizId, new ConcurrentHashMap<>(this.initialCapacity));
        }
        ConcurrentHashMap<String, IDLXBridgeMethod> concurrentHashMap2 = this.instanceCache.get(bizId);
        if (concurrentHashMap2 != null) {
            concurrentHashMap2.put(name, method);
        }
    }

    public static /* synthetic */ IDLXBridgeMethod get$default(MethodRepository methodRepository, String str, String str2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: get");
        }
        if ((i & 1) != 0) {
            str = "";
        }
        return methodRepository.get(str, str2);
    }

    public final IDLXBridgeMethod get(String bizId, String methodName) {
        Intrinsics.checkNotNullParameter(bizId, "bizId");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        ConcurrentHashMap<String, IDLXBridgeMethod> concurrentHashMap = this.instanceCache.get(bizId);
        boolean z = false;
        if (concurrentHashMap != null && concurrentHashMap.containsKey(methodName)) {
            z = true;
        }
        if (z) {
            return concurrentHashMap.get(methodName);
        }
        return null;
    }

    public final Map<String, Map<String, IDLXBridgeMethod>> getAllMethods() {
        return this.instanceCache;
    }

    public final void clear() {
        this.instanceCache.clear();
    }
}
