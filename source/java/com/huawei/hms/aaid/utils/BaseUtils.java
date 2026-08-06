package com.huawei.hms.aaid.utils;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.opendevice.AbstractC1197e;
import com.huawei.hms.opendevice.AbstractC1202j;
import com.huawei.hms.opendevice.C1201i;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class BaseUtils {
    private BaseUtils() {
    }

    public static void clearSubjectIds(Context context) {
        C1201i.m1865a(context).removeKey("subjectId");
    }

    public static void delLocalToken(Context context, String str) {
        C1201i.m1865a(context).m1871c(str);
    }

    public static void deleteAllTokenCache(Context context) {
        C1201i.m1865a(context).m1867a();
    }

    public static void deleteCacheData(Context context, String str) {
        C1201i.m1865a(context).removeKey(str);
    }

    public static String getCacheData(Context context, String str, boolean z) {
        if (z) {
            return C1201i.m1865a(context).m1866a(str);
        }
        return C1201i.m1865a(context).getString(str);
    }

    public static String getLocalToken(Context context, String str) {
        return C1201i.m1865a(context).m1869b(str);
    }

    public static boolean getProxyInit(Context context) {
        return C1201i.m1865a(context).getBoolean("_proxy_init");
    }

    public static String[] getSubjectIds(Context context) {
        String string = C1201i.m1865a(context).getString("subjectId");
        return TextUtils.isEmpty(string) ? new String[0] : string.split(",");
    }

    public static void initSecret(Context context) {
        AbstractC1202j.m1872a(context);
    }

    public static boolean isMainProc(Context context) {
        String m1850a = AbstractC1197e.m1850a(context);
        String str = context.getApplicationInfo().processName;
        HMSLog.m2120i("BaseUtils", "main process name: " + str + ", current process name: " + m1850a);
        return str.equals(m1850a);
    }

    public static boolean saveCacheData(Context context, String str, String str2, boolean z) {
        if (z) {
            return C1201i.m1865a(context).m1868a(str, str2);
        }
        return C1201i.m1865a(context).saveString(str, str2);
    }

    public static void saveProxyInit(Context context, boolean z) {
        C1201i.m1865a(context).saveBoolean("_proxy_init", z);
    }

    public static void saveToken(Context context, String str, String str2) {
        C1201i.m1865a(context).m1870b(str, str2);
    }
}
