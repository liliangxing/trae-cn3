package com.hihonor.push.sdk;

import android.content.Context;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import java.lang.ref.WeakReference;

/* renamed from: com.hihonor.push.sdk.l */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0937l {

    /* renamed from: e */
    public static final C0937l f734e = new C0937l();

    /* renamed from: a */
    public WeakReference<Context> f735a;

    /* renamed from: b */
    public volatile boolean f736b = false;

    /* renamed from: c */
    public volatile boolean f737c = false;

    /* renamed from: d */
    public C0952s f738d;

    /* renamed from: com.hihonor.push.sdk.l$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Runnable f739a;

        /* renamed from: b */
        public final /* synthetic */ HonorPushCallback f740b;

        public a(Runnable runnable, HonorPushCallback honorPushCallback) {
            this.f739a = runnable;
            this.f740b = honorPushCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C0937l.this.f736b) {
                this.f739a.run();
                return;
            }
            HonorPushCallback honorPushCallback = this.f740b;
            if (honorPushCallback != null) {
                HonorPushErrorEnum honorPushErrorEnum = HonorPushErrorEnum.ERROR_NOT_INITIALIZED;
                honorPushCallback.onFailure(honorPushErrorEnum.getErrorCode(), honorPushErrorEnum.getMessage());
            }
        }
    }

    /* renamed from: a */
    public boolean m775a(Context context) {
        return HonorPushErrorEnum.SUCCESS.statusCode == C0909b.m751b(context);
    }

    /* renamed from: a */
    public Context m773a() {
        return this.f735a.get();
    }

    /* renamed from: a */
    public final void m774a(Runnable runnable, HonorPushCallback<?> honorPushCallback) {
        C0911b1.m753a(new a(runnable, honorPushCallback));
    }
}
