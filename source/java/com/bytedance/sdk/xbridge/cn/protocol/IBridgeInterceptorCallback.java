package com.bytedance.sdk.xbridge.cn.protocol;

import kotlin.Metadata;

/* compiled from: BridgeCallInterceptor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0004H&¨\u0006\b"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/protocol/IBridgeInterceptorCallback;", "DATATYPE", "", "invokeJsCallback", "", "data", "(Ljava/lang/Object;)V", "invokeOrigin", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public interface IBridgeInterceptorCallback<DATATYPE> {
    void invokeJsCallback(DATATYPE data);

    void invokeOrigin();
}
