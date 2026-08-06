package com.bytedance.android.anniex.optimize.prehandle.intercept;

import androidx.core.app.NotificationCompat;
import com.bytedance.android.anniex.optimize.JSBPreHandleManager;
import com.bytedance.sdk.xbridge.cn.protocol.BridgeResultCallback;
import com.bytedance.sdk.xbridge.cn.protocol.IBridgeResultIntercept;
import com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: WebJSBResultIntercept.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J6\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/anniex/optimize/prehandle/intercept/WebJSBResultIntercept;", "Lcom/bytedance/sdk/xbridge/cn/protocol/IBridgeResultIntercept;", "Lorg/json/JSONObject;", "()V", "invokeCache", "", NotificationCompat.CATEGORY_CALL, "Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "bridge", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod;", "callBack", "Lcom/bytedance/sdk/xbridge/cn/protocol/BridgeResultCallback;", "resultIntercept", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class WebJSBResultIntercept implements IBridgeResultIntercept<JSONObject, JSONObject> {
    public boolean resultIntercept(IBDXBridgeContext bridgeContext) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        return JSBPreHandleManager.INSTANCE.allowUseCache(bridgeContext.getBridgeCall().getMethodName(), bridgeContext.getBridgeCall().getUrl());
    }

    public boolean invokeCache(BaseBridgeCall<JSONObject> call, IBDXBridgeContext bridgeContext, IDLXBridgeMethod bridge, BridgeResultCallback<JSONObject> callBack) {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(bridge, "bridge");
        Object preHandleResult = JSBPreHandleManager.INSTANCE.getPreHandleResult(bridgeContext.getContainerID(), call.getMethodName());
        if (preHandleResult == null) {
            return false;
        }
        if (callBack == null) {
            return true;
        }
        callBack.invoke((JSONObject) preHandleResult);
        return true;
    }
}
