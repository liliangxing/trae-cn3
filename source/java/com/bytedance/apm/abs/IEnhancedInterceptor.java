package com.bytedance.apm.abs;

import com.bytedance.apm6.commonevent.model.CommonEvent;
import com.bytedance.apm6.monitor.Monitorable;
import com.bytedance.apm6.monitor.MonitorableInterceptor;

/* loaded from: classes3.dex */
public abstract class IEnhancedInterceptor implements MonitorableInterceptor {
    public abstract boolean shouldIntercept(String str, String str2, Monitorable monitorable);

    @Override // com.bytedance.apm6.monitor.MonitorableInterceptor
    public boolean shouldIntercept(Monitorable monitorable) {
        return shouldIntercept(monitorable.getLogType(), monitorable instanceof CommonEvent ? ((CommonEvent) monitorable).getServiceName() : null, monitorable);
    }
}
