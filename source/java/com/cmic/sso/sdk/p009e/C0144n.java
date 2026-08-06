package com.cmic.sso.sdk.p009e;

import android.content.Context;
import com.cmic.sso.sdk.C0088a;
import com.cmic.sso.sdk.auth.AuthnHelper;
import java.lang.Thread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ThreadUtils.java */
/* renamed from: com.cmic.sso.sdk.e.n */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0144n {

    /* renamed from: a */
    private static final ExecutorService f330a = new ThreadPoolExecutor(0, 30, 60, TimeUnit.SECONDS, new SynchronousQueue());

    /* renamed from: a */
    public static void m391a(a aVar) {
        try {
            f330a.execute(aVar);
        } catch (Exception e) {
            aVar.f331a.uncaughtException(Thread.currentThread(), e);
        }
    }

    /* compiled from: ThreadUtils.java */
    /* renamed from: com.cmic.sso.sdk.e.n$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static abstract class a implements Runnable {

        /* renamed from: a */
        private final Thread.UncaughtExceptionHandler f331a;

        /* renamed from: a */
        protected abstract void mo128a();

        /* JADX INFO: Access modifiers changed from: protected */
        public a() {
            this.f331a = new Thread.UncaughtExceptionHandler() { // from class: com.cmic.sso.sdk.e.n.a.1
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public void uncaughtException(Thread thread, Throwable th) {
                    th.printStackTrace();
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public a(final Context context, final C0088a c0088a) {
            this.f331a = new Thread.UncaughtExceptionHandler() { // from class: com.cmic.sso.sdk.e.n.a.2
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public void uncaughtException(Thread thread, Throwable th) {
                    c0088a.m55a().f278a.add(th);
                    AuthnHelper.getInstance(context).callBackResult("200025", "发生未知错误", c0088a, null);
                }
            };
        }

        @Override // java.lang.Runnable
        public void run() {
            Thread.currentThread().setUncaughtExceptionHandler(this.f331a);
            mo128a();
            Thread.currentThread().setUncaughtExceptionHandler(null);
        }
    }
}
