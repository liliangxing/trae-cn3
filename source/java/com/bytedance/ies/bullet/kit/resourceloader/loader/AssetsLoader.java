package com.bytedance.ies.bullet.kit.resourceloader.loader;

import android.app.Application;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoader;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceMetaData;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceUriHelperKt;
import com.bytedance.ies.bullet.kit.resourceloader.StreamMetaInfo;
import com.bytedance.ies.bullet.kit.resourceloader.TimeInterval;
import com.bytedance.ies.bullet.kit.resourceloader.loggger.RLLogger;
import com.bytedance.ies.bullet.kit.resourceloader.loggger.RLLoggerConstant;
import com.bytedance.ies.bullet.kit.resourceloader.model.RLChannelBundleModel;
import com.bytedance.ies.bullet.kit.resourceloader.monitor.RLMonitorReporter;
import com.bytedance.ies.bullet.service.base.ResourceFrom;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.ies.bullet.service.base.ResourceType;
import com.bytedance.ies.bullet.service.base.resourceloader.config.IXResourceLoader;
import com.bytedance.ies.bullet.service.base.resourceloader.config.ResourceLoaderConfig;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.lynx.scc.cloudservice.SccResult;
import com.bytedance.push.event.sync.ISignalReportConstants;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AssetsLoader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J@\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\b0\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\b0\u0016H\u0016J\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ies/bullet/kit/resourceloader/loader/AssetsLoader;", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/IXResourceLoader;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "cancelLoad", "", "interceptAssetRequest", "Lcom/bytedance/ies/bullet/kit/resourceloader/ResourceMetaData;", "url", "bid", "loadAssetStream", "uri", "Landroid/net/Uri;", "loadAsync", "input", "Lcom/bytedance/ies/bullet/service/base/ResourceInfo;", "config", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/TaskConfig;", "resolve", "Lkotlin/Function1;", "reject", "", CDNLoader.STEP_NAME_SYNC, "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class AssetsLoader extends IXResourceLoader {
    private final String TAG = "BuildIn";

    @Override // com.bytedance.ies.bullet.service.base.resourceloader.config.IXResourceLoader
    public void cancelLoad() {
    }

    @Override // com.bytedance.ies.bullet.service.base.resourceloader.config.IXResourceLoader
    public String getTAG() {
        return this.TAG;
    }

    @Override // com.bytedance.ies.bullet.service.base.resourceloader.config.IXResourceLoader
    public ResourceInfo loadSync(final ResourceInfo input, TaskConfig config) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(config, "config");
        LoggerContext loggerContext = new LoggerContext();
        loggerContext.pushStage(RLLoggerConstant.RESOURCE_SESSION, config.getResourceLoaderSession());
        HybridLogger.INSTANCE.m11i("XResourceLoader", "start to sync load from assets", MapsKt.mapOf(TuplesKt.to("url", input.getSrcUri().toString())), loggerContext);
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        loadAsync(input, config, new Function1<ResourceInfo, Unit>() { // from class: com.bytedance.ies.bullet.kit.resourceloader.loader.AssetsLoader$loadSync$1
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
                Intrinsics.checkNotNullParameter(resourceInfo, "it");
                objectRef.element = resourceInfo;
                JSONArray pipelineStatus = input.getPipelineStatus();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("name", this.getTAG());
                jSONObject.put("status", "success");
                pipelineStatus.put(jSONObject);
                countDownLatch.countDown();
            }
        }, new Function1<Throwable, Unit>() { // from class: com.bytedance.ies.bullet.kit.resourceloader.loader.AssetsLoader$loadSync$2
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
                JSONArray pipelineStatus = ResourceInfo.this.getPipelineStatus();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("name", this.getTAG());
                jSONObject.put("status", SccResult.MESSAGE_FAIL);
                jSONObject.put("message", String.valueOf(th.getMessage()));
                pipelineStatus.put(jSONObject);
                booleanRef.element = false;
                countDownLatch.countDown();
            }
        });
        countDownLatch.await(config.getLoadTimeOut(), TimeUnit.MILLISECONDS);
        HybridLogger.INSTANCE.m11i("XResourceLoader", "AssetsLoader sync load from assets", MapsKt.mapOf(new Pair[]{TuplesKt.to("url", input.getSrcUri().toString()), TuplesKt.to("success", Boolean.valueOf(booleanRef.element))}), loggerContext);
        return (ResourceInfo) objectRef.element;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:158:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x014a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x03d0  */
    /* JADX WARN: Type inference failed for: r0v30, types: [com.bytedance.ies.bullet.base.utils.logger.HybridLogger] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.bytedance.ies.bullet.kit.resourceloader.loader.AssetsLoader] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v23, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r4v6, types: [com.bytedance.ies.bullet.base.utils.logger.HybridLogger] */
    /* JADX WARN: Type inference failed for: r7v10, types: [com.bytedance.ies.bullet.base.utils.logger.LoggerContext] */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v29, types: [com.bytedance.ies.bullet.base.utils.logger.LoggerContext] */
    /* JADX WARN: Type inference failed for: r7v9 */
    @Override // com.bytedance.ies.bullet.service.base.resourceloader.config.IXResourceLoader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void loadAsync(ResourceInfo input, TaskConfig config, Function1<? super ResourceInfo, Unit> resolve, Function1<? super Throwable, Unit> reject) {
        String channel;
        String bundle;
        String str;
        ?? r7;
        JSONObject metrics;
        Object obj;
        String str2;
        LoggerContext loggerContext;
        String str3;
        String str4;
        String str5;
        Uri streamPathUri;
        String str6;
        String str7;
        Uri streamPathUri2;
        ?? r1 = this;
        TaskConfig taskConfig = config;
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(taskConfig, "config");
        Intrinsics.checkNotNullParameter(resolve, "resolve");
        Intrinsics.checkNotNullParameter(reject, "reject");
        LoggerContext loggerContext2 = new LoggerContext();
        loggerContext2.pushStage(RLLoggerConstant.RESOURCE_SESSION, config.getResourceLoaderSession());
        HybridLogger.INSTANCE.m11i("XResourceLoader", "start to async load from assets", MapsKt.mapOf(TuplesKt.to("url", input.getSrcUri().toString())), loggerContext2);
        r1.setInterval(new TimeInterval());
        if (!config.getUseAssetsLoader()) {
            input.setBuldinFailedMessage("buildIn disable");
            HybridLogger.INSTANCE.m11i("XResourceLoader", "AssetsLoader buildIn disable", MapsKt.mapOf(new Pair[]{TuplesKt.to("url", input.getSrcUri().toString()), TuplesKt.to("config", config.toString())}), loggerContext2);
            reject.invoke(new Throwable("buildIn disable"));
            return;
        }
        if (config.getChannel().length() == 0) {
            RLChannelBundleModel model = input.getModel();
            channel = model != null ? model.provideChannel() : null;
            if (channel == null) {
                channel = "";
            }
        } else {
            channel = config.getChannel();
        }
        if (config.getBundle().length() == 0) {
            RLChannelBundleModel model2 = input.getModel();
            bundle = model2 != null ? model2.providerBundlePath() : null;
            if (bundle == null) {
                str = "";
                if (!(channel.length() != 0)) {
                    input.setBuldinFailedMessage("buildIn Channel/Bundle invalid");
                    JSONObject metrics2 = input.getPerformanceInfo().getMetrics();
                    if (metrics2 != null) {
                        metrics2.put(RLMonitorReporter.BUILDIN_TOTAL, getInterval().getTotalTime());
                    }
                    HybridLogger.INSTANCE.m11i("XResourceLoader", "AssetsLoader async load buildIn Channel/Bundle invalid", MapsKt.mapOf(new Pair[]{TuplesKt.to("url", input.getSrcUri().toString()), TuplesKt.to("channel", channel), TuplesKt.to(SchemaConstants.QUERY_KEY_BUNDLE, str)}), loggerContext2);
                    reject.invoke(new Exception("buildIn Channel/Bundle invalid"));
                    return;
                }
                try {
                    ResourceMetaData loadAssetStream = r1.loadAssetStream(ResourceUriHelperKt.makeAssetRelativeUri$default(LoaderUtil.INSTANCE.buildRawUri(channel, str), null, 2, null));
                    JSONObject metrics3 = input.getPerformanceInfo().getMetrics();
                    if (metrics3 != null) {
                        obj = "url";
                        try {
                            metrics3.put(RLMonitorReporter.BUILDIN_FIND, getInterval().getTimeInterval());
                        } catch (Exception e) {
                            e = e;
                            r7 = loggerContext2;
                            r1 = obj;
                            metrics = input.getPerformanceInfo().getMetrics();
                            if (metrics != null) {
                            }
                            input.setBuldinFailedMessage("buildIn " + e.getMessage());
                            HybridLogger.INSTANCE.m9e("XResourceLoader", "fetch builtin failed", MapsKt.mapOf(new Pair[]{TuplesKt.to("taskConfig", taskConfig), TuplesKt.to((Object) r1, input.getSrcUri().toString()), TuplesKt.to("error", e.getMessage())}), r7);
                            reject.invoke(e);
                            return;
                        }
                    } else {
                        obj = "url";
                    }
                    StreamMetaInfo asStreamMeta = loadAssetStream.asStreamMeta();
                    r7 = "status";
                    try {
                        if ((asStreamMeta != null ? asStreamMeta.getStream() : null) == null) {
                            try {
                                String uri = input.getSrcUri().toString();
                                Intrinsics.checkNotNullExpressionValue(uri, "input.srcUri.toString()");
                                ResourceMetaData interceptAssetRequest = r1.interceptAssetRequest(uri, config.getBid());
                                JSONObject metrics4 = input.getPerformanceInfo().getMetrics();
                                if (metrics4 != null) {
                                    str2 = "status";
                                    try {
                                        loggerContext = loggerContext2;
                                        str3 = "streamMeta?.streamPathUri?.path ?: \"\"";
                                        try {
                                            metrics4.put(RLMonitorReporter.BUILDIN_MATCH, getInterval().getTimeInterval());
                                        } catch (Exception e2) {
                                            e = e2;
                                            taskConfig = config;
                                            r1 = obj;
                                            r7 = loggerContext;
                                        }
                                    } catch (Exception e3) {
                                        e = e3;
                                        taskConfig = config;
                                        r7 = loggerContext2;
                                        r1 = obj;
                                        metrics = input.getPerformanceInfo().getMetrics();
                                        if (metrics != null) {
                                        }
                                        input.setBuldinFailedMessage("buildIn " + e.getMessage());
                                        HybridLogger.INSTANCE.m9e("XResourceLoader", "fetch builtin failed", MapsKt.mapOf(new Pair[]{TuplesKt.to("taskConfig", taskConfig), TuplesKt.to((Object) r1, input.getSrcUri().toString()), TuplesKt.to("error", e.getMessage())}), r7);
                                        reject.invoke(e);
                                        return;
                                    }
                                } else {
                                    str2 = "status";
                                    loggerContext = loggerContext2;
                                    str3 = "streamMeta?.streamPathUri?.path ?: \"\"";
                                }
                                try {
                                    StreamMetaInfo asStreamMeta2 = interceptAssetRequest.asStreamMeta();
                                    if ((asStreamMeta2 != null ? asStreamMeta2.getStream() : null) == null) {
                                        input.setBuldinFailedMessage("buildIn File Not Found");
                                        JSONObject metrics5 = input.getPerformanceInfo().getMetrics();
                                        if (metrics5 != null) {
                                            metrics5.put(RLMonitorReporter.BUILDIN_TOTAL, getInterval().getTotalTime());
                                        }
                                        HybridLogger hybridLogger = HybridLogger.INSTANCE;
                                        Pair[] pairArr = new Pair[3];
                                        Object obj2 = obj;
                                        try {
                                            pairArr[0] = TuplesKt.to(obj2, uri);
                                            pairArr[1] = TuplesKt.to("taskConfig", config.toString());
                                            pairArr[2] = TuplesKt.to(ISignalReportConstants.KEY_REASON, "buildIn File Not Found");
                                            hybridLogger.m11i("XResourceLoader", "buildIn File Not Found", MapsKt.mapOf(pairArr), loggerContext);
                                            reject.invoke(new FileNotFoundException("buildIn File Not Found"));
                                            return;
                                        } catch (Exception e4) {
                                            e = e4;
                                            r1 = obj2;
                                            r7 = loggerContext;
                                            taskConfig = config;
                                            metrics = input.getPerformanceInfo().getMetrics();
                                            if (metrics != null) {
                                            }
                                            input.setBuldinFailedMessage("buildIn " + e.getMessage());
                                            HybridLogger.INSTANCE.m9e("XResourceLoader", "fetch builtin failed", MapsKt.mapOf(new Pair[]{TuplesKt.to("taskConfig", taskConfig), TuplesKt.to((Object) r1, input.getSrcUri().toString()), TuplesKt.to("error", e.getMessage())}), r7);
                                            reject.invoke(e);
                                            return;
                                        }
                                    }
                                    Object obj3 = obj;
                                    LoggerContext loggerContext3 = loggerContext;
                                    StreamMetaInfo asStreamMeta3 = interceptAssetRequest.asStreamMeta();
                                    if (asStreamMeta3 == null || (streamPathUri = asStreamMeta3.getStreamPathUri()) == null || (str4 = streamPathUri.getPath()) == null) {
                                        str4 = "";
                                    }
                                    Intrinsics.checkNotNullExpressionValue(str4, str3);
                                    if (LoaderUtil.INSTANCE.isNotNullOrEmpty(str4)) {
                                        int length = str4.length();
                                        if (str4 == null) {
                                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                        }
                                        String substring = str4.substring(1, length);
                                        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                        str5 = substring;
                                    } else {
                                        str5 = "";
                                    }
                                    input.setFilePath(str5);
                                    input.setFileStream(asStreamMeta3 != null ? asStreamMeta3.getStream() : null);
                                    input.setType(ResourceType.ASSET);
                                    input.setFrom(ResourceFrom.BUILTIN);
                                    input.setCache(true);
                                    JSONArray pipelineStatus = input.getPipelineStatus();
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("name", "BUILDIN");
                                    jSONObject.put(str2, "success");
                                    pipelineStatus.put(jSONObject);
                                    JSONObject metrics6 = input.getPerformanceInfo().getMetrics();
                                    if (metrics6 != null) {
                                        metrics6.put(RLMonitorReporter.BUILDIN_TOTAL, getInterval().getTotalTime());
                                    }
                                    HybridLogger.INSTANCE.m11i("XResourceLoader", "fetch builtin successfully", MapsKt.mapOf(new Pair[]{TuplesKt.to("taskConfig", config.toString()), TuplesKt.to(obj3, input.getSrcUri().toString())}), loggerContext3);
                                    resolve.invoke(input);
                                    return;
                                } catch (Exception e5) {
                                    e = e5;
                                    r1 = obj;
                                }
                            } catch (Exception e6) {
                                e = e6;
                                r7 = loggerContext2;
                                r1 = obj;
                            }
                        } else {
                            r1 = obj;
                            r7 = loggerContext2;
                            StreamMetaInfo asStreamMeta4 = loadAssetStream.asStreamMeta();
                            JSONArray pipelineStatus2 = input.getPipelineStatus();
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("name", "BUILDIN");
                            jSONObject2.put("status", "success");
                            pipelineStatus2.put(jSONObject2);
                            if (asStreamMeta4 == null || (streamPathUri2 = asStreamMeta4.getStreamPathUri()) == null || (str6 = streamPathUri2.getPath()) == null) {
                                str6 = "";
                            }
                            Intrinsics.checkNotNullExpressionValue(str6, "streamMeta?.streamPathUri?.path ?: \"\"");
                            if (LoaderUtil.INSTANCE.isNotNullOrEmpty(str6)) {
                                int length2 = str6.length();
                                if (str6 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                }
                                str7 = str6.substring(1, length2);
                                Intrinsics.checkNotNullExpressionValue(str7, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                            } else {
                                str7 = "";
                            }
                            input.setFilePath(str7);
                            input.setFileStream(asStreamMeta4 != null ? asStreamMeta4.getStream() : null);
                            input.setType(ResourceType.ASSET);
                            input.setFrom(ResourceFrom.BUILTIN);
                            input.setCache(true);
                            JSONObject metrics7 = input.getPerformanceInfo().getMetrics();
                            if (metrics7 != null) {
                                metrics7.put(RLMonitorReporter.BUILDIN_TOTAL, getInterval().getTotalTime());
                            }
                            ?? r0 = HybridLogger.INSTANCE;
                            Pair[] pairArr2 = new Pair[2];
                            taskConfig = config;
                            try {
                                pairArr2[0] = TuplesKt.to("taskConfig", taskConfig);
                                pairArr2[1] = TuplesKt.to((Object) r1, input.getSrcUri().toString());
                                r0.m11i("XResourceLoader", "fetch builtin successfully", MapsKt.mapOf(pairArr2), r7);
                                resolve.invoke(input);
                                return;
                            } catch (Exception e7) {
                                e = e7;
                            }
                        }
                    } catch (Exception e8) {
                        e = e8;
                    }
                } catch (Exception e9) {
                    e = e9;
                    r7 = loggerContext2;
                    r1 = "url";
                }
                metrics = input.getPerformanceInfo().getMetrics();
                if (metrics != null) {
                    metrics.put(RLMonitorReporter.BUILDIN_TOTAL, getInterval().getTotalTime());
                }
                input.setBuldinFailedMessage("buildIn " + e.getMessage());
                HybridLogger.INSTANCE.m9e("XResourceLoader", "fetch builtin failed", MapsKt.mapOf(new Pair[]{TuplesKt.to("taskConfig", taskConfig), TuplesKt.to((Object) r1, input.getSrcUri().toString()), TuplesKt.to("error", e.getMessage())}), r7);
                reject.invoke(e);
                return;
            }
        } else {
            bundle = config.getBundle();
        }
        str = bundle;
        if (!(channel.length() != 0)) {
        }
    }

    private final ResourceMetaData interceptAssetRequest(String url, String bid) {
        Object obj;
        String substring;
        RLLogger.INSTANCE.m21d("interceptAssetRequest# url=" + url);
        ResourceLoaderConfig resourceConfig = ResourceLoader.with$default(ResourceLoader.INSTANCE, bid, null, 2, null).getResourceConfig();
        if (resourceConfig.getPrefix().isEmpty()) {
            Uri parse = Uri.parse(url);
            Intrinsics.checkNotNullExpressionValue(parse, "parse(url)");
            return new ResourceMetaData(parse);
        }
        ArrayList arrayList = new ArrayList();
        List<String> prefix = resourceConfig.getPrefix();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(prefix, 10));
        for (String str : prefix) {
            if (LoaderUtil.INSTANCE.isNotNullOrEmpty(str)) {
                Pattern compile = Pattern.compile(str);
                Intrinsics.checkNotNullExpressionValue(compile, "compile(it)");
                arrayList.add(compile);
            }
            arrayList2.add(Unit.INSTANCE);
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Pattern pattern = (Pattern) arrayList.get(i);
            try {
                Result.Companion companion = Result.Companion;
                AssetsLoader assetsLoader = this;
                obj = Result.constructor-impl(pattern.matcher(url));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (Result.isFailure-impl(obj)) {
                obj = null;
            }
            Matcher matcher = (Matcher) obj;
            if (matcher != null && matcher.find()) {
                String str2 = url;
                int indexOf$default = StringsKt.indexOf$default(str2, "?", 0, false, 6, (Object) null);
                int indexOf$default2 = StringsKt.indexOf$default(str2, "#", 0, false, 6, (Object) null);
                int coerceAtMost = RangesKt.coerceAtMost(indexOf$default, indexOf$default2);
                if (coerceAtMost == -1) {
                    coerceAtMost = RangesKt.coerceAtLeast(indexOf$default, indexOf$default2);
                }
                if (coerceAtMost != -1) {
                    int end = matcher.end();
                    if (url == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    substring = url.substring(end, coerceAtMost);
                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                } else {
                    int end2 = matcher.end();
                    if (url == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    substring = url.substring(end2);
                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
                }
                if (StringsKt.endsWith$default(substring, "/", false, 2, (Object) null)) {
                    int length = substring.length() - 1;
                    if (substring == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    substring = substring.substring(0, length);
                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                }
                if (!TextUtils.isEmpty(substring)) {
                    return loadAssetStream(ResourceUriHelperKt.makeAssetRelativeUri$default(substring, null, 2, null));
                }
            }
        }
        Uri parse2 = Uri.parse(url);
        Intrinsics.checkNotNullExpressionValue(parse2, "parse(url)");
        return new ResourceMetaData(parse2);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:7|(7:9|(2:11|(1:15))(2:25|(4:27|(1:39)(1:31)|32|(1:34)(2:35|(1:37)(1:38))))|16|17|18|19|20)|40|16|17|18|19|20) */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a4, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00a5, code lost:
    
        com.bytedance.ies.bullet.kit.resourceloader.loggger.RLLogger.INSTANCE.m21d("AsssetsLoader onException: " + r3.getMessage());
        r3 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final ResourceMetaData loadAssetStream(Uri uri) {
        String str;
        String scheme = uri.getScheme();
        if (scheme != null && scheme.hashCode() == -1408207997 && scheme.equals(ResourceUriHelperKt.SCHEME_ASSETS)) {
            String authority = uri.getAuthority();
            if (authority != null) {
                int hashCode = authority.hashCode();
                if (hashCode != -554435892) {
                    if (hashCode == 1728122231 && authority.equals("absolute")) {
                        str = String.valueOf(uri.getPath());
                    }
                } else if (authority.equals(ResourceUriHelperKt.AUTHORITY_RELATIVE)) {
                    String path = uri.getPath();
                    String str2 = path;
                    if (str2 == null || StringsKt.isBlank(str2)) {
                        str = ResourceInfo.RESOURCE_FROM_OFFLINE;
                    } else {
                        Intrinsics.checkNotNullExpressionValue(path, "it");
                        if (StringsKt.startsWith$default(path, "/", false, 2, (Object) null)) {
                            str = ResourceInfo.RESOURCE_FROM_OFFLINE + path;
                        } else {
                            str = "offline/" + path;
                        }
                    }
                }
                Application application = ResourceLoader.INSTANCE.getApplication();
                Intrinsics.checkNotNull(application);
                InputStream inputStream = application.getAssets().open(str);
                ResourceMetaData resourceMetaData = new ResourceMetaData(uri);
                resourceMetaData.setMetaInfo(new StreamMetaInfo(inputStream, ResourceFrom.BUILTIN, ResourceUriHelperKt.makeAssetAbsoluteUri$default(str, null, 2, null)));
                return resourceMetaData;
            }
            str = "";
            Application application2 = ResourceLoader.INSTANCE.getApplication();
            Intrinsics.checkNotNull(application2);
            InputStream inputStream2 = application2.getAssets().open(str);
            ResourceMetaData resourceMetaData2 = new ResourceMetaData(uri);
            resourceMetaData2.setMetaInfo(new StreamMetaInfo(inputStream2, ResourceFrom.BUILTIN, ResourceUriHelperKt.makeAssetAbsoluteUri$default(str, null, 2, null)));
            return resourceMetaData2;
        }
        RLLogger.INSTANCE.m21d("AsssetsLoader onException: error scheme");
        throw new IllegalArgumentException("error scheme");
    }

    public String toString() {
        return "AssetsLoader@" + this;
    }
}
