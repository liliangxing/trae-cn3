package com.bytedance.ies.bullet.lynx.init;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.forest.model.RequestParams;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.postprocessor.ProcessedResponse;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.forest.ForestInfoHelper;
import com.bytedance.ies.bullet.forest.ForestLoader;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoader;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoaderService;
import com.bytedance.ies.bullet.kit.resourceloader.config.TaskContext;
import com.bytedance.ies.bullet.lynx.util.FontCacheHelper;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.IPreLoadService;
import com.bytedance.ies.bullet.service.base.IPreloadV2Service;
import com.bytedance.ies.bullet.service.base.IPreloadV2ServiceKt;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.ies.bullet.service.base.api.IServiceToken;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import com.bytedance.ies.bullet.service.base.standard.StandardServiceManager;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import com.bytedance.sysoptimizer.TypeFaceLancet;
import com.bytedance.sysoptimizer.TypeFaceOptimizer;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.fontface.FontFace;
import com.lynx.tasm.loader.LynxFontFaceLoader;
import com.lynx.tasm.resourceprovider.LynxResourceRequest;
import com.lynx.tasm.utils.TypefaceUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* compiled from: LynxKit.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J&\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ(\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014¨\u0006\f"}, d2 = {"com/bytedance/ies/bullet/lynx/init/LynxKit$setFontLoader$1", "Lcom/lynx/tasm/loader/LynxFontFaceLoader$Loader;", "Lcom/bytedance/ies/bullet/forest/ForestInfoHelper;", "loadFromBase64", "Landroid/graphics/Typeface;", "context", "Lcom/lynx/tasm/behavior/LynxContext;", "type", "Lcom/lynx/tasm/fontface/FontFace$TYPE;", "src", "", "onLoadFontFace", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class LynxKit$setFontLoader$1 extends LynxFontFaceLoader.Loader implements ForestInfoHelper {
    final /* synthetic */ boolean $enableLynxFontCache;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LynxKit$setFontLoader$1(boolean z) {
        this.$enableLynxFontCache = z;
    }

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

    protected Typeface onLoadFontFace(LynxContext context, FontFace.TYPE type, String src) {
        IServiceToken iServiceToken;
        Typeface typeface;
        IServiceToken iServiceToken2;
        IServiceToken iServiceToken3;
        Object cache;
        IServiceToken iServiceToken4;
        IServiceToken iServiceToken5;
        Response loadSync;
        String str = src;
        if (str == null || str.length() == 0) {
            return null;
        }
        if (!this.$enableLynxFontCache || !FontCacheHelper.INSTANCE.findFontCache(src)) {
            iServiceToken = LynxKit.token;
            if (iServiceToken == null) {
                Intrinsics.throwUninitializedPropertyAccessException("token");
                iServiceToken = null;
            }
            if (useForest(iServiceToken) && !StringsKt.startsWith$default(src, "base64:", false, 2, (Object) null)) {
                ForestLoader forestLoader = ForestLoader.INSTANCE;
                iServiceToken5 = LynxKit.token;
                if (iServiceToken5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("token");
                    iServiceToken5 = null;
                }
                typeface = null;
                loadSync = forestLoader.loadSync((r17 & 1) != 0 ? forestLoader.getDefault() : null, src, (r17 & 4) != 0 ? null : ForestLoader.DOWNLOAD_ENGINE_DOWNLOADER, Scene.LYNX_FONT, sessionID(iServiceToken5), (r17 & 32) != 0 ? null : null, (r17 & 64) != 0 ? null : new Function1<RequestParams, Unit>() { // from class: com.bytedance.ies.bullet.lynx.init.LynxKit$setFontLoader$1$onLoadFontFace$1
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
                        BulletLogger.INSTANCE.printLog("Forest load fontFace failed", LogLevel.E, "XLynxKit");
                    } else {
                        String filePath = loadSync.getFilePath();
                        if (filePath == null || filePath.length() == 0) {
                            BulletLogger.INSTANCE.printLog("Forest's filePath is empty", LogLevel.E, "XLynxKit");
                        } else {
                            try {
                                String filePath2 = loadSync.getFilePath();
                                Intrinsics.checkNotNull(filePath2);
                                Typeface m26xc5f87150 = m26xc5f87150(new File(filePath2));
                                if (m26xc5f87150 != null) {
                                    Intrinsics.checkNotNullExpressionValue(m26xc5f87150, "createFromFile(File(response.filePath!!))");
                                    FontCacheHelper.INSTANCE.setFontCache(src, m26xc5f87150);
                                    BulletLogger.INSTANCE.printLog("Forest cache font for " + src, LogLevel.E, "XLynxKit");
                                }
                            } catch (Exception e) {
                                String message = e.getMessage();
                                if (message != null) {
                                    BulletLogger.INSTANCE.printLog(message, LogLevel.E, "XLynxKit");
                                }
                            }
                        }
                    }
                }
            } else {
                typeface = null;
                IPreloadV2Service preloadV2Service = IPreloadV2ServiceKt.getPreloadV2Service();
                if (preloadV2Service != null) {
                    iServiceToken4 = LynxKit.token;
                    if (iServiceToken4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("token");
                        iServiceToken4 = null;
                    }
                    Typeface cacheFont = preloadV2Service.getCacheFont(iServiceToken4.getMBid(), src);
                    if (cacheFont != null) {
                        if (this.$enableLynxFontCache) {
                            FontCacheHelper.INSTANCE.setFontCache(src, cacheFont);
                        }
                        return cacheFont;
                    }
                }
                IPreLoadService iPreLoadService = (IPreLoadService) StandardServiceManager.INSTANCE.get(IPreLoadService.class);
                if (iPreLoadService != null && (cache = iPreLoadService.getCache(src, 2)) != null) {
                    boolean z = this.$enableLynxFontCache;
                    if (cache instanceof Typeface) {
                        BulletLogger.INSTANCE.printLog("get typeface from preload service", LogLevel.I, "XLynxKit");
                        if (z) {
                            FontCacheHelper.INSTANCE.setFontCache(src, (Typeface) cache);
                        }
                        return (Typeface) cache;
                    }
                }
                ResourceLoader resourceLoader = ResourceLoader.INSTANCE;
                iServiceToken2 = LynxKit.token;
                if (iServiceToken2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("token");
                    iServiceToken2 = null;
                }
                ResourceLoaderService with$default = ResourceLoader.with$default(resourceLoader, iServiceToken2.getMBid(), null, 2, null);
                TaskConfig taskConfig = new TaskConfig(null, 1, null);
                TaskContext.Companion companion = TaskContext.INSTANCE;
                iServiceToken3 = LynxKit.token;
                IServiceToken iServiceToken6 = iServiceToken3;
                if (iServiceToken3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("token");
                    iServiceToken6 = null;
                }
                taskConfig.setTaskContext(companion.from(iServiceToken6.getAllDependency()));
                taskConfig.setResTag("sub_resource");
                Unit unit = Unit.INSTANCE;
                ResourceInfo loadSync2 = with$default.loadSync(src, taskConfig);
                if (loadSync2 == null) {
                    BulletLogger.INSTANCE.printLog("Load fontFace failed", LogLevel.E, "XLynxKit");
                } else {
                    String filePath3 = loadSync2.getFilePath();
                    if (filePath3 == null || filePath3.length() == 0) {
                        BulletLogger.INSTANCE.printLog("ResourceInfo's filePath is empty", LogLevel.E, "XLynxKit");
                    } else {
                        try {
                            String filePath4 = loadSync2.getFilePath();
                            Intrinsics.checkNotNull(filePath4);
                            Typeface m26xc5f871502 = m26xc5f87150(new File(filePath4));
                            if (m26xc5f871502 != null) {
                                Intrinsics.checkNotNullExpressionValue(m26xc5f871502, "createFromFile(File(it.filePath!!))");
                                FontCacheHelper.INSTANCE.setFontCache(src, m26xc5f871502);
                                BulletLogger.INSTANCE.printLog("cache font for " + src, LogLevel.E, "XLynxKit");
                            }
                        } catch (Exception e2) {
                            String message2 = e2.getMessage();
                            if (message2 != null) {
                                BulletLogger.INSTANCE.printLog(message2, LogLevel.E, "XLynxKit");
                            }
                        }
                    }
                }
            }
            Typeface fontCache = FontCacheHelper.INSTANCE.getFontCache(src);
            if (fontCache != null) {
                return fontCache;
            }
            Typeface loadFromBase64 = loadFromBase64(context, type, src);
            if (loadFromBase64 == null) {
                return typeface;
            }
            if (!this.$enableLynxFontCache) {
                return loadFromBase64;
            }
            FontCacheHelper.INSTANCE.setFontCache(src, loadFromBase64);
            return loadFromBase64;
        }
        return FontCacheHelper.INSTANCE.getFontCache(src);
    }

    public final Typeface loadFromBase64(LynxContext context, FontFace.TYPE type, String src) {
        String str = src;
        if (TextUtils.isEmpty(str) || type == FontFace.TYPE.LOCAL) {
            return null;
        }
        Intrinsics.checkNotNull(src);
        int indexOf$default = StringsKt.indexOf$default(str, "base64,", 0, false, 6, (Object) null);
        if (!StringsKt.startsWith$default(src, "data:", false, 2, (Object) null) || indexOf$default == -1) {
            return null;
        }
        String substring = src.substring(indexOf$default + 7);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
        try {
            return TypefaceUtils.createFromBytes((Context) context, Base64.decode(substring, 0));
        } catch (Exception e) {
            reportException(context, e.getMessage());
            return null;
        }
    }

    @Proxy("createFromFile")
    @TargetClass("android.graphics.Typeface")
    /* renamed from: INVOKESTATIC_com_bytedance_ies_bullet_lynx_init_LynxKit$setFontLoader$1_com_bytedance_sysoptimizer_TypeFaceLancet_createFromFile */
    public static Typeface m26xc5f87150(File file) {
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
