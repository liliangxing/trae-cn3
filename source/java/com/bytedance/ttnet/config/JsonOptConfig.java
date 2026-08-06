package com.bytedance.ttnet.config;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class JsonOptConfig {
    private static volatile boolean mEnableJsonOpt;
    private static volatile boolean mEnableTNCJsonOpt;
    private static volatile IJsonHandler mJsonHandler;

    /* loaded from: classes4.dex */
    public interface IJsonHandler {
        String optString(String str, String[] strArr);
    }

    public static void enableJsonOpt(boolean z) {
        mEnableJsonOpt = z;
    }

    public static boolean isJsonOptEnable() {
        return mEnableJsonOpt;
    }

    public static void enableTNCJsonOpt(boolean z) {
        mEnableTNCJsonOpt = z;
    }

    public static boolean isTNCJsonOptEnable() {
        return mEnableTNCJsonOpt;
    }

    public static boolean isValid(Object obj) {
        if (obj instanceof String) {
            return ((String) obj).length() > 0;
        }
        if (obj instanceof JSONObject) {
            return ((JSONObject) obj).length() > 0;
        }
        if (obj instanceof JsonWrapper) {
            return ((JsonWrapper) obj).isValid();
        }
        return false;
    }

    public static JSONObject jsonObject(Object obj) throws JSONException {
        if (obj instanceof String) {
            return new JSONObject((String) obj);
        }
        if (obj instanceof JSONObject) {
            return (JSONObject) obj;
        }
        if (obj instanceof JsonWrapper) {
            return ((JsonWrapper) obj).jsonObject();
        }
        return null;
    }

    public static JSONObject tncJSONObject(Object obj) {
        if (obj instanceof JSONObject) {
            return (JSONObject) obj;
        }
        if (obj instanceof JsonWrapper) {
            try {
                return ((JsonWrapper) obj).jsonObject().optJSONObject("data");
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return new JSONObject();
    }

    public static void setJsonHandler(IJsonHandler iJsonHandler) {
        mJsonHandler = iJsonHandler;
    }

    public static String optString(Object obj, JSONObject jSONObject, String[] strArr) {
        String str = (strArr == null || strArr.length <= 0) ? null : strArr[strArr.length - 1];
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (mJsonHandler != null && (obj instanceof JsonWrapper)) {
            try {
                return mJsonHandler.optString(((JsonWrapper) obj).jsonStr(), strArr);
            } catch (Throwable unused) {
            }
        }
        return jSONObject.optString(str);
    }

    /* loaded from: classes4.dex */
    public static class JsonWrapper {
        private JSONObject mJsonObject;
        private String mJsonStr;

        public JsonWrapper(String str, JSONObject jSONObject) {
            this.mJsonStr = str;
            this.mJsonObject = jSONObject;
        }

        public String jsonStr() {
            if (TextUtils.isEmpty(this.mJsonStr)) {
                this.mJsonStr = this.mJsonObject.toString();
            }
            return this.mJsonStr;
        }

        public JSONObject jsonObject() throws JSONException {
            if (this.mJsonObject == null) {
                this.mJsonObject = new JSONObject(this.mJsonStr);
            }
            return this.mJsonObject;
        }

        public boolean isValid() {
            JSONObject jSONObject;
            return !TextUtils.isEmpty(this.mJsonStr) || ((jSONObject = this.mJsonObject) != null && jSONObject.length() > 0);
        }
    }
}
