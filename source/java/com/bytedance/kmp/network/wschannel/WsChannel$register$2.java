package com.bytedance.kmp.network.wschannel;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: WsChannel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.kmp.network.wschannel.WsChannel$register$2", f = "WsChannel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
final class WsChannel$register$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ChannelInfo $info;
    final /* synthetic */ IWsEventListener $listener;
    int label;
    final /* synthetic */ WsChannel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WsChannel$register$2(WsChannel wsChannel, ChannelInfo channelInfo, IWsEventListener iWsEventListener, Continuation<? super WsChannel$register$2> continuation) {
        super(2, continuation);
        this.this$0 = wsChannel;
        this.$info = channelInfo;
        this.$listener = iWsEventListener;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WsChannel$register$2(this.this$0, this.$info, this.$listener, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IWsService iWsService;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        WsChannel wsChannel = this.this$0;
        iWsService = wsChannel.wsService;
        wsChannel.channelId = iWsService.register(this.$info, this.$listener);
        return Unit.INSTANCE;
    }
}
