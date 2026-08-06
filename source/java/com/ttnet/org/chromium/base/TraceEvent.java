package com.ttnet.org.chromium.base;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Looper;
import android.os.MessageQueue;
import android.util.Printer;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ttnet.org.chromium.base.TraceEvent;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;

@JNINamespace("base::android")
@MainDex
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class TraceEvent implements AutoCloseable {
    public static final long ATRACE_TAG_APP = 4096;
    public static final long ATRACE_TAG_WEBVIEW = 16;
    private static ATrace sATrace;
    private static volatile boolean sEnabled;
    private static boolean sEventNameFilteringEnabled;
    private static AtomicBoolean sNativeTracingReady = new AtomicBoolean();
    private static AtomicBoolean sUiThreadReady = new AtomicBoolean();
    private final String mName;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface Natives {
        void addViewDump(int i, int i2, boolean z, boolean z2, String str, String str2, long j);

        void begin(String str, String str2);

        void beginToplevel(String str);

        void end(String str, String str2);

        void endToplevel(String str);

        void finishAsync(String str, long j);

        void initViewHierarchyDump();

        void instant(String str, String str2);

        void instantAndroidIPC(String str, long j);

        void registerEnabledObserver();

        void setupATraceStartupTrace(String str);

        void startATrace(String str);

        long startActivityDump(String str, long j);

        void startAsync(String str, long j);

        void stopATrace();

        boolean viewHierarchyDumpEnabled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class ATrace implements MessageQueue.IdleHandler {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final String TAG = "ATrace";
        private Method mAsyncTraceBeginMethod;
        private Method mAsyncTraceEndMethod;
        private Method mGetSystemPropertyMethod;
        private boolean mIdleHandlerRegistered;
        private Method mIsTraceTagEnabledMethod;
        private boolean mShouldWriteToSystemTrace;
        private Class<?> mSystemPropertiesClass;
        private Method mTraceBeginMethod;
        private Class<?> mTraceClass;
        private Method mTraceEndMethod;
        private final long mTraceTag;
        private final AtomicBoolean mNativeTracingReady = new AtomicBoolean();
        private final AtomicBoolean mUiThreadReady = new AtomicBoolean();
        private final AtomicBoolean mTraceTagActive = new AtomicBoolean();

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
        public static class CategoryConfig {
            public String filter;
            public boolean shouldWriteToATrace;

            private CategoryConfig() {
                this.filter = "";
                this.shouldWriteToATrace = true;
            }
        }

        public ATrace(long j) {
            try {
                Class<?> cls = Class.forName("android.os.Trace");
                this.mTraceClass = cls;
                this.mIsTraceTagEnabledMethod = cls.getMethod("isTagEnabled", Long.TYPE);
                this.mTraceBeginMethod = this.mTraceClass.getMethod("traceBegin", Long.TYPE, String.class);
                this.mTraceEndMethod = this.mTraceClass.getMethod("traceEnd", Long.TYPE);
                this.mAsyncTraceBeginMethod = this.mTraceClass.getMethod("asyncTraceBegin", Long.TYPE, String.class, Integer.TYPE);
                this.mAsyncTraceEndMethod = this.mTraceClass.getMethod("asyncTraceEnd", Long.TYPE, String.class, Integer.TYPE);
                Class<?> cls2 = Class.forName("android.os.SystemProperties");
                this.mSystemPropertiesClass = cls2;
                this.mGetSystemPropertyMethod = cls2.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class);
            } catch (Exception e) {
                Log.m285w(TAG, "Reflection error", e);
                this.mIsTraceTagEnabledMethod = null;
            }
            this.mTraceTag = j;
            m302x6d1b6665();
        }

        private String getSystemProperty(String str) {
            try {
                return (String) this.mGetSystemPropertyMethod.invoke(this.mSystemPropertiesClass, str);
            } catch (Exception unused) {
                return null;
            }
        }

        private Integer getIntegerSystemProperty(String str) {
            String systemProperty = getSystemProperty(str);
            if (systemProperty == null) {
                return null;
            }
            try {
                return Integer.decode(systemProperty);
            } catch (NumberFormatException unused) {
                return null;
            }
        }

        private boolean isTraceTagEnabled(long j) {
            try {
                return ((Boolean) this.mIsTraceTagEnabledMethod.invoke(this.mTraceClass, Long.valueOf(j))).booleanValue();
            } catch (Exception unused) {
                return false;
            }
        }

        public boolean hasActiveSession() {
            return this.mTraceTagActive.get();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: pollConfig, reason: merged with bridge method [inline-methods] */
        public boolean m302x6d1b6665() {
            boolean z = this.mTraceTagActive.get();
            boolean isTraceTagEnabled = isTraceTagEnabled(this.mTraceTag);
            if (z == isTraceTagEnabled) {
                return false;
            }
            this.mTraceTagActive.set(isTraceTagEnabled);
            if (!isTraceTagEnabled) {
                EarlyTraceEvent.disable();
                disableNativeATrace();
                this.mShouldWriteToSystemTrace = false;
                ThreadUtils.getUiThreadLooper().setMessageLogging(null);
                return true;
            }
            CategoryConfig categoryConfigFromATrace = getCategoryConfigFromATrace();
            this.mShouldWriteToSystemTrace = false;
            if (this.mNativeTracingReady.get()) {
                if (categoryConfigFromATrace.shouldWriteToATrace) {
                    enableNativeATrace(categoryConfigFromATrace.filter);
                } else {
                    setupATraceStartupTrace(categoryConfigFromATrace.filter);
                }
            } else if (categoryConfigFromATrace.shouldWriteToATrace) {
                this.mShouldWriteToSystemTrace = true;
            } else {
                EarlyTraceEvent.enable();
            }
            if (!categoryConfigFromATrace.shouldWriteToATrace) {
                ThreadUtils.getUiThreadLooper().setMessageLogging(LooperMonitorHolder.sInstance);
            }
            return true;
        }

        private CategoryConfig getCategoryConfigFromATrace() {
            CategoryConfig categoryConfig = new CategoryConfig();
            Integer integerSystemProperty = getIntegerSystemProperty("debug.atrace.app_number");
            if (integerSystemProperty != null && integerSystemProperty.intValue() > 0 && ContextUtils.getApplicationContext() != null) {
                String packageName = ContextUtils.getApplicationContext().getPackageName();
                for (int i = 0; i < integerSystemProperty.intValue(); i++) {
                    String systemProperty = getSystemProperty("debug.atrace.app_" + i);
                    if (systemProperty != null && systemProperty.startsWith(packageName)) {
                        String substring = systemProperty.substring(packageName.length());
                        if (substring.startsWith("/")) {
                            for (String str : substring.substring(1).split(Constants.COLON_SEPARATOR)) {
                                if (str.equals("-atrace")) {
                                    categoryConfig.shouldWriteToATrace = false;
                                } else {
                                    if (categoryConfig.filter.length() > 0) {
                                        categoryConfig.filter += Constants.ACCEPT_TIME_SEPARATOR_SP;
                                    }
                                    categoryConfig.filter += str;
                                }
                            }
                        }
                    }
                }
            }
            return categoryConfig;
        }

        public void onNativeTracingReady() {
            this.mNativeTracingReady.set(true);
            this.mTraceTagActive.set(false);
            if (this.mUiThreadReady.get()) {
                ThreadUtils.postOnUiThread(new Runnable() { // from class: com.ttnet.org.chromium.base.TraceEvent$ATrace$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        TraceEvent.ATrace.this.m302x6d1b6665();
                    }
                });
            }
        }

        public void onUiThreadReady() {
            this.mUiThreadReady.set(true);
            if (!ThreadUtils.runningOnUiThread()) {
                ThreadUtils.postOnUiThread(new Runnable() { // from class: com.ttnet.org.chromium.base.TraceEvent$ATrace$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        TraceEvent.ATrace.this.m303x573fe1fb();
                    }
                });
            } else {
                m303x573fe1fb();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: startPolling, reason: merged with bridge method [inline-methods] */
        public void m303x573fe1fb() {
            ThreadUtils.assertOnUiThread();
            if (!this.mIdleHandlerRegistered) {
                Looper.myQueue().addIdleHandler(this);
                this.mIdleHandlerRegistered = true;
            }
            m302x6d1b6665();
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            m302x6d1b6665();
            return true;
        }

        private void enableNativeATrace(String str) {
            TraceEventJni.get().startATrace(str);
        }

        private void disableNativeATrace() {
            TraceEventJni.get().stopATrace();
        }

        private void setupATraceStartupTrace(String str) {
            TraceEventJni.get().setupATraceStartupTrace(str);
        }

        public void traceBegin(String str) {
            if (this.mShouldWriteToSystemTrace) {
                try {
                    this.mTraceBeginMethod.invoke(this.mTraceClass, Long.valueOf(this.mTraceTag), str);
                } catch (Exception unused) {
                }
            }
        }

        public void traceEnd() {
            if (this.mShouldWriteToSystemTrace) {
                try {
                    this.mTraceEndMethod.invoke(this.mTraceClass, Long.valueOf(this.mTraceTag));
                } catch (Exception unused) {
                }
            }
        }

        public void asyncTraceBegin(String str, int i) {
            if (this.mShouldWriteToSystemTrace) {
                try {
                    this.mAsyncTraceBeginMethod.invoke(this.mTraceClass, Long.valueOf(this.mTraceTag), str, Integer.valueOf(i));
                } catch (Exception unused) {
                }
            }
        }

        public void asyncTraceEnd(String str, int i) {
            if (this.mShouldWriteToSystemTrace) {
                try {
                    this.mAsyncTraceEndMethod.invoke(this.mTraceClass, Long.valueOf(this.mTraceTag), str, Integer.valueOf(i));
                } catch (Exception unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class BasicLooperMonitor implements Printer {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        static final String FILTERED_EVENT_NAME = "Looper.dispatch: EVENT_NAME_FILTERED";
        static final String LOOPER_TASK_PREFIX = "Looper.dispatch: ";
        private static final int SHORTEST_LOG_PREFIX_LENGTH = 18;
        private String mCurrentTarget;

        BasicLooperMonitor() {
        }

        @Override // android.util.Printer
        public void println(String str) {
            if (str.startsWith(">")) {
                beginHandling(str);
            } else {
                endHandling(str);
            }
        }

        void beginHandling(String str) {
            boolean enabled = EarlyTraceEvent.enabled();
            if (TraceEvent.sEnabled || enabled) {
                this.mCurrentTarget = getTraceEventName(str);
                if (TraceEvent.sEnabled) {
                    TraceEventJni.get().beginToplevel(this.mCurrentTarget);
                } else {
                    EarlyTraceEvent.begin(this.mCurrentTarget, true);
                }
            }
        }

        void endHandling(String str) {
            boolean enabled = EarlyTraceEvent.enabled();
            if ((TraceEvent.sEnabled || enabled) && this.mCurrentTarget != null) {
                if (TraceEvent.sEnabled) {
                    TraceEventJni.get().endToplevel(this.mCurrentTarget);
                } else {
                    EarlyTraceEvent.end(this.mCurrentTarget, true);
                }
            }
            this.mCurrentTarget = null;
        }

        static String getTraceEventName(String str) {
            return TraceEvent.sEventNameFilteringEnabled ? FILTERED_EVENT_NAME : LOOPER_TASK_PREFIX + getTarget(str) + "(" + getTargetName(str) + ")";
        }

        private static String getTarget(String str) {
            int indexOf = str.indexOf(40, SHORTEST_LOG_PREFIX_LENGTH);
            int indexOf2 = indexOf == -1 ? -1 : str.indexOf(41, indexOf);
            return indexOf2 != -1 ? str.substring(indexOf + 1, indexOf2) : "";
        }

        private static String getTargetName(String str) {
            int indexOf = str.indexOf(125, SHORTEST_LOG_PREFIX_LENGTH);
            int indexOf2 = indexOf == -1 ? -1 : str.indexOf(58, indexOf);
            if (indexOf2 == -1) {
                indexOf2 = str.length();
            }
            return indexOf != -1 ? str.substring(indexOf + 2, indexOf2) : "";
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private static final class IdleTracingLooperMonitor extends BasicLooperMonitor implements MessageQueue.IdleHandler {
        private static final long FRAME_DURATION_MILLIS = 16;
        private static final String IDLE_EVENT_NAME = "Looper.queueIdle";
        private static final long MIN_INTERESTING_BURST_DURATION_MILLIS = 48;
        private static final long MIN_INTERESTING_DURATION_MILLIS = 16;
        private static final String TAG = "TraceEvent_LooperMonitor";
        private boolean mIdleMonitorAttached;
        private long mLastIdleStartedAt;
        private long mLastWorkStartedAt;
        private int mNumIdlesSeen;
        private int mNumTasksSeen;
        private int mNumTasksSinceLastIdle;

        private IdleTracingLooperMonitor() {
        }

        private final void syncIdleMonitoring() {
            if (TraceEvent.sEnabled && !this.mIdleMonitorAttached) {
                this.mLastIdleStartedAt = TimeUtils.elapsedRealtimeMillis();
                Looper.myQueue().addIdleHandler(this);
                this.mIdleMonitorAttached = true;
                android.util.Log.v(TAG, "attached idle handler");
                return;
            }
            if (!this.mIdleMonitorAttached || TraceEvent.sEnabled) {
                return;
            }
            Looper.myQueue().removeIdleHandler(this);
            this.mIdleMonitorAttached = false;
            android.util.Log.v(TAG, "detached idle handler");
        }

        @Override // com.ttnet.org.chromium.base.TraceEvent.BasicLooperMonitor
        final void beginHandling(String str) {
            if (this.mNumTasksSinceLastIdle == 0) {
                TraceEvent.end(IDLE_EVENT_NAME);
            }
            this.mLastWorkStartedAt = TimeUtils.elapsedRealtimeMillis();
            syncIdleMonitoring();
            super.beginHandling(str);
        }

        @Override // com.ttnet.org.chromium.base.TraceEvent.BasicLooperMonitor
        final void endHandling(String str) {
            long elapsedRealtimeMillis = TimeUtils.elapsedRealtimeMillis() - this.mLastWorkStartedAt;
            if (elapsedRealtimeMillis > 16) {
                traceAndLog(5, "observed a task that took " + elapsedRealtimeMillis + "ms: " + str);
            }
            super.endHandling(str);
            syncIdleMonitoring();
            this.mNumTasksSeen++;
            this.mNumTasksSinceLastIdle++;
        }

        private static void traceAndLog(int i, String str) {
            TraceEvent.instant("TraceEvent.LooperMonitor:IdleStats", str);
            android.util.Log.println(i, TAG, str);
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            long elapsedRealtimeMillis = TimeUtils.elapsedRealtimeMillis();
            if (this.mLastIdleStartedAt == 0) {
                this.mLastIdleStartedAt = elapsedRealtimeMillis;
            }
            long j = elapsedRealtimeMillis - this.mLastIdleStartedAt;
            this.mNumIdlesSeen++;
            TraceEvent.begin(IDLE_EVENT_NAME, this.mNumTasksSinceLastIdle + " tasks since last idle.");
            if (j > MIN_INTERESTING_BURST_DURATION_MILLIS) {
                traceAndLog(3, this.mNumTasksSeen + " tasks and " + this.mNumIdlesSeen + " idles processed so far, " + this.mNumTasksSinceLastIdle + " tasks bursted and " + j + "ms elapsed since last idle");
            }
            this.mLastIdleStartedAt = elapsedRealtimeMillis;
            this.mNumTasksSinceLastIdle = 0;
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static final class LooperMonitorHolder {
        private static final BasicLooperMonitor sInstance;

        private LooperMonitorHolder() {
        }

        static {
            sInstance = CommandLine.getInstance().hasSwitch(BaseSwitches.ENABLE_IDLE_TRACING) ? new IdleTracingLooperMonitor() : new BasicLooperMonitor();
        }
    }

    private TraceEvent(String str, String str2) {
        this.mName = str;
        begin(str, str2);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        end(this.mName);
    }

    public static TraceEvent scoped(String str, String str2) {
        if (EarlyTraceEvent.enabled() || enabled()) {
            return new TraceEvent(str, str2);
        }
        return null;
    }

    public static TraceEvent scoped(String str) {
        return scoped(str, null);
    }

    public static void setEnabled(boolean z) {
        if (z) {
            EarlyTraceEvent.disable();
        }
        if (sEnabled != z) {
            sEnabled = z;
            ATrace aTrace = sATrace;
            if (aTrace == null || !aTrace.hasActiveSession()) {
                ThreadUtils.getUiThreadLooper().setMessageLogging(z ? LooperMonitorHolder.sInstance : null);
            }
        }
        if (sUiThreadReady.get()) {
            ViewHierarchyDumper.updateEnabledState();
        }
    }

    public static void setEventNameFilteringEnabled(boolean z) {
        sEventNameFilteringEnabled = z;
    }

    public static boolean eventNameFilteringEnabled() {
        return sEventNameFilteringEnabled;
    }

    public static void maybeEnableEarlyTracing(long j, boolean z) {
        if (z) {
            EarlyTraceEvent.maybeEnableInBrowserProcess();
        }
        if (j != 0) {
            sATrace = new ATrace(j);
            if (sNativeTracingReady.get()) {
                sATrace.onNativeTracingReady();
            }
            if (sUiThreadReady.get()) {
                sATrace.onUiThreadReady();
            }
        }
        if (EarlyTraceEvent.enabled()) {
            ATrace aTrace = sATrace;
            if (aTrace == null || !aTrace.hasActiveSession()) {
                ThreadUtils.getUiThreadLooper().setMessageLogging(LooperMonitorHolder.sInstance);
            }
        }
    }

    public static void onNativeTracingReady() {
        sNativeTracingReady.set(true);
        TraceEventJni.get().registerEnabledObserver();
        ATrace aTrace = sATrace;
        if (aTrace != null) {
            aTrace.onNativeTracingReady();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void onUiThreadReady() {
        sUiThreadReady.set(true);
        ATrace aTrace = sATrace;
        if (aTrace != null) {
            aTrace.onUiThreadReady();
        }
        if (sEnabled) {
            ViewHierarchyDumper.updateEnabledState();
        }
    }

    public static boolean enabled() {
        return sEnabled;
    }

    public static void instant(String str) {
        if (sEnabled) {
            TraceEventJni.get().instant(str, null);
        }
    }

    public static void instant(String str, String str2) {
        if (sEnabled) {
            TraceEventJni.get().instant(str, str2);
        }
    }

    public static void instantAndroidIPC(String str, long j) {
        if (sEnabled) {
            TraceEventJni.get().instantAndroidIPC(str, j);
        }
    }

    public static void startAsync(String str, long j) {
        EarlyTraceEvent.startAsync(str, j);
        if (sEnabled) {
            TraceEventJni.get().startAsync(str, j);
            return;
        }
        ATrace aTrace = sATrace;
        if (aTrace != null) {
            aTrace.asyncTraceBegin(str, (int) j);
        }
    }

    public static void finishAsync(String str, long j) {
        EarlyTraceEvent.finishAsync(str, j);
        if (sEnabled) {
            TraceEventJni.get().finishAsync(str, j);
            return;
        }
        ATrace aTrace = sATrace;
        if (aTrace != null) {
            aTrace.asyncTraceEnd(str, (int) j);
        }
    }

    public static void begin(String str) {
        begin(str, null);
    }

    public static void begin(String str, String str2) {
        EarlyTraceEvent.begin(str, false);
        if (sEnabled) {
            TraceEventJni.get().begin(str, str2);
            return;
        }
        ATrace aTrace = sATrace;
        if (aTrace != null) {
            aTrace.traceBegin(str);
        }
    }

    public static void end(String str) {
        end(str, null);
    }

    public static void end(String str, String str2) {
        EarlyTraceEvent.end(str, false);
        if (sEnabled) {
            TraceEventJni.get().end(str, str2);
            return;
        }
        ATrace aTrace = sATrace;
        if (aTrace != null) {
            aTrace.traceEnd();
        }
    }

    public static void dumpViewHierarchy(long j) {
        if (ApplicationStatus.isInitialized()) {
            for (Activity activity : ApplicationStatus.getRunningActivities()) {
                ViewHierarchyDumper.dumpView(0, activity.getWindow().getDecorView().getRootView(), TraceEventJni.get().startActivityDump(activity.getClass().getName(), j));
            }
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private static final class ViewHierarchyDumper implements MessageQueue.IdleHandler {
        private static final String EVENT_NAME = "TraceEvent.ViewHierarchyDumper";
        private static final long MIN_VIEW_DUMP_INTERVAL_MILLIS = 1000;
        private static boolean sEnabled;
        private static ViewHierarchyDumper sInstance;
        private long mLastDumpTs;

        private ViewHierarchyDumper() {
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            long elapsedRealtimeMillis = TimeUtils.elapsedRealtimeMillis();
            long j = this.mLastDumpTs;
            if (j != 0 && elapsedRealtimeMillis - j <= 1000) {
                return true;
            }
            this.mLastDumpTs = elapsedRealtimeMillis;
            TraceEventJni.get().initViewHierarchyDump();
            return true;
        }

        public static void updateEnabledState() {
            if (!ThreadUtils.runningOnUiThread()) {
                ThreadUtils.postOnUiThread(new Runnable() { // from class: com.ttnet.org.chromium.base.TraceEvent$ViewHierarchyDumper$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        TraceEvent.ViewHierarchyDumper.updateEnabledState();
                    }
                });
                return;
            }
            if (TraceEventJni.get().viewHierarchyDumpEnabled()) {
                if (sInstance == null) {
                    sInstance = new ViewHierarchyDumper();
                }
                enable();
            } else if (sInstance != null) {
                disable();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void dumpView(int i, View view, long j) {
            String str;
            ThreadUtils.assertOnUiThread();
            int id = view.getId();
            try {
                if (view.getResources() != null) {
                    str = id != 0 ? view.getResources().getResourceName(id) : "__no_id__";
                } else {
                    str = "__no_resources__";
                }
            } catch (Resources.NotFoundException unused) {
                str = "__name_not_found__";
            }
            TraceEventJni.get().addViewDump(id, i, view.isShown(), view.isDirty(), view.getClass().getSimpleName(), str, j);
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    dumpView(id, viewGroup.getChildAt(i2), j);
                }
            }
        }

        private static void enable() {
            ThreadUtils.assertOnUiThread();
            if (sEnabled) {
                return;
            }
            Looper.myQueue().addIdleHandler(sInstance);
            sEnabled = true;
        }

        private static void disable() {
            ThreadUtils.assertOnUiThread();
            if (sEnabled) {
                Looper.myQueue().removeIdleHandler(sInstance);
                sEnabled = false;
            }
        }
    }
}
