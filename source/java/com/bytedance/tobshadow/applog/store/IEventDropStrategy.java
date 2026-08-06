package com.bytedance.tobshadow.applog.store;

/* loaded from: classes5.dex */
public interface IEventDropStrategy {
    int eventDBCacheSize();

    int reportMaxRetryTimes();

    int reportTimeoutInDay();
}
