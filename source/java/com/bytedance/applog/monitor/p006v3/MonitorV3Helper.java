package com.bytedance.applog.monitor.p006v3;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.android.standard.tools.url.UrlUtils;
import com.bytedance.applog.compress.Gzip;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.applog.monitor.exception.AppLogExceptionManager;
import com.bytedance.applog.monitor.p006v3.impl.ErrorMonitor;
import com.bytedance.applog.monitor.p006v3.impl.SentryMonitor;
import com.bytedance.applog.monitor.p006v3.impl.StatsMonitor;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.Cdid;
import com.bytedance.bdinstall.INetworkClient;
import com.bytedance.common.wschannel.WsConstants;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class MonitorV3Helper implements Handler.Callback {
    private static final int MSG_REPORT = 1;
    public static final int SENTRY_STAINED_FLAG_EVENT_VERIFY_ONLY = 2;
    public static final int SENTRY_STAINED_FLAG_ONLINE_ONLY = 1;
    private MonitorV3Config config;
    private final MonitorConfigManager configManager;
    private final ErrorMonitor errorMonitor;
    private final JSONObject features;
    private Handler handler;
    private final AtomicBoolean hasInit;
    private final JSONObject header;
    private final SentryMonitor sentryMonitor;
    private final StatsMonitor statsMonitor;
    private static final List<String> logTags = Collections.singletonList("MonitorV3Helper");
    private static final String launchUuid = UUID.randomUUID().toString();
    private static int monitorAppId = 3590;

    public static void setMonitorAppId(int i) {
        if (i > 0) {
            monitorAppId = i;
        }
    }

    public MonitorV3Helper() {
        MonitorConfigManager monitorConfigManager = new MonitorConfigManager();
        this.configManager = monitorConfigManager;
        this.errorMonitor = new ErrorMonitor(monitorConfigManager);
        this.sentryMonitor = new SentryMonitor(monitorConfigManager);
        this.statsMonitor = new StatsMonitor(monitorConfigManager);
        this.header = new JSONObject();
        this.hasInit = new AtomicBoolean(false);
        this.features = new JSONObject();
        setStringHeader("cold_start_id", launchUuid);
    }

    public MonitorConfigManager getConfigManager() {
        return this.configManager;
    }

    public void setHeader(String str, String str2) {
        if (isEnabled()) {
            LoggerImpl.global().debug(8, logTags, "setHeader {} = {}", str, str2);
            try {
                this.header.put(str, str2);
            } catch (Throwable unused) {
            }
        }
    }

    public void setFeature(String str, boolean z) {
        if (isEnabled()) {
            LoggerImpl.global().debug(8, logTags, "setFeature boolean {} = {}", str, Boolean.valueOf(z));
            synchronized (this.features) {
                try {
                    this.features.put(str, z ? 1 : 0);
                } finally {
                }
            }
        }
    }

    public void setFeature(String str, String str2) {
        if (isEnabled()) {
            LoggerImpl.global().debug(8, logTags, "setFeature string {} = {}", str, str2);
            synchronized (this.features) {
                try {
                    this.features.put(str, str2);
                } finally {
                }
            }
        }
    }

    public void setFeature(String str, JSONObject jSONObject) {
        if (isEnabled()) {
            LoggerImpl.global().debug(8, logTags, "setFeature json {} = {}", str, jSONObject);
            synchronized (this.features) {
                try {
                    this.features.put(str, jSONObject);
                } finally {
                }
            }
        }
    }

    public void setFeature(String str, long j) {
        if (isEnabled()) {
            LoggerImpl.global().debug(8, logTags, "setFeature int {} = {}", str, Long.valueOf(j));
            synchronized (this.features) {
                try {
                    this.features.put(str, j);
                } finally {
                }
            }
        }
    }

    public void increaseStats(StatsCountKeys statsCountKeys) {
        increaseStats(statsCountKeys, 1);
    }

    public void increaseStats(String str) {
        increaseStats(str, 1);
    }

    public void increaseStats(StatsCountKeys statsCountKeys, int i) {
        if (isEnabled()) {
            LoggerImpl.global().debug(8, logTags, "increaseStats {} +{}", statsCountKeys, Integer.valueOf(i));
            this.statsMonitor.increase(statsCountKeys.name(), i);
        }
    }

    public void increaseStats(String str, int i) {
        if (isEnabled()) {
            LoggerImpl.global().debug(8, logTags, "increaseStats {} +{}", str, Integer.valueOf(i));
            this.statsMonitor.increase(str, i);
        }
    }

    public boolean isEventHitStage(String str) {
        if (isStageEnabled()) {
            return this.sentryMonitor.isEventHitSampling(str);
        }
        return false;
    }

    public boolean isEventMaybeAccepted(String str) {
        if (isStageEnabled()) {
            return this.sentryMonitor.isEventMaybeAccepted(str);
        }
        return false;
    }

    public void stageEvent(EventStage eventStage, String str, String str2, long j, StageEventType stageEventType) {
        stageEvent(null, -1, eventStage, str, str2, j, stageEventType);
    }

    public void stageEvent(String str, int i, EventStage eventStage, String str2, String str3, long j, StageEventType stageEventType) {
        if (isStageEnabled()) {
            LoggerImpl.global().debug(8, logTags, "stageEvent {} -> event: {}, monitor_id: {}, ts: {}, type: {}, priority: {}-{}", eventStage, str2, str3, Long.valueOf(j), stageEventType, str, Integer.valueOf(i));
            this.sentryMonitor.stage(str, i, eventStage, str2, str3, j, stageEventType);
        }
    }

    public void sendError(String str, Throwable th) {
        sendError(str, th, true);
    }

    public void sendError(String str, Throwable th, boolean z) {
        if (isErrorEnabled()) {
            LoggerImpl.global().debug(8, logTags, "sendError {} -> {}", str, th);
            this.errorMonitor.onError(str, th);
            if (z) {
                AppLogExceptionManager.getInstance().dispatchError(str, th);
            }
        }
    }

    public void init(MonitorV3Config monitorV3Config) {
        LoggerImpl.global().debug(8, logTags, "init monitor v3 helper with config: {}", monitorV3Config);
        if (this.hasInit.compareAndSet(false, true)) {
            this.config = monitorV3Config;
            MonitorV3AppLogConfig appLogConfig = monitorV3Config.getAppLogConfig();
            if (!this.configManager.isEnabled() || monitorV3Config.getContext() == null || appLogConfig == null) {
                this.errorMonitor.initWithDisabled();
                this.sentryMonitor.initWithDisabled();
                this.statsMonitor.initWithDisabled();
                return;
            }
            setStringHeader("aid", String.valueOf(monitorAppId));
            setStringHeader("host_aid", appLogConfig.getAppId());
            setStringHeader("channel", appLogConfig.getChannel());
            setStringHeader(Cdid.KEY_CDID, appLogConfig.getCdid());
            setStringHeader("sdk_version_v2", appLogConfig.getLogSdkVersion());
            setStringHeader("os", "Android");
            setStringHeader("os_version", Build.VERSION.RELEASE);
            setStringHeader(Api.KEY_APP_NAME, appLogConfig.getAppName());
            setStringHeader("app_version", appLogConfig.getVersion());
            setStringHeader("update_version_code", String.valueOf(appLogConfig.getUpdateVersionCode()));
            if (appLogConfig.isLogEnabled()) {
                setFeature("log_enable", 1L);
            }
            if (appLogConfig.isDevtoolsEnabled()) {
                setFeature("devtools_enable", 1L);
            }
            if (appLogConfig.isTouristMode()) {
                setFeature("tourist_mode", 1L);
            }
            if (appLogConfig.isFrequencyControlEnabled()) {
                setFeature("frequency_control_enable", 1L);
            }
            if (appLogConfig.isLogEventFilterEnabled()) {
                setFeature("log_event_filter_enable", 1L);
            }
            if (isDebugMode()) {
                setFeature("debug_mode", 1L);
            }
            setFeature("report_interval", monitorV3Config.getEventReportInterval());
            String appId = appLogConfig.getAppId();
            this.configManager.init(monitorV3Config.getContext(), appId);
            HandlerThread handlerThread = new HandlerThread(appLogConfig.getAppId() + "@applog_monitor_v3");
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper(), this);
            this.handler = handler;
            handler.sendEmptyMessageDelayed(1, this.configManager.getColdStartReportDelay());
            this.errorMonitor.init(monitorV3Config.getContext(), handlerThread, appId);
            this.sentryMonitor.init(monitorV3Config.getContext(), handlerThread, appId);
            this.statsMonitor.init(monitorV3Config.getContext(), handlerThread, appId);
        }
    }

    public void flush() {
        if (this.handler == null) {
            return;
        }
        LoggerImpl.global().debug(8, logTags, "monitor flush...", new Object[0]);
        this.handler.removeMessages(1);
        this.handler.sendEmptyMessageDelayed(1, 500L);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1) {
            return false;
        }
        doReport();
        return false;
    }

    public void setStringHeader(String str, String str2) {
        if (isEnabled()) {
            LoggerImpl.global().debug(8, logTags, "setStringHeader {}: {}", str, str2);
            try {
                this.header.put(str, str2);
            } catch (Throwable unused) {
            }
        }
    }

    public boolean isEnabled() {
        return this.configManager.isEnabled();
    }

    public boolean isStageEnabled() {
        return isEnabled() && this.configManager.isSentryEnabled();
    }

    public boolean isDebugMode() {
        return this.configManager.isDebugMode();
    }

    public boolean isStageForAllEvents() {
        return isStageEnabled() && this.sentryMonitor.isAcceptAllEvents();
    }

    public boolean isErrorEnabled() {
        return isEnabled() && this.configManager.isErrorReportEnabled();
    }

    private void doReport() {
        MonitorV3Config monitorV3Config;
        if (!isEnabled() || (monitorV3Config = this.config) == null || monitorV3Config.getNetworkClient() == null || this.config.getExecutor() == null || TextUtils.isEmpty(this.config.getReportUrl())) {
            return;
        }
        LoggerImpl.global().debug(8, logTags, "start doReport...", new Object[0]);
        final long maxRequestBodySize = this.configManager.getMaxRequestBodySize();
        final int maxRequestCount = this.configManager.getMaxRequestCount();
        final INetworkClient networkClient = this.config.getNetworkClient();
        final String reportUrl = this.config.getReportUrl();
        this.config.getExecutor().submit(new Runnable() { // from class: com.bytedance.applog.monitor.v3.MonitorV3Helper.1
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject;
                JSONArray jSONArray;
                Pair<Map<String, SentryMonitor.StageEvent>, Long> mapBySize;
                Pair<Map<String, Integer>, Long> mapBySize2;
                Pair<Map<String, JSONObject>, Long> mapBySize3;
                JSONObject fetchExternalHeaders;
                int i = 0;
                for (int i2 = 0; i2 < maxRequestCount; i2++) {
                    if (i >= 2) {
                        LoggerImpl.global().debug(8, MonitorV3Helper.logTags, "report failed and break with try 2 times: {}.", new Object[0]);
                        MonitorV3Helper.this.increaseStats("monitor_report_failed_2_tries");
                        return;
                    }
                    try {
                        Thread.sleep(WsConstants.EXIT_DELAY_TIME);
                    } catch (InterruptedException unused) {
                    }
                    long j = maxRequestBodySize;
                    try {
                        jSONObject = new JSONObject();
                        IMonitorDataFetcher dataFetcher = MonitorV3Helper.this.config.getDataFetcher();
                        if (dataFetcher != null && (fetchExternalHeaders = dataFetcher.fetchExternalHeaders()) != null && fetchExternalHeaders.length() > 0) {
                            Iterator<String> keys = fetchExternalHeaders.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                MonitorV3Helper.this.header.put(next, fetchExternalHeaders.opt(next));
                            }
                        }
                        MonitorV3Helper.this.header.put("feature_options", MonitorV3Helper.this.features);
                        jSONObject.put("header", MonitorV3Helper.this.header);
                        jSONArray = new JSONArray();
                        mapBySize = MonitorV3Helper.this.sentryMonitor.getMapBySize(j);
                        if (mapBySize.first != null) {
                            MonitorV3Helper.this.sentryMonitor.appendMapToJSONArray((Map) mapBySize.first, jSONArray);
                            j = ((Long) mapBySize.second).longValue();
                        }
                        mapBySize2 = MonitorV3Helper.this.statsMonitor.getMapBySize(j);
                        if (mapBySize2.first != null) {
                            MonitorV3Helper.this.statsMonitor.appendMapToJSONArray((Map) mapBySize2.first, jSONArray);
                            j = ((Long) mapBySize2.second).longValue();
                        }
                        mapBySize3 = MonitorV3Helper.this.errorMonitor.getMapBySize(j);
                        if (mapBySize3.first != null) {
                            MonitorV3Helper.this.errorMonitor.appendMapToJSONArray((Map) mapBySize3.first, jSONArray);
                            j = ((Long) mapBySize3.second).longValue();
                        }
                    } catch (Throwable th) {
                        LoggerImpl.global().error(8, MonitorV3Helper.logTags, "report to server failed!", th, new Object[0]);
                    }
                    if (jSONArray.length() == 0) {
                        LoggerImpl.global().debug(8, MonitorV3Helper.logTags, "report break for no any event!", new Object[0]);
                        return;
                    }
                    jSONObject.put(com.bytedance.applog.server.Api.KEY_V3, jSONArray);
                    byte[] compress = Gzip.compress(jSONObject.toString().getBytes(UrlUtils.UTF_8));
                    HashMap hashMap = new HashMap();
                    hashMap.put("log-encode-type", "gzip");
                    hashMap.put("Content-Encoding", "gzip");
                    hashMap.put("Content-Type", "application/octet-stream;tt-data=b");
                    String post = networkClient.post(reportUrl, compress, hashMap);
                    LoggerImpl.global().debug(8, MonitorV3Helper.logTags, "report with left body size left: {} and response: {}.", Long.valueOf(j), post);
                    if (!TextUtils.isEmpty(post) && "success".equals(new JSONObject(post).getString("message"))) {
                        LoggerImpl.global().info(8, MonitorV3Helper.logTags, "report to server success!", new Object[0]);
                        MonitorV3Helper.this.sentryMonitor.removeByMap((Map) mapBySize.first);
                        MonitorV3Helper.this.statsMonitor.removeByMap((Map) mapBySize2.first);
                        MonitorV3Helper.this.errorMonitor.removeByMap((Map) mapBySize3.first);
                        if (j > 0) {
                            return;
                        }
                    }
                    i++;
                }
            }
        });
        this.handler.removeMessages(1);
        this.handler.sendEmptyMessageDelayed(1, this.configManager.getReportInterval());
    }
}
