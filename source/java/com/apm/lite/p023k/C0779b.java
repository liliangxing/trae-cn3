package com.apm.lite.p023k;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* renamed from: com.apm.lite.k.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0779b {

    /* renamed from: a */
    private static DateFormat f573a;

    /* renamed from: a */
    public static DateFormat m753a() {
        if (f573a == null) {
            f573a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        }
        return f573a;
    }
}
