package io.noties.markwon.scrollable;

import android.animation.ValueAnimator;
import android.content.Context;
import android.text.Layout;
import android.text.Spannable;
import android.text.Spanned;
import android.text.method.MovementMethod;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import android.widget.TextView;
import androidx.compose.runtime.snapshots.SnapshotId_jvmKt;
import androidx.core.view.ViewCompat;
import io.noties.markwon.scrollable.HorizontalScrollableMovementMethod;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: HorizontalScrollableMovementMethod.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 )2\u00020\u0001:\u0002)*B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0002\u0010\u0005J\t\u0010\u000f\u001a\u00020\u0010H\u0096\u0001J)\u0010\u0011\u001a\u00020\u00122\u000e\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00142\u000e\u0010\u0016\u001a\n \u0015*\u0004\u0018\u00010\u00170\u0017H\u0096\u0001J9\u0010\u0018\u001a\u00020\u00102\u000e\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00142\u000e\u0010\u0016\u001a\n \u0015*\u0004\u0018\u00010\u00170\u00172\u000e\u0010\u0019\u001a\n \u0015*\u0004\u0018\u00010\u001a0\u001aH\u0096\u0001JA\u0010\u001b\u001a\u00020\u00102\u000e\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00142\u000e\u0010\u0016\u001a\n \u0015*\u0004\u0018\u00010\u00170\u00172\u0006\u0010\u0019\u001a\u00020\u001c2\u000e\u0010\u001d\u001a\n \u0015*\u0004\u0018\u00010\u001e0\u001eH\u0096\u0001J9\u0010\u001f\u001a\u00020\u00102\u000e\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00142\u000e\u0010\u0016\u001a\n \u0015*\u0004\u0018\u00010\u00170\u00172\u000e\u0010\u0019\u001a\n \u0015*\u0004\u0018\u00010\u001e0\u001eH\u0096\u0001JA\u0010 \u001a\u00020\u00102\u000e\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00142\u000e\u0010\u0016\u001a\n \u0015*\u0004\u0018\u00010\u00170\u00172\u0006\u0010\u0019\u001a\u00020\u001c2\u000e\u0010\u001d\u001a\n \u0015*\u0004\u0018\u00010\u001e0\u001eH\u0096\u0001J1\u0010!\u001a\u00020\u00122\u000e\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00142\u000e\u0010\u0016\u001a\n \u0015*\u0004\u0018\u00010\u00170\u00172\u0006\u0010\u0019\u001a\u00020\u001cH\u0096\u0001J \u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u001aH\u0016J \u0010&\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u001aH\u0002J9\u0010(\u001a\u00020\u00102\u000e\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00142\u000e\u0010\u0016\u001a\n \u0015*\u0004\u0018\u00010\u00170\u00172\u000e\u0010\u0019\u001a\n \u0015*\u0004\u0018\u00010\u001a0\u001aH\u0096\u0001R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lio/noties/markwon/scrollable/HorizontalScrollableMovementMethod;", "Landroid/text/method/MovementMethod;", "context", "Landroid/content/Context;", "delegate", "(Landroid/content/Context;Landroid/text/method/MovementMethod;)V", "flinger", "Lio/noties/markwon/scrollable/HorizontalScrollableMovementMethod$ViewFlinger;", "lastX", "", "maxVelocity", "scrollable", "Lio/noties/markwon/scrollable/HorizontalScrollable;", "tracker", "Landroid/view/VelocityTracker;", "canSelectArbitrarily", "", "initialize", "", "p0", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "p1", "Landroid/text/Spannable;", "onGenericMotionEvent", "p2", "Landroid/view/MotionEvent;", "onKeyDown", "", "p3", "Landroid/view/KeyEvent;", "onKeyOther", "onKeyUp", "onTakeFocus", "onTouchEvent", "widget", "text", "event", "onTouchEventInner", "buffer", "onTrackballEvent", "Companion", "ViewFlinger", "markwon-core_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class HorizontalScrollableMovementMethod implements MovementMethod {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final MovementMethod delegate;
    private final ViewFlinger flinger;
    private float lastX;
    private final float maxVelocity;
    private HorizontalScrollable scrollable;
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

    public HorizontalScrollableMovementMethod(Context context, MovementMethod movementMethod) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(movementMethod, "delegate");
        this.delegate = movementMethod;
        this.flinger = new ViewFlinger(context);
        Intrinsics.checkExpressionValueIsNotNull(ViewConfiguration.get(context), "ViewConfiguration.get(context)");
        this.maxVelocity = r2.getScaledMaximumFlingVelocity();
    }

    @Override // android.text.method.MovementMethod
    public boolean onTouchEvent(TextView widget, Spannable text, MotionEvent event) {
        Intrinsics.checkParameterIsNotNull(widget, "widget");
        Intrinsics.checkParameterIsNotNull(text, "text");
        Intrinsics.checkParameterIsNotNull(event, "event");
        onTouchEventInner(widget, text, event);
        return this.delegate.onTouchEvent(widget, text, event);
    }

    private final boolean onTouchEventInner(TextView widget, Spannable buffer, MotionEvent event) {
        int actionMasked = event.getActionMasked();
        if (actionMasked == 0) {
            this.flinger.stop();
            HorizontalScrollable[] horizontalScrollableArr = (HorizontalScrollable[]) INSTANCE.getTouchSpans(event, widget, HorizontalScrollable.class);
            HorizontalScrollable horizontalScrollable = horizontalScrollableArr != null ? (HorizontalScrollable) ArraysKt.firstOrNull(horizontalScrollableArr) : null;
            this.scrollable = horizontalScrollable;
            if (horizontalScrollable != null) {
                VelocityTracker velocityTracker = this.tracker;
                if (velocityTracker == null) {
                    this.tracker = VelocityTracker.obtain();
                } else if (velocityTracker != null) {
                    velocityTracker.clear();
                }
                VelocityTracker velocityTracker2 = this.tracker;
                if (velocityTracker2 != null) {
                    velocityTracker2.addMovement(event);
                }
            }
        } else {
            HorizontalScrollable horizontalScrollable2 = this.scrollable;
            if (horizontalScrollable2 != null && horizontalScrollable2.isScrollable()) {
                horizontalScrollable2.setScrollX$markwon_core_release(horizontalScrollable2.getScrollX() + (event.getX() - this.lastX));
                ViewCompat.postInvalidateOnAnimation(widget);
                VelocityTracker velocityTracker3 = this.tracker;
                if (velocityTracker3 != null) {
                    velocityTracker3.addMovement(event);
                }
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            HorizontalScrollable horizontalScrollable3 = this.scrollable;
            if (horizontalScrollable3 != null) {
                VelocityTracker velocityTracker4 = this.tracker;
                if (velocityTracker4 != null) {
                    velocityTracker4.computeCurrentVelocity(1000, this.maxVelocity);
                }
                ViewFlinger viewFlinger = this.flinger;
                TextView textView = widget;
                VelocityTracker velocityTracker5 = this.tracker;
                viewFlinger.fling(textView, horizontalScrollable3, velocityTracker5 != null ? MathKt.roundToInt(velocityTracker5.getXVelocity()) : 0);
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
    /* compiled from: HorizontalScrollableMovementMethod.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\nR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lio/noties/markwon/scrollable/HorizontalScrollableMovementMethod$ViewFlinger;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "animator", "Landroid/animation/ValueAnimator;", "scroller", "Landroid/widget/OverScroller;", "fling", "", "widget", "Landroid/view/View;", "scrollable", "Lio/noties/markwon/scrollable/HorizontalScrollable;", "velocityX", "", "stop", "markwon-core_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
    public static final class ViewFlinger {
        private ValueAnimator animator;
        private final OverScroller scroller;

        public ViewFlinger(Context context) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            this.scroller = new OverScroller(context, new Interpolator() { // from class: io.noties.markwon.scrollable.HorizontalScrollableMovementMethod$ViewFlinger$scroller$1
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
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: io.noties.markwon.scrollable.HorizontalScrollableMovementMethod$ViewFlinger$fling$$inlined$also$lambda$1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    OverScroller overScroller;
                    OverScroller overScroller2;
                    overScroller = HorizontalScrollableMovementMethod.ViewFlinger.this.scroller;
                    if (overScroller.computeScrollOffset()) {
                        HorizontalScrollable horizontalScrollable = scrollable;
                        overScroller2 = HorizontalScrollableMovementMethod.ViewFlinger.this.scroller;
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

    /* compiled from: HorizontalScrollableMovementMethod.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J7\u0010\u0003\u001a\n\u0012\u0004\u0012\u0002H\u0005\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000b¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lio/noties/markwon/scrollable/HorizontalScrollableMovementMethod$Companion;", "", "()V", "getTouchSpans", "", "T", "event", "Landroid/view/MotionEvent;", "widget", "Landroid/widget/TextView;", "span", "Ljava/lang/Class;", "(Landroid/view/MotionEvent;Landroid/widget/TextView;Ljava/lang/Class;)[Ljava/lang/Object;", "markwon-core_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final <T> T[] getTouchSpans(MotionEvent event, TextView widget, Class<T> span) {
            Intrinsics.checkParameterIsNotNull(event, "event");
            Intrinsics.checkParameterIsNotNull(widget, "widget");
            Intrinsics.checkParameterIsNotNull(span, "span");
            float x = event.getX();
            float totalPaddingLeft = (x - widget.getTotalPaddingLeft()) + widget.getScrollX();
            float y = (event.getY() - widget.getTotalPaddingTop()) + widget.getScrollY();
            Layout layout = widget.getLayout();
            CharSequence text = widget.getText();
            if (layout == null || !(text instanceof Spanned)) {
                return null;
            }
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical((int) y), totalPaddingLeft);
            return (T[]) ((Spanned) text).getSpans(offsetForHorizontal, offsetForHorizontal, span);
        }
    }
}
