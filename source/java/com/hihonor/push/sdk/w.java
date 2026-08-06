package com.hihonor.push.sdk;

import android.text.TextUtils;
import java.util.Arrays;

/* loaded from: classes6.dex */
public class w {
    public final String a;
    public final int b;

    public w(String str) {
        this.a = str;
        this.b = a(str);
    }

    public static w a(String str) {
        return new w(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || w.class != obj.getClass()) {
            return false;
        }
        return TextUtils.equals(this.a, ((w) obj).a);
    }

    public final int hashCode() {
        return this.b;
    }

    public static int a(Object... objArr) {
        return Arrays.hashCode(objArr);
    }
}
