package com.bytedance.platform.settingsx.convert;

import com.bytedance.platform.settingsx.api.ITypeConverter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class LongMap2StrConvert implements ITypeConverter<Map<String, Long>> {
    @Override // com.bytedance.platform.settingsx.api.ITypeConverter
    public Map<String, Long> to(String str) {
        if (str == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            HashMap hashMap = new HashMap();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, Long.valueOf(jSONObject.optLong(next)));
            }
            return hashMap;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.bytedance.platform.settingsx.api.ITypeConverter
    public String from(Map<String, Long> map) {
        if (map == null) {
            return null;
        }
        return new JSONObject(map).toString();
    }
}
