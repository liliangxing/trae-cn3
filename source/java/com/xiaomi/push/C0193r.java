package com.xiaomi.push;

import android.os.Looper;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Collection;

/* renamed from: com.xiaomi.push.r, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C0193r {
    public static int a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return i;
        }
    }

    public static long a(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return j;
        }
        try {
            return Long.parseLong(str);
        } catch (Exception unused) {
            return j;
        }
    }

    public static boolean a(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    /* renamed from: com.xiaomi.push.r$a */
    /* loaded from: classes7.dex */
    public static class a {
        private final String a;

        /* renamed from: a, reason: collision with other field name */
        private final StringBuilder f909a;
        private final String b;

        public a() {
            this(Constants.COLON_SEPARATOR, ",");
        }

        public a(String str, String str2) {
            this.f909a = new StringBuilder();
            this.a = str;
            this.b = str2;
        }

        public a a(String str, Object obj) {
            if (!TextUtils.isEmpty(str)) {
                if (this.f909a.length() > 0) {
                    this.f909a.append(this.b);
                }
                this.f909a.append(str).append(this.a).append(obj);
            }
            return this;
        }

        public String toString() {
            return this.f909a.toString();
        }
    }

    public static int b(String str, int i) {
        return !TextUtils.isEmpty(str) ? ((str.hashCode() / 10) * 10) + i : i;
    }

    public static boolean a() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }
}
