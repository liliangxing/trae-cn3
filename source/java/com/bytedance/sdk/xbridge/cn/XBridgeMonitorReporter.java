package com.bytedance.sdk.xbridge.cn;

import com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import kotlin.Metadata;

/* compiled from: XBridge.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/XBridgeMonitorReporter;", "", "report", "", "call", "Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;", "context", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public interface XBridgeMonitorReporter {
    void report(BaseBridgeCall<?> call, IBDXBridgeContext context);
}
