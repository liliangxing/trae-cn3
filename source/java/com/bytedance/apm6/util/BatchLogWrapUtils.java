package com.bytedance.apm6.util;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class BatchLogWrapUtils {
    private static final String KEY_TYPE_DESCRIPTION = "wrapper_type_description";
    public static final String KEY_WRAPPER_ARRAY_DATA = "wrapper_array_data";
    private static final int TYPE_DESCRIPTION = 1;

    public static JSONObject wrapData(String str, JSONArray jSONArray) {
        try {
            JSONObject put = new JSONObject().put(KEY_WRAPPER_ARRAY_DATA, jSONArray);
            put.put("log_type", str);
            put.put(KEY_TYPE_DESCRIPTION, 1);
            return put;
        } catch (Exception unused) {
            return null;
        }
    }

    public static List<Object> stripData(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (jSONObject.optInt(KEY_TYPE_DESCRIPTION, -1) != 1) {
            arrayList.add(jSONObject);
            return arrayList;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray(KEY_WRAPPER_ARRAY_DATA);
        if (optJSONArray == null) {
            return null;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            try {
                arrayList.add(optJSONArray.get(i));
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }
}
