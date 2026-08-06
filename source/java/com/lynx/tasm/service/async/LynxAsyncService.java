package com.lynx.tasm.service.async;

import com.lynx.tasm.core.LynxThreadPool;
import com.lynx.tasm.service.async.LynxAsyncManager;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxAsyncService {
    private ExecutorService mGlobalDefaultExecutor;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class SingletonHolder {
        private static final LynxAsyncService INSTANCE = new LynxAsyncService();

        private SingletonHolder() {
        }
    }

    public static LynxAsyncService getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private LynxAsyncService() {
    }

    public <T extends IPreLayoutContainer> LynxAsyncManager<T> generateLynxAsyncManager(LynxAsyncManager.Builder<T> builder) {
        LynxAsyncManager<T> build = builder.build();
        build.setLoadExecutor(getGlobalDefaultExecutor());
        return build;
    }

    public synchronized void setGlobalDefaultExecutor(ExecutorService executorService) {
        this.mGlobalDefaultExecutor = executorService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized ExecutorService getGlobalDefaultExecutor() {
        if (this.mGlobalDefaultExecutor == null) {
            Executor asyncServiceExecutor = LynxThreadPool.getAsyncServiceExecutor();
            if (asyncServiceExecutor instanceof ExecutorService) {
                this.mGlobalDefaultExecutor = (ExecutorService) asyncServiceExecutor;
            }
        }
        return this.mGlobalDefaultExecutor;
    }
}
