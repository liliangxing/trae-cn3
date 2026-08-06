package com.bytedance.sdk.xbridge.cn.protocol;

import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sdk.xbridge.cn.AbsBridgeLifecycleHandler;
import com.bytedance.sdk.xbridge.cn.BidConstants;
import com.bytedance.sdk.xbridge.cn.XBridge;
import com.bytedance.sdk.xbridge.cn.monitor.XBridgeCallMonitor;
import com.bytedance.sdk.xbridge.cn.optimize.OptimizeConfigKt;
import com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall;
import com.bytedance.sdk.xbridge.cn.utils.UGLogger;
import com.bytedance.sdk.xbridge.cn.utils.XBridgeInjectLogger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: BridgeResultCallback.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0015\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00028\u0000¢\u0006\u0002\u0010\u0013R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/protocol/BridgeResultCallback;", "DATA", "", "call", "Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;", "(Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;)V", "getCall", "()Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;", "containerID", "", "getContainerID$anniex_release", "()Ljava/lang/String;", "setContainerID$anniex_release", "(Ljava/lang/String;)V", "convertDataToJSONObject", "Lorg/json/JSONObject;", "dispatchPlatformInvoke", "", "data", "(Ljava/lang/Object;)V", "invoke", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class BridgeResultCallback<DATA> {
    private final BaseBridgeCall<DATA> call;
    private String containerID;

    public abstract void dispatchPlatformInvoke(DATA data);

    public BridgeResultCallback(BaseBridgeCall<DATA> baseBridgeCall) {
        Intrinsics.checkNotNullParameter(baseBridgeCall, "call");
        this.call = baseBridgeCall;
    }

    public final BaseBridgeCall<DATA> getCall() {
        return this.call;
    }

    /* renamed from: getContainerID$anniex_release, reason: from getter */
    public final String getContainerID() {
        return this.containerID;
    }

    public final void setContainerID$anniex_release(String str) {
        this.containerID = str;
    }

    public final void invoke(DATA data) {
        this.call.setNativeCallbackStartTime(System.currentTimeMillis());
        dispatchPlatformInvoke(data);
        this.call.setNativeCallbackTime(System.currentTimeMillis());
        if (Intrinsics.areEqual(this.call.getBid(), BidConstants.LOKI) && Intrinsics.areEqual(this.call.getExtraMap().get(OptimizeConfigKt.getLOKI_JSB_LOG_DROP_SWITCH()), true)) {
            AbsBridgeLifecycleHandler bridgeLifecycle = XBridge.INSTANCE.getConfig().getBridgeLifecycle();
            if (bridgeLifecycle != null) {
                bridgeLifecycle.onCallbackEnd(this.call, data);
                return;
            }
            return;
        }
        if (XBridge.INSTANCE.getConfig().getDebuggable() || (!this.call.getSuccess() && !this.call.getIsLatch() && !Intrinsics.areEqual(this.call.getNamespace(), "webcast"))) {
            UGLogger uGLogger = UGLogger.INSTANCE;
            Map<String, ? extends Object> mapOf = MapsKt.mapOf(new Pair[]{TuplesKt.to(IWeixinService.ResponseConstants.URL, this.call.getUrl()), TuplesKt.to("methodName", this.call.getMethodName()), TuplesKt.to("code", Integer.valueOf(this.call.getCode())), TuplesKt.to("message", this.call.getMessage()), TuplesKt.to("data", convertDataToJSONObject().toString()), TuplesKt.to(XBridgeInjectLogger.CALL_ID, this.call.getId())});
            UGLogger.Context context = new UGLogger.Context();
            String str = this.containerID;
            if (str == null) {
                str = "";
            }
            context.pushStage(XBridgeInjectLogger.SESSION_ID, str);
            context.pushStage(XBridgeInjectLogger.CALL_ID, this.call.getId());
            Unit unit = Unit.INSTANCE;
            uGLogger.m162i(XBridgeInjectLogger.BULLET_SDK_TAG, "BDXBridge end handle method", "BridgeResult", mapOf, context);
        }
        XBridgeCallMonitor.INSTANCE.reportJSBCall(this.call);
        AbsBridgeLifecycleHandler bridgeLifecycle2 = XBridge.INSTANCE.getConfig().getBridgeLifecycle();
        if (bridgeLifecycle2 != null) {
            bridgeLifecycle2.onCallbackEnd(this.call, data);
        }
    }

    public JSONObject convertDataToJSONObject() {
        return new JSONObject();
    }
}
