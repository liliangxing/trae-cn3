package com.bytedance.common.utility;

@Deprecated
/* loaded from: classes3.dex */
public interface ICustomToast extends com.bytedance.android.standard.tools.ui.ICustomToast {
    public static final int LENGTH_LONG = 3500;
    public static final int LENGTH_SHORT = 2000;
    public static final int LENGTH_WITH_ICON = 1500;

    @Override // com.bytedance.android.standard.tools.ui.ICustomToast
    void dismissCustomToast();

    @Override // com.bytedance.android.standard.tools.ui.ICustomToast
    void showCustomLongToast(int i, String str);

    @Override // com.bytedance.android.standard.tools.ui.ICustomToast
    void showCustomToast(int i, String str);

    @Override // com.bytedance.android.standard.tools.ui.ICustomToast
    void showCustomToast(int i, String str, int i2, int i3);

    @Override // com.bytedance.android.standard.tools.ui.ICustomToast
    void showCustomToast(String str);

    @Override // com.bytedance.android.standard.tools.ui.ICustomToast
    void showCustomToast(String str, int i, int i2);
}
