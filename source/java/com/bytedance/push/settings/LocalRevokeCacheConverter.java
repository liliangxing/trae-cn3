package com.bytedance.push.settings;

import com.bytedance.push.model.LocalRevokeCache;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class LocalRevokeCacheConverter implements ITypeConverter<List<LocalRevokeCache>>, IDefaultValueProvider<List<LocalRevokeCache>> {
    @Override // com.bytedance.push.settings.IDefaultValueProvider
    public List<LocalRevokeCache> create() {
        return new ArrayList();
    }

    @Override // com.bytedance.push.settings.ITypeConverter
    public List<LocalRevokeCache> to(String str) {
        LocalRevokeCache parse;
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null && (parse = LocalRevokeCache.parse(optJSONObject)) != null) {
                    arrayList.add(parse);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return arrayList;
    }

    @Override // com.bytedance.push.settings.ITypeConverter
    public String from(List<LocalRevokeCache> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null) {
            for (LocalRevokeCache localRevokeCache : list) {
                if (localRevokeCache != null) {
                    jSONArray.put(localRevokeCache.toJson());
                }
            }
        }
        return jSONArray.toString();
    }
}
