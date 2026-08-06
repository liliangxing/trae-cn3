package com.xiaomi.push.service;

import android.app.Notification;
import android.content.Context;
import android.os.SystemClock;
import android.service.notification.StatusBarNotification;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes7.dex */
public class d {
    private static List<a> a = new CopyOnWriteArrayList();

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(Context context, StatusBarNotification statusBarNotification, int i) {
        if (!com.xiaomi.push.j.m10105a(context) || i <= 0 || statusBarNotification == null) {
            return;
        }
        a(new a(statusBarNotification.getKey(), SystemClock.elapsedRealtime(), i, ag.m10168a(statusBarNotification.getNotification())));
    }

    private static void a(a aVar) {
        a.add(aVar);
        a();
    }

    private static void a() {
        for (int size = a.size() - 1; size >= 0; size--) {
            a aVar = a.get(size);
            if (SystemClock.elapsedRealtime() - aVar.f1031a > 5000) {
                a.remove(aVar);
            }
        }
        if (a.size() > 10) {
            a.remove(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class a {
        public final int a;

        /* renamed from: a, reason: collision with other field name */
        public final long f1031a;

        /* renamed from: a, reason: collision with other field name */
        public final String f1032a;

        /* renamed from: a, reason: collision with other field name */
        public final Notification.Action[] f1033a;

        a(String str, long j, int i, Notification.Action[] actionArr) {
            this.f1032a = str;
            this.f1031a = j;
            this.a = i;
            this.f1033a = actionArr;
        }
    }
}
