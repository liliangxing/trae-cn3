package com.bytedance.platform.settingsx.convert;

import com.bytedance.platform.settingsx.api.ITypeConverter;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class JSONObject2StrConvert implements ITypeConverter<JSONObject> {
    @Override // com.bytedance.platform.settingsx.api.ITypeConverter
    public JSONObject to(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.bytedance.platform.settingsx.api.ITypeConverter
    public String from(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString();
    }
}
