package com.huawei.hms.push;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: PushSelfShowThread.java */
/* renamed from: com.huawei.hms.push.p */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1226p extends Thread {

    /* renamed from: a */
    private Context f1728a;

    /* renamed from: b */
    private C1225o f1729b;

    public C1226p(Context context, C1225o c1225o) {
        this.f1728a = context;
        this.f1729b = c1225o;
    }

    /* renamed from: a */
    private static Intent m2021a(Context context, C1225o c1225o) {
        if (c1225o == null) {
            return null;
        }
        Intent m1951b = C1215e.m1951b(context, c1225o.m2000c());
        if (c1225o.m2010m() != null) {
            try {
                Intent parseUri = Intent.parseUri(c1225o.m2010m(), 0);
                parseUri.setSelector(null);
                if (parseUri.getClipData() == null) {
                    parseUri.setClipData(ClipData.newPlainText("avoid intent add read permission flags", "avoid"));
                }
                HMSLog.m2115d("PushSelfShowLog", "Intent.parseUri(msg.intentUri, 0), action:" + parseUri.getAction());
                return C1215e.m1948a(context, c1225o.m2000c(), parseUri).booleanValue() ? parseUri : m1951b;
            } catch (Exception e) {
                HMSLog.m2121w("PushSelfShowLog", "intentUri error," + e.toString());
                return m1951b;
            }
        }
        if (c1225o.m1997a() != null) {
            Intent intent = new Intent(c1225o.m1997a());
            if (C1215e.m1948a(context, c1225o.m2000c(), intent).booleanValue()) {
                m1951b = intent;
            }
        }
        m1951b.setPackage(c1225o.m2000c());
        return m1951b;
    }

    /* renamed from: b */
    private boolean m2023b(Context context) {
        if ("cosa".equals(this.f1729b.m2005h())) {
            return m2022a(context);
        }
        return true;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        HMSLog.m2120i("PushSelfShowLog", "enter run()");
        try {
            if (!m2023b(this.f1728a) || m2024b(this.f1728a, this.f1729b)) {
                return;
            }
            C1224n.m1972a(this.f1728a, this.f1729b);
        } catch (Exception e) {
            HMSLog.m2118e("PushSelfShowLog", e.toString());
        }
    }

    /* renamed from: b */
    private boolean m2024b(Context context, C1225o c1225o) {
        if (!"cosa".equals(c1225o.m2005h()) || m2021a(context, c1225o) != null) {
            return false;
        }
        HMSLog.m2115d("PushSelfShowLog", "launchCosaApp,intent == null");
        return true;
    }

    /* renamed from: a */
    private boolean m2022a(Context context) {
        return C1215e.m1954c(context, this.f1729b.m2000c());
    }
}
