package cn.com.chinatelecom.account.api.p009d;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* renamed from: cn.com.chinatelecom.account.api.d.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0686a {

    /* renamed from: b */
    private static Executor f208b = Executors.newSingleThreadExecutor();

    /* renamed from: a */
    public Handler f209a = new Handler(Looper.getMainLooper());

    /* renamed from: a */
    public static void m238a(Runnable runnable) {
        f208b.execute(runnable);
    }
}
