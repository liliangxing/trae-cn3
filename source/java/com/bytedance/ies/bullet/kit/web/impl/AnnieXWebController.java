package com.bytedance.ies.bullet.kit.web.impl;

import android.app.Application;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.android.anniex.monitor.MonitorManager;
import com.bytedance.android.anniex.web.model.AnnieXWebModel;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.postprocessor.ProcessedResponse;
import com.bytedance.ies.bullet.base.constants.GlobalPropertiesConstants;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.BulletEnv;
import com.bytedance.ies.bullet.forest.ForestLoader;
import com.bytedance.ies.bullet.forest.ForestWebInfoHelper;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoader;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoaderUtils;
import com.bytedance.ies.bullet.kit.resourceloader.config.TaskContext;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.bytedance.ies.bullet.kit.web.download.WebResourceDownloader;
import com.bytedance.ies.bullet.kit.web.impl.util.WebViewUtils;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.ies.bullet.service.base.ResourceType;
import com.bytedance.ies.bullet.service.base.api.BidConstants;
import com.bytedance.ies.bullet.service.base.api.IServiceToken;
import com.bytedance.ies.bullet.service.base.resourceloader.config.CustomLoaderConfig;
import com.bytedance.ies.bullet.service.base.resourceloader.config.LoaderType;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import com.bytedance.ies.bullet.service.base.web.IWebViewDelegate;
import com.bytedance.ies.bullet.service.base.web.WebViewDelegateConfig;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import com.bytedance.ies.bullet.service.webkit.WebKitService;
import com.bytedance.perf.monitor.ReportConst;
import com.bytedance.webx.precreate.util.PreCreateUtil;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.resourceprovider.LynxResourceRequest;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXWebController.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0007J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0018H\u0007J6\u0010\u001d\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00182\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001aH\u0003J\u0006\u0010\"\u001a\u00020#R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006$"}, d2 = {"Lcom/bytedance/ies/bullet/kit/web/impl/AnnieXWebController;", "Lcom/bytedance/ies/bullet/forest/ForestWebInfoHelper;", "kitService", "Lcom/bytedance/ies/bullet/service/webkit/WebKitService;", "(Lcom/bytedance/ies/bullet/service/webkit/WebKitService;)V", "userAgent", "", "webViewDelegate", "Lcom/bytedance/ies/bullet/service/base/web/IWebViewDelegate;", "getWebViewDelegate", "()Lcom/bytedance/ies/bullet/service/base/web/IWebViewDelegate;", "setWebViewDelegate", "(Lcom/bytedance/ies/bullet/service/base/web/IWebViewDelegate;)V", "createWebView", "Lcom/bytedance/ies/bullet/kit/web/SSWebView;", "context", "Landroid/content/Context;", GlobalPropertiesConstants.IS_PRE_CREATE, "", "webView", "Landroid/webkit/WebView;", "loadResource", "Landroid/webkit/WebResourceResponse;", "annieXWebModel", "Lcom/bytedance/android/anniex/web/model/AnnieXWebModel;", "request", "Landroid/webkit/WebResourceRequest;", "url", "model", "realLoadResource", ReportConst.KEY_SCENE, "Lcom/bytedance/forest/model/Scene;", "useForest", "webRequest", "release", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class AnnieXWebController implements ForestWebInfoHelper {
    private final WebKitService kitService;
    private String userAgent;
    private IWebViewDelegate webViewDelegate;

    /* compiled from: AnnieXWebController.kt */
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

    public final void release() {
    }

    public AnnieXWebController(WebKitService webKitService) {
        Intrinsics.checkNotNullParameter(webKitService, "kitService");
        this.kitService = webKitService;
        this.webViewDelegate = webKitService.createWebDelegate(new WebViewDelegateConfig());
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

    public final IWebViewDelegate getWebViewDelegate() {
        return this.webViewDelegate;
    }

    public final void setWebViewDelegate(IWebViewDelegate iWebViewDelegate) {
        Intrinsics.checkNotNullParameter(iWebViewDelegate, "<set-?>");
        this.webViewDelegate = iWebViewDelegate;
    }

    public final SSWebView createWebView(Context context) {
        SSWebView createWebView;
        Intrinsics.checkNotNullParameter(context, "context");
        Object provideWebView$default = IWebViewDelegate.DefaultImpls.provideWebView$default(this.webViewDelegate, context, null, 2, null);
        if (provideWebView$default instanceof SSWebView) {
            createWebView = (SSWebView) provideWebView$default;
        } else {
            if (IConditionCallKt.enableFlowPageContextFix()) {
                context = new MutableContextWrapper(context);
            }
            createWebView = WebViewUtils.INSTANCE.createWebView(context);
        }
        this.webViewDelegate.setWebView((WebView) createWebView);
        this.userAgent = createWebView.getSettings().getUserAgentString();
        return createWebView;
    }

    public final boolean isPreCreate(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        return PreCreateUtil.isPreCreate(webView);
    }

    public final WebResourceResponse loadResource(String url, AnnieXWebModel model) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(model, "model");
        if (!Uri.parse(url).isHierarchical()) {
            return null;
        }
        SchemaModelUnion schemaModelUnion = model.getSchemaModelUnion();
        Pair canInterceptByForest$default = ForestWebInfoHelper.DefaultImpls.canInterceptByForest$default(this, url, false, null, null, schemaModelUnion, 14, null);
        boolean booleanValue = ((Boolean) canInterceptByForest$default.component1()).booleanValue();
        Scene scene = (Scene) canInterceptByForest$default.component2();
        if (!useForest(schemaModelUnion) || !booleanValue) {
        }
        return realLoadResource$default(this, url, scene, false, model, null, 16, null);
    }

    public final WebResourceResponse loadResource(AnnieXWebModel annieXWebModel, WebResourceRequest request) {
        Intrinsics.checkNotNullParameter(annieXWebModel, "annieXWebModel");
        Intrinsics.checkNotNullParameter(request, "request");
        Uri url = request.getUrl();
        if (!(url != null && url.isHierarchical())) {
            return null;
        }
        SchemaModelUnion schemaModelUnion = annieXWebModel.getSchemaModelUnion();
        Pair canInterceptByForest$default = ForestWebInfoHelper.DefaultImpls.canInterceptByForest$default(this, request, null, null, schemaModelUnion, 6, null);
        boolean booleanValue = ((Boolean) canInterceptByForest$default.component1()).booleanValue();
        Scene scene = (Scene) canInterceptByForest$default.component2();
        String uri = request.getUrl().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "request.url.toString()");
        return realLoadResource$default(this, uri, scene, useForest(schemaModelUnion) && booleanValue, annieXWebModel, null, 16, null);
    }

    static /* synthetic */ WebResourceResponse realLoadResource$default(AnnieXWebController annieXWebController, String str, Scene scene, boolean z, AnnieXWebModel annieXWebModel, WebResourceRequest webResourceRequest, int i, Object obj) {
        if ((i & 16) != 0) {
            webResourceRequest = null;
        }
        return annieXWebController.realLoadResource(str, scene, z, annieXWebModel, webResourceRequest);
    }

    private final WebResourceResponse realLoadResource(String url, Scene scene, boolean useForest, AnnieXWebModel model, WebResourceRequest webRequest) {
        String str;
        WebResourceResponse loadLocalDiskResponse;
        Response loadSync;
        WebResourceResponse webResourceResponse = null;
        webResourceResponse = null;
        if (Intrinsics.areEqual(model.getBusinessId(), BidConstants.WEBCAST) && !useForest) {
            return null;
        }
        if (scene == Scene.WEB_MAIN_DOCUMENT) {
            MonitorManager.INSTANCE.onPrepareTemplateBegin(model.getSessionId());
        }
        TaskConfig taskConfig = new TaskConfig(null, 1, null);
        taskConfig.setWebRequest(webRequest);
        taskConfig.setInjectedUserAgent(this.userAgent);
        CustomLoaderConfig customLoaderConfig = new CustomLoaderConfig(false);
        customLoaderConfig.setLoaderSequence(CollectionsKt.mutableListOf(new LoaderType[]{LoaderType.GECKO, LoaderType.BUILTIN}));
        taskConfig.setLoaderConfig(customLoaderConfig);
        taskConfig.setTaskContext(TaskContext.INSTANCE.from(model.getServiceContext().getAllDependency()));
        taskConfig.setBid(model.getBusinessId());
        taskConfig.setResTag("web");
        if (useForest) {
            loadSync = r1.loadSync((r17 & 1) != 0 ? ForestLoader.INSTANCE.getDefault() : null, url, (r17 & 4) != 0 ? null : forestDownloadEngine((IServiceToken) model), scene, model.getSessionId(), (r17 & 32) != 0 ? null : taskConfig, (r17 & 64) != 0 ? null : null);
            if (loadSync != null) {
                HybridLogger.d$default(HybridLogger.INSTANCE, "forest-web", "forest resp: " + loadSync, null, null, 12, null);
                String sourceType = loadSync.getSourceType(loadSync.getFrom());
                webResourceResponse = loadSync.provideWebResourceResponse();
                str = sourceType;
            }
            str = null;
        } else {
            WebResourceResponse cacheResource = WebResourceDownloader.INSTANCE.getInstance().getCacheResource(url);
            if (cacheResource == null) {
                ResourceInfo loadSync2 = ResourceLoader.with$default(ResourceLoader.INSTANCE, this.kitService.getBid(), null, 2, null).loadSync(url, taskConfig);
                if (loadSync2 != null) {
                    String filePath = loadSync2.getFilePath();
                    if (!(!(filePath == null || filePath.length() == 0))) {
                        loadSync2 = null;
                    }
                    if (loadSync2 != null) {
                        WebResourceResponse webResourceResponse2 = loadSync2.getWebResourceResponse();
                        if (webResourceResponse2 == null) {
                            ResourceType type = loadSync2.getType();
                            int i = type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
                            if (i == 1) {
                                loadLocalDiskResponse = ResourceLoaderUtils.INSTANCE.loadLocalDiskResponse(loadSync2.getFilePath());
                            } else if (i == 2) {
                                ResourceLoaderUtils resourceLoaderUtils = ResourceLoaderUtils.INSTANCE;
                                Application application = BulletEnv.INSTANCE.getInstance().getApplication();
                                loadLocalDiskResponse = resourceLoaderUtils.loadLocalAssetResponse(application != null ? application.getAssets() : null, loadSync2.getFilePath());
                            }
                            webResourceResponse = loadLocalDiskResponse;
                        } else {
                            webResourceResponse = webResourceResponse2;
                        }
                        str = loadSync2.getStatisticFrom();
                    }
                }
                str = null;
            } else {
                str = null;
                webResourceResponse = cacheResource;
            }
        }
        if (scene == Scene.WEB_MAIN_DOCUMENT && webResourceResponse != null) {
            if (str != null) {
                model.getBulletContext().getResourceContext().setResFrom(str);
            }
            MonitorManager.INSTANCE.onWebPrepareTemplateEnd(model.getSessionId(), model.getBulletContext().getResourceContext());
        }
        return webResourceResponse;
    }
}
