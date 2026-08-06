package com.bytedance.ies.bullet.base.bridge;

import com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod;
import com.bytedance.ies.bullet.service.base.bridge.IGenericBridgeMethod;
import com.bytedance.ies.bullet.service.base.bridge.ILokiBridgeMethod;
import com.bytedance.ies.bullet.service.base.bridge.IStateBridgeMethod;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.protocol.StatefulMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IDLBridgeTransformer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ies/bullet/base/bridge/IDLBridgeTransformer;", "", "()V", "LokiBridge2IDLXBridgeMethod", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod;", "method", "Lcom/bytedance/ies/bullet/service/base/bridge/ILokiBridgeMethod;", "StateBridge2IDLXBridgeMethod", "Lcom/bytedance/ies/bullet/service/base/bridge/IStateBridgeMethod;", "bulletBridge2IDLXBridgeMethod", "Lcom/bytedance/ies/bullet/service/base/bridge/IBridgeMethod;", "oldXBridge2IDLXBridgeMethod", "Lcom/bytedance/ies/bullet/service/base/bridge/IGenericBridgeMethod;", "originXBridge2Xbridge3", "Lcom/bytedance/ies/xbridge/XBridgeMethod;", "xbridge2ToXBridge3", "Lcom/bytedance/ies/xbridge/IDLXBridgeMethod;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class IDLBridgeTransformer {
    public static final IDLBridgeTransformer INSTANCE = new IDLBridgeTransformer();

    private IDLBridgeTransformer() {
    }

    public final IDLXBridgeMethod StateBridge2IDLXBridgeMethod(IStateBridgeMethod method) {
        Intrinsics.checkNotNullParameter(method, "method");
        if (method instanceof StatefulMethod) {
            return new IDLBridgeTransformer$StateBridge2IDLXBridgeMethod$1(method);
        }
        return new StateBridge2XBridge3(method);
    }

    public final IDLXBridgeMethod LokiBridge2IDLXBridgeMethod(ILokiBridgeMethod method) {
        Intrinsics.checkNotNullParameter(method, "method");
        if (method instanceof StatefulMethod) {
            return new IDLBridgeTransformer$LokiBridge2IDLXBridgeMethod$1(method);
        }
        return new LokiBridge2XBridge3(method);
    }

    public final IDLXBridgeMethod bulletBridge2IDLXBridgeMethod(IBridgeMethod method) {
        Intrinsics.checkNotNullParameter(method, "method");
        if (method instanceof StatefulMethod) {
            return new IDLBridgeTransformer$bulletBridge2IDLXBridgeMethod$1(method);
        }
        return new BulletBridge2XBridge3(method);
    }

    public final IDLXBridgeMethod originXBridge2Xbridge3(XBridgeMethod method) {
        Intrinsics.checkNotNullParameter(method, "method");
        if (method instanceof StatefulMethod) {
            return new IDLBridgeTransformer$originXBridge2Xbridge3$1(method);
        }
        return new OriginXBridge2XBridge3(method);
    }

    public final IDLXBridgeMethod xbridge2ToXBridge3(com.bytedance.ies.xbridge.IDLXBridgeMethod method) {
        Intrinsics.checkNotNullParameter(method, "method");
        if (method instanceof StatefulMethod) {
            return new IDLBridgeTransformer$xbridge2ToXBridge3$1(method);
        }
        return new XBridge2ToXBridge3(method);
    }

    public final IDLXBridgeMethod oldXBridge2IDLXBridgeMethod(IGenericBridgeMethod method) {
        Intrinsics.checkNotNullParameter(method, "method");
        return new IDLBridgeTransformer$oldXBridge2IDLXBridgeMethod$1(method);
    }
}
