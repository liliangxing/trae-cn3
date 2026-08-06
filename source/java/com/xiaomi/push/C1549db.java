package com.xiaomi.push;

import com.xiaomi.channel.commonutils.logger.LoggerInterface;

/* renamed from: com.xiaomi.push.db */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1549db implements LoggerInterface {

    /* renamed from: a */
    private LoggerInterface f1309a;

    /* renamed from: b */
    private LoggerInterface f1310b;

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void setTag(String str) {
    }

    public C1549db(LoggerInterface loggerInterface, LoggerInterface loggerInterface2) {
        this.f1309a = loggerInterface;
        this.f1310b = loggerInterface2;
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void log(String str) {
        LoggerInterface loggerInterface = this.f1309a;
        if (loggerInterface != null) {
            loggerInterface.log(str);
        }
        LoggerInterface loggerInterface2 = this.f1310b;
        if (loggerInterface2 != null) {
            loggerInterface2.log(str);
        }
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void log(String str, Throwable th) {
        LoggerInterface loggerInterface = this.f1309a;
        if (loggerInterface != null) {
            loggerInterface.log(str, th);
        }
        LoggerInterface loggerInterface2 = this.f1310b;
        if (loggerInterface2 != null) {
            loggerInterface2.log(str, th);
        }
    }
}
