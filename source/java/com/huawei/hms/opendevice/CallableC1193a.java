package com.huawei.hms.opendevice;

import android.content.Context;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.AAIDResult;
import java.util.concurrent.Callable;

/* compiled from: AAIDCallable.java */
/* renamed from: com.huawei.hms.opendevice.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class CallableC1193a implements Callable<AAIDResult> {

    /* renamed from: a */
    private Context f1594a;

    public CallableC1193a(Context context) {
        this.f1594a = context;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AAIDResult call() throws Exception {
        Context context = this.f1594a;
        if (context != null) {
            String m1844b = C1194b.m1844b(context);
            AAIDResult aAIDResult = new AAIDResult();
            aAIDResult.setId(m1844b);
            return aAIDResult;
        }
        throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
    }
}
