package com.bytedance.trae.network;

import android.os.Process;
import android.os.SystemClock;
import com.bytedance.common.wschannel.ChannelInfo;
import com.bytedance.common.wschannel.MsgSendListener;
import com.bytedance.common.wschannel.WsChannel;
import com.bytedance.common.wschannel.WsChannelSdk;
import com.bytedance.common.wschannel.WsChannelSdk2;
import com.bytedance.common.wschannel.app.OnMessageReceiveListener;
import com.bytedance.common.wschannel.event.ConnectEvent;
import com.bytedance.common.wschannel.event.ConnectionState;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.push.event.sync.ISignalReportConstants;
import com.bytedance.push.model.HeadSetStatusExtraConfig;
import com.bytedance.trae.ApiHost;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.platform.api.ISdkCommonHttp;
import com.bytedance.trae.platform.service.ApplogService;
import com.bytedance.trae.utils.logger.FLogger;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* compiled from: FrontierConnection.kt */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 L2\u00020\u0001:\u0001LB\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J.\u0010+\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u00132\u0014\b\u0002\u0010(\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020*0)2\b\b\u0002\u0010\u0016\u001a\u00020\u0017J\u0006\u0010-\u001a\u00020\u001eJ\"\u0010.\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\u00032\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fJ\u001a\u00101\u001a\u00020\u000e2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u000e0\fJ\"\u00102\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\u00032\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fJ\u001a\u00103\u001a\u00020\u000e2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u000e0\fJ\u000e\u00104\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u0001J\u0006\u00105\u001a\u00020\u000eJF\u00106\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\u00032\u0006\u00107\u001a\u00020\r2\u0016\b\u0002\u00108\u001a\u0010\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020*\u0018\u00010)2\u0016\b\u0002\u00109\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fJ\u0010\u0010:\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020*H\u0007J\u0010\u0010<\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020*H\u0007J\u0016\u0010=\u001a\u00020\u000e2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u000e0?H\u0002J\u0012\u0010@\u001a\u00020\u001e2\b\u0010A\u001a\u0004\u0018\u00010\u0015H\u0002J\u001c\u0010B\u001a\u00020\u000e2\b\u0010C\u001a\u0004\u0018\u00010D2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\u0010\u0010G\u001a\u00020\u000e2\u0006\u0010H\u001a\u00020\u0010H\u0002J\u0012\u0010I\u001a\u00020\u000e2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR,\u0010\t\u001a \u0012\u0004\u0012\u00020\u0003\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f0\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u000e0\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010#\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b$\u0010%R\u001a\u0010(\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020*0)X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lcom/bytedance/trae/network/FrontierConnection;", "Lcom/bytedance/common/wschannel/app/OnMessageReceiveListener;", "channelId", "", "customFrontierId", "", "<init>", "(ILjava/lang/Long;)V", "Ljava/lang/Long;", "bytesListeners", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lkotlin/Function1;", "", "", "stateListeners", "Lcom/bytedance/trae/network/NetworkConnectState;", "pushListener", "wsConfig", "Lcom/bytedance/trae/network/FrontierConfig;", "wsChannel", "Lcom/bytedance/common/wschannel/WsChannel;", "clientMetadata", "Lcom/bytedance/trae/network/HubClientMetadata;", "currentState", "lastDataReceivedTime", "isConnecting", "Ljava/util/concurrent/atomic/AtomicBoolean;", "lastConnectTime", "pendingConsumeCloseEvent", "", "pendingCloseDeferred", "Lkotlinx/coroutines/CompletableDeferred;", "connectScope", "Lkotlinx/coroutines/CoroutineScope;", "frontierId", "getFrontierId", "()J", "frontierId$delegate", "Lkotlin/Lazy;", "extraHeaders", "", "", "setup", "config", "isReallyAlive", "registerBytesListener", "serviceId", "listener", "registerStateListener", "unregisterBytesListener", "unregisterStateListener", "registerPushListener", "unregisterPushListener", "sendBytes", "bytes", "headers", "callback", HeadSetStatusExtraConfig.VALUE_DISCONNECT, ISignalReportConstants.KEY_REASON, "connect", "tryWaitLastChannelClose", "block", "Lkotlin/Function0;", "updateWsChannel", "channel", "onReceiveConnectEvent", "connectEvent", "Lcom/bytedance/common/wschannel/event/ConnectEvent;", "connectJson", "Lorg/json/JSONObject;", "updateWsState", "state", "onReceiveMsg", "wsChannelMsg", "Lcom/bytedance/common/wschannel/model/WsChannelMsg;", "Companion", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class FrontierConnection implements OnMessageReceiveListener {
    private static final long ALIVE_TIMEOUT_MS = 45000;
    private static final String TAG = "IM/FrontierConnection";
    private final ConcurrentHashMap<Integer, Set<Function1<byte[], Unit>>> bytesListeners;
    private final int channelId;
    private HubClientMetadata clientMetadata;
    private CoroutineScope connectScope;
    private NetworkConnectState currentState;
    private final Long customFrontierId;
    private Map<String, String> extraHeaders;

    /* renamed from: frontierId$delegate, reason: from kotlin metadata */
    private final Lazy frontierId;
    private AtomicBoolean isConnecting;
    private long lastConnectTime;
    private volatile long lastDataReceivedTime;
    private CompletableDeferred<Unit> pendingCloseDeferred;
    private boolean pendingConsumeCloseEvent;
    private volatile OnMessageReceiveListener pushListener;
    private final Set<Function1<NetworkConnectState, Unit>> stateListeners;
    private WsChannel wsChannel;
    private FrontierConfig wsConfig;

    /* compiled from: FrontierConnection.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ConnectionState.values().length];
            try {
                iArr[ConnectionState.CONNECTING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ConnectionState.CONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ConnectionState.CONNECT_CLOSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ConnectionState.CONNECT_FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public FrontierConnection(int i, Long l) {
        this.channelId = i;
        this.customFrontierId = l;
        this.bytesListeners = new ConcurrentHashMap<>();
        this.stateListeners = new LinkedHashSet();
        FrontierConfig frontierConfig = ApiHost.FRONTIER_CONFIG;
        Intrinsics.checkNotNullExpressionValue(frontierConfig, "FRONTIER_CONFIG");
        this.wsConfig = frontierConfig;
        this.clientMetadata = HubClientMetadata.INSTANCE.fromSystem();
        this.currentState = NetworkConnectState.DISCONNECTED;
        this.isConnecting = new AtomicBoolean(false);
        this.lastConnectTime = -1L;
        this.connectScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus((CoroutineExceptionHandler) new FrontierConnection$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key)));
        this.frontierId = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.network.FrontierConnection$$ExternalSyntheticLambda2
            public final Object invoke() {
                long frontierId_delegate$lambda$2;
                frontierId_delegate$lambda$2 = FrontierConnection.frontierId_delegate$lambda$2(FrontierConnection.this);
                return Long.valueOf(frontierId_delegate$lambda$2);
            }
        });
        this.extraHeaders = MapsKt.emptyMap();
    }

    public /* synthetic */ FrontierConnection(int i, Long l, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : l);
    }

    public final long getFrontierId() {
        return ((Number) this.frontierId.getValue()).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long frontierId_delegate$lambda$2(FrontierConnection frontierConnection) {
        String str = frontierConnection.extraHeaders.get("user_id");
        if (str == null) {
            String frontierUserId = ISdkCommonHttp.INSTANCE.getFrontierUserId();
            if (frontierUserId.length() == 0) {
                frontierUserId = null;
            }
            str = frontierUserId;
            if (str == null) {
                str = ApplogService.INSTANCE.getUserID();
            }
        }
        Long l = frontierConnection.customFrontierId;
        return l != null ? l.longValue() : FrontierIdGenerator.INSTANCE.generateFrontierId(str, frontierConnection.wsConfig.getAppId(), FrontierIdGenerator.APP_RUNTIME_TYPE_ANDROID, Process.myPid());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setup$default(FrontierConnection frontierConnection, FrontierConfig frontierConfig, Map map, HubClientMetadata hubClientMetadata, int i, Object obj) {
        if ((i & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        if ((i & 4) != 0) {
            hubClientMetadata = HubClientMetadata.INSTANCE.fromSystem();
        }
        frontierConnection.setup(frontierConfig, map, hubClientMetadata);
    }

    public final void setup(FrontierConfig config, Map<String, String> extraHeaders, HubClientMetadata clientMetadata) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(extraHeaders, "extraHeaders");
        Intrinsics.checkNotNullParameter(clientMetadata, "clientMetadata");
        this.wsConfig = FrontierConfig.copy$default(config, 0, 0, null, null, 15, null);
        this.extraHeaders = extraHeaders;
        this.clientMetadata = clientMetadata;
    }

    public final boolean isReallyAlive() {
        return this.currentState == NetworkConnectState.CONNECTED;
    }

    public final void registerBytesListener(int serviceId, Function1<? super byte[], Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LinkedHashSet linkedHashSet = this.bytesListeners.get(Integer.valueOf(serviceId));
        if (linkedHashSet == null) {
            linkedHashSet = new LinkedHashSet();
        }
        linkedHashSet.add(listener);
        this.bytesListeners.put(Integer.valueOf(serviceId), linkedHashSet);
    }

    public final void registerStateListener(Function1<? super NetworkConnectState, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.stateListeners.add(listener);
    }

    public final void unregisterBytesListener(int serviceId, Function1<? super byte[], Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Set<Function1<byte[], Unit>> set = this.bytesListeners.get(Integer.valueOf(serviceId));
        if (set != null) {
            set.remove(listener);
        }
    }

    public final void unregisterStateListener(Function1<? super NetworkConnectState, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.stateListeners.remove(listener);
    }

    public final void registerPushListener(OnMessageReceiveListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.pushListener = listener;
    }

    public final void unregisterPushListener() {
        this.pushListener = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void sendBytes$default(FrontierConnection frontierConnection, int i, byte[] bArr, Map map, Function1 function1, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        if ((i2 & 8) != 0) {
            function1 = null;
        }
        frontierConnection.sendBytes(i, bArr, map, function1);
    }

    public final void sendBytes(int serviceId, byte[] bytes, Map<String, String> headers, final Function1<? super Boolean, Unit> callback) {
        Set<String> keySet;
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        WsChannel wsChannel = this.wsChannel;
        if (wsChannel == null) {
            if (callback != null) {
                callback.invoke(false);
                return;
            }
            return;
        }
        WsChannelMsg.Builder seqId = WsChannelMsg.Builder.create(wsChannel.getChannelId()).setService(serviceId).setMethod(1).setPayload(bytes).setSeqId(1L);
        if (headers != null && (keySet = headers.keySet()) != null) {
            for (String str : keySet) {
                seqId.addMsgHeader(str, headers.get(str));
            }
        }
        wsChannel.sendMsg(seqId.build(), new MsgSendListener() { // from class: com.bytedance.trae.network.FrontierConnection$$ExternalSyntheticLambda1
            public final void onSendResult(WsChannelMsg wsChannelMsg, boolean z) {
                FrontierConnection.sendBytes$lambda$6(callback, wsChannelMsg, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendBytes$lambda$6(Function1 function1, WsChannelMsg wsChannelMsg, boolean z) {
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(z));
        }
    }

    public final synchronized void disconnect(String reason) {
        Intrinsics.checkNotNullParameter(reason, ISignalReportConstants.KEY_REASON);
        updateWsChannel(null);
    }

    public final synchronized void connect(String reason) {
        Object obj;
        Intrinsics.checkNotNullParameter(reason, ISignalReportConstants.KEY_REASON);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - this.lastConnectTime > 1000 && this.isConnecting.get()) {
            this.isConnecting.set(false);
        }
        if (this.isConnecting.compareAndSet(false, true)) {
            this.lastConnectTime = elapsedRealtime;
            try {
                Result.Companion companion = Result.Companion;
                FrontierConnection frontierConnection = this;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                ApplogService.INSTANCE.putCommonParams(linkedHashMap);
                linkedHashMap.remove(CommonConstants.KEY_AID);
                linkedHashMap.remove(CommonConstants.KEY_DID);
                linkedHashMap.put("process_id", String.valueOf(Process.myPid()));
                linkedHashMap.put("app_runtime_type", FrontierIdGenerator.APP_RUNTIME_TYPE_ANDROID);
                HashMap hashMap = new HashMap();
                hashMap.put("ttnet_heartbeat_interval", "15");
                hashMap.put("ttnet_timeout_millis", "15000");
                List listOf = CollectionsKt.listOf(this.wsConfig.getUrl());
                hashMap.put("qos_level", "2");
                hashMap.putAll(linkedHashMap);
                Map<String, String> buildFrontierIdentityExtras = HubClientMetadataKt.buildFrontierIdentityExtras(getFrontierId(), this.clientMetadata);
                final ChannelInfo.Builder urls = ChannelInfo.Builder.create(this.channelId).setFPID(this.wsConfig.getProductId()).setAid(this.wsConfig.getAppId()).setDeviceId(ApplogService.INSTANCE.getDeviceId()).setInstallId(ApplogService.INSTANCE.getInstallId()).setAppKey(this.wsConfig.getAppKey()).extra("frontier_id", (String) MapsKt.getValue(buildFrontierIdentityExtras, "frontier_id")).extra("name", (String) MapsKt.getValue(buildFrontierIdentityExtras, "name")).extras(hashMap).setAppVersion(AppHost.Companion.getUpdateVersionCode()).urls(listOf);
                if (this.customFrontierId != null) {
                    urls.extra("notify", "1");
                }
                for (Map.Entry<String, String> entry : this.extraHeaders.entrySet()) {
                    urls.header(entry.getKey(), entry.getValue());
                }
                urls.header("sdk-version", "2");
                if (ISdkCommonHttp.INSTANCE.getToken().length() > 0) {
                    urls.header("x-ide-token", ISdkCommonHttp.INSTANCE.getToken());
                }
                for (Map.Entry<String, String> entry2 : ISdkCommonHttp.INSTANCE.getCommonAppendHeaders().entrySet()) {
                    urls.header(entry2.getKey(), entry2.getValue());
                }
                WsChannelSdk.setEnableReportAppState(AppHost.Companion.getApplication(), true);
                tryWaitLastChannelClose(new Function0() { // from class: com.bytedance.trae.network.FrontierConnection$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit connect$lambda$10$lambda$9;
                        connect$lambda$10$lambda$9 = FrontierConnection.connect$lambda$10$lambda$9(urls, this);
                        return connect$lambda$10$lambda$9;
                    }
                });
                obj = Result.constructor-impl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            Throwable th2 = Result.exceptionOrNull-impl(obj);
            if (th2 != null) {
                FLogger.INSTANCE.mo426e(TAG, "connect error: " + th2);
                this.isConnecting.set(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$10$lambda$9(ChannelInfo.Builder builder, FrontierConnection frontierConnection) {
        WsChannel registerChannel = WsChannelSdk2.registerChannel(AppHost.Companion.getApplication(), builder.builder(), frontierConnection);
        Intrinsics.checkNotNullExpressionValue(registerChannel, "registerChannel(...)");
        frontierConnection.updateWsChannel(registerChannel);
        return Unit.INSTANCE;
    }

    private final void tryWaitLastChannelClose(Function0<Unit> block) {
        if (updateWsChannel(null)) {
            BuildersKt.launch$default(this.connectScope, (CoroutineContext) null, (CoroutineStart) null, new FrontierConnection$tryWaitLastChannelClose$1(this, block, null), 3, (Object) null);
        } else {
            block.invoke();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean updateWsChannel(WsChannel channel) {
        Object obj;
        WsChannel wsChannel = this.wsChannel;
        boolean z = false;
        if (wsChannel != null) {
            try {
                Result.Companion companion = Result.Companion;
                this.pendingConsumeCloseEvent = true;
                this.pendingCloseDeferred = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
                updateWsState(NetworkConnectState.DISCONNECTED);
                wsChannel.unregister();
                try {
                    obj = Result.constructor-impl(Unit.INSTANCE);
                    z = true;
                } catch (Throwable th) {
                    th = th;
                    z = true;
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                    Result.box-impl(obj);
                    if (channel != null) {
                    }
                    this.wsChannel = channel;
                    return z;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            Result.box-impl(obj);
        }
        if (channel != null) {
            FLogger.INSTANCE.mo428i(TAG, "updateWsChannel: #" + channel.getChannelId() + ", isConnected: " + channel.isConnected());
        }
        this.wsChannel = channel;
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x009c, code lost:
    
        if ((r8 != null ? r8.connectionState : null) == com.bytedance.common.wschannel.event.ConnectionState.CONNECT_CLOSED) goto L51;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008a A[Catch: all -> 0x00af, TryCatch #1 {, blocks: (B:10:0x0028, B:12:0x002f, B:13:0x005b, B:16:0x0062, B:17:0x0066, B:19:0x006a, B:21:0x0070, B:23:0x0078, B:25:0x008a, B:26:0x008e, B:30:0x0098, B:31:0x009a, B:33:0x00a3, B:35:0x00aa, B:40:0x009e, B:45:0x0034, B:56:0x0050, B:57:0x0053, B:58:0x0056, B:59:0x0059, B:60:0x003c), top: B:9:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00aa A[Catch: all -> 0x00af, TRY_LEAVE, TryCatch #1 {, blocks: (B:10:0x0028, B:12:0x002f, B:13:0x005b, B:16:0x0062, B:17:0x0066, B:19:0x006a, B:21:0x0070, B:23:0x0078, B:25:0x008a, B:26:0x008e, B:30:0x0098, B:31:0x009a, B:33:0x00a3, B:35:0x00aa, B:40:0x009e, B:45:0x0034, B:56:0x0050, B:57:0x0053, B:58:0x0056, B:59:0x0059, B:60:0x003c), top: B:9:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void onReceiveConnectEvent(ConnectEvent connectEvent, JSONObject connectJson) {
        NetworkConnectState networkConnectState;
        boolean z;
        OnMessageReceiveListener onMessageReceiveListener;
        if (connectEvent != null && connectJson != null) {
            try {
                FLogger.INSTANCE.mo428i("HubNetConnection", "onReceiveConnectEvent:" + connectEvent.connectionState + ' ' + connectJson);
            } catch (Throwable unused) {
            }
        }
        if (this.wsChannel == null) {
            networkConnectState = NetworkConnectState.DISCONNECTED;
        } else {
            ConnectionState connectionState = connectEvent != null ? connectEvent.connectionState : null;
            int i = connectionState == null ? -1 : WhenMappings.$EnumSwitchMapping$0[connectionState.ordinal()];
            if (i == 1) {
                networkConnectState = NetworkConnectState.CONNECTING;
            } else if (i == 2) {
                networkConnectState = NetworkConnectState.CONNECTED;
            } else if (i == 3) {
                networkConnectState = NetworkConnectState.DISCONNECTED;
            } else if (i != 4) {
                return;
            } else {
                networkConnectState = NetworkConnectState.DISCONNECTED;
            }
        }
        if (this.pendingConsumeCloseEvent) {
            if ((connectEvent != null ? connectEvent.connectionState : null) == ConnectionState.CONNECT_CLOSED) {
                this.pendingConsumeCloseEvent = false;
                CompletableDeferred<Unit> completableDeferred = this.pendingCloseDeferred;
                if (completableDeferred != null) {
                    completableDeferred.complete(Unit.INSTANCE);
                }
                z = true;
                if (!CollectionsKt.contains(CollectionsKt.listOf(new ConnectionState[]{ConnectionState.CONNECTED, ConnectionState.CONNECT_FAILED}), connectEvent == null ? connectEvent.connectionState : null)) {
                    if (!z) {
                    }
                    updateWsState(networkConnectState);
                    onMessageReceiveListener = this.pushListener;
                    if (onMessageReceiveListener != null) {
                        onMessageReceiveListener.onReceiveConnectEvent(connectEvent, connectJson);
                    }
                }
                this.isConnecting.set(false);
                updateWsState(networkConnectState);
                onMessageReceiveListener = this.pushListener;
                if (onMessageReceiveListener != null) {
                }
            }
        }
        z = false;
        if (!CollectionsKt.contains(CollectionsKt.listOf(new ConnectionState[]{ConnectionState.CONNECTED, ConnectionState.CONNECT_FAILED}), connectEvent == null ? connectEvent.connectionState : null)) {
        }
        this.isConnecting.set(false);
        updateWsState(networkConnectState);
        onMessageReceiveListener = this.pushListener;
        if (onMessageReceiveListener != null) {
        }
    }

    private final void updateWsState(NetworkConnectState state) {
        if (this.currentState != state) {
            if (state == NetworkConnectState.CONNECTED) {
                this.lastDataReceivedTime = System.currentTimeMillis();
            }
            Iterator<T> it = this.stateListeners.iterator();
            while (it.hasNext()) {
                ((Function1) it.next()).invoke(state);
            }
            this.currentState = state;
        }
    }

    public void onReceiveMsg(WsChannelMsg wsChannelMsg) {
        byte[] payload;
        this.lastDataReceivedTime = System.currentTimeMillis();
        OnMessageReceiveListener onMessageReceiveListener = this.pushListener;
        if (onMessageReceiveListener != null) {
            onMessageReceiveListener.onReceiveMsg(wsChannelMsg);
        }
        if (wsChannelMsg == null || (payload = wsChannelMsg.getPayload()) == null) {
            return;
        }
        Collection<Set<Function1<byte[], Unit>>> values = this.bytesListeners.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            Set set = (Set) it.next();
            Intrinsics.checkNotNull(set);
            Iterator it2 = set.iterator();
            while (it2.hasNext()) {
                ((Function1) it2.next()).invoke(payload);
            }
        }
    }
}
