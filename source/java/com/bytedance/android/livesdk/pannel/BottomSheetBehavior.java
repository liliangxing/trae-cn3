package com.bytedance.android.livesdk.pannel;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewParentCompat;
import androidx.customview.widget.ViewDragHelper;
import androidx.exifinterface.media.ExifInterface;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.android.livesdk.pannel.BottomSheetBehavior;
import com.bytedance.android.livesdk.pannel.SheetBaseBehavior;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BottomSheetBehavior.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u0000*\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0002\u008b\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\b\u0010R\u001a\u00020SH\u0002J\b\u0010T\u001a\u00020\u0019H\u0002J\u0010\u0010U\u001a\u00020\u00192\u0006\u0010V\u001a\u00020WH\u0002J\b\u0010X\u001a\u00020\u0019H\u0002J\u000e\u0010Y\u001a\u00020S2\u0006\u0010Z\u001a\u00020\fJ\u0014\u0010[\u001a\u0004\u0018\u0001002\b\u0010\\\u001a\u0004\u0018\u00010\u0002H\u0002J\u0006\u0010]\u001a\u00020\fJ\u0006\u0010^\u001a\u00020\fJ\u0006\u0010_\u001a\u00020\u0019J%\u0010`\u001a\u00020\u00192\u0006\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00028\u00002\u0006\u0010V\u001a\u00020WH\u0016¢\u0006\u0002\u0010dJ%\u0010e\u001a\u00020\u00192\u0006\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00028\u00002\u0006\u0010f\u001a\u00020\fH\u0016¢\u0006\u0002\u0010gJ5\u0010h\u001a\u00020\u00192\u0006\u0010i\u001a\u00020b2\u0006\u0010c\u001a\u00028\u00002\u0006\u0010j\u001a\u00020\u00022\u0006\u0010k\u001a\u00020'2\u0006\u0010l\u001a\u00020'H\u0016¢\u0006\u0002\u0010mJE\u0010n\u001a\u00020S2\u0006\u0010i\u001a\u00020b2\u0006\u0010c\u001a\u00028\u00002\u0006\u0010j\u001a\u00020\u00022\u0006\u0010o\u001a\u00020\f2\u0006\u0010p\u001a\u00020\f2\u0006\u0010q\u001a\u00020r2\u0006\u0010s\u001a\u00020\fH\u0016¢\u0006\u0002\u0010tJ%\u0010u\u001a\u00020S2\u0006\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00028\u00002\u0006\u0010;\u001a\u00020vH\u0016¢\u0006\u0002\u0010wJ\u001f\u0010x\u001a\u0004\u0018\u00010v2\u0006\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010yJ=\u0010z\u001a\u00020\u00192\u0006\u0010i\u001a\u00020b2\u0006\u0010c\u001a\u00028\u00002\u0006\u0010{\u001a\u00020\u00022\u0006\u0010j\u001a\u00020\u00022\u0006\u0010|\u001a\u00020\f2\u0006\u0010s\u001a\u00020\fH\u0016¢\u0006\u0002\u0010}J-\u0010~\u001a\u00020S2\u0006\u0010i\u001a\u00020b2\u0006\u0010c\u001a\u00028\u00002\u0006\u0010j\u001a\u00020\u00022\u0006\u0010s\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\u007fJ&\u0010\u0080\u0001\u001a\u00020\u00192\u0006\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00028\u00002\u0006\u0010V\u001a\u00020WH\u0016¢\u0006\u0002\u0010dJ\t\u0010\u0081\u0001\u001a\u00020SH\u0002J\u000f\u0010\u0082\u0001\u001a\u00020S2\u0006\u0010\u0018\u001a\u00020\u0019J\u0011\u0010\u0083\u0001\u001a\u00020S2\u0006\u00106\u001a\u00020\fH\u0016J\u0011\u0010\u0084\u0001\u001a\u00020S2\u0006\u0010;\u001a\u00020\fH\u0016J\u000f\u0010\u0085\u0001\u001a\u00020S2\u0006\u0010;\u001a\u00020\fJ\u0018\u0010\u0086\u0001\u001a\u00020\u00192\u0006\u0010c\u001a\u00020\u00022\u0007\u0010\u0087\u0001\u001a\u00020'J\u0017\u0010\u0088\u0001\u001a\u00020S2\u0006\u0010c\u001a\u00020\u00022\u0006\u0010;\u001a\u00020\fJ\u0012\u0010\u0089\u0001\u001a\u00020S2\u0007\u0010\u008a\u0001\u001a\u00020\u0019H\u0002R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000eR\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\u001a\u0010\u001d\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000e\"\u0004\b\u001f\u0010\u0010R\u000e\u0010 \u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010)\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u0010/\u001a\f\u0012\u0006\u0012\u0004\u0018\u000100\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010,\"\u0004\b2\u0010.R\u001a\u00103\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u000e\"\u0004\b5\u0010\u0010R\u000e\u00106\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00108\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u000e\"\u0004\b:\u0010\u0010R\u000e\u0010;\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010<\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001a\u0010A\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010>\"\u0004\bC\u0010@R\u0010\u0010D\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010F\u001a\u0004\u0018\u00010GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\"\u0010L\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010,\"\u0004\bN\u0010.R\u0014\u0010O\u001a\u00020'8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bP\u0010Q¨\u0006\u008c\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/pannel/BottomSheetBehavior;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroid/view/View;", "Lcom/bytedance/android/livesdk/pannel/SheetBaseBehavior;", "view", "(Landroid/view/View;)V", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "activePointerId", "", "getActivePointerId", "()I", "setActivePointerId", "(I)V", "collapsedOffset", "getCollapsedOffset", "setCollapsedOffset", "dragCallback", "Landroidx/customview/widget/ViewDragHelper$Callback;", "expandedOffset", "getExpandedOffset", "fitToContents", "", "fitToContentsOffset", "getFitToContentsOffset", "setFitToContentsOffset", "halfExpandedOffset", "getHalfExpandedOffset", "setHalfExpandedOffset", "ignoreEvents", "importantForAccessibilityMap", "", "initialY", "lastNestedScrollDy", "lastPeekHeight", "maximumVelocity", "", "nestedScrolled", "nestedScrollingChildRef", "Ljava/lang/ref/WeakReference;", "getNestedScrollingChildRef", "()Ljava/lang/ref/WeakReference;", "setNestedScrollingChildRef", "(Ljava/lang/ref/WeakReference;)V", "nestedScrollingParentRef", "Landroid/view/ViewParent;", "getNestedScrollingParentRef", "setNestedScrollingParentRef", "parentHeight", "getParentHeight", "setParentHeight", "peekHeight", "peekHeightAuto", "peekHeightMin", "getPeekHeightMin", "setPeekHeightMin", StrategyConstants.STATE, "touchingScrollingChild", "getTouchingScrollingChild", "()Z", "setTouchingScrollingChild", "(Z)V", "touchingScrollingParent", "getTouchingScrollingParent", "setTouchingScrollingParent", "velocityTracker", "Landroid/view/VelocityTracker;", "viewDragHelper", "Landroidx/customview/widget/ViewDragHelper;", "getViewDragHelper", "()Landroid/support/v4/widget/ViewDragHelper;", "setViewDragHelper", "(Landroid/support/v4/widget/ViewDragHelper;)V", "viewRef", "getViewRef", "setViewRef", "yVelocity", "getYVelocity", "()F", "calculateCollapsedOffset", "", "disableNestedChildScroll", "disablePullDown", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "disablePullUp", "dispatchOnSlide", "top", "findNestedScrollParent", "thisView", "getPeekHeight", "getState", "isFitToContents", "onInterceptTouchEvent", "parent", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "child", "(Landroid/support/design/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/MotionEvent;)Z", "onLayoutChild", "layoutDirection", "(Landroid/support/design/widget/CoordinatorLayout;Landroid/view/View;I)Z", "onNestedPreFling", "coordinatorLayout", "target", "velocityX", "velocityY", "(Landroid/support/design/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/View;FF)Z", "onNestedPreScroll", "dx", "dy", "consumed", "", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "(Landroid/support/design/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/View;II[II)V", "onRestoreInstanceState", "Landroid/os/Parcelable;", "(Landroid/support/design/widget/CoordinatorLayout;Landroid/view/View;Landroid/os/Parcelable;)V", "onSaveInstanceState", "(Landroid/support/design/widget/CoordinatorLayout;Landroid/view/View;)Landroid/os/Parcelable;", "onStartNestedScroll", "directTargetChild", "axes", "(Landroid/support/design/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/View;Landroid/view/View;II)Z", "onStopNestedScroll", "(Landroid/support/design/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/View;I)V", "onTouchEvent", "reset", "setFitToContents", "setPeekHeight", "setState", "setStateInternal", "shouldHide", "yvel", "startSettlingAnimation", "updateImportantForAccessibility", "expanded", "SettleRunnable", "panel_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class BottomSheetBehavior<V extends View> extends SheetBaseBehavior<V> {
    private int activePointerId;
    private int collapsedOffset;
    private final ViewDragHelper.Callback dragCallback;
    private boolean fitToContents;
    private int fitToContentsOffset;
    private int halfExpandedOffset;
    private boolean ignoreEvents;
    private Map<View, Integer> importantForAccessibilityMap;
    private int initialY;
    private int lastNestedScrollDy;
    private int lastPeekHeight;
    private float maximumVelocity;
    private boolean nestedScrolled;
    private WeakReference<View> nestedScrollingChildRef;
    private WeakReference<ViewParent> nestedScrollingParentRef;
    private int parentHeight;
    private int peekHeight;
    private boolean peekHeightAuto;
    private int peekHeightMin;
    private int state;
    private boolean touchingScrollingChild;
    private boolean touchingScrollingParent;
    private VelocityTracker velocityTracker;
    private ViewDragHelper viewDragHelper;
    private WeakReference<V> viewRef;

    public final int getPeekHeightMin() {
        return this.peekHeightMin;
    }

    public final void setPeekHeightMin(int i) {
        this.peekHeightMin = i;
    }

    public final int getFitToContentsOffset() {
        return this.fitToContentsOffset;
    }

    public final void setFitToContentsOffset(int i) {
        this.fitToContentsOffset = i;
    }

    public final int getHalfExpandedOffset() {
        return this.halfExpandedOffset;
    }

    public final void setHalfExpandedOffset(int i) {
        this.halfExpandedOffset = i;
    }

    public final int getCollapsedOffset() {
        return this.collapsedOffset;
    }

    public final void setCollapsedOffset(int i) {
        this.collapsedOffset = i;
    }

    public final ViewDragHelper getViewDragHelper() {
        return this.viewDragHelper;
    }

    public final void setViewDragHelper(ViewDragHelper viewDragHelper) {
        this.viewDragHelper = viewDragHelper;
    }

    public final int getParentHeight() {
        return this.parentHeight;
    }

    public final void setParentHeight(int i) {
        this.parentHeight = i;
    }

    public final WeakReference<V> getViewRef() {
        return this.viewRef;
    }

    public final void setViewRef(WeakReference<V> weakReference) {
        this.viewRef = weakReference;
    }

    public final WeakReference<View> getNestedScrollingChildRef() {
        return this.nestedScrollingChildRef;
    }

    public final void setNestedScrollingChildRef(WeakReference<View> weakReference) {
        this.nestedScrollingChildRef = weakReference;
    }

    public final WeakReference<ViewParent> getNestedScrollingParentRef() {
        return this.nestedScrollingParentRef;
    }

    public final void setNestedScrollingParentRef(WeakReference<ViewParent> weakReference) {
        this.nestedScrollingParentRef = weakReference;
    }

    public final int getActivePointerId() {
        return this.activePointerId;
    }

    public final void setActivePointerId(int i) {
        this.activePointerId = i;
    }

    public final boolean getTouchingScrollingChild() {
        return this.touchingScrollingChild;
    }

    public final void setTouchingScrollingChild(boolean z) {
        this.touchingScrollingChild = z;
    }

    public final boolean getTouchingScrollingParent() {
        return this.touchingScrollingParent;
    }

    public final void setTouchingScrollingParent(boolean z) {
        this.touchingScrollingParent = z;
    }

    private final ViewParent findNestedScrollParent(View thisView) {
        View view = thisView;
        for (ViewParent parent = thisView != null ? thisView.getParent() : null; parent != null; parent = parent.getParent()) {
            if (ViewParentCompat.onStartNestedScroll(parent, view, thisView, 2)) {
                return parent;
            }
            if (parent instanceof View) {
                view = parent;
            }
        }
        return null;
    }

    public BottomSheetBehavior(V v) {
        this.fitToContents = true;
        this.state = 4;
        this.dragCallback = new ViewDragHelper.Callback() { // from class: com.bytedance.android.livesdk.pannel.BottomSheetBehavior$dragCallback$1
            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public boolean tryCaptureView(View child, int pointerId) {
                int i;
                boolean disableNestedChildScroll;
                int i2;
                boolean disableNestedChildScroll2;
                boolean z;
                Intrinsics.checkParameterIsNotNull(child, "child");
                i = BottomSheetBehavior.this.state;
                if (i == 1) {
                    return false;
                }
                if (BottomSheetBehavior.this.getTouchingScrollingChild() || BottomSheetBehavior.this.getTouchingScrollingParent()) {
                    disableNestedChildScroll = BottomSheetBehavior.this.disableNestedChildScroll();
                    if (!disableNestedChildScroll) {
                        return false;
                    }
                }
                i2 = BottomSheetBehavior.this.state;
                if (i2 == 3 && BottomSheetBehavior.this.getActivePointerId() == pointerId) {
                    WeakReference<View> nestedScrollingChildRef = BottomSheetBehavior.this.getNestedScrollingChildRef();
                    if (nestedScrollingChildRef == null) {
                        Intrinsics.throwNpe();
                    }
                    View view = nestedScrollingChildRef.get();
                    disableNestedChildScroll2 = BottomSheetBehavior.this.disableNestedChildScroll();
                    if (disableNestedChildScroll2) {
                        WeakReference<ViewParent> nestedScrollingParentRef = BottomSheetBehavior.this.getNestedScrollingParentRef();
                        if (nestedScrollingParentRef == null) {
                            Intrinsics.throwNpe();
                        }
                        ViewParent viewParent = nestedScrollingParentRef.get();
                        if (viewParent != null && (viewParent instanceof ViewGroup)) {
                            z = ((ViewGroup) viewParent).canScrollVertically(-1);
                            if (view != null && (view.canScrollVertically(-1) || z)) {
                                return false;
                            }
                        }
                    }
                    z = false;
                    if (view != null) {
                        return false;
                    }
                }
                if (BottomSheetBehavior.this.getViewRef() == null) {
                    return false;
                }
                WeakReference viewRef = BottomSheetBehavior.this.getViewRef();
                return (viewRef != null ? (View) viewRef.get() : null) == child;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewPositionChanged(View changedView, int left, int top, int dx, int dy) {
                Intrinsics.checkParameterIsNotNull(changedView, "changedView");
                BottomSheetBehavior.this.dispatchOnSlide(top);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewDragStateChanged(int state) {
                if (state == 1) {
                    BottomSheetBehavior.this.setStateInternal(1);
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewReleased(View releasedChild, float xvel, float yvel) {
                boolean z;
                byte b;
                int collapsedOffset;
                byte b2;
                boolean z2;
                boolean z3;
                Intrinsics.checkParameterIsNotNull(releasedChild, "releasedChild");
                if (!BottomSheetBehavior.this.getSkipCollapsed()) {
                    if (yvel < 0.0f) {
                        z2 = BottomSheetBehavior.this.fitToContents;
                        if (z2) {
                            collapsedOffset = BottomSheetBehavior.this.getFitToContentsOffset();
                            b2 = (byte) 3;
                        } else {
                            if (releasedChild.getTop() > BottomSheetBehavior.this.getHalfExpandedOffset()) {
                                r1 = BottomSheetBehavior.this.getHalfExpandedOffset();
                                b = (byte) 6;
                            } else {
                                b = (byte) 3;
                            }
                            b2 = b;
                        }
                    } else if (BottomSheetBehavior.this.getIsHideAble() && BottomSheetBehavior.this.shouldHide(releasedChild, yvel) && (releasedChild.getTop() > BottomSheetBehavior.this.getCollapsedOffset() || Math.abs(xvel) < Math.abs(yvel))) {
                        collapsedOffset = BottomSheetBehavior.this.getParentHeight();
                        b2 = (byte) 5;
                    } else if (yvel != 0.0f && Math.abs(xvel) <= Math.abs(yvel)) {
                        collapsedOffset = BottomSheetBehavior.this.getCollapsedOffset();
                        b2 = (byte) 4;
                    } else {
                        int top = releasedChild.getTop();
                        z = BottomSheetBehavior.this.fitToContents;
                        if (z) {
                            if (Math.abs(top - BottomSheetBehavior.this.getFitToContentsOffset()) < Math.abs(top - BottomSheetBehavior.this.getCollapsedOffset())) {
                                r1 = BottomSheetBehavior.this.getFitToContentsOffset();
                                b = (byte) 3;
                            } else {
                                r1 = BottomSheetBehavior.this.getCollapsedOffset();
                                b = (byte) 4;
                            }
                        } else {
                            if (top < BottomSheetBehavior.this.getHalfExpandedOffset()) {
                                if (top >= Math.abs(top - BottomSheetBehavior.this.getCollapsedOffset())) {
                                    r1 = BottomSheetBehavior.this.getHalfExpandedOffset();
                                }
                                b = (byte) 3;
                            } else if (Math.abs(top - BottomSheetBehavior.this.getHalfExpandedOffset()) < Math.abs(top - BottomSheetBehavior.this.getCollapsedOffset())) {
                                r1 = BottomSheetBehavior.this.getHalfExpandedOffset();
                            } else {
                                r1 = BottomSheetBehavior.this.getCollapsedOffset();
                                b = (byte) 4;
                            }
                            b = (byte) 6;
                        }
                        b2 = b;
                    }
                    collapsedOffset = r1;
                } else if (!BottomSheetBehavior.this.shouldHide(releasedChild, yvel)) {
                    z3 = BottomSheetBehavior.this.fitToContents;
                    r1 = z3 ? BottomSheetBehavior.this.getFitToContentsOffset() : 0;
                    b2 = (byte) 3;
                    collapsedOffset = r1;
                } else {
                    collapsedOffset = BottomSheetBehavior.this.getParentHeight();
                    b2 = (byte) 5;
                }
                if (b2 == 5) {
                    BottomSheetBehavior.this.setStateInternal(b2);
                    return;
                }
                ViewDragHelper viewDragHelper = BottomSheetBehavior.this.getViewDragHelper();
                if (viewDragHelper != null && viewDragHelper.settleCapturedViewAt(releasedChild.getLeft(), collapsedOffset)) {
                    BottomSheetBehavior.this.setStateInternal(2);
                    ViewCompat.postOnAnimation(releasedChild, new BottomSheetBehavior.SettleRunnable(BottomSheetBehavior.this, releasedChild, b2));
                } else {
                    BottomSheetBehavior.this.setStateInternal(b2);
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionVertical(View child, int top, int dy) {
                int expandedOffset;
                Intrinsics.checkParameterIsNotNull(child, "child");
                expandedOffset = BottomSheetBehavior.this.getExpandedOffset();
                return MathUtils.clamp(top, expandedOffset, BottomSheetBehavior.this.getIsHideAble() ? BottomSheetBehavior.this.getParentHeight() : BottomSheetBehavior.this.getCollapsedOffset());
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionHorizontal(View child, int left, int dx) {
                Intrinsics.checkParameterIsNotNull(child, "child");
                return child.getLeft();
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int getViewVerticalDragRange(View child) {
                Intrinsics.checkParameterIsNotNull(child, "child");
                return BottomSheetBehavior.this.getIsHideAble() ? BottomSheetBehavior.this.getParentHeight() : BottomSheetBehavior.this.getCollapsedOffset();
            }
        };
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.fitToContents = true;
        this.state = 4;
        this.dragCallback = new ViewDragHelper.Callback() { // from class: com.bytedance.android.livesdk.pannel.BottomSheetBehavior$dragCallback$1
            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public boolean tryCaptureView(View child, int pointerId) {
                int i;
                boolean disableNestedChildScroll;
                int i2;
                boolean disableNestedChildScroll2;
                boolean z;
                Intrinsics.checkParameterIsNotNull(child, "child");
                i = BottomSheetBehavior.this.state;
                if (i == 1) {
                    return false;
                }
                if (BottomSheetBehavior.this.getTouchingScrollingChild() || BottomSheetBehavior.this.getTouchingScrollingParent()) {
                    disableNestedChildScroll = BottomSheetBehavior.this.disableNestedChildScroll();
                    if (!disableNestedChildScroll) {
                        return false;
                    }
                }
                i2 = BottomSheetBehavior.this.state;
                if (i2 == 3 && BottomSheetBehavior.this.getActivePointerId() == pointerId) {
                    WeakReference<View> nestedScrollingChildRef = BottomSheetBehavior.this.getNestedScrollingChildRef();
                    if (nestedScrollingChildRef == null) {
                        Intrinsics.throwNpe();
                    }
                    View view = nestedScrollingChildRef.get();
                    disableNestedChildScroll2 = BottomSheetBehavior.this.disableNestedChildScroll();
                    if (disableNestedChildScroll2) {
                        WeakReference<ViewParent> nestedScrollingParentRef = BottomSheetBehavior.this.getNestedScrollingParentRef();
                        if (nestedScrollingParentRef == null) {
                            Intrinsics.throwNpe();
                        }
                        ViewParent viewParent = nestedScrollingParentRef.get();
                        if (viewParent != null && (viewParent instanceof ViewGroup)) {
                            z = ((ViewGroup) viewParent).canScrollVertically(-1);
                            if (view != null && (view.canScrollVertically(-1) || z)) {
                                return false;
                            }
                        }
                    }
                    z = false;
                    if (view != null) {
                        return false;
                    }
                }
                if (BottomSheetBehavior.this.getViewRef() == null) {
                    return false;
                }
                WeakReference viewRef = BottomSheetBehavior.this.getViewRef();
                return (viewRef != null ? (View) viewRef.get() : null) == child;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewPositionChanged(View changedView, int left, int top, int dx, int dy) {
                Intrinsics.checkParameterIsNotNull(changedView, "changedView");
                BottomSheetBehavior.this.dispatchOnSlide(top);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewDragStateChanged(int state) {
                if (state == 1) {
                    BottomSheetBehavior.this.setStateInternal(1);
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewReleased(View releasedChild, float xvel, float yvel) {
                boolean z;
                byte b;
                int collapsedOffset;
                byte b2;
                boolean z2;
                boolean z3;
                Intrinsics.checkParameterIsNotNull(releasedChild, "releasedChild");
                if (!BottomSheetBehavior.this.getSkipCollapsed()) {
                    if (yvel < 0.0f) {
                        z2 = BottomSheetBehavior.this.fitToContents;
                        if (z2) {
                            collapsedOffset = BottomSheetBehavior.this.getFitToContentsOffset();
                            b2 = (byte) 3;
                        } else {
                            if (releasedChild.getTop() > BottomSheetBehavior.this.getHalfExpandedOffset()) {
                                r1 = BottomSheetBehavior.this.getHalfExpandedOffset();
                                b = (byte) 6;
                            } else {
                                b = (byte) 3;
                            }
                            b2 = b;
                        }
                    } else if (BottomSheetBehavior.this.getIsHideAble() && BottomSheetBehavior.this.shouldHide(releasedChild, yvel) && (releasedChild.getTop() > BottomSheetBehavior.this.getCollapsedOffset() || Math.abs(xvel) < Math.abs(yvel))) {
                        collapsedOffset = BottomSheetBehavior.this.getParentHeight();
                        b2 = (byte) 5;
                    } else if (yvel != 0.0f && Math.abs(xvel) <= Math.abs(yvel)) {
                        collapsedOffset = BottomSheetBehavior.this.getCollapsedOffset();
                        b2 = (byte) 4;
                    } else {
                        int top = releasedChild.getTop();
                        z = BottomSheetBehavior.this.fitToContents;
                        if (z) {
                            if (Math.abs(top - BottomSheetBehavior.this.getFitToContentsOffset()) < Math.abs(top - BottomSheetBehavior.this.getCollapsedOffset())) {
                                r1 = BottomSheetBehavior.this.getFitToContentsOffset();
                                b = (byte) 3;
                            } else {
                                r1 = BottomSheetBehavior.this.getCollapsedOffset();
                                b = (byte) 4;
                            }
                        } else {
                            if (top < BottomSheetBehavior.this.getHalfExpandedOffset()) {
                                if (top >= Math.abs(top - BottomSheetBehavior.this.getCollapsedOffset())) {
                                    r1 = BottomSheetBehavior.this.getHalfExpandedOffset();
                                }
                                b = (byte) 3;
                            } else if (Math.abs(top - BottomSheetBehavior.this.getHalfExpandedOffset()) < Math.abs(top - BottomSheetBehavior.this.getCollapsedOffset())) {
                                r1 = BottomSheetBehavior.this.getHalfExpandedOffset();
                            } else {
                                r1 = BottomSheetBehavior.this.getCollapsedOffset();
                                b = (byte) 4;
                            }
                            b = (byte) 6;
                        }
                        b2 = b;
                    }
                    collapsedOffset = r1;
                } else if (!BottomSheetBehavior.this.shouldHide(releasedChild, yvel)) {
                    z3 = BottomSheetBehavior.this.fitToContents;
                    r1 = z3 ? BottomSheetBehavior.this.getFitToContentsOffset() : 0;
                    b2 = (byte) 3;
                    collapsedOffset = r1;
                } else {
                    collapsedOffset = BottomSheetBehavior.this.getParentHeight();
                    b2 = (byte) 5;
                }
                if (b2 == 5) {
                    BottomSheetBehavior.this.setStateInternal(b2);
                    return;
                }
                ViewDragHelper viewDragHelper = BottomSheetBehavior.this.getViewDragHelper();
                if (viewDragHelper != null && viewDragHelper.settleCapturedViewAt(releasedChild.getLeft(), collapsedOffset)) {
                    BottomSheetBehavior.this.setStateInternal(2);
                    ViewCompat.postOnAnimation(releasedChild, new BottomSheetBehavior.SettleRunnable(BottomSheetBehavior.this, releasedChild, b2));
                } else {
                    BottomSheetBehavior.this.setStateInternal(b2);
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionVertical(View child, int top, int dy) {
                int expandedOffset;
                Intrinsics.checkParameterIsNotNull(child, "child");
                expandedOffset = BottomSheetBehavior.this.getExpandedOffset();
                return MathUtils.clamp(top, expandedOffset, BottomSheetBehavior.this.getIsHideAble() ? BottomSheetBehavior.this.getParentHeight() : BottomSheetBehavior.this.getCollapsedOffset());
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionHorizontal(View child, int left, int dx) {
                Intrinsics.checkParameterIsNotNull(child, "child");
                return child.getLeft();
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int getViewVerticalDragRange(View child) {
                Intrinsics.checkParameterIsNotNull(child, "child");
                return BottomSheetBehavior.this.getIsHideAble() ? BottomSheetBehavior.this.getParentHeight() : BottomSheetBehavior.this.getCollapsedOffset();
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0890R.styleable.BottomSheetBehavior_Layout);
        TypedValue peekValue = obtainStyledAttributes.peekValue(C0890R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (peekValue != null && peekValue.data == -1) {
            setPeekHeight(peekValue.data);
        } else {
            setPeekHeight(obtainStyledAttributes.getDimensionPixelSize(C0890R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        }
        setHideAble(obtainStyledAttributes.getBoolean(C0890R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        setFitToContents(true);
        setSkipCollapsed(obtainStyledAttributes.getBoolean(C0890R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        obtainStyledAttributes.recycle();
        Intrinsics.checkExpressionValueIsNotNull(ViewConfiguration.get(context), "configuration");
        this.maximumVelocity = r5.getScaledMaximumFlingVelocity();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v) {
        Intrinsics.checkParameterIsNotNull(coordinatorLayout, "parent");
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, v), this.state);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        Intrinsics.checkParameterIsNotNull(coordinatorLayout, "parent");
        Intrinsics.checkParameterIsNotNull(parcelable, StrategyConstants.STATE);
        SavedState savedState = (SavedState) parcelable;
        if (savedState.getSuperState() != null) {
            Parcelable superState = savedState.getSuperState();
            if (superState == null) {
                Intrinsics.throwNpe();
            }
            super.onRestoreInstanceState(coordinatorLayout, v, superState);
        }
        if (savedState.state != 1 && savedState.state != 2) {
            this.state = savedState.state;
        } else {
            this.state = 4;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int i) {
        Intrinsics.checkParameterIsNotNull(coordinatorLayout, "parent");
        if (ViewCompat.getFitsSystemWindows(coordinatorLayout)) {
            if (v == null) {
                Intrinsics.throwNpe();
            }
            if (!ViewCompat.getFitsSystemWindows(v)) {
                v.setFitsSystemWindows(true);
            }
        }
        if (v == null) {
            Intrinsics.throwNpe();
        }
        int top = v.getTop();
        try {
            try {
                coordinatorLayout.onLayoutChild(v, i);
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            View findViewById = coordinatorLayout.findViewById(C0890R.id.ttlive_design_bottom_sheet);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "parent.findViewById(R.id…live_design_bottom_sheet)");
            ViewGroup viewGroup = (ViewGroup) findViewById;
            if (viewGroup != null) {
                findFirstId(viewGroup);
            }
        }
        this.parentHeight = coordinatorLayout.getHeight();
        if (this.peekHeightAuto) {
            if (this.peekHeightMin == 0) {
                this.peekHeightMin = coordinatorLayout.getResources().getDimensionPixelSize(C0890R.dimen.design_bottom_sheet_peek_height_min);
            }
            this.lastPeekHeight = Math.max(this.peekHeightMin, this.parentHeight - ((coordinatorLayout.getWidth() * 9) / 16));
        } else {
            this.lastPeekHeight = this.peekHeight;
        }
        this.fitToContentsOffset = Math.max(0, this.parentHeight - v.getHeight());
        this.halfExpandedOffset = this.parentHeight / 2;
        calculateCollapsedOffset();
        int i2 = this.state;
        if (i2 == 3) {
            ViewCompat.offsetTopAndBottom(v, getExpandedOffset());
        } else if (i2 == 6) {
            ViewCompat.offsetTopAndBottom(v, this.halfExpandedOffset);
        } else if (getIsHideAble() && this.state == 5) {
            ViewCompat.offsetTopAndBottom(v, this.parentHeight);
        } else {
            int i3 = this.state;
            if (i3 == 4) {
                ViewCompat.offsetTopAndBottom(v, this.collapsedOffset);
            } else if (i3 == 1 || i3 == 2) {
                ViewCompat.offsetTopAndBottom(v, top - v.getTop());
            }
        }
        if (this.viewDragHelper == null) {
            this.viewDragHelper = ViewDragHelper.create(coordinatorLayout, this.dragCallback);
        }
        this.viewRef = new WeakReference<>(v);
        this.nestedScrollingChildRef = new WeakReference<>(findScrollingChild(v));
        if (disableNestedChildScroll()) {
            WeakReference<View> weakReference = this.nestedScrollingChildRef;
            if (weakReference == null) {
                Intrinsics.throwNpe();
            }
            this.nestedScrollingParentRef = new WeakReference<>(findNestedScrollParent(weakReference.get()));
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0054, code lost:
    
        if (r0 != 3) goto L71;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v11, types: [java.lang.Object] */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        View view;
        Object obj;
        View view2;
        ViewDragHelper viewDragHelper;
        Intrinsics.checkParameterIsNotNull(coordinatorLayout, "parent");
        Intrinsics.checkParameterIsNotNull(motionEvent, NotificationCompat.CATEGORY_EVENT);
        if (v == null) {
            Intrinsics.throwNpe();
        }
        if (!v.isShown() || ((disablePullDown(motionEvent) && disablePullUp()) || this.pullUpProcessor.inIgnoreArea(motionEvent))) {
            this.ignoreEvents = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            reset();
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker == null) {
            Intrinsics.throwNpe();
        }
        velocityTracker.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x = (int) motionEvent.getX();
            this.initialY = (int) motionEvent.getY();
            WeakReference<View> weakReference = this.nestedScrollingChildRef;
            if (weakReference != null) {
                if (weakReference == null) {
                    Intrinsics.throwNpe();
                }
                view = weakReference.get();
            } else {
                view = null;
            }
            if (view != null && coordinatorLayout.isPointInChildBounds(view, x, this.initialY)) {
                this.activePointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                this.touchingScrollingChild = true;
            }
            WeakReference<ViewParent> weakReference2 = this.nestedScrollingParentRef;
            if (weakReference2 != null) {
                if (weakReference2 == null) {
                    Intrinsics.throwNpe();
                }
                obj = (ViewParent) weakReference2.get();
            } else {
                obj = null;
            }
            if (obj != null && coordinatorLayout.isPointInChildBounds((View) obj, x, this.initialY)) {
                this.activePointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                this.touchingScrollingParent = true;
            }
            this.ignoreEvents = this.activePointerId == -1 && !coordinatorLayout.isPointInChildBounds(v, x, this.initialY);
        } else {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (this.pullUpProcessor.enablePullUp() && this.pullUpProcessor.isWebViewReachTop()) {
                        this.ignoreEvents = false;
                    }
                }
            }
            this.touchingScrollingChild = false;
            this.touchingScrollingParent = false;
            this.activePointerId = -1;
            if (this.ignoreEvents) {
                this.ignoreEvents = false;
                return false;
            }
            if (this.pullUpProcessor.enablePullUp() && this.pullUpProcessor.isWebViewReachTop()) {
                this.ignoreEvents = false;
            }
        }
        if (this.ignoreEvents || (viewDragHelper = this.viewDragHelper) == null || viewDragHelper == null || !viewDragHelper.shouldInterceptTouchEvent(motionEvent)) {
            if (!disableNestedChildScroll()) {
                WeakReference<View> weakReference3 = this.nestedScrollingChildRef;
                if (weakReference3 != null) {
                    if (weakReference3 == null) {
                        Intrinsics.throwNpe();
                    }
                    r5 = weakReference3.get();
                }
                if (actionMasked != 2 || r5 == null || this.ignoreEvents || this.state == 1 || coordinatorLayout.isPointInChildBounds(r5, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.viewDragHelper == null) {
                    return false;
                }
                float abs = Math.abs(this.initialY - motionEvent.getY());
                if (this.viewDragHelper == null) {
                    Intrinsics.throwNpe();
                }
                if (abs <= r11.getTouchSlop()) {
                    return false;
                }
            } else {
                WeakReference<View> weakReference4 = this.nestedScrollingChildRef;
                if (weakReference4 != null) {
                    if (weakReference4 == null) {
                        Intrinsics.throwNpe();
                    }
                    view2 = weakReference4.get();
                } else {
                    view2 = null;
                }
                WeakReference<ViewParent> weakReference5 = this.nestedScrollingParentRef;
                if (weakReference5 != null) {
                    if (weakReference5 == null) {
                        Intrinsics.throwNpe();
                    }
                    ?? r3 = weakReference5.get();
                    r5 = (ViewGroup) (r3 instanceof ViewGroup ? r3 : null);
                }
                if (actionMasked != 2 || this.ignoreEvents) {
                    return false;
                }
                float abs2 = Math.abs(this.initialY - motionEvent.getY());
                ViewDragHelper viewDragHelper2 = this.viewDragHelper;
                if (viewDragHelper2 == null) {
                    Intrinsics.throwNpe();
                }
                return (abs2 <= ((float) viewDragHelper2.getTouchSlop()) || this.state == 1 || this.viewDragHelper == null || view2 == null || coordinatorLayout.isPointInChildBounds(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || r5 == null || coordinatorLayout.isPointInChildBounds(r5, (int) motionEvent.getX(), (int) motionEvent.getY())) ? false : true;
            }
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        Intrinsics.checkParameterIsNotNull(coordinatorLayout, "parent");
        Intrinsics.checkParameterIsNotNull(motionEvent, NotificationCompat.CATEGORY_EVENT);
        if (v == null) {
            Intrinsics.throwNpe();
        }
        if (!v.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.state != 1 || actionMasked != 0) {
            ViewDragHelper viewDragHelper = this.viewDragHelper;
            if (viewDragHelper != null) {
                viewDragHelper.processTouchEvent(motionEvent);
            }
            if (actionMasked == 0) {
                reset();
            }
            if (this.velocityTracker == null) {
                this.velocityTracker = VelocityTracker.obtain();
            }
            VelocityTracker velocityTracker = this.velocityTracker;
            if (velocityTracker == null) {
                Intrinsics.throwNpe();
            }
            velocityTracker.addMovement(motionEvent);
            ViewDragHelper viewDragHelper2 = this.viewDragHelper;
            if (viewDragHelper2 != null && actionMasked == 2 && !this.ignoreEvents && Math.abs(this.initialY - motionEvent.getY()) > viewDragHelper2.getTouchSlop()) {
                viewDragHelper2.captureChildView(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
            if (this.ignoreEvents) {
                return false;
            }
        }
        return true;
    }

    private final boolean disablePullDown(MotionEvent event) {
        if (this.slideProcessor.inIndicatorArea(event)) {
            return false;
        }
        return this.slideProcessor.disableDragDown() || !this.slideProcessor.shouldInterceptSlide((int) event.getY());
    }

    private final boolean disablePullUp() {
        if (this.pullUpProcessor.enablePullUp() && this.pullUpProcessor.isWebViewReachTop()) {
            return ((this.state == 4 && this.pullUpProcessor.enableToFull()) || (this.state == 3 && this.pullUpProcessor.enableToHalf())) ? false : true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean disableNestedChildScroll() {
        return this.pullUpProcessor.enablePullUp() && this.pullUpProcessor.disableNestedChildScroll();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(coordinatorLayout, "coordinatorLayout");
        Intrinsics.checkParameterIsNotNull(view, "directTargetChild");
        Intrinsics.checkParameterIsNotNull(view2, "target");
        this.lastNestedScrollDy = 0;
        this.nestedScrolled = false;
        return (i & 2) != 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr, int i3) {
        Intrinsics.checkParameterIsNotNull(coordinatorLayout, "coordinatorLayout");
        Intrinsics.checkParameterIsNotNull(view, "target");
        Intrinsics.checkParameterIsNotNull(iArr, "consumed");
        if (i3 != 1) {
            WeakReference<View> weakReference = this.nestedScrollingChildRef;
            if (weakReference == null) {
                Intrinsics.throwNpe();
            }
            if (view == weakReference.get()) {
                if (v == null) {
                    Intrinsics.throwNpe();
                }
                int top = v.getTop();
                int i4 = top - i2;
                if (i2 > 0) {
                    if (i4 < getExpandedOffset()) {
                        int expandedOffset = top - getExpandedOffset();
                        iArr[1] = expandedOffset;
                        ViewCompat.offsetTopAndBottom(v, -expandedOffset);
                        setStateInternal(3);
                    } else {
                        iArr[1] = i2;
                        ViewCompat.offsetTopAndBottom(v, -i2);
                        setStateInternal(1);
                    }
                } else if (i2 < 0 && !view.canScrollVertically(-1) && !this.slideProcessor.disableDragDown()) {
                    if (i4 > this.collapsedOffset && !getIsHideAble()) {
                        int i5 = top - this.collapsedOffset;
                        iArr[1] = i5;
                        ViewCompat.offsetTopAndBottom(v, -i5);
                        setStateInternal(4);
                    } else {
                        iArr[1] = i2;
                        ViewCompat.offsetTopAndBottom(v, -i2);
                        setStateInternal(1);
                    }
                }
                dispatchOnSlide(v.getTop());
                this.lastNestedScrollDy = i2;
                this.nestedScrolled = true;
                if (disableNestedChildScroll() && this.state == 3 && i2 < 0 && iArr[1] == 0) {
                    this.nestedScrolled = false;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c8  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
        int i2;
        byte b;
        Intrinsics.checkParameterIsNotNull(coordinatorLayout, "coordinatorLayout");
        Intrinsics.checkParameterIsNotNull(view, "target");
        if (v == null) {
            Intrinsics.throwNpe();
        }
        if (v.getTop() == getExpandedOffset()) {
            if (disableNestedChildScroll()) {
                if (this.nestedScrolled) {
                    setStateInternal(3);
                    return;
                }
                return;
            }
            setStateInternal(3);
            return;
        }
        WeakReference<View> weakReference = this.nestedScrollingChildRef;
        if (weakReference == null) {
            Intrinsics.throwNpe();
        }
        if (view != weakReference.get() || !this.nestedScrolled) {
            return;
        }
        if (this.lastNestedScrollDy > 30) {
            i2 = getExpandedOffset();
        } else {
            if (getIsHideAble() && shouldHide(v, getYVelocity())) {
                i2 = this.parentHeight;
                b = (byte) 5;
            } else if (getSkipCollapsed()) {
                i2 = getExpandedOffset();
            } else {
                if (this.lastNestedScrollDy == 0) {
                    int top = v.getTop();
                    if (this.fitToContents) {
                        if (Math.abs(top - this.fitToContentsOffset) < Math.abs(top - this.collapsedOffset)) {
                            i2 = this.fitToContentsOffset;
                        } else {
                            i2 = this.collapsedOffset;
                        }
                    } else {
                        int i3 = this.halfExpandedOffset;
                        if (top < i3) {
                            if (top < Math.abs(top - this.collapsedOffset)) {
                                b = (byte) 3;
                                i2 = 0;
                            } else {
                                i2 = this.halfExpandedOffset;
                            }
                        } else if (Math.abs(top - i3) < Math.abs(top - this.collapsedOffset)) {
                            i2 = this.halfExpandedOffset;
                        } else {
                            i2 = this.collapsedOffset;
                        }
                        b = (byte) 6;
                    }
                } else {
                    i2 = this.collapsedOffset;
                }
                b = (byte) 4;
            }
            if (b != 5) {
                setStateInternal(b);
                return;
            }
            ViewDragHelper viewDragHelper = this.viewDragHelper;
            if (viewDragHelper != null && viewDragHelper.smoothSlideViewTo(v, v.getLeft(), i2)) {
                setStateInternal(2);
                ViewCompat.postOnAnimation(v, new SettleRunnable(this, v, b));
            } else {
                setStateInternal(b);
            }
            this.nestedScrolled = false;
            return;
        }
        b = (byte) 3;
        if (b != 5) {
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
        Intrinsics.checkParameterIsNotNull(coordinatorLayout, "coordinatorLayout");
        Intrinsics.checkParameterIsNotNull(view, "target");
        WeakReference<View> weakReference = this.nestedScrollingChildRef;
        if (weakReference == null) {
            Intrinsics.throwNpe();
        }
        return view == weakReference.get() && (this.state != 3 || super.onNestedPreFling(coordinatorLayout, v, view, f, f2));
    }

    /* renamed from: isFitToContents, reason: from getter */
    public final boolean getFitToContents() {
        return this.fitToContents;
    }

    public final void setFitToContents(boolean fitToContents) {
        if (this.fitToContents != fitToContents) {
            this.fitToContents = fitToContents;
            if (this.viewRef != null) {
                calculateCollapsedOffset();
            }
            setStateInternal((this.fitToContents && this.state == 6) ? 3 : this.state);
        }
    }

    @Override // com.bytedance.android.livesdk.pannel.SheetBaseBehavior
    public void setPeekHeight(int peekHeight) {
        boolean z = true;
        if (peekHeight == -1) {
            if (!this.peekHeightAuto) {
                this.peekHeightAuto = true;
            }
            z = false;
        } else {
            if (this.peekHeightAuto || this.peekHeight != peekHeight) {
                this.peekHeightAuto = false;
                this.peekHeight = Math.max(0, peekHeight);
                this.collapsedOffset = this.parentHeight - peekHeight;
            }
            z = false;
        }
        if (z && this.state == 4) {
            WeakReference<V> weakReference = this.viewRef;
            V v = weakReference != null ? weakReference.get() : null;
            if (v != null) {
                v.requestLayout();
            }
        }
    }

    public final int getPeekHeight() {
        if (this.peekHeightAuto) {
            return -1;
        }
        return this.peekHeight;
    }

    @Override // com.bytedance.android.livesdk.pannel.SheetBaseBehavior
    public void setState(final int state) {
        if (state != this.state) {
            WeakReference<V> weakReference = this.viewRef;
            if (weakReference == null) {
                if (state == 4 || state == 3 || state == 6 || (getIsHideAble() && state == 5)) {
                    this.state = state;
                    return;
                }
                return;
            }
            final V v = weakReference != null ? weakReference.get() : null;
            if (v != null) {
                ViewParent parent = v.getParent();
                if (parent != null && parent.isLayoutRequested() && ViewCompat.isAttachedToWindow(v)) {
                    v.post(new Runnable() { // from class: com.bytedance.android.livesdk.pannel.BottomSheetBehavior$setState$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            BottomSheetBehavior.this.startSettlingAnimation(v, state);
                        }
                    });
                } else {
                    startSettlingAnimation(v, state);
                }
            }
        }
    }

    public final int getState() {
        return this.state;
    }

    public final void setStateInternal(int state) {
        if (this.state != state) {
            this.state = state;
            if (state == 6 || state == 3) {
                updateImportantForAccessibility(true);
            } else if (state == 5 || state == 4) {
                updateImportantForAccessibility(false);
            }
            WeakReference<V> weakReference = this.viewRef;
            if (weakReference == null) {
                Intrinsics.throwNpe();
            }
            V v = weakReference.get();
            if (v == null || getMCallback() == null) {
                return;
            }
            SheetBaseBehavior.SheetCallback mCallback = getMCallback();
            if (mCallback == null) {
                Intrinsics.throwNpe();
            }
            mCallback.onStateChanged(v, state);
        }
    }

    private final void calculateCollapsedOffset() {
        if (this.fitToContents) {
            this.collapsedOffset = Math.max(this.parentHeight - this.lastPeekHeight, this.fitToContentsOffset);
        } else {
            this.collapsedOffset = this.parentHeight - this.lastPeekHeight;
        }
    }

    private final void reset() {
        this.activePointerId = -1;
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            if (velocityTracker == null) {
                Intrinsics.throwNpe();
            }
            velocityTracker.recycle();
            this.velocityTracker = null;
        }
    }

    public final boolean shouldHide(View child, float yvel) {
        Intrinsics.checkParameterIsNotNull(child, "child");
        if (getSkipCollapsed()) {
            float f = yvel * 0.1f;
            if (f > 500) {
                return true;
            }
            if (f < -30) {
                return false;
            }
            if ((this.parentHeight - (child.getTop() + f)) / child.getHeight() < 0.5f) {
                return true;
            }
        } else if (child.getTop() >= this.collapsedOffset && Math.abs((child.getTop() + (yvel * 0.1f)) - this.collapsedOffset) / this.peekHeight > 0.5f) {
            return true;
        }
        return false;
    }

    private final float getYVelocity() {
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker == null) {
            return 0.0f;
        }
        if (velocityTracker == null) {
            Intrinsics.throwNpe();
        }
        velocityTracker.computeCurrentVelocity(1000, this.maximumVelocity);
        VelocityTracker velocityTracker2 = this.velocityTracker;
        if (velocityTracker2 == null) {
            Intrinsics.throwNpe();
        }
        return velocityTracker2.getYVelocity(this.activePointerId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getExpandedOffset() {
        if (this.fitToContents) {
            return this.fitToContentsOffset;
        }
        return 0;
    }

    public final void startSettlingAnimation(View child, int state) {
        int i;
        int i2;
        Intrinsics.checkParameterIsNotNull(child, "child");
        if (state == 4) {
            i = this.collapsedOffset;
        } else if (state == 6) {
            i = this.halfExpandedOffset;
            if (this.fitToContents && i <= (i2 = this.fitToContentsOffset)) {
                state = 3;
                i = i2;
            }
        } else if (state == 3) {
            i = getExpandedOffset();
        } else {
            if (!(getIsHideAble() && state == 5)) {
                throw new IllegalArgumentException(("Illegal state argument: " + state).toString());
            }
            i = this.parentHeight;
        }
        ViewDragHelper viewDragHelper = this.viewDragHelper;
        if (viewDragHelper != null && viewDragHelper.smoothSlideViewTo(child, child.getLeft(), i)) {
            setStateInternal(2);
            ViewCompat.postOnAnimation(child, new SettleRunnable(this, child, state));
        } else {
            setStateInternal(state);
        }
    }

    public final void dispatchOnSlide(int top) {
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference == null) {
            Intrinsics.throwNpe();
        }
        V v = weakReference.get();
        if (v == null || getMCallback() == null) {
            return;
        }
        if (top > this.collapsedOffset) {
            SheetBaseBehavior.SheetCallback mCallback = getMCallback();
            if (mCallback == null) {
                Intrinsics.throwNpe();
            }
            int i = this.collapsedOffset;
            mCallback.onSlide(v, (i - top) / (this.parentHeight - i));
            return;
        }
        SheetBaseBehavior.SheetCallback mCallback2 = getMCallback();
        if (mCallback2 == null) {
            Intrinsics.throwNpe();
        }
        int i2 = this.collapsedOffset;
        mCallback2.onSlide(v, (i2 - top) / (i2 - getExpandedOffset()));
    }

    private final void updateImportantForAccessibility(boolean expanded) {
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference != null) {
            V v = weakReference != null ? weakReference.get() : null;
            if (v == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.view.View");
            }
            ViewParent parent = v.getParent();
            if (parent instanceof CoordinatorLayout) {
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
                int childCount = coordinatorLayout.getChildCount();
                if (expanded) {
                    if (this.importantForAccessibilityMap != null) {
                        return;
                    } else {
                        this.importantForAccessibilityMap = new HashMap(childCount);
                    }
                }
                for (int i = 0; i < childCount; i++) {
                    View childAt = coordinatorLayout.getChildAt(i);
                    Intrinsics.checkExpressionValueIsNotNull(childAt, "parent.getChildAt(i)");
                    WeakReference<V> weakReference2 = this.viewRef;
                    if (childAt != (weakReference2 != null ? weakReference2.get() : null)) {
                        if (!expanded) {
                            Map<View, Integer> map = this.importantForAccessibilityMap;
                            if (map != null) {
                                if (map == null) {
                                    Intrinsics.throwNpe();
                                }
                                if (map.containsKey(childAt)) {
                                    Map<View, Integer> map2 = this.importantForAccessibilityMap;
                                    if (map2 == null) {
                                        Intrinsics.throwNpe();
                                    }
                                    Integer num = map2.get(childAt);
                                    if (num == null) {
                                        Intrinsics.throwNpe();
                                    }
                                    ViewCompat.setImportantForAccessibility(childAt, num.intValue());
                                }
                            }
                        } else {
                            Map<View, Integer> map3 = this.importantForAccessibilityMap;
                            if (map3 == null) {
                                Intrinsics.throwNpe();
                            }
                            map3.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                            ViewCompat.setImportantForAccessibility(childAt, 4);
                        }
                    }
                }
                if (expanded) {
                    return;
                }
                this.importantForAccessibilityMap = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BottomSheetBehavior.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/pannel/BottomSheetBehavior$SettleRunnable;", "Ljava/lang/Runnable;", "view", "Landroid/view/View;", "targetState", "", "(Lcom/bytedance/android/livesdk/pannel/BottomSheetBehavior;Landroid/view/View;I)V", "run", "", "panel_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public final class SettleRunnable implements Runnable {
        private final int targetState;
        final /* synthetic */ BottomSheetBehavior this$0;
        private final View view;

        public SettleRunnable(BottomSheetBehavior bottomSheetBehavior, View view, int i) {
            Intrinsics.checkParameterIsNotNull(view, "view");
            this.this$0 = bottomSheetBehavior;
            this.view = view;
            this.targetState = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewDragHelper viewDragHelper;
            if (this.this$0.getViewDragHelper() != null && (viewDragHelper = this.this$0.getViewDragHelper()) != null && viewDragHelper.continueSettling(true)) {
                ViewCompat.postOnAnimation(this.view, this);
            } else {
                this.this$0.setStateInternal(this.targetState);
            }
        }
    }
}
