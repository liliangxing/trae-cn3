package com.vivo.push.util;

import android.os.UserHandle;
import java.lang.reflect.Method;

/* compiled from: MultiUserManager.java */
/* renamed from: com.vivo.push.util.v */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1395v {

    /* renamed from: a */
    private static int f724a = -1;

    /* renamed from: a */
    public static int m1053a() {
        int i = f724a;
        if (i != -1) {
            return i;
        }
        try {
            Method declaredMethod = UserHandle.class.getDeclaredMethod("myUserId", new Class[0]);
            declaredMethod.setAccessible(true);
            f724a = ((Integer) declaredMethod.invoke(null, null)).intValue();
            C1393t.m1048d("MultiUserManager", "getMyUserId = " + f724a);
            return f724a;
        } catch (Exception e) {
            C1393t.m1034a("MultiUserManager", "getMyUserId error " + e.getMessage());
            return 0;
        }
    }
}
