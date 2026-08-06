package com.example.interopdemo;

import com.bytedance.webx.seclink.util.ReportUtil;
import com.example.interopdemo.nqe.NQEBridgeAdapter;
import com.example.interopdemo.nqe.NativeNQEListener;
import com.example.interopdemo.nqe.NativePacketLostStats;
import com.example.interopdemo.nqe.NativeRTTAndThroughput;
import com.example.interopdemo.websocket.NativeRawWsClient;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NativeTTNetworkClient.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u001cH\u0086@¢\u0006\u0002\u0010\u001dR\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001e"}, d2 = {"Lcom/example/interopdemo/NativeTTNetworkClient;", "", "<init>", "()V", "nqeAdapter", "Lcom/example/interopdemo/nqe/NQEBridgeAdapter;", "getNqeAdapter", "()Lcom/example/interopdemo/nqe/NQEBridgeAdapter;", "nqeAdapter$delegate", "Lkotlin/Lazy;", "getCall", "Lcom/example/interopdemo/SsHttpCall;", "getWsClient", "Lcom/example/interopdemo/websocket/NativeRawWsClient;", "registerNQEListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/example/interopdemo/nqe/NativeNQEListener;", "getRTTAndThroughput", "Lcom/example/interopdemo/nqe/NativeRTTAndThroughput;", "getPacketLostStats", "Lcom/example/interopdemo/nqe/NativePacketLostStats;", "getEffectiveConnectionType", "", "preConnect", ReportUtil.Params.HOST, "", "getMultiNetState", "Lcom/example/interopdemo/NativeMultiNetState;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kmpNativeInterface_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class NativeTTNetworkClient {
    public static final NativeTTNetworkClient INSTANCE = new NativeTTNetworkClient();

    /* renamed from: nqeAdapter$delegate, reason: from kotlin metadata */
    private static final Lazy nqeAdapter = LazyKt.lazy(new Function0() { // from class: com.example.interopdemo.NativeTTNetworkClient$$ExternalSyntheticLambda0
        public final Object invoke() {
            NQEBridgeAdapter nqeAdapter_delegate$lambda$0;
            nqeAdapter_delegate$lambda$0 = NativeTTNetworkClient.nqeAdapter_delegate$lambda$0();
            return nqeAdapter_delegate$lambda$0;
        }
    });

    private NativeTTNetworkClient() {
    }

    private final NQEBridgeAdapter getNqeAdapter() {
        return (NQEBridgeAdapter) nqeAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NQEBridgeAdapter nqeAdapter_delegate$lambda$0() {
        return new NQEBridgeAdapter();
    }

    public final SsHttpCall getCall() {
        return new SsHttpCall();
    }

    public final NativeRawWsClient getWsClient() {
        return new NativeRawWsClient();
    }

    public final void registerNQEListener(NativeNQEListener listener) {
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        System.out.println((Object) ("registerNQEListener " + listener));
        getNqeAdapter().register(listener);
    }

    public final NativeRTTAndThroughput getRTTAndThroughput() {
        return getNqeAdapter().getRTTAndThroughput();
    }

    public final NativePacketLostStats getPacketLostStats() {
        return getNqeAdapter().getPacketLostStats();
    }

    public final int getEffectiveConnectionType() {
        return getNqeAdapter().getEffectiveConnectionType();
    }

    public final void preConnect(String host) {
        Intrinsics.checkNotNullParameter(host, ReportUtil.Params.HOST);
        TTNetworkUtils.INSTANCE.preConnect(host);
    }

    public final Object getMultiNetState(Continuation<? super NativeMultiNetState> continuation) {
        return TTNetworkUtils.INSTANCE.getMultiNetState(continuation);
    }
}
