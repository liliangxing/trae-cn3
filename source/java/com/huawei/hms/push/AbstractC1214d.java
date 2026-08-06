package com.huawei.hms.push;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.log.HMSLog;
import com.lynx.tasm.animation.AnimationConstant;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import org.json.JSONObject;

/* compiled from: CommFun.java */
/* renamed from: com.huawei.hms.push.d */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public abstract class AbstractC1214d {

    /* renamed from: a */
    private static final Object f1683a = new Object();

    /* renamed from: b */
    private static int f1684b = -1;

    /* renamed from: a */
    private static boolean m1940a(Context context) {
        HMSLog.m2115d("CommFun", "existFrameworkPush:" + f1684b);
        try {
            File file = new File("/system/framework/hwpush.jar");
            if (m1939a()) {
                HMSLog.m2115d("CommFun", "push jarFile is exist");
            } else {
                if (!file.isFile()) {
                    return false;
                }
                HMSLog.m2115d("CommFun", "push jarFile is exist");
            }
            return true;
        } catch (Exception e) {
            HMSLog.m2118e("CommFun", "get Apk version faild ,Exception e= " + e.toString());
            return false;
        }
    }

    /* renamed from: b */
    public static long m1942b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.huawei.android.pushagent", AnimationConstant.PROP_MAX_WIDTH).versionCode;
        } catch (Exception unused) {
            HMSLog.m2118e("CommFun", "get nc versionCode error");
            return -1L;
        }
    }

    /* renamed from: c */
    public static boolean m1945c() {
        return HwBuildEx.VERSION.EMUI_SDK_INT < 19;
    }

    /* renamed from: d */
    public static boolean m1946d(Context context) {
        HMSLog.m2115d("CommFun", "existFrameworkPush:" + f1684b);
        synchronized (f1683a) {
            int i = f1684b;
            if (-1 != i) {
                return 1 == i;
            }
            if (m1940a(context)) {
                f1684b = 1;
            } else {
                f1684b = 0;
            }
            return 1 == f1684b;
        }
    }

    /* renamed from: c */
    public static String m1944c(Context context) {
        return AGConnectServicesConfig.fromContext(context).getString("client/project_id");
    }

    /* renamed from: b */
    public static boolean m1943b() {
        return HwBuildEx.VERSION.EMUI_SDK_INT >= 21;
    }

    /* renamed from: a */
    private static boolean m1939a() {
        try {
            Class<?> cls = Class.forName("huawei.cust.HwCfgFilePolicy");
            File file = (File) cls.getDeclaredMethod("getCfgFile", String.class, Integer.TYPE).invoke(cls, "jars/hwpush.jar", Integer.valueOf(((Integer) cls.getDeclaredField("CUST_TYPE_CONFIG").get(cls)).intValue()));
            if (file != null && file.exists()) {
                HMSLog.m2115d("CommFun", "get push cust File path success.");
                return true;
            }
        } catch (ClassNotFoundException unused) {
            HMSLog.m2118e("CommFun", "HwCfgFilePolicy ClassNotFoundException");
        } catch (IllegalAccessException unused2) {
            HMSLog.m2118e("CommFun", "check cust exist push IllegalAccessException.");
        } catch (IllegalArgumentException unused3) {
            HMSLog.m2118e("CommFun", "check cust exist push IllegalArgumentException.");
        } catch (NoSuchFieldException unused4) {
            HMSLog.m2118e("CommFun", "check cust exist push NoSuchFieldException.");
        } catch (NoSuchMethodException unused5) {
            HMSLog.m2118e("CommFun", "check cust exist push NoSuchMethodException.");
        } catch (SecurityException unused6) {
            HMSLog.m2118e("CommFun", "check cust exist push SecurityException.");
        } catch (InvocationTargetException unused7) {
            HMSLog.m2118e("CommFun", "check cust exist push InvocationTargetException.");
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m1941a(JSONObject jSONObject, JSONObject jSONObject2, String str) {
        return jSONObject == null || (TextUtils.isEmpty(str) && jSONObject2 == null);
    }
}
