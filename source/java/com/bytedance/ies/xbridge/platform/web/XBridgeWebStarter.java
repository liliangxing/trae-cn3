package com.bytedance.ies.xbridge.platform.web;

import com.bytedance.ies.xbridge.XBridge;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XBridgeRegister;
import com.bytedance.ies.xbridge.model.context.XContextProviderFactory;
import com.bytedance.ies.xbridge.platform.web.api.IH5JsBridge;
import com.bytedance.ies.xbridge.utils.XBridgeRegisterBuilder;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XBridgeWebStarter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/xbridge/platform/web/XBridgeWebStarter;", "", "()V", "registerXBridgeModuleBridge", "", "contextProviderFactory", "Lcom/bytedance/ies/xbridge/model/context/XContextProviderFactory;", "h5JsBridge", "Lcom/bytedance/ies/xbridge/platform/web/api/IH5JsBridge;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class XBridgeWebStarter {
    public static final XBridgeWebStarter INSTANCE = new XBridgeWebStarter();

    private XBridgeWebStarter() {
    }

    @JvmStatic
    public static final void registerXBridgeModuleBridge(XContextProviderFactory contextProviderFactory, IH5JsBridge h5JsBridge) {
        Intrinsics.checkNotNullParameter(h5JsBridge, "h5JsBridge");
        XBridgeRegister build = XBridgeRegisterBuilder.build(contextProviderFactory, XBridgePlatformType.WEB);
        WebPlatform webPlatform = (WebPlatform) XBridge.INSTANCE.getPlatform(WebPlatform.class);
        if (webPlatform != null) {
            webPlatform.adapt(h5JsBridge, build);
        }
    }
}
