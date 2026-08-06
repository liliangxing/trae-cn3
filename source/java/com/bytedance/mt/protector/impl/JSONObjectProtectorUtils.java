package com.bytedance.mt.protector.impl;

import com.bytedance.mt.protector.LogUtils;
import com.bytedance.mt.protector.Protector;
import com.bytedance.mt.protector.ProtectorType;
import com.bytedance.mt.protector.SelfDataManager;
import com.bytedance.mt.protector.ThrowableDisposerResult;
import com.bytedance.mt.protector.utils.StackTraceUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class JSONObjectProtectorUtils {
    private static void addSelfData(String str, Throwable th, String str2) {
        try {
            String stackTrace = StackTraceUtils.getStackTrace(th);
            JsonElement jsonObject = new JsonObject();
            jsonObject.addProperty("stackTrace", stackTrace);
            jsonObject.addProperty("inputData", str2);
            SelfDataManager.getInstance().addData(str, jsonObject, th);
        } catch (Throwable th2) {
            LogUtils.m113e("addSelfData", th2);
        }
    }

    private static void addSelfData(String str, Throwable th, JsonElement jsonElement) {
        addSelfData(str, th, jsonElement != null ? jsonElement.toString() : "null-param");
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static JSONObject createJSONObject(String str) throws JSONException {
        if (Protector.enable()) {
            try {
                return new JSONObject(str);
            } catch (Throwable th) {
                ThrowableDisposerResult disposeThrowable = Protector.disposeThrowable(ProtectorType.JSON, th);
                if (disposeThrowable == null) {
                    addSelfData("createJSONObject", th, str);
                    throw th;
                }
                Object result = disposeThrowable.getResult();
                if (result instanceof JsonElement) {
                    return new JSONObject(result.toString());
                }
                return null;
            }
        }
        return new JSONObject(str);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static JSONObject createJSONObject(JSONTokener jSONTokener) throws JSONException {
        if (Protector.enable()) {
            try {
                return new JSONObject(jSONTokener);
            } catch (Throwable th) {
                ThrowableDisposerResult disposeThrowable = Protector.disposeThrowable(ProtectorType.JSON, th);
                if (disposeThrowable == null) {
                    addSelfData("createJSONObject", th, jSONTokener != null ? jSONTokener.toString() : "null JSONTokener");
                    throw th;
                }
                Object result = disposeThrowable.getResult();
                if (result instanceof JsonElement) {
                    return new JSONObject(result.toString());
                }
                return null;
            }
        }
        return new JSONObject(jSONTokener);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static String getString(JSONObject jSONObject, String str) throws JSONException {
        if (Protector.enable()) {
            try {
                return jSONObject.getString(str);
            } catch (Throwable th) {
                ThrowableDisposerResult disposeThrowable = Protector.disposeThrowable(ProtectorType.JSON, th);
                if (disposeThrowable == null) {
                    throw th;
                }
                return (String) disposeThrowable.getResult();
            }
        }
        return jSONObject.getString(str);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static long getLong(JSONObject jSONObject, String str) throws JSONException {
        if (Protector.enable()) {
            try {
                return jSONObject.getLong(str);
            } catch (Throwable th) {
                ThrowableDisposerResult disposeThrowable = Protector.disposeThrowable(ProtectorType.JSON, th);
                if (disposeThrowable == null) {
                    throw th;
                }
                return ((Long) disposeThrowable.getResult()).longValue();
            }
        }
        return jSONObject.getLong(str);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static int getInt(JSONObject jSONObject, String str) throws JSONException {
        if (Protector.enable()) {
            try {
                return jSONObject.getInt(str);
            } catch (Throwable th) {
                ThrowableDisposerResult disposeThrowable = Protector.disposeThrowable(ProtectorType.JSON, th);
                if (disposeThrowable == null) {
                    throw th;
                }
                return ((Integer) disposeThrowable.getResult()).intValue();
            }
        }
        return jSONObject.getInt(str);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static double getDouble(JSONObject jSONObject, String str) throws JSONException {
        if (Protector.enable()) {
            try {
                return jSONObject.getDouble(str);
            } catch (Throwable th) {
                ThrowableDisposerResult disposeThrowable = Protector.disposeThrowable(ProtectorType.JSON, th);
                if (disposeThrowable == null) {
                    throw th;
                }
                return ((Double) disposeThrowable.getResult()).doubleValue();
            }
        }
        return jSONObject.getDouble(str);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static boolean getBoolean(JSONObject jSONObject, String str) throws JSONException {
        if (Protector.enable()) {
            try {
                return jSONObject.getBoolean(str);
            } catch (Throwable th) {
                ThrowableDisposerResult disposeThrowable = Protector.disposeThrowable(ProtectorType.JSON, th);
                if (disposeThrowable == null) {
                    throw th;
                }
                return ((Boolean) disposeThrowable.getResult()).booleanValue();
            }
        }
        return jSONObject.getBoolean(str);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static JSONObject getJSONObject(JSONObject jSONObject, String str) throws JSONException {
        if (Protector.enable()) {
            try {
                return jSONObject.getJSONObject(str);
            } catch (Throwable th) {
                ThrowableDisposerResult disposeThrowable = Protector.disposeThrowable(ProtectorType.JSON, th);
                if (disposeThrowable == null) {
                    throw th;
                }
                Object result = disposeThrowable.getResult();
                if (result instanceof JsonElement) {
                    return new JSONObject(result.toString());
                }
                return null;
            }
        }
        return jSONObject.getJSONObject(str);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static JSONArray getJSONArray(JSONObject jSONObject, String str) throws JSONException {
        if (Protector.enable()) {
            try {
                return jSONObject.getJSONArray(str);
            } catch (Throwable th) {
                ThrowableDisposerResult disposeThrowable = Protector.disposeThrowable(ProtectorType.JSON, th);
                if (disposeThrowable == null) {
                    throw th;
                }
                Object result = disposeThrowable.getResult();
                if (result instanceof JsonElement) {
                    return new JSONArray(result.toString());
                }
                return null;
            }
        }
        return jSONObject.getJSONArray(str);
    }
}
