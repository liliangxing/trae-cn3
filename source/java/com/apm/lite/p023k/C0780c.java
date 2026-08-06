package com.apm.lite.p023k;

import android.os.Debug;

/* renamed from: com.apm.lite.k.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0780c {

    /* renamed from: a */
    static final a f574a = new b();

    /* renamed from: com.apm.lite.k.c$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    private static class a {
        private a() {
        }

        /* renamed from: a */
        public int mo757a(Debug.MemoryInfo memoryInfo) {
            return -1;
        }

        /* renamed from: b */
        public int mo758b(Debug.MemoryInfo memoryInfo) {
            return -1;
        }

        /* renamed from: c */
        public int mo759c(Debug.MemoryInfo memoryInfo) {
            return -1;
        }
    }

    /* renamed from: com.apm.lite.k.c$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    private static class b extends a {
        private b() {
            super();
        }

        @Override // com.apm.lite.p023k.C0780c.a
        /* renamed from: a */
        public int mo757a(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalPrivateClean();
        }

        @Override // com.apm.lite.p023k.C0780c.a
        /* renamed from: b */
        public int mo758b(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalSharedClean();
        }

        @Override // com.apm.lite.p023k.C0780c.a
        /* renamed from: c */
        public int mo759c(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalSwappablePss();
        }
    }

    /* renamed from: a */
    public static int m754a(Debug.MemoryInfo memoryInfo) {
        return f574a.mo757a(memoryInfo);
    }

    /* renamed from: b */
    public static int m755b(Debug.MemoryInfo memoryInfo) {
        return f574a.mo758b(memoryInfo);
    }

    /* renamed from: c */
    public static int m756c(Debug.MemoryInfo memoryInfo) {
        return f574a.mo759c(memoryInfo);
    }
}
