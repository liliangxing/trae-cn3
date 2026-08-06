package cn.com.chinatelecom.account.api.d;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: classes2.dex */
public class a {
    private static Executor b = Executors.newSingleThreadExecutor();
    public Handler a = new Handler(Looper.getMainLooper());

    public static void a(Runnable runnable) {
        b.execute(runnable);
    }
}
