package com.hihonor.push.sdk;

import com.hihonor.push.sdk.common.data.ApiException;
import com.hihonor.push.sdk.common.data.UpMsgType;

/* renamed from: com.hihonor.push.sdk.a0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0907a0 {
    /* renamed from: a */
    public Void m732a(boolean z) throws ApiException {
        try {
            C0927g1 c0927g1 = new C0927g1(z ? UpMsgType.TURN_ON_PUSH : UpMsgType.TURN_OFF_PUSH, null);
            c0927g1.f715e = C0909b.m739a();
            C0909b.m743a(C0966z.f792c.m783a(c0927g1));
            return null;
        } catch (Exception e) {
            throw C0909b.m742a(e);
        }
    }
}
