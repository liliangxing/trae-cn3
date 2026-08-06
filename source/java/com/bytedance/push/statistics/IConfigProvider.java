package com.bytedance.push.statistics;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public interface IConfigProvider {
    long getBackgroundInterval();

    long getDefaultBackgroundInterval();

    long getDefaultForegroundInterval();

    long getForegroundInterval();

    boolean isAppForeground();

    boolean isMainProcess();

    boolean isScreenOn();

    boolean isUsbCharging();

    void save(AliveData aliveData, boolean z, boolean z2);

    void submitAndUpload(boolean z);

    void submitAndUploadSync(boolean z);
}
