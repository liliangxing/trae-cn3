package com.bytedance.ies.bullet.kit.resourceloader.loader;

import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoaderUtils;
import com.bytedance.ies.bullet.kit.resourceloader.TimeInterval;
import com.bytedance.ies.bullet.kit.resourceloader.loggger.RLLoggerConstant;
import com.bytedance.ies.bullet.kit.resourceloader.memory.MemoryManager;
import com.bytedance.ies.bullet.service.base.ResourceFrom;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.ies.bullet.service.base.resourceloader.config.IXResourceLoader;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import com.bytedance.lynx.scc.cloudservice.SccResult;
import com.bytedance.push.event.sync.ISignalReportConstants;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: MemoryLoader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J@\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00040\u000bH\u0016J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ies/bullet/kit/resourceloader/loader/MemoryLoader;", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/IXResourceLoader;", "()V", "cancelLoad", "", "loadAsync", "input", "Lcom/bytedance/ies/bullet/service/base/ResourceInfo;", "config", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/TaskConfig;", "resolve", "Lkotlin/Function1;", "reject", "", CDNLoader.STEP_NAME_SYNC, "loadWithMemory", "toString", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class MemoryLoader extends IXResourceLoader {
    @Override // com.bytedance.ies.bullet.service.base.resourceloader.config.IXResourceLoader
    public void cancelLoad() {
    }

    @Override // com.bytedance.ies.bullet.service.base.resourceloader.config.IXResourceLoader
    public ResourceInfo loadSync(ResourceInfo input, TaskConfig config) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(config, "config");
        setInterval(new TimeInterval());
        LoggerContext loggerContext = new LoggerContext();
        loggerContext.pushStage(RLLoggerConstant.RESOURCE_SESSION, config.getResourceLoaderSession());
        HybridLogger.INSTANCE.m11i("XResourceLoader", "MemoryLoader start sync load", MapsKt.mapOf(new Pair[]{TuplesKt.to("url", input.getSrcUri().toString()), TuplesKt.to("config", config.toString())}), loggerContext);
        ResourceInfo loadWithMemory = loadWithMemory(input, config);
        if (loadWithMemory != null) {
            loadWithMemory.setFromMemory(true);
            loadWithMemory.setPerformanceInfo(input.getPerformanceInfo());
            loadWithMemory.setPipelineStatus(input.getPipelineStatus());
            JSONObject metrics = loadWithMemory.getPerformanceInfo().getMetrics();
            if (metrics != null) {
                metrics.put("me_total", getInterval().getTotalTime());
            }
        }
        HybridLogger.INSTANCE.m11i("XResourceLoader", "MemoryLoader loadSync", MapsKt.mapOf(new Pair[]{TuplesKt.to("result", loadWithMemory), TuplesKt.to("url", input.getSrcUri().toString())}), loggerContext);
        return loadWithMemory;
    }

    @Override // com.bytedance.ies.bullet.service.base.resourceloader.config.IXResourceLoader
    public void loadAsync(ResourceInfo input, TaskConfig config, Function1<? super ResourceInfo, Unit> resolve, Function1<? super Throwable, Unit> reject) {
        String str;
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(resolve, "resolve");
        Intrinsics.checkNotNullParameter(reject, "reject");
        LoggerContext loggerContext = new LoggerContext();
        loggerContext.pushStage(RLLoggerConstant.RESOURCE_SESSION, config.getResourceLoaderSession());
        HybridLogger.INSTANCE.m11i("XResourceLoader", "MemoryLoader start async load", MapsKt.mapOf(new Pair[]{TuplesKt.to("url", input.getSrcUri().toString()), TuplesKt.to("config", config.toString())}), loggerContext);
        setInterval(new TimeInterval());
        ResourceInfo loadWithMemory = loadWithMemory(input, config);
        if (loadWithMemory == null) {
            JSONObject metrics = input.getPerformanceInfo().getMetrics();
            if (metrics != null) {
                str = "XResourceLoader";
                metrics.put("me_total", getInterval().getTotalTime());
            } else {
                str = "XResourceLoader";
            }
            JSONArray pipelineStatus = input.getPipelineStatus();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", "Memory");
            jSONObject.put("status", SccResult.MESSAGE_FAIL);
            jSONObject.put("message", "not found");
            pipelineStatus.put(jSONObject);
            HybridLogger.INSTANCE.m11i(str, "memory loader return null", MapsKt.mapOf(new Pair[]{TuplesKt.to("url", input.getSrcUri().toString()), TuplesKt.to(ISignalReportConstants.KEY_REASON, "because result is null")}), loggerContext);
            reject.invoke(new Throwable("memory loader return null"));
            return;
        }
        loadWithMemory.setFromMemory(true);
        loadWithMemory.setPerformanceInfo(input.getPerformanceInfo());
        JSONObject metrics2 = loadWithMemory.getPerformanceInfo().getMetrics();
        if (metrics2 != null) {
            metrics2.put("me_total", getInterval().getTotalTime());
        }
        InputStream provideInputStream = loadWithMemory.provideInputStream();
        if ((provideInputStream != null ? provideInputStream.available() : 0) > 0) {
            try {
                if (loadWithMemory.getFrom() != ResourceFrom.BUILTIN && provideInputStream != null) {
                    provideInputStream.close();
                }
            } catch (Exception e) {
                HybridLogger.INSTANCE.m13w("XResourceLoader", "inputStream error", MapsKt.mapOf(TuplesKt.to("error", e.getMessage())), loggerContext);
            }
            JSONArray pipelineStatus2 = input.getPipelineStatus();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("name", "Memory");
            jSONObject2.put("status", "success");
            pipelineStatus2.put(jSONObject2);
            input.setPipelineStatus(pipelineStatus2);
            loadWithMemory.setPipelineStatus(input.getPipelineStatus());
            HybridLogger.INSTANCE.m11i("XResourceLoader", "memory loader return result", MapsKt.mapOf(new Pair[]{TuplesKt.to("url", input.getSrcUri().toString()), TuplesKt.to("result", loadWithMemory)}), loggerContext);
            resolve.invoke(loadWithMemory);
            return;
        }
        input.setMemoryMessage("memory size 0");
        JSONArray pipelineStatus3 = input.getPipelineStatus();
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("name", "Memory");
        jSONObject3.put("status", CDNLoader.PIPELINE_STATUS_FAILED);
        jSONObject3.put("message", "size 0");
        pipelineStatus3.put(jSONObject3);
        input.setPipelineStatus(pipelineStatus3);
        HybridLogger.INSTANCE.m11i("XResourceLoader", "memory loader return null", MapsKt.mapOf(new Pair[]{TuplesKt.to("url", input.getSrcUri().toString()), TuplesKt.to(ISignalReportConstants.KEY_REASON, "memory loader size is 0")}), loggerContext);
        reject.invoke(new Throwable("memory loader size is 0"));
    }

    private final ResourceInfo loadWithMemory(ResourceInfo input, TaskConfig config) {
        LoggerContext loggerContext = new LoggerContext();
        loggerContext.pushStage(RLLoggerConstant.RESOURCE_SESSION, config.getResourceLoaderSession());
        Integer dynamic = config.getDynamic();
        if (dynamic != null && dynamic.intValue() == 2) {
            input.setMemoryMessage("memory dynamic is 2");
            HybridLogger.INSTANCE.m11i("XResourceLoader", "MemoryLoader return null", MapsKt.mapOf(new Pair[]{TuplesKt.to("url", input.getSrcUri().toString()), TuplesKt.to(ISignalReportConstants.KEY_REASON, "because dynamic is 2")}), loggerContext);
            return null;
        }
        if (!(config.getChannel().length() == 0)) {
            if (!(config.getBundle().length() == 0)) {
                return MemoryManager.INSTANCE.getInstance().getResourceInfoWithKey(ResourceLoaderUtils.INSTANCE.createCacheKey(input, config));
            }
        }
        input.setMemoryMessage("memory channel/bundle is empty");
        HybridLogger.INSTANCE.m11i("XResourceLoader", "MemoryLoader return null", MapsKt.mapOf(new Pair[]{TuplesKt.to("url", input.getSrcUri().toString()), TuplesKt.to(ISignalReportConstants.KEY_REASON, "because channel or bundle is empty")}), loggerContext);
        return null;
    }

    public String toString() {
        return "MemoryLoader@" + this;
    }
}
