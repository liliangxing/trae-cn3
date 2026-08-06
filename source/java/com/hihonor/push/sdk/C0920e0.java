package com.hihonor.push.sdk;

import android.os.Handler;
import android.os.Message;

/* renamed from: com.hihonor.push.sdk.e0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0920e0 implements Handler.Callback {

    /* renamed from: a */
    public final /* synthetic */ ServiceConnectionC0923f0 f702a;

    public C0920e0(ServiceConnectionC0923f0 serviceConnectionC0923f0) {
        this.f702a = serviceConnectionC0923f0;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message == null || message.what != 1001) {
            return false;
        }
        this.f702a.m765a(8002003);
        return true;
    }
}
