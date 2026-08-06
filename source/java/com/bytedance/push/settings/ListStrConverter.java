package com.bytedance.push.settings;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;

/* loaded from: classes4.dex */
public class ListStrConverter implements ITypeConverter<List<String>>, IDefaultValueProvider<List<String>> {
    @Override // com.bytedance.push.settings.IDefaultValueProvider
    public List<String> create() {
        return new ArrayList();
    }

    @Override // com.bytedance.push.settings.ITypeConverter
    public List<String> to(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.optString(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    @Override // com.bytedance.push.settings.ITypeConverter
    public String from(List<String> list) {
        JSONArray jSONArray;
        if (list != null) {
            jSONArray = new JSONArray((Collection) list);
        } else {
            jSONArray = new JSONArray();
        }
        return jSONArray.toString();
    }
}
