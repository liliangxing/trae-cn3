package com.bytedance.sdk.xbridge.cn.registry.core;

import android.app.Activity;
import android.view.View;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBridgeCall;
import com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall;
import com.bytedance.sdk.xbridge.cn.service.JSEventDelegate;
import com.bytedance.sdk.xbridge.cn.utils.XBridgeInjectLogger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IBDXBridgeContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J#\u0010!\u001a\u0004\u0018\u0001H\"\"\u0004\b\u0000\u0010\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H\"0$H\u0016¢\u0006\u0002\u0010%J(\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\n2\u0016\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010+\u0018\u00010*H\u0016R\u0018\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0014\u0010\u0013\u001a\u00020\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\fR\u0014\u0010\u0019\u001a\u00020\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006,"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/registry/core/BridgeCallContext;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "containerContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/BaseBDXBridgeContext;", "bridgeCall", "Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;", "(Lcom/bytedance/sdk/xbridge/cn/registry/core/BaseBDXBridgeContext;Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;)V", "getBridgeCall", "()Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;", XBridgeInjectLogger.CALL_ID, "", "getCallId", "()Ljava/lang/String;", "setCallId", "(Ljava/lang/String;)V", "getContainerContext", "()Lcom/bytedance/sdk/xbridge/cn/registry/core/BaseBDXBridgeContext;", "containerID", "getContainerID", "jsEventDelegate", "Lcom/bytedance/sdk/xbridge/cn/service/JSEventDelegate;", "getJsEventDelegate", "()Lcom/bytedance/sdk/xbridge/cn/service/JSEventDelegate;", LynxBridgeCall.NAME_SPACE, "getNamespace", "platformType", "Lcom/bytedance/sdk/xbridge/cn/PlatformType;", "getPlatformType", "()Lcom/bytedance/sdk/xbridge/cn/PlatformType;", "getEngineView", "Landroid/view/View;", "getOwnerActivity", "Landroid/app/Activity;", "getService", "T", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "sendEvent", "", "eventName", "params", "", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BridgeCallContext implements IBDXBridgeContext {
    private final BaseBridgeCall<?> bridgeCall;
    private String callId;
    private final BaseBDXBridgeContext containerContext;
    private final String containerID;
    private final JSEventDelegate jsEventDelegate;
    private final String namespace;
    private final PlatformType platformType;

    public BridgeCallContext(BaseBDXBridgeContext baseBDXBridgeContext, BaseBridgeCall<?> baseBridgeCall) {
        Intrinsics.checkNotNullParameter(baseBDXBridgeContext, "containerContext");
        Intrinsics.checkNotNullParameter(baseBridgeCall, "bridgeCall");
        this.containerContext = baseBDXBridgeContext;
        this.bridgeCall = baseBridgeCall;
        this.containerID = baseBDXBridgeContext.getContainerID();
        this.namespace = baseBDXBridgeContext.getNamespace();
        this.platformType = baseBDXBridgeContext.getPlatformType();
        this.jsEventDelegate = baseBDXBridgeContext.getJsEventDelegate();
        this.callId = getBridgeCall().getId();
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext
    public BaseBridgeCall<?> getBridgeCall() {
        return this.bridgeCall;
    }

    public final BaseBDXBridgeContext getContainerContext() {
        return this.containerContext;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public String getContainerID() {
        return this.containerID;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public String getNamespace() {
        return this.namespace;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public PlatformType getPlatformType() {
        return this.platformType;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public JSEventDelegate getJsEventDelegate() {
        return this.jsEventDelegate;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext
    public String getCallId() {
        return this.callId;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext
    public void setCallId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.callId = str;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public <T> T getService(Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return (T) this.containerContext.getService(clazz);
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public View getEngineView() {
        return this.containerContext.getEngineView();
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public Activity getOwnerActivity() {
        return this.containerContext.getOwnerActivity();
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public void sendEvent(String eventName, Map<String, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        this.containerContext.sendEvent(eventName, params);
    }
}
