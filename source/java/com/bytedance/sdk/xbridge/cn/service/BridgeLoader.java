package com.bytedance.sdk.xbridge.cn.service;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import kotlin.Metadata;

/* compiled from: BridgeLoader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\"\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/service/BridgeLoader;", "", "findMethod", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod;", "bizId", "", "methodName", "sessionId", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public interface BridgeLoader {
    IDLXBridgeMethod findMethod(String bizId, String methodName);

    IDLXBridgeMethod findMethod(String bizId, String methodName, String sessionId);
}
