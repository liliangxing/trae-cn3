package com.bytedance.ies.bullet.web.pia;

import android.app.Application;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.bytedance.forest.model.RequestParams;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.pollyfill.ForestNetAPI;
import com.bytedance.forest.postprocessor.ProcessedResponse;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.BulletEnv;
import com.bytedance.ies.bullet.forest.ForestLoader;
import com.bytedance.ies.bullet.forest.ForestWebInfoHelper;
import com.bytedance.ies.bullet.kit.resourceloader.LoadTask;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoader;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoaderService;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoaderUtils;
import com.bytedance.ies.bullet.kit.resourceloader.config.TaskContext;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.ies.bullet.service.base.ResourceType;
import com.bytedance.ies.bullet.service.base.api.BidConstants;
import com.bytedance.ies.bullet.service.base.api.IServiceToken;
import com.bytedance.ies.bullet.service.base.resourceloader.config.CustomLoaderConfig;
import com.bytedance.ies.bullet.service.base.resourceloader.config.LoaderType;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import com.bytedance.pia.core.api.resource.IResourceLoader;
import com.bytedance.pia.core.api.resource.IResourceRequest;
import com.bytedance.pia.core.api.resource.IResourceResponse;
import com.bytedance.pia.core.api.resource.LoadFrom;
import com.bytedance.pia.core.api.utils.IConsumer;
import com.bytedance.pia.core.api.utils.IReleasable;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.resourceprovider.LynxResourceRequest;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PiaResourceLoader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0014\u0015B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u001a\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0017J6\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0011H\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ies/bullet/web/pia/PiaResourceLoader;", "Lcom/bytedance/pia/core/api/resource/IResourceLoader;", "Lcom/bytedance/ies/bullet/forest/ForestWebInfoHelper;", "bid", "", "config", "Lcom/bytedance/ies/bullet/web/pia/PiaResourceLoader$Config;", "(Ljava/lang/String;Lcom/bytedance/ies/bullet/web/pia/PiaResourceLoader$Config;)V", "load", "Lcom/bytedance/pia/core/api/resource/IResourceResponse;", "loadFrom", "Lcom/bytedance/pia/core/api/resource/LoadFrom;", "request", "Lcom/bytedance/pia/core/api/resource/IResourceRequest;", "loadAsync", "Lcom/bytedance/pia/core/api/utils/IReleasable;", "resolve", "Lcom/bytedance/pia/core/api/utils/IConsumer;", "reject", "", "Config", "PIAWebResourceRequest", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PiaResourceLoader implements IResourceLoader, ForestWebInfoHelper {
    private final String bid;
    private final Config config;

    /* compiled from: PiaResourceLoader.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ResourceType.values().length];
            try {
                iArr[ResourceType.DISK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ResourceType.ASSET.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public PiaResourceLoader(String str, Config config) {
        Intrinsics.checkNotNullParameter(str, "bid");
        this.bid = str;
        this.config = config;
    }

    public /* synthetic */ PiaResourceLoader(String str, Config config, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : config);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestWebInfoHelper
    public Pair<Boolean, Scene> canInterceptByForest(WebResourceRequest webResourceRequest, IServiceToken iServiceToken, BulletContext bulletContext, SchemaModelUnion schemaModelUnion) {
        return ForestWebInfoHelper.DefaultImpls.canInterceptByForest(this, webResourceRequest, iServiceToken, bulletContext, schemaModelUnion);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestWebInfoHelper
    public Pair<Boolean, Scene> canInterceptByForest(String str, boolean z, IServiceToken iServiceToken, BulletContext bulletContext, SchemaModelUnion schemaModelUnion) {
        return ForestWebInfoHelper.DefaultImpls.canInterceptByForest(this, str, z, iServiceToken, bulletContext, schemaModelUnion);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean delayPreload(Uri uri) {
        return ForestWebInfoHelper.DefaultImpls.delayPreload(this, uri);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean delayPreload(BulletContext bulletContext) {
        return ForestWebInfoHelper.DefaultImpls.delayPreload(this, bulletContext);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean delayPreload(SchemaModelUnion schemaModelUnion) {
        return ForestWebInfoHelper.DefaultImpls.delayPreload(this, schemaModelUnion);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String forestDownloadEngine(Uri uri) {
        return ForestWebInfoHelper.DefaultImpls.forestDownloadEngine(this, uri);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String forestDownloadEngine(BulletContext bulletContext) {
        return ForestWebInfoHelper.DefaultImpls.forestDownloadEngine(this, bulletContext);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String forestDownloadEngine(IServiceToken iServiceToken) {
        return ForestWebInfoHelper.DefaultImpls.forestDownloadEngine(this, iServiceToken);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String forestDownloadEngine(SchemaModelUnion schemaModelUnion) {
        return ForestWebInfoHelper.DefaultImpls.forestDownloadEngine(this, schemaModelUnion);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String getResTag(LynxResourceRequest.LynxResourceType lynxResourceType) {
        return ForestWebInfoHelper.DefaultImpls.getResTag(this, lynxResourceType);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public Scene getSceneType(LynxResourceRequest.LynxResourceType lynxResourceType) {
        return ForestWebInfoHelper.DefaultImpls.getSceneType(this, lynxResourceType);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public ProcessedResponse<TemplateBundle> getTemplateBundleResponse(Response response) {
        return ForestWebInfoHelper.DefaultImpls.getTemplateBundleResponse(this, response);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean hasGeckoModelInfo(BulletContext bulletContext) {
        return ForestWebInfoHelper.DefaultImpls.hasGeckoModelInfo(this, bulletContext);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean hasGeckoModelInfo(IServiceToken iServiceToken) {
        return ForestWebInfoHelper.DefaultImpls.hasGeckoModelInfo(this, iServiceToken);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean hasGeckoModelInfo(SchemaModelUnion schemaModelUnion) {
        return ForestWebInfoHelper.DefaultImpls.hasGeckoModelInfo(this, schemaModelUnion);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String preloadScope(Uri uri) {
        return ForestWebInfoHelper.DefaultImpls.preloadScope(this, uri);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String preloadScope(BulletContext bulletContext) {
        return ForestWebInfoHelper.DefaultImpls.preloadScope(this, bulletContext);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String preloadScope(SchemaModelUnion schemaModelUnion) {
        return ForestWebInfoHelper.DefaultImpls.preloadScope(this, schemaModelUnion);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String sessionID(BulletContext bulletContext) {
        return ForestWebInfoHelper.DefaultImpls.sessionID(this, bulletContext);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String sessionID(IServiceToken iServiceToken) {
        return ForestWebInfoHelper.DefaultImpls.sessionID(this, iServiceToken);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean useForest(Uri uri) {
        return ForestWebInfoHelper.DefaultImpls.useForest(this, uri);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean useForest(BulletContext bulletContext) {
        return ForestWebInfoHelper.DefaultImpls.useForest(this, bulletContext);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean useForest(IServiceToken iServiceToken) {
        return ForestWebInfoHelper.DefaultImpls.useForest(this, iServiceToken);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean useForest(SchemaModelUnion schemaModelUnion) {
        return ForestWebInfoHelper.DefaultImpls.useForest(this, schemaModelUnion);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x012f, code lost:
    
        if (r2 != null) goto L41;
     */
    @Override // com.bytedance.pia.core.api.resource.IResourceLoader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public IResourceResponse load(final LoadFrom loadFrom, IResourceRequest request) {
        Response loadSync;
        WebResourceResponse webResourceResponse;
        Map responseHttpHeader;
        String forestDownloadEngine;
        Intrinsics.checkNotNullParameter(loadFrom, "loadFrom");
        Intrinsics.checkNotNullParameter(request, "request");
        Config config = this.config;
        SchemaModelUnion schemaModelUnion = config != null ? config.getSchemaModelUnion() : null;
        boolean useForest = schemaModelUnion != null ? useForest(schemaModelUnion) : useForest(request.getUrl());
        if (Intrinsics.areEqual(this.bid, BidConstants.WEBCAST) && !useForest) {
            return null;
        }
        if (useForest) {
            String uri = request.getUrl().toString();
            Intrinsics.checkNotNullExpressionValue(uri, "request.url.toString()");
            Scene scene = (Scene) ForestWebInfoHelper.DefaultImpls.canInterceptByForest$default(this, uri, request.isForMainFrame(), null, null, schemaModelUnion, 12, null).getSecond();
            TaskConfig taskConfig = new TaskConfig(null, 1, null);
            CustomLoaderConfig customLoaderConfig = new CustomLoaderConfig(false);
            customLoaderConfig.setLoaderSequence(CollectionsKt.mutableListOf(new LoaderType[]{LoaderType.GECKO, LoaderType.BUILTIN}));
            taskConfig.setLoaderConfig(customLoaderConfig);
            Config config2 = this.config;
            taskConfig.setInjectedUserAgent(config2 != null ? config2.getUserAgent() : null);
            taskConfig.setWebRequest(new PIAWebResourceRequest(request));
            taskConfig.setTaskContext(TaskContext.INSTANCE.from(null));
            taskConfig.setBid(this.bid);
            taskConfig.setResTag("web");
            ForestLoader forestLoader = ForestLoader.INSTANCE;
            String forestDownloadEngine2 = (schemaModelUnion == null || (forestDownloadEngine = forestDownloadEngine(schemaModelUnion)) == null) ? forestDownloadEngine(request.getUrl()) : forestDownloadEngine;
            Config config3 = this.config;
            loadSync = forestLoader.loadSync((r17 & 1) != 0 ? forestLoader.getDefault() : null, uri, (r17 & 4) != 0 ? null : forestDownloadEngine2, scene, config3 != null ? config3.getSessionId() : null, (r17 & 32) != 0 ? null : taskConfig, (r17 & 64) != 0 ? null : new Function1<RequestParams, Unit>() { // from class: com.bytedance.ies.bullet.web.pia.PiaResourceLoader$load$response$2

                /* compiled from: PiaResourceLoader.kt */
                @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
                /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
                public /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                    static {
                        int[] iArr = new int[LoadFrom.values().length];
                        try {
                            iArr[LoadFrom.Online.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            iArr[LoadFrom.Offline.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        $EnumSwitchMapping$0 = iArr;
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((RequestParams) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(RequestParams requestParams) {
                    Intrinsics.checkNotNullParameter(requestParams, "params");
                    int i = WhenMappings.$EnumSwitchMapping$0[LoadFrom.this.ordinal()];
                    if (i == 1) {
                        requestParams.setOnlyOnline(true);
                    } else {
                        if (i != 2) {
                            return;
                        }
                        requestParams.setOnlyLocal(true);
                    }
                }
            });
            if (loadSync != null) {
                HybridLogger.i$default(HybridLogger.INSTANCE, "forest-web", "forest resp: " + loadSync, null, null, 12, null);
                ForestNetAPI.HttpResponse httpResponse = loadSync.getHttpResponse();
                if (httpResponse != null && (responseHttpHeader = httpResponse.getResponseHttpHeader()) != null) {
                }
                webResourceResponse = loadSync.provideWebResourceResponse();
            }
            webResourceResponse = new WebResourceResponse("", "", null);
            PiaHelper.INSTANCE.toIResourceResponse(webResourceResponse, loadFrom);
            return null;
        }
        if (LoadFrom.Online == loadFrom) {
            return null;
        }
        ResourceLoaderService with$default = ResourceLoader.with$default(ResourceLoader.INSTANCE, this.bid, null, 2, null);
        String uri2 = request.getUrl().toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "request.url.toString()");
        TaskConfig taskConfig2 = new TaskConfig(null, 1, null);
        CustomLoaderConfig customLoaderConfig2 = new CustomLoaderConfig(true);
        customLoaderConfig2.setLoaderSequence(CollectionsKt.mutableListOf(new LoaderType[]{LoaderType.GECKO, LoaderType.BUILTIN}));
        taskConfig2.setLoaderConfig(customLoaderConfig2);
        taskConfig2.setResTag("web");
        Unit unit = Unit.INSTANCE;
        ResourceInfo loadSync2 = with$default.loadSync(uri2, taskConfig2);
        if (loadSync2 == null) {
            return null;
        }
        String filePath = loadSync2.getFilePath();
        if (!(!(filePath == null || filePath.length() == 0))) {
            loadSync2 = null;
        }
        if (loadSync2 == null) {
            return null;
        }
        WebResourceResponse webResourceResponse2 = loadSync2.getWebResourceResponse();
        if (webResourceResponse2 == null) {
            ResourceType type = loadSync2.getType();
            int i = type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
            if (i == 1) {
                webResourceResponse2 = ResourceLoaderUtils.INSTANCE.loadLocalDiskResponse(loadSync2.getFilePath());
            } else if (i != 2) {
                webResourceResponse2 = null;
            } else {
                ResourceLoaderUtils resourceLoaderUtils = ResourceLoaderUtils.INSTANCE;
                Application application = BulletEnv.INSTANCE.getInstance().getApplication();
                webResourceResponse2 = resourceLoaderUtils.loadLocalAssetResponse(application != null ? application.getAssets() : null, loadSync2.getFilePath());
            }
        }
        if (webResourceResponse2 != null) {
            return PiaHelper.INSTANCE.toIResourceResponse(webResourceResponse2, loadFrom);
        }
        return null;
    }

    @Override // com.bytedance.pia.core.api.resource.IResourceLoader
    public IReleasable loadAsync(final LoadFrom loadFrom, IResourceRequest request, final IConsumer<IResourceResponse> resolve, final IConsumer<Throwable> reject) {
        String forestDownloadEngine;
        Intrinsics.checkNotNullParameter(loadFrom, "loadFrom");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(resolve, "resolve");
        Intrinsics.checkNotNullParameter(reject, "reject");
        Config config = this.config;
        SchemaModelUnion schemaModelUnion = config != null ? config.getSchemaModelUnion() : null;
        boolean useForest = schemaModelUnion != null ? useForest(schemaModelUnion) : useForest(request.getUrl());
        if (Intrinsics.areEqual(this.bid, BidConstants.WEBCAST) && !useForest) {
            reject.accept(new Throwable("anniex pia config error, bid webcast MUST use Forest to load"));
            return new IReleasable() { // from class: com.bytedance.ies.bullet.web.pia.PiaResourceLoader$loadAsync$1
                @Override // com.bytedance.pia.core.api.utils.IReleasable
                public final void release() {
                }
            };
        }
        if (useForest) {
            String uri = request.getUrl().toString();
            Intrinsics.checkNotNullExpressionValue(uri, "request.url.toString()");
            Scene scene = (Scene) ForestWebInfoHelper.DefaultImpls.canInterceptByForest$default(this, uri, false, null, null, schemaModelUnion, 14, null).getSecond();
            TaskConfig taskConfig = new TaskConfig(null, 1, null);
            CustomLoaderConfig customLoaderConfig = new CustomLoaderConfig(false);
            customLoaderConfig.setLoaderSequence(CollectionsKt.mutableListOf(new LoaderType[]{LoaderType.GECKO, LoaderType.BUILTIN}));
            taskConfig.setLoaderConfig(customLoaderConfig);
            Config config2 = this.config;
            taskConfig.setInjectedUserAgent(config2 != null ? config2.getUserAgent() : null);
            taskConfig.setWebRequest(new PIAWebResourceRequest(request));
            taskConfig.setTaskContext(TaskContext.INSTANCE.from(null));
            taskConfig.setBid(this.bid);
            taskConfig.setResTag("web");
            ForestLoader forestLoader = ForestLoader.INSTANCE;
            String forestDownloadEngine2 = (schemaModelUnion == null || (forestDownloadEngine = forestDownloadEngine(schemaModelUnion)) == null) ? forestDownloadEngine(request.getUrl()) : forestDownloadEngine;
            Config config3 = this.config;
            forestLoader.loadAsync((r22 & 1) != 0 ? forestLoader.getDefault() : null, uri, (r22 & 4) != 0 ? null : forestDownloadEngine2, scene, config3 != null ? config3.getSessionId() : null, (r22 & 32) != 0 ? null : taskConfig, (r22 & 64) != 0 ? false : false, (r22 & 128) != 0 ? null : new Function1<RequestParams, Unit>() { // from class: com.bytedance.ies.bullet.web.pia.PiaResourceLoader$loadAsync$3

                /* compiled from: PiaResourceLoader.kt */
                @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
                /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
                public /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                    static {
                        int[] iArr = new int[LoadFrom.values().length];
                        try {
                            iArr[LoadFrom.Online.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            iArr[LoadFrom.Offline.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        $EnumSwitchMapping$0 = iArr;
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((RequestParams) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(RequestParams requestParams) {
                    Intrinsics.checkNotNullParameter(requestParams, "params");
                    int i = WhenMappings.$EnumSwitchMapping$0[LoadFrom.this.ordinal()];
                    if (i == 1) {
                        requestParams.setOnlyOnline(true);
                    } else {
                        if (i != 2) {
                            return;
                        }
                        requestParams.setOnlyLocal(true);
                    }
                }
            }, new Function1<Response, Unit>() { // from class: com.bytedance.ies.bullet.web.pia.PiaResourceLoader$loadAsync$4
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
                    Map responseHttpHeader;
                    Intrinsics.checkNotNullParameter(response, "it");
                    if (response.isSucceed()) {
                        ForestNetAPI.HttpResponse httpResponse = response.getHttpResponse();
                        if (httpResponse != null && (responseHttpHeader = httpResponse.getResponseHttpHeader()) != null) {
                        }
                        IConsumer<IResourceResponse> iConsumer = resolve;
                        WebResourceResponse provideWebResourceResponse = response.provideWebResourceResponse();
                        iConsumer.accept(provideWebResourceResponse != null ? PiaHelper.INSTANCE.toIResourceResponse(provideWebResourceResponse, loadFrom) : null);
                        return;
                    }
                    reject.accept(new Throwable("anniex pia load resource error"));
                }
            });
            return new IReleasable() { // from class: com.bytedance.ies.bullet.web.pia.PiaResourceLoader$loadAsync$5
                @Override // com.bytedance.pia.core.api.utils.IReleasable
                public final void release() {
                }
            };
        }
        if (LoadFrom.Online == loadFrom) {
            reject.accept(new Throwable("ResourceLoader can not load online resource in web"));
            return new IReleasable() { // from class: com.bytedance.ies.bullet.web.pia.PiaResourceLoader$loadAsync$6
                @Override // com.bytedance.pia.core.api.utils.IReleasable
                public final void release() {
                }
            };
        }
        ResourceLoaderService with$default = ResourceLoader.with$default(ResourceLoader.INSTANCE, this.bid, null, 2, null);
        String uri2 = request.getUrl().toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "request.url.toString()");
        TaskConfig taskConfig2 = new TaskConfig(null, 1, null);
        CustomLoaderConfig customLoaderConfig2 = new CustomLoaderConfig(true);
        customLoaderConfig2.setLoaderSequence(CollectionsKt.mutableListOf(new LoaderType[]{LoaderType.GECKO, LoaderType.BUILTIN}));
        taskConfig2.setLoaderConfig(customLoaderConfig2);
        taskConfig2.setResTag("web");
        Unit unit = Unit.INSTANCE;
        final LoadTask loadAsync = with$default.loadAsync(uri2, taskConfig2, new Function1<ResourceInfo, Unit>() { // from class: com.bytedance.ies.bullet.web.pia.PiaResourceLoader$loadAsync$loadTask$2

            /* compiled from: PiaResourceLoader.kt */
            @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
            /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[ResourceType.values().length];
                    try {
                        iArr[ResourceType.DISK.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[ResourceType.ASSET.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ResourceInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(ResourceInfo resourceInfo) {
                Intrinsics.checkNotNullParameter(resourceInfo, "_resourceInfo");
                String filePath = resourceInfo.getFilePath();
                if (!(!(filePath == null || filePath.length() == 0))) {
                    resourceInfo = null;
                }
                if (resourceInfo != null) {
                    IConsumer<IResourceResponse> iConsumer = resolve;
                    LoadFrom loadFrom2 = loadFrom;
                    WebResourceResponse webResourceResponse = resourceInfo.getWebResourceResponse();
                    if (webResourceResponse == null) {
                        ResourceType type = resourceInfo.getType();
                        int i = type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
                        if (i == 1) {
                            webResourceResponse = ResourceLoaderUtils.INSTANCE.loadLocalDiskResponse(resourceInfo.getFilePath());
                        } else if (i != 2) {
                            webResourceResponse = null;
                        } else {
                            ResourceLoaderUtils resourceLoaderUtils = ResourceLoaderUtils.INSTANCE;
                            Application application = BulletEnv.INSTANCE.getInstance().getApplication();
                            webResourceResponse = resourceLoaderUtils.loadLocalAssetResponse(application != null ? application.getAssets() : null, resourceInfo.getFilePath());
                        }
                    }
                    iConsumer.accept(webResourceResponse != null ? PiaHelper.INSTANCE.toIResourceResponse(webResourceResponse, loadFrom2) : null);
                }
            }
        }, new Function1<Throwable, Unit>() { // from class: com.bytedance.ies.bullet.web.pia.PiaResourceLoader$loadAsync$loadTask$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "it");
                reject.accept(th);
            }
        });
        return new IReleasable() { // from class: com.bytedance.ies.bullet.web.pia.PiaResourceLoader$loadAsync$7
            @Override // com.bytedance.pia.core.api.utils.IReleasable
            public final void release() {
                String str;
                ResourceLoader resourceLoader = ResourceLoader.INSTANCE;
                str = PiaResourceLoader.this.bid;
                ResourceLoader.with$default(resourceLoader, str, null, 2, null).cancel(loadAsync);
            }
        };
    }

    /* compiled from: PiaResourceLoader.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/bullet/web/pia/PiaResourceLoader$PIAWebResourceRequest;", "Landroid/webkit/WebResourceRequest;", "request", "Lcom/bytedance/pia/core/api/resource/IResourceRequest;", "(Lcom/bytedance/pia/core/api/resource/IResourceRequest;)V", "getMethod", "", "getRequestHeaders", "", "getUrl", "Landroid/net/Uri;", "hasGesture", "", "isForMainFrame", "isRedirect", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private static final class PIAWebResourceRequest implements WebResourceRequest {
        private final IResourceRequest request;

        @Override // android.webkit.WebResourceRequest
        public String getMethod() {
            return "GET";
        }

        @Override // android.webkit.WebResourceRequest
        public boolean hasGesture() {
            return false;
        }

        @Override // android.webkit.WebResourceRequest
        public boolean isRedirect() {
            return false;
        }

        public PIAWebResourceRequest(IResourceRequest iResourceRequest) {
            Intrinsics.checkNotNullParameter(iResourceRequest, "request");
            this.request = iResourceRequest;
        }

        @Override // android.webkit.WebResourceRequest
        public Uri getUrl() {
            Uri url = this.request.getUrl();
            Intrinsics.checkNotNullExpressionValue(url, "request.url");
            return url;
        }

        @Override // android.webkit.WebResourceRequest
        public boolean isForMainFrame() {
            return this.request.isForMainFrame();
        }

        @Override // android.webkit.WebResourceRequest
        public Map<String, String> getRequestHeaders() {
            Map<String, String> requestHeaders = this.request.getRequestHeaders();
            return requestHeaders == null ? new LinkedHashMap() : requestHeaders;
        }
    }

    /* compiled from: PiaResourceLoader.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ies/bullet/web/pia/PiaResourceLoader$Config;", "", "sessionId", "", "schemaModelUnion", "Lcom/bytedance/ies/bullet/service/schema/SchemaModelUnion;", "userAgent", "(Ljava/lang/String;Lcom/bytedance/ies/bullet/service/schema/SchemaModelUnion;Ljava/lang/String;)V", "getSchemaModelUnion", "()Lcom/bytedance/ies/bullet/service/schema/SchemaModelUnion;", "getSessionId", "()Ljava/lang/String;", "getUserAgent", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final /* data */ class Config {
        private final SchemaModelUnion schemaModelUnion;
        private final String sessionId;
        private final String userAgent;

        public Config() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ Config copy$default(Config config, String str, SchemaModelUnion schemaModelUnion, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = config.sessionId;
            }
            if ((i & 2) != 0) {
                schemaModelUnion = config.schemaModelUnion;
            }
            if ((i & 4) != 0) {
                str2 = config.userAgent;
            }
            return config.copy(str, schemaModelUnion, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getSessionId() {
            return this.sessionId;
        }

        /* renamed from: component2, reason: from getter */
        public final SchemaModelUnion getSchemaModelUnion() {
            return this.schemaModelUnion;
        }

        /* renamed from: component3, reason: from getter */
        public final String getUserAgent() {
            return this.userAgent;
        }

        public final Config copy(String sessionId, SchemaModelUnion schemaModelUnion, String userAgent) {
            return new Config(sessionId, schemaModelUnion, userAgent);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Config)) {
                return false;
            }
            Config config = (Config) other;
            return Intrinsics.areEqual(this.sessionId, config.sessionId) && Intrinsics.areEqual(this.schemaModelUnion, config.schemaModelUnion) && Intrinsics.areEqual(this.userAgent, config.userAgent);
        }

        public int hashCode() {
            String str = this.sessionId;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            SchemaModelUnion schemaModelUnion = this.schemaModelUnion;
            int hashCode2 = (hashCode + (schemaModelUnion == null ? 0 : schemaModelUnion.hashCode())) * 31;
            String str2 = this.userAgent;
            return hashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "Config(sessionId=" + this.sessionId + ", schemaModelUnion=" + this.schemaModelUnion + ", userAgent=" + this.userAgent + ')';
        }

        public Config(String str, SchemaModelUnion schemaModelUnion, String str2) {
            this.sessionId = str;
            this.schemaModelUnion = schemaModelUnion;
            this.userAgent = str2;
        }

        public /* synthetic */ Config(String str, SchemaModelUnion schemaModelUnion, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : schemaModelUnion, (i & 4) != 0 ? null : str2);
        }

        public final String getSessionId() {
            return this.sessionId;
        }

        public final SchemaModelUnion getSchemaModelUnion() {
            return this.schemaModelUnion;
        }

        public final String getUserAgent() {
            return this.userAgent;
        }
    }
}
