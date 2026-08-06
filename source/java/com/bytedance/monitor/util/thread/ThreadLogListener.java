package com.bytedance.monitor.util.thread;

/* loaded from: classes4.dex */
public interface ThreadLogListener {
    boolean isDebug();

    void onError(String str, String str2);

    void onLog(String str, String str2);
}
