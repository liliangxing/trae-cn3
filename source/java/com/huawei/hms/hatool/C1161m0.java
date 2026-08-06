package com.huawei.hms.hatool;

import android.util.Log;

/* renamed from: com.huawei.hms.hatool.m0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1161m0 {

    /* renamed from: a */
    private boolean f1517a = false;

    /* renamed from: b */
    private int f1518b = 4;

    /* renamed from: a */
    private static String m1625a() {
        return "FormalHASDK_2.2.0.315" + C1169p.m1672a();
    }

    /* renamed from: a */
    public void m1626a(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(System.lineSeparator()).append("======================================= ").append(System.lineSeparator()).append(m1625a()).append("").append(System.lineSeparator()).append("=======================================");
        Log.i("FormalHASDK", sb.toString());
        this.f1518b = i;
        this.f1517a = true;
    }

    /* renamed from: a */
    public void m1627a(int i, String str, String str2) {
        if (i == 3) {
            Log.d(str, str2);
            return;
        }
        if (i == 5) {
            Log.w(str, str2);
        } else if (i != 6) {
            Log.i(str, str2);
        } else {
            Log.e(str, str2);
        }
    }

    /* renamed from: b */
    public void m1628b(int i, String str, String str2) {
        m1627a(i, "FormalHASDK", str + "=> " + str2);
    }

    /* renamed from: b */
    public boolean m1629b(int i) {
        return this.f1517a && i >= this.f1518b;
    }
}
