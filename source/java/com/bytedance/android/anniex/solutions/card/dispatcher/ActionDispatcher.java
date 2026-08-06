package com.bytedance.android.anniex.solutions.card.dispatcher;

import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.android.anniex.solutions.card.AirSolutionContext;
import com.bytedance.android.anniex.solutions.card.model.Actions;
import com.bytedance.android.monitorV2.entity.JsbErrorData;
import com.bytedance.android.monitorV2.entity.JsbInfoData;
import com.bytedance.android.monitorV2.lynx.LynxViewMonitor;
import com.bytedance.framwork.core.sdklib.apm6.Constants;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBDXBridge;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBridgeCall;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBridgeContext;
import com.bytedance.sdk.xbridge.cn.protocol.BridgeResultCallback;
import com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: ActionDispatcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 '2\u00020\u0001:\u0002&'B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002J,\u0010\f\u001a\u00020\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J6\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\b2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J>\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\b2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J*\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u0013J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002JH\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u001e\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00010$H\u0002J\"\u0010%\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/bytedance/android/anniex/solutions/card/dispatcher/ActionDispatcher;", "", "lynxView", "Lcom/lynx/tasm/LynxView;", "lynxBDXBridge", "Lcom/bytedance/sdk/xbridge/cn/platform/lynx/LynxBDXBridge;", "(Lcom/lynx/tasm/LynxView;Lcom/bytedance/sdk/xbridge/cn/platform/lynx/LynxBDXBridge;)V", "composeErrorMessage", "", "message", "code", "", "handleHighExecAction", "", "realArguments", "", "highExec", "Lcom/bytedance/android/anniex/solutions/card/model/Actions$HighExec;", "airSolutionContext", "Lcom/bytedance/android/anniex/solutions/card/AirSolutionContext;", "handleJSBAction", "actionName", "jsb", "Lcom/bytedance/android/anniex/solutions/card/model/Actions$JSBAction;", "handleJsbCall", "bridgeName", "handleLifecycle", "handleValid", "realHandleJsbCall", "params", "Lcom/lynx/react/bridge/JavaOnlyMap;", "callback", "reportToMonitor", "lynxBridgeContext", "Lcom/bytedance/sdk/xbridge/cn/platform/lynx/LynxBridgeContext;", "bridgeCall", "Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;", "updateData", "ActionExecutorCallback", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class ActionDispatcher {
    private static final String TAG = "AirSolution_ActionDispatcher";
    private final LynxBDXBridge lynxBDXBridge;
    private final LynxView lynxView;

    /* compiled from: ActionDispatcher.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u0006\u001a\u00020\u00032\u0010\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\bH&¨\u0006\t"}, d2 = {"Lcom/bytedance/android/anniex/solutions/card/dispatcher/ActionDispatcher$ActionExecutorCallback;", "", "onFail", "", "reason", "", "onSuccess", StrategyConstants.RESULT, "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public interface ActionExecutorCallback {
        void onFail(String reason);

        void onSuccess(Map<String, ?> result);
    }

    public ActionDispatcher(LynxView lynxView, LynxBDXBridge lynxBDXBridge) {
        Intrinsics.checkNotNullParameter(lynxView, "lynxView");
        Intrinsics.checkNotNullParameter(lynxBDXBridge, "lynxBDXBridge");
        this.lynxView = lynxView;
        this.lynxBDXBridge = lynxBDXBridge;
    }

    public final void handleLifecycle(String actionName, Map<String, ? extends Object> realArguments, AirSolutionContext airSolutionContext) {
        Actions.HighExec highExec;
        Actions.JSBAction jSBAction;
        Intrinsics.checkNotNullParameter(actionName, "actionName");
        Intrinsics.checkNotNullParameter(realArguments, "realArguments");
        Intrinsics.checkNotNullParameter(airSolutionContext, "airSolutionContext");
        if (actionName.length() == 0) {
            HybridLogger.e$default(HybridLogger.INSTANCE, TAG, "jsb action failed, reason: action name is empty", (Map) null, (LoggerContext) null, 12, (Object) null);
            return;
        }
        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "handleLifecycle: annieXLynxView: " + this.lynxView + ", actionName: " + actionName + ", realArguments: " + realArguments, (Map) null, (LoggerContext) null, 12, (Object) null);
        Map<String, Actions.JSBAction> actions = airSolutionContext.getActions();
        if (actions != null && actions.containsKey(actionName)) {
            Map<String, Actions.JSBAction> actions2 = airSolutionContext.getActions();
            if (actions2 == null || (jSBAction = actions2.get(actionName)) == null) {
                return;
            }
            handleJSBAction(actionName, realArguments, jSBAction, airSolutionContext);
            return;
        }
        Map<String, Actions.HighExec> highExecActions = airSolutionContext.getHighExecActions();
        if (highExecActions != null && highExecActions.containsKey(actionName)) {
            Map<String, Actions.HighExec> highExecActions2 = airSolutionContext.getHighExecActions();
            if (highExecActions2 == null || (highExec = highExecActions2.get(actionName)) == null) {
                return;
            }
            handleHighExecAction(realArguments, highExec, airSolutionContext);
            return;
        }
        JavaOnlyMap from = JavaOnlyMap.from(realArguments);
        Intrinsics.checkNotNullExpressionValue(from, "from(realArguments)");
        realHandleJsbCall(actionName, actionName, from, realArguments, null, airSolutionContext);
    }

    public final void handleHighExecAction(Map<String, ? extends Object> realArguments, Actions.HighExec highExec, AirSolutionContext airSolutionContext) {
        Intrinsics.checkNotNullParameter(highExec, "highExec");
        Intrinsics.checkNotNullParameter(airSolutionContext, "airSolutionContext");
        airSolutionContext.getHighEE().execute(this, highExec, realArguments);
    }

    public final void updateData(AirSolutionContext airSolutionContext, Map<String, ? extends Object> realArguments) {
        Intrinsics.checkNotNullParameter(airSolutionContext, "airSolutionContext");
        Intrinsics.checkNotNullParameter(realArguments, "realArguments");
        HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "updateData: annieXLynxView: data: " + realArguments, (Map) null, (LoggerContext) null, 12, (Object) null);
        airSolutionContext.getDataCenter().getInitData().putAll(realArguments);
        this.lynxView.updateData(realArguments);
    }

    private final void handleJSBAction(String actionName, Map<String, ? extends Object> realArguments, Actions.JSBAction jsb, AirSolutionContext airSolutionContext) {
        Unit unit;
        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "handleJSBAction, actionName:" + actionName + ", jsb:" + jsb, (Map) null, (LoggerContext) null, 12, (Object) null);
        String handleValid = handleValid(jsb);
        if (handleValid != null) {
            handleJsbCall(actionName, realArguments, handleValid, jsb, airSolutionContext);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            HybridLogger.e$default(HybridLogger.INSTANCE, TAG, "invalid jsb: " + jsb, (Map) null, (LoggerContext) null, 12, (Object) null);
        }
    }

    private final String handleValid(Actions.JSBAction jsb) {
        return jsb.getMethod();
    }

    private final void handleJsbCall(String actionName, Map<String, ? extends Object> realArguments, String bridgeName, Actions.JSBAction jsb, AirSolutionContext airSolutionContext) {
        realHandleJsbCall(actionName, bridgeName, airSolutionContext.getParamEE().preExecute(jsb, realArguments), realArguments, jsb.getHighExec(), airSolutionContext);
    }

    private final void realHandleJsbCall(String actionName, String bridgeName, JavaOnlyMap params, Map<String, ? extends Object> realArguments, Actions.HighExec callback, AirSolutionContext airSolutionContext) {
        String str;
        ReadableMap readableMap = (ReadableMap) params;
        LynxView lynxView = this.lynxBDXBridge.getLynxBridgeContext().getLynxView();
        if (lynxView == null || (str = lynxView.getTemplateUrl()) == null) {
            str = "";
        }
        final BaseBridgeCall lynxBridgeCall = new LynxBridgeCall(bridgeName, readableMap, str);
        final ActionDispatcher$realHandleJsbCall$actionCallback$1 actionDispatcher$realHandleJsbCall$actionCallback$1 = new ActionDispatcher$realHandleJsbCall$actionCallback$1(airSolutionContext, callback, actionName, this, realArguments, bridgeName);
        this.lynxBDXBridge.handleCallV2(lynxBridgeCall, new BridgeResultCallback<Object>(lynxBridgeCall, actionDispatcher$realHandleJsbCall$actionCallback$1, this) { // from class: com.bytedance.android.anniex.solutions.card.dispatcher.ActionDispatcher$realHandleJsbCall$resultCallback$1
            final /* synthetic */ ActionDispatcher$realHandleJsbCall$actionCallback$1 $actionCallback;
            final /* synthetic */ LynxBridgeCall $bridgeCall;
            private JSONObject data;
            final /* synthetic */ ActionDispatcher this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super((BaseBridgeCall) lynxBridgeCall);
                this.$bridgeCall = lynxBridgeCall;
                this.$actionCallback = actionDispatcher$realHandleJsbCall$actionCallback$1;
                this.this$0 = this;
                Intrinsics.checkNotNull(lynxBridgeCall, "null cannot be cast to non-null type com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall<kotlin.Any>");
            }

            public void dispatchPlatformInvoke(Object data) {
                LynxBDXBridge lynxBDXBridge;
                Intrinsics.checkNotNullParameter(data, Constants.KEY_DATA);
                Map<String, ?> map = (Map) data;
                boolean z = true;
                if (!Intrinsics.areEqual(map.get("code"), 1)) {
                    Object obj = map.get("__jsb2__data__");
                    JSONObject jSONObject = obj instanceof JSONObject ? (JSONObject) obj : null;
                    if (!(jSONObject != null ? Intrinsics.areEqual(jSONObject.get("code"), 1) : false)) {
                        z = false;
                    }
                }
                if (z) {
                    this.$actionCallback.onSuccess(map);
                } else {
                    this.$actionCallback.onFail(this.$bridgeCall.getMessage());
                }
                ActionDispatcher actionDispatcher = this.this$0;
                lynxBDXBridge = actionDispatcher.lynxBDXBridge;
                LynxBridgeContext lynxBridgeContext = lynxBDXBridge.getLynxBridgeContext();
                BaseBridgeCall baseBridgeCall = this.$bridgeCall;
                Intrinsics.checkNotNull(baseBridgeCall, "null cannot be cast to non-null type com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall<kotlin.Any>");
                actionDispatcher.reportToMonitor(lynxBridgeContext, baseBridgeCall);
            }

            public JSONObject convertDataToJSONObject() {
                JSONObject jSONObject = this.data;
                return jSONObject == null ? super.convertDataToJSONObject() : jSONObject;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportToMonitor(LynxBridgeContext lynxBridgeContext, BaseBridgeCall<Object> bridgeCall) {
        LynxView lynxView = lynxBridgeContext.getLynxView();
        if (lynxView != null) {
            if (bridgeCall.getCode() == 1) {
                LynxViewMonitor instance = LynxViewMonitor.Companion.getINSTANCE();
                JsbInfoData jsbInfoData = new JsbInfoData();
                jsbInfoData.setBridgeName(bridgeCall.getMethodName());
                jsbInfoData.setStatusCode(0);
                jsbInfoData.setCostTime(System.currentTimeMillis() - bridgeCall.getNativeCallStartTime());
                Unit unit = Unit.INSTANCE;
                instance.reportJsbInfo(lynxView, jsbInfoData);
                return;
            }
            LynxViewMonitor instance2 = LynxViewMonitor.Companion.getINSTANCE();
            JsbErrorData jsbErrorData = new JsbErrorData();
            jsbErrorData.setBridgeName(bridgeCall.getMethodName());
            jsbErrorData.setErrorCode(bridgeCall.getCode());
            jsbErrorData.setErrorMessage(composeErrorMessage(bridgeCall.getMessage(), bridgeCall.getCode()));
            Unit unit2 = Unit.INSTANCE;
            instance2.reportJsbError(lynxView, jsbErrorData);
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
}
