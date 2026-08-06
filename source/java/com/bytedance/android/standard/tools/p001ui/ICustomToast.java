package com.bytedance.android.standard.tools.p001ui;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public interface ICustomToast {
    public static final int LENGTH_LONG = 3500;
    public static final int LENGTH_SHORT = 2000;
    public static final int LENGTH_WITH_ICON = 1500;

    void dismissCustomToast();

    void showCustomLongToast(int i, String str);

    void showCustomToast(int i, String str);

    void showCustomToast(int i, String str, int i2, int i3);

    void showCustomToast(String str);

    void showCustomToast(String str, int i, int i2);
}
