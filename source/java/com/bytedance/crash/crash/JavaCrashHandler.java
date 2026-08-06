package com.bytedance.crash.crash;

import com.bytedance.crash.CrashType;
import com.bytedance.crash.Global;
import com.bytedance.crash.ICrashCallback;
import com.bytedance.crash.IOOMCallback;
import com.bytedance.crash.IPreCrashCallback;
import com.bytedance.crash.NpthCore;
import com.bytedance.crash.UserDataCenter;
import com.bytedance.crash.config.RuntimeConfig;
import com.bytedance.crash.dumper.tools.ThrowableDumper;
import com.bytedance.crash.java.CrashIgnoreHandler;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.CrashListener;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.NpthLog;
import java.io.File;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class JavaCrashHandler implements Thread.UncaughtExceptionHandler {
    private static volatile boolean isDumpHistoryMessage;
    private static volatile boolean isDumpViewTree;
    private static volatile boolean isHprofEnable;
    private static final ArrayList<CrashIgnoreHandler> sCrashIgnoreHandlers = new ArrayList<>();
    private static boolean sIsDropData;
    private JSONArray mAllData;
    private final CrashDumper mCrashDumper;
    private final AtomicBoolean mLatch = new AtomicBoolean(false);
    private final Thread.UncaughtExceptionHandler mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();

    public static void setHprofEnable(boolean z) {
        isHprofEnable = z;
    }

    public static void setDumpViewTreeEnable(boolean z) {
        isDumpViewTree = z;
    }

    public static void setDumpHistoryMessageEnable(boolean z) {
        isDumpHistoryMessage = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JavaCrashHandler(CrashDumper crashDumper) {
        this.mCrashDumper = crashDumper;
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    private boolean handleException(Thread thread, Throwable th) {
        Global.setHasCrashBefore(true);
        AppMonitor appMonitor = MonitorManager.getAppMonitor();
        if (appMonitor != null && appMonitor.getUserDataCenter().isIgnored(thread, th)) {
            return (ignoreTag(th, thread) & 1) != 0;
        }
        long currentTimeMillis = System.currentTimeMillis();
        File directory = this.mCrashDumper.getDirectory();
        FileSystemUtils.createDirectory(directory);
        boolean isLaunchCrash = isLaunchCrash(currentTimeMillis);
        CrashType crashType = isLaunchCrash ? CrashType.LAUNCH : CrashType.JAVA;
        boolean isOutOfMemory = isOutOfMemory(th);
        if (!sIsDropData) {
            JavaCrashSummary.dump(directory, thread, th, currentTimeMillis, isLaunchCrash, isOutOfMemory);
            ThrowableDumper.dump(directory, th);
            NpthLog.m229e("NPTH", th + " has been detected!");
            NpthLog.m229e("NPTH", "handleException：" + directory);
            this.mCrashDumper.dumpAppVersion();
            handlePreCallbacks(crashType, currentTimeMillis);
            this.mCrashDumper.dumpCrashInfoFromJava(crashType, currentTimeMillis, isDumpViewTree, isDumpHistoryMessage);
        }
        boolean z = (ignoreTag(th, thread) & 1) != 0;
        if (z) {
            try {
                new File(directory, "ignore").createNewFile();
            } catch (Throwable unused) {
            }
        }
        handleCallbacks(thread, th, directory, crashType, currentTimeMillis, isOutOfMemory);
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001c A[Catch: all -> 0x0021, TryCatch #1 {, blocks: (B:9:0x0016, B:10:0x001f, B:14:0x001c, B:16:0x0011, B:4:0x0002, B:6:0x000b), top: B:3:0x0002, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0016 A[Catch: all -> 0x0021, TryCatch #1 {, blocks: (B:9:0x0016, B:10:0x001f, B:14:0x001c, B:16:0x0011, B:4:0x0002, B:6:0x000b), top: B:3:0x0002, inners: #0 }] */
    @Override // java.lang.Thread.UncaughtExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void uncaughtException(Thread thread, Throwable th) {
        synchronized (this) {
            boolean z = false;
            try {
                if (this.mLatch.compareAndSet(false, true)) {
                    z = handleException(thread, th);
                }
            } finally {
                if (z) {
                }
            }
            if (z) {
                this.mDefaultHandler.uncaughtException(thread, th);
            } else {
                afterIgnore(th, thread);
            }
        }
    }

    private static int ignoreTag(Throwable th, Thread thread) {
        int i = 0;
        int i2 = 0;
        while (true) {
            ArrayList<CrashIgnoreHandler> arrayList = sCrashIgnoreHandlers;
            if (i >= arrayList.size()) {
                break;
            }
            try {
                try {
                    i2 |= arrayList.get(i).shouldIgnore(th, thread);
                } catch (Throwable unused) {
                }
                i++;
            } catch (Throwable unused2) {
            }
        }
        return i2;
    }

    public static boolean isOutOfMemory(Throwable th) {
        int i = 20;
        while (th != null) {
            int i2 = i - 1;
            if (i <= 0) {
                return false;
            }
            try {
                if (th instanceof OutOfMemoryError) {
                    return true;
                }
                th = th.getCause();
                i = i2;
            } catch (Throwable unused) {
                return false;
            }
        }
        return false;
    }

    private static boolean isJavaOom(Throwable th) {
        String message;
        while (th != null) {
            try {
                if ((th instanceof OutOfMemoryError) && (message = th.getMessage()) != null && (message.contains("allocate") || message.contains("thrown"))) {
                    return true;
                }
                th = th.getCause();
            } catch (Throwable unused) {
                return false;
            }
        }
        return false;
    }

    public static boolean isLaunchCrash(long j) {
        return j - Global.getAppStartTime() <= RuntimeConfig.getLaunchCrashInterval() && !(NpthCore.isCurrentMiniAppProcess() && NpthCore.getMiniAppId() == 0);
    }

    private void handleCallbacks(Thread thread, Throwable th, File file, CrashType crashType, long j, boolean z) {
        String load = ThrowableDumper.load(file);
        boolean isJavaOom = isJavaOom(th);
        Iterator<CrashListener> it = MonitorManager.getCrashListenerList().iterator();
        while (it.hasNext()) {
            handleMonitorCallbacks(it.next(), z, isJavaOom, crashType, th, thread, load, j);
        }
    }

    private void handleMonitorCallbacks(CrashListener crashListener, boolean z, boolean z2, CrashType crashType, Throwable th, Thread thread, String str, long j) {
        if (crashListener == null) {
            return;
        }
        UserDataCenter userDataCenter = crashListener.getUserDataCenter();
        List<IOOMCallback> oOMCallback = (z || z2) ? userDataCenter.getOOMCallback() : null;
        if (oOMCallback != null) {
            Iterator<IOOMCallback> it = oOMCallback.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onCrash(crashType, th, thread, j);
                } catch (Throwable unused) {
                }
            }
        }
        List<ICrashCallback> crashCallback = userDataCenter.getCrashCallback(crashType);
        if (crashCallback != null) {
            Iterator<ICrashCallback> it2 = crashCallback.iterator();
            while (it2.hasNext()) {
                try {
                    it2.next().onCrash(crashType, str, thread);
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public static void setIgnoreHandler(CrashIgnoreHandler crashIgnoreHandler) {
        sCrashIgnoreHandlers.add(crashIgnoreHandler);
    }

    private static void afterIgnore(Throwable th, Thread thread) {
        int i = 0;
        while (true) {
            ArrayList<CrashIgnoreHandler> arrayList = sCrashIgnoreHandlers;
            if (i >= arrayList.size()) {
                return;
            }
            try {
                try {
                    arrayList.get(i).afterIgnore(th, thread);
                } catch (Throwable unused) {
                }
                i++;
            } catch (Throwable unused2) {
                return;
            }
        }
    }

    public static void setDropData(boolean z) {
        sIsDropData = z;
    }

    private void handlePreCallbacks(CrashType crashType, long j) {
        try {
            AppMonitor appMonitor = MonitorManager.getAppMonitor();
            if (appMonitor == null) {
                return;
            }
            Iterator<IPreCrashCallback> it = appMonitor.getUserDataCenter().getPreCrashCallback(crashType).iterator();
            while (it.hasNext()) {
                try {
                    it.next().onCrash(crashType, j);
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
        }
    }
}
