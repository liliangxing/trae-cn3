package com.huawei.hms.hatool;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.hms.framework.common.BundleUtil;
import java.util.Map;

/* renamed from: com.huawei.hms.hatool.d */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1133d {
    /* renamed from: a */
    public static long m1463a(Context context, String str, String str2, long j) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C1182v.m1786f("hmsSdk", "context is null or spName empty or spkey is empty");
            return j;
        }
        SharedPreferences m1467b = m1467b(context, str);
        return m1467b != null ? m1467b.getLong(str2, j) : j;
    }

    /* renamed from: a */
    public static String m1464a(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C1182v.m1786f("hmsSdk", "context is null or spName empty or spkey is empty");
            return str3;
        }
        SharedPreferences m1467b = m1467b(context, str);
        return m1467b != null ? m1467b.getString(str2, str3) : str3;
    }

    /* renamed from: a */
    public static Map<String, ?> m1465a(Context context, String str) {
        return m1467b(context, str).getAll();
    }

    /* renamed from: a */
    public static void m1466a(Context context, String str, String... strArr) {
        String str2;
        if (context == null || TextUtils.isEmpty(str)) {
            str2 = "clearData(): parameter error.context,spname";
        } else {
            if (strArr != null) {
                SharedPreferences m1467b = m1467b(context, str);
                if (m1467b != null) {
                    SharedPreferences.Editor edit = m1467b.edit();
                    if (strArr.length == 0) {
                        edit.clear();
                        edit.commit();
                        return;
                    }
                    for (String str3 : strArr) {
                        if (m1467b.contains(str3)) {
                            edit.remove(str3);
                            edit.commit();
                        }
                    }
                    return;
                }
                return;
            }
            str2 = "clearData(): No data need to be deleted,keys is null";
        }
        C1182v.m1786f("hmsSdk", str2);
    }

    /* renamed from: b */
    private static SharedPreferences m1467b(Context context, String str) {
        return context.getSharedPreferences(m1470c(context, str), 0);
    }

    /* renamed from: b */
    public static void m1468b(Context context, String str, String str2, long j) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C1182v.m1786f("hmsSdk", "context is null or spName empty or spkey is empty");
            return;
        }
        SharedPreferences m1467b = m1467b(context, str);
        if (m1467b != null) {
            SharedPreferences.Editor edit = m1467b.edit();
            edit.putLong(str2, j);
            edit.commit();
        }
    }

    /* renamed from: b */
    public static void m1469b(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C1182v.m1785e("hmsSdk", "context is null or spName empty or spkey is empty");
            return;
        }
        SharedPreferences m1467b = m1467b(context, str);
        if (m1467b != null) {
            SharedPreferences.Editor edit = m1467b.edit();
            edit.putString(str2, str3);
            edit.commit();
        }
    }

    /* renamed from: c */
    public static String m1470c(Context context, String str) {
        String packageName = context.getPackageName();
        String m1427n = AbstractC1126a1.m1427n("_hms_config_tag", "oper");
        return (TextUtils.isEmpty(m1427n) ? new StringBuilder("hms_").append(str).append(BundleUtil.UNDERLINE_TAG).append(packageName) : new StringBuilder("hms_").append(str).append(BundleUtil.UNDERLINE_TAG).append(packageName).append(BundleUtil.UNDERLINE_TAG).append(m1427n)).toString();
    }
}
