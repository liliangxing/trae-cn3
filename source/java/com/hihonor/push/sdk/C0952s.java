package com.hihonor.push.sdk;

import android.content.Context;
import com.hihonor.push.sdk.common.data.ApiException;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import java.util.concurrent.Callable;

/* renamed from: com.hihonor.push.sdk.s */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0952s {

    /* renamed from: a */
    public final Context f759a;

    /* renamed from: b */
    public C0907a0 f760b = new C0907a0();

    /* renamed from: com.hihonor.push.sdk.s$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Callable f761a;

        /* renamed from: b */
        public final /* synthetic */ HonorPushCallback f762b;

        public a(Callable callable, HonorPushCallback honorPushCallback) {
            this.f761a = callable;
            this.f762b = honorPushCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Object call = this.f761a.call();
                C0952s c0952s = C0952s.this;
                HonorPushCallback honorPushCallback = this.f762b;
                c0952s.getClass();
                C0911b1.m753a(new RunnableC0954t(c0952s, honorPushCallback, call));
            } catch (ApiException e) {
                C0952s.m778a(C0952s.this, this.f762b, e.getErrorCode(), e.getMessage());
            } catch (Exception unused) {
                C0952s c0952s2 = C0952s.this;
                HonorPushCallback honorPushCallback2 = this.f762b;
                HonorPushErrorEnum honorPushErrorEnum = HonorPushErrorEnum.ERROR_INTERNAL_ERROR;
                C0952s.m778a(c0952s2, honorPushCallback2, honorPushErrorEnum.getErrorCode(), honorPushErrorEnum.getMessage());
            }
        }
    }

    public C0952s(Context context) {
        this.f759a = context;
    }

    /* renamed from: a */
    public static void m778a(C0952s c0952s, HonorPushCallback honorPushCallback, int i, String str) {
        c0952s.getClass();
        C0911b1.m753a(new RunnableC0956u(c0952s, honorPushCallback, i, str));
    }

    /* renamed from: a */
    public final <T> void m779a(Callable<T> callable, HonorPushCallback<T> honorPushCallback) {
        a aVar = new a(callable, honorPushCallback);
        C0911b1 c0911b1 = C0911b1.f689d;
        if (c0911b1.f691b == null) {
            synchronized (c0911b1.f692c) {
                if (c0911b1.f691b == null) {
                    c0911b1.f691b = c0911b1.m755b();
                }
            }
        }
        c0911b1.f691b.execute(aVar);
    }
}
