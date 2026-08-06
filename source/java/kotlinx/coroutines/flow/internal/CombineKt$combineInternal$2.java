package kotlinx.coroutines.flow.internal;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.YieldKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import net.openid.appauth.BuildConfig;
import org.bouncycastle.asn1.eac.EACTags;

/* compiled from: Combine.kt */
@Metadata(m4d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H\u008a@"}, m5d2 = {"<anonymous>", BuildConfig.FLAVOR, "R", "T", "Lkotlinx/coroutines/CoroutineScope;"}, m6k = 3, m7mv = {1, 9, 0}, m9xi = 48)
@DebugMetadata(m41c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2", m42f = "Combine.kt", m43i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, m44l = {EACTags.TRANSACTION_DATE, 73, 76}, m45m = "invokeSuspend", m46n = {"latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch", "latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch", "latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch"}, m47s = {"L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
final class CombineKt$combineInternal$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<T[]> $arrayFactory;
    final /* synthetic */ Flow<T>[] $flows;
    final /* synthetic */ FlowCollector<R> $this_combineInternal;
    final /* synthetic */ Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> $transform;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CombineKt$combineInternal$2(Flow<? extends T>[] flowArr, Function0<T[]> function0, Function3<? super FlowCollector<? super R>, ? super T[], ? super Continuation<? super Unit>, ? extends Object> function3, FlowCollector<? super R> flowCollector, Continuation<? super CombineKt$combineInternal$2> continuation) {
        super(2, continuation);
        this.$flows = flowArr;
        this.$arrayFactory = function0;
        this.$transform = function3;
        this.$this_combineInternal = flowCollector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CombineKt$combineInternal$2 combineKt$combineInternal$2 = new CombineKt$combineInternal$2(this.$flows, this.$arrayFactory, this.$transform, this.$this_combineInternal, continuation);
        combineKt$combineInternal$2.L$0 = obj;
        return combineKt$combineInternal$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CombineKt$combineInternal$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x00de A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0111 A[EDGE_INSN: B:39:0x0111->B:25:0x0111 BREAK  A[LOOP:0: B:17:0x00ec->B:38:?], SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r15v0, types: [kotlinx.coroutines.flow.Flow[], kotlinx.coroutines.flow.Flow<T>[]] */
    /* JADX WARN: Type inference failed for: r2v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    /* JADX WARN: Type inference failed for: r6v0, types: [kotlinx.coroutines.flow.Flow<T>[]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0134 -> B:8:0x00c6). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object[] objArr;
        byte b;
        byte[] bArr;
        CombineKt$combineInternal$2 combineKt$combineInternal$2;
        int i;
        Channel channel;
        byte b2;
        Object obj2;
        Object[] objArr2;
        IndexedValue indexedValue;
        int index;
        Object obj3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        int i3 = 2;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            int length = this.$flows.length;
            if (length == 0) {
                return Unit.INSTANCE;
            }
            objArr = new Object[length];
            ArraysKt.fill$default(objArr, NullSurrogateKt.UNINITIALIZED, 0, 0, 6, (Object) null);
            Channel Channel$default = ChannelKt.Channel$default(length, null, null, 6, null);
            AtomicInteger atomicInteger = new AtomicInteger(length);
            b = 0;
            int i4 = 0;
            while (i4 < length) {
                int i5 = i4;
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C00921(this.$flows, i5, atomicInteger, Channel$default, null), 3, null);
                i4 = i5 + 1;
                atomicInteger = atomicInteger;
            }
            bArr = new byte[length];
            combineKt$combineInternal$2 = this;
            i = length;
            channel = Channel$default;
        } else if (i2 == 1) {
            ?? r2 = this.I$1;
            i = this.I$0;
            byte[] bArr2 = (byte[]) this.L$2;
            Channel channel2 = (Channel) this.L$1;
            objArr2 = (Object[]) this.L$0;
            ResultKt.throwOnFailure(obj);
            obj2 = ((ChannelResult) obj).getHolder();
            b2 = r2;
            bArr = bArr2;
            channel = channel2;
            combineKt$combineInternal$2 = this;
            indexedValue = (IndexedValue) ChannelResult.m1896getOrNullimpl(obj2);
            if (indexedValue == null) {
                return Unit.INSTANCE;
            }
            do {
                index = indexedValue.getIndex();
                obj3 = objArr2[index];
                objArr2[index] = indexedValue.getValue();
                if (obj3 == NullSurrogateKt.UNINITIALIZED) {
                    i--;
                }
                if (bArr[index] != b2) {
                    break;
                }
                bArr[index] = b2;
                indexedValue = (IndexedValue) ChannelResult.m1896getOrNullimpl(channel.mo1885tryReceivePtdJZtk());
            } while (indexedValue != null);
            if (i != 0) {
                b = b2;
                objArr = objArr2;
            } else {
                Object[] objArr3 = (Object[]) combineKt$combineInternal$2.$arrayFactory.invoke();
                if (objArr3 == null) {
                    Function3 function3 = combineKt$combineInternal$2.$transform;
                    Object obj4 = combineKt$combineInternal$2.$this_combineInternal;
                    combineKt$combineInternal$2.L$0 = objArr2;
                    combineKt$combineInternal$2.L$1 = channel;
                    combineKt$combineInternal$2.L$2 = bArr;
                    combineKt$combineInternal$2.I$0 = i;
                    combineKt$combineInternal$2.I$1 = b2;
                    combineKt$combineInternal$2.label = i3;
                    if (function3.invoke(obj4, objArr2, combineKt$combineInternal$2) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    objArr = objArr2;
                    b = b2;
                } else {
                    byte b3 = b2;
                    ArraysKt.copyInto$default(objArr2, objArr3, 0, 0, 0, 14, (Object) null);
                    Function3 function32 = combineKt$combineInternal$2.$transform;
                    Object obj5 = combineKt$combineInternal$2.$this_combineInternal;
                    combineKt$combineInternal$2.L$0 = objArr2;
                    combineKt$combineInternal$2.L$1 = channel;
                    combineKt$combineInternal$2.L$2 = bArr;
                    combineKt$combineInternal$2.I$0 = i;
                    combineKt$combineInternal$2.I$1 = b3;
                    combineKt$combineInternal$2.label = 3;
                    if (function32.invoke(obj5, objArr3, combineKt$combineInternal$2) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    b = b3;
                    objArr = objArr2;
                }
            }
            i3 = 2;
        } else if (i2 == 2) {
            ?? r22 = this.I$1;
            i = this.I$0;
            byte[] bArr3 = (byte[]) this.L$2;
            Channel channel3 = (Channel) this.L$1;
            Object[] objArr4 = (Object[]) this.L$0;
            ResultKt.throwOnFailure(obj);
            b = r22;
            bArr = bArr3;
            channel = channel3;
            objArr = objArr4;
            combineKt$combineInternal$2 = this;
        } else {
            if (i2 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ?? r23 = this.I$1;
            i = this.I$0;
            byte[] bArr4 = (byte[]) this.L$2;
            Channel channel4 = (Channel) this.L$1;
            Object[] objArr5 = (Object[]) this.L$0;
            ResultKt.throwOnFailure(obj);
            b = r23;
            bArr = bArr4;
            channel = channel4;
            objArr = objArr5;
            combineKt$combineInternal$2 = this;
            i3 = 2;
        }
        byte b4 = (byte) (b + 1);
        combineKt$combineInternal$2.L$0 = objArr;
        combineKt$combineInternal$2.L$1 = channel;
        combineKt$combineInternal$2.L$2 = bArr;
        combineKt$combineInternal$2.I$0 = i;
        combineKt$combineInternal$2.I$1 = b4;
        combineKt$combineInternal$2.label = 1;
        obj2 = channel.mo1884receiveCatchingJP2dKIU(combineKt$combineInternal$2);
        if (obj2 != coroutine_suspended) {
            return coroutine_suspended;
        }
        b2 = b4;
        objArr2 = objArr;
        indexedValue = (IndexedValue) ChannelResult.m1896getOrNullimpl(obj2);
        if (indexedValue == null) {
        }
        do {
            index = indexedValue.getIndex();
            obj3 = objArr2[index];
            objArr2[index] = indexedValue.getValue();
            if (obj3 == NullSurrogateKt.UNINITIALIZED) {
            }
            if (bArr[index] != b2) {
            }
        } while (indexedValue != null);
        if (i != 0) {
        }
        i3 = 2;
        byte b42 = (byte) (b + 1);
        combineKt$combineInternal$2.L$0 = objArr;
        combineKt$combineInternal$2.L$1 = channel;
        combineKt$combineInternal$2.L$2 = bArr;
        combineKt$combineInternal$2.I$0 = i;
        combineKt$combineInternal$2.I$1 = b42;
        combineKt$combineInternal$2.label = 1;
        obj2 = channel.mo1884receiveCatchingJP2dKIU(combineKt$combineInternal$2);
        if (obj2 != coroutine_suspended) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Combine.kt */
    @Metadata(m4d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H\u008a@"}, m5d2 = {"<anonymous>", BuildConfig.FLAVOR, "R", "T", "Lkotlinx/coroutines/CoroutineScope;"}, m6k = 3, m7mv = {1, 9, 0}, m9xi = 48)
    @DebugMetadata(m41c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1", m42f = "Combine.kt", m43i = {}, m44l = {28}, m45m = "invokeSuspend", m46n = {}, m47s = {})
    /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    public static final class C00921 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Flow<T>[] $flows;

        /* renamed from: $i */
        final /* synthetic */ int f116$i;
        final /* synthetic */ AtomicInteger $nonClosed;
        final /* synthetic */ Channel<IndexedValue<Object>> $resultChannel;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C00921(Flow<? extends T>[] flowArr, int i, AtomicInteger atomicInteger, Channel<IndexedValue<Object>> channel, Continuation<? super C00921> continuation) {
            super(2, continuation);
            this.$flows = flowArr;
            this.f116$i = i;
            this.$nonClosed = atomicInteger;
            this.$resultChannel = channel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00921(this.$flows, this.f116$i, this.$nonClosed, this.$resultChannel, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C00921) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            AtomicInteger atomicInteger;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (this.$flows[this.f116$i].collect(new AnonymousClass1(this.$resultChannel, this.f116$i), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                if (atomicInteger.decrementAndGet() == 0) {
                    SendChannel.DefaultImpls.close$default(this.$resultChannel, null, 1, null);
                }
                return Unit.INSTANCE;
            } finally {
                if (this.$nonClosed.decrementAndGet() == 0) {
                    SendChannel.DefaultImpls.close$default(this.$resultChannel, null, 1, null);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Combine.kt */
        @Metadata(m4d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, m5d2 = {"<anonymous>", BuildConfig.FLAVOR, "R", "T", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, m6k = 3, m7mv = {1, 9, 0}, m9xi = 48)
        /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1, reason: invalid class name */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
        public static final class AnonymousClass1<T> implements FlowCollector {

            /* renamed from: $i */
            final /* synthetic */ int f117$i;
            final /* synthetic */ Channel<IndexedValue<Object>> $resultChannel;

            AnonymousClass1(Channel<IndexedValue<Object>> channel, int i) {
                this.$resultChannel = channel;
                this.f117$i = i;
            }

            /* JADX WARN: Removed duplicated region for block: B:19:0x0056 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:20:0x0039  */
            /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object emit(T t, Continuation<? super Unit> continuation) {
                CombineKt$combineInternal$2$1$1$emit$1 combineKt$combineInternal$2$1$1$emit$1;
                Object coroutine_suspended;
                int i;
                if (continuation instanceof CombineKt$combineInternal$2$1$1$emit$1) {
                    combineKt$combineInternal$2$1$1$emit$1 = (CombineKt$combineInternal$2$1$1$emit$1) continuation;
                    if ((combineKt$combineInternal$2$1$1$emit$1.label & Integer.MIN_VALUE) != 0) {
                        combineKt$combineInternal$2$1$1$emit$1.label -= Integer.MIN_VALUE;
                        Object obj = combineKt$combineInternal$2$1$1$emit$1.result;
                        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i = combineKt$combineInternal$2$1$1$emit$1.label;
                        if (i != 0) {
                            ResultKt.throwOnFailure(obj);
                            Channel<IndexedValue<Object>> channel = this.$resultChannel;
                            IndexedValue<Object> indexedValue = new IndexedValue<>(this.f117$i, t);
                            combineKt$combineInternal$2$1$1$emit$1.label = 1;
                            if (channel.send(indexedValue, combineKt$combineInternal$2$1$1$emit$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                if (i != 2) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                                return Unit.INSTANCE;
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        combineKt$combineInternal$2$1$1$emit$1.label = 2;
                        if (YieldKt.yield(combineKt$combineInternal$2$1$1$emit$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                }
                combineKt$combineInternal$2$1$1$emit$1 = new CombineKt$combineInternal$2$1$1$emit$1(this, continuation);
                Object obj2 = combineKt$combineInternal$2$1$1$emit$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = combineKt$combineInternal$2$1$1$emit$1.label;
                if (i != 0) {
                }
                combineKt$combineInternal$2$1$1$emit$1.label = 2;
                if (YieldKt.yield(combineKt$combineInternal$2$1$1$emit$1) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            }
        }
    }
}
