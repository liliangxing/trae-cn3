package com.bytedance.sdk.xbridge.cn.platform.lynx;

import android.content.Context;
import com.bytedance.sdk.xbridge.cn.BidConstants;
import com.bytedance.sdk.xbridge.cn.optimize.OptimizeConfigKt;
import com.lynx.jsbridge.LynxMethod;
import com.lynx.jsbridge.LynxModule;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XBridgeLynxModule.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/platform/lynx/XBridgeLynxModule;", "Lcom/lynx/jsbridge/LynxModule;", "androidContext", "Landroid/content/Context;", "bdxBridge", "", "(Landroid/content/Context;Ljava/lang/Object;)V", "getAndroidContext", "()Landroid/content/Context;", "getBdxBridge", "()Ljava/lang/Object;", "call", "", "bridgeName", "", "params", "Lcom/lynx/react/bridge/ReadableMap;", "callback", "Lcom/lynx/react/bridge/Callback;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XBridgeLynxModule extends LynxModule {
    public static final String NAME = "bridge";
    private final Context androidContext;
    private final Object bdxBridge;

    public final Context getAndroidContext() {
        return this.androidContext;
    }

    public final Object getBdxBridge() {
        return this.bdxBridge;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XBridgeLynxModule(Context context, Object obj) {
        super(context, obj);
        Intrinsics.checkNotNullParameter(context, "androidContext");
        Intrinsics.checkNotNullParameter(obj, "bdxBridge");
        this.androidContext = context;
        this.bdxBridge = obj;
    }

    @LynxMethod
    public final void call(String bridgeName, ReadableMap params, Callback callback) {
        String str;
        Intrinsics.checkNotNullParameter(bridgeName, "bridgeName");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Object obj = this.bdxBridge;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBDXBridge");
        LynxBDXBridge lynxBDXBridge = (LynxBDXBridge) obj;
        lynxBDXBridge.executeDelayInitBlock$anniex_release();
        LynxView lynxView = lynxBDXBridge.getLynxBridgeContext().getLynxView();
        if (lynxView == null || (str = lynxView.getTemplateUrl()) == null) {
            str = "";
        }
        LynxBridgeCall lynxBridgeCall = new LynxBridgeCall(bridgeName, params, str);
        if ((Intrinsics.areEqual(((LynxBDXBridge) this.bdxBridge).getNamespace(), "webcast") && Intrinsics.areEqual(((LynxBDXBridge) this.bdxBridge).getSettings(OptimizeConfigKt.getMIX_JSB_OPT_SWITCH()), true)) || ((LynxBDXBridge) this.bdxBridge).isThreadOptEnable()) {
            LynxBridgeCall lynxBridgeCall2 = lynxBridgeCall;
            ((LynxBDXBridge) this.bdxBridge).handleCallV2(lynxBridgeCall2, new LynxIDLCallbackWrapper(callback, lynxBridgeCall2, lynxBDXBridge.getLynxBridgeContext()));
        } else if ((Intrinsics.areEqual(((LynxBDXBridge) this.bdxBridge).getNamespace(), BidConstants.LOKI) && Intrinsics.areEqual(((LynxBDXBridge) this.bdxBridge).getSettings(OptimizeConfigKt.getLOKI_JSB_OPT_SWITCH()), true)) || ((LynxBDXBridge) this.bdxBridge).isThreadOptEnable()) {
            LynxBridgeCall lynxBridgeCall3 = lynxBridgeCall;
            ((LynxBDXBridge) this.bdxBridge).handleCallV2(lynxBridgeCall3, new LynxIDLCallbackWrapper(callback, lynxBridgeCall3, lynxBDXBridge.getLynxBridgeContext()));
        } else {
            LynxBridgeCall lynxBridgeCall4 = lynxBridgeCall;
            ((LynxBDXBridge) this.bdxBridge).handleCall(lynxBridgeCall4, new LynxIDLCallbackWrapper(callback, lynxBridgeCall4, lynxBDXBridge.getLynxBridgeContext()));
        }
    }
}
