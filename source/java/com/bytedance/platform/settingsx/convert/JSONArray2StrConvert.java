package com.bytedance.platform.settingsx.convert;

import com.bytedance.platform.settingsx.api.ITypeConverter;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes4.dex */
public class JSONArray2StrConvert implements ITypeConverter<JSONArray> {
    @Override // com.bytedance.platform.settingsx.api.ITypeConverter
    public JSONArray to(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new JSONArray(str);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.bytedance.platform.settingsx.api.ITypeConverter
    public String from(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        return jSONArray.toString();
    }
}
