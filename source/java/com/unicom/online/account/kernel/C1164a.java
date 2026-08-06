package com.unicom.online.account.kernel;

import android.content.Context;
import android.util.DisplayMetrics;

/* renamed from: com.unicom.online.account.kernel.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1164a {

    /* renamed from: a */
    private static float f219a;

    /* renamed from: b */
    private static DisplayMetrics f220b;

    /* renamed from: c */
    private static float f221c;

    /* renamed from: a */
    public static void m443a(Context context) {
        f220b = new DisplayMetrics();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        f220b = displayMetrics;
        float f = displayMetrics.densityDpi;
        f219a = f;
        f221c = f / 160.0f;
    }

    public final String toString() {
        return " dmDensityDpi:" + f219a;
    }
}
