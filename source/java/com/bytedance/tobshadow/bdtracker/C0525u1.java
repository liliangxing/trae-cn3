package com.bytedance.tobshadow.bdtracker;

import com.bytedance.tobshadow.applog.ILogger;
import com.bytedance.tobshadow.applog.log.ILogProcessor;
import com.bytedance.tobshadow.applog.log.LogInfo;

/* renamed from: com.bytedance.tobshadow.bdtracker.u1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0525u1 implements ILogProcessor {

    /* renamed from: a */
    public final ILogger f1096a;

    public C0525u1(ILogger iLogger) {
        this.f1096a = iLogger;
    }

    @Override // com.bytedance.tobshadow.applog.log.ILogProcessor
    public void onLog(LogInfo logInfo) {
        ILogger iLogger = this.f1096a;
        if (iLogger != null) {
            iLogger.log(logInfo.getMessage(), logInfo.getThrowable());
        }
    }
}
