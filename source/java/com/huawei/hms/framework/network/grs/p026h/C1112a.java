package com.huawei.hms.framework.network.grs.p026h;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.Logger;
import com.lynx.tasm.animation.AnimationConstant;
import java.util.Locale;

/* renamed from: com.huawei.hms.framework.network.grs.h.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1112a {
    /* renamed from: a */
    public static String m1363a() {
        return "8.0.1.304";
    }

    /* renamed from: a */
    public static String m1364a(Context context) {
        if (context == null) {
            return "";
        }
        if (ContextHolder.getAppContext() != null) {
            context = ContextHolder.getAppContext();
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), AnimationConstant.PROP_MAX_WIDTH).versionName;
        } catch (PackageManager.NameNotFoundException | RuntimeException e) {
            Logger.m1190w("AgentUtil", "", e);
            return "";
        }
    }

    /* renamed from: a */
    public static String m1365a(Context context, String str, String str2) {
        if (context == null) {
            return String.format(Locale.ROOT, str + "/%s", m1363a());
        }
        String packageName = (ContextHolder.getAppContext() == null ? context : ContextHolder.getAppContext()).getPackageName();
        String m1364a = m1364a(context);
        String str3 = Build.VERSION.RELEASE;
        String str4 = Build.MODEL;
        Locale locale = Locale.ROOT;
        String str5 = "%s/%s (Linux; Android %s; %s) " + str + "/%s %s";
        Object[] objArr = new Object[6];
        objArr[0] = packageName;
        objArr[1] = m1364a;
        objArr[2] = str3;
        objArr[3] = str4;
        objArr[4] = m1363a();
        if (TextUtils.isEmpty(str2)) {
            str2 = "no_service_name";
        }
        objArr[5] = str2;
        return String.format(locale, str5, objArr);
    }

    /* renamed from: b */
    public static String m1366b(Context context, String str, String str2) {
        return m1365a(context, str, str2);
    }
}
