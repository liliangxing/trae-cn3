package com.bytedance.crash.npth_repair.utils;

import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class RepairPortrait {
    private String[] mApiLevels;
    private String[] mBrands;
    private JSONObject mCustomConfig;

    public static RepairPortrait createRepairPortrait(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() < 2) {
            return null;
        }
        return new RepairPortrait(jSONArray);
    }

    public RepairPortrait(JSONArray jSONArray) {
        try {
            this.mApiLevels = jSONArray.optString(0).split(",");
            this.mBrands = jSONArray.optString(1).split(",");
            this.mCustomConfig = new JSONObject();
            for (int i = 2; i < jSONArray.length(); i++) {
                String optString = jSONArray.optString(i);
                if (!"".equals(optString)) {
                    String[] split = optString.split(Constants.COLON_SEPARATOR);
                    if (split.length == 2) {
                        this.mCustomConfig.putOpt(split[0], split[1]);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static boolean checkSupport(String[] strArr, String str) {
        if (strArr == null || strArr.length == 0 || "none".equals(strArr[0])) {
            return false;
        }
        if ("all".equals(strArr[0])) {
            return true;
        }
        for (String str2 : strArr) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkApiLevel(int i) {
        return checkSupport(this.mApiLevels, String.valueOf(i));
    }

    public boolean checkBrand(String str) {
        return checkSupport(this.mBrands, str);
    }

    public String getCustomConfig(String str) {
        return (this.mCustomConfig == null || str == null || "".equals(str)) ? "" : this.mCustomConfig.optString(str);
    }

    public JSONArray getCustomConfigArray(String str) {
        if (this.mCustomConfig == null || str == null) {
            return null;
        }
        if (!"".equals(str)) {
            try {
            } catch (JSONException unused) {
                return null;
            }
        }
        return new JSONArray(this.mCustomConfig.optString(str));
    }

    public boolean checkCustomConfig(String str, String str2) {
        return getCustomConfig(str).equals(str2);
    }
}
