package com.huawei.hms.push;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.support.log.HMSLog;
import com.ss.ttm.player.C;

/* compiled from: SelfShowType.java */
/* loaded from: classes6.dex */
public class u {
    private static final String[] c = {"url", "app", "cosa", "rp"};
    private Context a;
    private o b;

    public u(Context context, o oVar) {
        this.a = context;
        this.b = oVar;
    }

    public static boolean a(String str) {
        for (String str2 : c) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private void b() {
        HMSLog.i("PushSelfShowLog", "run into launchCosaApp");
        try {
            HMSLog.i("PushSelfShowLog", "enter launchExistApp cosa, appPackageName =" + this.b.c() + ",and msg.intentUri is " + this.b.m());
            Intent b = e.b(this.a, this.b.c());
            boolean z = false;
            if (this.b.m() != null) {
                try {
                    Intent parseUri = Intent.parseUri(this.b.m(), 0);
                    parseUri.setSelector(null);
                    if (parseUri.getClipData() == null) {
                        parseUri.setClipData(ClipData.newPlainText("avoid intent add read permission flags", "avoid"));
                    }
                    HMSLog.i("PushSelfShowLog", "Intent.parseUri(msg.intentUri, 0), action:" + parseUri.getAction());
                    z = e.a(this.a, this.b.c(), parseUri).booleanValue();
                    if (z) {
                        b = parseUri;
                    }
                } catch (Exception e) {
                    HMSLog.w("PushSelfShowLog", "intentUri error." + e.toString());
                }
            } else if (this.b.a() != null) {
                Intent intent = new Intent(this.b.a());
                if (e.a(this.a, this.b.c(), intent).booleanValue()) {
                    b = intent;
                }
            }
            if (b == null) {
                HMSLog.i("PushSelfShowLog", "launchCosaApp,intent == null");
                return;
            }
            b.setPackage(this.b.c());
            if (z) {
                b.addFlags(C.ENCODING_PCM_MU_LAW);
            } else {
                b.setFlags(805437440);
            }
            this.a.startActivity(b);
        } catch (Exception e2) {
            HMSLog.e("PushSelfShowLog", "launch Cosa App exception." + e2.toString());
        }
    }

    public void c() {
        o oVar;
        HMSLog.d("PushSelfShowLog", "enter launchNotify()");
        if (this.a != null && (oVar = this.b) != null) {
            if ("app".equals(oVar.h())) {
                a();
                return;
            }
            if ("cosa".equals(this.b.h())) {
                b();
                return;
            }
            if ("rp".equals(this.b.h())) {
                HMSLog.w("PushSelfShowLog", this.b.h() + " not support rich message.");
                return;
            } else if ("url".equals(this.b.h())) {
                HMSLog.w("PushSelfShowLog", this.b.h() + " not support URL.");
                return;
            } else {
                HMSLog.d("PushSelfShowLog", this.b.h() + " is not exist in hShowType");
                return;
            }
        }
        HMSLog.d("PushSelfShowLog", "launchNotify  context or msg is null");
    }

    private void a() {
        try {
            HMSLog.i("PushSelfShowLog", "enter launchApp, appPackageName =" + this.b.c());
            if (e.c(this.a, this.b.c())) {
                b();
            }
        } catch (Exception e) {
            HMSLog.e("PushSelfShowLog", "launchApp error:" + e.toString());
        }
    }
}
