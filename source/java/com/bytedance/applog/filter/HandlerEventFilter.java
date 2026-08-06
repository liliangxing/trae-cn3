package com.bytedance.applog.filter;

import com.bytedance.applog.AppLogInstance;
import com.bytedance.applog.monitor.MonitorKey;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class HandlerEventFilter implements IEventFilter {
    private final AppLogInstance appLogInstance;

    public HandlerEventFilter(AppLogInstance appLogInstance) {
        this.appLogInstance = appLogInstance;
    }

    @Override // com.bytedance.applog.filter.IEventFilter
    public boolean filterAndDiscardEvent(MonitorKey monitorKey, String str, String str2) {
        if (this.appLogInstance.getEventHandler() == null) {
            return false;
        }
        return !this.appLogInstance.getEventHandler().filter(monitorKey.name(), str, str2);
    }

    @Override // com.bytedance.applog.filter.IEventFilter
    public boolean noFilter() {
        return this.appLogInstance.getEventHandler() == null;
    }
}
