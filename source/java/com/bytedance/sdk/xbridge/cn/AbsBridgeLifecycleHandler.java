package com.bytedance.sdk.xbridge.cn;

import com.bytedance.sdk.xbridge.cn.protocol.BridgeResultCallback;
import com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XBridge.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0016J,\u0010\b\u001a\u00020\t2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\rH\u0016J\"\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00012\u0006\u0010\n\u001a\u00020\u0012H\u0016¨\u0006\u0013"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/AbsBridgeLifecycleHandler;", "", "()V", "onCallbackEnd", "", "call", "Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;", "result", "onHandleStart", "", "context", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "callback", "Lcom/bytedance/sdk/xbridge/cn/protocol/BridgeResultCallback;", "onSendEvent", "name", "", "data", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXContainerContext;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class AbsBridgeLifecycleHandler {
    public void onCallbackEnd(BaseBridgeCall<?> call, Object result) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public boolean onHandleStart(BaseBridgeCall<Object> call, IBDXBridgeContext context, BridgeResultCallback<Object> callback) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        return false;
    }

    public void onSendEvent(String name, Object data, IBDXContainerContext context) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
