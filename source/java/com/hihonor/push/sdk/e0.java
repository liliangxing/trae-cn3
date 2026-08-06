package com.hihonor.push.sdk;

import android.os.Handler;
import android.os.Message;

/* loaded from: classes6.dex */
public class e0 implements Handler.Callback {
    public final /* synthetic */ f0 a;

    public e0(f0 f0Var) {
        this.a = f0Var;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message == null || message.what != 1001) {
            return false;
        }
        this.a.a(8002003);
        return true;
    }
}
