package com.bytedance.ies.web.jsbridge2;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
class SerializeHelper {
    private static boolean shouldFlattenData;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getEmptyString() {
        return "";
    }

    private SerializeHelper() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getErrorResponse(Throwable th) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", th instanceof JsBridgeException ? ((JsBridgeException) th).code : 0);
            if (th != null && !TextUtils.isEmpty(th.getMessage())) {
                jSONObject.put("msg", th.getMessage());
            }
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> JSONObject getSuccessResponseJson(T t) {
        if (!(t instanceof JSONObject)) {
            return null;
        }
        try {
            ((JSONObject) t).put("code", 1);
            return (JSONObject) t;
        } catch (JSONException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> String getSuccessResponse(DataConverterActual dataConverterActual, T t) {
        if ((t instanceof JSONObject) && shouldFlattenData && dataConverterActual.isOptJsonObject()) {
            JSONObject jSONObject = (JSONObject) t;
            try {
                jSONObject.put("code", 1);
                return jSONObject.toString();
            } catch (JSONException unused) {
            }
        }
        String rawData = dataConverterActual.toRawData(t);
        if (TextUtils.isEmpty(rawData)) {
            return "{\"code\":1}";
        }
        String substring = shouldFlattenData ? rawData.substring(1, rawData.length() - 1) : "";
        String str = "{\"code\":1,\"__data\":" + rawData;
        if (!substring.isEmpty()) {
            return str + "," + substring + "}";
        }
        return str + "}";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setShouldFlattenData(boolean z) {
        shouldFlattenData = z;
    }
}
