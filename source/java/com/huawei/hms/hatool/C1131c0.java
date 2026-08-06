package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import com.heytap.mcssdk.constant.C0878a;
import com.huawei.hms.framework.common.BundleUtil;
import java.io.File;

/* renamed from: com.huawei.hms.hatool.c0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1131c0 {
    /* renamed from: a */
    public static boolean m1452a(Context context) {
        return System.currentTimeMillis() - C1133d.m1463a(context, "Privacy_MY", "flashKeyTime", -1L) > C0878a.f521g;
    }

    /* renamed from: a */
    public static boolean m1453a(Context context, String str) {
        if (context == null) {
            return true;
        }
        if (context.checkSelfPermission(str) == 0) {
            return false;
        }
        C1182v.m1786f("hmsSdk", "not have read phone permission!");
        return true;
    }

    /* renamed from: a */
    public static boolean m1454a(Context context, String str, int i) {
        String str2 = C1133d.m1470c(context, str) + ".xml";
        File file = new File(context.getFilesDir(), "../shared_prefs/" + str2);
        if (!file.exists()) {
            file = new File(context.getFilesDir(), "../../shared_prefs/" + (context.getPackageName() + BundleUtil.UNDERLINE_TAG + str2));
        }
        long length = file.length();
        if (length <= i) {
            return false;
        }
        C1182v.m1781c("hmsSdk", String.format("reach local file limited size - file len: %d limitedSize: %d", Long.valueOf(length), Integer.valueOf(i)));
        return true;
    }

    /* renamed from: a */
    public static boolean m1455a(String str, long j, long j2) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            return j - Long.parseLong(str) > j2;
        } catch (NumberFormatException unused) {
            C1182v.m1786f("hmsSdk", "isTimeExpired(): Data type conversion error : number format !");
            return true;
        }
    }
}
