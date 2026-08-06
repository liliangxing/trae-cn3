package com.bytedance.trae.network;

import android.os.Process;
import com.bytedance.ies.bullet.prefetchv2.PrefetchConfigKt;
import com.bytedance.push.interfaze.ISignalReportService;
import com.bytedance.push.model.HeadSetStatusExtraConfig;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Streaming;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.trae.platform.api.ISdkCommonHttp;
import com.bytedance.trae.utils.logger.FLogger;
import com.bytedance.ttnet.http.RequestContext;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.SupervisorKt;

/* compiled from: SseConnection.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 K2\u00020\u0001:\u0002KLB\u0007¢\u0006\u0004\b\u0002\u0010\u0003JN\u0010$\u001a\u00020\"2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020'2\u0006\u0010\b\u001a\u00020\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\n2\b\b\u0002\u0010(\u001a\u00020\u00052\b\b\u0002\u0010)\u001a\u00020\fJ\u0006\u0010*\u001a\u00020\u0018J\u000e\u0010+\u001a\u00020\"2\u0006\u0010\u0006\u001a\u00020\u0018J\u0006\u0010,\u001a\u00020\"J\u0006\u0010-\u001a\u00020\"J\u000e\u0010.\u001a\u00020\"2\u0006\u0010/\u001a\u00020\u0018J\u001a\u00100\u001a\u00020\"2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0 J\u001a\u00102\u001a\u00020\"2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0 J\u001a\u00103\u001a\u00020\"2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\"0 J\u001a\u00104\u001a\u00020\"2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\"0 J\u0006\u00105\u001a\u00020\u000eJ\u0006\u00106\u001a\u000207J\u0006\u00108\u001a\u00020'J\b\u00109\u001a\u00020\"H\u0002J\u000e\u0010:\u001a\u00020\"H\u0082@¢\u0006\u0002\u0010;J\u000e\u0010<\u001a\u000207H\u0082@¢\u0006\u0002\u0010;J\b\u0010=\u001a\u00020>H\u0002J \u0010?\u001a\u00020\"2\u0006\u0010@\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u0005H\u0002J\b\u0010C\u001a\u00020\u0005H\u0002J\b\u0010D\u001a\u00020\"H\u0002J\b\u0010E\u001a\u00020\"H\u0002J\b\u0010F\u001a\u00020\"H\u0002J\u0010\u0010G\u001a\u00020\u00182\u0006\u0010H\u001a\u00020'H\u0002J\u0010\u0010I\u001a\u00020\"2\u0006\u0010J\u001a\u00020\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u001e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0 0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010#\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\"0 0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lcom/bytedance/trae/network/SseConnection;", "", "<init>", "()V", "baseUrl", "", "frontierId", "Ljava/util/concurrent/atomic/AtomicLong;", "deviceId", "headers", "", "config", "Lcom/bytedance/trae/network/SseConfig;", "state", "Lcom/bytedance/trae/network/SseState;", "lastDownSeqId", "consecutiveFailures", "Ljava/util/concurrent/atomic/AtomicInteger;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "connectJob", "Lkotlinx/coroutines/Job;", "heartbeatWatchdogJob", "lastDataReceivedTime", "", "activeCall", "Lcom/bytedance/retrofit2/Call;", "Lcom/bytedance/retrofit2/mime/TypedInput;", "gson", "Lcom/google/gson/Gson;", "messageListeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lkotlin/Function1;", "Lcom/bytedance/trae/network/WsMessage;", "", "stateListeners", "setup", "userId", "appId", "", "appRuntimeType", "sseConfig", "getFrontierId", "updateFrontierId", "connect", HeadSetStatusExtraConfig.VALUE_DISCONNECT, "updateLastSeqId", "seqId", "registerMessageListener", "listener", "unregisterMessageListener", "registerStateListener", "unregisterStateListener", "getState", "isReallyAlive", "", "getConsecutiveFailures", "startConnection", "runSseLoop", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startSseStream", "createSseApi", "Lcom/bytedance/trae/network/SseConnection$SseApi;", "dispatchSseEvent", ISignalReportService.BODY_KEY_EVENT, "id", "data", "buildSseUrl", "startHeartbeatWatchdog", "stopHeartbeatWatchdog", "cancelActiveCall", "calculateBackoff", "failures", "updateState", "newState", "Companion", "SseApi", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class SseConnection {
    private static final String DEFAULT_SSE_EVENT = "message";
    private static final String TAG = "SseConnection";
    private volatile Call<TypedInput> activeCall;
    private Job connectJob;
    private Job heartbeatWatchdogJob;
    private volatile long lastDataReceivedTime;
    private String baseUrl = "";
    private final AtomicLong frontierId = new AtomicLong(0);
    private String deviceId = "";
    private Map<String, String> headers = MapsKt.emptyMap();
    private SseConfig config = new SseConfig(0, 0, 0, 0, 0, 31, null);
    private volatile SseState state = SseState.DISCONNECTED;
    private final AtomicLong lastDownSeqId = new AtomicLong(0);
    private final AtomicInteger consecutiveFailures = new AtomicInteger(0);
    private final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()).plus((CoroutineExceptionHandler) new SseConnection$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key)));
    private final Gson gson = new Gson();
    private final CopyOnWriteArraySet<Function1<WsMessage, Unit>> messageListeners = new CopyOnWriteArraySet<>();
    private final CopyOnWriteArraySet<Function1<SseState, Unit>> stateListeners = new CopyOnWriteArraySet<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SseConnection.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bb\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0001H'¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/network/SseConnection$SseApi;", "", "connectSse", "Lcom/bytedance/retrofit2/Call;", "Lcom/bytedance/retrofit2/mime/TypedInput;", "url", "", "extraInfo", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface SseApi {
        @GET
        @Streaming
        Call<TypedInput> connectSse(@Url String url, @ExtraInfo Object extraInfo);
    }

    public final void setup(String baseUrl, String userId, int appId, String deviceId, Map<String, String> headers, String appRuntimeType, SseConfig sseConfig) {
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(appRuntimeType, "appRuntimeType");
        Intrinsics.checkNotNullParameter(sseConfig, "sseConfig");
        this.baseUrl = baseUrl;
        this.frontierId.set(FrontierIdGenerator.INSTANCE.generateFrontierId(userId, appId, appRuntimeType, Process.myPid()));
        this.deviceId = deviceId;
        this.headers = headers;
        this.config = sseConfig;
    }

    public final long getFrontierId() {
        return this.frontierId.get();
    }

    public final void updateFrontierId(long frontierId) {
        long frontierId2 = getFrontierId();
        if (frontierId <= 0 || frontierId2 == frontierId) {
            return;
        }
        FLogger.INSTANCE.mo428i(TAG, "updateFrontierId: " + frontierId2 + " -> " + frontierId);
        this.frontierId.set(frontierId);
    }

    public final void connect() {
        if (this.state == SseState.CONNECTING || this.state == SseState.CONNECTED) {
            FLogger.INSTANCE.mo425d(TAG, "connect: already " + this.state + ", skip");
            return;
        }
        FLogger.INSTANCE.mo428i(TAG, "connect: starting SSE connection");
        this.consecutiveFailures.set(0);
        startConnection();
    }

    public final void disconnect() {
        FLogger.INSTANCE.mo428i(TAG, HeadSetStatusExtraConfig.VALUE_DISCONNECT);
        Job job = this.connectJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.connectJob = null;
        Job job2 = this.heartbeatWatchdogJob;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        this.heartbeatWatchdogJob = null;
        cancelActiveCall();
        updateState(SseState.DISCONNECTED);
    }

    public final void updateLastSeqId(long seqId) {
        if (seqId > this.lastDownSeqId.get()) {
            this.lastDownSeqId.set(seqId);
        }
    }

    public final void registerMessageListener(Function1<? super WsMessage, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.messageListeners.add(listener);
    }

    public final void unregisterMessageListener(Function1<? super WsMessage, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.messageListeners.remove(listener);
    }

    public final void registerStateListener(Function1<? super SseState, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.stateListeners.add(listener);
    }

    public final void unregisterStateListener(Function1<? super SseState, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.stateListeners.remove(listener);
    }

    public final SseState getState() {
        return this.state;
    }

    public final boolean isReallyAlive() {
        return this.state == SseState.CONNECTED && System.currentTimeMillis() - this.lastDataReceivedTime < this.config.getHeartbeatTimeoutMs();
    }

    public final int getConsecutiveFailures() {
        return this.consecutiveFailures.get();
    }

    private final void startConnection() {
        Job job = this.connectJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        cancelActiveCall();
        this.connectJob = BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new SseConnection$startConnection$1(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0058 A[Catch: all -> 0x0045, CancellationException -> 0x0047, TRY_ENTER, TryCatch #2 {CancellationException -> 0x0047, all -> 0x0045, blocks: (B:14:0x0058, B:18:0x0063, B:41:0x0041), top: B:40:0x0041 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0101 -> B:11:0x0104). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object runSseLoop(Continuation<? super Unit> continuation) {
        SseConnection$runSseLoop$1 sseConnection$runSseLoop$1;
        int i;
        SseConnection sseConnection;
        boolean z;
        if (continuation instanceof SseConnection$runSseLoop$1) {
            sseConnection$runSseLoop$1 = (SseConnection$runSseLoop$1) continuation;
            if ((sseConnection$runSseLoop$1.label & Integer.MIN_VALUE) != 0) {
                sseConnection$runSseLoop$1.label -= Integer.MIN_VALUE;
                Object obj = sseConnection$runSseLoop$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = sseConnection$runSseLoop$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    sseConnection = this;
                    if (JobKt.isActive(sseConnection$runSseLoop$1.getContext())) {
                    }
                    return Unit.INSTANCE;
                }
                if (i == 1) {
                    sseConnection = (SseConnection) sseConnection$runSseLoop$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (CancellationException e) {
                        throw e;
                    } catch (Throwable th) {
                        FLogger.INSTANCE.mo426e(TAG, "SSE stream error: " + th.getMessage());
                        z = false;
                    }
                    z = ((Boolean) obj).booleanValue();
                    if (JobKt.isActive(sseConnection$runSseLoop$1.getContext())) {
                    }
                    return Unit.INSTANCE;
                }
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                sseConnection = (SseConnection) sseConnection$runSseLoop$1.L$0;
                ResultKt.throwOnFailure(obj);
                sseConnection.updateState(SseState.CONNECTING);
                if (JobKt.isActive(sseConnection$runSseLoop$1.getContext())) {
                    sseConnection$runSseLoop$1.L$0 = sseConnection;
                    sseConnection$runSseLoop$1.label = 1;
                    obj = sseConnection.startSseStream(sseConnection$runSseLoop$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    z = ((Boolean) obj).booleanValue();
                    if (JobKt.isActive(sseConnection$runSseLoop$1.getContext())) {
                        if (z) {
                            sseConnection.consecutiveFailures.set(0);
                        } else {
                            Boxing.boxInt(sseConnection.consecutiveFailures.incrementAndGet());
                        }
                        sseConnection.updateState(SseState.DISCONNECTED);
                        sseConnection.stopHeartbeatWatchdog();
                        int i2 = sseConnection.consecutiveFailures.get();
                        if (i2 >= sseConnection.config.getMaxConsecutiveFailures()) {
                            FLogger.INSTANCE.mo430w(TAG, "runSseLoop: " + i2 + " consecutive failures, giving up");
                        } else {
                            long calculateBackoff = sseConnection.calculateBackoff(i2);
                            FLogger.INSTANCE.mo428i(TAG, "runSseLoop: reconnecting in " + calculateBackoff + "ms (attempt " + i2 + ')');
                            sseConnection$runSseLoop$1.L$0 = sseConnection;
                            sseConnection$runSseLoop$1.label = 2;
                            if (DelayKt.delay(calculateBackoff, sseConnection$runSseLoop$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            sseConnection.updateState(SseState.CONNECTING);
                            if (JobKt.isActive(sseConnection$runSseLoop$1.getContext())) {
                            }
                        }
                    }
                }
                return Unit.INSTANCE;
            }
        }
        sseConnection$runSseLoop$1 = new SseConnection$runSseLoop$1(this, continuation);
        Object obj2 = sseConnection$runSseLoop$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = sseConnection$runSseLoop$1.label;
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Not initialized variable reg: 10, insn: 0x01da: IF  (r10 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:99:0x01df, block:B:97:0x01da */
    public final Object startSseStream(Continuation<? super Boolean> continuation) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        boolean z;
        SsResponse<TypedInput> execute;
        String readLine;
        String buildSseUrl = buildSseUrl();
        FLogger.INSTANCE.mo428i(TAG, "startSseStream: " + buildSseUrl);
        SseApi createSseApi = createSseApi();
        RequestContext requestContext = new RequestContext();
        requestContext.timeout_connect = PrefetchConfigKt.DEFAULT_EXPIRE_MS;
        requestContext.timeout_read = 60000L;
        requestContext.timeout_write = PrefetchConfigKt.DEFAULT_EXPIRE_MS;
        requestContext.protect_timeout = 0L;
        requestContext.socket_connect_timeout = PrefetchConfigKt.DEFAULT_EXPIRE_MS;
        requestContext.socket_read_timeout = 60000L;
        requestContext.socket_write_timeout = PrefetchConfigKt.DEFAULT_EXPIRE_MS;
        Call<TypedInput> connectSse = createSseApi.connectSse(buildSseUrl, requestContext);
        this.activeCall = connectSse;
        boolean z2 = false;
        try {
            try {
                try {
                    execute = connectSse.execute();
                    Intrinsics.checkNotNullExpressionValue(execute, "execute(...)");
                } catch (Throwable th) {
                    th = th;
                    bufferedReader2 = null;
                }
                if (!execute.isSuccessful()) {
                    FLogger.INSTANCE.mo430w(TAG, "startSseStream: http code=" + execute.code());
                    Boolean boxBoolean = Boxing.boxBoolean(false);
                    if (Intrinsics.areEqual(this.activeCall, connectSse)) {
                        this.activeCall = null;
                    }
                    return boxBoolean;
                }
                TypedInput body = execute.body();
                if (body == null) {
                    FLogger.INSTANCE.mo430w(TAG, "startSseStream: response body is null");
                    Boolean boxBoolean2 = Boxing.boxBoolean(false);
                    if (Intrinsics.areEqual(this.activeCall, connectSse)) {
                        this.activeCall = null;
                    }
                    return boxBoolean2;
                }
                try {
                    updateState(SseState.CONNECTED);
                    this.consecutiveFailures.set(0);
                    this.lastDataReceivedTime = System.currentTimeMillis();
                    startHeartbeatWatchdog();
                    bufferedReader2 = new BufferedReader(new InputStreamReader(body.mo349in(), Charsets.UTF_8));
                    try {
                        StringBuilder sb = new StringBuilder();
                        String str = "";
                        String str2 = "message";
                        while (JobKt.isActive(continuation.getContext()) && (readLine = bufferedReader2.readLine()) != null) {
                            BufferedReader bufferedReader3 = bufferedReader2;
                            try {
                                this.lastDataReceivedTime = System.currentTimeMillis();
                                if (readLine.length() == 0) {
                                    String sb2 = sb.toString();
                                    Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
                                    dispatchSseEvent(str2, str, sb2);
                                    sb = new StringBuilder();
                                    str = "";
                                    str2 = "message";
                                } else if (StringsKt.startsWith$default(readLine, "event:", false, 2, (Object) null)) {
                                    str2 = StringsKt.trim(StringsKt.removePrefix(readLine, "event:")).toString();
                                } else if (StringsKt.startsWith$default(readLine, "id:", false, 2, (Object) null)) {
                                    str = StringsKt.trim(StringsKt.removePrefix(readLine, "id:")).toString();
                                } else if (StringsKt.startsWith$default(readLine, "data:", false, 2, (Object) null)) {
                                    if (sb.length() > 0) {
                                        sb.append("\n");
                                    }
                                    sb.append(StringsKt.trim(StringsKt.removePrefix(readLine, "data:")).toString());
                                } else {
                                    StringsKt.startsWith$default(readLine, ":", false, 2, (Object) null);
                                }
                                bufferedReader2 = bufferedReader3;
                            } catch (CancellationException e) {
                                throw e;
                            } catch (Throwable th2) {
                                th = th2;
                                bufferedReader2 = bufferedReader3;
                                z2 = true;
                                if (JobKt.isActive(continuation.getContext())) {
                                    FLogger.INSTANCE.mo426e(TAG, "startSseStream error: " + th.getMessage());
                                }
                                if (bufferedReader2 != null) {
                                    bufferedReader2.close();
                                }
                                if (Intrinsics.areEqual(this.activeCall, connectSse)) {
                                    this.activeCall = null;
                                }
                                z = z2;
                                return Boxing.boxBoolean(z);
                            }
                        }
                        bufferedReader2.close();
                        if (Intrinsics.areEqual(this.activeCall, connectSse)) {
                            this.activeCall = null;
                        }
                        z = true;
                    } catch (CancellationException e2) {
                        throw e2;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    bufferedReader2 = null;
                }
                return Boxing.boxBoolean(z);
            } catch (CancellationException e3) {
                throw e3;
            }
        } catch (Throwable th5) {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (Intrinsics.areEqual(this.activeCall, connectSse)) {
                this.activeCall = null;
            }
            throw th5;
        }
    }

    private final SseApi createSseApi() {
        Object create = RetrofitUtils.createSsRetrofit(this.baseUrl, CollectionsKt.listOf(new Interceptor() { // from class: com.bytedance.trae.network.SseConnection$$ExternalSyntheticLambda0
            @Override // com.bytedance.retrofit2.intercept.Interceptor
            public final SsResponse intercept(Interceptor.Chain chain) {
                SsResponse createSseApi$lambda$4;
                createSseApi$lambda$4 = SseConnection.createSseApi$lambda$4(SseConnection.this, chain);
                return createSseApi$lambda$4;
            }
        }), null).create(SseApi.class);
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        return (SseApi) create;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SsResponse createSseApi$lambda$4(SseConnection sseConnection, Interceptor.Chain chain) {
        Request request = chain.request();
        if (request == null) {
            return null;
        }
        List<Header> headers = request.getHeaders();
        Intrinsics.checkNotNullExpressionValue(headers, "getHeaders(...)");
        List<Header> mutableList = CollectionsKt.toMutableList(headers);
        mutableList.add(new Header("Accept", "text/event-stream"));
        mutableList.add(new Header(RetrofitUtils.HNAME_CACHE_CONTROL, "no-cache"));
        mutableList.add(new Header("x-ttnet-req-biz-id", "sse_connection"));
        String token = ISdkCommonHttp.INSTANCE.getToken();
        if (token.length() > 0) {
            mutableList.add(new Header("x-ide-token", token));
        }
        for (Map.Entry<String, String> entry : sseConnection.headers.entrySet()) {
            mutableList.add(new Header(entry.getKey(), entry.getValue()));
        }
        for (Map.Entry<String, String> entry2 : DebugSettings.INSTANCE.getCustomHeaders().entrySet()) {
            mutableList.add(new Header(entry2.getKey(), entry2.getValue()));
        }
        return chain.proceed(request.newBuilder().headers(mutableList).build());
    }

    private final void dispatchSseEvent(String event, String id, String data) {
        if ((data.length() == 0) && Intrinsics.areEqual(event, "message")) {
            return;
        }
        String str = event;
        String str2 = str.length() == 0 ? "message" : str;
        int hashCode = str2.hashCode();
        if (hashCode != 94756344) {
            if (hashCode != 200896764) {
                if (hashCode == 954925063 && str2.equals("message")) {
                    try {
                        FLogger.INSTANCE.mo425d(TAG, "dispatchSseEvent: message data=" + data);
                        WsMessage wsMessage = (WsMessage) this.gson.fromJson(data, WsMessage.class);
                        if (wsMessage == null) {
                            return;
                        }
                        Long longOrNull = StringsKt.toLongOrNull(id);
                        if (longOrNull == null) {
                            longOrNull = wsMessage.getDownSeqId();
                        }
                        Long l = longOrNull;
                        if (l != null) {
                            updateLastSeqId(l.longValue());
                        }
                        if (wsMessage.getDownSeqId() == null && l != null) {
                            wsMessage = WsMessage.copy$default(wsMessage, null, null, l, null, 11, null);
                        }
                        Iterator<T> it = this.messageListeners.iterator();
                        while (it.hasNext()) {
                            ((Function1) it.next()).invoke(wsMessage);
                        }
                        return;
                    } catch (Throwable th) {
                        FLogger.INSTANCE.mo426e(TAG, "dispatchSseEvent: parse message error: " + th.getMessage());
                        return;
                    }
                }
            } else if (str2.equals("heartbeat")) {
                FLogger.INSTANCE.mo425d(TAG, "dispatchSseEvent: heartbeat received");
                return;
            }
        } else if (str2.equals("close")) {
            FLogger.INSTANCE.mo428i(TAG, "dispatchSseEvent: close event, data=" + data);
            cancelActiveCall();
            return;
        }
        if (str.length() > 0) {
            FLogger.INSTANCE.mo425d(TAG, "dispatchSseEvent: unknown event=" + event);
        }
    }

    private final String buildSseUrl() {
        return StringsKt.trimEnd(this.baseUrl, new char[]{'/'}) + "/api/solo_hub/v1/wsmessages/sse/poll?frontier_id=" + getFrontierId() + "&device_id=" + this.deviceId + "&from_down_seq_id=" + this.lastDownSeqId.get();
    }

    private final void startHeartbeatWatchdog() {
        Job job = this.heartbeatWatchdogJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.heartbeatWatchdogJob = BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new SseConnection$startHeartbeatWatchdog$1(this, null), 3, (Object) null);
    }

    private final void stopHeartbeatWatchdog() {
        Job job = this.heartbeatWatchdogJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.heartbeatWatchdogJob = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cancelActiveCall() {
        try {
            Call<TypedInput> call = this.activeCall;
            if (call != null) {
                call.cancel();
            }
        } catch (Throwable unused) {
        }
        this.activeCall = null;
    }

    private final long calculateBackoff(int failures) {
        return Math.min(this.config.getReconnectBaseMs() * (1 << Math.min(failures, 15)), this.config.getReconnectMaxMs()) + ((long) (Math.random() * this.config.getReconnectJitterMs()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateState(SseState newState) {
        if (this.state == newState) {
            return;
        }
        SseState sseState = this.state;
        this.state = newState;
        FLogger.INSTANCE.mo428i(TAG, "state: " + sseState + " → " + newState);
        Iterator<T> it = this.stateListeners.iterator();
        while (it.hasNext()) {
            ((Function1) it.next()).invoke(newState);
        }
    }
}
