package com.bytedance.sdk.xbridge.cn.registry.core.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IllegalInputParamException.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/registry/core/exception/IllegalInputParamException;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/exception/XBridgeException;", "message", "", "(Ljava/lang/String;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final class IllegalInputParamException extends XBridgeException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IllegalInputParamException(String message) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
