package com.bytedance.push.interfaze;

/* loaded from: classes4.dex */
public interface OnSwitcherSyncListener {
    public static final int ERROR_CODE_SERVER = 1001;
    public static final int ERROR_NETWORK_NOT_AVAILABLE = 1002;
    public static final int ERROR_UNKNOWN = 1003;

    void onFailed(int i, String str);

    void onSuccess();
}
