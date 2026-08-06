package com.bytedance.ies.bullet.lynx.resource;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.forest.chain.fetchers.GeckoXAdapter;
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
import com.bytedance.ies.bullet.kit.resourceloader.ResourceUriHelperKt;
import com.bytedance.ies.bullet.kit.resourceloader.config.TaskContext;
import com.bytedance.ies.bullet.kit.resourceloader.loader.CDNLoader;
import com.bytedance.ies.bullet.preloadv2.redirect.RedirectManager;
import com.bytedance.ies.bullet.preloadv2.utils.PreloadLogger;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.ies.bullet.service.base.api.IServiceToken;
import com.bytedance.ies.bullet.service.base.resourceloader.config.CustomLoaderConfig;
import com.bytedance.ies.bullet.service.base.resourceloader.config.LoaderType;
import com.bytedance.ies.bullet.service.base.resourceloader.config.RLOptimiseConfig;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import com.bytedance.kit.nglynx.compatible.CompatibleUtil;
import com.facebook.common.references.CloseableReference;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.resourceprovider.LynxResourceCallback;
import com.lynx.tasm.resourceprovider.LynxResourceRequest;
import com.lynx.tasm.resourceprovider.LynxResourceResponse;
import com.lynx.tasm.resourceprovider.media.LynxMediaResourceFetcher;
import com.lynx.tasm.resourceprovider.media.OptionalBool;
import java.io.Closeable;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: DefaultMediaResourceProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\"\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0016J*\u0010\u0013\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0014\u001a\u00020\u00072\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u0016J\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\u001b\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/resource/DefaultMediaResourceProvider;", "Lcom/lynx/tasm/resourceprovider/media/LynxMediaResourceFetcher;", "Lcom/bytedance/ies/bullet/forest/ForestInfoHelper;", "token", "Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;", "(Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;)V", "TAG", "", "mWeakToken", "Ljava/lang/ref/WeakReference;", "useForest", "", "fetchImage", "", "request", "Lcom/lynx/tasm/resourceprovider/LynxResourceRequest;", "callback", "Lcom/lynx/tasm/resourceprovider/LynxResourceCallback;", "Ljava/io/Closeable;", "fetchLynxImageFromForest", "url", "containerId", "taskConfig", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/TaskConfig;", "isLocalResource", "Lcom/lynx/tasm/resourceprovider/media/OptionalBool;", "redirectWithPipeline", "shouldRedirectUrl", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class DefaultMediaResourceProvider extends LynxMediaResourceFetcher implements ForestInfoHelper {
    private final String TAG;
    private WeakReference<IServiceToken> mWeakToken;
    private final IServiceToken token;
    private final boolean useForest;

    public DefaultMediaResourceProvider(IServiceToken iServiceToken) {
        Intrinsics.checkNotNullParameter(iServiceToken, "token");
        this.token = iServiceToken;
        this.TAG = "DefaultMediaResourceProvider";
        this.mWeakToken = new WeakReference<>(iServiceToken);
        this.useForest = useForest(iServiceToken);
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

    public String shouldRedirectUrl(LynxResourceRequest request) {
        String redirectWithPipeline;
        Uri parse = Uri.parse(request != null ? request.getUrl() : null);
        if (!this.useForest) {
            CompatibleUtil compatibleUtil = CompatibleUtil.INSTANCE;
            WeakReference<IServiceToken> weakReference = this.mWeakToken;
            String bdlynxCompatible$anniex_release = compatibleUtil.bdlynxCompatible$anniex_release(parse, weakReference != null ? weakReference.get() : null);
            String str = bdlynxCompatible$anniex_release;
            if (!(!(str == null || str.length() == 0))) {
                bdlynxCompatible$anniex_release = null;
            }
            if (bdlynxCompatible$anniex_release != null) {
                return bdlynxCompatible$anniex_release;
            }
        }
        String url = request != null ? request.getUrl() : null;
        if (!(!TextUtils.isEmpty(url))) {
            url = null;
        }
        if (url != null && (redirectWithPipeline = redirectWithPipeline(url)) != null) {
            if (!(!equals(url))) {
                redirectWithPipeline = null;
            }
            if (redirectWithPipeline != null) {
                return redirectWithPipeline;
            }
        }
        String url2 = request != null ? request.getUrl() : null;
        if (!(url2 == null || url2.length() == 0)) {
            List listOf = CollectionsKt.listOf(new String[]{"http", "https", "file", "content", "res", "data"});
            String scheme = parse.getScheme();
            if (scheme == null) {
                scheme = "";
            }
            if (listOf.contains(scheme)) {
                String url3 = request != null ? request.getUrl() : null;
                return url3 == null ? "" : url3;
            }
            if (Intrinsics.areEqual(parse.getScheme(), SchemaConstants.QUERY_KEY_BUNDLE) || Intrinsics.areEqual(parse.getScheme(), ResourceUriHelperKt.AUTHORITY_RELATIVE)) {
                parse.getPath();
            } else if (request != null) {
                request.getUrl();
            }
        }
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void fetchImage(LynxResourceRequest request, LynxResourceCallback<Closeable> callback) {
        CloseableReference closeableReference;
        String url;
        String url2;
        if (this.useForest) {
            boolean z = false;
            if (request != null && (url2 = request.getUrl()) != null && StringsKt.startsWith$default(url2, "base64:", false, 2, (Object) null)) {
                z = true;
            }
            if (z) {
                return;
            }
            WeakReference<IServiceToken> weakReference = this.mWeakToken;
            String sessionID = sessionID(weakReference != null ? weakReference.get() : null);
            if (request != null && (url = request.getUrl()) != null) {
                Response fetchImageCache = ForestLoader.INSTANCE.fetchImageCache(sessionID, url);
                if (fetchImageCache == null || (closeableReference = fetchImageCache.getImage()) == null) {
                    fetchLynxImageFromForest$default(this, url, sessionID, null, 4, null);
                    Response fetchImageCache2 = ForestLoader.INSTANCE.fetchImageCache(sessionID, url);
                    if (fetchImageCache2 != null) {
                        closeableReference = fetchImageCache2.getImage();
                    }
                }
                HybridLogger.i$default(HybridLogger.INSTANCE, this.TAG, "Forest preload image " + (closeableReference != null ? CDNLoader.PIPELINE_STATUS_FAILED : "success") + " for " + (request != null ? request.getUrl() : null) + " on " + sessionID, null, null, 12, null);
                if (closeableReference != null || callback == null) {
                }
                callback.onResponse(LynxResourceResponse.onSuccess(closeableReference));
                return;
            }
            closeableReference = null;
            HybridLogger.i$default(HybridLogger.INSTANCE, this.TAG, "Forest preload image " + (closeableReference != null ? CDNLoader.PIPELINE_STATUS_FAILED : "success") + " for " + (request != null ? request.getUrl() : null) + " on " + sessionID, null, null, 12, null);
            if (closeableReference != null) {
            }
        }
    }

    public OptionalBool isLocalResource(String url) {
        String str = url;
        if ((str == null || str.length() == 0) || (!StringsKt.startsWith$default(url, "http://", false, 2, (Object) null) && !StringsKt.startsWith$default(url, "https://", false, 2, (Object) null))) {
            return OptionalBool.FALSE;
        }
        if (GeckoXAdapter.Companion.isCDNMultiVersionResource(url) || GeckoXAdapter.Companion.canParsed(url)) {
            return OptionalBool.TRUE;
        }
        return OptionalBool.FALSE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0189, code lost:
    
        if (r3 != null) goto L91;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String redirectWithPipeline(String url) {
        List<String> emptyList;
        String str;
        String str2;
        IServiceToken iServiceToken;
        String str3;
        IServiceToken iServiceToken2;
        IServiceToken iServiceToken3;
        IServiceToken iServiceToken4;
        RLOptimiseConfig rLOptimiseConfig;
        IServiceToken iServiceToken5;
        IServiceToken iServiceToken6;
        String str4;
        IServiceToken iServiceToken7;
        long currentTimeMillis = System.currentTimeMillis();
        PreloadLogger.INSTANCE.m43i("redirectWithPipeline URL:" + url + ",defaultCache:" + RedirectManager.INSTANCE.getDefaultCache());
        String str5 = url;
        if (!(str5 == null || str5.length() == 0)) {
            if (!StringsKt.startsWith$default(url, "file://", false, 2, (Object) null) && !StringsKt.startsWith$default(url, "data:", false, 2, (Object) null)) {
                WeakReference<IServiceToken> weakReference = this.mWeakToken;
                String sessionID = sessionID(weakReference != null ? weakReference.get() : null);
                String redirectPath = RedirectManager.INSTANCE.getRedirectPath(this.useForest ? ForestLoader.INSTANCE.getForestPreloadKey(url) : url);
                if (redirectPath != null) {
                    RedirectManager redirectManager = RedirectManager.INSTANCE;
                    WeakReference<IServiceToken> weakReference2 = this.mWeakToken;
                    if (weakReference2 == null || (iServiceToken7 = weakReference2.get()) == null || (str4 = iServiceToken7.getMBid()) == null) {
                        str4 = "default_bid";
                    }
                    redirectManager.reportRedirect(str4, url, redirectPath, true, System.currentTimeMillis() - currentTimeMillis);
                    return redirectPath;
                }
                TaskConfig taskConfig = new TaskConfig(null, 1, null);
                TaskContext.Companion companion = TaskContext.INSTANCE;
                WeakReference<IServiceToken> weakReference3 = this.mWeakToken;
                taskConfig.setTaskContext(companion.from((weakReference3 == null || (iServiceToken6 = weakReference3.get()) == null) ? null : iServiceToken6.getAllDependency()));
                CustomLoaderConfig.Companion companion2 = CustomLoaderConfig.INSTANCE;
                WeakReference<IServiceToken> weakReference4 = this.mWeakToken;
                CustomLoaderConfig from = companion2.from((weakReference4 == null || (iServiceToken5 = weakReference4.get()) == null) ? null : (CustomLoaderConfig) iServiceToken5.getDependency(CustomLoaderConfig.class));
                if (from == null) {
                    from = new CustomLoaderConfig(true);
                }
                WeakReference<IServiceToken> weakReference5 = this.mWeakToken;
                if (weakReference5 == null || (iServiceToken4 = weakReference5.get()) == null || (rLOptimiseConfig = (RLOptimiseConfig) iServiceToken4.getDependency(RLOptimiseConfig.class)) == null || (emptyList = rLOptimiseConfig.getSpecifiedPrefix()) == null) {
                    emptyList = CollectionsKt.emptyList();
                }
                taskConfig.setSpecifiedPrefix(emptyList);
                from.setLoaderSequence(CollectionsKt.mutableListOf(new LoaderType[]{LoaderType.GECKO, LoaderType.BUILTIN}));
                taskConfig.setLoaderConfig(from);
                WeakReference<IServiceToken> weakReference6 = this.mWeakToken;
                if (weakReference6 == null || (iServiceToken3 = weakReference6.get()) == null || (str = iServiceToken3.getMBid()) == null) {
                    str = "";
                }
                taskConfig.setBid(str);
                taskConfig.setResTag("sub_resource");
                if (this.useForest && !StringsKt.startsWith$default(url, "base64:", false, 2, (Object) null)) {
                    str2 = fetchLynxImageFromForest(url, sessionID, taskConfig);
                } else {
                    ResourceLoader resourceLoader = ResourceLoader.INSTANCE;
                    WeakReference<IServiceToken> weakReference7 = this.mWeakToken;
                    ResourceInfo loadSync = ResourceLoader.with$default(resourceLoader, (weakReference7 == null || (iServiceToken = weakReference7.get()) == null) ? null : iServiceToken.getMBid(), null, 2, null).loadSync(url, taskConfig);
                    if (loadSync != null) {
                        String filePath = loadSync.getFilePath();
                        ResourceInfo resourceInfo = filePath != null && (StringsKt.isBlank(filePath) ^ true) ? loadSync : null;
                        if (resourceInfo != null) {
                            RedirectManager redirectManager2 = RedirectManager.INSTANCE;
                            String filePath2 = resourceInfo.getFilePath();
                            Intrinsics.checkNotNull(filePath2);
                            str2 = redirectManager2.wrapRedirectPath(filePath2, resourceInfo.getType());
                        }
                    }
                    str2 = url;
                }
                String str6 = str2;
                if (((str6 == null || str6.length() == 0) || Intrinsics.areEqual(str2, url)) && GeckoXAdapter.Companion.isCDNMultiVersionResource(url)) {
                    str2 = GeckoXAdapter.Companion.addCommonParamsForCDNMultiVersionURL(url);
                }
                String str7 = str2;
                if (RedirectManager.INSTANCE.getDefaultCache()) {
                    PreloadLogger.INSTANCE.m43i("redirectWithPipeline putRedirectPath URL:" + url + ",redirectUrl:" + str7 + ", useForest=" + this.useForest);
                    RedirectManager.INSTANCE.putRedirectPath(url, str7);
                }
                RedirectManager redirectManager3 = RedirectManager.INSTANCE;
                WeakReference<IServiceToken> weakReference8 = this.mWeakToken;
                if (weakReference8 == null || (iServiceToken2 = weakReference8.get()) == null || (str3 = iServiceToken2.getMBid()) == null) {
                    str3 = "default_bid";
                }
                redirectManager3.reportRedirect(str3, url, str7, false, System.currentTimeMillis() - currentTimeMillis);
                return str7;
            }
        }
        return url;
    }

    static /* synthetic */ String fetchLynxImageFromForest$default(DefaultMediaResourceProvider defaultMediaResourceProvider, String str, String str2, TaskConfig taskConfig, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            taskConfig = null;
        }
        return defaultMediaResourceProvider.fetchLynxImageFromForest(str, str2, taskConfig);
    }

    private final String fetchLynxImageFromForest(String url, String containerId, TaskConfig taskConfig) {
        String filePath;
        Response fetchImageCache = ForestLoader.INSTANCE.fetchImageCache(containerId, url);
        if (fetchImageCache == null) {
            ForestLoader forestLoader = ForestLoader.INSTANCE;
            WeakReference<IServiceToken> weakReference = this.mWeakToken;
            fetchImageCache = forestLoader.loadSync((r17 & 1) != 0 ? forestLoader.getDefault() : null, url, (r17 & 4) != 0 ? null : forestDownloadEngine(weakReference != null ? weakReference.get() : null), Scene.LYNX_IMAGE, containerId, (r17 & 32) != 0 ? null : taskConfig, (r17 & 64) != 0 ? null : new Function1<RequestParams, Unit>() { // from class: com.bytedance.ies.bullet.lynx.resource.DefaultMediaResourceProvider$fetchLynxImageFromForest$response$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((RequestParams) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(RequestParams requestParams) {
                    Intrinsics.checkNotNullParameter(requestParams, "requestParams");
                    requestParams.setDisableCdn(true);
                    requestParams.setCheckGeckoFileAvailable(false);
                }
            });
        }
        if (fetchImageCache != null && (filePath = fetchImageCache.getFilePath()) != null) {
            if (!(!StringsKt.isBlank(filePath))) {
                filePath = null;
            }
            if (filePath != null) {
                RedirectManager redirectManager = RedirectManager.INSTANCE;
                String from = fetchImageCache.getFrom();
                r1 = from != ResourceFrom.MEMORY ? from : null;
                if (r1 == null) {
                    r1 = fetchImageCache.getOriginFrom();
                }
                r1 = redirectManager.wrapRedirectPath(filePath, (ResourceFrom) r1);
            }
        }
        if (fetchImageCache != null) {
            ForestLoader forestLoader2 = ForestLoader.INSTANCE;
            if (r1 != null) {
                url = r1;
            }
            forestLoader2.putImageToCache(containerId, url, fetchImageCache);
        }
        return r1;
    }
}
