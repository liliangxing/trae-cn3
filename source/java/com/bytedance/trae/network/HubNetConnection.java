package com.bytedance.trae.network;

import android.os.Process;
import android.util.Base64;
import com.bytedance.apm.ApmAgent;
import com.bytedance.ies.xbridge.base.runtime.utils.XBridgeAPIRequestUtils;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.push.event.sync.ISignalReportConstants;
import com.bytedance.push.model.HeadSetStatusExtraConfig;
import com.bytedance.services.apm.api.EnsureManager;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.network.HubNetConnection;
import com.bytedance.trae.network.HubNetFallbackApi;
import com.bytedance.trae.network.RegisterAppApi;
import com.bytedance.trae.network.response.BizResponse;
import com.bytedance.trae.network.response.HttpDataResult;
import com.bytedance.trae.platform.api.ISdkCommonHttp;
import com.bytedance.trae.platform.service.ApplogService;
import com.bytedance.trae.utils.logger.FLogger;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;

/* compiled from: HubNetConnection.kt */
@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010 \n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ~2\u00020\u0001:\u0002~\u007fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J8\u00108\u001a\u0002052\u0006\u0010'\u001a\u00020(2\u0014\b\u0002\u0010)\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020+0*2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010,\u001a\u00020-J\u0016\u00109\u001a\u00020\r2\u0006\u0010'\u001a\u00020(H\u0082@¢\u0006\u0002\u0010:J1\u0010;\u001a\u0004\u0018\u00010\u00152\u0006\u0010'\u001a\u00020(2\b\u0010<\u001a\u0004\u0018\u00010+2\u0006\u0010=\u001a\u00020+2\u0006\u0010>\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0010?J\n\u0010@\u001a\u0004\u0018\u00010+H\u0002J\n\u0010A\u001a\u0004\u0018\u00010+H\u0002J\u001a\u0010B\u001a\u0002052\u0006\u0010C\u001a\u00020+2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010EJ\u0006\u0010F\u001a\u000205J\u0010\u0010G\u001a\u0002052\u0006\u0010C\u001a\u00020+H\u0002J\b\u0010H\u001a\u000205H\u0002J\u0010\u0010I\u001a\u0002052\u0006\u0010C\u001a\u00020+H\u0002J\u0010\u0010J\u001a\u0002052\u0006\u0010C\u001a\u00020+H\u0002J\u0010\u0010O\u001a\u0002052\u0006\u0010C\u001a\u00020+H\u0002J\u0010\u0010P\u001a\u0002052\u0006\u0010Q\u001a\u00020NH\u0002J\b\u0010R\u001a\u000205H\u0002J\b\u0010S\u001a\u000205H\u0002J\u001c\u0010T\u001a\u0002052\u0006\u0010U\u001a\u00020(2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010EH\u0002J\u000e\u0010V\u001a\u0002052\u0006\u0010C\u001a\u00020+J.\u0010W\u001a\u0002052\u0006\u0010X\u001a\u00020\u00032\u0006\u0010Y\u001a\u0002042\u0016\b\u0002\u0010Z\u001a\u0010\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020+\u0018\u00010*J\u000e\u0010[\u001a\u0002052\u0006\u0010D\u001a\u00020&J\u000e\u0010\\\u001a\u0002052\u0006\u0010D\u001a\u00020&J\u0010\u0010]\u001a\u0002052\u0006\u0010Q\u001a\u000207H\u0002J\u0010\u0010^\u001a\u0002052\u0006\u0010Y\u001a\u000204H\u0002J\u001e\u0010_\u001a\u0002052\f\u0010`\u001a\b\u0012\u0004\u0012\u00020L0a2\u0006\u0010b\u001a\u00020\rH\u0002J\u0016\u0010c\u001a\u0002052\u0006\u0010d\u001a\u00020\u0015H\u0082@¢\u0006\u0002\u0010eJ\u001e\u0010f\u001a\n\u0012\u0004\u0012\u00020L\u0018\u00010a2\u0006\u0010g\u001a\u00020\u0015H\u0082@¢\u0006\u0002\u0010eJ \u0010h\u001a\u0002052\u0006\u0010X\u001a\u00020\u00032\u0006\u0010i\u001a\u00020+2\u0006\u0010j\u001a\u00020\rH\u0002J\b\u0010k\u001a\u000205H\u0002J\b\u0010l\u001a\u000205H\u0002J\u000e\u0010m\u001a\u00020\rH\u0082@¢\u0006\u0002\u0010nJ\u001c\u0010o\u001a\u00020\r2\f\u0010`\u001a\b\u0012\u0004\u0012\u00020\u001d0aH\u0082@¢\u0006\u0002\u0010pJ\b\u0010q\u001a\u000205H\u0002J'\u0010r\u001a\u0002052\f\u0010`\u001a\b\u0012\u0004\u0012\u00020\u001d0a2\n\b\u0002\u0010s\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0002\u0010tJ\b\u0010u\u001a\u000205H\u0002J\u000f\u0010v\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0002\u0010wJ(\u0010x\u001a\u0002052\u0006\u0010y\u001a\u00020+2\n\b\u0002\u0010z\u001a\u0004\u0018\u00010{2\n\b\u0002\u0010|\u001a\u0004\u0018\u00010{H\u0002J(\u0010}\u001a\u0002052\u0006\u0010y\u001a\u00020+2\n\b\u0002\u0010z\u001a\u0004\u0018\u00010{2\n\b\u0002\u0010|\u001a\u0004\u0018\u00010{H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010)\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020+0*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010.\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020+0*8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\u0010\u00101\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00102\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020503X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00106\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020503X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010K\u001a\u000e\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020503X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010M\u001a\u000e\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u00020503X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0080\u0001"}, d2 = {"Lcom/bytedance/trae/network/HubNetConnection;", "", "channelId", "", "<init>", "(I)V", "frontier", "Lcom/bytedance/trae/network/FrontierConnection;", "gson", "Lcom/google/gson/Gson;", "sseConnection", "Lcom/bytedance/trae/network/SseConnection;", "isToB", "", "sseBackgroundRetryJob", "Lkotlinx/coroutines/Job;", "modeLock", "Ljava/util/concurrent/locks/ReentrantLock;", "transportMode", "Lcom/bytedance/trae/network/TransportMode;", "websocketGeneration", "", "frontierConnectTimeoutJob", "upSeqId", "Ljava/util/concurrent/atomic/AtomicLong;", "dispatchLock", "nextExpectedDownSeq", "pendingSendQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/bytedance/trae/network/HubNetConnection$PendingSend;", "pendingQueuePumpJob", "isFillingGap", "httpFlushJob", "httpPollJob", "scope", "Lkotlinx/coroutines/CoroutineScope;", "messageListeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/bytedance/trae/network/HubNetMessageListener;", "config", "Lcom/bytedance/trae/network/FrontierConfig;", "extraHeaders", "", "", "clientMetadata", "Lcom/bytedance/trae/network/HubClientMetadata;", "fallbackHeaders", "getFallbackHeaders", "()Ljava/util/Map;", "networkRecoveryJob", "frontierBytesListener", "Lkotlin/Function1;", "", "", "frontierStateListener", "Lcom/bytedance/trae/network/NetworkConnectState;", "setup", "registerApp", "(Lcom/bytedance/trae/network/FrontierConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRegisterFrontierId", "userId", "appRuntimeType", "processId", "(Lcom/bytedance/trae/network/FrontierConfig;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/Long;", "getRegisterUserId", "getEnterpriseUserIdFromToken", "connect", ISignalReportConstants.KEY_REASON, "listener", "Lcom/bytedance/trae/network/HubConnectionListener;", "checkAliveAndReconnect", "startFrontierConnect", "scheduleInitialFrontierConnectTimeout", "startConnectedTransport", "startForcedHttpFallback", "sseMessageListener", "Lcom/bytedance/trae/network/WsMessage;", "sseStateListener", "Lcom/bytedance/trae/network/SseState;", "startSseTransport", "handleSseStateChange", "state", "startSseBackgroundRetry", "stopSseTransport", "awaitNetworkRecoveryAndRetry", "cfg", HeadSetStatusExtraConfig.VALUE_DISCONNECT, "sendBytesToHub", "proto", "bytes", "headers", "registerMessageListener", "unregisterMessageListener", "handleFrontierStateChange", "handleFrontierMessage", "dispatch", "messages", "", "fromHttp", "fillGap", "fromSeq", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pollViaHttp", "fromDownSeqId", "dispatchToListeners", "data", "isConsecutiveSeq", "startHttpFallback", "stopHttpFallback", "flushPendingViaHttp", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pushMessagesViaHttp", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "drainPendingQueueViaFrontier", "reEnqueuePendingSends", "attemptGeneration", "(Ljava/util/List;Ljava/lang/Long;)V", "schedulePendingQueuePumpLocked", "getFrontierId", "()Ljava/lang/Long;", "monitorStatus", "status", "metric", "Lorg/json/JSONObject;", "extraLog", "monitorFillGap", "Companion", "PendingSend", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class HubNetConnection {
    private static final int FILL_GAP_BATCH_SIZE = 20;
    private static final int FLUSH_COUNT_THRESHOLD = 5;
    private static final long FLUSH_INTERVAL_MS = 1000;
    private static final long FRONTIER_CONNECT_TIMEOUT_MS = 15000;
    private static final long HTTP_BACKOFF_BASE_SECS = 3;
    private static final long HTTP_BACKOFF_MAX_SECS = 180;
    private static final String HUB_MONITOR_EVENT = "hub_connection_monitor";
    private static final long PENDING_QUEUE_RETRY_DELAY_MS = 1000;
    private static final long POLL_INTERVAL_MS = 3000;
    private static final long REGISTER_RETRY_EXPIRED_BACKOFF_SECS = 30;
    private static final long REGISTER_RETRY_INTERVAL_SECS = 2;
    private static final long REGISTER_RETRY_MAX_TOTAL_SECS = 180;
    private static final String TAG = "HubNetConnection";
    private final int channelId;
    private FrontierConfig config;
    private FrontierConnection frontier;
    private Job frontierConnectTimeoutJob;
    private Job httpFlushJob;
    private Job httpPollJob;
    private volatile boolean isFillingGap;
    private volatile boolean isToB;
    private Job networkRecoveryJob;
    private Job pendingQueuePumpJob;
    private Job sseBackgroundRetryJob;
    private SseConnection sseConnection;
    private long websocketGeneration;
    private final Gson gson = new Gson();
    private final ReentrantLock modeLock = new ReentrantLock();
    private volatile TransportMode transportMode = TransportMode.IDLE;
    private final AtomicLong upSeqId = new AtomicLong(0);
    private final ReentrantLock dispatchLock = new ReentrantLock();
    private long nextExpectedDownSeq = 1;
    private final ConcurrentLinkedQueue<PendingSend> pendingSendQueue = new ConcurrentLinkedQueue<>();
    private final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()).plus((CoroutineExceptionHandler) new HubNetConnection$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key)));
    private final CopyOnWriteArraySet<HubNetMessageListener> messageListeners = new CopyOnWriteArraySet<>();
    private Map<String, String> extraHeaders = MapsKt.emptyMap();
    private HubClientMetadata clientMetadata = HubClientMetadata.INSTANCE.fromSystem();
    private final Function1<byte[], Unit> frontierBytesListener = new Function1() { // from class: com.bytedance.trae.network.HubNetConnection$$ExternalSyntheticLambda2
        public final Object invoke(Object obj) {
            Unit frontierBytesListener$lambda$2;
            frontierBytesListener$lambda$2 = HubNetConnection.frontierBytesListener$lambda$2(HubNetConnection.this, (byte[]) obj);
            return frontierBytesListener$lambda$2;
        }
    };
    private final Function1<NetworkConnectState, Unit> frontierStateListener = new Function1() { // from class: com.bytedance.trae.network.HubNetConnection$$ExternalSyntheticLambda3
        public final Object invoke(Object obj) {
            Unit frontierStateListener$lambda$3;
            frontierStateListener$lambda$3 = HubNetConnection.frontierStateListener$lambda$3(HubNetConnection.this, (NetworkConnectState) obj);
            return frontierStateListener$lambda$3;
        }
    };
    private final Function1<WsMessage, Unit> sseMessageListener = new Function1() { // from class: com.bytedance.trae.network.HubNetConnection$$ExternalSyntheticLambda4
        public final Object invoke(Object obj) {
            Unit sseMessageListener$lambda$19;
            sseMessageListener$lambda$19 = HubNetConnection.sseMessageListener$lambda$19(HubNetConnection.this, (WsMessage) obj);
            return sseMessageListener$lambda$19;
        }
    };
    private final Function1<SseState, Unit> sseStateListener = new Function1() { // from class: com.bytedance.trae.network.HubNetConnection$$ExternalSyntheticLambda5
        public final Object invoke(Object obj) {
            Unit sseStateListener$lambda$20;
            sseStateListener$lambda$20 = HubNetConnection.sseStateListener$lambda$20(HubNetConnection.this, (SseState) obj);
            return sseStateListener$lambda$20;
        }
    };

    /* compiled from: HubNetConnection.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[SseState.values().length];
            try {
                iArr[SseState.CONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SseState.DISCONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SseState.CONNECTING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[TransportMode.values().length];
            try {
                iArr2[TransportMode.WEBSOCKET.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[TransportMode.SSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[TransportMode.HTTP_FALLBACK.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[TransportMode.IDLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[TransportMode.CONNECTING.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[TransportMode.SHUTDOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[NetworkConnectState.values().length];
            try {
                iArr3[NetworkConnectState.CONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr3[NetworkConnectState.DISCONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr3[NetworkConnectState.CONNECTING.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    public HubNetConnection(int i) {
        this.channelId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HubNetConnection.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u0015\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/bytedance/trae/network/HubNetConnection$PendingSend;", "", "message", "Lcom/bytedance/trae/network/WsMessage;", "bytes", "", "headers", "", "", "<init>", "(Lcom/bytedance/trae/network/WsMessage;[BLjava/util/Map;)V", "getMessage", "()Lcom/bytedance/trae/network/WsMessage;", "getBytes", "()[B", "getHeaders", "()Ljava/util/Map;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final /* data */ class PendingSend {
        private final byte[] bytes;
        private final Map<String, String> headers;
        private final WsMessage message;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PendingSend copy$default(PendingSend pendingSend, WsMessage wsMessage, byte[] bArr, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                wsMessage = pendingSend.message;
            }
            if ((i & 2) != 0) {
                bArr = pendingSend.bytes;
            }
            if ((i & 4) != 0) {
                map = pendingSend.headers;
            }
            return pendingSend.copy(wsMessage, bArr, map);
        }

        /* renamed from: component1, reason: from getter */
        public final WsMessage getMessage() {
            return this.message;
        }

        /* renamed from: component2, reason: from getter */
        public final byte[] getBytes() {
            return this.bytes;
        }

        public final Map<String, String> component3() {
            return this.headers;
        }

        public final PendingSend copy(WsMessage message, byte[] bytes, Map<String, String> headers) {
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(bytes, "bytes");
            Intrinsics.checkNotNullParameter(headers, "headers");
            return new PendingSend(message, bytes, headers);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PendingSend)) {
                return false;
            }
            PendingSend pendingSend = (PendingSend) other;
            return Intrinsics.areEqual(this.message, pendingSend.message) && Intrinsics.areEqual(this.bytes, pendingSend.bytes) && Intrinsics.areEqual(this.headers, pendingSend.headers);
        }

        public int hashCode() {
            return (((this.message.hashCode() * 31) + Arrays.hashCode(this.bytes)) * 31) + this.headers.hashCode();
        }

        public String toString() {
            return "PendingSend(message=" + this.message + ", bytes=" + Arrays.toString(this.bytes) + ", headers=" + this.headers + ')';
        }

        public PendingSend(WsMessage wsMessage, byte[] bArr, Map<String, String> map) {
            Intrinsics.checkNotNullParameter(wsMessage, "message");
            Intrinsics.checkNotNullParameter(bArr, "bytes");
            Intrinsics.checkNotNullParameter(map, "headers");
            this.message = wsMessage;
            this.bytes = bArr;
            this.headers = map;
        }

        public final WsMessage getMessage() {
            return this.message;
        }

        public final byte[] getBytes() {
            return this.bytes;
        }

        public final Map<String, String> getHeaders() {
            return this.headers;
        }
    }

    private final Map<String, String> getFallbackHeaders() {
        Map createMapBuilder = MapsKt.createMapBuilder();
        createMapBuilder.put(XBridgeAPIRequestUtils.CONTENT_TYPE, "application/json");
        createMapBuilder.putAll(this.extraHeaders);
        return MapsKt.build(createMapBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit frontierBytesListener$lambda$2(HubNetConnection hubNetConnection, byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        hubNetConnection.handleFrontierMessage(bArr);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit frontierStateListener$lambda$3(HubNetConnection hubNetConnection, NetworkConnectState networkConnectState) {
        Intrinsics.checkNotNullParameter(networkConnectState, "state");
        hubNetConnection.handleFrontierStateChange(networkConnectState);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setup$default(HubNetConnection hubNetConnection, FrontierConfig frontierConfig, Map map, boolean z, HubClientMetadata hubClientMetadata, int i, Object obj) {
        if ((i & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            hubClientMetadata = HubClientMetadata.INSTANCE.fromSystem();
        }
        hubNetConnection.setup(frontierConfig, map, z, hubClientMetadata);
    }

    public final void setup(FrontierConfig config, Map<String, String> extraHeaders, boolean isToB, HubClientMetadata clientMetadata) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(extraHeaders, "extraHeaders");
        Intrinsics.checkNotNullParameter(clientMetadata, "clientMetadata");
        FLogger.INSTANCE.mo428i(TAG, "setup: url=" + config.getUrl() + ", appId=" + config.getAppId() + ", isToB=" + isToB);
        this.config = config;
        this.extraHeaders = extraHeaders;
        this.isToB = isToB;
        this.clientMetadata = clientMetadata;
        if (isToB) {
            if (this.sseConnection == null) {
                this.sseConnection = new SseConnection();
            }
            String baseUrl = HostResolver.INSTANCE.getBaseUrl(HostType.f144AI);
            String registerUserId = getRegisterUserId();
            String str = registerUserId == null ? "" : registerUserId;
            int appId = config.getAppId();
            String deviceId = ApplogService.INSTANCE.getDeviceId();
            String str2 = deviceId == null ? "" : deviceId;
            Map createMapBuilder = MapsKt.createMapBuilder();
            createMapBuilder.putAll(extraHeaders);
            String token = ISdkCommonHttp.INSTANCE.getToken();
            if (token.length() > 0) {
                createMapBuilder.put("x-ide-token", token);
            }
            Map build = MapsKt.build(createMapBuilder);
            SseConnection sseConnection = this.sseConnection;
            if (sseConnection != null) {
                sseConnection.setup(baseUrl, str, appId, str2, build, (r28 & 32) != 0 ? FrontierIdGenerator.APP_RUNTIME_TYPE_ANDROID : FrontierIdGenerator.APP_RUNTIME_TYPE_TRAE, (r28 & 64) != 0 ? new SseConfig(0L, 0L, 0L, 0L, 0, 31, null) : null);
                return;
            }
            return;
        }
        if (this.frontier == null) {
            this.frontier = new FrontierConnection(this.channelId, null, 2, null);
        }
        FrontierConnection frontierConnection = this.frontier;
        if (frontierConnection != null) {
            frontierConnection.setup(config, extraHeaders, clientMetadata);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00d7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object registerApp(FrontierConfig frontierConfig, Continuation<? super Boolean> continuation) {
        HubNetConnection$registerApp$1 hubNetConnection$registerApp$1;
        int i;
        boolean z;
        Set<Long> default_success_codes;
        HubNetConnection hubNetConnection;
        HttpDataResult httpDataResult;
        SseConnection sseConnection;
        AppInfo app;
        if (continuation instanceof HubNetConnection$registerApp$1) {
            hubNetConnection$registerApp$1 = (HubNetConnection$registerApp$1) continuation;
            if ((hubNetConnection$registerApp$1.label & Integer.MIN_VALUE) != 0) {
                hubNetConnection$registerApp$1.label -= Integer.MIN_VALUE;
                Object obj = hubNetConnection$registerApp$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = hubNetConnection$registerApp$1.label;
                boolean z2 = false;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    String registerUserId = getRegisterUserId();
                    String deviceId = ApplogService.INSTANCE.getDeviceId();
                    String str = this.isToB ? FrontierIdGenerator.APP_RUNTIME_TYPE_TRAE : FrontierIdGenerator.APP_RUNTIME_TYPE_ANDROID;
                    int myPid = Process.myPid();
                    RegisterAppRequest buildRegisterAppRequest = HubNetConnectionKt.buildRegisterAppRequest(frontierConfig, this.isToB, deviceId, registerUserId, getRegisterFrontierId(frontierConfig, registerUserId, str, myPid), str, myPid, this.clientMetadata);
                    FLogger fLogger = FLogger.INSTANCE;
                    StringBuilder append = new StringBuilder("registerApp: appId=").append(frontierConfig.getAppId()).append(", isToB=").append(this.isToB).append(", hasUserId=");
                    if (registerUserId != null) {
                        if (registerUserId.length() > 0) {
                            z = true;
                            fLogger.mo428i(TAG, append.append(z).append(", appRuntimeType=").append(str).toString());
                            RegisterAppApi.Companion companion = RegisterAppApi.INSTANCE;
                            if (!this.isToB) {
                                default_success_codes = RegisterAppApi.INSTANCE.getTOB_REGISTER_SUCCESS_CODES();
                            } else {
                                default_success_codes = BizResponse.INSTANCE.getDEFAULT_SUCCESS_CODES();
                            }
                            hubNetConnection$registerApp$1.L$0 = this;
                            hubNetConnection$registerApp$1.label = 1;
                            obj = companion.safeCall(buildRegisterAppRequest, default_success_codes, hubNetConnection$registerApp$1);
                            if (obj != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            hubNetConnection = this;
                        }
                    }
                    z = false;
                    fLogger.mo428i(TAG, append.append(z).append(", appRuntimeType=").append(str).toString());
                    RegisterAppApi.Companion companion2 = RegisterAppApi.INSTANCE;
                    if (!this.isToB) {
                    }
                    hubNetConnection$registerApp$1.L$0 = this;
                    hubNetConnection$registerApp$1.label = 1;
                    obj = companion2.safeCall(buildRegisterAppRequest, default_success_codes, hubNetConnection$registerApp$1);
                    if (obj != coroutine_suspended) {
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    HubNetConnection hubNetConnection2 = (HubNetConnection) hubNetConnection$registerApp$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    hubNetConnection = hubNetConnection2;
                }
                httpDataResult = (HttpDataResult) obj;
                if (!(httpDataResult instanceof HttpDataResult.Success)) {
                    if (!hubNetConnection.isToB) {
                        FLogger.INSTANCE.mo428i(TAG, "registerApp success");
                        return Boxing.boxBoolean(true);
                    }
                    HttpDataResult.Success success = (HttpDataResult.Success) httpDataResult;
                    if (!success.getBizResp().isSuccess()) {
                        FLogger fLogger2 = FLogger.INSTANCE;
                        StringBuilder append2 = new StringBuilder("registerApp failed: code=").append(success.getBizResp().getCode()).append(", message=");
                        String message = success.getBizResp().getMessage();
                        if (message == null) {
                            message = success.getBizResp().getMsg();
                        }
                        fLogger2.mo430w(TAG, append2.append(message).toString());
                        monitorStatus$default(hubNetConnection, "registerAppFailed", null, null, 6, null);
                        return Boxing.boxBoolean(false);
                    }
                    RegisterAppResponse registerAppResponse = (RegisterAppResponse) success.getBizResp().getData();
                    Long frontierId = (registerAppResponse == null || (app = registerAppResponse.getApp()) == null) ? null : app.getFrontierId();
                    if (hubNetConnection.isToB && frontierId != null && frontierId.longValue() > 0 && (sseConnection = hubNetConnection.sseConnection) != null) {
                        sseConnection.updateFrontierId(frontierId.longValue());
                    }
                    FLogger.INSTANCE.mo428i(TAG, "registerApp success, serverFrontierId=" + frontierId);
                    z2 = true;
                } else {
                    if (!(httpDataResult instanceof HttpDataResult.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    FLogger.INSTANCE.mo430w(TAG, "registerApp failed: " + httpDataResult);
                    monitorStatus$default(hubNetConnection, "registerAppFailed", null, null, 6, null);
                }
                return Boxing.boxBoolean(z2);
            }
        }
        hubNetConnection$registerApp$1 = new HubNetConnection$registerApp$1(this, continuation);
        Object obj2 = hubNetConnection$registerApp$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = hubNetConnection$registerApp$1.label;
        boolean z22 = false;
        if (i != 0) {
        }
        httpDataResult = (HttpDataResult) obj2;
        if (!(httpDataResult instanceof HttpDataResult.Success)) {
        }
        return Boxing.boxBoolean(z22);
    }

    private final Long getRegisterFrontierId(FrontierConfig config, String userId, String appRuntimeType, int processId) {
        if (!this.isToB) {
            return getFrontierId();
        }
        if (userId == null) {
            userId = ApplogService.INSTANCE.getUserID();
            if (!(!StringsKt.isBlank(userId))) {
                userId = null;
            }
            if (userId == null) {
                return null;
            }
        }
        return Long.valueOf(FrontierIdGenerator.INSTANCE.generateFrontierId(userId, config.getAppId(), appRuntimeType, processId));
    }

    private final String getRegisterUserId() {
        String str = this.extraHeaders.get("user_id");
        if (str == null || !(!StringsKt.isBlank(str))) {
            str = null;
        }
        if (!this.isToB) {
            return str;
        }
        String enterpriseUserIdFromToken = getEnterpriseUserIdFromToken();
        if (enterpriseUserIdFromToken != null) {
            return enterpriseUserIdFromToken;
        }
        if (str == null) {
            str = ApplogService.INSTANCE.getUserID();
            if (!(!StringsKt.isBlank(str))) {
                return null;
            }
        }
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x007e, code lost:
    
        if ((!kotlin.text.StringsKt.isBlank(r1)) != false) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String getEnterpriseUserIdFromToken() {
        Object obj;
        Throwable th;
        String str;
        String optString;
        String token = ISdkCommonHttp.INSTANCE.getToken();
        if (!(!StringsKt.isBlank(token))) {
            token = null;
        }
        if (token == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            HubNetConnection hubNetConnection = this;
            str = (String) CollectionsKt.getOrNull(StringsKt.split$default(token, new String[]{LibrarianImpl.Constants.DOT}, false, 0, 6, (Object) null), 1);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th2));
        }
        if (str != null) {
            byte[] decode = Base64.decode(str, 11);
            Intrinsics.checkNotNull(decode);
            JSONObject optJSONObject = new JSONObject(new String(decode, Charsets.UTF_8)).optJSONObject("data");
            if (optJSONObject != null) {
                optString = optJSONObject.optString("user_id");
                Intrinsics.checkNotNull(optString);
                if (!(!StringsKt.isBlank(optString))) {
                    optString = null;
                }
                if (optString == null) {
                    optString = optJSONObject.optString("id");
                    Intrinsics.checkNotNull(optString);
                }
                obj = Result.constructor-impl(optString);
                th = Result.exceptionOrNull-impl(obj);
                if (th != null) {
                    FLogger.INSTANCE.mo430w(TAG, "getEnterpriseUserIdFromToken failed: " + th.getMessage());
                }
                return (String) (Result.isFailure-impl(obj) ? null : obj);
            }
        }
        optString = null;
        obj = Result.constructor-impl(optString);
        th = Result.exceptionOrNull-impl(obj);
        if (th != null) {
        }
        return (String) (Result.isFailure-impl(obj) ? null : obj);
    }

    public static /* synthetic */ void connect$default(HubNetConnection hubNetConnection, String str, HubConnectionListener hubConnectionListener, int i, Object obj) {
        if ((i & 2) != 0) {
            hubConnectionListener = null;
        }
        hubNetConnection.connect(str, hubConnectionListener);
    }

    public final void connect(String reason, HubConnectionListener listener) {
        Intrinsics.checkNotNullParameter(reason, ISignalReportConstants.KEY_REASON);
        FLogger.INSTANCE.mo428i(TAG, "connect: reason=" + reason);
        FrontierConfig frontierConfig = this.config;
        if (frontierConfig == null) {
            FLogger.INSTANCE.mo430w(TAG, "connect: config is null, call setup() first");
            return;
        }
        if (!FrontierSwitchConfig.INSTANCE.isDisabled()) {
            ReentrantLock reentrantLock = this.modeLock;
            reentrantLock.lock();
            try {
                if (this.transportMode == TransportMode.SHUTDOWN) {
                    this.transportMode = TransportMode.IDLE;
                }
                Unit unit = Unit.INSTANCE;
            } finally {
                reentrantLock.unlock();
            }
        }
        BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new HubNetConnection$connect$2(this, reason, frontierConfig, listener, null), 3, (Object) null);
    }

    public final void checkAliveAndReconnect() {
        BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new HubNetConnection$checkAliveAndReconnect$1(this, null), 3, (Object) null);
    }

    private final void startFrontierConnect(String reason) {
        ReentrantLock reentrantLock = this.modeLock;
        reentrantLock.lock();
        try {
            if (this.transportMode == TransportMode.SHUTDOWN) {
                FLogger.INSTANCE.mo430w(TAG, "startFrontierConnect: already SHUTDOWN, skip");
                return;
            }
            if (this.transportMode == TransportMode.IDLE) {
                this.transportMode = TransportMode.CONNECTING;
            }
            FrontierConnection frontierConnection = this.frontier;
            if (frontierConnection != null) {
                frontierConnection.registerBytesListener(this.channelId, this.frontierBytesListener);
            }
            FrontierConnection frontierConnection2 = this.frontier;
            if (frontierConnection2 != null) {
                frontierConnection2.registerStateListener(this.frontierStateListener);
            }
            FrontierConnection frontierConnection3 = this.frontier;
            if (frontierConnection3 != null) {
                frontierConnection3.connect(reason);
            }
            scheduleInitialFrontierConnectTimeout();
        } finally {
            reentrantLock.unlock();
        }
    }

    private final void scheduleInitialFrontierConnectTimeout() {
        ReentrantLock reentrantLock = this.modeLock;
        reentrantLock.lock();
        try {
            Job job = this.frontierConnectTimeoutJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.frontierConnectTimeoutJob = BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new HubNetConnection$scheduleInitialFrontierConnectTimeout$1$1(this, null), 3, (Object) null);
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startConnectedTransport(String reason) {
        if (E2ENetworkOverrides.INSTANCE.isHubHttpFallbackForced()) {
            startForcedHttpFallback(reason);
        } else if (this.isToB) {
            startSseTransport(reason);
        } else {
            startFrontierConnect(reason);
        }
    }

    private final void startForcedHttpFallback(String reason) {
        ReentrantLock reentrantLock = this.modeLock;
        reentrantLock.lock();
        try {
            if (this.transportMode == TransportMode.SHUTDOWN) {
                FLogger.INSTANCE.mo430w(TAG, "startForcedHttpFallback: already SHUTDOWN, skip");
                return;
            }
            FLogger.INSTANCE.mo428i(TAG, "startForcedHttpFallback: reason=" + reason);
            FrontierConnection frontierConnection = this.frontier;
            if (frontierConnection != null) {
                frontierConnection.unregisterBytesListener(this.channelId, this.frontierBytesListener);
            }
            FrontierConnection frontierConnection2 = this.frontier;
            if (frontierConnection2 != null) {
                frontierConnection2.unregisterStateListener(this.frontierStateListener);
            }
            stopHttpFallback();
            this.transportMode = TransportMode.HTTP_FALLBACK;
            startHttpFallback();
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sseMessageListener$lambda$19(HubNetConnection hubNetConnection, WsMessage wsMessage) {
        Intrinsics.checkNotNullParameter(wsMessage, "msg");
        hubNetConnection.dispatch(CollectionsKt.listOf(wsMessage), true);
        Long downSeqId = wsMessage.getDownSeqId();
        if (downSeqId != null) {
            long longValue = downSeqId.longValue();
            SseConnection sseConnection = hubNetConnection.sseConnection;
            if (sseConnection != null) {
                sseConnection.updateLastSeqId(longValue);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sseStateListener$lambda$20(HubNetConnection hubNetConnection, SseState sseState) {
        Intrinsics.checkNotNullParameter(sseState, "state");
        hubNetConnection.handleSseStateChange(sseState);
        return Unit.INSTANCE;
    }

    private final void startSseTransport(String reason) {
        ReentrantLock reentrantLock = this.modeLock;
        reentrantLock.lock();
        try {
            if (this.transportMode == TransportMode.SHUTDOWN) {
                FLogger.INSTANCE.mo430w(TAG, "startSseTransport: already SHUTDOWN, skip");
                return;
            }
            FLogger.INSTANCE.mo428i(TAG, "startSseTransport: reason=" + reason);
            SseConnection sseConnection = this.sseConnection;
            if (sseConnection != null) {
                sseConnection.registerMessageListener(this.sseMessageListener);
            }
            SseConnection sseConnection2 = this.sseConnection;
            if (sseConnection2 != null) {
                sseConnection2.registerStateListener(this.sseStateListener);
            }
            SseConnection sseConnection3 = this.sseConnection;
            if (sseConnection3 != null) {
                sseConnection3.connect();
            }
            this.transportMode = TransportMode.SSE;
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    private final void handleSseStateChange(SseState state) {
        FLogger.INSTANCE.mo428i(TAG, "sseStateChange: " + state + ", currentMode=" + this.transportMode);
        int i = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
        if (i == 1) {
            ReentrantLock reentrantLock = this.modeLock;
            reentrantLock.lock();
            try {
                if (this.transportMode == TransportMode.HTTP_FALLBACK) {
                    FLogger.INSTANCE.mo428i(TAG, "SSE connected, switching HTTP_FALLBACK → SSE");
                    stopHttpFallback();
                    this.transportMode = TransportMode.SSE;
                }
                Unit unit = Unit.INSTANCE;
                reentrantLock.unlock();
                Job job = this.sseBackgroundRetryJob;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                this.sseBackgroundRetryJob = null;
                monitorStatus$default(this, "SseConnected", null, null, 6, null);
                return;
            } finally {
            }
        }
        if (i != 2) {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            return;
        }
        SseConnection sseConnection = this.sseConnection;
        int consecutiveFailures = sseConnection != null ? sseConnection.getConsecutiveFailures() : 0;
        if (consecutiveFailures >= new SseConfig(0L, 0L, 0L, 0L, 0, 31, null).getMaxConsecutiveFailures()) {
            this.modeLock.lock();
            try {
                if (this.transportMode == TransportMode.SSE) {
                    FLogger.INSTANCE.mo430w(TAG, "SSE degrading to HTTP_FALLBACK after " + consecutiveFailures + " failures");
                    this.transportMode = TransportMode.HTTP_FALLBACK;
                    startHttpFallback();
                    startSseBackgroundRetry();
                    monitorStatus$default(this, "SseDegradedToHttp", null, null, 6, null);
                }
                Unit unit2 = Unit.INSTANCE;
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startSseBackgroundRetry() {
        Job job = this.sseBackgroundRetryJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.sseBackgroundRetryJob = BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new HubNetConnection$startSseBackgroundRetry$1(this, null), 3, (Object) null);
    }

    private final void stopSseTransport() {
        SseConnection sseConnection = this.sseConnection;
        if (sseConnection != null) {
            sseConnection.unregisterMessageListener(this.sseMessageListener);
        }
        SseConnection sseConnection2 = this.sseConnection;
        if (sseConnection2 != null) {
            sseConnection2.unregisterStateListener(this.sseStateListener);
        }
        SseConnection sseConnection3 = this.sseConnection;
        if (sseConnection3 != null) {
            sseConnection3.disconnect();
        }
        Job job = this.sseBackgroundRetryJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.sseBackgroundRetryJob = null;
    }

    static /* synthetic */ void awaitNetworkRecoveryAndRetry$default(HubNetConnection hubNetConnection, FrontierConfig frontierConfig, HubConnectionListener hubConnectionListener, int i, Object obj) {
        if ((i & 2) != 0) {
            hubConnectionListener = null;
        }
        hubNetConnection.awaitNetworkRecoveryAndRetry(frontierConfig, hubConnectionListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void awaitNetworkRecoveryAndRetry(FrontierConfig cfg, HubConnectionListener listener) {
        Job job = this.networkRecoveryJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.networkRecoveryJob = BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new HubNetConnection$awaitNetworkRecoveryAndRetry$1(this, cfg, listener, null), 3, (Object) null);
    }

    public final void disconnect(String reason) {
        Intrinsics.checkNotNullParameter(reason, ISignalReportConstants.KEY_REASON);
        FLogger.INSTANCE.mo428i(TAG, "disconnect: reason=" + reason);
        ReentrantLock reentrantLock = this.modeLock;
        reentrantLock.lock();
        try {
            this.transportMode = TransportMode.SHUTDOWN;
            Job job = this.frontierConnectTimeoutJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.frontierConnectTimeoutJob = null;
            Job job2 = this.pendingQueuePumpJob;
            if (job2 != null) {
                Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
            }
            this.pendingQueuePumpJob = null;
            try {
                Job job3 = this.networkRecoveryJob;
                if (job3 != null) {
                    Job.DefaultImpls.cancel$default(job3, (CancellationException) null, 1, (Object) null);
                }
                this.networkRecoveryJob = null;
            } catch (Throwable unused) {
                EnsureManager.ensureNotReachHere();
            }
            stopHttpFallback();
            if (this.isToB) {
                stopSseTransport();
                Unit unit = Unit.INSTANCE;
            } else {
                FrontierConnection frontierConnection = this.frontier;
                if (frontierConnection != null) {
                    frontierConnection.unregisterBytesListener(this.channelId, this.frontierBytesListener);
                }
                FrontierConnection frontierConnection2 = this.frontier;
                if (frontierConnection2 != null) {
                    frontierConnection2.unregisterStateListener(this.frontierStateListener);
                }
                FrontierConnection frontierConnection3 = this.frontier;
                if (frontierConnection3 != null) {
                    frontierConnection3.disconnect(reason);
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void sendBytesToHub$default(HubNetConnection hubNetConnection, int i, byte[] bArr, Map map, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        hubNetConnection.sendBytesToHub(i, bArr, map);
    }

    public final void sendBytesToHub(int proto, byte[] bytes, Map<String, String> headers) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        final long incrementAndGet = this.upSeqId.incrementAndGet();
        WsMessage wsMessage = new WsMessage(Integer.valueOf(proto), Long.valueOf(incrementAndGet), null, new String(bytes, Charsets.UTF_8), 4, null);
        byte[] copyOf = Arrays.copyOf(bytes, bytes.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        final PendingSend pendingSend = new PendingSend(wsMessage, copyOf, MapsKt.toMap(headers == null ? MapsKt.emptyMap() : headers));
        ReentrantLock reentrantLock = this.modeLock;
        reentrantLock.lock();
        try {
            switch (WhenMappings.$EnumSwitchMapping$1[this.transportMode.ordinal()]) {
                case 1:
                    if (!this.pendingSendQueue.isEmpty()) {
                        FLogger.INSTANCE.mo425d(TAG, "sendBytesToHub[WS]: queue not empty(" + this.pendingSendQueue.size() + "), enqueue upSeq=" + incrementAndGet);
                        this.pendingSendQueue.offer(pendingSend);
                        drainPendingQueueViaFrontier();
                        if (this.pendingSendQueue.size() >= 5) {
                            FLogger.INSTANCE.mo425d(TAG, "sendBytesToHub[WS]: queue(" + this.pendingSendQueue.size() + ") >= threshold, fallback to HTTP flush");
                            BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new HubNetConnection$sendBytesToHub$1$1(this, null), 3, (Object) null);
                            break;
                        }
                    } else {
                        final long j = this.websocketGeneration;
                        FrontierConnection frontierConnection = this.frontier;
                        if (frontierConnection == null) {
                            FLogger.INSTANCE.mo430w(TAG, "sendBytesToHub[WS]: frontier missing, enqueue upSeq=" + incrementAndGet);
                            this.pendingSendQueue.offer(pendingSend);
                            schedulePendingQueuePumpLocked();
                            break;
                        } else {
                            frontierConnection.sendBytes(this.channelId, pendingSend.getBytes(), pendingSend.getHeaders(), new Function1() { // from class: com.bytedance.trae.network.HubNetConnection$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj) {
                                    Unit sendBytesToHub$lambda$26$lambda$25;
                                    sendBytesToHub$lambda$26$lambda$25 = HubNetConnection.sendBytesToHub$lambda$26$lambda$25(incrementAndGet, this, pendingSend, j, ((Boolean) obj).booleanValue());
                                    return sendBytesToHub$lambda$26$lambda$25;
                                }
                            });
                            break;
                        }
                    }
                    break;
                case 2:
                    FLogger.INSTANCE.mo425d(TAG, "sendBytesToHub[SSE]: enqueue upSeq=" + incrementAndGet + ", queueSize=" + (this.pendingSendQueue.size() + 1));
                    this.pendingSendQueue.offer(pendingSend);
                    BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new HubNetConnection$sendBytesToHub$1$3(this, null), 3, (Object) null);
                    break;
                case 3:
                    FLogger.INSTANCE.mo425d(TAG, "sendBytesToHub[HTTP]: enqueue upSeq=" + incrementAndGet + ", queueSize=" + (this.pendingSendQueue.size() + 1));
                    this.pendingSendQueue.offer(pendingSend);
                    if (this.pendingSendQueue.size() >= 5) {
                        BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new HubNetConnection$sendBytesToHub$1$4(this, null), 3, (Object) null);
                        break;
                    }
                    break;
                case 4:
                case 5:
                    FLogger.INSTANCE.mo425d(TAG, "sendBytesToHub[" + this.transportMode + "]: buffering upSeq=" + incrementAndGet + ", queueSize=" + (this.pendingSendQueue.size() + 1));
                    this.pendingSendQueue.offer(pendingSend);
                    break;
                case 6:
                    FLogger.INSTANCE.mo430w(TAG, "sendBytesToHub: SHUTDOWN, ignoring upSeq=" + incrementAndGet);
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sendBytesToHub$lambda$26$lambda$25(long j, HubNetConnection hubNetConnection, PendingSend pendingSend, long j2, boolean z) {
        if (!z) {
            FLogger.INSTANCE.mo430w(TAG, "sendBytesToHub[WS]: frontier send failed, enqueue upSeq=" + j);
            hubNetConnection.reEnqueuePendingSends(CollectionsKt.listOf(pendingSend), Long.valueOf(j2));
        }
        return Unit.INSTANCE;
    }

    public final void registerMessageListener(HubNetMessageListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.messageListeners) {
            if (this.messageListeners.contains(listener)) {
                return;
            }
            this.messageListeners.add(listener);
        }
    }

    public final void unregisterMessageListener(HubNetMessageListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.messageListeners) {
            this.messageListeners.remove(listener);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x004c. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void handleFrontierStateChange(NetworkConnectState state) {
        FLogger.INSTANCE.mo428i(TAG, "frontierStateChange: " + state + ", currentMode=" + this.transportMode);
        int i = WhenMappings.$EnumSwitchMapping$2[state.ordinal()];
        boolean z = true;
        if (i == 1) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("transportMode", this.transportMode.name());
                monitorStatus("FrontierConnected", null, jSONObject);
            } catch (Throwable unused) {
            }
            this.modeLock.lock();
            try {
                switch (WhenMappings.$EnumSwitchMapping$1[this.transportMode.ordinal()]) {
                    case 1:
                    case 3:
                    case 4:
                    case 5:
                        FLogger.INSTANCE.mo428i(TAG, "Frontier connected, switching " + this.transportMode + " → WEBSOCKET");
                        if (this.transportMode == TransportMode.HTTP_FALLBACK) {
                            stopHttpFallback();
                        }
                        Job job = this.frontierConnectTimeoutJob;
                        if (job != null) {
                            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                        }
                        this.frontierConnectTimeoutJob = null;
                        Job job2 = this.pendingQueuePumpJob;
                        if (job2 != null) {
                            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
                        }
                        this.pendingQueuePumpJob = null;
                        this.transportMode = TransportMode.WEBSOCKET;
                        this.websocketGeneration++;
                        drainPendingQueueViaFrontier();
                        break;
                    case 2:
                    case 6:
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                Unit unit = Unit.INSTANCE;
                return;
            } finally {
            }
        }
        if (i == 2) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("transportMode", this.transportMode.name());
                monitorStatus("FrontierDisconnected", null, jSONObject2);
            } catch (Throwable unused2) {
            }
            this.modeLock.lock();
            try {
                switch (WhenMappings.$EnumSwitchMapping$1[this.transportMode.ordinal()]) {
                    case 1:
                    case 4:
                    case 5:
                        FLogger.INSTANCE.mo430w(TAG, "Frontier disconnected, switching " + this.transportMode + " → HTTP_FALLBACK");
                        Job job3 = this.frontierConnectTimeoutJob;
                        if (job3 != null) {
                            Job.DefaultImpls.cancel$default(job3, (CancellationException) null, 1, (Object) null);
                        }
                        this.frontierConnectTimeoutJob = null;
                        Job job4 = this.pendingQueuePumpJob;
                        if (job4 != null) {
                            Job.DefaultImpls.cancel$default(job4, (CancellationException) null, 1, (Object) null);
                        }
                        this.pendingQueuePumpJob = null;
                        this.transportMode = TransportMode.HTTP_FALLBACK;
                        startHttpFallback();
                        break;
                    case 2:
                    case 3:
                    case 6:
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                Unit unit2 = Unit.INSTANCE;
                return;
            } finally {
            }
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        this.modeLock.lock();
        try {
            switch (WhenMappings.$EnumSwitchMapping$1[this.transportMode.ordinal()]) {
                case 1:
                    FLogger.INSTANCE.mo430w(TAG, "Frontier reconnecting, switching WEBSOCKET → HTTP_FALLBACK");
                    Job job5 = this.pendingQueuePumpJob;
                    if (job5 != null) {
                        Job.DefaultImpls.cancel$default(job5, (CancellationException) null, 1, (Object) null);
                    }
                    this.pendingQueuePumpJob = null;
                    this.transportMode = TransportMode.HTTP_FALLBACK;
                    startHttpFallback();
                case 2:
                case 3:
                case 5:
                case 6:
                    z = false;
                    Unit unit3 = Unit.INSTANCE;
                    if (z) {
                        return;
                    }
                    scheduleInitialFrontierConnectTimeout();
                    return;
                case 4:
                    this.transportMode = TransportMode.CONNECTING;
                    Unit unit32 = Unit.INSTANCE;
                    if (z) {
                    }
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        } finally {
        }
    }

    private final void handleFrontierMessage(byte[] bytes) {
        try {
            WsMessage wsMessage = (WsMessage) this.gson.fromJson(new String(bytes, Charsets.UTF_8), WsMessage.class);
            if (wsMessage == null) {
                return;
            }
            dispatch(CollectionsKt.listOf(wsMessage), false);
        } catch (Throwable th) {
            FLogger.INSTANCE.mo426e(TAG, "handleFrontierMessage error: " + th);
            EnsureManager.ensureNotReachHere();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatch(List<WsMessage> messages, boolean fromHttp) {
        ReentrantLock reentrantLock = this.dispatchLock;
        reentrantLock.lock();
        String str = fromHttp ? "HTTP" : "Frontier";
        try {
            ArrayList arrayList = new ArrayList();
            for (Object obj : messages) {
                Long downSeqId = ((WsMessage) obj).getDownSeqId();
                if ((downSeqId != null ? downSeqId.longValue() : 0L) >= this.nextExpectedDownSeq) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = arrayList;
            int size = messages.size() - arrayList2.size();
            if (size > 0) {
                monitorStatus$default(this, "DropMessage", null, null, 6, null);
                FLogger.INSTANCE.mo425d(TAG, "dispatch[" + str + "]: dropped " + size + " dup msgs (< expected=" + this.nextExpectedDownSeq + ')');
            }
            Iterator it = arrayList2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WsMessage wsMessage = (WsMessage) it.next();
                Long downSeqId2 = wsMessage.getDownSeqId();
                Integer proto = wsMessage.getProto();
                if (proto != null) {
                    int intValue = proto.intValue();
                    String data = wsMessage.getData();
                    if (data != null) {
                        if (downSeqId2 == null) {
                            FLogger.INSTANCE.mo430w(TAG, "dispatch[" + str + "]: msg with null downSeqId");
                            monitorStatus$default(this, "SeqNull", null, null, 6, null);
                            dispatchToListeners(intValue, data, false);
                        } else {
                            FLogger.INSTANCE.mo428i(TAG, "dispatch[" + str + "]: msg =" + wsMessage);
                            if (downSeqId2.longValue() == this.nextExpectedDownSeq) {
                                if (AppHost.Companion.isDebug()) {
                                    FLogger.INSTANCE.mo428i(TAG, "dispatch[" + str + "]: hit expected seq=" + downSeqId2 + ", proto=" + intValue);
                                }
                                dispatchToListeners(intValue, data, true);
                                this.nextExpectedDownSeq = downSeqId2.longValue() + 1;
                            } else if (downSeqId2.longValue() <= this.nextExpectedDownSeq) {
                                continue;
                            } else if (fromHttp) {
                                dispatchToListeners(intValue, data, false);
                                this.nextExpectedDownSeq = downSeqId2.longValue() + 1;
                                try {
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("nextExpectedDownSeq", this.nextExpectedDownSeq);
                                    jSONObject.put("seq", downSeqId2.longValue());
                                    monitorStatus("HttpGaped", null, jSONObject);
                                } catch (Throwable unused) {
                                }
                            } else if (!this.isFillingGap) {
                                monitorStatus$default(this, "FrontierGapedFilling", null, null, 6, null);
                                FLogger.INSTANCE.mo428i(TAG, "dispatch[" + str + "]: gap detected, expected=" + this.nextExpectedDownSeq + ", got=" + downSeqId2 + ", starting fillGap");
                                this.isFillingGap = true;
                                BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new HubNetConnection$dispatch$1$1(this, null), 3, (Object) null);
                            } else {
                                monitorStatus$default(this, "FrontierGapedNoFilling", null, null, 6, null);
                                FLogger.INSTANCE.mo425d(TAG, "dispatch[" + str + "]: gap at seq=" + downSeqId2 + " but fillGap already running");
                            }
                        }
                    }
                }
            }
            if (fromHttp && arrayList2.isEmpty()) {
                if (this.isFillingGap) {
                    FLogger.INSTANCE.mo428i(TAG, "dispatch[HTTP]: all msgs filtered or empty, stopping fillGap");
                }
                this.isFillingGap = false;
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0098 A[Catch: all -> 0x003b, TRY_LEAVE, TryCatch #3 {all -> 0x003b, blocks: (B:11:0x0037, B:12:0x0084, B:14:0x008c, B:19:0x0098, B:20:0x012f, B:29:0x00da, B:31:0x00e1, B:32:0x00e7, B:34:0x00f3, B:36:0x00ff, B:38:0x0106, B:40:0x010c, B:42:0x0118, B:50:0x011d, B:52:0x0125, B:53:0x006f, B:55:0x0073, B:58:0x0104, B:59:0x0129, B:60:0x012e), top: B:10:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0073 A[Catch: all -> 0x003b, TryCatch #3 {all -> 0x003b, blocks: (B:11:0x0037, B:12:0x0084, B:14:0x008c, B:19:0x0098, B:20:0x012f, B:29:0x00da, B:31:0x00e1, B:32:0x00e7, B:34:0x00f3, B:36:0x00ff, B:38:0x0106, B:40:0x010c, B:42:0x0118, B:50:0x011d, B:52:0x0125, B:53:0x006f, B:55:0x0073, B:58:0x0104, B:59:0x0129, B:60:0x012e), top: B:10:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x0081 -> B:12:0x0084). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fillGap(long j, Continuation<? super Unit> continuation) {
        HubNetConnection$fillGap$1 hubNetConnection$fillGap$1;
        int i;
        HubNetConnection hubNetConnection;
        JSONObject jSONObject;
        Ref.LongRef longRef;
        List<WsMessage> list;
        List<WsMessage> list2;
        boolean z;
        if (continuation instanceof HubNetConnection$fillGap$1) {
            hubNetConnection$fillGap$1 = (HubNetConnection$fillGap$1) continuation;
            if ((hubNetConnection$fillGap$1.label & Integer.MIN_VALUE) != 0) {
                hubNetConnection$fillGap$1.label -= Integer.MIN_VALUE;
                Object obj = hubNetConnection$fillGap$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = hubNetConnection$fillGap$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("fromSeq", j);
                    } catch (Throwable unused) {
                    }
                    try {
                        FLogger.INSTANCE.mo428i(TAG, "fillGap start: fromSeq=" + j);
                        Ref.LongRef longRef2 = new Ref.LongRef();
                        longRef2.element = j;
                        jSONObject = jSONObject2;
                        longRef = longRef2;
                        hubNetConnection = this;
                        if (hubNetConnection.isFillingGap) {
                        }
                        FLogger.INSTANCE.mo428i(TAG, "fillGap done: cursor=" + longRef.element + ", nextExpected=" + hubNetConnection.nextExpectedDownSeq);
                    } catch (Throwable th) {
                        th = th;
                        hubNetConnection = this;
                        jSONObject = jSONObject2;
                    }
                    return Unit.INSTANCE;
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                longRef = (Ref.LongRef) hubNetConnection$fillGap$1.L$2;
                jSONObject = (JSONObject) hubNetConnection$fillGap$1.L$1;
                hubNetConnection = (HubNetConnection) hubNetConnection$fillGap$1.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    list = (List) obj;
                    list2 = list;
                } catch (Throwable th2) {
                    th = th2;
                }
                if (list2 != null && !list2.isEmpty()) {
                    z = false;
                    if (z) {
                        hubNetConnection.monitorFillGap("empty", null, jSONObject);
                        hubNetConnection.dispatch(CollectionsKt.emptyList(), true);
                    } else {
                        if (!list.isEmpty()) {
                            jSONObject.put("response_min_seq_num", list.get(0).getDownSeqId());
                            jSONObject.put("response_max_seq_num", list.get(list.size() - 1).getDownSeqId());
                        }
                        hubNetConnection.monitorFillGap("full", null, jSONObject);
                        hubNetConnection.dispatch(list, true);
                        if (!hubNetConnection.isFillingGap) {
                            hubNetConnection.monitorFillGap("break", null, jSONObject);
                        } else {
                            Iterator<T> it = list.iterator();
                            if (!it.hasNext()) {
                                throw new NoSuchElementException();
                            }
                            Long downSeqId = ((WsMessage) it.next()).getDownSeqId();
                            long longValue = downSeqId != null ? downSeqId.longValue() : longRef.element;
                            while (it.hasNext()) {
                                Long downSeqId2 = ((WsMessage) it.next()).getDownSeqId();
                                long longValue2 = downSeqId2 != null ? downSeqId2.longValue() : longRef.element;
                                if (longValue < longValue2) {
                                    longValue = longValue2;
                                }
                            }
                            longRef.element = longValue;
                            if (hubNetConnection.isFillingGap) {
                                long j2 = longRef.element;
                                hubNetConnection$fillGap$1.L$0 = hubNetConnection;
                                hubNetConnection$fillGap$1.L$1 = jSONObject;
                                hubNetConnection$fillGap$1.L$2 = longRef;
                                hubNetConnection$fillGap$1.label = 1;
                                obj = hubNetConnection.pollViaHttp(j2, hubNetConnection$fillGap$1);
                                if (obj == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                list = (List) obj;
                                list2 = list;
                                if (list2 != null) {
                                    z = false;
                                    if (z) {
                                    }
                                }
                            }
                        }
                    }
                    FLogger.INSTANCE.mo428i(TAG, "fillGap done: cursor=" + longRef.element + ", nextExpected=" + hubNetConnection.nextExpectedDownSeq);
                    return Unit.INSTANCE;
                }
                z = true;
                if (z) {
                }
                FLogger.INSTANCE.mo428i(TAG, "fillGap done: cursor=" + longRef.element + ", nextExpected=" + hubNetConnection.nextExpectedDownSeq);
                return Unit.INSTANCE;
                FLogger.INSTANCE.mo426e(TAG, "fillGap error: " + th);
                hubNetConnection.monitorFillGap("error", null, jSONObject);
                hubNetConnection.dispatch(CollectionsKt.emptyList(), true);
                EnsureManager.ensureNotReachHere();
                return Unit.INSTANCE;
            }
        }
        hubNetConnection$fillGap$1 = new HubNetConnection$fillGap$1(this, continuation);
        Object obj2 = hubNetConnection$fillGap$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = hubNetConnection$fillGap$1.label;
        if (i != 0) {
        }
        FLogger.INSTANCE.mo426e(TAG, "fillGap error: " + th);
        hubNetConnection.monitorFillGap("error", null, jSONObject);
        hubNetConnection.dispatch(CollectionsKt.emptyList(), true);
        EnsureManager.ensureNotReachHere();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object pollViaHttp(long j, Continuation<? super List<WsMessage>> continuation) {
        HubNetConnection$pollViaHttp$1 hubNetConnection$pollViaHttp$1;
        int i;
        HubNetConnection hubNetConnection;
        HttpDataResult httpDataResult;
        List<WsMessage> msgs;
        if (continuation instanceof HubNetConnection$pollViaHttp$1) {
            hubNetConnection$pollViaHttp$1 = (HubNetConnection$pollViaHttp$1) continuation;
            if ((hubNetConnection$pollViaHttp$1.label & Integer.MIN_VALUE) != 0) {
                hubNetConnection$pollViaHttp$1.label -= Integer.MIN_VALUE;
                HubNetConnection$pollViaHttp$1 hubNetConnection$pollViaHttp$12 = hubNetConnection$pollViaHttp$1;
                Object obj = hubNetConnection$pollViaHttp$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = hubNetConnection$pollViaHttp$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Long frontierId = getFrontierId();
                    if (frontierId == null) {
                        return null;
                    }
                    long longValue = frontierId.longValue();
                    String deviceId = ApplogService.INSTANCE.getDeviceId();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("fromDownSeqId", j);
                        monitorStatus("HttpPoll", null, jSONObject);
                    } catch (Throwable unused) {
                    }
                    HubNetFallbackApi.Companion companion = HubNetFallbackApi.INSTANCE;
                    Map<String, String> fallbackHeaders = getFallbackHeaders();
                    Long boxLong = Boxing.boxLong(j);
                    Integer boxInt = Boxing.boxInt(20);
                    hubNetConnection$pollViaHttp$12.L$0 = this;
                    hubNetConnection$pollViaHttp$12.label = 1;
                    obj = companion.pollRawCall$ttnet_mainlandRelease(fallbackHeaders, longValue, deviceId, boxLong, boxInt, hubNetConnection$pollViaHttp$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    hubNetConnection = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    HubNetConnection hubNetConnection2 = (HubNetConnection) hubNetConnection$pollViaHttp$12.L$0;
                    ResultKt.throwOnFailure(obj);
                    hubNetConnection = hubNetConnection2;
                }
                httpDataResult = (HttpDataResult) obj;
                if (!(httpDataResult instanceof HttpDataResult.Success)) {
                    HttpDataResult.Success success = (HttpDataResult.Success) httpDataResult;
                    if (success.getBizResp().isSuccess()) {
                        FallbackPollResponse fallbackPollResponse = (FallbackPollResponse) success.getBizResp().getData();
                        return (fallbackPollResponse == null || (msgs = fallbackPollResponse.getMsgs()) == null) ? CollectionsKt.emptyList() : msgs;
                    }
                    FLogger.INSTANCE.mo430w(TAG, "pollViaHttp biz error: code=" + success.getBizResp().getCode());
                    monitorStatus$default(hubNetConnection, "HttpPollError", null, null, 6, null);
                    return null;
                }
                if (!(httpDataResult instanceof HttpDataResult.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                FLogger.INSTANCE.mo430w(TAG, "pollViaHttp error: " + httpDataResult);
                monitorStatus$default(hubNetConnection, "HttpPollError", null, null, 6, null);
                return null;
            }
        }
        hubNetConnection$pollViaHttp$1 = new HubNetConnection$pollViaHttp$1(this, continuation);
        HubNetConnection$pollViaHttp$1 hubNetConnection$pollViaHttp$122 = hubNetConnection$pollViaHttp$1;
        Object obj2 = hubNetConnection$pollViaHttp$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = hubNetConnection$pollViaHttp$122.label;
        if (i != 0) {
        }
        httpDataResult = (HttpDataResult) obj2;
        if (!(httpDataResult instanceof HttpDataResult.Success)) {
        }
    }

    private final void dispatchToListeners(int proto, String data, boolean isConsecutiveSeq) {
        Iterator<T> it = this.messageListeners.iterator();
        while (it.hasNext()) {
            ((HubNetMessageListener) it.next()).onMessage(proto, data, isConsecutiveSeq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startHttpFallback() {
        FLogger.INSTANCE.mo428i(TAG, "startHttpFallback: starting flush + poll timers");
        monitorStatus$default(this, "HttpFallbackStart", null, null, 6, null);
        this.httpFlushJob = BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new HubNetConnection$startHttpFallback$1(this, null), 3, (Object) null);
        this.httpPollJob = BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new HubNetConnection$startHttpFallback$2(this, null), 3, (Object) null);
    }

    private final void stopHttpFallback() {
        FLogger.INSTANCE.mo428i(TAG, "stopHttpFallback: cancelling flush + poll timers");
        monitorStatus$default(this, "HttpFallbackStop", null, null, 6, null);
        Job job = this.httpFlushJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.httpFlushJob = null;
        Job job2 = this.httpPollJob;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        this.httpPollJob = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object flushPendingViaHttp(Continuation<? super Boolean> continuation) {
        ArrayList arrayList = new ArrayList(this.pendingSendQueue.size());
        Iterator it = SequencesKt.generateSequence(new Function0() { // from class: com.bytedance.trae.network.HubNetConnection$$ExternalSyntheticLambda1
            public final Object invoke() {
                HubNetConnection.PendingSend flushPendingViaHttp$lambda$36;
                flushPendingViaHttp$lambda$36 = HubNetConnection.flushPendingViaHttp$lambda$36(HubNetConnection.this);
                return flushPendingViaHttp$lambda$36;
            }
        }).iterator();
        while (it.hasNext()) {
            arrayList.add((PendingSend) it.next());
        }
        if (arrayList.isEmpty()) {
            return Boxing.boxBoolean(true);
        }
        monitorStatus$default(this, "HttpFlush", null, null, 6, null);
        ArrayList arrayList2 = arrayList;
        if (arrayList2.size() > 1) {
            CollectionsKt.sortWith(arrayList2, new Comparator() { // from class: com.bytedance.trae.network.HubNetConnection$flushPendingViaHttp$$inlined$sortBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(((HubNetConnection.PendingSend) t).getMessage().getUpSeqId(), ((HubNetConnection.PendingSend) t2).getMessage().getUpSeqId());
                }
            });
        }
        FLogger.INSTANCE.mo425d(TAG, "flushPendingViaHttp: sending " + arrayList.size() + " msgs, upSeq=[" + ((PendingSend) CollectionsKt.first(arrayList2)).getMessage().getUpSeqId() + ".." + ((PendingSend) CollectionsKt.last(arrayList2)).getMessage().getUpSeqId() + ']');
        return pushMessagesViaHttp(arrayList2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PendingSend flushPendingViaHttp$lambda$36(HubNetConnection hubNetConnection) {
        return hubNetConnection.pendingSendQueue.poll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00ee A[Catch: all -> 0x01b8, CancellationException -> 0x01bb, TRY_ENTER, TryCatch #8 {CancellationException -> 0x01bb, all -> 0x01b8, blocks: (B:14:0x00e4, B:17:0x00ee, B:19:0x00fb, B:20:0x01a6, B:23:0x0120, B:25:0x0160, B:27:0x0164, B:29:0x01ab, B:30:0x01b1, B:31:0x01b2, B:32:0x01b7), top: B:13:0x00e4 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0160 A[Catch: all -> 0x01b8, CancellationException -> 0x01bb, TryCatch #8 {CancellationException -> 0x01bb, all -> 0x01b8, blocks: (B:14:0x00e4, B:17:0x00ee, B:19:0x00fb, B:20:0x01a6, B:23:0x0120, B:25:0x0160, B:27:0x0164, B:29:0x01ab, B:30:0x01b1, B:31:0x01b2, B:32:0x01b7), top: B:13:0x00e4 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002f  */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v15 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object pushMessagesViaHttp(List<PendingSend> list, Continuation<? super Boolean> continuation) {
        HubNetConnection$pushMessagesViaHttp$1 hubNetConnection$pushMessagesViaHttp$1;
        int i;
        HubNetConnection hubNetConnection;
        Long frontierId;
        Ref.BooleanRef booleanRef;
        Ref.BooleanRef booleanRef2;
        Ref.BooleanRef booleanRef3;
        HubNetConnection hubNetConnection2;
        HttpDataResult httpDataResult;
        boolean z;
        List<PendingSend> list2 = list;
        try {
            if (continuation instanceof HubNetConnection$pushMessagesViaHttp$1) {
                hubNetConnection$pushMessagesViaHttp$1 = (HubNetConnection$pushMessagesViaHttp$1) continuation;
                if ((hubNetConnection$pushMessagesViaHttp$1.label & Integer.MIN_VALUE) != 0) {
                    hubNetConnection$pushMessagesViaHttp$1.label -= Integer.MIN_VALUE;
                    HubNetConnection$pushMessagesViaHttp$1 hubNetConnection$pushMessagesViaHttp$12 = hubNetConnection$pushMessagesViaHttp$1;
                    Object obj = hubNetConnection$pushMessagesViaHttp$12.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = hubNetConnection$pushMessagesViaHttp$12.label;
                    ?? r14 = 1;
                    ?? r142 = 1;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        Ref.BooleanRef booleanRef4 = new Ref.BooleanRef();
                        try {
                            frontierId = getFrontierId();
                        } catch (CancellationException e) {
                            e = e;
                            r142 = booleanRef4;
                        } catch (Throwable th) {
                            th = th;
                            r14 = booleanRef4;
                        }
                        try {
                            if (frontierId == null) {
                                HubNetConnection hubNetConnection3 = this;
                                pushMessagesViaHttp$requeueOnce(booleanRef4, this, list2);
                                return Boxing.boxBoolean(false);
                            }
                            long longValue = frontierId.longValue();
                            String deviceId = ApplogService.INSTANCE.getDeviceId();
                            try {
                                if (deviceId == null) {
                                    HubNetConnection hubNetConnection4 = this;
                                    pushMessagesViaHttp$requeueOnce(booleanRef4, this, list2);
                                    return Boxing.boxBoolean(false);
                                }
                                long parseLong = Long.parseLong(deviceId);
                                List<PendingSend> list3 = list2;
                                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
                                Iterator<T> it = list3.iterator();
                                while (it.hasNext()) {
                                    arrayList.add(((PendingSend) it.next()).getMessage());
                                }
                                FallbackPushRequest fallbackPushRequest = new FallbackPushRequest(longValue, parseLong, arrayList);
                                TraeHttpConnection traeHttpConnection = TraeHttpConnection.INSTANCE;
                                Map<String, String> fallbackHeaders = getFallbackHeaders();
                                HubNetConnection$pushMessagesViaHttp$result$1 hubNetConnection$pushMessagesViaHttp$result$1 = new HubNetConnection$pushMessagesViaHttp$result$1(fallbackPushRequest, null);
                                hubNetConnection$pushMessagesViaHttp$12.L$0 = this;
                                hubNetConnection$pushMessagesViaHttp$12.L$1 = list2;
                                hubNetConnection$pushMessagesViaHttp$12.L$2 = booleanRef4;
                                hubNetConnection$pushMessagesViaHttp$12.label = 1;
                                booleanRef3 = booleanRef4;
                                obj = traeHttpConnection.safeCall("hub_fallback", HubNetFallbackApi.class, (Map<String, String>) fallbackHeaders, (Function2) hubNetConnection$pushMessagesViaHttp$result$1, (r17 & 16) != 0 ? null : null, (Set<Long>) ((r17 & 32) != 0 ? BizResponse.INSTANCE.getDEFAULT_SUCCESS_CODES() : null), (Continuation) hubNetConnection$pushMessagesViaHttp$12);
                                if (obj == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                hubNetConnection2 = this;
                            } catch (CancellationException e2) {
                                e = e2;
                                hubNetConnection = this;
                                booleanRef2 = booleanRef4;
                                pushMessagesViaHttp$requeueOnce(booleanRef2, hubNetConnection, list2);
                                throw e;
                            } catch (Throwable th2) {
                                th = th2;
                                hubNetConnection = this;
                                booleanRef = booleanRef4;
                                FLogger.INSTANCE.mo426e(TAG, "pushMessagesViaHttp error: " + th);
                                pushMessagesViaHttp$requeueOnce(booleanRef, hubNetConnection, list2);
                                EnsureManager.ensureNotReachHere();
                                return Boxing.boxBoolean(false);
                            }
                        } catch (CancellationException e3) {
                            e = e3;
                            hubNetConnection = this;
                            booleanRef2 = r142;
                            pushMessagesViaHttp$requeueOnce(booleanRef2, hubNetConnection, list2);
                            throw e;
                        } catch (Throwable th3) {
                            th = th3;
                            hubNetConnection = this;
                            booleanRef = r14;
                            FLogger.INSTANCE.mo426e(TAG, "pushMessagesViaHttp error: " + th);
                            pushMessagesViaHttp$requeueOnce(booleanRef, hubNetConnection, list2);
                            EnsureManager.ensureNotReachHere();
                            return Boxing.boxBoolean(false);
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        Ref.BooleanRef booleanRef5 = (Ref.BooleanRef) hubNetConnection$pushMessagesViaHttp$12.L$2;
                        List<PendingSend> list4 = (List) hubNetConnection$pushMessagesViaHttp$12.L$1;
                        hubNetConnection = (HubNetConnection) hubNetConnection$pushMessagesViaHttp$12.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            booleanRef3 = booleanRef5;
                            list2 = list4;
                            hubNetConnection2 = hubNetConnection;
                        } catch (CancellationException e4) {
                            e = e4;
                            booleanRef2 = booleanRef5;
                            list2 = list4;
                            pushMessagesViaHttp$requeueOnce(booleanRef2, hubNetConnection, list2);
                            throw e;
                        } catch (Throwable th4) {
                            th = th4;
                            booleanRef = booleanRef5;
                            list2 = list4;
                            FLogger.INSTANCE.mo426e(TAG, "pushMessagesViaHttp error: " + th);
                            pushMessagesViaHttp$requeueOnce(booleanRef, hubNetConnection, list2);
                            EnsureManager.ensureNotReachHere();
                            return Boxing.boxBoolean(false);
                        }
                    }
                    httpDataResult = (HttpDataResult) obj;
                    if (!(httpDataResult instanceof HttpDataResult.Success)) {
                        if (((HttpDataResult.Success) httpDataResult).getBizResp().isSuccess()) {
                            FLogger.INSTANCE.mo425d(TAG, "HTTP push " + list2.size() + " messages ok");
                            z = true;
                            return Boxing.boxBoolean(z);
                        }
                        FLogger.INSTANCE.mo430w(TAG, "HTTP push biz error: code=" + ((HttpDataResult.Success) httpDataResult).getBizResp().getCode() + ", re-queuing " + list2.size() + " messages");
                        pushMessagesViaHttp$requeueOnce(booleanRef3, hubNetConnection2, list2);
                        monitorStatus$default(hubNetConnection2, "HttpPushError", null, null, 6, null);
                    } else {
                        if (!(httpDataResult instanceof HttpDataResult.Error)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        FLogger.INSTANCE.mo430w(TAG, "HTTP push error: " + httpDataResult + ", re-queuing " + list2.size() + " messages");
                        pushMessagesViaHttp$requeueOnce(booleanRef3, hubNetConnection2, list2);
                        monitorStatus$default(hubNetConnection2, "HttpPushError", null, null, 6, null);
                        if (((HttpDataResult.Error) httpDataResult).getThrowable() instanceof CancellationException) {
                            throw ((HttpDataResult.Error) httpDataResult).getThrowable();
                        }
                    }
                    z = false;
                    return Boxing.boxBoolean(z);
                }
            }
            httpDataResult = (HttpDataResult) obj;
            if (!(httpDataResult instanceof HttpDataResult.Success)) {
            }
            z = false;
            return Boxing.boxBoolean(z);
        } catch (CancellationException e5) {
            e = e5;
            hubNetConnection = hubNetConnection2;
            booleanRef2 = booleanRef3;
            pushMessagesViaHttp$requeueOnce(booleanRef2, hubNetConnection, list2);
            throw e;
        } catch (Throwable th5) {
            th = th5;
            hubNetConnection = hubNetConnection2;
            booleanRef = booleanRef3;
            FLogger.INSTANCE.mo426e(TAG, "pushMessagesViaHttp error: " + th);
            pushMessagesViaHttp$requeueOnce(booleanRef, hubNetConnection, list2);
            EnsureManager.ensureNotReachHere();
            return Boxing.boxBoolean(false);
        }
        hubNetConnection$pushMessagesViaHttp$1 = new HubNetConnection$pushMessagesViaHttp$1(this, continuation);
        HubNetConnection$pushMessagesViaHttp$1 hubNetConnection$pushMessagesViaHttp$122 = hubNetConnection$pushMessagesViaHttp$1;
        Object obj2 = hubNetConnection$pushMessagesViaHttp$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = hubNetConnection$pushMessagesViaHttp$122.label;
        ?? r143 = 1;
        ?? r1422 = 1;
        if (i != 0) {
        }
    }

    private static final void pushMessagesViaHttp$requeueOnce(Ref.BooleanRef booleanRef, HubNetConnection hubNetConnection, List<PendingSend> list) {
        if (booleanRef.element) {
            return;
        }
        booleanRef.element = true;
        reEnqueuePendingSends$default(hubNetConnection, list, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void drainPendingQueueViaFrontier() {
        FrontierConnection frontierConnection = this.frontier;
        if (frontierConnection == null) {
            FLogger.INSTANCE.mo430w(TAG, "drainPendingQueueViaFrontier: frontier missing, switching to HTTP_FALLBACK");
            this.transportMode = TransportMode.HTTP_FALLBACK;
            startHttpFallback();
            return;
        }
        ArrayList arrayList = new ArrayList(this.pendingSendQueue.size());
        Iterator it = SequencesKt.generateSequence(new Function0() { // from class: com.bytedance.trae.network.HubNetConnection$$ExternalSyntheticLambda6
            public final Object invoke() {
                HubNetConnection.PendingSend drainPendingQueueViaFrontier$lambda$42;
                drainPendingQueueViaFrontier$lambda$42 = HubNetConnection.drainPendingQueueViaFrontier$lambda$42(HubNetConnection.this);
                return drainPendingQueueViaFrontier$lambda$42;
            }
        }).iterator();
        while (it.hasNext()) {
            arrayList.add((PendingSend) it.next());
        }
        if (arrayList.isEmpty()) {
            return;
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.size() > 1) {
            CollectionsKt.sortWith(arrayList2, new Comparator() { // from class: com.bytedance.trae.network.HubNetConnection$drainPendingQueueViaFrontier$$inlined$sortBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(((HubNetConnection.PendingSend) t).getMessage().getUpSeqId(), ((HubNetConnection.PendingSend) t2).getMessage().getUpSeqId());
                }
            });
        }
        FLogger.INSTANCE.mo428i(TAG, "drainPendingQueueViaFrontier: " + arrayList.size() + " messages");
        final long j = this.websocketGeneration;
        Iterator it2 = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
        while (it2.hasNext()) {
            Object next = it2.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            final PendingSend pendingSend = (PendingSend) next;
            frontierConnection.sendBytes(this.channelId, pendingSend.getBytes(), pendingSend.getHeaders(), new Function1() { // from class: com.bytedance.trae.network.HubNetConnection$$ExternalSyntheticLambda7
                public final Object invoke(Object obj) {
                    Unit drainPendingQueueViaFrontier$lambda$45;
                    drainPendingQueueViaFrontier$lambda$45 = HubNetConnection.drainPendingQueueViaFrontier$lambda$45(HubNetConnection.PendingSend.this, this, j, ((Boolean) obj).booleanValue());
                    return drainPendingQueueViaFrontier$lambda$45;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PendingSend drainPendingQueueViaFrontier$lambda$42(HubNetConnection hubNetConnection) {
        return hubNetConnection.pendingSendQueue.poll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit drainPendingQueueViaFrontier$lambda$45(PendingSend pendingSend, HubNetConnection hubNetConnection, long j, boolean z) {
        if (!z) {
            FLogger.INSTANCE.mo430w(TAG, "drainViaFrontier: send failed upSeq=" + pendingSend.getMessage().getUpSeqId() + ", re-queuing");
            hubNetConnection.reEnqueuePendingSends(CollectionsKt.listOf(pendingSend), Long.valueOf(j));
        }
        return Unit.INSTANCE;
    }

    static /* synthetic */ void reEnqueuePendingSends$default(HubNetConnection hubNetConnection, List list, Long l, int i, Object obj) {
        if ((i & 2) != 0) {
            l = null;
        }
        hubNetConnection.reEnqueuePendingSends(list, l);
    }

    private final void reEnqueuePendingSends(List<PendingSend> messages, Long attemptGeneration) {
        ReentrantLock reentrantLock = this.modeLock;
        reentrantLock.lock();
        try {
            if (this.transportMode == TransportMode.SHUTDOWN) {
                return;
            }
            ConcurrentLinkedQueue<PendingSend> concurrentLinkedQueue = this.pendingSendQueue;
            Iterator<T> it = messages.iterator();
            while (it.hasNext()) {
                concurrentLinkedQueue.offer((PendingSend) it.next());
            }
            if (this.transportMode == TransportMode.WEBSOCKET && (attemptGeneration == null || attemptGeneration.longValue() < this.websocketGeneration)) {
                drainPendingQueueViaFrontier();
            } else {
                schedulePendingQueuePumpLocked();
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    private final void schedulePendingQueuePumpLocked() {
        if (this.pendingSendQueue.isEmpty()) {
            return;
        }
        Job job = this.pendingQueuePumpJob;
        boolean z = false;
        if (job != null && job.isActive()) {
            z = true;
        }
        if (z) {
            return;
        }
        if (this.transportMode == TransportMode.WEBSOCKET || this.transportMode == TransportMode.SSE) {
            this.pendingQueuePumpJob = BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new HubNetConnection$schedulePendingQueuePumpLocked$1(this, null), 3, (Object) null);
        }
    }

    private final Long getFrontierId() {
        if (this.isToB) {
            SseConnection sseConnection = this.sseConnection;
            if (sseConnection != null) {
                return Long.valueOf(sseConnection.getFrontierId());
            }
            return null;
        }
        FrontierConnection frontierConnection = this.frontier;
        if (frontierConnection != null) {
            return Long.valueOf(frontierConnection.getFrontierId());
        }
        return null;
    }

    static /* synthetic */ void monitorStatus$default(HubNetConnection hubNetConnection, String str, JSONObject jSONObject, JSONObject jSONObject2, int i, Object obj) {
        if ((i & 2) != 0) {
            jSONObject = null;
        }
        if ((i & 4) != 0) {
            jSONObject2 = null;
        }
        hubNetConnection.monitorStatus(str, jSONObject, jSONObject2);
    }

    private final void monitorStatus(String status, JSONObject metric, JSONObject extraLog) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("status", status);
        ApmAgent.monitorEvent(HUB_MONITOR_EVENT, jSONObject, metric, extraLog);
    }

    static /* synthetic */ void monitorFillGap$default(HubNetConnection hubNetConnection, String str, JSONObject jSONObject, JSONObject jSONObject2, int i, Object obj) {
        if ((i & 2) != 0) {
            jSONObject = null;
        }
        if ((i & 4) != 0) {
            jSONObject2 = null;
        }
        hubNetConnection.monitorFillGap(str, jSONObject, jSONObject2);
    }

    private final void monitorFillGap(String status, JSONObject metric, JSONObject extraLog) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("status", status);
            ApmAgent.monitorEvent("hub_http_fill_gap", jSONObject, metric, extraLog);
        } catch (Throwable unused) {
        }
    }
}
