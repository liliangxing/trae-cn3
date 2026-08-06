package com.huawei.hms.push;

import android.R;
import android.app.Notification;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: NotificationIconUtil.java */
/* renamed from: com.huawei.hms.push.h */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1218h {
    /* renamed from: a */
    private static int m1957a(Context context) {
        int i = context.getApplicationInfo().icon;
        if (i != 0) {
            return i;
        }
        int identifier = context.getResources().getIdentifier("btn_star_big_on", "drawable", "android");
        HMSLog.m2115d("PushSelfShowLog", "icon is btn_star_big_on ");
        if (identifier != 0) {
            return identifier;
        }
        HMSLog.m2115d("PushSelfShowLog", "icon is sym_def_app_icon ");
        return R.drawable.sym_def_app_icon;
    }

    /* renamed from: b */
    private static int m1960b(Context context, C1225o c1225o) {
        int i = 0;
        if (context != null && c1225o != null) {
            if (!TextUtils.isEmpty(c1225o.m2009l())) {
                String[] split = c1225o.m2009l().split("/");
                if (split.length == 3) {
                    i = C1232s.m2037a(context, split[1], split[2]);
                }
            }
            if (i == 0) {
                i = C1232s.m2036a(context, "com.huawei.messaging.default_notification_icon");
            }
            return i != 0 ? i : m1957a(context);
        }
        HMSLog.m2120i("PushSelfShowLog", "enter getSmallIconId, context or msg is null");
        return 0;
    }

    /* renamed from: a */
    public static Bitmap m1958a(Context context, C1225o c1225o) {
        if (context == null || c1225o == null) {
            return null;
        }
        try {
            if (HwBuildEx.VERSION.EMUI_SDK_INT >= 11) {
                HMSLog.m2120i("PushSelfShowLog", "huawei phone, and emui5.0, need not show large icon.");
                return null;
            }
            if ("com.huawei.android.pushagent".equals(c1225o.m2007j())) {
                return null;
            }
            HMSLog.m2120i("PushSelfShowLog", "get left bitmap from " + c1225o.m2007j());
            return ((BitmapDrawable) context.getPackageManager().getApplicationIcon(c1225o.m2007j())).getBitmap();
        } catch (PackageManager.NameNotFoundException unused) {
            HMSLog.m2118e("PushSelfShowLog", "build left icon occur NameNotFoundException.");
            return null;
        } catch (Exception unused2) {
            HMSLog.m2118e("PushSelfShowLog", "build left icon occur Exception.");
            return null;
        }
    }

    /* renamed from: a */
    public static void m1959a(Context context, Notification.Builder builder, C1225o c1225o) {
        if (context != null && builder != null && c1225o != null) {
            builder.setSmallIcon(m1960b(context, c1225o));
        } else {
            HMSLog.m2118e("PushSelfShowLog", "msg is null");
        }
    }
}
