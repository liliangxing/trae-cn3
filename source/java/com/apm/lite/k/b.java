package com.apm.lite.k;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* loaded from: classes2.dex */
public class b {
    private static DateFormat a;

    public static DateFormat a() {
        if (a == null) {
            a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        }
        return a;
    }
}
