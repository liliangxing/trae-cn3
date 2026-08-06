package com.bytedance.monitor.collector;

import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Printer;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.block.ILooperObserver;
import com.bytedance.apm.block.LooperObserverMonitor;
import com.bytedance.apm.block.trace.MainThreadMonitor;
import com.bytedance.apm.samplers.SamplerHelper;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.LooperPrinterUtils;
import com.bytedance.perf.monitor.ReportConst;
import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class LooperMonitor {
    private static final char END = '<';
    private static final char START = '>';
    private static final String TAG = "LooperMonitor";
    private static volatile IReporter iReporter;
    private static boolean mBlocked;
    private static AbsLooperDispatchListener mFirstListener;
    private static boolean mLooperBlocked;
    private static AbsLooperDispatchListener mRealFirstListener;
    private static volatile boolean sInited;
    private static Printer sLooperUtilsPrinter;
    private static ILooperObserver sObserver;
    private static Printer sPrinter;
    private static List<Printer> tempPrinters;
    private static final CopyOnWriteArrayList<AbsLooperDispatchListener> listeners = new CopyOnWriteArrayList<>();
    private static volatile boolean enableLooperCostMonitor = false;
    private static long cost = 0;
    private static int count = 0;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface IReporter {
        void reportCost(long j);
    }

    public static void enableLooperCostMonitor(boolean z) {
        enableLooperCostMonitor = z;
    }

    public static void setReporter(IReporter iReporter2) {
        iReporter = iReporter2;
    }

    public static void init() {
        if (Util.enable || sInited) {
            return;
        }
        sInited = true;
        sPrinter = new Printer() { // from class: com.bytedance.monitor.collector.LooperMonitor.1
            @Override // android.util.Printer
            public void println(String str) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (str.charAt(0) == '>') {
                    if (Util.enableLooperObserver) {
                        LooperObserverMonitor.messageDispatchStarting(str);
                        return;
                    } else {
                        LooperMonitor.dispatch(true, str, null);
                        return;
                    }
                }
                if (str.charAt(0) == '<') {
                    if (Util.enableLooperObserver) {
                        LooperObserverMonitor.messageDispatched(str, (Message) null);
                    } else {
                        LooperMonitor.dispatch(false, str, null);
                    }
                }
            }
        };
        sObserver = new ILooperObserver() { // from class: com.bytedance.monitor.collector.LooperMonitor.2
            public void messageDispatchStarting(String str) {
                LooperMonitor.dispatch(true, str, null);
            }

            public void messageDispatched(String str, Message message) {
                LooperMonitor.dispatch(false, str, message);
            }
        };
        if (Util.enableLooperObserver && LooperObserverMonitor.init(sPrinter)) {
            if (ApmContext.isDebugMode()) {
                Logger.i(TAG, "enable Looper Observer monitor.");
            }
            if (LooperObserverMonitor.isUsePrinter) {
                initLooperPrinterUtils();
            }
            LooperObserverMonitor.addMessageObserver(sObserver);
            return;
        }
        initLooperPrinterUtils();
    }

    public static void setFirstListener(AbsLooperDispatchListener absLooperDispatchListener) {
        mFirstListener = absLooperDispatchListener;
    }

    public static void setRealFirstListener(AbsLooperDispatchListener absLooperDispatchListener) {
        mRealFirstListener = absLooperDispatchListener;
        if (absLooperDispatchListener != null) {
            unBlockLooperMonitor();
        }
    }

    public static void destroy() {
        if (sInited) {
            LooperPrinterUtils.removeMessageLogging(sPrinter);
        }
    }

    public static void initLooperPrinterUtils() {
        LooperPrinterUtils.init();
        LooperPrinterUtils.addMessageLogging(sPrinter);
    }

    private static boolean realUseLooperObserver() {
        return Util.enableLooperObserver && LooperObserverMonitor.init(sPrinter) && !LooperObserverMonitor.isUsePrinter;
    }

    public static void blockLooperMonitor() {
        if (!sInited || mBlocked || mRealFirstListener != null) {
            if (!mBlocked || mLooperBlocked) {
                return;
            }
            blockLooperPrinterObserver();
            return;
        }
        if (SamplerHelper.getPerfSecondStageSwitch(ReportConst.MONITOR_TYPE_BLOCK)) {
            return;
        }
        blockLooperPrinterObserver();
        if (realUseLooperObserver()) {
            if (ApmContext.isDebugMode()) {
                Logger.i(TAG, "enable Looper Observer monitor.");
            }
            LooperObserverMonitor.removeMessageObserver(sObserver);
        } else {
            LooperPrinterUtils.removeMessageLogging(sPrinter);
        }
        mBlocked = true;
    }

    public static void blockLooperPrinterObserver() {
        if (sInited && !mLooperBlocked && Util.enableLooperOpt) {
            if (realUseLooperObserver()) {
                List observers = LooperObserverMonitor.getObservers();
                if (observers != null && observers.size() == 1 && observers.get(0) == sObserver) {
                    LooperObserverMonitor.removeMessageObserverWrapper();
                    mLooperBlocked = true;
                }
            } else {
                List printers = LooperPrinterUtils.getPrinters();
                if (printers != null && printers.size() == 1 && printers.get(0) == sPrinter) {
                    Printer currentPrinter = getCurrentPrinter();
                    sLooperUtilsPrinter = currentPrinter;
                    if (currentPrinter != null) {
                        Looper.getMainLooper().setMessageLogging(null);
                        mLooperBlocked = true;
                    }
                }
            }
            if (ApmContext.isDebugMode()) {
                Logger.i(TAG, "enable Looper Observer block.");
            }
        }
    }

    private static Printer getCurrentPrinter() {
        try {
            Field declaredField = Class.forName("android.os.Looper").getDeclaredField("mLogging");
            declaredField.setAccessible(true);
            return (Printer) declaredField.get(Looper.getMainLooper());
        } catch (Exception unused) {
            return null;
        }
    }

    public static int getLisenerSize() {
        return listeners.size();
    }

    public static void unBlockLooperMonitor() {
        if (sInited && mBlocked) {
            unBlockLooperPrinterObserver(false);
            if (realUseLooperObserver()) {
                if (ApmContext.isDebugMode()) {
                    Logger.i(TAG, "enable Looper Observer monitor.");
                }
                LooperObserverMonitor.addMessageObserver(sObserver);
            } else {
                initLooperPrinterUtils();
            }
            mBlocked = false;
        }
    }

    public static void unBlockLooperPrinterObserver(boolean z) {
        if (sInited && mLooperBlocked && Util.enableLooperOpt) {
            if (realUseLooperObserver() && z) {
                return;
            }
            if (realUseLooperObserver()) {
                LooperObserverMonitor.addMessageObserverWrapper();
            } else if (sLooperUtilsPrinter != null) {
                Looper.getMainLooper().setMessageLogging(sLooperUtilsPrinter);
            }
            if (ApmContext.isDebugMode()) {
                Logger.i(TAG, "enable Looper Observer unblock.");
            }
            mLooperBlocked = false;
        }
    }

    public static void register(AbsLooperDispatchListener absLooperDispatchListener) {
        CopyOnWriteArrayList<AbsLooperDispatchListener> copyOnWriteArrayList = listeners;
        synchronized (copyOnWriteArrayList) {
            if (absLooperDispatchListener != null) {
                if (!copyOnWriteArrayList.contains(absLooperDispatchListener)) {
                    copyOnWriteArrayList.add(absLooperDispatchListener);
                    if (MainThreadMonitor.getMonitor().isEnableLooperOpt()) {
                        unBlockLooperMonitor();
                    }
                }
            }
        }
    }

    public static void unregister(AbsLooperDispatchListener absLooperDispatchListener) {
        if (absLooperDispatchListener == null) {
            return;
        }
        CopyOnWriteArrayList<AbsLooperDispatchListener> copyOnWriteArrayList = listeners;
        synchronized (copyOnWriteArrayList) {
            copyOnWriteArrayList.remove(absLooperDispatchListener);
            if (MainThreadMonitor.getMonitor().isEnableLooperOpt() && copyOnWriteArrayList.isEmpty() && MainThreadMonitor.getMonitor().getObservers() == 0 && mRealFirstListener == null) {
                blockLooperMonitor();
            }
        }
    }

    public static void checkLooperState() {
        if (sInited && !mBlocked && MainThreadMonitor.getMonitor().isEnableLooperOpt()) {
            int observers = MainThreadMonitor.getMonitor().getObservers();
            if (listeners.isEmpty() && observers == 0 && mRealFirstListener == null) {
                blockLooperMonitor();
            }
        }
    }

    public static void dispatch(boolean z, String str, Message message) {
        AbsLooperDispatchListener absLooperDispatchListener;
        AbsLooperDispatchListener absLooperDispatchListener2;
        AbsLooperDispatchListener absLooperDispatchListener3;
        AbsLooperDispatchListener absLooperDispatchListener4;
        long nanoTime = System.nanoTime();
        AbsLooperDispatchListener.uptime = nanoTime / 1000000;
        AbsLooperDispatchListener.cpuTime = SystemClock.currentThreadTimeMillis();
        if (z && (absLooperDispatchListener4 = mRealFirstListener) != null && absLooperDispatchListener4.isValid()) {
            mRealFirstListener.dispatchStart(str);
        }
        if (z && (absLooperDispatchListener3 = mFirstListener) != null && absLooperDispatchListener3.isValid()) {
            mFirstListener.dispatchStart(str);
        }
        try {
            CopyOnWriteArrayList<AbsLooperDispatchListener> copyOnWriteArrayList = listeners;
            for (int i = 0; i < copyOnWriteArrayList.size(); i++) {
                AbsLooperDispatchListener absLooperDispatchListener5 = copyOnWriteArrayList.get(i);
                if (absLooperDispatchListener5 == null || !absLooperDispatchListener5.isValid()) {
                    if (!z && absLooperDispatchListener5.isHasDispatchStart) {
                        absLooperDispatchListener5.dispatchEnd("", null);
                    }
                } else if (z) {
                    if (!absLooperDispatchListener5.isHasDispatchStart) {
                        absLooperDispatchListener5.dispatchStart(str);
                    }
                } else if (absLooperDispatchListener5.isHasDispatchStart) {
                    absLooperDispatchListener5.dispatchEnd(str, message);
                }
            }
        } catch (Exception unused) {
        }
        if (!z && (absLooperDispatchListener2 = mFirstListener) != null && absLooperDispatchListener2.isValid()) {
            mFirstListener.dispatchEnd("", null);
        }
        if (!z && (absLooperDispatchListener = mRealFirstListener) != null && absLooperDispatchListener.isValid()) {
            mRealFirstListener.dispatchEnd("", null);
        }
        if (enableLooperCostMonitor) {
            cost += System.nanoTime() - nanoTime;
            int i2 = count;
            count = i2 + 1;
            if (i2 >= 1000) {
                if (iReporter != null) {
                    iReporter.reportCost(cost);
                }
                count = 0;
                cost = 0L;
                enableLooperCostMonitor = false;
            }
        }
    }
}
