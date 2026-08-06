package com.bytedance.ies.bullet.base.bridge;

import com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod;
import com.bytedance.sdk.xbridge.cn.protocol.StatefulMethod;
import kotlin.Metadata;

/* compiled from: IDLBridgeTransformer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"com/bytedance/ies/bullet/base/bridge/IDLBridgeTransformer$bulletBridge2IDLXBridgeMethod$1", "Lcom/bytedance/ies/bullet/base/bridge/BulletBridge2XBridge3;", "Lcom/bytedance/sdk/xbridge/cn/protocol/StatefulMethod;", "release", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class IDLBridgeTransformer$bulletBridge2IDLXBridgeMethod$1 extends BulletBridge2XBridge3 implements StatefulMethod {
    final /* synthetic */ IBridgeMethod $method;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IDLBridgeTransformer$bulletBridge2IDLXBridgeMethod$1(IBridgeMethod iBridgeMethod) {
        super(iBridgeMethod);
        this.$method = iBridgeMethod;
    }

    public void release() {
        this.$method.release();
    }
}
