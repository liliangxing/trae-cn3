package com.bytedance.sync.interfaze;

/* loaded from: classes5.dex */
public interface IMonitor {
    void ensureNotReachHere(Throwable th, String str);

    void monitorAccountChanged(boolean z);

    void monitorSettingError(String str, String str2);

    void sendErrorAck(long j, int i, long j2, long j3, String str);
}
