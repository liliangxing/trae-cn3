package com.bytedance.ies.bullet.prefetchv2;

import android.content.Context;
import android.net.Uri;
import com.bytedance.ies.bullet.kit.resourceloader.loader.LoaderUtil;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.settings.IBulletSettingsService;
import com.bytedance.ies.bullet.service.base.settings.PineappleConfig;
import com.bytedance.ies.bullet.service.base.standard.StandardServiceManager;
import com.bytedance.ies.bullet.service.base.utils.BulletLoadUriIdentifier;
import com.bytedance.ies.bullet.service.schema.ISchemaData;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PrefetchV2.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0014\u001a\u00020\u0015J\u0015\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0000¢\u0006\u0002\b\u0019J\u0015\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cH\u0000¢\u0006\u0002\b\u001dJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0017\u001a\u00020\u0018J \u0010 \u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\u0006J<\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010&2\b\b\u0002\u0010$\u001a\u00020\u00062\u0006\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020&J\u001a\u0010*\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00010+2\u0006\u0010\"\u001a\u00020#J\u0010\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010.\u001a\u00020\u00152\u0006\u0010/\u001a\u000200J\u0016\u0010.\u001a\u00020\u00152\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202J$\u00103\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020#2\n\b\u0002\u00104\u001a\u0004\u0018\u0001052\b\b\u0002\u0010)\u001a\u00020&JO\u00106\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020#2\n\b\u0002\u00104\u001a\u0004\u0018\u0001052\b\b\u0002\u0010)\u001a\u00020&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(2\n\b\u0002\u00107\u001a\u0004\u0018\u0001082\n\b\u0002\u00109\u001a\u0004\u0018\u00010&H\u0000¢\u0006\u0002\b:J\u000e\u0010;\u001a\u00020\u00152\u0006\u0010<\u001a\u000202J\u0016\u0010=\u001a\u00020\u00152\u0006\u0010>\u001a\u00020&2\u0006\u0010<\u001a\u000202R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0000@\u0000X\u0081\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006?"}, d2 = {"Lcom/bytedance/ies/bullet/prefetchv2/PrefetchV2;", "", "()V", "CACHE_CAPACITY", "", "hasInit", "", "prefetchCache", "Lcom/bytedance/ies/bullet/prefetchv2/PrefetchCache;", "getPrefetchCache$anniex_release", "()Lcom/bytedance/ies/bullet/prefetchv2/PrefetchCache;", "setPrefetchCache$anniex_release", "(Lcom/bytedance/ies/bullet/prefetchv2/PrefetchCache;)V", "prefetchExecutor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "getPrefetchExecutor$anniex_release", "()Ljava/util/concurrent/ExecutorService;", "prefetchWorker", "getPrefetchWorker$anniex_release", "clearPrefetchCache", "", "deleteCache", "request", "Lcom/bytedance/ies/bullet/prefetchv2/PrefetchRequest;", "deleteCache$anniex_release", "executeInWorker", "runnable", "Ljava/lang/Runnable;", "executeInWorker$anniex_release", "getCacheByRequest", "Lcom/bytedance/ies/bullet/prefetchv2/PrefetchResult;", "getCacheBySchemaUri", "", "uri", "Landroid/net/Uri;", "memOnly", "identifierUrl", "", "schemaData", "Lcom/bytedance/ies/bullet/service/schema/ISchemaData;", "bid", "getPrefetchData", "", "getRunningPrefetchTask", "Lcom/bytedance/ies/bullet/prefetchv2/PrefetchTask;", "initialize", "context", "Landroid/content/Context;", "defaultProcessor", "Lcom/bytedance/ies/bullet/prefetchv2/PrefetchProcessor;", "prefetchBySchemaUri", "config", "Lcom/bytedance/ies/bullet/prefetchv2/PrefetchConfig;", "prefetchBySchemaUriInternal", "identifier", "Lcom/bytedance/ies/bullet/service/base/utils/BulletLoadUriIdentifier;", "pageSessionId", "prefetchBySchemaUriInternal$anniex_release", "registerDefaultProcessor", "processor", "registerPrefetchProcessor", "business", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PrefetchV2 {
    private static final int CACHE_CAPACITY = 4;
    private static volatile boolean hasInit;
    private static PrefetchCache prefetchCache;
    public static final PrefetchV2 INSTANCE = new PrefetchV2();
    private static final ExecutorService prefetchExecutor = Executors.newCachedThreadPool(new NamedThreadFactory("PrefetchV2"));
    private static final ExecutorService prefetchWorker = Executors.newFixedThreadPool(4, new NamedThreadFactory("PrefetchV2Worker"));

    private PrefetchV2() {
    }

    public final ExecutorService getPrefetchExecutor$anniex_release() {
        return prefetchExecutor;
    }

    public final ExecutorService getPrefetchWorker$anniex_release() {
        return prefetchWorker;
    }

    public final PrefetchCache getPrefetchCache$anniex_release() {
        return prefetchCache;
    }

    public final void setPrefetchCache$anniex_release(PrefetchCache prefetchCache2) {
        prefetchCache = prefetchCache2;
    }

    public static /* synthetic */ void prefetchBySchemaUri$default(PrefetchV2 prefetchV2, Uri uri, PrefetchConfig prefetchConfig, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            prefetchConfig = null;
        }
        if ((i & 4) != 0) {
            str = "default_bid";
        }
        prefetchV2.prefetchBySchemaUri(uri, prefetchConfig, str);
    }

    public final void prefetchBySchemaUri(Uri uri, PrefetchConfig config, String bid) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(bid, "bid");
        prefetchBySchemaUriInternal$anniex_release$default(this, uri, config, bid, null, null, null, 48, null);
    }

    public final void executeInWorker$anniex_release(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        prefetchWorker.execute(runnable);
    }

    public static /* synthetic */ void prefetchBySchemaUriInternal$anniex_release$default(PrefetchV2 prefetchV2, Uri uri, PrefetchConfig prefetchConfig, String str, ISchemaData iSchemaData, BulletLoadUriIdentifier bulletLoadUriIdentifier, String str2, int i, Object obj) {
        prefetchV2.prefetchBySchemaUriInternal$anniex_release(uri, (i & 2) != 0 ? null : prefetchConfig, (i & 4) != 0 ? "default_bid" : str, (i & 8) != 0 ? null : iSchemaData, (i & 16) != 0 ? null : bulletLoadUriIdentifier, (i & 32) == 0 ? str2 : null);
    }

    public final void prefetchBySchemaUriInternal$anniex_release(final Uri uri, final PrefetchConfig config, final String bid, final ISchemaData schemaData, final BulletLoadUriIdentifier identifier, final String pageSessionId) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(bid, "bid");
        prefetchExecutor.execute(new Runnable() { // from class: com.bytedance.ies.bullet.prefetchv2.PrefetchV2$prefetchBySchemaUriInternal$1
            @Override // java.lang.Runnable
            public final void run() {
                final SchemaModel schemaModel;
                PineappleConfig pineappleConfig;
                try {
                    IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
                    boolean disablePrefetch = (iBulletSettingsService == null || (pineappleConfig = (PineappleConfig) iBulletSettingsService.obtainSettings(PineappleConfig.class)) == null) ? false : pineappleConfig.getDisablePrefetch();
                    if (disablePrefetch) {
                        BulletLogger.printXDBLog$default(BulletLogger.INSTANCE, "BulletOptimize PrefetchV2 disable by settings " + disablePrefetch, null, null, 6, null);
                        return;
                    }
                    PrefetchLogger.INSTANCE.m38i("开始执行Prefetch: " + uri);
                    PrefetchCache prefetchCache$anniex_release = PrefetchV2.INSTANCE.getPrefetchCache$anniex_release();
                    if (prefetchCache$anniex_release != null) {
                        prefetchCache$anniex_release.trim();
                    }
                    ISchemaData iSchemaData = schemaData;
                    if (iSchemaData == null || (schemaModel = PrefetchSchemaKt.toSchemaModelBySchemaData(iSchemaData)) == null) {
                        schemaModel = PrefetchSchemaKt.toSchemaModel(uri, bid);
                    }
                    if (!schemaModel.getEnablePrefetch()) {
                        PrefetchLogger.INSTANCE.m39w("未添加enable_prefetch参数，不发起预取请求: " + uri);
                        return;
                    }
                    PrefetchLoggerKt.debugPrint(new Function0<String>() { // from class: com.bytedance.ies.bullet.prefetchv2.PrefetchV2$prefetchBySchemaUriInternal$1.1
                        {
                            super(0);
                        }

                        public final String invoke() {
                            return "Prefetch QueryItems: " + SchemaModel.this.getRawData().getQueryItems();
                        }
                    });
                    final PrefetchConfig prefetchConfig = config;
                    if (prefetchConfig == null) {
                        Uri uri2 = uri;
                        String business = schemaModel.getBusiness();
                        String str = bid;
                        BulletLoadUriIdentifier bulletLoadUriIdentifier = identifier;
                        prefetchConfig = ConfigLoaderKt.loadConfig(uri2, business, str, bulletLoadUriIdentifier != null ? bulletLoadUriIdentifier.getIdentifierUrl() : null);
                    }
                    if (prefetchConfig == null) {
                        return;
                    }
                    prefetchConfig.setBid(bid);
                    String str2 = pageSessionId;
                    if (str2 != null) {
                        PrefetchSessionManager.INSTANCE.getOrCreateContext(str2).setPrefetchConfig(prefetchConfig);
                    }
                    PrefetchLoggerKt.debugPrint(new Function0<String>() { // from class: com.bytedance.ies.bullet.prefetchv2.PrefetchV2$prefetchBySchemaUriInternal$1.4
                        {
                            super(0);
                        }

                        public final String invoke() {
                            StringBuilder sb = new StringBuilder("配置加载结果: ");
                            PrefetchConfig prefetchConfig2 = PrefetchConfig.this;
                            return sb.append(prefetchConfig2 != null ? prefetchConfig2.toJson() : null).append(", from: ").append(PrefetchConfig.this.getConfigFrom()).toString();
                        }
                    });
                    if (prefetchConfig.getApis().isEmpty()) {
                        PrefetchLogger.INSTANCE.m37e("Prefetch请求配置为空");
                        return;
                    }
                    for (final PrefetchRequestConfig prefetchRequestConfig : prefetchConfig.getApis()) {
                        final PrefetchRequest from = PrefetchRequest.INSTANCE.from(prefetchRequestConfig, schemaModel, prefetchConfig);
                        if (from != null) {
                            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.bytedance.ies.bullet.prefetchv2.PrefetchV2$prefetchBySchemaUriInternal$1$startPrefetchRequest$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                public /* bridge */ /* synthetic */ Object invoke() {
                                    m536invoke();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: collision with other method in class */
                                public final void m536invoke() {
                                    PrefetchCache prefetchCache$anniex_release2;
                                    if (PrefetchRequestConfig.this.getClearCacheBeforeRequest() && (prefetchCache$anniex_release2 = PrefetchV2.INSTANCE.getPrefetchCache$anniex_release()) != null) {
                                        prefetchCache$anniex_release2.delete(from);
                                    }
                                    PrefetchTask prefetchTask = new PrefetchTask(schemaModel, PrefetchRequestConfig.this, from, prefetchConfig);
                                    if (from.getIsStreamLoadType()) {
                                        TaskManager.INSTANCE.removeAndFinish(from);
                                        PrefetchCache prefetchCache$anniex_release3 = PrefetchV2.INSTANCE.getPrefetchCache$anniex_release();
                                        if (prefetchCache$anniex_release3 != null) {
                                            prefetchCache$anniex_release3.delete(from);
                                        }
                                    }
                                    TaskManager.INSTANCE.enqueue(prefetchTask);
                                }
                            };
                            if (prefetchRequestConfig.getRequestIgnoreCache()) {
                                function0.invoke();
                            } else {
                                PrefetchCache prefetchCache$anniex_release2 = PrefetchV2.INSTANCE.getPrefetchCache$anniex_release();
                                if ((prefetchCache$anniex_release2 != null ? PrefetchCache.get$default(prefetchCache$anniex_release2, from, false, 2, null) : null) == null) {
                                    function0.invoke();
                                } else {
                                    PrefetchLogger.INSTANCE.m39w("缓存未过期，不进行prefetch: " + from.getUrl());
                                }
                            }
                        } else {
                            PrefetchLogger.INSTANCE.m37e("PrefetchRequest生成失败, url: " + prefetchRequestConfig.getUrl());
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    PrefetchLogger.INSTANCE.m37e(th.getMessage());
                }
            }
        });
    }

    public final PrefetchResult getCacheByRequest(PrefetchRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        PrefetchCache prefetchCache2 = prefetchCache;
        PrefetchResult prefetchResult = prefetchCache2 != null ? PrefetchCache.get$default(prefetchCache2, request, false, 2, null) : null;
        if (prefetchResult == null) {
            PrefetchLogger.INSTANCE.m39w("内存缓存查找失败: " + request.getRequestKey());
        }
        return prefetchResult;
    }

    public static /* synthetic */ List getCacheBySchemaUri$default(PrefetchV2 prefetchV2, Uri uri, String str, boolean z, ISchemaData iSchemaData, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i & 16) != 0) {
            str2 = "default_bid";
        }
        return prefetchV2.getCacheBySchemaUri(uri, str, z2, iSchemaData, str2);
    }

    public final List<PrefetchResult> getCacheBySchemaUri(Uri uri, String identifierUrl, boolean memOnly, ISchemaData schemaData, String bid) {
        PrefetchConfig prefetchConfig;
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(schemaData, "schemaData");
        Intrinsics.checkNotNullParameter(bid, "bid");
        SchemaModel schemaModelBySchemaData = PrefetchSchemaKt.toSchemaModelBySchemaData(schemaData);
        if (!schemaModelBySchemaData.getEnablePrefetch()) {
            return CollectionsKt.emptyList();
        }
        if (identifierUrl != null) {
            prefetchConfig = ConfigCache.INSTANCE.getConfigByIdentifier(identifierUrl);
            if (prefetchConfig == null) {
                prefetchConfig = ConfigCache.INSTANCE.getBySchemaUri(uri);
            }
        } else {
            prefetchConfig = null;
        }
        if (prefetchConfig == null || prefetchConfig.getApis().isEmpty()) {
            PrefetchLogger.INSTANCE.m37e("未获取到prefetch配置，无法进行globalprops注入");
            return null;
        }
        prefetchConfig.setBid(bid);
        ArrayList arrayList = new ArrayList();
        for (PrefetchRequestConfig prefetchRequestConfig : prefetchConfig.getApis()) {
            PrefetchRequest from = PrefetchRequest.INSTANCE.from(prefetchRequestConfig, schemaModelBySchemaData, prefetchConfig);
            if (from != null) {
                PrefetchCache prefetchCache2 = prefetchCache;
                PrefetchResult prefetchResult = prefetchCache2 != null ? prefetchCache2.get(from, memOnly) : null;
                if (prefetchResult != null) {
                    prefetchResult.setGlobalPropsName(prefetchRequestConfig.getGlobalPropsName());
                    arrayList.add(prefetchResult);
                }
            } else {
                PrefetchLogger.INSTANCE.m37e("PrefetchRequest创建失败: " + prefetchRequestConfig.getUrl());
            }
        }
        return arrayList;
    }

    public static /* synthetic */ List getCacheBySchemaUri$default(PrefetchV2 prefetchV2, Uri uri, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return prefetchV2.getCacheBySchemaUri(uri, z);
    }

    public final List<PrefetchResult> getCacheBySchemaUri(Uri uri, boolean memOnly) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        SchemaModel schemaModelOnlyFromCache = PrefetchSchemaKt.toSchemaModelOnlyFromCache(uri);
        if (schemaModelOnlyFromCache == null) {
            return CollectionsKt.emptyList();
        }
        if (!schemaModelOnlyFromCache.getEnablePrefetch()) {
            return CollectionsKt.emptyList();
        }
        PrefetchConfig bySchemaUri = ConfigCache.INSTANCE.getBySchemaUri(uri);
        if (bySchemaUri == null || bySchemaUri.getApis().isEmpty()) {
            PrefetchLogger.INSTANCE.m37e("未获取到prefetch配置，无法进行globalProps注入");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (PrefetchRequestConfig prefetchRequestConfig : bySchemaUri.getApis()) {
            PrefetchRequest from = PrefetchRequest.INSTANCE.from(prefetchRequestConfig, schemaModelOnlyFromCache, bySchemaUri);
            if (from != null) {
                PrefetchCache prefetchCache2 = prefetchCache;
                PrefetchResult prefetchResult = prefetchCache2 != null ? prefetchCache2.get(from, memOnly) : null;
                if (prefetchResult != null) {
                    prefetchResult.setGlobalPropsName(prefetchRequestConfig.getGlobalPropsName());
                    arrayList.add(prefetchResult);
                }
            } else {
                PrefetchLogger.INSTANCE.m37e("PrefetchRequest创建失败: " + prefetchRequestConfig.getUrl());
            }
        }
        return arrayList;
    }

    public final Map<String, Object> getPrefetchData(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        boolean z = false;
        List<PrefetchResult> cacheBySchemaUri$default = getCacheBySchemaUri$default(this, uri, false, 2, null);
        if (cacheBySchemaUri$default != null && (!cacheBySchemaUri$default.isEmpty())) {
            z = true;
        }
        if (z) {
            for (PrefetchResult prefetchResult : cacheBySchemaUri$default) {
                String globalPropsName = prefetchResult.getGlobalPropsName();
                if (globalPropsName != null && LoaderUtil.INSTANCE.isNotNullOrEmpty(globalPropsName) && prefetchResult.getBody() != null) {
                    linkedHashMap.put(globalPropsName, String.valueOf(prefetchResult.getBody()));
                }
            }
        }
        return linkedHashMap;
    }

    public final void deleteCache$anniex_release(PrefetchRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        PrefetchCache prefetchCache2 = prefetchCache;
        if (prefetchCache2 != null) {
            prefetchCache2.delete(request);
        }
    }

    public final void clearPrefetchCache() {
        PrefetchCache prefetchCache2 = prefetchCache;
        if (prefetchCache2 != null) {
            prefetchCache2.clear();
        }
    }

    public final PrefetchTask getRunningPrefetchTask(PrefetchRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return TaskManager.INSTANCE.get(request);
    }

    public final void registerPrefetchProcessor(String business, PrefetchProcessor processor) {
        Intrinsics.checkNotNullParameter(business, "business");
        Intrinsics.checkNotNullParameter(processor, "processor");
        ProcessorManager.INSTANCE.registerProcessor(business, processor);
    }

    public final void initialize(Context context, PrefetchProcessor defaultProcessor) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(defaultProcessor, "defaultProcessor");
        initialize(context);
        ProcessorManager.INSTANCE.registerDefault(defaultProcessor);
    }

    public final void initialize(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (hasInit) {
            return;
        }
        hasInit = true;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        prefetchCache = new PrefetchCache(applicationContext, 4);
    }

    public final void registerDefaultProcessor(PrefetchProcessor processor) {
        Intrinsics.checkNotNullParameter(processor, "processor");
        ProcessorManager.INSTANCE.registerDefault(processor);
    }
}
