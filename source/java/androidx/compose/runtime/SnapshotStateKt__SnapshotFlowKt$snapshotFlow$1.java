package androidx.compose.runtime;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSet;
import androidx.compose.runtime.collection.ScatterSetWrapper;
import androidx.compose.runtime.snapshots.ObserverHandle;
import androidx.compose.runtime.snapshots.ReaderKind;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: SnapshotFlow.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1", f = "SnapshotFlow.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {143, 147, 170}, m = "invokeSuspend", n = {"$this$flow", "readSet", "readObserver", "appliedChanges", "unregisterApplyObserver", "lastValue", "$this$flow", "readSet", "readObserver", "appliedChanges", "unregisterApplyObserver", "lastValue", "found", "$this$flow", "readSet", "readObserver", "appliedChanges", "unregisterApplyObserver", "lastValue"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1<T> extends SuspendLambda implements Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<T> $block;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1(Function0<? extends T> function0, Continuation<? super SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1> continuation) {
        super(2, continuation);
        this.$block = function0;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> snapshotStateKt__SnapshotFlowKt$snapshotFlow$1 = new SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1<>(this.$block, continuation);
        snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$0 = obj;
        return snapshotStateKt__SnapshotFlowKt$snapshotFlow$1;
    }

    public final Object invoke(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00e0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00ed A[Catch: all -> 0x0053, TryCatch #2 {all -> 0x0053, blocks: (B:15:0x00e9, B:17:0x00ed, B:21:0x00f7, B:25:0x0105, B:31:0x011b, B:33:0x0124, B:45:0x014a, B:46:0x014d, B:59:0x004b, B:27:0x0110, B:30:0x0118, B:41:0x0145, B:42:0x0148), top: B:58:0x004b, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0105 A[Catch: all -> 0x0053, TRY_LEAVE, TryCatch #2 {all -> 0x0053, blocks: (B:15:0x00e9, B:17:0x00ed, B:21:0x00f7, B:25:0x0105, B:31:0x011b, B:33:0x0124, B:45:0x014a, B:46:0x014d, B:59:0x004b, B:27:0x0110, B:30:0x0118, B:41:0x0145, B:42:0x0148), top: B:58:0x004b, inners: #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ObserverHandle observerHandle;
        FlowCollector flowCollector;
        final MutableScatterSet mutableScatterSet;
        Function1<Object, Unit> function1;
        final Channel Channel$default;
        Snapshot takeSnapshot;
        Snapshot makeCurrent;
        Object obj2;
        Object obj3;
        SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1<T> snapshotStateKt__SnapshotFlowKt$snapshotFlow$1;
        boolean intersects$SnapshotStateKt__SnapshotFlowKt;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i != 0) {
                if (i == 1) {
                    obj2 = this.L$5;
                    observerHandle = (ObserverHandle) this.L$4;
                    Channel$default = (Channel) this.L$3;
                    function1 = (Function1) this.L$2;
                    mutableScatterSet = (MutableScatterSet) this.L$1;
                    flowCollector = (FlowCollector) this.L$0;
                } else if (i == 2) {
                    int i2 = this.I$0;
                    Object obj4 = this.L$5;
                    ObserverHandle observerHandle2 = (ObserverHandle) this.L$4;
                    Channel channel = (Channel) this.L$3;
                    Function1<Object, Unit> function12 = (Function1) this.L$2;
                    MutableScatterSet mutableScatterSet2 = (MutableScatterSet) this.L$1;
                    FlowCollector flowCollector2 = (FlowCollector) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        obj3 = obj;
                        SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1<T> snapshotStateKt__SnapshotFlowKt$snapshotFlow$12 = this;
                        Set set = (Set) obj3;
                        do {
                            if (i2 == 0) {
                                intersects$SnapshotStateKt__SnapshotFlowKt = SnapshotStateKt__SnapshotFlowKt.intersects$SnapshotStateKt__SnapshotFlowKt(mutableScatterSet2, set);
                                if (!intersects$SnapshotStateKt__SnapshotFlowKt) {
                                    i2 = 0;
                                    set = (Set) ChannelResult.getOrNull-impl(channel.tryReceive-PtdJZtk());
                                }
                            }
                            i2 = 1;
                            set = (Set) ChannelResult.getOrNull-impl(channel.tryReceive-PtdJZtk());
                        } while (set != null);
                        if (i2 != 0) {
                            mutableScatterSet2.clear();
                            takeSnapshot = Snapshot.INSTANCE.takeSnapshot(function12);
                            Function0<T> function0 = snapshotStateKt__SnapshotFlowKt$snapshotFlow$12.$block;
                            try {
                                try {
                                    Object invoke = function0.invoke();
                                    takeSnapshot.restoreCurrent(makeCurrent);
                                    takeSnapshot.dispose();
                                    if (!Intrinsics.areEqual(invoke, obj4)) {
                                        snapshotStateKt__SnapshotFlowKt$snapshotFlow$12.L$0 = flowCollector2;
                                        snapshotStateKt__SnapshotFlowKt$snapshotFlow$12.L$1 = mutableScatterSet2;
                                        snapshotStateKt__SnapshotFlowKt$snapshotFlow$12.L$2 = function12;
                                        snapshotStateKt__SnapshotFlowKt$snapshotFlow$12.L$3 = channel;
                                        snapshotStateKt__SnapshotFlowKt$snapshotFlow$12.L$4 = observerHandle2;
                                        snapshotStateKt__SnapshotFlowKt$snapshotFlow$12.L$5 = invoke;
                                        snapshotStateKt__SnapshotFlowKt$snapshotFlow$12.label = 3;
                                        if (flowCollector2.emit(invoke, (Continuation) snapshotStateKt__SnapshotFlowKt$snapshotFlow$12) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        observerHandle = observerHandle2;
                                        Channel$default = channel;
                                        function1 = function12;
                                        mutableScatterSet = mutableScatterSet2;
                                        flowCollector = flowCollector2;
                                        obj2 = invoke;
                                        snapshotStateKt__SnapshotFlowKt$snapshotFlow$1 = snapshotStateKt__SnapshotFlowKt$snapshotFlow$12;
                                        snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$0 = flowCollector;
                                        snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$1 = mutableScatterSet;
                                        snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$2 = function1;
                                        snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$3 = Channel$default;
                                        snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$4 = observerHandle;
                                        snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$5 = obj2;
                                        snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.I$0 = 0;
                                        snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.label = 2;
                                        obj3 = Channel$default.receive((Continuation) snapshotStateKt__SnapshotFlowKt$snapshotFlow$1);
                                        if (obj3 == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        snapshotStateKt__SnapshotFlowKt$snapshotFlow$12 = snapshotStateKt__SnapshotFlowKt$snapshotFlow$1;
                                        flowCollector2 = flowCollector;
                                        mutableScatterSet2 = mutableScatterSet;
                                        function12 = function1;
                                        channel = Channel$default;
                                        observerHandle2 = observerHandle;
                                        obj4 = obj2;
                                        i2 = 0;
                                        Set set2 = (Set) obj3;
                                        do {
                                            if (i2 == 0) {
                                            }
                                            i2 = 1;
                                            set2 = (Set) ChannelResult.getOrNull-impl(channel.tryReceive-PtdJZtk());
                                        } while (set2 != null);
                                        if (i2 != 0) {
                                        }
                                    }
                                } finally {
                                }
                                makeCurrent = takeSnapshot.makeCurrent();
                            } finally {
                            }
                        }
                        obj2 = obj4;
                        observerHandle = observerHandle2;
                        Channel$default = channel;
                        function1 = function12;
                        mutableScatterSet = mutableScatterSet2;
                        flowCollector = flowCollector2;
                        snapshotStateKt__SnapshotFlowKt$snapshotFlow$1 = snapshotStateKt__SnapshotFlowKt$snapshotFlow$12;
                        snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$0 = flowCollector;
                        snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$1 = mutableScatterSet;
                        snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$2 = function1;
                        snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$3 = Channel$default;
                        snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$4 = observerHandle;
                        snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$5 = obj2;
                        snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.I$0 = 0;
                        snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.label = 2;
                        obj3 = Channel$default.receive((Continuation) snapshotStateKt__SnapshotFlowKt$snapshotFlow$1);
                        if (obj3 == coroutine_suspended) {
                        }
                    } catch (Throwable th) {
                        th = th;
                        observerHandle = observerHandle2;
                        observerHandle.dispose();
                        throw th;
                    }
                } else {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    obj2 = this.L$5;
                    observerHandle = (ObserverHandle) this.L$4;
                    Channel$default = (Channel) this.L$3;
                    function1 = (Function1) this.L$2;
                    mutableScatterSet = (MutableScatterSet) this.L$1;
                    flowCollector = (FlowCollector) this.L$0;
                }
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                flowCollector = (FlowCollector) this.L$0;
                mutableScatterSet = new MutableScatterSet(0, 1, null);
                function1 = new Function1() { // from class: androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj5) {
                        Unit invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1.invokeSuspend$lambda$0(MutableScatterSet.this, obj5);
                        return invokeSuspend$lambda$0;
                    }
                };
                Channel$default = ChannelKt.Channel$default(Integer.MAX_VALUE, (BufferOverflow) null, (Function1) null, 6, (Object) null);
                observerHandle = Snapshot.INSTANCE.registerApplyObserver(new Function2() { // from class: androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj5, Object obj6) {
                        Unit invokeSuspend$lambda$2;
                        invokeSuspend$lambda$2 = SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1.invokeSuspend$lambda$2(Channel$default, (Set) obj5, (Snapshot) obj6);
                        return invokeSuspend$lambda$2;
                    }
                });
                takeSnapshot = Snapshot.INSTANCE.takeSnapshot(function1);
                Function0<T> function02 = this.$block;
                try {
                    makeCurrent = takeSnapshot.makeCurrent();
                    try {
                        Object invoke2 = function02.invoke();
                        takeSnapshot.restoreCurrent(makeCurrent);
                        takeSnapshot.dispose();
                        this.L$0 = flowCollector;
                        this.L$1 = mutableScatterSet;
                        this.L$2 = function1;
                        this.L$3 = Channel$default;
                        this.L$4 = observerHandle;
                        this.L$5 = invoke2;
                        this.label = 1;
                        if (flowCollector.emit(invoke2, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj2 = invoke2;
                    } finally {
                        takeSnapshot.restoreCurrent(makeCurrent);
                    }
                } finally {
                }
            }
            snapshotStateKt__SnapshotFlowKt$snapshotFlow$1 = this;
            snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$0 = flowCollector;
            snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$1 = mutableScatterSet;
            snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$2 = function1;
            snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$3 = Channel$default;
            snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$4 = observerHandle;
            snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$5 = obj2;
            snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.I$0 = 0;
            snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.label = 2;
            obj3 = Channel$default.receive((Continuation) snapshotStateKt__SnapshotFlowKt$snapshotFlow$1);
            if (obj3 == coroutine_suspended) {
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(MutableScatterSet mutableScatterSet, Object obj) {
        if (obj instanceof StateObjectImpl) {
            ReaderKind.Companion companion = ReaderKind.INSTANCE;
            ((StateObjectImpl) obj).m4276recordReadInh_f27i8$runtime(ReaderKind.m4253constructorimpl(4));
        }
        mutableScatterSet.add(obj);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a5 A[EDGE_INSN: B:20:0x00a5->B:21:0x00a5 BREAK  A[LOOP:0: B:6:0x001a->B:35:0x006a, LOOP_LABEL: LOOP:0: B:6:0x001a->B:35:0x006a], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0062 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a5 A[EDGE_INSN: B:52:0x00a5->B:21:0x00a5 BREAK  A[LOOP:2: B:43:0x0083->B:53:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[LOOP:2: B:43:0x0083->B:53:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit invokeSuspend$lambda$2(Channel channel, Set set, Snapshot snapshot) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        if (set instanceof ScatterSetWrapper) {
            ScatterSet<T> set$runtime = ((ScatterSetWrapper) set).getSet$runtime();
            Object[] objArr = set$runtime.elements;
            long[] jArr = set$runtime.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i = 0;
                loop0: while (true) {
                    long j = jArr[i];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i2 = 8 - ((~(i - length)) >>> 31);
                        for (int i3 = 0; i3 < i2; i3++) {
                            if ((255 & j) < 128) {
                                Object obj = objArr[(i << 3) + i3];
                                if (obj instanceof StateObjectImpl) {
                                    ReaderKind.Companion companion = ReaderKind.INSTANCE;
                                    if (!((StateObjectImpl) obj).m4275isReadInh_f27i8$runtime(ReaderKind.m4253constructorimpl(4))) {
                                        z2 = false;
                                        if (!z2) {
                                            break loop0;
                                        }
                                    }
                                }
                                z2 = true;
                                if (!z2) {
                                }
                            }
                            j >>= 8;
                        }
                        if (i2 != 8) {
                            break;
                        }
                    }
                    if (i == length) {
                        break;
                    }
                    i++;
                }
            }
            z3 = false;
        } else {
            Set set2 = set;
            if (!(set2 instanceof Collection) || !set2.isEmpty()) {
                for (T t : set2) {
                    if (t instanceof StateObjectImpl) {
                        ReaderKind.Companion companion2 = ReaderKind.INSTANCE;
                        if (!((StateObjectImpl) t).m4275isReadInh_f27i8$runtime(ReaderKind.m4253constructorimpl(4))) {
                            z = false;
                            if (!z) {
                                break;
                            }
                        }
                    }
                    z = true;
                    if (!z) {
                    }
                }
            }
            z3 = false;
        }
        if (z3) {
            channel.trySend-JP2dKIU(set);
        }
        return Unit.INSTANCE;
    }
}
