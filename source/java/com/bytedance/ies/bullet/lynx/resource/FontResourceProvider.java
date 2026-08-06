package com.bytedance.ies.bullet.lynx.resource;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.forest.model.RequestParams;
import com.bytedance.forest.model.ResourceFrom;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.postprocessor.ProcessedResponse;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.forest.ForestInfoHelper;
import com.bytedance.ies.bullet.forest.ForestLoader;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoader;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoaderService;
import com.bytedance.ies.bullet.kit.resourceloader.config.TaskContext;
import com.bytedance.ies.bullet.lynx.util.FontCacheHelper;
import com.bytedance.ies.bullet.preloadv2.redirect.RedirectManager;
import com.bytedance.ies.bullet.service.base.BulletSettings;
import com.bytedance.ies.bullet.service.base.IPreLoadService;
import com.bytedance.ies.bullet.service.base.IPreloadV2Service;
import com.bytedance.ies.bullet.service.base.IPreloadV2ServiceKt;
import com.bytedance.ies.bullet.service.base.ISettingService;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.ies.bullet.service.base.api.IServiceContext;
import com.bytedance.ies.bullet.service.base.api.IServiceToken;
import com.bytedance.ies.bullet.service.base.impl.BaseBulletService;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import com.bytedance.ies.bullet.service.base.standard.StandardServiceManager;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import com.bytedance.sysoptimizer.TypeFaceLancet;
import com.bytedance.sysoptimizer.TypeFaceOptimizer;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.provider.LynxResourceCallback;
import com.lynx.tasm.provider.LynxResourceProvider;
import com.lynx.tasm.provider.LynxResourceRequest;
import com.lynx.tasm.provider.LynxResourceResponse;
import com.lynx.tasm.resourceprovider.LynxResourceRequest;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* compiled from: FontResourceProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u00012\u00020\u0005B\u0015\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ*\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0013H\u0016R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/resource/FontResourceProvider;", "Lcom/lynx/tasm/provider/LynxResourceProvider;", "Lcom/lynx/tasm/provider/LynxResourceRequest;", "Landroid/os/Bundle;", "", "Lcom/bytedance/ies/bullet/forest/ForestInfoHelper;", "token", "Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;", "service", "Lcom/bytedance/ies/bullet/service/base/impl/BaseBulletService;", "(Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;Lcom/bytedance/ies/bullet/service/base/impl/BaseBulletService;)V", "TAG", "mWeakToken", "Ljava/lang/ref/WeakReference;", "getService", "()Lcom/bytedance/ies/bullet/service/base/impl/BaseBulletService;", "request", "", "callback", "Lcom/lynx/tasm/provider/LynxResourceCallback;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class FontResourceProvider extends LynxResourceProvider<LynxResourceRequest<Bundle>, String> implements ForestInfoHelper {
    private final String TAG;
    private WeakReference<IServiceToken> mWeakToken;
    private final BaseBulletService service;

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

    public FontResourceProvider(IServiceToken iServiceToken, BaseBulletService baseBulletService) {
        Intrinsics.checkNotNullParameter(iServiceToken, "token");
        Intrinsics.checkNotNullParameter(baseBulletService, "service");
        this.service = baseBulletService;
        this.TAG = "FontResourceProvider";
        this.mWeakToken = new WeakReference<>(iServiceToken);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void request(com.lynx.tasm.provider.LynxResourceRequest<com.lynx.tasm.provider.LynxResourceRequest<Bundle>> request, LynxResourceCallback<String> callback) {
        IServiceToken iServiceToken;
        IServiceToken iServiceToken2;
        IServiceToken iServiceToken3;
        String mBid;
        Response loadSync;
        IServiceToken iServiceToken4;
        IServiceContext serviceContext;
        Context context;
        IServiceToken iServiceToken5;
        ISettingService iSettingService;
        BulletSettings provideBulletSettings;
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (TextUtils.isEmpty(request.getUrl())) {
            LynxResourceResponse failed = LynxResourceResponse.failed(-1, new Throwable("request.url is null"));
            Intrinsics.checkNotNull(failed, "null cannot be cast to non-null type com.lynx.tasm.provider.LynxResourceResponse<kotlin.String>");
            callback.onResponse(failed);
            return;
        }
        WeakReference<IServiceToken> weakReference = this.mWeakToken;
        boolean enableLynxFontCache = (weakReference == null || (iServiceToken5 = weakReference.get()) == null || (iSettingService = (ISettingService) iServiceToken5.getService(ISettingService.class)) == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null) ? true : provideBulletSettings.getEnableLynxFontCache();
        if (enableLynxFontCache) {
            FontCacheHelper fontCacheHelper = FontCacheHelper.INSTANCE;
            String url = request.getUrl();
            Intrinsics.checkNotNullExpressionValue(url, "request.url");
            if (fontCacheHelper.findFontCache(url)) {
                callback.onResponse(LynxResourceResponse.success(request.getUrl()));
                return;
            }
        }
        WeakReference<IServiceToken> weakReference2 = this.mWeakToken;
        Map<Class<?>, Object> map = null;
        String str = null;
        r11 = null;
        r11 = null;
        r11 = null;
        r11 = null;
        Typeface m34x919b896a = null;
        map = null;
        if (useForest(weakReference2 != null ? weakReference2.get() : null)) {
            String url2 = request.getUrl();
            Intrinsics.checkNotNullExpressionValue(url2, "request.url");
            if (!StringsKt.startsWith$default(url2, "base64:", false, 2, (Object) null)) {
                ForestLoader forestLoader = ForestLoader.INSTANCE;
                String url3 = request.getUrl();
                WeakReference<IServiceToken> weakReference3 = this.mWeakToken;
                String sessionID = sessionID(weakReference3 != null ? weakReference3.get() : null);
                Scene scene = Scene.LYNX_FONT;
                Intrinsics.checkNotNullExpressionValue(url3, "url");
                loadSync = forestLoader.loadSync((r17 & 1) != 0 ? forestLoader.getDefault() : null, url3, (r17 & 4) != 0 ? null : ForestLoader.DOWNLOAD_ENGINE_DOWNLOADER, scene, sessionID, (r17 & 32) != 0 ? null : null, (r17 & 64) != 0 ? null : new Function1<RequestParams, Unit>() { // from class: com.bytedance.ies.bullet.lynx.resource.FontResourceProvider$request$1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((RequestParams) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(RequestParams requestParams) {
                        Intrinsics.checkNotNullParameter(requestParams, "params");
                        requestParams.setLoadToMemory(false);
                        requestParams.setEnableMemoryCache(false);
                    }
                });
                if (loadSync != null) {
                    if (!loadSync.isSucceed()) {
                        HybridLogger.e$default(HybridLogger.INSTANCE, this.TAG, "Forest load fontFace failed", null, null, 12, null);
                        LynxResourceResponse failed2 = LynxResourceResponse.failed(-1, new Throwable("Forest load fontFace failed"));
                        Intrinsics.checkNotNull(failed2, "null cannot be cast to non-null type com.lynx.tasm.provider.LynxResourceResponse<kotlin.String>");
                        callback.onResponse(failed2);
                        return;
                    }
                    String filePath = loadSync.getFilePath();
                    if ((filePath == null || filePath.length() == 0) != false) {
                        HybridLogger.e$default(HybridLogger.INSTANCE, this.TAG, "Forest's filePath is empty", null, null, 12, null);
                        LynxResourceResponse failed3 = LynxResourceResponse.failed(-1, new Throwable("Forest's filePath is empty"));
                        Intrinsics.checkNotNull(failed3, "null cannot be cast to non-null type com.lynx.tasm.provider.LynxResourceResponse<kotlin.String>");
                        callback.onResponse(failed3);
                        return;
                    }
                    ResourceFrom from = loadSync.getFrom();
                    if (!(from != ResourceFrom.MEMORY)) {
                        from = null;
                    }
                    if (from == null) {
                        from = loadSync.getOriginFrom();
                    }
                    RedirectManager redirectManager = RedirectManager.INSTANCE;
                    String filePath2 = loadSync.getFilePath();
                    Intrinsics.checkNotNull(filePath2);
                    String wrapRedirectPath = redirectManager.wrapRedirectPath(filePath2, from);
                    callback.onResponse(LynxResourceResponse.success(wrapRedirectPath));
                    try {
                        Uri parse = Uri.parse(wrapRedirectPath);
                        if (from == ResourceFrom.BUILTIN && !Intrinsics.areEqual(parse.getScheme(), "file")) {
                            WeakReference<IServiceToken> weakReference4 = this.mWeakToken;
                            if (weakReference4 != null && (iServiceToken4 = weakReference4.get()) != null && (serviceContext = iServiceToken4.getServiceContext()) != null && (context = serviceContext.getContext()) != null) {
                                AssetManager assets = context.getAssets();
                                String path = parse.getPath();
                                if (path != null) {
                                    Intrinsics.checkNotNullExpressionValue(path, "path");
                                    str = StringsKt.removePrefix(path, "/");
                                }
                                m34x919b896a = Typeface.createFromAsset(assets, str);
                            }
                        } else {
                            String path2 = parse.getPath();
                            if (path2 != null) {
                                m34x919b896a = m34x919b896a(new File(path2));
                            }
                        }
                        if (m34x919b896a != null) {
                            FontCacheHelper fontCacheHelper2 = FontCacheHelper.INSTANCE;
                            String url4 = request.getUrl();
                            Intrinsics.checkNotNullExpressionValue(url4, "request.url");
                            fontCacheHelper2.setFontCache(url4, m34x919b896a);
                            HybridLogger.e$default(HybridLogger.INSTANCE, this.TAG, "Forest cache font for " + request + ".url", null, null, 12, null);
                            return;
                        }
                        return;
                    } catch (Exception e) {
                        String message = e.getMessage();
                        if (message != null) {
                            HybridLogger.e$default(HybridLogger.INSTANCE, this.TAG, message, null, null, 12, null);
                            Unit unit = Unit.INSTANCE;
                            return;
                        }
                        return;
                    }
                }
                return;
            }
        }
        WeakReference<IServiceToken> weakReference5 = this.mWeakToken;
        if (weakReference5 != null && (iServiceToken3 = weakReference5.get()) != null && (mBid = iServiceToken3.getMBid()) != null) {
            IPreloadV2Service preloadV2Service = IPreloadV2ServiceKt.getPreloadV2Service();
            if (preloadV2Service != null) {
                String url5 = request.getUrl();
                Intrinsics.checkNotNullExpressionValue(url5, "request.url");
                Typeface cacheFont = preloadV2Service.getCacheFont(mBid, url5);
                if (cacheFont != null) {
                    if (enableLynxFontCache) {
                        FontCacheHelper fontCacheHelper3 = FontCacheHelper.INSTANCE;
                        String url6 = request.getUrl();
                        Intrinsics.checkNotNullExpressionValue(url6, "request.url");
                        fontCacheHelper3.setFontCache(url6, cacheFont);
                    }
                    callback.onResponse(LynxResourceResponse.success(request.getUrl()));
                    return;
                }
            }
            IPreLoadService iPreLoadService = (IPreLoadService) StandardServiceManager.INSTANCE.get(IPreLoadService.class);
            if (iPreLoadService != null) {
                String url7 = request.getUrl();
                Intrinsics.checkNotNullExpressionValue(url7, "request.url");
                Object cache = iPreLoadService.getCache(url7, 2);
                if (cache != null && (cache instanceof Typeface)) {
                    HybridLogger.i$default(HybridLogger.INSTANCE, this.TAG, "get typeface from preload service", null, null, 12, null);
                    if (enableLynxFontCache) {
                        FontCacheHelper fontCacheHelper4 = FontCacheHelper.INSTANCE;
                        String url8 = request.getUrl();
                        Intrinsics.checkNotNullExpressionValue(url8, "request.url");
                        fontCacheHelper4.setFontCache(url8, (Typeface) cache);
                    }
                    callback.onResponse(LynxResourceResponse.success(request.getUrl()));
                    return;
                }
            }
        }
        ResourceLoader resourceLoader = ResourceLoader.INSTANCE;
        WeakReference<IServiceToken> weakReference6 = this.mWeakToken;
        ResourceLoaderService with$default = ResourceLoader.with$default(resourceLoader, (weakReference6 == null || (iServiceToken2 = weakReference6.get()) == null) ? null : iServiceToken2.getMBid(), null, 2, null);
        String url9 = request.getUrl();
        Intrinsics.checkNotNullExpressionValue(url9, "request.url");
        TaskConfig taskConfig = new TaskConfig(null, 1, null);
        TaskContext.Companion companion = TaskContext.INSTANCE;
        WeakReference<IServiceToken> weakReference7 = this.mWeakToken;
        if (weakReference7 != null && (iServiceToken = weakReference7.get()) != null) {
            map = iServiceToken.getAllDependency();
        }
        taskConfig.setTaskContext(companion.from(map));
        taskConfig.setResTag("sub_resource");
        Unit unit2 = Unit.INSTANCE;
        ResourceInfo loadSync2 = with$default.loadSync(url9, taskConfig);
        if (loadSync2 == null) {
            HybridLogger.e$default(HybridLogger.INSTANCE, this.TAG, "Load fontFace failed", null, null, 12, null);
            LynxResourceResponse failed4 = LynxResourceResponse.failed(-1, new Throwable("Load fontFace failed"));
            Intrinsics.checkNotNull(failed4, "null cannot be cast to non-null type com.lynx.tasm.provider.LynxResourceResponse<kotlin.String>");
            callback.onResponse(failed4);
            return;
        }
        String filePath3 = loadSync2.getFilePath();
        if (filePath3 != null && filePath3.length() != 0) {
            r8 = false;
        }
        if (r8) {
            HybridLogger.e$default(HybridLogger.INSTANCE, this.TAG, "ResourceInfo's filePath is empty", null, null, 12, null);
            LynxResourceResponse failed5 = LynxResourceResponse.failed(-1, new Throwable("ResourceInfo's filePath is empty"));
            Intrinsics.checkNotNull(failed5, "null cannot be cast to non-null type com.lynx.tasm.provider.LynxResourceResponse<kotlin.String>");
            callback.onResponse(failed5);
            return;
        }
        String filePath4 = loadSync2.getFilePath();
        callback.onResponse(LynxResourceResponse.success(loadSync2.getFrom() == com.bytedance.ies.bullet.service.base.ResourceFrom.BUILTIN ? "asset://" + filePath4 : "file://" + filePath4));
        try {
            String filePath5 = loadSync2.getFilePath();
            Intrinsics.checkNotNull(filePath5);
            Typeface m34x919b896a2 = m34x919b896a(new File(filePath5));
            if (m34x919b896a2 != null) {
                Intrinsics.checkNotNullExpressionValue(m34x919b896a2, "createFromFile(File(resourceInfo.filePath!!))");
                FontCacheHelper fontCacheHelper5 = FontCacheHelper.INSTANCE;
                String url10 = request.getUrl();
                Intrinsics.checkNotNullExpressionValue(url10, "request.url");
                fontCacheHelper5.setFontCache(url10, m34x919b896a2);
                HybridLogger.e$default(HybridLogger.INSTANCE, this.TAG, "cache font for " + request + ".url", null, null, 12, null);
                Unit unit3 = Unit.INSTANCE;
            }
        } catch (Exception e2) {
            String message2 = e2.getMessage();
            if (message2 != null) {
                HybridLogger.e$default(HybridLogger.INSTANCE, this.TAG, message2, null, null, 12, null);
                Unit unit4 = Unit.INSTANCE;
            }
        }
    }

    @Proxy("createFromFile")
    @TargetClass("android.graphics.Typeface")
    /* renamed from: INVOKESTATIC_com_bytedance_ies_bullet_lynx_resource_FontResourceProvider_com_bytedance_sysoptimizer_TypeFaceLancet_createFromFile */
    public static Typeface m34x919b896a(File file) {
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
