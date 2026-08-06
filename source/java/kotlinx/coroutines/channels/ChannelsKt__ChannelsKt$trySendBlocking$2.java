package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import net.openid.appauth.BuildConfig;
import org.bouncycastle.asn1.eac.EACTags;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Channels.kt */
@Metadata(m4d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u0003*\u00020\u0004H\u008a@"}, m5d2 = {"<anonymous>", "Lkotlinx/coroutines/channels/ChannelResult;", BuildConfig.FLAVOR, "E", "Lkotlinx/coroutines/CoroutineScope;"}, m6k = 3, m7mv = {1, 9, 0}, m9xi = 48)
@DebugMetadata(m41c = "kotlinx.coroutines.channels.ChannelsKt__ChannelsKt$trySendBlocking$2", m42f = "Channels.kt", m43i = {}, m44l = {EACTags.INTERCHANGE_CONTROL}, m45m = "invokeSuspend", m46n = {}, m47s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class ChannelsKt__ChannelsKt$trySendBlocking$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ChannelResult<? extends Unit>>, Object> {
    final /* synthetic */ E $element;
    final /* synthetic */ SendChannel<E> $this_trySendBlocking;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__ChannelsKt$trySendBlocking$2(SendChannel<? super E> sendChannel, E e, Continuation<? super ChannelsKt__ChannelsKt$trySendBlocking$2> continuation) {
        super(2, continuation);
        this.$this_trySendBlocking = sendChannel;
        this.$element = e;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChannelsKt__ChannelsKt$trySendBlocking$2 channelsKt__ChannelsKt$trySendBlocking$2 = new ChannelsKt__ChannelsKt$trySendBlocking$2(this.$this_trySendBlocking, this.$element, continuation);
        channelsKt__ChannelsKt$trySendBlocking$2.L$0 = obj;
        return channelsKt__ChannelsKt$trySendBlocking$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super ChannelResult<? extends Unit>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super ChannelResult<Unit>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super ChannelResult<Unit>> continuation) {
        return ((ChannelsKt__ChannelsKt$trySendBlocking$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m378constructorimpl;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SendChannel<E> sendChannel = this.$this_trySendBlocking;
                E e = this.$element;
                Result.Companion companion = Result.INSTANCE;
                this.label = 1;
                if (sendChannel.send(e, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            m378constructorimpl = Result.m378constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m378constructorimpl = Result.m378constructorimpl(ResultKt.createFailure(th));
        }
        return ChannelResult.m1891boximpl(Result.m385isSuccessimpl(m378constructorimpl) ? ChannelResult.INSTANCE.m1906successJP2dKIU(Unit.INSTANCE) : ChannelResult.INSTANCE.m1904closedJP2dKIU(Result.m381exceptionOrNullimpl(m378constructorimpl)));
    }
}
