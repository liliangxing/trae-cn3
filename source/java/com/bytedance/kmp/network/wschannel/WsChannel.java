package com.bytedance.kmp.network.wschannel;

import com.bytedance.kmp.spi.IKmpService;
import com.bytedance.kmp.spi.KmpServiceManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: WsChannel.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010\tJ\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u0014J\u0016\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u0017J\u000e\u0010\u0018\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\tJ\u000e\u0010\u0019\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/kmp/network/wschannel/WsChannel;", "", "()V", "channelId", "", "wsService", "Lcom/bytedance/kmp/network/wschannel/IWsService;", "isConnected", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "register", "", "info", "Lcom/bytedance/kmp/network/wschannel/ChannelInfo;", "listener", "Lcom/bytedance/kmp/network/wschannel/IWsEventListener;", "(Lcom/bytedance/kmp/network/wschannel/ChannelInfo;Lcom/bytedance/kmp/network/wschannel/IWsEventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendMsg", "msg", "Lcom/bytedance/kmp/network/wschannel/WsChannelMsg;", "(Lcom/bytedance/kmp/network/wschannel/WsChannelMsg;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setNewParams", "channelInfo", "(Lcom/bytedance/kmp/network/wschannel/ChannelInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startConnection", "stopConnection", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class WsChannel {
    private int channelId;
    private final IWsService wsService;

    public WsChannel() {
        IKmpService iKmpService = KmpServiceManager.INSTANCE.get(Reflection.getOrCreateKotlinClass(IWsService.class));
        Intrinsics.checkNotNull(iKmpService);
        this.wsService = (IWsService) iKmpService;
        this.channelId = -1;
    }

    public final Object register(ChannelInfo channelInfo, IWsEventListener iWsEventListener, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new WsChannel$register$2(this, channelInfo, iWsEventListener, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object startConnection(Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new WsChannel$startConnection$2(this, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object stopConnection(Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new WsChannel$stopConnection$2(this, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object setNewParams(ChannelInfo channelInfo, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new WsChannel$setNewParams$2(this, channelInfo, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object sendMsg(WsChannelMsg wsChannelMsg, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new WsChannel$sendMsg$2(this, wsChannelMsg, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object isConnected(Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new WsChannel$isConnected$2(this, null), continuation);
    }
}
