package com.lynx.tasm.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Process;
import android.os.Trace;
import android.util.Log;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import java.io.File;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class TraceController {
    private static final String ACTION_START = "LYNX_TRACE_START";
    private static final String ACTION_STOP = "LYNX_TRACE_STOP";
    private static final long ATRACE_TAG_ALL = 134217727;
    private static final String BUFFER_SIZE_EXTRA = "buffer";
    private static final String CATEGORIES_EXTRA = "categories";
    private static final int DEFAULT_BUFFER_SIZE = 40960;
    private static final String FILE_EXTRA = "file";
    private static final String NATIVE_ONLY_EXTRA = "nativeOnly";
    private static final String TAG = "Lynx startup trace";
    private static boolean isTraceEnvInit;
    private static boolean mTracingStarted;
    private static boolean sNativeTracingOnly;
    private TraceBroadcastReceiver mBroadcastReceiver;
    private List<CompleteCallback> mCompleteCallbacks;
    private Context mContext;
    private long mNativeTraceController;
    private String traceFilePath;
    private int tracingSession;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public interface CompleteCallback {
        void onComplete(String str);
    }

    private native long nativeCreateTraceController();

    private native void nativeStartStartupTracingIfNeeded(long j);

    private native int nativeStartTracing(long j, int i, String[] strArr, String[] strArr2, String str, boolean z);

    private native void nativeStopTracing(long j, int i);

    @Deprecated
    public void recordClockSyncMarker(String str) {
    }

    private TraceController() {
        this.mCompleteCallbacks = new ArrayList();
        this.mNativeTraceController = 0L;
        this.tracingSession = -1;
        if (0 == 0) {
            try {
                if (isTraceEnvInited()) {
                    this.mNativeTraceController = nativeCreateTraceController();
                }
            } catch (Exception e) {
                Log.w(TAG, "failed to create NativeTraceController", e);
            } catch (UnsatisfiedLinkError e2) {
                Log.w(TAG, "failed to create NativeTraceController", e2);
            }
        }
        if (this.mNativeTraceController == 0) {
            Log.w(TAG, "failed to create NativeTraceController");
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    private static class TraceControllerLoader {
        private static final TraceController INSTANCE = new TraceController();

        private TraceControllerLoader() {
        }
    }

    public static boolean isNativeTracingOnly() {
        return sNativeTracingOnly;
    }

    public static TraceController getInstance() {
        return TraceControllerLoader.INSTANCE;
    }

    public long getNativeTraceController() {
        return this.mNativeTraceController;
    }

    public String startTrace() {
        File file = getFile();
        String path = file.getPath();
        startTracing(DEFAULT_BUFFER_SIZE, null, null, path, false);
        String str = "Trace started at: " + path;
        Toast.makeText(this.mContext, str, 0).show();
        Log.i(TAG, str);
        return file.getAbsolutePath();
    }

    public void stopTrace() {
        stopTracing();
        Toast.makeText(this.mContext, "Trace stopped", 0).show();
        Log.i(TAG, "Trace stopped");
    }

    public void startStartupTracingIfNeeded() {
        long j = this.mNativeTraceController;
        if (j != 0) {
            nativeStartStartupTracingIfNeeded(j);
        }
    }

    public void startTracing(CompleteCallback completeCallback, String str) {
        this.mCompleteCallbacks.add(completeCallback);
        startTracing(DEFAULT_BUFFER_SIZE, null, null, generateTracingFileName(), false);
    }

    public void startTracing(CompleteCallback completeCallback, Map<String, String> map) {
        this.mCompleteCallbacks.add(completeCallback);
        String generateTracingFileName = generateTracingFileName();
        Boolean bool = false;
        if (map.containsKey("trace_file")) {
            generateTracingFileName = map.get("trace_file");
        }
        String str = generateTracingFileName;
        int parseInt = map.containsKey("buffer_size") ? Integer.parseInt(map.get("buffer_size")) : DEFAULT_BUFFER_SIZE;
        if (map.containsKey("enable_systrace")) {
            bool = Boolean.valueOf(Boolean.parseBoolean(map.get("enable_systrace")));
        }
        startTracing(parseInt, null, null, str, bool.booleanValue());
    }

    public void stopTracing() {
        long j = this.mNativeTraceController;
        if (j == 0 || !mTracingStarted) {
            return;
        }
        mTracingStarted = false;
        nativeStopTracing(j, this.tracingSession);
        if (this.traceFilePath.isEmpty()) {
            return;
        }
        onTracingComplete(this.traceFilePath);
        this.traceFilePath = "";
    }

    public static boolean isTracingStarted() {
        return mTracingStarted;
    }

    public void onTracingComplete(String str) {
        Iterator<CompleteCallback> it = this.mCompleteCallbacks.iterator();
        while (it.hasNext()) {
            it.next().onComplete(str);
        }
        this.mCompleteCallbacks.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String generateTracingFileName() {
        return getFile().getPath();
    }

    private String generateTracingFileDir() {
        return this.mContext.getExternalFilesDir(null).getPath();
    }

    private File getFile() {
        int myPid = Process.myPid();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HHmmss", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return new File(this.mContext.getExternalFilesDir(null), "lynx-profile-trace-" + myPid + "-" + simpleDateFormat.format(new Date()));
    }

    private void setIsTracingStarted(boolean z) {
        mTracingStarted = z;
    }

    private void refreshATraceTags() {
        try {
            Field declaredField = Trace.class.getDeclaredField("sEnabledTags");
            declaredField.setAccessible(true);
            declaredField.setLong(null, ATRACE_TAG_ALL);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static boolean isTraceEnvInited() {
        boolean z = isTraceEnvInit;
        if (z) {
            return z;
        }
        boolean init = LynxTraceEnv.inst().init();
        isTraceEnvInit = init;
        return init;
    }

    protected void startTracing(int i, String[] strArr, String[] strArr2, String str, boolean z) {
        if (mTracingStarted) {
            Toast.makeText(this.mContext, "Trace already started, please stop it first", 0).show();
            return;
        }
        if (this.mNativeTraceController == 0) {
            Log.w(TAG, "tracing not enabled");
            return;
        }
        mTracingStarted = true;
        if (str.isEmpty()) {
            str = getFile().getPath();
        }
        String str2 = str;
        this.traceFilePath = str2;
        this.tracingSession = nativeStartTracing(this.mNativeTraceController, i, strArr, strArr2, str2, z);
        HashMap hashMap = new HashMap();
        hashMap.put("Version", "3.5.25-rc.12");
        TraceEvent.instant(1L, "Version", hashMap);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    private static class TraceIntentFilter extends IntentFilter {
        public TraceIntentFilter(Context context) {
            addAction(context.getPackageName() + ".LYNX_TRACE_START");
            addAction(context.getPackageName() + ".LYNX_TRACE_STOP");
        }
    }

    public void init(Context context) {
        this.mContext = context;
        if (TraceEvent.enableTrace()) {
            this.mBroadcastReceiver = new TraceBroadcastReceiver();
            TraceIntentFilter traceIntentFilter = new TraceIntentFilter(this.mContext);
            if (Build.VERSION.SDK_INT >= 34 && context.getApplicationInfo().targetSdkVersion >= 34) {
                m2584xad4da933(this.mContext, this.mBroadcastReceiver, traceIntentFilter, 2);
            } else {
                m2583xad4da933(this.mContext, this.mBroadcastReceiver, traceIntentFilter);
            }
        }
    }

    public void onTerminate() {
        if (TraceEvent.enableTrace()) {
            m2585x7555898c(this.mContext, this.mBroadcastReceiver);
        }
        this.mContext = null;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    class TraceBroadcastReceiver extends BroadcastReceiver {
        TraceBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().endsWith(TraceController.ACTION_START)) {
                String stringExtra = intent.getStringExtra(TraceController.CATEGORIES_EXTRA);
                String stringExtra2 = intent.getStringExtra("file");
                int intExtra = intent.getIntExtra(TraceController.BUFFER_SIZE_EXTRA, TraceController.DEFAULT_BUFFER_SIZE);
                boolean unused = TraceController.sNativeTracingOnly = intent.getBooleanExtra(TraceController.NATIVE_ONLY_EXTRA, false);
                if (stringExtra2 == null) {
                    stringExtra2 = TraceController.this.generateTracingFileName();
                }
                TraceController.this.startTracing(intExtra, stringExtra != null ? stringExtra.split(",") : null, null, stringExtra2, false);
                String str = "Trace started at: " + stringExtra2;
                Toast.makeText(context, str, 0).show();
                Log.i(TraceController.TAG, str);
                return;
            }
            if (intent.getAction().endsWith(TraceController.ACTION_STOP)) {
                boolean unused2 = TraceController.sNativeTracingOnly = false;
                TraceController.this.stopTracing();
                Toast.makeText(context, "Trace stopped", 0).show();
                Log.i(TraceController.TAG, "Trace stopped");
            }
        }
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    /* renamed from: INVOKEVIRTUAL_com_lynx_tasm_base_TraceController_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m2583xad4da933(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        }
        try {
            if (ReceiverRegisterCrashOptimizer.doRegisterHandler()) {
                ReceiverRegisterLancet.initHandler();
                Context context2 = context;
                return context.registerReceiver(broadcastReceiver, intentFilter, null, ReceiverRegisterLancet.sReceiverHandler);
            }
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null && ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(intentFilter)) {
                ReceiverRegisterLancet.initProxyHandler();
                Context context3 = context;
                return ContextCompat.registerReceiver(context, broadcastReceiver, intentFilter, (String) null, ReceiverRegisterLancet.sProxyHandler, 2);
            }
            return context.registerReceiver(broadcastReceiver, intentFilter);
        } catch (Exception e) {
            if (!ReceiverRegisterCrashOptimizer.fixedOpen()) {
                throw e;
            }
            return ReceiverRegisterCrashOptimizer.registerReceiver(broadcastReceiver, intentFilter);
        }
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.iab.omid.library.bytedance.b.b"})
    /* renamed from: INVOKEVIRTUAL_com_lynx_tasm_base_TraceController_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m2584xad4da933(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, int i) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        }
        try {
            if (ReceiverRegisterCrashOptimizer.doRegisterHandler()) {
                ReceiverRegisterLancet.initHandler();
                Context context2 = context;
                return context.registerReceiver(broadcastReceiver, intentFilter, null, ReceiverRegisterLancet.sReceiverHandler);
            }
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null && ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(intentFilter)) {
                ReceiverRegisterLancet.initProxyHandler();
                Context context3 = context;
                return ContextCompat.registerReceiver(context, broadcastReceiver, intentFilter, (String) null, ReceiverRegisterLancet.sProxyHandler, i);
            }
            return context.registerReceiver(broadcastReceiver, intentFilter, i);
        } catch (Exception e) {
            if (!ReceiverRegisterCrashOptimizer.fixedOpen()) {
                throw e;
            }
            return ReceiverRegisterCrashOptimizer.registerReceiver(broadcastReceiver, intentFilter, i);
        }
    }

    @Proxy("unregisterReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    /* renamed from: INVOKEVIRTUAL_com_lynx_tasm_base_TraceController_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver */
    public static void m2585x7555898c(Context context, BroadcastReceiver broadcastReceiver) {
        ReceiverRegisterLancet.loge(broadcastReceiver, false);
        context.unregisterReceiver(broadcastReceiver);
    }
}
