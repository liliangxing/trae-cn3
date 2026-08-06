package com.bytedance.ies.uikit.toast;

/* loaded from: classes4.dex */
public interface IToastType {
    public static final int TYPE_SYSTEM = 1;
    public static final int TYPE_TITLE = 0;
    public static final int TYPE_TITLE_LIGHT = 2;

    /* loaded from: classes4.dex */
    public @interface ToastType {
    }

    int showToastType();

    int titleToastMargin();
}
