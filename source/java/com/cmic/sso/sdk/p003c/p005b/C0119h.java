package com.cmic.sso.sdk.p003c.p005b;

import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.lynx.tasm.base.trace.TraceEventDef;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ScripAndTokenParameter.java */
/* renamed from: com.cmic.sso.sdk.c.b.h */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0119h extends AbstractC0112a {

    /* renamed from: y */
    protected String f244y = "";

    /* renamed from: z */
    protected String f245z = "";

    @Override // com.cmic.sso.sdk.p003c.p005b.AbstractC0112a
    /* renamed from: a */
    public void mo197a(String str) {
        this.f214v = m216t(str);
    }

    /* renamed from: w */
    public void m251w(String str) {
        this.f244y = m216t(str);
    }

    /* renamed from: x */
    public void m252x(String str) {
        this.f245z = m216t(str);
    }

    @Override // com.cmic.sso.sdk.p003c.p005b.AbstractC0118g
    /* renamed from: b */
    public JSONObject mo219b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ver", this.f193a);
            jSONObject.put("sdkver", this.f194b);
            jSONObject.put(HiAnalyticsConstant.HaKey.BI_KEY_APPID, this.f195c);
            jSONObject.put("imsi", this.f196d);
            jSONObject.put("operatortype", this.f197e);
            jSONObject.put("networktype", this.f198f);
            jSONObject.put("mobilebrand", this.f199g);
            jSONObject.put("mobilemodel", this.f200h);
            jSONObject.put("mobilesystem", this.f201i);
            jSONObject.put("clienttype", this.f202j);
            jSONObject.put("interfacever", this.f203k);
            jSONObject.put("expandparams", this.f204l);
            jSONObject.put("msgid", this.f205m);
            jSONObject.put(TraceEventDef.TIMING_TIMESTAMP, this.f206n);
            jSONObject.put("subimsi", this.f207o);
            jSONObject.put("sign", this.f208p);
            jSONObject.put("apppackage", this.f209q);
            jSONObject.put("appsign", this.f210r);
            jSONObject.put("ipv4_list", this.f211s);
            jSONObject.put("ipv6_list", this.f212t);
            jSONObject.put("sdkType", this.f213u);
            jSONObject.put("tempPDR", this.f214v);
            jSONObject.put("scrip", this.f244y);
            jSONObject.put("userCapaid", this.f245z);
            jSONObject.put("funcType", this.f215w);
            jSONObject.put("socketip", this.f216x);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.cmic.sso.sdk.p003c.p005b.AbstractC0118g
    /* renamed from: a_ */
    protected String mo218a_(String str) {
        return this.f194b + this.f195c + this.f196d + this.f197e + this.f198f + this.f199g + this.f200h + this.f201i + this.f202j + this.f205m + this.f206n + str + this.f207o + this.f209q + this.f210r + this.f211s + this.f212t + this.f213u + this.f214v + this.f244y + this.f245z + this.f215w + this.f216x;
    }

    public String toString() {
        return this.f193a + ContainerUtils.FIELD_DELIMITER + this.f194b + ContainerUtils.FIELD_DELIMITER + this.f195c + ContainerUtils.FIELD_DELIMITER + this.f196d + ContainerUtils.FIELD_DELIMITER + this.f197e + ContainerUtils.FIELD_DELIMITER + this.f198f + ContainerUtils.FIELD_DELIMITER + this.f199g + ContainerUtils.FIELD_DELIMITER + this.f200h + ContainerUtils.FIELD_DELIMITER + this.f201i + ContainerUtils.FIELD_DELIMITER + this.f202j + ContainerUtils.FIELD_DELIMITER + this.f203k + ContainerUtils.FIELD_DELIMITER + this.f204l + ContainerUtils.FIELD_DELIMITER + this.f205m + ContainerUtils.FIELD_DELIMITER + this.f206n + ContainerUtils.FIELD_DELIMITER + this.f207o + ContainerUtils.FIELD_DELIMITER + this.f208p + ContainerUtils.FIELD_DELIMITER + this.f209q + ContainerUtils.FIELD_DELIMITER + this.f210r + "&&" + this.f211s + ContainerUtils.FIELD_DELIMITER + this.f212t + ContainerUtils.FIELD_DELIMITER + this.f213u + ContainerUtils.FIELD_DELIMITER + this.f214v + ContainerUtils.FIELD_DELIMITER + this.f244y + ContainerUtils.FIELD_DELIMITER + this.f245z + ContainerUtils.FIELD_DELIMITER + this.f215w + ContainerUtils.FIELD_DELIMITER + this.f216x;
    }
}
