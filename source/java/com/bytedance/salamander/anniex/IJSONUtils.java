package com.bytedance.salamander.anniex;

import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AnniexMonitorFoundationInterfaceIJSONUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H&J,\u0010\u0007\u001a\u00020\u00032\"\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\tj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001`\nH&J\f\u0010\u000b\u001a\u00060\fj\u0002`\rH&J\u0014\u0010\u000b\u001a\u00060\fj\u0002`\r2\u0006\u0010\u000e\u001a\u00020\u0003H&J\f\u0010\u000f\u001a\u00060\u0005j\u0002`\u0006H&J0\u0010\u000f\u001a\u00060\u0005j\u0002`\u00062\"\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\tj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\nH&J\u0014\u0010\u000f\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0010\u001a\u00020\u0003H&J\u001c\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\fj\u0002`\r2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u001c\u0010\u0016\u001a\u00020\u00122\n\u0010\u0017\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0018\u001a\u00020\u0003H&J\u001c\u0010\u0019\u001a\u00020\u001a2\n\u0010\u0013\u001a\u00060\fj\u0002`\r2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u001c\u0010\u001b\u001a\u00020\u001a2\n\u0010\u0017\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0018\u001a\u00020\u0003H&J\u001c\u0010\u001c\u001a\u00020\u00152\n\u0010\u0013\u001a\u00060\fj\u0002`\r2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u001c\u0010\u001d\u001a\u00020\u00152\n\u0010\u0017\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0018\u001a\u00020\u0003H&J \u0010\u001e\u001a\u00060\fj\u0002`\r2\n\u0010\u0013\u001a\u00060\fj\u0002`\r2\u0006\u0010\u0014\u001a\u00020\u0015H&J \u0010\u001f\u001a\u00060\fj\u0002`\r2\n\u0010\u0017\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0018\u001a\u00020\u0003H&J \u0010 \u001a\u00060\u0005j\u0002`\u00062\n\u0010\u0013\u001a\u00060\fj\u0002`\r2\u0006\u0010\u0014\u001a\u00020\u0015H&J \u0010!\u001a\u00060\u0005j\u0002`\u00062\n\u0010\u0017\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0018\u001a\u00020\u0003H&J$\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u00030#j\b\u0012\u0004\u0012\u00020\u0003`$2\n\u0010\u0017\u001a\u00060\u0005j\u0002`\u0006H&J\u001c\u0010%\u001a\u00020&2\n\u0010\u0013\u001a\u00060\fj\u0002`\r2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u001c\u0010'\u001a\u00020&2\n\u0010\u0017\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0018\u001a\u00020\u0003H&J\u001c\u0010(\u001a\u00020\u00012\n\u0010\u0013\u001a\u00060\fj\u0002`\r2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u001c\u0010)\u001a\u00020\u00012\n\u0010\u0017\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0018\u001a\u00020\u0003H&J\u001c\u0010*\u001a\u00020\u00032\n\u0010\u0013\u001a\u00060\fj\u0002`\r2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u001c\u0010+\u001a\u00020\u00032\n\u0010\u0017\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0018\u001a\u00020\u0003H&J$\u0010,\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\fj\u0002`\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\u0012H&J$\u0010.\u001a\u00020\u00122\n\u0010\u0017\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u0012H&J$\u0010/\u001a\u00020\u001a2\n\u0010\u0013\u001a\u00060\fj\u0002`\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\u001aH&J$\u00100\u001a\u00020\u001a2\n\u0010\u0017\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u001aH&J$\u00101\u001a\u00020\u00152\n\u0010\u0013\u001a\u00060\fj\u0002`\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\u0015H&J$\u00102\u001a\u00020\u00152\n\u0010\u0017\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u0015H&J,\u00103\u001a\u00060\fj\u0002`\r2\n\u0010\u0013\u001a\u00060\fj\u0002`\r2\u0006\u0010\u0014\u001a\u00020\u00152\n\u0010-\u001a\u00060\fj\u0002`\rH&J,\u00104\u001a\u00060\fj\u0002`\r2\n\u0010\u0017\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0018\u001a\u00020\u00032\n\u0010-\u001a\u00060\fj\u0002`\rH&J,\u00105\u001a\u00060\u0005j\u0002`\u00062\n\u0010\u0013\u001a\u00060\fj\u0002`\r2\u0006\u0010\u0014\u001a\u00020\u00152\n\u0010-\u001a\u00060\u0005j\u0002`\u0006H&J,\u00106\u001a\u00060\u0005j\u0002`\u00062\n\u0010\u0017\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0018\u001a\u00020\u00032\n\u0010-\u001a\u00060\u0005j\u0002`\u0006H&J$\u00107\u001a\u00020&2\n\u0010\u0013\u001a\u00060\fj\u0002`\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010-\u001a\u00020&H&J$\u00108\u001a\u00020&2\n\u0010\u0017\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010-\u001a\u00020&H&J$\u00109\u001a\u00020\u00012\n\u0010\u0013\u001a\u00060\fj\u0002`\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\u0001H&J$\u0010:\u001a\u00020\u00012\n\u0010\u0017\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u0001H&J$\u0010;\u001a\u00020\u00032\n\u0010\u0013\u001a\u00060\fj\u0002`\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\u0003H&J$\u0010<\u001a\u00020\u00032\n\u0010\u0017\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u0003H&J\u001c\u0010=\u001a\u00020>2\n\u0010\u0013\u001a\u00060\fj\u0002`\r2\u0006\u0010?\u001a\u00020\u0001H&J$\u0010@\u001a\u00020>2\n\u0010\u0017\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u0001H&¨\u0006A"}, d2 = {"Lcom/bytedance/salamander/anniex/IJSONUtils;", "", "convertJSONObjectTOJSONString", "", "jsonObject", "Lorg/json/JSONObject;", "Lcom/bytedance/salamander/anniex/AnnieXJSONObject;", "convertMapToJSONString", "jsonMap", "", "Lcom/bytedance/rts/foundation/RTSMap;", "createJSONArray", "Lorg/json/JSONArray;", "Lcom/bytedance/salamander/anniex/AnnieXJSONArray;", "json", "createJSONObject", "jsonString", "getBooleanFromJSONArray", "", "jsonArr", "index", "", "getBooleanFromJSONObject", "jsonObj", "key", "getDoubleFromJSONArray", "", "getDoubleFromJSONObject", "getIntFromJSONArray", "getIntFromJSONObject", "getJSONArrayFromJSONArray", "getJSONArrayFromJSONObject", "getJSONObjectFromJSONArray", "getJSONObjectFromJSONObject", "getJSONObjectKeys", "Ljava/util/ArrayList;", "Lcom/bytedance/rts/foundation/RTSArray;", "getLongFromJSONArray", "", "getLongFromJSONObject", "getObjectFromJSONArray", "getObjectFromJSONObject", "getStringFromJSONArray", "getStringFromJSONObject", "optBooleanFromJSONArray", "defaultValue", "optBooleanFromJSONObject", "optDoubleFromJSONArray", "optDoubleFromJSONObject", "optIntFromJSONArray", "optIntFromJSONObject", "optJSONArrayFromJSONArray", "optJSONArrayFromJSONObject", "optJSONObjectFromJSONArray", "optJSONObjectFromJSONObject", "optLongFromJSONArray", "optLongFromJSONObject", "optObjectFromJSONArray", "optObjectFromJSONObject", "optStringFromJSONArray", "optStringFromJSONObject", "pushValueToJSONArray", "", "value", "putKVToJSONObject", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IJSONUtils {
    String convertJSONObjectTOJSONString(JSONObject jsonObject);

    String convertMapToJSONString(Map<String, Object> jsonMap);

    JSONArray createJSONArray();

    JSONArray createJSONArray(String json);

    JSONObject createJSONObject();

    JSONObject createJSONObject(String jsonString);

    JSONObject createJSONObject(Map<String, String> jsonMap);

    boolean getBooleanFromJSONArray(JSONArray jsonArr, int index);

    boolean getBooleanFromJSONObject(JSONObject jsonObj, String key);

    double getDoubleFromJSONArray(JSONArray jsonArr, int index);

    double getDoubleFromJSONObject(JSONObject jsonObj, String key);

    int getIntFromJSONArray(JSONArray jsonArr, int index);

    int getIntFromJSONObject(JSONObject jsonObj, String key);

    JSONArray getJSONArrayFromJSONArray(JSONArray jsonArr, int index);

    JSONArray getJSONArrayFromJSONObject(JSONObject jsonObj, String key);

    JSONObject getJSONObjectFromJSONArray(JSONArray jsonArr, int index);

    JSONObject getJSONObjectFromJSONObject(JSONObject jsonObj, String key);

    ArrayList<String> getJSONObjectKeys(JSONObject jsonObj);

    long getLongFromJSONArray(JSONArray jsonArr, int index);

    long getLongFromJSONObject(JSONObject jsonObj, String key);

    Object getObjectFromJSONArray(JSONArray jsonArr, int index);

    Object getObjectFromJSONObject(JSONObject jsonObj, String key);

    String getStringFromJSONArray(JSONArray jsonArr, int index);

    String getStringFromJSONObject(JSONObject jsonObj, String key);

    boolean optBooleanFromJSONArray(JSONArray jsonArr, int index, boolean defaultValue);

    boolean optBooleanFromJSONObject(JSONObject jsonObj, String key, boolean defaultValue);

    double optDoubleFromJSONArray(JSONArray jsonArr, int index, double defaultValue);

    double optDoubleFromJSONObject(JSONObject jsonObj, String key, double defaultValue);

    int optIntFromJSONArray(JSONArray jsonArr, int index, int defaultValue);

    int optIntFromJSONObject(JSONObject jsonObj, String key, int defaultValue);

    JSONArray optJSONArrayFromJSONArray(JSONArray jsonArr, int index, JSONArray defaultValue);

    JSONArray optJSONArrayFromJSONObject(JSONObject jsonObj, String key, JSONArray defaultValue);

    JSONObject optJSONObjectFromJSONArray(JSONArray jsonArr, int index, JSONObject defaultValue);

    JSONObject optJSONObjectFromJSONObject(JSONObject jsonObj, String key, JSONObject defaultValue);

    long optLongFromJSONArray(JSONArray jsonArr, int index, long defaultValue);

    long optLongFromJSONObject(JSONObject jsonObj, String key, long defaultValue);

    Object optObjectFromJSONArray(JSONArray jsonArr, int index, Object defaultValue);

    Object optObjectFromJSONObject(JSONObject jsonObj, String key, Object defaultValue);

    String optStringFromJSONArray(JSONArray jsonArr, int index, String defaultValue);

    String optStringFromJSONObject(JSONObject jsonObj, String key, String defaultValue);

    void pushValueToJSONArray(JSONArray jsonArr, Object value);

    void putKVToJSONObject(JSONObject jsonObj, String key, Object value);
}
