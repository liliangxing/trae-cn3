package com.bytedance.sdk.xbridge.cn.registry.core;

import com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall;
import kotlin.Metadata;

/* compiled from: IBDXBridgeContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\u00020\u0007X¦\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXContainerContext;", "bridgeCall", "Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;", "getBridgeCall", "()Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;", "callId", "", "getCallId", "()Ljava/lang/String;", "setCallId", "(Ljava/lang/String;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public interface IBDXBridgeContext extends IBDXContainerContext {
    BaseBridgeCall<?> getBridgeCall();

    String getCallId();

    void setCallId(String str);
}
