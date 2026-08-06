package com.bytedance.pitaya.api;

import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.pitaya.api.bean.PTYCepCallbackMode;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: PitayaCep.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H&J\"\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\fH&J\"\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000eH&J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H&J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00112\u0006\u0010\b\u001a\u00020\u0003H&J\u001a\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H&J\u001a\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H&J*\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H&J \u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H&J\"\u0010!\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\"\u001a\u00020#H&J*\u0010!\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\"\u001a\u00020#H&J\u0018\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020'H&J \u0010$\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020'H&J\u0010\u0010(\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0003H&J\u0010\u0010)\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&J\u0018\u0010)\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H&J\u0010\u0010*\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0003H&J\u0018\u0010*\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0003H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006+"}, d2 = {"Lcom/bytedance/pitaya/api/PitayaCep;", "", CommonConstants.KEY_AID, "", "getAid", "()Ljava/lang/String;", "clean", "", "bizName", "ruleName", "disableRule", "disableStrategy", "Lcom/bytedance/pitaya/api/CepDisableStrategy;", "cleanEngine", "", "enableRule", "getEnabledRules", "", "onEvent", SchemaConstants.INNER_PARAM_EVENT_NAME, "eventParamsStr", "eventParams", "Lorg/json/JSONObject;", "processEvent", "Lcom/bytedance/pitaya/api/PTYCepResult;", "business", "rule", "registerAction", "actionName", "callback", "Lcom/bytedance/pitaya/api/PTYCepCallback;", "callbackConfig", "Lcom/bytedance/pitaya/api/PTYCepCallbackConfig;", "registerCallback", "callbackMode", "Lcom/bytedance/pitaya/api/bean/PTYCepCallbackMode;", "registerFunction", "funcName", "func", "Lcom/bytedance/pitaya/api/PTYCepFunction;", "unregisterAction", "unregisterCallback", "unregisterFunction", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface PitayaCep {
    void clean(String bizName);

    void clean(String bizName, String ruleName);

    void disableRule(String bizName, String ruleName, CepDisableStrategy disableStrategy);

    void disableRule(String bizName, String ruleName, boolean cleanEngine);

    void enableRule(String bizName, String ruleName);

    String getAid();

    List<String> getEnabledRules(String bizName);

    void onEvent(String eventName, String eventParamsStr);

    void onEvent(String eventName, JSONObject eventParams);

    PTYCepResult processEvent(String business, String rule, String eventName, JSONObject eventParams);

    void registerAction(String actionName, PTYCepCallback callback, PTYCepCallbackConfig callbackConfig);

    void registerCallback(String bizName, PTYCepCallback callback, PTYCepCallbackMode callbackMode);

    void registerCallback(String bizName, String ruleName, PTYCepCallback callback, PTYCepCallbackMode callbackMode);

    void registerFunction(String funcName, PTYCepFunction func);

    void registerFunction(String bizName, String funcName, PTYCepFunction func);

    void unregisterAction(String actionName);

    void unregisterCallback(String bizName);

    void unregisterCallback(String bizName, String ruleName);

    void unregisterFunction(String funcName);

    void unregisterFunction(String bizName, String funcName);

    /* compiled from: PitayaCep.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void registerCallback$default(PitayaCep pitayaCep, String str, PTYCepCallback pTYCepCallback, PTYCepCallbackMode pTYCepCallbackMode, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: registerCallback");
            }
            if ((i & 4) != 0) {
                pTYCepCallbackMode = PTYCepCallbackMode.SUCCESS_AND_ERROR;
            }
            pitayaCep.registerCallback(str, pTYCepCallback, pTYCepCallbackMode);
        }

        public static /* synthetic */ void registerCallback$default(PitayaCep pitayaCep, String str, String str2, PTYCepCallback pTYCepCallback, PTYCepCallbackMode pTYCepCallbackMode, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: registerCallback");
            }
            if ((i & 8) != 0) {
                pTYCepCallbackMode = PTYCepCallbackMode.SUCCESS_AND_ERROR;
            }
            pitayaCep.registerCallback(str, str2, pTYCepCallback, pTYCepCallbackMode);
        }

        public static /* synthetic */ void disableRule$default(PitayaCep pitayaCep, String str, String str2, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: disableRule");
            }
            if ((i & 4) != 0) {
                z = true;
            }
            pitayaCep.disableRule(str, str2, z);
        }

        public static /* synthetic */ void disableRule$default(PitayaCep pitayaCep, String str, String str2, CepDisableStrategy cepDisableStrategy, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: disableRule");
            }
            if ((i & 4) != 0) {
                cepDisableStrategy = CepDisableStrategy.CLEAN;
            }
            pitayaCep.disableRule(str, str2, cepDisableStrategy);
        }
    }
}
