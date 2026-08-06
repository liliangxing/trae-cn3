package com.bytedance.memory.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.bytedance.crash.Npth;
import com.bytedance.memory.common.IAnalyseCallBack;
import com.bytedance.memory.common.MemoryExecutorSupplier;
import com.bytedance.memory.common.MemoryLog;
import com.bytedance.memory.common.MemoryUtils;
import com.bytedance.memory.common.MemoryWidgetGlobal;
import com.bytedance.memory.common.Preconditions;
import com.bytedance.memory.dump.DumpFileProvider;
import com.bytedance.memory.dump.HeapDumper;
import com.bytedance.memory.event.EventUtils;
import com.bytedance.memory.handler.MemoryWidgetOomCallBack;
import com.bytedance.memory.heap.HeapSaver;
import com.bytedance.memory.model.MemoryWidgetConfig;
import com.bytedance.memory.upload.MemoryNetApi;
import com.bytedance.memory.watcher.MemoryChecker;
import com.bytedance.memory.watcher.OnGetMemoryResultListener;
import com.bytedance.push.settings.StatisticsSettings;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class MemoryApi {
    public static final String ACTION_RESULT_MEMORY_WIDGET = "Action_Result_Memory_Client_Analyzer";
    private static final String CONTEXT_PROMPT_MSG = " mustn't be null";
    public static final String DEBUG = "debug";
    public static final String HPROF_FILE_PATH = "hprofFilePath";
    private static final String INIT_PROMPT_MSG = "You must call init() first before using !!!";
    public static final String KEY_RESULT_CLIENT_MEMORY = "Key_Result_Client_Memory";
    private static final String NAME_ANALYZER_SERVICE = "com.bytedance.apm.momory.analyzer.AnalyzerService";
    private static volatile long sLastCheckTime;
    private static volatile MemoryApi sMemoryApi;
    private volatile boolean mClientAnalyzing;
    private Context mContext;
    private String mFilePath;
    private volatile boolean mInitEd;
    private MemoryWidgetConfig mMemoryWidgetConfig;
    private volatile boolean mRunning;
    private long mClientAnalyzeStartTime = 0;
    private IAnalyseCallBack mIAnalyseCallBack = new IAnalyseCallBack() { // from class: com.bytedance.memory.api.MemoryApi.1
        @Override // com.bytedance.memory.common.IAnalyseCallBack
        public void dumpHeap() {
            HeapDumper.getInstance().dumpHeap(System.currentTimeMillis());
        }

        @Override // com.bytedance.memory.common.IAnalyseCallBack
        public boolean canAnalyse() {
            return DumpFileProvider.getInstance().pendingHeapMarkFileExist();
        }

        @Override // com.bytedance.memory.common.IAnalyseCallBack
        public boolean lessThanThreshold() {
            return !MemoryApi.getInstance().debugMode() && HeapSaver.getInstance().lessThanThreshold();
        }

        @Override // com.bytedance.memory.common.IAnalyseCallBack
        public boolean debugMode() {
            return MemoryApi.getInstance().debugMode();
        }
    };

    public void setContext(Context context) {
        this.mContext = context;
    }

    public void setSavePath(String str) {
        this.mFilePath = str;
    }

    public String getSavePath() {
        return this.mFilePath;
    }

    private MemoryApi() {
    }

    public boolean debugMode() {
        try {
            MemoryWidgetConfig memoryWidgetConfig = this.mMemoryWidgetConfig;
            if (memoryWidgetConfig == null || !memoryWidgetConfig.isDebug()) {
                return false;
            }
            return MemoryUtils.isApkInDebug(this.mContext);
        } catch (Exception e) {
            MemoryLog.m101i(Log.getStackTraceString(e), new Object[0]);
            return false;
        }
    }

    public static MemoryApi getInstance() {
        if (sMemoryApi == null) {
            synchronized (MemoryApi.class) {
                if (sMemoryApi == null) {
                    sMemoryApi = new MemoryApi();
                }
            }
        }
        return sMemoryApi;
    }

    public void init(Context context, MemoryWidgetConfig memoryWidgetConfig, OnGetMemoryResultListener onGetMemoryResultListener) {
        if (this.mInitEd) {
            return;
        }
        Preconditions.checkNotNull(context, Context.class.getSimpleName() + CONTEXT_PROMPT_MSG);
        Preconditions.checkNotNull(memoryWidgetConfig, "MemoryWidgetConfig mustn't be null");
        this.mContext = context;
        this.mMemoryWidgetConfig = memoryWidgetConfig;
        MemoryWidgetGlobal.DEBUG = memoryWidgetConfig.isDebug();
        if (memoryWidgetConfig.clientAnalyse()) {
            registerResultReceiver(context, onGetMemoryResultListener);
        }
        Npth.registerOOMCallback(new MemoryWidgetOomCallBack());
        this.mInitEd = true;
    }

    private void registerResultReceiver(Context context, OnGetMemoryResultListener onGetMemoryResultListener) {
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.bytedance.memory.api.MemoryApi.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                MemoryLog.m101i("ResultReceiver onReceive", new Object[0]);
                MemoryApi.this.mClientAnalyzing = false;
                if (intent.hasExtra(MemoryApi.KEY_RESULT_CLIENT_MEMORY)) {
                    String stringExtra = intent.getStringExtra(MemoryApi.KEY_RESULT_CLIENT_MEMORY);
                    try {
                        if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(new JSONObject(stringExtra).optString("memory_object"))) {
                            MemoryLog.m101i("can upload", new Object[0]);
                            EventUtils.uploadCategoryEvent(EventUtils.CLIENT_ANALYZE_END);
                            EventUtils.uploadMetricEvent(EventUtils.CLIENT_ANALYZE_TIME, System.currentTimeMillis() - MemoryApi.this.mClientAnalyzeStartTime);
                            MemoryNetApi.uploadClientResult(stringExtra);
                        }
                        MemoryLog.m101i("deleteCache", new Object[0]);
                        HeapSaver.getInstance().deleteCache();
                    } catch (Exception e) {
                        MemoryLog.m101i("deleteCache catch", new Object[0]);
                        e.printStackTrace();
                    }
                }
            }
        };
        try {
            if (Build.VERSION.SDK_INT > 33) {
                m99x99c26bec(context.getApplicationContext(), broadcastReceiver, new IntentFilter(ACTION_RESULT_MEMORY_WIDGET), 2);
            } else {
                m98x99c26bec(context.getApplicationContext(), broadcastReceiver, new IntentFilter(ACTION_RESULT_MEMORY_WIDGET));
            }
        } catch (Throwable th) {
            MemoryLog.m101i("sendBroadcast catch", new Object[0]);
            th.printStackTrace();
        }
    }

    public void start() {
        if (this.mRunning) {
            return;
        }
        MemoryLog.m101i("MemoryApi start", new Object[0]);
        this.mRunning = true;
        Preconditions.checkTrue(this.mInitEd, INIT_PROMPT_MSG);
        MemoryExecutorSupplier.NORMAL_SERVICE.execute(new Runnable() { // from class: com.bytedance.memory.api.MemoryApi.3
            @Override // java.lang.Runnable
            public void run() {
                if (MemoryApi.this.mMemoryWidgetConfig.getRunStrategy() == 2 && HeapDumper.getInstance().checkStorage()) {
                    MemoryChecker.getInstance().startCheck(MemoryApi.this.mMemoryWidgetConfig, MemoryApi.this.mIAnalyseCallBack);
                }
                MemoryApi.this.checkToRun(false);
                MemoryApi.this.mRunning = false;
            }
        }, "MemoryApi-start");
    }

    public void checkToRun(boolean z) {
        if (z || !HeapSaver.getInstance().isDumpThisTime()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!z && currentTimeMillis - sLastCheckTime < StatisticsSettings.DEFAULT_STATS_INTERVAL) {
                MemoryLog.m101i("uploadCheck return", new Object[0]);
                return;
            }
            sLastCheckTime = currentTimeMillis;
            HeapSaver.getInstance().checkCacheIfExist();
            if (this.mMemoryWidgetConfig.clientAnalyse()) {
                MemoryLog.m101i("client analyze mode", new Object[0]);
                if (this.mClientAnalyzing || !DumpFileProvider.getInstance().pendingHeapMarkFileExist()) {
                    return;
                }
                try {
                    MemoryUtils.setEnabledBlocking(this.mContext, Class.forName(NAME_ANALYZER_SERVICE), true);
                    Intent intent = new Intent(this.mContext, Class.forName(NAME_ANALYZER_SERVICE));
                    intent.putExtra(HPROF_FILE_PATH, DumpFileProvider.getInstance().getPendingHeapFile().getAbsolutePath());
                    intent.putExtra(DEBUG, this.mMemoryWidgetConfig.isDebug());
                    this.mContext.startService(intent);
                    this.mClientAnalyzeStartTime = System.currentTimeMillis();
                    MemoryLog.m101i("start Service success", new Object[0]);
                    EventUtils.uploadCategoryEvent(EventUtils.CLIENT_ANALYZE_BEGIN);
                    this.mClientAnalyzing = true;
                    return;
                } catch (Throwable th) {
                    MemoryLog.m101i("start Service failed", new Object[0]);
                    this.mMemoryWidgetConfig.setClientAnalyse(false);
                    th.printStackTrace();
                    return;
                }
            }
            MemoryLog.m101i("upload mode", new Object[0]);
            MemoryNetApi.uploadCheck();
        }
    }

    public Context getContext() {
        Preconditions.checkNotNull(this.mContext, INIT_PROMPT_MSG);
        return this.mContext;
    }

    public MemoryWidgetConfig getInitConfig() {
        Preconditions.checkNotNull(this.mMemoryWidgetConfig, "MemoryWidgetConfig mustn't be null");
        return this.mMemoryWidgetConfig;
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    /* renamed from: INVOKEVIRTUAL_com_bytedance_memory_api_MemoryApi_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m98x99c26bec(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
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
    /* renamed from: INVOKEVIRTUAL_com_bytedance_memory_api_MemoryApi_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m99x99c26bec(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, int i) {
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
}
