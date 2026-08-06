package com.bytedance.ies.bullet.base.bridge;

import android.util.Log;
import com.bytedance.ies.bullet.core.kit.bridge.BridgeMethod;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.kit.web.jsbridge.JSB4Support;
import com.bytedance.sdk.xbridge.cn.protocol.MethodFinder;
import com.bytedance.sdk.xbridge.cn.protocol.StatefulMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BDXCompatMethodFinder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/bullet/base/bridge/BulletMethodFinder;", "Lcom/bytedance/sdk/xbridge/cn/protocol/MethodFinder;", "contextProviderFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "(Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;)V", "getContextProviderFactory", "()Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "getPrefix", "", "loadMethod", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod;", "methodName", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BulletMethodFinder extends MethodFinder {
    private final ContextProviderFactory contextProviderFactory;

    public String getPrefix() {
        return "bullet";
    }

    public BulletMethodFinder(ContextProviderFactory contextProviderFactory) {
        Intrinsics.checkNotNullParameter(contextProviderFactory, "contextProviderFactory");
        this.contextProviderFactory = contextProviderFactory;
    }

    public final ContextProviderFactory getContextProviderFactory() {
        return this.contextProviderFactory;
    }

    public IDLXBridgeMethod loadMethod(String methodName) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        try {
            Class findCreatorClass = findCreatorClass(methodName);
            if (findCreatorClass == null) {
                return null;
            }
            Method declaredMethod = findCreatorClass.getDeclaredMethod("create", ContextProviderFactory.class);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, this.contextProviderFactory);
            Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type com.bytedance.ies.bullet.core.kit.bridge.BridgeMethod");
            BridgeMethod bridgeMethod = (BridgeMethod) invoke;
            if (!(bridgeMethod instanceof StatefulMethod)) {
                bridgeMethod.setContextProviderFactory(new ContextProviderFactory());
            }
            return IDLBridgeTransformer.INSTANCE.bulletBridge2IDLXBridgeMethod(bridgeMethod);
        } catch (Throwable unused) {
            Log.e(JSB4Support.BRIDGE_OBJECT_NAME, "bullet method find failed: " + methodName);
            return null;
        }
    }
}
