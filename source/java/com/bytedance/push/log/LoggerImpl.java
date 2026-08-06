package com.bytedance.push.log;

import com.bytedance.push.utils.Logger;

/* loaded from: classes4.dex */
public class LoggerImpl implements ILogger {
    @Override // com.bytedance.push.log.ILogger
    public void d(String str) {
        Logger.d(str);
    }

    @Override // com.bytedance.push.log.ILogger
    public void d(String str, String str2) {
        Logger.d(str, str2);
    }

    @Override // com.bytedance.push.log.ILogger
    public void e(String str) {
        Logger.e(str);
    }

    @Override // com.bytedance.push.log.ILogger
    public void e(String str, String str2) {
        Logger.e(str, str2);
    }

    @Override // com.bytedance.push.log.ILogger
    public void e(String str, String str2, Throwable th) {
        Logger.e(str, str2, th);
    }

    @Override // com.bytedance.push.log.ILogger
    public boolean debug() {
        return Logger.debug();
    }

    @Override // com.bytedance.push.log.ILogger
    public void i(String str) {
        Logger.i(str);
    }

    @Override // com.bytedance.push.log.ILogger
    public void i(String str, String str2) {
        Logger.i(str, str2);
    }

    @Override // com.bytedance.push.log.ILogger
    public void i(String str, String str2, Throwable th) {
        Logger.i(str, str2, th);
    }

    @Override // com.bytedance.push.log.ILogger
    public void v(String str, String str2) {
        Logger.v(str, str2);
    }

    @Override // com.bytedance.push.log.ILogger
    public void w(String str, String str2) {
        Logger.w(str, str2);
    }
}
