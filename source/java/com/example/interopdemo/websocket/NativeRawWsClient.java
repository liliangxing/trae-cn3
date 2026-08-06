package com.example.interopdemo.websocket;

import com.example.interopdemo.WsClient;
import com.example.interopdemo.WsClient_androidKt;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* compiled from: RawNativeWsClient.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\fJ\u000e\u0010\r\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u000fJ\u000e\u0010\u0010\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u0014J\u0016\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0015H\u0086@¢\u0006\u0002\u0010\u0016J\u000e\u0010\u0017\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/example/interopdemo/websocket/NativeRawWsClient;", "", "<init>", "()V", "wsClient", "Lcom/example/interopdemo/WsClient;", "register", "", "info", "Lcom/example/interopdemo/websocket/NativeRawWsInfo;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/example/interopdemo/websocket/NativeRawWsListener;", "(Lcom/example/interopdemo/websocket/NativeRawWsInfo;Lcom/example/interopdemo/websocket/NativeRawWsListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startConnection", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopConnection", "sendMsg", "msg", "", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isConnected", "kmpNativeInterface_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class NativeRawWsClient {
    private final WsClient wsClient = WsClient_androidKt.newWsClient();

    public final Object register(NativeRawWsInfo nativeRawWsInfo, NativeRawWsListener nativeRawWsListener, Continuation<? super Unit> continuation) {
        Object register = this.wsClient.register(nativeRawWsInfo, nativeRawWsListener, continuation);
        return register == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? register : Unit.INSTANCE;
    }

    public final Object startConnection(Continuation<? super Boolean> continuation) {
        return this.wsClient.startConnection(continuation);
    }

    public final Object stopConnection(Continuation<? super Boolean> continuation) {
        return this.wsClient.stopConnection(continuation);
    }

    public final Object sendMsg(byte[] bArr, Continuation<? super Boolean> continuation) {
        return this.wsClient.sendMsg(bArr, continuation);
    }

    public final Object sendMsg(String str, Continuation<? super Boolean> continuation) {
        return this.wsClient.sendMsg(str, continuation);
    }

    public final Object isConnected(Continuation<? super Boolean> continuation) {
        return this.wsClient.isConnected(continuation);
    }
}
