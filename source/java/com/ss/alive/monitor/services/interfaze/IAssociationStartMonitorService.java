package com.ss.alive.monitor.services.interfaze;

import com.bytedance.android.service.manager.alive.monitor.IMonitorCallback;

/* loaded from: classes7.dex */
public interface IAssociationStartMonitorService {
    boolean hasHookActivityManagerSuccess();

    boolean hasHookActivityTaskManagerSuccess();

    void startMonitor();

    void startMonitor(IMonitorCallback iMonitorCallback);
}
