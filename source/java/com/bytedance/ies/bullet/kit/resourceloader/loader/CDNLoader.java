package com.bytedance.ies.bullet.kit.resourceloader.loader;

import android.net.Uri;
import android.os.Looper;
import android.os.SystemClock;
import bolts.Task;
import com.bytedance.ies.argus.util.ForceHttpsUtil;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.kit.resourceloader.FileMetaInfo;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoader;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoaderUtils;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceMetaData;
import com.bytedance.ies.bullet.kit.resourceloader.TimeInterval;
import com.bytedance.ies.bullet.kit.resourceloader.loggger.RLLogger;
import com.bytedance.ies.bullet.kit.resourceloader.loggger.RLLoggerConstant;
import com.bytedance.ies.bullet.kit.resourceloader.monitor.RLMonitorReporter;
import com.bytedance.ies.bullet.service.base.ResourceFrom;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.ies.bullet.service.base.ResourceType;
import com.bytedance.ies.bullet.service.base.resourceloader.config.IXResourceLoader;
import com.bytedance.ies.bullet.service.base.resourceloader.config.RLDownLoadInfo;
import com.bytedance.ies.bullet.service.base.resourceloader.config.RLDownloaderListener;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import com.bytedance.push.event.sync.ISignalReportConstants;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: CDNLoader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016JH\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\b0\u00102\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\b0\u0010H\u0002J\b\u0010\u0014\u001a\u00020\fH\u0002J@\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\b0\u00102\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\b0\u0010H\u0016JH\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\b0\u00102\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\b0\u0010H\u0002J\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u000eH\u0016J`\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\b0\u001d2$\u0010\u0012\u001a \u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\b0\u001fH\u0002J\b\u0010!\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006#"}, d2 = {"Lcom/bytedance/ies/bullet/kit/resourceloader/loader/CDNLoader;", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/IXResourceLoader;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "cancelLoad", "", CDNLoader.STEP_NAME_DOWNLOAD_RESOURCE_FILE, CDNLoader.DIAGNOSE_SOURCE_URL, "syncCall", "", "config", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/TaskConfig;", "resolve", "Lkotlin/Function1;", "Lcom/bytedance/ies/bullet/kit/resourceloader/ResourceMetaData;", "reject", "", "isMainThread", "loadAsync", "input", "Lcom/bytedance/ies/bullet/service/base/ResourceInfo;", "loadFromCDN", "uri", "Landroid/net/Uri;", CDNLoader.STEP_NAME_SYNC, "realLoad", "Lkotlin/Function2;", "", "Lkotlin/Function4;", "", "toString", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class CDNLoader extends IXResourceLoader {
    public static final String CDN_INVALID_URL = "cdn Invalid URL";
    public static final String DIAGNOSE_ERROR_CODE = "error_code";
    public static final String DIAGNOSE_ERROR_MESSAGE = "error_message";
    public static final String DIAGNOSE_REJECT_ERROR_MESSAGE = "reject_error_message";
    public static final String DIAGNOSE_SOURCE_URL = "sourceUrl";
    public static final String DOWNLOAD_FAILED_ERROR = "-2";
    public static final String DOWNLOAD_SUCCESS_ERROR = "-1";
    public static final String EXCEPTION_CDN_FAILED = "cdn ";
    public static final String EXCEPTION_FILE_NOT_FOUND = "[cdn] resource not found on url:";
    public static final String EXTRA_INPUT = "input";
    public static final String MESSAGE_ASYNC_CDN_RESOLVE = "start to Async load from cdn";
    public static final String MESSAGE_CDN_REJECT = "[cdn] resource load rejected";
    public static final String MESSAGE_FILE_DOWNLOAD_FAILED = "onFailed ";
    public static final String MESSAGE_RESOURCE_NOT_FOUND = "[cdn] resource not found";
    public static final String MESSAGE_SYNC_CDN_RESOLVE = "start to sync load from cdn";
    public static final String MODULE_NAME = "CDNLoader";
    public static final String PIPELINE_MESSAGE = "message";
    public static final String PIPELINE_NAME = "name";
    public static final String PIPELINE_STATUS = "status";
    public static final String PIPELINE_STATUS_FAILED = "failed";
    public static final String PIPELINE_STATUS_SUCCESS = "success";
    public static final String PIPELINE_VALUE = "CDN";
    public static final int REJECT_FILE_NOT_FOUND = 0;
    public static final int REJECT_OTHER = 1;
    public static final String SCHEMA_HTTP = "http";
    public static final String SCHEMA_HTTPS = "https";
    public static final String SCHEMA_LYNXVIEW = "lynxview";
    public static final String STEP_NAME_ASYNC = "loadASync";
    public static final String STEP_NAME_DOWNLOAD_RESOURCE_FILE = "downloadResourceFile";
    public static final String STEP_NAME_SYNC = "loadSync";
    private final String TAG = PIPELINE_VALUE;

    @Override // com.bytedance.ies.bullet.service.base.resourceloader.config.IXResourceLoader
    public void cancelLoad() {
    }

    @Override // com.bytedance.ies.bullet.service.base.resourceloader.config.IXResourceLoader
    public String getTAG() {
        return this.TAG;
    }

    private final void realLoad(final ResourceInfo input, final TaskConfig config, boolean syncCall, final Function2<? super ResourceInfo, ? super Long, Unit> resolve, final Function4<? super Integer, ? super Throwable, ? super ResourceInfo, ? super Long, Unit> reject) {
        Uri parse;
        final LoggerContext loggerContext = new LoggerContext();
        loggerContext.pushStage(RLLoggerConstant.RESOURCE_SESSION, config.getResourceLoaderSession());
        setInterval(new TimeInterval());
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        if (config.getCdnUrl().length() == 0) {
            parse = input.getSrcUri();
        } else {
            parse = Uri.parse(config.getCdnUrl());
        }
        final Uri uri = parse;
        HybridLogger.INSTANCE.m11i("XResourceLoader", "CDNLoader realLoad", MapsKt.mapOf(new Pair[]{TuplesKt.to("cdnUrl", config.getCdnUrl()), TuplesKt.to("taskConfig", config.toString()), TuplesKt.to("url", input.getSrcUri().toString())}), loggerContext);
        Intrinsics.checkNotNullExpressionValue(uri, "uri");
        loadFromCDN(uri, syncCall, config, new Function1<ResourceMetaData, Unit>() { // from class: com.bytedance.ies.bullet.kit.resourceloader.loader.CDNLoader$realLoad$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ResourceMetaData) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(ResourceMetaData resourceMetaData) {
                Intrinsics.checkNotNullParameter(resourceMetaData, "it");
                FileMetaInfo asFileMeta = resourceMetaData.asFileMeta();
                File file = asFileMeta != null ? asFileMeta.getFile() : null;
                JSONObject metrics = ResourceInfo.this.getPerformanceInfo().getMetrics();
                if (metrics != null) {
                    metrics.put(RLMonitorReporter.CDN_TOTAL, this.getInterval().getTotalTime());
                }
                if (file != null && file.exists()) {
                    HybridLogger.INSTANCE.m11i("XResourceLoader", "fetch cdn successfully", MapsKt.mapOf(new Pair[]{TuplesKt.to("taskConfig", config.toString()), TuplesKt.to("url", uri.toString())}), loggerContext);
                    Function2<ResourceInfo, Long, Unit> function2 = resolve;
                    ResourceInfo resourceInfo = ResourceInfo.this;
                    Uri uri2 = uri;
                    resourceInfo.setFilePath(file.getAbsolutePath());
                    resourceInfo.setType(ResourceType.DISK);
                    resourceInfo.setFrom(ResourceFrom.CDN);
                    resourceInfo.setCache(asFileMeta.getIsCache());
                    JSONArray pipelineStatus = resourceInfo.getPipelineStatus();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("name", CDNLoader.PIPELINE_VALUE);
                    jSONObject.put("status", "success");
                    pipelineStatus.put(jSONObject);
                    resourceInfo.setCdnSafeUrl(uri2.toString());
                    function2.invoke(resourceInfo, Long.valueOf(elapsedRealtime));
                    return;
                }
                HybridLogger.INSTANCE.m11i("XResourceLoader", "fetch cdn failed", MapsKt.mapOf(new Pair[]{TuplesKt.to(ISignalReportConstants.KEY_REASON, CDNLoader.EXCEPTION_FILE_NOT_FOUND), TuplesKt.to("taskConfig", config.toString()), TuplesKt.to("url", uri)}), loggerContext);
                reject.invoke(0, new FileNotFoundException(CDNLoader.EXCEPTION_FILE_NOT_FOUND + ResourceInfo.this.getSrcUri()), ResourceInfo.this, Long.valueOf(elapsedRealtime));
            }
        }, new Function1<Throwable, Unit>() { // from class: com.bytedance.ies.bullet.kit.resourceloader.loader.CDNLoader$realLoad$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "throwable");
                ResourceInfo resourceInfo = ResourceInfo.this;
                CDNLoader cDNLoader = this;
                JSONObject metrics = resourceInfo.getPerformanceInfo().getMetrics();
                if (metrics != null) {
                    metrics.put(RLMonitorReporter.CDN_TOTAL, cDNLoader.getInterval().getTotalTime());
                }
                JSONArray pipelineStatus = resourceInfo.getPipelineStatus();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("name", CDNLoader.PIPELINE_VALUE);
                jSONObject.put("status", CDNLoader.PIPELINE_STATUS_FAILED);
                jSONObject.put("message", th.getMessage());
                pipelineStatus.put(jSONObject);
                ResourceInfo resourceInfo2 = ResourceInfo.this;
                StringBuilder sb = new StringBuilder(CDNLoader.EXCEPTION_CDN_FAILED);
                String message = th.getMessage();
                if (message == null) {
                    message = "";
                }
                resourceInfo2.setCdnFailedMessage(sb.append(message).toString());
                HybridLogger.INSTANCE.m11i("XResourceLoader", "fetch cdn failed", MapsKt.mapOf(new Pair[]{TuplesKt.to(ISignalReportConstants.KEY_REASON, th.getMessage()), TuplesKt.to("taskConfig", config.toString()), TuplesKt.to("url", uri.toString())}), loggerContext);
                reject.invoke(1, th, ResourceInfo.this, Long.valueOf(elapsedRealtime));
            }
        });
    }

    @Override // com.bytedance.ies.bullet.service.base.resourceloader.config.IXResourceLoader
    public ResourceInfo loadSync(ResourceInfo input, TaskConfig config) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(config, "config");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        realLoad(input, config, true, new Function2<ResourceInfo, Long, Unit>() { // from class: com.bytedance.ies.bullet.kit.resourceloader.loader.CDNLoader$loadSync$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((ResourceInfo) obj, ((Number) obj2).longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(ResourceInfo resourceInfo, long j) {
                Intrinsics.checkNotNullParameter(resourceInfo, "info");
                objectRef.element = resourceInfo;
                countDownLatch.countDown();
            }
        }, new Function4<Integer, Throwable, ResourceInfo, Long, Unit>() { // from class: com.bytedance.ies.bullet.kit.resourceloader.loader.CDNLoader$loadSync$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                invoke(((Number) obj).intValue(), (Throwable) obj2, (ResourceInfo) obj3, ((Number) obj4).longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i, Throwable th, ResourceInfo resourceInfo, long j) {
                Intrinsics.checkNotNullParameter(th, "<anonymous parameter 1>");
                Intrinsics.checkNotNullParameter(resourceInfo, "info");
                objectRef.element = resourceInfo;
                booleanRef.element = false;
                countDownLatch.countDown();
            }
        });
        countDownLatch.await(config.getLoadTimeOut(), TimeUnit.MILLISECONDS);
        HybridLogger hybridLogger = HybridLogger.INSTANCE;
        Map<String, ? extends Object> mapOf = MapsKt.mapOf(new Pair[]{TuplesKt.to("cdnUrl", config.getCdnUrl()), TuplesKt.to("taskConfig", config.toString()), TuplesKt.to("url", input.getSrcUri().toString()), TuplesKt.to("success", Boolean.valueOf(booleanRef.element))});
        LoggerContext loggerContext = new LoggerContext();
        loggerContext.pushStage(RLLoggerConstant.RESOURCE_SESSION, config.getResourceLoaderSession());
        Unit unit = Unit.INSTANCE;
        hybridLogger.m11i("XResourceLoader", "CDNLoader loadSync", mapOf, loggerContext);
        return (ResourceInfo) objectRef.element;
    }

    @Override // com.bytedance.ies.bullet.service.base.resourceloader.config.IXResourceLoader
    public void loadAsync(ResourceInfo input, TaskConfig config, final Function1<? super ResourceInfo, Unit> resolve, final Function1<? super Throwable, Unit> reject) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(resolve, "resolve");
        Intrinsics.checkNotNullParameter(reject, "reject");
        HybridLogger hybridLogger = HybridLogger.INSTANCE;
        Map<String, ? extends Object> mapOf = MapsKt.mapOf(new Pair[]{TuplesKt.to("cdnUrl", config.getCdnUrl()), TuplesKt.to("taskConfig", config.toString()), TuplesKt.to("url", input.getSrcUri().toString())});
        LoggerContext loggerContext = new LoggerContext();
        loggerContext.pushStage(RLLoggerConstant.RESOURCE_SESSION, config.getResourceLoaderSession());
        Unit unit = Unit.INSTANCE;
        hybridLogger.m11i("XResourceLoader", "CDNLoader loadAsync", mapOf, loggerContext);
        realLoad(input, config, false, new Function2<ResourceInfo, Long, Unit>() { // from class: com.bytedance.ies.bullet.kit.resourceloader.loader.CDNLoader$loadAsync$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((ResourceInfo) obj, ((Number) obj2).longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(ResourceInfo resourceInfo, long j) {
                Intrinsics.checkNotNullParameter(resourceInfo, "info");
                resolve.invoke(resourceInfo);
            }
        }, new Function4<Integer, Throwable, ResourceInfo, Long, Unit>() { // from class: com.bytedance.ies.bullet.kit.resourceloader.loader.CDNLoader$loadAsync$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                invoke(((Number) obj).intValue(), (Throwable) obj2, (ResourceInfo) obj3, ((Number) obj4).longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i, Throwable th, ResourceInfo resourceInfo, long j) {
                Intrinsics.checkNotNullParameter(th, "throwable");
                Intrinsics.checkNotNullParameter(resourceInfo, "info");
                reject.invoke(th);
            }
        });
    }

    private final void loadFromCDN(Uri uri, boolean syncCall, TaskConfig config, Function1<? super ResourceMetaData, Unit> resolve, Function1<? super Throwable, Unit> reject) {
        RLLogger.INSTANCE.m24w("CDNLoader loadFromCDN,uri=" + uri + ", syncCall=" + syncCall);
        String scheme = uri.getScheme();
        if (scheme != null) {
            int hashCode = scheme.hashCode();
            if (hashCode != -1772600516) {
                if (hashCode != 3213448) {
                    String uri2 = uri.toString();
                    Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
                    downloadResourceFile(uri2, syncCall, config, resolve, reject);
                    return;
                } else {
                    String uri22 = uri.toString();
                    Intrinsics.checkNotNullExpressionValue(uri22, "uri.toString()");
                    downloadResourceFile(uri22, syncCall, config, resolve, reject);
                    return;
                }
            }
            if (scheme.equals("lynxview")) {
                String cdn = ResourceLoaderUtils.INSTANCE.getCDN(uri);
                if (cdn == null) {
                    cdn = "";
                }
                downloadResourceFile(cdn, syncCall, config, resolve, reject);
                return;
            }
        }
        HybridLogger hybridLogger = HybridLogger.INSTANCE;
        Map<String, ? extends Object> mapOf = MapsKt.mapOf(new Pair[]{TuplesKt.to("cdnUrl", uri.toString()), TuplesKt.to("taskConfig", config.toString())});
        LoggerContext loggerContext = new LoggerContext();
        loggerContext.pushStage(RLLoggerConstant.RESOURCE_SESSION, config.getResourceLoaderSession());
        Unit unit = Unit.INSTANCE;
        hybridLogger.m11i("XResourceLoader", "CDNLoader cdn Invalid URL", mapOf, loggerContext);
        reject.invoke(new IllegalArgumentException(CDN_INVALID_URL));
    }

    private final void downloadResourceFile(String sourceUrl, final boolean syncCall, TaskConfig config, final Function1<? super ResourceMetaData, Unit> resolve, final Function1<? super Throwable, Unit> reject) {
        final String forceToHttps = ForceHttpsUtil.INSTANCE.forceToHttps(sourceUrl);
        RLLogger.INSTANCE.m24w("CDNLoader downloadResourceFile,origin uri=" + sourceUrl + ", secUrl=" + forceToHttps + ", syncCall=" + syncCall);
        getService().getResourceConfig().getDownloadDepender().downloadResourceFile(forceToHttps, syncCall, config, new RLDownloaderListener() { // from class: com.bytedance.ies.bullet.kit.resourceloader.loader.CDNLoader$downloadResourceFile$1
            @Override // com.bytedance.ies.bullet.service.base.resourceloader.config.RLDownloaderListener
            public void onSuccess(final RLDownLoadInfo infoRL) {
                boolean isMainThread;
                Intrinsics.checkNotNullParameter(infoRL, "infoRL");
                RLLogger.INSTANCE.m21d("CDNLoader onSuccess,uri=" + forceToHttps + ", syncCall=" + syncCall + ",isCache=" + infoRL.getIsCache());
                final Function1<ResourceMetaData, Unit> function1 = resolve;
                final String str = forceToHttps;
                Callable callable = new Callable() { // from class: com.bytedance.ies.bullet.kit.resourceloader.loader.CDNLoader$downloadResourceFile$1$onSuccess$runnable$1
                    @Override // java.util.concurrent.Callable
                    public /* bridge */ /* synthetic */ Object call() {
                        call();
                        return Unit.INSTANCE;
                    }

                    @Override // java.util.concurrent.Callable
                    public final void call() {
                        try {
                            Function1<ResourceMetaData, Unit> function12 = function1;
                            Uri parse = Uri.parse(str);
                            Intrinsics.checkNotNullExpressionValue(parse, "parse(secUrl)");
                            ResourceMetaData resourceMetaData = new ResourceMetaData(parse);
                            RLDownLoadInfo rLDownLoadInfo = infoRL;
                            FileMetaInfo fileMetaInfo = new FileMetaInfo(new File(rLDownLoadInfo.getFilePath()), ResourceFrom.CDN);
                            fileMetaInfo.setChannelVersion(0L);
                            fileMetaInfo.setFrom(ResourceFrom.CDN);
                            fileMetaInfo.setCache(rLDownLoadInfo.getIsCache());
                            resourceMetaData.setMetaInfo(fileMetaInfo);
                            function12.invoke(resourceMetaData);
                        } catch (Throwable th) {
                            if (ResourceLoader.INSTANCE.isDebug()) {
                                throw new Throwable(th);
                            }
                            RLLogger.INSTANCE.m21d("CDNLoader resolveOnException,uri=" + str + ", message=" + th.getMessage());
                        }
                    }
                };
                isMainThread = this.isMainThread();
                if (isMainThread) {
                    callable.call();
                } else {
                    Task.call(callable, Task.UI_THREAD_EXECUTOR);
                }
            }

            @Override // com.bytedance.ies.bullet.service.base.resourceloader.config.RLDownloaderListener
            public void onFailed(final String errorMessage) {
                boolean isMainThread;
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                RLLogger.INSTANCE.m21d("CDNLoader onFailed,uri=" + forceToHttps + ", message=" + errorMessage);
                final Function1<Throwable, Unit> function1 = reject;
                Callable callable = new Callable() { // from class: com.bytedance.ies.bullet.kit.resourceloader.loader.CDNLoader$downloadResourceFile$1$onFailed$runnable$1
                    @Override // java.util.concurrent.Callable
                    public /* bridge */ /* synthetic */ Object call() {
                        call();
                        return Unit.INSTANCE;
                    }

                    @Override // java.util.concurrent.Callable
                    public final void call() {
                        try {
                            function1.invoke(new Throwable(errorMessage));
                        } catch (Throwable th) {
                            if (ResourceLoader.INSTANCE.isDebug()) {
                                throw new Throwable(th);
                            }
                            th.printStackTrace();
                        }
                    }
                };
                isMainThread = this.isMainThread();
                if (isMainThread) {
                    callable.call();
                } else {
                    Task.call(callable, Task.UI_THREAD_EXECUTOR);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isMainThread() {
        return Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper());
    }

    public String toString() {
        return "CDNLoader@" + this;
    }
}
