package com.bytedance.sdk.xbridge.cn.platform.lynx;

import android.view.View;
import com.bytedance.android.anniex.monitor.salamander.SLMonitorCompatKt;
import com.bytedance.android.monitorV2.entity.JsbErrorData;
import com.bytedance.android.monitorV2.entity.JsbInfoData;
import com.bytedance.android.monitorV2.lynx.LynxViewMonitor;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.salamander.anniex.SLAnnieXMonitor;
import com.bytedance.salamander.anniex.SLInfoCategory;
import com.bytedance.salamander.anniex.SLInfoPerf;
import com.bytedance.salamander.anniex.SLJSBErrorEventInfo;
import com.bytedance.salamander.anniex.SLJSBPerfEventInfo;
import com.bytedance.sdk.xbridge.cn.BidConstants;
import com.bytedance.sdk.xbridge.cn.protocol.BridgeResultCallback;
import com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall;
import com.bytedance.sdk.xbridge.cn.utils.XBridgeMonitorHelper;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: XBridgeLynxModule.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/platform/lynx/LynxIDLCallbackWrapper;", "Lcom/bytedance/sdk/xbridge/cn/protocol/BridgeResultCallback;", "", "callback", "Lcom/lynx/react/bridge/Callback;", "bridgeCall", "Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;", "lynxBridgeContext", "Lcom/bytedance/sdk/xbridge/cn/platform/lynx/LynxBridgeContext;", "(Lcom/lynx/react/bridge/Callback;Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;Lcom/bytedance/sdk/xbridge/cn/platform/lynx/LynxBridgeContext;)V", "getCallback", "()Lcom/lynx/react/bridge/Callback;", "data", "composeErrorMessage", "", "message", "code", "", "convertDataToJSONObject", "Lorg/json/JSONObject;", "dispatchPlatformInvoke", "", "reportToMonitor", "shouldIgnoreJsbError", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class LynxIDLCallbackWrapper extends BridgeResultCallback<Object> {
    private final BaseBridgeCall<Object> bridgeCall;
    private final Callback callback;
    private Object data;
    private final LynxBridgeContext lynxBridgeContext;

    public final Callback getCallback() {
        return this.callback;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LynxIDLCallbackWrapper(Callback callback, BaseBridgeCall<Object> baseBridgeCall, LynxBridgeContext lynxBridgeContext) {
        super(baseBridgeCall);
        Intrinsics.checkNotNullParameter(baseBridgeCall, "bridgeCall");
        Intrinsics.checkNotNullParameter(lynxBridgeContext, "lynxBridgeContext");
        this.callback = callback;
        this.bridgeCall = baseBridgeCall;
        this.lynxBridgeContext = lynxBridgeContext;
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.BridgeResultCallback
    public void dispatchPlatformInvoke(Object data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
        if (data instanceof PiperDataProxy) {
            Callback callback = this.callback;
            if (callback != null) {
                callback.invoke(new Object[]{((PiperDataProxy) data).getPiperData()});
            }
        } else {
            Callback callback2 = this.callback;
            if (callback2 != null) {
                callback2.invoke(new Object[]{data});
            }
        }
        if (Intrinsics.areEqual(this.bridgeCall.getBid(), BidConstants.LOKI)) {
            return;
        }
        reportToMonitor();
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.BridgeResultCallback
    public JSONObject convertDataToJSONObject() {
        JSONObject jsonObject;
        Object obj = this.data;
        if (obj != null) {
            if (obj instanceof JavaOnlyMap) {
                JavaOnlyMap javaOnlyMap = obj instanceof JavaOnlyMap ? (JavaOnlyMap) obj : null;
                JSONObject jSONObject = javaOnlyMap != null ? javaOnlyMap.toJSONObject() : null;
                if (jSONObject == null) {
                    return super.convertDataToJSONObject();
                }
                Intrinsics.checkNotNullExpressionValue(jSONObject, "map?.toJSONObject() ?: s…convertDataToJSONObject()");
                return jSONObject;
            }
            if (obj instanceof PiperDataProxy) {
                PiperDataProxy piperDataProxy = obj instanceof PiperDataProxy ? (PiperDataProxy) obj : null;
                return (piperDataProxy == null || (jsonObject = piperDataProxy.toJsonObject()) == null) ? super.convertDataToJSONObject() : jsonObject;
            }
        }
        return super.convertDataToJSONObject();
    }

    private final void reportToMonitor() {
        View lynxView = this.lynxBridgeContext.getLynxView();
        if (lynxView != null) {
            if (this.bridgeCall.getCode() == 1) {
                LynxViewMonitor instance = LynxViewMonitor.Companion.getINSTANCE();
                JsbInfoData jsbInfoData = new JsbInfoData();
                jsbInfoData.setBridgeName(this.bridgeCall.getMethodName());
                jsbInfoData.setStatusCode(0);
                jsbInfoData.setCostTime(System.currentTimeMillis() - this.bridgeCall.getNativeCallStartTime());
                Unit unit = Unit.INSTANCE;
                instance.reportJsbInfo(lynxView, jsbInfoData);
                SLAnnieXMonitor monitorWithSessionId = SLMonitorCompatKt.getSLMonitorManager().getMonitorWithSessionId(this.lynxBridgeContext.getContainerID());
                SLJSBPerfEventInfo sLJSBPerfEventInfo = new SLJSBPerfEventInfo();
                SLInfoCategory sLInfoCategory = new SLInfoCategory();
                sLInfoCategory.setJsb_name(this.bridgeCall.getMethodName());
                sLJSBPerfEventInfo.setInfo(sLInfoCategory);
                SLInfoPerf sLInfoPerf = new SLInfoPerf();
                sLInfoPerf.setJsb_call(System.currentTimeMillis() - this.bridgeCall.getNativeCallStartTime());
                sLJSBPerfEventInfo.setPerf(sLInfoPerf);
                monitorWithSessionId.reportJSBPerf(sLJSBPerfEventInfo);
                return;
            }
            if (shouldIgnoreJsbError()) {
                XBridgeMonitorHelper.INSTANCE.reportJSBFailed(XBridgeMonitorHelper.EVENTNAME_JSB2_FINISH_WITH_FAILURE, this.bridgeCall.getMethodName(), this.bridgeCall.getUrl(), this.bridgeCall.getMessage(), lynxView);
                return;
            }
            LynxViewMonitor instance2 = LynxViewMonitor.Companion.getINSTANCE();
            JsbErrorData jsbErrorData = new JsbErrorData();
            jsbErrorData.setBridgeName(this.bridgeCall.getMethodName());
            jsbErrorData.setErrorCode(this.bridgeCall.getCode());
            jsbErrorData.setErrorMessage(composeErrorMessage(this.bridgeCall.getMessage(), this.bridgeCall.getCode()));
            Unit unit2 = Unit.INSTANCE;
            instance2.reportJsbError(lynxView, jsbErrorData);
            SLAnnieXMonitor monitorWithSessionId2 = SLMonitorCompatKt.getSLMonitorManager().getMonitorWithSessionId(this.lynxBridgeContext.getContainerID());
            SLJSBErrorEventInfo sLJSBErrorEventInfo = new SLJSBErrorEventInfo();
            sLJSBErrorEventInfo.setError_ts(System.currentTimeMillis());
            sLJSBErrorEventInfo.setBridge_name(this.bridgeCall.getMethodName());
            sLJSBErrorEventInfo.setError_code(this.bridgeCall.getCode());
            sLJSBErrorEventInfo.setError_message(this.bridgeCall.getMessage());
            try {
                Result.Companion companion = Result.Companion;
                if (IConditionCallKt.enableSLMonitorJSBErrorParams()) {
                    Object params = this.bridgeCall.getParams();
                    ReadableMap readableMap = params instanceof ReadableMap ? (ReadableMap) params : null;
                    if (readableMap != null) {
                        sLJSBErrorEventInfo.setJsb_params(new JSONObject(readableMap.asHashMap()).toString());
                    }
                }
                Result.constructor-impl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.createFailure(th));
            }
            monitorWithSessionId2.reportJSBError(sLJSBErrorEventInfo);
            SLAnnieXMonitor monitorWithSessionId3 = SLMonitorCompatKt.getSLMonitorManager().getMonitorWithSessionId(this.lynxBridgeContext.getContainerID());
            SLJSBPerfEventInfo sLJSBPerfEventInfo2 = new SLJSBPerfEventInfo();
            SLInfoCategory sLInfoCategory2 = new SLInfoCategory();
            sLInfoCategory2.setJsb_name(this.bridgeCall.getMethodName());
            sLJSBPerfEventInfo2.setInfo(sLInfoCategory2);
            SLInfoPerf sLInfoPerf2 = new SLInfoPerf();
            sLInfoPerf2.setJsb_call(-1L);
            sLJSBPerfEventInfo2.setPerf(sLInfoPerf2);
            monitorWithSessionId3.reportJSBPerf(sLJSBPerfEventInfo2);
        }
    }

    private final String composeErrorMessage(String message, int code) {
        try {
            Result.Companion companion = Result.Companion;
            String jSONObject = new JSONObject().putOpt("message", message).putOpt("code", Integer.valueOf(code)).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject()\n           …              .toString()");
            return jSONObject;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            return message;
        }
    }

    private final boolean shouldIgnoreJsbError() {
        if (IConditionCallKt.enableAnnieXIgnoreJSB2Failure()) {
            return getCall().getIgnoreJSBError();
        }
        return false;
    }
}
