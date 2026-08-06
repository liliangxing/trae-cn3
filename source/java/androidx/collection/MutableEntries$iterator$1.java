package androidx.collection;

import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: ScatterMap.kt */
@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0010)\n\u0002\u0010'\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010(\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00020\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u0096\u0002J\u0015\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR,\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"androidx/collection/MutableEntries$iterator$1", "", "", "current", "", "getCurrent", "()I", "setCurrent", "(I)V", "iterator", "", "getIterator", "()Ljava/util/Iterator;", "setIterator", "(Ljava/util/Iterator;)V", "hasNext", "", "next", "remove", "", "collection"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class MutableEntries$iterator$1<K, V> implements Iterator<Map.Entry<K, V>>, KMutableIterator {
    private int current = -1;
    private Iterator<? extends Map.Entry<K, V>> iterator;
    final /* synthetic */ MutableEntries<K, V> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MutableEntries$iterator$1(MutableEntries<K, V> mutableEntries) {
        this.this$0 = mutableEntries;
        this.iterator = SequencesKt.iterator(new C01811(mutableEntries, this, null));
    }

    public final Iterator<Map.Entry<K, V>> getIterator() {
        return this.iterator;
    }

    public final void setIterator(Iterator<? extends Map.Entry<K, V>> it) {
        Intrinsics.checkNotNullParameter(it, "<set-?>");
        this.iterator = it;
    }

    public final int getCurrent() {
        return this.current;
    }

    public final void setCurrent(int i) {
        this.current = i;
    }

    /* compiled from: ScatterMap.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010'\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00050\u0004H\u008a@"}, d2 = {"<anonymous>", "", "K", "V", "Lkotlin/sequences/SequenceScope;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "androidx.collection.MutableEntries$iterator$1$1", f = "ScatterMap.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {1538}, m = "invokeSuspend", n = {"$this$iterator", "m$iv", "lastIndex$iv", "i$iv", "slot$iv", "bitCount$iv", "j$iv"}, s = {"L$0", "L$3", "I$0", "I$1", "J$0", "I$2", "I$3"})
    /* renamed from: androidx.collection.MutableEntries$iterator$1$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
    static final class C01811 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Map.Entry<K, V>>, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ MutableEntries<K, V> this$0;
        final /* synthetic */ MutableEntries$iterator$1 this$1;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01811(MutableEntries<K, V> mutableEntries, MutableEntries$iterator$1 mutableEntries$iterator$1, Continuation<? super C01811> continuation) {
            super(2, continuation);
            this.this$0 = mutableEntries;
            this.this$1 = mutableEntries$iterator$1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c01811 = new C01811(this.this$0, this.this$1, continuation);
            c01811.L$0 = obj;
            return c01811;
        }

        public final Object invoke(SequenceScope<? super Map.Entry<K, V>> sequenceScope, Continuation<? super Unit> continuation) {
            return create(sequenceScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x00de  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00ef  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0067  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00ec  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0083  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x00cc -> B:5:0x00d0). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x00d7 -> B:6:0x00d8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0067 -> B:7:0x0081). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00ec -> B:22:0x00ed). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            SequenceScope sequenceScope;
            MutableScatterMap mutableScatterMap;
            MutableEntries$iterator$1 mutableEntries$iterator$1;
            MutableEntries<K, V> mutableEntries;
            long[] jArr;
            int length;
            C01811 c01811;
            int i;
            long j;
            MutableScatterMap mutableScatterMap2;
            MutableScatterMap mutableScatterMap3;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            int i3 = 8;
            int i4 = 1;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                sequenceScope = (SequenceScope) this.L$0;
                mutableScatterMap = ((MutableEntries) this.this$0).parent;
                mutableEntries$iterator$1 = this.this$1;
                mutableEntries = this.this$0;
                jArr = mutableScatterMap.metadata;
                length = jArr.length - 2;
                if (length >= 0) {
                    c01811 = this;
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
            int i7 = this.I$1;
            int i8 = this.I$0;
            long[] jArr2 = (long[]) this.L$3;
            MutableEntries<K, V> mutableEntries2 = (MutableEntries) this.L$2;
            MutableEntries$iterator$1 mutableEntries$iterator$12 = (MutableEntries$iterator$1) this.L$1;
            SequenceScope sequenceScope2 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            C01811 c018112 = this;
            int i9 = 1;
            SequenceScope sequenceScope3 = sequenceScope2;
            MutableEntries$iterator$1 mutableEntries$iterator$13 = mutableEntries$iterator$12;
            MutableEntries<K, V> mutableEntries3 = mutableEntries2;
            C01811 c018113 = c018112;
            i3 = 8;
            j2 >>= i3;
            i5 += i9;
            i4 = i9;
            if (i5 < i6) {
                int i10 = i4;
                if (i6 == i3) {
                    jArr = jArr2;
                    c01811 = c018113;
                    mutableEntries = mutableEntries3;
                    mutableEntries$iterator$1 = mutableEntries$iterator$13;
                    sequenceScope = sequenceScope3;
                    int i11 = i8;
                    i = i7;
                    length = i11;
                    if (i != length) {
                        i++;
                        i4 = i10;
                        j = jArr[i];
                        if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                            sequenceScope3 = sequenceScope;
                            i5 = 0;
                            C01811 c018114 = c01811;
                            jArr2 = jArr;
                            i6 = 8 - ((~(i - length)) >>> 31);
                            mutableEntries$iterator$13 = mutableEntries$iterator$1;
                            mutableEntries3 = mutableEntries;
                            c018113 = c018114;
                            j2 = j;
                            int i12 = i;
                            i8 = length;
                            i7 = i12;
                            if (i5 < i6) {
                                if (((j2 & 255) < 128 ? i4 : 0) != 0) {
                                    mutableEntries$iterator$13.setCurrent((i7 << 3) + i5);
                                    mutableScatterMap2 = ((MutableEntries) mutableEntries3).parent;
                                    Object[] objArr = mutableScatterMap2.keys;
                                    mutableScatterMap3 = ((MutableEntries) mutableEntries3).parent;
                                    MutableMapEntry mutableMapEntry = new MutableMapEntry(objArr, mutableScatterMap3.values, mutableEntries$iterator$13.getCurrent());
                                    c018113.L$0 = sequenceScope3;
                                    c018113.L$1 = mutableEntries$iterator$13;
                                    c018113.L$2 = mutableEntries3;
                                    c018113.L$3 = jArr2;
                                    c018113.I$0 = i8;
                                    c018113.I$1 = i7;
                                    c018113.J$0 = j2;
                                    c018113.I$2 = i6;
                                    c018113.I$3 = i5;
                                    i9 = 1;
                                    c018113.label = 1;
                                    if (sequenceScope3.yield(mutableMapEntry, c018113) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    c018112 = c018113;
                                    mutableEntries2 = mutableEntries3;
                                    mutableEntries$iterator$12 = mutableEntries$iterator$13;
                                    sequenceScope2 = sequenceScope3;
                                    SequenceScope sequenceScope32 = sequenceScope2;
                                    MutableEntries$iterator$1 mutableEntries$iterator$132 = mutableEntries$iterator$12;
                                    MutableEntries<K, V> mutableEntries32 = mutableEntries2;
                                    C01811 c0181132 = c018112;
                                    i3 = 8;
                                    j2 >>= i3;
                                    i5 += i9;
                                    i4 = i9;
                                    if (i5 < i6) {
                                    }
                                } else {
                                    i9 = i4;
                                    j2 >>= i3;
                                    i5 += i9;
                                    i4 = i9;
                                    if (i5 < i6) {
                                    }
                                }
                            }
                        } else {
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

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // java.util.Iterator
    public Map.Entry<K, V> next() {
        return this.iterator.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        MutableScatterMap mutableScatterMap;
        if (this.current != -1) {
            mutableScatterMap = ((MutableEntries) this.this$0).parent;
            mutableScatterMap.removeValueAt(this.current);
            this.current = -1;
        }
    }
}
