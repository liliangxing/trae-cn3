package com.bytedance.sync.p005v4.net;

import com.bytedance.sync.Singleton;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class NetThreadPool {
    private static final Singleton<ExecutorService> sNetThreadPool = new Singleton<ExecutorService>() { // from class: com.bytedance.sync.v4.net.NetThreadPool.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.sync.Singleton
        public ExecutorService create(Object... objArr) {
            return Executors.newSingleThreadExecutor();
        }
    };

    public static void submit(Runnable runnable) {
        try {
            sNetThreadPool.get(new Object[0]).submit(runnable);
        } catch (Throwable unused) {
        }
    }
}
