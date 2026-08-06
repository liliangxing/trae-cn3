package com.bytedance.sliver;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import com.bytedance.sliver.Sliver;
import com.ss.android.update.UpdateDialogNewBase;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class SliverAllThreadSupport {
    static final int SLIVER_GROUP_CACHE_SIZE = 50000;
    private static final int SUPPORT_API_MAX = 31;
    private static final int SUPPORT_API_MIN = 21;
    private static final List<SliverGroup> threadGroups = new LinkedList();
    private static final Thread mainThread = Looper.getMainLooper().getThread();
    private static volatile boolean isStart = false;
    private static volatile boolean isRunning = false;
    private static int samplingRateMs = 10;
    private static Sliver.ThreadFilter filter = null;
    private static Handler threadHandler = null;
    private static ThreadGroup systemThreadGroup = null;

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nClearSliverGroup(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nDumpSliverGroup(long j, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public static native int nGetThreadId(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nNotifySliverGroup(long j, Thread[] threadArr, long[] jArr);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nPauseSliverGroup(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nResumeSliverGroup(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public static native long nStartSliverGroup(int i, int i2, int i3, int i4);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nStopSliverGroup(long j);

    SliverAllThreadSupport() {
    }

    static /* synthetic */ List access$200() {
        return getAllThread();
    }

    static /* synthetic */ Handler access$300() {
        return newThreadHandler();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isStart() {
        return isStart;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean startAll(int i, int i2, int i3, Sliver.Mode mode, Sliver.ThreadFilter threadFilter) {
        if (Build.VERSION.SDK_INT > 31 || isStart || !initSystemThreadGroup()) {
            return false;
        }
        samplingRateMs = i2;
        filter = threadFilter;
        List<SliverGroup> list = threadGroups;
        list.clear();
        int max = Math.max(i, 2);
        SliverGroup sliverGroup = new SliverGroup(0, i2, i3, mode);
        sliverGroup.add(mainThread);
        sliverGroup.notifyThread();
        list.add(sliverGroup);
        for (int i4 = 1; i4 < max; i4++) {
            threadGroups.add(new SliverGroup(i4, i2, i3, mode));
        }
        newThreadHandler().post(new SliverThreadMonitor(i2 * 5));
        isStart = true;
        isRunning = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean stopAll() {
        if (!isStart) {
            return false;
        }
        Iterator<SliverGroup> it = threadGroups.iterator();
        while (it.hasNext()) {
            it.next().stop();
        }
        threadGroups.clear();
        deleteThreadHandler();
        isStart = false;
        isRunning = false;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean dumpAll(final String str, boolean z) {
        if (!isStart) {
            return false;
        }
        Runnable runnable = new Runnable() { // from class: com.bytedance.sliver.SliverAllThreadSupport.1
            @Override // java.lang.Runnable
            public void run() {
                if (SliverAllThreadSupport.dumpHeader(str)) {
                    Iterator it = SliverAllThreadSupport.threadGroups.iterator();
                    while (it.hasNext()) {
                        ((SliverGroup) it.next()).dumpHeader(str);
                    }
                    Iterator it2 = SliverAllThreadSupport.threadGroups.iterator();
                    while (it2.hasNext()) {
                        ((SliverGroup) it2.next()).dump(str);
                    }
                }
            }
        };
        if (z) {
            runnable.run();
            return true;
        }
        newThreadHandler().post(runnable);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean pauseAll() {
        if (!isStart || !isRunning) {
            return false;
        }
        Iterator<SliverGroup> it = threadGroups.iterator();
        while (it.hasNext()) {
            it.next().pause();
        }
        deleteThreadHandler();
        isRunning = false;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean resumeAll() {
        if (!isStart || isRunning) {
            return false;
        }
        Iterator<SliverGroup> it = threadGroups.iterator();
        while (it.hasNext()) {
            it.next().resume();
        }
        newThreadHandler().post(new SliverThreadMonitor(samplingRateMs));
        isRunning = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean clearAll() {
        if (!isStart) {
            return false;
        }
        Iterator<SliverGroup> it = threadGroups.iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean dumpHeader(String str) {
        BufferedWriter bufferedWriter = null;
        try {
            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(str));
            try {
                bufferedWriter2.write("# sliver\n");
                bufferedWriter2.write("# pid:" + Process.myPid() + UpdateDialogNewBase.TYPE);
                bufferedWriter2.flush();
                try {
                    bufferedWriter2.close();
                    return true;
                } catch (IOException unused) {
                    return true;
                }
            } catch (Throwable unused2) {
                bufferedWriter = bufferedWriter2;
                if (bufferedWriter == null) {
                    return false;
                }
                try {
                    bufferedWriter.close();
                    return false;
                } catch (IOException unused3) {
                    return false;
                }
            }
        } catch (Throwable unused4) {
        }
    }

    private static synchronized Handler newThreadHandler() {
        Handler handler;
        synchronized (SliverAllThreadSupport.class) {
            if (threadHandler == null) {
                HandlerThread handlerThread = new HandlerThread("sliver_check_thread");
                handlerThread.start();
                threadHandler = new Handler(handlerThread.getLooper());
            }
            handler = threadHandler;
        }
        return handler;
    }

    private static synchronized void deleteThreadHandler() {
        synchronized (SliverAllThreadSupport.class) {
            Handler handler = threadHandler;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                threadHandler.getLooper().quitSafely();
                threadHandler = null;
            }
        }
    }

    private static boolean initSystemThreadGroup() {
        try {
            if (systemThreadGroup == null) {
                Field declaredField = ThreadGroup.class.getDeclaredField("systemThreadGroup");
                declaredField.setAccessible(true);
                systemThreadGroup = (ThreadGroup) declaredField.get(null);
            }
        } catch (Throwable unused) {
        }
        return systemThreadGroup != null;
    }

    private static List<Thread> getAllThread() {
        int activeCount = systemThreadGroup.activeCount();
        Thread[] threadArr = new Thread[activeCount + (activeCount / 2)];
        int enumerate = systemThreadGroup.enumerate(threadArr);
        ArrayList arrayList = new ArrayList(enumerate);
        for (int i = 0; i < enumerate; i++) {
            Thread thread = threadArr[i];
            if (thread != mainThread && !thread.getName().contains("sliver")) {
                arrayList.add(threadArr[i]);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class SliverThreadMonitor implements Runnable {
        private List<Thread> preThreads;
        private final int samplingRateMs;

        public SliverThreadMonitor(int i) {
            this.samplingRateMs = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            List<Thread> access$200 = SliverAllThreadSupport.access$200();
            if (this.preThreads == null) {
                onNewThread(access$200);
            } else {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (Thread thread : access$200) {
                    if (!this.preThreads.contains(thread)) {
                        arrayList.add(thread);
                    }
                }
                for (Thread thread2 : this.preThreads) {
                    if (!access$200.contains(thread2)) {
                        arrayList2.add(thread2);
                    }
                }
                onDeleteThread(arrayList2);
                onNewThread(arrayList);
            }
            this.preThreads = access$200;
            notifyThreadGroup();
            SliverAllThreadSupport.access$300().postDelayed(this, this.samplingRateMs);
        }

        private void notifyThreadGroup() {
            Iterator it = SliverAllThreadSupport.threadGroups.iterator();
            while (it.hasNext()) {
                ((SliverGroup) it.next()).notifyThread();
            }
        }

        private void onDeleteThread(List<Thread> list) {
            for (Thread thread : list) {
                for (int i = 1; i < SliverAllThreadSupport.threadGroups.size() && !((SliverGroup) SliverAllThreadSupport.threadGroups.get(i)).remove(thread); i++) {
                }
            }
        }

        private void onNewThread(List<Thread> list) {
            int size = list.size();
            int i = 0;
            while (true) {
                int i2 = 1;
                while (i < size) {
                    if (SliverAllThreadSupport.filter == null || SliverAllThreadSupport.filter.traceEnable(list.get(i))) {
                        ((SliverGroup) SliverAllThreadSupport.threadGroups.get(i2)).add(list.get(i));
                        i++;
                        i2++;
                        if (i2 >= SliverAllThreadSupport.threadGroups.size()) {
                            break;
                        }
                    } else {
                        i++;
                    }
                }
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class SliverGroup {
        private final int cacheSize;
        private final int index;
        private final Sliver.Mode mode;
        private final int samplingRateMs;
        private volatile long peer = 0;
        private volatile boolean change = false;
        private final HashSet<Thread> threads = new HashSet<>();

        SliverGroup(int i, int i2, int i3, Sliver.Mode mode) {
            this.index = i;
            this.samplingRateMs = i2;
            this.cacheSize = i3;
            this.mode = mode;
        }

        synchronized void add(Thread thread) {
            this.threads.add(thread);
            this.change = true;
        }

        synchronized boolean remove(Thread thread) {
            if (this.threads.isEmpty()) {
                return false;
            }
            if (!this.threads.remove(thread)) {
                return false;
            }
            this.change = true;
            return true;
        }

        synchronized void notifyThread() {
            start();
            if (this.peer == 0) {
                return;
            }
            if (this.change) {
                ArrayList arrayList = new ArrayList(this.threads.size());
                ArrayList arrayList2 = new ArrayList(this.threads.size());
                Iterator<Thread> it = this.threads.iterator();
                while (it.hasNext()) {
                    Thread next = it.next();
                    long threadPeer = Sliver.getThreadPeer(next);
                    if (threadPeer != 0) {
                        arrayList.add(Long.valueOf(threadPeer));
                        arrayList2.add(next);
                    }
                }
                long[] jArr = new long[arrayList.size()];
                for (int i = 0; i < arrayList.size(); i++) {
                    jArr[i] = ((Long) arrayList.get(i)).longValue();
                }
                SliverAllThreadSupport.nNotifySliverGroup(this.peer, (Thread[]) arrayList2.toArray(new Thread[0]), jArr);
                this.change = false;
            }
        }

        synchronized void start() {
            if (this.peer != 0) {
                return;
            }
            this.peer = SliverAllThreadSupport.nStartSliverGroup(this.samplingRateMs, this.cacheSize, Sliver.mode2Int(this.mode), this.index);
        }

        synchronized void stop() {
            if (this.peer == 0) {
                return;
            }
            SliverAllThreadSupport.nStopSliverGroup(this.peer);
        }

        synchronized void dumpHeader(String str) {
            BufferedWriter bufferedWriter = null;
            try {
                try {
                    BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(str, true));
                    try {
                        Iterator<Thread> it = this.threads.iterator();
                        while (it.hasNext()) {
                            Thread next = it.next();
                            long threadPeer = Sliver.getThreadPeer(next);
                            if (threadPeer != 0) {
                                bufferedWriter2.write("# thread_info:" + SliverAllThreadSupport.nGetThreadId(threadPeer) + Constants.COLON_SEPARATOR + next.getName() + UpdateDialogNewBase.TYPE);
                            }
                        }
                        bufferedWriter2.flush();
                        bufferedWriter2.close();
                    } catch (Throwable unused) {
                        bufferedWriter = bufferedWriter2;
                        if (bufferedWriter != null) {
                            bufferedWriter.close();
                        }
                    }
                } catch (Throwable unused2) {
                }
            } catch (IOException unused3) {
            }
        }

        synchronized int getThreadNum() {
            return this.threads.size();
        }

        synchronized void dump(String str) {
            SliverAllThreadSupport.nDumpSliverGroup(this.peer, str);
        }

        synchronized void pause() {
            SliverAllThreadSupport.nPauseSliverGroup(this.peer);
        }

        synchronized void resume() {
            SliverAllThreadSupport.nResumeSliverGroup(this.peer);
        }

        synchronized void clear() {
            SliverAllThreadSupport.nClearSliverGroup(this.peer);
        }
    }
}
