package com.xiaomi.clientreport.data;

import com.ss.android.deviceregister.base.RegistrationHeaderHelper;
import com.vivo.push.PushClientConstants;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.C1504bk;
import com.xiaomi.push.C1694j;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.xiaomi.clientreport.data.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1419a {
    public String clientInterfaceId;
    private String pkgName;
    public int production;
    public int reportType;
    private String sdkVersion;

    /* renamed from: os */
    private String f753os = C1504bk.m1663a();
    private String miuiVersion = C1694j.m3421a();

    public void setAppPackageName(String str) {
        this.pkgName = str;
    }

    public String getPackageName() {
        return this.pkgName;
    }

    public void setSdkVersion(String str) {
        this.sdkVersion = str;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("production", this.production);
            jSONObject.put("reportType", this.reportType);
            jSONObject.put("clientInterfaceId", this.clientInterfaceId);
            jSONObject.put(RegistrationHeaderHelper.KEY_OS, this.f753os);
            jSONObject.put("miuiVersion", this.miuiVersion);
            jSONObject.put(PushClientConstants.TAG_PKG_NAME, this.pkgName);
            jSONObject.put("sdkVersion", this.sdkVersion);
            return jSONObject;
        } catch (JSONException e) {
            AbstractC1417b.m1093a(e);
            return null;
        }
    }

    public String toJsonString() {
        JSONObject json = toJson();
        return json == null ? "" : json.toString();
    }
}
