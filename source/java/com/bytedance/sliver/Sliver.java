package com.bytedance.sliver;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import com.bytedance.push.settings.pull.PullSettingsModel;
import com.bytedance.vcloud.strategy.StrategyCenter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes5.dex */
public final class Sliver {
    private static final int SUPPORT_API_MAX = 34;
    private static final int SUPPORT_API_MIN = 19;
    private static final String TAG = "SLIVER";
    private static final boolean isArt;
    private static volatile boolean isInit;
    private static final SliverExecutor sDefaultExecutor;
    private static final SliverLogger sDefaultLogger;
    private static SliverExecutor sExecutor;
    private static SliverLogger sLogger;
    private static boolean sLoggerEnable;
    private static final Field threadPeerField;
    private static final Field threadPeerFieldDalvik;
    private static final Map<Thread, Monitor> cache = new ConcurrentHashMap(16);
    private static final Map<String, Long> mark = new ConcurrentHashMap(16);
    private static final List<OnStackSamplingListener> sListenerList = new CopyOnWriteArrayList();

    /* loaded from: classes5.dex */
    public enum Mode {
        RING,
        NORMAL
    }

    /* loaded from: classes5.dex */
    public interface OnStackSamplingListener {
        void onSampling(Thread thread, long[] jArr, long j);
    }

    /* loaded from: classes5.dex */
    public interface SliverExecutor {
        void execute(Runnable runnable);
    }

    /* loaded from: classes5.dex */
    public interface SliverLogger {
        void onError(String str, Throwable th);

        void onStep(String str);
    }

    /* loaded from: classes5.dex */
    public interface ThreadFilter {
        boolean traceEnable(Thread thread);
    }

    private static boolean isArt() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nClear(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nDump(long j, String str, long j2);

    private static native long[] nGetMethodStackTrace(Thread thread, long j);

    private static native String nGetStackTrace(Thread thread, long j);

    private static native String nGetStackTrace(long[] jArr);

    private static native String[] nGetStackTrace3(long[] jArr);

    private static native boolean nInit(int i, Method method, boolean z, boolean z2);

    private static native void nPause(long j);

    private static native void nResetSamplingMs(long j, int i);

    private static native void nResume(long j);

    private static native long nStart(Thread thread, long j, int i, int i2, int i3);

    private static native void nStop(long j);

    static {
        Field field;
        Field declaredField;
        SliverLogger sliverLogger = new SliverLogger() { // from class: com.bytedance.sliver.Sliver.1
            @Override // com.bytedance.sliver.Sliver.SliverLogger
            public void onStep(String str) {
                Log.i(Sliver.TAG, str);
            }

            @Override // com.bytedance.sliver.Sliver.SliverLogger
            public void onError(String str, Throwable th) {
                Log.e(Sliver.TAG, str, th);
            }
        };
        sDefaultLogger = sliverLogger;
        sLogger = sliverLogger;
        sLoggerEnable = false;
        SliverExecutor sliverExecutor = new SliverExecutor() { // from class: com.bytedance.sliver.Sliver.2
            @Override // com.bytedance.sliver.Sliver.SliverExecutor
            public void execute(Runnable runnable) {
                AsyncTask.execute(runnable);
            }
        };
        sDefaultExecutor = sliverExecutor;
        sExecutor = sliverExecutor;
        boolean isArt2 = isArt();
        isArt = isArt2;
        Field field2 = null;
        try {
            if (isArt2) {
                declaredField = Thread.class.getDeclaredField("nativePeer");
            } else {
                declaredField = Thread.class.getDeclaredField("vmThread");
                try {
                    field2 = Class.forName("java.lang.VMThread").getDeclaredField("vmData");
                    field2.setAccessible(true);
                } catch (Throwable unused) {
                    Field field3 = field2;
                    field2 = declaredField;
                    field = field3;
                }
            }
            Field field4 = field2;
            field2 = declaredField;
            field = field4;
            try {
                field2.setAccessible(true);
            } catch (Throwable unused2) {
            }
        } catch (Throwable unused3) {
            field = field2;
        }
        threadPeerField = field2;
        threadPeerFieldDalvik = field;
    }

    public static void enableLog() {
        sLoggerEnable = true;
    }

    public static void setLogger(SliverLogger sliverLogger) {
        if (sliverLogger != null) {
            enableLog();
            sLogger = sliverLogger;
        }
    }

    public static void setExecutor(SliverExecutor sliverExecutor) {
        if (sliverExecutor != null) {
            sExecutor = sliverExecutor;
        }
    }

    public static synchronized boolean init(boolean z) {
        Method method;
        synchronized (Sliver.class) {
            int i = Build.VERSION.SDK_INT;
            if (i > 34) {
                onError("not support api : " + i + ", sliver support 19-34", new Throwable());
                return false;
            }
            if (isInit) {
                onStep("sliver already init");
                return true;
            }
            if (!loadLibrary()) {
                return false;
            }
            try {
                method = Looper.class.getMethod(PullSettingsModel.SCENE_LOOP, new Class[0]);
            } catch (Throwable unused) {
                method = null;
            }
            if (!nInit(i, method, z, isArt)) {
                onError("sliver init failed, because native init error", new Throwable());
                return false;
            }
            isInit = true;
            onStep("sliver init success, protect is " + z);
            return true;
        }
    }

    public static boolean isInit() {
        return isInit;
    }

    public static void mark(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        mark.put(str, Long.valueOf(System.nanoTime()));
    }

    public static synchronized void reportStack(Thread thread, long[] jArr, long j) {
        synchronized (Sliver.class) {
            int i = 0;
            while (true) {
                List<OnStackSamplingListener> list = sListenerList;
                if (i < list.size()) {
                    list.get(i).onSampling(thread, jArr, j);
                    i++;
                }
            }
        }
    }

    public static void registerSamplingListener(OnStackSamplingListener onStackSamplingListener) {
        List<OnStackSamplingListener> list = sListenerList;
        if (list.contains(onStackSamplingListener)) {
            return;
        }
        list.add(onStackSamplingListener);
    }

    public static void unRegisterSamplingListener(OnStackSamplingListener onStackSamplingListener) {
        sListenerList.remove(onStackSamplingListener);
    }

    public static synchronized long[] getMethodStackTrace(Thread thread) {
        synchronized (Sliver.class) {
            if (!init(false)) {
                return new long[0];
            }
            long threadPeer = getThreadPeer(thread);
            if (threadPeer == 0) {
                return new long[0];
            }
            return nGetMethodStackTrace(thread, threadPeer);
        }
    }

    public static synchronized String getStackTrace(long[] jArr) {
        synchronized (Sliver.class) {
            if (jArr != null) {
                if (jArr.length != 0) {
                    return nGetStackTrace(jArr);
                }
            }
            return "";
        }
    }

    public static synchronized String[] getStackTraceArray(long[] jArr) {
        synchronized (Sliver.class) {
            if (jArr != null) {
                if (jArr.length != 0) {
                    return nGetStackTrace3(jArr);
                }
            }
            return null;
        }
    }

    public static synchronized String getStackTrace(Thread thread) {
        synchronized (Sliver.class) {
            if (!init(false)) {
                return "";
            }
            long threadPeer = getThreadPeer(thread);
            if (threadPeer == 0) {
                return "";
            }
            return nGetStackTrace(thread, threadPeer);
        }
    }

    public static boolean start(int i) {
        return start(Thread.currentThread(), i, AndroidComposeViewAccessibilityDelegateCompat.ParcelSafeTextLength, Mode.RING);
    }

    public static synchronized boolean start(Thread thread, int i, int i2, Mode mode) {
        synchronized (Sliver.class) {
            if (SliverAllThreadSupport.isStart()) {
                onError("sliver start failed , because sliver all thread was started", new Throwable());
                return false;
            }
            if (!init(false)) {
                onError("sliver start failed , because sliver init failed", new Throwable());
                return false;
            }
            Map<Thread, Monitor> map = cache;
            if (map.containsKey(thread)) {
                onStep(thread + " already sampling by sliver");
                return true;
            }
            long threadPeer = getThreadPeer(thread);
            if (threadPeer == 0) {
                onError("sliver start failed , because can't get thread peer", new Throwable());
                return false;
            }
            int mode2Int = mode2Int(mode);
            long nStart = nStart(thread, threadPeer, i, i2, mode2Int);
            if (nStart == 0) {
                onError("sliver start failed , because can't get native peer", new Throwable());
                return false;
            }
            Monitor monitor = new Monitor();
            monitor.peer = nStart;
            monitor.focus = thread;
            monitor.samplingRateMs = i;
            monitor.methodCacheSize = i2;
            monitor.running = true;
            monitor.mode = mode2Int;
            map.put(thread, monitor);
            onStep(thread + " sampling by sliver success");
            return true;
        }
    }

    public static boolean pause() {
        return pause(Thread.currentThread());
    }

    public static synchronized boolean pause(Thread thread) {
        synchronized (Sliver.class) {
            Monitor monitor = cache.get(thread);
            if (monitor == null) {
                onError(thread + " pause failed, because thread is not sampling", new Throwable());
                return false;
            }
            if (!monitor.running) {
                onStep(thread + " already pause");
                return true;
            }
            nPause(monitor.peer);
            monitor.running = false;
            onStep(thread + " pause success");
            return true;
        }
    }

    public static boolean resume() {
        return resume(Thread.currentThread());
    }

    public static synchronized boolean resume(Thread thread) {
        synchronized (Sliver.class) {
            Monitor monitor = cache.get(thread);
            if (monitor == null) {
                onError(thread + " resume failed, because thread is not sampling", new Throwable());
                return false;
            }
            if (monitor.running) {
                onStep(thread + " already resume");
                return true;
            }
            nResume(monitor.peer);
            monitor.running = true;
            onStep(thread + " resume success");
            return true;
        }
    }

    public static boolean stop() {
        return stop(Thread.currentThread());
    }

    public static synchronized boolean stop(Thread thread) {
        synchronized (Sliver.class) {
            if (!isInit) {
                onError(thread + " stop failed, because sliver is not init", new Throwable());
                return false;
            }
            Monitor remove = cache.remove(thread);
            if (remove == null) {
                onError(thread + " stop failed, because thread is not sampling", new Throwable());
                return true;
            }
            nStop(remove.peer);
            onStep(thread + " stop success");
            return true;
        }
    }

    public static boolean dump(String str) {
        return dump(Thread.currentThread(), str);
    }

    public static boolean dump(String str, String str2) {
        return dump(Thread.currentThread(), str, str2);
    }

    public static boolean dump(Thread thread, String str) {
        return dump(thread, str, false);
    }

    public static boolean dump(Thread thread, String str, String str2) {
        return dump(thread, str, false, str2);
    }

    public static synchronized boolean dump(Thread thread, String str, boolean z) {
        boolean dump;
        synchronized (Sliver.class) {
            dump = dump(thread, str, z, null);
        }
        return dump;
    }

    public static synchronized boolean dump(final Thread thread, final String str, final boolean z, final String str2) {
        synchronized (Sliver.class) {
            if (!isInit) {
                onError(thread + " dump failed, because sliver is not init", new Throwable());
                return false;
            }
            final Monitor monitor = cache.get(thread);
            if (monitor == null) {
                onError(thread + " stop failed, because thread is not sampling", new Throwable());
                return false;
            }
            Runnable runnable = new Runnable() { // from class: com.bytedance.sliver.Sliver.3
                @Override // java.lang.Runnable
                public void run() {
                    Long l;
                    Sliver.nDump(monitor.peer, str, (TextUtils.isEmpty(str2) || (l = (Long) Sliver.mark.get(str2)) == null) ? -1L : l.longValue());
                    Sliver.onStep(thread + " dump " + (z ? "sync" : "async") + " success");
                }
            };
            onStep(thread + " dump " + (z ? "sync" : "async") + " start");
            if (z) {
                runnable.run();
            } else {
                sExecutor.execute(runnable);
            }
            return true;
        }
    }

    public static boolean clear() {
        return clear(Thread.currentThread());
    }

    public static synchronized boolean clear(final Thread thread) {
        synchronized (Sliver.class) {
            if (!isInit) {
                onError(thread + " clear failed, because sliver is not init", new Throwable());
                return false;
            }
            final Monitor monitor = cache.get(thread);
            if (monitor == null) {
                onError(thread + " clear failed, because thread is not sampling", new Throwable());
                return false;
            }
            sExecutor.execute(new Runnable() { // from class: com.bytedance.sliver.Sliver.4
                @Override // java.lang.Runnable
                public void run() {
                    Sliver.nClear(Monitor.this.peer);
                    Sliver.onStep(thread + " clear success");
                }
            });
            return true;
        }
    }

    public static boolean startAll(int i, int i2) {
        return startAll(i, i2, StrategyCenter.GLOBAL_OPTION_START, Mode.RING, null);
    }

    public static synchronized boolean startAll(int i, int i2, int i3, Mode mode, ThreadFilter threadFilter) {
        synchronized (Sliver.class) {
            if (!cache.isEmpty()) {
                return false;
            }
            if (!init(false)) {
                return false;
            }
            return SliverAllThreadSupport.startAll(i, i2, i3, mode, threadFilter);
        }
    }

    public static synchronized boolean stopAll() {
        boolean stopAll;
        synchronized (Sliver.class) {
            stopAll = SliverAllThreadSupport.stopAll();
        }
        return stopAll;
    }

    public static synchronized boolean dumpAll(String str) {
        boolean dumpAll;
        synchronized (Sliver.class) {
            dumpAll = dumpAll(str, false);
        }
        return dumpAll;
    }

    public static synchronized boolean dumpAll(String str, boolean z) {
        boolean dumpAll;
        synchronized (Sliver.class) {
            dumpAll = SliverAllThreadSupport.dumpAll(str, z);
        }
        return dumpAll;
    }

    public static synchronized boolean pauseAll() {
        boolean pauseAll;
        synchronized (Sliver.class) {
            pauseAll = SliverAllThreadSupport.pauseAll();
        }
        return pauseAll;
    }

    public static synchronized boolean resumeAll() {
        boolean resumeAll;
        synchronized (Sliver.class) {
            resumeAll = SliverAllThreadSupport.resumeAll();
        }
        return resumeAll;
    }

    public static synchronized boolean clearAll() {
        boolean clearAll;
        synchronized (Sliver.class) {
            clearAll = SliverAllThreadSupport.clearAll();
        }
        return clearAll;
    }

    public static synchronized boolean resetSamplingMs(int i) {
        boolean resetSamplingMs;
        synchronized (Sliver.class) {
            resetSamplingMs = resetSamplingMs(Thread.currentThread(), i);
        }
        return resetSamplingMs;
    }

    public static synchronized boolean resetSamplingMs(Thread thread, int i) {
        synchronized (Sliver.class) {
            if (!isInit) {
                onError(thread + " reset sampling ms  failed, because sliver is not init", new Throwable());
                return false;
            }
            Monitor monitor = cache.get(thread);
            if (monitor == null) {
                onError(thread + " reset sampling ms  failed, because thread is not sampling", new Throwable());
                return false;
            }
            nResetSamplingMs(monitor.peer, i);
            onStep(thread + " reset sampling ms success");
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getThreadPeer(Thread thread) {
        Field field;
        Object obj;
        Object obj2;
        try {
            if (isArt) {
                Field field2 = threadPeerField;
                if (field2 != null && (obj2 = field2.get(thread)) != null) {
                    return ((Long) obj2).longValue();
                }
                return 0L;
            }
            Field field3 = threadPeerField;
            if (field3 != null && (field = threadPeerFieldDalvik) != null && (obj = field.get(field3.get(thread))) != null) {
                return ((Integer) obj).intValue();
            }
            return 0L;
        } catch (Throwable unused) {
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int mode2Int(Mode mode) {
        return (mode != Mode.RING && mode == Mode.NORMAL) ? 1 : 0;
    }

    private static boolean loadLibrary() {
        try {
            System.loadLibrary("sliver");
            return true;
        } catch (Throwable th) {
            onError("sliver so load failed", th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class Monitor {
        Thread focus;
        int methodCacheSize;
        int mode;
        long peer;
        boolean running;
        int samplingRateMs;

        private Monitor() {
        }
    }

    static void onStep(String str) {
        if (sLoggerEnable) {
            sLogger.onStep(str);
        }
    }

    static void onError(String str, Throwable th) {
        if (sLoggerEnable) {
            sLogger.onError(str, th);
        }
    }
}
