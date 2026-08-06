package com.bytedance.applog.strategy;

/* loaded from: classes3.dex */
public interface IReportDropStrategy {
    int getMaxRetryTimes();

    long getTimeoutInMills();
}
