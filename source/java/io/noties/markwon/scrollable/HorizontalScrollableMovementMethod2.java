package io.noties.markwon.scrollable;

import android.animation.ValueAnimator;
import android.content.Context;
import android.text.Spannable;
import android.text.method.MovementMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import android.widget.TextView;
import androidx.compose.runtime.snapshots.SnapshotId_jvmKt;
import androidx.core.view.ViewCompat;
import io.noties.markwon.scrollable.HorizontalScrollableMovementMethod2;
import io.noties.markwon.utils.DeviceChecker;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: HorizontalScrollableMovementMethod2.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001:\u00010B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0018\u001a\u00020\u0006H\u0096\u0001J)\u0010\u0019\u001a\u00020\u001a2\u000e\u0010\u001b\u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001c2\u000e\u0010\u001e\u001a\n \u001d*\u0004\u0018\u00010\u001f0\u001fH\u0096\u0001J9\u0010 \u001a\u00020\u00062\u000e\u0010\u001b\u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001c2\u000e\u0010\u001e\u001a\n \u001d*\u0004\u0018\u00010\u001f0\u001f2\u000e\u0010!\u001a\n \u001d*\u0004\u0018\u00010\"0\"H\u0096\u0001JA\u0010#\u001a\u00020\u00062\u000e\u0010\u001b\u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001c2\u000e\u0010\u001e\u001a\n \u001d*\u0004\u0018\u00010\u001f0\u001f2\u0006\u0010!\u001a\u00020\u00152\u000e\u0010$\u001a\n \u001d*\u0004\u0018\u00010%0%H\u0096\u0001J9\u0010&\u001a\u00020\u00062\u000e\u0010\u001b\u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001c2\u000e\u0010\u001e\u001a\n \u001d*\u0004\u0018\u00010\u001f0\u001f2\u000e\u0010!\u001a\n \u001d*\u0004\u0018\u00010%0%H\u0096\u0001JA\u0010'\u001a\u00020\u00062\u000e\u0010\u001b\u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001c2\u000e\u0010\u001e\u001a\n \u001d*\u0004\u0018\u00010\u001f0\u001f2\u0006\u0010!\u001a\u00020\u00152\u000e\u0010$\u001a\n \u001d*\u0004\u0018\u00010%0%H\u0096\u0001J1\u0010(\u001a\u00020\u001a2\u000e\u0010\u001b\u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001c2\u000e\u0010\u001e\u001a\n \u001d*\u0004\u0018\u00010\u001f0\u001f2\u0006\u0010!\u001a\u00020\u0015H\u0096\u0001J \u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020\"H\u0016J \u0010-\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020\"H\u0002J9\u0010/\u001a\u00020\u00062\u000e\u0010\u001b\u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001c2\u000e\u0010\u001e\u001a\n \u001d*\u0004\u0018\u00010\u001f0\u001f2\u000e\u0010!\u001a\n \u001d*\u0004\u0018\u00010\"0\"H\u0096\u0001R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lio/noties/markwon/scrollable/HorizontalScrollableMovementMethod2;", "Landroid/text/method/MovementMethod;", "context", "Landroid/content/Context;", "delegate", "allowParentInterceptTouchWhenOverScroll", "", "(Landroid/content/Context;Landroid/text/method/MovementMethod;Z)V", "firstCanScrollLeft", "firstCanScrollRight", "firstX", "", "firstY", "flag", "flinger", "Lio/noties/markwon/scrollable/HorizontalScrollableMovementMethod2$ViewFlinger;", "lastX", "maxVelocity", "scrollable", "Lio/noties/markwon/scrollable/HorizontalScrollable;", "touchSlop", "", "tracker", "Landroid/view/VelocityTracker;", "canSelectArbitrarily", "initialize", "", "p0", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "p1", "Landroid/text/Spannable;", "onGenericMotionEvent", "p2", "Landroid/view/MotionEvent;", "onKeyDown", "p3", "Landroid/view/KeyEvent;", "onKeyOther", "onKeyUp", "onTakeFocus", "onTouchEvent", "widget", "text", "event", "onTouchEventInner", "buffer", "onTrackballEvent", "ViewFlinger", "markwon-core_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class HorizontalScrollableMovementMethod2 implements MovementMethod {
    private final boolean allowParentInterceptTouchWhenOverScroll;
    private final MovementMethod delegate;
    private boolean firstCanScrollLeft;
    private boolean firstCanScrollRight;
    private float firstX;
    private float firstY;
    private boolean flag;
    private final ViewFlinger flinger;
    private float lastX;
    private final float maxVelocity;
    private HorizontalScrollable scrollable;
    private final int touchSlop;
    private VelocityTracker tracker;

    @Override // android.text.method.MovementMethod
    public boolean canSelectArbitrarily() {
        return this.delegate.canSelectArbitrarily();
    }

    @Override // android.text.method.MovementMethod
    public void initialize(TextView p0, Spannable p1) {
        this.delegate.initialize(p0, p1);
    }

    @Override // android.text.method.MovementMethod
    public boolean onGenericMotionEvent(TextView p0, Spannable p1, MotionEvent p2) {
        return this.delegate.onGenericMotionEvent(p0, p1, p2);
    }

    @Override // android.text.method.MovementMethod
    public boolean onKeyDown(TextView p0, Spannable p1, int p2, KeyEvent p3) {
        return this.delegate.onKeyDown(p0, p1, p2, p3);
    }

    @Override // android.text.method.MovementMethod
    public boolean onKeyOther(TextView p0, Spannable p1, KeyEvent p2) {
        return this.delegate.onKeyOther(p0, p1, p2);
    }

    @Override // android.text.method.MovementMethod
    public boolean onKeyUp(TextView p0, Spannable p1, int p2, KeyEvent p3) {
        return this.delegate.onKeyUp(p0, p1, p2, p3);
    }

    @Override // android.text.method.MovementMethod
    public void onTakeFocus(TextView p0, Spannable p1, int p2) {
        this.delegate.onTakeFocus(p0, p1, p2);
    }

    @Override // android.text.method.MovementMethod
    public boolean onTrackballEvent(TextView p0, Spannable p1, MotionEvent p2) {
        return this.delegate.onTrackballEvent(p0, p1, p2);
    }

    public HorizontalScrollableMovementMethod2(Context context, MovementMethod movementMethod, boolean z) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(movementMethod, "delegate");
        this.delegate = movementMethod;
        this.allowParentInterceptTouchWhenOverScroll = z;
        ViewFlinger viewFlinger = null;
        if (!DeviceChecker.INSTANCE.isXiaomiDevice()) {
            try {
                viewFlinger = new ViewFlinger(context);
            } catch (Exception unused) {
            }
        }
        this.flinger = viewFlinger;
        Intrinsics.checkExpressionValueIsNotNull(ViewConfiguration.get(context), "ViewConfiguration.get(context)");
        this.maxVelocity = r3.getScaledMaximumFlingVelocity();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        Intrinsics.checkExpressionValueIsNotNull(viewConfiguration, "ViewConfiguration.get(context)");
        this.touchSlop = viewConfiguration.getScaledTouchSlop();
    }

    public /* synthetic */ HorizontalScrollableMovementMethod2(Context context, MovementMethod movementMethod, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, movementMethod, (i & 4) != 0 ? false : z);
    }

    @Override // android.text.method.MovementMethod
    public boolean onTouchEvent(TextView widget, Spannable text, MotionEvent event) {
        Intrinsics.checkParameterIsNotNull(widget, "widget");
        Intrinsics.checkParameterIsNotNull(text, "text");
        Intrinsics.checkParameterIsNotNull(event, "event");
        try {
            onTouchEventInner(widget, text, event);
        } catch (Exception e) {
            Log.d("onTouchEventInner", "onTouchEventInner exception: " + e);
        }
        return this.delegate.onTouchEvent(widget, text, event);
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x014e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean onTouchEventInner(TextView widget, Spannable buffer, MotionEvent event) {
        ViewParent parent;
        ViewParent parent2;
        int i;
        ViewFlinger viewFlinger;
        VelocityTracker velocityTracker;
        ViewParent parent3;
        int actionMasked = event.getActionMasked();
        if (actionMasked == 0) {
            this.flag = true;
            this.firstX = event.getX();
            this.firstY = event.getY();
            ViewFlinger viewFlinger2 = this.flinger;
            if (viewFlinger2 != null) {
                viewFlinger2.stop();
            }
            HorizontalScrollable[] horizontalScrollableArr = (HorizontalScrollable[]) HorizontalScrollableMovementMethod.INSTANCE.getTouchSpans(event, widget, HorizontalScrollable.class);
            HorizontalScrollable horizontalScrollable = horizontalScrollableArr != null ? (HorizontalScrollable) ArraysKt.firstOrNull(horizontalScrollableArr) : null;
            this.scrollable = horizontalScrollable;
            if (horizontalScrollable != null) {
                if (horizontalScrollable.isScrollable() && (parent3 = widget.getParent()) != null) {
                    parent3.requestDisallowInterceptTouchEvent(true);
                }
                this.firstCanScrollLeft = Math.abs(horizontalScrollable.getScrollX()) < horizontalScrollable.getMaxScroll() || horizontalScrollable.getOverScale() != 0.0f;
                this.firstCanScrollRight = horizontalScrollable.getScrollX() < ((float) 0) || horizontalScrollable.getOverScale() != 0.0f;
                VelocityTracker velocityTracker2 = this.tracker;
                if (velocityTracker2 == null) {
                    this.tracker = VelocityTracker.obtain();
                } else if (velocityTracker2 != null) {
                    velocityTracker2.clear();
                }
                VelocityTracker velocityTracker3 = this.tracker;
                if (velocityTracker3 != null) {
                    velocityTracker3.addMovement(event);
                }
            }
        } else {
            HorizontalScrollable horizontalScrollable2 = this.scrollable;
            if (horizontalScrollable2 != null && horizontalScrollable2.isScrollable()) {
                float abs = Math.abs(event.getX() - this.firstX);
                if (this.flag && abs > this.touchSlop) {
                    widget.cancelLongPress();
                    this.flag = false;
                }
                float abs2 = Math.abs(event.getY() - this.firstY);
                if (abs2 > abs && abs2 > this.touchSlop && (parent2 = widget.getParent()) != null) {
                    parent2.requestDisallowInterceptTouchEvent(false);
                }
                if (abs > abs2 && abs > this.touchSlop) {
                    if (this.allowParentInterceptTouchWhenOverScroll && (((event.getX() > this.firstX && !this.firstCanScrollRight) || (event.getX() < this.firstX && !this.firstCanScrollLeft)) && (parent = widget.getParent()) != null)) {
                        parent.requestDisallowInterceptTouchEvent(false);
                    }
                    horizontalScrollable2.setScrollX$markwon_core_release(horizontalScrollable2.getScrollX() + (event.getX() - this.lastX));
                    ViewCompat.postInvalidateOnAnimation(widget);
                }
                VelocityTracker velocityTracker4 = this.tracker;
                if (velocityTracker4 != null) {
                    velocityTracker4.addMovement(event);
                }
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            HorizontalScrollable horizontalScrollable3 = this.scrollable;
            if (horizontalScrollable3 != null) {
                VelocityTracker velocityTracker5 = this.tracker;
                if (velocityTracker5 != null) {
                    velocityTracker5.computeCurrentVelocity(1000, this.maxVelocity);
                }
                try {
                    velocityTracker = this.tracker;
                } catch (Exception unused) {
                }
                if (velocityTracker != null) {
                    i = MathKt.roundToInt(velocityTracker.getXVelocity());
                    viewFlinger = this.flinger;
                    if (viewFlinger != null) {
                        viewFlinger.fling(widget, horizontalScrollable3, i);
                    }
                }
                i = 0;
                viewFlinger = this.flinger;
                if (viewFlinger != null) {
                }
            }
            this.scrollable = null;
            VelocityTracker velocityTracker6 = this.tracker;
            if (velocityTracker6 != null) {
                velocityTracker6.recycle();
            }
            this.tracker = null;
        }
        this.lastX = event.getX();
        HorizontalScrollable horizontalScrollable4 = this.scrollable;
        return horizontalScrollable4 != null && horizontalScrollable4.isScrollable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HorizontalScrollableMovementMethod2.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\nR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lio/noties/markwon/scrollable/HorizontalScrollableMovementMethod2$ViewFlinger;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "animator", "Landroid/animation/ValueAnimator;", "scroller", "Landroid/widget/OverScroller;", "fling", "", "widget", "Landroid/view/View;", "scrollable", "Lio/noties/markwon/scrollable/HorizontalScrollable;", "velocityX", "", "stop", "markwon-core_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
    public static final class ViewFlinger {
        private ValueAnimator animator;
        private final OverScroller scroller;

        public ViewFlinger(Context context) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            this.scroller = new OverScroller(context, new Interpolator() { // from class: io.noties.markwon.scrollable.HorizontalScrollableMovementMethod2$ViewFlinger$scroller$1
                @Override // android.animation.TimeInterpolator
                public final float getInterpolation(float f) {
                    float f2 = f - 1.0f;
                    return (f2 * f2 * f2 * f2 * f2) + 1.0f;
                }
            });
        }

        public final void fling(final View widget, final HorizontalScrollable scrollable, int velocityX) {
            Intrinsics.checkParameterIsNotNull(widget, "widget");
            Intrinsics.checkParameterIsNotNull(scrollable, "scrollable");
            this.scroller.fling((int) scrollable.getScrollX(), 0, velocityX, 0, -((int) scrollable.getMaxScroll()), 0, 0, 0, (int) scrollable.getOver(), 0);
            ValueAnimator valueAnimator = this.animator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            Intrinsics.checkExpressionValueIsNotNull(ofFloat, "anim");
            ofFloat.setDuration(SnapshotId_jvmKt.SnapshotIdMax);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: io.noties.markwon.scrollable.HorizontalScrollableMovementMethod2$ViewFlinger$fling$$inlined$also$lambda$1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    OverScroller overScroller;
                    OverScroller overScroller2;
                    overScroller = HorizontalScrollableMovementMethod2.ViewFlinger.this.scroller;
                    if (overScroller.computeScrollOffset()) {
                        HorizontalScrollable horizontalScrollable = scrollable;
                        overScroller2 = HorizontalScrollableMovementMethod2.ViewFlinger.this.scroller;
                        horizontalScrollable.setScrollX$markwon_core_release(overScroller2.getCurrX());
                        ViewCompat.postInvalidateOnAnimation(widget);
                        return;
                    }
                    Intrinsics.checkExpressionValueIsNotNull(valueAnimator2, "it");
                    if (valueAnimator2.getAnimatedFraction() < 1.0f) {
                        valueAnimator2.end();
                    }
                }
            });
            ofFloat.start();
            this.animator = ofFloat;
        }

        public final void stop() {
            ValueAnimator valueAnimator = this.animator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            this.animator = null;
            this.scroller.abortAnimation();
        }
    }
}
