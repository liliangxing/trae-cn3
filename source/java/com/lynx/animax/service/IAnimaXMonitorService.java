package com.lynx.animax.service;

import com.lynx.animax.listener.AnimaXErrorParam;
import com.lynx.animax.monitor.MetricsAndEventStore;

/* loaded from: classes6.dex */
public interface IAnimaXMonitorService extends IAnimaXService {
    void reportError(AnimaXErrorParam animaXErrorParam);

    void reportPerformanceMetrics(MetricsAndEventStore metricsAndEventStore);

    void setCurrentUrl(String str);
}
