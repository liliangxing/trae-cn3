package com.bytedance.bdinstall;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.bytedance.bdinstall.util.Singleton;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class ExecutorUtil {
    private static Map<String, Executor> sNetExecutorMap = new ConcurrentHashMap(4);
    private static Map<String, ExecutorService> sIOExecutorMap = new ConcurrentHashMap(4);
    private static Map<String, Looper> sLooperMap = new ConcurrentHashMap(4);
    private static Map<String, Handler> sHandlerMap = new ConcurrentHashMap(4);
    private static final Singleton<Executor> sDefaultNetExecutor = new Singleton<Executor>() { // from class: com.bytedance.bdinstall.ExecutorUtil.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.bdinstall.util.Singleton
        public Executor create(Object... objArr) {
            return new ThreadPoolExecutor(0, Integer.MAX_VALUE, 10L, TimeUnit.SECONDS, new SynchronousQueue());
        }
    };
    private static final Singleton<ExecutorService> sDefaultIOExecutor = new Singleton<ExecutorService>() { // from class: com.bytedance.bdinstall.ExecutorUtil.2
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.bdinstall.util.Singleton
        public ExecutorService create(Object... objArr) {
            return new ThreadPoolExecutor(0, Integer.MAX_VALUE, 5L, TimeUnit.SECONDS, new SynchronousQueue());
        }
    };
    private static final Singleton<Looper> sDefaultLooper = new Singleton<Looper>() { // from class: com.bytedance.bdinstall.ExecutorUtil.3
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bytedance.bdinstall.util.Singleton
        public Looper create(Object... objArr) {
            try {
                HandlerThread handlerThread = new HandlerThread("bd_install");
                handlerThread.start();
                return handlerThread.getLooper();
            } catch (Exception unused) {
                return Looper.getMainLooper();
            }
        }
    };
    private static final Singleton<Handler> HANDLER = new Singleton<Handler>() { // from class: com.bytedance.bdinstall.ExecutorUtil.4
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bytedance.bdinstall.util.Singleton
        public Handler create(Object... objArr) {
            return new Handler((Looper) ExecutorUtil.sDefaultLooper.get(new Object[0]));
        }
    };

    private static Executor getNetExecutor(String str) {
        if (str == null) {
            return sDefaultNetExecutor.get(new Object[0]);
        }
        Executor executor = sNetExecutorMap.get(str);
        return executor == null ? sDefaultNetExecutor.get(new Object[0]) : executor;
    }

    private static ExecutorService getIOExecutor(String str) {
        if (str == null) {
            return sDefaultIOExecutor.get(new Object[0]);
        }
        ExecutorService executorService = sIOExecutorMap.get(str);
        return executorService == null ? sDefaultIOExecutor.get(new Object[0]) : executorService;
    }

    public static Looper getLooper(String str) {
        if (str == null) {
            return sDefaultLooper.get(new Object[0]);
        }
        Looper looper = sLooperMap.get(str);
        return looper == null ? sDefaultLooper.get(new Object[0]) : looper;
    }

    public static Handler getFirstHandler() {
        return getHandler(getFirstItemKey(sHandlerMap));
    }

    public static Handler getHandler(String str) {
        if (str == null) {
            return HANDLER.get(new Object[0]);
        }
        Handler handler = sHandlerMap.get(str);
        if (handler != null) {
            return handler;
        }
        Looper looper = getLooper(str);
        if (looper != null) {
            Handler handler2 = new Handler(looper);
            sHandlerMap.put(str, handler2);
            return handler2;
        }
        DrLog.e("getLooper return null");
        return handler;
    }

    public static void runOnNetExecutor(String str, Runnable runnable) {
        getNetExecutor(str).execute(runnable);
    }

    public static void runOnIOExecutor(String str, Runnable runnable) {
        getIOExecutor(str).execute(runnable);
    }

    public static <T> Future<T> submitToIOExecutor(String str, Callable<T> callable) {
        return getIOExecutor(str).submit(callable);
    }

    public static <T> Future<T> submitToFirstIOExecutor(Callable<T> callable) {
        return submitToIOExecutor(getFirstItemKey(sIOExecutorMap), callable);
    }

    public static void runOnHandlerThread(String str, Runnable runnable) {
        if (Looper.myLooper() == getLooper(str)) {
            runnable.run();
            return;
        }
        Handler handler = getHandler(str);
        if (handler == null) {
            handler = HANDLER.get(new Object[0]);
        }
        handler.post(runnable);
    }

    public static void runOnFirstHandlerThread(Runnable runnable) {
        runOnHandlerThread(getFirstItemKey(sHandlerMap), runnable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setExecutor(String str, ExecutorOptions executorOptions) {
        if (executorOptions == null) {
            return;
        }
        Executor executor = executorOptions.networkExecutor;
        if (executor != null) {
            sNetExecutorMap.put(str, executor);
        }
        ExecutorService executorService = executorOptions.ioExecutor;
        if (executorService != null) {
            sIOExecutorMap.put(str, executorService);
        }
        Looper looper = executorOptions.workLooper;
        if (looper != null) {
            sLooperMap.put(str, looper);
        }
    }

    private static String getFirstItemKey(Map map) {
        Set keySet;
        if (map == null || map.size() == 0 || (keySet = map.keySet()) == null || keySet.size() <= 0) {
            return null;
        }
        return (String) keySet.iterator().next();
    }
}
