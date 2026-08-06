package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import android.util.Log;
import com.bytedance.shadowhook.ShadowHook;
import java.lang.Thread;

/* loaded from: classes5.dex */
public class GetHeldByThreadOpt {
    private static String TAG = "GetHeldByThreadOpt";
    private static boolean sShadowHookInited;
    static Thread threadA = new Thread();
    static Thread threadB = new Thread();
    static Thread threadC = new Thread();

    /* loaded from: classes5.dex */
    public static class ThreadData {
        public Thread thread = null;
        public int tid = 0;
        public int threadid = 0;
        public boolean deadLock = false;
        public boolean countException = false;
    }

    public static native int getHeldByThreadId(Thread thread, int i);

    public static native int nativePeer2ThreadTid(Thread thread, int i);

    public static native int nativePeer2Threadid(Thread thread, int i);

    public static boolean Init(Context context) {
        if (sShadowHookInited) {
            return true;
        }
        try {
            if (SysOptimizer.loadOptimizerLibrary(context)) {
                ShadowHook.init(new ShadowHook.ConfigBuilder().setMode(ShadowHook.Mode.SHARED).setDebuggable(true).build());
                sShadowHookInited = true;
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static ThreadData getThreadDataForLockMonitor(Thread thread) {
        return getThreadDataForLockMonitor(thread, thread, 0);
    }

    public static void debug() {
        debugWaitLockForThread();
        debugWaitLockFor2Thread();
        debugWaitLockForDeadLock();
        debugWaitLockForDeadLock2();
    }

    public static void debugWaitLockForThread() {
        final Object obj = new Object();
        Thread thread = new Thread(new Runnable() { // from class: com.bytedance.sysoptimizer.GetHeldByThreadOpt.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (obj) {
                    try {
                        Thread.sleep(500L);
                        if (GetHeldByThreadOpt.threadB.getState() == Thread.State.BLOCKED) {
                            long threadCpuTimeNanos = Debug.threadCpuTimeNanos();
                            ThreadData threadDataForLockMonitor = GetHeldByThreadOpt.getThreadDataForLockMonitor(GetHeldByThreadOpt.threadB);
                            if (threadDataForLockMonitor.thread == null) {
                                Log.d(GetHeldByThreadOpt.TAG, "debugWaitLockForThread getThreadDataForLockMonitor error");
                            } else {
                                Log.d(GetHeldByThreadOpt.TAG, "debugWaitLockForThread result block Thread: " + GetHeldByThreadOpt.threadB.getName() + ", threadid:" + GetHeldByThreadOpt.threadB.getId() + ", wait lock:" + (GetHeldByThreadOpt.threadB.getState() == Thread.State.BLOCKED) + ", held by:" + threadDataForLockMonitor.threadid + ", heldByThread:" + threadDataForLockMonitor.thread.getName() + ", held bytid:" + threadDataForLockMonitor.tid + ", deadLock:" + threadDataForLockMonitor.deadLock + ", useCpuTime:" + ((Debug.threadCpuTimeNanos() - threadCpuTimeNanos) / 1000000));
                                Process.setThreadPriority(threadDataForLockMonitor.tid, -20);
                                AnrThreadPriorityOpt.getAllThreadPriorty();
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        threadA = thread;
        thread.start();
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread thread2 = new Thread(new Runnable() { // from class: com.bytedance.sysoptimizer.GetHeldByThreadOpt.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (obj) {
                    Log.d(GetHeldByThreadOpt.TAG, "");
                }
            }
        });
        threadB = thread2;
        thread2.start();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        Log.d(TAG, "debugWaitLockForThread answer: block thread:" + threadB.getName() + ", held by thread:" + threadA.getName());
    }

    public static void debugWaitLockFor2Thread() {
        final Object obj = new Object();
        final Object obj2 = new Object();
        Thread thread = new Thread(new Runnable() { // from class: com.bytedance.sysoptimizer.GetHeldByThreadOpt.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (obj) {
                    try {
                        Thread.sleep(1000L);
                        if (GetHeldByThreadOpt.threadC.getState() == Thread.State.BLOCKED) {
                            long threadCpuTimeNanos = Debug.threadCpuTimeNanos();
                            ThreadData threadDataForLockMonitor = GetHeldByThreadOpt.getThreadDataForLockMonitor(GetHeldByThreadOpt.threadC);
                            if (threadDataForLockMonitor.thread == null) {
                                Log.d(GetHeldByThreadOpt.TAG, "debugWaitLockFor2Thread getThreadDataForLockMonitor error");
                            } else {
                                Log.d(GetHeldByThreadOpt.TAG, "debugWaitLockFor2Thread result block Thread: " + GetHeldByThreadOpt.threadC.getName() + ", threadid:" + GetHeldByThreadOpt.threadC.getId() + ", wait lock:" + (GetHeldByThreadOpt.threadC.getState() == Thread.State.BLOCKED) + ", held by:" + threadDataForLockMonitor.threadid + ", heldByThread:" + threadDataForLockMonitor.thread.getName() + ", held bytid:" + threadDataForLockMonitor.tid + ", deadLock:" + threadDataForLockMonitor.deadLock + ", useCpuTime:" + ((Debug.threadCpuTimeNanos() - threadCpuTimeNanos) / 1000000));
                                Process.setThreadPriority(threadDataForLockMonitor.tid, -20);
                                AnrThreadPriorityOpt.getAllThreadPriorty();
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        threadA = thread;
        thread.start();
        try {
            Thread.sleep(200L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread thread2 = new Thread(new Runnable() { // from class: com.bytedance.sysoptimizer.GetHeldByThreadOpt.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (obj2) {
                    synchronized (obj) {
                    }
                }
            }
        });
        threadB = thread2;
        thread2.start();
        try {
            Thread.sleep(200L);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        Thread thread3 = new Thread(new Runnable() { // from class: com.bytedance.sysoptimizer.GetHeldByThreadOpt.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (obj2) {
                    synchronized (obj) {
                    }
                }
            }
        });
        threadC = thread3;
        thread3.start();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e3) {
            e3.printStackTrace();
        }
        Log.d(TAG, "debugWaitLockFor2Thread answer:  block thread:" + threadC.getName() + ", held by thread:" + threadA.getName());
    }

    public static void debugWaitLockForDeadLock() {
        final Object obj = new Object();
        final Object obj2 = new Object();
        Thread thread = new Thread(new Runnable() { // from class: com.bytedance.sysoptimizer.GetHeldByThreadOpt.6
            @Override // java.lang.Runnable
            public void run() {
                synchronized (obj) {
                    try {
                        Thread.sleep(1000L);
                        synchronized (obj2) {
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        threadA = thread;
        thread.start();
        try {
            Thread.sleep(200L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread thread2 = new Thread(new Runnable() { // from class: com.bytedance.sysoptimizer.GetHeldByThreadOpt.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    synchronized (obj2) {
                        Thread.sleep(1000L);
                        synchronized (obj) {
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
        threadB = thread2;
        thread2.start();
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        if (threadA.getState() == Thread.State.BLOCKED) {
            long threadCpuTimeNanos = Debug.threadCpuTimeNanos();
            ThreadData threadDataForLockMonitor = getThreadDataForLockMonitor(threadA);
            if (threadDataForLockMonitor.thread != null && !threadDataForLockMonitor.countException) {
                Log.d(TAG, "debugWaitLockForDeadLock result block Thread: " + threadA.getName() + ", threadid:" + threadA.getId() + ", wait lock:" + (threadA.getState() == Thread.State.BLOCKED) + ", held by:" + threadDataForLockMonitor.threadid + ", heldByThread:" + threadDataForLockMonitor.thread.getName() + ", held bytid:" + threadDataForLockMonitor.tid + ", deadLock:" + threadDataForLockMonitor.deadLock + ", useCpuTime:" + ((Debug.threadCpuTimeNanos() - threadCpuTimeNanos) / 1000000));
            } else {
                Log.d(TAG, "debugWaitLockForDeadLock getThreadDataForLockMonitor error");
            }
        }
        Log.d(TAG, "debugWaitLockForDeadLock answer: block thread:" + threadA.getName() + ", dead lock by thread:" + threadB.getName());
    }

    public static void debugWaitLockForDeadLock2() {
        final Object obj = new Object();
        final Object obj2 = new Object();
        final Object obj3 = new Object();
        Thread thread = new Thread(new Runnable() { // from class: com.bytedance.sysoptimizer.GetHeldByThreadOpt.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Thread.sleep(1000L);
                    synchronized (obj) {
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadA = thread;
        thread.start();
        try {
            Thread.sleep(200L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread thread2 = new Thread(new Runnable() { // from class: com.bytedance.sysoptimizer.GetHeldByThreadOpt.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    synchronized (obj) {
                        synchronized (obj3) {
                            Thread.sleep(1000L);
                            synchronized (obj2) {
                            }
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
        threadB = thread2;
        thread2.start();
        Thread thread3 = new Thread(new Runnable() { // from class: com.bytedance.sysoptimizer.GetHeldByThreadOpt.10
            @Override // java.lang.Runnable
            public void run() {
                try {
                    synchronized (obj2) {
                        Thread.sleep(1000L);
                        synchronized (obj3) {
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
        threadC = thread3;
        thread3.start();
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        if (threadA.getState() == Thread.State.BLOCKED) {
            long threadCpuTimeNanos = Debug.threadCpuTimeNanos();
            ThreadData threadDataForLockMonitor = getThreadDataForLockMonitor(threadA);
            if (threadDataForLockMonitor.thread != null && !threadDataForLockMonitor.countException) {
                Log.d(TAG, "debugWaitLockForDeadLock result block Thread: " + threadA.getName() + ", threadid:" + threadA.getId() + ", wait lock:" + (threadA.getState() == Thread.State.BLOCKED) + ", held by:" + threadDataForLockMonitor.threadid + ", heldByThread:" + threadDataForLockMonitor.thread.getName() + ", held bytid:" + threadDataForLockMonitor.tid + ", deadLock:" + threadDataForLockMonitor.deadLock + ", useCpuTime:" + ((Debug.threadCpuTimeNanos() - threadCpuTimeNanos) / 1000000));
            } else {
                Log.d(TAG, "debugWaitLockForDeadLock getThreadDataForLockMonitor error");
            }
        }
        Log.d(TAG, "debugWaitLockForDeadLock answer: threadData.countException = true,  block thread:" + threadB.getName() + ", dead lock by thread:" + threadC.getName());
    }

    private static ThreadData getThreadDataForLockMonitor(Thread thread, Thread thread2, int i) {
        int heldByThreadId;
        Thread heldByThread;
        ThreadData threadData = new ThreadData();
        if (i > 15) {
            Log.d(TAG, "getThreadDataForLockMonitor count > 15");
            threadData.deadLock = true;
            threadData.countException = true;
            return threadData;
        }
        if (thread2.getState() == Thread.State.BLOCKED && (heldByThread = getHeldByThread((heldByThreadId = getHeldByThreadId(thread2, Build.VERSION.SDK_INT)))) != null) {
            int nativePeer2ThreadTid = nativePeer2ThreadTid(heldByThread, Build.VERSION.SDK_INT);
            threadData.thread = heldByThread;
            threadData.tid = nativePeer2ThreadTid;
            threadData.threadid = heldByThreadId;
            if (thread2 == heldByThread) {
                Log.d(TAG, "block thread: " + thread.getName() + ", held by:" + threadData.thread.getName());
                return threadData;
            }
            if (thread != heldByThread) {
                ThreadData threadDataForLockMonitor = getThreadDataForLockMonitor(thread, heldByThread, i + 1);
                if (threadDataForLockMonitor.countException) {
                    return threadDataForLockMonitor;
                }
                if (threadDataForLockMonitor.thread == null) {
                    Log.d(TAG, "block thread: " + thread.getName() + ", held by:" + threadData.thread.getName());
                    return threadData;
                }
                Log.d(TAG, "block thread: " + thread.getName() + ", held by:" + threadDataForLockMonitor.thread.getName());
                return threadDataForLockMonitor;
            }
            threadData.deadLock = true;
            threadData.thread = thread2;
            threadData.tid = nativePeer2ThreadTid(thread2, Build.VERSION.SDK_INT);
            threadData.threadid = getHeldByThreadId(thread2, Build.VERSION.SDK_INT);
            Log.d(TAG, "thread " + thread.getName() + ", dead lock whih:" + threadData.thread.getName());
        }
        return threadData;
    }

    private static Thread getHeldByThread(int i) {
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        int activeCount = Thread.activeCount();
        Thread[] threadArr = new Thread[activeCount];
        threadGroup.enumerate(threadArr);
        Thread thread = null;
        for (int i2 = 0; i2 < activeCount; i2++) {
            Thread thread2 = threadArr[i2];
            if (nativePeer2Threadid(thread2, Build.VERSION.SDK_INT) == i) {
                thread = thread2;
            }
        }
        return thread;
    }
}
