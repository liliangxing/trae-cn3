package com.huawei.hms.activity.internal;

import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class ForegroundInnerHeader {
    private int a;
    private String b;
    private String c;

    public void fromJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.a = JsonUtil.getIntValue(jSONObject, "apkVersion");
            this.b = JsonUtil.getStringValue(jSONObject, StrategyConstants.ACTION);
            this.c = JsonUtil.getStringValue(jSONObject, "responseCallbackKey");
        } catch (JSONException e) {
            HMSLog.e("ForegroundInnerHeader", "fromJson failed: " + e.getMessage());
        }
    }

    public String getAction() {
        return this.b;
    }

    public int getApkVersion() {
        return this.a;
    }

    public String getResponseCallbackKey() {
        return this.c;
    }

    public void setAction(String str) {
        this.b = str;
    }

    public void setApkVersion(int i) {
        this.a = i;
    }

    public void setResponseCallbackKey(String str) {
        this.c = str;
    }

    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("apkVersion", this.a);
            jSONObject.put(StrategyConstants.ACTION, this.b);
            jSONObject.put("responseCallbackKey", this.c);
        } catch (JSONException e) {
            HMSLog.e("ForegroundInnerHeader", "ForegroundInnerHeader toJson failed: " + e.getMessage());
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "apkVersion:" + this.a + ", action:" + this.b + ", responseCallbackKey:" + this.c;
    }
}
