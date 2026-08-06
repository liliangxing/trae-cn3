package androidx.compose.runtime.snapshots;

import androidx.collection.MutableScatterSet;
import androidx.compose.runtime.snapshots.SnapshotApplyResult;
import androidx.compose.runtime.snapshots.tooling.SnapshotObserverKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Snapshot.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001BO\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b\u0012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b\u0012\u0006\u0010\f\u001a\u00020\u0001¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0017\u001a\u00020\nH\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\nH\u0002R\u0011\u0010\f\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Landroidx/compose/runtime/snapshots/NestedMutableSnapshot;", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "snapshotId", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "invalid", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "readObserver", "Lkotlin/Function1;", "", "", "writeObserver", "parent", "<init>", "(JLandroidx/compose/runtime/snapshots/SnapshotIdSet;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/snapshots/MutableSnapshot;)V", "getParent", "()Landroidx/compose/runtime/snapshots/MutableSnapshot;", "deactivated", "", "root", "Landroidx/compose/runtime/snapshots/Snapshot;", "getRoot", "()Landroidx/compose/runtime/snapshots/Snapshot;", "dispose", "apply", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "deactivate", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class NestedMutableSnapshot extends MutableSnapshot {
    public static final int $stable = 8;
    private boolean deactivated;
    private final MutableSnapshot parent;

    public final MutableSnapshot getParent() {
        return this.parent;
    }

    public NestedMutableSnapshot(long j, SnapshotIdSet snapshotIdSet, Function1<Object, Unit> function1, Function1<Object, Unit> function12, MutableSnapshot mutableSnapshot) {
        super(j, snapshotIdSet, function1, function12);
        this.parent = mutableSnapshot;
        mutableSnapshot.mo4249nestedActivated$runtime(this);
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public Snapshot getRoot() {
        return this.parent.getRoot();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public void dispose() {
        if (getDisposed()) {
            return;
        }
        super.dispose();
        deactivate();
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0071, code lost:
    
        if (r1 == null) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008d A[Catch: all -> 0x00de, TryCatch #0 {, blocks: (B:11:0x0038, B:13:0x0040, B:16:0x0047, B:21:0x0063, B:23:0x006b, B:25:0x0081, B:27:0x008d, B:28:0x0092, B:33:0x0073, B:34:0x007c), top: B:10:0x0038 }] */
    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SnapshotApplyResult apply() {
        Map<StateRecord, ? extends StateRecord> map;
        Map<StateRecord, ? extends StateRecord> optimisticMerges;
        if (this.parent.getApplied() || this.parent.getDisposed()) {
            return new SnapshotApplyResult.Failure(this);
        }
        MutableScatterSet<StateObject> modified$runtime = getModified$runtime();
        long snapshotId = getSnapshotId();
        if (modified$runtime != null) {
            optimisticMerges = SnapshotKt.optimisticMerges(this.parent.getSnapshotId(), this, this.parent.getInvalid());
            map = optimisticMerges;
        } else {
            map = null;
        }
        synchronized (SnapshotKt.getLock()) {
            SnapshotKt.validateOpen(this);
            if (modified$runtime != null && modified$runtime.get_size() != 0) {
                SnapshotApplyResult innerApplyLocked$runtime = innerApplyLocked$runtime(this.parent.getSnapshotId(), modified$runtime, map, this.parent.getInvalid());
                if (!Intrinsics.areEqual(innerApplyLocked$runtime, SnapshotApplyResult.Success.INSTANCE)) {
                    return innerApplyLocked$runtime;
                }
                MutableScatterSet<StateObject> modified$runtime2 = this.parent.getModified$runtime();
                if (modified$runtime2 != null) {
                    modified$runtime2.addAll(modified$runtime);
                }
                this.parent.setModified$runtime(modified$runtime);
                setModified$runtime(null);
                if (Intrinsics.compare(this.parent.getSnapshotId(), snapshotId) < 0) {
                    this.parent.advance$runtime();
                }
                MutableSnapshot mutableSnapshot = this.parent;
                mutableSnapshot.setInvalid$runtime(mutableSnapshot.getInvalid().clear(snapshotId).andNot(getPreviousIds()));
                this.parent.recordPrevious$runtime(snapshotId);
                this.parent.recordPreviousPinnedSnapshot$runtime(takeoverPinnedSnapshot$runtime());
                this.parent.recordPreviousList$runtime(getPreviousIds());
                this.parent.recordPreviousPinnedSnapshots$runtime(getPreviousPinnedSnapshots());
                Unit unit = Unit.INSTANCE;
                setApplied$runtime(true);
                deactivate();
                SnapshotObserverKt.dispatchObserverOnApplied(this, modified$runtime);
                return SnapshotApplyResult.Success.INSTANCE;
            }
            closeAndReleasePinning$runtime();
            Unit unit2 = Unit.INSTANCE;
            if (Intrinsics.compare(this.parent.getSnapshotId(), snapshotId) < 0) {
            }
            MutableSnapshot mutableSnapshot2 = this.parent;
            mutableSnapshot2.setInvalid$runtime(mutableSnapshot2.getInvalid().clear(snapshotId).andNot(getPreviousIds()));
            this.parent.recordPrevious$runtime(snapshotId);
            this.parent.recordPreviousPinnedSnapshot$runtime(takeoverPinnedSnapshot$runtime());
            this.parent.recordPreviousList$runtime(getPreviousIds());
            this.parent.recordPreviousPinnedSnapshots$runtime(getPreviousPinnedSnapshots());
            Unit unit3 = Unit.INSTANCE;
            setApplied$runtime(true);
            deactivate();
            SnapshotObserverKt.dispatchObserverOnApplied(this, modified$runtime);
            return SnapshotApplyResult.Success.INSTANCE;
        }
    }

    private final void deactivate() {
        if (this.deactivated) {
            return;
        }
        this.deactivated = true;
        this.parent.mo4250nestedDeactivated$runtime(this);
    }
}
