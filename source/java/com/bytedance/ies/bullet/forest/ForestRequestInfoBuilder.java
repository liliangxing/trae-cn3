package com.bytedance.ies.bullet.forest;

import android.app.Application;
import android.net.Uri;
import android.os.Looper;
import com.bytedance.android.anniex.ability.service.IAnnieXAccountService;
import com.bytedance.android.anniex.base.service.AnnieXServiceCenter;
import com.bytedance.android.anniex.web.api.AnnieXWebApi;
import com.bytedance.forest.Forest;
import com.bytedance.forest.model.DynamicType;
import com.bytedance.forest.model.GeckoConfig;
import com.bytedance.forest.model.RequestParams;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.pollyfill.NetWorker;
import com.bytedance.forest.utils.LoaderUtils;
import com.bytedance.ies.argus.api.ArgusGlobalDelegate;
import com.bytedance.ies.argus.api.params.InjectLoginStateParams;
import com.bytedance.ies.bullet.base.settings.ForestSettingsConfig;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoaderService;
import com.bytedance.ies.bullet.kit.resourceloader.config.TaskContext;
import com.bytedance.ies.bullet.prefetchv2.PrefetchSchemaParam;
import com.bytedance.ies.bullet.service.base.resourceloader.config.ExtraInfo;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import com.bytedance.ies.bullet.service.base.settings.IBulletSettingsService;
import com.bytedance.ies.bullet.service.base.standard.StandardServiceManager;
import com.bytedance.ies.bullet.service.base.utils.ExtKt;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.perf.monitor.ReportConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ForestRequestInfoBuilder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000 $2\u00020\u0001:\u0001$B\u0005¢\u0006\u0002\u0010\u0002JB\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007J\u001e\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00132\b\u0010\u000f\u001a\u0004\u0018\u00010\tJD\u0010\u0014\u001a\u00020\u00152\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002J0\u0010\u0017\u001a\u00020\u0018*\u00020\u00152\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\b\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\tH\u0002J$\u0010\u001c\u001a\u00020\u0018*\u00020\u00152\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J.\u0010\u001e\u001a\u00020\u0018*\u00020\u00152\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J0\u0010\u001f\u001a\u00020\u0018*\u00020\u00152\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0003J\u0018\u0010 \u001a\u00020\u0018*\u00020\u00152\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0003J\u0018\u0010!\u001a\u00020\u0018*\u00020\u00152\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0003J$\u0010\"\u001a\u00020\u0018*\u00020\u00152\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001aH\u0003J\u0016\u0010#\u001a\u00020\u0018*\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0003R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/bytedance/ies/bullet/forest/ForestRequestInfoBuilder;", "", "()V", "cache", "Lcom/bytedance/ies/bullet/forest/ForestContainerCache;", "Lcom/bytedance/ies/bullet/forest/RequestInfoCacheKey;", "Lcom/bytedance/ies/bullet/forest/ForestRequestInfo;", "build", "srcUrl", "", "isPreload", "", "downloadEngine", ReportConst.KEY_SCENE, "Lcom/bytedance/forest/model/Scene;", "containerId", "taskConfig", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/TaskConfig;", "clear", "Ljava/util/concurrent/ConcurrentHashMap;", "obtainDefaultRequestParams", "Lcom/bytedance/forest/model/RequestParams;", "cached", "addAnnieXAccessTokenHeader", "", "schemaUri", "Landroid/net/Uri;", "cdnUrl", "fetchCacheKeyInfluencingFactor", "cdnUri", "fetchCustomMaxAge", "fetchCustomizedPrefixes", "fetchDynamicInfo", "fetchGeckoInfo", "fetchLoaderConfig", "fetchLockInfo", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ForestRequestInfoBuilder {
    private static final Companion Companion = new Companion(null);
    private static final Scene[] MAIN_RES = {Scene.LYNX_TEMPLATE, Scene.WEB_MAIN_DOCUMENT};
    private static final String TAG = "ForestRequestInfoBuilder";
    private static final boolean enableResourceLock;
    private final ForestContainerCache<RequestInfoCacheKey, ForestRequestInfo> cache = new ForestContainerCache<>();

    /* compiled from: ForestRequestInfoBuilder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/bullet/forest/ForestRequestInfoBuilder$Companion;", "", "()V", "MAIN_RES", "", "Lcom/bytedance/forest/model/Scene;", "getMAIN_RES", "()[Lcom/bytedance/forest/model/Scene;", "[Lcom/bytedance/forest/model/Scene;", "TAG", "", "enableResourceLock", "", "getEnableResourceLock$anniex_release", "()Z", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Scene[] getMAIN_RES() {
            return ForestRequestInfoBuilder.MAIN_RES;
        }

        public final boolean getEnableResourceLock$anniex_release() {
            return ForestRequestInfoBuilder.enableResourceLock;
        }
    }

    static {
        ForestSettingsConfig forestSettingsConfig;
        boolean z = false;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService != null && (forestSettingsConfig = (ForestSettingsConfig) iBulletSettingsService.obtainSettings(ForestSettingsConfig.class)) != null) {
            z = Intrinsics.areEqual(forestSettingsConfig.getEnableSession(), true);
        }
        enableResourceLock = z;
    }

    public final ConcurrentHashMap<RequestInfoCacheKey, ForestRequestInfo> clear(String containerId) {
        return this.cache.clear(containerId);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x007f, code lost:
    
        if (r2 != null) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ForestRequestInfo build(String srcUrl, boolean isPreload, @DownloadEngine String downloadEngine, Scene scene, String containerId, TaskConfig taskConfig) {
        Uri uri;
        Set<Map.Entry<RequestInfoCacheKey, ForestRequestInfo>> entrySet;
        Object obj;
        ForestRequestInfo forestRequestInfo;
        Uri srcUri;
        String str;
        String cDN$default;
        ForestRequestInfo fetchCache;
        String bid;
        String bid2;
        Intrinsics.checkNotNullParameter(srcUrl, "srcUrl");
        Intrinsics.checkNotNullParameter(scene, ReportConst.KEY_SCENE);
        boolean contains = ArraysKt.contains(MAIN_RES, scene);
        if (contains) {
            srcUri = Uri.parse(srcUrl);
        } else {
            Map<RequestInfoCacheKey, ForestRequestInfo> fetchAll = this.cache.fetchAll(containerId);
            if (fetchAll != null && (entrySet = fetchAll.entrySet()) != null) {
                Iterator<T> it = entrySet.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (((ForestRequestInfo) ((Map.Entry) obj).getValue()).isMainResource()) {
                        break;
                    }
                }
                Map.Entry entry = (Map.Entry) obj;
                if (entry != null && (forestRequestInfo = (ForestRequestInfo) entry.getValue()) != null) {
                    srcUri = forestRequestInfo.getSrcUri();
                }
            }
            uri = null;
            if (taskConfig != null && (str = taskConfig.getCdnUrl()) != null) {
                if (!(str.length() <= 0)) {
                    str = null;
                }
            }
            str = !(contains ^ true) ? srcUrl : null;
            if (str == null) {
                str = uri != null ? uri.getQueryParameter("annie_x_url") : null;
                if (str == null) {
                    cDN$default = uri != null ? ExtKt.getCDN$default(uri, null, 1, null) : null;
                    Uri parse = cDN$default != null ? Uri.parse(cDN$default) : null;
                    RequestInfoCacheKey requestInfoCacheKey = new RequestInfoCacheKey(srcUrl, cDN$default);
                    fetchCache = this.cache.fetchCache(containerId, requestInfoCacheKey);
                    RequestParams obtainDefaultRequestParams = obtainDefaultRequestParams(downloadEngine, scene, containerId, taskConfig, isPreload, fetchCache != null ? fetchCache.getParams() : null);
                    if (fetchCache != null) {
                        return new ForestRequestInfo(fetchCache.getSrcUri(), fetchCache.getSrcUrl(), fetchCache.getCdnUrl(), obtainDefaultRequestParams, contains, (taskConfig == null || (bid2 = taskConfig.getBid()) == null) ? "default_bid" : bid2, containerId);
                    }
                    fetchLoaderConfig(obtainDefaultRequestParams, uri, parse);
                    fetchCustomMaxAge(obtainDefaultRequestParams, uri, parse, taskConfig);
                    fetchLockInfo(obtainDefaultRequestParams, uri);
                    if (!contains) {
                        fetchDynamicInfo(obtainDefaultRequestParams, uri);
                    } else if (LoaderUtils.INSTANCE.isNotNullOrEmpty(cDN$default)) {
                        fetchGeckoInfo(obtainDefaultRequestParams, uri);
                        fetchDynamicInfo(obtainDefaultRequestParams, uri);
                    }
                    fetchCustomizedPrefixes(obtainDefaultRequestParams, parse, uri, taskConfig);
                    fetchCacheKeyInfluencingFactor(obtainDefaultRequestParams, parse, uri);
                    addAnnieXAccessTokenHeader(obtainDefaultRequestParams, scene, uri, srcUrl, cDN$default);
                    if (contains) {
                        Intrinsics.checkNotNull(uri);
                    } else {
                        Intrinsics.checkNotNull(parse);
                        uri = parse;
                    }
                    ForestRequestInfo forestRequestInfo2 = new ForestRequestInfo(uri, srcUrl, cDN$default, obtainDefaultRequestParams, contains, (taskConfig == null || (bid = taskConfig.getBid()) == null) ? "default_bid" : bid, containerId);
                    this.cache.putToCache(containerId, requestInfoCacheKey, forestRequestInfo2);
                    return forestRequestInfo2;
                }
            }
            cDN$default = str;
            if (cDN$default != null) {
            }
            RequestInfoCacheKey requestInfoCacheKey2 = new RequestInfoCacheKey(srcUrl, cDN$default);
            fetchCache = this.cache.fetchCache(containerId, requestInfoCacheKey2);
            RequestParams obtainDefaultRequestParams2 = obtainDefaultRequestParams(downloadEngine, scene, containerId, taskConfig, isPreload, fetchCache != null ? fetchCache.getParams() : null);
            if (fetchCache != null) {
            }
        }
        uri = srcUri;
        if (taskConfig != null) {
            if (!(str.length() <= 0)) {
            }
        }
        if (!(contains ^ true)) {
        }
        if (str == null) {
        }
        cDN$default = str;
        if (cDN$default != null) {
        }
        RequestInfoCacheKey requestInfoCacheKey22 = new RequestInfoCacheKey(srcUrl, cDN$default);
        fetchCache = this.cache.fetchCache(containerId, requestInfoCacheKey22);
        RequestParams obtainDefaultRequestParams22 = obtainDefaultRequestParams(downloadEngine, scene, containerId, taskConfig, isPreload, fetchCache != null ? fetchCache.getParams() : null);
        if (fetchCache != null) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0017, code lost:
    
        if (r5.intValue() == 1) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void addAnnieXAccessTokenHeader(RequestParams requestParams, Scene scene, Uri uri, String str, String str2) {
        boolean z;
        IAnnieXAccountService service;
        String accessTokenForAuthPlatform;
        String queryParameter;
        if (uri != null && (queryParameter = uri.getQueryParameter("enable_access_token")) != null && (r5 = StringsKt.toIntOrNull(queryParameter)) != null) {
            z = true;
        }
        z = false;
        if (z) {
            if (!StringsKt.startsWith$default(str, "http://", false, 2, (Object) null) && !StringsKt.startsWith$default(str, "https://", false, 2, (Object) null) && str2 != null) {
                if (!LoaderUtils.INSTANCE.isNotNullOrEmpty(str2)) {
                    str2 = null;
                }
                if (str2 != null) {
                    str = str2;
                }
            }
            if (ArgusGlobalDelegate.Companion.getInstance().verifyInjectLoginState(new InjectLoginStateParams(str, InjectLoginStateParams.SceneType.FOREST)).isBlock() || (service = AnnieXServiceCenter.INSTANCE.getService("default_bid", IAnnieXAccountService.class)) == null || (accessTokenForAuthPlatform = service.accessTokenForAuthPlatform()) == null) {
                return;
            }
            requestParams.getInjectedHttpHeaders().put("X-Tt-Sass-Auth", accessTokenForAuthPlatform);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RequestParams obtainDefaultRequestParams(@DownloadEngine String downloadEngine, Scene scene, String containerId, TaskConfig taskConfig, boolean isPreload, RequestParams cached) {
        RequestParams requestParams;
        String str;
        Forest forest;
        Application application;
        String str2;
        Map<String, String> injectedHttpHeaders;
        if (cached != null) {
            requestParams = new RequestParams(cached, isPreload);
            requestParams.setResourceScene(scene);
        } else {
            requestParams = new RequestParams(scene);
        }
        requestParams.setWebResourceRequest(taskConfig != null ? taskConfig.getWebRequest() : null);
        boolean z = false;
        if (taskConfig == null || (str = taskConfig.getInjectedUserAgent()) == null) {
            if (!Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread()) || (!(scene == Scene.WEB_MAIN_DOCUMENT || scene == Scene.WEB_CHILD_RESOURCE) || (forest = ForestLoader.INSTANCE.getDefault()) == null || (application = forest.getApplication()) == null)) {
                str = null;
            } else {
                AnnieXWebApi annieXWebApi = AnnieXWebApi.INSTANCE;
                Application application2 = application;
                if (taskConfig == null || (str2 = taskConfig.getBid()) == null) {
                    str2 = "default_bid";
                }
                str = annieXWebApi.getWebViewUA$anniex_release(application2, false, str2);
            }
        }
        requestParams.setInjectedUserAgent(str);
        if (taskConfig != null && (injectedHttpHeaders = taskConfig.getInjectedHttpHeaders()) != null) {
            requestParams.getInjectedHttpHeaders().putAll(injectedHttpHeaders);
        }
        String accessKey = requestParams.getAccessKey();
        if (!Boolean.valueOf(accessKey.length() > 0).booleanValue()) {
            accessKey = null;
        }
        if (accessKey == null) {
            GeckoConfig majorGeckoConfigByBid = ForestConfigCenter.INSTANCE.majorGeckoConfigByBid(taskConfig != null ? taskConfig.getBid() : null);
            String accessKey2 = majorGeckoConfigByBid != null ? majorGeckoConfigByBid.getAccessKey() : null;
            accessKey = accessKey2 == null ? "" : accessKey2;
        }
        requestParams.setAccessKey(accessKey);
        if (scene != Scene.LYNX_IMAGE) {
            if (taskConfig != null ? taskConfig.getLoadToMemory() : true) {
                z = true;
            }
        }
        requestParams.setLoadToMemory(z);
        requestParams.setCheckGeckoFileAvailable(true);
        requestParams.setNetWorker(Intrinsics.areEqual(downloadEngine, ForestLoader.DOWNLOAD_ENGINE_DOWNLOADER) ? NetWorker.Downloader : NetWorker.TTNet);
        if (containerId != null) {
            requestParams.getCustomParams().put("rl_container_uuid", containerId);
        }
        return requestParams;
    }

    static /* synthetic */ void fetchLoaderConfig$default(ForestRequestInfoBuilder forestRequestInfoBuilder, RequestParams requestParams, Uri uri, Uri uri2, int i, Object obj) {
        if ((i & 1) != 0) {
            uri = null;
        }
        if ((i & 2) != 0) {
            uri2 = null;
        }
        forestRequestInfoBuilder.fetchLoaderConfig(requestParams, uri, uri2);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void fetchLoaderConfig(RequestParams requestParams, Uri uri, Uri uri2) {
        boolean areEqual;
        String queryParameter;
        Boolean valueOf;
        String queryParameter2;
        boolean z;
        boolean z2;
        String queryParameter3;
        boolean areEqual2;
        String queryParameter4;
        String queryParameter5;
        boolean z3;
        boolean valueOf2;
        String queryParameter6;
        String queryParameter7;
        boolean areEqual3;
        String queryParameter8;
        String queryParameter9;
        String queryParameter10;
        String queryParameter11;
        String queryParameter12;
        String queryParameter13;
        String queryParameter14;
        String queryParameter15;
        boolean z4;
        String queryParameter16;
        boolean areEqual4;
        String queryParameter17;
        String queryParameter18;
        String queryParameter19;
        String queryParameter20;
        String queryParameter21;
        String queryParameter22;
        String queryParameter23;
        String queryParameter24;
        String queryParameter25;
        String queryParameter26;
        if (uri == null && uri2 == null) {
            return;
        }
        boolean z5 = true;
        if (uri2 == null || (queryParameter26 = uri2.getQueryParameter(SchemaConstants.QUERY_KEY_READ_RES_INFO_IN_MAIN)) == null) {
            areEqual = (uri == null || (queryParameter = uri.getQueryParameter(SchemaConstants.QUERY_KEY_READ_RES_INFO_IN_MAIN)) == null) ? true : Intrinsics.areEqual(queryParameter, "1");
        } else {
            areEqual = Intrinsics.areEqual(queryParameter26, "1");
        }
        requestParams.setAllowIOOnMainThread(areEqual);
        if (uri2 == null || (queryParameter25 = uri2.getQueryParameter(SchemaConstants.QUERY_KEY_DISABLE_OFFLINE)) == null) {
            valueOf = (uri == null || (queryParameter2 = uri.getQueryParameter(SchemaConstants.QUERY_KEY_DISABLE_OFFLINE)) == null) ? null : Boolean.valueOf(Intrinsics.areEqual(queryParameter2, "1"));
        } else {
            valueOf = Boolean.valueOf(Intrinsics.areEqual(queryParameter25, "1"));
        }
        boolean z6 = false;
        if (!Intrinsics.areEqual(valueOf, true)) {
            if (!((uri2 == null || (queryParameter24 = uri2.getQueryParameter("disable_gecko")) == null) ? (uri == null || (queryParameter23 = uri.getQueryParameter("disable_gecko")) == null) ? false : Intrinsics.areEqual(queryParameter23, "1") : Intrinsics.areEqual(queryParameter24, "1"))) {
                z = false;
                requestParams.setDisableOffline(z);
                if (!Intrinsics.areEqual(valueOf, true)) {
                    if (!((uri2 == null || (queryParameter22 = uri2.getQueryParameter("disable_builtin")) == null) ? (uri == null || (queryParameter21 = uri.getQueryParameter("disable_builtin")) == null) ? false : Intrinsics.areEqual(queryParameter21, "1") : Intrinsics.areEqual(queryParameter22, "1"))) {
                        z2 = false;
                        requestParams.setDisableBuiltin(z2);
                        requestParams.setDisableCdn((uri2 != null || (queryParameter20 = uri2.getQueryParameter(PrefetchSchemaParam.PREFETCH_RES_FROM_DISABLE_CDN)) == null) ? (uri != null || (queryParameter3 = uri.getQueryParameter(PrefetchSchemaParam.PREFETCH_RES_FROM_DISABLE_CDN)) == null) ? false : Intrinsics.areEqual(queryParameter3, "1") : Intrinsics.areEqual(queryParameter20, "1"));
                        if (uri2 != null || (queryParameter19 = uri2.getQueryParameter("disable_gecko_update")) == null) {
                            areEqual2 = (uri != null || (queryParameter4 = uri.getQueryParameter("disable_gecko_update")) == null) ? false : Intrinsics.areEqual(queryParameter4, "1");
                        } else {
                            areEqual2 = Intrinsics.areEqual(queryParameter19, "1");
                        }
                        requestParams.setDisableGeckoUpdate(areEqual2);
                        requestParams.setOnlyLocal((uri2 != null || (queryParameter18 = uri2.getQueryParameter("only_local")) == null) ? (uri != null || (queryParameter5 = uri.getQueryParameter("only_local")) == null) ? false : Intrinsics.areEqual(queryParameter5, "1") : Intrinsics.areEqual(queryParameter18, "1"));
                        if (!Intrinsics.areEqual(valueOf, true)) {
                            if (uri2 != null && (queryParameter17 = uri2.getQueryParameter("disable_cdn_cache")) != null) {
                                areEqual4 = Intrinsics.areEqual(queryParameter17, "1");
                            } else if (uri == null || (queryParameter16 = uri.getQueryParameter("disable_cdn_cache")) == null) {
                                z4 = true;
                                if (z4) {
                                    z3 = true;
                                    requestParams.setEnableCDNCache(Boolean.valueOf(z3));
                                    if (uri2 != null || (queryParameter15 = uri2.getQueryParameter(ResourceLoaderService.ENABLE_MEMORY_CACHE)) == null) {
                                        valueOf2 = (uri != null || (queryParameter6 = uri.getQueryParameter(ResourceLoaderService.ENABLE_MEMORY_CACHE)) == null) ? true : Boolean.valueOf(Intrinsics.areEqual(queryParameter6, "1"));
                                    } else {
                                        valueOf2 = Boolean.valueOf(Intrinsics.areEqual(queryParameter15, "1"));
                                    }
                                    requestParams.setEnableMemoryCache(valueOf2);
                                    requestParams.setIgnoreWaitReusedRequest((uri2 != null || (queryParameter14 = uri2.getQueryParameter("ignore_wait_reused_request")) == null) ? (uri != null || (queryParameter7 = uri.getQueryParameter("ignore_wait_reused_request")) == null) ? false : Intrinsics.areEqual(queryParameter7, "1") : Intrinsics.areEqual(queryParameter14, "1"));
                                    if (uri2 != null || (queryParameter13 = uri2.getQueryParameter("streaming_load")) == null) {
                                        areEqual3 = (uri != null || (queryParameter8 = uri.getQueryParameter("streaming_load")) == null) ? false : Intrinsics.areEqual(queryParameter8, "1");
                                    } else {
                                        areEqual3 = Intrinsics.areEqual(queryParameter13, "1");
                                    }
                                    if (areEqual3 || (requestParams.getResourceScene() != Scene.WEB_MAIN_DOCUMENT && requestParams.getResourceScene() != Scene.WEB_CHILD_RESOURCE)) {
                                        z5 = false;
                                    }
                                    requestParams.setStreamingLoad(z5);
                                    requestParams.setUseConcurrentBuffer((uri2 != null || (queryParameter12 = uri2.getQueryParameter("forest_buffer_mode")) == null) ? (uri != null || (queryParameter9 = uri.getQueryParameter("forest_buffer_mode")) == null) ? false : Intrinsics.areEqual(queryParameter9, "concurrent") : Intrinsics.areEqual(queryParameter12, "concurrent"));
                                    if (uri2 == null && (queryParameter11 = uri2.getQueryParameter("forest_newly_builtin")) != null) {
                                        z6 = Intrinsics.areEqual(queryParameter11, "1");
                                    } else if (uri != null && (queryParameter10 = uri.getQueryParameter("forest_newly_builtin")) != null) {
                                        z6 = Intrinsics.areEqual(queryParameter10, "1");
                                    }
                                    requestParams.setUseGeckoNewlyBuiltin(z6);
                                }
                            } else {
                                areEqual4 = Intrinsics.areEqual(queryParameter16, "1");
                            }
                            z4 = !areEqual4;
                            if (z4) {
                            }
                        }
                        z3 = false;
                        requestParams.setEnableCDNCache(Boolean.valueOf(z3));
                        if (uri2 != null) {
                        }
                        if (uri != null) {
                        }
                        requestParams.setEnableMemoryCache(valueOf2);
                        requestParams.setIgnoreWaitReusedRequest((uri2 != null || (queryParameter14 = uri2.getQueryParameter("ignore_wait_reused_request")) == null) ? (uri != null || (queryParameter7 = uri.getQueryParameter("ignore_wait_reused_request")) == null) ? false : Intrinsics.areEqual(queryParameter7, "1") : Intrinsics.areEqual(queryParameter14, "1"));
                        if (uri2 != null) {
                        }
                        if (uri != null) {
                        }
                        if (areEqual3) {
                        }
                        z5 = false;
                        requestParams.setStreamingLoad(z5);
                        requestParams.setUseConcurrentBuffer((uri2 != null || (queryParameter12 = uri2.getQueryParameter("forest_buffer_mode")) == null) ? (uri != null || (queryParameter9 = uri.getQueryParameter("forest_buffer_mode")) == null) ? false : Intrinsics.areEqual(queryParameter9, "concurrent") : Intrinsics.areEqual(queryParameter12, "concurrent"));
                        if (uri2 == null) {
                        }
                        if (uri != null) {
                            z6 = Intrinsics.areEqual(queryParameter10, "1");
                        }
                        requestParams.setUseGeckoNewlyBuiltin(z6);
                    }
                }
                z2 = true;
                requestParams.setDisableBuiltin(z2);
                requestParams.setDisableCdn((uri2 != null || (queryParameter20 = uri2.getQueryParameter(PrefetchSchemaParam.PREFETCH_RES_FROM_DISABLE_CDN)) == null) ? (uri != null || (queryParameter3 = uri.getQueryParameter(PrefetchSchemaParam.PREFETCH_RES_FROM_DISABLE_CDN)) == null) ? false : Intrinsics.areEqual(queryParameter3, "1") : Intrinsics.areEqual(queryParameter20, "1"));
                if (uri2 != null) {
                }
                if (uri != null) {
                }
                requestParams.setDisableGeckoUpdate(areEqual2);
                requestParams.setOnlyLocal((uri2 != null || (queryParameter18 = uri2.getQueryParameter("only_local")) == null) ? (uri != null || (queryParameter5 = uri.getQueryParameter("only_local")) == null) ? false : Intrinsics.areEqual(queryParameter5, "1") : Intrinsics.areEqual(queryParameter18, "1"));
                if (!Intrinsics.areEqual(valueOf, true)) {
                }
                z3 = false;
                requestParams.setEnableCDNCache(Boolean.valueOf(z3));
                if (uri2 != null) {
                }
                if (uri != null) {
                }
                requestParams.setEnableMemoryCache(valueOf2);
                requestParams.setIgnoreWaitReusedRequest((uri2 != null || (queryParameter14 = uri2.getQueryParameter("ignore_wait_reused_request")) == null) ? (uri != null || (queryParameter7 = uri.getQueryParameter("ignore_wait_reused_request")) == null) ? false : Intrinsics.areEqual(queryParameter7, "1") : Intrinsics.areEqual(queryParameter14, "1"));
                if (uri2 != null) {
                }
                if (uri != null) {
                }
                if (areEqual3) {
                }
                z5 = false;
                requestParams.setStreamingLoad(z5);
                requestParams.setUseConcurrentBuffer((uri2 != null || (queryParameter12 = uri2.getQueryParameter("forest_buffer_mode")) == null) ? (uri != null || (queryParameter9 = uri.getQueryParameter("forest_buffer_mode")) == null) ? false : Intrinsics.areEqual(queryParameter9, "concurrent") : Intrinsics.areEqual(queryParameter12, "concurrent"));
                if (uri2 == null) {
                }
                if (uri != null) {
                }
                requestParams.setUseGeckoNewlyBuiltin(z6);
            }
        }
        z = true;
        requestParams.setDisableOffline(z);
        if (!Intrinsics.areEqual(valueOf, true)) {
        }
        z2 = true;
        requestParams.setDisableBuiltin(z2);
        requestParams.setDisableCdn((uri2 != null || (queryParameter20 = uri2.getQueryParameter(PrefetchSchemaParam.PREFETCH_RES_FROM_DISABLE_CDN)) == null) ? (uri != null || (queryParameter3 = uri.getQueryParameter(PrefetchSchemaParam.PREFETCH_RES_FROM_DISABLE_CDN)) == null) ? false : Intrinsics.areEqual(queryParameter3, "1") : Intrinsics.areEqual(queryParameter20, "1"));
        if (uri2 != null) {
        }
        if (uri != null) {
        }
        requestParams.setDisableGeckoUpdate(areEqual2);
        requestParams.setOnlyLocal((uri2 != null || (queryParameter18 = uri2.getQueryParameter("only_local")) == null) ? (uri != null || (queryParameter5 = uri.getQueryParameter("only_local")) == null) ? false : Intrinsics.areEqual(queryParameter5, "1") : Intrinsics.areEqual(queryParameter18, "1"));
        if (!Intrinsics.areEqual(valueOf, true)) {
        }
        z3 = false;
        requestParams.setEnableCDNCache(Boolean.valueOf(z3));
        if (uri2 != null) {
        }
        if (uri != null) {
        }
        requestParams.setEnableMemoryCache(valueOf2);
        requestParams.setIgnoreWaitReusedRequest((uri2 != null || (queryParameter14 = uri2.getQueryParameter("ignore_wait_reused_request")) == null) ? (uri != null || (queryParameter7 = uri.getQueryParameter("ignore_wait_reused_request")) == null) ? false : Intrinsics.areEqual(queryParameter7, "1") : Intrinsics.areEqual(queryParameter14, "1"));
        if (uri2 != null) {
        }
        if (uri != null) {
        }
        if (areEqual3) {
        }
        z5 = false;
        requestParams.setStreamingLoad(z5);
        requestParams.setUseConcurrentBuffer((uri2 != null || (queryParameter12 = uri2.getQueryParameter("forest_buffer_mode")) == null) ? (uri != null || (queryParameter9 = uri.getQueryParameter("forest_buffer_mode")) == null) ? false : Intrinsics.areEqual(queryParameter9, "concurrent") : Intrinsics.areEqual(queryParameter12, "concurrent"));
        if (uri2 == null) {
        }
        if (uri != null) {
        }
        requestParams.setUseGeckoNewlyBuiltin(z6);
    }

    static /* synthetic */ void fetchCustomMaxAge$default(ForestRequestInfoBuilder forestRequestInfoBuilder, RequestParams requestParams, Uri uri, Uri uri2, TaskConfig taskConfig, int i, Object obj) {
        if ((i & 1) != 0) {
            uri = null;
        }
        if ((i & 2) != 0) {
            uri2 = null;
        }
        forestRequestInfoBuilder.fetchCustomMaxAge(requestParams, uri, uri2, taskConfig);
    }

    private final void fetchCustomMaxAge(RequestParams requestParams, Uri uri, Uri uri2, TaskConfig taskConfig) {
        int intValue;
        String queryParameter;
        String queryParameter2;
        Integer customMaxAge;
        if (taskConfig == null || (customMaxAge = taskConfig.getCustomMaxAge()) == null) {
            Integer num = null;
            Integer intOrNull = (uri2 == null || (queryParameter2 = uri2.getQueryParameter("forest_max_age")) == null) ? null : StringsKt.toIntOrNull(queryParameter2);
            if (intOrNull != null) {
                intValue = intOrNull.intValue();
            } else {
                if (uri != null && (queryParameter = uri.getQueryParameter("forest_max_age")) != null) {
                    num = StringsKt.toIntOrNull(queryParameter);
                }
                intValue = num != null ? num.intValue() : 0;
            }
        } else {
            intValue = customMaxAge.intValue();
        }
        requestParams.setCustomHttpMaxAge(intValue);
    }

    static /* synthetic */ void fetchGeckoInfo$default(ForestRequestInfoBuilder forestRequestInfoBuilder, RequestParams requestParams, Uri uri, int i, Object obj) {
        if ((i & 1) != 0) {
            uri = null;
        }
        forestRequestInfoBuilder.fetchGeckoInfo(requestParams, uri);
    }

    private final void fetchGeckoInfo(RequestParams requestParams, Uri uri) {
        if (uri == null) {
            return;
        }
        String queryParameter = uri.getQueryParameter("accessKey");
        if (queryParameter != null) {
            requestParams.setAccessKey(queryParameter);
        }
        String queryParameter2 = uri.getQueryParameter("channel");
        String queryParameter3 = uri.getQueryParameter(SchemaConstants.QUERY_KEY_BUNDLE);
        if (LoaderUtils.INSTANCE.isNotNullOrEmpty(queryParameter2) && LoaderUtils.INSTANCE.isNotNullOrEmpty(queryParameter3)) {
            requestParams.setChannel(queryParameter2);
            requestParams.setBundle(queryParameter3);
        }
    }

    static /* synthetic */ void fetchDynamicInfo$default(ForestRequestInfoBuilder forestRequestInfoBuilder, RequestParams requestParams, Uri uri, int i, Object obj) {
        if ((i & 1) != 0) {
            uri = null;
        }
        forestRequestInfoBuilder.fetchDynamicInfo(requestParams, uri);
    }

    private final void fetchDynamicInfo(RequestParams requestParams, Uri uri) {
        if (uri == null) {
            return;
        }
        String queryParameter = uri.getQueryParameter("dynamic");
        boolean z = false;
        if (queryParameter != null) {
            try {
                z = DynamicType.INSTANCE.asWaitGeckoUpdate(Integer.parseInt(queryParameter));
            } catch (Throwable unused) {
            }
        }
        requestParams.setWaitGeckoUpdate(z);
    }

    private final void fetchLockInfo(RequestParams requestParams, Uri uri) {
        String str = null;
        if (enableResourceLock && uri != null) {
            str = uri.getQueryParameter("forest_session_id");
        }
        requestParams.setSessionId(str);
    }

    static /* synthetic */ void fetchCustomizedPrefixes$default(ForestRequestInfoBuilder forestRequestInfoBuilder, RequestParams requestParams, Uri uri, Uri uri2, TaskConfig taskConfig, int i, Object obj) {
        if ((i & 1) != 0) {
            uri = null;
        }
        if ((i & 2) != 0) {
            uri2 = null;
        }
        if ((i & 4) != 0) {
            taskConfig = null;
        }
        forestRequestInfoBuilder.fetchCustomizedPrefixes(requestParams, uri, uri2, taskConfig);
    }

    private final void fetchCustomizedPrefixes(RequestParams requestParams, Uri uri, Uri uri2, TaskConfig taskConfig) {
        ExtraInfo extraInfo;
        String queryParameter;
        String queryParameter2;
        ArrayList arrayList = new ArrayList();
        if (uri != null && (queryParameter2 = uri.getQueryParameter(SchemaConstants.QUERY_KEY_PREFIX)) != null) {
            arrayList.add(queryParameter2);
        }
        if (uri2 != null && (queryParameter = uri2.getQueryParameter(SchemaConstants.QUERY_KEY_PREFIX)) != null) {
            arrayList.add(queryParameter);
        }
        if (taskConfig != null) {
            arrayList.addAll(taskConfig.getSpecifiedPrefix());
            TaskContext taskContext = taskConfig.getTaskContext();
            if (taskContext != null && (extraInfo = (ExtraInfo) taskContext.getDependency(ExtraInfo.class)) != null) {
                arrayList.add(extraInfo.getPrefix());
            }
        }
        if (!arrayList.isEmpty()) {
            requestParams.setPrefixList(arrayList);
        }
    }

    static /* synthetic */ void fetchCacheKeyInfluencingFactor$default(ForestRequestInfoBuilder forestRequestInfoBuilder, RequestParams requestParams, Uri uri, Uri uri2, int i, Object obj) {
        if ((i & 1) != 0) {
            uri = null;
        }
        if ((i & 2) != 0) {
            uri2 = null;
        }
        forestRequestInfoBuilder.fetchCacheKeyInfluencingFactor(requestParams, uri, uri2);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void fetchCacheKeyInfluencingFactor(RequestParams requestParams, Uri uri, Uri uri2) {
        String queryParameter;
        Set set;
        String queryParameter2;
        List split$default;
        String str = null;
        if (uri == null || (queryParameter = uri.getQueryParameter("forest_key_include")) == null) {
            queryParameter = uri2 != null ? uri2.getQueryParameter("forest_key_include") : null;
        }
        if (queryParameter != null && (split$default = StringsKt.split$default(queryParameter, new String[]{","}, false, 0, 6, (Object) null)) != null) {
            if (!(!split$default.isEmpty())) {
                split$default = null;
            }
            if (split$default != null) {
                set = CollectionsKt.toSet(split$default);
                requestParams.setCacheKeySensitiveQueries(set);
                if (uri == null && (queryParameter2 = uri.getQueryParameter("forest_key_ua_include")) != null) {
                    str = queryParameter2;
                } else if (uri2 != null) {
                    str = uri2.getQueryParameter("forest_key_ua_include");
                }
                requestParams.setCacheKeyUASensitive(Intrinsics.areEqual(str, "1"));
            }
        }
        set = null;
        requestParams.setCacheKeySensitiveQueries(set);
        if (uri == null) {
        }
        if (uri2 != null) {
        }
        requestParams.setCacheKeyUASensitive(Intrinsics.areEqual(str, "1"));
    }
}
