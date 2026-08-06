package com.bytedance.sdk.xbridge.cn.protocol;

import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.sdk.xbridge.cn.mix.AllowListForSpecialLogic;
import com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.exception.IllegalInputParamException;
import com.bytedance.sdk.xbridge.cn.registry.core.exception.IllegalOperationException;
import com.bytedance.sdk.xbridge.cn.registry.core.exception.IllegalOutputParamException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: BaseBridgeHandler.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J)\u0010\u000b\u001a\u00028\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006¢\u0006\u0002\u0010\u0011J\u001d\u0010\u0012\u001a\u00028\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006H&¢\u0006\u0002\u0010\u0013JA\u0010\u0014\u001a\u00020\u00152\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00010\u001cH\u0016¢\u0006\u0002\u0010\u001dR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u001e"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/protocol/BaseBridgeHandler;", "INPUT", "OUTPUT", "", "()V", "TEST_REGISTER_PARAM", "", "processor", "Lcom/bytedance/sdk/xbridge/cn/protocol/IPlatformDataProcessor;", "getProcessor", "()Lcom/bytedance/sdk/xbridge/cn/protocol/IPlatformDataProcessor;", "createErrorData", "call", "Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;", "code", "", "message", "(Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;ILjava/lang/String;)Ljava/lang/Object;", "createErrorDataRaw", "(ILjava/lang/String;)Ljava/lang/Object;", "handle", "", "data", "bridge", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod;", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", JsCallParser.VALUE_CALLBACK, "Lcom/bytedance/sdk/xbridge/cn/protocol/BridgeResultCallback;", "(Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;Ljava/lang/Object;Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod;Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;Lcom/bytedance/sdk/xbridge/cn/protocol/BridgeResultCallback;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public abstract class BaseBridgeHandler<INPUT, OUTPUT> {
    private final String TEST_REGISTER_PARAM = "__test_register";

    public abstract OUTPUT createErrorDataRaw(int code, String message);

    public abstract IPlatformDataProcessor<INPUT, OUTPUT> getProcessor();

    /* JADX WARN: Multi-variable type inference failed */
    public void handle(final BaseBridgeCall<INPUT> call, INPUT data, final IDLXBridgeMethod bridge, final IBDXBridgeContext bridgeContext, final BridgeResultCallback<OUTPUT> callback) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(bridge, "bridge");
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            IDLXBridgeMethod.Callback callback2 = new IDLXBridgeMethod.Callback() { // from class: com.bytedance.sdk.xbridge.cn.protocol.BaseBridgeHandler$handle$idlCallback$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod.Callback
                public void invoke(Map<String, ? extends Object> data2) {
                    Intrinsics.checkNotNullParameter(data2, "data");
                    Object obj = data2.get("code");
                    Integer num = obj instanceof Integer ? (Integer) obj : null;
                    int intValue = num != null ? num.intValue() : 1;
                    call.setCode(intValue);
                    BaseBridgeCall<INPUT> baseBridgeCall = call;
                    Object obj2 = data2.get("msg");
                    String str = obj2 instanceof String ? (String) obj2 : null;
                    if (str == null) {
                        Object obj3 = data2.get("message");
                        String str2 = obj3 instanceof String ? (String) obj3 : null;
                        str = str2 == null ? "unknown error 1" : str2;
                    }
                    baseBridgeCall.setMessage(str);
                    call.setSuccess(intValue == 1);
                    callback.invoke(this.getProcessor().transformMapToPlatformData(data2, bridge.getClass(), call));
                }
            };
            IDLXBridgeMethod.Callback callback3 = new IDLXBridgeMethod.Callback() { // from class: com.bytedance.sdk.xbridge.cn.protocol.BaseBridgeHandler$handle$jsb2CallBack$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod.Callback
                public void invoke(Map<String, ? extends Object> data2) {
                    String str;
                    Object m10253constructorimpl;
                    Object obj;
                    Intrinsics.checkNotNullParameter(data2, "data");
                    Object obj2 = data2.get(AllowListForSpecialLogic.JSB2_DATA);
                    if (obj2 != null && (obj2 instanceof JSONObject)) {
                        Object opt = ((JSONObject) obj2).opt("code");
                        Integer num = opt instanceof Integer ? (Integer) opt : null;
                        int intValue = num != null ? num.intValue() : 1;
                        call.setCode(intValue);
                        try {
                            Result.Companion companion = Result.INSTANCE;
                            Object opt2 = ((JSONObject) obj2).opt("msg");
                            if ((opt2 instanceof String ? (String) opt2 : null) != null) {
                                obj = ((JSONObject) obj2).opt("msg");
                            } else {
                                Object opt3 = ((JSONObject) obj2).opt("message");
                                if ((opt3 instanceof String ? (String) opt3 : null) != null) {
                                    obj = ((JSONObject) obj2).opt("message");
                                } else {
                                    Object opt4 = ((JSONObject) obj2).opt("data");
                                    JSONObject jSONObject = opt4 instanceof JSONObject ? (JSONObject) opt4 : null;
                                    Object opt5 = jSONObject != null ? jSONObject.opt("msg") : null;
                                    if ((opt5 instanceof String ? (String) opt5 : null) != null) {
                                        Object opt6 = ((JSONObject) obj2).opt("data");
                                        JSONObject jSONObject2 = opt6 instanceof JSONObject ? (JSONObject) opt6 : null;
                                        obj = jSONObject2 != null ? jSONObject2.opt("msg") : null;
                                    } else {
                                        obj = "wrap1 data: " + obj2;
                                    }
                                }
                            }
                            m10253constructorimpl = Result.m10253constructorimpl(obj);
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.INSTANCE;
                            m10253constructorimpl = Result.m10253constructorimpl(ResultKt.createFailure(th));
                        }
                        if (Result.m10256exceptionOrNullimpl(m10253constructorimpl) != null) {
                            m10253constructorimpl = "wrap2 data: " + obj2;
                        }
                        BaseBridgeCall<INPUT> baseBridgeCall = call;
                        str = m10253constructorimpl instanceof String ? (String) m10253constructorimpl : null;
                        if (str == null) {
                            str = "wrap3 data: " + obj2;
                        }
                        baseBridgeCall.setMessage(str);
                        call.setSuccess(intValue == 1);
                        callback.invoke(this.getProcessor().transformMapToPlatformData(data2, bridge.getClass(), call));
                        return;
                    }
                    Map<String, Object> dealSpecialDataSwitch = AllowListForSpecialLogic.INSTANCE.dealSpecialDataSwitch(call.getMethodName(), bridgeContext, data2);
                    Object obj3 = dealSpecialDataSwitch.get("code");
                    Integer num2 = obj3 instanceof Integer ? (Integer) obj3 : null;
                    int intValue2 = num2 != null ? num2.intValue() : 1;
                    call.setCode(intValue2);
                    BaseBridgeCall<INPUT> baseBridgeCall2 = call;
                    Object obj4 = dealSpecialDataSwitch.get("msg");
                    String str2 = obj4 instanceof String ? (String) obj4 : null;
                    if (str2 == null) {
                        Object obj5 = dealSpecialDataSwitch.get("message");
                        str = obj5 instanceof String ? (String) obj5 : null;
                        str2 = str == null ? "unknown error 2" : str;
                    }
                    baseBridgeCall2.setMessage(str2);
                    call.setSuccess(intValue2 == 1);
                    callback.invoke(this.getProcessor().transformMapToPlatformData(dealSpecialDataSwitch, bridge.getClass(), call));
                }
            };
            if (bridge.getCompatibility().getValue()) {
                Map<String, ? extends Object> transformPlatformDataToMapCompat = getProcessor().transformPlatformDataToMapCompat(data);
                if (Intrinsics.areEqual(transformPlatformDataToMapCompat.get(this.TEST_REGISTER_PARAM), (Object) 1)) {
                    callback.invoke(createErrorData(call, 0, "bridge已注册"));
                    return;
                } else if (Intrinsics.areEqual(call.getNamespace(), "webcast")) {
                    bridge.realHandle(bridgeContext, transformPlatformDataToMapCompat, callback3);
                    return;
                } else {
                    bridge.realHandle(bridgeContext, transformPlatformDataToMapCompat, callback2);
                    return;
                }
            }
            Map<String, ? extends Object> transformPlatformDataToMapWithNamespace = Intrinsics.areEqual(call.getNamespace(), "webcast") ? getProcessor().transformPlatformDataToMapWithNamespace(data, bridge.getClass(), call.getNamespace()) : getProcessor().transformPlatformDataToMap(data, bridge.getClass());
            if (transformPlatformDataToMapWithNamespace == null) {
                callback.invoke(createErrorData(call, -10, "XBridge IDL 数据转换失败"));
                return;
            }
            if (Intrinsics.areEqual(transformPlatformDataToMapWithNamespace.get(this.TEST_REGISTER_PARAM), (Object) 1)) {
                callback.invoke(createErrorData(call, 0, "bridge已注册"));
            } else if (Intrinsics.areEqual(call.getNamespace(), "webcast")) {
                bridge.realHandle(bridgeContext, transformPlatformDataToMapWithNamespace, callback3);
            } else {
                bridge.realHandle(bridgeContext, transformPlatformDataToMapWithNamespace, callback2);
            }
        } catch (IllegalInputParamException e) {
            OUTPUT createErrorData = createErrorData(call, -3, e.toString());
            Intrinsics.checkNotNull(createErrorData);
            callback.invoke(createErrorData);
        } catch (IllegalOperationException e2) {
            OUTPUT createErrorData2 = createErrorData(call, -10, e2.toString());
            Intrinsics.checkNotNull(createErrorData2);
            callback.invoke(createErrorData2);
        } catch (IllegalOutputParamException e3) {
            OUTPUT createErrorData3 = createErrorData(call, -5, e3.toString());
            Intrinsics.checkNotNull(createErrorData3);
            callback.invoke(createErrorData3);
        } catch (Throwable th) {
            OUTPUT createErrorData4 = createErrorData(call, -11, th.toString());
            Intrinsics.checkNotNull(createErrorData4);
            callback.invoke(createErrorData4);
        }
    }

    public final OUTPUT createErrorData(BaseBridgeCall<INPUT> call, int code, String message) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(message, "message");
        call.setCode(code);
        call.setMessage(message);
        call.setSuccess(false);
        return createErrorDataRaw(code, message);
    }
}
