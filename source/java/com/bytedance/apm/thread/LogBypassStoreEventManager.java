package com.bytedance.apm.thread;

import com.bytedance.apm.ApmContext;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class LogBypassStoreEventManager {
    private volatile ExecutorService mExecutors;

    private LogBypassStoreEventManager() {
        this.mExecutors = Executors.newFixedThreadPool(1, new ThreadFactory() { // from class: com.bytedance.apm.thread.LogBypassStoreEventManager.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "Apm_Log_Bypass_Store");
            }
        });
    }

    public static LogBypassStoreEventManager getInstance() {
        if (ApmContext.isInternalTest()) {
            return Holder.sINSTANCE;
        }
        return null;
    }

    public void post(Runnable runnable) {
        this.mExecutors.submit(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class Holder {
        static final LogBypassStoreEventManager sINSTANCE = new LogBypassStoreEventManager();

        private Holder() {
        }
    }
}
