package com.vivo.push.util;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: WindowPeriodManager.java */
/* renamed from: com.vivo.push.util.ai */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1374ai {

    /* renamed from: a */
    private static final SimpleDateFormat f671a = new SimpleDateFormat("yyyy-MM-dd");

    /* renamed from: b */
    private static final SimpleDateFormat f672b = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    /* renamed from: c */
    private static volatile C1374ai f673c;

    /* renamed from: d */
    private CopyOnWriteArrayList<a> f674d = new CopyOnWriteArrayList<>();

    /* renamed from: e */
    private String f675e;

    private C1374ai() {
    }

    /* renamed from: a */
    public static synchronized C1374ai m968a() {
        C1374ai c1374ai;
        synchronized (C1374ai.class) {
            if (f673c == null) {
                f673c = new C1374ai();
            }
            c1374ai = f673c;
        }
        return c1374ai;
    }

    /* renamed from: a */
    public final boolean m969a(String str) {
        long j;
        long j2;
        long j3;
        String str2;
        Date date;
        SimpleDateFormat simpleDateFormat;
        SimpleDateFormat simpleDateFormat2;
        String str3 = " ";
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        char c = 0;
        if (TextUtils.isEmpty(str)) {
            C1393t.m1046c("WindowPeriodManager", "invalid period");
        } else if (TextUtils.equals(str, this.f675e)) {
            C1393t.m1046c("WindowPeriodManager", "has already updated");
        } else {
            this.f675e = str;
            this.f674d.clear();
            Date date2 = new Date();
            long m950a = C1372ag.m950a();
            String[] split = str.split(";");
            int length = split.length;
            int i = 0;
            while (i < length) {
                String[] split2 = split[i].split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                if (split2.length == 2) {
                    try {
                        simpleDateFormat = f672b;
                        StringBuilder sb = new StringBuilder();
                        simpleDateFormat2 = f671a;
                        j = simpleDateFormat.parse(sb.append(simpleDateFormat2.format(date2)).append(str3).append(split2[c]).toString()).getTime();
                    } catch (Exception e) {
                        e = e;
                        j = -1;
                    }
                    try {
                        j3 = simpleDateFormat.parse(simpleDateFormat2.format(date2) + str3 + split2[1]).getTime();
                        j2 = j;
                    } catch (Exception e2) {
                        e = e2;
                        C1393t.m1034a("WindowPeriodManager", "parse window period failed." + e.getMessage());
                        j2 = j;
                        j3 = -1;
                        if (m950a > 0) {
                            str2 = str3;
                            date = date2;
                            this.f674d.add(new a(j2 - m950a, j3 - m950a));
                            C1393t.m1046c("WindowPeriodManager", "set window period to [" + split2[0] + ", " + split2[1] + "]");
                            i++;
                            str3 = str2;
                            date2 = date;
                            c = 0;
                        }
                        str2 = str3;
                        date = date2;
                        i++;
                        str3 = str2;
                        date2 = date;
                        c = 0;
                    }
                    if (m950a > 0 && j2 > 0 && j3 > 0 && j2 < j3) {
                        str2 = str3;
                        date = date2;
                        this.f674d.add(new a(j2 - m950a, j3 - m950a));
                        C1393t.m1046c("WindowPeriodManager", "set window period to [" + split2[0] + ", " + split2[1] + "]");
                        i++;
                        str3 = str2;
                        date2 = date;
                        c = 0;
                    }
                }
                str2 = str3;
                date = date2;
                i++;
                str3 = str2;
                date2 = date;
                c = 0;
            }
        }
        if (C1373ah.m960a(this.f674d)) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - C1372ag.m950a();
        Iterator<a> it = this.f674d.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (currentTimeMillis >= next.m970a() && currentTimeMillis <= next.m971b()) {
                return true;
            }
        }
        return false;
    }

    /* compiled from: WindowPeriodManager.java */
    /* renamed from: com.vivo.push.util.ai$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private static class a {

        /* renamed from: a */
        private long f676a;

        /* renamed from: b */
        private long f677b;

        public a(long j, long j2) {
            this.f676a = j;
            this.f677b = j2;
        }

        /* renamed from: a */
        public final long m970a() {
            return this.f676a;
        }

        /* renamed from: b */
        public final long m971b() {
            return this.f677b;
        }
    }
}
