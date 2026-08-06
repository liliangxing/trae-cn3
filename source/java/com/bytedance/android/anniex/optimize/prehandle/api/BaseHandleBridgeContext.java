package com.bytedance.android.anniex.optimize.prehandle.api;

import android.app.Activity;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.service.JSEventDelegate;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IPreHandleTask.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J#\u0010\u001d\u001a\u0004\u0018\u0001H\u001e\"\u0004\b\u0000\u0010\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u001e0 H\u0016¢\u0006\u0002\u0010!J(\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\b2\u0016\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010'\u0018\u00010&H\u0016R\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\nR\u0014\u0010\u0015\u001a\u00020\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006("}, d2 = {"Lcom/bytedance/android/anniex/optimize/prehandle/api/BaseHandleBridgeContext;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "bridgeCall", "Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;", "(Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;)V", "getBridgeCall", "()Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;", "callId", "", "getCallId", "()Ljava/lang/String;", "setCallId", "(Ljava/lang/String;)V", "containerID", "getContainerID", "jsEventDelegate", "Lcom/bytedance/sdk/xbridge/cn/service/JSEventDelegate;", "getJsEventDelegate", "()Lcom/bytedance/sdk/xbridge/cn/service/JSEventDelegate;", "namespace", "getNamespace", "platformType", "Lcom/bytedance/sdk/xbridge/cn/PlatformType;", "getPlatformType", "()Lcom/bytedance/sdk/xbridge/cn/PlatformType;", "getEngineView", "Landroid/view/View;", "getOwnerActivity", "Landroid/app/Activity;", "getService", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "sendEvent", "", "eventName", "params", "", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class BaseHandleBridgeContext implements IBDXBridgeContext {
    private final BaseBridgeCall<?> bridgeCall;
    private String callId;
    private final String containerID;
    private final JSEventDelegate jsEventDelegate;
    private final String namespace;
    private final PlatformType platformType;

    public View getEngineView() {
        return null;
    }

    public Activity getOwnerActivity() {
        return null;
    }

    public <T> T getService(Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return null;
    }

    public void sendEvent(String eventName, Map<String, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
    }

    public BaseHandleBridgeContext(BaseBridgeCall<?> baseBridgeCall) {
        Intrinsics.checkNotNullParameter(baseBridgeCall, "bridgeCall");
        this.bridgeCall = baseBridgeCall;
        this.containerID = "";
        this.namespace = "";
        this.platformType = getBridgeCall().getPlatformType();
        this.jsEventDelegate = new JSEventDelegate() { // from class: com.bytedance.android.anniex.optimize.prehandle.api.BaseHandleBridgeContext$jsEventDelegate$1
            public void sendJSEvent(String eventName, Map<String, ? extends Object> params) {
                Intrinsics.checkNotNullParameter(eventName, "eventName");
            }
        };
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        this.callId = uuid;
    }

    public BaseBridgeCall<?> getBridgeCall() {
        return this.bridgeCall;
    }

    public String getContainerID() {
        return this.containerID;
    }

    public String getNamespace() {
        return this.namespace;
    }

    public PlatformType getPlatformType() {
        return this.platformType;
    }

    public JSEventDelegate getJsEventDelegate() {
        return this.jsEventDelegate;
    }

    public String getCallId() {
        return this.callId;
    }

    public void setCallId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.callId = str;
    }
}
