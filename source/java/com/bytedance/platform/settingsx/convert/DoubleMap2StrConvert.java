package com.bytedance.platform.settingsx.convert;

import com.bytedance.platform.settingsx.api.ITypeConverter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class DoubleMap2StrConvert implements ITypeConverter<Map<String, Double>> {
    @Override // com.bytedance.platform.settingsx.api.ITypeConverter
    public Map<String, Double> to(String str) {
        if (str == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            HashMap hashMap = new HashMap();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, Double.valueOf(jSONObject.optDouble(next)));
            }
            return hashMap;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.bytedance.platform.settingsx.api.ITypeConverter
    public String from(Map<String, Double> map) {
        if (map == null) {
            return null;
        }
        return new JSONObject(map).toString();
    }
}
