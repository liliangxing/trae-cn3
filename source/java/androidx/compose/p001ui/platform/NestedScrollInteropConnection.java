package androidx.compose.p001ui.platform;

import android.view.View;
import androidx.compose.p001ui.unit.Velocity;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ViewCompat;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;

/* compiled from: NestedScrollInteropConnection.android.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u0018H\u0096@¢\u0006\u0004\b\u0019\u0010\u001aJ \u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u0018H\u0096@¢\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u001fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Landroidx/compose/ui/platform/NestedScrollInteropConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "view", "Landroid/view/View;", "minFlingVelocity", "", "<init>", "(Landroid/view/View;F)V", "nestedScrollChildHelper", "Landroidx/core/view/NestedScrollingChildHelper;", "consumedScrollCache", "", "onPreScroll", "Landroidx/compose/ui/geometry/Offset;", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPreScroll-OzD1aCk", "(JI)J", "onPostScroll", "consumed", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "Landroidx/compose/ui/unit/Velocity;", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostFling", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopNestedScrolls", "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class NestedScrollInteropConnection implements NestedScrollConnection {
    public static final int $stable = 8;
    private final int[] consumedScrollCache;
    private final float minFlingVelocity;
    private final NestedScrollingChildHelper nestedScrollChildHelper;
    private final View view;

    public NestedScrollInteropConnection(View view, float f) {
        this.view = view;
        this.minFlingVelocity = f;
        NestedScrollingChildHelper nestedScrollingChildHelper = new NestedScrollingChildHelper(view);
        nestedScrollingChildHelper.setNestedScrollingEnabled(true);
        this.nestedScrollChildHelper = nestedScrollingChildHelper;
        this.consumedScrollCache = new int[2];
        ViewCompat.setNestedScrollingEnabled(view, true);
    }

    /* renamed from: onPreScroll-OzD1aCk, reason: not valid java name */
    public long m1801onPreScrollOzD1aCk(long available, int source) {
        int m1805getScrollAxesk4lQ0M;
        int m1808toViewTypeGyEprt8;
        int m1808toViewTypeGyEprt82;
        long m1807toOffsetUv8p0NA;
        NestedScrollingChildHelper nestedScrollingChildHelper = this.nestedScrollChildHelper;
        m1805getScrollAxesk4lQ0M = NestedScrollInteropConnectionKt.m1805getScrollAxesk4lQ0M(available);
        m1808toViewTypeGyEprt8 = NestedScrollInteropConnectionKt.m1808toViewTypeGyEprt8(source);
        if (nestedScrollingChildHelper.startNestedScroll(m1805getScrollAxesk4lQ0M, m1808toViewTypeGyEprt8)) {
            ArraysKt.fill$default(this.consumedScrollCache, 0, 0, 0, 6, (Object) null);
            NestedScrollingChildHelper nestedScrollingChildHelper2 = this.nestedScrollChildHelper;
            int composeToViewOffset = NestedScrollInteropConnectionKt.composeToViewOffset(Float.intBitsToFloat((int) (available >> 32)));
            int composeToViewOffset2 = NestedScrollInteropConnectionKt.composeToViewOffset(Float.intBitsToFloat((int) (4294967295L & available)));
            int[] iArr = this.consumedScrollCache;
            m1808toViewTypeGyEprt82 = NestedScrollInteropConnectionKt.m1808toViewTypeGyEprt8(source);
            nestedScrollingChildHelper2.dispatchNestedPreScroll(composeToViewOffset, composeToViewOffset2, iArr, null, m1808toViewTypeGyEprt82);
            m1807toOffsetUv8p0NA = NestedScrollInteropConnectionKt.m1807toOffsetUv8p0NA(this.consumedScrollCache, available);
            return m1807toOffsetUv8p0NA;
        }
        return Offset.Companion.getZero-F1C5BW0();
    }

    /* renamed from: onPostScroll-DzOQY0M, reason: not valid java name */
    public long m1799onPostScrollDzOQY0M(long consumed, long available, int source) {
        int m1805getScrollAxesk4lQ0M;
        int m1808toViewTypeGyEprt8;
        int m1808toViewTypeGyEprt82;
        long m1807toOffsetUv8p0NA;
        NestedScrollingChildHelper nestedScrollingChildHelper = this.nestedScrollChildHelper;
        m1805getScrollAxesk4lQ0M = NestedScrollInteropConnectionKt.m1805getScrollAxesk4lQ0M(available);
        m1808toViewTypeGyEprt8 = NestedScrollInteropConnectionKt.m1808toViewTypeGyEprt8(source);
        if (nestedScrollingChildHelper.startNestedScroll(m1805getScrollAxesk4lQ0M, m1808toViewTypeGyEprt8)) {
            ArraysKt.fill$default(this.consumedScrollCache, 0, 0, 0, 6, (Object) null);
            NestedScrollingChildHelper nestedScrollingChildHelper2 = this.nestedScrollChildHelper;
            int composeToViewOffset = NestedScrollInteropConnectionKt.composeToViewOffset(Float.intBitsToFloat((int) (consumed >> 32)));
            int composeToViewOffset2 = NestedScrollInteropConnectionKt.composeToViewOffset(Float.intBitsToFloat((int) (consumed & 4294967295L)));
            int composeToViewOffset3 = NestedScrollInteropConnectionKt.composeToViewOffset(Float.intBitsToFloat((int) (available >> 32)));
            int composeToViewOffset4 = NestedScrollInteropConnectionKt.composeToViewOffset(Float.intBitsToFloat((int) (available & 4294967295L)));
            m1808toViewTypeGyEprt82 = NestedScrollInteropConnectionKt.m1808toViewTypeGyEprt8(source);
            nestedScrollingChildHelper2.dispatchNestedScroll(composeToViewOffset, composeToViewOffset2, composeToViewOffset3, composeToViewOffset4, null, m1808toViewTypeGyEprt82, this.consumedScrollCache);
            m1807toOffsetUv8p0NA = NestedScrollInteropConnectionKt.m1807toOffsetUv8p0NA(this.consumedScrollCache, available);
            return m1807toOffsetUv8p0NA;
        }
        return Offset.Companion.getZero-F1C5BW0();
    }

    /* renamed from: onPreFling-QWom1Mo, reason: not valid java name */
    public Object m1800onPreFlingQWom1Mo(long j, Continuation<? super Velocity> continuation) {
        float viewVelocity;
        float viewVelocity2;
        float viewVelocity3;
        float viewVelocity4;
        NestedScrollingChildHelper nestedScrollingChildHelper = this.nestedScrollChildHelper;
        viewVelocity = NestedScrollInteropConnectionKt.toViewVelocity(Velocity.m2918getXimpl(j));
        viewVelocity2 = NestedScrollInteropConnectionKt.toViewVelocity(Velocity.m2919getYimpl(j));
        if (!nestedScrollingChildHelper.dispatchNestedPreFling(viewVelocity, viewVelocity2)) {
            NestedScrollingChildHelper nestedScrollingChildHelper2 = this.nestedScrollChildHelper;
            viewVelocity3 = NestedScrollInteropConnectionKt.toViewVelocity(Velocity.m2918getXimpl(j));
            viewVelocity4 = NestedScrollInteropConnectionKt.toViewVelocity(Velocity.m2919getYimpl(j));
            if (!nestedScrollingChildHelper2.dispatchNestedFling(viewVelocity3, viewVelocity4, true)) {
                j = Velocity.INSTANCE.m2929getZero9UxMQ8M();
            }
        }
        return Velocity.m2909boximpl(j);
    }

    /* renamed from: onPostFling-RZ2iAVY, reason: not valid java name */
    public Object m1798onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation) {
        stopNestedScrolls();
        return Velocity.m2909boximpl(Velocity.INSTANCE.m2929getZero9UxMQ8M());
    }

    private final void stopNestedScrolls() {
        if (this.nestedScrollChildHelper.hasNestedScrollingParent(0)) {
            this.nestedScrollChildHelper.stopNestedScroll(0);
        }
        if (this.nestedScrollChildHelper.hasNestedScrollingParent(1)) {
            this.nestedScrollChildHelper.stopNestedScroll(1);
        }
    }
}
