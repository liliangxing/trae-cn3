package com.cmic.sso.sdk.c.b;

import com.bytedance.android.sdk.bdticketguard.TicketGuardProviderKt;
import com.bytedance.bdinstall.loader.SstLoader;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ScripAndTokenParameter.java */
/* loaded from: classes6.dex */
public class h extends a {
    protected String y = "";
    protected String z = "";

    @Override // com.cmic.sso.sdk.c.b.a
    public void a(String str) {
        this.v = t(str);
    }

    public void w(String str) {
        this.y = t(str);
    }

    public void x(String str) {
        this.z = t(str);
    }

    @Override // com.cmic.sso.sdk.c.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ver", this.a);
            jSONObject.put("sdkver", this.b);
            jSONObject.put(HiAnalyticsConstant.HaKey.BI_KEY_APPID, this.c);
            jSONObject.put("imsi", this.d);
            jSONObject.put(OnekeyLoginConstants.OPERATOR_TYPE, this.e);
            jSONObject.put("networktype", this.f);
            jSONObject.put("mobilebrand", this.g);
            jSONObject.put("mobilemodel", this.h);
            jSONObject.put("mobilesystem", this.i);
            jSONObject.put("clienttype", this.j);
            jSONObject.put("interfacever", this.k);
            jSONObject.put("expandparams", this.l);
            jSONObject.put("msgid", this.m);
            jSONObject.put("timestamp", this.n);
            jSONObject.put("subimsi", this.o);
            jSONObject.put(TicketGuardProviderKt.PATH_SIGN, this.p);
            jSONObject.put("apppackage", this.q);
            jSONObject.put("appsign", this.r);
            jSONObject.put("ipv4_list", this.s);
            jSONObject.put(SstLoader.KEY_IPV6_LIST, this.t);
            jSONObject.put("sdkType", this.u);
            jSONObject.put("tempPDR", this.v);
            jSONObject.put("scrip", this.y);
            jSONObject.put("userCapaid", this.z);
            jSONObject.put("funcType", this.w);
            jSONObject.put("socketip", this.x);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.cmic.sso.sdk.c.b.g
    protected String a_(String str) {
        return this.b + this.c + this.d + this.e + this.f + this.g + this.h + this.i + this.j + this.m + this.n + str + this.o + this.q + this.r + this.s + this.t + this.u + this.v + this.y + this.z + this.w + this.x;
    }

    public String toString() {
        return this.a + ContainerUtils.FIELD_DELIMITER + this.b + ContainerUtils.FIELD_DELIMITER + this.c + ContainerUtils.FIELD_DELIMITER + this.d + ContainerUtils.FIELD_DELIMITER + this.e + ContainerUtils.FIELD_DELIMITER + this.f + ContainerUtils.FIELD_DELIMITER + this.g + ContainerUtils.FIELD_DELIMITER + this.h + ContainerUtils.FIELD_DELIMITER + this.i + ContainerUtils.FIELD_DELIMITER + this.j + ContainerUtils.FIELD_DELIMITER + this.k + ContainerUtils.FIELD_DELIMITER + this.l + ContainerUtils.FIELD_DELIMITER + this.m + ContainerUtils.FIELD_DELIMITER + this.n + ContainerUtils.FIELD_DELIMITER + this.o + ContainerUtils.FIELD_DELIMITER + this.p + ContainerUtils.FIELD_DELIMITER + this.q + ContainerUtils.FIELD_DELIMITER + this.r + "&&" + this.s + ContainerUtils.FIELD_DELIMITER + this.t + ContainerUtils.FIELD_DELIMITER + this.u + ContainerUtils.FIELD_DELIMITER + this.v + ContainerUtils.FIELD_DELIMITER + this.y + ContainerUtils.FIELD_DELIMITER + this.z + ContainerUtils.FIELD_DELIMITER + this.w + ContainerUtils.FIELD_DELIMITER + this.x;
    }
}
