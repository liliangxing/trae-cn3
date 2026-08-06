package com.bytedance.applog.log;

import com.bytedance.bdinstall.ILogger;

/* loaded from: classes3.dex */
public class CustomLogProcessor implements ILogProcessor {
    private final ILogger logger;

    public CustomLogProcessor(ILogger iLogger) {
        this.logger = iLogger;
    }

    @Override // com.bytedance.applog.log.ILogProcessor
    public void onLog(LogInfo logInfo) {
        if (this.logger != null) {
            int level = logInfo.getLevel();
            if (level == 1) {
                this.logger.d(logInfo.toMessage(), logInfo.getThrowable());
                return;
            }
            if (level == 2) {
                this.logger.i(logInfo.toMessage(), logInfo.getThrowable());
                return;
            }
            if (level == 3) {
                this.logger.w(logInfo.toMessage(), logInfo.getThrowable());
            } else if (level != 4) {
                this.logger.v(logInfo.toMessage(), logInfo.getThrowable());
            } else {
                this.logger.e(logInfo.toMessage(), logInfo.getThrowable());
            }
        }
    }
}
