package com.bytedance.applog;

/* loaded from: classes3.dex */
public interface IEventObserver {
    public static final int STAGE_PRE_PROCESS = 2;
    public static final int STAGE_PRE_RECEIVE = 1;
    public static final int STAGE_PRE_STORE = 0;

    void onEvent(String str, String str2, String str3, long j, long j2, String str4);

    void onEventV3(String str, String str2);

    void onMiscEvent(String str, String str2);
}
