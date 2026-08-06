package com.bytedance.sdk.xbridge.cn.protocol;

import android.util.Log;
import com.bytedance.sdk.xbridge.annotations.NamespaceValidator;
import com.bytedance.sdk.xbridge.cn.auth.respository.PermissionConfigParser;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBridgeCall;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XBridge3MethodFinder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u001e\u0010\u000e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J \u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00042\u0006\u0010\r\u001a\u00020\u0005H\u0002J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005J\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0016R7\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00040\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/protocol/XBridge3MethodFinder;", "Lcom/bytedance/sdk/xbridge/cn/protocol/MethodFinder;", "()V", "creatorClassCacheWithBiz", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/lang/Class;", "getCreatorClassCacheWithBiz", "()Ljava/util/concurrent/ConcurrentHashMap;", "creatorClassCacheWithBiz$delegate", "Lkotlin/Lazy;", "canLoadWithBiz", "", "bizId", "findCreatorClassWithCache", LynxBridgeCall.NAME_SPACE, "methodName", "getCreatorClassCache", "getPrefix", "loadMethod", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod;", "loadMethodInternal", "loadMethodWithNamespace", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XBridge3MethodFinder extends MethodFinder {
    private static final String METHOD_CREATE = "create";

    /* renamed from: creatorClassCacheWithBiz$delegate, reason: from kotlin metadata */
    private final Lazy creatorClassCacheWithBiz = LazyKt.lazy(new Function0<ConcurrentHashMap<String, ConcurrentHashMap<String, Class<?>>>>() { // from class: com.bytedance.sdk.xbridge.cn.protocol.XBridge3MethodFinder$creatorClassCacheWithBiz$2
        public final ConcurrentHashMap<String, ConcurrentHashMap<String, Class<?>>> invoke() {
            return new ConcurrentHashMap<>();
        }
    });

    @Override // com.bytedance.sdk.xbridge.cn.protocol.MethodFinder
    public String getPrefix() {
        return "xbridge3";
    }

    private final ConcurrentHashMap<String, ConcurrentHashMap<String, Class<?>>> getCreatorClassCacheWithBiz() {
        return (ConcurrentHashMap) this.creatorClassCacheWithBiz.getValue();
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.MethodFinder
    public boolean canLoadWithBiz(String bizId) {
        Intrinsics.checkNotNullParameter(bizId, "bizId");
        if (Intrinsics.areEqual("webcast", bizId) || Intrinsics.areEqual(PermissionConfigParser.WEBCAST_HOST_NAMESPACE, bizId)) {
            return true;
        }
        return NamespaceValidator.validate(bizId);
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.MethodFinder
    public IDLXBridgeMethod loadMethodWithNamespace(String namespace, String methodName) {
        Intrinsics.checkNotNullParameter(namespace, LynxBridgeCall.NAME_SPACE);
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        if (Intrinsics.areEqual("webcast", namespace) || Intrinsics.areEqual(PermissionConfigParser.WEBCAST_HOST_NAMESPACE, namespace)) {
            return loadMethodInternal("", methodName);
        }
        return loadMethodInternal(namespace, methodName);
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.MethodFinder
    public IDLXBridgeMethod loadMethod(String methodName) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        return loadMethodInternal("", methodName);
    }

    public final IDLXBridgeMethod loadMethodInternal(String namespace, String methodName) {
        Intrinsics.checkNotNullParameter(namespace, LynxBridgeCall.NAME_SPACE);
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        try {
            Class<?> findCreatorClassWithCache = findCreatorClassWithCache(namespace, methodName);
            if (findCreatorClassWithCache == null) {
                return null;
            }
            Method declaredMethod = findCreatorClassWithCache.getDeclaredMethod(METHOD_CREATE, new Class[0]);
            declaredMethod.setAccessible(true);
            return (IDLXBridgeMethod) declaredMethod.invoke(null, new Object[0]);
        } catch (Throwable unused) {
            Log.e("XBridge3MethodFinder", "### Load method by reflect failed, method name: " + methodName);
            return null;
        }
    }

    private final ConcurrentHashMap<String, Class<?>> getCreatorClassCache(String bizId) {
        if (getCreatorClassCacheWithBiz().get(bizId) == null) {
            ConcurrentHashMap<String, Class<?>> concurrentHashMap = new ConcurrentHashMap<>(100);
            getCreatorClassCacheWithBiz().put(bizId, concurrentHashMap);
            return concurrentHashMap;
        }
        ConcurrentHashMap<String, Class<?>> concurrentHashMap2 = getCreatorClassCacheWithBiz().get(bizId);
        Intrinsics.checkNotNull(concurrentHashMap2);
        return concurrentHashMap2;
    }

    private final Class<?> findCreatorClassWithCache(String namespace, String methodName) {
        String findXBridge3CreatorByNameSpaceAndMethodName;
        ConcurrentHashMap<String, Class<?>> creatorClassCache = getCreatorClassCache(namespace);
        Class<?> cls = creatorClassCache.get(methodName);
        if (cls == null) {
            String str = namespace;
            if (str == null || str.length() == 0) {
                findXBridge3CreatorByNameSpaceAndMethodName = APTContract.findCreatorByMethodName(methodName, getPrefix());
            } else {
                findXBridge3CreatorByNameSpaceAndMethodName = APTContract.findXBridge3CreatorByNameSpaceAndMethodName(namespace, methodName);
            }
            try {
                Class<?> cls2 = Class.forName(findXBridge3CreatorByNameSpaceAndMethodName);
                Intrinsics.checkNotNullExpressionValue(cls2, "creatorClassLoaded");
                creatorClassCache.put(methodName, cls2);
                return cls2;
            } catch (Throwable unused) {
                creatorClassCache.put(methodName, MethodFinder.INSTANCE.getLOAD_FAILED_CLASS());
                Log.e("MethodFinder", getPrefix() + " creator class load failed: " + methodName);
                return null;
            }
        }
        if (Intrinsics.areEqual(cls, MethodFinder.INSTANCE.getLOAD_FAILED_CLASS())) {
            return null;
        }
        return cls;
    }
}
