package com.vivo.push.util;

import android.os.UserHandle;
import java.lang.reflect.Method;

/* compiled from: MultiUserManager.java */
/* loaded from: classes7.dex */
public final class v {
    private static int a = -1;

    public static int a() {
        int i = a;
        if (i != -1) {
            return i;
        }
        try {
            Method declaredMethod = UserHandle.class.getDeclaredMethod("myUserId", new Class[0]);
            declaredMethod.setAccessible(true);
            a = ((Integer) declaredMethod.invoke(null, null)).intValue();
            t.d("MultiUserManager", "getMyUserId = " + a);
            return a;
        } catch (Exception e) {
            t.a("MultiUserManager", "getMyUserId error " + e.getMessage());
            return 0;
        }
    }
}
