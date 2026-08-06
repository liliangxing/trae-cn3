package com.bytedance.forest.chain.fetchers;

import android.util.Pair;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.applog.server.Api;
import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.forest.Forest;
import com.bytedance.forest.model.ErrorInfo;
import com.bytedance.forest.model.GeckoConfig;
import com.bytedance.forest.model.LogReportNode;
import com.bytedance.forest.model.Request;
import com.bytedance.forest.model.ResourceFrom;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.model.Timing;
import com.bytedance.forest.utils.ForestLogger;
import com.bytedance.forest.utils.ForestPipelineContext;
import com.bytedance.geckox.GeckoClient;
import com.bytedance.geckox.OptionCheckUpdateParams;
import com.bytedance.geckox.listener.GeckoUpdateListener;
import com.bytedance.geckox.model.CheckRequestBodyModel;
import com.bytedance.geckox.model.LocalPackageModel;
import com.bytedance.geckox.model.UpdatePackage;
import com.bytedance.iesgurd.IESGurdResData;
import com.bytedance.iesgurd.IESGurdResError;
import com.bytedance.iesgurd.IESGurdResFrom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: GeckoFetcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001+B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J8\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0014H\u0002J,\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00110\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016JK\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\n2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00110\u001bH\u0002¢\u0006\u0002\u0010$J \u0010%\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002JG\u0010&\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00110(H\u0002¢\u0006\u0002\u0010)J4\u0010*\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00110\u001b2\u0006\u0010!\u001a\u00020\"H\u0002¨\u0006,"}, d2 = {"Lcom/bytedance/forest/chain/fetchers/GeckoFetcher;", "Lcom/bytedance/forest/chain/fetchers/ResourceFetcher;", "forest", "Lcom/bytedance/forest/Forest;", "(Lcom/bytedance/forest/Forest;)V", "buildChannelOptionParams", "Lcom/bytedance/geckox/OptionCheckUpdateParams;", "adapter", "Lcom/bytedance/forest/chain/fetchers/GeckoXAdapter;", "accessKey", "", "useInteraction", "", Api.COL_TAG, "listener", "Lcom/bytedance/geckox/listener/GeckoUpdateListener;", "cancel", "", "checkUpdate", "channel", "Lcom/bytedance/forest/chain/fetchers/OnUpdateListener;", "fetchAsync", "request", "Lcom/bytedance/forest/model/Request;", ApmTrafficStats.TTNET_RESPONSE, "Lcom/bytedance/forest/model/Response;", JsCallParser.VALUE_CALLBACK, "Lkotlin/Function1;", "fetchSync", "geckoLoadOfflineFile", "bundle", "channelVersion", "", "loaderConfig", "Lcom/bytedance/forest/model/GeckoConfig;", "Lcom/bytedance/iesgurd/IESGurdResData;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/bytedance/forest/model/Response;Lcom/bytedance/forest/model/GeckoConfig;Lkotlin/jvm/functions/Function1;)V", "isPathTraversal", "loadGeckoFile", "isCache", "Lkotlin/Function0;", "(Lcom/bytedance/forest/model/Request;Lcom/bytedance/forest/model/Response;ZLjava/lang/Long;Lcom/bytedance/forest/model/GeckoConfig;Lkotlin/jvm/functions/Function0;)V", "pullGeckoPackage", "Companion", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class GeckoFetcher extends ResourceFetcher {
    public static final String GECKO_SDK_INVOKE_ASYNC_TAG = "Forest";
    public static final String GECKO_SDK_INVOKE_SYNC_TAG = "Forest_Update";
    public static final String TAG = "GeckoFetcher";

    @Override // com.bytedance.forest.chain.fetchers.ResourceFetcher
    public void cancel() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GeckoFetcher(Forest forest) {
        super(forest);
        Intrinsics.checkParameterIsNotNull(forest, "forest");
    }

    @Override // com.bytedance.forest.chain.fetchers.ResourceFetcher
    public void fetchSync(Request request, Response response) {
        Intrinsics.checkParameterIsNotNull(request, "request");
        Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
        ForestLogger.print$default(getContext$forest_release().getLogger(), 3, TAG, "start to fetchSync from gecko", true, null, Timing.GECKO_TOTAL_START, 16, null);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        fetchAsync(request, response, new Function1<Response, Unit>() { // from class: com.bytedance.forest.chain.fetchers.GeckoFetcher$fetchSync$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Response) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Response response2) {
                Intrinsics.checkParameterIsNotNull(response2, "it");
                countDownLatch.countDown();
            }
        });
        countDownLatch.await(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
    }

    @Override // com.bytedance.forest.chain.fetchers.ResourceFetcher
    public void fetchAsync(Request request, Response response, Function1<? super Response, Unit> callback) {
        Intrinsics.checkParameterIsNotNull(request, "request");
        Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
        Intrinsics.checkParameterIsNotNull(callback, JsCallParser.VALUE_CALLBACK);
        ForestPipelineContext.recordPerformanceTiming$forest_release$default(getContext$forest_release(), new String[]{Timing.GECKO_TOTAL_START}, null, 2, null);
        ForestLogger.print$default(getContext$forest_release().getLogger(), 3, TAG, "start to fetchAsync from gecko", true, null, Timing.GECKO_TOTAL_START, 16, null);
        final String channel = request.getGeckoModel().getChannel();
        final String bundle = request.getGeckoModel().getBundle();
        if (!(channel.length() == 0)) {
            if (!(bundle.length() == 0)) {
                String accessKey = request.getGeckoModel().getAccessKey();
                if (accessKey.length() == 0) {
                    ForestLogger.print$default(getContext$forest_release().getLogger(), 4, TAG, "config accessKey not found, using default", true, null, LogReportNode.GECKO_AK_EMPTY_USE_DEFAULT, 16, null);
                }
                ForestPipelineContext.recordPerformanceTiming$forest_release$default(getContext$forest_release(), new String[]{"gecko_get_config_start"}, null, 2, null);
                final GeckoConfig geckoConfig = getForest().getConfig().getGeckoConfig(accessKey);
                ForestPipelineContext.recordPerformanceTiming$forest_release$default(getContext$forest_release(), new String[]{"gecko_get_config_finish"}, null, 2, null);
                if (geckoConfig == null) {
                    response.getErrorInfo().setGeckoErrorCode(4);
                    response.getErrorInfo().setGeckoError("can not find offline root path for access key " + accessKey + ". Neither transmit related parameters of GeckoConfig in ForestConfig nor register access key to gecko sdk.");
                    callback.invoke(response);
                    return;
                } else {
                    String accessKey2 = geckoConfig.getAccessKey();
                    ForestLogger.printOptimize$default(getContext$forest_release().getLogger(), 3, TAG, true, null, LogReportNode.GECKO_CONFIG_GET, new Function0<String>() { // from class: com.bytedance.forest.chain.fetchers.GeckoFetcher$fetchAsync$3
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        public final String invoke() {
                            return "{ak:" + GeckoConfig.this.getAccessKey() + ", channel:" + channel + ", bundle=" + bundle + ", rootDir:" + GeckoConfig.this.getOfflineDir() + '}';
                        }
                    }, 8, null);
                    loadGeckoFile(request, response, true, null, geckoConfig, new GeckoFetcher$fetchAsync$4(this, response, callback, request, accessKey2, channel, geckoConfig, bundle));
                    return;
                }
            }
        }
        response.getErrorInfo().setError(ErrorInfo.Type.Gecko, 3, "channel is empty for gecko");
        callback.invoke(response);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pullGeckoPackage(Request request, Response response, Function1<? super Response, Unit> callback, GeckoConfig loaderConfig) {
        boolean onlyLocal = request.getOnlyLocal();
        if (onlyLocal) {
            response.getErrorInfo().setError(ErrorInfo.Type.Gecko, 7, "gecko only local");
            callback.invoke(response);
        } else {
            request.setUseInteraction(true);
            ForestPipelineContext.recordPerformanceTiming$forest_release$default(getContext$forest_release(), new String[]{Timing.GECKO_UPDATE_START}, null, 2, null);
            checkUpdate(getForest(), loaderConfig.getAccessKey(), request.getGeckoModel().getChannel(), request.getUseInteraction(), GECKO_SDK_INVOKE_SYNC_TAG, new GeckoFetcher$pullGeckoPackage$1(this, request, onlyLocal, response, loaderConfig, callback));
        }
    }

    private final boolean isPathTraversal(String channel, String bundle, Response response) {
        int geckoCheckPathTraversalMode = getForest().getConfig().getGeckoCheckPathTraversalMode();
        if (geckoCheckPathTraversalMode == 0) {
            return false;
        }
        if (StringsKt.contains$default(channel, "../", false, 2, (Object) null) || StringsKt.contains$default(bundle, "../", false, 2, (Object) null)) {
            ForestLogger.print$default(getContext$forest_release().getLogger(), 6, TAG, "security check failed: gecko fetcher path traversal, channel = " + channel + ", bundle = " + bundle + ", mode = " + geckoCheckPathTraversalMode, true, null, null, 48, null);
            getContext$forest_release().getReporter().reportForestLoadSecure$forest_release(response, getContext$forest_release(), channel, bundle, getForest().getConfig().getGeckoCheckPathTraversalMode());
            if (geckoCheckPathTraversalMode == 2) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ void loadGeckoFile$default(GeckoFetcher geckoFetcher, Request request, Response response, boolean z, Long l, GeckoConfig geckoConfig, Function0 function0, int i, Object obj) {
        if ((i & 8) != 0) {
            l = null;
        }
        geckoFetcher.loadGeckoFile(request, response, z, l, geckoConfig, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadGeckoFile(final Request request, final Response response, final boolean isCache, final Long channelVersion, GeckoConfig loaderConfig, final Function0<Unit> callback) {
        final String accessKey = loaderConfig.getAccessKey();
        final String channel = request.getGeckoModel().getChannel();
        final String bundle = request.getGeckoModel().getBundle();
        if (isPathTraversal(channel, bundle, response)) {
            response.setSucceed(false);
            response.getErrorInfo().setError(ErrorInfo.Type.Gecko, 8, "security check failed: gecko fetcher path traversal, channel = " + channel + ", bundle = " + bundle);
            callback.invoke();
        } else {
            ForestPipelineContext.recordPerformanceTiming$forest_release$default(getContext$forest_release(), new String[]{Timing.GECKO_START}, null, 2, null);
            geckoLoadOfflineFile(channel, bundle, channelVersion, response, loaderConfig, new Function1<IESGurdResData, Unit>() { // from class: com.bytedance.forest.chain.fetchers.GeckoFetcher$loadGeckoFile$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((IESGurdResData) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(IESGurdResData iESGurdResData) {
                    boolean checkFileContentAvailable;
                    Intrinsics.checkParameterIsNotNull(iESGurdResData, "geckoData");
                    ForestPipelineContext.recordPerformanceTiming$forest_release$default(GeckoFetcher.this.getContext$forest_release(), new String[]{Timing.GECKO_FINISH}, null, 2, null);
                    boolean z = iESGurdResData.getResFrom() != IESGurdResFrom.NONE;
                    if (z) {
                        if (request.getCheckGeckoFileAvailable() && request.getScene() != Scene.LYNX_TEMPLATE) {
                            checkFileContentAvailable = GeckoFetcherKt.checkFileContentAvailable(iESGurdResData);
                            if (!checkFileContentAvailable) {
                                response.getErrorInfo().setError(ErrorInfo.Type.Gecko, 8, "file available size =0");
                                callback.invoke();
                                return;
                            }
                        }
                        ForestPipelineContext.recordPerformanceTiming$forest_release$default(GeckoFetcher.this.getContext$forest_release(), new String[]{Timing.GECKO_TOTAL_FINISH}, null, 2, null);
                        Response response2 = response;
                        if (iESGurdResData.getResFrom() == IESGurdResFrom.OFFLINE) {
                            response2.setFilePath(iESGurdResData.getPath());
                        }
                        response2.setInMemoryBuffer$forest_release(GeckoFetcher.this.getContext$forest_release().obtainInMemoryByteBuffer$forest_release(new GeckoResBytesProvider(iESGurdResData, response, GeckoFetcher.this.getContext$forest_release(), accessKey, channel, bundle), request));
                        response2.setFrom(ResourceFrom.GECKO);
                        response2.setGeckoOfflineFromCDN$forest_release(iESGurdResData.getResFrom() == IESGurdResFrom.OFFLINE_FROM_CDN);
                        if (response2.getVersion() == 0) {
                            Long l = channelVersion;
                            response2.setVersion(l != null ? l.longValue() : iESGurdResData.getId());
                        }
                        response2.setCache(response2.getIsGeckoOfflineFromCDN() ? false : isCache);
                    }
                    IESGurdResError error = iESGurdResData.getError();
                    if (error != null) {
                        int offlineCode = error.getOfflineCode();
                        if (offlineCode == Integer.MIN_VALUE) {
                            if (accessKey.length() == 0) {
                                response.getErrorInfo().setError(ErrorInfo.Type.Gecko, 2, "Gecko accessKey invalid. Neither GeckoConfig in ForestConfig nor accessKey in RequestParams not transmitted and access key not registered to gecko sdk yet.");
                            } else {
                                if (!(channel.length() == 0)) {
                                    if (!(bundle.length() == 0)) {
                                        ErrorInfo errorInfo = response.getErrorInfo();
                                        ErrorInfo.Type type = ErrorInfo.Type.Gecko;
                                        String offlineMessage = error.getOfflineMessage();
                                        errorInfo.setError(type, 6, offlineMessage != null ? offlineMessage : "gecko File Not Found");
                                    }
                                }
                                response.getErrorInfo().setError(ErrorInfo.Type.Gecko, 3, "channel or bundle is empty");
                            }
                        } else if (offlineCode == 2) {
                            response.getErrorInfo().setError(ErrorInfo.Type.Gecko, 9, "channel in blocklist");
                        } else {
                            response.getErrorInfo().setError(ErrorInfo.Type.Gecko, 6, "gecko File Not Found");
                        }
                        if (error.getOfflineCode() != Integer.MIN_VALUE) {
                            response.getErrorInfo().setGecko_library_read_error_code(error.getOfflineCode());
                            ErrorInfo errorInfo2 = response.getErrorInfo();
                            String offlineMessage2 = error.getOfflineMessage();
                            if (offlineMessage2 == null) {
                                offlineMessage2 = "";
                            }
                            errorInfo2.setGecko_library_read_error_msg(offlineMessage2);
                            response.getErrorInfo().setGecko_cdn_library_read_error_code(error.getCdnCode());
                            ErrorInfo errorInfo3 = response.getErrorInfo();
                            String cdnMessage = error.getCdnMessage();
                            errorInfo3.setGecko_cdn_library_read_error_msg(cdnMessage != null ? cdnMessage : "");
                        }
                    }
                    response.setSucceed(z);
                    callback.invoke();
                }
            });
        }
    }

    private final void geckoLoadOfflineFile(String channel, String bundle, Long channelVersion, Response response, final GeckoConfig loaderConfig, final Function1<? super IESGurdResData, Unit> callback) {
        getForest().getGeckoXAdapter().getGeckoResourceData(response, channel, bundle, channelVersion, loaderConfig, new Function1<IESGurdResData, Unit>() { // from class: com.bytedance.forest.chain.fetchers.GeckoFetcher$geckoLoadOfflineFile$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((IESGurdResData) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(IESGurdResData iESGurdResData) {
                Intrinsics.checkParameterIsNotNull(iESGurdResData, "data");
                ForestLogger.print$default(GeckoFetcher.this.getContext$forest_release().getLogger(), 3, GeckoFetcher.TAG, "using gecko info [accessKey=" + loaderConfig.getAccessKey() + ",path=" + iESGurdResData.getPath() + ']', true, null, LogReportNode.GECKO_LOAD_OFFLINE_FILE, 16, null);
                callback.invoke(iESGurdResData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkUpdate(Forest forest, final String accessKey, final String channel, boolean useInteraction, String tag, final OnUpdateListener listener) {
        if (channel.length() == 0) {
            listener.onUpdateFailed("", new Exception("update failed because channel is null"));
            return;
        }
        GeckoUpdateListener geckoUpdateListener = new GeckoUpdateListener() { // from class: com.bytedance.forest.chain.fetchers.GeckoFetcher$checkUpdate$updateListener$1
            @Override // com.bytedance.geckox.listener.GeckoUpdateListener
            public void onLocalNewestVersion(final LocalPackageModel localPackage) {
                super.onLocalNewestVersion(localPackage);
                ForestLogger.printOptimize$default(GeckoFetcher.this.getContext$forest_release().getLogger(), 6, GeckoXAdapter.TAG, false, null, null, new Function0<String>() { // from class: com.bytedance.forest.chain.fetchers.GeckoFetcher$checkUpdate$updateListener$1$onLocalNewestVersion$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    public final String invoke() {
                        return "onLocalNewestVersion:localPackage:" + LocalPackageModel.this;
                    }
                }, 28, null);
                listener.onUpdateSuccess(channel, localPackage != null ? localPackage.getChannelPath() : null, localPackage != null ? Long.valueOf(localPackage.getLatestVersion()) : null);
            }

            @Override // com.bytedance.geckox.listener.GeckoUpdateListener
            public void onUpdateSuccess(UpdatePackage updatePackage, long version) {
                ForestLogger.print$default(GeckoFetcher.this.getContext$forest_release().getLogger(), 4, GeckoXAdapter.TAG, "onUpdateSuccess:channel:" + (updatePackage != null ? updatePackage.getChannel() : null) + " version:" + version, false, null, null, 56, null);
                super.onUpdateSuccess(updatePackage, version);
                listener.onUpdateSuccess(channel, null, Long.valueOf(version));
            }

            @Override // com.bytedance.geckox.listener.GeckoUpdateListener
            public void onCheckServerVersionSuccess(final Map<String, List<Pair<String, Long>>> requestMap, final Map<String, List<UpdatePackage>> responseMap) {
                Pair pair;
                List<UpdatePackage> list;
                List<Pair<String, Long>> list2;
                Object obj;
                super.onCheckServerVersionSuccess(requestMap, responseMap);
                ForestLogger.printOptimize$default(GeckoFetcher.this.getContext$forest_release().getLogger(), 4, GeckoXAdapter.TAG, false, null, null, new Function0<String>() { // from class: com.bytedance.forest.chain.fetchers.GeckoFetcher$checkUpdate$updateListener$1$onCheckServerVersionSuccess$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    public final String invoke() {
                        return "onCheckServerVersionSuccess:requestMap:" + requestMap + " responseMap:" + responseMap;
                    }
                }, 28, null);
                Object obj2 = null;
                if (requestMap == null || (list2 = requestMap.get(accessKey)) == null) {
                    pair = null;
                } else {
                    Iterator<T> it = list2.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        } else {
                            obj = it.next();
                            if (Intrinsics.areEqual((String) ((Pair) obj).first, channel)) {
                                break;
                            }
                        }
                    }
                    pair = (Pair) obj;
                }
                if (pair == null) {
                    if (responseMap != null && (list = responseMap.get(accessKey)) != null) {
                        Iterator<T> it2 = list.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            Object next = it2.next();
                            if (Intrinsics.areEqual(((UpdatePackage) next).getChannel(), channel)) {
                                obj2 = next;
                                break;
                            }
                        }
                        obj2 = (UpdatePackage) obj2;
                    }
                    if (obj2 == null) {
                        listener.onUpdateFailed(channel, new Throwable("invalid channel"));
                    }
                }
            }

            @Override // com.bytedance.geckox.listener.GeckoUpdateListener
            public void onUpdateFailed(UpdatePackage updatePackage, Throwable e) {
                super.onUpdateFailed(updatePackage, e);
                OnUpdateListener onUpdateListener = listener;
                String str = channel;
                if (e == null) {
                    e = new Throwable("geckox update failed", e);
                }
                onUpdateListener.onUpdateFailed(str, e);
            }

            @Override // com.bytedance.geckox.listener.GeckoUpdateListener
            public void onCheckServerVersionFail(final Map<String, List<Pair<String, Long>>> requestMap, Throwable e) {
                ForestLogger.printOptimize$default(GeckoFetcher.this.getContext$forest_release().getLogger(), 6, GeckoXAdapter.TAG, false, e, null, new Function0<String>() { // from class: com.bytedance.forest.chain.fetchers.GeckoFetcher$checkUpdate$updateListener$1$onCheckServerVersionFail$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    public final String invoke() {
                        return "onCheckServerVersionFail:requestMap:" + requestMap;
                    }
                }, 20, null);
                OnUpdateListener onUpdateListener = listener;
                String str = channel;
                if (e == null) {
                    e = new Throwable("geckox update failed", e);
                }
                onUpdateListener.onUpdateFailed(str, e);
            }

            @Override // com.bytedance.geckox.listener.GeckoUpdateListener
            public void onCheckRequestIntercept(final int code, final Map<String, List<Pair<String, Long>>> requestMap, Throwable e) {
                super.onCheckRequestIntercept(code, requestMap, e);
                ForestLogger.printOptimize$default(GeckoFetcher.this.getContext$forest_release().getLogger(), 6, GeckoXAdapter.TAG, false, e, null, new Function0<String>() { // from class: com.bytedance.forest.chain.fetchers.GeckoFetcher$checkUpdate$updateListener$1$onCheckRequestIntercept$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    public final String invoke() {
                        return "onCheckRequestIntercept:code:" + code + " requestMap:" + requestMap;
                    }
                }, 20, null);
                OnUpdateListener onUpdateListener = listener;
                String str = channel;
                if (e == null) {
                    e = new Throwable("geckox request intercept", e);
                }
                onUpdateListener.onUpdateFailed(str, e);
            }
        };
        GeckoXAdapter geckoXAdapter = forest.getGeckoXAdapter();
        GeckoClient normalGeckoXClient$forest_release = geckoXAdapter.getNormalGeckoXClient$forest_release(accessKey);
        if (normalGeckoXClient$forest_release != null) {
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new CheckRequestBodyModel.TargetChannel(channel));
            HashMap hashMap2 = hashMap;
            hashMap2.put(accessKey, arrayList);
            normalGeckoXClient$forest_release.checkUpdateMulti((String) null, hashMap2, buildChannelOptionParams(geckoXAdapter, accessKey, useInteraction, tag, geckoUpdateListener));
            return;
        }
        listener.onUpdateFailed(channel, new Throwable("GeckoXClient is null"));
    }

    private final OptionCheckUpdateParams buildChannelOptionParams(GeckoXAdapter adapter, String accessKey, boolean useInteraction, String tag, GeckoUpdateListener listener) {
        OptionCheckUpdateParams optionCheckUpdateParams = new OptionCheckUpdateParams();
        optionCheckUpdateParams.setTag(tag);
        OptionCheckUpdateParams listener2 = optionCheckUpdateParams.setRequestWhenHasLocalVersion(false).setCustomParam(adapter.getCustomParams$forest_release(accessKey)).setListener(listener);
        if (useInteraction) {
            Intrinsics.checkExpressionValueIsNotNull(listener2, "result");
            listener2.setChannelUpdatePriority(3);
        }
        Intrinsics.checkExpressionValueIsNotNull(listener2, "result");
        return listener2;
    }
}
