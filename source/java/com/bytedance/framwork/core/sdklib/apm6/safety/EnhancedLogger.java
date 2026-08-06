package com.bytedance.framwork.core.sdklib.apm6.safety;

import com.bytedance.framwork.core.sdklib.apm6.safety.Logger;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class EnhancedLogger extends Logger.DefaultLogger {
    public static EnhancedLogger getInstance() {
        return InnerHolder.holder;
    }

    @Override // com.bytedance.framwork.core.sdklib.apm6.safety.Logger.DefaultLogger
    /* renamed from: e */
    public void mo1303e(String str, String str2) {
        super.mo1303e(str, str2);
        CustomExceptionHelper.reportSlardarIfNeed(str, str2, null);
    }

    @Override // com.bytedance.framwork.core.sdklib.apm6.safety.Logger.DefaultLogger
    /* renamed from: e */
    public void mo1304e(String str, String str2, Throwable th) {
        super.mo1304e(str, str2, th);
        CustomExceptionHelper.reportSlardarIfNeed(str, str2, th);
    }

    @Override // com.bytedance.framwork.core.sdklib.apm6.safety.Logger.DefaultLogger
    public void wtf(String str, String str2) {
        super.wtf(str, str2);
        CustomExceptionHelper.reportSlardarIfNeed(str, str2, null);
    }

    @Override // com.bytedance.framwork.core.sdklib.apm6.safety.Logger.DefaultLogger
    public void wtf(String str, String str2, Throwable th) {
        super.wtf(str, str2, th);
        CustomExceptionHelper.reportSlardarIfNeed(str, str2, th);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    private static class InnerHolder {
        private static final EnhancedLogger holder = new EnhancedLogger();

        private InnerHolder() {
        }
    }
}
