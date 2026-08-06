package com.bytedance.forest;

import android.net.Uri;
import android.webkit.WebResourceRequest;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.forest.model.GeckoConfig;
import com.bytedance.forest.model.GeckoModel;
import com.bytedance.forest.model.GeckoSource;
import com.bytedance.forest.model.Request;
import com.bytedance.forest.model.RequestParams;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.model.Timing;
import com.bytedance.forest.model.URIQueryParamKeys;
import com.bytedance.forest.pollyfill.DownloadDepender;
import com.bytedance.forest.pollyfill.NetWorker;
import com.bytedance.forest.pollyfill.TTNetDepender;
import com.bytedance.forest.postprocessor.PostProcessParams;
import com.bytedance.forest.postprocessor.PostProcessRequest;
import com.bytedance.forest.utils.ForestLogger;
import com.bytedance.forest.utils.ForestPipelineContext;
import com.bytedance.forest.utils.LoaderUtils;
import com.bytedance.forest.utils.UriParser;
import com.bytedance.forest.utils.UriParserKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RequestFactory.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ0\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0004H\u0002J.\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002¨\u0006\u001a"}, d2 = {"Lcom/bytedance/forest/RequestFactory;", "", "()V", "buildRequest", "Lcom/bytedance/forest/model/Request;", "url", "", "forest", "Lcom/bytedance/forest/Forest;", "params", "Lcom/bytedance/forest/model/RequestParams;", "async", "", "context", "Lcom/bytedance/forest/utils/ForestPipelineContext;", "createRequestFromParams", "extractGeckoModelFromUrlQuery", "", "uri", "Landroid/net/Uri;", "request", "extractGeckoModelWithCustomizedPrefix", "prefixes", "", DBHelper.BATTERY_COL_SOURCE, "Lcom/bytedance/forest/model/GeckoSource;", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class RequestFactory {
    public static final RequestFactory INSTANCE = new RequestFactory();

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NetWorker.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[NetWorker.TTNet.ordinal()] = 1;
            iArr[NetWorker.Downloader.ordinal()] = 2;
        }
    }

    private RequestFactory() {
    }

    @Deprecated(message = "This fun is stale", replaceWith = @ReplaceWith(expression = "buildRequest(\n        url: String,\n        forest: Forest,\n        params: RequestParams,\n        async: Boolean,\n        context: ForestPipelineContext\n    )", imports = {"url", "forest", "params", "async", "context"}))
    public final Request buildRequest(String url, Forest forest, RequestParams params, boolean async) {
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(forest, "forest");
        Intrinsics.checkParameterIsNotNull(params, "params");
        return buildRequest(url, forest, params, async, new ForestPipelineContext(forest.getApplication(), null, 2, null));
    }

    public final Request buildRequest(String url, Forest forest, RequestParams params, boolean async, ForestPipelineContext context) {
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(forest, "forest");
        Intrinsics.checkParameterIsNotNull(params, "params");
        Intrinsics.checkParameterIsNotNull(context, "context");
        ForestLogger.print$default(context.getLogger(), 4, "buildRequest", "build request start. ", true, null, Timing.REQ_BUILD_START, 16, null);
        Request createRequestFromParams = createRequestFromParams(url, params, forest, async, context);
        Uri originUri = createRequestFromParams.getOriginUri();
        if (!originUri.isHierarchical()) {
            return createRequestFromParams;
        }
        forest.getGeckoXAdapter().isGeckoCDNAndMergeConfig(originUri, url, createRequestFromParams);
        if (createRequestFromParams.getGeckoModel().isChannelOrBundleBlank()) {
            extractGeckoModelFromUrlQuery(originUri, createRequestFromParams);
        }
        if (createRequestFromParams.getGeckoModel().isChannelOrBundleBlank()) {
            String queryParameter = originUri.getQueryParameter(URIQueryParamKeys.KRY_PREFIX);
            if (queryParameter == null) {
                queryParameter = "";
            }
            extractGeckoModelWithCustomizedPrefix(url, createRequestFromParams, CollectionsKt.listOf(queryParameter), GeckoSource.QUERIED_PREFIX);
        }
        if (createRequestFromParams.getGeckoModel().isChannelOrBundleBlank()) {
            GeckoModel geckoModel = createRequestFromParams.getGeckoModel();
            String channel = params.getChannel();
            if (channel == null) {
                channel = "";
            }
            geckoModel.setChannel(channel);
            GeckoModel geckoModel2 = createRequestFromParams.getGeckoModel();
            String bundle = params.getBundle();
            geckoModel2.setBundle(bundle != null ? bundle : "");
        }
        if (createRequestFromParams.getGeckoModel().isChannelOrBundleBlank()) {
            List<String> prefixList = params.getPrefixList();
            if (prefixList == null) {
                prefixList = CollectionsKt.emptyList();
            }
            extractGeckoModelWithCustomizedPrefix(url, createRequestFromParams, prefixList, GeckoSource.INJECTED_PREFIXES);
        }
        UriParserKt.parseUriParams(createRequestFromParams);
        return createRequestFromParams;
    }

    private final void extractGeckoModelFromUrlQuery(Uri uri, Request request) {
        String geckoChannel = UriParserKt.getGeckoChannel(uri);
        String geckoBundle = UriParserKt.getGeckoBundle(uri);
        if (LoaderUtils.INSTANCE.isNotNullOrEmpty(geckoChannel) && LoaderUtils.INSTANCE.isNotNullOrEmpty(geckoBundle)) {
            GeckoModel geckoModel = request.getGeckoModel();
            if (geckoChannel == null) {
                Intrinsics.throwNpe();
            }
            geckoModel.setChannel(geckoChannel);
            GeckoModel geckoModel2 = request.getGeckoModel();
            if (geckoBundle == null) {
                Intrinsics.throwNpe();
            }
            geckoModel2.setBundle(geckoBundle);
            String queryParameter = uri.getQueryParameter("accessKey");
            if (queryParameter == null) {
                queryParameter = uri.getQueryParameter(URIQueryParamKeys.KEY_ACCESS_KEY);
            }
            if (LoaderUtils.INSTANCE.isNotNullOrEmpty(queryParameter)) {
                GeckoModel geckoModel3 = request.getGeckoModel();
                Intrinsics.checkExpressionValueIsNotNull(queryParameter, "ak");
                geckoModel3.setAccessKey(queryParameter);
            }
            request.setGeckoSource(GeckoSource.URL_QUERY);
        }
    }

    private final void extractGeckoModelWithCustomizedPrefix(String url, Request request, List<String> prefixes, GeckoSource source) {
        Iterator<String> it = prefixes.iterator();
        while (it.hasNext()) {
            GeckoModel parseChannelBundleByPrefix = UriParser.INSTANCE.parseChannelBundleByPrefix(url, it.next());
            if (parseChannelBundleByPrefix != null) {
                request.setGeckoSource(source);
                request.getGeckoModel().setChannel(parseChannelBundleByPrefix.getChannel());
                request.getGeckoModel().setBundle(parseChannelBundleByPrefix.getBundle());
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x010d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Request createRequestFromParams(String url, RequestParams params, Forest forest, boolean async, ForestPipelineContext context) {
        boolean z;
        boolean z2;
        List<String> redirectRegions;
        ArrayList arrayList;
        Request request;
        NetWorker netWorker;
        int i;
        boolean z3;
        TTNetDepender tTNetDepender;
        Request request2;
        Scene resourceScene;
        GeckoConfig geckoConfig;
        Map<String, Object> customParams = params.getCustomParams();
        String accessKey = params.getAccessKey();
        if ((accessKey.length() == 0) && ((geckoConfig = forest.getConfig().getGeckoConfig()) == null || (accessKey = geckoConfig.getAccessKey()) == null)) {
            accessKey = "";
        }
        GeckoModel geckoModel = new GeckoModel(accessKey, "", "");
        boolean waitGeckoUpdate = params.getWaitGeckoUpdate();
        boolean onlyLocal = params.getOnlyLocal();
        if (!params.getNeedLocalFile() && !params.getOnlyLocal()) {
            Scene resourceScene2 = params.getResourceScene();
            if (!(resourceScene2 == Scene.LYNX_IMAGE || resourceScene2 == Scene.LYNX_FONT || resourceScene2 == Scene.LYNX_VIDEO)) {
                z = false;
                boolean z4 = (params.getDisableCdn() && UriParserKt.isHttpUrl(url) && params.getResourceScene() != Scene.LYNX_IMAGE) ? false : true;
                boolean disableBuiltin = params.getDisableBuiltin();
                boolean disableOffline = params.getDisableOffline();
                boolean disableGeckoUpdate = params.getDisableGeckoUpdate();
                boolean useConcurrentBuffer = params.getUseConcurrentBuffer();
                if (params.getLoadToMemory() && (!params.getStreamingLoad() || params.getUseConcurrentBuffer())) {
                    resourceScene = params.getResourceScene();
                    if ((resourceScene != Scene.LYNX_IMAGE || resourceScene == Scene.LYNX_FONT || resourceScene == Scene.LYNX_VIDEO) ? false : true) {
                        z2 = true;
                        boolean allowIOOnMainThread = params.getAllowIOOnMainThread();
                        boolean checkGeckoFileAvailable = params.getLoadToMemory() ? false : params.getCheckGeckoFileAvailable();
                        int loadRetryTimes = params.getLoadRetryTimes();
                        Scene resourceScene3 = params.getResourceScene();
                        String groupId = params.getGroupId();
                        Boolean enableNegotiation = params.getEnableNegotiation();
                        boolean booleanValue = enableNegotiation != null ? enableNegotiation.booleanValue() : forest.getConfig().getEnableNegotiation();
                        Boolean enableMemoryCache = params.getEnableMemoryCache();
                        boolean booleanValue2 = enableMemoryCache != null ? enableMemoryCache.booleanValue() : forest.getConfig().getEnableMemoryCache();
                        Boolean enableCDNCache = params.getEnableCDNCache();
                        boolean booleanValue3 = enableCDNCache != null ? enableCDNCache.booleanValue() : forest.getConfig().getEnableCDNCache();
                        List mutableList = CollectionsKt.toMutableList(params.getFetcherSequence());
                        boolean isPreload = params.getIsPreload();
                        boolean enableRequestReuse = params.getEnableRequestReuse();
                        boolean ignoreWaitReusedRequest = params.getIgnoreWaitReusedRequest();
                        String sessionId = params.getSessionId();
                        WebResourceRequest webResourceRequest = params.getWebResourceRequest();
                        boolean streamingLoad = params.getStreamingLoad();
                        int customHttpMaxAge = params.getCustomHttpMaxAge();
                        boolean useGeckoNewlyBuiltin = params.getUseGeckoNewlyBuiltin();
                        Map<String, String> injectedHttpHeaders = params.getInjectedHttpHeaders();
                        Set<String> cacheKeySensitiveQueries = params.getCacheKeySensitiveQueries();
                        boolean cacheKeyUASensitive = params.getCacheKeyUASensitive();
                        boolean cdnRegionRedirect = params.getCdnRegionRedirect();
                        redirectRegions = params.getRedirectRegions();
                        if (redirectRegions != null) {
                            List<String> list = redirectRegions;
                            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                            for (String str : list) {
                                Locale locale = Locale.ENGLISH;
                                Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.ENGLISH");
                                if (str == null) {
                                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                                }
                                String lowerCase = str.toLowerCase(locale);
                                Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                                arrayList2.add(lowerCase);
                            }
                            arrayList = arrayList2;
                        } else {
                            arrayList = null;
                        }
                        request = new Request(url, forest, customParams, geckoModel, waitGeckoUpdate, onlyLocal, z4, disableBuiltin, disableOffline, disableGeckoUpdate, z2, useConcurrentBuffer, allowIOOnMainThread, checkGeckoFileAvailable, loadRetryTimes, resourceScene3, async, groupId, booleanValue, booleanValue2, booleanValue3, mutableList, isPreload, enableRequestReuse, ignoreWaitReusedRequest, sessionId, webResourceRequest, z, streamingLoad, customHttpMaxAge, useGeckoNewlyBuiltin, injectedHttpHeaders, cacheKeySensitiveQueries, cacheKeyUASensitive, cdnRegionRedirect, arrayList);
                        request.setOnlyOnline(params.getOnlyOnline());
                        netWorker = NetWorker.Downloader;
                        if (!request.getNeedLocalFile()) {
                            netWorker = null;
                        }
                        if (netWorker == null) {
                            netWorker = params.getNetWorker();
                        }
                        if (netWorker == null) {
                            netWorker = forest.getConfig().getNetWorker();
                        }
                        i = WhenMappings.$EnumSwitchMapping$0[netWorker.ordinal()];
                        if (i == 1) {
                            z3 = true;
                            tTNetDepender = new TTNetDepender(context);
                        } else {
                            if (i != 2) {
                                throw new NoWhenBranchMatchedException();
                            }
                            z3 = true;
                            tTNetDepender = new DownloadDepender(context);
                        }
                        request.setNetDepender$forest_release(tTNetDepender);
                        Unit unit = Unit.INSTANCE;
                        request2 = (params instanceof PostProcessParams) ^ z3 ? request : null;
                        if (request2 != null) {
                            return request2;
                        }
                        if (params != null) {
                            return new PostProcessRequest(request, ((PostProcessParams) params).getProcessor$forest_release());
                        }
                        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.forest.postprocessor.PostProcessParams<*>");
                    }
                }
                z2 = false;
                boolean allowIOOnMainThread2 = params.getAllowIOOnMainThread();
                if (params.getLoadToMemory()) {
                }
                int loadRetryTimes2 = params.getLoadRetryTimes();
                Scene resourceScene32 = params.getResourceScene();
                String groupId2 = params.getGroupId();
                Boolean enableNegotiation2 = params.getEnableNegotiation();
                boolean booleanValue4 = enableNegotiation2 != null ? enableNegotiation2.booleanValue() : forest.getConfig().getEnableNegotiation();
                Boolean enableMemoryCache2 = params.getEnableMemoryCache();
                boolean booleanValue22 = enableMemoryCache2 != null ? enableMemoryCache2.booleanValue() : forest.getConfig().getEnableMemoryCache();
                Boolean enableCDNCache2 = params.getEnableCDNCache();
                boolean booleanValue32 = enableCDNCache2 != null ? enableCDNCache2.booleanValue() : forest.getConfig().getEnableCDNCache();
                List mutableList2 = CollectionsKt.toMutableList(params.getFetcherSequence());
                boolean isPreload2 = params.getIsPreload();
                boolean enableRequestReuse2 = params.getEnableRequestReuse();
                boolean ignoreWaitReusedRequest2 = params.getIgnoreWaitReusedRequest();
                String sessionId2 = params.getSessionId();
                WebResourceRequest webResourceRequest2 = params.getWebResourceRequest();
                boolean streamingLoad2 = params.getStreamingLoad();
                int customHttpMaxAge2 = params.getCustomHttpMaxAge();
                boolean useGeckoNewlyBuiltin2 = params.getUseGeckoNewlyBuiltin();
                Map<String, String> injectedHttpHeaders2 = params.getInjectedHttpHeaders();
                Set<String> cacheKeySensitiveQueries2 = params.getCacheKeySensitiveQueries();
                boolean cacheKeyUASensitive2 = params.getCacheKeyUASensitive();
                boolean cdnRegionRedirect2 = params.getCdnRegionRedirect();
                redirectRegions = params.getRedirectRegions();
                if (redirectRegions != null) {
                }
                request = new Request(url, forest, customParams, geckoModel, waitGeckoUpdate, onlyLocal, z4, disableBuiltin, disableOffline, disableGeckoUpdate, z2, useConcurrentBuffer, allowIOOnMainThread2, checkGeckoFileAvailable, loadRetryTimes2, resourceScene32, async, groupId2, booleanValue4, booleanValue22, booleanValue32, mutableList2, isPreload2, enableRequestReuse2, ignoreWaitReusedRequest2, sessionId2, webResourceRequest2, z, streamingLoad2, customHttpMaxAge2, useGeckoNewlyBuiltin2, injectedHttpHeaders2, cacheKeySensitiveQueries2, cacheKeyUASensitive2, cdnRegionRedirect2, arrayList);
                request.setOnlyOnline(params.getOnlyOnline());
                netWorker = NetWorker.Downloader;
                if (!request.getNeedLocalFile()) {
                }
                if (netWorker == null) {
                }
                if (netWorker == null) {
                }
                i = WhenMappings.$EnumSwitchMapping$0[netWorker.ordinal()];
                if (i == 1) {
                }
                request.setNetDepender$forest_release(tTNetDepender);
                Unit unit2 = Unit.INSTANCE;
                if ((params instanceof PostProcessParams) ^ z3) {
                }
                if (request2 != null) {
                }
            }
        }
        z = true;
        if (params.getDisableCdn()) {
        }
        boolean disableBuiltin2 = params.getDisableBuiltin();
        boolean disableOffline2 = params.getDisableOffline();
        boolean disableGeckoUpdate2 = params.getDisableGeckoUpdate();
        boolean useConcurrentBuffer2 = params.getUseConcurrentBuffer();
        if (params.getLoadToMemory()) {
            resourceScene = params.getResourceScene();
            if ((resourceScene != Scene.LYNX_IMAGE || resourceScene == Scene.LYNX_FONT || resourceScene == Scene.LYNX_VIDEO) ? false : true) {
            }
        }
        z2 = false;
        boolean allowIOOnMainThread22 = params.getAllowIOOnMainThread();
        if (params.getLoadToMemory()) {
        }
        int loadRetryTimes22 = params.getLoadRetryTimes();
        Scene resourceScene322 = params.getResourceScene();
        String groupId22 = params.getGroupId();
        Boolean enableNegotiation22 = params.getEnableNegotiation();
        boolean booleanValue42 = enableNegotiation22 != null ? enableNegotiation22.booleanValue() : forest.getConfig().getEnableNegotiation();
        Boolean enableMemoryCache22 = params.getEnableMemoryCache();
        boolean booleanValue222 = enableMemoryCache22 != null ? enableMemoryCache22.booleanValue() : forest.getConfig().getEnableMemoryCache();
        Boolean enableCDNCache22 = params.getEnableCDNCache();
        boolean booleanValue322 = enableCDNCache22 != null ? enableCDNCache22.booleanValue() : forest.getConfig().getEnableCDNCache();
        List mutableList22 = CollectionsKt.toMutableList(params.getFetcherSequence());
        boolean isPreload22 = params.getIsPreload();
        boolean enableRequestReuse22 = params.getEnableRequestReuse();
        boolean ignoreWaitReusedRequest22 = params.getIgnoreWaitReusedRequest();
        String sessionId22 = params.getSessionId();
        WebResourceRequest webResourceRequest22 = params.getWebResourceRequest();
        boolean streamingLoad22 = params.getStreamingLoad();
        int customHttpMaxAge22 = params.getCustomHttpMaxAge();
        boolean useGeckoNewlyBuiltin22 = params.getUseGeckoNewlyBuiltin();
        Map<String, String> injectedHttpHeaders22 = params.getInjectedHttpHeaders();
        Set<String> cacheKeySensitiveQueries22 = params.getCacheKeySensitiveQueries();
        boolean cacheKeyUASensitive22 = params.getCacheKeyUASensitive();
        boolean cdnRegionRedirect22 = params.getCdnRegionRedirect();
        redirectRegions = params.getRedirectRegions();
        if (redirectRegions != null) {
        }
        request = new Request(url, forest, customParams, geckoModel, waitGeckoUpdate, onlyLocal, z4, disableBuiltin2, disableOffline2, disableGeckoUpdate2, z2, useConcurrentBuffer2, allowIOOnMainThread22, checkGeckoFileAvailable, loadRetryTimes22, resourceScene322, async, groupId22, booleanValue42, booleanValue222, booleanValue322, mutableList22, isPreload22, enableRequestReuse22, ignoreWaitReusedRequest22, sessionId22, webResourceRequest22, z, streamingLoad22, customHttpMaxAge22, useGeckoNewlyBuiltin22, injectedHttpHeaders22, cacheKeySensitiveQueries22, cacheKeyUASensitive22, cdnRegionRedirect22, arrayList);
        request.setOnlyOnline(params.getOnlyOnline());
        netWorker = NetWorker.Downloader;
        if (!request.getNeedLocalFile()) {
        }
        if (netWorker == null) {
        }
        if (netWorker == null) {
        }
        i = WhenMappings.$EnumSwitchMapping$0[netWorker.ordinal()];
        if (i == 1) {
        }
        request.setNetDepender$forest_release(tTNetDepender);
        Unit unit22 = Unit.INSTANCE;
        if ((params instanceof PostProcessParams) ^ z3) {
        }
        if (request2 != null) {
        }
    }
}
