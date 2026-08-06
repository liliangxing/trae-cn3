package com.hihonor.push.sdk;

import com.hihonor.push.framework.aidl.entity.BooleanResult;
import com.hihonor.push.sdk.common.data.UpMsgType;
import java.util.concurrent.Callable;

/* renamed from: com.hihonor.push.sdk.o */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class CallableC0944o implements Callable<Boolean> {

    /* renamed from: a */
    public final /* synthetic */ C0952s f746a;

    public CallableC0944o(C0952s c0952s) {
        this.f746a = c0952s;
    }

    @Override // java.util.concurrent.Callable
    public Boolean call() throws Exception {
        this.f746a.f760b.getClass();
        try {
            C0914c1 c0914c1 = new C0914c1(UpMsgType.QUERY_PUSH_STATUS, null);
            c0914c1.f715e = C0909b.m739a();
            return Boolean.valueOf(((BooleanResult) C0909b.m743a(C0966z.f792c.m783a(c0914c1))).getStatus());
        } catch (Exception e) {
            throw C0909b.m742a(e);
        }
    }
}
