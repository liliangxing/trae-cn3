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
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0016H\u0096@¢\u0006\u0004\b\u0017\u0010\u0018J \u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0016H\u0096@¢\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u001dH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Landroidx/compose/ui/platform/LegacyNestedScrollInteropConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "nestedScrollChildHelper", "Landroidx/core/view/NestedScrollingChildHelper;", "consumedScrollCache", "", "onPreScroll", "Landroidx/compose/ui/geometry/Offset;", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPreScroll-OzD1aCk", "(JI)J", "onPostScroll", "consumed", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "Landroidx/compose/ui/unit/Velocity;", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostFling", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "interruptOngoingScrolls", "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class LegacyNestedScrollInteropConnection implements NestedScrollConnection {
    public static final int $stable = 8;
    private final int[] consumedScrollCache;
    private final NestedScrollingChildHelper nestedScrollChildHelper;
    private final View view;

    public LegacyNestedScrollInteropConnection(View view) {
        this.view = view;
        NestedScrollingChildHelper nestedScrollingChildHelper = new NestedScrollingChildHelper(view);
        nestedScrollingChildHelper.setNestedScrollingEnabled(true);
        this.nestedScrollChildHelper = nestedScrollingChildHelper;
        this.consumedScrollCache = new int[2];
        ViewCompat.setNestedScrollingEnabled(view, true);
    }

    /* renamed from: onPreScroll-OzD1aCk, reason: not valid java name */
    public long m1783onPreScrollOzD1aCk(long available, int source) {
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
    public long m1781onPostScrollDzOQY0M(long consumed, long available, int source) {
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
    public Object m1782onPreFlingQWom1Mo(long j, Continuation<? super Velocity> continuation) {
        float viewVelocity;
        float viewVelocity2;
        NestedScrollingChildHelper nestedScrollingChildHelper = this.nestedScrollChildHelper;
        viewVelocity = NestedScrollInteropConnectionKt.toViewVelocity(Velocity.m2918getXimpl(j));
        viewVelocity2 = NestedScrollInteropConnectionKt.toViewVelocity(Velocity.m2919getYimpl(j));
        if (!nestedScrollingChildHelper.dispatchNestedPreFling(viewVelocity, viewVelocity2)) {
            j = Velocity.INSTANCE.m2929getZero9UxMQ8M();
        }
        interruptOngoingScrolls();
        return Velocity.m2909boximpl(j);
    }

    /* renamed from: onPostFling-RZ2iAVY, reason: not valid java name */
    public Object m1780onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation) {
        float viewVelocity;
        float viewVelocity2;
        NestedScrollingChildHelper nestedScrollingChildHelper = this.nestedScrollChildHelper;
        viewVelocity = NestedScrollInteropConnectionKt.toViewVelocity(Velocity.m2918getXimpl(j2));
        viewVelocity2 = NestedScrollInteropConnectionKt.toViewVelocity(Velocity.m2919getYimpl(j2));
        if (!nestedScrollingChildHelper.dispatchNestedFling(viewVelocity, viewVelocity2, true)) {
            j2 = Velocity.INSTANCE.m2929getZero9UxMQ8M();
        }
        interruptOngoingScrolls();
        return Velocity.m2909boximpl(j2);
    }

    private final void interruptOngoingScrolls() {
        if (this.nestedScrollChildHelper.hasNestedScrollingParent(0)) {
            this.nestedScrollChildHelper.stopNestedScroll(0);
        }
        if (this.nestedScrollChildHelper.hasNestedScrollingParent(1)) {
            this.nestedScrollChildHelper.stopNestedScroll(1);
        }
    }
}
