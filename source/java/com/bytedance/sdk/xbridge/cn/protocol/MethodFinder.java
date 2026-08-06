package com.bytedance.sdk.xbridge.cn.protocol;

import android.util.Log;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBridgeCall;
import com.bytedance.sdk.xbridge.cn.platform.web.protocol.JSB4Impl;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.MethodRepository;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MethodFinder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\u0014\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00062\u0006\u0010\u0014\u001a\u00020\u0005J\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0005H&J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0014\u001a\u00020\u0005H&J\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0016J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0016J\b\u0010\u001e\u001a\u00020\u001cH\u0016R+\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006 "}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/protocol/MethodFinder;", "", "()V", "creatorClassCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/lang/Class;", "getCreatorClassCache", "()Ljava/util/concurrent/ConcurrentHashMap;", "creatorClassCache$delegate", "Lkotlin/Lazy;", "statefulMethodCache", "Lcom/bytedance/sdk/xbridge/cn/protocol/StatefulMethodRepository;", "getStatefulMethodCache", "()Lcom/bytedance/sdk/xbridge/cn/protocol/StatefulMethodRepository;", "statefulMethodCache$delegate", "canLoadWithBiz", "", "bizId", "findCreatorClass", "methodName", "findMethod", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod;", "getPrefix", "loadMethod", "loadMethodWithNamespace", LynxBridgeCall.NAME_SPACE, "registerStatefulMethod", "", "method", "release", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class MethodFinder {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Class<Object> LOAD_FAILED_CLASS = Object.class;

    /* renamed from: creatorClassCache$delegate, reason: from kotlin metadata */
    private final Lazy creatorClassCache = LazyKt.lazy(new Function0<ConcurrentHashMap<String, Class<?>>>() { // from class: com.bytedance.sdk.xbridge.cn.protocol.MethodFinder$creatorClassCache$2
        public final ConcurrentHashMap<String, Class<?>> invoke() {
            return new ConcurrentHashMap<>(100);
        }
    });

    /* renamed from: statefulMethodCache$delegate, reason: from kotlin metadata */
    private final Lazy statefulMethodCache = LazyKt.lazy(new Function0<StatefulMethodRepository>() { // from class: com.bytedance.sdk.xbridge.cn.protocol.MethodFinder$statefulMethodCache$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final StatefulMethodRepository m912invoke() {
            return new StatefulMethodRepository();
        }
    });

    public boolean canLoadWithBiz(String bizId) {
        Intrinsics.checkNotNullParameter(bizId, "bizId");
        return true;
    }

    public abstract String getPrefix();

    public abstract IDLXBridgeMethod loadMethod(String methodName);

    /* compiled from: MethodFinder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/protocol/MethodFinder$Companion;", "", "()V", "LOAD_FAILED_CLASS", "Ljava/lang/Class;", "Ljava/lang/Object;", "getLOAD_FAILED_CLASS", "()Ljava/lang/Class;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Class<Object> getLOAD_FAILED_CLASS() {
            return MethodFinder.LOAD_FAILED_CLASS;
        }
    }

    private final ConcurrentHashMap<String, Class<?>> getCreatorClassCache() {
        return (ConcurrentHashMap) this.creatorClassCache.getValue();
    }

    protected final StatefulMethodRepository getStatefulMethodCache() {
        return (StatefulMethodRepository) this.statefulMethodCache.getValue();
    }

    public final void registerStatefulMethod(IDLXBridgeMethod method) {
        Intrinsics.checkNotNullParameter(method, "method");
        if (!(method instanceof StatefulMethod)) {
            Log.w(JSB4Impl.BRIDGE_OBJECT_NAME, "非stateful的bridge无法动态注册: " + method.getName());
        } else {
            MethodRepository.put$default(getStatefulMethodCache(), null, method, 1, null);
        }
    }

    public static /* synthetic */ IDLXBridgeMethod findMethod$default(MethodFinder methodFinder, String str, String str2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findMethod");
        }
        if ((i & 1) != 0) {
            str = "";
        }
        return methodFinder.findMethod(str, str2);
    }

    public IDLXBridgeMethod findMethod(String bizId, String methodName) {
        IDLXBridgeMethod loadMethodWithNamespace;
        Intrinsics.checkNotNullParameter(bizId, "bizId");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        IDLXBridgeMethod iDLXBridgeMethod = getStatefulMethodCache().get(bizId, methodName);
        if (iDLXBridgeMethod != null) {
            return iDLXBridgeMethod;
        }
        if (!canLoadWithBiz(bizId) || (loadMethodWithNamespace = loadMethodWithNamespace(bizId, methodName)) == null) {
            return null;
        }
        if (loadMethodWithNamespace instanceof StatefulMethod) {
            getStatefulMethodCache().put(bizId, loadMethodWithNamespace);
        } else {
            StatelessMethodRepository.INSTANCE.put(bizId, loadMethodWithNamespace);
        }
        return loadMethodWithNamespace;
    }

    public IDLXBridgeMethod loadMethodWithNamespace(String namespace, String methodName) {
        Intrinsics.checkNotNullParameter(namespace, LynxBridgeCall.NAME_SPACE);
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        return loadMethod(methodName);
    }

    public final Class<?> findCreatorClass(String methodName) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Class<?> cls = getCreatorClassCache().get(methodName);
        if (cls == null) {
            try {
                Class<?> cls2 = Class.forName(APTContract.findCreatorByMethodName(methodName, getPrefix()));
                ConcurrentHashMap<String, Class<?>> creatorClassCache = getCreatorClassCache();
                Intrinsics.checkNotNullExpressionValue(cls2, "creatorClassLoaded");
                creatorClassCache.put(methodName, cls2);
                return cls2;
            } catch (Throwable unused) {
                getCreatorClassCache().put(methodName, LOAD_FAILED_CLASS);
                Log.e("MethodFinder", getPrefix() + " creator class load failed: " + methodName);
                return null;
            }
        }
        if (Intrinsics.areEqual(cls, LOAD_FAILED_CLASS)) {
            return null;
        }
        return cls;
    }

    public void release() {
        getStatefulMethodCache().release();
    }
}
