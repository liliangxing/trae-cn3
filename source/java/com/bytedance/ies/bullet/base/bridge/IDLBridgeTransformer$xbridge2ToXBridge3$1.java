package com.bytedance.ies.bullet.base.bridge;

import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.xbridge.IDLXBridgeMethod;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.ies.xbridge.model.context.XContextProviderFactory;
import com.bytedance.sdk.xbridge.cn.protocol.StatefulMethod;
import kotlin.Metadata;

/* compiled from: IDLBridgeTransformer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"com/bytedance/ies/bullet/base/bridge/IDLBridgeTransformer$xbridge2ToXBridge3$1", "Lcom/bytedance/ies/bullet/base/bridge/XBridge2ToXBridge3;", "Lcom/bytedance/sdk/xbridge/cn/protocol/StatefulMethod;", "release", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class IDLBridgeTransformer$xbridge2ToXBridge3$1 extends XBridge2ToXBridge3 implements StatefulMethod {
    final /* synthetic */ IDLXBridgeMethod $method;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IDLBridgeTransformer$xbridge2ToXBridge3$1(IDLXBridgeMethod iDLXBridgeMethod) {
        super(iDLXBridgeMethod);
        this.$method = iDLXBridgeMethod;
    }

    public void release() {
        XContextProviderFactory contextProviderFactory;
        if (IConditionCallKt.enableBridgeProviderRelease()) {
            IDLXBridgeMethod iDLXBridgeMethod = this.$method;
            XCoreIDLBridgeMethod xCoreIDLBridgeMethod = iDLXBridgeMethod instanceof XCoreIDLBridgeMethod ? (XCoreIDLBridgeMethod) iDLXBridgeMethod : null;
            if (xCoreIDLBridgeMethod != null && (contextProviderFactory = xCoreIDLBridgeMethod.getContextProviderFactory()) != null) {
                contextProviderFactory.removeAll();
            }
            this.$method.setProviderFactory(null);
        }
        this.$method.release();
    }
}
