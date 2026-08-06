package com.bytedance.android.anniex.optimize.prehandle.intercept;

import androidx.core.app.NotificationCompat;
import com.bytedance.android.anniex.optimize.JSBPreHandleManager;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.sdk.xbridge.cn.protocol.BridgeResultCallback;
import com.bytedance.sdk.xbridge.cn.protocol.IBridgeResultIntercept;
import com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.lynx.react.bridge.ReadableMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LynxJSBResultIntercept.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J6\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/anniex/optimize/prehandle/intercept/LynxJSBResultInterceptL;", "Lcom/bytedance/sdk/xbridge/cn/protocol/IBridgeResultIntercept;", "Lcom/lynx/react/bridge/ReadableMap;", "", "()V", "invokeCache", "", NotificationCompat.CATEGORY_CALL, "Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "bridge", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod;", "callBack", "Lcom/bytedance/sdk/xbridge/cn/protocol/BridgeResultCallback;", "resultIntercept", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class LynxJSBResultInterceptL implements IBridgeResultIntercept<ReadableMap, Object> {
    public boolean resultIntercept(IBDXBridgeContext bridgeContext) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        return JSBPreHandleManager.INSTANCE.allowUseCache(bridgeContext.getBridgeCall().getMethodName(), bridgeContext.getBridgeCall().getUrl());
    }

    public boolean invokeCache(BaseBridgeCall<ReadableMap> call, IBDXBridgeContext bridgeContext, IDLXBridgeMethod bridge, BridgeResultCallback<Object> callBack) {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(bridge, "bridge");
        Object preHandleResult = JSBPreHandleManager.INSTANCE.getPreHandleResult(bridgeContext.getContainerID(), call.getMethodName());
        if (preHandleResult == null) {
            return false;
        }
        HybridLogger.i$default(HybridLogger.INSTANCE, "AnnieX", "jsb result invokeCache, method name: " + call.getMethodName(), (Map) null, (LoggerContext) null, 12, (Object) null);
        if (callBack == null) {
            return false;
        }
        callBack.invoke(preHandleResult);
        return false;
    }
}
