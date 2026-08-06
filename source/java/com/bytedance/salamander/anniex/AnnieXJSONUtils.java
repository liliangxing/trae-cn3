package com.bytedance.salamander.anniex;

import com.bytedance.rts.foundation.RTSArrayKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AnniexMonitorFoundationImplJSONUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007H\u0016J,\u0010\b\u001a\u00020\u00042\"\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b`\fH\u0016J\f\u0010\r\u001a\u00060\u000ej\u0002`\u000fH\u0016J\u0014\u0010\r\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\f\u0010\u0011\u001a\u00060\u0006j\u0002`\u0007H\u0016J0\u0010\u0011\u001a\u00060\u0006j\u0002`\u00072\"\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\nj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\fH\u0016J\u0014\u0010\u0011\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\u001c\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001c\u0010\u0018\u001a\u00020\u00142\n\u0010\u0019\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\u001a\u001a\u00020\u0004H\u0016J\u001c\u0010\u001b\u001a\u00020\u001c2\n\u0010\u0015\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001c\u0010\u001d\u001a\u00020\u001c2\n\u0010\u0019\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\u001a\u001a\u00020\u0004H\u0016J\u001c\u0010\u001e\u001a\u00020\u00172\n\u0010\u0015\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001c\u0010\u001f\u001a\u00020\u00172\n\u0010\u0019\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\u001a\u001a\u00020\u0004H\u0016J \u0010 \u001a\u00060\u000ej\u0002`\u000f2\n\u0010\u0015\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J \u0010!\u001a\u00060\u000ej\u0002`\u000f2\n\u0010\u0019\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\u001a\u001a\u00020\u0004H\u0016J \u0010\"\u001a\u00060\u0006j\u0002`\u00072\n\u0010\u0015\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J \u0010#\u001a\u00060\u0006j\u0002`\u00072\n\u0010\u0019\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\u001a\u001a\u00020\u0004H\u0016J$\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\u00040%j\b\u0012\u0004\u0012\u00020\u0004`&2\n\u0010\u0019\u001a\u00060\u0006j\u0002`\u0007H\u0016J\u001c\u0010'\u001a\u00020(2\n\u0010\u0015\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001c\u0010)\u001a\u00020(2\n\u0010\u0019\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\u001a\u001a\u00020\u0004H\u0016J\u001c\u0010*\u001a\u00020\u000b2\n\u0010\u0015\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001c\u0010+\u001a\u00020\u000b2\n\u0010\u0019\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\u001a\u001a\u00020\u0004H\u0016J\u001c\u0010,\u001a\u00020\u00042\n\u0010\u0015\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001c\u0010-\u001a\u00020\u00042\n\u0010\u0019\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\u001a\u001a\u00020\u0004H\u0016J$\u0010.\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010/\u001a\u00020\u0014H\u0016J$\u00100\u001a\u00020\u00142\n\u0010\u0019\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u0014H\u0016J$\u00101\u001a\u00020\u001c2\n\u0010\u0015\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010/\u001a\u00020\u001cH\u0016J$\u00102\u001a\u00020\u001c2\n\u0010\u0019\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u001cH\u0016J$\u00103\u001a\u00020\u00172\n\u0010\u0015\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010/\u001a\u00020\u0017H\u0016J$\u00104\u001a\u00020\u00172\n\u0010\u0019\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u0017H\u0016J,\u00105\u001a\u00060\u000ej\u0002`\u000f2\n\u0010\u0015\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\n\u0010/\u001a\u00060\u000ej\u0002`\u000fH\u0016J,\u00106\u001a\u00060\u000ej\u0002`\u000f2\n\u0010\u0019\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\u001a\u001a\u00020\u00042\n\u0010/\u001a\u00060\u000ej\u0002`\u000fH\u0016J,\u00107\u001a\u00060\u0006j\u0002`\u00072\n\u0010\u0015\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\n\u0010/\u001a\u00060\u0006j\u0002`\u0007H\u0016J,\u00108\u001a\u00060\u0006j\u0002`\u00072\n\u0010\u0019\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\u001a\u001a\u00020\u00042\n\u0010/\u001a\u00060\u0006j\u0002`\u0007H\u0016J$\u00109\u001a\u00020(2\n\u0010\u0015\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010/\u001a\u00020(H\u0016J$\u0010:\u001a\u00020(2\n\u0010\u0019\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010/\u001a\u00020(H\u0016J$\u0010;\u001a\u00020\u000b2\n\u0010\u0015\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010/\u001a\u00020\u000bH\u0016J$\u0010<\u001a\u00020\u000b2\n\u0010\u0019\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u000bH\u0016J$\u0010=\u001a\u00020\u00042\n\u0010\u0015\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010/\u001a\u00020\u0004H\u0016J$\u0010>\u001a\u00020\u00042\n\u0010\u0019\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u0004H\u0016J\u001c\u0010?\u001a\u00020@2\n\u0010\u0015\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010A\u001a\u00020\u000bH\u0016J$\u0010B\u001a\u00020@2\n\u0010\u0019\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u000bH\u0016¨\u0006C"}, d2 = {"Lcom/bytedance/salamander/anniex/AnnieXJSONUtils;", "Lcom/bytedance/salamander/anniex/IJSONUtils;", "()V", "convertJSONObjectTOJSONString", "", "jsonObject", "Lorg/json/JSONObject;", "Lcom/bytedance/salamander/anniex/AnnieXJSONObject;", "convertMapToJSONString", "jsonMap", "", "", "Lcom/bytedance/rts/foundation/RTSMap;", "createJSONArray", "Lorg/json/JSONArray;", "Lcom/bytedance/salamander/anniex/AnnieXJSONArray;", "json", "createJSONObject", "jsonString", "getBooleanFromJSONArray", "", "jsonArr", "index", "", "getBooleanFromJSONObject", "jsonObj", "key", "getDoubleFromJSONArray", "", "getDoubleFromJSONObject", "getIntFromJSONArray", "getIntFromJSONObject", "getJSONArrayFromJSONArray", "getJSONArrayFromJSONObject", "getJSONObjectFromJSONArray", "getJSONObjectFromJSONObject", "getJSONObjectKeys", "Ljava/util/ArrayList;", "Lcom/bytedance/rts/foundation/RTSArray;", "getLongFromJSONArray", "", "getLongFromJSONObject", "getObjectFromJSONArray", "getObjectFromJSONObject", "getStringFromJSONArray", "getStringFromJSONObject", "optBooleanFromJSONArray", "defaultValue", "optBooleanFromJSONObject", "optDoubleFromJSONArray", "optDoubleFromJSONObject", "optIntFromJSONArray", "optIntFromJSONObject", "optJSONArrayFromJSONArray", "optJSONArrayFromJSONObject", "optJSONObjectFromJSONArray", "optJSONObjectFromJSONObject", "optLongFromJSONArray", "optLongFromJSONObject", "optObjectFromJSONArray", "optObjectFromJSONObject", "optStringFromJSONArray", "optStringFromJSONObject", "pushValueToJSONArray", "", "value", "putKVToJSONObject", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public class AnnieXJSONUtils implements IJSONUtils {
    @Override // com.bytedance.salamander.anniex.IJSONUtils
    public JSONObject createJSONObject() {
        return new JSONObject();
    }

    @Override // com.bytedance.salamander.anniex.IJSONUtils
    public JSONObject createJSONObject(String jsonString) {
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        return new JSONObject(jsonString);
    }

    @Override // com.bytedance.salamander.anniex.IJSONUtils
    public JSONObject createJSONObject(Map<String, String> jsonMap) {
        Intrinsics.checkNotNullParameter(jsonMap, "jsonMap");
        return new JSONObject(jsonMap);
    }

    @Override // com.bytedance.salamander.anniex.IJSONUtils
    public String convertMapToJSONString(Map<String, Object> jsonMap) {
        Intrinsics.checkNotNullParameter(jsonMap, "jsonMap");
        String jSONObject = new JSONObject(jsonMap).toString();
        Intrinsics.checkNotNull(jSONObject);
        return jSONObject;
    }

    @Override // com.bytedance.salamander.anniex.IJSONUtils
    public String convertJSONObjectTOJSONString(JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        String jSONObject = jsonObject.toString();
        return jSONObject == null ? "" : jSONObject;
    }

    @Override // com.bytedance.salamander.anniex.IJSONUtils
    public ArrayList<String> getJSONObjectKeys(JSONObject jsonObj) {
        Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<String> keys = jsonObj.keys();
        if (keys != null) {
            while (keys.hasNext()) {
                RTSArrayKt.push(arrayList, keys.next());
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.salamander.anniex.IJSONUtils
    public void putKVToJSONObject(JSONObject jsonObj, String key, Object value) {
        Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        jsonObj.put(key, value);
    }

    @Override // com.bytedance.salamander.anniex.IJSONUtils
    public String getStringFromJSONObject(JSONObject jsonObj, String key) {
        Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
        Intrinsics.checkNotNullParameter(key, "key");
        String string = jsonObj.getString(key);
        Intrinsics.checkNotNull(string);
        return string;
    }

    @Override // com.bytedance.salamander.anniex.IJSONUtils
    public int getIntFromJSONObject(JSONObject jsonObj, String key) {
        Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
        Intrinsics.checkNotNullParameter(key, "key");
        return jsonObj.getInt(key);
    }

    @Override // com.bytedance.salamander.anniex.IJSONUtils
    public long getLongFromJSONObject(JSONObject jsonObj, String key) {
        Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
        Intrinsics.checkNotNullParameter(key, "key");
        return jsonObj.getLong(key);
    }

    @Override // com.bytedance.salamander.anniex.IJSONUtils
    public boolean getBooleanFromJSONObject(JSONObject jsonObj, String key) {
        Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
        Intrinsics.checkNotNullParameter(key, "key");
        return jsonObj.getBoolean(key);
    }

    @Override // com.bytedance.salamander.anniex.IJSONUtils
    public double getDoubleFromJSONObject(JSONObject jsonObj, String key) {
        Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
        Intrinsics.checkNotNullParameter(key, "key");
        return jsonObj.getDouble(key);
    }

    @Override // com.bytedance.salamander.anniex.IJSONUtils
    public JSONObject getJSONObjectFromJSONObject(JSONObject jsonObj, String key) {
        Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
        Intrinsics.checkNotNullParameter(key, "key");
        JSONObject jSONObject = jsonObj.getJSONObject(key);
        Intrinsics.checkNotNull(jSONObject);
        return jSONObject;
    }

    @Override // com.bytedance.salamander.anniex.IJSONUtils
    public JSONArray getJSONArrayFromJSONObject(JSONObject jsonObj, String key) {
        Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
        Intrinsics.checkNotNullParameter(key, "key");
        JSONArray jSONArray = jsonObj.getJSONArray(key);
        Intrinsics.checkNotNull(jSONArray);
        return jSONArray;
    }

    @Override // com.bytedance.salamander.anniex.IJSONUtils
    public Object getObjectFromJSONObject(JSONObject jsonObj, String key) {
        Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
        Intrinsics.checkNotNullParameter(key, "key");
        Object obj = jsonObj.get(key);
        Intrinsics.checkNotNull(obj);
        return obj;
    }

    @Override // com.bytedance.salamander.anniex.IJSONUtils
    public String optStringFromJSONObject(JSONObject jsonObj, String key, String defaultValue) {
        Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        String optString = jsonObj.optString(key, defaultValue);
        return optString == null ? defaultValue : optString;
    }

    @Override // com.bytedance.salamander.anniex.IJSONUtils
    public int optIntFromJSONObject(JSONObject jsonObj, String key, int defaultValue) {
        Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
        Intrinsics.checkNotNullParameter(key, "key");
        return jsonObj.optInt(key, defaultValue);
    }

    @Override // com.bytedance.salamander.anniex.IJSONUtils
    public long optLongFromJSONObject(JSONObject jsonObj, String key, long defaultValue) {
        Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
        Intrinsics.checkNotNullParameter(key, "key");
        return jsonObj.optLong(key, defaultValue);
    }

    @Override // com.bytedance.salamander.anniex.IJSONUtils
    public boolean optBooleanFromJSONObject(JSONObject jsonObj, String key, boolean defaultValue) {
        Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
        Intrinsics.checkNotNullParameter(key, "key");
        return jsonObj.optBoolean(key, defaultValue);
    }

    @Override // com.bytedance.salamander.anniex.IJSONUtils
    public double optDoubleFromJSONObject(JSONObject jsonObj, String key, double defaultValue) {
        Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
        Intrinsics.checkNotNullParameter(key, "key");
        return jsonObj.optDouble(key, defaultValue);
    }

    @Override // com.bytedance.salamander.anniex.IJSONUtils
    public JSONObject optJSONObjectFromJSONObject(JSONObject jsonObj, String key, JSONObject defaultValue) {
        Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        JSONObject optJSONObject = jsonObj.optJSONObject(key);
        return optJSONObject == null ? defaultValue : optJSONObject;
    }

    @Override // com.bytedance.salamander.anniex.IJSONUtils
    public JSONArray optJSONArrayFromJSONObject(JSONObject jsonObj, String key, JSONArray defaultValue) {
        Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        JSONArray optJSONArray = jsonObj.optJSONArray(key);
        return optJSONArray == null ? defaultValue : optJSONArray;
    }

    @Override // com.bytedance.salamander.anniex.IJSONUtils
    public Object optObjectFromJSONObject(JSONObject jsonObj, String key, Object defaultValue) {
        Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        Object opt = jsonObj.opt(key);
        return opt == null ? defaultValue : opt;
    }

    @Override // com.bytedance.salamander.anniex.IJSONUtils
    public JSONArray createJSONArray() {
        return new JSONArray();
    }

    @Override // com.bytedance.salamander.anniex.IJSONUtils
    public JSONArray createJSONArray(String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        return new JSONArray(json);
    }

    @Override // com.bytedance.salamander.anniex.IJSONUtils
    public void pushValueToJSONArray(JSONArray jsonArr, Object value) {
        Intrinsics.checkNotNullParameter(jsonArr, "jsonArr");
        Intrinsics.checkNotNullParameter(value, "value");
        jsonArr.put(value);
    }

    @Override // com.bytedance.salamander.anniex.IJSONUtils
    public String getStringFromJSONArray(JSONArray jsonArr, int index) {
        Intrinsics.checkNotNullParameter(jsonArr, "jsonArr");
        String string = jsonArr.getString(index);
        Intrinsics.checkNotNull(string);
        return string;
    }

    @Override // com.bytedance.salamander.anniex.IJSONUtils
    public int getIntFromJSONArray(JSONArray jsonArr, int index) {
        Intrinsics.checkNotNullParameter(jsonArr, "jsonArr");
        return jsonArr.getInt(index);
    }

    @Override // com.bytedance.salamander.anniex.IJSONUtils
    public long getLongFromJSONArray(JSONArray jsonArr, int index) {
        Intrinsics.checkNotNullParameter(jsonArr, "jsonArr");
        return jsonArr.getLong(index);
    }

    @Override // com.bytedance.salamander.anniex.IJSONUtils
    public boolean getBooleanFromJSONArray(JSONArray jsonArr, int index) {
        Intrinsics.checkNotNullParameter(jsonArr, "jsonArr");
        return jsonArr.getBoolean(index);
    }

    @Override // com.bytedance.salamander.anniex.IJSONUtils
    public double getDoubleFromJSONArray(JSONArray jsonArr, int index) {
        Intrinsics.checkNotNullParameter(jsonArr, "jsonArr");
        return jsonArr.getDouble(index);
    }

    @Override // com.bytedance.salamander.anniex.IJSONUtils
    public JSONObject getJSONObjectFromJSONArray(JSONArray jsonArr, int index) {
        Intrinsics.checkNotNullParameter(jsonArr, "jsonArr");
        JSONObject jSONObject = jsonArr.getJSONObject(index);
        Intrinsics.checkNotNull(jSONObject);
        return jSONObject;
    }

    @Override // com.bytedance.salamander.anniex.IJSONUtils
    public JSONArray getJSONArrayFromJSONArray(JSONArray jsonArr, int index) {
        Intrinsics.checkNotNullParameter(jsonArr, "jsonArr");
        JSONArray jSONArray = jsonArr.getJSONArray(index);
        Intrinsics.checkNotNull(jSONArray);
        return jSONArray;
    }

    @Override // com.bytedance.salamander.anniex.IJSONUtils
    public Object getObjectFromJSONArray(JSONArray jsonArr, int index) {
        Intrinsics.checkNotNullParameter(jsonArr, "jsonArr");
        Object obj = jsonArr.get(index);
        Intrinsics.checkNotNull(obj);
        return obj;
    }

    @Override // com.bytedance.salamander.anniex.IJSONUtils
    public String optStringFromJSONArray(JSONArray jsonArr, int index, String defaultValue) {
        Intrinsics.checkNotNullParameter(jsonArr, "jsonArr");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        String optString = jsonArr.optString(index, defaultValue);
        return optString == null ? defaultValue : optString;
    }

    @Override // com.bytedance.salamander.anniex.IJSONUtils
    public int optIntFromJSONArray(JSONArray jsonArr, int index, int defaultValue) {
        Intrinsics.checkNotNullParameter(jsonArr, "jsonArr");
        return jsonArr.optInt(index, defaultValue);
    }

    @Override // com.bytedance.salamander.anniex.IJSONUtils
    public long optLongFromJSONArray(JSONArray jsonArr, int index, long defaultValue) {
        Intrinsics.checkNotNullParameter(jsonArr, "jsonArr");
        return jsonArr.optLong(index, defaultValue);
    }

    @Override // com.bytedance.salamander.anniex.IJSONUtils
    public boolean optBooleanFromJSONArray(JSONArray jsonArr, int index, boolean defaultValue) {
        Intrinsics.checkNotNullParameter(jsonArr, "jsonArr");
        return jsonArr.optBoolean(index, defaultValue);
    }

    @Override // com.bytedance.salamander.anniex.IJSONUtils
    public double optDoubleFromJSONArray(JSONArray jsonArr, int index, double defaultValue) {
        Intrinsics.checkNotNullParameter(jsonArr, "jsonArr");
        return jsonArr.optDouble(index, defaultValue);
    }

    @Override // com.bytedance.salamander.anniex.IJSONUtils
    public JSONObject optJSONObjectFromJSONArray(JSONArray jsonArr, int index, JSONObject defaultValue) {
        Intrinsics.checkNotNullParameter(jsonArr, "jsonArr");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        JSONObject optJSONObject = jsonArr.optJSONObject(index);
        return optJSONObject == null ? defaultValue : optJSONObject;
    }

    @Override // com.bytedance.salamander.anniex.IJSONUtils
    public JSONArray optJSONArrayFromJSONArray(JSONArray jsonArr, int index, JSONArray defaultValue) {
        Intrinsics.checkNotNullParameter(jsonArr, "jsonArr");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        JSONArray optJSONArray = jsonArr.optJSONArray(index);
        return optJSONArray == null ? defaultValue : optJSONArray;
    }

    @Override // com.bytedance.salamander.anniex.IJSONUtils
    public Object optObjectFromJSONArray(JSONArray jsonArr, int index, Object defaultValue) {
        Intrinsics.checkNotNullParameter(jsonArr, "jsonArr");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        Object opt = jsonArr.opt(index);
        return opt == null ? defaultValue : opt;
    }
}
