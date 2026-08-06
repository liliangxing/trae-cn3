package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.C1609fh;
import com.xiaomi.push.C1703r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.xiaomi.push.service.t */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1792t {

    /* renamed from: a */
    private static final Map<String, byte[]> f3219a = new HashMap();

    /* renamed from: a */
    private static ArrayList<Pair<String, byte[]>> f3218a = new ArrayList<>();

    /* renamed from: a */
    public static void m3982a(String str, byte[] bArr) {
        Map<String, byte[]> map = f3219a;
        synchronized (map) {
            AbstractC1417b.m1089a("pending registration request. " + str);
            map.put(str, bArr);
        }
    }

    /* renamed from: a */
    public static void m3981a(XMPushService xMPushService, boolean z) {
        try {
            Map<String, byte[]> map = f3219a;
            synchronized (map) {
                for (String str : map.keySet()) {
                    AbstractC1417b.m1089a("processing pending registration request. " + str);
                    C1795w.m4035a(xMPushService, str, f3219a.get(str));
                    if (z && !C1703r.m3474a()) {
                        try {
                            Thread.sleep(200L);
                        } catch (Exception unused) {
                        }
                    }
                }
                f3219a.clear();
            }
        } catch (C1609fh e) {
            AbstractC1417b.m1103d("fail to deal with pending register request. " + e);
            xMPushService.m3546a(10, e);
        }
    }

    /* renamed from: a */
    public static void m3978a(Context context, int i, String str) {
        Map<String, byte[]> map = f3219a;
        synchronized (map) {
            for (String str2 : map.keySet()) {
                AbstractC1417b.m1089a("notify registration error. " + str2);
                m3979a(context, str2, f3219a.get(str2), i, str);
            }
            f3219a.clear();
        }
    }

    /* renamed from: a */
    public static void m3980a(XMPushService xMPushService) {
        ArrayList<Pair<String, byte[]>> arrayList;
        try {
            synchronized (f3218a) {
                arrayList = f3218a;
                f3218a = new ArrayList<>();
            }
            boolean m3474a = C1703r.m3474a();
            Iterator<Pair<String, byte[]>> it = arrayList.iterator();
            while (it.hasNext()) {
                Pair<String, byte[]> next = it.next();
                C1795w.m4035a(xMPushService, (String) next.first, (byte[]) next.second);
                if (!m3474a) {
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        } catch (C1609fh e) {
            AbstractC1417b.m1103d("meet error when process pending message. " + e);
            xMPushService.m3546a(10, e);
        }
    }

    /* renamed from: b */
    public static void m3983b(String str, byte[] bArr) {
        synchronized (f3218a) {
            f3218a.add(new Pair<>(str, bArr));
            if (f3218a.size() > 50) {
                f3218a.remove(0);
            }
        }
    }

    /* renamed from: a */
    public static void m3979a(Context context, String str, byte[] bArr, int i, String str2) {
        Intent intent = new Intent("com.xiaomi.mipush.ERROR");
        intent.setPackage(str);
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mipush_error_code", i);
        intent.putExtra("mipush_error_msg", str2);
        context.sendBroadcast(intent, C1795w.m4030a(str));
    }
}
