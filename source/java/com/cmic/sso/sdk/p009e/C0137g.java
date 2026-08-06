package com.cmic.sso.sdk.p009e;

import android.content.Context;

/* compiled from: PermissionUtils.java */
/* renamed from: com.cmic.sso.sdk.e.g */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0137g {
    /* renamed from: a */
    public static boolean m339a(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }
}
