package com.bytedance.frameworks.baselib.network.http.ok3.impl.metadispatch;

import android.text.TextUtils;
import com.bytedance.frameworks.baselib.network.config.hostpathmatch.TTHostPathRuleBaseTNCConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class TTMetaDispatchConfig extends TTHostPathRuleBaseTNCConfig<TTMetaDispatchValue> {
    @Override // com.bytedance.frameworks.baselib.network.config.hostpathmatch.TTHostPathRuleBaseTNCConfig
    public String getConfigRootKey() {
        return "ttnet_req_meta_dp";
    }

    @Override // com.bytedance.frameworks.baselib.network.config.hostpathmatch.TTHostPathRuleBaseTNCConfig
    public TTMetaDispatchValue parseHostPathValue(Object obj) {
        JSONObject jSONObject = obj instanceof JSONObject ? (JSONObject) obj : null;
        if (jSONObject == null) {
            return null;
        }
        TTMetaDispatchValue tTMetaDispatchValue = new TTMetaDispatchValue();
        tTMetaDispatchValue.queryAddMap = parseMapConfig(jSONObject.optJSONObject("query_add"));
        tTMetaDispatchValue.queryRmSet = parseJSONArrayToSet(jSONObject.optJSONArray("query_rm"));
        tTMetaDispatchValue.headerAddMap = parseMapConfig(jSONObject.optJSONObject("header_add"));
        tTMetaDispatchValue.headerRmSet = parseJSONArrayToSet(jSONObject.optJSONArray("header_rm"));
        return tTMetaDispatchValue;
    }

    private Map<String, String> parseMapConfig(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        if (jSONObject != null && jSONObject.length() != 0) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String optString = jSONObject.optString(next);
                if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(optString)) {
                    hashMap.put(next, optString);
                }
            }
        }
        return hashMap;
    }
}
