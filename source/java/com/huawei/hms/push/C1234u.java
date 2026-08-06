package com.huawei.hms.push;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: SelfShowType.java */
/* renamed from: com.huawei.hms.push.u */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1234u {

    /* renamed from: c */
    private static final String[] f1748c = {"url", "app", "cosa", "rp"};

    /* renamed from: a */
    private Context f1749a;

    /* renamed from: b */
    private C1225o f1750b;

    public C1234u(Context context, C1225o c1225o) {
        this.f1749a = context;
        this.f1750b = c1225o;
    }

    /* renamed from: a */
    public static boolean m2046a(String str) {
        for (String str2 : f1748c) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private void m2047b() {
        HMSLog.m2120i("PushSelfShowLog", "run into launchCosaApp");
        try {
            HMSLog.m2120i("PushSelfShowLog", "enter launchExistApp cosa, appPackageName =" + this.f1750b.m2000c() + ",and msg.intentUri is " + this.f1750b.m2010m());
            Intent m1951b = C1215e.m1951b(this.f1749a, this.f1750b.m2000c());
            boolean z = false;
            if (this.f1750b.m2010m() != null) {
                try {
                    Intent parseUri = Intent.parseUri(this.f1750b.m2010m(), 0);
                    parseUri.setSelector(null);
                    if (parseUri.getClipData() == null) {
                        parseUri.setClipData(ClipData.newPlainText("avoid intent add read permission flags", "avoid"));
                    }
                    HMSLog.m2120i("PushSelfShowLog", "Intent.parseUri(msg.intentUri, 0), action:" + parseUri.getAction());
                    z = C1215e.m1948a(this.f1749a, this.f1750b.m2000c(), parseUri).booleanValue();
                    if (z) {
                        m1951b = parseUri;
                    }
                } catch (Exception e) {
                    HMSLog.m2121w("PushSelfShowLog", "intentUri error." + e.toString());
                }
            } else if (this.f1750b.m1997a() != null) {
                Intent intent = new Intent(this.f1750b.m1997a());
                if (C1215e.m1948a(this.f1749a, this.f1750b.m2000c(), intent).booleanValue()) {
                    m1951b = intent;
                }
            }
            if (m1951b == null) {
                HMSLog.m2120i("PushSelfShowLog", "launchCosaApp,intent == null");
                return;
            }
            m1951b.setPackage(this.f1750b.m2000c());
            if (z) {
                m1951b.addFlags(268435456);
            } else {
                m1951b.setFlags(805437440);
            }
            this.f1749a.startActivity(m1951b);
        } catch (Exception e2) {
            HMSLog.m2118e("PushSelfShowLog", "launch Cosa App exception." + e2.toString());
        }
    }

    /* renamed from: c */
    public void m2048c() {
        C1225o c1225o;
        HMSLog.m2115d("PushSelfShowLog", "enter launchNotify()");
        if (this.f1749a != null && (c1225o = this.f1750b) != null) {
            if ("app".equals(c1225o.m2005h())) {
                m2045a();
                return;
            }
            if ("cosa".equals(this.f1750b.m2005h())) {
                m2047b();
                return;
            }
            if ("rp".equals(this.f1750b.m2005h())) {
                HMSLog.m2121w("PushSelfShowLog", this.f1750b.m2005h() + " not support rich message.");
                return;
            } else if ("url".equals(this.f1750b.m2005h())) {
                HMSLog.m2121w("PushSelfShowLog", this.f1750b.m2005h() + " not support URL.");
                return;
            } else {
                HMSLog.m2115d("PushSelfShowLog", this.f1750b.m2005h() + " is not exist in hShowType");
                return;
            }
        }
        HMSLog.m2115d("PushSelfShowLog", "launchNotify  context or msg is null");
    }

    /* renamed from: a */
    private void m2045a() {
        try {
            HMSLog.m2120i("PushSelfShowLog", "enter launchApp, appPackageName =" + this.f1750b.m2000c());
            if (C1215e.m1954c(this.f1749a, this.f1750b.m2000c())) {
                m2047b();
            }
        } catch (Exception e) {
            HMSLog.m2118e("PushSelfShowLog", "launchApp error:" + e.toString());
        }
    }
}
