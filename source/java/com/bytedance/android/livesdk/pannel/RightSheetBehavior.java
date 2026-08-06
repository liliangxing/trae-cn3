package com.bytedance.android.livesdk.pannel;

import android.content.Context;
import android.content.res.Resources;
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
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import androidx.exifinterface.media.ExifInterface;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.android.livesdk.pannel.RightSheetBehavior;
import com.bytedance.android.livesdk.pannel.SheetBaseBehavior;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: RightSheetBehavior.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u0000*\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001}B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\b\u0010H\u001a\u00020IH\u0002J\u0010\u0010J\u001a\u00020\u00192\u0006\u0010K\u001a\u00020LH\u0002J\b\u0010M\u001a\u00020\u0019H\u0002J\u000e\u0010N\u001a\u00020I2\u0006\u0010O\u001a\u00020\fJ\u0006\u0010P\u001a\u00020\fJ\u0006\u0010Q\u001a\u00020\u0019J%\u0010R\u001a\u00020\u00192\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00028\u00002\u0006\u0010K\u001a\u00020LH\u0016¢\u0006\u0002\u0010VJ%\u0010W\u001a\u00020\u00192\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00028\u00002\u0006\u0010X\u001a\u00020\fH\u0017¢\u0006\u0002\u0010YJ5\u0010Z\u001a\u00020\u00192\u0006\u0010[\u001a\u00020T2\u0006\u0010U\u001a\u00028\u00002\u0006\u0010\\\u001a\u00020\u00022\u0006\u0010]\u001a\u00020'2\u0006\u0010^\u001a\u00020'H\u0016¢\u0006\u0002\u0010_JE\u0010`\u001a\u00020I2\u0006\u0010[\u001a\u00020T2\u0006\u0010U\u001a\u00028\u00002\u0006\u0010\\\u001a\u00020\u00022\u0006\u0010a\u001a\u00020\f2\u0006\u0010b\u001a\u00020\f2\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020\fH\u0016¢\u0006\u0002\u0010fJ%\u0010g\u001a\u00020I2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00028\u00002\u0006\u00104\u001a\u00020hH\u0016¢\u0006\u0002\u0010iJ\u001f\u0010j\u001a\u0004\u0018\u00010h2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010kJ=\u0010l\u001a\u00020\u00192\u0006\u0010[\u001a\u00020T2\u0006\u0010U\u001a\u00028\u00002\u0006\u0010m\u001a\u00020\u00022\u0006\u0010\\\u001a\u00020\u00022\u0006\u0010n\u001a\u00020\f2\u0006\u0010e\u001a\u00020\fH\u0016¢\u0006\u0002\u0010oJ-\u0010p\u001a\u00020I2\u0006\u0010[\u001a\u00020T2\u0006\u0010U\u001a\u00028\u00002\u0006\u0010\\\u001a\u00020\u00022\u0006\u0010e\u001a\u00020\fH\u0016¢\u0006\u0002\u0010qJ%\u0010r\u001a\u00020\u00192\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00028\u00002\u0006\u0010K\u001a\u00020LH\u0016¢\u0006\u0002\u0010VJ\b\u0010s\u001a\u00020IH\u0002J\u000e\u0010t\u001a\u00020I2\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010u\u001a\u00020I2\u0006\u00102\u001a\u00020\fH\u0016J\u0010\u0010v\u001a\u00020I2\u0006\u00104\u001a\u00020\fH\u0016J\u000e\u0010w\u001a\u00020I2\u0006\u00104\u001a\u00020\fJ\u0016\u0010x\u001a\u00020\u00192\u0006\u0010U\u001a\u00020\u00022\u0006\u0010y\u001a\u00020'J\u0016\u0010z\u001a\u00020I2\u0006\u0010U\u001a\u00020\u00022\u0006\u00104\u001a\u00020\fJ\u0010\u0010{\u001a\u00020I2\u0006\u0010|\u001a\u00020\u0019H\u0002R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000eR\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\u001a\u0010\u001d\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000e\"\u0004\b\u001f\u0010\u0010R\u000e\u0010 \u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010)\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u000e\"\u0004\b1\u0010\u0010R\u000e\u00102\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00105\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010<\u001a\u0004\u0018\u00010=X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010B\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010,\"\u0004\bD\u0010.R\u0014\u0010E\u001a\u00020'8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bF\u0010G¨\u0006~"}, d2 = {"Lcom/bytedance/android/livesdk/pannel/RightSheetBehavior;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroid/view/View;", "Lcom/bytedance/android/livesdk/pannel/SheetBaseBehavior;", "view", "(Landroid/view/View;)V", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "activePointerId", "", "getActivePointerId", "()I", "setActivePointerId", "(I)V", "collapsedOffset", "getCollapsedOffset", "setCollapsedOffset", "dragCallback", "Landroidx/customview/widget/ViewDragHelper$Callback;", "expandedOffset", "getExpandedOffset", "fitToContents", "", "fitToContentsOffset", "getFitToContentsOffset", "setFitToContentsOffset", "halfExpandedOffset", "getHalfExpandedOffset", "setHalfExpandedOffset", "ignoreEvents", "importantForAccessibilityMap", "", "initialX", "lastNestedScrollDy", "lastPeekWidth", "maximumVelocity", "", "nestedScrolled", "nestedScrollingChildRef", "Ljava/lang/ref/WeakReference;", "getNestedScrollingChildRef", "()Ljava/lang/ref/WeakReference;", "setNestedScrollingChildRef", "(Ljava/lang/ref/WeakReference;)V", "parentWidth", "getParentWidth", "setParentWidth", "peekHeight", "peekHeightAuto", StrategyConstants.STATE, "touchingScrollingChild", "getTouchingScrollingChild", "()Z", "setTouchingScrollingChild", "(Z)V", "velocityTracker", "Landroid/view/VelocityTracker;", "viewDragHelper", "Landroidx/customview/widget/ViewDragHelper;", "getViewDragHelper", "()Landroid/support/v4/widget/ViewDragHelper;", "setViewDragHelper", "(Landroid/support/v4/widget/ViewDragHelper;)V", "viewRef", "getViewRef", "setViewRef", "yVelocity", "getYVelocity", "()F", "calculateCollapsedOffset", "", "disablePullDown", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "disablePullUp", "dispatchOnSlide", "left", "getState", "isFitToContents", "onInterceptTouchEvent", "parent", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "child", "(Landroid/support/design/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/MotionEvent;)Z", "onLayoutChild", "layoutDirection", "(Landroid/support/design/widget/CoordinatorLayout;Landroid/view/View;I)Z", "onNestedPreFling", "coordinatorLayout", "target", "velocityX", "velocityY", "(Landroid/support/design/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/View;FF)Z", "onNestedPreScroll", "dx", "dy1", "consumed", "", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "(Landroid/support/design/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/View;II[II)V", "onRestoreInstanceState", "Landroid/os/Parcelable;", "(Landroid/support/design/widget/CoordinatorLayout;Landroid/view/View;Landroid/os/Parcelable;)V", "onSaveInstanceState", "(Landroid/support/design/widget/CoordinatorLayout;Landroid/view/View;)Landroid/os/Parcelable;", "onStartNestedScroll", "directTargetChild", "axes", "(Landroid/support/design/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/View;Landroid/view/View;II)Z", "onStopNestedScroll", "(Landroid/support/design/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/View;I)V", "onTouchEvent", "reset", "setFitToContents", "setPeekHeight", "setState", "setStateInternal", "shouldHide", "xvel", "startSettlingAnimation", "updateImportantForAccessibility", "expanded", "SettleRunnable", "panel_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class RightSheetBehavior<V extends View> extends SheetBaseBehavior<V> {
    private int activePointerId;
    private int collapsedOffset;
    private final ViewDragHelper.Callback dragCallback;
    private boolean fitToContents;
    private int fitToContentsOffset;
    private int halfExpandedOffset;
    private boolean ignoreEvents;
    private Map<View, Integer> importantForAccessibilityMap;
    private int initialX;
    private int lastNestedScrollDy;
    private int lastPeekWidth;
    private float maximumVelocity;
    private boolean nestedScrolled;
    private WeakReference<View> nestedScrollingChildRef;
    private int parentWidth;
    private int peekHeight;
    private boolean peekHeightAuto;
    private int state;
    private boolean touchingScrollingChild;
    private VelocityTracker velocityTracker;
    private ViewDragHelper viewDragHelper;
    private WeakReference<V> viewRef;

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

    public final int getParentWidth() {
        return this.parentWidth;
    }

    public final void setParentWidth(int i) {
        this.parentWidth = i;
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

    public RightSheetBehavior(V v) {
        this.fitToContents = true;
        this.state = 4;
        this.dragCallback = new ViewDragHelper.Callback() { // from class: com.bytedance.android.livesdk.pannel.RightSheetBehavior$dragCallback$1
            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public boolean tryCaptureView(View child, int pointerId) {
                int i;
                int i2;
                Intrinsics.checkParameterIsNotNull(child, "child");
                i = RightSheetBehavior.this.state;
                if (i == 1 || RightSheetBehavior.this.getTouchingScrollingChild()) {
                    return false;
                }
                i2 = RightSheetBehavior.this.state;
                if (i2 == 3 && RightSheetBehavior.this.getActivePointerId() == pointerId) {
                    WeakReference<View> nestedScrollingChildRef = RightSheetBehavior.this.getNestedScrollingChildRef();
                    if (nestedScrollingChildRef == null) {
                        Intrinsics.throwNpe();
                    }
                    View view = nestedScrollingChildRef.get();
                    if (view != null && view.canScrollHorizontally(-1)) {
                        return false;
                    }
                }
                if (RightSheetBehavior.this.getViewRef() == null) {
                    return false;
                }
                WeakReference viewRef = RightSheetBehavior.this.getViewRef();
                return (viewRef != null ? (View) viewRef.get() : null) == child;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewPositionChanged(View changedView, int left, int top, int dx, int dy) {
                Intrinsics.checkParameterIsNotNull(changedView, "changedView");
                RightSheetBehavior.this.dispatchOnSlide(left);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewDragStateChanged(int state) {
                if (state == 1) {
                    RightSheetBehavior.this.setStateInternal(1);
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
                if (!RightSheetBehavior.this.getSkipCollapsed()) {
                    if (xvel < 0.0f) {
                        z2 = RightSheetBehavior.this.fitToContents;
                        if (z2) {
                            collapsedOffset = RightSheetBehavior.this.getFitToContentsOffset();
                            b2 = (byte) 3;
                        } else {
                            if (releasedChild.getTop() > RightSheetBehavior.this.getHalfExpandedOffset()) {
                                r1 = RightSheetBehavior.this.getHalfExpandedOffset();
                                b = (byte) 6;
                            } else {
                                b = (byte) 3;
                            }
                            b2 = b;
                        }
                    } else if (RightSheetBehavior.this.getIsHideAble() && RightSheetBehavior.this.shouldHide(releasedChild, yvel) && (releasedChild.getTop() > RightSheetBehavior.this.getCollapsedOffset() || Math.abs(xvel) < Math.abs(yvel))) {
                        collapsedOffset = RightSheetBehavior.this.getParentWidth();
                        b2 = (byte) 5;
                    } else if (yvel != 0.0f && Math.abs(xvel) <= Math.abs(yvel)) {
                        collapsedOffset = RightSheetBehavior.this.getCollapsedOffset();
                        b2 = (byte) 4;
                    } else {
                        int top = releasedChild.getTop();
                        z = RightSheetBehavior.this.fitToContents;
                        if (z) {
                            if (Math.abs(top - RightSheetBehavior.this.getFitToContentsOffset()) < Math.abs(top - RightSheetBehavior.this.getCollapsedOffset())) {
                                r1 = RightSheetBehavior.this.getFitToContentsOffset();
                                b = (byte) 3;
                            } else {
                                r1 = RightSheetBehavior.this.getCollapsedOffset();
                                b = (byte) 4;
                            }
                        } else {
                            if (top < RightSheetBehavior.this.getHalfExpandedOffset()) {
                                if (top >= Math.abs(top - RightSheetBehavior.this.getCollapsedOffset())) {
                                    r1 = RightSheetBehavior.this.getHalfExpandedOffset();
                                }
                                b = (byte) 3;
                            } else if (Math.abs(top - RightSheetBehavior.this.getHalfExpandedOffset()) < Math.abs(top - RightSheetBehavior.this.getCollapsedOffset())) {
                                r1 = RightSheetBehavior.this.getHalfExpandedOffset();
                            } else {
                                r1 = RightSheetBehavior.this.getCollapsedOffset();
                                b = (byte) 4;
                            }
                            b = (byte) 6;
                        }
                        b2 = b;
                    }
                    collapsedOffset = r1;
                } else if (!RightSheetBehavior.this.shouldHide(releasedChild, xvel)) {
                    z3 = RightSheetBehavior.this.fitToContents;
                    r1 = z3 ? RightSheetBehavior.this.getFitToContentsOffset() : 0;
                    b2 = (byte) 3;
                    collapsedOffset = r1;
                } else {
                    collapsedOffset = RightSheetBehavior.this.getParentWidth();
                    b2 = (byte) 5;
                }
                if (b2 == 5) {
                    RightSheetBehavior.this.setStateInternal(b2);
                    return;
                }
                ViewDragHelper viewDragHelper = RightSheetBehavior.this.getViewDragHelper();
                if (viewDragHelper != null && viewDragHelper.settleCapturedViewAt(collapsedOffset, releasedChild.getTop())) {
                    RightSheetBehavior.this.setStateInternal(2);
                    ViewCompat.postOnAnimation(releasedChild, new RightSheetBehavior.SettleRunnable(RightSheetBehavior.this, releasedChild, b2));
                } else {
                    RightSheetBehavior.this.setStateInternal(b2);
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionVertical(View child, int top, int dy) {
                Intrinsics.checkParameterIsNotNull(child, "child");
                return child.getTop();
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionHorizontal(View child, int left, int dx) {
                Intrinsics.checkParameterIsNotNull(child, "child");
                return RangesKt.coerceAtLeast(RightSheetBehavior.this.getParentWidth() - child.getWidth(), left);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int getViewHorizontalDragRange(View child) {
                Intrinsics.checkParameterIsNotNull(child, "child");
                Context context = child.getContext();
                Intrinsics.checkExpressionValueIsNotNull(context, "child.context");
                Resources resources = context.getResources();
                Intrinsics.checkExpressionValueIsNotNull(resources, "child.context.resources");
                return resources.getDisplayMetrics().widthPixels;
            }
        };
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RightSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.fitToContents = true;
        this.state = 4;
        this.dragCallback = new ViewDragHelper.Callback() { // from class: com.bytedance.android.livesdk.pannel.RightSheetBehavior$dragCallback$1
            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public boolean tryCaptureView(View child, int pointerId) {
                int i;
                int i2;
                Intrinsics.checkParameterIsNotNull(child, "child");
                i = RightSheetBehavior.this.state;
                if (i == 1 || RightSheetBehavior.this.getTouchingScrollingChild()) {
                    return false;
                }
                i2 = RightSheetBehavior.this.state;
                if (i2 == 3 && RightSheetBehavior.this.getActivePointerId() == pointerId) {
                    WeakReference<View> nestedScrollingChildRef = RightSheetBehavior.this.getNestedScrollingChildRef();
                    if (nestedScrollingChildRef == null) {
                        Intrinsics.throwNpe();
                    }
                    View view = nestedScrollingChildRef.get();
                    if (view != null && view.canScrollHorizontally(-1)) {
                        return false;
                    }
                }
                if (RightSheetBehavior.this.getViewRef() == null) {
                    return false;
                }
                WeakReference viewRef = RightSheetBehavior.this.getViewRef();
                return (viewRef != null ? (View) viewRef.get() : null) == child;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewPositionChanged(View changedView, int left, int top, int dx, int dy) {
                Intrinsics.checkParameterIsNotNull(changedView, "changedView");
                RightSheetBehavior.this.dispatchOnSlide(left);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewDragStateChanged(int state) {
                if (state == 1) {
                    RightSheetBehavior.this.setStateInternal(1);
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
                if (!RightSheetBehavior.this.getSkipCollapsed()) {
                    if (xvel < 0.0f) {
                        z2 = RightSheetBehavior.this.fitToContents;
                        if (z2) {
                            collapsedOffset = RightSheetBehavior.this.getFitToContentsOffset();
                            b2 = (byte) 3;
                        } else {
                            if (releasedChild.getTop() > RightSheetBehavior.this.getHalfExpandedOffset()) {
                                r1 = RightSheetBehavior.this.getHalfExpandedOffset();
                                b = (byte) 6;
                            } else {
                                b = (byte) 3;
                            }
                            b2 = b;
                        }
                    } else if (RightSheetBehavior.this.getIsHideAble() && RightSheetBehavior.this.shouldHide(releasedChild, yvel) && (releasedChild.getTop() > RightSheetBehavior.this.getCollapsedOffset() || Math.abs(xvel) < Math.abs(yvel))) {
                        collapsedOffset = RightSheetBehavior.this.getParentWidth();
                        b2 = (byte) 5;
                    } else if (yvel != 0.0f && Math.abs(xvel) <= Math.abs(yvel)) {
                        collapsedOffset = RightSheetBehavior.this.getCollapsedOffset();
                        b2 = (byte) 4;
                    } else {
                        int top = releasedChild.getTop();
                        z = RightSheetBehavior.this.fitToContents;
                        if (z) {
                            if (Math.abs(top - RightSheetBehavior.this.getFitToContentsOffset()) < Math.abs(top - RightSheetBehavior.this.getCollapsedOffset())) {
                                r1 = RightSheetBehavior.this.getFitToContentsOffset();
                                b = (byte) 3;
                            } else {
                                r1 = RightSheetBehavior.this.getCollapsedOffset();
                                b = (byte) 4;
                            }
                        } else {
                            if (top < RightSheetBehavior.this.getHalfExpandedOffset()) {
                                if (top >= Math.abs(top - RightSheetBehavior.this.getCollapsedOffset())) {
                                    r1 = RightSheetBehavior.this.getHalfExpandedOffset();
                                }
                                b = (byte) 3;
                            } else if (Math.abs(top - RightSheetBehavior.this.getHalfExpandedOffset()) < Math.abs(top - RightSheetBehavior.this.getCollapsedOffset())) {
                                r1 = RightSheetBehavior.this.getHalfExpandedOffset();
                            } else {
                                r1 = RightSheetBehavior.this.getCollapsedOffset();
                                b = (byte) 4;
                            }
                            b = (byte) 6;
                        }
                        b2 = b;
                    }
                    collapsedOffset = r1;
                } else if (!RightSheetBehavior.this.shouldHide(releasedChild, xvel)) {
                    z3 = RightSheetBehavior.this.fitToContents;
                    r1 = z3 ? RightSheetBehavior.this.getFitToContentsOffset() : 0;
                    b2 = (byte) 3;
                    collapsedOffset = r1;
                } else {
                    collapsedOffset = RightSheetBehavior.this.getParentWidth();
                    b2 = (byte) 5;
                }
                if (b2 == 5) {
                    RightSheetBehavior.this.setStateInternal(b2);
                    return;
                }
                ViewDragHelper viewDragHelper = RightSheetBehavior.this.getViewDragHelper();
                if (viewDragHelper != null && viewDragHelper.settleCapturedViewAt(collapsedOffset, releasedChild.getTop())) {
                    RightSheetBehavior.this.setStateInternal(2);
                    ViewCompat.postOnAnimation(releasedChild, new RightSheetBehavior.SettleRunnable(RightSheetBehavior.this, releasedChild, b2));
                } else {
                    RightSheetBehavior.this.setStateInternal(b2);
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionVertical(View child, int top, int dy) {
                Intrinsics.checkParameterIsNotNull(child, "child");
                return child.getTop();
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionHorizontal(View child, int left, int dx) {
                Intrinsics.checkParameterIsNotNull(child, "child");
                return RangesKt.coerceAtLeast(RightSheetBehavior.this.getParentWidth() - child.getWidth(), left);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int getViewHorizontalDragRange(View child) {
                Intrinsics.checkParameterIsNotNull(child, "child");
                Context context2 = child.getContext();
                Intrinsics.checkExpressionValueIsNotNull(context2, "child.context");
                Resources resources = context2.getResources();
                Intrinsics.checkExpressionValueIsNotNull(resources, "child.context.resources");
                return resources.getDisplayMetrics().widthPixels;
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
        if (v == null) {
            return false;
        }
        if (ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(v)) {
            v.setFitsSystemWindows(true);
        }
        v.getLeft();
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
        int width = coordinatorLayout.getWidth();
        this.parentWidth = width;
        if (this.peekHeightAuto) {
            this.lastPeekWidth = (width * 9) / 16;
        } else {
            this.lastPeekWidth = this.peekHeight;
        }
        this.fitToContentsOffset = RangesKt.coerceAtLeast(0, width - v.getWidth());
        this.halfExpandedOffset = this.parentWidth / 2;
        calculateCollapsedOffset();
        if (this.viewDragHelper == null) {
            this.viewDragHelper = ViewDragHelper.create(coordinatorLayout, this.dragCallback);
        }
        this.viewRef = new WeakReference<>(v);
        this.nestedScrollingChildRef = new WeakReference<>(findScrollingChild(v));
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x004c, code lost:
    
        if (r0 != 3) goto L59;
     */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        View view;
        ViewDragHelper viewDragHelper;
        Intrinsics.checkParameterIsNotNull(coordinatorLayout, "parent");
        Intrinsics.checkParameterIsNotNull(motionEvent, NotificationCompat.CATEGORY_EVENT);
        if (v == null) {
            Intrinsics.throwNpe();
        }
        if (!v.isShown() || (disablePullDown(motionEvent) && disablePullUp())) {
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
        View view2 = null;
        if (actionMasked == 0) {
            this.initialX = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            WeakReference<View> weakReference = this.nestedScrollingChildRef;
            if (weakReference != null) {
                if (weakReference == null) {
                    Intrinsics.throwNpe();
                }
                view = weakReference.get();
            } else {
                view = null;
            }
            if (view != null && coordinatorLayout.isPointInChildBounds(view, this.initialX, y)) {
                this.activePointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                this.touchingScrollingChild = true;
            }
            this.ignoreEvents = this.activePointerId == -1 && !coordinatorLayout.isPointInChildBounds(v, this.initialX, y);
        } else {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (this.pullUpProcessor.enablePullUp() && this.pullUpProcessor.isWebViewReachTop()) {
                        this.ignoreEvents = false;
                    }
                }
            }
            this.touchingScrollingChild = false;
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
            WeakReference<View> weakReference2 = this.nestedScrollingChildRef;
            if (weakReference2 != null) {
                if (weakReference2 == null) {
                    Intrinsics.throwNpe();
                }
                view2 = weakReference2.get();
            }
            if (actionMasked != 2 || view2 == null || this.ignoreEvents || this.state == 1 || coordinatorLayout.isPointInChildBounds(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.viewDragHelper == null) {
                return false;
            }
            float abs = Math.abs(this.initialX - motionEvent.getX());
            if (this.viewDragHelper == null) {
                Intrinsics.throwNpe();
            }
            if (abs <= r11.getTouchSlop()) {
                return false;
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
            if (viewDragHelper2 != null && actionMasked == 2 && !this.ignoreEvents && Math.abs(this.initialX - motionEvent.getX()) > viewDragHelper2.getTouchSlop()) {
                viewDragHelper2.captureChildView(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
            if (this.ignoreEvents) {
                return false;
            }
        }
        return true;
    }

    private final boolean disablePullDown(MotionEvent event) {
        return this.slideProcessor.disableDragDown() || !this.slideProcessor.shouldInterceptSlide((int) event.getY());
    }

    private final boolean disablePullUp() {
        if (this.pullUpProcessor.enablePullUp() && this.pullUpProcessor.isWebViewReachTop()) {
            return ((this.state == 4 && this.pullUpProcessor.enableToFull()) || (this.state == 3 && this.pullUpProcessor.enableToHalf())) ? false : true;
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(coordinatorLayout, "coordinatorLayout");
        Intrinsics.checkParameterIsNotNull(view, "directTargetChild");
        Intrinsics.checkParameterIsNotNull(view2, "target");
        this.lastNestedScrollDy = 0;
        this.nestedScrolled = false;
        return (i & 1) != 0;
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
                int left = v.getLeft();
                int i4 = left - i;
                if (i > 0) {
                    if (i4 < getExpandedOffset()) {
                        int expandedOffset = left - getExpandedOffset();
                        iArr[0] = expandedOffset;
                        ViewCompat.offsetLeftAndRight(v, -expandedOffset);
                        setStateInternal(3);
                    } else {
                        iArr[0] = i;
                        ViewCompat.offsetLeftAndRight(v, -i);
                        setStateInternal(1);
                    }
                } else if (i < 0 && !view.canScrollHorizontally(-1) && !this.slideProcessor.disableDragDown()) {
                    if (i4 > this.collapsedOffset && !getIsHideAble()) {
                        int i5 = left - this.collapsedOffset;
                        iArr[0] = i5;
                        ViewCompat.offsetLeftAndRight(v, -i5);
                        setStateInternal(4);
                    } else {
                        iArr[0] = i;
                        ViewCompat.offsetLeftAndRight(v, -i);
                        setStateInternal(1);
                    }
                }
                dispatchOnSlide(v.getLeft());
                this.lastNestedScrollDy = i;
                this.nestedScrolled = true;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b9  */
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
        if (v.getLeft() == getExpandedOffset()) {
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
                i2 = this.parentWidth;
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
            if (viewDragHelper != null && viewDragHelper.smoothSlideViewTo(v, i2, v.getTop())) {
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
                this.collapsedOffset = this.parentWidth - peekHeight;
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
                    v.post(new Runnable() { // from class: com.bytedance.android.livesdk.pannel.RightSheetBehavior$setState$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            RightSheetBehavior.this.startSettlingAnimation(v, state);
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
            this.collapsedOffset = Math.max(this.parentWidth - this.lastPeekWidth, this.fitToContentsOffset);
        } else {
            this.collapsedOffset = this.parentWidth - this.lastPeekWidth;
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

    public final boolean shouldHide(View child, float xvel) {
        Intrinsics.checkParameterIsNotNull(child, "child");
        if (getSkipCollapsed()) {
            float f = xvel * 0.1f;
            if (f > 500) {
                return true;
            }
            if (f < -30) {
                return false;
            }
            if ((this.parentWidth - (child.getLeft() + f)) / child.getWidth() < 0.5f) {
                return true;
            }
        } else if (child.getLeft() >= this.collapsedOffset && Math.abs((child.getLeft() + (xvel * 0.1f)) - this.collapsedOffset) / this.peekHeight > 0.5f) {
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

    private final int getExpandedOffset() {
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
            i = this.parentWidth;
        }
        ViewDragHelper viewDragHelper = this.viewDragHelper;
        if (viewDragHelper != null && viewDragHelper.smoothSlideViewTo(child, i, child.getTop())) {
            setStateInternal(2);
            ViewCompat.postOnAnimation(child, new SettleRunnable(this, child, state));
        } else {
            setStateInternal(state);
        }
    }

    public final void dispatchOnSlide(int left) {
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference == null) {
            Intrinsics.throwNpe();
        }
        V v = weakReference.get();
        if (v == null || getMCallback() == null) {
            return;
        }
        if (left > this.collapsedOffset) {
            SheetBaseBehavior.SheetCallback mCallback = getMCallback();
            if (mCallback == null) {
                Intrinsics.throwNpe();
            }
            int i = this.collapsedOffset;
            mCallback.onSlide(v, (i - left) / (this.parentWidth - i));
            return;
        }
        SheetBaseBehavior.SheetCallback mCallback2 = getMCallback();
        if (mCallback2 == null) {
            Intrinsics.throwNpe();
        }
        int i2 = this.collapsedOffset;
        mCallback2.onSlide(v, (i2 - left) / (i2 - getExpandedOffset()));
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
    /* compiled from: RightSheetBehavior.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/pannel/RightSheetBehavior$SettleRunnable;", "Ljava/lang/Runnable;", "view", "Landroid/view/View;", "targetState", "", "(Lcom/bytedance/android/livesdk/pannel/RightSheetBehavior;Landroid/view/View;I)V", "run", "", "panel_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public final class SettleRunnable implements Runnable {
        private final int targetState;
        final /* synthetic */ RightSheetBehavior this$0;
        private final View view;

        public SettleRunnable(RightSheetBehavior rightSheetBehavior, View view, int i) {
            Intrinsics.checkParameterIsNotNull(view, "view");
            this.this$0 = rightSheetBehavior;
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
