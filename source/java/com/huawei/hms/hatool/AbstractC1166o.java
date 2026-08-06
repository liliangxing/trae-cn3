package com.huawei.hms.hatool;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.lynx.tasm.animation.AnimationConstant;
import java.lang.reflect.InvocationTargetException;

/* renamed from: com.huawei.hms.hatool.o */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public abstract class AbstractC1166o {

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.huawei.hms.hatool.o$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class a extends Exception {
        a(String str) {
            super(str);
        }
    }

    /* renamed from: a */
    private static Object m1651a(Class cls, String str, Class[] clsArr, Object[] objArr) {
        String str2;
        if (cls == null) {
            throw new a("class is null in invokeStaticFun");
        }
        if (clsArr == null) {
            if (objArr != null) {
                throw new a("paramsType is null, but params is not null");
            }
        } else {
            if (objArr == null) {
                throw new a("paramsType or params should be same");
            }
            if (clsArr.length != objArr.length) {
                throw new a("paramsType len:" + clsArr.length + " should equal params.len:" + objArr.length);
            }
        }
        try {
        } catch (NoSuchMethodException unused) {
            C1182v.m1786f("hmsSdk", "invokeStaticFun(): cls.getMethod(),No Such Method !");
        }
        try {
            return cls.getMethod(str, clsArr).invoke(null, objArr);
        } catch (IllegalAccessException unused2) {
            str2 = "invokeStaticFun(): method invoke Exception!";
            C1182v.m1786f("hmsSdk", str2);
            return null;
        } catch (IllegalArgumentException unused3) {
            str2 = "invokeStaticFun(): Illegal Argument!";
            C1182v.m1786f("hmsSdk", str2);
            return null;
        } catch (InvocationTargetException unused4) {
            str2 = "invokeStaticFun(): Invocation Target Exception!";
            C1182v.m1786f("hmsSdk", str2);
            return null;
        }
    }

    /* renamed from: a */
    private static Object m1652a(String str, String str2, Class[] clsArr, Object[] objArr) {
        String str3;
        try {
            return m1651a(Class.forName(str), str2, clsArr, objArr);
        } catch (a unused) {
            str3 = "invokeStaticFun(): Static function call Exception ";
            C1182v.m1786f("hmsSdk", str3);
            return null;
        } catch (ClassNotFoundException unused2) {
            str3 = "invokeStaticFun() Not found class!";
            C1182v.m1786f("hmsSdk", str3);
            return null;
        }
    }

    /* renamed from: a */
    public static String m1653a() {
        return m1655a("ro.build.version.emui", "");
    }

    /* renamed from: a */
    public static String m1654a(Context context) {
        return context == null ? "" : m1660xe5268955(context.getContentResolver(), "android_id");
    }

    /* renamed from: a */
    public static String m1655a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        String m1656a = m1656a("android.os.SystemProperties", str, str2);
        return TextUtils.isEmpty(m1656a) ? m1656a("com.huawei.android.os.SystemPropertiesEx", str, str2) : m1656a;
    }

    /* renamed from: a */
    private static String m1656a(String str, String str2, String str3) {
        Object m1652a = m1652a(str, "get", new Class[]{String.class, String.class}, new Object[]{str2, str3});
        return m1652a != null ? (String) m1652a : str3;
    }

    /* renamed from: b */
    public static String m1657b() {
        String m1656a = m1656a("com.huawei.android.os.SystemPropertiesEx", "ro.huawei.build.display.id", "");
        C1182v.m1775a("hmsSdk", "SystemPropertiesEx: get rom_ver: " + m1656a);
        if (!TextUtils.isEmpty(m1656a)) {
            return m1656a;
        }
        String str = Build.DISPLAY;
        C1182v.m1781c("hmsSdk", "SystemProperties: get rom_ver: " + str);
        return str;
    }

    /* renamed from: b */
    public static String m1658b(Context context) {
        Bundle bundle;
        Object obj;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null || (obj = bundle.get("CHANNEL")) == null) {
                return "Unknown";
            }
            String obj2 = obj.toString();
            return obj2.length() > 256 ? "Unknown" : obj2;
        } catch (PackageManager.NameNotFoundException unused) {
            C1182v.m1786f("hmsSdk", "getChannel(): The packageName is not correct!");
            return "Unknown";
        }
    }

    /* renamed from: c */
    public static String m1659c(Context context) {
        return context == null ? "" : context.getPackageName();
    }

    /* renamed from: com_huawei_hms_hatool_o_android_provider_Settings$Secure_getString */
    private static String m1660xe5268955(ContentResolver contentResolver, String str) {
        HeliosApiHook heliosApiHook = new HeliosApiHook();
        Object[] objArr = {contentResolver, str};
        ExtraInfo extraInfo = new ExtraInfo(false, "(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;");
        Result preInvoke = heliosApiHook.preInvoke(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, objArr, "java.lang.String", extraInfo);
        if (preInvoke.isIntercept()) {
            heliosApiHook.postInvoke(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, objArr, (Object) null, extraInfo, false);
            return (String) preInvoke.getReturnValue();
        }
        String string = Settings.Secure.getString(contentResolver, str);
        heliosApiHook.postInvoke(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, objArr, string, extraInfo, true);
        return string;
    }

    /* renamed from: d */
    public static String m1661d(Context context) {
        if (context == null) {
            return "";
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(m1659c(context), AnimationConstant.PROP_MAX_WIDTH);
            return packageInfo != null ? packageInfo.versionName : "";
        } catch (PackageManager.NameNotFoundException unused) {
            C1182v.m1786f("hmsSdk", "getVersion(): The package name is not correct!");
            return "";
        }
    }
}
