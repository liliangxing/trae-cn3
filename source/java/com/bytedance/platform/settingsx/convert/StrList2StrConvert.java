package com.bytedance.platform.settingsx.convert;

import com.bytedance.platform.settingsx.api.ITypeConverter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes4.dex */
public class StrList2StrConvert implements ITypeConverter<List<String>> {
    @Override // com.bytedance.platform.settingsx.api.ITypeConverter
    public List<String> to(String str) {
        if (str == null) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.optString(i));
            }
            return arrayList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.bytedance.platform.settingsx.api.ITypeConverter
    public String from(List<String> list) {
        if (list == null) {
            return null;
        }
        return new JSONArray((Collection) list).toString();
    }
}
