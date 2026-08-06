package com.cmic.sso.sdk.p009e;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/* compiled from: SignUtil.java */
/* renamed from: com.cmic.sso.sdk.e.l */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0142l {
    /* renamed from: a */
    public static byte[] m382a(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        if (context.getPackageName().equalsIgnoreCase(str)) {
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 64);
                if (packageInfo.packageName.equals(str)) {
                    return packageInfo.signatures[0].toByteArray();
                }
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
