package com.bytedance.tobshadow.bdtracker;

import com.bytedance.tobshadow.applog.ILogger;
import com.bytedance.tobshadow.applog.log.ILogProcessor;
import com.bytedance.tobshadow.applog.log.LogInfo;

/* loaded from: classes5.dex */
public class u1 implements ILogProcessor {
    public final ILogger a;

    public u1(ILogger iLogger) {
        this.a = iLogger;
    }

    @Override // com.bytedance.tobshadow.applog.log.ILogProcessor
    public void onLog(LogInfo logInfo) {
        ILogger iLogger = this.a;
        if (iLogger != null) {
            iLogger.log(logInfo.getMessage(), logInfo.getThrowable());
        }
    }
}
