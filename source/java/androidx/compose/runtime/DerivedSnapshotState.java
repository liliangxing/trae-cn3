package androidx.compose.runtime;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.ObjectIntMap;
import androidx.collection.ObjectIntMapKt;
import androidx.compose.runtime.DerivedState;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.IntRef;
import androidx.compose.runtime.internal.System_jvmKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import androidx.compose.runtime.snapshots.StateRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DerivedState.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001(B%\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J:\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000fH\u0016J\b\u0010!\u001a\u00020\"H\u0016J\b\u0010'\u001a\u00020\"H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0019\u0010#\u001a\u0004\u0018\u00018\u00008G¢\u0006\f\u0012\u0004\b$\u0010%\u001a\u0004\b&\u0010\u001d¨\u0006)"}, d2 = {"Landroidx/compose/runtime/DerivedSnapshotState;", "T", "Landroidx/compose/runtime/snapshots/StateObjectImpl;", "Landroidx/compose/runtime/DerivedState;", "calculation", "Lkotlin/Function0;", "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "<init>", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/SnapshotMutationPolicy;)V", "getPolicy", "()Landroidx/compose/runtime/SnapshotMutationPolicy;", "first", "Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord;", "current", "Landroidx/compose/runtime/snapshots/StateRecord;", "snapshot", "Landroidx/compose/runtime/snapshots/Snapshot;", "currentRecord", "readable", "forceDependencyReads", "", "firstStateRecord", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "prependStateRecord", "", "value", "getValue", "()Ljava/lang/Object;", "Landroidx/compose/runtime/DerivedState$Record;", "getCurrentRecord", "()Landroidx/compose/runtime/DerivedState$Record;", "toString", "", "debuggerDisplayValue", "getDebuggerDisplayValue$annotations", "()V", "getDebuggerDisplayValue", "displayValue", "ResultRecord", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class DerivedSnapshotState<T> extends StateObjectImpl implements DerivedState<T> {
    private final Function0<T> calculation;
    private ResultRecord<T> first = new ResultRecord<>(SnapshotKt.currentSnapshot().getSnapshotId());
    private final SnapshotMutationPolicy<T> policy;

    public static /* synthetic */ void getDebuggerDisplayValue$annotations() {
    }

    @Override // androidx.compose.runtime.DerivedState
    public SnapshotMutationPolicy<T> getPolicy() {
        return this.policy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DerivedSnapshotState(Function0<? extends T> function0, SnapshotMutationPolicy<T> snapshotMutationPolicy) {
        this.calculation = function0;
        this.policy = snapshotMutationPolicy;
    }

    /* compiled from: DerivedState.kt */
    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 2*\u0004\b\u0001\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u00012B\u0013\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0002H\u0016J\b\u0010'\u001a\u00020\u0002H\u0016J\u0019\u0010'\u001a\u00020\u00022\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H\u0016¢\u0006\u0002\u0010(J\u001a\u0010)\u001a\u00020*2\n\u0010+\u001a\u0006\u0012\u0002\b\u00030,2\u0006\u0010-\u001a\u00020.J\u001a\u0010/\u001a\u00020\u000f2\n\u0010+\u001a\u0006\u0012\u0002\b\u00030,2\u0006\u0010-\u001a\u00020.R \u0010\t\u001a\u00060\u0005j\u0002`\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\bR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0011\"\u0004\b#\u0010\u0013R\u0014\u00100\u001a\u00028\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u0010\u001e¨\u00063"}, d2 = {"Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord;", "T", "Landroidx/compose/runtime/snapshots/StateRecord;", "Landroidx/compose/runtime/DerivedState$Record;", "snapshotId", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "<init>", "(J)V", "validSnapshotId", "getValidSnapshotId", "()J", "setValidSnapshotId", "J", "validSnapshotWriteCount", "", "getValidSnapshotWriteCount", "()I", "setValidSnapshotWriteCount", "(I)V", "dependencies", "Landroidx/collection/ObjectIntMap;", "Landroidx/compose/runtime/snapshots/StateObject;", "getDependencies", "()Landroidx/collection/ObjectIntMap;", "setDependencies", "(Landroidx/collection/ObjectIntMap;)V", "result", "", "getResult", "()Ljava/lang/Object;", "setResult", "(Ljava/lang/Object;)V", "resultHash", "getResultHash", "setResultHash", "assign", "", "value", "create", "(J)Landroidx/compose/runtime/snapshots/StateRecord;", "isValid", "", "derivedState", "Landroidx/compose/runtime/DerivedState;", "snapshot", "Landroidx/compose/runtime/snapshots/Snapshot;", "readableHash", "currentValue", "getCurrentValue", "Companion", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
    public static final class ResultRecord<T> extends StateRecord implements DerivedState.Record<T> {
        private ObjectIntMap<StateObject> dependencies;
        private Object result;
        private int resultHash;
        private long validSnapshotId;
        private int validSnapshotWriteCount;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final int $stable = 8;
        private static final Object Unset = new Object();

        /* compiled from: DerivedState.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord$Companion;", "", "<init>", "()V", "Unset", "getUnset", "()Ljava/lang/Object;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Object getUnset() {
                return ResultRecord.Unset;
            }
        }

        public ResultRecord(long j) {
            super(j);
            this.dependencies = ObjectIntMapKt.emptyObjectIntMap();
            this.result = Unset;
        }

        public final long getValidSnapshotId() {
            return this.validSnapshotId;
        }

        public final void setValidSnapshotId(long j) {
            this.validSnapshotId = j;
        }

        public final int getValidSnapshotWriteCount() {
            return this.validSnapshotWriteCount;
        }

        public final void setValidSnapshotWriteCount(int i) {
            this.validSnapshotWriteCount = i;
        }

        @Override // androidx.compose.runtime.DerivedState.Record
        public ObjectIntMap<StateObject> getDependencies() {
            return this.dependencies;
        }

        public void setDependencies(ObjectIntMap<StateObject> objectIntMap) {
            this.dependencies = objectIntMap;
        }

        public final Object getResult() {
            return this.result;
        }

        public final void setResult(Object obj) {
            this.result = obj;
        }

        public final int getResultHash() {
            return this.resultHash;
        }

        public final void setResultHash(int i) {
            this.resultHash = i;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public void assign(StateRecord value) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.runtime.DerivedSnapshotState.ResultRecord<T of androidx.compose.runtime.DerivedSnapshotState.ResultRecord>");
            ResultRecord resultRecord = (ResultRecord) value;
            setDependencies(resultRecord.getDependencies());
            this.result = resultRecord.result;
            this.resultHash = resultRecord.resultHash;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public StateRecord create() {
            return create(SnapshotKt.currentSnapshot().getSnapshotId());
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public StateRecord create(long snapshotId) {
            return new ResultRecord(snapshotId);
        }

        @Override // androidx.compose.runtime.DerivedState.Record
        public T getCurrentValue() {
            return (T) this.result;
        }

        public final boolean isValid(DerivedState<?> derivedState, Snapshot snapshot) {
            boolean z;
            boolean z2;
            synchronized (SnapshotKt.getLock()) {
                z = false;
                if (this.validSnapshotId == snapshot.getSnapshotId()) {
                    if (this.validSnapshotWriteCount == snapshot.getWriteCount()) {
                        z2 = false;
                    }
                }
                z2 = true;
            }
            if (this.result != Unset && (!z2 || this.resultHash == readableHash(derivedState, snapshot))) {
                z = true;
            }
            if (z && z2) {
                synchronized (SnapshotKt.getLock()) {
                    this.validSnapshotId = snapshot.getSnapshotId();
                    this.validSnapshotWriteCount = snapshot.getWriteCount();
                    Unit unit = Unit.INSTANCE;
                }
            }
            return z;
        }

        public final int readableHash(DerivedState<?> derivedState, Snapshot snapshot) {
            ObjectIntMap<StateObject> dependencies;
            int i;
            int i2;
            StateRecord current;
            synchronized (SnapshotKt.getLock()) {
                dependencies = getDependencies();
            }
            char c = 7;
            if (!dependencies.isNotEmpty()) {
                return 7;
            }
            MutableVector<DerivedStateObserver> derivedStateObservers = SnapshotStateKt.derivedStateObservers();
            DerivedStateObserver[] derivedStateObserverArr = derivedStateObservers.content;
            int size = derivedStateObservers.getSize();
            for (int i3 = 0; i3 < size; i3++) {
                derivedStateObserverArr[i3].start(derivedState);
            }
            try {
                Object[] objArr = dependencies.keys;
                int[] iArr = dependencies.values;
                long[] jArr = dependencies.metadata;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i4 = 7;
                    int i5 = 0;
                    while (true) {
                        long j = jArr[i5];
                        if ((((~j) << c) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i6 = 8;
                            int i7 = 8 - ((~(i5 - length)) >>> 31);
                            int i8 = 0;
                            while (i8 < i7) {
                                if ((j & 255) < 128) {
                                    int i9 = (i5 << 3) + i8;
                                    StateObject stateObject = (StateObject) objArr[i9];
                                    if (iArr[i9] == 1) {
                                        if (stateObject instanceof DerivedSnapshotState) {
                                            current = ((DerivedSnapshotState) stateObject).current(snapshot);
                                        } else {
                                            current = SnapshotKt.current(stateObject.getFirstStateRecord(), snapshot);
                                        }
                                        i4 = (((i4 * 31) + System_jvmKt.identityHashCode(current)) * 31) + Long.hashCode(current.getSnapshotId());
                                    }
                                    i2 = 8;
                                } else {
                                    i2 = i6;
                                }
                                j >>= i2;
                                i8++;
                                i6 = i2;
                            }
                            if (i7 != i6) {
                                break;
                            }
                        }
                        if (i5 == length) {
                            break;
                        }
                        i5++;
                        c = 7;
                    }
                    i = i4;
                } else {
                    i = 7;
                }
                Unit unit = Unit.INSTANCE;
                return i;
            } finally {
                DerivedStateObserver[] derivedStateObserverArr2 = derivedStateObservers.content;
                int size2 = derivedStateObservers.getSize();
                for (int i10 = 0; i10 < size2; i10++) {
                    derivedStateObserverArr2[i10].done(derivedState);
                }
            }
        }
    }

    public final StateRecord current(Snapshot snapshot) {
        return currentRecord((ResultRecord) SnapshotKt.current(this.first, snapshot), snapshot, false, this.calculation);
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0180 A[Catch: all -> 0x01ee, TryCatch #3 {, blocks: (B:71:0x0157, B:73:0x0169, B:75:0x016f, B:79:0x0180, B:97:0x0191), top: B:70:0x0157 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final ResultRecord<T> currentRecord(ResultRecord<T> readable, Snapshot snapshot, boolean forceDependencyReads, Function0<? extends T> calculation) {
        boolean z;
        boolean z2;
        long[] jArr;
        long[] jArr2;
        ResultRecord<T> resultRecord = readable;
        DerivedSnapshotState<T> derivedSnapshotState = this;
        if (resultRecord.isValid(derivedSnapshotState, snapshot)) {
            if (forceDependencyReads) {
                MutableVector<DerivedStateObserver> derivedStateObservers = SnapshotStateKt.derivedStateObservers();
                DerivedStateObserver[] derivedStateObserverArr = derivedStateObservers.content;
                int size = derivedStateObservers.getSize();
                for (int i = 0; i < size; i++) {
                    derivedStateObserverArr[i].start(derivedSnapshotState);
                }
                try {
                    ObjectIntMap<StateObject> dependencies = readable.getDependencies();
                    IntRef intRef = (IntRef) SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel.get();
                    if (intRef == null) {
                        intRef = new IntRef(0);
                        SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel.set(intRef);
                    }
                    int element = intRef.getElement();
                    Object[] objArr = dependencies.keys;
                    int[] iArr = dependencies.values;
                    long[] jArr3 = dependencies.metadata;
                    int length = jArr3.length - 2;
                    if (length >= 0) {
                        int i2 = 0;
                        while (true) {
                            long j = jArr3[i2];
                            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                                int i3 = 8 - ((~(i2 - length)) >>> 31);
                                int i4 = 0;
                                while (i4 < i3) {
                                    if ((j & 255) < 128) {
                                        int i5 = (i2 << 3) + i4;
                                        StateObject stateObject = (StateObject) objArr[i5];
                                        jArr2 = jArr3;
                                        intRef.setElement(element + iArr[i5]);
                                        Function1<Object, Unit> readObserver = snapshot.getReadObserver();
                                        if (readObserver != null) {
                                            readObserver.invoke(stateObject);
                                        }
                                    } else {
                                        jArr2 = jArr3;
                                    }
                                    j >>= 8;
                                    i4++;
                                    jArr3 = jArr2;
                                }
                                jArr = jArr3;
                                if (i3 != 8) {
                                    break;
                                }
                            } else {
                                jArr = jArr3;
                            }
                            if (i2 == length) {
                                break;
                            }
                            i2++;
                            jArr3 = jArr;
                        }
                    }
                    intRef.setElement(element);
                    Unit unit = Unit.INSTANCE;
                } finally {
                    DerivedStateObserver[] derivedStateObserverArr2 = derivedStateObservers.content;
                    int size2 = derivedStateObservers.getSize();
                    for (int i6 = 0; i6 < size2; i6++) {
                        derivedStateObserverArr2[i6].done(derivedSnapshotState);
                    }
                }
            }
            return resultRecord;
        }
        final MutableObjectIntMap mutableObjectIntMap = new MutableObjectIntMap(0, 1, null);
        final IntRef intRef2 = (IntRef) SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel.get();
        if (intRef2 == null) {
            intRef2 = new IntRef(0);
            SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel.set(intRef2);
        }
        final int element2 = intRef2.getElement();
        MutableVector<DerivedStateObserver> derivedStateObservers2 = SnapshotStateKt.derivedStateObservers();
        DerivedStateObserver[] derivedStateObserverArr3 = derivedStateObservers2.content;
        int size3 = derivedStateObservers2.getSize();
        for (int i7 = 0; i7 < size3; i7++) {
            derivedStateObserverArr3[i7].start(derivedSnapshotState);
        }
        try {
            intRef2.setElement(element2 + 1);
            Object observe = Snapshot.INSTANCE.observe(new Function1() { // from class: androidx.compose.runtime.DerivedSnapshotState$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit currentRecord$lambda$5$lambda$4$lambda$3;
                    currentRecord$lambda$5$lambda$4$lambda$3 = DerivedSnapshotState.currentRecord$lambda$5$lambda$4$lambda$3(DerivedSnapshotState.this, intRef2, mutableObjectIntMap, element2, obj);
                    return currentRecord$lambda$5$lambda$4$lambda$3;
                }
            }, null, calculation);
            intRef2.setElement(element2);
            DerivedStateObserver[] derivedStateObserverArr4 = derivedStateObservers2.content;
            int size4 = derivedStateObservers2.getSize();
            for (int i8 = 0; i8 < size4; i8++) {
                derivedStateObserverArr4[i8].done(derivedSnapshotState);
            }
            synchronized (SnapshotKt.getLock()) {
                Snapshot current = Snapshot.INSTANCE.getCurrent();
                if (readable.getResult() != ResultRecord.INSTANCE.getUnset()) {
                    SnapshotMutationPolicy<T> policy = getPolicy();
                    if (policy != 0) {
                        z = true;
                        if (policy.equivalent(observe, readable.getResult())) {
                            z2 = true;
                            if (z2) {
                                resultRecord.setDependencies(mutableObjectIntMap);
                                resultRecord.setResultHash(resultRecord.readableHash(this, current));
                            }
                        }
                    } else {
                        z = true;
                    }
                    z2 = false;
                    if (z2) {
                    }
                } else {
                    z = true;
                }
                resultRecord = (ResultRecord) SnapshotKt.newWritableRecord(this.first, this, current);
                resultRecord.setDependencies(mutableObjectIntMap);
                resultRecord.setResultHash(resultRecord.readableHash(this, current));
                resultRecord.setResult(observe);
            }
            IntRef intRef3 = (IntRef) SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel.get();
            if ((intRef3 == null || intRef3.getElement() != 0) ? false : z) {
                Snapshot.INSTANCE.notifyObjectsInitialized();
                synchronized (SnapshotKt.getLock()) {
                    Snapshot current2 = Snapshot.INSTANCE.getCurrent();
                    resultRecord.setValidSnapshotId(current2.getSnapshotId());
                    resultRecord.setValidSnapshotWriteCount(current2.getWriteCount());
                    Unit unit2 = Unit.INSTANCE;
                }
            }
            return resultRecord;
        } catch (Throwable th) {
            DerivedStateObserver[] derivedStateObserverArr5 = derivedStateObservers2.content;
            int size5 = derivedStateObservers2.getSize();
            for (int i9 = 0; i9 < size5; i9++) {
                derivedStateObserverArr5[i9].done(derivedSnapshotState);
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit currentRecord$lambda$5$lambda$4$lambda$3(DerivedSnapshotState derivedSnapshotState, IntRef intRef, MutableObjectIntMap mutableObjectIntMap, int i, Object obj) {
        if (obj == derivedSnapshotState) {
            throw new IllegalStateException("A derived state calculation cannot read itself".toString());
        }
        if (obj instanceof StateObject) {
            mutableObjectIntMap.set(obj, Math.min(intRef.getElement() - i, mutableObjectIntMap.getOrDefault(obj, Integer.MAX_VALUE)));
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public StateRecord getFirstStateRecord() {
        return this.first;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public void prependStateRecord(StateRecord value) {
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.runtime.DerivedSnapshotState.ResultRecord<T of androidx.compose.runtime.DerivedSnapshotState>");
        this.first = (ResultRecord) value;
    }

    @Override // androidx.compose.runtime.State
    public T getValue() {
        Function1<Object, Unit> readObserver = Snapshot.INSTANCE.getCurrent().getReadObserver();
        if (readObserver != null) {
            readObserver.invoke(this);
        }
        Snapshot current = Snapshot.INSTANCE.getCurrent();
        return (T) currentRecord((ResultRecord) SnapshotKt.current(this.first, current), current, true, this.calculation).getResult();
    }

    @Override // androidx.compose.runtime.DerivedState
    public DerivedState.Record<T> getCurrentRecord() {
        Snapshot current = Snapshot.INSTANCE.getCurrent();
        return currentRecord((ResultRecord) SnapshotKt.current(this.first, current), current, false, this.calculation);
    }

    public String toString() {
        return "DerivedState(value=" + displayValue() + ")@" + hashCode();
    }

    public final T getDebuggerDisplayValue() {
        ResultRecord resultRecord = (ResultRecord) SnapshotKt.current(this.first);
        if (resultRecord.isValid(this, Snapshot.INSTANCE.getCurrent())) {
            return (T) resultRecord.getResult();
        }
        return null;
    }

    private final String displayValue() {
        ResultRecord resultRecord = (ResultRecord) SnapshotKt.current(this.first);
        return resultRecord.isValid(this, Snapshot.INSTANCE.getCurrent()) ? String.valueOf(resultRecord.getResult()) : "<Not calculated>";
    }
}
