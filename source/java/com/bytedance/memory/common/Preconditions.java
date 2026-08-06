package com.bytedance.memory.common;

/* loaded from: classes4.dex */
public final class Preconditions {
    public static <T> T checkNotNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str + " must not be null");
    }

    public static void checkTrue(boolean z, String str) {
        if (!z) {
            throw new IllegalStateException(str);
        }
    }

    private Preconditions() {
        throw new AssertionError();
    }
}
