package com.bytedance.ies.bullet.kit.resourceloader;

import android.net.Uri;
import android.os.SystemClock;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.forest.ForestResourceInfo;
import com.bytedance.ies.bullet.kit.resourceloader.debugger.GlobalResourceInterceptor;
import com.bytedance.ies.bullet.kit.resourceloader.loader.AssetsLoader;
import com.bytedance.ies.bullet.kit.resourceloader.loader.CDNLoader;
import com.bytedance.ies.bullet.kit.resourceloader.loader.GeckoLoader;
import com.bytedance.ies.bullet.kit.resourceloader.loader.LoaderUtil;
import com.bytedance.ies.bullet.kit.resourceloader.loader.MemoryLoader;
import com.bytedance.ies.bullet.kit.resourceloader.loggger.RLLogger;
import com.bytedance.ies.bullet.kit.resourceloader.loggger.RLLoggerConstant;
import com.bytedance.ies.bullet.kit.resourceloader.memory.MemoryManager;
import com.bytedance.ies.bullet.kit.resourceloader.model.RLChannelBundleModel;
import com.bytedance.ies.bullet.kit.resourceloader.monitor.RLMonitorReporter;
import com.bytedance.ies.bullet.kit.resourceloader.monitor.RLReportInfo;
import com.bytedance.ies.bullet.kit.resourceloader.monitor.StatisticFilter;
import com.bytedance.ies.bullet.kit.resourceloader.pipeline.ResourceLoaderChain;
import com.bytedance.ies.bullet.secure.HybridSecureUtil;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.ResourceFrom;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.ies.bullet.service.base.resourceloader.config.GeckoConfig;
import com.bytedance.ies.bullet.service.base.resourceloader.config.ILoaderDepender;
import com.bytedance.ies.bullet.service.base.resourceloader.config.IXResourceLoader;
import com.bytedance.ies.bullet.service.base.resourceloader.config.LoaderType;
import com.bytedance.ies.bullet.service.base.resourceloader.config.ResourceLoaderConfig;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import com.bytedance.ies.bullet.service.base.standard.visiblestate.ViewVisibleBridge;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.schema.utils.SchemaUtilsKt;
import com.bytedance.lynx.scc.cloudservice.SccResult;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: ResourceLoaderService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 A2\u00020\u0001:\u0001AB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001aJ\u0018\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!2\u0006\u0010\t\u001a\u00020\"H\u0002J7\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020&2\u0006\u0010\t\u001a\u00020\"2\u0006\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*H\u0000¢\u0006\u0002\b+J\u0010\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u0004H\u0002J\u0010\u0010.\u001a\u00020\u001d2\u0006\u0010/\u001a\u00020&H\u0016J\u0018\u00100\u001a\u00020*2\u0006\u0010 \u001a\u00020!2\u0006\u0010\t\u001a\u00020\"H\u0002J\u0014\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0019H\u0007J\u0006\u00102\u001a\u00020\nJ@\u00103\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\"2\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u001d052\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u001d05H\u0016J\u001a\u00108\u001a\u0004\u0018\u00010&2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\"H\u0016J\u0012\u00109\u001a\u0004\u0018\u00010:2\b\u0010;\u001a\u0004\u0018\u00010\u0004J\u0016\u0010<\u001a\u00020\u001d2\u0006\u0010=\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020>J\u0006\u0010?\u001a\u00020*J\u000e\u0010@\u001a\u00020\u001d2\u0006\u0010=\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u00150\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u00150\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/bytedance/ies/bullet/kit/resourceloader/ResourceLoaderService;", "", "()V", "bid", "", "getBid", "()Ljava/lang/String;", "setBid", "(Ljava/lang/String;)V", "config", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/ResourceLoaderConfig;", "getConfig", "()Lcom/bytedance/ies/bullet/service/base/resourceloader/config/ResourceLoaderConfig;", "setConfig", "(Lcom/bytedance/ies/bullet/service/base/resourceloader/config/ResourceLoaderConfig;)V", "defaultSequence", "", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/LoaderType;", "perfFrequency", "", "priorityHighLoader", "Ljava/lang/Class;", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/IXResourceLoader;", "priorityLowLoader", "taskMap", "", "Lcom/bytedance/ies/bullet/kit/resourceloader/LoadTask;", "Lcom/bytedance/ies/bullet/kit/resourceloader/pipeline/ResourceLoaderChain;", "cancel", "", "task", "createLoaderChain", "srcUri", "Landroid/net/Uri;", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/TaskConfig;", "dealConfigAndResourceInfo", "uri", "resInfo", "Lcom/bytedance/ies/bullet/service/base/ResourceInfo;", EventConstants.PARAM_SOURCE_INTERVAL, "Lcom/bytedance/ies/bullet/kit/resourceloader/TimeInterval;", "skipGeckoInfo", "", "dealConfigAndResourceInfo$anniex_release", "dealPrefix", "str", "deleteResource", "info", "enableMemoryCache", "getPreloadConfigs", "getResourceConfig", "loadAsync", "resolve", "Lkotlin/Function1;", "reject", "", CDNLoader.STEP_NAME_SYNC, "parseChannelBundle", "Lcom/bytedance/ies/bullet/kit/resourceloader/model/RLChannelBundleModel;", "schema", "registerGeckoConfig", "ak", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/GeckoConfig;", "resourceConfigIsInitialized", "unRegisterGeckoConfig", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ResourceLoaderService {
    public static final String DEV_FLAG = "__dev";
    public static final String ENABLE_MEMORY_CACHE = "enable_memory_cache";
    private static final String KEY_ONLY_LOCAL = "onlyLocal";
    public static final String MEMORY_CACHE_PRIORITY = "memory_cache_priority";
    public static final String RESOURCE_GECKO_AID = "1234";
    public static final String TAG = "ResourceLoaderService";
    public String bid;
    public ResourceLoaderConfig config;
    private int perfFrequency;
    private final List<Class<? extends IXResourceLoader>> priorityHighLoader = new ArrayList();
    private final List<Class<? extends IXResourceLoader>> priorityLowLoader = new ArrayList();
    private final List<LoaderType> defaultSequence = CollectionsKt.mutableListOf(new LoaderType[]{LoaderType.GECKO, LoaderType.BUILTIN, LoaderType.CDN});
    private final Map<LoadTask, ResourceLoaderChain> taskMap = new LinkedHashMap();

    /* compiled from: ResourceLoaderService.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoaderType.values().length];
            try {
                iArr[LoaderType.GECKO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LoaderType.BUILTIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LoaderType.CDN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final String getBid() {
        String str = this.bid;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("bid");
        return null;
    }

    public final void setBid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bid = str;
    }

    public final ResourceLoaderConfig getConfig() {
        ResourceLoaderConfig resourceLoaderConfig = this.config;
        if (resourceLoaderConfig != null) {
            return resourceLoaderConfig;
        }
        Intrinsics.throwUninitializedPropertyAccessException("config");
        return null;
    }

    public final void setConfig(ResourceLoaderConfig resourceLoaderConfig) {
        Intrinsics.checkNotNullParameter(resourceLoaderConfig, "<set-?>");
        this.config = resourceLoaderConfig;
    }

    public final RLChannelBundleModel parseChannelBundle(String schema) {
        if (schema == null) {
            return null;
        }
        if (!Uri.parse(schema).isHierarchical()) {
            RLLogger.INSTANCE.m21d("parseChannelBundle: is notHierarchical");
            return null;
        }
        return ChannelBundleParser.parse$default(ChannelBundleParser.INSTANCE, schema, getResourceConfig(), getBid(), false, null, 24, null);
    }

    public final ResourceLoaderConfig getResourceConfig() {
        return getConfig();
    }

    public final boolean resourceConfigIsInitialized() {
        return this.config != null;
    }

    public final Map<String, String> getPreloadConfigs() {
        if (!resourceConfigIsInitialized()) {
            RLLogger.INSTANCE.m22e("ResourceLoaderConfig 实例未初始化，getPreloadConfigs未执行");
            return new LinkedHashMap();
        }
        String accessKey = getResourceConfig().getDftGeckoCfg().getAccessKey();
        GeckoConfig geckoConfig = getResourceConfig().getGeckoConfig(accessKey);
        return geckoConfig.getLoaderDepender().getPreloadConfigs(geckoConfig.getOfflineDir(), accessKey);
    }

    public final void registerGeckoConfig(String ak, GeckoConfig config) {
        Intrinsics.checkNotNullParameter(ak, "ak");
        Intrinsics.checkNotNullParameter(config, "config");
        if (!resourceConfigIsInitialized()) {
            RLLogger.INSTANCE.m22e("ResourceLoaderConfig 实例未初始化，registerGeckoConfig未执行");
            return;
        }
        config.getLoaderDepender().setService(this);
        getResourceConfig().getGeckoConfigs().put(ak, config);
        if (config.getNetworkImpl() == null) {
            if (config.getLocalInfo().length() > 0) {
                config.setNetworkImpl(getResourceConfig().getGeckoNetworkImpl());
            } else {
                config.setNetworkImpl(getResourceConfig().getGeckoXNetworkImpl());
            }
        }
    }

    public final void unRegisterGeckoConfig(String ak) {
        Intrinsics.checkNotNullParameter(ak, "ak");
        if (!resourceConfigIsInitialized()) {
            RLLogger.INSTANCE.m22e("ResourceLoaderConfig 实例未初始化，unRegisterGeckoConfig未执行");
        } else {
            getResourceConfig().getGeckoConfigs().remove(ak);
        }
    }

    private final boolean enableMemoryCache(Uri srcUri, TaskConfig config) {
        String queryParameter = srcUri.getQueryParameter("__dev");
        if (Intrinsics.areEqual(queryParameter, "1")) {
            return false;
        }
        String str = queryParameter;
        if ((str == null || str.length() == 0) && ResourceLoader.INSTANCE.isDebug()) {
            return false;
        }
        String safeGetQueryParameter = ResourceLoaderUtils.INSTANCE.safeGetQueryParameter(ENABLE_MEMORY_CACHE, srcUri);
        if (LoaderUtil.INSTANCE.isNotNullOrEmpty(safeGetQueryParameter)) {
            return Intrinsics.areEqual(safeGetQueryParameter, "1");
        }
        return getResourceConfig().getEnableMemCache();
    }

    private final ResourceLoaderChain createLoaderChain(Uri srcUri, TaskConfig config) {
        int i;
        ArrayList arrayList = new ArrayList();
        if (!GlobalResourceInterceptor.INSTANCE.getLoaders().isEmpty()) {
            arrayList.addAll(GlobalResourceInterceptor.INSTANCE.getLoaders());
        }
        List<Class<? extends IXResourceLoader>> priorityHigh = config.getLoaderConfig().getPriorityHigh();
        if (priorityHigh != null) {
            arrayList.addAll(priorityHigh);
        }
        arrayList.addAll(this.priorityHighLoader);
        int size = arrayList.size();
        if (config.getLoaderConfig().getLoaderSequence().isEmpty() && !config.getLoaderConfig().getDisableDefaultLoader()) {
            config.getLoaderConfig().setLoaderSequence(this.defaultSequence);
        }
        if (enableMemoryCache(srcUri, config)) {
            arrayList.add(MemoryLoader.class);
        }
        IXResourceLoader preloadLoader = ResourceLoader.INSTANCE.getPreloadLoader();
        if (preloadLoader != null) {
            arrayList.add(preloadLoader.getClass());
        }
        Iterator<LoaderType> it = config.getLoaderConfig().getLoaderSequence().iterator();
        while (it.hasNext()) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[it.next().ordinal()];
            if (i2 == 1) {
                arrayList.add(GeckoLoader.class);
            } else if (i2 == 2) {
                arrayList.add(AssetsLoader.class);
            } else if (i2 == 3) {
                arrayList.add(CDNLoader.class);
            }
        }
        arrayList.addAll(this.priorityLowLoader);
        List<Class<? extends IXResourceLoader>> priorityLow = config.getLoaderConfig().getPriorityLow();
        if (priorityLow != null) {
            i = arrayList.size();
            arrayList.addAll(priorityLow);
        } else {
            i = -1;
        }
        List<Class<? extends IXResourceLoader>> removedLoader = config.getLoaderConfig().getRemovedLoader();
        if (removedLoader != null) {
            arrayList.removeAll(removedLoader);
        }
        ResourceLoaderChain resourceLoaderChain = new ResourceLoaderChain(arrayList, this);
        resourceLoaderChain.setDefaultIndex(size);
        resourceLoaderChain.setLowIndex(i);
        return resourceLoaderChain;
    }

    public ResourceInfo loadSync(final String uri, TaskConfig config) {
        String createResourceLoaderSession;
        Object obj;
        TaskConfig taskConfig;
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(config, "config");
        createResourceLoaderSession = ResourceLoaderServiceKt.createResourceLoaderSession();
        config.setResourceLoaderSession(createResourceLoaderSession);
        final LoggerContext loggerContext = new LoggerContext();
        loggerContext.pushStage(RLLoggerConstant.RESOURCE_SESSION, config.getResourceLoaderSession());
        HybridLogger.INSTANCE.m11i("XResourceLoader", "ResourceLoader start load", MapsKt.mapOf(new Pair[]{TuplesKt.to("url", uri), TuplesKt.to("config", config.toString()), TuplesKt.to("type", "sync")}), loggerContext);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        final TimeInterval timeInterval = new TimeInterval();
        if (getResourceConfig().getCaptureFrequency() > 0) {
            this.perfFrequency = (this.perfFrequency + 1) % getResourceConfig().getCaptureFrequency();
        }
        config.setBid(getBid());
        if (ResourceLoader.INSTANCE.getApplication() == null) {
            RLLogger.INSTANCE.m22e("ResourceLoader_sync did not init yet");
            return null;
        }
        Uri parse = Uri.parse(uri);
        if (!parse.isHierarchical()) {
            return null;
        }
        if (config.getAccessKey().length() == 0) {
            try {
                Result.Companion companion = Result.Companion;
                String queryParameter = parse.getQueryParameter("accessKey");
                if (queryParameter == null) {
                    queryParameter = "";
                }
                obj = Result.constructor-impl(queryParameter);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            String accessKey = getResourceConfig().getDftGeckoCfg().getAccessKey();
            if (Result.isFailure-impl(obj)) {
                obj = accessKey;
            }
            config.setAccessKey((String) obj);
            if (config.getAccessKey().length() == 0) {
                config.setAccessKey(getResourceConfig().getDftGeckoCfg().getAccessKey());
            }
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Uri hookUrl = GlobalResourceInterceptor.INSTANCE.hookUrl(uri, config);
        if (hookUrl == null) {
            hookUrl = parse;
        }
        Intrinsics.checkNotNullExpressionValue(hookUrl, "GlobalResourceIntercepto…rl(uri, config) ?: srcUri");
        final ResourceInfo resourceInfo = new ResourceInfo(hookUrl, null, null, null, false, 0L, false, null, null, null, elapsedRealtime, null, 3070, null);
        if (this.perfFrequency == 0 || !StatisticFilter.INSTANCE.checkSample(getResourceConfig(), uri)) {
            resourceInfo.getPerformanceInfo().setMetrics(new JSONObject());
        } else {
            resourceInfo.getPerformanceInfo().setMetrics(null);
        }
        resourceInfo.setResTag(config.getResTag());
        dealConfigAndResourceInfo$anniex_release$default(this, uri, resourceInfo, config, timeInterval, false, 16, null);
        GeckoConfig geckoConfig = getResourceConfig().getGeckoConfig(config.getAccessKey());
        if (getResourceConfig().getEnableRemoteConfig()) {
            ILoaderDepender loaderDepender = geckoConfig.getLoaderDepender();
            Intrinsics.checkNotNullExpressionValue(parse, "srcUri");
            taskConfig = loaderDepender.mergeConfig(parse, config);
        } else {
            taskConfig = config;
        }
        HybridLogger.INSTANCE.m11i("XResourceLoader", "show channel/bundle before load", MapsKt.mapOf(new Pair[]{TuplesKt.to("url", uri), TuplesKt.to("channel", taskConfig.getChannel()), TuplesKt.to(SchemaConstants.QUERY_KEY_BUNDLE, taskConfig.getBundle()), TuplesKt.to("config", config.toString())}), loggerContext);
        resourceInfo.setEnableMemory(enableMemoryCache(resourceInfo.getSrcUri(), taskConfig));
        resourceInfo.setMemoryCachePriority(ResourceLoaderUtils.INSTANCE.safeGetQueryParameter("memory_cache_priority", resourceInfo.getSrcUri()));
        resourceInfo.setCacheKey(ResourceLoaderUtils.INSTANCE.createCacheKey(resourceInfo, taskConfig));
        JSONObject metrics = resourceInfo.getPerformanceInfo().getMetrics();
        if (metrics != null) {
            metrics.put(RLMonitorReporter.CONFIG_MERGE, timeInterval.getTimeInterval());
        }
        ResourceLoaderChain createLoaderChain = createLoaderChain(resourceInfo.getSrcUri(), taskConfig);
        HybridLogger.INSTANCE.m11i("XResourceLoader", "loadSync create loader chain", MapsKt.mapOf(new Pair[]{TuplesKt.to("loaderChain", createLoaderChain.toLoaderStrList()), TuplesKt.to("url", uri)}), loggerContext);
        resourceInfo.setLoaders(createLoaderChain.toLoaderStrList());
        JSONObject metrics2 = resourceInfo.getPerformanceInfo().getMetrics();
        if (metrics2 != null) {
            metrics2.put(RLMonitorReporter.CREATE_PIPELINE, timeInterval.getTimeInterval());
        }
        HybridLogger.INSTANCE.m11i("XResourceLoader", "loadSync start load", MapsKt.mapOf(new Pair[]{TuplesKt.to("resInfo", resourceInfo.toString()), TuplesKt.to("url", uri)}), loggerContext);
        GlobalResourceInterceptor.INSTANCE.startLoad(resourceInfo, taskConfig);
        ResourceInfoWrapper resourceInfoWrapper = new ResourceInfoWrapper(resourceInfo, taskConfig);
        resourceInfoWrapper.setASync(false);
        final TaskConfig taskConfig2 = taskConfig;
        Function1<ResourceInfoWrapper, Unit> function1 = new Function1<ResourceInfoWrapper, Unit>() { // from class: com.bytedance.ies.bullet.kit.resourceloader.ResourceLoaderService$loadSync$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                invoke((ResourceInfoWrapper) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(ResourceInfoWrapper resourceInfoWrapper2) {
                Intrinsics.checkNotNullParameter(resourceInfoWrapper2, "it");
                objectRef.element = resourceInfoWrapper2.getInfo();
                JSONObject metrics3 = resourceInfo.getPerformanceInfo().getMetrics();
                if (metrics3 != null) {
                    metrics3.put(RLMonitorReporter.MEMORY_RESOLVE, timeInterval.getTimeInterval());
                }
                JSONObject metrics4 = resourceInfo.getPerformanceInfo().getMetrics();
                if (metrics4 != null) {
                    metrics4.put(RLMonitorReporter.TOTAL, timeInterval.getTotalTime());
                }
                GlobalResourceInterceptor globalResourceInterceptor = GlobalResourceInterceptor.INSTANCE;
                Object obj2 = objectRef.element;
                Intrinsics.checkNotNull(obj2);
                globalResourceInterceptor.loadSuccess((ResourceInfo) obj2, taskConfig2);
                HybridLogger.INSTANCE.m11i("XResourceLoader", "sync fetch successfully", MapsKt.mapOf(new Pair[]{TuplesKt.to("url", uri), TuplesKt.to("ppl", resourceInfoWrapper2.getInfo().getPipelineStatus().toString())}), loggerContext);
                RLMonitorReporter.INSTANCE.reportSuccess(this.getResourceConfig(), resourceInfoWrapper2.getInfo(), taskConfig2, SystemClock.elapsedRealtime() - resourceInfo.getStartLoadTime());
                RLMonitorReporter.INSTANCE.reportPerformance(this.getResourceConfig(), taskConfig2, resourceInfo, "success");
                if (resourceInfoWrapper2.getInfo().getFrom() != ResourceFrom.GECKO || resourceInfo.getCacheKey() == null) {
                    return;
                }
                if (taskConfig2.getIsPreload()) {
                    resourceInfoWrapper2.getInfo().setFrom(ResourceFrom.PRELOAD);
                }
                MemoryManager.INSTANCE.getInstance().updateResourceInfo(ResourceLoaderUtils.INSTANCE.createCacheKey(resourceInfoWrapper2.getInfo(), taskConfig2), resourceInfo);
            }
        };
        final TaskConfig taskConfig3 = taskConfig;
        createLoaderChain.load(resourceInfoWrapper, function1, new Function1<Throwable, Unit>() { // from class: com.bytedance.ies.bullet.kit.resourceloader.ResourceLoaderService$loadSync$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                invoke((Throwable) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(Throwable th2) {
                Intrinsics.checkNotNullParameter(th2, "it");
                HybridLogger.INSTANCE.m9e("XResourceLoader", "sync fetch failed", MapsKt.mapOf(new Pair[]{TuplesKt.to("url", uri), TuplesKt.to("ppl", resourceInfo.getPipelineStatus().toString()), TuplesKt.to("taskConfig", taskConfig3.toString()), TuplesKt.to("error", th2.getMessage())}), loggerContext);
                JSONObject metrics3 = resourceInfo.getPerformanceInfo().getMetrics();
                if (metrics3 != null) {
                    metrics3.put(RLMonitorReporter.TOTAL, timeInterval.getTotalTime());
                }
                RLMonitorReporter rLMonitorReporter = RLMonitorReporter.INSTANCE;
                ResourceLoaderConfig resourceConfig = this.getResourceConfig();
                ResourceInfo resourceInfo2 = resourceInfo;
                TaskConfig taskConfig4 = taskConfig3;
                String message = th2.getMessage();
                if (message == null) {
                    message = "";
                }
                rLMonitorReporter.reportFailed(resourceConfig, resourceInfo2, taskConfig4, message);
                RLMonitorReporter.INSTANCE.reportPerformance(this.getResourceConfig(), taskConfig3, resourceInfo, SccResult.MESSAGE_FAIL);
                GlobalResourceInterceptor.INSTANCE.loadFailed(resourceInfo, taskConfig3, th2);
            }
        });
        String jSONArray = resourceInfo.getPipelineStatus().toString();
        Intrinsics.checkNotNullExpressionValue(jSONArray, "resInfo.pipelineStatus.toString()");
        config.setPipelineInfo(jSONArray);
        return (ResourceInfo) objectRef.element;
    }

    private final String dealPrefix(String str) {
        if (StringsKt.lastIndexOf$default(str, "/", 0, false, 6, (Object) null) != str.length() - 1) {
            return str;
        }
        int length = str.length() - 1;
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String substring = str.substring(0, length);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ void dealConfigAndResourceInfo$anniex_release$default(ResourceLoaderService resourceLoaderService, String str, ResourceInfo resourceInfo, TaskConfig taskConfig, TimeInterval timeInterval, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dealConfigAndResourceInfo");
        }
        if ((i & 16) != 0) {
            z = false;
        }
        resourceLoaderService.dealConfigAndResourceInfo$anniex_release(str, resourceInfo, taskConfig, timeInterval, z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0194, code lost:
    
        if ((r18.getBundle().length() == 0) != false) goto L59;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void dealConfigAndResourceInfo$anniex_release(String uri, ResourceInfo resInfo, TaskConfig config, TimeInterval interval, boolean skipGeckoInfo) {
        String uriWithoutQuery;
        Object obj;
        String str = uri;
        Intrinsics.checkNotNullParameter(str, "uri");
        Intrinsics.checkNotNullParameter(resInfo, "resInfo");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(interval, EventConstants.PARAM_SOURCE_INTERVAL);
        Uri srcUri = resInfo.getSrcUri();
        if (!srcUri.isHierarchical()) {
            srcUri = null;
        }
        boolean z = true;
        if (srcUri != null) {
            if (srcUri.getQueryParameter("disable_builtin") != null) {
                config.setUseAssetsLoader(!Intrinsics.areEqual(r2, "1"));
            }
            if (srcUri.getQueryParameter(SchemaConstants.QUERY_KEY_DISABLE_OFFLINE) != null) {
                config.setUseGeckoLoader(!Intrinsics.areEqual(r2, "1"));
            } else {
                if (srcUri.getQueryParameter("disable_gecko") != null) {
                    config.setUseGeckoLoader(!Intrinsics.areEqual(r0, "1"));
                }
            }
        }
        if (LoaderUtil.INSTANCE.isNotNullOrEmpty(config.getCdnUrl())) {
            String safeGetQueryParameter = ResourceLoaderUtils.INSTANCE.safeGetQueryParameter("need_common_params", resInfo.getSrcUri());
            RLLogger.INSTANCE.m21d("needCommonParams " + safeGetQueryParameter);
            if (safeGetQueryParameter != null) {
                HybridSecureUtil hybridSecureUtil = HybridSecureUtil.INSTANCE;
                Uri parse = Uri.parse(config.getCdnUrl());
                Intrinsics.checkExpressionValueIsNotNull(parse, "Uri.parse(this)");
                if (hybridSecureUtil.inCommonParamsAllowList(parse)) {
                    Uri parse2 = Uri.parse(config.getCdnUrl());
                    Intrinsics.checkExpressionValueIsNotNull(parse2, "Uri.parse(this)");
                    String uri2 = parse2.buildUpon().appendQueryParameter("need_common_params", safeGetQueryParameter).build().toString();
                    Intrinsics.checkNotNullExpressionValue(uri2, "config.cdnUrl.toUri().bu…              .toString()");
                    config.setCdnUrl(uri2);
                } else {
                    Uri parse3 = Uri.parse(config.getCdnUrl());
                    Intrinsics.checkExpressionValueIsNotNull(parse3, "Uri.parse(this)");
                    String uri3 = SchemaUtilsKt.removeQueryParameterSafely(parse3, "need_common_params").buildUpon().appendQueryParameter("need_common_params", ViewVisibleBridge.INVISIBLE).build().toString();
                    Intrinsics.checkNotNullExpressionValue(uri3, "config.cdnUrl.toUri()\n  …              .toString()");
                    config.setCdnUrl(uri3);
                }
            } else {
                Uri parse4 = Uri.parse(config.getCdnUrl());
                Intrinsics.checkExpressionValueIsNotNull(parse4, "Uri.parse(this)");
                String uri4 = parse4.buildUpon().appendQueryParameter("need_common_params", ViewVisibleBridge.INVISIBLE).build().toString();
                Intrinsics.checkNotNullExpressionValue(uri4, "config.cdnUrl.toUri().bu…              .toString()");
                config.setCdnUrl(uri4);
            }
        }
        if ((config.getAccessKey().length() == 0) && !skipGeckoInfo) {
            try {
                Result.Companion companion = Result.Companion;
                String queryParameter = resInfo.getSrcUri().getQueryParameter("accessKey");
                if (queryParameter == null) {
                    queryParameter = "";
                }
                obj = Result.constructor-impl(queryParameter);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (Result.isFailure-impl(obj)) {
                obj = "";
            }
            config.setAccessKey((String) obj);
            if (config.getAccessKey().length() == 0) {
                config.setAccessKey(getResourceConfig().getDftGeckoCfg().getAccessKey());
            }
        }
        if (!(config.getChannel().length() == 0)) {
        }
        if (!skipGeckoInfo) {
            ChannelBundleParser channelBundleParser = ChannelBundleParser.INSTANCE;
            if (config.getCdnUrl().length() > 0) {
                str = config.getCdnUrl();
            }
            RLChannelBundleModel parse5 = channelBundleParser.parse(str, getResourceConfig(), config.getBid(), false, config);
            String provideChannel = parse5 != null ? parse5.provideChannel() : null;
            if (provideChannel == null) {
                provideChannel = "";
            }
            config.setChannel(provideChannel);
            String providerBundlePath = parse5 != null ? parse5.providerBundlePath() : null;
            config.setBundle(providerBundlePath != null ? providerBundlePath : "");
        }
        HybridLogger hybridLogger = HybridLogger.INSTANCE;
        Map<String, ? extends Object> mapOf = MapsKt.mapOf(new Pair[]{TuplesKt.to("channel", config.getChannel()), TuplesKt.to(SchemaConstants.QUERY_KEY_BUNDLE, config.getBundle()), TuplesKt.to("skipGeckoInfo", Boolean.valueOf(skipGeckoInfo))});
        LoggerContext loggerContext = new LoggerContext();
        loggerContext.pushStage(RLLoggerConstant.RESOURCE_SESSION, config.getResourceLoaderSession());
        Unit unit = Unit.INSTANCE;
        hybridLogger.m11i("XResourceLoader", "show channel bundle", mapOf, loggerContext);
        if (!Intrinsics.areEqual(resInfo.getSrcUri().getQueryParameter(KEY_ONLY_LOCAL), "1") && !config.getOnlyLocal()) {
            z = false;
        }
        config.setOnlyLocal(z);
        config.setEnableNegotiation(getResourceConfig().getEnableNegotiation());
        JSONObject metrics = resInfo.getPerformanceInfo().getMetrics();
        if (metrics != null) {
            metrics.put(RLMonitorReporter.PARSE, interval.getTimeInterval());
        }
        RLReportInfo performanceInfo = resInfo.getPerformanceInfo();
        if (LoaderUtil.INSTANCE.isNotNullOrEmpty(config.getCdnUrl())) {
            uriWithoutQuery = config.getCdnUrl();
        } else {
            uriWithoutQuery = LoaderUtil.INSTANCE.getUriWithoutQuery(resInfo.getSrcUri());
        }
        performanceInfo.setUrl(uriWithoutQuery);
    }

    public LoadTask loadAsync(final String uri, final TaskConfig config, final Function1<? super ResourceInfo, Unit> resolve, final Function1<? super Throwable, Unit> reject) {
        String createResourceLoaderSession;
        TaskConfig taskConfig;
        String str;
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(resolve, "resolve");
        Intrinsics.checkNotNullParameter(reject, "reject");
        createResourceLoaderSession = ResourceLoaderServiceKt.createResourceLoaderSession();
        config.setResourceLoaderSession(createResourceLoaderSession);
        final LoggerContext loggerContext = new LoggerContext();
        loggerContext.pushStage(RLLoggerConstant.RESOURCE_SESSION, config.getResourceLoaderSession());
        HybridLogger.INSTANCE.m11i("XResourceLoader", "ResourceLoader start load", MapsKt.mapOf(new Pair[]{TuplesKt.to("url", uri), TuplesKt.to("config", config.toString()), TuplesKt.to("type", "async")}), loggerContext);
        ResourceLoaderConfig resourceConfig = getResourceConfig();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Uri parse = Uri.parse(uri);
        final TimeInterval timeInterval = new TimeInterval();
        config.setBid(getBid());
        final LoadTask loadTask = new LoadTask(parse, 0, null);
        if (ResourceLoader.INSTANCE.getApplication() == null) {
            RLLogger.INSTANCE.m22e("ResourceLoader_Async service not init ");
            reject.invoke(new Throwable("resource loader service not init"));
            return loadTask;
        }
        if (!parse.isHierarchical()) {
            RLLogger.INSTANCE.m22e("ResourceLoader_Async url: " + parse + " is not hierarchical url ");
            reject.invoke(new Throwable("is not hierarchical url"));
            return loadTask;
        }
        HybridLogger.INSTANCE.m11i("XResourceLoader", "start async fetch", MapsKt.mapOf(new Pair[]{TuplesKt.to("url", uri), TuplesKt.to("taskConfig", config.toString())}), loggerContext);
        if (resourceConfig.getCaptureFrequency() > 0) {
            this.perfFrequency = (this.perfFrequency + 1) % resourceConfig.getCaptureFrequency();
        }
        Uri hookUrl = GlobalResourceInterceptor.INSTANCE.hookUrl(uri, config);
        if (hookUrl == null) {
            hookUrl = parse;
        }
        Intrinsics.checkNotNullExpressionValue(hookUrl, "GlobalResourceIntercepto…Url(uri,config) ?: srcUri");
        final ResourceInfo resourceInfo = new ResourceInfo(hookUrl, null, null, null, false, 0L, false, null, null, null, elapsedRealtime, null, 3070, null);
        if (this.perfFrequency == 0 || !StatisticFilter.INSTANCE.checkSample(resourceConfig, uri)) {
            resourceInfo.getPerformanceInfo().setMetrics(new JSONObject());
        } else {
            resourceInfo.getPerformanceInfo().setMetrics(null);
        }
        resourceInfo.setResTag(config.getResTag());
        dealConfigAndResourceInfo$anniex_release$default(this, uri, resourceInfo, config, timeInterval, false, 16, null);
        GeckoConfig geckoConfig = resourceConfig.getGeckoConfig(config.getAccessKey());
        if (resourceConfig.getEnableRemoteConfig()) {
            ILoaderDepender loaderDepender = geckoConfig.getLoaderDepender();
            Intrinsics.checkNotNullExpressionValue(parse, "srcUri");
            taskConfig = loaderDepender.mergeConfig(parse, config);
        } else {
            taskConfig = config;
        }
        resourceInfo.setEnableMemory(enableMemoryCache(resourceInfo.getSrcUri(), taskConfig));
        resourceInfo.setMemoryCachePriority(ResourceLoaderUtils.INSTANCE.safeGetQueryParameter("memory_cache_priority", resourceInfo.getSrcUri()));
        JSONObject metrics = resourceInfo.getPerformanceInfo().getMetrics();
        if (metrics != null) {
            metrics.put(RLMonitorReporter.PARSE, timeInterval.getTimeInterval());
        }
        ResourceLoaderChain createLoaderChain = createLoaderChain(resourceInfo.getSrcUri(), taskConfig);
        HybridLogger.INSTANCE.m11i("XResourceLoader", "loadAsync create loader chain", MapsKt.mapOf(new Pair[]{TuplesKt.to("loaderChain", createLoaderChain.toLoaderStrList()), TuplesKt.to("url", uri)}), loggerContext);
        resourceInfo.setLoaders(createLoaderChain.toLoaderStrList());
        JSONObject metrics2 = resourceInfo.getPerformanceInfo().getMetrics();
        if (metrics2 != null) {
            str = "XResourceLoader";
            metrics2.put(RLMonitorReporter.CREATE_PIPELINE, timeInterval.getTimeInterval());
        } else {
            str = "XResourceLoader";
        }
        resourceInfo.setCacheKey(ResourceLoaderUtils.INSTANCE.createCacheKey(resourceInfo, taskConfig));
        JSONObject metrics3 = resourceInfo.getPerformanceInfo().getMetrics();
        if (metrics3 != null) {
            metrics3.put(RLMonitorReporter.CONFIG_MERGE, timeInterval.getTimeInterval());
        }
        HybridLogger.INSTANCE.m11i(str, "loadAsync start load", MapsKt.mapOf(new Pair[]{TuplesKt.to("resInfo", resourceInfo.toString()), TuplesKt.to("url", uri), TuplesKt.to("taskConfig", config.toString())}), loggerContext);
        GlobalResourceInterceptor.INSTANCE.startLoad(resourceInfo, taskConfig);
        ResourceInfoWrapper resourceInfoWrapper = new ResourceInfoWrapper(resourceInfo, taskConfig);
        resourceInfoWrapper.setASync(true);
        final TaskConfig taskConfig2 = taskConfig;
        final TaskConfig taskConfig3 = taskConfig;
        createLoaderChain.load(resourceInfoWrapper, new Function1<ResourceInfoWrapper, Unit>() { // from class: com.bytedance.ies.bullet.kit.resourceloader.ResourceLoaderService$loadAsync$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ResourceInfoWrapper) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(ResourceInfoWrapper resourceInfoWrapper2) {
                Map map;
                Intrinsics.checkNotNullParameter(resourceInfoWrapper2, "it");
                map = ResourceLoaderService.this.taskMap;
                map.remove(loadTask);
                timeInterval.getTimeInterval();
                TaskConfig taskConfig4 = config;
                String jSONArray = resourceInfo.getPipelineStatus().toString();
                Intrinsics.checkNotNullExpressionValue(jSONArray, "resInfo.pipelineStatus.toString()");
                taskConfig4.setPipelineInfo(jSONArray);
                GlobalResourceInterceptor.INSTANCE.loadSuccess(resourceInfoWrapper2.getInfo(), taskConfig2);
                long elapsedRealtime2 = SystemClock.elapsedRealtime() - resourceInfo.getStartLoadTime();
                JSONObject metrics4 = resourceInfo.getPerformanceInfo().getMetrics();
                if (metrics4 != null) {
                    metrics4.put(RLMonitorReporter.MEMORY_RESOLVE, timeInterval.getTimeInterval());
                }
                JSONObject metrics5 = resourceInfo.getPerformanceInfo().getMetrics();
                if (metrics5 != null) {
                    metrics5.put(RLMonitorReporter.TOTAL, timeInterval.getTotalTime());
                }
                HybridLogger.INSTANCE.m11i("XResourceLoader", "async fetch successfully", MapsKt.mapOf(new Pair[]{TuplesKt.to("url", uri), TuplesKt.to("ppl", resourceInfoWrapper2.getInfo().getPipelineStatus().toString())}), loggerContext);
                resolve.invoke(resourceInfoWrapper2.getInfo());
                RLMonitorReporter.INSTANCE.reportSuccess(ResourceLoaderService.this.getResourceConfig(), resourceInfoWrapper2.getInfo(), taskConfig2, elapsedRealtime2);
                RLMonitorReporter.INSTANCE.reportPerformance(ResourceLoaderService.this.getResourceConfig(), taskConfig2, resourceInfo, "success");
                if (resourceInfo.getCacheKey() == null || !config.getEnableCached()) {
                    return;
                }
                if (Intrinsics.areEqual(resourceInfo.getResTag(), "template") || Intrinsics.areEqual(resourceInfo.getResTag(), "external_js")) {
                    MemoryManager.INSTANCE.getInstance().updateResourceInfo(ResourceLoaderUtils.INSTANCE.createCacheKey(resourceInfoWrapper2.getInfo(), taskConfig2), resourceInfo);
                }
            }
        }, new Function1<Throwable, Unit>() { // from class: com.bytedance.ies.bullet.kit.resourceloader.ResourceLoaderService$loadAsync$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Throwable th) {
                Map map;
                Intrinsics.checkNotNullParameter(th, "it");
                JSONObject metrics4 = ResourceInfo.this.getPerformanceInfo().getMetrics();
                if (metrics4 != null) {
                    metrics4.put(RLMonitorReporter.TOTAL, timeInterval.getTotalTime());
                }
                map = this.taskMap;
                map.remove(loadTask);
                TaskConfig taskConfig4 = config;
                String jSONArray = ResourceInfo.this.getPipelineStatus().toString();
                Intrinsics.checkNotNullExpressionValue(jSONArray, "resInfo.pipelineStatus.toString()");
                taskConfig4.setPipelineInfo(jSONArray);
                GlobalResourceInterceptor.INSTANCE.loadFailed(ResourceInfo.this, taskConfig3, th);
                HybridLogger.INSTANCE.m11i("XResourceLoader", "async fetch failed", MapsKt.mapOf(new Pair[]{TuplesKt.to("url", uri), TuplesKt.to("ppl", ResourceInfo.this.getPipelineStatus().toString()), TuplesKt.to("taskConfig", taskConfig3.toString()), TuplesKt.to("error", th.getMessage())}), loggerContext);
                reject.invoke(th);
                RLMonitorReporter rLMonitorReporter = RLMonitorReporter.INSTANCE;
                ResourceLoaderConfig resourceConfig2 = this.getResourceConfig();
                ResourceInfo resourceInfo2 = ResourceInfo.this;
                TaskConfig taskConfig5 = taskConfig3;
                String message = th.getMessage();
                if (message == null) {
                    message = "";
                }
                rLMonitorReporter.reportFailed(resourceConfig2, resourceInfo2, taskConfig5, message);
                RLMonitorReporter.INSTANCE.reportPerformance(this.getResourceConfig(), taskConfig3, ResourceInfo.this, SccResult.MESSAGE_FAIL);
            }
        });
        this.taskMap.put(loadTask, createLoaderChain);
        return loadTask;
    }

    public void deleteResource(ResourceInfo info) {
        ResourceFrom from;
        Intrinsics.checkNotNullParameter(info, "info");
        RLLogger.INSTANCE.m21d("deleteResource " + info);
        if (IConditionCallKt.enableLynx100ErrorFix() && (info instanceof ForestResourceInfo)) {
            from = ((ForestResourceInfo) info).getOriginFrom();
        } else {
            from = info.getFrom();
        }
        if (from == ResourceFrom.GECKO) {
            try {
                RLLogger.INSTANCE.m21d("deleteResource gecko");
                MemoryManager.INSTANCE.getInstance().clearCacheWithKey(info);
                ILoaderDepender loaderDepender = getResourceConfig().getGeckoConfig(info.getAccessKey()).getLoaderDepender();
                TaskConfig taskConfig = new TaskConfig(info.getAccessKey());
                taskConfig.setChannel(info.getChannel());
                loaderDepender.deleteChannel(taskConfig);
                return;
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        if (from == ResourceFrom.CDN) {
            RLLogger.INSTANCE.m21d("deleteResource cdn");
            try {
                String filePath = info.getFilePath();
                if (filePath != null) {
                    File file = new File(filePath);
                    RLLogger.INSTANCE.m21d("deleteResource gecko " + info.getFilePath());
                    if (file.exists()) {
                        file.delete();
                    }
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public final void cancel(LoadTask task) {
        Intrinsics.checkNotNullParameter(task, "task");
        ResourceLoaderChain resourceLoaderChain = this.taskMap.get(task);
        if (resourceLoaderChain != null) {
            resourceLoaderChain.cancel();
        }
        this.taskMap.remove(task);
    }
}
