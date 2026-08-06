package com.bytedance.android.anniex.container.popup;

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
import com.bytedance.android.anniex.C0840R;
import com.bytedance.android.anniex.assemble.AnnieX;
import com.bytedance.android.anniex.container.popup.BottomSheetBehavior;
import com.bytedance.android.anniex.container.popup.SheetBaseBehavior;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.google.android.material.R;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BottomSheetBehavior.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0000\u0018\u0000 \u008b\u0001*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0004\u008b\u0001\u008c\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\b\u0010R\u001a\u00020SH\u0002J\b\u0010T\u001a\u00020\u0019H\u0002J\u0010\u0010U\u001a\u00020\u00192\u0006\u0010V\u001a\u00020WH\u0002J\b\u0010X\u001a\u00020\u0019H\u0002J\u000e\u0010Y\u001a\u00020S2\u0006\u0010Z\u001a\u00020\fJ\u0014\u0010[\u001a\u0004\u0018\u0001002\b\u0010\\\u001a\u0004\u0018\u00010\u0002H\u0002J\u0006\u0010]\u001a\u00020\fJ\u0006\u0010^\u001a\u00020\fJ\u0006\u0010_\u001a\u00020\u0019J%\u0010`\u001a\u00020\u00192\u0006\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00028\u00002\u0006\u0010V\u001a\u00020WH\u0016¢\u0006\u0002\u0010dJ%\u0010e\u001a\u00020\u00192\u0006\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00028\u00002\u0006\u0010f\u001a\u00020\fH\u0016¢\u0006\u0002\u0010gJ5\u0010h\u001a\u00020\u00192\u0006\u0010i\u001a\u00020b2\u0006\u0010c\u001a\u00028\u00002\u0006\u0010j\u001a\u00020\u00022\u0006\u0010k\u001a\u00020'2\u0006\u0010l\u001a\u00020'H\u0016¢\u0006\u0002\u0010mJE\u0010n\u001a\u00020S2\u0006\u0010i\u001a\u00020b2\u0006\u0010c\u001a\u00028\u00002\u0006\u0010j\u001a\u00020\u00022\u0006\u0010o\u001a\u00020\f2\u0006\u0010p\u001a\u00020\f2\u0006\u0010q\u001a\u00020r2\u0006\u0010s\u001a\u00020\fH\u0016¢\u0006\u0002\u0010tJ%\u0010u\u001a\u00020S2\u0006\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00028\u00002\u0006\u0010;\u001a\u00020vH\u0016¢\u0006\u0002\u0010wJ\u001f\u0010x\u001a\u0004\u0018\u00010v2\u0006\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010yJ=\u0010z\u001a\u00020\u00192\u0006\u0010i\u001a\u00020b2\u0006\u0010c\u001a\u00028\u00002\u0006\u0010{\u001a\u00020\u00022\u0006\u0010j\u001a\u00020\u00022\u0006\u0010|\u001a\u00020\f2\u0006\u0010s\u001a\u00020\fH\u0016¢\u0006\u0002\u0010}J-\u0010~\u001a\u00020S2\u0006\u0010i\u001a\u00020b2\u0006\u0010c\u001a\u00028\u00002\u0006\u0010j\u001a\u00020\u00022\u0006\u0010s\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\u007fJ&\u0010\u0080\u0001\u001a\u00020\u00192\u0006\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00028\u00002\u0006\u0010V\u001a\u00020WH\u0016¢\u0006\u0002\u0010dJ\t\u0010\u0081\u0001\u001a\u00020SH\u0002J\u000f\u0010\u0082\u0001\u001a\u00020S2\u0006\u0010\u0018\u001a\u00020\u0019J\u0011\u0010\u0083\u0001\u001a\u00020S2\u0006\u00106\u001a\u00020\fH\u0016J\u0011\u0010\u0084\u0001\u001a\u00020S2\u0006\u0010;\u001a\u00020\fH\u0016J\u000f\u0010\u0085\u0001\u001a\u00020S2\u0006\u0010;\u001a\u00020\fJ\u0018\u0010\u0086\u0001\u001a\u00020\u00192\u0006\u0010c\u001a\u00020\u00022\u0007\u0010\u0087\u0001\u001a\u00020'J\u0017\u0010\u0088\u0001\u001a\u00020S2\u0006\u0010c\u001a\u00020\u00022\u0006\u0010;\u001a\u00020\fJ\u0012\u0010\u0089\u0001\u001a\u00020S2\u0007\u0010\u008a\u0001\u001a\u00020\u0019H\u0002R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000eR\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\u001a\u0010\u001d\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000e\"\u0004\b\u001f\u0010\u0010R\u000e\u0010 \u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010)\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u0010/\u001a\f\u0012\u0006\u0012\u0004\u0018\u000100\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010,\"\u0004\b2\u0010.R\u001a\u00103\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u000e\"\u0004\b5\u0010\u0010R\u000e\u00106\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00108\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u000e\"\u0004\b:\u0010\u0010R\u000e\u0010;\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010<\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001a\u0010A\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010>\"\u0004\bC\u0010@R\u0010\u0010D\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010F\u001a\u0004\u0018\u00010GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\"\u0010L\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010,\"\u0004\bN\u0010.R\u0014\u0010O\u001a\u00020'8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bP\u0010Q¨\u0006\u008d\u0001"}, d2 = {"Lcom/bytedance/android/anniex/container/popup/BottomSheetBehavior;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroid/view/View;", "Lcom/bytedance/android/anniex/container/popup/SheetBaseBehavior;", "view", "(Landroid/view/View;)V", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "activePointerId", "", "getActivePointerId", "()I", "setActivePointerId", "(I)V", "collapsedOffset", "getCollapsedOffset", "setCollapsedOffset", "dragCallback", "Landroidx/customview/widget/ViewDragHelper$Callback;", "expandedOffset", "getExpandedOffset", "fitToContents", "", "fitToContentsOffset", "getFitToContentsOffset", "setFitToContentsOffset", "halfExpandedOffset", "getHalfExpandedOffset", "setHalfExpandedOffset", "ignoreEvents", "importantForAccessibilityMap", "", "initialY", "lastNestedScrollDy", "lastPeekHeight", "maximumVelocity", "", "nestedScrolled", "nestedScrollingChildRef", "Ljava/lang/ref/WeakReference;", "getNestedScrollingChildRef", "()Ljava/lang/ref/WeakReference;", "setNestedScrollingChildRef", "(Ljava/lang/ref/WeakReference;)V", "nestedScrollingParentRef", "Landroid/view/ViewParent;", "getNestedScrollingParentRef", "setNestedScrollingParentRef", "parentHeight", "getParentHeight", "setParentHeight", "peekHeight", "peekHeightAuto", "peekHeightMin", "getPeekHeightMin", "setPeekHeightMin", StrategyConstants.STATE, "touchingScrollingChild", "getTouchingScrollingChild", "()Z", "setTouchingScrollingChild", "(Z)V", "touchingScrollingParent", "getTouchingScrollingParent", "setTouchingScrollingParent", "velocityTracker", "Landroid/view/VelocityTracker;", "viewDragHelper", "Landroidx/customview/widget/ViewDragHelper;", "getViewDragHelper", "()Landroidx/customview/widget/ViewDragHelper;", "setViewDragHelper", "(Landroidx/customview/widget/ViewDragHelper;)V", "viewRef", "getViewRef", "setViewRef", "yVelocity", "getYVelocity", "()F", "calculateCollapsedOffset", "", "disableNestedChildScroll", "disablePullDown", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "disablePullUp", "dispatchOnSlide", "top", "findNestedScrollParent", "thisView", "getPeekHeight", "getState", "isFitToContents", "onInterceptTouchEvent", "parent", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "child", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/MotionEvent;)Z", "onLayoutChild", "layoutDirection", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;I)Z", "onNestedPreFling", "coordinatorLayout", "target", "velocityX", "velocityY", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/View;FF)Z", "onNestedPreScroll", "dx", "dy", "consumed", "", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/View;II[II)V", "onRestoreInstanceState", "Landroid/os/Parcelable;", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;Landroid/os/Parcelable;)V", "onSaveInstanceState", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;)Landroid/os/Parcelable;", "onStartNestedScroll", "directTargetChild", "axes", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/View;Landroid/view/View;II)Z", "onStopNestedScroll", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/View;I)V", "onTouchEvent", "reset", "setFitToContents", "setPeekHeight", "setState", "setStateInternal", "shouldHide", "yvel", "startSettlingAnimation", "updateImportantForAccessibility", "expanded", "Companion", "SettleRunnable", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class BottomSheetBehavior<V extends View> extends SheetBaseBehavior<V> {
    public static final String TAG = "BottomSheetBehavior";
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
            Intrinsics.checkNotNull(view);
            Intrinsics.checkNotNull(thisView);
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
        Intrinsics.checkNotNullParameter(v, "view");
        this.fitToContents = true;
        this.state = 4;
        this.dragCallback = new ViewDragHelper.Callback(this) { // from class: com.bytedance.android.anniex.container.popup.BottomSheetBehavior$dragCallback$1
            final /* synthetic */ BottomSheetBehavior<V> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.this$0 = this;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public boolean tryCaptureView(View child, int pointerId) {
                int i;
                boolean disableNestedChildScroll;
                int i2;
                boolean disableNestedChildScroll2;
                boolean z;
                Intrinsics.checkNotNullParameter(child, "child");
                i = ((BottomSheetBehavior) this.this$0).state;
                if (i == 1) {
                    return false;
                }
                if (this.this$0.getTouchingScrollingChild() || this.this$0.getTouchingScrollingParent()) {
                    disableNestedChildScroll = this.this$0.disableNestedChildScroll();
                    if (!disableNestedChildScroll) {
                        return false;
                    }
                }
                i2 = ((BottomSheetBehavior) this.this$0).state;
                if (i2 == 3 && this.this$0.getActivePointerId() == pointerId) {
                    WeakReference<View> nestedScrollingChildRef = this.this$0.getNestedScrollingChildRef();
                    Intrinsics.checkNotNull(nestedScrollingChildRef);
                    View view = nestedScrollingChildRef.get();
                    disableNestedChildScroll2 = this.this$0.disableNestedChildScroll();
                    if (disableNestedChildScroll2) {
                        WeakReference<ViewParent> nestedScrollingParentRef = this.this$0.getNestedScrollingParentRef();
                        Intrinsics.checkNotNull(nestedScrollingParentRef);
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
                if (this.this$0.getViewRef() == null) {
                    return false;
                }
                WeakReference viewRef = this.this$0.getViewRef();
                return (viewRef != null ? (View) viewRef.get() : null) == child;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewPositionChanged(View changedView, int left, int top, int dx, int dy) {
                Intrinsics.checkNotNullParameter(changedView, "changedView");
                this.this$0.dispatchOnSlide(top);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewDragStateChanged(int state) {
                if (state == 1) {
                    this.this$0.setStateInternal(1);
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewReleased(View releasedChild, float xvel, float yvel) {
                boolean z;
                int collapsedOffset;
                byte b;
                boolean z2;
                boolean z3;
                Intrinsics.checkNotNullParameter(releasedChild, "releasedChild");
                if (this.this$0.getSkipCollapsed()) {
                    if (!this.this$0.shouldHide(releasedChild, yvel)) {
                        z3 = ((BottomSheetBehavior) this.this$0).fitToContents;
                        collapsedOffset = z3 ? this.this$0.getFitToContentsOffset() : 0;
                        b = (byte) 3;
                    } else {
                        collapsedOffset = this.this$0.getParentHeight();
                        b = (byte) 5;
                    }
                } else if (yvel < 0.0f) {
                    z2 = ((BottomSheetBehavior) this.this$0).fitToContents;
                    if (z2) {
                        collapsedOffset = this.this$0.getFitToContentsOffset();
                        b = (byte) 3;
                    } else {
                        if (releasedChild.getTop() > this.this$0.getHalfExpandedOffset()) {
                            collapsedOffset = this.this$0.getHalfExpandedOffset();
                            b = (byte) 6;
                        }
                        b = (byte) 3;
                        collapsedOffset = 0;
                    }
                } else if (this.this$0.getIsHideAble() && this.this$0.shouldHide(releasedChild, yvel) && (releasedChild.getTop() > this.this$0.getCollapsedOffset() || Math.abs(xvel) < Math.abs(yvel))) {
                    collapsedOffset = this.this$0.getParentHeight();
                    b = (byte) 5;
                } else {
                    if (!(yvel == 0.0f) && Math.abs(xvel) <= Math.abs(yvel)) {
                        collapsedOffset = this.this$0.getCollapsedOffset();
                    } else {
                        int top = releasedChild.getTop();
                        z = ((BottomSheetBehavior) this.this$0).fitToContents;
                        if (z) {
                            if (Math.abs(top - this.this$0.getFitToContentsOffset()) < Math.abs(top - this.this$0.getCollapsedOffset())) {
                                collapsedOffset = this.this$0.getFitToContentsOffset();
                                b = (byte) 3;
                            } else {
                                collapsedOffset = this.this$0.getCollapsedOffset();
                            }
                        } else {
                            if (top < this.this$0.getHalfExpandedOffset()) {
                                if (top >= Math.abs(top - this.this$0.getCollapsedOffset())) {
                                    collapsedOffset = this.this$0.getHalfExpandedOffset();
                                }
                                b = (byte) 3;
                                collapsedOffset = 0;
                            } else if (Math.abs(top - this.this$0.getHalfExpandedOffset()) < Math.abs(top - this.this$0.getCollapsedOffset())) {
                                collapsedOffset = this.this$0.getHalfExpandedOffset();
                            } else {
                                collapsedOffset = this.this$0.getCollapsedOffset();
                            }
                            b = (byte) 6;
                        }
                    }
                    b = (byte) 4;
                }
                if (b == 5) {
                    this.this$0.setStateInternal(b);
                    return;
                }
                ViewDragHelper viewDragHelper = this.this$0.getViewDragHelper();
                if (viewDragHelper != null && viewDragHelper.settleCapturedViewAt(releasedChild.getLeft(), collapsedOffset)) {
                    this.this$0.setStateInternal(2);
                    ViewCompat.postOnAnimation(releasedChild, new BottomSheetBehavior.SettleRunnable(this.this$0, releasedChild, b));
                } else {
                    this.this$0.setStateInternal(b);
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionVertical(View child, int top, int dy) {
                int expandedOffset;
                Intrinsics.checkNotNullParameter(child, "child");
                expandedOffset = this.this$0.getExpandedOffset();
                return MathUtils.clamp(top, expandedOffset, this.this$0.getIsHideAble() ? this.this$0.getParentHeight() : this.this$0.getCollapsedOffset());
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionHorizontal(View child, int left, int dx) {
                Intrinsics.checkNotNullParameter(child, "child");
                return child.getLeft();
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int getViewVerticalDragRange(View child) {
                Intrinsics.checkNotNullParameter(child, "child");
                return this.this$0.getIsHideAble() ? this.this$0.getParentHeight() : this.this$0.getCollapsedOffset();
            }
        };
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.fitToContents = true;
        this.state = 4;
        this.dragCallback = new ViewDragHelper.Callback(this) { // from class: com.bytedance.android.anniex.container.popup.BottomSheetBehavior$dragCallback$1
            final /* synthetic */ BottomSheetBehavior<V> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.this$0 = this;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public boolean tryCaptureView(View child, int pointerId) {
                int i;
                boolean disableNestedChildScroll;
                int i2;
                boolean disableNestedChildScroll2;
                boolean z;
                Intrinsics.checkNotNullParameter(child, "child");
                i = ((BottomSheetBehavior) this.this$0).state;
                if (i == 1) {
                    return false;
                }
                if (this.this$0.getTouchingScrollingChild() || this.this$0.getTouchingScrollingParent()) {
                    disableNestedChildScroll = this.this$0.disableNestedChildScroll();
                    if (!disableNestedChildScroll) {
                        return false;
                    }
                }
                i2 = ((BottomSheetBehavior) this.this$0).state;
                if (i2 == 3 && this.this$0.getActivePointerId() == pointerId) {
                    WeakReference<View> nestedScrollingChildRef = this.this$0.getNestedScrollingChildRef();
                    Intrinsics.checkNotNull(nestedScrollingChildRef);
                    View view = nestedScrollingChildRef.get();
                    disableNestedChildScroll2 = this.this$0.disableNestedChildScroll();
                    if (disableNestedChildScroll2) {
                        WeakReference<ViewParent> nestedScrollingParentRef = this.this$0.getNestedScrollingParentRef();
                        Intrinsics.checkNotNull(nestedScrollingParentRef);
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
                if (this.this$0.getViewRef() == null) {
                    return false;
                }
                WeakReference viewRef = this.this$0.getViewRef();
                return (viewRef != null ? (View) viewRef.get() : null) == child;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewPositionChanged(View changedView, int left, int top, int dx, int dy) {
                Intrinsics.checkNotNullParameter(changedView, "changedView");
                this.this$0.dispatchOnSlide(top);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewDragStateChanged(int state) {
                if (state == 1) {
                    this.this$0.setStateInternal(1);
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewReleased(View releasedChild, float xvel, float yvel) {
                boolean z;
                int collapsedOffset;
                byte b;
                boolean z2;
                boolean z3;
                Intrinsics.checkNotNullParameter(releasedChild, "releasedChild");
                if (this.this$0.getSkipCollapsed()) {
                    if (!this.this$0.shouldHide(releasedChild, yvel)) {
                        z3 = ((BottomSheetBehavior) this.this$0).fitToContents;
                        collapsedOffset = z3 ? this.this$0.getFitToContentsOffset() : 0;
                        b = (byte) 3;
                    } else {
                        collapsedOffset = this.this$0.getParentHeight();
                        b = (byte) 5;
                    }
                } else if (yvel < 0.0f) {
                    z2 = ((BottomSheetBehavior) this.this$0).fitToContents;
                    if (z2) {
                        collapsedOffset = this.this$0.getFitToContentsOffset();
                        b = (byte) 3;
                    } else {
                        if (releasedChild.getTop() > this.this$0.getHalfExpandedOffset()) {
                            collapsedOffset = this.this$0.getHalfExpandedOffset();
                            b = (byte) 6;
                        }
                        b = (byte) 3;
                        collapsedOffset = 0;
                    }
                } else if (this.this$0.getIsHideAble() && this.this$0.shouldHide(releasedChild, yvel) && (releasedChild.getTop() > this.this$0.getCollapsedOffset() || Math.abs(xvel) < Math.abs(yvel))) {
                    collapsedOffset = this.this$0.getParentHeight();
                    b = (byte) 5;
                } else {
                    if (!(yvel == 0.0f) && Math.abs(xvel) <= Math.abs(yvel)) {
                        collapsedOffset = this.this$0.getCollapsedOffset();
                    } else {
                        int top = releasedChild.getTop();
                        z = ((BottomSheetBehavior) this.this$0).fitToContents;
                        if (z) {
                            if (Math.abs(top - this.this$0.getFitToContentsOffset()) < Math.abs(top - this.this$0.getCollapsedOffset())) {
                                collapsedOffset = this.this$0.getFitToContentsOffset();
                                b = (byte) 3;
                            } else {
                                collapsedOffset = this.this$0.getCollapsedOffset();
                            }
                        } else {
                            if (top < this.this$0.getHalfExpandedOffset()) {
                                if (top >= Math.abs(top - this.this$0.getCollapsedOffset())) {
                                    collapsedOffset = this.this$0.getHalfExpandedOffset();
                                }
                                b = (byte) 3;
                                collapsedOffset = 0;
                            } else if (Math.abs(top - this.this$0.getHalfExpandedOffset()) < Math.abs(top - this.this$0.getCollapsedOffset())) {
                                collapsedOffset = this.this$0.getHalfExpandedOffset();
                            } else {
                                collapsedOffset = this.this$0.getCollapsedOffset();
                            }
                            b = (byte) 6;
                        }
                    }
                    b = (byte) 4;
                }
                if (b == 5) {
                    this.this$0.setStateInternal(b);
                    return;
                }
                ViewDragHelper viewDragHelper = this.this$0.getViewDragHelper();
                if (viewDragHelper != null && viewDragHelper.settleCapturedViewAt(releasedChild.getLeft(), collapsedOffset)) {
                    this.this$0.setStateInternal(2);
                    ViewCompat.postOnAnimation(releasedChild, new BottomSheetBehavior.SettleRunnable(this.this$0, releasedChild, b));
                } else {
                    this.this$0.setStateInternal(b);
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionVertical(View child, int top, int dy) {
                int expandedOffset;
                Intrinsics.checkNotNullParameter(child, "child");
                expandedOffset = this.this$0.getExpandedOffset();
                return MathUtils.clamp(top, expandedOffset, this.this$0.getIsHideAble() ? this.this$0.getParentHeight() : this.this$0.getCollapsedOffset());
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionHorizontal(View child, int left, int dx) {
                Intrinsics.checkNotNullParameter(child, "child");
                return child.getLeft();
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int getViewVerticalDragRange(View child) {
                Intrinsics.checkNotNullParameter(child, "child");
                return this.this$0.getIsHideAble() ? this.this$0.getParentHeight() : this.this$0.getCollapsedOffset();
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BottomSheetBehavior_Layout);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…ttomSheetBehavior_Layout)");
        TypedValue peekValue = obtainStyledAttributes.peekValue(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (peekValue != null && peekValue.data == -1) {
            setPeekHeight(peekValue.data);
        } else {
            setPeekHeight(obtainStyledAttributes.getDimensionPixelSize(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        }
        setHideAble(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        setFitToContents(true);
        setSkipCollapsed(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        obtainStyledAttributes.recycle();
        this.maximumVelocity = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public Parcelable onSaveInstanceState(CoordinatorLayout parent, V child) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        Parcelable onSaveInstanceState = super.onSaveInstanceState(parent, child);
        return onSaveInstanceState != null ? new SavedState(onSaveInstanceState, this.state) : null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onRestoreInstanceState(CoordinatorLayout parent, V child, Parcelable state) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(state, StrategyConstants.STATE);
        SavedState savedState = (SavedState) state;
        if (savedState.getSuperState() != null) {
            Parcelable superState = savedState.getSuperState();
            Intrinsics.checkNotNull(superState);
            super.onRestoreInstanceState(parent, child, superState);
        }
        if (savedState.getState() != 1 && savedState.getState() != 2) {
            this.state = savedState.getState();
        } else {
            this.state = 4;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout parent, V child, int layoutDirection) {
        String str;
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        if (ViewCompat.getFitsSystemWindows(parent) && !ViewCompat.getFitsSystemWindows(child)) {
            child.setFitsSystemWindows(true);
        }
        int top = child.getTop();
        try {
            parent.onLayoutChild(child, layoutDirection);
        } catch (Exception e) {
            try {
                View findViewById = parent.findViewById(C0840R.id.annie_x_bottom_sheet);
                Intrinsics.checkNotNullExpressionValue(findViewById, "parent.findViewById(Anni….id.annie_x_bottom_sheet)");
                str = findFirstId((ViewGroup) findViewById);
            } catch (Exception unused) {
                str = "";
            }
            if (AnnieX.isDebug()) {
                throw new RuntimeException("invalid state in BottomSheetBehavior: " + str + " Real exception: " + e);
            }
        }
        this.parentHeight = parent.getHeight();
        if (this.peekHeightAuto) {
            if (this.peekHeightMin == 0) {
                this.peekHeightMin = parent.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            }
            this.lastPeekHeight = Math.max(this.peekHeightMin, this.parentHeight - ((parent.getWidth() * 9) / 16));
        } else {
            this.lastPeekHeight = this.peekHeight;
        }
        this.fitToContentsOffset = Math.max(0, this.parentHeight - child.getHeight());
        this.halfExpandedOffset = this.parentHeight / 2;
        calculateCollapsedOffset();
        int i = this.state;
        if (i == 3) {
            ViewCompat.offsetTopAndBottom(child, getExpandedOffset());
        } else if (i == 6) {
            ViewCompat.offsetTopAndBottom(child, this.halfExpandedOffset);
        } else if (getIsHideAble() && this.state == 5) {
            ViewCompat.offsetTopAndBottom(child, this.parentHeight);
        } else {
            int i2 = this.state;
            if (i2 == 4) {
                ViewCompat.offsetTopAndBottom(child, this.collapsedOffset);
            } else if (i2 == 1 || i2 == 2) {
                ViewCompat.offsetTopAndBottom(child, top - child.getTop());
            }
        }
        if (this.viewDragHelper == null) {
            this.viewDragHelper = ViewDragHelper.create(parent, this.dragCallback);
        }
        this.viewRef = new WeakReference<>(child);
        this.nestedScrollingChildRef = new WeakReference<>(findScrollingChild(child));
        if (disableNestedChildScroll()) {
            WeakReference<View> weakReference = this.nestedScrollingChildRef;
            Intrinsics.checkNotNull(weakReference);
            this.nestedScrollingParentRef = new WeakReference<>(findNestedScrollParent(weakReference.get()));
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0052, code lost:
    
        if (r0 != 3) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0107, code lost:
    
        if ((r11 != null && r11.shouldInterceptTouchEvent(r12)) != false) goto L71;
     */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(CoordinatorLayout parent, V child, MotionEvent event) {
        View view;
        Object obj;
        View view2;
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
        if (!child.isShown() || ((disablePullDown(event) && disablePullUp()) || this.pullUpProcessor.inIgnoreArea(event))) {
            this.ignoreEvents = true;
            return false;
        }
        int actionMasked = event.getActionMasked();
        if (actionMasked == 0) {
            reset();
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        VelocityTracker velocityTracker = this.velocityTracker;
        Intrinsics.checkNotNull(velocityTracker);
        velocityTracker.addMovement(event);
        View view3 = null;
        if (actionMasked == 0) {
            int x = (int) event.getX();
            this.initialY = (int) event.getY();
            WeakReference<View> weakReference = this.nestedScrollingChildRef;
            if (weakReference != null) {
                Intrinsics.checkNotNull(weakReference);
                view = weakReference.get();
            } else {
                view = null;
            }
            if (view != null && parent.isPointInChildBounds(view, x, this.initialY)) {
                this.activePointerId = event.getPointerId(event.getActionIndex());
                this.touchingScrollingChild = true;
            }
            WeakReference<ViewParent> weakReference2 = this.nestedScrollingParentRef;
            if (weakReference2 != null) {
                Intrinsics.checkNotNull(weakReference2);
                obj = (ViewParent) weakReference2.get();
            } else {
                obj = null;
            }
            if (obj != null && parent.isPointInChildBounds((View) obj, x, this.initialY)) {
                this.activePointerId = event.getPointerId(event.getActionIndex());
                this.touchingScrollingParent = true;
            }
            this.ignoreEvents = this.activePointerId == -1 && !parent.isPointInChildBounds(child, x, this.initialY);
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
        if (!this.ignoreEvents && (r11 = this.viewDragHelper) != null) {
        }
        if (!disableNestedChildScroll()) {
            WeakReference<View> weakReference3 = this.nestedScrollingChildRef;
            if (weakReference3 != null) {
                Intrinsics.checkNotNull(weakReference3);
                view3 = weakReference3.get();
            }
            if (actionMasked != 2 || view3 == null || this.ignoreEvents || this.state == 1 || parent.isPointInChildBounds(view3, (int) event.getX(), (int) event.getY()) || this.viewDragHelper == null) {
                return false;
            }
            float abs = Math.abs(this.initialY - event.getY());
            Intrinsics.checkNotNull(this.viewDragHelper);
            if (abs <= r11.getTouchSlop()) {
                return false;
            }
            return true;
        }
        WeakReference<View> weakReference4 = this.nestedScrollingChildRef;
        if (weakReference4 != null) {
            Intrinsics.checkNotNull(weakReference4);
            view2 = weakReference4.get();
        } else {
            view2 = null;
        }
        WeakReference<ViewParent> weakReference5 = this.nestedScrollingParentRef;
        if (weakReference5 != null) {
            Intrinsics.checkNotNull(weakReference5);
            ViewParent viewParent = weakReference5.get();
            if (viewParent instanceof ViewGroup) {
                view3 = (ViewGroup) viewParent;
            }
        }
        if (actionMasked != 2 || this.ignoreEvents) {
            return false;
        }
        float abs2 = Math.abs(this.initialY - event.getY());
        ViewDragHelper viewDragHelper = this.viewDragHelper;
        Intrinsics.checkNotNull(viewDragHelper);
        return (abs2 <= ((float) viewDragHelper.getTouchSlop()) || this.state == 1 || this.viewDragHelper == null || view2 == null || parent.isPointInChildBounds(view2, (int) event.getX(), (int) event.getY()) || view3 == null || parent.isPointInChildBounds(view3, (int) event.getX(), (int) event.getY())) ? false : true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout parent, V child, MotionEvent event) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
        if (!child.isShown()) {
            return false;
        }
        int actionMasked = event.getActionMasked();
        if (this.state != 1 || actionMasked != 0) {
            ViewDragHelper viewDragHelper = this.viewDragHelper;
            if (viewDragHelper != null) {
                viewDragHelper.processTouchEvent(event);
            }
            if (actionMasked == 0) {
                reset();
            }
            if (this.velocityTracker == null) {
                this.velocityTracker = VelocityTracker.obtain();
            }
            VelocityTracker velocityTracker = this.velocityTracker;
            Intrinsics.checkNotNull(velocityTracker);
            velocityTracker.addMovement(event);
            ViewDragHelper viewDragHelper2 = this.viewDragHelper;
            if (viewDragHelper2 != null && actionMasked == 2 && !this.ignoreEvents && Math.abs(this.initialY - event.getY()) > viewDragHelper2.getTouchSlop()) {
                viewDragHelper2.captureChildView(child, event.getPointerId(event.getActionIndex()));
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
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V child, View directTargetChild, View target, int axes, int type) {
        Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(directTargetChild, "directTargetChild");
        Intrinsics.checkNotNullParameter(target, "target");
        this.lastNestedScrollDy = 0;
        this.nestedScrolled = false;
        return (axes & 2) != 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V child, View target, int dx, int dy, int[] consumed, int type) {
        Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(consumed, "consumed");
        if (type != 1) {
            WeakReference<View> weakReference = this.nestedScrollingChildRef;
            Intrinsics.checkNotNull(weakReference);
            if (target == weakReference.get()) {
                int top = child.getTop();
                int i = top - dy;
                if (dy > 0) {
                    if (i < getExpandedOffset()) {
                        int expandedOffset = top - getExpandedOffset();
                        consumed[1] = expandedOffset;
                        ViewCompat.offsetTopAndBottom(child, -expandedOffset);
                        setStateInternal(3);
                    } else {
                        consumed[1] = dy;
                        ViewCompat.offsetTopAndBottom(child, -dy);
                        setStateInternal(1);
                    }
                } else if (dy < 0 && !target.canScrollVertically(-1) && !this.slideProcessor.disableDragDown()) {
                    if (i > this.collapsedOffset && !getIsHideAble()) {
                        int i2 = top - this.collapsedOffset;
                        consumed[1] = i2;
                        ViewCompat.offsetTopAndBottom(child, -i2);
                        setStateInternal(4);
                    } else {
                        consumed[1] = dy;
                        ViewCompat.offsetTopAndBottom(child, -dy);
                        setStateInternal(1);
                    }
                }
                dispatchOnSlide(child.getTop());
                this.lastNestedScrollDy = dy;
                this.nestedScrolled = true;
                if (disableNestedChildScroll() && this.state == 3 && dy < 0 && consumed[1] == 0) {
                    this.nestedScrolled = false;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00d1, code lost:
    
        if (r5 == true) goto L56;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c4  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V child, View target, int type) {
        int i;
        byte b;
        boolean z;
        Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        if (child.getTop() == getExpandedOffset()) {
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
        Intrinsics.checkNotNull(weakReference);
        if (target != weakReference.get() || !this.nestedScrolled) {
            return;
        }
        if (this.lastNestedScrollDy > 30) {
            i = getExpandedOffset();
        } else {
            if (getIsHideAble() && shouldHide(child, getYVelocity())) {
                i = this.parentHeight;
                b = (byte) 5;
            } else if (getSkipCollapsed()) {
                i = getExpandedOffset();
            } else {
                if (this.lastNestedScrollDy == 0) {
                    int top = child.getTop();
                    if (this.fitToContents) {
                        if (Math.abs(top - this.fitToContentsOffset) < Math.abs(top - this.collapsedOffset)) {
                            i = this.fitToContentsOffset;
                        } else {
                            i = this.collapsedOffset;
                        }
                    } else {
                        int i2 = this.halfExpandedOffset;
                        if (top < i2) {
                            if (top < Math.abs(top - this.collapsedOffset)) {
                                b = (byte) 3;
                                i = 0;
                            } else {
                                i = this.halfExpandedOffset;
                            }
                        } else if (Math.abs(top - i2) < Math.abs(top - this.collapsedOffset)) {
                            i = this.halfExpandedOffset;
                        } else {
                            i = this.collapsedOffset;
                        }
                        b = (byte) 6;
                    }
                } else {
                    i = this.collapsedOffset;
                }
                b = (byte) 4;
            }
            if (b != 5) {
                setStateInternal(b);
                return;
            }
            ViewDragHelper viewDragHelper = this.viewDragHelper;
            if (viewDragHelper != null) {
                boolean smoothSlideViewTo = viewDragHelper.smoothSlideViewTo(child, child.getLeft(), i);
                z = true;
            }
            z = false;
            if (z) {
                setStateInternal(2);
                ViewCompat.postOnAnimation(child, new SettleRunnable(this, child, b));
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
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V child, View target, float velocityX, float velocityY) {
        Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        WeakReference<View> weakReference = this.nestedScrollingChildRef;
        Intrinsics.checkNotNull(weakReference);
        return target == weakReference.get() && (this.state != 3 || super.onNestedPreFling(coordinatorLayout, child, target, velocityX, velocityY));
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

    @Override // com.bytedance.android.anniex.container.popup.SheetBaseBehavior
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

    @Override // com.bytedance.android.anniex.container.popup.SheetBaseBehavior
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
                    v.post(new Runnable() { // from class: com.bytedance.android.anniex.container.popup.BottomSheetBehavior$setState$1
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
            } else if (state == 4 || state == 5) {
                updateImportantForAccessibility(false);
            }
            WeakReference<V> weakReference = this.viewRef;
            Intrinsics.checkNotNull(weakReference);
            V v = weakReference.get();
            if (v == null || getMCallback() == null) {
                return;
            }
            SheetBaseBehavior.SheetCallback mCallback = getMCallback();
            Intrinsics.checkNotNull(mCallback);
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
            Intrinsics.checkNotNull(velocityTracker);
            velocityTracker.recycle();
            this.velocityTracker = null;
        }
    }

    public final boolean shouldHide(View child, float yvel) {
        Intrinsics.checkNotNullParameter(child, "child");
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
        Intrinsics.checkNotNull(velocityTracker);
        velocityTracker.computeCurrentVelocity(1000, this.maximumVelocity);
        VelocityTracker velocityTracker2 = this.velocityTracker;
        Intrinsics.checkNotNull(velocityTracker2);
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
        Intrinsics.checkNotNullParameter(child, "child");
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
        Intrinsics.checkNotNull(weakReference);
        V v = weakReference.get();
        if (v == null || getMCallback() == null) {
            return;
        }
        if (top > this.collapsedOffset) {
            SheetBaseBehavior.SheetCallback mCallback = getMCallback();
            Intrinsics.checkNotNull(mCallback);
            int i = this.collapsedOffset;
            mCallback.onSlide(v, (i - top) / (this.parentHeight - i));
            return;
        }
        SheetBaseBehavior.SheetCallback mCallback2 = getMCallback();
        Intrinsics.checkNotNull(mCallback2);
        int i2 = this.collapsedOffset;
        mCallback2.onSlide(v, (i2 - top) / (i2 - getExpandedOffset()));
    }

    private final void updateImportantForAccessibility(boolean expanded) {
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference != null) {
            V v = weakReference != null ? weakReference.get() : null;
            Intrinsics.checkNotNull(v, "null cannot be cast to non-null type android.view.View");
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
                    Intrinsics.checkNotNullExpressionValue(childAt, "parent.getChildAt(i)");
                    WeakReference<V> weakReference2 = this.viewRef;
                    if (childAt != (weakReference2 != null ? weakReference2.get() : null)) {
                        if (!expanded) {
                            Map<View, Integer> map = this.importantForAccessibilityMap;
                            if (map != null) {
                                Intrinsics.checkNotNull(map);
                                if (map.containsKey(childAt)) {
                                    Map<View, Integer> map2 = this.importantForAccessibilityMap;
                                    Intrinsics.checkNotNull(map2);
                                    Integer num = map2.get(childAt);
                                    Intrinsics.checkNotNull(num);
                                    ViewCompat.setImportantForAccessibility(childAt, num.intValue());
                                }
                            }
                        } else {
                            Map<View, Integer> map3 = this.importantForAccessibilityMap;
                            Intrinsics.checkNotNull(map3);
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
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/android/anniex/container/popup/BottomSheetBehavior$SettleRunnable;", "Ljava/lang/Runnable;", "view", "Landroid/view/View;", "targetState", "", "(Lcom/bytedance/android/anniex/container/popup/BottomSheetBehavior;Landroid/view/View;I)V", "run", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public final class SettleRunnable implements Runnable {
        private final int targetState;
        final /* synthetic */ BottomSheetBehavior<V> this$0;
        private final View view;

        public SettleRunnable(BottomSheetBehavior bottomSheetBehavior, View view, int i) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.this$0 = bottomSheetBehavior;
            this.view = view;
            this.targetState = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.this$0.getViewDragHelper() != null) {
                ViewDragHelper viewDragHelper = this.this$0.getViewDragHelper();
                boolean z = false;
                if (viewDragHelper != null && viewDragHelper.continueSettling(true)) {
                    z = true;
                }
                if (z) {
                    ViewCompat.postOnAnimation(this.view, this);
                    return;
                }
            }
            this.this$0.setStateInternal(this.targetState);
        }
    }
}
