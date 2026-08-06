package com.xiaomi.push;

import android.os.Looper;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Collection;

/* renamed from: com.xiaomi.push.r */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1703r {
    /* renamed from: a */
    public static int m3472a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return i;
        }
    }

    /* renamed from: a */
    public static long m3473a(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return j;
        }
        try {
            return Long.parseLong(str);
        } catch (Exception unused) {
            return j;
        }
    }

    /* renamed from: a */
    public static boolean m3475a(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    /* renamed from: com.xiaomi.push.r$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class a {

        /* renamed from: a */
        private final String f2834a;

        /* renamed from: a */
        private final StringBuilder f2835a;

        /* renamed from: b */
        private final String f2836b;

        public a() {
            this(Constants.COLON_SEPARATOR, Constants.ACCEPT_TIME_SEPARATOR_SP);
        }

        public a(String str, String str2) {
            this.f2835a = new StringBuilder();
            this.f2834a = str;
            this.f2836b = str2;
        }

        /* renamed from: a */
        public a m3477a(String str, Object obj) {
            if (!TextUtils.isEmpty(str)) {
                if (this.f2835a.length() > 0) {
                    this.f2835a.append(this.f2836b);
                }
                this.f2835a.append(str).append(this.f2834a).append(obj);
            }
            return this;
        }

        public String toString() {
            return this.f2835a.toString();
        }
    }

    /* renamed from: b */
    public static int m3476b(String str, int i) {
        return !TextUtils.isEmpty(str) ? ((str.hashCode() / 10) * 10) + i : i;
    }

    /* renamed from: a */
    public static boolean m3474a() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }
}
