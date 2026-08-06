package com.bytedance.ies.tools.prefetch;

import com.bytedance.ies.tools.prefetch.INetworkExecutor;
import com.bytedance.perf.monitor.ReportConst;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: PrefetchProcess.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 82\u00020\u0001:\u000289B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\u000e\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0016J\u000e\u0010/\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0016J\b\u00100\u001a\u00020-H\u0002J\u0010\u00101\u001a\u00020-2\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u00102\u001a\u00020-2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u000e\u00103\u001a\u00020-2\u0006\u00104\u001a\u00020\u0007J\u0010\u00105\u001a\u00020-2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u0006\u00106\u001a\u000207R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R2\u0010\u0014\u001a&\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00160\u0016 \u0017*\u0012\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00160\u0016\u0018\u00010\u00180\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\rR\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006:"}, d2 = {"Lcom/bytedance/ies/tools/prefetch/PrefetchProcess;", "Lcom/bytedance/ies/tools/prefetch/INetworkExecutor$Callback;", "pageUrl", "", "request", "Lcom/bytedance/ies/tools/prefetch/PrefetchRequest;", "expires", "", "(Ljava/lang/String;Lcom/bytedance/ies/tools/prefetch/PrefetchRequest;J)V", "startTimeStamp", "(Ljava/lang/String;Lcom/bytedance/ies/tools/prefetch/PrefetchRequest;JJ)V", "businessGetDataStartTimeStamp", "getExpires", "()J", "hitState", "Lcom/bytedance/ies/tools/prefetch/PrefetchProcess$HitState;", "getHitState", "()Lcom/bytedance/ies/tools/prefetch/PrefetchProcess$HitState;", "setHitState", "(Lcom/bytedance/ies/tools/prefetch/PrefetchProcess$HitState;)V", "listenerSet", "", "Lcom/bytedance/ies/tools/prefetch/ProcessListener;", "kotlin.jvm.PlatformType", "", "monitor", "Lcom/bytedance/ies/tools/prefetch/IMonitor;", "getPageUrl", "()Ljava/lang/String;", "getRequest", "()Lcom/bytedance/ies/tools/prefetch/PrefetchRequest;", "response", "Lcom/bytedance/ies/tools/prefetch/INetworkExecutor$HttpResponse;", "getResponse", "()Lcom/bytedance/ies/tools/prefetch/INetworkExecutor$HttpResponse;", "setResponse", "(Lcom/bytedance/ies/tools/prefetch/INetworkExecutor$HttpResponse;)V", "getStartTimeStamp", "throwable", "", "getThrowable", "()Ljava/lang/Throwable;", "setThrowable", "(Ljava/lang/Throwable;)V", "attachListener", "", "processListener", "detachListener", "monitorDataFetched", "onRequestFailed", "onRequestSucceed", "setBusinessGetDataStartTimeStamp", "timeStamp", "setMonitor", "toJSONObject", "Lorg/json/JSONObject;", "Companion", "HitState", "prefetch_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PrefetchProcess implements INetworkExecutor.Callback {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private transient long businessGetDataStartTimeStamp;
    private final long expires;
    private transient HitState hitState;
    private final transient Set<ProcessListener> listenerSet;
    private transient IMonitor monitor;
    private final String pageUrl;
    private final PrefetchRequest request;
    private INetworkExecutor.HttpResponse response;
    private final long startTimeStamp;
    private transient Throwable throwable;

    /* compiled from: PrefetchProcess.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ies/tools/prefetch/PrefetchProcess$HitState;", "", "(Ljava/lang/String;I)V", "FALLBACK", "PENDING", "CACHED", "prefetch_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public enum HitState {
        FALLBACK,
        PENDING,
        CACHED
    }

    public PrefetchProcess(String str, PrefetchRequest prefetchRequest, long j, long j2) {
        Intrinsics.checkParameterIsNotNull(str, "pageUrl");
        Intrinsics.checkParameterIsNotNull(prefetchRequest, "request");
        this.pageUrl = str;
        this.request = prefetchRequest;
        this.startTimeStamp = j;
        this.expires = j2;
        this.listenerSet = Collections.synchronizedSet(new HashSet());
        this.hitState = HitState.FALLBACK;
        this.businessGetDataStartTimeStamp = System.currentTimeMillis();
    }

    public final String getPageUrl() {
        return this.pageUrl;
    }

    public final PrefetchRequest getRequest() {
        return this.request;
    }

    public final long getStartTimeStamp() {
        return this.startTimeStamp;
    }

    public final long getExpires() {
        return this.expires;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PrefetchProcess(String str, PrefetchRequest prefetchRequest, long j) {
        this(str, prefetchRequest, System.currentTimeMillis(), j);
        Intrinsics.checkParameterIsNotNull(str, "pageUrl");
        Intrinsics.checkParameterIsNotNull(prefetchRequest, "request");
    }

    public final HitState getHitState() {
        return this.hitState;
    }

    public final void setHitState(HitState hitState) {
        Intrinsics.checkParameterIsNotNull(hitState, "<set-?>");
        this.hitState = hitState;
    }

    public final Throwable getThrowable() {
        return this.throwable;
    }

    public final void setThrowable(Throwable th) {
        this.throwable = th;
    }

    public final INetworkExecutor.HttpResponse getResponse() {
        return this.response;
    }

    public final void setResponse(INetworkExecutor.HttpResponse httpResponse) {
        this.response = httpResponse;
    }

    public final void attachListener(ProcessListener processListener) {
        Intrinsics.checkParameterIsNotNull(processListener, "processListener");
        this.listenerSet.add(processListener);
        INetworkExecutor.HttpResponse httpResponse = this.response;
        if (httpResponse != null) {
            monitorDataFetched();
            processListener.onSucceed(httpResponse);
        }
        Throwable th = this.throwable;
        if (th != null) {
            monitorDataFetched();
            processListener.onFailed(th);
        }
    }

    public final void detachListener(ProcessListener processListener) {
        Intrinsics.checkParameterIsNotNull(processListener, "processListener");
        this.listenerSet.remove(processListener);
    }

    public final void setBusinessGetDataStartTimeStamp(long timeStamp) {
        this.businessGetDataStartTimeStamp = timeStamp;
    }

    public final void setMonitor(IMonitor monitor) {
        this.monitor = monitor;
    }

    @Override // com.bytedance.ies.tools.prefetch.INetworkExecutor.Callback
    public void onRequestSucceed(INetworkExecutor.HttpResponse response) {
        Intrinsics.checkParameterIsNotNull(response, "response");
        this.response = response;
        monitorDataFetched();
        Set<ProcessListener> set = this.listenerSet;
        Intrinsics.checkExpressionValueIsNotNull(set, "listenerSet");
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            ((ProcessListener) it.next()).onSucceed(response);
        }
    }

    @Override // com.bytedance.ies.tools.prefetch.INetworkExecutor.Callback
    public void onRequestFailed(Throwable throwable) {
        Intrinsics.checkParameterIsNotNull(throwable, "throwable");
        this.throwable = throwable;
        monitorDataFetched();
        Set<ProcessListener> set = this.listenerSet;
        Intrinsics.checkExpressionValueIsNotNull(set, "listenerSet");
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            ((ProcessListener) it.next()).onFailed(throwable);
        }
    }

    public final JSONObject toJSONObject() {
        JSONObject put = new JSONObject().put("page_url", this.pageUrl).put("request", this.request.toJSONObject()).put(ReportConst.KEY_TIMESTAMP, this.startTimeStamp).put("expires", this.expires);
        INetworkExecutor.HttpResponse httpResponse = this.response;
        JSONObject put2 = put.put("response", httpResponse != null ? httpResponse.toJSONObject$prefetch_release() : null);
        Intrinsics.checkExpressionValueIsNotNull(put2, "JSONObject()\n        .pu…response?.toJSONObject())");
        return put2;
    }

    private final void monitorDataFetched() {
        Class<?> cls;
        if (this.monitor == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.businessGetDataStartTimeStamp;
        IMonitor iMonitor = this.monitor;
        if (iMonitor != null) {
            iMonitor.onDataFetched(this.request, currentTimeMillis, this.response != null, this.hitState);
        }
        LogUtil logUtil = LogUtil.INSTANCE;
        StringBuilder append = new StringBuilder("{ request: ").append(this.request.getUrl()).append("], duration: ").append(currentTimeMillis).append(", hitState: ").append(this.hitState).append(", content: ").append(this.request.toJSONObject()).append(", error: ");
        Throwable th = this.throwable;
        logUtil.m55d(append.append((th == null || (cls = th.getClass()) == null) ? null : cls.getSimpleName()).append(" }").toString());
    }

    /* compiled from: PrefetchProcess.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ies/tools/prefetch/PrefetchProcess$Companion;", "", "()V", "fromJSONObject", "Lcom/bytedance/ies/tools/prefetch/PrefetchProcess;", "requestObject", "Lorg/json/JSONObject;", "fromJSONObject$prefetch_release", "prefetch_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PrefetchProcess fromJSONObject$prefetch_release(JSONObject requestObject) {
            Intrinsics.checkParameterIsNotNull(requestObject, "requestObject");
            String string = requestObject.getString("page_url");
            Intrinsics.checkExpressionValueIsNotNull(string, "requestObject.getString(\"page_url\")");
            JSONObject jSONObject = requestObject.getJSONObject("request");
            Intrinsics.checkExpressionValueIsNotNull(jSONObject, "requestObject.getJSONObject(\"request\")");
            PrefetchProcess prefetchProcess = new PrefetchProcess(string, new PrefetchRequest(jSONObject), requestObject.getLong(ReportConst.KEY_TIMESTAMP), requestObject.getLong("expires"));
            JSONObject jSONObject2 = requestObject.getJSONObject("response");
            INetworkExecutor.HttpResponse httpResponse = new INetworkExecutor.HttpResponse();
            Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "this");
            prefetchProcess.setResponse(httpResponse.fromJSONObject$prefetch_release(jSONObject2));
            return prefetchProcess;
        }
    }
}
