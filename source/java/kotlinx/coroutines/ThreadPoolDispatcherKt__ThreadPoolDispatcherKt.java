package kotlinx.coroutines;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import net.openid.appauth.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ThreadPoolDispatcher.kt */
@Metadata(m4d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, m5d2 = {"newFixedThreadPoolContext", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "nThreads", BuildConfig.FLAVOR, "name", BuildConfig.FLAVOR, "kotlinx-coroutines-core"}, m6k = 5, m7mv = {1, 9, 0}, m9xi = 48, m10xs = "kotlinx/coroutines/ThreadPoolDispatcherKt")
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final /* synthetic */ class ThreadPoolDispatcherKt__ThreadPoolDispatcherKt {
    public static final ExecutorCoroutineDispatcher newFixedThreadPoolContext(final int i, final String str) {
        if (!(i >= 1)) {
            throw new IllegalArgumentException(("Expected at least one thread, but " + i + " specified").toString());
        }
        final AtomicInteger atomicInteger = new AtomicInteger();
        return ExecutorsKt.from((ExecutorService) Executors.newScheduledThreadPool(i, new ThreadFactory() { // from class: kotlinx.coroutines.ThreadPoolDispatcherKt__ThreadPoolDispatcherKt$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread m58x1146da6d;
                m58x1146da6d = ThreadPoolDispatcherKt__ThreadPoolDispatcherKt.m58x1146da6d(i, str, atomicInteger, runnable);
                return m58x1146da6d;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: newFixedThreadPoolContext$lambda$1$ThreadPoolDispatcherKt__ThreadPoolDispatcherKt */
    public static final Thread m58x1146da6d(int i, String str, AtomicInteger atomicInteger, Runnable runnable) {
        if (i != 1) {
            str = str + '-' + atomicInteger.incrementAndGet();
        }
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(true);
        return thread;
    }
}
