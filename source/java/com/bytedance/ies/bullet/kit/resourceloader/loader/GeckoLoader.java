package com.bytedance.ies.bullet.kit.resourceloader.loader;

import android.net.Uri;
import bolts.Task;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.kit.resourceloader.FileMetaInfo;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoader;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceMetaData;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceUriHelperKt;
import com.bytedance.ies.bullet.kit.resourceloader.TimeInterval;
import com.bytedance.ies.bullet.kit.resourceloader.loggger.RLLogger;
import com.bytedance.ies.bullet.kit.resourceloader.loggger.RLLoggerConstant;
import com.bytedance.ies.bullet.kit.resourceloader.monitor.RLMonitorReporter;
import com.bytedance.ies.bullet.secure.GeckoLoaderSecureManager;
import com.bytedance.ies.bullet.service.base.ResourceFrom;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.ies.bullet.service.base.ResourceType;
import com.bytedance.ies.bullet.service.base.resourceloader.config.GeckoConfig;
import com.bytedance.ies.bullet.service.base.resourceloader.config.IXResourceLoader;
import com.bytedance.ies.bullet.service.base.resourceloader.config.OnUpdateListener;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.push.event.sync.ISignalReportConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
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
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: GeckoLoader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J \u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002JR\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\b0\u00182\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\b0\u0018H\u0002J\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0002J\"\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u0004H\u0002J \u0010!\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0002J@\u0010#\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\b0\u00182\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\b0\u0018H\u0016J\u001a\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\rH\u0002J\u001a\u0010&\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\rH\u0016J \u0010'\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\r2\u0006\u0010(\u001a\u00020\u000fH\u0002J\b\u0010)\u001a\u00020\u0004H\u0016J&\u0010*\u001a\u00020\u0012*\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\r2\b\u0010+\u001a\u0004\u0018\u00010%H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006-"}, d2 = {"Lcom/bytedance/ies/bullet/kit/resourceloader/loader/GeckoLoader;", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/IXResourceLoader;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "cancelLoad", "", "checkUpdate", "uri", "Landroid/net/Uri;", "config", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/TaskConfig;", "updateListener", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/OnUpdateListener;", "dealResult", "isCache", "", "input", "Lcom/bytedance/ies/bullet/service/base/ResourceInfo;", "throwable", "", "resolve", "Lkotlin/Function1;", "reject", "geckoLoadOfflineFile", "Ljava/io/File;", "relativePath", "getSdkVersion", "innerLoadFromGeckoFile", "Lcom/bytedance/ies/bullet/kit/resourceloader/ResourceMetaData;", "channel", "isPathTraversal", SchemaConstants.QUERY_KEY_BUNDLE, "loadAsync", "loadGeckoFile", "Lcom/bytedance/ies/bullet/kit/resourceloader/FileMetaInfo;", CDNLoader.STEP_NAME_SYNC, "pullGeckoPackSync", "listener", "toString", "mapFileMata2ResourceInfo", "fileMeta", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class GeckoLoader extends IXResourceLoader {
    private static final String KEY_DYNAMIC = "dynamic";
    private final String TAG = "GECKO";

    @Override // com.bytedance.ies.bullet.service.base.resourceloader.config.IXResourceLoader
    public void cancelLoad() {
    }

    @Override // com.bytedance.ies.bullet.service.base.resourceloader.config.IXResourceLoader
    public String getTAG() {
        return this.TAG;
    }

    @Override // com.bytedance.ies.bullet.service.base.resourceloader.config.IXResourceLoader
    public ResourceInfo loadSync(ResourceInfo input, TaskConfig config) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(config, "config");
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        loadAsync(input, config, new Function1<ResourceInfo, Unit>() { // from class: com.bytedance.ies.bullet.kit.resourceloader.loader.GeckoLoader$loadSync$1
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
                countDownLatch.countDown();
            }
        }, new Function1<Throwable, Unit>() { // from class: com.bytedance.ies.bullet.kit.resourceloader.loader.GeckoLoader$loadSync$2
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
                booleanRef.element = false;
                countDownLatch.countDown();
            }
        });
        countDownLatch.await(config.getLoadTimeOut(), TimeUnit.MILLISECONDS);
        HybridLogger hybridLogger = HybridLogger.INSTANCE;
        Map<String, ? extends Object> mapOf = MapsKt.mapOf(new Pair[]{TuplesKt.to("url", input.getSrcUri().toString()), TuplesKt.to("loadSuccess", Boolean.valueOf(booleanRef.element))});
        LoggerContext loggerContext = new LoggerContext();
        loggerContext.pushStage(RLLoggerConstant.RESOURCE_SESSION, config.getResourceLoaderSession());
        Unit unit = Unit.INSTANCE;
        hybridLogger.m11i("XResourceLoader", "GeckoLoader sync load", mapOf, loggerContext);
        return (ResourceInfo) objectRef.element;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v28, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v36 */
    @Override // com.bytedance.ies.bullet.service.base.resourceloader.config.IXResourceLoader
    public void loadAsync(final ResourceInfo input, final TaskConfig config, final Function1<? super ResourceInfo, Unit> resolve, final Function1<? super Throwable, Unit> reject) {
        Object obj;
        GeckoLoader geckoLoader;
        ?? r1;
        GeckoLoader geckoLoader2 = this;
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(resolve, "resolve");
        Intrinsics.checkNotNullParameter(reject, "reject");
        geckoLoader2.setInterval(new TimeInterval());
        final LoggerContext loggerContext = new LoggerContext();
        loggerContext.pushStage(RLLoggerConstant.RESOURCE_SESSION, config.getResourceLoaderSession());
        HybridLogger.INSTANCE.m11i("XResourceLoader", "GeckoLoader start to async load from gecko", MapsKt.mapOf(new Pair[]{TuplesKt.to("channel", config.getChannel()), TuplesKt.to(SchemaConstants.QUERY_KEY_BUNDLE, config.getBundle()), TuplesKt.to("ak", config.getAccessKey()), TuplesKt.to("url", input.getSrcUri().toString())}), loggerContext);
        input.setGeckoFailMessage("");
        if (!config.getUseGeckoLoader()) {
            input.setGeckoFailMessage("gecko disable");
            JSONArray pipelineStatus = input.getPipelineStatus();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", getTAG());
            jSONObject.put("status", CDNLoader.PIPELINE_STATUS_FAILED);
            jSONObject.put("detail", input.getGeckoFailMessage());
            pipelineStatus.put(jSONObject);
            JSONObject metrics = input.getPerformanceInfo().getMetrics();
            if (metrics != null) {
                metrics.put(RLMonitorReporter.GECKO_TOTAL, getInterval().getTotalTime());
            }
            HybridLogger.INSTANCE.m11i("XResourceLoader", "GeckoLoader async load gecko disable", MapsKt.mapOf(new Pair[]{TuplesKt.to("url", input.getSrcUri().toString()), TuplesKt.to("useGeckoLoader", Boolean.valueOf(config.getUseGeckoLoader()))}), loggerContext);
            reject.invoke(new Throwable("gecko disable"));
            return;
        }
        ResourceFrom resourceFrom = null;
        if (config.getChannel().length() == 0) {
            ResourceMetaData innerLoadFromGeckoFile = geckoLoader2.innerLoadFromGeckoFile(input.getSrcUri(), config, config.getChannel());
            FileMetaInfo asFileMeta = innerLoadFromGeckoFile != null ? innerLoadFromGeckoFile.asFileMeta() : null;
            if (asFileMeta != null && asFileMeta.getFile().exists()) {
                input.setFilePath(asFileMeta.getFile().getAbsolutePath());
                input.setType(ResourceType.DISK);
                input.setCache(true);
                String authority = input.getSrcUri().getAuthority();
                if (authority != null) {
                    int hashCode = authority.hashCode();
                    if (hashCode != -554435892) {
                        if (hashCode == 1728122231 && authority.equals("absolute")) {
                            resourceFrom = ResourceFrom.LOCAL_FILE;
                        }
                    } else if (authority.equals(ResourceUriHelperKt.AUTHORITY_RELATIVE)) {
                        resourceFrom = ResourceFrom.GECKO;
                    }
                }
                input.setFrom(resourceFrom);
                JSONArray pipelineStatus2 = input.getPipelineStatus();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("name", getTAG());
                jSONObject2.put("status", "success");
                pipelineStatus2.put(jSONObject2);
                Long channelVersion = asFileMeta.getChannelVersion();
                input.setVersion(channelVersion != null ? channelVersion.longValue() : 0L);
                input.setSdkVersion(geckoLoader2.getSdkVersion(config));
                HybridLogger.INSTANCE.m11i("XResourceLoader", "GeckoLoader async load url success", MapsKt.mapOf(new Pair[]{TuplesKt.to("url", input.getSrcUri().toString()), TuplesKt.to("resourceInfo", input.toString())}), loggerContext);
                JSONObject metrics2 = input.getPerformanceInfo().getMetrics();
                if (metrics2 != null) {
                    metrics2.put(RLMonitorReporter.GECKO_TOTAL, getInterval().getTotalTime());
                }
                resolve.invoke(input);
                return;
            }
            input.setGeckoFailMessage("GFM:Channel/Bundle invalid");
            JSONArray pipelineStatus3 = input.getPipelineStatus();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("name", getTAG());
            jSONObject3.put("status", CDNLoader.PIPELINE_STATUS_FAILED);
            jSONObject3.put("detail", input.getGeckoFailMessage());
            pipelineStatus3.put(jSONObject3);
            JSONObject metrics3 = input.getPerformanceInfo().getMetrics();
            if (metrics3 != null) {
                metrics3.put(RLMonitorReporter.GECKO_TOTAL, getInterval().getTotalTime());
            }
            HybridLogger.INSTANCE.m11i("XResourceLoader", "GeckoLoader async load url failed,channel is empty for gecko", MapsKt.mapOf(TuplesKt.to("url", input.getSrcUri().toString())), loggerContext);
            reject.invoke(new IllegalArgumentException("channel is empty for gecko"));
            return;
        }
        String accessKey = config.getAccessKey();
        if (config.getAccessKey().length() == 0) {
            HybridLogger.INSTANCE.m11i("XResourceLoader", "GeckoLoader config accessKey not found, using default", MapsKt.mapOf(TuplesKt.to("url", input.getSrcUri().toString())), loggerContext);
        }
        GeckoConfig geckoConfig = ResourceLoader.with$default(ResourceLoader.INSTANCE, config.getBid(), null, 2, null).getResourceConfig().getGeckoConfig(accessKey);
        if (accessKey.length() == 0) {
            accessKey = geckoConfig.getAccessKey();
        }
        String str = accessKey;
        Uri srcUri = input.getSrcUri();
        try {
            Result.Companion companion = Result.Companion;
            String queryParameter = srcUri.getQueryParameter(KEY_DYNAMIC);
            obj = Result.constructor-impl(queryParameter != null ? Integer.valueOf(Integer.parseInt(queryParameter)) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        Integer num = (Integer) obj;
        Integer dynamic = config.getDynamic();
        int intValue = dynamic != null ? dynamic.intValue() : num != null ? num.intValue() : 0;
        HybridLogger.INSTANCE.m11i("XResourceLoader", "GeckoLoader load detail", MapsKt.mapOf(new Pair[]{TuplesKt.to("url", input.getSrcUri().toString()), TuplesKt.to("accessKey", str), TuplesKt.to("channel", config.getChannel()), TuplesKt.to(SchemaConstants.QUERY_KEY_BUNDLE, config.getBundle()), TuplesKt.to(KEY_DYNAMIC, Integer.valueOf(intValue)), TuplesKt.to("config", config.toString())}), loggerContext);
        OnUpdateListener onUpdateListener = new OnUpdateListener() { // from class: com.bytedance.ies.bullet.kit.resourceloader.loader.GeckoLoader$loadAsync$listener$1
            @Override // com.bytedance.ies.bullet.service.base.resourceloader.config.OnUpdateListener
            public void onUpdateSuccess(List<String> channelList, String path) {
                Intrinsics.checkNotNullParameter(channelList, "channelList");
                JSONObject metrics4 = ResourceInfo.this.getPerformanceInfo().getMetrics();
                if (metrics4 != null) {
                    metrics4.put(RLMonitorReporter.GECKO_UPDATE, this.getInterval().getTimeInterval());
                }
                HybridLogger.INSTANCE.m11i("XResourceLoader", "finish gecko update", MapsKt.mapOf(TuplesKt.to("taskConfig", config.toString())), loggerContext);
                if (config.getOnlyLocal()) {
                    HybridLogger.INSTANCE.m11i("XResourceLoader", "finish gecko update success, skip callbacks when onlyLocal is true", MapsKt.mapOf(new Pair[]{TuplesKt.to("taskConfig", config.toString()), TuplesKt.to("url", ResourceInfo.this.getSrcUri().toString())}), loggerContext);
                    return;
                }
                HybridLogger.INSTANCE.m11i("XResourceLoader", "pull gecko resource Successfully,start deal result", MapsKt.mapOf(new Pair[]{TuplesKt.to("taskConfig", config.toString()), TuplesKt.to("url", ResourceInfo.this.getSrcUri().toString())}), loggerContext);
                final GeckoLoader geckoLoader3 = this;
                final ResourceInfo resourceInfo = ResourceInfo.this;
                final TaskConfig taskConfig = config;
                final Function1<ResourceInfo, Unit> function1 = resolve;
                final Function1<Throwable, Unit> function12 = reject;
                Task.call(new Callable() { // from class: com.bytedance.ies.bullet.kit.resourceloader.loader.GeckoLoader$loadAsync$listener$1$onUpdateSuccess$1
                    @Override // java.util.concurrent.Callable
                    public /* bridge */ /* synthetic */ Object call() {
                        call();
                        return Unit.INSTANCE;
                    }

                    @Override // java.util.concurrent.Callable
                    public final void call() {
                        GeckoLoader.this.dealResult(false, resourceInfo, taskConfig, null, function1, function12);
                    }
                }, Task.UI_THREAD_EXECUTOR);
            }

            @Override // com.bytedance.ies.bullet.service.base.resourceloader.config.OnUpdateListener
            public void onUpdateFailed(List<String> channelList, final Throwable throwable) {
                Intrinsics.checkNotNullParameter(channelList, "channelList");
                JSONObject metrics4 = ResourceInfo.this.getPerformanceInfo().getMetrics();
                if (metrics4 != null) {
                    metrics4.put(RLMonitorReporter.GECKO_UPDATE, this.getInterval().getTimeInterval());
                }
                HybridLogger hybridLogger = HybridLogger.INSTANCE;
                Pair[] pairArr = new Pair[3];
                pairArr[0] = TuplesKt.to("taskConfig", config.toString());
                pairArr[1] = TuplesKt.to("url", ResourceInfo.this.getSrcUri().toString());
                pairArr[2] = TuplesKt.to("message", throwable != null ? throwable.getMessage() : null);
                hybridLogger.m11i("XResourceLoader", "GeckoLoader check update failed", MapsKt.mapOf(pairArr), loggerContext);
                ResourceInfo.this.setGeckoFailMessage("gecko CheckUpdate Failed");
                if (config.getOnlyLocal()) {
                    HybridLogger.INSTANCE.m11i("XResourceLoader", "finish gecko update failed, skip callbacks when onlyLocal is true", MapsKt.mapOf(new Pair[]{TuplesKt.to("taskConfig", config.toString()), TuplesKt.to("url", ResourceInfo.this.getSrcUri().toString())}), loggerContext);
                    return;
                }
                HybridLogger.INSTANCE.m11i("XResourceLoader", "pull gecko resource failed,try to read it, if it failed will go through the failure process", MapsKt.mapOf(new Pair[]{TuplesKt.to("taskConfig", config.toString()), TuplesKt.to("url", ResourceInfo.this.getSrcUri().toString())}), loggerContext);
                final GeckoLoader geckoLoader3 = this;
                final ResourceInfo resourceInfo = ResourceInfo.this;
                final TaskConfig taskConfig = config;
                final Function1<ResourceInfo, Unit> function1 = resolve;
                final Function1<Throwable, Unit> function12 = reject;
                Task.call(new Callable() { // from class: com.bytedance.ies.bullet.kit.resourceloader.loader.GeckoLoader$loadAsync$listener$1$onUpdateFailed$1
                    @Override // java.util.concurrent.Callable
                    public /* bridge */ /* synthetic */ Object call() {
                        call();
                        return Unit.INSTANCE;
                    }

                    @Override // java.util.concurrent.Callable
                    public final void call() {
                        GeckoLoader.this.dealResult(false, resourceInfo, taskConfig, throwable, function1, function12);
                    }
                }, Task.UI_THREAD_EXECUTOR);
            }
        };
        if (intValue == 0) {
            if (geckoLoader2.mapFileMata2ResourceInfo(input, true, config, loadGeckoFile(input, config))) {
                JSONObject metrics4 = input.getPerformanceInfo().getMetrics();
                if (metrics4 != null) {
                    metrics4.put(RLMonitorReporter.GECKO_TOTAL, getInterval().getTotalTime());
                }
                HybridLogger.INSTANCE.m11i("XResourceLoader", "GeckoLoader async load uri no update load success", MapsKt.mapOf(new Pair[]{TuplesKt.to("url", input.getSrcUri().toString()), TuplesKt.to(KEY_DYNAMIC, String.valueOf(intValue))}), loggerContext);
                resolve.invoke(input);
                return;
            }
            JSONObject metrics5 = input.getPerformanceInfo().getMetrics();
            if (metrics5 != null) {
                metrics5.put(RLMonitorReporter.GECKO_TOTAL, getInterval().getTotalTime());
            }
            HybridLogger.INSTANCE.m11i("XResourceLoader", "GeckoLoader async load uri no update load failed", MapsKt.mapOf(new Pair[]{TuplesKt.to("url", input.getSrcUri().toString()), TuplesKt.to(KEY_DYNAMIC, String.valueOf(intValue))}), loggerContext);
            reject.invoke(new Throwable("Gecko File not found"));
            return;
        }
        if (intValue != 1) {
            if (intValue == 2) {
                input.setCache(false);
                if (config.getOnlyLocal()) {
                    JSONObject metrics6 = input.getPerformanceInfo().getMetrics();
                    if (metrics6 != null) {
                        metrics6.put(RLMonitorReporter.GECKO_TOTAL, getInterval().getTotalTime());
                    }
                    HybridLogger.INSTANCE.m11i("XResourceLoader", "GeckoLoader pull sync,but onlyLocal", MapsKt.mapOf(new Pair[]{TuplesKt.to("url", input.getSrcUri().toString()), TuplesKt.to(KEY_DYNAMIC, String.valueOf(intValue)), TuplesKt.to("onlyLocal", Boolean.valueOf(config.getOnlyLocal()))}), loggerContext);
                    reject.invoke(new Throwable("GeckoLoader pull sync but onlyLocal，reject"));
                }
                geckoLoader2 = this;
                geckoLoader2.pullGeckoPackSync(input, config, onUpdateListener);
            } else if (intValue != 3) {
                if (geckoLoader2.mapFileMata2ResourceInfo(input, true, config, loadGeckoFile(input, config))) {
                    JSONObject metrics7 = input.getPerformanceInfo().getMetrics();
                    if (metrics7 != null) {
                        metrics7.put(RLMonitorReporter.GECKO_TOTAL, getInterval().getTotalTime());
                    }
                    HybridLogger.INSTANCE.m11i("XResourceLoader", "GeckoLoader async load uri gecko success", MapsKt.mapOf(new Pair[]{TuplesKt.to("url", input.getSrcUri().toString()), TuplesKt.to(KEY_DYNAMIC, String.valueOf(intValue))}), loggerContext);
                    resolve.invoke(input);
                } else {
                    JSONObject metrics8 = input.getPerformanceInfo().getMetrics();
                    if (metrics8 != null) {
                        metrics8.put(RLMonitorReporter.GECKO_TOTAL, getInterval().getTotalTime());
                    }
                    HybridLogger.INSTANCE.m11i("XResourceLoader", "GeckoLoader async load uri gecko file not found", MapsKt.mapOf(new Pair[]{TuplesKt.to("url", input.getSrcUri().toString()), TuplesKt.to(KEY_DYNAMIC, String.valueOf(intValue))}), loggerContext);
                    reject.invoke(new Throwable("Gecko File not found"));
                }
            }
            return;
        }
        boolean checkIsExists = geckoConfig.getLoaderDepender().checkIsExists(geckoConfig.getOfflineDir(), str, config.getChannel());
        Uri makeRelativeUri$default = ResourceUriHelperKt.makeRelativeUri$default(config.getChannel(), null, 2, null);
        if (checkIsExists) {
            geckoLoader = this;
            r1 = 1;
        } else {
            if (intValue != 3) {
                input.setCache(false);
                if (config.getOnlyLocal()) {
                    HybridLogger.INSTANCE.m11i("XResourceLoader", "GeckoLoader pull sync,but onlyLocal", MapsKt.mapOf(new Pair[]{TuplesKt.to("url", input.getSrcUri().toString()), TuplesKt.to(KEY_DYNAMIC, String.valueOf(intValue)), TuplesKt.to("onlyLocal", Boolean.valueOf(config.getOnlyLocal()))}), loggerContext);
                    JSONObject metrics9 = input.getPerformanceInfo().getMetrics();
                    if (metrics9 != null) {
                        metrics9.put(RLMonitorReporter.GECKO_TOTAL, getInterval().getTotalTime());
                    }
                    reject.invoke(new Throwable("GeckoLoader pull sync but onlyLocal，reject"));
                }
                pullGeckoPackSync(input, config, onUpdateListener);
                return;
            }
            r1 = 1;
            geckoLoader = this;
        }
        input.setCache(r1);
        HybridLogger hybridLogger = HybridLogger.INSTANCE;
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to("url", input.getSrcUri().toString());
        pairArr[r1] = TuplesKt.to(KEY_DYNAMIC, String.valueOf(intValue));
        pairArr[2] = TuplesKt.to("isCache", Boolean.valueOf((boolean) r1));
        hybridLogger.m11i("XResourceLoader", "GeckoLoader load from cache", MapsKt.mapOf(pairArr), loggerContext);
        dealResult(checkIsExists, input, config, null, resolve, reject);
        geckoLoader.checkUpdate(makeRelativeUri$default, config, new OnUpdateListener() { // from class: com.bytedance.ies.bullet.kit.resourceloader.loader.GeckoLoader$loadAsync$4
            @Override // com.bytedance.ies.bullet.service.base.resourceloader.config.OnUpdateListener
            public void onUpdateFailed(List<String> channelList, Throwable throwable) {
                Intrinsics.checkNotNullParameter(channelList, "channelList");
            }

            @Override // com.bytedance.ies.bullet.service.base.resourceloader.config.OnUpdateListener
            public void onUpdateSuccess(List<String> channelList, String path) {
                Intrinsics.checkNotNullParameter(channelList, "channelList");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dealResult(boolean isCache, ResourceInfo input, TaskConfig config, Throwable throwable, Function1<? super ResourceInfo, Unit> resolve, Function1<? super Throwable, Unit> reject) {
        LoggerContext loggerContext = new LoggerContext();
        loggerContext.pushStage(RLLoggerConstant.RESOURCE_SESSION, config.getResourceLoaderSession());
        RLLogger.INSTANCE.m21d("GeckoLoader#dealResult: input=" + input + ",throwable=" + (throwable != null ? throwable.getMessage() : null));
        if (throwable != null) {
            JSONArray pipelineStatus = input.getPipelineStatus();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", getTAG());
            jSONObject.put("status", CDNLoader.PIPELINE_STATUS_FAILED);
            jSONObject.put("detail", throwable.getMessage());
            pipelineStatus.put(jSONObject);
            JSONObject metrics = input.getPerformanceInfo().getMetrics();
            if (metrics != null) {
                metrics.put(RLMonitorReporter.GECKO_TOTAL, getInterval().getTotalTime());
            }
            HybridLogger.INSTANCE.m11i("XResourceLoader", "fetch gecko failed", MapsKt.mapOf(new Pair[]{TuplesKt.to(ISignalReportConstants.KEY_REASON, throwable.getMessage()), TuplesKt.to("taskConfig", config.toString()), TuplesKt.to("url", input.getSrcUri().toString())}), loggerContext);
            reject.invoke(throwable);
            return;
        }
        boolean mapFileMata2ResourceInfo = mapFileMata2ResourceInfo(input, isCache, config, loadGeckoFile(input, config));
        JSONArray pipelineStatus2 = input.getPipelineStatus();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("name", getTAG());
        if (mapFileMata2ResourceInfo) {
            jSONObject2.put("status", "success");
        } else {
            jSONObject2.put("status", CDNLoader.PIPELINE_STATUS_FAILED);
            jSONObject2.put("detail", "Gecko File not found");
        }
        pipelineStatus2.put(jSONObject2);
        if (mapFileMata2ResourceInfo) {
            JSONObject metrics2 = input.getPerformanceInfo().getMetrics();
            if (metrics2 != null) {
                metrics2.put(RLMonitorReporter.GECKO_TOTAL, getInterval().getTotalTime());
            }
            HybridLogger.INSTANCE.m11i("XResourceLoader", "fetch gecko successfully", MapsKt.mapOf(new Pair[]{TuplesKt.to("taskConfig", config.toString()), TuplesKt.to("url", input.getSrcUri().toString()), TuplesKt.to("isCache", Boolean.valueOf(isCache))}), loggerContext);
            resolve.invoke(input);
            return;
        }
        JSONObject metrics3 = input.getPerformanceInfo().getMetrics();
        if (metrics3 != null) {
            metrics3.put(RLMonitorReporter.GECKO_TOTAL, getInterval().getTotalTime());
        }
        HybridLogger.INSTANCE.m11i("XResourceLoader", "fetch gecko failed", MapsKt.mapOf(new Pair[]{TuplesKt.to(ISignalReportConstants.KEY_REASON, "Gecko File not found"), TuplesKt.to("taskConfig", config.toString()), TuplesKt.to("url", input.getSrcUri().toString()), TuplesKt.to("isCache", Boolean.valueOf(isCache))}), loggerContext);
        reject.invoke(new Throwable("Gecko File not found"));
    }

    private final boolean mapFileMata2ResourceInfo(ResourceInfo resourceInfo, boolean z, TaskConfig taskConfig, FileMetaInfo fileMetaInfo) {
        if (fileMetaInfo == null) {
            return false;
        }
        resourceInfo.setCache(z);
        resourceInfo.setFilePath(fileMetaInfo.getFile().getAbsolutePath());
        resourceInfo.setType(ResourceType.DISK);
        resourceInfo.setFrom(ResourceFrom.GECKO);
        Long channelVersion = fileMetaInfo.getChannelVersion();
        resourceInfo.setVersion(channelVersion != null ? channelVersion.longValue() : 0L);
        JSONArray pipelineStatus = resourceInfo.getPipelineStatus();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", getTAG());
        jSONObject.put("status", "success");
        pipelineStatus.put(jSONObject);
        resourceInfo.setSdkVersion(getSdkVersion(taskConfig));
        resourceInfo.setChannel(taskConfig.getChannel());
        resourceInfo.setBundle(taskConfig.getBundle());
        resourceInfo.setAccessKey(taskConfig.getAccessKey());
        return true;
    }

    private final void pullGeckoPackSync(ResourceInfo input, TaskConfig config, OnUpdateListener listener) {
        if (config.getOnlyLocal()) {
            input.setGeckoFailMessage("gecko only local");
            JSONArray pipelineStatus = input.getPipelineStatus();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", getTAG());
            jSONObject.put("status", CDNLoader.PIPELINE_STATUS_FAILED);
            jSONObject.put("detail", input);
            pipelineStatus.put(jSONObject);
            HybridLogger hybridLogger = HybridLogger.INSTANCE;
            Map<String, ? extends Object> mapOf = MapsKt.mapOf(TuplesKt.to(ISignalReportConstants.KEY_REASON, "gecko only local"));
            LoggerContext loggerContext = new LoggerContext();
            loggerContext.pushStage(RLLoggerConstant.RESOURCE_SESSION, config.getResourceLoaderSession());
            Unit unit = Unit.INSTANCE;
            hybridLogger.m11i("XResourceLoader", "GeckoLoader pull Gecko package sync failed", mapOf, loggerContext);
            listener.onUpdateFailed(CollectionsKt.mutableListOf(new String[]{config.getChannel()}), new Exception("gecko only local"));
        }
        Uri makeRelativeUri$default = ResourceUriHelperKt.makeRelativeUri$default(config.getChannel(), null, 2, null);
        config.setUseInteraction(1);
        checkUpdate(makeRelativeUri$default, config, listener);
    }

    private final boolean isPathTraversal(String channel, String bundle, TaskConfig config) {
        int mode = GeckoLoaderSecureManager.INSTANCE.getInstance().getMode();
        if (mode == 0) {
            return false;
        }
        if (StringsKt.contains$default(channel, "../", false, 2, (Object) null) || StringsKt.contains$default(bundle, "../", false, 2, (Object) null)) {
            RLMonitorReporter.INSTANCE.reportGeckoLoaderSecure(ResourceLoader.with$default(ResourceLoader.INSTANCE, config.getBid(), null, 2, null).getResourceConfig(), config, channel, bundle, GeckoLoaderSecureManager.INSTANCE.getInstance().getMode());
            HybridLogger.e$default(HybridLogger.INSTANCE, "XResourceLoader", "security check failed: gecko loader path traversal, mode: " + mode + ", channel: " + channel + ", bundle: " + bundle, null, null, 12, null);
            if (mode == 2) {
                return true;
            }
        }
        return false;
    }

    private final FileMetaInfo loadGeckoFile(ResourceInfo input, TaskConfig config) {
        Object obj;
        TimeInterval timeInterval = new TimeInterval();
        String channel = config.getChannel();
        String bundle = config.getBundle();
        if (isPathTraversal(channel, bundle, config)) {
            input.setGeckoFailMessage("security check failed: gecko loader path traversal");
            input.setCache(false);
            return null;
        }
        ResourceMetaData innerLoadFromGeckoFile = innerLoadFromGeckoFile(ResourceUriHelperKt.makeRelativeUri$default(LoaderUtil.INSTANCE.buildRawUri(channel, bundle), null, 2, null), config, channel);
        FileMetaInfo asFileMeta = innerLoadFromGeckoFile != null ? innerLoadFromGeckoFile.asFileMeta() : null;
        RLLogger.INSTANCE.m21d("GeckoLoader async load uri: " + input.getSrcUri() + " gecko only local");
        JSONObject metrics = input.getPerformanceInfo().getMetrics();
        if (metrics != null) {
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.constructor-impl(Long.valueOf(metrics.getLong(RLMonitorReporter.GECKO_LOCAL)));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (Result.isFailure-impl(obj)) {
                obj = 0L;
            }
            metrics.put(RLMonitorReporter.GECKO_LOCAL, ((Number) obj).longValue() + timeInterval.getTimeInterval());
        }
        if (asFileMeta != null && asFileMeta.getFile().exists()) {
            try {
                Result.Companion companion3 = Result.Companion;
                GeckoLoader geckoLoader = this;
                if (Intrinsics.areEqual(config.getResTag(), "template")) {
                    FileInputStream fileInputStream = new FileInputStream(asFileMeta.getFile());
                    if (fileInputStream.available() == 0) {
                        input.setGeckoFailMessage("gecko size 0");
                        fileInputStream.close();
                        input.setCache(false);
                        return null;
                    }
                    fileInputStream.close();
                }
                Result.constructor-impl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.Companion;
                Result.constructor-impl(ResultKt.createFailure(th2));
            }
            return asFileMeta;
        }
        boolean z = true;
        if (config.getAccessKey().length() == 0) {
            String geckoFailMessage = input.getGeckoFailMessage();
            if (geckoFailMessage != null && geckoFailMessage.length() != 0) {
                z = false;
            }
            if (z) {
                input.setGeckoFailMessage("gecko accessKey invalid");
                input.setCache(false);
                return null;
            }
        }
        input.setGeckoFailMessage("gecko File Not Found");
        input.setCache(false);
        return null;
    }

    private final void checkUpdate(Uri uri, TaskConfig config, OnUpdateListener updateListener) {
        String str;
        HybridLogger hybridLogger = HybridLogger.INSTANCE;
        boolean z = false;
        Map<String, ? extends Object> mapOf = MapsKt.mapOf(new Pair[]{TuplesKt.to("taskConfig", config.toString()), TuplesKt.to("url", uri.toString())});
        LoggerContext loggerContext = new LoggerContext();
        loggerContext.pushStage(RLLoggerConstant.RESOURCE_SESSION, config.getResourceLoaderSession());
        Unit unit = Unit.INSTANCE;
        hybridLogger.m11i("XResourceLoader", "trigger gecko update", mapOf, loggerContext);
        if (Intrinsics.areEqual(uri.getScheme(), ResourceUriHelperKt.SCHEME_FILE) && Intrinsics.areEqual(uri.getAuthority(), ResourceUriHelperKt.AUTHORITY_RELATIVE)) {
            String path = uri.getPath();
            if (path == null) {
                path = "";
            }
            if (path.length() > 1 && StringsKt.startsWith$default(path, "/", false, 2, (Object) null)) {
                z = true;
            }
            if (!z) {
                path = null;
            }
            if (path != null) {
                str = path.substring(1);
                Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.String).substring(startIndex)");
            } else {
                str = null;
            }
            if (str == null) {
                updateListener.onUpdateFailed(new ArrayList(), new Exception("update failed because channel is null"));
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            ResourceLoader.with$default(ResourceLoader.INSTANCE, config.getBid(), null, 2, null).getResourceConfig().getGeckoConfig(config.getAccessKey()).getLoaderDepender().checkUpdate(config, arrayList, updateListener);
        }
    }

    private final String getSdkVersion(TaskConfig config) {
        return ResourceLoader.with$default(ResourceLoader.INSTANCE, config.getBid(), null, 2, null).getResourceConfig().getGeckoConfig(config.getAccessKey()).getLoaderDepender().getSdkVersion();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005d A[Catch: FileNotFoundException -> 0x00d6, TryCatch #0 {FileNotFoundException -> 0x00d6, blocks: (B:3:0x0001, B:6:0x0009, B:8:0x0012, B:10:0x001a, B:12:0x0020, B:17:0x0030, B:19:0x0038, B:22:0x0042, B:24:0x005d, B:29:0x0046, B:31:0x004f, B:34:0x0057, B:36:0x00a8, B:37:0x00be, B:38:0x00bf, B:39:0x00d5), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final ResourceMetaData innerLoadFromGeckoFile(Uri uri, TaskConfig config, String channel) {
        File geckoLoadOfflineFile;
        try {
            String scheme = uri.getScheme();
            if (scheme != null && scheme.hashCode() == 1303296464 && scheme.equals(ResourceUriHelperKt.SCHEME_FILE)) {
                String authority = uri.getAuthority();
                if (authority != null) {
                    int hashCode = authority.hashCode();
                    String str = "";
                    if (hashCode != -554435892) {
                        if (hashCode == 1728122231 && authority.equals("absolute")) {
                            String path = uri.getPath();
                            if (path != null) {
                                str = path;
                            }
                            geckoLoadOfflineFile = new File(str);
                            if (geckoLoadOfflineFile != null) {
                                return null;
                            }
                            ResourceMetaData resourceMetaData = new ResourceMetaData(uri);
                            RLLogger.INSTANCE.m21d("load from gecko success");
                            FileMetaInfo fileMetaInfo = new FileMetaInfo(geckoLoadOfflineFile, null, 2, null);
                            fileMetaInfo.setFrom(ResourceFrom.GECKO);
                            GeckoConfig geckoConfig = ResourceLoader.with$default(ResourceLoader.INSTANCE, config.getBid(), null, 2, null).getResourceConfig().getGeckoConfig(config.getAccessKey());
                            fileMetaInfo.setChannelVersion(Long.valueOf(geckoConfig.getLoaderDepender().getChannelVersion(geckoConfig.getOfflineDir(), config.getAccessKey(), channel)));
                            resourceMetaData.setMetaInfo(fileMetaInfo);
                            return resourceMetaData;
                        }
                    } else if (authority.equals(ResourceUriHelperKt.AUTHORITY_RELATIVE)) {
                        String path2 = uri.getPath();
                        if (path2 != null) {
                            str = path2;
                        }
                        geckoLoadOfflineFile = geckoLoadOfflineFile(str, config);
                        if (geckoLoadOfflineFile != null) {
                        }
                    }
                }
                throw new FileNotFoundException(uri + " not found");
            }
            throw new FileNotFoundException(uri + " not found");
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    private final File geckoLoadOfflineFile(String relativePath, TaskConfig config) {
        String accessKey = config.getAccessKey();
        GeckoConfig geckoConfig = ResourceLoader.with$default(ResourceLoader.INSTANCE, config.getBid(), null, 2, null).getResourceConfig().getGeckoConfig(config.getAccessKey());
        String geckoOfflineDir = geckoConfig.getLoaderDepender().getGeckoOfflineDir(geckoConfig.getOfflineDir(), accessKey, relativePath);
        RLLogger.INSTANCE.m21d("GeckoLoader using gecko info [accessKey=" + accessKey + ",filePath=" + geckoOfflineDir + ']');
        String str = geckoOfflineDir;
        if (str == null || str.length() == 0) {
            return null;
        }
        return new File(geckoOfflineDir);
    }

    public String toString() {
        return "GeckoLoader@" + this;
    }
}
