package com.cmic.sso.sdk.p008d;

import android.text.TextUtils;
import com.cmic.sso.sdk.auth.AuthnHelper;
import com.cmic.sso.sdk.p003c.p005b.AbstractC0118g;
import com.heytap.mcssdk.constant.C0879b;
import com.huawei.hms.push.AttributionReporter;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: LogBean.java */
/* renamed from: com.cmic.sso.sdk.d.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0129a extends AbstractC0118g {

    /* renamed from: A */
    private String f277A;

    /* renamed from: o */
    private JSONArray f292o;

    /* renamed from: x */
    private String f301x;

    /* renamed from: y */
    private String f302y;

    /* renamed from: z */
    private String f303z;

    /* renamed from: b */
    private String f279b = null;

    /* renamed from: c */
    private String f280c = null;

    /* renamed from: d */
    private String f281d = null;

    /* renamed from: e */
    private String f282e = null;

    /* renamed from: f */
    private String f283f = null;

    /* renamed from: g */
    private String f284g = null;

    /* renamed from: h */
    private String f285h = null;

    /* renamed from: i */
    private String f286i = null;

    /* renamed from: j */
    private String f287j = null;

    /* renamed from: k */
    private String f288k = "";

    /* renamed from: l */
    private String f289l = null;

    /* renamed from: m */
    private String f290m = null;

    /* renamed from: n */
    private String f291n = null;

    /* renamed from: p */
    private String f293p = null;

    /* renamed from: q */
    private String f294q = null;

    /* renamed from: r */
    private String f295r = null;

    /* renamed from: s */
    private String f296s = null;

    /* renamed from: t */
    private String f297t = null;

    /* renamed from: u */
    private String f298u = null;

    /* renamed from: v */
    private String f299v = null;

    /* renamed from: w */
    private String f300w = null;

    /* renamed from: a */
    public CopyOnWriteArrayList<Throwable> f278a = new CopyOnWriteArrayList<>();

    @Override // com.cmic.sso.sdk.p003c.p005b.AbstractC0118g
    /* renamed from: a */
    public String mo196a() {
        return null;
    }

    @Override // com.cmic.sso.sdk.p003c.p005b.AbstractC0118g
    /* renamed from: a_ */
    protected String mo218a_(String str) {
        return null;
    }

    /* renamed from: b */
    public void m286b(String str) {
        this.f279b = str;
    }

    /* renamed from: c */
    public void m287c(String str) {
        this.f299v = str;
    }

    /* renamed from: d */
    public void m288d(String str) {
        this.f300w = str;
    }

    /* renamed from: e */
    public void m289e(String str) {
        this.f295r = str;
    }

    /* renamed from: f */
    public void m290f(String str) {
        this.f290m = str;
    }

    /* renamed from: g */
    public void m291g(String str) {
        this.f289l = str;
    }

    /* renamed from: h */
    public void m292h(String str) {
        this.f288k = str;
    }

    /* renamed from: i */
    public void m293i(String str) {
        this.f281d = str;
    }

    /* renamed from: j */
    public void m294j(String str) {
        this.f282e = str;
    }

    /* renamed from: k */
    public void m295k(String str) {
        this.f283f = str;
    }

    /* renamed from: l */
    public void m296l(String str) {
        this.f286i = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m285a(JSONArray jSONArray) {
        this.f292o = jSONArray;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: m */
    public void m297m(String str) {
        this.f298u = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: n */
    public void m298n(String str) {
        this.f293p = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: o */
    public void m299o(String str) {
        this.f296s = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: p */
    public void m300p(String str) {
        this.f297t = str;
    }

    /* renamed from: q */
    public void m301q(String str) {
        this.f291n = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: r */
    public void m302r(String str) {
        this.f280c = str;
    }

    /* renamed from: s */
    public void m303s(String str) {
        this.f284g = str;
    }

    /* renamed from: t */
    public void m304t(String str) {
        this.f285h = str;
    }

    /* renamed from: u */
    public void m305u(String str) {
        this.f287j = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: w */
    public void m306w(String str) {
        this.f294q = str;
    }

    /* renamed from: x */
    public void m307x(String str) {
        this.f301x = str;
    }

    /* renamed from: y */
    public void m308y(String str) {
        this.f302y = str;
    }

    /* renamed from: z */
    public void m309z(String str) {
        this.f303z = str;
    }

    /* renamed from: A */
    public void m284A(String str) {
        this.f277A = str;
    }

    @Override // com.cmic.sso.sdk.p003c.p005b.AbstractC0118g
    /* renamed from: b */
    public JSONObject mo219b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(HiAnalyticsConstant.HaKey.BI_KEY_APPID, this.f279b);
            jSONObject.put("traceId", this.f280c);
            jSONObject.put("appName", this.f281d);
            jSONObject.put(AttributionReporter.APP_VERSION, this.f282e);
            jSONObject.put(C0879b.f554C, AuthnHelper.SDK_VERSION);
            jSONObject.put("clientType", "android");
            jSONObject.put("timeOut", this.f283f);
            jSONObject.put("requestTime", this.f284g);
            jSONObject.put("responseTime", this.f285h);
            jSONObject.put("elapsedTime", this.f286i);
            jSONObject.put("requestType", this.f287j);
            jSONObject.put("interfaceType", this.f288k);
            jSONObject.put("interfaceCode", this.f289l);
            jSONObject.put("interfaceElasped", this.f290m);
            jSONObject.put("loginType", this.f291n);
            jSONObject.put("exceptionStackTrace", this.f292o);
            jSONObject.put("operatorType", this.f293p);
            jSONObject.put("networkType", this.f294q);
            jSONObject.put("brand", this.f295r);
            jSONObject.put("reqDevice", this.f296s);
            jSONObject.put("reqSystem", this.f297t);
            jSONObject.put("simCardNum", this.f298u);
            jSONObject.put("imsiState", this.f299v);
            jSONObject.put("resultCode", this.f300w);
            jSONObject.put("AID", this.f301x);
            jSONObject.put("sysOperType", this.f302y);
            jSONObject.put("scripType", this.f303z);
            if (!TextUtils.isEmpty(this.f277A)) {
                jSONObject.put("networkTypeByAPI", this.f277A);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
