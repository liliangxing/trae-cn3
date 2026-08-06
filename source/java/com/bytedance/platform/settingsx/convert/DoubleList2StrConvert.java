package com.bytedance.platform.settingsx.convert;

import com.bytedance.platform.settingsx.api.ITypeConverter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes4.dex */
public class DoubleList2StrConvert implements ITypeConverter<List<Double>> {
    @Override // com.bytedance.platform.settingsx.api.ITypeConverter
    public List<Double> to(String str) {
        if (str == null) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(Double.valueOf(jSONArray.optDouble(i)));
            }
            return arrayList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.bytedance.platform.settingsx.api.ITypeConverter
    public String from(List<Double> list) {
        if (list == null) {
            return null;
        }
        return new JSONArray((Collection) list).toString();
    }
}
