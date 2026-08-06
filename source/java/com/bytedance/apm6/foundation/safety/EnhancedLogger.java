package com.bytedance.apm6.foundation.safety;

import com.bytedance.apm6.util.log.Logger;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class EnhancedLogger extends Logger.DefaultLogger {
    @Override // com.bytedance.apm6.util.log.Logger.DefaultLogger, com.bytedance.apm6.util.log.ILogger
    /* renamed from: e */
    public void mo112e(String str, String str2) {
        super.mo112e(str, str2);
        CustomExceptionHelper.reportSlardarIfNeed(str, str2, null);
    }

    @Override // com.bytedance.apm6.util.log.Logger.DefaultLogger, com.bytedance.apm6.util.log.ILogger
    /* renamed from: e */
    public void mo113e(String str, String str2, Throwable th) {
        super.mo113e(str, str2, th);
        CustomExceptionHelper.reportSlardarIfNeed(str, str2, th);
    }

    @Override // com.bytedance.apm6.util.log.Logger.DefaultLogger, com.bytedance.apm6.util.log.ILogger
    public void wtf(String str, String str2) {
        super.wtf(str, str2);
        CustomExceptionHelper.reportSlardarIfNeed(str, str2, null);
    }

    @Override // com.bytedance.apm6.util.log.Logger.DefaultLogger, com.bytedance.apm6.util.log.ILogger
    public void wtf(String str, String str2, Throwable th) {
        super.wtf(str, str2, th);
        CustomExceptionHelper.reportSlardarIfNeed(str, str2, th);
    }
}
