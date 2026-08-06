package com.bytedance.reparo.core.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes4.dex */
public class ExecutorServiceUtils {
    private static ExecutorService sCoreService;

    public static ExecutorService getReparoCoreExecutorService() {
        if (sCoreService == null) {
            synchronized (ExecutorServiceUtils.class) {
                if (sCoreService == null) {
                    sCoreService = Executors.newSingleThreadExecutor();
                }
            }
        }
        return sCoreService;
    }
}
