package com.bytedance.sdk.xbridge.cn.protocol;

import com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BridgeCallInterceptor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J.\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006H\u0016R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/protocol/BaseBridgeCallInterceptor;", "INPUT", "OUTPUT", "Lcom/bytedance/sdk/xbridge/cn/protocol/IBridgeCallInterceptor;", "()V", "callBack", "Lcom/bytedance/sdk/xbridge/cn/protocol/IBridgeInterceptorCallback;", "getCallBack", "()Lcom/bytedance/sdk/xbridge/cn/protocol/IBridgeInterceptorCallback;", "setCallBack", "(Lcom/bytedance/sdk/xbridge/cn/protocol/IBridgeInterceptorCallback;)V", "intercept", "", "call", "Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class BaseBridgeCallInterceptor<INPUT, OUTPUT> implements IBridgeCallInterceptor<INPUT, OUTPUT> {
    private IBridgeInterceptorCallback<OUTPUT> callBack;

    @Override // com.bytedance.sdk.xbridge.cn.protocol.IBridgeCallInterceptor
    public boolean intercept(BaseBridgeCall<INPUT> call, IBDXBridgeContext bridgeContext, IBridgeInterceptorCallback<OUTPUT> callBack) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        return false;
    }

    public IBridgeInterceptorCallback<OUTPUT> getCallBack() {
        return this.callBack;
    }

    public void setCallBack(IBridgeInterceptorCallback<OUTPUT> iBridgeInterceptorCallback) {
        this.callBack = iBridgeInterceptorCallback;
    }
}
