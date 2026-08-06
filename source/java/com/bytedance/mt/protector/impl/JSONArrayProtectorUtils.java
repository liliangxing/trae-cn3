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
public class JSONArrayProtectorUtils {
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
    public static JSONArray createJSONArray(String str) throws JSONException {
        if (Protector.enable()) {
            try {
                return new JSONArray(str);
            } catch (Throwable th) {
                ThrowableDisposerResult disposeThrowable = Protector.disposeThrowable(ProtectorType.JSON, th);
                if (disposeThrowable == null) {
                    addSelfData("createJSONArray", th, str);
                    throw th;
                }
                Object result = disposeThrowable.getResult();
                if (result instanceof JsonElement) {
                    return new JSONArray(result.toString());
                }
                return null;
            }
        }
        return new JSONArray(str);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static JSONArray createJSONArray(JSONTokener jSONTokener) throws JSONException {
        if (Protector.enable()) {
            try {
                return new JSONArray(jSONTokener);
            } catch (Throwable th) {
                ThrowableDisposerResult disposeThrowable = Protector.disposeThrowable(ProtectorType.JSON, th);
                if (disposeThrowable == null) {
                    addSelfData("createJSONArray", th, jSONTokener != null ? jSONTokener.toString() : "null JSONTokener");
                    throw th;
                }
                Object result = disposeThrowable.getResult();
                if (result instanceof JsonElement) {
                    return new JSONArray(result.toString());
                }
                return null;
            }
        }
        return new JSONArray(jSONTokener);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static String getString(JSONArray jSONArray, int i) throws JSONException {
        if (Protector.enable()) {
            try {
                return jSONArray.getString(i);
            } catch (Throwable th) {
                ThrowableDisposerResult disposeThrowable = Protector.disposeThrowable(ProtectorType.JSON, th);
                if (disposeThrowable == null) {
                    throw th;
                }
                return (String) disposeThrowable.getResult();
            }
        }
        return jSONArray.getString(i);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static long getLong(JSONArray jSONArray, int i) throws JSONException {
        if (Protector.enable()) {
            try {
                return jSONArray.getLong(i);
            } catch (Throwable th) {
                ThrowableDisposerResult disposeThrowable = Protector.disposeThrowable(ProtectorType.JSON, th);
                if (disposeThrowable == null) {
                    throw th;
                }
                return ((Long) disposeThrowable.getResult()).longValue();
            }
        }
        return jSONArray.getLong(i);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static int getInt(JSONArray jSONArray, int i) throws JSONException {
        if (Protector.enable()) {
            try {
                return jSONArray.getInt(i);
            } catch (Throwable th) {
                ThrowableDisposerResult disposeThrowable = Protector.disposeThrowable(ProtectorType.JSON, th);
                if (disposeThrowable == null) {
                    throw th;
                }
                return ((Integer) disposeThrowable.getResult()).intValue();
            }
        }
        return jSONArray.getInt(i);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static double getDouble(JSONArray jSONArray, int i) throws JSONException {
        if (Protector.enable()) {
            try {
                return jSONArray.getDouble(i);
            } catch (Throwable th) {
                ThrowableDisposerResult disposeThrowable = Protector.disposeThrowable(ProtectorType.JSON, th);
                if (disposeThrowable == null) {
                    throw th;
                }
                return ((Double) disposeThrowable.getResult()).doubleValue();
            }
        }
        return jSONArray.getDouble(i);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static boolean getBoolean(JSONArray jSONArray, int i) throws JSONException {
        if (Protector.enable()) {
            try {
                return jSONArray.getBoolean(i);
            } catch (Throwable th) {
                ThrowableDisposerResult disposeThrowable = Protector.disposeThrowable(ProtectorType.JSON, th);
                if (disposeThrowable == null) {
                    throw th;
                }
                return ((Boolean) disposeThrowable.getResult()).booleanValue();
            }
        }
        return jSONArray.getBoolean(i);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static JSONObject getJSONObject(JSONArray jSONArray, int i) throws JSONException {
        if (Protector.enable()) {
            try {
                return jSONArray.getJSONObject(i);
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
        return jSONArray.getJSONObject(i);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static JSONArray getJSONArray(JSONArray jSONArray, int i) throws JSONException {
        if (Protector.enable()) {
            try {
                return jSONArray.getJSONArray(i);
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
        return jSONArray.getJSONArray(i);
    }
}
