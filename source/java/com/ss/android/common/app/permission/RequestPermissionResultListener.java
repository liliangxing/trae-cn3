package com.ss.android.common.app.permission;

/* loaded from: classes7.dex */
public interface RequestPermissionResultListener {
    public static final int DENIED = 1;
    public static final int ERROR = 3;
    public static final int GRANTED = 0;
    public static final int NOT_FOUND = 2;

    void onPermissionResult(String str, int i);
}
