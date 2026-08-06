package com.bytedance.platform.godzilla.anr.monitor.idletask;

import com.bytedance.platform.godzilla.anr.monitor.ITaskCostTimeCallback;

/* loaded from: classes4.dex */
public final class IdleHandlerCostTimeMonitor {
    private static IdleHandlerCostTimeMonitor sInstance;
    private ITaskCostTimeCallback mITaskCostTimeCallback;

    private IdleHandlerCostTimeMonitor() {
    }

    public static IdleHandlerCostTimeMonitor getInstance() {
        if (sInstance == null) {
            synchronized (IdleHandlerCostTimeMonitor.class) {
                if (sInstance == null) {
                    sInstance = new IdleHandlerCostTimeMonitor();
                }
            }
        }
        return sInstance;
    }

    public void setIdleHandlerCostTimeCallback(ITaskCostTimeCallback iTaskCostTimeCallback) {
        this.mITaskCostTimeCallback = iTaskCostTimeCallback;
    }

    public ITaskCostTimeCallback getIdleHandlerCostTimeCallback() {
        return this.mITaskCostTimeCallback;
    }
}
