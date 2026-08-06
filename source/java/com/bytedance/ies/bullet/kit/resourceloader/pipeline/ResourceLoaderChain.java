package com.bytedance.ies.bullet.kit.resourceloader.pipeline;

import android.os.SystemClock;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceInfoWrapper;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoaderService;
import com.bytedance.ies.bullet.kit.resourceloader.TimeInterval;
import com.bytedance.ies.bullet.kit.resourceloader.loggger.RLLogger;
import com.bytedance.ies.bullet.kit.resourceloader.loggger.RLLoggerConstant;
import com.bytedance.ies.bullet.kit.resourceloader.monitor.RLMonitorReporter;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.ies.bullet.service.base.resourceloader.config.IXResourceLoader;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import com.bytedance.lynx.scc.cloudservice.SccResult;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ResourceLoaderChain.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B#\u0012\u0014\u0010\u0002\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00040\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\"\u001a\u00020#J6\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020#0(2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020#0(J^\u0010+\u001a\u00020#2\u0006\u0010%\u001a\u00020&2\u0014\u0010,\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00040-2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020#0(2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020#0(2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0011H\u0002J8\u00101\u001a\u00020#2\u0006\u0010%\u001a\u00020&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020#0(2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020#0(H\u0002J\f\u00102\u001a\b\u0012\u0004\u0012\u0002030\u0003R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\u001c\u0010\u0002\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001b¨\u00064"}, d2 = {"Lcom/bytedance/ies/bullet/kit/resourceloader/pipeline/ResourceLoaderChain;", "", "processors", "", "Ljava/lang/Class;", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/IXResourceLoader;", "service", "Lcom/bytedance/ies/bullet/kit/resourceloader/ResourceLoaderService;", "(Ljava/util/List;Lcom/bytedance/ies/bullet/kit/resourceloader/ResourceLoaderService;)V", "countDown", "Ljava/util/concurrent/CountDownLatch;", "current", "getCurrent", "()Lcom/bytedance/ies/bullet/service/base/resourceloader/config/IXResourceLoader;", "setCurrent", "(Lcom/bytedance/ies/bullet/service/base/resourceloader/config/IXResourceLoader;)V", "defaultIndex", "", "getDefaultIndex", "()I", "setDefaultIndex", "(I)V", "hasCanceled", "", "getHasCanceled", "()Z", "setHasCanceled", "(Z)V", "lowIndex", "getLowIndex", "setLowIndex", "useLowLoader", "getUseLowLoader", "setUseLowLoader", "cancel", "", "load", "input", "Lcom/bytedance/ies/bullet/kit/resourceloader/ResourceInfoWrapper;", "resolve", "Lkotlin/Function1;", "reject", "", "loadAsyncInner", "iter", "", EventConstants.PARAM_SOURCE_INTERVAL, "Lcom/bytedance/ies/bullet/kit/resourceloader/TimeInterval;", "index", "loadSyncImpl", "toLoaderStrList", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ResourceLoaderChain {
    private CountDownLatch countDown;
    private IXResourceLoader current;
    private int defaultIndex;
    private boolean hasCanceled;
    private int lowIndex;
    private final List<Class<? extends IXResourceLoader>> processors;
    private final ResourceLoaderService service;
    private boolean useLowLoader;

    /* JADX WARN: Multi-variable type inference failed */
    public ResourceLoaderChain(List<? extends Class<? extends IXResourceLoader>> list, ResourceLoaderService resourceLoaderService) {
        Intrinsics.checkNotNullParameter(list, "processors");
        Intrinsics.checkNotNullParameter(resourceLoaderService, "service");
        this.processors = list;
        this.service = resourceLoaderService;
        this.lowIndex = -1;
    }

    public final int getDefaultIndex() {
        return this.defaultIndex;
    }

    public final void setDefaultIndex(int i) {
        this.defaultIndex = i;
    }

    public final int getLowIndex() {
        return this.lowIndex;
    }

    public final void setLowIndex(int i) {
        this.lowIndex = i;
    }

    public final boolean getHasCanceled() {
        return this.hasCanceled;
    }

    public final void setHasCanceled(boolean z) {
        this.hasCanceled = z;
    }

    public final boolean getUseLowLoader() {
        return this.useLowLoader;
    }

    public final void setUseLowLoader(boolean z) {
        this.useLowLoader = z;
    }

    public final IXResourceLoader getCurrent() {
        return this.current;
    }

    public final void setCurrent(IXResourceLoader iXResourceLoader) {
        this.current = iXResourceLoader;
    }

    public final void load(ResourceInfoWrapper input, Function1<? super ResourceInfoWrapper, Unit> resolve, Function1<? super Throwable, Unit> reject) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(resolve, "resolve");
        Intrinsics.checkNotNullParameter(reject, "reject");
        LoggerContext loggerContext = new LoggerContext();
        loggerContext.pushStage(RLLoggerConstant.RESOURCE_SESSION, input.getConfig().getResourceLoaderSession());
        input.setConfig(new TaskConfig(input.getConfig().getAccessKey()).from(input.getConfig()));
        if (this.processors.isEmpty()) {
            reject.invoke(new Throwable("ResourceLoaderChain# no processor for " + input.getInfo().getSrcUri()));
            return;
        }
        HybridLogger.INSTANCE.m11i("XResourceLoader", "ResourceLoader chain info", MapsKt.mapOf(new Pair[]{TuplesKt.to("url", input.getInfo().getSrcUri().toString()), TuplesKt.to("processors", this.processors.toString()), TuplesKt.to("processors size", Integer.valueOf(this.processors.size()))}), loggerContext);
        if (input.getIsASync()) {
            loadAsyncInner(input, this.processors.iterator(), resolve, reject, new TimeInterval(), 0);
        } else {
            loadSyncImpl(input, resolve, reject);
        }
        RLLogger.INSTANCE.m21d("Load url = " + input.getInfo().getSrcUri() + ", message = " + input.getInfo().getPipelineStatus());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadAsyncInner(final ResourceInfoWrapper input, final Iterator<? extends Class<? extends IXResourceLoader>> iter, final Function1<? super ResourceInfoWrapper, Unit> resolve, final Function1<? super Throwable, Unit> reject, final TimeInterval interval, final int index) {
        char c;
        String str;
        int i;
        Object obj;
        JSONObject metrics;
        LoggerContext loggerContext = new LoggerContext();
        loggerContext.pushStage(RLLoggerConstant.RESOURCE_SESSION, input.getConfig().getResourceLoaderSession());
        if (iter.hasNext()) {
            final Class<? extends IXResourceLoader> next = iter.next();
            final boolean hasNext = iter.hasNext();
            final IXResourceLoader newInstance = next.newInstance();
            newInstance.setService(this.service);
            this.current = newInstance;
            SystemClock.elapsedRealtime();
            HybridLogger.INSTANCE.m11i("XResourceLoader", "ResourceLoader chain start load", MapsKt.mapOf(TuplesKt.to("loader", next.toString())), loggerContext);
            try {
                if (index == this.defaultIndex && (metrics = input.getInfo().getPerformanceInfo().getMetrics()) != null) {
                    metrics.put(RLMonitorReporter.HIGH_PROCESSOR_TOTAL, interval.getTimeInterval());
                }
                if (index == this.lowIndex) {
                    this.useLowLoader = true;
                    interval.getTimeInterval();
                }
                c = 1;
                try {
                    str = "XResourceLoader";
                    i = 3;
                    obj = "url";
                    try {
                        newInstance.loadAsync(input.getInfo(), input.getConfig(), new Function1<ResourceInfo, Unit>() { // from class: com.bytedance.ies.bullet.kit.resourceloader.pipeline.ResourceLoaderChain$loadAsyncInner$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                invoke((ResourceInfo) obj2);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ResourceInfo resourceInfo) {
                                JSONObject metrics2;
                                Intrinsics.checkNotNullParameter(resourceInfo, "it");
                                if (ResourceLoaderChain.this.getHasCanceled()) {
                                    reject.invoke(new Throwable("ResourceLoaderChain# on cancel load"));
                                    return;
                                }
                                input.setInfo(resourceInfo);
                                ResourceInfo info = input.getInfo();
                                String simpleName = next.getSimpleName();
                                Intrinsics.checkNotNullExpressionValue(simpleName, "clz.simpleName");
                                info.setSuccessLoader(simpleName);
                                if (ResourceLoaderChain.this.getUseLowLoader() && (metrics2 = input.getInfo().getPerformanceInfo().getMetrics()) != null) {
                                    metrics2.put(RLMonitorReporter.LOW_PROCESSOR_TOTAL, interval.getTimeInterval());
                                }
                                resolve.invoke(input);
                                JSONArray pipelineStatus = input.getInfo().getPipelineStatus();
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("name", newInstance.getTAG());
                                jSONObject.put("status", "success");
                                pipelineStatus.put(jSONObject);
                            }
                        }, new Function1<Throwable, Unit>() { // from class: com.bytedance.ies.bullet.kit.resourceloader.pipeline.ResourceLoaderChain$loadAsyncInner$2
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                invoke((Throwable) obj2);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Throwable th) {
                                JSONObject metrics2;
                                Intrinsics.checkNotNullParameter(th, "it");
                                JSONArray pipelineStatus = ResourceInfoWrapper.this.getInfo().getPipelineStatus();
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("name", newInstance.getTAG());
                                jSONObject.put("status", SccResult.MESSAGE_FAIL);
                                jSONObject.put("message", String.valueOf(th.getMessage()));
                                pipelineStatus.put(jSONObject);
                                if (this.getHasCanceled()) {
                                    reject.invoke(new Throwable("ResourceLoaderChain# on cancel load"));
                                    return;
                                }
                                if (hasNext) {
                                    this.loadAsyncInner(ResourceInfoWrapper.this, iter, resolve, reject, interval, index + 1);
                                    return;
                                }
                                if (this.getUseLowLoader() && (metrics2 = ResourceInfoWrapper.this.getInfo().getPerformanceInfo().getMetrics()) != null) {
                                    metrics2.put(RLMonitorReporter.LOW_PROCESSOR_TOTAL, interval.getTimeInterval());
                                }
                                reject.invoke(th);
                            }
                        });
                    } catch (Throwable th) {
                        th = th;
                        HybridLogger hybridLogger = HybridLogger.INSTANCE;
                        Pair[] pairArr = new Pair[i];
                        pairArr[0] = TuplesKt.to(obj, input.getInfo().getSrcUri().toString());
                        pairArr[c] = TuplesKt.to("error", th.getMessage());
                        pairArr[2] = TuplesKt.to("hasNex", Boolean.valueOf(hasNext));
                        hybridLogger.m9e(str, "ResourceLoader chain catch error", MapsKt.mapOf(pairArr), loggerContext);
                        if (hasNext) {
                            loadAsyncInner(input, iter, resolve, reject, interval, index + 1);
                        } else {
                            reject.invoke(new Throwable("ResourceLoaderChain# " + th.getMessage()));
                        }
                        return;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    obj = "url";
                    str = "XResourceLoader";
                    i = 3;
                }
            } catch (Throwable th3) {
                th = th3;
                c = 1;
                str = "XResourceLoader";
                i = 3;
                obj = "url";
            }
            return;
        }
        HybridLogger.INSTANCE.m9e("XResourceLoader", "ResourceLoader chain no Element for load", MapsKt.mapOf(new Pair[]{TuplesKt.to("url", input.getInfo().getSrcUri().toString()), TuplesKt.to("processors", this.processors.toString()), TuplesKt.to("processors size", Integer.valueOf(this.processors.size()))}), loggerContext);
        reject.invoke(new Throwable("ResourceLoaderChain# no Element for " + input.getInfo().getSrcUri()));
    }

    private final void loadSyncImpl(ResourceInfoWrapper input, Function1<? super ResourceInfoWrapper, Unit> resolve, Function1<? super Throwable, Unit> reject) {
        JSONObject metrics;
        ResourceInfo loadSync;
        JSONObject metrics2;
        JSONObject metrics3;
        JSONObject metrics4;
        TimeInterval timeInterval = new TimeInterval();
        Iterator<T> it = this.processors.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2 = i + 1;
            Class cls = (Class) it.next();
            try {
                if (i == this.defaultIndex && (metrics4 = input.getInfo().getPerformanceInfo().getMetrics()) != null) {
                    metrics4.put(RLMonitorReporter.HIGH_PROCESSOR_TOTAL, timeInterval.getTimeInterval());
                }
                if (i == this.lowIndex) {
                    timeInterval.getTimeInterval();
                    this.useLowLoader = true;
                }
                IXResourceLoader iXResourceLoader = (IXResourceLoader) cls.newInstance();
                iXResourceLoader.setService(this.service);
                this.current = iXResourceLoader;
                loadSync = iXResourceLoader.loadSync(input.getInfo(), input.getConfig());
            } catch (Throwable th) {
                if (i == this.processors.size() - 1) {
                    if (this.useLowLoader && (metrics = input.getInfo().getPerformanceInfo().getMetrics()) != null) {
                        metrics.put(RLMonitorReporter.LOW_PROCESSOR_TOTAL, timeInterval.getTimeInterval());
                    }
                    reject.invoke(th);
                }
            }
            if (loadSync == null) {
                Throwable th2 = new Throwable(cls.getCanonicalName() + " return null");
                if (i == this.processors.size() - 1) {
                    if (this.useLowLoader && (metrics3 = input.getInfo().getPerformanceInfo().getMetrics()) != null) {
                        metrics3.put(RLMonitorReporter.LOW_PROCESSOR_TOTAL, timeInterval.getTimeInterval());
                    }
                    reject.invoke(th2);
                }
                RLLogger.INSTANCE.m23e("rl load sync failed", th2);
                if (this.hasCanceled) {
                    reject.invoke(new Throwable("ResourceLoaderChain# on cancel load"));
                    return;
                }
                i = i2;
            } else {
                input.setInfo(loadSync);
                ResourceInfo info = input.getInfo();
                String simpleName = cls.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "clz.simpleName");
                info.setSuccessLoader(simpleName);
                if (this.useLowLoader && (metrics2 = input.getInfo().getPerformanceInfo().getMetrics()) != null) {
                    metrics2.put(RLMonitorReporter.LOW_PROCESSOR_TOTAL, timeInterval.getTimeInterval());
                }
                resolve.invoke(input);
                return;
            }
        }
    }

    public final void cancel() {
        this.hasCanceled = true;
        CountDownLatch countDownLatch = this.countDown;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
        IXResourceLoader iXResourceLoader = this.current;
        if (iXResourceLoader != null) {
            iXResourceLoader.cancelLoad();
        }
    }

    public final List<String> toLoaderStrList() {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = this.processors.iterator();
        while (it.hasNext()) {
            String name = ((Class) it.next()).getName();
            Intrinsics.checkNotNullExpressionValue(name, "it.name");
            arrayList.add(name);
        }
        return arrayList;
    }
}
