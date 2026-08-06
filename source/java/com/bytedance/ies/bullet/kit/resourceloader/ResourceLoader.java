package com.bytedance.ies.bullet.kit.resourceloader;

import android.app.Application;
import com.bytedance.ies.bullet.forest.ForestConfigCenter;
import com.bytedance.ies.bullet.kit.resourceloader.loggger.RLLogger;
import com.bytedance.ies.bullet.kit.resourceloader.memory.MemoryManager;
import com.bytedance.ies.bullet.kit.resourceloader.model.ResourceLoaderEnvData;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.ies.bullet.service.base.resourceloader.config.IXResourceLoader;
import com.bytedance.ies.bullet.service.base.resourceloader.config.ResourceLoaderConfig;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResourceLoader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013J\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004J\b\u0010\u0018\u001a\u0004\u0018\u00010\u0010J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0005\u001a\u00020\u0006J\u001e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0016\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010 \u001a\u00020\u001a2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010!\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0013J4\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00062\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130(H\u0007J\u001c\u0010)\u001a\u00020\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\b0\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/bytedance/ies/bullet/kit/resourceloader/ResourceLoader;", "", "()V", "application", "Landroid/app/Application;", "isDebug", "", "placeHolder", "Lcom/bytedance/ies/bullet/kit/resourceloader/ResourceLoaderService;", "preloadLoader", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/IXResourceLoader;", "getPreloadLoader", "()Lcom/bytedance/ies/bullet/service/base/resourceloader/config/IXResourceLoader;", "setPreloadLoader", "(Lcom/bytedance/ies/bullet/service/base/resourceloader/config/IXResourceLoader;)V", "resourceLoaderEnvData", "Lcom/bytedance/ies/bullet/kit/resourceloader/model/ResourceLoaderEnvData;", "rlsMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "containsBid", "bid", "fallback", "getApplication", "getResourceLoaderEnvData", EventConstants.PARAM_SOURCE_INIT, "", "register", "service", "config", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/ResourceLoaderConfig;", "setDebug", "setResourceLoaderEnvData", "unRegister", "updateResourceLoaderConfig", "enableMem", "memSize", "", "enableRemoteConfig", "prefix2ak", "", "with", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ResourceLoader {
    private static Application application;
    private static boolean isDebug;
    private static IXResourceLoader preloadLoader;
    private static ResourceLoaderEnvData resourceLoaderEnvData;
    public static final ResourceLoader INSTANCE = new ResourceLoader();
    private static ConcurrentHashMap<String, ResourceLoaderService> rlsMap = new ConcurrentHashMap<>();
    private static ResourceLoaderService placeHolder = new ResourceLoaderService() { // from class: com.bytedance.ies.bullet.kit.resourceloader.ResourceLoader$placeHolder$1
        @Override // com.bytedance.ies.bullet.kit.resourceloader.ResourceLoaderService
        public ResourceInfo loadSync(String uri, TaskConfig config) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            Intrinsics.checkNotNullParameter(config, "config");
            RLLogger.INSTANCE.m22e("placeHolder loadSync " + uri);
            return null;
        }

        @Override // com.bytedance.ies.bullet.kit.resourceloader.ResourceLoaderService
        public LoadTask loadAsync(String uri, TaskConfig config, Function1<? super ResourceInfo, Unit> resolve, Function1<? super Throwable, Unit> reject) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            Intrinsics.checkNotNullParameter(config, "config");
            Intrinsics.checkNotNullParameter(resolve, "resolve");
            Intrinsics.checkNotNullParameter(reject, "reject");
            RLLogger.INSTANCE.m22e("placeHolder loadAsync " + uri);
            reject.invoke(new Throwable("rl not init"));
            return new LoadTask(null, 0, null, 7, null);
        }
    };

    private ResourceLoader() {
    }

    public final void init(Application application2, boolean z) {
        Intrinsics.checkNotNullParameter(application2, "application");
        RLLogger.INSTANCE.m21d("init ResourceLoader");
        application = application2;
        setDebug(z);
    }

    @JvmStatic
    public static final void updateResourceLoaderConfig(boolean enableMem, int memSize, boolean enableRemoteConfig, Map<String, String> prefix2ak) {
        Intrinsics.checkNotNullParameter(prefix2ak, "prefix2ak");
        Iterator<Map.Entry<String, ResourceLoaderService>> it = rlsMap.entrySet().iterator();
        while (it.hasNext()) {
            ResourceLoaderConfig resourceConfig = it.next().getValue().getResourceConfig();
            resourceConfig.setEnableMemCache(enableMem);
            resourceConfig.setMaxMem(memSize);
            resourceConfig.setEnableRemoteConfig(enableRemoteConfig);
            resourceConfig.getDefaultPrefix2Ak().putAll(prefix2ak);
        }
    }

    public final void register(String bid, ResourceLoaderConfig config) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(config, "config");
        RLLogger.INSTANCE.m21d("register ResourceLoader with " + bid);
        ForestConfigCenter.INSTANCE.register(bid, config);
        ConcurrentHashMap<String, ResourceLoaderService> concurrentHashMap = rlsMap;
        ResourceLoaderService resourceLoaderService = new ResourceLoaderService();
        resourceLoaderService.setBid(bid);
        resourceLoaderService.setConfig(config);
        resourceLoaderService.registerGeckoConfig(config.getDftGeckoCfg().getAccessKey(), config.getDftGeckoCfg());
        concurrentHashMap.put(bid, resourceLoaderService);
        MemoryManager.INSTANCE.getInstance().init(config.getMaxMem());
    }

    public final void register(String bid, ResourceLoaderService service, ResourceLoaderConfig config) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(config, "config");
        RLLogger.INSTANCE.m21d("register ResourceLoader with " + bid);
        ForestConfigCenter.INSTANCE.register(bid, config);
        ConcurrentHashMap<String, ResourceLoaderService> concurrentHashMap = rlsMap;
        service.setBid(bid);
        service.setConfig(config);
        service.registerGeckoConfig(config.getDftGeckoCfg().getAccessKey(), config.getDftGeckoCfg());
        concurrentHashMap.put(bid, service);
        MemoryManager.INSTANCE.getInstance().init(config.getMaxMem());
    }

    public final void unRegister(String bid) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        RLLogger.INSTANCE.m21d("ResourceLoader unRegister with " + bid);
        rlsMap.remove(bid);
    }

    public static /* synthetic */ ResourceLoaderService with$default(ResourceLoader resourceLoader, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "default_bid";
        }
        if ((i & 2) != 0) {
            str2 = "default_bid";
        }
        return resourceLoader.with(str, str2);
    }

    public final ResourceLoaderService with(String bid, String fallback) {
        Intrinsics.checkNotNullParameter(fallback, "fallback");
        ResourceLoaderService resourceLoaderService = rlsMap.get(bid);
        if (resourceLoaderService != null) {
            return resourceLoaderService;
        }
        ResourceLoaderService resourceLoaderService2 = rlsMap.get(fallback);
        return resourceLoaderService2 == null ? placeHolder : resourceLoaderService2;
    }

    public static /* synthetic */ boolean containsBid$default(ResourceLoader resourceLoader, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "default_bid";
        }
        return resourceLoader.containsBid(str, str2);
    }

    public final boolean containsBid(String bid, String fallback) {
        Intrinsics.checkNotNullParameter(fallback, "fallback");
        ConcurrentHashMap<String, ResourceLoaderService> concurrentHashMap = rlsMap;
        if (concurrentHashMap != null) {
            return concurrentHashMap.containsKey(bid) || rlsMap.containsKey(fallback);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
    }

    public final Application getApplication() {
        return application;
    }

    public final boolean isDebug() {
        return isDebug;
    }

    public final void setDebug(boolean isDebug2) {
        isDebug = isDebug2;
    }

    public final void setResourceLoaderEnvData(ResourceLoaderEnvData resourceLoaderEnvData2) {
        Intrinsics.checkNotNullParameter(resourceLoaderEnvData2, "resourceLoaderEnvData");
        resourceLoaderEnvData = resourceLoaderEnvData2;
    }

    public final ResourceLoaderEnvData getResourceLoaderEnvData() {
        return resourceLoaderEnvData;
    }

    public final IXResourceLoader getPreloadLoader() {
        return preloadLoader;
    }

    public final void setPreloadLoader(IXResourceLoader iXResourceLoader) {
        preloadLoader = iXResourceLoader;
    }
}
