package com.bytedance.applog.filter;

import com.bytedance.applog.monitor.MonitorKey;

/* loaded from: classes3.dex */
public interface IEventFilter {
    boolean filterAndDiscardEvent(MonitorKey monitorKey, String str, String str2);

    boolean noFilter();
}
