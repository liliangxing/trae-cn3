package com.huawei.hms.push;

import android.text.TextUtils;
import com.bytedance.webx.addr.AddressParam;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.log.HMSLog;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PushSelfShowMessage.java */
/* renamed from: com.huawei.hms.push.o */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1225o {

    /* renamed from: B */
    private int f1697B;

    /* renamed from: D */
    private String f1699D;

    /* renamed from: b */
    private int f1703b;

    /* renamed from: c */
    private String f1704c;

    /* renamed from: d */
    private String f1705d;

    /* renamed from: l */
    private String f1713l;

    /* renamed from: m */
    private String f1714m;

    /* renamed from: n */
    private String f1715n;

    /* renamed from: o */
    private String f1716o;

    /* renamed from: p */
    private String f1717p;

    /* renamed from: r */
    private String f1719r;

    /* renamed from: s */
    private String f1720s;

    /* renamed from: z */
    private String f1727z;

    /* renamed from: a */
    private String f1702a = "";

    /* renamed from: e */
    private String f1706e = "";

    /* renamed from: f */
    private String f1707f = "";

    /* renamed from: g */
    private String f1708g = "";

    /* renamed from: h */
    private String f1709h = "";

    /* renamed from: i */
    private String f1710i = "";

    /* renamed from: j */
    private String f1711j = "";

    /* renamed from: k */
    private String f1712k = "";

    /* renamed from: q */
    private String f1718q = "";

    /* renamed from: t */
    private int f1721t = EnumC1221k.STYLE_DEFAULT.ordinal();

    /* renamed from: u */
    private String f1722u = "";

    /* renamed from: v */
    private String f1723v = "";

    /* renamed from: w */
    private String f1724w = "";

    /* renamed from: x */
    private int f1725x = 0;

    /* renamed from: y */
    private int f1726y = 0;

    /* renamed from: A */
    private String f1696A = "";

    /* renamed from: C */
    private String f1698C = "";

    /* renamed from: E */
    private String f1700E = "";

    /* renamed from: F */
    private String f1701F = "";

    public C1225o(byte[] bArr, byte[] bArr2) {
        Charset charset = C1223m.f1692a;
        this.f1719r = new String(bArr, charset);
        this.f1720s = new String(bArr2, charset);
    }

    /* renamed from: a */
    private JSONObject m1983a(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(RemoteMessageConst.MessageBody.MSG_CONTENT, jSONObject);
        jSONObject2.put("group", this.f1702a);
        jSONObject2.put("tag", this.f1696A);
        jSONObject2.put(RemoteMessageConst.Notification.AUTO_CANCEL, this.f1725x);
        jSONObject2.put("visibility", this.f1726y);
        jSONObject2.put(RemoteMessageConst.Notification.WHEN, this.f1727z);
        return jSONObject2;
    }

    /* renamed from: b */
    private JSONObject m1985b(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("cmd", this.f1708g);
        jSONObject2.put("content", this.f1709h);
        jSONObject2.put(RemoteMessageConst.Notification.NOTIFY_ICON, this.f1710i);
        jSONObject2.put(RemoteMessageConst.Notification.NOTIFY_TITLE, this.f1711j);
        jSONObject2.put("notifySummary", this.f1712k);
        jSONObject2.put(RemoteMessageConst.MessageBody.PARAM, jSONObject);
        return jSONObject2;
    }

    /* renamed from: c */
    private void m1986c(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("ap")) {
            String string = jSONObject.getString("ap");
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(string) && string.length() < 48) {
                int length = 48 - string.length();
                for (int i = 0; i < length; i++) {
                    sb.append(AddressParam.TYPE_DISAPPROVE);
                }
                sb.append(string);
                this.f1705d = sb.toString();
                return;
            }
            this.f1705d = string.substring(0, 48);
        }
    }

    /* renamed from: d */
    private boolean m1987d(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return false;
        }
        if (jSONObject.has(RemoteMessageConst.Notification.CLICK_ACTION)) {
            this.f1714m = jSONObject.getString(RemoteMessageConst.Notification.CLICK_ACTION);
        }
        if (jSONObject.has(RemoteMessageConst.Notification.INTENT_URI)) {
            this.f1704c = jSONObject.getString(RemoteMessageConst.Notification.INTENT_URI);
        }
        if (jSONObject.has("appPackageName")) {
            this.f1713l = jSONObject.getString("appPackageName");
            return true;
        }
        HMSLog.m2115d("PushSelfShowLog", "appPackageName is null");
        return false;
    }

    /* renamed from: e */
    private boolean m1988e(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has(RemoteMessageConst.MSGID)) {
            Object obj = jSONObject.get(RemoteMessageConst.MSGID);
            if (obj instanceof String) {
                this.f1706e = (String) obj;
                return true;
            }
            if (!(obj instanceof Integer)) {
                return true;
            }
            this.f1706e = String.valueOf(((Integer) obj).intValue());
            return true;
        }
        HMSLog.m2120i("PushSelfShowLog", "msgId == null");
        return false;
    }

    /* renamed from: f */
    private boolean m1989f(JSONObject jSONObject) {
        HMSLog.m2115d("PushSelfShowLog", "enter parseNotifyParam");
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(RemoteMessageConst.MessageBody.NOTIFY_DETAIL);
            if (jSONObject2.has("style")) {
                this.f1721t = jSONObject2.getInt("style");
            }
            this.f1722u = jSONObject2.optString("bigTitle");
            this.f1723v = jSONObject2.optString("bigContent");
            this.f1700E = jSONObject2.optString(RemoteMessageConst.Notification.ICON);
            return true;
        } catch (JSONException e) {
            HMSLog.m2120i("PushSelfShowLog", e.toString());
            return false;
        }
    }

    /* renamed from: g */
    private void m1990g(JSONObject jSONObject) {
        this.f1702a = jSONObject.optString("group");
        HMSLog.m2115d("PushSelfShowLog", "NOTIFY_GROUP:" + this.f1702a);
        this.f1725x = jSONObject.optInt(RemoteMessageConst.Notification.AUTO_CANCEL, 1);
        HMSLog.m2115d("PushSelfShowLog", "autoCancel: " + this.f1725x);
        this.f1726y = jSONObject.optInt("visibility", 0);
        this.f1727z = jSONObject.optString(RemoteMessageConst.Notification.WHEN);
        this.f1696A = jSONObject.optString("tag");
    }

    /* renamed from: h */
    private boolean m1991h(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(RemoteMessageConst.MessageBody.PARAM);
            if (jSONObject2.has("autoClear")) {
                this.f1703b = jSONObject2.getInt("autoClear");
            } else {
                this.f1703b = 0;
            }
            if (!"app".equals(this.f1708g) && !"cosa".equals(this.f1708g)) {
                if ("url".equals(this.f1708g)) {
                    m1994k(jSONObject2);
                    return true;
                }
                if (!"rp".equals(this.f1708g)) {
                    return true;
                }
                m1993j(jSONObject2);
                return true;
            }
            m1987d(jSONObject2);
            return true;
        } catch (Exception e) {
            HMSLog.m2119e("PushSelfShowLog", "ParseParam error ", e);
            return false;
        }
    }

    /* renamed from: i */
    private boolean m1992i(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has(RemoteMessageConst.MessageBody.PS_CONTENT)) {
            JSONObject jSONObject2 = jSONObject.getJSONObject(RemoteMessageConst.MessageBody.PS_CONTENT);
            this.f1708g = jSONObject2.getString("cmd");
            this.f1709h = jSONObject2.optString("content");
            this.f1710i = jSONObject2.optString(RemoteMessageConst.Notification.NOTIFY_ICON);
            this.f1711j = jSONObject2.optString(RemoteMessageConst.Notification.NOTIFY_TITLE);
            this.f1712k = jSONObject2.optString("notifySummary");
            this.f1699D = jSONObject2.optString(RemoteMessageConst.Notification.TICKER);
            if ((!jSONObject2.has(RemoteMessageConst.MessageBody.NOTIFY_DETAIL) || m1989f(jSONObject2)) && jSONObject2.has(RemoteMessageConst.MessageBody.PARAM)) {
                return m1991h(jSONObject2);
            }
        }
        return false;
    }

    /* renamed from: j */
    private boolean m1993j(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return false;
        }
        if (jSONObject.has("appPackageName")) {
            this.f1713l = jSONObject.getString("appPackageName");
        }
        if (jSONObject.has("rpt") && jSONObject.has("rpl")) {
            this.f1716o = jSONObject.getString("rpl");
            this.f1717p = jSONObject.getString("rpt");
            if (!jSONObject.has("rpct")) {
                return true;
            }
            this.f1718q = jSONObject.getString("rpct");
            return true;
        }
        HMSLog.m2115d("PushSelfShowLog", "rpl or rpt is null");
        return false;
    }

    /* renamed from: k */
    private boolean m1994k(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return false;
        }
        if (jSONObject.has("url")) {
            this.f1715n = jSONObject.getString("url");
            if (jSONObject.has("appPackageName")) {
                this.f1713l = jSONObject.getString("appPackageName");
            }
            if (!jSONObject.has("rpt") || !jSONObject.has("rpl")) {
                return true;
            }
            this.f1716o = jSONObject.getString("rpl");
            this.f1717p = jSONObject.getString("rpt");
            if (!jSONObject.has("rpct")) {
                return true;
            }
            this.f1718q = jSONObject.getString("rpct");
            return true;
        }
        HMSLog.m2115d("PushSelfShowLog", "url is null");
        return false;
    }

    /* renamed from: q */
    private JSONObject m1995q() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("style", this.f1721t);
        jSONObject.put("bigTitle", this.f1722u);
        jSONObject.put("bigContent", this.f1723v);
        jSONObject.put("bigPic", this.f1724w);
        return jSONObject;
    }

    /* renamed from: u */
    private JSONObject m1996u() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("autoClear", this.f1703b);
        jSONObject.put("url", this.f1715n);
        jSONObject.put("rpl", this.f1716o);
        jSONObject.put("rpt", this.f1717p);
        jSONObject.put("rpct", this.f1718q);
        jSONObject.put("appPackageName", this.f1713l);
        jSONObject.put(RemoteMessageConst.Notification.CLICK_ACTION, this.f1714m);
        jSONObject.put(RemoteMessageConst.Notification.INTENT_URI, this.f1704c);
        return jSONObject;
    }

    /* renamed from: l */
    public String m2009l() {
        return this.f1700E;
    }

    /* renamed from: m */
    public String m2010m() {
        return this.f1704c;
    }

    /* renamed from: n */
    public byte[] m2011n() {
        try {
            return m1983a(m1984a(m1985b(m1996u()), m1995q())).toString().getBytes(C1223m.f1692a);
        } catch (JSONException e) {
            HMSLog.m2119e("PushSelfShowLog", "getMsgData failed JSONException:", e);
            return new byte[0];
        }
    }

    /* renamed from: o */
    public String m2012o() {
        HMSLog.m2115d("PushSelfShowLog", "msgId =" + this.f1706e);
        return this.f1706e;
    }

    /* renamed from: p */
    public String m2013p() {
        return this.f1696A;
    }

    /* renamed from: r */
    public int m2014r() {
        return this.f1697B;
    }

    /* renamed from: s */
    public String m2015s() {
        return this.f1712k;
    }

    /* renamed from: t */
    public String m2016t() {
        return this.f1711j;
    }

    /* renamed from: v */
    public int m2017v() {
        return this.f1721t;
    }

    /* renamed from: w */
    public String m2018w() {
        return this.f1699D;
    }

    /* renamed from: x */
    public byte[] m2019x() {
        return this.f1720s.getBytes(C1223m.f1692a);
    }

    /* renamed from: y */
    public boolean m2020y() {
        try {
            if (TextUtils.isEmpty(this.f1719r)) {
                HMSLog.m2115d("PushSelfShowLog", "msg is null");
                return false;
            }
            JSONObject jSONObject = new JSONObject(this.f1719r);
            m1990g(jSONObject);
            JSONObject jSONObject2 = jSONObject.getJSONObject(RemoteMessageConst.MessageBody.MSG_CONTENT);
            if (!m1988e(jSONObject2)) {
                return false;
            }
            this.f1707f = jSONObject2.optString("dispPkgName");
            m1986c(jSONObject2);
            this.f1697B = jSONObject2.optInt(RemoteMessageConst.Notification.NOTIFY_ID, -1);
            this.f1698C = jSONObject2.optString("data");
            this.f1701F = jSONObject2.optString(RemoteMessageConst.ANALYTIC_INFO);
            return m1992i(jSONObject2);
        } catch (JSONException unused) {
            HMSLog.m2115d("PushSelfShowLog", "parse message exception.");
            return false;
        } catch (Exception e) {
            HMSLog.m2115d("PushSelfShowLog", e.toString());
            return false;
        }
    }

    /* renamed from: a */
    private JSONObject m1984a(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("dispPkgName", this.f1707f);
        jSONObject3.put(RemoteMessageConst.MSGID, this.f1706e);
        jSONObject3.put("ap", this.f1705d);
        jSONObject3.put(RemoteMessageConst.Notification.NOTIFY_ID, this.f1697B);
        jSONObject3.put(RemoteMessageConst.MessageBody.PS_CONTENT, jSONObject);
        jSONObject3.put(RemoteMessageConst.MessageBody.NOTIFY_DETAIL, jSONObject2);
        jSONObject3.put(RemoteMessageConst.Notification.TICKER, this.f1699D);
        jSONObject3.put("data", this.f1698C);
        return jSONObject3;
    }

    /* renamed from: b */
    public String m1999b() {
        return this.f1701F;
    }

    /* renamed from: d */
    public int m2001d() {
        return this.f1725x;
    }

    /* renamed from: e */
    public int m2002e() {
        return this.f1703b;
    }

    /* renamed from: c */
    public String m2000c() {
        return this.f1713l;
    }

    /* renamed from: j */
    public String m2007j() {
        return this.f1707f;
    }

    /* renamed from: g */
    public String m2004g() {
        return this.f1722u;
    }

    /* renamed from: a */
    public String m1997a() {
        return this.f1714m;
    }

    /* renamed from: f */
    public String m2003f() {
        return this.f1723v;
    }

    /* renamed from: a */
    public void m1998a(int i) {
        this.f1697B = i;
    }

    /* renamed from: k */
    public String m2008k() {
        return this.f1702a;
    }

    /* renamed from: h */
    public String m2005h() {
        return this.f1708g;
    }

    /* renamed from: i */
    public String m2006i() {
        return this.f1709h;
    }
}
