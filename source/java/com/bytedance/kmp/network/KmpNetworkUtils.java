package com.bytedance.kmp.network;

import com.bytedance.kmp.network.multinet.MultiNetState;
import com.bytedance.kmp.network.multinet.MultiNetStateValue;
import com.bytedance.kmp.network.nqe.EffectiveConnectionType;
import com.bytedance.kmp.network.nqe.NQEListener;
import com.bytedance.kmp.network.nqe.NQEListenerManager;
import com.bytedance.kmp.network.nqe.PacketLoss;
import com.bytedance.kmp.network.nqe.RttAndThroughput;
import com.bytedance.kmp.network.requet.Request;
import com.example.interopdemo.NativeMultiNetState;
import com.example.interopdemo.NativeTTNetworkClient;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.atomicfu.AtomicBoolean;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* compiled from: KmpNetworkUtils.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u0010\u0015J\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"J\u0016\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020%H\u0086@¢\u0006\u0002\u0010&J\u0016\u0010'\u001a\u00020\u00102\u0006\u0010$\u001a\u00020%H\u0086@¢\u0006\u0002\u0010&R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/bytedance/kmp/network/KmpNetworkUtils;", "", "()V", "isInitialized", "Lkotlinx/atomicfu/AtomicBoolean;", "nqeListenerManager", "Lcom/bytedance/kmp/network/nqe/NQEListenerManager;", "getNqeListenerManager", "()Lcom/bytedance/kmp/network/nqe/NQEListenerManager;", "nqeListenerManager$delegate", "Lkotlin/Lazy;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "service", "Lcom/bytedance/kmp/network/IKmpNetworkService;", "ensureNQEInitialized", "", "getEffectiveConnectionType", "Lcom/bytedance/kmp/network/nqe/EffectiveConnectionType;", "getMultiNetState", "Lcom/bytedance/kmp/network/multinet/MultiNetState;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNetworkQuality", "Lcom/bytedance/kmp/network/nqe/RttAndThroughput;", "getPacketLossRateMetrics", "Lcom/bytedance/kmp/network/nqe/PacketLoss;", "protocol", "", "isPureRequest", "", "request", "Lcom/bytedance/kmp/network/requet/Request;", "preConnect", "url", "", "registerNQEListener", "listener", "Lcom/bytedance/kmp/network/nqe/NQEListener;", "(Lcom/bytedance/kmp/network/nqe/NQEListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeNQEListener", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class KmpNetworkUtils {
    public static final KmpNetworkUtils INSTANCE = new KmpNetworkUtils();

    /* renamed from: nqeListenerManager$delegate, reason: from kotlin metadata */
    private static final Lazy nqeListenerManager = LazyKt.lazy(new Function0<NQEListenerManager>() { // from class: com.bytedance.kmp.network.KmpNetworkUtils$nqeListenerManager$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final NQEListenerManager m678invoke() {
            return new NQEListenerManager();
        }
    });
    private static final IKmpNetworkService service = KmpNetworkService_androidKt.getKmpNetworkService();
    private static final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getDefault()));
    private static final AtomicBoolean isInitialized = AtomicFU.atomic(false);

    private KmpNetworkUtils() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NQEListenerManager getNqeListenerManager() {
        return (NQEListenerManager) nqeListenerManager.getValue();
    }

    private final void ensureNQEInitialized() {
        if (isInitialized.compareAndSet(false, true)) {
            BuildersKt.launch$default(scope, (CoroutineContext) null, (CoroutineStart) null, new KmpNetworkUtils$ensureNQEInitialized$1(null), 3, (Object) null);
        }
    }

    public final Object registerNQEListener(NQEListener nQEListener, Continuation<? super Unit> continuation) {
        ensureNQEInitialized();
        Object registerListener = getNqeListenerManager().registerListener(nQEListener, continuation);
        return registerListener == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? registerListener : Unit.INSTANCE;
    }

    public final Object removeNQEListener(NQEListener nQEListener, Continuation<? super Unit> continuation) {
        ensureNQEInitialized();
        Object removeListener = getNqeListenerManager().removeListener(nQEListener, continuation);
        return removeListener == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? removeListener : Unit.INSTANCE;
    }

    public final RttAndThroughput getNetworkQuality() {
        ensureNQEInitialized();
        return getNqeListenerManager().getNetworkQuality();
    }

    public final EffectiveConnectionType getEffectiveConnectionType() {
        ensureNQEInitialized();
        return getNqeListenerManager().getEffectiveConnectionType();
    }

    public static /* synthetic */ PacketLoss getPacketLossRateMetrics$default(KmpNetworkUtils kmpNetworkUtils, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        return kmpNetworkUtils.getPacketLossRateMetrics(i);
    }

    public final PacketLoss getPacketLossRateMetrics(int protocol) {
        ensureNQEInitialized();
        return getNqeListenerManager().getPacketLossRateMetrics(protocol);
    }

    public final void preConnect(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        service.preConnect(url);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getMultiNetState(Continuation<? super MultiNetState> continuation) {
        KmpNetworkUtils$getMultiNetState$1 kmpNetworkUtils$getMultiNetState$1;
        int i;
        if (continuation instanceof KmpNetworkUtils$getMultiNetState$1) {
            kmpNetworkUtils$getMultiNetState$1 = (KmpNetworkUtils$getMultiNetState$1) continuation;
            if ((kmpNetworkUtils$getMultiNetState$1.label & Integer.MIN_VALUE) != 0) {
                kmpNetworkUtils$getMultiNetState$1.label -= Integer.MIN_VALUE;
                Object obj = kmpNetworkUtils$getMultiNetState$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = kmpNetworkUtils$getMultiNetState$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    NativeTTNetworkClient nativeTTNetworkClient = NativeTTNetworkClient.INSTANCE;
                    kmpNetworkUtils$getMultiNetState$1.label = 1;
                    obj = nativeTTNetworkClient.getMultiNetState(kmpNetworkUtils$getMultiNetState$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                NativeMultiNetState nativeMultiNetState = (NativeMultiNetState) obj;
                return new MultiNetState(MultiNetStateValue.INSTANCE.fromValue(nativeMultiNetState.getPreState()), MultiNetStateValue.INSTANCE.fromValue(nativeMultiNetState.getCurState()));
            }
        }
        kmpNetworkUtils$getMultiNetState$1 = new KmpNetworkUtils$getMultiNetState$1(this, continuation);
        Object obj2 = kmpNetworkUtils$getMultiNetState$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = kmpNetworkUtils$getMultiNetState$1.label;
        if (i != 0) {
        }
        NativeMultiNetState nativeMultiNetState2 = (NativeMultiNetState) obj2;
        return new MultiNetState(MultiNetStateValue.INSTANCE.fromValue(nativeMultiNetState2.getPreState()), MultiNetStateValue.INSTANCE.fromValue(nativeMultiNetState2.getCurState()));
    }

    public final boolean isPureRequest(Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return Intrinsics.areEqual(request.getHeaders().get(com.bytedance.retrofit2.client.Request.KEY_BYPASS_TTNET_FEATURES), "1");
    }
}
