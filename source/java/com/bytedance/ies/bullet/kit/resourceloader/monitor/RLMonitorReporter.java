package com.bytedance.ies.bullet.kit.resourceloader.monitor;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.SystemClock;
import bolts.Task;
import com.bytedance.android.monitorV2.webview.IWebViewMonitorHelper;
import com.bytedance.android.monitorV2.webview.WebViewMonitorHelper;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoader;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoaderUtils;
import com.bytedance.ies.bullet.kit.resourceloader.loader.LoaderUtil;
import com.bytedance.ies.bullet.kit.resourceloader.loggger.RLLogger;
import com.bytedance.ies.bullet.kit.resourceloader.model.RLChannelBundleModel;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.ies.bullet.service.base.resourceloader.config.ResourceLoaderConfig;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import com.bytedance.ies.bullet.service.base.settings.IBulletSettingsService;
import com.bytedance.ies.bullet.service.base.settings.MonitorSettingsConfig;
import com.bytedance.ies.bullet.service.base.standard.StandardServiceManager;
import com.bytedance.ies.bullet.service.base.standard.visiblestate.ViewVisibleBridge;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.lynx.scc.cloudservice.SccResult;
import com.bytedance.lynx.service.reporter.performance.LynxTimingPerformanceReportProcessor;
import com.bytedance.memory.shrink.HprofMemoryConstants;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: RLMonitorReporter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J&\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u0004J\u0018\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020(2\u0006\u0010#\u001a\u00020$H\u0002J.\u0010)\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020-J&\u0010.\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020$2\u0006\u0010/\u001a\u00020\u0004J&\u00100\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u00101\u001a\u000202R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/bytedance/ies/bullet/kit/resourceloader/monitor/RLMonitorReporter;", "", "()V", "BUILDIN_FIND", "", "BUILDIN_MATCH", "BUILDIN_TOTAL", "CDN_TOTAL", "CONFIG_MERGE", "CREATE_PIPELINE", "EVENT_FETCH", "EVENT_PERFORMANCE", "GECKO_LOCAL", "GECKO_TOTAL", "GECKO_UPDATE", "HIGH_PROCESSOR_TOTAL", "LOW_PROCESSOR_TOTAL", "MEMORY_RESOLVE", "PARSE", "TOTAL", "channelCheckList", "", "logPre", "getLogPre", "()Ljava/lang/String;", "resLoadSp", "Landroid/content/SharedPreferences;", "isEnableSSP", "", "taskConfig", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/TaskConfig;", "reportFailed", "", "config", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/ResourceLoaderConfig;", "resInfo", "Lcom/bytedance/ies/bullet/service/base/ResourceInfo;", "errorMessage", "reportFirstLoadChannel", "category", "Lorg/json/JSONObject;", "reportGeckoLoaderSecure", "channel", SchemaConstants.QUERY_KEY_BUNDLE, "mode", "", "reportPerformance", "status", "reportSuccess", LynxTimingPerformanceReportProcessor.KEY_DURATION, "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class RLMonitorReporter {
    public static final String BUILDIN_FIND = "buildIn_find";
    public static final String BUILDIN_MATCH = "buildIn_match";
    public static final String BUILDIN_TOTAL = "buildIn_total";
    public static final String CDN_TOTAL = "cdn_total";
    public static final String CONFIG_MERGE = "find_config";
    public static final String CREATE_PIPELINE = "create_pipeline";
    public static final String EVENT_FETCH = "bdx_resourceloader_fetch";
    public static final String EVENT_PERFORMANCE = "bdx_resourceloader_performance";
    public static final String GECKO_LOCAL = "gecko_local";
    public static final String GECKO_TOTAL = "gecko_total";
    public static final String GECKO_UPDATE = "gecko_update";
    public static final String HIGH_PROCESSOR_TOTAL = "high_processor_total";
    public static final RLMonitorReporter INSTANCE = new RLMonitorReporter();
    public static final String LOW_PROCESSOR_TOTAL = "low_processor_total";
    public static final String MEMORY_RESOLVE = "memory_resolve";
    public static final String PARSE = "parse";
    public static final String TOTAL = "total";
    private static final List<String> channelCheckList;
    private static final String logPre;
    private static final SharedPreferences resLoadSp;

    private RLMonitorReporter() {
    }

    static {
        Context applicationContext;
        Application application = ResourceLoader.INSTANCE.getApplication();
        resLoadSp = (application == null || (applicationContext = application.getApplicationContext()) == null) ? null : applicationContext.getSharedPreferences("resourceloader_sp", 0);
        ArrayList arrayList = new ArrayList();
        arrayList.add("fe_lynx_group");
        arrayList.add("fe_app_lynx");
        arrayList.add("fe_lynx_knowledge");
        channelCheckList = arrayList;
        logPre = "geckoResourceFirstLoad: ";
    }

    public final String getLogPre() {
        return logPre;
    }

    public final void reportSuccess(final ResourceLoaderConfig config, final ResourceInfo resInfo, final TaskConfig taskConfig, final long duration) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(resInfo, "resInfo");
        Intrinsics.checkNotNullParameter(taskConfig, "taskConfig");
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        Task.callInBackground(new Callable() { // from class: com.bytedance.ies.bullet.kit.resourceloader.monitor.RLMonitorReporter$reportSuccess$1
            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                call();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:42:0x0157, code lost:
            
                if ((r1 != null ? r1.put("res_type", r0) : null) == null) goto L61;
             */
            @Override // java.util.concurrent.Callable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void call() {
                boolean isEnableSSP;
                String cdn;
                Object obj;
                Object obj2;
                String provideChannel;
                String providerBundlePath;
                boolean isEnableSSP2;
                StatisticFilter.INSTANCE.filterResult(ResourceInfo.this, taskConfig);
                if (ResourceInfo.this.getStatisic()) {
                    isEnableSSP = RLMonitorReporter.INSTANCE.isEnableSSP(taskConfig);
                    LinkedHashMap linkedHashMap = isEnableSSP ? new LinkedHashMap() : null;
                    ICommonService commonService = config.getCommonService();
                    TaskConfig taskConfig2 = taskConfig;
                    RLReportInfo commonReportInfo = ResourceInfo.this.getCommonReportInfo();
                    TaskConfig taskConfig3 = taskConfig;
                    ResourceInfo resourceInfo = ResourceInfo.this;
                    ResourceLoaderConfig resourceLoaderConfig = config;
                    long j = duration;
                    long j2 = elapsedRealtime;
                    if (taskConfig3.getCdnUrl().length() > 0) {
                        cdn = taskConfig3.getCdnUrl();
                    } else {
                        cdn = ResourceLoaderUtils.INSTANCE.getCDN(resourceInfo.getSrcUri());
                        if (cdn == null) {
                            cdn = "";
                        }
                    }
                    if (cdn.length() == 0) {
                        cdn = LoaderUtil.INSTANCE.getUriWithoutQuery(resourceInfo.getSrcUri());
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(SchemaConstants.QUERY_KEY_RES_URL, cdn);
                    if (linkedHashMap != null) {
                        linkedHashMap.put("res_full_src", cdn);
                    }
                    jSONObject.put("res_from", resourceInfo.getStatisticFrom());
                    if (linkedHashMap != null) {
                        linkedHashMap.put("res_from", resourceInfo.getStatisticFrom());
                    }
                    jSONObject.put("res_version", String.valueOf(resourceInfo.getVersion()));
                    jSONObject.put("res_state", "success");
                    if (Intrinsics.areEqual(taskConfig3.getResTag(), "template")) {
                        jSONObject.put("res_tag", "template");
                    } else if (Intrinsics.areEqual(taskConfig3.getResTag(), "web")) {
                        jSONObject.put("res_tag", "web");
                    } else {
                        jSONObject.put("res_tag", "sub_resource");
                    }
                    if (taskConfig3.getIsPreload()) {
                        obj2 = "1";
                        obj = obj2;
                    } else {
                        obj = "1";
                        obj2 = ViewVisibleBridge.INVISIBLE;
                    }
                    jSONObject.put(ResourceInfo.RESOURCE_FROM_PRELOAD, obj2);
                    jSONObject.put("preload_high_priority", taskConfig3.getPreloadHighPriority() ? obj : ViewVisibleBridge.INVISIBLE);
                    jSONObject.put("res_remote", taskConfig3.getIsFromRemoteConfig() ? obj : ViewVisibleBridge.INVISIBLE);
                    jSONObject.put("res_message", "fetch success");
                    String filePath = resourceInfo.getFilePath();
                    if (filePath != null) {
                        String extension = FilesKt.getExtension(new File(filePath));
                        Locale locale = Locale.ROOT;
                        Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
                        if (extension == null) {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                        String lowerCase = extension.toLowerCase(locale);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                        jSONObject.put("res_type", lowerCase);
                    }
                    jSONObject.put("res_type", "unknown");
                    jSONObject.put("res_memory", resourceInfo.getIsFromMemory() ? obj : ViewVisibleBridge.INVISIBLE);
                    jSONObject.put("preload_fail_message", resourceInfo.getPreloadFailMessage());
                    jSONObject.put("gecko_fail_message", resourceInfo.getGeckoFailMessage());
                    jSONObject.put("buildIn_fail_message", resourceInfo.getBuldinFailedMessage());
                    jSONObject.put("cdn_fail_message", resourceInfo.getCdnFailedMessage());
                    jSONObject.put("memory_fail_message", resourceInfo.getMemoryMessage());
                    if (Intrinsics.areEqual(resourceInfo.getStatisticFrom(), ResourceInfo.RESOURCE_FROM_GECKO) || Intrinsics.areEqual(resourceInfo.getStatisticFrom(), ResourceInfo.RESOURCE_FROM_GECKO_UPDATE)) {
                        jSONObject.put("gecko_sdk_version", resourceInfo.getSdkVersion());
                        jSONObject.put(CommonConstants.KEY_AID, resourceLoaderConfig.getAppId());
                        jSONObject.put("package_id", String.valueOf(resourceInfo.getVersion()));
                        if (LoaderUtil.INSTANCE.isNotNullOrEmpty(taskConfig3.getChannel())) {
                            provideChannel = taskConfig3.getChannel();
                        } else {
                            RLChannelBundleModel model = resourceInfo.getModel();
                            provideChannel = model != null ? model.provideChannel() : null;
                        }
                        jSONObject.put("channel", provideChannel);
                        if (LoaderUtil.INSTANCE.isNotNullOrEmpty(taskConfig3.getBid())) {
                            providerBundlePath = taskConfig3.getBundle();
                        } else {
                            RLChannelBundleModel model2 = resourceInfo.getModel();
                            providerBundlePath = model2 != null ? model2.providerBundlePath() : null;
                        }
                        jSONObject.put(SchemaConstants.QUERY_KEY_BUNDLE, providerBundlePath);
                    }
                    commonReportInfo.setCategory(jSONObject);
                    JSONObject category = commonReportInfo.getCategory();
                    if (category != null) {
                        RLMonitorReporter.INSTANCE.reportFirstLoadChannel(category, resourceInfo);
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("res_duration", j);
                    if (LoaderUtil.INSTANCE.isNotNullOrEmpty(resourceInfo.getFilePath())) {
                        LoaderUtil loaderUtil = LoaderUtil.INSTANCE;
                        String filePath2 = resourceInfo.getFilePath();
                        Intrinsics.checkNotNull(filePath2);
                        double fileSize = loaderUtil.getFileSize(new File(filePath2));
                        jSONObject2.put("res_size", fileSize);
                        if (linkedHashMap != null) {
                            linkedHashMap.put("res_size", Double.valueOf(fileSize));
                        }
                    }
                    if (Intrinsics.areEqual(resourceInfo.getStatisticFrom(), ResourceInfo.RESOURCE_FROM_GECKO) || Intrinsics.areEqual(resourceInfo.getStatisticFrom(), ResourceInfo.RESOURCE_FROM_GECKO_UPDATE)) {
                        jSONObject2.put("read_duration", j2 - resourceInfo.getStartLoadTime());
                    }
                    commonReportInfo.setMetrics(jSONObject2);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("res_channel", taskConfig3.getChannel());
                    jSONObject3.put("res_config", taskConfig3.toString());
                    commonReportInfo.setExtra(jSONObject3);
                    StatisticFilter statisticFilter = StatisticFilter.INSTANCE;
                    String uri = resourceInfo.getSrcUri().toString();
                    Intrinsics.checkNotNullExpressionValue(uri, "resInfo.srcUri.toString()");
                    commonReportInfo.setHighFrequency(Boolean.valueOf(statisticFilter.checkSample(resourceLoaderConfig, uri)));
                    Unit unit = Unit.INSTANCE;
                    commonService.report(taskConfig2, commonReportInfo);
                    isEnableSSP2 = RLMonitorReporter.INSTANCE.isEnableSSP(taskConfig);
                    if (isEnableSSP2) {
                        IWebViewMonitorHelper webViewMonitorHelper = WebViewMonitorHelper.getInstance();
                        String engineViewHash = taskConfig.getEngineViewHash();
                        if (engineViewHash == null) {
                            engineViewHash = "";
                        }
                        String engineUrl = taskConfig.getEngineUrl();
                        if (engineUrl == null) {
                            engineUrl = "";
                        }
                        if (linkedHashMap != null) {
                            Object obj3 = linkedHashMap.get("res_full_src");
                            if (obj3 != null) {
                                LoaderUtil loaderUtil2 = LoaderUtil.INSTANCE;
                                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.String");
                                Uri parse = Uri.parse((String) obj3);
                                Intrinsics.checkNotNullExpressionValue(parse, "parse(it as String)");
                                linkedHashMap.put("res_format_src", loaderUtil2.getUriWithoutQuery(parse));
                            }
                            linkedHashMap.put(EventConstants.PARAM_REQUEST_METHOD, "GET");
                            Unit unit2 = Unit.INSTANCE;
                        } else {
                            linkedHashMap = null;
                        }
                        webViewMonitorHelper.handleSSPInfo("anniex_ssp_res_loader_info", engineViewHash, engineUrl, linkedHashMap);
                    }
                }
            }
        });
    }

    public final void reportFailed(final ResourceLoaderConfig config, final ResourceInfo resInfo, final TaskConfig taskConfig, final String errorMessage) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(resInfo, "resInfo");
        Intrinsics.checkNotNullParameter(taskConfig, "taskConfig");
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        Task.callInBackground(new Callable() { // from class: com.bytedance.ies.bullet.kit.resourceloader.monitor.RLMonitorReporter$reportFailed$1
            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                call();
                return Unit.INSTANCE;
            }

            @Override // java.util.concurrent.Callable
            public final void call() {
                String cdn;
                boolean isEnableSSP;
                StatisticFilter.INSTANCE.filterResult(ResourceInfo.this, taskConfig);
                if (ResourceInfo.this.getStatisic()) {
                    ICommonService commonService = config.getCommonService();
                    TaskConfig taskConfig2 = taskConfig;
                    RLReportInfo rLReportInfo = new RLReportInfo(RLMonitorReporter.EVENT_FETCH, null, null, null, null, null, null, null, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_HEAP_DUMP_INFO, null);
                    TaskConfig taskConfig3 = taskConfig;
                    ResourceInfo resourceInfo = ResourceInfo.this;
                    ResourceLoaderConfig resourceLoaderConfig = config;
                    String str = errorMessage;
                    long j = elapsedRealtime;
                    if (taskConfig3.getCdnUrl().length() > 0) {
                        cdn = taskConfig3.getCdnUrl();
                    } else {
                        cdn = ResourceLoaderUtils.INSTANCE.getCDN(resourceInfo.getSrcUri());
                        if (cdn == null) {
                            cdn = "";
                        }
                    }
                    if (cdn.length() == 0) {
                        cdn = LoaderUtil.INSTANCE.getUriWithoutQuery(resourceInfo.getSrcUri());
                    }
                    rLReportInfo.setUrl(cdn);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(SchemaConstants.QUERY_KEY_RES_URL, cdn);
                    jSONObject.put("res_state", SccResult.MESSAGE_FAIL);
                    jSONObject.put("res_message", str);
                    jSONObject.put("preload_fail_message", resourceInfo.getPreloadFailMessage());
                    jSONObject.put("gecko_fail_message", resourceInfo.getGeckoFailMessage());
                    jSONObject.put("buildIn_fail_message", resourceInfo.getBuldinFailedMessage());
                    jSONObject.put("cdn_failed_message", resourceInfo.getCdnFailedMessage());
                    String resTag = taskConfig3.getResTag();
                    if (Intrinsics.areEqual(resTag, "template")) {
                        jSONObject.put("res_tag", "template");
                    } else if (Intrinsics.areEqual(resTag, "web")) {
                        jSONObject.put("res_tag", "web");
                    } else {
                        jSONObject.put("res_tag", "sub_resource");
                    }
                    jSONObject.put(ResourceInfo.RESOURCE_FROM_PRELOAD, taskConfig3.getIsPreload() ? "1" : ViewVisibleBridge.INVISIBLE);
                    jSONObject.put("preload_high_priority", taskConfig3.getPreloadHighPriority() ? "1" : ViewVisibleBridge.INVISIBLE);
                    rLReportInfo.setCategory(jSONObject);
                    JSONObject category = rLReportInfo.getCategory();
                    if (category != null) {
                        RLMonitorReporter.INSTANCE.reportFirstLoadChannel(category, resourceInfo);
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("res_duration", j - resourceInfo.getStartLoadTime());
                    rLReportInfo.setMetrics(jSONObject2);
                    StatisticFilter statisticFilter = StatisticFilter.INSTANCE;
                    String uri = resourceInfo.getSrcUri().toString();
                    Intrinsics.checkNotNullExpressionValue(uri, "resInfo.srcUri.toString()");
                    rLReportInfo.setHighFrequency(Boolean.valueOf(statisticFilter.checkSample(resourceLoaderConfig, uri)));
                    Unit unit = Unit.INSTANCE;
                    commonService.report(taskConfig2, rLReportInfo);
                    isEnableSSP = RLMonitorReporter.INSTANCE.isEnableSSP(taskConfig);
                    if (isEnableSSP) {
                        IWebViewMonitorHelper webViewMonitorHelper = WebViewMonitorHelper.getInstance();
                        String engineViewHash = taskConfig.getEngineViewHash();
                        if (engineViewHash == null) {
                            engineViewHash = "";
                        }
                        String engineUrl = taskConfig.getEngineUrl();
                        String str2 = engineUrl != null ? engineUrl : "";
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        LoaderUtil loaderUtil = LoaderUtil.INSTANCE;
                        Uri parse = Uri.parse(cdn);
                        Intrinsics.checkNotNullExpressionValue(parse, "parse(resourceUrl)");
                        linkedHashMap.put("res_format_src", loaderUtil.getUriWithoutQuery(parse));
                        Intrinsics.checkNotNull(cdn, "null cannot be cast to non-null type kotlin.String");
                        linkedHashMap.put("res_full_src", cdn);
                        linkedHashMap.put(EventConstants.PARAM_REQUEST_METHOD, "GET");
                        Unit unit2 = Unit.INSTANCE;
                        webViewMonitorHelper.handleSSPInfo("anniex_ssp_res_loader_info", engineViewHash, str2, linkedHashMap);
                    }
                }
            }
        });
    }

    public final void reportGeckoLoaderSecure(final ResourceLoaderConfig config, final TaskConfig taskConfig, final String channel, final String bundle, final int mode) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(taskConfig, "taskConfig");
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(bundle, SchemaConstants.QUERY_KEY_BUNDLE);
        Task.callInBackground(new Callable() { // from class: com.bytedance.ies.bullet.kit.resourceloader.monitor.RLMonitorReporter$reportGeckoLoaderSecure$1
            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                call();
                return Unit.INSTANCE;
            }

            @Override // java.util.concurrent.Callable
            public final void call() {
                ICommonService commonService = ResourceLoaderConfig.this.getCommonService();
                TaskConfig taskConfig2 = taskConfig;
                RLReportInfo rLReportInfo = new RLReportInfo("res_gecko_loader_secure", null, null, null, null, null, null, null, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_HEAP_DUMP_INFO, null);
                String str = channel;
                String str2 = bundle;
                int i = mode;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("channel", str);
                jSONObject.put(SchemaConstants.QUERY_KEY_BUNDLE, str2);
                jSONObject.put("loader", "ResourceLoader");
                jSONObject.put("mode", i);
                rLReportInfo.setCategory(jSONObject);
                rLReportInfo.setHighFrequency(true);
                Unit unit = Unit.INSTANCE;
                commonService.report(taskConfig2, rLReportInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isEnableSSP(TaskConfig taskConfig) {
        MonitorSettingsConfig monitorSettingsConfig;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        return (taskConfig.getEngineViewHash() == null || taskConfig.getEngineUrl() == null || !((iBulletSettingsService == null || (monitorSettingsConfig = (MonitorSettingsConfig) iBulletSettingsService.obtainSettings(MonitorSettingsConfig.class)) == null) ? false : monitorSettingsConfig.getWebSSPReport())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportFirstLoadChannel(JSONObject category, ResourceInfo resInfo) {
        if (channelCheckList.contains(resInfo.getChannel())) {
            SharedPreferences sharedPreferences = resLoadSp;
            if (sharedPreferences == null) {
                RLLogger.INSTANCE.m22e("sp is null");
                return;
            }
            if (!sharedPreferences.getBoolean(resInfo.getChannel(), false)) {
                sharedPreferences.edit().putBoolean(resInfo.getChannel(), true).apply();
                category.put("res_first_try_fetch", "1");
                RLLogger.INSTANCE.m21d(logPre + "first load！");
            } else {
                category.put("res_first_try_fetch", ViewVisibleBridge.INVISIBLE);
                RLLogger.INSTANCE.m21d(logPre + "loaded！");
            }
        }
    }

    public final void reportPerformance(final ResourceLoaderConfig config, final TaskConfig taskConfig, final ResourceInfo resInfo, final String status) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(taskConfig, "taskConfig");
        Intrinsics.checkNotNullParameter(resInfo, "resInfo");
        Intrinsics.checkNotNullParameter(status, "status");
        Task.callInBackground(new Callable() { // from class: com.bytedance.ies.bullet.kit.resourceloader.monitor.RLMonitorReporter$reportPerformance$1
            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                call();
                return Unit.INSTANCE;
            }

            @Override // java.util.concurrent.Callable
            public final void call() {
                RLReportInfo performanceInfo = ResourceInfo.this.getPerformanceInfo();
                JSONObject jSONObject = new JSONObject();
                ResourceInfo resourceInfo = ResourceInfo.this;
                String str = status;
                TaskConfig taskConfig2 = taskConfig;
                jSONObject.put(SchemaConstants.QUERY_KEY_RES_URL, resourceInfo.getSrcUri().toString());
                jSONObject.put("res_state", str);
                jSONObject.put(ResourceInfo.RESOURCE_FROM_PRELOAD, taskConfig2.getIsPreload() ? "1" : ViewVisibleBridge.INVISIBLE);
                performanceInfo.setCategory(jSONObject);
                if (ResourceInfo.this.getPerformanceInfo().getMetrics() != null) {
                    ICommonService commonService = config.getCommonService();
                    TaskConfig taskConfig3 = taskConfig;
                    RLReportInfo performanceInfo2 = ResourceInfo.this.getPerformanceInfo();
                    ResourceLoaderConfig resourceLoaderConfig = config;
                    ResourceInfo resourceInfo2 = ResourceInfo.this;
                    StatisticFilter statisticFilter = StatisticFilter.INSTANCE;
                    String uri = resourceInfo2.getSrcUri().toString();
                    Intrinsics.checkNotNullExpressionValue(uri, "resInfo.srcUri.toString()");
                    performanceInfo2.setHighFrequency(Boolean.valueOf(statisticFilter.checkSample(resourceLoaderConfig, uri)));
                    Unit unit = Unit.INSTANCE;
                    commonService.report(taskConfig3, performanceInfo2);
                }
            }
        });
    }
}
