package com.bytedance.ies.bullet.base.bridge;

import android.util.Log;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.model.context.XContextProviderFactory;
import com.bytedance.sdk.xbridge.cn.protocol.MethodFinder;
import com.bytedance.sdk.xbridge.cn.protocol.StatefulMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BDXCompatMethodFinder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ies/bullet/base/bridge/OriginXBridgeMethodFinder;", "Lcom/bytedance/sdk/xbridge/cn/protocol/MethodFinder;", "providerFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "(Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;)V", "contextProvider", "Lcom/bytedance/ies/xbridge/model/context/XContextProviderFactory;", "getProviderFactory", "()Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "getPrefix", "", "loadMethod", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod;", "methodName", "release", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class OriginXBridgeMethodFinder extends MethodFinder {
    private XContextProviderFactory contextProvider;
    private final ContextProviderFactory providerFactory;

    public String getPrefix() {
        return "xbridge";
    }

    public OriginXBridgeMethodFinder(ContextProviderFactory contextProviderFactory) {
        Intrinsics.checkNotNullParameter(contextProviderFactory, "providerFactory");
        this.providerFactory = contextProviderFactory;
    }

    public final ContextProviderFactory getProviderFactory() {
        return this.providerFactory;
    }

    public IDLXBridgeMethod loadMethod(String methodName) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        try {
            Class findCreatorClass = findCreatorClass(methodName);
            if (findCreatorClass == null) {
                return null;
            }
            Method declaredMethod = findCreatorClass.getDeclaredMethod("create", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type com.bytedance.ies.xbridge.XBridgeMethod");
            XBridgeMethod xBridgeMethod = (XBridgeMethod) invoke;
            if (xBridgeMethod instanceof StatefulMethod) {
                if (IConditionCallKt.enableXBridgeContextLeakFix()) {
                    if (this.contextProvider == null) {
                        this.contextProvider = BDXCompatMethodFinderKt.getXBridgeProviderFactory(this.providerFactory);
                    }
                    xBridgeMethod.setProviderFactory(this.contextProvider);
                } else {
                    xBridgeMethod.setProviderFactory(BDXCompatMethodFinderKt.getXBridgeProviderFactory(this.providerFactory));
                }
            } else {
                xBridgeMethod.setProviderFactory(new XContextProviderFactory());
            }
            return IDLBridgeTransformer.INSTANCE.originXBridge2Xbridge3(xBridgeMethod);
        } catch (Throwable unused) {
            Log.e("OXBridgeMethodFinder", "### Load method by reflect failed, method name: " + methodName);
            return null;
        }
    }

    public void release() {
        super.release();
        XContextProviderFactory xContextProviderFactory = this.contextProvider;
        if (xContextProviderFactory != null) {
            xContextProviderFactory.removeAll();
        }
        this.contextProvider = null;
    }
}
