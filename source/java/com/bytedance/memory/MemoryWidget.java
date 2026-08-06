package com.bytedance.memory;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.apm.BaseApmWidget;
import com.bytedance.apm.util.ListUtils;
import com.bytedance.memory.api.MemoryApi;
import com.bytedance.memory.common.MemoryLog;
import com.bytedance.memory.dump.DumpFileController;
import com.bytedance.memory.dump.DumpFileProvider;
import com.bytedance.memory.event.EventUtils;
import com.bytedance.memory.handler.NpthHprofManager;
import com.bytedance.memory.model.MemoryWidgetConfig;
import com.bytedance.memory.upload.MemoryNetApi;
import com.bytedance.memory.watcher.MemoryChecker;
import com.bytedance.memory.watcher.OnGetMemoryResultListener;
import com.bytedance.platform.thread.Constants;
import com.bytedance.services.apm.api.WidgetParams;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class MemoryWidget extends BaseApmWidget {
    public static final String KEY_CLIENT_ANALYZE = "client_analyze";
    public static final String KEY_ENABLE_WIDGET_MEMORY = "enable_widget_memory";
    public static final String KEY_MAX_CAPACITY_ANALYSE = "max_capacity_analyse";
    public static final String KEY_MEMORY_RATE = "rate_memory_occupied";
    public static final String KEY_RUN_STRATEGY = "memory_strategy";
    private Context mAppContext;
    private volatile boolean mCheckedFolder;
    private boolean mClientAnalyze = false;
    private boolean mEnable;
    private volatile boolean mInitEd;
    private boolean mIsDebug;
    private MemoryWidgetConfig mMemoryWidgetConfig;
    private volatile boolean mNeedStop;
    private OnGetMemoryResultListener mResultListener;
    private JSONObject memory;

    public boolean isOnlyMainProcess() {
        return false;
    }

    public MemoryWidget(MemoryWidgetConfig memoryWidgetConfig) {
        this.mMemoryWidgetConfig = memoryWidgetConfig;
    }

    public MemoryWidget(MemoryWidgetConfig memoryWidgetConfig, OnGetMemoryResultListener onGetMemoryResultListener) {
        this.mMemoryWidgetConfig = memoryWidgetConfig;
        this.mResultListener = onGetMemoryResultListener;
    }

    public void init(Context context) {
        super.init(context);
        this.mAppContext = context;
        registerConfigService();
        MemoryApi.getInstance().setContext(this.mAppContext);
        MemoryApi memoryApi = MemoryApi.getInstance();
        MemoryWidgetConfig memoryWidgetConfig = this.mMemoryWidgetConfig;
        memoryApi.setSavePath(memoryWidgetConfig != null ? memoryWidgetConfig.getFilePath() : "");
        try {
            DumpFileProvider.getInstance();
        } catch (Exception unused) {
            this.mNeedStop = true;
        }
    }

    public void onRefresh(JSONObject jSONObject, boolean z) {
        super.onRefresh(jSONObject, z);
        if (this.mNeedStop) {
            return;
        }
        this.mIsDebug = this.mMemoryWidgetConfig.isDebug();
        parseConfig(jSONObject);
        if (ableToInit()) {
            if (!this.mInitEd) {
                registerAppLifeCycle();
                int memoryRate = this.mMemoryWidgetConfig.getMemoryRate();
                JSONObject jSONObject2 = this.memory;
                if (jSONObject2 != null) {
                    this.mMemoryWidgetConfig.setRunStrategy(jSONObject2.optInt(KEY_RUN_STRATEGY, this.mMemoryWidgetConfig.getRunStrategy()));
                    memoryRate = this.memory.optInt(KEY_MEMORY_RATE, this.mMemoryWidgetConfig.getMemoryRate());
                    boolean z2 = this.memory.optInt(KEY_CLIENT_ANALYZE, 0) == 1;
                    this.mClientAnalyze = z2;
                    this.mMemoryWidgetConfig.setClientAnalyse(z2);
                }
                if (this.mMemoryWidgetConfig.getRunStrategy() == 2) {
                    MemoryLog.m101i("reach top mode", new Object[0]);
                    this.mMemoryWidgetConfig.setMemoryRate(memoryRate);
                    MemoryWidgetConfig memoryWidgetConfig = this.mMemoryWidgetConfig;
                    memoryWidgetConfig.setNumAnalyse(getConfigInt(KEY_MAX_CAPACITY_ANALYSE, memoryWidgetConfig.getNumAnalyse()));
                }
                MemoryApi.getInstance().init(this.mAppContext, this.mMemoryWidgetConfig, this.mResultListener);
                MemoryLog.m101i("memorywidget is inited", new Object[0]);
                MemoryLog.m101i(this.mMemoryWidgetConfig.toString(), new Object[0]);
                this.mInitEd = true;
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bytedance.memory.MemoryWidget.1
                @Override // java.lang.Runnable
                public void run() {
                    MemoryApi.getInstance().start();
                }
            }, MemoryApi.getInstance().debugMode() ? 0L : 20000L);
        }
        MemoryLog.m101i("onRefresh run", new Object[0]);
        if (!EventUtils.getMemoryEventNoDebug(EventUtils.CLOSE_NPTH_HPROF)) {
            NpthHprofManager.getInstance().init();
        }
        if (this.mCheckedFolder) {
            return;
        }
        this.mCheckedFolder = true;
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bytedance.memory.MemoryWidget.2
            @Override // java.lang.Runnable
            public void run() {
                DumpFileController.getInstance().checkWidgetFolder();
            }
        }, Constants.TASK_WAIT_THRESHOLD);
    }

    private void parseConfig(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(EventUtils.PERFORMANCE_MODULES);
        if (optJSONObject != null) {
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("memory");
            this.memory = optJSONObject2;
            if (optJSONObject2 != null) {
                this.mEnable = optJSONObject2.optInt(KEY_ENABLE_WIDGET_MEMORY, 0) == 1;
            }
        }
    }

    private boolean inited() {
        return this.mInitEd && ableToInit();
    }

    private boolean ableToInit() {
        return this.mEnable || this.mIsDebug;
    }

    public void start() {
        super.start();
    }

    public void notifyParams(WidgetParams widgetParams) {
        List<String> reportDomain;
        if (widgetParams == null || (reportDomain = widgetParams.getReportDomain()) == null || reportDomain.size() <= 0) {
            return;
        }
        List<String> convertHost = convertHost(reportDomain, MemoryNetApi.UPLOAD_CHECK_PATH);
        if (convertHost != null && convertHost.size() > 0) {
            MemoryNetApi.sUploadCheckUrls = convertHost;
        }
        List<String> convertHost2 = convertHost(reportDomain, MemoryNetApi.DUMP_COLLECT_PATH);
        if (convertHost2 != null && convertHost2.size() > 0) {
            MemoryNetApi.sDumpCollectUrls = convertHost2;
        }
        List<String> convertHost3 = convertHost(reportDomain, MemoryNetApi.UPLOAD_CLIENT_SUFFIX);
        if (convertHost3 == null || convertHost3.size() <= 0) {
            return;
        }
        MemoryNetApi.sUploadClientResultUrls = convertHost3;
    }

    private List<String> convertHost(List<String> list, String str) {
        try {
            if (!ListUtils.isEmpty(list)) {
                ArrayList arrayList = new ArrayList(2);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    String host = new URL(list.get(i)).getHost();
                    if (!TextUtils.isEmpty(host) && host.indexOf(46) > 0) {
                        arrayList.add("https://" + host + str);
                    }
                }
                return arrayList;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public void onFront(Activity activity) {
        super.onFront(activity);
        if (inited() && this.mMemoryWidgetConfig.getRunStrategy() == 2) {
            MemoryLog.m101i("onFront", new Object[0]);
            MemoryApi.getInstance().start();
        }
    }

    public void onBackground(Activity activity) {
        super.onBackground(activity);
        if (inited() && this.mMemoryWidgetConfig.getRunStrategy() == 2) {
            MemoryChecker.getInstance().stopCheck();
        }
    }
}
