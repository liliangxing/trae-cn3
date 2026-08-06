package com.example.interopdemo;

import com.bytedance.bdturing.methods.JsCallParser;
import com.example.interopdemo.websocket.NativeRawWsInfo;
import com.example.interopdemo.websocket.NativeRawWsListener;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;

/* compiled from: WsClient.android.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\rJ\u000e\u0010\u000e\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\rJ\u0016\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0012J\u0016\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0013H\u0096@¢\u0006\u0002\u0010\u0014J\u000e\u0010\u0015\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/example/interopdemo/AndroidWsClient;", "Lcom/example/interopdemo/WsClient;", "<init>", "()V", "register", "", "info", "Lcom/example/interopdemo/websocket/NativeRawWsInfo;", JsCallParser.VALUE_CALLBACK, "Lcom/example/interopdemo/websocket/NativeRawWsListener;", "(Lcom/example/interopdemo/websocket/NativeRawWsInfo;Lcom/example/interopdemo/websocket/NativeRawWsListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startConnection", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopConnection", "sendMsg", "msg", "", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isConnected", "kmpNativeInterface_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class AndroidWsClient implements WsClient {
    @Override // com.example.interopdemo.WsClient
    public Object register(NativeRawWsInfo nativeRawWsInfo, NativeRawWsListener nativeRawWsListener, Continuation<? super Integer> continuation) {
        return Boxing.boxInt(0);
    }

    @Override // com.example.interopdemo.WsClient
    public Object startConnection(Continuation<? super Boolean> continuation) {
        return Boxing.boxBoolean(true);
    }

    @Override // com.example.interopdemo.WsClient
    public Object stopConnection(Continuation<? super Boolean> continuation) {
        return Boxing.boxBoolean(true);
    }

    @Override // com.example.interopdemo.WsClient
    public Object sendMsg(byte[] bArr, Continuation<? super Boolean> continuation) {
        return Boxing.boxBoolean(true);
    }

    @Override // com.example.interopdemo.WsClient
    public Object sendMsg(String str, Continuation<? super Boolean> continuation) {
        return Boxing.boxBoolean(true);
    }

    @Override // com.example.interopdemo.WsClient
    public Object isConnected(Continuation<? super Boolean> continuation) {
        return Boxing.boxBoolean(true);
    }
}
