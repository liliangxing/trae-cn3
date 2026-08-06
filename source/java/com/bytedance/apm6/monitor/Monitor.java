package com.bytedance.apm6.monitor;

import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.util.TraceUtils;
import com.bytedance.apm6.util.log.Logger;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedTransferQueue;

/* loaded from: classes3.dex */
public class Monitor {
    private static final String LOG_TAG = "APM-Monitor";
    private static final String THREAD_NAME = "APM-Monitor";
    private static List<MonitorableHandler> handlers = new CopyOnWriteArrayList();
    private static List<MonitorableInterceptor> interceptors = new CopyOnWriteArrayList();
    private static final BlockingQueue<Monitorable> queue = new LinkedTransferQueue();
    private static volatile boolean isWorking = false;

    public static void registerHandler(MonitorableHandler monitorableHandler) {
        if (handlers.contains(monitorableHandler)) {
            return;
        }
        handlers.add(monitorableHandler);
    }

    public static void registerInterceptor(MonitorableInterceptor monitorableInterceptor) {
        if (monitorableInterceptor == null || interceptors.contains(monitorableInterceptor)) {
            return;
        }
        interceptors.add(monitorableInterceptor);
    }

    public static void record(Monitorable monitorable) {
        if (monitorable == null) {
            return;
        }
        queue.offer(monitorable);
        if (isWorking) {
            return;
        }
        startWork();
    }

    private static synchronized void startWork() {
        synchronized (Monitor.class) {
            if (isWorking) {
                return;
            }
            isWorking = true;
            new Thread(new Runnable() { // from class: com.bytedance.apm6.monitor.Monitor.1
                @Override // java.lang.Runnable
                public void run() {
                    Monitorable monitorable;
                    boolean z;
                    while (true) {
                        TraceUtils.beginSection("APM-Consumers");
                        try {
                            monitorable = (Monitorable) Monitor.queue.take();
                            Iterator it = Monitor.interceptors.iterator();
                            z = false;
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                MonitorableInterceptor monitorableInterceptor = (MonitorableInterceptor) it.next();
                                try {
                                } catch (Throwable th) {
                                    if (ApmContext.isDebugMode()) {
                                        Logger.e("APM-Monitor", "interceptor throws a Throwable", th);
                                    }
                                }
                                if (monitorableInterceptor.shouldIntercept(monitorable)) {
                                    z = true;
                                    if (ApmContext.isDebugMode()) {
                                        Logger.w("APM-Monitor", "monitorable intercepted by " + monitorableInterceptor.getClass() + " content: " + monitorable);
                                    }
                                }
                            }
                        } catch (Throwable th2) {
                            Logger.e("APM", "record error", th2);
                        }
                        if (!z) {
                            for (MonitorableHandler monitorableHandler : Monitor.handlers) {
                                TraceUtils.beginSection("APM-Handler");
                                try {
                                    if (monitorable.isValid()) {
                                        monitorableHandler.handle(monitorable);
                                    } else if (ApmContext.isDebugMode()) {
                                        Logger.w("APM-Monitor", "monitorable invalid. ignored. " + monitorable);
                                    }
                                } catch (Throwable th3) {
                                    Logger.e("APM-Monitor", "monitorableHandler " + monitorableHandler + " handle monitorable " + monitorable + "failed.", th3);
                                }
                                TraceUtils.endSection();
                            }
                            TraceUtils.endSection();
                        }
                    }
                }
            }, "APM-Monitor").start();
        }
    }
}
