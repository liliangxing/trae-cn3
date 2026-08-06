package com.bytedance.ies.bullet.lynx.resource;

import android.graphics.Typeface;
import android.net.Uri;
import android.text.TextUtils;
import bolts.Task;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.postprocessor.ProcessedResponse;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.forest.ForestInfoHelper;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoader;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoaderService;
import com.bytedance.ies.bullet.kit.resourceloader.config.TaskContext;
import com.bytedance.ies.bullet.lynx.resource.forest.ForestLynxGenericResourceProvider;
import com.bytedance.ies.bullet.lynx.util.FontCacheHelper;
import com.bytedance.ies.bullet.service.base.BulletSettings;
import com.bytedance.ies.bullet.service.base.IPreLoadService;
import com.bytedance.ies.bullet.service.base.IPreloadV2Service;
import com.bytedance.ies.bullet.service.base.IPreloadV2ServiceKt;
import com.bytedance.ies.bullet.service.base.ISettingService;
import com.bytedance.ies.bullet.service.base.ResourceFrom;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.ies.bullet.service.base.api.IServiceToken;
import com.bytedance.ies.bullet.service.base.impl.BaseBulletService;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import com.bytedance.ies.bullet.service.base.standard.StandardServiceManager;
import com.bytedance.ies.bullet.service.base.utils.ExtKt;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import com.bytedance.sysoptimizer.TypeFaceLancet;
import com.bytedance.sysoptimizer.TypeFaceOptimizer;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.resourceprovider.LynxResourceCallback;
import com.lynx.tasm.resourceprovider.LynxResourceRequest;
import com.lynx.tasm.resourceprovider.LynxResourceResponse;
import com.lynx.tasm.resourceprovider.generic.LynxGenericResourceFetcher;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* compiled from: DefaultLynxGenericResourceProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\"\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0016J\"\u0010\u0019\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0017H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/resource/DefaultLynxGenericResourceProvider;", "Lcom/lynx/tasm/resourceprovider/generic/LynxGenericResourceFetcher;", "Lcom/bytedance/ies/bullet/forest/ForestInfoHelper;", "token", "Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;", "service", "Lcom/bytedance/ies/bullet/service/base/impl/BaseBulletService;", "(Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;Lcom/bytedance/ies/bullet/service/base/impl/BaseBulletService;)V", "TAG", "", "mForestProvider", "Lcom/bytedance/ies/bullet/lynx/resource/forest/ForestLynxGenericResourceProvider;", "mWeakToken", "Ljava/lang/ref/WeakReference;", "getService", "()Lcom/bytedance/ies/bullet/service/base/impl/BaseBulletService;", "useForest", "", "fetchResource", "", "request", "Lcom/lynx/tasm/resourceprovider/LynxResourceRequest;", "callback", "Lcom/lynx/tasm/resourceprovider/LynxResourceCallback;", "", "fetchResourcePath", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class DefaultLynxGenericResourceProvider extends LynxGenericResourceFetcher implements ForestInfoHelper {
    private final String TAG;
    private final ForestLynxGenericResourceProvider mForestProvider;
    private WeakReference<IServiceToken> mWeakToken;
    private final BaseBulletService service;
    private final boolean useForest;

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean delayPreload(Uri uri) {
        return ForestInfoHelper.DefaultImpls.delayPreload(this, uri);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean delayPreload(BulletContext bulletContext) {
        return ForestInfoHelper.DefaultImpls.delayPreload(this, bulletContext);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean delayPreload(SchemaModelUnion schemaModelUnion) {
        return ForestInfoHelper.DefaultImpls.delayPreload(this, schemaModelUnion);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String forestDownloadEngine(Uri uri) {
        return ForestInfoHelper.DefaultImpls.forestDownloadEngine(this, uri);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String forestDownloadEngine(BulletContext bulletContext) {
        return ForestInfoHelper.DefaultImpls.forestDownloadEngine(this, bulletContext);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String forestDownloadEngine(IServiceToken iServiceToken) {
        return ForestInfoHelper.DefaultImpls.forestDownloadEngine(this, iServiceToken);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String forestDownloadEngine(SchemaModelUnion schemaModelUnion) {
        return ForestInfoHelper.DefaultImpls.forestDownloadEngine(this, schemaModelUnion);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String getResTag(LynxResourceRequest.LynxResourceType lynxResourceType) {
        return ForestInfoHelper.DefaultImpls.getResTag(this, lynxResourceType);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public Scene getSceneType(LynxResourceRequest.LynxResourceType lynxResourceType) {
        return ForestInfoHelper.DefaultImpls.getSceneType(this, lynxResourceType);
    }

    public final BaseBulletService getService() {
        return this.service;
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public ProcessedResponse<TemplateBundle> getTemplateBundleResponse(Response response) {
        return ForestInfoHelper.DefaultImpls.getTemplateBundleResponse(this, response);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean hasGeckoModelInfo(BulletContext bulletContext) {
        return ForestInfoHelper.DefaultImpls.hasGeckoModelInfo(this, bulletContext);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean hasGeckoModelInfo(IServiceToken iServiceToken) {
        return ForestInfoHelper.DefaultImpls.hasGeckoModelInfo(this, iServiceToken);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean hasGeckoModelInfo(SchemaModelUnion schemaModelUnion) {
        return ForestInfoHelper.DefaultImpls.hasGeckoModelInfo(this, schemaModelUnion);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String preloadScope(Uri uri) {
        return ForestInfoHelper.DefaultImpls.preloadScope(this, uri);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String preloadScope(BulletContext bulletContext) {
        return ForestInfoHelper.DefaultImpls.preloadScope(this, bulletContext);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String preloadScope(SchemaModelUnion schemaModelUnion) {
        return ForestInfoHelper.DefaultImpls.preloadScope(this, schemaModelUnion);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String sessionID(BulletContext bulletContext) {
        return ForestInfoHelper.DefaultImpls.sessionID(this, bulletContext);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String sessionID(IServiceToken iServiceToken) {
        return ForestInfoHelper.DefaultImpls.sessionID(this, iServiceToken);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean useForest(Uri uri) {
        return ForestInfoHelper.DefaultImpls.useForest(this, uri);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean useForest(BulletContext bulletContext) {
        return ForestInfoHelper.DefaultImpls.useForest(this, bulletContext);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean useForest(IServiceToken iServiceToken) {
        return ForestInfoHelper.DefaultImpls.useForest(this, iServiceToken);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean useForest(SchemaModelUnion schemaModelUnion) {
        return ForestInfoHelper.DefaultImpls.useForest(this, schemaModelUnion);
    }

    public DefaultLynxGenericResourceProvider(IServiceToken iServiceToken, BaseBulletService baseBulletService) {
        Intrinsics.checkNotNullParameter(iServiceToken, "token");
        Intrinsics.checkNotNullParameter(baseBulletService, "service");
        this.service = baseBulletService;
        this.TAG = "DefaultLynxGenericResourceProvider";
        this.mWeakToken = new WeakReference<>(iServiceToken);
        this.useForest = useForest(iServiceToken);
        this.mForestProvider = new ForestLynxGenericResourceProvider(forestDownloadEngine(iServiceToken), sessionID(iServiceToken));
    }

    public void fetchResource(LynxResourceRequest request, final LynxResourceCallback<byte[]> callback) {
        IServiceToken iServiceToken;
        final LynxResourceRequest.LynxResourceType resourceType = request != null ? request.getResourceType() : null;
        if (this.useForest) {
            this.mForestProvider.fetchResource(request, callback);
            return;
        }
        String url = request != null ? request.getUrl() : null;
        if (!(!TextUtils.isEmpty(url))) {
            url = null;
        }
        if (url != null) {
            ResourceLoaderService with$default = ResourceLoader.with$default(ResourceLoader.INSTANCE, this.service.getBid(), null, 2, null);
            TaskConfig taskConfig = new TaskConfig(null, 1, null);
            taskConfig.setResTag(getResTag(resourceType));
            TaskContext.Companion companion = TaskContext.INSTANCE;
            WeakReference<IServiceToken> weakReference = this.mWeakToken;
            taskConfig.setTaskContext(companion.from((weakReference == null || (iServiceToken = weakReference.get()) == null) ? null : iServiceToken.getAllDependency()));
            try {
                Uri parse = Uri.parse(url);
                Intrinsics.checkNotNullExpressionValue(parse, "uri");
                String cDN$default = ExtKt.getCDN$default(parse, null, 1, null);
                if (cDN$default != null) {
                    taskConfig.setCdnUrl(cDN$default);
                }
                String queryParameter = parse.getQueryParameter("channel");
                if (queryParameter != null) {
                    Intrinsics.checkNotNullExpressionValue(queryParameter, "it");
                    taskConfig.setChannel(queryParameter);
                }
                String queryParameter2 = parse.getQueryParameter(SchemaConstants.QUERY_KEY_BUNDLE);
                if (queryParameter2 != null) {
                    Intrinsics.checkNotNullExpressionValue(queryParameter2, "it");
                    taskConfig.setBundle(queryParameter2);
                }
                String queryParameter3 = parse.getQueryParameter("dynamic");
                if (queryParameter3 != null) {
                    Intrinsics.checkNotNullExpressionValue(queryParameter3, "it");
                    taskConfig.setDynamic(Integer.valueOf(Integer.parseInt(queryParameter3)));
                }
            } catch (Throwable th) {
                HybridLogger.e$default(HybridLogger.INSTANCE, this.TAG, "DefaultLynxGenericResourceProvider parse url error, e: " + th.getMessage(), null, null, 12, null);
                if (callback != null) {
                    LynxResourceResponse onFailed = LynxResourceResponse.onFailed(th);
                    Intrinsics.checkNotNull(onFailed, "null cannot be cast to non-null type com.lynx.tasm.resourceprovider.LynxResourceResponse<kotlin.ByteArray>");
                    callback.onResponse(onFailed);
                }
            }
            Unit unit = Unit.INSTANCE;
            with$default.loadAsync(url, taskConfig, new Function1<ResourceInfo, Unit>() { // from class: com.bytedance.ies.bullet.lynx.resource.DefaultLynxGenericResourceProvider$fetchResource$2$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((ResourceInfo) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(final ResourceInfo resourceInfo) {
                    Intrinsics.checkNotNullParameter(resourceInfo, "it");
                    final LynxResourceCallback<byte[]> lynxResourceCallback = callback;
                    final DefaultLynxGenericResourceProvider defaultLynxGenericResourceProvider = this;
                    final LynxResourceRequest.LynxResourceType lynxResourceType = resourceType;
                    Task.call(new Callable() { // from class: com.bytedance.ies.bullet.lynx.resource.DefaultLynxGenericResourceProvider$fetchResource$2$2.1
                        @Override // java.util.concurrent.Callable
                        public /* bridge */ /* synthetic */ Object call() {
                            call();
                            return Unit.INSTANCE;
                        }

                        @Override // java.util.concurrent.Callable
                        public final void call() {
                            String str;
                            String str2;
                            byte[] provideByteArray = ResourceInfo.this.provideByteArray();
                            boolean z = false;
                            if (provideByteArray != null) {
                                if (!(provideByteArray.length == 0)) {
                                    z = true;
                                }
                            }
                            if (z) {
                                LynxResourceCallback<byte[]> lynxResourceCallback2 = lynxResourceCallback;
                                if (lynxResourceCallback2 != null) {
                                    lynxResourceCallback2.onResponse(LynxResourceResponse.onSuccess(provideByteArray));
                                }
                                HybridLogger hybridLogger = HybridLogger.INSTANCE;
                                str2 = defaultLynxGenericResourceProvider.TAG;
                                StringBuilder sb = new StringBuilder("get ");
                                LynxResourceRequest.LynxResourceType lynxResourceType2 = lynxResourceType;
                                HybridLogger.i$default(hybridLogger, str2, sb.append(lynxResourceType2 != null ? lynxResourceType2.name() : null).append(" resource success").toString(), null, null, 12, null);
                                return;
                            }
                            LynxResourceCallback<byte[]> lynxResourceCallback3 = lynxResourceCallback;
                            if (lynxResourceCallback3 != null) {
                                LynxResourceResponse onFailed2 = LynxResourceResponse.onFailed(new Error("InputStream is null"));
                                Intrinsics.checkNotNull(onFailed2, "null cannot be cast to non-null type com.lynx.tasm.resourceprovider.LynxResourceResponse<kotlin.ByteArray>");
                                lynxResourceCallback3.onResponse(onFailed2);
                            }
                            HybridLogger hybridLogger2 = HybridLogger.INSTANCE;
                            str = defaultLynxGenericResourceProvider.TAG;
                            StringBuilder sb2 = new StringBuilder("get ");
                            LynxResourceRequest.LynxResourceType lynxResourceType3 = lynxResourceType;
                            HybridLogger.e$default(hybridLogger2, str, sb2.append(lynxResourceType3 != null ? lynxResourceType3.name() : null).append(" resource failed: InputStream is null").toString(), null, null, 12, null);
                        }
                    }, Task.BACKGROUND_EXECUTOR);
                }
            }, new Function1<Throwable, Unit>() { // from class: com.bytedance.ies.bullet.lynx.resource.DefaultLynxGenericResourceProvider$fetchResource$2$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Throwable) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(Throwable th2) {
                    String str;
                    Intrinsics.checkNotNullParameter(th2, "err");
                    LynxResourceCallback<byte[]> lynxResourceCallback = callback;
                    if (lynxResourceCallback != null) {
                        LynxResourceResponse onFailed2 = LynxResourceResponse.onFailed(th2);
                        Intrinsics.checkNotNull(onFailed2, "null cannot be cast to non-null type com.lynx.tasm.resourceprovider.LynxResourceResponse<kotlin.ByteArray>");
                        lynxResourceCallback.onResponse(onFailed2);
                    }
                    HybridLogger hybridLogger = HybridLogger.INSTANCE;
                    str = this.TAG;
                    StringBuilder sb = new StringBuilder("get ");
                    LynxResourceRequest.LynxResourceType lynxResourceType = resourceType;
                    HybridLogger.e$default(hybridLogger, str, sb.append(lynxResourceType != null ? lynxResourceType.name() : null).append(" resource failed: ").append(th2.getMessage()).toString(), null, null, 12, null);
                }
            });
        }
    }

    public void fetchResourcePath(LynxResourceRequest request, LynxResourceCallback<String> callback) {
        boolean z;
        String str;
        IServiceToken iServiceToken;
        IServiceToken iServiceToken2;
        IServiceToken iServiceToken3;
        String mBid;
        Object cache;
        Typeface cacheFont;
        IServiceToken iServiceToken4;
        ISettingService iSettingService;
        BulletSettings provideBulletSettings;
        if (TextUtils.isEmpty(request != null ? request.getUrl() : null)) {
            if (callback != null) {
                LynxResourceResponse onFailed = LynxResourceResponse.onFailed(new Throwable("request.url is null"));
                Intrinsics.checkNotNull(onFailed, "null cannot be cast to non-null type com.lynx.tasm.resourceprovider.LynxResourceResponse<kotlin.String>");
                callback.onResponse(onFailed);
                return;
            }
            return;
        }
        String url = request != null ? request.getUrl() : null;
        if (url == null) {
            url = "";
        }
        LynxResourceRequest.LynxResourceType resourceType = request != null ? request.getResourceType() : null;
        boolean z2 = true;
        if (resourceType == LynxResourceRequest.LynxResourceType.LynxResourceTypeFont) {
            WeakReference<IServiceToken> weakReference = this.mWeakToken;
            z = (weakReference == null || (iServiceToken4 = weakReference.get()) == null || (iSettingService = (ISettingService) iServiceToken4.getService(ISettingService.class)) == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null) ? true : provideBulletSettings.getEnableLynxFontCache();
            if (z && FontCacheHelper.INSTANCE.findFontCache(url)) {
                if (callback != null) {
                    callback.onResponse(LynxResourceResponse.onSuccess(url));
                    return;
                }
                return;
            }
        } else {
            z = true;
        }
        if (this.useForest && !StringsKt.startsWith$default(url, "base64:", false, 2, (Object) null)) {
            this.mForestProvider.fetchResourcePath(request, callback);
            return;
        }
        WeakReference<IServiceToken> weakReference2 = this.mWeakToken;
        if (weakReference2 != null && (iServiceToken3 = weakReference2.get()) != null && (mBid = iServiceToken3.getMBid()) != null) {
            if (!(resourceType == LynxResourceRequest.LynxResourceType.LynxResourceTypeFont)) {
                mBid = null;
            }
            if (mBid != null) {
                IPreloadV2Service preloadV2Service = IPreloadV2ServiceKt.getPreloadV2Service();
                if (preloadV2Service != null && (cacheFont = preloadV2Service.getCacheFont(mBid, url)) != null) {
                    if (z) {
                        FontCacheHelper.INSTANCE.setFontCache(url, cacheFont);
                    }
                    if (callback != null) {
                        callback.onResponse(LynxResourceResponse.onSuccess(url));
                        return;
                    }
                    return;
                }
                IPreLoadService iPreLoadService = (IPreLoadService) StandardServiceManager.INSTANCE.get(IPreLoadService.class);
                if (iPreLoadService != null && (cache = iPreLoadService.getCache(url, 2)) != null && (cache instanceof Typeface)) {
                    HybridLogger.i$default(HybridLogger.INSTANCE, this.TAG, "get typeface from preload service", null, null, 12, null);
                    if (z) {
                        FontCacheHelper.INSTANCE.setFontCache(url, (Typeface) cache);
                    }
                    if (callback != null) {
                        callback.onResponse(LynxResourceResponse.onSuccess(url));
                        return;
                    }
                    return;
                }
            }
        }
        ResourceLoader resourceLoader = ResourceLoader.INSTANCE;
        WeakReference<IServiceToken> weakReference3 = this.mWeakToken;
        ResourceLoaderService with$default = ResourceLoader.with$default(resourceLoader, (weakReference3 == null || (iServiceToken2 = weakReference3.get()) == null) ? null : iServiceToken2.getMBid(), null, 2, null);
        TaskConfig taskConfig = new TaskConfig(null, 1, null);
        TaskContext.Companion companion = TaskContext.INSTANCE;
        WeakReference<IServiceToken> weakReference4 = this.mWeakToken;
        taskConfig.setTaskContext(companion.from((weakReference4 == null || (iServiceToken = weakReference4.get()) == null) ? null : iServiceToken.getAllDependency()));
        taskConfig.setResTag(getResTag(resourceType));
        Unit unit = Unit.INSTANCE;
        ResourceInfo loadSync = with$default.loadSync(url, taskConfig);
        if (loadSync == null) {
            HybridLogger.e$default(HybridLogger.INSTANCE, this.TAG, "Load " + (resourceType != null ? resourceType.name() : null) + " failed", null, null, 12, null);
            if (callback != null) {
                LynxResourceResponse onFailed2 = LynxResourceResponse.onFailed(new Throwable("Load " + (resourceType != null ? resourceType.name() : null) + " failed"));
                Intrinsics.checkNotNull(onFailed2, "null cannot be cast to non-null type com.lynx.tasm.resourceprovider.LynxResourceResponse<kotlin.String>");
                callback.onResponse(onFailed2);
                return;
            }
            return;
        }
        String filePath = loadSync.getFilePath();
        if (filePath != null && filePath.length() != 0) {
            z2 = false;
        }
        if (z2) {
            HybridLogger.e$default(HybridLogger.INSTANCE, this.TAG, "ResourceInfo's filePath is empty", null, null, 12, null);
            if (callback != null) {
                LynxResourceResponse onFailed3 = LynxResourceResponse.onFailed(new Throwable("ResourceInfo's filePath is empty"));
                Intrinsics.checkNotNull(onFailed3, "null cannot be cast to non-null type com.lynx.tasm.resourceprovider.LynxResourceResponse<kotlin.String>");
                callback.onResponse(onFailed3);
                return;
            }
            return;
        }
        try {
            if (resourceType == LynxResourceRequest.LynxResourceType.LynxResourceTypeFont) {
                String filePath2 = loadSync.getFilePath();
                Intrinsics.checkNotNull(filePath2);
                Typeface m33x309a6c3a = m33x309a6c3a(new File(filePath2));
                if (m33x309a6c3a != null) {
                    Intrinsics.checkNotNullExpressionValue(m33x309a6c3a, "createFromFile(File(resourceInfo.filePath!!))");
                    FontCacheHelper.INSTANCE.setFontCache(url, m33x309a6c3a);
                    HybridLogger.e$default(HybridLogger.INSTANCE, this.TAG, "cache font for " + url, null, null, 12, null);
                }
            }
            if (callback != null) {
                String filePath3 = loadSync.getFilePath();
                if (loadSync.getFrom() == ResourceFrom.BUILTIN) {
                    str = "asset://" + filePath3;
                } else {
                    str = "file://" + filePath3;
                }
                callback.onResponse(LynxResourceResponse.onSuccess(str));
                Unit unit2 = Unit.INSTANCE;
            }
        } catch (Exception e) {
            String message = e.getMessage();
            if (message != null) {
                HybridLogger.e$default(HybridLogger.INSTANCE, this.TAG, message, null, null, 12, null);
                Unit unit3 = Unit.INSTANCE;
            }
        }
    }

    @Proxy("createFromFile")
    @TargetClass("android.graphics.Typeface")
    /* renamed from: INVOKESTATIC_com_bytedance_ies_bullet_lynx_resource_DefaultLynxGenericResourceProvider_com_bytedance_sysoptimizer_TypeFaceLancet_createFromFile */
    public static Typeface m33x309a6c3a(File file) {
        String path;
        if (TypeFaceOptimizer.getSwitch() && (path = file.getPath()) != null) {
            if (TypeFaceLancet.cache.contains(path)) {
                return (Typeface) TypeFaceLancet.cache.get(path);
            }
            Typeface createFromFile = Typeface.createFromFile(file);
            if (createFromFile != null) {
                TypeFaceLancet.cache.put(path, createFromFile);
                return createFromFile;
            }
        }
        return Typeface.createFromFile(file);
    }
}
