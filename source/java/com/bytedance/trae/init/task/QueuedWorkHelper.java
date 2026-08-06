package com.bytedance.trae.init.task;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.monitor.collector.service.DoubleReflectHelper;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.utils.logger.FLogger;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class QueuedWorkHelper {
    static final String TAG = "QueuedWorkHelper";
    private static Class<?> clsQueuedWork = null;
    private static Field fieldWork = null;
    private static Method hasPendingWorkMethod = null;
    private static boolean inited = false;
    private static ProxyHandler mHandler = null;
    private static Handler originHandler = null;
    private static LinkedList<Runnable> sFinishers = null;
    private static Object sLock = null;
    private static boolean sOutBuild = false;
    private static LinkedList<Runnable> sWork = null;
    private static boolean sWorkEmptyReported = false;
    private static int sleepTime = 100;

    public static void init() {
        FLogger fLogger;
        StringBuilder sb;
        Field field;
        Field field2;
        Field field3;
        Method methodInner;
        if (inited) {
            return;
        }
        sOutBuild = !AppHost.INSTANCE.isDebug();
        if (Build.VERSION.SDK_INT < 26 || Build.VERSION.SDK_INT > 33) {
            FLogger.INSTANCE.d(TAG, "QueuedWorkHelper does not support " + Build.VERSION.SDK_INT);
            return;
        }
        try {
            Class<?> cls = Class.forName("android.app.QueuedWork");
            clsQueuedWork = cls;
            field = DoubleReflectHelper.getField(cls, "sHandler");
            fieldWork = DoubleReflectHelper.getField(clsQueuedWork, "sWork");
            field2 = DoubleReflectHelper.getField(clsQueuedWork, "sFinishers");
            field3 = DoubleReflectHelper.getField(clsQueuedWork, "sLock");
            methodInner = DoubleReflectHelper.getMethodInner(clsQueuedWork, "getHandler", new Class[0]);
            hasPendingWorkMethod = DoubleReflectHelper.getMethodInner(clsQueuedWork, "hasPendingWork", new Class[0]);
        } catch (Throwable th) {
            try {
                FLogger.INSTANCE.d(TAG, "ignore: " + th);
                fLogger = FLogger.INSTANCE;
                sb = new StringBuilder("init: ");
            } finally {
                FLogger.INSTANCE.d(TAG, "init: " + inited);
            }
        }
        if (methodInner == null) {
            return;
        }
        methodInner.invoke(null, new Object[0]);
        if (field == null) {
            return;
        }
        originHandler = (Handler) field.get(null);
        Field field4 = fieldWork;
        if (field4 != null && field3 != null) {
            sWork = (LinkedList) field4.get(null);
            sLock = field3.get(null);
        }
        if (sWork != null && sLock != null) {
            ProxyFinisher proxyFinisher = new ProxyFinisher();
            sFinishers = proxyFinisher;
            field2.set(null, proxyFinisher);
            ProxyHandler proxyHandler = new ProxyHandler(originHandler.getLooper());
            mHandler = proxyHandler;
            field.set(null, proxyHandler);
            inited = true;
            fLogger = FLogger.INSTANCE;
            sb = new StringBuilder("init: ");
            fLogger.d(TAG, sb.append(inited).toString());
        }
    }

    public static void setSleepTime(int i) {
        sleepTime = i;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static class ProxyFinisher extends LinkedList<Runnable> {
        @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, java.util.Queue
        public boolean add(Runnable runnable) {
            return true;
        }

        @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
        public boolean remove(Object obj) {
            return true;
        }

        private ProxyFinisher() {
        }

        @Override // java.util.LinkedList, java.util.Deque, java.util.Queue
        public Runnable poll() {
            try {
                if (Build.VERSION.SDK_INT >= 31) {
                    LinkedList unused = QueuedWorkHelper.sWork = (LinkedList) QueuedWorkHelper.fieldWork.get(null);
                }
                if (!QueuedWorkHelper.sOutBuild && QueuedWorkHelper.sWork != null) {
                    FLogger.INSTANCE.d(QueuedWorkHelper.TAG, "ProxyFinisher: sWork.size: " + QueuedWorkHelper.sWork.size());
                }
            } catch (Throwable th) {
                FLogger.INSTANCE.e(QueuedWorkHelper.TAG, th.getMessage());
            }
            return null;
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static class ProxyHandler extends Handler {
        private static boolean hasRun;
        private static boolean running;
        LinkedList<Runnable> cache;

        ProxyHandler(Looper looper) {
            super(looper);
            this.cache = new LinkedList<>();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            LinkedList<Runnable> linkedList;
            if (!QueuedWorkHelper.sOutBuild) {
                FLogger.INSTANCE.d(QueuedWorkHelper.TAG, "handleMessage begin cache.size: " + this.cache.size());
            }
            if (this.cache.isEmpty()) {
                return;
            }
            synchronized (QueuedWorkHelper.sLock) {
                linkedList = this.cache;
                this.cache = new LinkedList<>();
            }
            running = true;
            if (QueuedWorkHelper.sleepTime != -1) {
                try {
                    Thread.sleep(QueuedWorkHelper.sleepTime);
                } catch (InterruptedException e) {
                    FLogger.INSTANCE.i(QueuedWorkHelper.TAG, "ignore: " + e);
                }
            }
            if (!QueuedWorkHelper.sOutBuild) {
                FLogger.INSTANCE.d(QueuedWorkHelper.TAG, "handleMessage clone.size: " + linkedList.size());
            }
            Iterator<Runnable> it = linkedList.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
            if (!this.cache.isEmpty()) {
                sendMessageAtFrontOfQueue(Message.obtain(this, 2));
            } else {
                running = false;
            }
        }

        @Override // android.os.Handler
        public boolean sendMessageAtTime(Message message, long j) {
            boolean z = hasRun;
            if (!z) {
                try {
                    LinkedList unused = QueuedWorkHelper.sWork = (LinkedList) QueuedWorkHelper.fieldWork.get(null);
                    QueuedWorkHelper.originHandler.removeMessages(1);
                    QueuedWorkHelper.sFinishers.clear();
                    hasRun = true;
                } catch (Throwable unused2) {
                }
            }
            if (!QueuedWorkHelper.sOutBuild) {
                FLogger.INSTANCE.d(QueuedWorkHelper.TAG, "sendMessageAtTime cache.size: " + this.cache.size() + "  sWork.size: " + QueuedWorkHelper.sWork.size() + "  hasRunBackUp: " + z + "  hasRun: " + hasRun + "  hasPendingWork:" + QueuedWorkHelper.hasPendingWorkMethod.invoke(null, new Object[0]));
            }
            if (QueuedWorkHelper.sWork.isEmpty() && !QueuedWorkHelper.sWorkEmptyReported) {
                boolean unused3 = QueuedWorkHelper.sWorkEmptyReported = true;
            }
            if (QueuedWorkHelper.sWork.size() == 1) {
                this.cache.addLast((Runnable) QueuedWorkHelper.sWork.poll());
            } else if (QueuedWorkHelper.sWork.size() > 1) {
                for (Runnable runnable = (Runnable) QueuedWorkHelper.sWork.poll(); runnable != null; runnable = (Runnable) QueuedWorkHelper.sWork.poll()) {
                    this.cache.addLast(runnable);
                }
            }
            if (running) {
                return true;
            }
            message.what = 2;
            return super.sendMessageAtFrontOfQueue(message);
        }
    }
}
