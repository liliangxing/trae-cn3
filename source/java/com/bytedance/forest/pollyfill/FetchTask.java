package com.bytedance.forest.pollyfill;

import com.bytedance.android.sdk.bdticketguard.TicketGuardProviderKt;
import com.bytedance.apm.constant.AgentConstants;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.forest.Forest;
import com.bytedance.forest.chain.fetchers.CDNFetcher;
import com.bytedance.forest.model.InMemoryBuffer;
import com.bytedance.forest.model.Request;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Timing;
import com.bytedance.forest.pollyfill.ForestNetAPI;
import com.bytedance.forest.utils.ForestLogger;
import com.bytedance.forest.utils.ForestPipelineContext;
import com.bytedance.forest.utils.OfflineUtil;
import com.bytedance.forest.utils.ThreadUtils;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: CDNFetchDepender.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0003\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000 42\u00020\u0001:\u000245B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010\u0017\u001a\u00020\u0018H\u0000¢\u0006\u0002\b\u0019J\u000f\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0002\b\u001bJ\r\u0010\u001c\u001a\u00020\u0018H\u0010¢\u0006\u0002\b\u001dJ\u001d\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020!H\u0010¢\u0006\u0002\b\"J\r\u0010#\u001a\u00020\u0018H\u0010¢\u0006\u0002\b$J\b\u0010%\u001a\u00020\u0018H\u0016J\u0015\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u0011H\u0010¢\u0006\u0002\b(J\u0010\u0010)\u001a\u00020\u00182\b\u0010*\u001a\u0004\u0018\u00010+J\r\u0010,\u001a\u00020\u0018H\u0010¢\u0006\u0002\b-J\u0015\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u00020\u0000H\u0000¢\u0006\u0002\b0J\u0015\u00101\u001a\u00020\u00182\u0006\u00102\u001a\u00020\u0001H\u0000¢\u0006\u0002\b3R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/bytedance/forest/pollyfill/FetchTask;", "", "forest", "Lcom/bytedance/forest/Forest;", ApmTrafficStats.TTNET_RESPONSE, "Lcom/bytedance/forest/model/Response;", "context", "Lcom/bytedance/forest/utils/ForestPipelineContext;", "(Lcom/bytedance/forest/Forest;Lcom/bytedance/forest/model/Response;Lcom/bytedance/forest/utils/ForestPipelineContext;)V", "hasSubTask", "", "mustRevalidate", "getMustRevalidate", "()Z", "onlyLocal", "getOnlyLocal", "redirectedUrl", "", "getResponse", "()Lcom/bytedance/forest/model/Response;", "state", "Lcom/bytedance/forest/pollyfill/FetchTask$State;", "unique", "cancel", "", "cancel$forest_release", "getUnique", "getUnique$forest_release", "onCanceled", "onCanceled$forest_release", "onFailure", "shouldRetry", "error", "", "onFailure$forest_release", "onIntercept", "onIntercept$forest_release", "onPaused", "onRedirection", "url", "onRedirection$forest_release", AgentConstants.ON_START, "httpRequest", "Lcom/bytedance/forest/pollyfill/ForestNetAPI$HttpRequest;", "onSuccess", "onSuccess$forest_release", "registerSubTask", "fetchTask", "registerSubTask$forest_release", "setUnique", TicketGuardProviderKt.PATH_SIGN, "setUnique$forest_release", "Companion", "State", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public abstract class FetchTask {
    private static final String TAG = "fetch_task";
    private final ForestPipelineContext context;
    private final Forest forest;
    private volatile boolean hasSubTask;
    private final boolean mustRevalidate;
    private final boolean onlyLocal;
    private String redirectedUrl;
    private final Response response;
    private volatile State state;
    private Object unique;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CDNFetchDepender.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/forest/pollyfill/FetchTask$State;", "", "(Ljava/lang/String;I)V", "PENDING", "SUCCESS", "FAILURE", "CANCEL", "REDIRECTION", "INTERCEPT", "forest_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public enum State {
        PENDING,
        SUCCESS,
        FAILURE,
        CANCEL,
        REDIRECTION,
        INTERCEPT
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[State.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[State.SUCCESS.ordinal()] = 1;
            iArr[State.REDIRECTION.ordinal()] = 2;
        }
    }

    public void onPaused() {
    }

    public FetchTask(Forest forest, Response response, ForestPipelineContext forestPipelineContext) {
        Intrinsics.checkParameterIsNotNull(forest, "forest");
        Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
        Intrinsics.checkParameterIsNotNull(forestPipelineContext, "context");
        this.forest = forest;
        this.response = response;
        this.context = forestPipelineContext;
        this.state = State.PENDING;
        Request request = response.getRequest();
        boolean z = false;
        boolean z2 = request.getOnlyLocal() || (ThreadUtils.INSTANCE.isMainThread() && !request.getIsASync());
        this.onlyLocal = z2;
        if (!z2) {
            Request request2 = response.getRequest();
            if (request2.getOnlyOnline() || !request2.getEnableCDNCache()) {
                z = true;
            }
        }
        this.mustRevalidate = z;
    }

    public final Response getResponse() {
        return this.response;
    }

    public final void setUnique$forest_release(Object sign) {
        Intrinsics.checkParameterIsNotNull(sign, TicketGuardProviderKt.PATH_SIGN);
        this.unique = sign;
    }

    /* renamed from: getUnique$forest_release, reason: from getter */
    public final Object getUnique() {
        return this.unique;
    }

    public final boolean getOnlyLocal() {
        return this.onlyLocal;
    }

    public final boolean getMustRevalidate() {
        return this.mustRevalidate;
    }

    public final boolean registerSubTask$forest_release(FetchTask fetchTask) {
        Intrinsics.checkParameterIsNotNull(fetchTask, "fetchTask");
        if (Intrinsics.areEqual(fetchTask, this)) {
            ForestLogger.printOptimize$default(this.context.getLogger(), 6, TAG, true, null, null, new Function0<String>() { // from class: com.bytedance.forest.pollyfill.FetchTask$registerSubTask$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                public final String invoke() {
                    return "unexpected behavior: self-register on " + FetchTask.this.getResponse().getRequest().getUrl();
                }
            }, 24, null);
            return true;
        }
        this.hasSubTask = true;
        while (this.state == State.PENDING) {
            Thread.sleep(200L);
        }
        int i = WhenMappings.$EnumSwitchMapping$0[this.state.ordinal()];
        if (i != 1) {
            if (i == 2) {
                String str = this.redirectedUrl;
                if (str == null) {
                    str = "";
                }
                fetchTask.onRedirection$forest_release(str);
                return true;
            }
            ForestLogger.print$default(this.context.getLogger(), 6, CDNFetcher.TAG, "failed, state: " + this.state, false, null, null, 56, null);
            return false;
        }
        InMemoryBuffer inMemoryBuffer$forest_release = this.response.getInMemoryBuffer$forest_release();
        if (inMemoryBuffer$forest_release != null) {
            if (!(this.response.getIsSucceed() && inMemoryBuffer$forest_release.supportReuse())) {
                inMemoryBuffer$forest_release = null;
            }
            if (inMemoryBuffer$forest_release != null) {
                Response response = fetchTask.response;
                response.setHttpResponse(this.response.getHttpResponse());
                response.setHttpHeader(this.response.getHttpHeader());
                response.setDataType$forest_release(this.response.getDataType());
                response.setCharset$forest_release(this.response.getCharset());
                response.setVersion(this.response.getVersion());
                response.setImageReference$forest_release(this.response.getImageReference$forest_release());
                response.setInMemoryBuffer$forest_release(inMemoryBuffer$forest_release);
                response.setCache(true);
                response.setRedirection(this.response.getIsRedirection());
                response.setNegotiation(this.response.getIsNegotiation());
                response.setFilePath(this.response.getFilePath());
                ConcurrentHashMap<String, Long> performanceInfo$forest_release = this.context.getPerformanceInfo$forest_release();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry<String, Long> entry : performanceInfo$forest_release.entrySet()) {
                    String key = entry.getKey();
                    if (StringsKt.contains$default(key, "cdn_", false, 2, (Object) null) && !fetchTask.context.getPerformanceInfo$forest_release().containsKey(key)) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                    fetchTask.context.getPerformanceInfo$forest_release().put(entry2.getKey(), entry2.getValue());
                }
                fetchTask.context.getCdnHeadersInfo$forest_release().putAll(this.context.getCdnHeadersInfo$forest_release());
                if (response.getRequest().isWebRequest()) {
                    OfflineUtil offlineUtil = OfflineUtil.INSTANCE;
                    String dataType = this.response.getDataType();
                    String charset = this.response.getCharset();
                    InputStream provideInputStream = inMemoryBuffer$forest_release.provideInputStream(response);
                    String url = response.getRequest().getUrl();
                    ForestNetAPI.HttpResponse httpResponse = response.getHttpResponse();
                    response.setWebResourceResponseFromTTNet(offlineUtil.generateWebResourceResponse(dataType, charset, provideInputStream, url, httpResponse != null ? httpResponse.getResponseHttpHeader() : null));
                }
                fetchTask.onSuccess$forest_release();
                return true;
            }
        }
        ForestLogger.printOptimize$default(this.context.getLogger(), 6, TAG, true, null, null, new Function0<String>() { // from class: com.bytedance.forest.pollyfill.FetchTask$registerSubTask$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final String invoke() {
                return "cannot get corresponding forest buffer on response:" + FetchTask.this.getResponse();
            }
        }, 24, null);
        return false;
    }

    public final void cancel$forest_release() {
        if (this.hasSubTask) {
            return;
        }
        this.response.getRequest().getNetDepender$forest_release().cancel(this);
        onCanceled$forest_release();
    }

    public final void onStart(ForestNetAPI.HttpRequest httpRequest) {
        this.state = State.PENDING;
        this.redirectedUrl = null;
    }

    public void onRedirection$forest_release(String url) {
        Intrinsics.checkParameterIsNotNull(url, "url");
        this.redirectedUrl = url;
        this.state = State.REDIRECTION;
        this.unique = null;
    }

    public void onSuccess$forest_release() {
        ForestPipelineContext.recordPerformanceTiming$forest_release$default(this.context, new String[]{Timing.CDN_FINISH}, null, 2, null);
        this.state = State.SUCCESS;
        this.response.setSucceed(true);
        this.unique = null;
    }

    public void onFailure$forest_release(boolean shouldRetry, Throwable error) {
        Intrinsics.checkParameterIsNotNull(error, "error");
        ForestPipelineContext.recordPerformanceTiming$forest_release$default(this.context, new String[]{Timing.CDN_FINISH}, null, 2, null);
        this.state = State.FAILURE;
        this.unique = null;
    }

    public void onCanceled$forest_release() {
        this.state = State.CANCEL;
        this.unique = null;
    }

    public void onIntercept$forest_release() {
        this.state = State.INTERCEPT;
        this.unique = null;
    }
}
