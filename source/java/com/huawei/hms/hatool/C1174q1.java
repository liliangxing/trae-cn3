package com.huawei.hms.hatool;

import android.content.Context;
import android.os.UserManager;

/* renamed from: com.huawei.hms.hatool.q1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1174q1 {

    /* renamed from: c */
    private static C1174q1 f1542c = new C1174q1();

    /* renamed from: a */
    private boolean f1543a = false;

    /* renamed from: b */
    private Context f1544b = AbstractC1173q0.m1707i();

    private C1174q1() {
    }

    /* renamed from: b */
    public static C1174q1 m1714b() {
        return f1542c;
    }

    /* renamed from: a */
    public boolean m1715a() {
        if (!this.f1543a) {
            Context context = this.f1544b;
            if (context == null) {
                return false;
            }
            UserManager userManager = (UserManager) context.getSystemService("user");
            if (userManager != null) {
                this.f1543a = userManager.isUserUnlocked();
            } else {
                this.f1543a = false;
            }
        }
        return this.f1543a;
    }
}
