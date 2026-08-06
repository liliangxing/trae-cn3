package com.heytap.mcssdk.utils;

import android.os.Binder;
import android.os.UserHandle;
import java.lang.reflect.Method;

/* renamed from: com.heytap.mcssdk.utils.g */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0898g {

    /* renamed from: a */
    private static final String f639a = "PushService";

    /* renamed from: b */
    private static final int f640b = 100000;

    /* renamed from: a */
    public static int m692a() {
        try {
            UserHandle callingUserHandle = Binder.getCallingUserHandle();
            Method declaredMethod = callingUserHandle.getClass().getDeclaredMethod("getIdentifier", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Integer) declaredMethod.invoke(callingUserHandle, new Object[0])).intValue();
        } catch (Exception e) {
            C0895d.m662b(f639a, "get userId exception," + e);
            return 0;
        }
    }

    /* renamed from: a */
    public static int m693a(int i, int i2) {
        return (i2 * f640b) + (i % f640b);
    }
}
