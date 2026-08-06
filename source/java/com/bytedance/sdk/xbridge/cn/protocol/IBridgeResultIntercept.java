package com.bytedance.sdk.xbridge.cn.protocol;

import com.bytedance.sdk.xbridge.cn.platform.lynx.XBridgeLynxModule;
import com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import kotlin.Metadata;

/* compiled from: BridgeCallInterceptor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003J6\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\rH&J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/protocol/IBridgeResultIntercept;", "INPUT", "OUTPUT", "", "invokeCache", "", "call", "Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", XBridgeLynxModule.NAME, "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod;", "callBack", "Lcom/bytedance/sdk/xbridge/cn/protocol/BridgeResultCallback;", "resultIntercept", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IBridgeResultIntercept<INPUT, OUTPUT> {
    boolean invokeCache(BaseBridgeCall<INPUT> call, IBDXBridgeContext bridgeContext, IDLXBridgeMethod bridge, BridgeResultCallback<OUTPUT> callBack);

    boolean resultIntercept(IBDXBridgeContext bridgeContext);
}
