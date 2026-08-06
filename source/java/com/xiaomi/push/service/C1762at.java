package com.xiaomi.push.service;

import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.push.C1580ef;
import com.xiaomi.push.C1581eg;
import com.xiaomi.push.service.XMPushService;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.xiaomi.push.service.at */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1762at {

    /* renamed from: a */
    private final ConcurrentHashMap<String, c> f3085a = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.xiaomi.push.service.at$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class b {

        /* renamed from: a */
        private static final C1762at f3086a = new C1762at();
    }

    /* renamed from: a */
    public static C1762at m3753a() {
        return b.f3086a;
    }

    /* renamed from: a */
    public void m3755a() {
        if (this.f3085a.isEmpty()) {
            return;
        }
        Iterator<Map.Entry<String, c>> it = this.f3085a.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, c> next = it.next();
            if (next == null || next.getValue() == null) {
                it.remove();
            } else {
                c value = next.getValue();
                if (Math.abs(SystemClock.elapsedRealtime() - value.f3088b) > 10000) {
                    m3754a(next.getKey(), value);
                    it.remove();
                }
            }
        }
    }

    /* renamed from: com.xiaomi.push.service.at$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class a extends XMPushService.AbstractC1731j {
        @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
        /* renamed from: a */
        public String mo2389a() {
            return "RecordTimeManager clear";
        }

        public a() {
            super(17);
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
        /* renamed from: a */
        public void mo2390a() {
            C1762at.m3753a().m3755a();
        }
    }

    /* renamed from: a */
    public void m3757a(String str, long j, long j2) {
        c cVar = new c();
        cVar.f3087a = j2;
        cVar.f3088b = j;
        this.f3085a.put(str, cVar);
    }

    /* renamed from: a */
    public void m3756a(String str, long j) {
        c cVar = this.f3085a.get(str);
        if (cVar != null) {
            cVar.f3089c = j;
        }
    }

    /* renamed from: b */
    public void m3758b(String str, long j) {
        c remove = this.f3085a.remove(str);
        if (remove != null) {
            remove.f3090d = j;
            m3754a(str, remove);
        }
    }

    /* renamed from: a */
    private void m3754a(String str, c cVar) {
        if (TextUtils.isEmpty(str) || cVar == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("xmsfVC", Long.valueOf(cVar.f3087a));
        hashMap.put("packetId", str);
        hashMap.put("pTime", Long.valueOf(cVar.m3760a()));
        hashMap.put("bTime", Long.valueOf(cVar.m3761b()));
        C1581eg.m2343a().mo2341a(new C1580ef("msg_process_time", hashMap));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.xiaomi.push.service.at$c */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class c {

        /* renamed from: a */
        long f3087a;

        /* renamed from: b */
        long f3088b;

        /* renamed from: c */
        long f3089c;

        /* renamed from: d */
        long f3090d;

        private c() {
        }

        /* renamed from: a */
        public long m3760a() {
            long j = this.f3089c;
            long j2 = this.f3088b;
            if (j > j2) {
                return j - j2;
            }
            return 0L;
        }

        /* renamed from: b */
        public long m3761b() {
            long j = this.f3090d;
            long j2 = this.f3089c;
            if (j > j2) {
                return j - j2;
            }
            return 0L;
        }
    }
}
