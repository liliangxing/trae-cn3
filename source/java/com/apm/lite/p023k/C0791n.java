package com.apm.lite.p023k;

import android.app.ActivityManager;

/* renamed from: com.apm.lite.k.n */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0791n {

    /* renamed from: a */
    static final a f592a = new b();

    /* renamed from: com.apm.lite.k.n$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    private static class a {
        private a() {
        }

        /* renamed from: a */
        public long mo844a(ActivityManager.MemoryInfo memoryInfo) {
            return 0L;
        }
    }

    /* renamed from: com.apm.lite.k.n$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    private static class b extends a {
        private b() {
            super();
        }

        @Override // com.apm.lite.p023k.C0791n.a
        /* renamed from: a */
        public long mo844a(ActivityManager.MemoryInfo memoryInfo) {
            return memoryInfo.totalMem;
        }
    }

    /* renamed from: a */
    public static long m843a(ActivityManager.MemoryInfo memoryInfo) {
        return f592a.mo844a(memoryInfo);
    }
}
