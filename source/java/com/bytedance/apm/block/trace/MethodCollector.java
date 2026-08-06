package com.bytedance.apm.block.trace;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bytedance.apm.block.BlockConstants;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.monitor.collector.AbsLooperDispatchListener;
import com.bytedance.monitor.collector.LooperMonitor;
import com.bytedance.perf.collector.TraceDataUtils;
import java.util.LinkedList;

/* loaded from: classes3.dex */
public class MethodCollector {
    public static final int DEFAULT_STACK_DEPTH = 5;
    public static final int METHOD_ID_DISPATCH = 1048574;
    private static final int METHOD_ID_MAX = 1048575;
    private static final int STATUS_DEFAULT = Integer.MAX_VALUE;
    private static final int STATUS_EXPIRED_START = -2;
    private static final int STATUS_NO_PERMIT = -4;
    private static final int STATUS_OUT_RELEASE = -3;
    private static final int STATUS_READY = 1;
    private static final int STATUS_STARTED = 2;
    private static final int STATUS_STOPPED = -1;
    private static final String TAG = "MethodCollector";
    private static boolean assertIn;
    private static Runnable checkStartExpiredRunnable;
    private static boolean isPauseUpdateTime;
    private static AbsLooperDispatchListener looperMonitorListener;
    private static long[] sBuffer;
    private static volatile long sCurrentDiffTime;
    private static volatile long sDiffTime;
    private static Handler sHandler;
    private static int sIndex;
    private static IndexRecord sIndexRecordHead;
    private static IndexRecord sIndexRecordTail;
    private static int sLastIndex;
    private static Thread sMainThread;
    private static volatile Runnable sReleaseOnMainThread;
    private static HandlerThread sTimerUpdateThread;
    private static Runnable sUpdateDiffTimeRunnable;
    private static volatile int status;
    private static final Object statusLock;
    private static Object updateTimeLock;
    private static MethodCollector sInstance = new MethodCollector();
    private static volatile boolean sDontRecord = false;

    private static long getTime(long j) {
        return j & 8796093022207L;
    }

    static /* synthetic */ long access$600() {
        return getCurrentTime();
    }

    static {
        status = Integer.MAX_VALUE;
        Object obj = new Object();
        statusLock = obj;
        sBuffer = null;
        sIndex = 0;
        sLastIndex = -1;
        assertIn = false;
        sCurrentDiffTime = getCurrentTime();
        sDiffTime = sCurrentDiffTime;
        sMainThread = Looper.getMainLooper().getThread();
        sReleaseOnMainThread = null;
        sTimerUpdateThread = getTimerUpdateThread();
        sHandler = new Handler(sTimerUpdateThread.getLooper());
        updateTimeLock = new Object();
        isPauseUpdateTime = false;
        checkStartExpiredRunnable = null;
        looperMonitorListener = new AbsLooperDispatchListener() { // from class: com.bytedance.apm.block.trace.MethodCollector.1
            @Override // com.bytedance.monitor.collector.AbsLooperDispatchListener
            public boolean isValid() {
                if (MethodCollector.sReleaseOnMainThread != null) {
                    MethodCollector.sReleaseOnMainThread.run();
                    Runnable unused = MethodCollector.sReleaseOnMainThread = null;
                }
                return MethodCollector.status >= 1;
            }

            @Override // com.bytedance.monitor.collector.AbsLooperDispatchListener
            public void dispatchStart(String str) {
                super.dispatchStart(str);
                MethodCollector.dispatchBegin();
            }

            @Override // com.bytedance.monitor.collector.AbsLooperDispatchListener
            public void dispatchEnd(String str, Message message) {
                super.dispatchEnd(str, message);
                MethodCollector.dispatchEnd();
            }
        };
        sUpdateDiffTimeRunnable = new Runnable() { // from class: com.bytedance.apm.block.trace.MethodCollector.2
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    try {
                        if (MethodCollector.isPauseUpdateTime || MethodCollector.status <= -1) {
                            synchronized (MethodCollector.updateTimeLock) {
                                MethodCollector.updateTimeLock.wait();
                            }
                        } else {
                            long unused = MethodCollector.sCurrentDiffTime = MethodCollector.access$600() - MethodCollector.sDiffTime;
                            MethodCollector.sCurrentDiffTime &= 8796093022207L;
                            SystemClock.sleep(5L);
                        }
                    } catch (InterruptedException unused2) {
                        return;
                    }
                }
            }
        };
        sBuffer = new long[BlockConstants.BUFFER_SIZE];
        if (status == Integer.MAX_VALUE) {
            synchronized (obj) {
                if (status == Integer.MAX_VALUE) {
                    realExecute();
                    status = 1;
                }
            }
        }
        i(METHOD_ID_DISPATCH, 0L);
        maskIndex("EvilMethodTracer#message_0", AbsLooperDispatchListener.uptime);
        sHandler.postDelayed(new Runnable() { // from class: com.bytedance.apm.block.trace.MethodCollector.3
            @Override // java.lang.Runnable
            public void run() {
                MethodCollector.realRelease();
            }
        }, 15000L);
    }

    private static HandlerThread getTimerUpdateThread() {
        HandlerThread handlerThread = new HandlerThread("trace_time_update_thread");
        handlerThread.start();
        return handlerThread;
    }

    public static MethodCollector getInstance() {
        return sInstance;
    }

    public void onStart() {
        synchronized (statusLock) {
            if (status < 2 && status >= -2) {
                sHandler.removeCallbacks(checkStartExpiredRunnable);
                if (sBuffer == null) {
                    throw new RuntimeException("MethodCollector sBuffer == null");
                }
                status = 2;
                sDontRecord = false;
            }
        }
    }

    public void onStop() {
        synchronized (statusLock) {
            if (status == 2) {
                status = -1;
                sDontRecord = true;
            }
        }
    }

    public boolean isAlive() {
        return status >= 2;
    }

    public static boolean isRealTrace() {
        return status >= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void realRelease() {
        synchronized (statusLock) {
            if (status == Integer.MAX_VALUE || status == -4) {
                status = -3;
                sDontRecord = true;
                sReleaseOnMainThread = new Runnable() { // from class: com.bytedance.apm.block.trace.MethodCollector.4
                    @Override // java.lang.Runnable
                    public void run() {
                        MethodCollector.sHandler.removeCallbacksAndMessages(null);
                        LooperMonitor.unregister(MethodCollector.looperMonitorListener);
                        MethodCollector.sTimerUpdateThread.quit();
                        long[] unused = MethodCollector.sBuffer = null;
                    }
                };
            }
        }
    }

    public static void releaseForOpt() {
        synchronized (statusLock) {
            status = -3;
            sDontRecord = true;
            sReleaseOnMainThread = new Runnable() { // from class: com.bytedance.apm.block.trace.MethodCollector.5
                @Override // java.lang.Runnable
                public void run() {
                    MethodCollector.sHandler.removeCallbacksAndMessages(null);
                    LooperMonitor.unregister(MethodCollector.looperMonitorListener);
                    MethodCollector.sTimerUpdateThread.quit();
                    long[] unused = MethodCollector.sBuffer = null;
                }
            };
        }
    }

    private static long getCurrentTime() {
        return SystemClock.uptimeMillis();
    }

    public static long getCurrentDiffTime() {
        return sCurrentDiffTime;
    }

    private static void realExecute() {
        sCurrentDiffTime = getCurrentTime() - sDiffTime;
        sHandler.removeCallbacksAndMessages(null);
        sHandler.postDelayed(sUpdateDiffTimeRunnable, 5L);
        Handler handler = sHandler;
        Runnable runnable = new Runnable() { // from class: com.bytedance.apm.block.trace.MethodCollector.6
            @Override // java.lang.Runnable
            public void run() {
                synchronized (MethodCollector.statusLock) {
                    if (MethodCollector.status == Integer.MAX_VALUE || MethodCollector.status == 1) {
                        int unused = MethodCollector.status = -2;
                        boolean unused2 = MethodCollector.sDontRecord = true;
                    }
                }
            }
        };
        checkStartExpiredRunnable = runnable;
        handler.postDelayed(runnable, 15000L);
        LooperMonitor.register(looperMonitorListener);
    }

    public static void unRegisterListener() {
        LooperMonitor.unregister(looperMonitorListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dispatchBegin() {
        sCurrentDiffTime = AbsLooperDispatchListener.uptime - sDiffTime;
        isPauseUpdateTime = false;
        synchronized (updateTimeLock) {
            updateTimeLock.notify();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dispatchEnd() {
        isPauseUpdateTime = true;
    }

    public static void i(int i, long j) {
        if (!sDontRecord && i < METHOD_ID_MAX && Thread.currentThread() == sMainThread && !assertIn) {
            assertIn = true;
            if (j != 0) {
                sCurrentDiffTime = j - sDiffTime;
                sCurrentDiffTime &= 8796093022207L;
            }
            long j2 = (i << 43) | Long.MIN_VALUE | sCurrentDiffTime;
            long[] jArr = sBuffer;
            int i2 = sIndex;
            jArr[i2] = j2;
            int i3 = i2 + 1;
            sIndex = i3;
            if (i3 == 600000) {
                sIndex = 0;
            }
            assertIn = false;
            IndexRecord indexRecord = sIndexRecordTail;
            if (indexRecord != null && indexRecord.index == sIndex) {
                IndexRecord indexRecord2 = sIndexRecordTail.pre;
                sIndexRecordTail = indexRecord2;
                if (indexRecord2 == null) {
                    sIndexRecordHead = null;
                } else {
                    indexRecord2.next = null;
                }
            }
        }
    }

    public static void o(int i, long j) {
        if (!sDontRecord && i < METHOD_ID_MAX && Thread.currentThread() == sMainThread) {
            if (j != 0) {
                sCurrentDiffTime = j - sDiffTime;
                sCurrentDiffTime &= 8796093022207L;
            }
            long j2 = (i << 43) | 0 | sCurrentDiffTime;
            long[] jArr = sBuffer;
            int i2 = sIndex;
            jArr[i2] = j2;
            int i3 = i2 + 1;
            sIndex = i3;
            if (i3 == 600000) {
                sIndex = 0;
            }
            IndexRecord indexRecord = sIndexRecordTail;
            if (indexRecord == null || indexRecord.index != sIndex) {
                return;
            }
            IndexRecord indexRecord2 = sIndexRecordTail.pre;
            sIndexRecordTail = indexRecord2;
            if (indexRecord2 == null) {
                sIndexRecordHead = null;
            } else {
                indexRecord2.next = null;
            }
        }
    }

    public static String getVisibleScene() {
        return ActivityLifeObserver.getInstance().getTopActivityClassName();
    }

    public static IndexRecord maskIndex(String str, long j) {
        if (sIndexRecordHead == null) {
            IndexRecord indexRecord = new IndexRecord(sIndex);
            sIndexRecordHead = indexRecord;
            if (j <= 0) {
                j = SystemClock.uptimeMillis();
            }
            indexRecord.timestamp = j;
            sIndexRecordHead.source = str;
            IndexRecord indexRecord2 = sIndexRecordHead;
            sIndexRecordTail = indexRecord2;
            return indexRecord2;
        }
        IndexRecord indexRecord3 = new IndexRecord(sIndex);
        if (j <= 0) {
            j = SystemClock.uptimeMillis();
        }
        indexRecord3.timestamp = j;
        indexRecord3.source = str;
        indexRecord3.next = sIndexRecordHead;
        sIndexRecordHead.endIndex = indexRecord3.index - 1;
        sIndexRecordHead.pre = indexRecord3;
        sIndexRecordHead = indexRecord3;
        return indexRecord3;
    }

    public IndexRecord getCurrentMethodIndex(String str) {
        int i = sIndex - 1;
        IndexRecord indexRecord = new IndexRecord(i);
        indexRecord.source = str;
        if (i >= 0) {
            long[] jArr = sBuffer;
            if (i < jArr.length) {
                indexRecord.timestamp = getTime(jArr[i]);
            }
        }
        return indexRecord;
    }

    public static int getLastMethodIndex() {
        return sIndex - 1;
    }

    /* loaded from: classes3.dex */
    public static final class IndexRecord {
        int endIndex;
        public int index;
        boolean isValid = true;
        private IndexRecord next;
        private IndexRecord pre;
        public String source;
        private long timestamp;

        public IndexRecord(int i) {
            this.index = i;
        }

        public String toString() {
            return "index:" + this.index + ",\tisValid:" + this.isValid + " source:" + this.source;
        }
    }

    public long[] copyData(IndexRecord indexRecord) {
        return copyData(indexRecord, new IndexRecord(sIndex - 1));
    }

    public long[] copyData(IndexRecord indexRecord, IndexRecord indexRecord2) {
        if (status == -3) {
            return null;
        }
        long[] jArr = new long[0];
        try {
            if (indexRecord.isValid && indexRecord2.isValid) {
                return copyData(indexRecord.index - 1, indexRecord2.index);
            }
        } catch (OutOfMemoryError unused) {
        }
        return jArr;
    }

    public long[] copyAllData() {
        IndexRecord indexRecord;
        try {
            IndexRecord indexRecord2 = sIndexRecordHead;
            if (indexRecord2 != null && (indexRecord = sIndexRecordTail) != null && indexRecord2 != indexRecord) {
                return copyData(sIndexRecordTail.index, indexRecord2.endIndex == 0 ? sIndex - 1 : sIndexRecordHead.endIndex);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private long[] copyData(long j, long j2) {
        IndexRecord indexRecord;
        IndexRecord indexRecord2 = sIndexRecordHead;
        if (indexRecord2 == null || (indexRecord = sIndexRecordTail) == null) {
            return null;
        }
        while (indexRecord2 != indexRecord) {
            if (indexRecord2.next.timestamp <= j2) {
                if (indexRecord.pre.timestamp >= j) {
                    break;
                }
                indexRecord = indexRecord.pre;
            } else {
                indexRecord2 = indexRecord2.next;
            }
        }
        return copyData(indexRecord.index, indexRecord2.endIndex == 0 ? sIndex - 1 : indexRecord2.endIndex);
    }

    public long[] copyData(int i, int i2) {
        long[] jArr = new long[0];
        int max = Math.max(0, i);
        int max2 = Math.max(0, i2);
        if (max2 > max) {
            int i3 = (max2 - max) + 1;
            long[] jArr2 = new long[i3];
            System.arraycopy(sBuffer, max, jArr2, 0, i3);
            return jArr2;
        }
        if (max2 >= max) {
            return jArr;
        }
        int i4 = max2 + 1;
        long[] jArr3 = sBuffer;
        long[] jArr4 = new long[(jArr3.length - max) + i4];
        System.arraycopy(jArr3, max, jArr4, 0, jArr3.length - max);
        long[] jArr5 = sBuffer;
        System.arraycopy(jArr5, 0, jArr4, jArr5.length - max, i4);
        return jArr4;
    }

    public static long getDiffTime() {
        return sDiffTime;
    }

    public static long getLastMethodTime() {
        return getTime(sBuffer[sIndex - 1]);
    }

    public String getEvilMethod(long j, long j2) {
        return evilMethodString(copyData(j, j2), SystemClock.uptimeMillis());
    }

    public String evilMethodString(long[] jArr, long j) {
        if (jArr == null) {
            return "";
        }
        LinkedList linkedList = new LinkedList();
        TraceDataUtils.structuredDataToStack(jArr, (LinkedList<MethodItem>) linkedList, true, j);
        TraceDataUtils.trimStack(linkedList, 1);
        StringBuilder sb = new StringBuilder();
        TraceDataUtils.stackToString(linkedList, sb);
        return sb.toString();
    }
}
