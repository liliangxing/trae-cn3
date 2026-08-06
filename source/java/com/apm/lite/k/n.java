package com.apm.lite.k;

import android.app.ActivityManager;

/* loaded from: classes2.dex */
public class n {
    static final a a = new b();

    /* loaded from: classes2.dex */
    private static class a {
        private a() {
        }

        public long a(ActivityManager.MemoryInfo memoryInfo) {
            return 0L;
        }
    }

    /* loaded from: classes2.dex */
    private static class b extends a {
        private b() {
            super();
        }

        @Override // com.apm.lite.k.n.a
        public long a(ActivityManager.MemoryInfo memoryInfo) {
            return memoryInfo.totalMem;
        }
    }

    public static long a(ActivityManager.MemoryInfo memoryInfo) {
        return a.a(memoryInfo);
    }
}
