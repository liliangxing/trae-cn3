package com.cmic.sso.sdk.p009e;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.huawei.hms.framework.common.ContainerUtils;

/* compiled from: PackageUtils.java */
/* renamed from: com.cmic.sso.sdk.e.f */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0136f {
    /* renamed from: c */
    private static PackageInfo m337c(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: d */
    private static String m338d(Context context) {
        PackageInfo m337c = m337c(context);
        return m337c == null ? "" : m337c.packageName;
    }

    /* renamed from: a */
    public static String m335a(Context context) {
        String str = null;
        try {
            PackageManager packageManager = context.getPackageManager();
            String str2 = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(m338d(context), 0));
            if (str2 != null) {
                return str2;
            }
            try {
                PackageInfo m337c = m337c(context);
                if (m337c == null) {
                    return null;
                }
                return context.getResources().getString(m337c.applicationInfo.labelRes);
            } catch (Exception e) {
                e = e;
                str = str2;
                e.printStackTrace();
                return str;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    /* renamed from: b */
    public static String m336b(Context context) {
        try {
            PackageInfo m337c = m337c(context);
            return m337c != null ? m338d(context) + ContainerUtils.FIELD_DELIMITER + m337c.versionName : "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
