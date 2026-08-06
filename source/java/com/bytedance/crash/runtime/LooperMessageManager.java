package com.bytedance.crash.runtime;

import android.os.Looper;
import android.os.SystemClock;
import android.util.Printer;
import com.bytedance.crash.util.NpthLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Deprecated
/* loaded from: classes3.dex */
public class LooperMessageManager {
    private static final char END = '<';
    private static final long MESSAGE_WAIT_INTERVAL_MAX = 5000;
    private static final char START = '>';
    private static LooperMessageManager sInstance;
    private static Printer sOriginalPrinter;
    private static final Printer sPrinter = new Printer() { // from class: com.bytedance.crash.runtime.LooperMessageManager.1
        @Override // android.util.Printer
        public void println(String str) {
            if (str == null) {
                return;
            }
            if (str.charAt(0) == '>') {
                LooperMessageManager.getInstance().dispatching(str);
            } else if (str.charAt(0) == '<') {
                LooperMessageManager.getInstance().finished(str);
            }
            if (LooperMessageManager.sOriginalPrinter == null || LooperMessageManager.sOriginalPrinter == LooperMessageManager.sPrinter) {
                return;
            }
            LooperMessageManager.sOriginalPrinter.println(str);
        }
    };
    private boolean mIsStarted;
    private long mFinishDispatchTime = -1;
    private final List<Printer> mStartRunnableList = new ArrayList();
    private final List<Printer> mEndRunnableList = new ArrayList();

    private LooperMessageManager() {
    }

    public static LooperMessageManager getInstance() {
        if (sInstance == null) {
            synchronized (LooperMessageManager.class) {
                if (sInstance == null) {
                    sInstance = new LooperMessageManager();
                }
            }
        }
        return sInstance;
    }

    public void start() {
        if (this.mIsStarted) {
            return;
        }
        this.mIsStarted = true;
        Printer currentPrinter = getCurrentPrinter();
        sOriginalPrinter = currentPrinter;
        Printer printer = sPrinter;
        if (currentPrinter == printer) {
            sOriginalPrinter = null;
        }
        Looper.getMainLooper().setMessageLogging(printer);
    }

    private Printer getCurrentPrinter() {
        try {
            Field declaredField = Class.forName("android.os.Looper").getDeclaredField("mLogging");
            declaredField.setAccessible(true);
            return (Printer) declaredField.get(Looper.getMainLooper());
        } catch (Exception e) {
            NpthLog.w(e);
            return null;
        }
    }

    public void stop() {
        if (this.mIsStarted) {
            this.mIsStarted = false;
            if (getCurrentPrinter() != sPrinter || sOriginalPrinter == null) {
                return;
            }
            Looper.getMainLooper().setMessageLogging(sOriginalPrinter);
        }
    }

    public boolean isStarted() {
        return this.mIsStarted;
    }

    public void registerSyncEndPrinter(Printer printer) {
        this.mEndRunnableList.add(printer);
    }

    public synchronized void registerSyncStartPrinter(Printer printer) {
        this.mStartRunnableList.add(printer);
    }

    public boolean noMessageDispatch() {
        return this.mFinishDispatchTime != -1 && SystemClock.uptimeMillis() - this.mFinishDispatchTime > 5000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatching(String str) {
        this.mFinishDispatchTime = -1L;
        try {
            invokeCallbackList(this.mStartRunnableList, str);
        } catch (Exception e) {
            NpthLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finished(String str) {
        this.mFinishDispatchTime = SystemClock.uptimeMillis();
        try {
            invokeCallbackList(this.mEndRunnableList, str);
        } catch (Exception e) {
            NpthLog.w(e);
        }
    }

    private static void invokeCallbackList(List<? extends Printer> list, String str) {
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Printer printer = list.get(i);
                if (printer == null) {
                    return;
                }
                printer.println(str);
            }
        } catch (Throwable th) {
            NpthLog.e(th);
        }
    }
}
