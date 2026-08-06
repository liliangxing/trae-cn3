package com.ttnet.org.chromium.base;

import android.os.Process;
import android.os.StrictMode;
import android.os.SystemClock;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@JNINamespace("base::android")
@MainDex
/* loaded from: classes7.dex */
public class EarlyTraceEvent {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String BACKGROUND_STARTUP_TRACING_ENABLED_KEY = "bg_startup_tracing";
    static final int STATE_DISABLED = 0;
    static final int STATE_ENABLED = 1;
    static final int STATE_FINISHED = 2;
    private static final String TRACE_CONFIG_FILENAME = "/data/local/chrome-trace-config.json";
    public static final String TRACE_EARLY_JAVA_IN_CHILD_SWITCH = "trace-early-java-in-child";
    private static final String TRACE_STARTUP_SWITCH = "trace-startup";
    static List<AsyncEvent> sAsyncEvents;
    private static boolean sCachedBackgroundStartupTracingFlag;
    private static volatile boolean sEnabledInChildProcessBeforeCommandLine;
    static List<Event> sEvents;
    static final Object sLock = new Object();
    static volatile int sState;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public interface Natives {
        void recordEarlyAsyncBeginEvent(String str, long j, long j2);

        void recordEarlyAsyncEndEvent(String str, long j, long j2);

        void recordEarlyBeginEvent(String str, long j, int i, long j2);

        void recordEarlyEndEvent(String str, long j, int i, long j2);

        void recordEarlyToplevelBeginEvent(String str, long j, int i, long j2);

        void recordEarlyToplevelEndEvent(String str, long j, int i, long j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class Event {
        final boolean mIsStart;
        final boolean mIsToplevel;
        final String mName;
        final int mThreadId = Process.myTid();
        final long mTimeNanos = System.nanoTime();
        final long mThreadTimeMillis = SystemClock.currentThreadTimeMillis();

        Event(String str, boolean z, boolean z2) {
            this.mIsStart = z;
            this.mIsToplevel = z2;
            this.mName = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class AsyncEvent {
        final long mId;
        final boolean mIsStart;
        final String mName;
        final long mTimeNanos = System.nanoTime();

        AsyncEvent(String str, long j, boolean z) {
            this.mName = str;
            this.mId = j;
            this.mIsStart = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void maybeEnableInBrowserProcess() {
        boolean z;
        ThreadUtils.assertOnUiThread();
        if (sState != 0) {
            return;
        }
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            boolean z2 = true;
            if (CommandLine.getInstance().hasSwitch(TRACE_STARTUP_SWITCH)) {
                z = true;
            } else {
                try {
                    z = new File(TRACE_CONFIG_FILENAME).exists();
                } catch (SecurityException unused) {
                    z = false;
                }
            }
            if (ContextUtils.getAppSharedPreferences().getBoolean(BACKGROUND_STARTUP_TRACING_ENABLED_KEY, false)) {
                if (z) {
                    setBackgroundStartupTracingFlag(false);
                    sCachedBackgroundStartupTracingFlag = false;
                } else {
                    sCachedBackgroundStartupTracingFlag = true;
                    if (z2) {
                        return;
                    }
                    enable();
                    return;
                }
            }
            z2 = z;
            if (z2) {
            }
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    public static void earlyEnableInChildWithoutCommandLine() {
        sEnabledInChildProcessBeforeCommandLine = true;
        enable();
    }

    public static void onCommandLineAvailableInChildProcess() {
        if (sEnabledInChildProcessBeforeCommandLine) {
            synchronized (sLock) {
                if (!CommandLine.getInstance().hasSwitch(TRACE_EARLY_JAVA_IN_CHILD_SWITCH)) {
                    reset();
                } else {
                    if (sState == 0) {
                        enable();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void enable() {
        synchronized (sLock) {
            if (sState != 0) {
                return;
            }
            sEvents = new ArrayList();
            sAsyncEvents = new ArrayList();
            sState = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void disable() {
        synchronized (sLock) {
            if (enabled()) {
                if (!sEvents.isEmpty()) {
                    dumpEvents(sEvents);
                    sEvents.clear();
                }
                if (!sAsyncEvents.isEmpty()) {
                    dumpAsyncEvents(sAsyncEvents);
                    sAsyncEvents.clear();
                }
                sState = 2;
                sEvents = null;
                sAsyncEvents = null;
            }
        }
    }

    static void reset() {
        synchronized (sLock) {
            sState = 0;
            sEvents = null;
            sAsyncEvents = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean enabled() {
        return sState == 1;
    }

    static void setBackgroundStartupTracingFlag(boolean z) {
        ContextUtils.getAppSharedPreferences().edit().putBoolean(BACKGROUND_STARTUP_TRACING_ENABLED_KEY, z).apply();
    }

    public static boolean getBackgroundStartupTracingFlag() {
        return sCachedBackgroundStartupTracingFlag;
    }

    public static void begin(String str, boolean z) {
        if (enabled()) {
            Event event = new Event(str, true, z);
            synchronized (sLock) {
                if (enabled()) {
                    sEvents.add(event);
                }
            }
        }
    }

    public static void end(String str, boolean z) {
        if (enabled()) {
            Event event = new Event(str, false, z);
            synchronized (sLock) {
                if (enabled()) {
                    sEvents.add(event);
                }
            }
        }
    }

    public static void startAsync(String str, long j) {
        if (enabled()) {
            AsyncEvent asyncEvent = new AsyncEvent(str, j, true);
            synchronized (sLock) {
                if (enabled()) {
                    sAsyncEvents.add(asyncEvent);
                }
            }
        }
    }

    public static void finishAsync(String str, long j) {
        if (enabled()) {
            AsyncEvent asyncEvent = new AsyncEvent(str, j, false);
            synchronized (sLock) {
                if (enabled()) {
                    sAsyncEvents.add(asyncEvent);
                }
            }
        }
    }

    static List<Event> getMatchingCompletedEventsForTesting(String str) {
        ArrayList arrayList;
        synchronized (sLock) {
            arrayList = new ArrayList();
            for (Event event : sEvents) {
                if (event.mName.equals(str)) {
                    arrayList.add(event);
                }
            }
        }
        return arrayList;
    }

    private static void dumpEvents(List<Event> list) {
        for (Event event : list) {
            if (event.mIsStart) {
                if (event.mIsToplevel) {
                    EarlyTraceEventJni.get().recordEarlyToplevelBeginEvent(event.mName, event.mTimeNanos, event.mThreadId, event.mThreadTimeMillis);
                } else {
                    EarlyTraceEventJni.get().recordEarlyBeginEvent(event.mName, event.mTimeNanos, event.mThreadId, event.mThreadTimeMillis);
                }
            } else if (event.mIsToplevel) {
                EarlyTraceEventJni.get().recordEarlyToplevelEndEvent(event.mName, event.mTimeNanos, event.mThreadId, event.mThreadTimeMillis);
            } else {
                EarlyTraceEventJni.get().recordEarlyEndEvent(event.mName, event.mTimeNanos, event.mThreadId, event.mThreadTimeMillis);
            }
        }
    }

    private static void dumpAsyncEvents(List<AsyncEvent> list) {
        for (AsyncEvent asyncEvent : list) {
            if (asyncEvent.mIsStart) {
                EarlyTraceEventJni.get().recordEarlyAsyncBeginEvent(asyncEvent.mName, asyncEvent.mId, asyncEvent.mTimeNanos);
            } else {
                EarlyTraceEventJni.get().recordEarlyAsyncEndEvent(asyncEvent.mName, asyncEvent.mId, asyncEvent.mTimeNanos);
            }
        }
    }
}
