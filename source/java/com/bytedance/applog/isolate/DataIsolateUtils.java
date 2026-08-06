package com.bytedance.applog.isolate;

import com.bytedance.applog.store.BaseData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class DataIsolateUtils {
    public static Map<String, List<BaseData>> splitBaseDataByIsolateKey(DataIsolateKey dataIsolateKey, List<BaseData> list) {
        HashMap hashMap = new HashMap();
        for (BaseData baseData : list) {
            String isolateKeyValue = getIsolateKeyValue(dataIsolateKey, baseData, "");
            if (!hashMap.containsKey(isolateKeyValue)) {
                hashMap.put(isolateKeyValue, new ArrayList());
            }
            ((List) hashMap.get(isolateKeyValue)).add(baseData);
        }
        return hashMap;
    }

    public static String getIsolateKeyValue(DataIsolateKey dataIsolateKey, JSONObject jSONObject, String str) {
        return (jSONObject == null || dataIsolateKey == null || dataIsolateKey != DataIsolateKey.USER_ID) ? str : jSONObject.optString("user_id", "0");
    }

    public static String getIsolateKeyValue(DataIsolateKey dataIsolateKey, BaseData baseData, String str) {
        return (baseData == null || dataIsolateKey == null || dataIsolateKey != DataIsolateKey.USER_ID) ? str : String.valueOf(baseData.user_id);
    }
}
