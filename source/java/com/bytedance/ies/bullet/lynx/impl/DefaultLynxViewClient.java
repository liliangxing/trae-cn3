package com.bytedance.ies.bullet.lynx.impl;

import android.content.Context;
import android.net.Uri;
import com.bytedance.forest.chain.fetchers.GeckoXAdapter;
import com.bytedance.forest.model.RequestParams;
import com.bytedance.forest.model.ResourceFrom;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.postprocessor.ProcessedResponse;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.forest.ForestInfoHelper;
import com.bytedance.ies.bullet.forest.ForestLoader;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoader;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceUriHelperKt;
import com.bytedance.ies.bullet.kit.resourceloader.config.TaskContext;
import com.bytedance.ies.bullet.kit.resourceloader.loader.CDNLoader;
import com.bytedance.ies.bullet.lynx.init.LynxSdkMonitor;
import com.bytedance.ies.bullet.preloadv2.redirect.RedirectManager;
import com.bytedance.ies.bullet.preloadv2.utils.PreloadLogger;
import com.bytedance.ies.bullet.service.base.BulletLogger;
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
import com.lynx.tasm.LynxConfigInfo;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.LynxPerfMetric;
import com.lynx.tasm.LynxViewClient;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.behavior.ImageInterceptor;
import com.lynx.tasm.resourceprovider.LynxResourceRequest;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.xml.transform.Transformer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: DefaultLynxViewClient.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J*\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002JF\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00152\b\u0010\u001e\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\u001bH\u0016J\b\u0010'\u001a\u00020\u001bH\u0016J\u0012\u0010(\u001a\u00020\u001b2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010+\u001a\u00020\u001bH\u0016J\u0012\u0010,\u001a\u00020\u001b2\b\u0010-\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010.\u001a\u00020\u001bH\u0016J\b\u0010/\u001a\u00020\u001bH\u0016J$\u00100\u001a\u00020\u001b2\b\u00101\u001a\u0004\u0018\u00010\u00152\b\u00102\u001a\u0004\u0018\u00010\u00152\u0006\u00103\u001a\u000204H\u0016J\u0012\u00105\u001a\u00020\u001b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u00106\u001a\u00020\u001bH\u0016J\u0012\u00107\u001a\u00020\u001b2\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u0018\u0010:\u001a\u00020\u001b2\u000e\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010<H\u0016J\u0012\u0010=\u001a\u00020\u001b2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\b\u0010@\u001a\u00020\u001bH\u0016J\u0012\u0010A\u001a\u00020\u001b2\b\u0010>\u001a\u0004\u0018\u00010BH\u0016J\u0012\u0010C\u001a\u00020\u001b2\b\u0010>\u001a\u0004\u0018\u00010BH\u0016J\u001e\u0010D\u001a\u00020\u001b2\u0014\u0010E\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020G\u0018\u00010FH\u0016J>\u0010H\u001a\u00020\u001b2\u0014\u0010E\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020G\u0018\u00010F2\u0014\u0010I\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020J\u0018\u00010F2\b\u0010K\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010L\u001a\u00020\u001bH\u0016J\u0012\u0010M\u001a\u00020\u001b2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0014\u0010N\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002J\u0014\u0010O\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006P"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/impl/DefaultLynxViewClient;", "Lcom/lynx/tasm/LynxViewClient;", "Lcom/bytedance/ies/bullet/forest/ForestInfoHelper;", "initDelegates", "", "token", "Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;", "(Ljava/util/List;Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;)V", "context", "delegates", "getDelegates", "()Ljava/util/List;", "setDelegates", "(Ljava/util/List;)V", "uri", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "setUri", "(Landroid/net/Uri;)V", "fetchLynxImageFromForest", "", "url", "containerId", "taskConfig", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/TaskConfig;", "loadImage", "", "Landroid/content/Context;", "cacheKey", "src", "width", "", "height", "transformer", "Ljavax/xml/transform/Transformer;", "handler", "Lcom/lynx/tasm/behavior/ImageInterceptor$CompletionHandler;", "onDataUpdated", "onDestroy", "onFirstLoadPerfReady", "metric", "Lcom/lynx/tasm/LynxPerfMetric;", "onFirstScreen", "onLoadFailed", "message", "onLoadSuccess", "onLynxViewAndJSRuntimeDestroy", "onModuleMethodInvoked", "module", "method", CDNLoader.DIAGNOSE_ERROR_CODE, "", "onPageStart", "onPageUpdate", "onReceivedError", "error", "Lcom/lynx/tasm/LynxError;", "onReportComponentInfo", "mComponentSet", "", "onReportLynxConfigInfo", "info", "Lcom/lynx/tasm/LynxConfigInfo;", "onRuntimeReady", "onScrollStart", "Lcom/lynx/tasm/LynxViewClient$ScrollInfo;", "onScrollStop", "onTimingSetup", "timingInfo", "", "", "onTimingUpdate", "updateTiming", "", "flag", "onUpdateDataWithoutChange", "onUpdatePerfReady", "redirectWithPipeline", "shouldRedirectImageUrl", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class DefaultLynxViewClient extends LynxViewClient implements ForestInfoHelper {
    private final IServiceToken context;
    private List<LynxViewClient> delegates;
    private Uri uri;

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

    public DefaultLynxViewClient(List<LynxViewClient> list, IServiceToken iServiceToken) {
        Intrinsics.checkNotNullParameter(list, "initDelegates");
        this.delegates = list;
        this.context = iServiceToken;
    }

    public final List<LynxViewClient> getDelegates() {
        return this.delegates;
    }

    public final void setDelegates(List<LynxViewClient> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.delegates = list;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final void setUri(Uri uri) {
        this.uri = uri;
    }

    public void onPageStart(String url) {
        Iterator<T> it = this.delegates.iterator();
        while (it.hasNext()) {
            ((LynxViewClient) it.next()).onPageStart(url);
        }
        this.uri = url != null ? Uri.parse(url) : null;
    }

    public void onUpdatePerfReady(LynxPerfMetric metric) {
        Iterator<T> it = this.delegates.iterator();
        while (it.hasNext()) {
            ((LynxViewClient) it.next()).onUpdatePerfReady(metric);
        }
    }

    public void onScrollStart(LynxViewClient.ScrollInfo info) {
        Iterator<T> it = this.delegates.iterator();
        while (it.hasNext()) {
            ((LynxViewClient) it.next()).onScrollStart(info);
        }
    }

    public void onScrollStop(LynxViewClient.ScrollInfo info) {
        Iterator<T> it = this.delegates.iterator();
        while (it.hasNext()) {
            ((LynxViewClient) it.next()).onScrollStop(info);
        }
    }

    public void onTimingSetup(Map<String, Object> timingInfo) {
        Iterator<T> it = this.delegates.iterator();
        while (it.hasNext()) {
            ((LynxViewClient) it.next()).onTimingSetup(timingInfo);
        }
    }

    public void onTimingUpdate(Map<String, Object> timingInfo, Map<String, Long> updateTiming, String flag) {
        Iterator<T> it = this.delegates.iterator();
        while (it.hasNext()) {
            ((LynxViewClient) it.next()).onTimingUpdate(timingInfo, updateTiming, flag);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void loadImage(Context context, String cacheKey, String src, float width, float height, Transformer transformer, ImageInterceptor.CompletionHandler handler) {
        CloseableReference closeableReference;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(handler, "handler");
        if (useForest(this.context)) {
            boolean z = false;
            if (src != null && StringsKt.startsWith$default(src, "base64:", false, 2, (Object) null)) {
                z = true;
            }
            if (!z) {
                String sessionID = sessionID(this.context);
                if (src != null) {
                    Response fetchImageCache = ForestLoader.INSTANCE.fetchImageCache(sessionID, src);
                    if (fetchImageCache == null || (closeableReference = fetchImageCache.getImage()) == null) {
                        fetchLynxImageFromForest$default(this, src, sessionID, null, 4, null);
                        Response fetchImageCache2 = ForestLoader.INSTANCE.fetchImageCache(sessionID, src);
                        if (fetchImageCache2 != null) {
                            closeableReference = fetchImageCache2.getImage();
                        }
                    }
                    BulletLogger.printLog$default(BulletLogger.INSTANCE, "Forest preload image " + (closeableReference != null ? CDNLoader.PIPELINE_STATUS_FAILED : "success") + " for " + src + " on " + sessionID, null, null, 6, null);
                    if (closeableReference != null) {
                        handler.imageLoadCompletion(closeableReference, (Throwable) null);
                        return;
                    }
                }
                closeableReference = null;
                BulletLogger.printLog$default(BulletLogger.INSTANCE, "Forest preload image " + (closeableReference != null ? CDNLoader.PIPELINE_STATUS_FAILED : "success") + " for " + src + " on " + sessionID, null, null, 6, null);
                if (closeableReference != null) {
                }
            }
        }
        Iterator<T> it = this.delegates.iterator();
        while (it.hasNext()) {
            ((LynxViewClient) it.next()).loadImage(context, cacheKey, src, width, height, transformer, handler);
        }
    }

    public void onRuntimeReady() {
        Iterator<T> it = this.delegates.iterator();
        while (it.hasNext()) {
            ((LynxViewClient) it.next()).onRuntimeReady();
        }
    }

    public void onReceivedError(LynxError error) {
        Iterator<T> it = this.delegates.iterator();
        while (it.hasNext()) {
            ((LynxViewClient) it.next()).onReceivedError(error);
        }
    }

    public void onLoadFailed(String message) {
        Iterator<T> it = this.delegates.iterator();
        while (it.hasNext()) {
            ((LynxViewClient) it.next()).onLoadFailed(message);
        }
    }

    public void onPageUpdate() {
        Iterator<T> it = this.delegates.iterator();
        while (it.hasNext()) {
            ((LynxViewClient) it.next()).onPageUpdate();
        }
    }

    public void onDataUpdated() {
        Iterator<T> it = this.delegates.iterator();
        while (it.hasNext()) {
            ((LynxViewClient) it.next()).onDataUpdated();
        }
    }

    public void onUpdateDataWithoutChange() {
        Iterator<T> it = this.delegates.iterator();
        while (it.hasNext()) {
            ((LynxViewClient) it.next()).onUpdateDataWithoutChange();
        }
    }

    public void onModuleMethodInvoked(String module, String method, int error_code) {
        Iterator<T> it = this.delegates.iterator();
        while (it.hasNext()) {
            ((LynxViewClient) it.next()).onModuleMethodInvoked(module, method, error_code);
        }
    }

    public void onFirstLoadPerfReady(LynxPerfMetric metric) {
        Iterator<T> it = this.delegates.iterator();
        while (it.hasNext()) {
            ((LynxViewClient) it.next()).onFirstLoadPerfReady(metric);
        }
    }

    public String shouldRedirectImageUrl(String url) {
        Iterator<T> it = this.delegates.iterator();
        while (it.hasNext()) {
            String shouldRedirectImageUrl = ((LynxViewClient) it.next()).shouldRedirectImageUrl(url);
            if (shouldRedirectImageUrl != null) {
                return shouldRedirectImageUrl;
            }
        }
        Uri parse = Uri.parse(url);
        if (!useForest(this.context)) {
            String bdlynxCompatible$anniex_release = CompatibleUtil.INSTANCE.bdlynxCompatible$anniex_release(parse, this.context);
            String str = bdlynxCompatible$anniex_release;
            if (!(!(str == null || str.length() == 0))) {
                bdlynxCompatible$anniex_release = null;
            }
            if (bdlynxCompatible$anniex_release != null) {
                return bdlynxCompatible$anniex_release;
            }
        }
        String redirectWithPipeline = redirectWithPipeline(url);
        if (redirectWithPipeline != null) {
            if (!(!equals(url))) {
                redirectWithPipeline = null;
            }
            if (redirectWithPipeline != null) {
                return redirectWithPipeline;
            }
        }
        String str2 = url;
        if (!(str2 == null || str2.length() == 0)) {
            List listOf = CollectionsKt.listOf(new String[]{"http", "https", "file", "content", "res", "data"});
            String scheme = parse.getScheme();
            if (scheme == null) {
                scheme = "";
            }
            if (listOf.contains(scheme)) {
                return url;
            }
            if (Intrinsics.areEqual(parse.getScheme(), SchemaConstants.QUERY_KEY_BUNDLE) || Intrinsics.areEqual(parse.getScheme(), ResourceUriHelperKt.AUTHORITY_RELATIVE)) {
                parse.getPath();
            }
        }
        return null;
    }

    public void onLoadSuccess() {
        Iterator<T> it = this.delegates.iterator();
        while (it.hasNext()) {
            ((LynxViewClient) it.next()).onLoadSuccess();
        }
    }

    public void onFirstScreen() {
        Iterator<T> it = this.delegates.iterator();
        while (it.hasNext()) {
            ((LynxViewClient) it.next()).onFirstScreen();
        }
    }

    public void onDestroy() {
        Iterator<T> it = this.delegates.iterator();
        while (it.hasNext()) {
            ((LynxViewClient) it.next()).onDestroy();
        }
    }

    public void onLynxViewAndJSRuntimeDestroy() {
        Iterator<T> it = this.delegates.iterator();
        while (it.hasNext()) {
            ((LynxViewClient) it.next()).onLynxViewAndJSRuntimeDestroy();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:83:0x0155, code lost:
    
        if (r4 != null) goto L75;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String redirectWithPipeline(String url) {
        List<String> emptyList;
        String str;
        String str2;
        String str3;
        RLOptimiseConfig rLOptimiseConfig;
        String str4;
        long currentTimeMillis = System.currentTimeMillis();
        PreloadLogger.INSTANCE.m43i("redirectWithPipeline URL:" + url + ",defaultCache:" + RedirectManager.INSTANCE.getDefaultCache());
        String str5 = url;
        if (!(str5 == null || str5.length() == 0)) {
            if (!StringsKt.startsWith$default(url, "file://", false, 2, (Object) null) && !StringsKt.startsWith$default(url, "data:", false, 2, (Object) null)) {
                String sessionID = sessionID(this.context);
                boolean useForest = useForest(this.context);
                String redirectPath = RedirectManager.INSTANCE.getRedirectPath(useForest ? ForestLoader.INSTANCE.getForestPreloadKey(url) : url);
                if (redirectPath != null) {
                    RedirectManager redirectManager = RedirectManager.INSTANCE;
                    IServiceToken iServiceToken = this.context;
                    if (iServiceToken == null || (str4 = iServiceToken.getMBid()) == null) {
                        str4 = "default_bid";
                    }
                    redirectManager.reportRedirect(str4, url, redirectPath, true, System.currentTimeMillis() - currentTimeMillis);
                    return redirectPath;
                }
                TaskConfig taskConfig = new TaskConfig(null, 1, null);
                TaskContext.Companion companion = TaskContext.INSTANCE;
                IServiceToken iServiceToken2 = this.context;
                taskConfig.setTaskContext(companion.from(iServiceToken2 != null ? iServiceToken2.getAllDependency() : null));
                CustomLoaderConfig.Companion companion2 = CustomLoaderConfig.INSTANCE;
                IServiceToken iServiceToken3 = this.context;
                CustomLoaderConfig from = companion2.from(iServiceToken3 != null ? (CustomLoaderConfig) iServiceToken3.getDependency(CustomLoaderConfig.class) : null);
                if (from == null) {
                    from = new CustomLoaderConfig(true);
                }
                IServiceToken iServiceToken4 = this.context;
                if (iServiceToken4 == null || (rLOptimiseConfig = (RLOptimiseConfig) iServiceToken4.getDependency(RLOptimiseConfig.class)) == null || (emptyList = rLOptimiseConfig.getSpecifiedPrefix()) == null) {
                    emptyList = CollectionsKt.emptyList();
                }
                taskConfig.setSpecifiedPrefix(emptyList);
                from.setLoaderSequence(CollectionsKt.mutableListOf(new LoaderType[]{LoaderType.GECKO, LoaderType.BUILTIN}));
                taskConfig.setLoaderConfig(from);
                IServiceToken iServiceToken5 = this.context;
                if (iServiceToken5 == null || (str = iServiceToken5.getMBid()) == null) {
                    str = "";
                }
                taskConfig.setBid(str);
                taskConfig.setResTag("sub_resource");
                if (useForest && !StringsKt.startsWith$default(url, "base64:", false, 2, (Object) null)) {
                    str2 = fetchLynxImageFromForest(url, sessionID, taskConfig);
                } else {
                    ResourceLoader resourceLoader = ResourceLoader.INSTANCE;
                    IServiceToken iServiceToken6 = this.context;
                    ResourceInfo loadSync = ResourceLoader.with$default(resourceLoader, iServiceToken6 != null ? iServiceToken6.getMBid() : null, null, 2, null).loadSync(url, taskConfig);
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
                    PreloadLogger.INSTANCE.m43i("redirectWithPipeline putRedirectPath URL:" + url + ",redirectUrl:" + str7 + ", useForest=" + useForest);
                    RedirectManager.INSTANCE.putRedirectPath(url, str7);
                }
                RedirectManager redirectManager3 = RedirectManager.INSTANCE;
                IServiceToken iServiceToken7 = this.context;
                if (iServiceToken7 == null || (str3 = iServiceToken7.getMBid()) == null) {
                    str3 = "default_bid";
                }
                redirectManager3.reportRedirect(str3, url, str7, false, System.currentTimeMillis() - currentTimeMillis);
                return str7;
            }
        }
        return url;
    }

    static /* synthetic */ String fetchLynxImageFromForest$default(DefaultLynxViewClient defaultLynxViewClient, String str, String str2, TaskConfig taskConfig, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            taskConfig = null;
        }
        return defaultLynxViewClient.fetchLynxImageFromForest(str, str2, taskConfig);
    }

    private final String fetchLynxImageFromForest(String url, String containerId, TaskConfig taskConfig) {
        String filePath;
        Response fetchImageCache = ForestLoader.INSTANCE.fetchImageCache(containerId, url);
        if (fetchImageCache == null) {
            fetchImageCache = r1.loadSync((r17 & 1) != 0 ? ForestLoader.INSTANCE.getDefault() : null, url, (r17 & 4) != 0 ? null : forestDownloadEngine(this.context), Scene.LYNX_IMAGE, containerId, (r17 & 32) != 0 ? null : taskConfig, (r17 & 64) != 0 ? null : new Function1<RequestParams, Unit>() { // from class: com.bytedance.ies.bullet.lynx.impl.DefaultLynxViewClient$fetchLynxImageFromForest$response$1
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
                r14 = from != ResourceFrom.MEMORY ? from : null;
                if (r14 == null) {
                    r14 = fetchImageCache.getOriginFrom();
                }
                r14 = redirectManager.wrapRedirectPath(filePath, (ResourceFrom) r14);
            }
        }
        if (fetchImageCache != null) {
            ForestLoader forestLoader = ForestLoader.INSTANCE;
            if (r14 != null) {
                url = r14;
            }
            forestLoader.putImageToCache(containerId, url, fetchImageCache);
        }
        return r14;
    }

    public void onReportLynxConfigInfo(LynxConfigInfo info) {
        super.onReportLynxConfigInfo(info);
        LynxSdkMonitor.onReportLynxConfigInfo(info);
    }

    public void onReportComponentInfo(Set<String> mComponentSet) {
        super.onReportComponentInfo(mComponentSet);
        LynxSdkMonitor.onReportComponentInfo(mComponentSet);
    }
}
