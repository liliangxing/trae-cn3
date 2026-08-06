package com.bytedance.mt.protector;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ProtectorExceptionHandler {
    public static Object handlerThrowable(String str, Throwable th) {
        Protector.getCallback().loge(ProtectorCallbackDefault.TAG, str, th, 1);
        return null;
    }
}
