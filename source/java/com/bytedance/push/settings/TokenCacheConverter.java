package com.bytedance.push.settings;

import com.bytedance.push.model.TokenCache;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes4.dex */
public class TokenCacheConverter implements ITypeConverter<List<TokenCache>>, IDefaultValueProvider<List<TokenCache>> {
    @Override // com.bytedance.push.settings.ITypeConverter
    public List<TokenCache> to(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                TokenCache parse = TokenCache.parse(jSONArray.optJSONObject(i));
                if (parse != null) {
                    arrayList.add(parse);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    @Override // com.bytedance.push.settings.ITypeConverter
    public String from(List<TokenCache> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null) {
            for (TokenCache tokenCache : list) {
                if (tokenCache != null) {
                    jSONArray.put(tokenCache.toJson());
                }
            }
        }
        return jSONArray.toString();
    }

    @Override // com.bytedance.push.settings.IDefaultValueProvider
    public List<TokenCache> create() {
        return new ArrayList();
    }
}
