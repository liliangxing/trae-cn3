package com.bytedance.forest.preload;

import com.bytedance.applog.server.Api;
import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.forest.Forest;
import com.bytedance.forest.model.DefaultConfig;
import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.forest.model.PreloadType;
import com.bytedance.forest.model.RequestParams;
import com.bytedance.forest.model.ResourceConfig;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.postprocessor.ForestPostProcessor;
import com.bytedance.forest.postprocessor.PostProcessParams;
import com.bytedance.forest.utils.CacheIdentifier;
import com.bytedance.forest.utils.ForestLogger;
import com.bytedance.forest.utils.IResourcePool;
import com.bytedance.forest.utils.LogUtils;
import com.bytedance.forest.utils.MemoryCacheItem;
import com.bytedance.forest.utils.MemoryManager;
import com.bytedance.forest.utils.PoolType;
import com.bytedance.forest.utils.ThreadUtils;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableImage;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: PreLoader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 +2\u00020\u0001:\u0001+B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JE\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0014\u0010\u0011\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\b0\u0012H\u0000¢\u0006\u0002\b\u0014J1\u0010\u0015\u001a\u0004\u0018\u00010\u00132\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u0016J\u0017\u0010\u0017\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0002\b\u0019J-\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0000¢\u0006\u0002\b JJ\u0010\u001a\u001a\u00020\b2\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u001eH\u0002J\u001d\u0010\u001a\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020*H\u0000¢\u0006\u0002\b R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/bytedance/forest/preload/PreLoader;", "", "forest", "Lcom/bytedance/forest/Forest;", "(Lcom/bytedance/forest/Forest;)V", "recorder", "Lcom/bytedance/forest/preload/Recorder;", "fetchCache", "", "preloadKey", "Lcom/bytedance/forest/utils/CacheIdentifier;", "ignoreWait", "", "logger", "Lcom/bytedance/forest/utils/ForestLogger;", "memoryManager", "Lcom/bytedance/forest/utils/MemoryManager;", JsCallParser.VALUE_CALLBACK, "Lkotlin/Function1;", "Lcom/bytedance/forest/preload/PreloadResult;", "fetchCache$forest_release", "fetchCacheSync", "fetchCacheSync$forest_release", "isPreloaded", Api.KEY_ENCRYPT_RESP_KEY, "isPreloaded$forest_release", "preload", "config", "Lcom/bytedance/forest/model/PreloadConfig;", "containerId", "", "sessionId", "preload$forest_release", "resourceConfig", "Lcom/bytedance/forest/model/ResourceConfig;", "scene", "Lcom/bytedance/forest/model/Scene;", "sid", "from", "ua", "url", "params", "Lcom/bytedance/forest/model/RequestParams;", "Companion", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class PreLoader {
    public static final String TAG = "PreLoader";
    private final Forest forest;
    private final Recorder recorder;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final CopyOnWriteArrayList<WeakReference<PreLoader>> preloaders = new CopyOnWriteArrayList<>();

    public PreLoader(Forest forest) {
        Intrinsics.checkParameterIsNotNull(forest, "forest");
        this.forest = forest;
        preloaders.add(new WeakReference<>(this));
        this.recorder = new Recorder(0, 0, 3, null);
    }

    /* compiled from: PreLoader.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/forest/preload/PreLoader$Companion;", "", "()V", "TAG", "", "preloaders", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/lang/ref/WeakReference;", "Lcom/bytedance/forest/preload/PreLoader;", "isPreloaded", "", Api.KEY_ENCRYPT_RESP_KEY, "Lcom/bytedance/forest/utils/CacheIdentifier;", "forest_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean isPreloaded(CacheIdentifier key) {
            Intrinsics.checkParameterIsNotNull(key, Api.KEY_ENCRYPT_RESP_KEY);
            Iterator it = PreLoader.preloaders.iterator();
            boolean z = false;
            while (it.hasNext()) {
                PreLoader preLoader = (PreLoader) ((WeakReference) it.next()).get();
                if (preLoader != null) {
                    Intrinsics.checkExpressionValueIsNotNull(preLoader, "ref.get() ?: continue");
                    z |= preLoader.isPreloaded$forest_release(key);
                }
            }
            return z;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean isPreloaded$forest_release(CacheIdentifier key) {
        Object obj;
        Boolean bool;
        boolean z;
        if (key == null) {
            return false;
        }
        try {
            Result.Companion companion = Result.Companion;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (!this.recorder.isPreloadPerformed$forest_release(key) && !this.forest.getMemoryManager().hasCache(key, PoolType.Preload)) {
            z = false;
            obj = Result.constructor-impl(Boolean.valueOf(z));
            if (Result.isFailure-impl(obj)) {
                obj = null;
            }
            bool = (Boolean) obj;
            if (bool == null) {
                return bool.booleanValue();
            }
            return false;
        }
        z = true;
        obj = Result.constructor-impl(Boolean.valueOf(z));
        if (Result.isFailure-impl(obj)) {
        }
        bool = (Boolean) obj;
        if (bool == null) {
        }
    }

    public static /* synthetic */ void preload$forest_release$default(PreLoader preLoader, PreloadConfig preloadConfig, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        preLoader.preload$forest_release(preloadConfig, str, str2);
    }

    public final void preload$forest_release(PreloadConfig config, String containerId, String sessionId) {
        Scene scene;
        Set<Map.Entry<String, List<ResourceConfig>>> entrySet;
        List<ResourceConfig> list;
        Intrinsics.checkParameterIsNotNull(config, "config");
        ResourceConfig mainResource = config.getMainResource();
        ResourceConfig mainResource2 = config.getMainResource();
        if ((mainResource2 != null ? mainResource2.getUrl() : null) == null) {
            LogUtils.i$default(LogUtils.INSTANCE, TAG, "preload with mainUrl is null", false, null, null, null, 60, null);
        } else {
            if (mainResource == null) {
                Intrinsics.throwNpe();
            }
            preload(mainResource, config.getType() == PreloadType.WEB ? Scene.WEB_MAIN_DOCUMENT : Scene.LYNX_TEMPLATE, containerId, sessionId, config.getFrom(), config.getInjectUserAgent());
        }
        if (config.getType() == PreloadType.WEB) {
            String[] strArr = {PreloadConfig.KEY_STYLESHEET, PreloadConfig.KEY_SCRIPT};
            for (int i = 0; i < 2; i++) {
                String str = strArr[i];
                Map<String, List<ResourceConfig>> subResource = config.getSubResource();
                if (subResource != null && (list = subResource.get(str)) != null) {
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        preload((ResourceConfig) it.next(), Scene.WEB_CHILD_RESOURCE, containerId, sessionId, config.getFrom(), config.getInjectUserAgent());
                    }
                }
            }
            Map<String, List<ResourceConfig>> subResource2 = config.getSubResource();
            if (subResource2 == null || (entrySet = subResource2.entrySet()) == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : entrySet) {
                if (!ArraysKt.contains(strArr, ((Map.Entry) obj).getKey())) {
                    arrayList.add(obj);
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                Iterator it3 = ((Iterable) ((Map.Entry) it2.next()).getValue()).iterator();
                while (it3.hasNext()) {
                    preload((ResourceConfig) it3.next(), Scene.WEB_CHILD_RESOURCE, containerId, sessionId, config.getFrom(), config.getInjectUserAgent());
                }
            }
            return;
        }
        Map<String, List<ResourceConfig>> subResource3 = config.getSubResource();
        if (subResource3 != null) {
            for (Map.Entry<String, List<ResourceConfig>> entry : subResource3.entrySet()) {
                String key = entry.getKey();
                int hashCode = key.hashCode();
                if (hashCode == 3148879) {
                    if (key.equals(PreloadConfig.KEY_FONT)) {
                        scene = Scene.LYNX_FONT;
                    }
                    scene = Scene.LYNX_CHILD_RESOURCE;
                } else if (hashCode == 100313435) {
                    if (key.equals("image")) {
                        scene = Scene.LYNX_IMAGE;
                    }
                    scene = Scene.LYNX_CHILD_RESOURCE;
                } else {
                    if (hashCode == 112202875 && key.equals("video")) {
                        scene = Scene.LYNX_VIDEO;
                    }
                    scene = Scene.LYNX_CHILD_RESOURCE;
                }
                Iterator<T> it4 = entry.getValue().iterator();
                while (it4.hasNext()) {
                    preload((ResourceConfig) it4.next(), scene, containerId, sessionId, config.getFrom(), config.getInjectUserAgent());
                }
            }
        }
    }

    static /* synthetic */ void preload$default(PreLoader preLoader, ResourceConfig resourceConfig, Scene scene, String str, String str2, String str3, String str4, int i, Object obj) {
        String str5;
        String str6;
        String str7;
        String str8;
        if ((i & 2) != 0) {
            scene = Scene.OTHER;
        }
        Scene scene2 = scene;
        if ((i & 4) != 0) {
            str5 = null;
        } else {
            str5 = str;
        }
        if ((i & 8) != 0) {
            str6 = null;
        } else {
            str6 = str2;
        }
        if ((i & 16) != 0) {
            str7 = null;
        } else {
            str7 = str3;
        }
        if ((i & 32) != 0) {
            str8 = null;
        } else {
            str8 = str4;
        }
        preLoader.preload(resourceConfig, scene2, str5, str6, str7, str8);
    }

    private final void preload(ResourceConfig resourceConfig, Scene scene, String containerId, String sid, String from, String ua) {
        ForestPostProcessor<?> processor = resourceConfig.getProcessor();
        PostProcessParams postProcessParams = processor != null ? new PostProcessParams(processor, scene) : new RequestParams(scene);
        postProcessParams.setPreloadFrom(from);
        postProcessParams.setInjectedUserAgent(ua);
        postProcessParams.setCustomHttpMaxAge(resourceConfig.getMaxAge());
        postProcessParams.setLoadToMemory(resourceConfig.getEnableMemoryCache());
        postProcessParams.setEnableMemoryCache(Boolean.valueOf(resourceConfig.getEnableMemoryCache()));
        postProcessParams.setDisableCdn(resourceConfig.getDisableCDN());
        if (containerId != null) {
            postProcessParams.setGroupId(containerId);
        }
        postProcessParams.setSessionId(sid);
        preload$forest_release(resourceConfig.getUrl(), postProcessParams);
    }

    public final void preload$forest_release(String url, RequestParams params) {
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(params, "params");
        final CacheIdentifier obtain = CacheIdentifier.INSTANCE.obtain(url, params, this.forest);
        if (obtain == null) {
            LogUtils.e$default(LogUtils.INSTANCE, TAG, "can not generate cache key for preload task of " + url, null, true, null, null, null, 116, null);
            return;
        }
        if (isPreloaded$forest_release(obtain)) {
            LogUtils.i$default(LogUtils.INSTANCE, TAG, "already has a preload producing or preloaded task for " + obtain, false, null, null, null, 60, null);
            return;
        }
        CallbackDelegate callbackDelegate = new CallbackDelegate(url, params.getResourceScene(), new Function0<Unit>() { // from class: com.bytedance.forest.preload.PreLoader$preload$delegate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m532invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m532invoke() {
                Recorder recorder;
                Recorder recorder2;
                recorder = PreLoader.this.recorder;
                recorder.onProducingFinish$forest_release(obtain);
                recorder2 = PreLoader.this.recorder;
                PreloadTask fetchLatestPreparingTask$forest_release = recorder2.fetchLatestPreparingTask$forest_release();
                if (fetchLatestPreparingTask$forest_release != null) {
                    PreLoader.this.preload$forest_release(fetchLatestPreparingTask$forest_release.getUrl(), fetchLatestPreparingTask$forest_release.getParams());
                }
            }
        });
        if (this.recorder.prepareToProduce$forest_release(new PreloadTask(url, params, obtain, callbackDelegate))) {
            params.setPreload$forest_release(true);
            LogUtils.i$default(LogUtils.INSTANCE, TAG, "start preload for " + obtain, false, null, null, null, 60, null);
            this.forest.fetchResourceAsync(url, params, callbackDelegate);
            return;
        }
        LogUtils.i$default(LogUtils.INSTANCE, TAG, "can not perform preload task for " + obtain + ", maybe producing queue is full, wait for someone finish", false, null, null, null, 60, null);
    }

    public final void fetchCache$forest_release(final CacheIdentifier preloadKey, final boolean ignoreWait, final ForestLogger logger, MemoryManager memoryManager, final Function1<? super PreloadResult, Unit> callback) {
        Intrinsics.checkParameterIsNotNull(logger, "logger");
        Intrinsics.checkParameterIsNotNull(memoryManager, "memoryManager");
        Intrinsics.checkParameterIsNotNull(callback, JsCallParser.VALUE_CALLBACK);
        if (preloadKey == null) {
            callback.invoke((Object) null);
            return;
        }
        this.recorder.removePreparingTask$forest_release(preloadKey);
        MemoryCacheItem cache = memoryManager.getCache(preloadKey, true);
        if (cache != null) {
            IResourcePool pool = cache.getPool();
            MemoryCacheItem memoryCacheItem = (pool != null ? pool.getType() : null) == PoolType.Preload ? cache : null;
            if (memoryCacheItem != null) {
                ForestLogger.print$default(logger, 4, TAG, "fetchCache:hit in-memory cache immediately", true, null, null, 48, null);
                callback.invoke(new PreloadResult(memoryCacheItem.getResponse(), false));
                return;
            }
        }
        PreloadTask findProducingTask$forest_release = this.recorder.findProducingTask$forest_release(preloadKey);
        if (findProducingTask$forest_release == null) {
            ForestLogger.printOptimize$default(logger, 3, TAG, true, null, null, new Function0<String>() { // from class: com.bytedance.forest.preload.PreLoader$fetchCache$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                public final String invoke() {
                    return "request reuse failed for " + CacheIdentifier.this + ", cause it is not in producing";
                }
            }, 24, null);
            callback.invoke((Object) null);
            return;
        }
        final CallbackDelegate delegate = findProducingTask$forest_release.getDelegate();
        ForestLogger.printOptimize$default(logger, 4, TAG, true, null, null, new Function0<String>() { // from class: com.bytedance.forest.preload.PreLoader$fetchCache$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final String invoke() {
                return "request reused by callbackDelegate for key:" + CacheIdentifier.this;
            }
        }, 24, null);
        synchronized (delegate) {
            if (delegate.getResponse() == null) {
                if (ignoreWait) {
                    ForestLogger.print$default(logger, 4, TAG, "fetchCache:request not finished and ignoring waiting it", true, null, null, 48, null);
                    callback.invoke((Object) null);
                    return;
                } else {
                    ForestLogger.print$default(logger, 4, TAG, "fetchCache:waiting for result", true, null, null, 48, null);
                    delegate.getListeners().add(new Function1<Response, Unit>() { // from class: com.bytedance.forest.preload.PreLoader$fetchCache$$inlined$synchronized$lambda$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((Response) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Response response) {
                            Intrinsics.checkParameterIsNotNull(response, "it");
                            callback.invoke(new PreloadResult(response, true));
                        }
                    });
                    return;
                }
            }
            SoftReference<DataSource<CloseableReference<CloseableImage>>> imageSource = delegate.getImageSource();
            DataSource<CloseableReference<CloseableImage>> dataSource = imageSource != null ? imageSource.get() : null;
            ForestLogger.print$default(logger, 4, TAG, "fetchCache:hit callbackDelegate response immediately. LynxImage=[finished:" + (dataSource != null ? dataSource.isFinished() : false) + " progress:" + (dataSource != null ? Float.valueOf(dataSource.getProgress()) : -1) + ']', true, null, null, 48, null);
            Response response = delegate.getResponse();
            if (response == null) {
                Intrinsics.throwNpe();
            }
            callback.invoke(new PreloadResult(response, false));
        }
    }

    public final PreloadResult fetchCacheSync$forest_release(final CacheIdentifier preloadKey, boolean ignoreWait, ForestLogger logger, MemoryManager memoryManager) {
        Intrinsics.checkParameterIsNotNull(logger, "logger");
        Intrinsics.checkParameterIsNotNull(memoryManager, "memoryManager");
        if (ThreadUtils.INSTANCE.isMainThread()) {
            ForestLogger.printOptimize$default(logger, 5, TAG, false, null, null, new Function0<String>() { // from class: com.bytedance.forest.preload.PreLoader$fetchCacheSync$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                public final String invoke() {
                    return "Fetching " + CacheIdentifier.this + " sync in main thread!";
                }
            }, 28, null);
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        fetchCache$forest_release(preloadKey, ignoreWait, logger, memoryManager, new Function1<PreloadResult, Unit>() { // from class: com.bytedance.forest.preload.PreLoader$fetchCacheSync$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PreloadResult) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(PreloadResult preloadResult) {
                objectRef.element = preloadResult;
                countDownLatch.countDown();
            }
        });
        countDownLatch.await(DefaultConfig.INSTANCE.getCDN_TIMEOUT(), TimeUnit.MILLISECONDS);
        return (PreloadResult) objectRef.element;
    }
}
