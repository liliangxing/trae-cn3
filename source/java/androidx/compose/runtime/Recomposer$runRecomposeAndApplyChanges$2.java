package androidx.compose.runtime;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.collection.ScatterSetWrapperKt;
import androidx.compose.runtime.internal.Trace;
import androidx.compose.runtime.snapshots.MutableSnapshot;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.TransparentObserverMutableSnapshot;
import androidx.compose.runtime.snapshots.TransparentObserverSnapshot;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Recomposer.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "parentFrameClock", "Landroidx/compose/runtime/MonotonicFrameClock;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2", f = "Recomposer.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {587, 598}, m = "invokeSuspend", n = {"parentFrameClock", "toRecompose", "toInsert", "toApply", "toLateApply", "toComplete", "modifiedValues", "modifiedValuesSet", "alreadyComposed", "parentFrameClock", "toRecompose", "toInsert", "toApply", "toLateApply", "toComplete", "modifiedValues", "modifiedValuesSet", "alreadyComposed"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class Recomposer$runRecomposeAndApplyChanges$2 extends SuspendLambda implements Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    int label;
    final /* synthetic */ Recomposer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Recomposer$runRecomposeAndApplyChanges$2(Recomposer recomposer, Continuation<? super Recomposer$runRecomposeAndApplyChanges$2> continuation) {
        super(3, continuation);
        this.this$0 = recomposer;
    }

    public final Object invoke(CoroutineScope coroutineScope, MonotonicFrameClock monotonicFrameClock, Continuation<? super Unit> continuation) {
        Recomposer$runRecomposeAndApplyChanges$2 recomposer$runRecomposeAndApplyChanges$2 = new Recomposer$runRecomposeAndApplyChanges$2(this.this$0, continuation);
        recomposer$runRecomposeAndApplyChanges$2.L$0 = monotonicFrameClock;
        return recomposer$runRecomposeAndApplyChanges$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00c6  */
    /* JADX WARN: Type inference failed for: r10v11, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r10v14, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r11v12, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r11v15, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v11, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v14, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x014a -> B:6:0x0153). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x015f -> B:7:0x00be). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        MonotonicFrameClock monotonicFrameClock;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        MutableScatterSet mutableScatterSetOf;
        MutableScatterSet mutableScatterSetOf2;
        MutableScatterSet mutableScatterSet;
        Set wrapIntoSet;
        MutableScatterSet mutableScatterSetOf3;
        Recomposer$runRecomposeAndApplyChanges$2 recomposer$runRecomposeAndApplyChanges$2;
        ArrayList arrayList4;
        ArrayList arrayList5;
        ArrayList arrayList6;
        MutableScatterSet mutableScatterSet2;
        MutableScatterSet mutableScatterSet3;
        Set set;
        Recomposer$runRecomposeAndApplyChanges$2 recomposer$runRecomposeAndApplyChanges$22;
        MutableScatterSet mutableScatterSet4;
        boolean recordComposerModifications;
        boolean shouldKeepRecomposing;
        Object awaitWorkAvailable;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        char c = 2;
        int i2 = 1;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            monotonicFrameClock = (MonotonicFrameClock) this.L$0;
            arrayList = new ArrayList();
            arrayList2 = new ArrayList();
            arrayList3 = new ArrayList();
            mutableScatterSetOf = ScatterSetKt.mutableScatterSetOf();
            mutableScatterSetOf2 = ScatterSetKt.mutableScatterSetOf();
            mutableScatterSet = new MutableScatterSet(0, 1, null);
            wrapIntoSet = ScatterSetWrapperKt.wrapIntoSet(mutableScatterSet);
            mutableScatterSetOf3 = ScatterSetKt.mutableScatterSetOf();
            recomposer$runRecomposeAndApplyChanges$2 = this;
            shouldKeepRecomposing = recomposer$runRecomposeAndApplyChanges$2.this$0.getShouldKeepRecomposing();
            if (!shouldKeepRecomposing) {
            }
        } else if (i == 1) {
            MutableScatterSet mutableScatterSet5 = (MutableScatterSet) this.L$8;
            Set set2 = (Set) this.L$7;
            MutableScatterSet mutableScatterSet6 = (MutableScatterSet) this.L$6;
            MutableScatterSet mutableScatterSet7 = (MutableScatterSet) this.L$5;
            MutableScatterSet mutableScatterSet8 = (MutableScatterSet) this.L$4;
            ?? r9 = (List) this.L$3;
            ?? r10 = (List) this.L$2;
            ?? r11 = (List) this.L$1;
            MonotonicFrameClock monotonicFrameClock2 = (MonotonicFrameClock) this.L$0;
            ResultKt.throwOnFailure(obj);
            arrayList6 = r9;
            arrayList5 = r10;
            arrayList4 = r11;
            set = set2;
            mutableScatterSet = mutableScatterSet6;
            mutableScatterSet3 = mutableScatterSet7;
            mutableScatterSet4 = mutableScatterSet5;
            monotonicFrameClock = monotonicFrameClock2;
            mutableScatterSet2 = mutableScatterSet8;
            recomposer$runRecomposeAndApplyChanges$22 = this;
            recordComposerModifications = recomposer$runRecomposeAndApplyChanges$22.this$0.recordComposerModifications();
            if (recordComposerModifications) {
            }
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            MutableScatterSet mutableScatterSet9 = (MutableScatterSet) this.L$8;
            Set set3 = (Set) this.L$7;
            MutableScatterSet mutableScatterSet10 = (MutableScatterSet) this.L$6;
            MutableScatterSet mutableScatterSet11 = (MutableScatterSet) this.L$5;
            mutableScatterSetOf = (MutableScatterSet) this.L$4;
            ?? r92 = (List) this.L$3;
            ?? r102 = (List) this.L$2;
            ?? r112 = (List) this.L$1;
            MonotonicFrameClock monotonicFrameClock3 = (MonotonicFrameClock) this.L$0;
            ResultKt.throwOnFailure(obj);
            recomposer$runRecomposeAndApplyChanges$2 = this;
            MutableScatterSet mutableScatterSet12 = mutableScatterSet11;
            arrayList3 = r92;
            char c2 = 2;
            mutableScatterSetOf3 = mutableScatterSet9;
            monotonicFrameClock = monotonicFrameClock3;
            wrapIntoSet = set3;
            arrayList = r112;
            mutableScatterSet = mutableScatterSet10;
            arrayList2 = r102;
            recomposer$runRecomposeAndApplyChanges$2.this$0.discardUnusedMovableContentState();
            c = c2;
            i2 = 1;
            mutableScatterSetOf2 = mutableScatterSet12;
            shouldKeepRecomposing = recomposer$runRecomposeAndApplyChanges$2.this$0.getShouldKeepRecomposing();
            if (!shouldKeepRecomposing) {
                recomposer$runRecomposeAndApplyChanges$2.L$0 = monotonicFrameClock;
                recomposer$runRecomposeAndApplyChanges$2.L$1 = arrayList;
                recomposer$runRecomposeAndApplyChanges$2.L$2 = arrayList2;
                recomposer$runRecomposeAndApplyChanges$2.L$3 = arrayList3;
                recomposer$runRecomposeAndApplyChanges$2.L$4 = mutableScatterSetOf;
                recomposer$runRecomposeAndApplyChanges$2.L$5 = mutableScatterSetOf2;
                recomposer$runRecomposeAndApplyChanges$2.L$6 = mutableScatterSet;
                recomposer$runRecomposeAndApplyChanges$2.L$7 = wrapIntoSet;
                recomposer$runRecomposeAndApplyChanges$2.L$8 = mutableScatterSetOf3;
                recomposer$runRecomposeAndApplyChanges$2.label = i2;
                awaitWorkAvailable = recomposer$runRecomposeAndApplyChanges$2.this$0.awaitWorkAvailable((Continuation) recomposer$runRecomposeAndApplyChanges$2);
                if (awaitWorkAvailable == coroutine_suspended) {
                    return coroutine_suspended;
                }
                arrayList4 = arrayList;
                arrayList5 = arrayList2;
                Recomposer$runRecomposeAndApplyChanges$2 recomposer$runRecomposeAndApplyChanges$23 = recomposer$runRecomposeAndApplyChanges$2;
                arrayList6 = arrayList3;
                mutableScatterSet4 = mutableScatterSetOf3;
                mutableScatterSet2 = mutableScatterSetOf;
                recomposer$runRecomposeAndApplyChanges$22 = recomposer$runRecomposeAndApplyChanges$23;
                Set set4 = wrapIntoSet;
                mutableScatterSet3 = mutableScatterSetOf2;
                set = set4;
                recordComposerModifications = recomposer$runRecomposeAndApplyChanges$22.this$0.recordComposerModifications();
                if (recordComposerModifications) {
                    Recomposer$runRecomposeAndApplyChanges$2 recomposer$runRecomposeAndApplyChanges$24 = recomposer$runRecomposeAndApplyChanges$22;
                    MutableScatterSet mutableScatterSet13 = mutableScatterSet;
                    MutableScatterSet mutableScatterSet14 = mutableScatterSet2;
                    Object obj2 = coroutine_suspended;
                    mutableScatterSetOf3 = mutableScatterSet4;
                    MutableScatterSet mutableScatterSet15 = mutableScatterSet3;
                    ArrayList arrayList7 = arrayList6;
                    mutableScatterSetOf = mutableScatterSet14;
                    recomposer$runRecomposeAndApplyChanges$2 = recomposer$runRecomposeAndApplyChanges$24;
                    wrapIntoSet = set;
                    arrayList = arrayList4;
                    i2 = 1;
                    arrayList3 = arrayList7;
                    coroutine_suspended = obj2;
                    mutableScatterSet = mutableScatterSet13;
                    arrayList2 = arrayList5;
                    c = c;
                    mutableScatterSetOf2 = mutableScatterSet15;
                    shouldKeepRecomposing = recomposer$runRecomposeAndApplyChanges$2.this$0.getShouldKeepRecomposing();
                    if (!shouldKeepRecomposing) {
                    }
                } else {
                    final Recomposer recomposer = recomposer$runRecomposeAndApplyChanges$22.this$0;
                    final MutableScatterSet mutableScatterSet16 = mutableScatterSet4;
                    final MutableScatterSet mutableScatterSet17 = mutableScatterSet;
                    Recomposer$runRecomposeAndApplyChanges$2 recomposer$runRecomposeAndApplyChanges$25 = recomposer$runRecomposeAndApplyChanges$22;
                    final Set set5 = set;
                    final ArrayList arrayList8 = arrayList4;
                    MutableScatterSet mutableScatterSet18 = mutableScatterSet;
                    final ArrayList arrayList9 = arrayList5;
                    final MutableScatterSet mutableScatterSet19 = mutableScatterSet3;
                    final MutableScatterSet mutableScatterSet20 = mutableScatterSet2;
                    MutableScatterSet mutableScatterSet21 = mutableScatterSet2;
                    final ArrayList arrayList10 = arrayList6;
                    Object obj3 = coroutine_suspended;
                    ArrayList arrayList11 = arrayList6;
                    ArrayList arrayList12 = arrayList5;
                    recomposer$runRecomposeAndApplyChanges$25.L$0 = monotonicFrameClock;
                    recomposer$runRecomposeAndApplyChanges$25.L$1 = arrayList4;
                    recomposer$runRecomposeAndApplyChanges$25.L$2 = arrayList12;
                    recomposer$runRecomposeAndApplyChanges$25.L$3 = arrayList11;
                    recomposer$runRecomposeAndApplyChanges$25.L$4 = mutableScatterSet21;
                    recomposer$runRecomposeAndApplyChanges$25.L$5 = mutableScatterSet19;
                    recomposer$runRecomposeAndApplyChanges$25.L$6 = mutableScatterSet18;
                    recomposer$runRecomposeAndApplyChanges$25.L$7 = set5;
                    mutableScatterSetOf3 = mutableScatterSet16;
                    recomposer$runRecomposeAndApplyChanges$25.L$8 = mutableScatterSetOf3;
                    c2 = 2;
                    recomposer$runRecomposeAndApplyChanges$25.label = 2;
                    if (monotonicFrameClock.withFrameNanos(new Function1() { // from class: androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj4) {
                            Unit invokeSuspend$lambda$22;
                            invokeSuspend$lambda$22 = Recomposer$runRecomposeAndApplyChanges$2.invokeSuspend$lambda$22(Recomposer.this, mutableScatterSet17, mutableScatterSet16, arrayList8, arrayList9, mutableScatterSet20, arrayList10, mutableScatterSet19, set5, ((Long) obj4).longValue());
                            return invokeSuspend$lambda$22;
                        }
                    }, (Continuation) recomposer$runRecomposeAndApplyChanges$25) == obj3) {
                        return obj3;
                    }
                    mutableScatterSetOf = mutableScatterSet21;
                    recomposer$runRecomposeAndApplyChanges$2 = recomposer$runRecomposeAndApplyChanges$25;
                    wrapIntoSet = set5;
                    mutableScatterSet12 = mutableScatterSet19;
                    arrayList = arrayList4;
                    arrayList3 = arrayList11;
                    coroutine_suspended = obj3;
                    mutableScatterSet = mutableScatterSet18;
                    arrayList2 = arrayList12;
                    recomposer$runRecomposeAndApplyChanges$2.this$0.discardUnusedMovableContentState();
                    c = c2;
                    i2 = 1;
                    mutableScatterSetOf2 = mutableScatterSet12;
                    shouldKeepRecomposing = recomposer$runRecomposeAndApplyChanges$2.this$0.getShouldKeepRecomposing();
                    if (!shouldKeepRecomposing) {
                        return Unit.INSTANCE;
                    }
                }
            }
        }
    }

    private static final void invokeSuspend$clearRecompositionState(Recomposer recomposer, List<ControlledComposition> list, List<MovableContentStateReference> list2, List<ControlledComposition> list3, MutableScatterSet<ControlledComposition> mutableScatterSet, MutableScatterSet<ControlledComposition> mutableScatterSet2, MutableScatterSet<Object> mutableScatterSet3, MutableScatterSet<ControlledComposition> mutableScatterSet4) {
        synchronized (recomposer.stateLock) {
            list.clear();
            list2.clear();
            int size = list3.size();
            for (int i = 0; i < size; i++) {
                ControlledComposition controlledComposition = list3.get(i);
                controlledComposition.abandonChanges();
                recomposer.recordFailedCompositionLocked(controlledComposition);
            }
            list3.clear();
            MutableScatterSet<ControlledComposition> mutableScatterSet5 = mutableScatterSet;
            Object[] objArr = mutableScatterSet5.elements;
            long[] jArr = mutableScatterSet5.metadata;
            int length = jArr.length - 2;
            char c = 7;
            if (length >= 0) {
                int i2 = 0;
                while (true) {
                    long j = jArr[i2];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i3 = 8 - ((~(i2 - length)) >>> 31);
                        for (int i4 = 0; i4 < i3; i4++) {
                            if ((j & 255) < 128) {
                                ControlledComposition controlledComposition2 = (ControlledComposition) objArr[(i2 << 3) + i4];
                                controlledComposition2.abandonChanges();
                                recomposer.recordFailedCompositionLocked(controlledComposition2);
                            }
                            j >>= 8;
                        }
                        if (i3 != 8) {
                            break;
                        }
                    }
                    if (i2 == length) {
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            mutableScatterSet.clear();
            MutableScatterSet<ControlledComposition> mutableScatterSet6 = mutableScatterSet2;
            Object[] objArr2 = mutableScatterSet6.elements;
            long[] jArr2 = mutableScatterSet6.metadata;
            int length2 = jArr2.length - 2;
            if (length2 >= 0) {
                int i5 = 0;
                while (true) {
                    long j2 = jArr2[i5];
                    if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i6 = 8 - ((~(i5 - length2)) >>> 31);
                        for (int i7 = 0; i7 < i6; i7++) {
                            if ((j2 & 255) < 128) {
                                ((ControlledComposition) objArr2[(i5 << 3) + i7]).changesApplied();
                            }
                            j2 >>= 8;
                        }
                        if (i6 != 8) {
                            break;
                        }
                    }
                    if (i5 == length2) {
                        break;
                    } else {
                        i5++;
                    }
                }
            }
            mutableScatterSet2.clear();
            mutableScatterSet3.clear();
            MutableScatterSet<ControlledComposition> mutableScatterSet7 = mutableScatterSet4;
            Object[] objArr3 = mutableScatterSet7.elements;
            long[] jArr3 = mutableScatterSet7.metadata;
            int length3 = jArr3.length - 2;
            if (length3 >= 0) {
                int i8 = 0;
                while (true) {
                    long j3 = jArr3[i8];
                    if ((((~j3) << c) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i9 = 8 - ((~(i8 - length3)) >>> 31);
                        for (int i10 = 0; i10 < i9; i10++) {
                            if ((j3 & 255) < 128) {
                                ControlledComposition controlledComposition3 = (ControlledComposition) objArr3[(i8 << 3) + i10];
                                controlledComposition3.abandonChanges();
                                recomposer.recordFailedCompositionLocked(controlledComposition3);
                            }
                            j3 >>= 8;
                        }
                        if (i9 != 8) {
                            break;
                        }
                    }
                    if (i8 == length3) {
                        break;
                    }
                    i8++;
                    c = 7;
                }
            }
            mutableScatterSet4.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    private static final void invokeSuspend$fillToInsert(List<MovableContentStateReference> list, Recomposer recomposer) {
        List list2;
        List list3;
        list.clear();
        synchronized (recomposer.stateLock) {
            list2 = recomposer.movableContentAwaitingInsert;
            int size = list2.size();
            for (int i = 0; i < size; i++) {
                list.add((MovableContentStateReference) list2.get(i));
            }
            list3 = recomposer.movableContentAwaitingInsert;
            list3.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0380  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x03c5  */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12, types: [androidx.compose.runtime.snapshots.Snapshot] */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v14, types: [androidx.compose.runtime.snapshots.Snapshot] */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v17, types: [androidx.compose.runtime.snapshots.Snapshot] */
    /* JADX WARN: Type inference failed for: r11v19, types: [androidx.compose.runtime.snapshots.Snapshot] */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v14, types: [androidx.compose.runtime.snapshots.Snapshot] */
    /* JADX WARN: Type inference failed for: r12v19, types: [int] */
    /* JADX WARN: Type inference failed for: r12v25, types: [androidx.compose.runtime.snapshots.Snapshot] */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9, types: [androidx.compose.runtime.snapshots.Snapshot] */
    /* JADX WARN: Type inference failed for: r3v8, types: [T[], java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r6v15, types: [androidx.compose.runtime.snapshots.Snapshot] */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v19, types: [androidx.collection.MutableScatterSet] */
    /* JADX WARN: Type inference failed for: r6v8, types: [T[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit invokeSuspend$lambda$22(Recomposer recomposer, MutableScatterSet mutableScatterSet, MutableScatterSet mutableScatterSet2, List list, List list2, MutableScatterSet mutableScatterSet3, List list3, MutableScatterSet mutableScatterSet4, Set set, long j) {
        boolean hasBroadcastFrameClockAwaiters;
        boolean z;
        Unit unit;
        boolean z2;
        List list4;
        List performInsertValues;
        ControlledComposition performRecompose;
        Snapshot snapshot;
        BroadcastFrameClock broadcastFrameClock;
        Collection collection = list2;
        ScatterSet scatterSet = mutableScatterSet3;
        List list5 = list3;
        MutableScatterSet mutableScatterSet5 = mutableScatterSet4;
        hasBroadcastFrameClockAwaiters = recomposer.getHasBroadcastFrameClockAwaiters();
        if (hasBroadcastFrameClockAwaiters) {
            Object beginSection = Trace.INSTANCE.beginSection("Recomposer:animation");
            try {
                broadcastFrameClock = recomposer.broadcastFrameClock;
                broadcastFrameClock.sendFrame(j);
                Snapshot.INSTANCE.sendApplyNotifications();
                Unit unit2 = Unit.INSTANCE;
            } finally {
            }
        }
        Object beginSection2 = Trace.INSTANCE.beginSection("Recomposer:recompose");
        try {
            recomposer.recordComposerModifications();
            synchronized (recomposer.stateLock) {
                MutableVector mutableVector = recomposer.compositionInvalidations;
                Object[] objArr = mutableVector.content;
                int size = mutableVector.getSize();
                z = false;
                for (int i = 0; i < size; i++) {
                    list.add((ControlledComposition) objArr[i]);
                }
                recomposer.compositionInvalidations.clear();
                Unit unit3 = Unit.INSTANCE;
            }
            mutableScatterSet.clear();
            mutableScatterSet2.clear();
            while (true) {
                if (!(!list.isEmpty()) && !(!collection.isEmpty())) {
                    break;
                }
                try {
                    int size2 = list.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        ControlledComposition controlledComposition = (ControlledComposition) list.get(i2);
                        performRecompose = recomposer.performRecompose(controlledComposition, mutableScatterSet);
                        if (performRecompose != null) {
                            list3.add(performRecompose);
                            Unit unit4 = Unit.INSTANCE;
                            Unit unit5 = Unit.INSTANCE;
                        }
                        mutableScatterSet2.add(controlledComposition);
                    }
                    list.clear();
                    if (!mutableScatterSet.isNotEmpty()) {
                        if (!(recomposer.compositionInvalidations.getSize() != 0)) {
                            if (list.isEmpty()) {
                                list4 = list2;
                            } else {
                                list4 = list2;
                                try {
                                    invokeSuspend$fillToInsert(list4, recomposer);
                                    while (!list4.isEmpty()) {
                                        performInsertValues = recomposer.performInsertValues(list4, mutableScatterSet);
                                        try {
                                            mutableScatterSet3.plusAssign((Iterable) performInsertValues);
                                            invokeSuspend$fillToInsert(list4, recomposer);
                                        } catch (Throwable th) {
                                            th = th;
                                            Recomposer.processCompositionError$default(recomposer, th, null, true, 2, null);
                                            invokeSuspend$clearRecompositionState(recomposer, list, list2, list3, mutableScatterSet3, mutableScatterSet4, mutableScatterSet, mutableScatterSet2);
                                            unit = Unit.INSTANCE;
                                            return unit;
                                        }
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            }
                            scatterSet = mutableScatterSet3;
                            list5 = list3;
                            mutableScatterSet5 = mutableScatterSet4;
                            z = false;
                            collection = list4;
                        }
                    }
                    synchronized (recomposer.stateLock) {
                        List knownCompositionsLocked = recomposer.knownCompositionsLocked();
                        int size3 = knownCompositionsLocked.size();
                        for (int i3 = 0; i3 < size3; i3++) {
                            ControlledComposition controlledComposition2 = (ControlledComposition) knownCompositionsLocked.get(i3);
                            if (!mutableScatterSet2.contains(controlledComposition2) && controlledComposition2.observesAnyOf(set)) {
                                list.add(controlledComposition2);
                            }
                        }
                        MutableVector mutableVector2 = recomposer.compositionInvalidations;
                        int size4 = mutableVector2.getSize();
                        int i4 = 0;
                        for (int i5 = 0; i5 < size4; i5++) {
                            ControlledComposition controlledComposition3 = (ControlledComposition) mutableVector2.content[i5];
                            if (mutableScatterSet2.contains(controlledComposition3) || list.contains(controlledComposition3)) {
                                z2 = false;
                            } else {
                                list.add(controlledComposition3);
                                z2 = true;
                            }
                            if (z2) {
                                i4++;
                            } else if (i4 > 0) {
                                mutableVector2.content[i5 - i4] = mutableVector2.content[i5];
                            }
                        }
                        int i6 = size4 - i4;
                        ArraysKt.fill((Object[]) mutableVector2.content, (Object) null, i6, size4);
                        mutableVector2.setSize(i6);
                        Unit unit6 = Unit.INSTANCE;
                    }
                    if (list.isEmpty()) {
                    }
                    scatterSet = mutableScatterSet3;
                    list5 = list3;
                    mutableScatterSet5 = mutableScatterSet4;
                    z = false;
                    collection = list4;
                } catch (Throwable th3) {
                    try {
                        Recomposer.processCompositionError$default(recomposer, th3, null, true, 2, null);
                        invokeSuspend$clearRecompositionState(recomposer, list, list2, list3, mutableScatterSet3, mutableScatterSet4, mutableScatterSet, mutableScatterSet2);
                        unit = Unit.INSTANCE;
                        list.clear();
                        return unit;
                    } catch (Throwable th4) {
                        list.clear();
                        throw th4;
                    }
                }
            }
            Snapshot current = Snapshot.INSTANCE.getCurrent();
            ?? transparentObserverMutableSnapshot = current instanceof MutableSnapshot ? new TransparentObserverMutableSnapshot((MutableSnapshot) current, null, null, true, false) : new TransparentObserverSnapshot(current, null, true, z);
            try {
                try {
                    Snapshot makeCurrent = transparentObserverMutableSnapshot.makeCurrent();
                    try {
                        try {
                            if (!list5.isEmpty()) {
                                try {
                                    recomposer.changeCount = recomposer.getChangeCount() + 1;
                                    try {
                                        int size5 = list5.size();
                                        for (int i7 = 0; i7 < size5; i7++) {
                                            mutableScatterSet5.add((ControlledComposition) list5.get(i7));
                                        }
                                        int size6 = list5.size();
                                        for (int i8 = 0; i8 < size6; i8++) {
                                            ((ControlledComposition) list5.get(i8)).applyChanges();
                                        }
                                        list3.clear();
                                    } catch (Throwable th5) {
                                        collection = transparentObserverMutableSnapshot;
                                        transparentObserverMutableSnapshot = 0;
                                        try {
                                            Recomposer.processCompositionError$default(recomposer, th5, null, false, 6, null);
                                            transparentObserverMutableSnapshot = mutableScatterSet4;
                                            invokeSuspend$clearRecompositionState(recomposer, list, list2, list3, mutableScatterSet3, transparentObserverMutableSnapshot, mutableScatterSet, mutableScatterSet2);
                                            unit = Unit.INSTANCE;
                                            try {
                                                list3.clear();
                                                collection.restoreCurrent(makeCurrent);
                                                snapshot = collection;
                                                snapshot.dispose();
                                                return unit;
                                            } catch (Throwable th6) {
                                                th = th6;
                                                scatterSet = makeCurrent;
                                                collection.restoreCurrent(scatterSet);
                                                throw th;
                                            }
                                        } catch (Throwable th7) {
                                            list3.clear();
                                            throw th7;
                                        }
                                    }
                                } catch (Throwable th8) {
                                    th = th8;
                                    collection = transparentObserverMutableSnapshot;
                                    scatterSet = makeCurrent;
                                }
                            }
                            collection = transparentObserverMutableSnapshot;
                            char c = 7;
                            try {
                                if (mutableScatterSet3.isNotEmpty()) {
                                    try {
                                        mutableScatterSet5.plusAssign(scatterSet);
                                        ScatterSet scatterSet2 = scatterSet;
                                        Object[] objArr2 = scatterSet2.elements;
                                        long[] jArr = scatterSet2.metadata;
                                        int length = jArr.length - 2;
                                        if (length >= 0) {
                                            int i9 = 0;
                                            while (true) {
                                                long j2 = jArr[i9];
                                                scatterSet = ((((~j2) << c) & j2 & (-9187201950435737472L)) > (-9187201950435737472L) ? 1 : ((((~j2) << c) & j2 & (-9187201950435737472L)) == (-9187201950435737472L) ? 0 : -1));
                                                if (scatterSet != 0) {
                                                    int i10 = 8 - ((~(i9 - length)) >>> 31);
                                                    for (int i11 = 0; i11 < i10; i11++) {
                                                        if ((j2 & 255) < 128) {
                                                            ((ControlledComposition) objArr2[(i9 << 3) + i11]).applyLateChanges();
                                                        }
                                                        j2 >>= 8;
                                                    }
                                                    if (i10 != 8) {
                                                        break;
                                                    }
                                                }
                                                if (i9 == length) {
                                                    break;
                                                }
                                                i9++;
                                                c = 7;
                                            }
                                        }
                                    } catch (Throwable th9) {
                                        scatterSet = makeCurrent;
                                        try {
                                            Recomposer.processCompositionError$default(recomposer, th9, null, false, 6, null);
                                            invokeSuspend$clearRecompositionState(recomposer, list, list2, list3, mutableScatterSet3, mutableScatterSet4, mutableScatterSet, mutableScatterSet2);
                                            unit = Unit.INSTANCE;
                                            collection.restoreCurrent(scatterSet);
                                            snapshot = collection;
                                            snapshot.dispose();
                                            return unit;
                                        } finally {
                                            mutableScatterSet3.clear();
                                        }
                                    }
                                }
                                scatterSet = makeCurrent;
                                if (mutableScatterSet4.isNotEmpty()) {
                                    try {
                                        MutableScatterSet mutableScatterSet6 = mutableScatterSet5;
                                        Object[] objArr3 = mutableScatterSet6.elements;
                                        long[] jArr2 = mutableScatterSet6.metadata;
                                        int length2 = jArr2.length - 2;
                                        if (length2 >= 0) {
                                            int i12 = 0;
                                            while (true) {
                                                long j3 = jArr2[i12];
                                                if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                    int i13 = 8 - ((~(i12 - length2)) >>> 31);
                                                    for (int i14 = 0; i14 < i13; i14++) {
                                                        if ((j3 & 255) < 128) {
                                                            ((ControlledComposition) objArr3[(i12 << 3) + i14]).changesApplied();
                                                        }
                                                        j3 >>= 8;
                                                    }
                                                    if (i13 != 8) {
                                                        break;
                                                    }
                                                }
                                                if (i12 == length2) {
                                                    break;
                                                }
                                                i12++;
                                            }
                                        }
                                    } catch (Throwable th10) {
                                        try {
                                            Recomposer.processCompositionError$default(recomposer, th10, null, false, 6, null);
                                            invokeSuspend$clearRecompositionState(recomposer, list, list2, list3, mutableScatterSet3, mutableScatterSet4, mutableScatterSet, mutableScatterSet2);
                                            unit = Unit.INSTANCE;
                                            collection.restoreCurrent(scatterSet);
                                            snapshot = collection;
                                            snapshot.dispose();
                                            return unit;
                                        } finally {
                                            mutableScatterSet4.clear();
                                        }
                                    }
                                }
                                Unit unit7 = Unit.INSTANCE;
                                collection.restoreCurrent(scatterSet);
                                collection.dispose();
                                synchronized (recomposer.stateLock) {
                                    recomposer.deriveStateLocked();
                                }
                                Snapshot.INSTANCE.notifyObjectsInitialized();
                                mutableScatterSet2.clear();
                                mutableScatterSet.clear();
                                recomposer.compositionsRemoved = null;
                                Unit unit8 = Unit.INSTANCE;
                                Trace.INSTANCE.endSection(beginSection2);
                                return Unit.INSTANCE;
                            } catch (Throwable th11) {
                                th = th11;
                                collection.restoreCurrent(scatterSet);
                                throw th;
                            }
                        } catch (Throwable th12) {
                            th = th12;
                            scatterSet = transparentObserverMutableSnapshot;
                        }
                    } catch (Throwable th13) {
                        th = th13;
                        scatterSet = makeCurrent;
                        collection = transparentObserverMutableSnapshot;
                    }
                } catch (Throwable th14) {
                    th = th14;
                    collection.dispose();
                    throw th;
                }
            } catch (Throwable th15) {
                th = th15;
                collection = transparentObserverMutableSnapshot;
                collection.dispose();
                throw th;
            }
        } finally {
        }
    }
}
