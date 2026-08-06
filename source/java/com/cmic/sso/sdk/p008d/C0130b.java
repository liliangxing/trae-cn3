package com.cmic.sso.sdk.p008d;

import android.content.Context;
import android.text.TextUtils;
import com.cmic.sso.sdk.C0088a;
import com.cmic.sso.sdk.p001a.C0089a;
import com.cmic.sso.sdk.p003c.p006c.C0121a;
import com.cmic.sso.sdk.p003c.p006c.InterfaceC0124d;
import com.cmic.sso.sdk.p009e.C0133c;
import com.cmic.sso.sdk.p009e.C0136f;
import com.cmic.sso.sdk.p009e.C0141k;
import com.cmic.sso.sdk.p009e.C0143m;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: SendLog.java */
/* renamed from: com.cmic.sso.sdk.d.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0130b {

    /* renamed from: a */
    private C0088a f304a;

    /* renamed from: a */
    private static void m311a(C0129a c0129a, C0088a c0088a) {
        if (c0129a == null || c0088a == null) {
            return;
        }
        c0129a.m286b(c0088a.m68b(HiAnalyticsConstant.HaKey.BI_KEY_APPID, ""));
        c0129a.m289e(C0143m.m384a());
        c0129a.m292h(c0088a.m68b("interfaceType", ""));
        c0129a.m291g(c0088a.m68b("interfaceCode", ""));
        c0129a.m290f(c0088a.m68b("interfaceElasped", ""));
        c0129a.m295k(c0088a.m67b("timeOut"));
        c0129a.m302r(c0088a.m67b("traceId"));
        c0129a.m297m(c0088a.m67b("simCardNum"));
        c0129a.m298n(c0088a.m67b("operatortype"));
        c0129a.m299o(C0143m.m387b());
        c0129a.m300p(C0143m.m388c());
        c0129a.m306w(String.valueOf(c0088a.m64b("networktype", 0)));
        c0129a.m303s(c0088a.m67b("starttime"));
        c0129a.m304t(c0088a.m67b("endtime"));
        c0129a.m296l(String.valueOf(c0088a.m65b("systemEndTime", 0L) - c0088a.m65b("systemStartTime", 0L)));
        c0129a.m287c(c0088a.m67b("imsiState"));
        c0129a.m307x(C0141k.m374b("AID", ""));
        c0129a.m308y(c0088a.m67b("operatortype"));
        c0129a.m309z(c0088a.m67b("scripType"));
        c0129a.m284A(c0088a.m67b("networkTypeByAPI"));
        C0133c.m326a("SendLog", "traceId" + c0088a.m67b("traceId"));
    }

    /* renamed from: a */
    public void m314a(Context context, String str, C0088a c0088a) {
        JSONArray jSONArray;
        String str2 = "";
        try {
            C0129a m55a = c0088a.m55a();
            String m336b = C0136f.m336b(context);
            m55a.m288d(str);
            m55a.m305u(c0088a.m68b("loginMethod", ""));
            if (c0088a.m69b("isCacheScrip", false)) {
                m55a.m301q("scrip");
            } else {
                m55a.m301q("pgw");
            }
            m55a.m293i(C0136f.m335a(context));
            if (!TextUtils.isEmpty(m336b)) {
                str2 = m336b;
            }
            m55a.m294j(str2);
            m311a(m55a, c0088a);
            if (m55a.f278a.size() > 0) {
                jSONArray = new JSONArray();
                Iterator<Throwable> it = m55a.f278a.iterator();
                while (it.hasNext()) {
                    Throwable next = it.next();
                    StringBuffer stringBuffer = new StringBuffer();
                    JSONObject jSONObject = new JSONObject();
                    for (StackTraceElement stackTraceElement : next.getStackTrace()) {
                        stringBuffer.append("\n").append(stackTraceElement.toString());
                    }
                    jSONObject.put("message", next.toString());
                    jSONObject.put("stack", stringBuffer.toString());
                    jSONArray.put(jSONObject);
                }
                m55a.f278a.clear();
            } else {
                jSONArray = null;
            }
            if (jSONArray != null && jSONArray.length() > 0) {
                m55a.m285a(jSONArray);
            }
            C0133c.m326a("SendLog", "登录日志");
            m313a(m55a.mo219b(), c0088a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m313a(JSONObject jSONObject, C0088a c0088a) {
        this.f304a = c0088a;
        m312a(jSONObject);
    }

    /* renamed from: a */
    private void m312a(JSONObject jSONObject) {
        C0121a.m254a().m257a(jSONObject, this.f304a, new InterfaceC0124d() { // from class: com.cmic.sso.sdk.d.b.1
            @Override // com.cmic.sso.sdk.p003c.p006c.InterfaceC0124d
            /* renamed from: a */
            public void mo127a(String str, String str2, JSONObject jSONObject2) {
                C0089a m66b = C0130b.this.f304a.m66b();
                HashMap hashMap = new HashMap();
                if (!str.equals("103000")) {
                    if (m66b.m94l() != 0 && m66b.m93k() != 0) {
                        int m363a = C0141k.m363a("logFailTimes", 0) + 1;
                        if (m363a >= m66b.m93k()) {
                            hashMap.put("logFailTimes", 0);
                            hashMap.put("logCloseTime", Long.valueOf(System.currentTimeMillis()));
                        } else {
                            hashMap.put("logFailTimes", Integer.valueOf(m363a));
                        }
                    }
                } else {
                    hashMap.put("logFailTimes", 0);
                    hashMap.put("logCloseTime", 0L);
                }
                C0141k.m372a(hashMap);
            }
        });
    }
}
