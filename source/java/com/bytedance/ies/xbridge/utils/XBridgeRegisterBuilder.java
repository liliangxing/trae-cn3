package com.bytedance.ies.xbridge.utils;

import com.bytedance.ies.xbridge.IDLXBridgeMethod;
import com.bytedance.ies.xbridge.IDLXBridgeMethodProvider;
import com.bytedance.ies.xbridge.XBridge;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgeMethodProvider;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XBridgeRegister;
import com.bytedance.ies.xbridge.model.context.XContextProviderFactory;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XBridgeRegisterBuilder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/xbridge/utils/XBridgeRegisterBuilder;", "", "()V", "build", "Lcom/bytedance/ies/xbridge/XBridgeRegister;", "contextProviderFactory", "Lcom/bytedance/ies/xbridge/model/context/XContextProviderFactory;", "platform", "Lcom/bytedance/ies/xbridge/XBridgePlatformType;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class XBridgeRegisterBuilder {
    public static final XBridgeRegisterBuilder INSTANCE = new XBridgeRegisterBuilder();

    private XBridgeRegisterBuilder() {
    }

    @JvmStatic
    public static final XBridgeRegister build(final XContextProviderFactory contextProviderFactory, XBridgePlatformType platform) {
        Intrinsics.checkNotNullParameter(platform, "platform");
        XBridgeRegister xBridgeRegister = new XBridgeRegister();
        Map methodList$default = XBridge.getMethodList$default(XBridge.INSTANCE, platform, null, 2, null);
        if (methodList$default != null) {
            for (final Map.Entry entry : methodList$default.entrySet()) {
                xBridgeRegister.registerMethod((String) entry.getKey(), new XBridgeMethodProvider() { // from class: com.bytedance.ies.xbridge.utils.XBridgeRegisterBuilder$build$1$1$1
                    @Override // com.bytedance.ies.xbridge.XBridgeMethodProvider
                    public XBridgeMethod provideMethod() {
                        XBridgeMethod newInstance = entry.getValue().newInstance();
                        newInstance.setProviderFactory(contextProviderFactory);
                        Intrinsics.checkNotNullExpressionValue(newInstance, "bridgeMethod");
                        return newInstance;
                    }
                });
            }
        }
        Map iDLMethodList$default = XBridge.getIDLMethodList$default(platform, null, 2, null);
        if (iDLMethodList$default != null) {
            for (final Map.Entry entry2 : iDLMethodList$default.entrySet()) {
                xBridgeRegister.registerMethod((String) entry2.getKey(), new IDLXBridgeMethodProvider() { // from class: com.bytedance.ies.xbridge.utils.XBridgeRegisterBuilder$build$1$2$1
                    @Override // com.bytedance.ies.xbridge.IDLXBridgeMethodProvider
                    public IDLXBridgeMethod provideMethod() {
                        IDLXBridgeMethod newInstance = entry2.getValue().newInstance();
                        newInstance.setProviderFactory(contextProviderFactory);
                        Intrinsics.checkNotNullExpressionValue(newInstance, "bridgeMethod");
                        return newInstance;
                    }
                });
            }
        }
        return xBridgeRegister;
    }
}
