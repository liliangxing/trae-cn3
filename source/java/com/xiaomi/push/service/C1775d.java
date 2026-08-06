package com.xiaomi.push.service;

import android.app.Notification;
import android.content.Context;
import android.os.SystemClock;
import android.service.notification.StatusBarNotification;
import com.xiaomi.push.C1694j;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.xiaomi.push.service.d */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1775d {

    /* renamed from: a */
    private static List<a> f3139a = new CopyOnWriteArrayList();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public static void m3826a(Context context, StatusBarNotification statusBarNotification, int i) {
        if (!C1694j.m3427a(context) || i <= 0 || statusBarNotification == null) {
            return;
        }
        m3827a(new a(statusBarNotification.getKey(), SystemClock.elapsedRealtime(), i, C1749ag.m3670a(statusBarNotification.getNotification())));
    }

    /* renamed from: a */
    private static void m3827a(a aVar) {
        f3139a.add(aVar);
        m3825a();
    }

    /* renamed from: a */
    private static void m3825a() {
        for (int size = f3139a.size() - 1; size >= 0; size--) {
            a aVar = f3139a.get(size);
            if (SystemClock.elapsedRealtime() - aVar.f3141a > 5000) {
                f3139a.remove(aVar);
            }
        }
        if (f3139a.size() > 10) {
            f3139a.remove(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.xiaomi.push.service.d$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class a {

        /* renamed from: a */
        public final int f3140a;

        /* renamed from: a */
        public final long f3141a;

        /* renamed from: a */
        public final String f3142a;

        /* renamed from: a */
        public final Notification.Action[] f3143a;

        a(String str, long j, int i, Notification.Action[] actionArr) {
            this.f3142a = str;
            this.f3141a = j;
            this.f3140a = i;
            this.f3143a = actionArr;
        }
    }
}
