package com.bytedance.platform.settingsx.convert;

import com.bytedance.platform.settingsx.api.ITypeConverter;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes4.dex */
public class DoubleSet2StrConvert implements ITypeConverter<Set<Double>> {
    @Override // com.bytedance.platform.settingsx.api.ITypeConverter
    public Set<Double> to(String str) {
        if (str == null) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            HashSet hashSet = new HashSet();
            for (int i = 0; i < jSONArray.length(); i++) {
                hashSet.add(Double.valueOf(jSONArray.optDouble(i)));
            }
            return hashSet;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.bytedance.platform.settingsx.api.ITypeConverter
    public String from(Set<Double> set) {
        if (set == null) {
            return null;
        }
        return new JSONArray((Collection) set).toString();
    }
}
