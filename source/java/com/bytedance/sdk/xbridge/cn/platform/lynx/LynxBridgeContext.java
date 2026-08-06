package com.bytedance.sdk.xbridge.cn.platform.lynx;

import android.view.View;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.sdk.xbridge.cn.registry.core.BaseBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.service.JSEventDelegate;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.TemplateData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LynxBridgeContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/platform/lynx/LynxBridgeContext;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/BaseBDXBridgeContext;", "containerID", "", "view", "Lcom/lynx/tasm/LynxView;", "jsEventDelegate", "Lcom/bytedance/sdk/xbridge/cn/service/JSEventDelegate;", LynxBridgeCall.NAME_SPACE, "platformType", "Lcom/bytedance/sdk/xbridge/cn/PlatformType;", "(Ljava/lang/String;Lcom/lynx/tasm/LynxView;Lcom/bytedance/sdk/xbridge/cn/service/JSEventDelegate;Ljava/lang/String;Lcom/bytedance/sdk/xbridge/cn/PlatformType;)V", "getJsEventDelegate", "()Lcom/bytedance/sdk/xbridge/cn/service/JSEventDelegate;", "getPlatformType", "()Lcom/bytedance/sdk/xbridge/cn/PlatformType;", "getLynxView", "sendGlobalEvent", "", "name", "params", "Lcom/lynx/react/bridge/JavaOnlyArray;", "updateData", "templateData", "Lcom/lynx/tasm/TemplateData;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class LynxBridgeContext extends BaseBDXBridgeContext {
    private final JSEventDelegate jsEventDelegate;
    private final PlatformType platformType;
    private final LynxView view;

    public /* synthetic */ LynxBridgeContext(String str, LynxView lynxView, JSEventDelegate jSEventDelegate, String str2, PlatformType platformType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, lynxView, jSEventDelegate, (i & 8) != 0 ? "" : str2, (i & 16) != 0 ? PlatformType.LYNX : platformType);
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public JSEventDelegate getJsEventDelegate() {
        return this.jsEventDelegate;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public PlatformType getPlatformType() {
        return this.platformType;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LynxBridgeContext(String str, LynxView lynxView, JSEventDelegate jSEventDelegate, String str2, PlatformType platformType) {
        super(str, (View) lynxView, str2);
        Intrinsics.checkNotNullParameter(str, "containerID");
        Intrinsics.checkNotNullParameter(lynxView, "view");
        Intrinsics.checkNotNullParameter(jSEventDelegate, "jsEventDelegate");
        Intrinsics.checkNotNullParameter(str2, LynxBridgeCall.NAME_SPACE);
        Intrinsics.checkNotNullParameter(platformType, "platformType");
        this.view = lynxView;
        this.jsEventDelegate = jSEventDelegate;
        this.platformType = platformType;
    }

    public final LynxView getLynxView() {
        return getEngineView();
    }

    public final void updateData(TemplateData templateData) {
        Intrinsics.checkNotNullParameter(templateData, "templateData");
        this.view.updateData(templateData);
    }

    public final void sendGlobalEvent(String name, JavaOnlyArray params) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(params, "params");
        this.view.sendGlobalEvent(name, params);
    }
}
