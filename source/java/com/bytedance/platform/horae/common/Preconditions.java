package com.bytedance.platform.horae.common;

/* loaded from: classes4.dex */
public final class Preconditions {
    private Preconditions() {
    }

    public static void checkArgument(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void checkArgument(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static <T> T checkNotNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException(str);
    }

    public static <T> T checkNotNull(T t, String str, Object... objArr) {
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException(String.format(str, objArr));
    }

    public static int checkElementIndex(int i, int i2, String str) {
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(str);
        }
        return i;
    }

    public static int checkElementIndex(int i, int i2, String str, Object... objArr) {
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(String.format(str, objArr));
        }
        return i;
    }

    public static void checkTrue(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void checkTrue(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }
}
