package com.example.interopdemo;

import com.example.interopdemo.websocket.NativeRawWsInfo;
import com.example.interopdemo.websocket.NativeRawWsListener;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: WsClient.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\nH¦@¢\u0006\u0002\u0010\u000bJ\u000e\u0010\f\u001a\u00020\nH¦@¢\u0006\u0002\u0010\u000bJ\u0016\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH¦@¢\u0006\u0002\u0010\u0010J\u0016\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0011H¦@¢\u0006\u0002\u0010\u0012J\u000e\u0010\u0013\u001a\u00020\nH¦@¢\u0006\u0002\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/example/interopdemo/WsClient;", "", "register", "", "info", "Lcom/example/interopdemo/websocket/NativeRawWsInfo;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/example/interopdemo/websocket/NativeRawWsListener;", "(Lcom/example/interopdemo/websocket/NativeRawWsInfo;Lcom/example/interopdemo/websocket/NativeRawWsListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startConnection", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopConnection", "sendMsg", "msg", "", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isConnected", "kmpNativeInterface_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface WsClient {
    Object isConnected(Continuation<? super Boolean> continuation);

    Object register(NativeRawWsInfo nativeRawWsInfo, NativeRawWsListener nativeRawWsListener, Continuation<? super Integer> continuation);

    Object sendMsg(String str, Continuation<? super Boolean> continuation);

    Object sendMsg(byte[] bArr, Continuation<? super Boolean> continuation);

    Object startConnection(Continuation<? super Boolean> continuation);

    Object stopConnection(Continuation<? super Boolean> continuation);
}
