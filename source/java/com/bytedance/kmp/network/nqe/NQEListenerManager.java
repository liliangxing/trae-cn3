package com.bytedance.kmp.network.nqe;

import com.bytedance.kmp.network.IKmpNetworkService;
import com.bytedance.kmp.network.util.NLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: NQEListenerManager.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\r\b\u0000\u0018\u0000 12\u00020\u0001:\u00011B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00130\u0015H\u0082@¢\u0006\u0002\u0010\u0016J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0016\u0010\u001f\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010 J\u0010\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u0018H\u0016J0\u0010#\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020%2\u0006\u0010(\u001a\u00020%H\u0016J \u0010)\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\u001eH\u0016J\u0016\u0010-\u001a\u00020\u00132\u0006\u0010.\u001a\u00020\u0001H\u0086@¢\u0006\u0002\u0010/J\u0016\u00100\u001a\u00020\u00132\u0006\u0010.\u001a\u00020\u0001H\u0086@¢\u0006\u0002\u0010/R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u00062"}, d2 = {"Lcom/bytedance/kmp/network/nqe/NQEListenerManager;", "Lcom/bytedance/kmp/network/nqe/NQEListener;", "()V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/bytedance/kmp/network/nqe/NetworkQualityState;", "listeners", "", "listenersMutex", "Lkotlinx/coroutines/sync/Mutex;", "managerScope", "Lkotlinx/coroutines/CoroutineScope;", "service", "Lcom/bytedance/kmp/network/IKmpNetworkService;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "dispatchToListeners", "", "action", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEffectiveConnectionType", "Lcom/bytedance/kmp/network/nqe/EffectiveConnectionType;", "getNetworkQuality", "Lcom/bytedance/kmp/network/nqe/RttAndThroughput;", "getPacketLossRateMetrics", "Lcom/bytedance/kmp/network/nqe/PacketLoss;", "protocol", "", "initialize", "(Lcom/bytedance/kmp/network/IKmpNetworkService;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onEffectiveConnectionTypeChanged", "type", "onPacketLossComputed", "upstreamLossRate", "", "upstreamLossRateVariance", "downstreamLossRate", "downstreamLossRateVariance", "onRTTOrThroughputEstimatesComputed", "httpRttMs", "transportRttMs", "downstreamThroughputKbps", "registerListener", "listener", "(Lcom/bytedance/kmp/network/nqe/NQEListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeListener", "Companion", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class NQEListenerManager implements NQEListener {
    public static final int PACKET_LOSS_PROTOCOL_QUIC = 1;
    public static final int PACKET_LOSS_PROTOCOL_TCP = 0;
    private final MutableStateFlow<NetworkQualityState> _state;
    private final List<NQEListener> listeners = new ArrayList();
    private final Mutex listenersMutex = MutexKt.Mutex$default(false, 1, (Object) null);
    private final CoroutineScope managerScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getDefault()));
    private IKmpNetworkService service;
    private final StateFlow<NetworkQualityState> state;

    public NQEListenerManager() {
        MutableStateFlow<NetworkQualityState> MutableStateFlow = StateFlowKt.MutableStateFlow(new NetworkQualityState(null, null, null, null, 15, null));
        this._state = MutableStateFlow;
        this.state = FlowKt.asStateFlow(MutableStateFlow);
    }

    public final StateFlow<NetworkQualityState> getState() {
        return this.state;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object initialize(IKmpNetworkService iKmpNetworkService, Continuation<? super Unit> continuation) {
        NQEListenerManager$initialize$1 nQEListenerManager$initialize$1;
        int i;
        MutableStateFlow<NetworkQualityState> mutableStateFlow;
        if (continuation instanceof NQEListenerManager$initialize$1) {
            nQEListenerManager$initialize$1 = (NQEListenerManager$initialize$1) continuation;
            if ((nQEListenerManager$initialize$1.label & Integer.MIN_VALUE) != 0) {
                nQEListenerManager$initialize$1.label -= Integer.MIN_VALUE;
                Object obj = nQEListenerManager$initialize$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = nQEListenerManager$initialize$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    this.service = iKmpNetworkService;
                    iKmpNetworkService.registerNQEListener(this);
                    MutableStateFlow<NetworkQualityState> mutableStateFlow2 = this._state;
                    nQEListenerManager$initialize$1.L$0 = mutableStateFlow2;
                    nQEListenerManager$initialize$1.label = 1;
                    Object networkQualityState = iKmpNetworkService.getNetworkQualityState(nQEListenerManager$initialize$1);
                    if (networkQualityState == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = networkQualityState;
                    mutableStateFlow = mutableStateFlow2;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    mutableStateFlow = (MutableStateFlow) nQEListenerManager$initialize$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                mutableStateFlow.setValue(obj);
                return Unit.INSTANCE;
            }
        }
        nQEListenerManager$initialize$1 = new NQEListenerManager$initialize$1(this, continuation);
        Object obj2 = nQEListenerManager$initialize$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = nQEListenerManager$initialize$1.label;
        if (i != 0) {
        }
        mutableStateFlow.setValue(obj2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0057 A[Catch: all -> 0x0064, TryCatch #0 {all -> 0x0064, blocks: (B:11:0x004f, B:13:0x0057, B:14:0x005c), top: B:10:0x004f }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object registerListener(NQEListener nQEListener, Continuation<? super Unit> continuation) {
        NQEListenerManager$registerListener$1 nQEListenerManager$registerListener$1;
        int i;
        Mutex mutex;
        try {
            if (continuation instanceof NQEListenerManager$registerListener$1) {
                nQEListenerManager$registerListener$1 = (NQEListenerManager$registerListener$1) continuation;
                if ((nQEListenerManager$registerListener$1.label & Integer.MIN_VALUE) != 0) {
                    nQEListenerManager$registerListener$1.label -= Integer.MIN_VALUE;
                    Object obj = nQEListenerManager$registerListener$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = nQEListenerManager$registerListener$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        mutex = this.listenersMutex;
                        nQEListenerManager$registerListener$1.L$0 = nQEListener;
                        nQEListenerManager$registerListener$1.L$1 = mutex;
                        nQEListenerManager$registerListener$1.label = 1;
                        if (mutex.lock((Object) null, nQEListenerManager$registerListener$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        Mutex mutex2 = (Mutex) nQEListenerManager$registerListener$1.L$1;
                        NQEListener nQEListener2 = (NQEListener) nQEListenerManager$registerListener$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        mutex = mutex2;
                        nQEListener = nQEListener2;
                    }
                    if (!this.listeners.contains(nQEListener)) {
                        this.listeners.add(nQEListener);
                    }
                    Unit unit = Unit.INSTANCE;
                    mutex.unlock((Object) null);
                    return Unit.INSTANCE;
                }
            }
            if (!this.listeners.contains(nQEListener)) {
            }
            Unit unit2 = Unit.INSTANCE;
            mutex.unlock((Object) null);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            mutex.unlock((Object) null);
            throw th;
        }
        nQEListenerManager$registerListener$1 = new NQEListenerManager$registerListener$1(this, continuation);
        Object obj2 = nQEListenerManager$registerListener$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = nQEListenerManager$registerListener$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object removeListener(NQEListener nQEListener, Continuation<? super Unit> continuation) {
        NQEListenerManager$removeListener$1 nQEListenerManager$removeListener$1;
        int i;
        Mutex mutex;
        try {
            if (continuation instanceof NQEListenerManager$removeListener$1) {
                nQEListenerManager$removeListener$1 = (NQEListenerManager$removeListener$1) continuation;
                if ((nQEListenerManager$removeListener$1.label & Integer.MIN_VALUE) != 0) {
                    nQEListenerManager$removeListener$1.label -= Integer.MIN_VALUE;
                    Object obj = nQEListenerManager$removeListener$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = nQEListenerManager$removeListener$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        mutex = this.listenersMutex;
                        nQEListenerManager$removeListener$1.L$0 = nQEListener;
                        nQEListenerManager$removeListener$1.L$1 = mutex;
                        nQEListenerManager$removeListener$1.label = 1;
                        if (mutex.lock((Object) null, nQEListenerManager$removeListener$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        Mutex mutex2 = (Mutex) nQEListenerManager$removeListener$1.L$1;
                        NQEListener nQEListener2 = (NQEListener) nQEListenerManager$removeListener$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        mutex = mutex2;
                        nQEListener = nQEListener2;
                    }
                    this.listeners.remove(nQEListener);
                    mutex.unlock((Object) null);
                    return Unit.INSTANCE;
                }
            }
            this.listeners.remove(nQEListener);
            mutex.unlock((Object) null);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            mutex.unlock((Object) null);
            throw th;
        }
        nQEListenerManager$removeListener$1 = new NQEListenerManager$removeListener$1(this, continuation);
        Object obj2 = nQEListenerManager$removeListener$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = nQEListenerManager$removeListener$1.label;
        if (i != 0) {
        }
    }

    public final RttAndThroughput getNetworkQuality() {
        return ((NetworkQualityState) this.state.getValue()).getRttAndThroughput();
    }

    public final EffectiveConnectionType getEffectiveConnectionType() {
        return ((NetworkQualityState) this.state.getValue()).getEffectiveConnectionType();
    }

    public final PacketLoss getPacketLossRateMetrics(int protocol) {
        if (protocol == 0) {
            return ((NetworkQualityState) this.state.getValue()).getTcpPacketLoss();
        }
        if (protocol == 1) {
            return ((NetworkQualityState) this.state.getValue()).getQuicPacketLoss();
        }
        return PacketLoss.INSTANCE.getINVALID();
    }

    @Override // com.bytedance.kmp.network.nqe.NQEListener
    public void onRTTOrThroughputEstimatesComputed(int httpRttMs, int transportRttMs, int downstreamThroughputKbps) {
        Object value;
        MutableStateFlow<NetworkQualityState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, NetworkQualityState.copy$default((NetworkQualityState) value, null, new RttAndThroughput(httpRttMs, transportRttMs, downstreamThroughputKbps), null, null, 13, null)));
        BuildersKt.launch$default(this.managerScope, (CoroutineContext) null, (CoroutineStart) null, new NQEListenerManager$onRTTOrThroughputEstimatesComputed$2(this, httpRttMs, transportRttMs, downstreamThroughputKbps, null), 3, (Object) null);
    }

    @Override // com.bytedance.kmp.network.nqe.NQEListener
    public void onEffectiveConnectionTypeChanged(EffectiveConnectionType type) {
        Object value;
        Intrinsics.checkNotNullParameter(type, "type");
        MutableStateFlow<NetworkQualityState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, NetworkQualityState.copy$default((NetworkQualityState) value, type, null, null, null, 14, null)));
        BuildersKt.launch$default(this.managerScope, (CoroutineContext) null, (CoroutineStart) null, new NQEListenerManager$onEffectiveConnectionTypeChanged$2(this, type, null), 3, (Object) null);
    }

    @Override // com.bytedance.kmp.network.nqe.NQEListener
    public void onPacketLossComputed(int protocol, double upstreamLossRate, double upstreamLossRateVariance, double downstreamLossRate, double downstreamLossRateVariance) {
        Object value;
        NetworkQualityState networkQualityState;
        PacketLoss packetLoss = new PacketLoss(protocol, upstreamLossRate, upstreamLossRateVariance, downstreamLossRate, downstreamLossRateVariance);
        MutableStateFlow<NetworkQualityState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
            networkQualityState = (NetworkQualityState) value;
            if (protocol == 0) {
                networkQualityState = NetworkQualityState.copy$default(networkQualityState, null, null, packetLoss, null, 11, null);
            } else if (protocol == 1) {
                networkQualityState = NetworkQualityState.copy$default(networkQualityState, null, null, null, packetLoss, 7, null);
            }
        } while (!mutableStateFlow.compareAndSet(value, networkQualityState));
        BuildersKt.launch$default(this.managerScope, (CoroutineContext) null, (CoroutineStart) null, new NQEListenerManager$onPacketLossComputed$2(this, protocol, upstreamLossRate, upstreamLossRateVariance, downstreamLossRate, downstreamLossRateVariance, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object dispatchToListeners(Function1<? super NQEListener, Unit> function1, Continuation<? super Unit> continuation) {
        NQEListenerManager$dispatchToListeners$1 nQEListenerManager$dispatchToListeners$1;
        int i;
        Function1<? super NQEListener, Unit> function12;
        Mutex mutex;
        Iterator it;
        String str;
        try {
            if (continuation instanceof NQEListenerManager$dispatchToListeners$1) {
                nQEListenerManager$dispatchToListeners$1 = (NQEListenerManager$dispatchToListeners$1) continuation;
                if ((nQEListenerManager$dispatchToListeners$1.label & Integer.MIN_VALUE) != 0) {
                    nQEListenerManager$dispatchToListeners$1.label -= Integer.MIN_VALUE;
                    Object obj = nQEListenerManager$dispatchToListeners$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = nQEListenerManager$dispatchToListeners$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        Mutex mutex2 = this.listenersMutex;
                        nQEListenerManager$dispatchToListeners$1.L$0 = function1;
                        nQEListenerManager$dispatchToListeners$1.L$1 = mutex2;
                        nQEListenerManager$dispatchToListeners$1.label = 1;
                        if (mutex2.lock((Object) null, nQEListenerManager$dispatchToListeners$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function12 = function1;
                        mutex = mutex2;
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        mutex = (Mutex) nQEListenerManager$dispatchToListeners$1.L$1;
                        function12 = (Function1) nQEListenerManager$dispatchToListeners$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    List list = CollectionsKt.toList(this.listeners);
                    mutex.unlock((Object) null);
                    it = list.iterator();
                    while (it.hasNext()) {
                        try {
                            function12.invoke((NQEListener) it.next());
                        } catch (Exception e) {
                            NLog nLog = NLog.INSTANCE;
                            NLog.Level level = NLog.Level.ERROR;
                            if (level.compareTo(nLog.getLevel()) >= 0) {
                                String str2 = "Error in NQEListener callback: " + e.getMessage();
                                if (str2 == null || (str = str2.toString()) == null) {
                                    str = "null";
                                }
                                System.out.println((Object) ("[" + StringsKt.first(level.name()) + "][kmp-ttnet] " + str));
                                System.out.println((Object) ("[" + StringsKt.first(level.name()) + "][kmp-ttnet] Exception: " + e));
                            }
                        }
                    }
                    return Unit.INSTANCE;
                }
            }
            List list2 = CollectionsKt.toList(this.listeners);
            mutex.unlock((Object) null);
            it = list2.iterator();
            while (it.hasNext()) {
            }
            return Unit.INSTANCE;
        } catch (Throwable th) {
            mutex.unlock((Object) null);
            throw th;
        }
        nQEListenerManager$dispatchToListeners$1 = new NQEListenerManager$dispatchToListeners$1(this, continuation);
        Object obj2 = nQEListenerManager$dispatchToListeners$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = nQEListenerManager$dispatchToListeners$1.label;
        if (i != 0) {
        }
    }
}
