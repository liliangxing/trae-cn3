package androidx.collection;

import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: ScatterMap.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010&\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00050\u0004H\u008a@"}, d2 = {"<anonymous>", "", "K", "V", "Lkotlin/sequences/SequenceScope;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "androidx.collection.Entries$iterator$1", f = "ScatterMap.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {1414}, m = "invokeSuspend", n = {"$this$iterator", "m$iv", "lastIndex$iv", "i$iv", "slot$iv", "bitCount$iv", "j$iv"}, s = {"L$0", "L$2", "I$0", "I$1", "J$0", "I$2", "I$3"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
final class Entries$iterator$1<K, V> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Map.Entry<? extends K, ? extends V>>, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ Entries<K, V> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Entries$iterator$1(Entries<K, V> entries, Continuation<? super Entries$iterator$1> continuation) {
        super(2, continuation);
        this.this$0 = entries;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> entries$iterator$1 = new Entries$iterator$1<>(this.this$0, continuation);
        entries$iterator$1.L$0 = obj;
        return entries$iterator$1;
    }

    public final Object invoke(SequenceScope<? super Map.Entry<? extends K, ? extends V>> sequenceScope, Continuation<? super Unit> continuation) {
        return create(sequenceScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0070  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x00b0 -> B:5:0x00b4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x00bb -> B:6:0x00b8). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x005c -> B:8:0x006e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00cc -> B:23:0x00ce). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        SequenceScope sequenceScope;
        ScatterMap scatterMap;
        Entries<K, V> entries;
        long[] jArr;
        int length;
        Entries$iterator$1<K, V> entries$iterator$1;
        int i;
        long j;
        ScatterMap scatterMap2;
        ScatterMap scatterMap3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        int i3 = 8;
        int i4 = 1;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            sequenceScope = (SequenceScope) this.L$0;
            scatterMap = ((Entries) this.this$0).parent;
            entries = this.this$0;
            jArr = scatterMap.metadata;
            length = jArr.length - 2;
            if (length >= 0) {
                entries$iterator$1 = this;
                i = 0;
                j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                }
            }
            return Unit.INSTANCE;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int i5 = this.I$3;
        int i6 = this.I$2;
        long j2 = this.J$0;
        i = this.I$1;
        int i7 = this.I$0;
        long[] jArr2 = (long[]) this.L$2;
        Entries<K, V> entries2 = (Entries) this.L$1;
        SequenceScope sequenceScope2 = (SequenceScope) this.L$0;
        ResultKt.throwOnFailure(obj);
        Entries$iterator$1<K, V> entries$iterator$12 = this;
        int i8 = 1;
        SequenceScope sequenceScope3 = sequenceScope2;
        Entries<K, V> entries3 = entries2;
        long[] jArr3 = jArr2;
        Entries$iterator$1<K, V> entries$iterator$13 = entries$iterator$12;
        j2 >>= 8;
        i5 += i8;
        i4 = i8;
        i3 = 8;
        if (i5 < i6) {
            int i9 = i3;
            int i10 = i4;
            if (i6 == i9) {
                length = i7;
                entries$iterator$1 = entries$iterator$13;
                jArr = jArr3;
                entries = entries3;
                sequenceScope = sequenceScope3;
                if (i != length) {
                    i++;
                    i4 = i10;
                    i3 = i9;
                    j = jArr[i];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                        sequenceScope3 = sequenceScope;
                        i5 = 0;
                        jArr3 = jArr;
                        entries$iterator$13 = entries$iterator$1;
                        i6 = 8 - ((~(i - length)) >>> 31);
                        entries3 = entries;
                        i7 = length;
                        j2 = j;
                        if (i5 < i6) {
                            if (((255 & j2) < 128 ? i4 : 0) != 0) {
                                int i11 = (i << 3) + i5;
                                scatterMap2 = ((Entries) entries3).parent;
                                Object obj2 = scatterMap2.keys[i11];
                                scatterMap3 = ((Entries) entries3).parent;
                                MapEntry mapEntry = new MapEntry(obj2, scatterMap3.values[i11]);
                                entries$iterator$13.L$0 = sequenceScope3;
                                entries$iterator$13.L$1 = entries3;
                                entries$iterator$13.L$2 = jArr3;
                                entries$iterator$13.I$0 = i7;
                                entries$iterator$13.I$1 = i;
                                entries$iterator$13.J$0 = j2;
                                entries$iterator$13.I$2 = i6;
                                entries$iterator$13.I$3 = i5;
                                i8 = 1;
                                entries$iterator$13.label = 1;
                                if (sequenceScope3.yield(mapEntry, entries$iterator$13) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                entries$iterator$12 = entries$iterator$13;
                                jArr2 = jArr3;
                                entries2 = entries3;
                                sequenceScope2 = sequenceScope3;
                                SequenceScope sequenceScope32 = sequenceScope2;
                                Entries<K, V> entries32 = entries2;
                                long[] jArr32 = jArr2;
                                Entries$iterator$1<K, V> entries$iterator$132 = entries$iterator$12;
                                j2 >>= 8;
                                i5 += i8;
                                i4 = i8;
                                i3 = 8;
                                if (i5 < i6) {
                                }
                            } else {
                                i8 = i4;
                                j2 >>= 8;
                                i5 += i8;
                                i4 = i8;
                                i3 = 8;
                                if (i5 < i6) {
                                }
                            }
                        }
                    } else {
                        i9 = i3;
                        i10 = i4;
                        if (i != length) {
                        }
                    }
                }
            }
            return Unit.INSTANCE;
        }
    }
}
