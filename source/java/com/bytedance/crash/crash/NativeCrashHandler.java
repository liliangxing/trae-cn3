package com.bytedance.crash.crash;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.ICrashCallback;
import com.bytedance.crash.IPreCrashCallback;
import com.bytedance.crash.game.GameScriptStack;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.CrashListener;
import com.bytedance.crash.monitor.MonitorManager;
import java.io.File;
import java.util.Iterator;
import org.json.JSONArray;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class NativeCrashHandler {
    public static volatile boolean isDumpHistoryMessage;
    public static volatile boolean isDumpViewTree;
    private static volatile boolean isEnableDumpAllThreadStack;
    private JSONArray mAllData;
    private final CrashDumper mCrashDumper;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NativeCrashHandler(Context context, CrashDumper crashDumper) {
        this.mCrashDumper = crashDumper;
        NativeBridge.loadLibrary();
        NativeBridge.startNativeCrashMonitor(context, crashDumper.getDirectory());
    }

    public static void setDumpAllThreadStackEnable(boolean z) {
        isEnableDumpAllThreadStack = z;
    }

    public static void setDumpHistoryMessageEnable(boolean z) {
        isDumpHistoryMessage = z;
    }

    public static void setDumpViewTreeEnable(boolean z) {
        isDumpViewTree = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nativeDumperFinished(long j, int i) {
        if (j > 0) {
            handlePreCallbacks(j);
        }
        this.mCrashDumper.dumpJavaInfoAfterNative(j, isEnableDumpAllThreadStack, isDumpViewTree, isDumpHistoryMessage, i);
        if (j > 0) {
            File directory = this.mCrashDumper.getDirectory();
            GameScriptStack.dump(directory);
            String loadNativeCrashBacktrace = NativeBridge.loadNativeCrashBacktrace(directory.getAbsolutePath());
            if (TextUtils.isEmpty(loadNativeCrashBacktrace)) {
                return;
            }
            handleCallbacks(loadNativeCrashBacktrace);
        }
    }

    private void handlePreCallbacks(long j) {
        try {
            AppMonitor appMonitor = MonitorManager.getAppMonitor();
            if (appMonitor == null) {
                return;
            }
            Iterator<IPreCrashCallback> it = appMonitor.getUserDataCenter().getPreCrashCallback(CrashType.NATIVE).iterator();
            while (it.hasNext()) {
                try {
                    it.next().onCrash(CrashType.NATIVE, j);
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
        }
    }

    private void handleCallbacks(String str) {
        Iterator<CrashListener> it = MonitorManager.getCrashListenerList().iterator();
        while (it.hasNext()) {
            handleMonitorCallbacks(it.next(), str);
        }
    }

    private void handleMonitorCallbacks(CrashListener crashListener, String str) {
        if (crashListener != null) {
            Iterator<ICrashCallback> it = crashListener.getUserDataCenter().getCrashCallback(CrashType.NATIVE).iterator();
            while (it.hasNext()) {
                try {
                    it.next().onCrash(CrashType.NATIVE, str, null);
                } catch (Throwable unused) {
                }
            }
        }
    }
}
