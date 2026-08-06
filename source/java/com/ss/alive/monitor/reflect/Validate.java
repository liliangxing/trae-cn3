package com.ss.alive.monitor.reflect;

/* loaded from: classes7.dex */
class Validate {
    Validate() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void throwsIfTrue(boolean z, String str, Object... objArr) {
        if (z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }
}
