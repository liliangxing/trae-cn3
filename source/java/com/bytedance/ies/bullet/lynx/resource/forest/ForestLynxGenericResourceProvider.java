package com.bytedance.ies.bullet.lynx.resource.forest;

import android.graphics.Typeface;
import android.net.Uri;
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
import com.bytedance.ies.bullet.lynx.util.FontCacheHelper;
import com.bytedance.ies.bullet.service.base.api.IServiceToken;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import com.bytedance.sysoptimizer.TypeFaceLancet;
import com.bytedance.sysoptimizer.TypeFaceOptimizer;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.resourceprovider.LynxResourceCallback;
import com.lynx.tasm.resourceprovider.LynxResourceRequest;
import com.lynx.tasm.resourceprovider.LynxResourceResponse;
import com.lynx.tasm.resourceprovider.generic.LynxGenericResourceFetcher;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* compiled from: ForestLynxGenericResourceProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006J\"\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0016J\"\u0010\u0012\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0010H\u0016R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/resource/forest/ForestLynxGenericResourceProvider;", "Lcom/lynx/tasm/resourceprovider/generic/LynxGenericResourceFetcher;", "Lcom/bytedance/ies/bullet/forest/ForestInfoHelper;", "downloadEngine", "", "sessionId", "(Ljava/lang/String;Ljava/lang/String;)V", "TAG", "getDownloadEngine", "()Ljava/lang/String;", "getSessionId", "fetchResource", "", "request", "Lcom/lynx/tasm/resourceprovider/LynxResourceRequest;", "callback", "Lcom/lynx/tasm/resourceprovider/LynxResourceCallback;", "", "fetchResourcePath", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ForestLynxGenericResourceProvider extends LynxGenericResourceFetcher implements ForestInfoHelper {
    private final String TAG;
    private final String downloadEngine;
    private final String sessionId;

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

    public final String getDownloadEngine() {
        return this.downloadEngine;
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String getResTag(LynxResourceRequest.LynxResourceType lynxResourceType) {
        return ForestInfoHelper.DefaultImpls.getResTag(this, lynxResourceType);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public Scene getSceneType(LynxResourceRequest.LynxResourceType lynxResourceType) {
        return ForestInfoHelper.DefaultImpls.getSceneType(this, lynxResourceType);
    }

    public final String getSessionId() {
        return this.sessionId;
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

    public ForestLynxGenericResourceProvider(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "downloadEngine");
        this.downloadEngine = str;
        this.sessionId = str2;
        this.TAG = "ForestLynxGenericResourceProvider";
    }

    public void fetchResource(LynxResourceRequest request, final LynxResourceCallback<byte[]> callback) {
        final LynxResourceRequest.LynxResourceType resourceType = request != null ? request.getResourceType() : null;
        String url = request != null ? request.getUrl() : null;
        String str = TextUtils.isEmpty(url) ^ true ? url : null;
        if (str != null) {
            r5.loadAsync((r22 & 1) != 0 ? ForestLoader.INSTANCE.getDefault() : null, str, (r22 & 4) != 0 ? null : this.downloadEngine, getSceneType(resourceType), this.sessionId, (r22 & 32) != 0 ? null : null, (r22 & 64) != 0 ? false : false, (r22 & 128) != 0 ? null : null, new Function1<Response, Unit>() { // from class: com.bytedance.ies.bullet.lynx.resource.forest.ForestLynxGenericResourceProvider$fetchResource$2$1
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
                    String str2;
                    String str3;
                    String str4;
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (response.isSucceed()) {
                        byte[] provideBytes = response.provideBytes();
                        boolean z = false;
                        if (provideBytes != null) {
                            if (!(provideBytes.length == 0)) {
                                z = true;
                            }
                        }
                        if (z) {
                            LynxResourceCallback<byte[]> lynxResourceCallback = callback;
                            if (lynxResourceCallback != null) {
                                lynxResourceCallback.onResponse(LynxResourceResponse.onSuccess(provideBytes));
                            }
                            HybridLogger hybridLogger = HybridLogger.INSTANCE;
                            str4 = this.TAG;
                            StringBuilder sb = new StringBuilder("Forest get ");
                            LynxResourceRequest.LynxResourceType lynxResourceType = resourceType;
                            HybridLogger.i$default(hybridLogger, str4, sb.append(lynxResourceType != null ? lynxResourceType.name() : null).append(" resource success").toString(), null, null, 12, null);
                            return;
                        }
                        LynxResourceCallback<byte[]> lynxResourceCallback2 = callback;
                        if (lynxResourceCallback2 != null) {
                            lynxResourceCallback2.onResponse(LynxResourceResponse.onFailed(new Error("Bytes is empty")));
                        }
                        HybridLogger hybridLogger2 = HybridLogger.INSTANCE;
                        str3 = this.TAG;
                        StringBuilder sb2 = new StringBuilder("Forest get ");
                        LynxResourceRequest.LynxResourceType lynxResourceType2 = resourceType;
                        HybridLogger.e$default(hybridLogger2, str3, sb2.append(lynxResourceType2 != null ? lynxResourceType2.name() : null).append(" resource failed: bytes is empty").toString(), null, null, 12, null);
                        return;
                    }
                    LynxResourceCallback<byte[]> lynxResourceCallback3 = callback;
                    if (lynxResourceCallback3 != null) {
                        LynxResourceResponse onFailed = LynxResourceResponse.onFailed(new IllegalStateException(response.getErrorInfo().toString()));
                        Intrinsics.checkNotNull(onFailed, "null cannot be cast to non-null type com.lynx.tasm.resourceprovider.LynxResourceResponse<kotlin.ByteArray>");
                        lynxResourceCallback3.onResponse(onFailed);
                    }
                    HybridLogger hybridLogger3 = HybridLogger.INSTANCE;
                    str2 = this.TAG;
                    StringBuilder sb3 = new StringBuilder("Forest get ");
                    LynxResourceRequest.LynxResourceType lynxResourceType3 = resourceType;
                    HybridLogger.e$default(hybridLogger3, str2, sb3.append(lynxResourceType3 != null ? lynxResourceType3.name() : null).append(" resource failed: ").append(response.getErrorInfo()).toString(), null, null, 12, null);
                }
            });
        }
    }

    public void fetchResourcePath(LynxResourceRequest request, LynxResourceCallback<String> callback) {
        Response loadSync;
        String str;
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
        if (resourceType == LynxResourceRequest.LynxResourceType.LynxResourceTypeFont && FontCacheHelper.INSTANCE.findFontCache(url)) {
            if (callback != null) {
                callback.onResponse(LynxResourceResponse.onSuccess(url));
                return;
            }
            return;
        }
        LynxResourceRequest.LynxResourceType lynxResourceType = resourceType;
        loadSync = r8.loadSync((r17 & 1) != 0 ? ForestLoader.INSTANCE.getDefault() : null, url, (r17 & 4) != 0 ? null : ForestLoader.DOWNLOAD_ENGINE_DOWNLOADER, getSceneType(resourceType), this.sessionId, (r17 & 32) != 0 ? null : null, (r17 & 64) != 0 ? null : new Function1<RequestParams, Unit>() { // from class: com.bytedance.ies.bullet.lynx.resource.forest.ForestLynxGenericResourceProvider$fetchResourcePath$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((RequestParams) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(RequestParams requestParams) {
                Intrinsics.checkNotNullParameter(requestParams, "params");
                requestParams.setLoadToMemory(false);
                requestParams.setEnableMemoryCache(false);
                requestParams.setNeedLocalFile(true);
            }
        });
        if (loadSync != null) {
            if (!loadSync.isSucceed()) {
                HybridLogger.e$default(HybridLogger.INSTANCE, this.TAG, "Forest load " + (lynxResourceType != null ? lynxResourceType.name() : null) + " failed", null, null, 12, null);
                if (callback != null) {
                    LynxResourceResponse onFailed2 = LynxResourceResponse.onFailed(new Throwable("Forest load " + (lynxResourceType != null ? lynxResourceType.name() : null) + " failed"));
                    Intrinsics.checkNotNull(onFailed2, "null cannot be cast to non-null type com.lynx.tasm.resourceprovider.LynxResourceResponse<kotlin.String>");
                    callback.onResponse(onFailed2);
                    return;
                }
                return;
            }
            String filePath = loadSync.getFilePath();
            if (filePath == null || filePath.length() == 0) {
                HybridLogger.e$default(HybridLogger.INSTANCE, this.TAG, "Forest's filePath is empty", null, null, 12, null);
                if (callback != null) {
                    LynxResourceResponse onFailed3 = LynxResourceResponse.onFailed(new Throwable("Forest's filePath is empty"));
                    Intrinsics.checkNotNull(onFailed3, "null cannot be cast to non-null type com.lynx.tasm.resourceprovider.LynxResourceResponse<kotlin.String>");
                    callback.onResponse(onFailed3);
                    return;
                }
                return;
            }
            try {
                if (lynxResourceType == LynxResourceRequest.LynxResourceType.LynxResourceTypeFont) {
                    String filePath2 = loadSync.getFilePath();
                    Intrinsics.checkNotNull(filePath2);
                    Typeface m35xd6589bf8 = m35xd6589bf8(new File(filePath2));
                    if (m35xd6589bf8 != null) {
                        Intrinsics.checkNotNullExpressionValue(m35xd6589bf8, "createFromFile(File(response.filePath!!))");
                        FontCacheHelper.INSTANCE.setFontCache(url, m35xd6589bf8);
                        HybridLogger.e$default(HybridLogger.INSTANCE, this.TAG, "Forest cache font for " + url, null, null, 12, null);
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
                    Unit unit = Unit.INSTANCE;
                }
            } catch (Exception e) {
                String message = e.getMessage();
                if (message != null) {
                    HybridLogger.e$default(HybridLogger.INSTANCE, this.TAG, message, null, null, 12, null);
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        }
    }

    @Proxy("createFromFile")
    @TargetClass("android.graphics.Typeface")
    /* renamed from: INVOKESTATIC_com_bytedance_ies_bullet_lynx_resource_forest_ForestLynxGenericResourceProvider_com_bytedance_sysoptimizer_TypeFaceLancet_createFromFile */
    public static Typeface m35xd6589bf8(File file) {
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
