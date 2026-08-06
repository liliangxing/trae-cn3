package com.hihonor.push.sdk;

import android.content.Context;
import com.hihonor.push.sdk.common.data.UpMsgType;
import java.util.concurrent.Callable;

/* renamed from: com.hihonor.push.sdk.n */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class CallableC0942n implements Callable<Void> {

    /* renamed from: a */
    public final /* synthetic */ C0952s f744a;

    public CallableC0942n(C0952s c0952s) {
        this.f744a = c0952s;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        C0952s c0952s = this.f744a;
        C0907a0 c0907a0 = c0952s.f760b;
        Context context = c0952s.f759a;
        c0907a0.getClass();
        try {
            C0918d1 c0918d1 = new C0918d1(UpMsgType.UNREGISTER_PUSH_TOKEN, null);
            c0918d1.f715e = C0909b.m739a();
            C0909b.m743a(C0966z.f792c.m783a(c0918d1));
            C0916d.f695b.m760a(context, null);
            return null;
        } catch (Exception e) {
            throw C0909b.m742a(e);
        }
    }
}
