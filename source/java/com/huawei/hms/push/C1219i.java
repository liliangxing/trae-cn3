package com.huawei.hms.push;

import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.lang.reflect.InvocationTargetException;

/* compiled from: NotificationUtil.java */
/* renamed from: com.huawei.hms.push.i */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1219i {
    /* renamed from: a */
    public static boolean m1961a(Context context) {
        if (new PushPreferences(context, "push_notify_flag").getBoolean("notify_msg_enable")) {
            return false;
        }
        if (C1215e.m1953c()) {
            return ((NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION)).areNotificationsEnabled();
        }
        return m1962b(context);
    }

    /* renamed from: b */
    private static boolean m1962b(Context context) {
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String packageName = context.getApplicationContext().getPackageName();
        int i = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            return ((Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i), packageName)).intValue() == 0;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        }
    }
}
