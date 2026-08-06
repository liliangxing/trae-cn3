package com.bytedance.kmp.network.websocket;

import com.bytedance.kmp.spi.IKmpService;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: IRawWsService.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\fJ\u001e\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH¦@¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/bytedance/kmp/network/websocket/IRawWsService;", "Lcom/bytedance/kmp/spi/IKmpService;", "isConnected", "", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "register", "info", "Lcom/bytedance/kmp/network/websocket/RawWebsocketInfo;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/bytedance/kmp/network/websocket/IRawWsEventListener;", "(Lcom/bytedance/kmp/network/websocket/RawWebsocketInfo;Lcom/bytedance/kmp/network/websocket/IRawWsEventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendMsg", "msg", "Lcom/bytedance/kmp/network/websocket/RawWebsocketlMsg;", "(ILcom/bytedance/kmp/network/websocket/RawWebsocketlMsg;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startConnection", "stopConnection", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface IRawWsService extends IKmpService {
    Object isConnected(int i, Continuation<? super Boolean> continuation);

    Object register(RawWebsocketInfo rawWebsocketInfo, IRawWsEventListener iRawWsEventListener, Continuation<? super Integer> continuation);

    Object sendMsg(int i, RawWebsocketlMsg rawWebsocketlMsg, Continuation<? super Boolean> continuation);

    Object startConnection(int i, Continuation<? super Boolean> continuation);

    Object stopConnection(int i, Continuation<? super Boolean> continuation);
}
