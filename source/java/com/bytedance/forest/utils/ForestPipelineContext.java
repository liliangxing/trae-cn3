package com.bytedance.forest.utils;

import android.app.Application;
import android.content.Context;
import android.os.Looper;
import com.bytedance.apm.agent.instrumentation.okhttp3.OkHttpEventListener;
import com.bytedance.forest.InternalReporter;
import com.bytedance.forest.model.BytesProvider;
import com.bytedance.forest.model.ForestBuffer;
import com.bytedance.forest.model.InMemoryByteBuffer;
import com.bytedance.forest.model.Request;
import com.bytedance.forest.utils.io.ForestConcurrentBuffer;
import com.bytedance.forest.utils.io.ForestWebStreamConcurrentBuffer;
import com.bytedance.forest.utils.io.ForestWebStreamingBuffer;
import com.bytedance.retrofit2.client.Header;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ForestPipelineContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0005\u0018\u0000 72\u00020\u0001:\u00017B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001d\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0000¢\u0006\u0002\b*J\u001b\u0010+\u001a\u00020,2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.H\u0000¢\u0006\u0002\b0J/\u00101\u001a\u00020,2\u0012\u00102\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001303\"\u00020\u00132\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0019H\u0000¢\u0006\u0004\b5\u00106R\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u0012X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R \u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00190\u0012X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u001a\u0010\u001b\u001a\u00020\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020!X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u00068"}, d2 = {"Lcom/bytedance/forest/utils/ForestPipelineContext;", "", "app", "Landroid/app/Application;", "logger", "Lcom/bytedance/forest/utils/ForestLogger;", "(Landroid/app/Application;Lcom/bytedance/forest/utils/ForestLogger;)V", "androidContext", "Landroid/content/Context;", "getAndroidContext$forest_release", "()Landroid/content/Context;", "getApp", "()Landroid/app/Application;", "callFromMainThread", "", "getCallFromMainThread$forest_release", "()Z", "cdnHeadersInfo", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getCdnHeadersInfo$forest_release", "()Ljava/util/concurrent/ConcurrentHashMap;", "getLogger$forest_release", "()Lcom/bytedance/forest/utils/ForestLogger;", "performanceInfo", "", "getPerformanceInfo$forest_release", "pipelineTag", "getPipelineTag$forest_release", "()Ljava/lang/String;", "setPipelineTag$forest_release", "(Ljava/lang/String;)V", "reporter", "Lcom/bytedance/forest/InternalReporter;", "getReporter$forest_release", "()Lcom/bytedance/forest/InternalReporter;", "obtainInMemoryByteBuffer", "Lcom/bytedance/forest/model/InMemoryByteBuffer;", "bytesProvider", "Lcom/bytedance/forest/model/BytesProvider;", "request", "Lcom/bytedance/forest/model/Request;", "obtainInMemoryByteBuffer$forest_release", "recordCDNHeaderInfo", "", "headers", "", "Lcom/bytedance/retrofit2/client/Header;", "recordCDNHeaderInfo$forest_release", "recordPerformanceTiming", "timingName", "", "timing", "recordPerformanceTiming$forest_release", "([Ljava/lang/String;Ljava/lang/Long;)V", "Companion", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ForestPipelineContext {
    private static final String[] SENSITIVE_CDN_HEADERS = {"x-tt-logid", OkHttpEventListener.X_TT_TRACE_HOST, OkHttpEventListener.X_TT_TRACE_ID, OkHttpEventListener.X_TT_TRACE_TAG, "date", "x-request-ip", "x-net-info.remoteaddr", "content-encoding", OfflineUtil.CONTENT_LENGTH_HEADER, "content-type", "eagleid", "x-link-via", "Ser", "via", "x-cdn-request-id", "x-tos-request-id"};
    private final Context androidContext;
    private final Application app;
    private final boolean callFromMainThread;
    private final ConcurrentHashMap<String, String> cdnHeadersInfo;
    private final ForestLogger logger;
    private final ConcurrentHashMap<String, Long> performanceInfo;
    private String pipelineTag;
    private final InternalReporter reporter;

    public ForestPipelineContext(Application application, ForestLogger forestLogger) {
        Intrinsics.checkParameterIsNotNull(application, "app");
        Intrinsics.checkParameterIsNotNull(forestLogger, "logger");
        this.app = application;
        this.logger = forestLogger;
        this.reporter = new InternalReporter(this);
        Thread currentThread = Thread.currentThread();
        Looper mainLooper = Looper.getMainLooper();
        Intrinsics.checkExpressionValueIsNotNull(mainLooper, "Looper.getMainLooper()");
        this.callFromMainThread = Intrinsics.areEqual(currentThread, mainLooper.getThread());
        Context applicationContext = application.getApplicationContext();
        Intrinsics.checkExpressionValueIsNotNull(applicationContext, "app.applicationContext");
        this.androidContext = applicationContext;
        this.performanceInfo = new ConcurrentHashMap<>();
        this.pipelineTag = "";
        this.cdnHeadersInfo = new ConcurrentHashMap<>();
    }

    public final Application getApp() {
        return this.app;
    }

    public /* synthetic */ ForestPipelineContext(Application application, ForestLogger forestLogger, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(application, (i & 2) != 0 ? new ForestLogger() : forestLogger);
    }

    /* renamed from: getLogger$forest_release, reason: from getter */
    public final ForestLogger getLogger() {
        return this.logger;
    }

    /* renamed from: getReporter$forest_release, reason: from getter */
    public final InternalReporter getReporter() {
        return this.reporter;
    }

    /* renamed from: getCallFromMainThread$forest_release, reason: from getter */
    public final boolean getCallFromMainThread() {
        return this.callFromMainThread;
    }

    /* renamed from: getAndroidContext$forest_release, reason: from getter */
    public final Context getAndroidContext() {
        return this.androidContext;
    }

    public final ConcurrentHashMap<String, Long> getPerformanceInfo$forest_release() {
        return this.performanceInfo;
    }

    /* renamed from: getPipelineTag$forest_release, reason: from getter */
    public final String getPipelineTag() {
        return this.pipelineTag;
    }

    public final void setPipelineTag$forest_release(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.pipelineTag = str;
    }

    public static /* synthetic */ void recordPerformanceTiming$forest_release$default(ForestPipelineContext forestPipelineContext, String[] strArr, Long l, int i, Object obj) {
        if ((i & 2) != 0) {
            l = null;
        }
        forestPipelineContext.recordPerformanceTiming$forest_release(strArr, l);
    }

    public final void recordPerformanceTiming$forest_release(String[] timingName, Long timing) {
        Intrinsics.checkParameterIsNotNull(timingName, "timingName");
        long longValue = timing != null ? timing.longValue() : System.currentTimeMillis();
        for (String str : timingName) {
            this.performanceInfo.put(StringsKt.removePrefix(this.pipelineTag + '_' + str, "_"), Long.valueOf(longValue));
        }
    }

    public final ConcurrentHashMap<String, String> getCdnHeadersInfo$forest_release() {
        return this.cdnHeadersInfo;
    }

    public final void recordCDNHeaderInfo$forest_release(List<Header> headers) {
        Intrinsics.checkParameterIsNotNull(headers, "headers");
        ArrayList<Header> arrayList = new ArrayList();
        for (Object obj : headers) {
            if (ArraysKt.contains(SENSITIVE_CDN_HEADERS, ((Header) obj).getName())) {
                arrayList.add(obj);
            }
        }
        for (Header header : arrayList) {
            ConcurrentHashMap<String, String> concurrentHashMap = this.cdnHeadersInfo;
            String str = "cdn-ttnet-" + header.getName();
            String value = header.getValue();
            Intrinsics.checkExpressionValueIsNotNull(value, "header.value");
            concurrentHashMap.put(str, value);
        }
    }

    public final InMemoryByteBuffer obtainInMemoryByteBuffer$forest_release(BytesProvider bytesProvider, Request request) {
        Intrinsics.checkParameterIsNotNull(bytesProvider, "bytesProvider");
        Intrinsics.checkParameterIsNotNull(request, "request");
        if (request.getStreamingLoad()) {
            if (request.getIoConcurrency()) {
                return new ForestWebStreamConcurrentBuffer(bytesProvider, this);
            }
            return new ForestWebStreamingBuffer(bytesProvider, this);
        }
        if (request.getIoConcurrency()) {
            return new ForestConcurrentBuffer(bytesProvider, this);
        }
        return new ForestBuffer(bytesProvider, this);
    }
}
