package com.lynx.animax.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.lynx.animax.util.AnimaXLog;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes6.dex */
public class CleanupReference extends PhantomReference<Object> {
    private static final int ADD_REF = 1;
    private static final boolean DEBUG = false;
    private static final int REMOVE_REF = 2;
    private static final String TAG = "CleanupReference";
    private static final Thread sReaperThread;
    private static ConcurrentLinkedQueue sReaperThreadPendingRefs;
    private static Set<CleanupReference> sReaperThreadRefs;
    private static Set<CleanupReference> sUiThreadRefs;
    private final boolean mCleanupOnUiThread;
    private Runnable mCleanupTask;
    private static ReferenceQueue<Object> sGcQueue = new ReferenceQueue<>();
    private static Object sCleanupMonitor = new Object();

    static {
        Thread thread = new Thread(TAG) { // from class: com.lynx.animax.base.CleanupReference.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                while (true) {
                    try {
                        CleanupReference cleanupReference = (CleanupReference) CleanupReference.sGcQueue.remove();
                        synchronized (CleanupReference.sCleanupMonitor) {
                            if (!cleanupReference.mCleanupOnUiThread) {
                                CleanupReference.sReaperThreadPendingRefs.offer(cleanupReference);
                            } else {
                                Message.obtain(LazyHolder.sHandler, 2, cleanupReference).sendToTarget();
                                CleanupReference.sCleanupMonitor.wait(500L);
                            }
                            while (true) {
                                CleanupReference cleanupReference2 = (CleanupReference) CleanupReference.sReaperThreadPendingRefs.poll();
                                if (cleanupReference2 == null) {
                                    break;
                                } else {
                                    cleanupReference2.runCleanupTaskInternal(CleanupReference.sReaperThreadRefs);
                                }
                            }
                        }
                    } catch (Exception e) {
                        AnimaXLog.e(CleanupReference.TAG, "Queue remove exception:" + e.toString());
                    }
                }
            }
        };
        sReaperThread = thread;
        thread.setDaemon(true);
        thread.start();
        sUiThreadRefs = new HashSet();
        sReaperThreadRefs = ConcurrentHashMap.newKeySet();
        sReaperThreadPendingRefs = new ConcurrentLinkedQueue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class LazyHolder {
        static final Handler sHandler = new Handler(Looper.getMainLooper()) { // from class: com.lynx.animax.base.CleanupReference.LazyHolder.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                CleanupReference cleanupReference = (CleanupReference) message.obj;
                int i = message.what;
                if (i == 1) {
                    CleanupReference.sUiThreadRefs.add(cleanupReference);
                } else if (i != 2) {
                    AnimaXLog.e(CleanupReference.TAG, String.format("Bad message=%d", Integer.valueOf(message.what)));
                } else {
                    cleanupReference.runCleanupTaskInternal(CleanupReference.sUiThreadRefs);
                }
                synchronized (CleanupReference.sCleanupMonitor) {
                    while (true) {
                        CleanupReference cleanupReference2 = (CleanupReference) CleanupReference.sGcQueue.poll();
                        if (cleanupReference2 != null) {
                            if (!cleanupReference2.mCleanupOnUiThread) {
                                CleanupReference.sReaperThreadPendingRefs.offer(cleanupReference2);
                            } else {
                                cleanupReference2.runCleanupTaskInternal(CleanupReference.sUiThreadRefs);
                            }
                        } else {
                            CleanupReference.sCleanupMonitor.notifyAll();
                        }
                    }
                }
            }
        };

        private LazyHolder() {
        }
    }

    public CleanupReference(Object obj, Runnable runnable, boolean z) {
        super(obj, sGcQueue);
        this.mCleanupTask = runnable;
        this.mCleanupOnUiThread = z;
        if (!z) {
            sReaperThreadRefs.add(this);
        } else {
            handleOnUiThread(1);
        }
    }

    public void cleanupNow() {
        if (!this.mCleanupOnUiThread) {
            runCleanupTaskInternal(sReaperThreadRefs);
        } else {
            handleOnUiThread(2);
        }
    }

    public boolean hasCleanedUp() {
        return this.mCleanupTask == null;
    }

    private void handleOnUiThread(int i) {
        Message obtain = Message.obtain(LazyHolder.sHandler, i, this);
        if (Looper.myLooper() == obtain.getTarget().getLooper()) {
            obtain.getTarget().handleMessage(obtain);
            obtain.recycle();
        } else {
            obtain.sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runCleanupTaskInternal(Set<CleanupReference> set) {
        if (set.remove(this)) {
            Runnable runnable = this.mCleanupTask;
            this.mCleanupTask = null;
            if (runnable != null) {
                runnable.run();
            }
            clear();
        }
    }
}
