package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import me.ele.lancet.base.annotations.ClassOf;
import net.openid.appauth.BuildConfig;

/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: Deprecated.kt */
@Metadata(m4d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, m5d2 = {"<anonymous>", BuildConfig.FLAVOR, "E", "Lkotlinx/coroutines/channels/ProducerScope;"}, m6k = 3, m7mv = {1, 9, 0}, m9xi = 48)
@DebugMetadata(m41c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterIndexed$1", m42f = "Deprecated.kt", m43i = {0, 0, 1, 1, 1, 2, 2}, m44l = {241, 242, 242}, m45m = "invokeSuspend", m46n = {"$this$produce", ClassOf.INDEX, "$this$produce", "e", ClassOf.INDEX, "$this$produce", ClassOf.INDEX}, m47s = {"L$0", "I$0", "L$0", "L$2", "I$0", "L$0", "I$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
final class ChannelsKt__DeprecatedKt$filterIndexed$1<E> extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<Integer, E, Continuation<? super Boolean>, Object> $predicate;
    final /* synthetic */ ReceiveChannel<E> $this_filterIndexed;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__DeprecatedKt$filterIndexed$1(ReceiveChannel<? extends E> receiveChannel, Function3<? super Integer, ? super E, ? super Continuation<? super Boolean>, ? extends Object> function3, Continuation<? super ChannelsKt__DeprecatedKt$filterIndexed$1> continuation) {
        super(2, continuation);
        this.$this_filterIndexed = receiveChannel;
        this.$predicate = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$filterIndexed$1 channelsKt__DeprecatedKt$filterIndexed$1 = new ChannelsKt__DeprecatedKt$filterIndexed$1(this.$this_filterIndexed, this.$predicate, continuation);
        channelsKt__DeprecatedKt$filterIndexed$1.L$0 = obj;
        return channelsKt__DeprecatedKt$filterIndexed$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ProducerScope<? super E> producerScope, Continuation<? super Unit> continuation) {
        return ((ChannelsKt__DeprecatedKt$filterIndexed$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0066, code lost:
    
        r13 = r0;
        r0 = r1;
        r7 = r8;
        r1 = r10;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00cb  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ProducerScope producerScope;
        ChannelsKt__DeprecatedKt$filterIndexed$1<E> channelsKt__DeprecatedKt$filterIndexed$1;
        ChannelIterator<E> it;
        int i;
        ChannelIterator<E> channelIterator;
        int i2;
        ProducerScope producerScope2;
        E e;
        Object obj2;
        ChannelsKt__DeprecatedKt$filterIndexed$1<E> channelsKt__DeprecatedKt$filterIndexed$12;
        ChannelIterator<E> channelIterator2;
        int i3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.label;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            producerScope = (ProducerScope) this.L$0;
            channelsKt__DeprecatedKt$filterIndexed$1 = this;
            it = this.$this_filterIndexed.iterator();
            i = 0;
        } else if (i4 == 1) {
            int i5 = this.I$0;
            ChannelIterator<E> channelIterator3 = (ChannelIterator) this.L$1;
            ProducerScope producerScope3 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            producerScope2 = producerScope3;
            channelIterator2 = channelIterator3;
            i3 = i5;
            obj2 = coroutine_suspended;
            channelsKt__DeprecatedKt$filterIndexed$12 = this;
            if (!((Boolean) obj).booleanValue()) {
                E next = channelIterator2.next();
                Function3<Integer, E, Continuation<? super Boolean>, Object> function3 = channelsKt__DeprecatedKt$filterIndexed$12.$predicate;
                i2 = i3 + 1;
                Integer boxInt = Boxing.boxInt(i3);
                channelsKt__DeprecatedKt$filterIndexed$12.L$0 = producerScope2;
                channelsKt__DeprecatedKt$filterIndexed$12.L$1 = channelIterator2;
                channelsKt__DeprecatedKt$filterIndexed$12.L$2 = next;
                channelsKt__DeprecatedKt$filterIndexed$12.I$0 = i2;
                channelsKt__DeprecatedKt$filterIndexed$12.label = 2;
                Object invoke = function3.invoke(boxInt, next, channelsKt__DeprecatedKt$filterIndexed$12);
                if (invoke == obj2) {
                    return obj2;
                }
                channelIterator = channelIterator2;
                e = next;
                obj = invoke;
                it = channelIterator;
                if (((Boolean) obj).booleanValue()) {
                }
                channelsKt__DeprecatedKt$filterIndexed$1 = channelsKt__DeprecatedKt$filterIndexed$12;
                coroutine_suspended = obj2;
                producerScope = producerScope2;
                i = i2;
            } else {
                return Unit.INSTANCE;
            }
        } else if (i4 == 2) {
            int i6 = this.I$0;
            Object obj3 = this.L$2;
            ChannelIterator<E> channelIterator4 = (ChannelIterator) this.L$1;
            producerScope2 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            i2 = i6;
            obj2 = coroutine_suspended;
            channelsKt__DeprecatedKt$filterIndexed$12 = this;
            channelIterator = channelIterator4;
            e = obj3;
            it = channelIterator;
            if (((Boolean) obj).booleanValue()) {
                channelsKt__DeprecatedKt$filterIndexed$12.L$0 = producerScope2;
                channelsKt__DeprecatedKt$filterIndexed$12.L$1 = it;
                channelsKt__DeprecatedKt$filterIndexed$12.L$2 = null;
                channelsKt__DeprecatedKt$filterIndexed$12.I$0 = i2;
                channelsKt__DeprecatedKt$filterIndexed$12.label = 3;
                if (producerScope2.send(e, channelsKt__DeprecatedKt$filterIndexed$12) == obj2) {
                    return obj2;
                }
            }
            channelsKt__DeprecatedKt$filterIndexed$1 = channelsKt__DeprecatedKt$filterIndexed$12;
            coroutine_suspended = obj2;
            producerScope = producerScope2;
            i = i2;
        } else {
            if (i4 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = this.I$0;
            it = (ChannelIterator) this.L$1;
            producerScope = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            channelsKt__DeprecatedKt$filterIndexed$1 = this;
        }
        channelsKt__DeprecatedKt$filterIndexed$1.L$0 = producerScope;
        channelsKt__DeprecatedKt$filterIndexed$1.L$1 = it;
        channelsKt__DeprecatedKt$filterIndexed$1.L$2 = null;
        channelsKt__DeprecatedKt$filterIndexed$1.I$0 = i;
        channelsKt__DeprecatedKt$filterIndexed$1.label = 1;
        Object hasNext = it.hasNext(channelsKt__DeprecatedKt$filterIndexed$1);
        if (hasNext == coroutine_suspended) {
            return coroutine_suspended;
        }
        Object obj4 = coroutine_suspended;
        channelsKt__DeprecatedKt$filterIndexed$12 = channelsKt__DeprecatedKt$filterIndexed$1;
        obj = hasNext;
        producerScope2 = producerScope;
        channelIterator2 = it;
        i3 = i;
        obj2 = obj4;
        if (!((Boolean) obj).booleanValue()) {
        }
    }
}
