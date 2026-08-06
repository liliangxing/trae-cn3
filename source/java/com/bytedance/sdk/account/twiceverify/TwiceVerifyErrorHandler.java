package com.bytedance.sdk.account.twiceverify;

import android.text.TextUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.sdk.account.error.handler.ErrorHandler;
import com.bytedance.sdk.account.error.handler.ErrorHandlerCenter;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class TwiceVerifyErrorHandler implements ErrorHandler {
    @Override // com.bytedance.sdk.account.error.handler.ErrorHandler
    public String getName() {
        return "verify";
    }

    public static void register() {
        ErrorHandlerCenter.registerGlobalHandler(new TwiceVerifyErrorHandler());
    }

    @Override // com.bytedance.sdk.account.error.handler.ErrorHandler
    public boolean handle(int i, final Map<String, String> map, JSONObject jSONObject, final ErrorHandler.HandlerCallback handlerCallback) {
        if (jSONObject == null || jSONObject.optJSONObject("data") == null) {
            return false;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (TwiceVerifyManager.getInstance().canHandle(i, true, "", "", jSONObject)) {
            return TwiceVerifyManager.getInstance().startTwiceVerify(optJSONObject, new TwiceVerifyResultCallback() { // from class: com.bytedance.sdk.account.twiceverify.TwiceVerifyErrorHandler.1
                @Override // com.bytedance.sdk.account.twiceverify.TwiceVerifyResultCallback
                public void onSuccess(String str, String str2, Map<String, String> map2, Map<String, Object> map3) {
                    Map map4 = map;
                    if (map4 != null && map4.get("mix_mode") != null && map2 != null) {
                        boolean equals = "1".equals(map.get("mix_mode"));
                        String str3 = map2.get("sms_code_key");
                        if (equals && !TextUtils.isEmpty(str3)) {
                            map2.put("sms_code_key", StringUtils.encryptWithXor(str3));
                        }
                    }
                    handlerCallback.onHandlerResult(true, true, map2);
                }

                @Override // com.bytedance.sdk.account.twiceverify.TwiceVerifyResultCallback
                public void onFail() {
                    handlerCallback.onHandlerResult(false, false, null);
                }
            });
        }
        return false;
    }
}
