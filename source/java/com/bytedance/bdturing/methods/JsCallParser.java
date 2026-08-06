package com.bytedance.bdturing.methods;

import com.bytedance.bdturing.LogUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class JsCallParser {
    public static final String GO_TO_CLOSE = "bytedcert.goToClose";
    static final String KEY_CALL_BACK = "__callback_id";
    static final String KEY_CODE = "code";
    static final String KEY_DATA = "data";
    static final String KEY_FUNC_NAME = "func";
    static final String KEY_PARAMS = "params";
    static final String KEY_PARAMS_BACK = "__params";
    static final String KEY_TYPE = "__msg_type";
    static final String KEY_VERSION = "JSSDK";
    public static final int MSG_FAILED = 0;
    public static final int MSG_NO_HANDLER = -2;
    public static final int MSG_NO_PERMISSION = -1;
    public static final int MSG_PARAM_ERROR = -3;
    public static final int MSG_SUCCESS = 1;
    public static final String REFRESH_VERIFY_VIEW = "bytedcert.refreshVerifyView";
    public static final String VALUE_CALL = "call";
    public static final String VALUE_CALLBACK = "callback";
    public static final String VERIFY_DATA = "bytedcert.verifyData";
    public static final String VERIFY_REPORT = "bytedcert.verifyReport";
    JsBridgeModule jsBridge;
    int mJsSdkVersion;
    String mFuncName = null;
    String mParams = null;
    String mMsgType = null;
    String mCallback = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public JsCallParser(JsBridgeModule jsBridgeModule, String str) {
        this.jsBridge = jsBridgeModule;
        try {
            parseJsCallNative(str);
        } catch (JSONException e) {
            LogUtil.printException(e);
        }
    }

    private void parseJsCallNative(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        this.mJsSdkVersion = jSONObject.getInt(KEY_VERSION);
        this.mFuncName = jSONObject.getString(KEY_FUNC_NAME);
        this.mParams = jSONObject.getString("params");
        this.mMsgType = jSONObject.getString(KEY_TYPE);
        this.mCallback = jSONObject.getString(KEY_CALL_BACK);
    }

    public void response(int i, JSONObject jSONObject) {
        JsBridgeModule jsBridgeModule = this.jsBridge;
        if (jsBridgeModule == null) {
            return;
        }
        try {
            jsBridgeModule.callJsCode(parseNativeResponse(i, VALUE_CALLBACK, jSONObject, this).toString());
        } catch (JSONException unused) {
        }
    }

    public static JSONObject parseNativeResponse(int i, String str, JSONObject jSONObject, JsCallParser jsCallParser) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("code", i);
        jSONObject2.put(KEY_FUNC_NAME, jsCallParser.mFuncName);
        jSONObject2.put(KEY_TYPE, str);
        Object obj = jSONObject;
        if (jSONObject == null) {
            obj = "{}";
        }
        jSONObject2.put("data", obj);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(KEY_PARAMS_BACK, jSONObject2);
        jSONObject3.put(KEY_CALL_BACK, jsCallParser.mCallback);
        return jSONObject3;
    }

    public static String parseNativeCallJs(int i, String str, String str2, JSONObject jSONObject, String str3) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("code", i);
            jSONObject2.put(KEY_FUNC_NAME, str);
            jSONObject2.put(KEY_TYPE, str2);
            jSONObject2.put("data", jSONObject);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(KEY_PARAMS_BACK, jSONObject2);
            jSONObject3.put(KEY_CALL_BACK, str3);
            return jSONObject3.toString();
        } catch (JSONException e) {
            LogUtil.printException(e);
            return null;
        }
    }

    public static JSONArray parseGetDataResponse(String str) {
        try {
            return new JSONObject(str).getJSONObject(KEY_PARAMS_BACK).getJSONObject("data").getJSONArray("data");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
