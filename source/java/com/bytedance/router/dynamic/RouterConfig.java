package com.bytedance.router.dynamic;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.router.util.Logger;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class RouterConfig {
    private Map<String, String> mIncMapping = Collections.emptyMap();
    private Map<String, String> mRewriteMapping = Collections.emptyMap();
    private String mTag;

    public RouterConfig(String str) {
        this.mTag = "";
        this.mTag = str;
    }

    public void setIncMapping(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            this.mIncMapping = Collections.emptyMap();
        } else {
            this.mIncMapping = map;
        }
    }

    public void setRewriteMapping(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            this.mRewriteMapping = Collections.emptyMap();
        } else {
            this.mRewriteMapping = map;
        }
    }

    public Map<String, String> getIncMapping() {
        return this.mIncMapping;
    }

    public Map<String, String> getRewriteMapping() {
        return this.mRewriteMapping;
    }

    public static RouterConfig load(String str) {
        return parse(str);
    }

    private static RouterConfig parse(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            RouterConfig routerConfig = new RouterConfig(jSONObject.optString("tag"));
            routerConfig.setIncMapping(parseJsonArray(jSONObject.optJSONArray("incMapping")));
            routerConfig.setRewriteMapping(parseJsonArray(jSONObject.optJSONArray("rewriteMapping")));
            return routerConfig;
        } catch (JSONException e) {
            e.printStackTrace();
            Logger.e("DynamicMapping#load failed: " + str);
            return null;
        }
    }

    public static Map<String, String> parseJsonArray(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < jSONArray.length(); i++) {
            String optString = jSONArray.optString(i);
            if (!TextUtils.isEmpty(optString)) {
                String[] split = optString.split(",");
                if (split.length != 2) {
                    Logger.e("DynamicMapping#parseJsonArray illegal schema mapping: " + optString);
                } else {
                    String str = split[0];
                    if (str == null || split[1] == null) {
                        Logger.e("DynamicMapping#parseJsonArray illegal schema mapping(null): " + optString);
                    } else {
                        split[0] = str.trim();
                        split[1] = split[1].trim();
                        if (TextUtils.isEmpty(split[0]) || TextUtils.isEmpty(split[1])) {
                            Logger.e("DynamicMapping#parseJsonArray illegal schema mapping empty: " + optString);
                        } else {
                            hashMap.put(split[0], split[1]);
                        }
                    }
                }
            }
        }
        return hashMap;
    }

    public static boolean isExpired(Context context, RouterConfig routerConfig) {
        String str = "";
        if (context == null || routerConfig == null) {
            return true;
        }
        try {
            str = "" + context.getPackageManager().getPackageInfo(context.getPackageName(), 128).versionCode;
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle != null) {
                str = str + "_" + String.valueOf(bundle.getInt("UPDATE_VERSION_CODE"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return TextUtils.isEmpty(str) || !str.equals(routerConfig.mTag);
    }

    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tag", this.mTag);
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, String> entry : this.mIncMapping.entrySet()) {
                jSONArray.put(entry.getKey() + "," + entry.getValue());
            }
            jSONObject.put("incMapping", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            for (Map.Entry<String, String> entry2 : this.mRewriteMapping.entrySet()) {
                jSONArray2.put(entry2.getKey() + "," + entry2.getValue());
            }
            jSONObject.put("rewriteMapping", jSONArray2);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
