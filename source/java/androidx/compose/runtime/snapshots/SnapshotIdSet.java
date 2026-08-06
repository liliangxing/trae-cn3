package androidx.compose.runtime.snapshots;

import androidx.autofill.HintConstants;
import androidx.compose.p002ui.graphics.Fields;
import com.bytedance.trae.keva.KevaRepos;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequencesKt;

/* compiled from: SnapshotIdSet.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0016\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0001\u0018\u0000 ,2\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001:\u0001,B5\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003\u0012\u000e\u0010\u0007\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0002\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00002\n\u0010\u0010\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0002\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00002\n\u0010\u0010\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0002\u0010\u0013J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0000J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0000J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0000J\u0013\u0010\u001a\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u001bH\u0096\u0002J>\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u00002+\u0010\u001e\u001a'\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u00000\u001fH\u0082\bJ!\u0010#\u001a\u00020$2\u0016\u0010%\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020$0&H\u0086\bJ\u001b\u0010'\u001a\u00060\u0002j\u0002`\u00032\n\u0010(\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0002\u0010)J\b\u0010*\u001a\u00020+H\u0016R\u000e\u0010\u0004\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010\u0007\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\r¨\u0006-"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "upperSet", "lowerSet", "lowerBound", "belowBound", "", "Landroidx/compose/runtime/snapshots/SnapshotIdArray;", "<init>", "(JJJ[J)V", "J", "[J", "get", "", "id", "(J)Z", "set", "(J)Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "clear", "andNot", "ids", "and", "or", "bits", "iterator", "", "fastFold", "initial", "operation", "Lkotlin/Function2;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "acc", "fastForEach", "", "block", "Lkotlin/Function1;", "lowest", KevaRepos.REPO_DEFAULT, "(J)J", "toString", "", "Companion", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class SnapshotIdSet implements Iterable<Long>, KMappedMarker {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final SnapshotIdSet EMPTY = new SnapshotIdSet(0, 0, 0, null);
    private final long[] belowBound;
    private final long lowerBound;
    private final long lowerSet;
    private final long upperSet;

    private SnapshotIdSet(long j, long j2, long j3, long[] jArr) {
        this.upperSet = j;
        this.lowerSet = j2;
        this.lowerBound = j3;
        this.belowBound = jArr;
    }

    public final boolean get(long id) {
        long[] jArr;
        long j = id - this.lowerBound;
        long j2 = 0;
        return Intrinsics.compare(j, j2) < 0 || Intrinsics.compare(j, (long) 64) >= 0 ? Intrinsics.compare(j, (long) 64) < 0 || Intrinsics.compare(j, (long) Fields.SpotShadowColor) >= 0 ? Intrinsics.compare(j, j2) <= 0 && (jArr = this.belowBound) != null && SnapshotId_jvmKt.binarySearch(jArr, id) >= 0 : ((1 << (((int) j) - 64)) & this.upperSet) != 0 : ((1 << ((int) j)) & this.lowerSet) != 0;
    }

    public final SnapshotIdSet set(long id) {
        long j;
        long j2;
        long[] jArr;
        long j3;
        long j4 = id - this.lowerBound;
        long j5 = 0;
        if (Intrinsics.compare(j4, j5) >= 0 && Intrinsics.compare(j4, 64) < 0) {
            long j6 = 1 << ((int) j4);
            long j7 = this.lowerSet;
            if ((j7 & j6) == 0) {
                return new SnapshotIdSet(this.upperSet, j7 | j6, this.lowerBound, this.belowBound);
            }
        } else {
            long j8 = 64;
            if (Intrinsics.compare(j4, j8) >= 0 && Intrinsics.compare(j4, Fields.SpotShadowColor) < 0) {
                long j9 = 1 << (((int) j4) - 64);
                long j10 = this.upperSet;
                if ((j10 & j9) == 0) {
                    return new SnapshotIdSet(j10 | j9, this.lowerSet, this.lowerBound, this.belowBound);
                }
            } else {
                long j11 = Fields.SpotShadowColor;
                if (Intrinsics.compare(j4, j11) >= 0) {
                    if (!get(id)) {
                        long j12 = this.upperSet;
                        long j13 = this.lowerSet;
                        long j14 = this.lowerBound;
                        long j15 = 1;
                        long j16 = ((id + j15) / j8) * j8;
                        if (Intrinsics.compare(j16, j5) < 0) {
                            j16 = (SnapshotId_jvmKt.SnapshotIdMax - j11) + j15;
                        }
                        SnapshotIdArrayBuilder snapshotIdArrayBuilder = null;
                        long j17 = j12;
                        while (true) {
                            if (Intrinsics.compare(j14, j16) >= 0) {
                                j = j14;
                                j2 = j13;
                                break;
                            }
                            if (j13 != 0) {
                                if (snapshotIdArrayBuilder == null) {
                                    snapshotIdArrayBuilder = new SnapshotIdArrayBuilder(this.belowBound);
                                }
                                int i = 0;
                                while (i < 64) {
                                    long j18 = j16;
                                    if ((j13 & (1 << i)) != 0) {
                                        snapshotIdArrayBuilder.add(i + j14);
                                    }
                                    i++;
                                    j16 = j18;
                                }
                                j3 = j16;
                            } else {
                                j3 = j16;
                            }
                            if (j17 == 0) {
                                j = j3;
                                j2 = 0;
                                break;
                            }
                            j14 += j8;
                            j13 = j17;
                            j17 = 0;
                            j16 = j3;
                        }
                        if (snapshotIdArrayBuilder == null || (jArr = snapshotIdArrayBuilder.toArray()) == null) {
                            jArr = this.belowBound;
                        }
                        return new SnapshotIdSet(j17, j2, j, jArr).set(id);
                    }
                } else {
                    long[] jArr2 = this.belowBound;
                    if (jArr2 == null) {
                        return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, new long[]{id});
                    }
                    int binarySearch = SnapshotId_jvmKt.binarySearch(jArr2, id);
                    if (binarySearch < 0) {
                        return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, SnapshotId_jvmKt.withIdInsertedAt(jArr2, -(binarySearch + 1), id));
                    }
                }
            }
        }
        return this;
    }

    public final SnapshotIdSet clear(long id) {
        long[] jArr;
        int binarySearch;
        long j = id - this.lowerBound;
        long j2 = 0;
        if (Intrinsics.compare(j, j2) >= 0 && Intrinsics.compare(j, 64) < 0) {
            long j3 = 1 << ((int) j);
            long j4 = this.lowerSet;
            if ((j4 & j3) != 0) {
                return new SnapshotIdSet(this.upperSet, j4 & (~j3), this.lowerBound, this.belowBound);
            }
        } else if (Intrinsics.compare(j, 64) >= 0 && Intrinsics.compare(j, Fields.SpotShadowColor) < 0) {
            long j5 = 1 << (((int) j) - 64);
            long j6 = this.upperSet;
            if ((j6 & j5) != 0) {
                return new SnapshotIdSet(j6 & (~j5), this.lowerSet, this.lowerBound, this.belowBound);
            }
        } else if (Intrinsics.compare(j, j2) < 0 && (jArr = this.belowBound) != null && (binarySearch = SnapshotId_jvmKt.binarySearch(jArr, id)) >= 0) {
            return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, SnapshotId_jvmKt.withIdRemovedAt(jArr, binarySearch));
        }
        return this;
    }

    public final SnapshotIdSet andNot(SnapshotIdSet ids) {
        SnapshotIdSet snapshotIdSet;
        SnapshotIdSet snapshotIdSet2 = EMPTY;
        if (ids == snapshotIdSet2) {
            return this;
        }
        if (this == snapshotIdSet2) {
            return snapshotIdSet2;
        }
        long j = ids.lowerBound;
        long j2 = this.lowerBound;
        if (j == j2) {
            long[] jArr = ids.belowBound;
            long[] jArr2 = this.belowBound;
            if (jArr == jArr2) {
                return new SnapshotIdSet((~ids.upperSet) & this.upperSet, (~ids.lowerSet) & this.lowerSet, j2, jArr2);
            }
        }
        long[] jArr3 = ids.belowBound;
        if (jArr3 != null) {
            snapshotIdSet = this;
            for (long j3 : jArr3) {
                snapshotIdSet = snapshotIdSet.clear(j3);
            }
        } else {
            snapshotIdSet = this;
        }
        if (ids.lowerSet != 0) {
            for (int i = 0; i < 64; i++) {
                if ((ids.lowerSet & (1 << i)) != 0) {
                    snapshotIdSet = snapshotIdSet.clear(ids.lowerBound + i);
                }
            }
        }
        if (ids.upperSet != 0) {
            for (int i2 = 0; i2 < 64; i2++) {
                if ((ids.upperSet & (1 << i2)) != 0) {
                    snapshotIdSet = snapshotIdSet.clear(ids.lowerBound + i2 + 64);
                }
            }
        }
        return snapshotIdSet;
    }

    public final SnapshotIdSet and(SnapshotIdSet ids) {
        SnapshotIdSet snapshotIdSet = EMPTY;
        if (Intrinsics.areEqual(ids, snapshotIdSet) || Intrinsics.areEqual(this, snapshotIdSet)) {
            return snapshotIdSet;
        }
        long j = ids.lowerBound;
        long j2 = this.lowerBound;
        if (j == j2) {
            long[] jArr = ids.belowBound;
            long[] jArr2 = this.belowBound;
            if (jArr == jArr2) {
                long j3 = this.upperSet;
                long j4 = ids.upperSet;
                long j5 = j3 & j4;
                long j6 = this.lowerSet;
                SnapshotIdSet snapshotIdSet2 = snapshotIdSet;
                long j7 = ids.lowerSet;
                long j8 = j6 & j7;
                if (j5 != 0 || j8 != 0 || jArr2 != null) {
                    snapshotIdSet2 = new SnapshotIdSet(j3 & j4, j6 & j7, j2, jArr2);
                }
                return snapshotIdSet2;
            }
        }
        SnapshotIdSet snapshotIdSet3 = snapshotIdSet;
        int i = 0;
        if (this.belowBound == null) {
            long[] jArr3 = this.belowBound;
            if (jArr3 != null) {
                for (long j9 : jArr3) {
                    if (ids.get(j9)) {
                        snapshotIdSet3 = snapshotIdSet3.set(j9);
                    }
                }
            }
            SnapshotIdSet snapshotIdSet4 = snapshotIdSet3;
            long j10 = 0;
            if (this.lowerSet != 0) {
                int i2 = 0;
                while (i2 < 64) {
                    if ((this.lowerSet & (1 << i2)) != j10) {
                        long j11 = this.lowerBound + i2;
                        if (ids.get(j11)) {
                            snapshotIdSet4 = snapshotIdSet4.set(j11);
                        }
                    }
                    i2++;
                    j10 = 0;
                }
            }
            long j12 = 0;
            if (this.upperSet == 0) {
                return snapshotIdSet4;
            }
            while (i < 64) {
                if ((this.upperSet & (1 << i)) != j12) {
                    long j13 = this.lowerBound + i + 64;
                    if (ids.get(j13)) {
                        snapshotIdSet4 = snapshotIdSet4.set(j13);
                    }
                }
                i++;
                j12 = 0;
            }
            return snapshotIdSet4;
        }
        long[] jArr4 = ids.belowBound;
        if (jArr4 != null) {
            for (long j14 : jArr4) {
                if (get(j14)) {
                    snapshotIdSet3 = snapshotIdSet3.set(j14);
                }
            }
        }
        SnapshotIdSet snapshotIdSet5 = snapshotIdSet3;
        long j15 = 0;
        if (ids.lowerSet != 0) {
            int i3 = 0;
            while (i3 < 64) {
                if ((ids.lowerSet & (1 << i3)) != j15) {
                    long j16 = ids.lowerBound + i3;
                    if (get(j16)) {
                        snapshotIdSet5 = snapshotIdSet5.set(j16);
                    }
                }
                i3++;
                j15 = 0;
            }
        }
        if (ids.upperSet == 0) {
            return snapshotIdSet5;
        }
        while (i < 64) {
            if ((ids.upperSet & (1 << i)) != 0) {
                long j17 = ids.lowerBound + i + 64;
                if (get(j17)) {
                    snapshotIdSet5 = snapshotIdSet5.set(j17);
                }
            }
            i++;
        }
        return snapshotIdSet5;
    }

    /* renamed from: or */
    public final SnapshotIdSet m55or(SnapshotIdSet bits) {
        SnapshotIdSet snapshotIdSet;
        SnapshotIdSet snapshotIdSet2 = EMPTY;
        if (bits == snapshotIdSet2) {
            return this;
        }
        if (this == snapshotIdSet2) {
            return bits;
        }
        long j = bits.lowerBound;
        long j2 = this.lowerBound;
        if (j == j2) {
            long[] jArr = bits.belowBound;
            long[] jArr2 = this.belowBound;
            if (jArr == jArr2) {
                return new SnapshotIdSet(bits.upperSet | this.upperSet, bits.lowerSet | this.lowerSet, j2, jArr2);
            }
        }
        int i = 0;
        if (this.belowBound == null) {
            long[] jArr3 = this.belowBound;
            if (jArr3 != null) {
                for (long j3 : jArr3) {
                    bits = bits.set(j3);
                }
            }
            if (this.lowerSet != 0) {
                for (int i2 = 0; i2 < 64; i2++) {
                    if ((this.lowerSet & (1 << i2)) != 0) {
                        bits = bits.set(this.lowerBound + i2);
                    }
                }
            }
            if (this.upperSet != 0) {
                while (i < 64) {
                    if ((this.upperSet & (1 << i)) != 0) {
                        bits = bits.set(this.lowerBound + i + 64);
                    }
                    i++;
                }
            }
            return bits;
        }
        long[] jArr4 = bits.belowBound;
        if (jArr4 != null) {
            snapshotIdSet = this;
            for (long j4 : jArr4) {
                snapshotIdSet = snapshotIdSet.set(j4);
            }
        } else {
            snapshotIdSet = this;
        }
        if (bits.lowerSet != 0) {
            for (int i3 = 0; i3 < 64; i3++) {
                if ((bits.lowerSet & (1 << i3)) != 0) {
                    snapshotIdSet = snapshotIdSet.set(bits.lowerBound + i3);
                }
            }
        }
        if (bits.upperSet != 0) {
            while (i < 64) {
                if ((bits.upperSet & (1 << i)) != 0) {
                    snapshotIdSet = snapshotIdSet.set(bits.lowerBound + i + 64);
                }
                i++;
            }
        }
        return snapshotIdSet;
    }

    @Override // java.lang.Iterable
    public Iterator<Long> iterator() {
        return SequencesKt.sequence(new SnapshotIdSet$iterator$1(this, null)).iterator();
    }

    public final void fastForEach(Function1<? super Long, Unit> block) {
        long[] jArr = this.belowBound;
        if (jArr != null) {
            for (long j : jArr) {
                block.invoke(Long.valueOf(j));
            }
        }
        if (this.lowerSet != 0) {
            for (int i = 0; i < 64; i++) {
                if ((this.lowerSet & (1 << i)) != 0) {
                    block.invoke(Long.valueOf(this.lowerBound + i));
                }
            }
        }
        if (this.upperSet != 0) {
            for (int i2 = 0; i2 < 64; i2++) {
                if ((this.upperSet & (1 << i2)) != 0) {
                    block.invoke(Long.valueOf(this.lowerBound + i2 + 64));
                }
            }
        }
    }

    public final long lowest(long r6) {
        long[] jArr = this.belowBound;
        if (jArr == null) {
            if (this.lowerSet != 0) {
                return this.lowerBound + Long.numberOfTrailingZeros(r0);
            }
            return this.upperSet != 0 ? this.lowerBound + 64 + Long.numberOfTrailingZeros(r0) : r6;
        }
        return jArr[0];
    }

    public String toString() {
        StringBuilder append = new StringBuilder().append(super.toString()).append(" [");
        SnapshotIdSet snapshotIdSet = this;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(snapshotIdSet, 10));
        Iterator<Long> it = snapshotIdSet.iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(it.next().longValue()));
        }
        return append.append(ListUtilsKt.fastJoinToString$default(arrayList, null, null, null, 0, null, null, 63, null)).append(']').toString();
    }

    /* compiled from: SnapshotIdSet.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotIdSet$Companion;", "", "<init>", "()V", "EMPTY", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "getEMPTY", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SnapshotIdSet getEMPTY() {
            return SnapshotIdSet.EMPTY;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [androidx.compose.runtime.snapshots.SnapshotIdSet] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v9 */
    private final SnapshotIdSet fastFold(SnapshotIdSet initial, Function2<? super SnapshotIdSet, ? super Long, SnapshotIdSet> operation) {
        long[] jArr = this.belowBound;
        int i = 0;
        if (jArr != null) {
            int length = jArr.length;
            int i2 = 0;
            initial = initial;
            while (i2 < length) {
                Object invoke = operation.invoke((Object) initial, Long.valueOf(jArr[i2]));
                i2++;
                initial = invoke;
            }
        }
        if (this.lowerSet != 0) {
            int i3 = 0;
            initial = initial;
            while (i3 < 64) {
                if ((this.lowerSet & (1 << i3)) != 0) {
                    initial = operation.invoke((Object) initial, Long.valueOf(this.lowerBound + i3));
                }
                i3++;
                initial = initial;
            }
        }
        initial = initial;
        if (this.upperSet != 0) {
            while (i < 64) {
                if ((this.upperSet & (1 << i)) != 0) {
                    initial = operation.invoke((Object) initial, Long.valueOf(this.lowerBound + i + 64));
                }
                i++;
                initial = initial;
            }
        }
        return (SnapshotIdSet) initial;
    }
}
