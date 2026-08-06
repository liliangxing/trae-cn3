package com.bytedance.ies.bullet.forest;

import android.app.Application;
import android.net.Uri;
import com.bytedance.forest.Forest;
import com.bytedance.forest.interceptor.GlobalInterceptor;
import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.forest.model.PreloadType;
import com.bytedance.forest.model.RequestOperation;
import com.bytedance.forest.model.RequestParams;
import com.bytedance.forest.model.ResourceConfig;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.pollyfill.NetWorker;
import com.bytedance.forest.postprocessor.ForestPostProcessor;
import com.bytedance.forest.postprocessor.PostProcessOperation;
import com.bytedance.forest.postprocessor.PostProcessParams;
import com.bytedance.forest.postprocessor.ProcessedResponse;
import com.bytedance.forest.utils.LogUtils;
import com.bytedance.ies.bullet.core.BulletEnv;
import com.bytedance.ies.bullet.kit.resourceloader.loader.CDNLoader;
import com.bytedance.ies.bullet.lynx.DefaultLynxParams;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.perf.monitor.ReportConst;
import com.bytedance.praisedialoglib.PraiseDialogConstant;
import com.bytedance.ttwebview.TTWebPredictor;
import com.bytedance.ug.sdk.share.impl.network.request.FetchTokenInfoThread;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* compiled from: ForestLoader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010#\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u00102\u0006\u0010#\u001a\u00020\u0004H\u0002J\u0010\u0010$\u001a\u00020!2\u0006\u0010#\u001a\u00020\u0004H\u0002J\u001a\u0010%\u001a\u0004\u0018\u00010\u00182\b\u0010&\u001a\u0004\u0018\u00010\u00042\u0006\u0010'\u001a\u00020\u0004J\u000e\u0010(\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0004J|\u0010)\u001a\u00020*2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00102\u0006\u0010#\u001a\u00020\u00042\n\b\u0003\u0010+\u001a\u0004\u0018\u00010\u00042\u0006\u0010,\u001a\u00020-2\b\u0010&\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\b\b\u0002\u00100\u001a\u00020!2\u0016\b\u0002\u00101\u001a\u0010\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020*\u0018\u0001022\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020*02H\u0007J\u0096\u0001\u00105\u001a\u00020*\"\u0004\b\u0000\u001062\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00102\u0006\u0010#\u001a\u00020\u00042\n\b\u0003\u0010+\u001a\u0004\u0018\u00010\u00042\u0006\u0010,\u001a\u00020-2\b\u0010&\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\b\b\u0002\u00100\u001a\u00020!2\f\u00107\u001a\b\u0012\u0004\u0012\u0002H6082\u0016\b\u0002\u00101\u001a\u0010\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020*\u0018\u0001022\u0018\u00104\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H609\u0012\u0004\u0012\u00020*02H\u0007J`\u0010:\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00102\u0006\u0010#\u001a\u00020\u00042\n\b\u0003\u0010+\u001a\u0004\u0018\u00010\u00042\u0006\u0010,\u001a\u00020-2\b\u0010&\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\u0016\b\u0002\u00101\u001a\u0010\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020*\u0018\u000102H\u0007Jz\u0010;\u001a\n\u0012\u0004\u0012\u0002H6\u0018\u000109\"\u0004\b\u0000\u001062\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00102\u0006\u0010#\u001a\u00020\u00042\n\b\u0003\u0010+\u001a\u0004\u0018\u00010\u00042\u0006\u0010,\u001a\u00020-2\b\u0010&\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\f\u00107\u001a\b\u0012\u0004\u0012\u0002H6082\u0016\b\u0002\u00101\u001a\u0010\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020*\u0018\u000102H\u0007JF\u0010<\u001a\u00020\u00072\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00102\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u00042\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\b\b\u0002\u00100\u001a\u00020!H\u0007J\u0080\u0001\u0010<\u001a\u00020\u00072\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00102\u0006\u0010#\u001a\u00020\u00042\u0006\u0010A\u001a\u00020!2\b\u0010@\u001a\u0004\u0018\u00010\u00042\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020!2\u0006\u0010?\u001a\u00020\u00042\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\b\b\u0002\u00100\u001a\u00020!2\"\b\u0002\u0010E\u001a\u001c\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020*\u0018\u00010Fj\u0004\u0018\u0001`HH\u0007J^\u0010<\u001a\u00020\u00072\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010I\u001a\u0004\u0018\u00010J2\u0006\u0010?\u001a\u00020\u00042\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u00042\u0006\u0010B\u001a\u00020C2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\b\b\u0002\u00100\u001a\u00020!H\u0007J\u0094\u0001\u0010K\u001a\u00020\u0007\"\u0004\b\u0000\u001062\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00102\u0006\u0010#\u001a\u00020\u00042\u0006\u0010A\u001a\u00020!2\b\u0010@\u001a\u0004\u0018\u00010\u00042\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020!2\u0006\u0010?\u001a\u00020\u00042\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\b\b\u0002\u00100\u001a\u00020!2\f\u00107\u001a\b\u0012\u0004\u0012\u0002H6082\"\b\u0002\u0010E\u001a\u001c\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020*\u0018\u00010Fj\u0004\u0018\u0001`HH\u0007Jr\u0010K\u001a\u00020\u0007\"\u0004\b\u0000\u001062\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010I\u001a\u0004\u0018\u00010J2\u0006\u0010?\u001a\u00020\u00042\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u00042\u0006\u0010B\u001a\u00020C2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\f\u00107\u001a\b\u0012\u0004\u0012\u0002H6082\b\b\u0002\u00100\u001a\u00020!H\u0007J \u0010L\u001a\u00020*2\b\u0010&\u001a\u0004\u0018\u00010\u00042\u0006\u0010'\u001a\u00020\u00042\u0006\u0010M\u001a\u00020\u0018J\u001c\u0010N\u001a\u00020*2\b\u0010O\u001a\u0004\u0018\u00010\u00042\b\u0010&\u001a\u0004\u0018\u00010\u0004H\u0003J\u0012\u0010P\u001a\u00020*2\b\u0010&\u001a\u0004\u0018\u00010\u0004H\u0007J\u001e\u0010Q\u001a\u00020*2\u0006\u00100\u001a\u00020!2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020*0SH\u0003R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R$\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u00108G@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00180\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006T"}, d2 = {"Lcom/bytedance/ies/bullet/forest/ForestLoader;", "", "()V", "DOWNLOAD_ENGINE_DOWNLOADER", "", "DOWNLOAD_ENGINE_TTNET", "PRELOAD_RET_FOREST_NOT_INIT", "", "PRELOAD_RET_FROM_NOT_SET", "PRELOAD_RET_NOT_ERROR", "PRELOAD_RET_URL_INVALID", "PRELOAD_SCOPE_ALL", "PRELOAD_SCOPE_DISABLE", "PRELOAD_SCOPE_MAIN", "TAG", "<set-?>", "Lcom/bytedance/forest/Forest;", DefaultLynxParams.DEFAULT_LYNX_GROUP_NAME, "getDefault", "()Lcom/bytedance/forest/Forest;", "executingRequests", "Lcom/bytedance/ies/bullet/forest/ForestContainerCache;", "Lcom/bytedance/forest/model/RequestOperation;", "imageCache", "Lcom/bytedance/forest/model/Response;", "preloadMonitor", "Lcom/bytedance/ies/bullet/forest/ForestPreloadMonitor;", "reqInfoBuilder", "Lcom/bytedance/ies/bullet/forest/ForestRequestInfoBuilder;", "resourceLocker", "", "", "checkRequestValid", "", "forest", "url", "checkUrlValid", "fetchImageCache", "containerId", "imgPath", "getForestPreloadKey", "loadAsync", "", "downloadEngine", ReportConst.KEY_SCENE, "Lcom/bytedance/forest/model/Scene;", "taskConfig", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/TaskConfig;", "forceAsync", "onRequestParamsBuilt", "Lkotlin/Function1;", "Lcom/bytedance/forest/model/RequestParams;", "callback", "loadAsyncWithProcessor", "T", "processor", "Lcom/bytedance/forest/postprocessor/ForestPostProcessor;", "Lcom/bytedance/forest/postprocessor/ProcessedResponse;", CDNLoader.STEP_NAME_SYNC, "loadSyncWithProcessor", ResourceInfo.RESOURCE_FROM_PRELOAD, "config", "Lcom/bytedance/forest/model/PreloadConfig;", PraiseDialogConstant.FROM, "monitorID", "withSubResources", "type", "Lcom/bytedance/forest/model/PreloadType;", "useTTNet", "onPreloadFinished", "Lkotlin/Function2;", "Lcom/bytedance/ies/bullet/forest/ForestRequestInfo;", "Lcom/bytedance/ies/bullet/forest/ForestPreloadCallback;", "subConfigs", "Lorg/json/JSONObject;", "preloadWithProcessor", "putImageToCache", "response", "recordResourceLockInfo", "sessionId", "release", "runForestRequest", "request", "Lkotlin/Function0;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ForestLoader {
    public static final String DOWNLOAD_ENGINE_DOWNLOADER = "downloader";
    public static final String DOWNLOAD_ENGINE_TTNET = "ttnet";
    public static final int PRELOAD_RET_FOREST_NOT_INIT = -1;
    public static final int PRELOAD_RET_FROM_NOT_SET = -2;
    public static final int PRELOAD_RET_NOT_ERROR = 0;
    public static final int PRELOAD_RET_URL_INVALID = -3;
    public static final String PRELOAD_SCOPE_ALL = "all";
    public static final String PRELOAD_SCOPE_DISABLE = "disable";
    public static final String PRELOAD_SCOPE_MAIN = "main";
    private static final String TAG = "ForestLoader";
    private static volatile Forest default;
    public static final ForestLoader INSTANCE = new ForestLoader();
    private static final ForestContainerCache<String, RequestOperation> executingRequests = new ForestContainerCache<>();
    private static final ForestContainerCache<String, Response> imageCache = new ForestContainerCache<>();
    private static final Map<String, Set<String>> resourceLocker = new LinkedHashMap();
    private static final ForestRequestInfoBuilder reqInfoBuilder = new ForestRequestInfoBuilder();
    private static final ForestPreloadMonitor preloadMonitor = new ForestPreloadMonitor();

    private ForestLoader() {
    }

    static {
        TTWebPredictor.INSTANCE.initResPreload();
        EventCenter.registerJsEventSubscriber("client_ai_forest_preload", new ForestAIEventSubscriber());
    }

    public final Forest getDefault() {
        Object obj;
        Application application = BulletEnv.INSTANCE.getInstance().getApplication();
        if (application == null) {
            throw new IllegalStateException("MUST attach application via BulletSdk#init!");
        }
        if (default == null) {
            try {
                Result.Companion companion = Result.Companion;
                default = new Forest(application, ForestConfigCenter.INSTANCE.getForestConfig());
                obj = Result.constructor-impl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            Throwable th2 = Result.exceptionOrNull-impl(obj);
            if (th2 != null) {
                LogUtils.e$default(LogUtils.INSTANCE, TAG, "Init forest instance failed!", th2, true, (Function3) null, (String) null, (Map) null, 112, (Object) null);
                throw th2;
            }
            if (Result.isSuccess-impl(obj)) {
                GlobalInterceptor.INSTANCE.registerMonitor(preloadMonitor);
            }
        }
        return default;
    }

    public final Response loadSync(Forest forest, String url, @DownloadEngine String downloadEngine, Scene scene, String containerId, TaskConfig taskConfig, Function1<? super RequestParams, Unit> onRequestParamsBuilt) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(scene, ReportConst.KEY_SCENE);
        if (!checkRequestValid(forest, url)) {
            return null;
        }
        ForestRequestInfo build = reqInfoBuilder.build(url, false, downloadEngine, scene, containerId, taskConfig);
        if (onRequestParamsBuilt != null) {
            onRequestParamsBuilt.invoke(build.getParams());
        }
        INSTANCE.recordResourceLockInfo(build.getParams().getSessionId(), containerId);
        Intrinsics.checkNotNull(forest);
        RequestOperation createSyncRequest = forest.createSyncRequest(build.generateForestUrl(forest), build.getParams());
        if (createSyncRequest != null) {
            return createSyncRequest.execute();
        }
        return null;
    }

    public final <T> ProcessedResponse<T> loadSyncWithProcessor(Forest forest, String url, @DownloadEngine String downloadEngine, Scene scene, String containerId, TaskConfig taskConfig, ForestPostProcessor<T> processor, Function1<? super RequestParams, Unit> onRequestParamsBuilt) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(scene, ReportConst.KEY_SCENE);
        Intrinsics.checkNotNullParameter(processor, "processor");
        if (!checkRequestValid(forest, url)) {
            return null;
        }
        ForestRequestInfo build = reqInfoBuilder.build(url, false, downloadEngine, scene, containerId, taskConfig);
        if (onRequestParamsBuilt != null) {
            onRequestParamsBuilt.invoke(build.getParams());
        }
        Intrinsics.checkNotNull(forest);
        String generateForestUrl = build.generateForestUrl(forest);
        PostProcessParams postProcessParams = new PostProcessParams(build.getParams(), false, processor, 2, (DefaultConstructorMarker) null);
        INSTANCE.recordResourceLockInfo(postProcessParams.getSessionId(), containerId);
        PostProcessOperation createSyncRequestWithProcessor = forest.createSyncRequestWithProcessor(generateForestUrl, postProcessParams);
        if (createSyncRequestWithProcessor != null) {
            return createSyncRequestWithProcessor.execute();
        }
        return null;
    }

    public final void loadAsync(final Forest forest, String url, @DownloadEngine String downloadEngine, Scene scene, final String containerId, TaskConfig taskConfig, boolean forceAsync, Function1<? super RequestParams, Unit> onRequestParamsBuilt, final Function1<? super Response, Unit> callback) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(scene, ReportConst.KEY_SCENE);
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (checkRequestValid(forest, url)) {
            final ForestRequestInfo build = reqInfoBuilder.build(url, false, downloadEngine, scene, containerId, taskConfig);
            if (onRequestParamsBuilt != null) {
                onRequestParamsBuilt.invoke(build.getParams());
            }
            INSTANCE.recordResourceLockInfo(build.getParams().getSessionId(), containerId);
            Intrinsics.checkNotNull(forest);
            final String generateForestUrl = build.generateForestUrl(forest);
            runForestRequest(forceAsync, new Function0<Unit>() { // from class: com.bytedance.ies.bullet.forest.ForestLoader$loadAsync$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m500invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m500invoke() {
                    ForestContainerCache forestContainerCache;
                    Forest forest2 = forest;
                    String str = generateForestUrl;
                    RequestParams params = build.getParams();
                    final String str2 = containerId;
                    final String str3 = generateForestUrl;
                    final Function1<Response, Unit> function1 = callback;
                    RequestOperation fetchResourceAsync = forest2.fetchResourceAsync(str, params, new Function1<Response, Unit>() { // from class: com.bytedance.ies.bullet.forest.ForestLoader$loadAsync$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((Response) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Response response) {
                            ForestContainerCache forestContainerCache2;
                            Intrinsics.checkNotNullParameter(response, "response");
                            forestContainerCache2 = ForestLoader.executingRequests;
                            forestContainerCache2.remove(str2, str3);
                            function1.invoke(response);
                        }
                    });
                    if (fetchResourceAsync != null) {
                        String str4 = containerId;
                        String str5 = generateForestUrl;
                        forestContainerCache = ForestLoader.executingRequests;
                        forestContainerCache.putToCache(str4, str5, fetchResourceAsync);
                    }
                }
            });
        }
    }

    public final <T> void loadAsyncWithProcessor(final Forest forest, String url, @DownloadEngine String downloadEngine, Scene scene, final String containerId, TaskConfig taskConfig, boolean forceAsync, ForestPostProcessor<T> processor, Function1<? super RequestParams, Unit> onRequestParamsBuilt, final Function1<? super ProcessedResponse<T>, Unit> callback) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(scene, ReportConst.KEY_SCENE);
        Intrinsics.checkNotNullParameter(processor, "processor");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (checkRequestValid(forest, url)) {
            ForestRequestInfo build = reqInfoBuilder.build(url, false, downloadEngine, scene, containerId, taskConfig);
            if (onRequestParamsBuilt != null) {
                onRequestParamsBuilt.invoke(build.getParams());
            }
            Intrinsics.checkNotNull(forest);
            final String generateForestUrl = build.generateForestUrl(forest);
            final PostProcessParams postProcessParams = new PostProcessParams(build.getParams(), false, processor, 2, (DefaultConstructorMarker) null);
            INSTANCE.recordResourceLockInfo(postProcessParams.getSessionId(), containerId);
            runForestRequest(forceAsync, new Function0<Unit>() { // from class: com.bytedance.ies.bullet.forest.ForestLoader$loadAsyncWithProcessor$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m501invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m501invoke() {
                    ForestContainerCache forestContainerCache;
                    Forest forest2 = forest;
                    String str = generateForestUrl;
                    PostProcessParams<T> postProcessParams2 = postProcessParams;
                    final String str2 = containerId;
                    final String str3 = generateForestUrl;
                    final Function1<ProcessedResponse<T>, Unit> function1 = callback;
                    RequestOperation fetchAsyncWithProcessor = forest2.fetchAsyncWithProcessor(str, postProcessParams2, new Function1<ProcessedResponse<T>, Unit>() { // from class: com.bytedance.ies.bullet.forest.ForestLoader$loadAsyncWithProcessor$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((ProcessedResponse) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(ProcessedResponse<T> processedResponse) {
                            ForestContainerCache forestContainerCache2;
                            Intrinsics.checkNotNullParameter(processedResponse, "response");
                            forestContainerCache2 = ForestLoader.executingRequests;
                            forestContainerCache2.remove(str2, str3);
                            function1.invoke(processedResponse);
                        }
                    });
                    if (fetchAsyncWithProcessor != null) {
                        String str4 = containerId;
                        String str5 = generateForestUrl;
                        forestContainerCache = ForestLoader.executingRequests;
                        forestContainerCache.putToCache(str4, str5, fetchAsyncWithProcessor);
                    }
                }
            });
        }
    }

    public final int preload(final Forest forest, String url, final JSONObject subConfigs, String from, String monitorID, final PreloadType type, TaskConfig taskConfig, boolean forceAsync) {
        final ForestRequestInfo forestRequestInfo;
        Scene scene;
        ForestRequestInfo build;
        Intrinsics.checkNotNullParameter(from, PraiseDialogConstant.FROM);
        Intrinsics.checkNotNullParameter(type, "type");
        if (forest == null) {
            LogUtils.e$default(LogUtils.INSTANCE, TAG, "Neither argument nor default of forest is NULL!", (Throwable) null, true, (Function3) null, (String) null, (Map) null, 112, (Object) null);
            return -1;
        }
        if (from.length() == 0) {
            LogUtils.e$default(LogUtils.INSTANCE, TAG, "from is NULL!", (Throwable) null, true, (Function3) null, (String) null, (Map) null, 112, (Object) null);
            return -2;
        }
        LogUtils.i$default(LogUtils.INSTANCE, TAG, "invoke preload from " + from, false, (Function3) null, (String) null, (Map) null, 60, (Object) null);
        if ((url == null || INSTANCE.checkUrlValid(url)) ? false : true) {
            return -3;
        }
        if (type == PreloadType.LYNX && subConfigs != null) {
            subConfigs.remove(FetchTokenInfoThread.VIDEO_TOKEN);
        }
        if (url != null) {
            ForestRequestInfoBuilder forestRequestInfoBuilder = reqInfoBuilder;
            scene = ForestLoaderKt.toScene(type);
            build = forestRequestInfoBuilder.build(url, true, (r16 & 4) != 0 ? null : null, scene, monitorID, (r16 & 32) != 0 ? null : taskConfig);
            build.getParams().setPreloadFrom(from);
            INSTANCE.recordResourceLockInfo(build.getParams().getSessionId(), monitorID);
            forestRequestInfo = build;
        } else {
            forestRequestInfo = null;
        }
        final String generateForestUrl = forestRequestInfo != null ? forestRequestInfo.generateForestUrl(forest) : null;
        runForestRequest(forceAsync, new Function0<Unit>() { // from class: com.bytedance.ies.bullet.forest.ForestLoader$preload$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m502invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m502invoke() {
                RequestParams requestParams;
                Scene scene2;
                Forest forest2 = forest;
                String str = generateForestUrl;
                ForestRequestInfo forestRequestInfo2 = forestRequestInfo;
                if (forestRequestInfo2 == null || (requestParams = forestRequestInfo2.getParams()) == null) {
                    scene2 = ForestLoaderKt.toScene(type);
                    requestParams = new RequestParams(scene2);
                }
                forest2.preload(str, requestParams, subConfigs, new Function1<String, ForestPostProcessor<?>>() { // from class: com.bytedance.ies.bullet.forest.ForestLoader$preload$2.1
                    public final ForestPostProcessor<?> invoke(String str2) {
                        Intrinsics.checkNotNullParameter(str2, "processType");
                        return Intrinsics.areEqual(str2, "templateBundle") ? new TemplateBundleProcessor(null, false, 3, null) : null;
                    }
                });
            }
        });
        return 0;
    }

    public final <T> int preloadWithProcessor(final Forest forest, String url, final JSONObject subConfigs, String from, String monitorID, final PreloadType type, TaskConfig taskConfig, ForestPostProcessor<T> processor, boolean forceAsync) {
        ForestRequestInfo forestRequestInfo;
        Scene scene;
        Intrinsics.checkNotNullParameter(from, PraiseDialogConstant.FROM);
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(processor, "processor");
        if (forest == null) {
            LogUtils.e$default(LogUtils.INSTANCE, TAG, "Neither argument nor default of forest is NULL!", (Throwable) null, true, (Function3) null, (String) null, (Map) null, 112, (Object) null);
            return -1;
        }
        if (from.length() == 0) {
            LogUtils.e$default(LogUtils.INSTANCE, TAG, "from is NULL!", (Throwable) null, true, (Function3) null, (String) null, (Map) null, 112, (Object) null);
            return -2;
        }
        if ((url == null || INSTANCE.checkUrlValid(url)) ? false : true) {
            return -3;
        }
        if (type == PreloadType.LYNX && subConfigs != null) {
            subConfigs.remove(FetchTokenInfoThread.VIDEO_TOKEN);
        }
        if (url != null) {
            ForestRequestInfoBuilder forestRequestInfoBuilder = reqInfoBuilder;
            scene = ForestLoaderKt.toScene(type);
            forestRequestInfo = forestRequestInfoBuilder.build(url, true, (r16 & 4) != 0 ? null : null, scene, monitorID, (r16 & 32) != 0 ? null : taskConfig);
            forestRequestInfo.getParams().setPreloadFrom(from);
            INSTANCE.recordResourceLockInfo(forestRequestInfo.getParams().getSessionId(), monitorID);
        } else {
            forestRequestInfo = null;
        }
        final String generateForestUrl = forestRequestInfo != null ? forestRequestInfo.generateForestUrl(forest) : null;
        final PostProcessParams postProcessParams = (forestRequestInfo == null || forestRequestInfo.getParams() == null) ? null : new PostProcessParams(forestRequestInfo.getParams(), false, processor, 2, (DefaultConstructorMarker) null);
        runForestRequest(forceAsync, new Function0<Unit>() { // from class: com.bytedance.ies.bullet.forest.ForestLoader$preloadWithProcessor$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m505invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m505invoke() {
                RequestParams requestParams;
                Scene scene2;
                Forest forest2 = forest;
                String str = generateForestUrl;
                RequestParams requestParams2 = postProcessParams;
                if (requestParams2 != null) {
                    requestParams = requestParams2;
                } else {
                    scene2 = ForestLoaderKt.toScene(type);
                    requestParams = new RequestParams(scene2);
                }
                forest2.preload(str, requestParams, subConfigs, new Function1<String, ForestPostProcessor<?>>() { // from class: com.bytedance.ies.bullet.forest.ForestLoader$preloadWithProcessor$2.1
                    public final ForestPostProcessor<?> invoke(String str2) {
                        Intrinsics.checkNotNullParameter(str2, "processType");
                        if (Intrinsics.areEqual(str2, "templateBundle")) {
                            return new TemplateBundleProcessor(null, false, 3, null);
                        }
                        return null;
                    }
                });
            }
        });
        return 0;
    }

    public static /* synthetic */ int preload$default(ForestLoader forestLoader, Forest forest, PreloadConfig preloadConfig, String str, String str2, TaskConfig taskConfig, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            forest = forestLoader.getDefault();
        }
        Forest forest2 = forest;
        String str3 = (i & 8) != 0 ? null : str2;
        TaskConfig taskConfig2 = (i & 16) != 0 ? null : taskConfig;
        if ((i & 32) != 0) {
            z = false;
        }
        return forestLoader.preload(forest2, preloadConfig, str, str3, taskConfig2, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x018a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int preload(final Forest forest, PreloadConfig config, String from, final String monitorID, TaskConfig taskConfig, boolean forceAsync) {
        String str;
        ResourceConfig resourceConfig;
        Map subResource;
        LinkedHashMap linkedHashMap;
        Scene scene;
        ForestRequestInfo build;
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(from, PraiseDialogConstant.FROM);
        if (forest == null) {
            LogUtils.e$default(LogUtils.INSTANCE, TAG, "Neither argument nor default of forest is NULL!", (Throwable) null, true, (Function3) null, (String) null, (Map) null, 112, (Object) null);
            return -1;
        }
        if (from.length() == 0) {
            LogUtils.e$default(LogUtils.INSTANCE, TAG, "from is NULL!", (Throwable) null, true, (Function3) null, (String) null, (Map) null, 112, (Object) null);
            return -2;
        }
        LogUtils.i$default(LogUtils.INSTANCE, TAG, "invoke preload from " + from, false, (Function3) null, (String) null, (Map) null, 60, (Object) null);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ResourceConfig mainResource = config.getMainResource();
        if (mainResource != null) {
            ForestLoader forestLoader = INSTANCE;
            if (forestLoader.checkUrlValid(mainResource.getUrl())) {
                ForestRequestInfoBuilder forestRequestInfoBuilder = reqInfoBuilder;
                String url = mainResource.getUrl();
                scene = ForestLoaderKt.toScene(config.getType());
                build = forestRequestInfoBuilder.build(url, true, (r16 & 4) != 0 ? null : null, scene, monitorID, (r16 & 32) != 0 ? null : taskConfig);
                objectRef.element = build.getParams().getSessionId();
                str = build.getParams().getInjectedUserAgent();
                forestLoader.recordResourceLockInfo((String) objectRef.element, monitorID);
                resourceConfig = new ResourceConfig(build.generateForestUrl(forest), mainResource.getEnableMemoryCache(), mainResource.getSize(), mainResource.getDisableCDN(), mainResource.getNetWorker());
                resourceConfig.setMaxAge(mainResource.getMaxAge());
                PreloadType type = config.getType();
                subResource = config.getSubResource();
                if (subResource == null) {
                    Set<Map.Entry> entrySet = subResource.entrySet();
                    int i = 10;
                    linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(entrySet, 10)), 16));
                    for (Map.Entry entry : entrySet) {
                        Object key = entry.getKey();
                        Iterable<ResourceConfig> iterable = (Iterable) entry.getValue();
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, i));
                        for (ResourceConfig resourceConfig2 : iterable) {
                            ResourceConfig resourceConfig3 = new ResourceConfig(!INSTANCE.checkUrlValid(resourceConfig2.getUrl()) ? "" : ForestRequestInfoBuilderKt.addEnvParamsForCDNMultiVersion(resourceConfig2.getUrl()), resourceConfig2.getEnableMemoryCache(), resourceConfig2.getSize(), resourceConfig2.getDisableCDN(), resourceConfig2.getNetWorker());
                            resourceConfig3.setMaxAge(resourceConfig2.getMaxAge());
                            arrayList.add(resourceConfig3);
                        }
                        Pair pair = TuplesKt.to(key, arrayList);
                        linkedHashMap.put(pair.getFirst(), pair.getSecond());
                        i = 10;
                    }
                } else {
                    linkedHashMap = null;
                }
                final PreloadConfig preloadConfig = new PreloadConfig(resourceConfig, type, linkedHashMap);
                preloadConfig.setFrom(from);
                preloadConfig.setInjectUserAgent(str);
                runForestRequest(forceAsync, new Function0<Unit>() { // from class: com.bytedance.ies.bullet.forest.ForestLoader$preload$3
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m503invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m503invoke() {
                        forest.preload(preloadConfig, monitorID, (String) objectRef.element);
                    }
                });
                return 0;
            }
        }
        str = null;
        resourceConfig = null;
        PreloadType type2 = config.getType();
        subResource = config.getSubResource();
        if (subResource == null) {
        }
        final PreloadConfig preloadConfig2 = new PreloadConfig(resourceConfig, type2, linkedHashMap);
        preloadConfig2.setFrom(from);
        preloadConfig2.setInjectUserAgent(str);
        runForestRequest(forceAsync, new Function0<Unit>() { // from class: com.bytedance.ies.bullet.forest.ForestLoader$preload$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m503invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m503invoke() {
                forest.preload(preloadConfig2, monitorID, (String) objectRef.element);
            }
        });
        return 0;
    }

    public final int preload(final Forest forest, String url, final boolean withSubResources, final String monitorID, PreloadType type, boolean useTTNet, String from, TaskConfig taskConfig, boolean forceAsync, Function2<? super Response, ? super ForestRequestInfo, Unit> onPreloadFinished) {
        Scene scene;
        final ForestRequestInfo build;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(from, PraiseDialogConstant.FROM);
        if (forest == null) {
            LogUtils.e$default(LogUtils.INSTANCE, TAG, "Neither argument nor default of forest is NULL!", (Throwable) null, true, (Function3) null, (String) null, (Map) null, 112, (Object) null);
            return -1;
        }
        if (from.length() == 0) {
            LogUtils.e$default(LogUtils.INSTANCE, TAG, "from is NULL!", (Throwable) null, true, (Function3) null, (String) null, (Map) null, 112, (Object) null);
            return -2;
        }
        LogUtils.i$default(LogUtils.INSTANCE, TAG, "invoke preload from " + from, false, (Function3) null, (String) null, (Map) null, 60, (Object) null);
        if (!checkUrlValid(url)) {
            return -3;
        }
        ForestRequestInfoBuilder forestRequestInfoBuilder = reqInfoBuilder;
        scene = ForestLoaderKt.toScene(type);
        build = forestRequestInfoBuilder.build(url, true, (r16 & 4) != 0 ? null : null, scene, monitorID, (r16 & 32) != 0 ? null : taskConfig);
        build.getParams().setPreloadFrom(from);
        if (useTTNet) {
            build.getParams().setNetWorker(NetWorker.TTNet);
        }
        INSTANCE.recordResourceLockInfo(build.getParams().getSessionId(), monitorID);
        if (onPreloadFinished != null) {
            preloadMonitor.listen(monitorID, build, onPreloadFinished, forest);
        }
        final String generateForestUrl = build.generateForestUrl(forest);
        runForestRequest(forceAsync, new Function0<Unit>() { // from class: com.bytedance.ies.bullet.forest.ForestLoader$preload$5
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m504invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m504invoke() {
                forest.preload(generateForestUrl, build.getParams(), withSubResources, monitorID, build.getParams().getSessionId(), new Function1<String, ForestPostProcessor<?>>() { // from class: com.bytedance.ies.bullet.forest.ForestLoader$preload$5.1
                    public final ForestPostProcessor<?> invoke(String str) {
                        Intrinsics.checkNotNullParameter(str, "processType");
                        return Intrinsics.areEqual(str, "templateBundle") ? new TemplateBundleProcessor(null, false, 3, null) : null;
                    }
                });
            }
        });
        return 0;
    }

    public final <T> int preloadWithProcessor(final Forest forest, String url, final boolean withSubResources, final String monitorID, PreloadType type, boolean useTTNet, String from, TaskConfig taskConfig, boolean forceAsync, ForestPostProcessor<T> processor, Function2<? super Response, ? super ForestRequestInfo, Unit> onPreloadFinished) {
        Scene scene;
        final ForestRequestInfo build;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(from, PraiseDialogConstant.FROM);
        Intrinsics.checkNotNullParameter(processor, "processor");
        if (forest == null) {
            LogUtils.e$default(LogUtils.INSTANCE, TAG, "Neither argument nor default of forest is NULL!", (Throwable) null, true, (Function3) null, (String) null, (Map) null, 112, (Object) null);
            return -1;
        }
        if (from.length() == 0) {
            LogUtils.e$default(LogUtils.INSTANCE, TAG, "from is NULL!", (Throwable) null, true, (Function3) null, (String) null, (Map) null, 112, (Object) null);
            return -2;
        }
        if (!checkUrlValid(url)) {
            return -3;
        }
        ForestRequestInfoBuilder forestRequestInfoBuilder = reqInfoBuilder;
        scene = ForestLoaderKt.toScene(type);
        build = forestRequestInfoBuilder.build(url, true, (r16 & 4) != 0 ? null : null, scene, monitorID, (r16 & 32) != 0 ? null : taskConfig);
        build.getParams().setPreloadFrom(from);
        if (useTTNet) {
            build.getParams().setNetWorker(NetWorker.TTNet);
        }
        if (onPreloadFinished != null) {
            preloadMonitor.listen(monitorID, build, onPreloadFinished, forest);
        }
        final String generateForestUrl = build.generateForestUrl(forest);
        final PostProcessParams postProcessParams = new PostProcessParams(build.getParams(), false, processor, 2, (DefaultConstructorMarker) null);
        INSTANCE.recordResourceLockInfo(postProcessParams.getSessionId(), monitorID);
        runForestRequest(forceAsync, new Function0<Unit>() { // from class: com.bytedance.ies.bullet.forest.ForestLoader$preloadWithProcessor$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m506invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m506invoke() {
                forest.preload(generateForestUrl, postProcessParams, withSubResources, monitorID, build.getParams().getSessionId(), new Function1<String, ForestPostProcessor<?>>() { // from class: com.bytedance.ies.bullet.forest.ForestLoader$preloadWithProcessor$4.1
                    public final ForestPostProcessor<?> invoke(String str) {
                        Intrinsics.checkNotNullParameter(str, "processType");
                        if (Intrinsics.areEqual(str, "templateBundle")) {
                            return new TemplateBundleProcessor(null, false, 3, null);
                        }
                        return null;
                    }
                });
            }
        });
        return 0;
    }

    private final boolean checkRequestValid(Forest forest, String url) {
        if (forest != null) {
            return checkUrlValid(url);
        }
        LogUtils.e$default(LogUtils.INSTANCE, TAG, "Neither argument nor default of forest is NULL!", (Throwable) null, true, (Function3) null, (String) null, (Map) null, 112, (Object) null);
        if (BulletEnv.INSTANCE.getInstance().getDebuggable()) {
            throw new IllegalArgumentException("Neither argument nor default of forest is NULL!");
        }
        return false;
    }

    private final boolean checkUrlValid(String url) {
        if (Uri.parse(url).isHierarchical()) {
            return true;
        }
        LogUtils.e$default(LogUtils.INSTANCE, TAG, url + " is not a hierarchical uri", (Throwable) null, true, (Function3) null, (String) null, (Map) null, 112, (Object) null);
        return false;
    }

    public final Response fetchImageCache(String containerId, String imgPath) {
        Intrinsics.checkNotNullParameter(imgPath, "imgPath");
        return imageCache.fetchCache(containerId, imgPath);
    }

    public final void putImageToCache(String containerId, String imgPath, Response response) {
        Intrinsics.checkNotNullParameter(imgPath, "imgPath");
        Intrinsics.checkNotNullParameter(response, "response");
        imageCache.putToCache(containerId, imgPath, response);
    }

    public final void release(String containerId) {
        Set<Map.Entry<String, RequestOperation>> entrySet;
        String str = containerId;
        if (str == null || str.length() == 0) {
            return;
        }
        ConcurrentHashMap<String, RequestOperation> clear = executingRequests.clear(containerId);
        if (clear != null && (entrySet = clear.entrySet()) != null) {
            Iterator<T> it = entrySet.iterator();
            while (it.hasNext()) {
                ((RequestOperation) ((Map.Entry) it.next()).getValue()).cancel();
            }
        }
        imageCache.clear(containerId);
        reqInfoBuilder.clear(containerId);
        Map<String, Set<String>> map = resourceLocker;
        synchronized (map) {
            Iterator<Map.Entry<String, Set<String>>> it2 = map.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry<String, Set<String>> next = it2.next();
                String key = next.getKey();
                Set<String> value = next.getValue();
                value.remove(containerId);
                if (value.isEmpty()) {
                    Forest forest = INSTANCE.getDefault();
                    if (forest != null) {
                        forest.closeSession(key);
                    }
                    it2.remove();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void runForestRequest(boolean forceAsync, final Function0<Unit> request) {
        if (forceAsync) {
            Schedulers.io().scheduleDirect(new Runnable() { // from class: com.bytedance.ies.bullet.forest.ForestLoader$runForestRequest$1
                @Override // java.lang.Runnable
                public final void run() {
                    request.invoke();
                }
            });
        } else {
            request.invoke();
        }
    }

    private final void recordResourceLockInfo(String sessionId, String containerId) {
        String str = sessionId;
        if (str == null || str.length() == 0) {
            return;
        }
        String str2 = containerId;
        if (str2 == null || str2.length() == 0) {
            return;
        }
        Map<String, Set<String>> map = resourceLocker;
        synchronized (map) {
            LinkedHashSet linkedHashSet = map.get(sessionId);
            if (linkedHashSet == null) {
                linkedHashSet = new LinkedHashSet();
            }
            linkedHashSet.add(containerId);
            map.put(sessionId, linkedHashSet);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final String getForestPreloadKey(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return new ForestPreloadKey(url).getKey();
    }
}
