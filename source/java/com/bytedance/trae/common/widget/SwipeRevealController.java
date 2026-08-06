package com.bytedance.trae.common.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.trae.common.widget.SwipeRevealController;
import com.bytedance.trae.common.widget.SwipeRevealGestureState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SwipeRevealController.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 92\u00020\u0001:\u000289B\u007f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\"\u001a\u00020\u000e2\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0007J \u0010$\u001a\u00020\u000e2\u0016\b\u0002\u0010#\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u000e\u0018\u00010%H\u0007J\u000e\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020)J\b\u0010*\u001a\u00020&H\u0002J\b\u0010+\u001a\u00020\u000eH\u0002J\b\u0010,\u001a\u00020\u000eH\u0002J\u0006\u0010-\u001a\u00020\u000eJ\u0006\u0010.\u001a\u00020\u000eJ\u0006\u0010/\u001a\u00020\u000eJ\u0018\u00100\u001a\u00020\u000e2\u0006\u00101\u001a\u00020\n2\u0006\u00102\u001a\u00020\u001aH\u0002J\u0012\u00103\u001a\u00020\u000e2\b\b\u0002\u00104\u001a\u00020\u001aH\u0002J\u0018\u00105\u001a\u00020\u000e2\u0006\u00101\u001a\u00020\n2\u0006\u00102\u001a\u00020\u001aH\u0002J\b\u00106\u001a\u00020\nH\u0002J\b\u00107\u001a\u00020\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001d\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001eR\u0011\u0010 \u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b!\u0010\u001e¨\u0006:"}, d2 = {"Lcom/bytedance/trae/common/widget/SwipeRevealController;", "", "contentView", "Landroid/view/View;", "actionsView", "closedActionsVisibility", "", "animationDurationMs", "", "touchSlop", "", "dampingFactor", "onDragStarted", "Lkotlin/Function0;", "", "onCancelPendingLongPress", "onOpened", "onClosed", "<init>", "(Landroid/view/View;Landroid/view/View;IJFFLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "state", "Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;", "animator", "Landroid/animation/ValueAnimator;", "animationTargetTranslationX", "animationTargetShouldOpen", "", "lastTouchRawX", "lastTouchRawY", "isOpen", "()Z", "isDragging", "canTriggerLongPress", "getCanTriggerLongPress", "attachToContent", "onLongPress", "attachToContentWithTouch", "Lkotlin/Function1;", "Lcom/bytedance/trae/common/widget/SwipeRevealController$LongPressTouch;", "handleTouch", "event", "Landroid/view/MotionEvent;", "currentLongPressTouch", "clearLastTouchRaw", "cancelPendingLongPress", "animateOpen", "animateClose", "reset", "animateTo", "targetTranslationX", "shouldOpen", "cancelAnimator", "settleToTarget", "settleAnimationTarget", "revealWidth", "measureActionsWidth", "LongPressTouch", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SwipeRevealController {
    private static final float DEFAULT_DAMPING_FACTOR = 0.45f;
    private final View actionsView;
    private final long animationDurationMs;
    private boolean animationTargetShouldOpen;
    private float animationTargetTranslationX;
    private ValueAnimator animator;
    private final int closedActionsVisibility;
    private final View contentView;
    private float lastTouchRawX;
    private float lastTouchRawY;
    private final Function0<Unit> onCancelPendingLongPress;
    private final Function0<Unit> onClosed;
    private final Function0<Unit> onDragStarted;
    private final Function0<Unit> onOpened;
    private final SwipeRevealGestureState state;

    public SwipeRevealController(View contentView, View actionsView, int i, long j, float f, float f2, Function0<Unit> onDragStarted, Function0<Unit> onCancelPendingLongPress, Function0<Unit> onOpened, Function0<Unit> onClosed) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        Intrinsics.checkNotNullParameter(actionsView, "actionsView");
        Intrinsics.checkNotNullParameter(onDragStarted, "onDragStarted");
        Intrinsics.checkNotNullParameter(onCancelPendingLongPress, "onCancelPendingLongPress");
        Intrinsics.checkNotNullParameter(onOpened, "onOpened");
        Intrinsics.checkNotNullParameter(onClosed, "onClosed");
        this.contentView = contentView;
        this.actionsView = actionsView;
        this.closedActionsVisibility = i;
        this.animationDurationMs = j;
        this.onDragStarted = onDragStarted;
        this.onCancelPendingLongPress = onCancelPendingLongPress;
        this.onOpened = onOpened;
        this.onClosed = onClosed;
        this.state = new SwipeRevealGestureState(f, f2);
        this.lastTouchRawX = Float.NaN;
        this.lastTouchRawY = Float.NaN;
    }

    public /* synthetic */ SwipeRevealController(View view, View view2, int i, long j, float f, float f2, Function0 function0, Function0 function02, Function0 function03, Function0 function04, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, view2, (i2 & 4) != 0 ? 4 : i, (i2 & 8) != 0 ? 200L : j, (i2 & 16) != 0 ? ViewConfiguration.get(view.getContext()).getScaledTouchSlop() : f, (i2 & 32) != 0 ? 0.45f : f2, (i2 & 64) != 0 ? new Function0() { // from class: com.bytedance.trae.common.widget.SwipeRevealController$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        } : function0, (i2 & 128) != 0 ? new Function0() { // from class: com.bytedance.trae.common.widget.SwipeRevealController$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        } : function02, (i2 & 256) != 0 ? new Function0() { // from class: com.bytedance.trae.common.widget.SwipeRevealController$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        } : function03, (i2 & 512) != 0 ? new Function0() { // from class: com.bytedance.trae.common.widget.SwipeRevealController$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        } : function04);
    }

    /* compiled from: SwipeRevealController.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/common/widget/SwipeRevealController$LongPressTouch;", "", "rawX", "", "rawY", "<init>", "(FF)V", "getRawX", "()F", "getRawY", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "common-ui_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class LongPressTouch {
        private final float rawX;
        private final float rawY;

        public static /* synthetic */ LongPressTouch copy$default(LongPressTouch longPressTouch, float f, float f2, int i, Object obj) {
            if ((i & 1) != 0) {
                f = longPressTouch.rawX;
            }
            if ((i & 2) != 0) {
                f2 = longPressTouch.rawY;
            }
            return longPressTouch.copy(f, f2);
        }

        /* renamed from: component1, reason: from getter */
        public final float getRawX() {
            return this.rawX;
        }

        /* renamed from: component2, reason: from getter */
        public final float getRawY() {
            return this.rawY;
        }

        public final LongPressTouch copy(float rawX, float rawY) {
            return new LongPressTouch(rawX, rawY);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LongPressTouch)) {
                return false;
            }
            LongPressTouch longPressTouch = (LongPressTouch) other;
            return Float.compare(this.rawX, longPressTouch.rawX) == 0 && Float.compare(this.rawY, longPressTouch.rawY) == 0;
        }

        public int hashCode() {
            return (Float.hashCode(this.rawX) * 31) + Float.hashCode(this.rawY);
        }

        public String toString() {
            return "LongPressTouch(rawX=" + this.rawX + ", rawY=" + this.rawY + ')';
        }

        public LongPressTouch(float f, float f2) {
            this.rawX = f;
            this.rawY = f2;
        }

        public final float getRawX() {
            return this.rawX;
        }

        public final float getRawY() {
            return this.rawY;
        }
    }

    public final boolean isOpen() {
        return this.state.getIsOpen();
    }

    public final boolean isDragging() {
        return this.state.getIsDragging();
    }

    public final boolean getCanTriggerLongPress() {
        return this.state.getCanTriggerLongPress() && this.animator == null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void attachToContent$default(SwipeRevealController swipeRevealController, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        swipeRevealController.attachToContent(function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit attachToContent$lambda$5$lambda$4(Function0 function0, LongPressTouch it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function0.invoke();
        return Unit.INSTANCE;
    }

    public final void attachToContent(final Function0<Unit> onLongPress) {
        attachToContentWithTouch(onLongPress != null ? new Function1() { // from class: com.bytedance.trae.common.widget.SwipeRevealController$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit attachToContent$lambda$5$lambda$4;
                attachToContent$lambda$5$lambda$4 = SwipeRevealController.attachToContent$lambda$5$lambda$4(Function0.this, (SwipeRevealController.LongPressTouch) obj);
                return attachToContent$lambda$5$lambda$4;
            }
        } : null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void attachToContentWithTouch$default(SwipeRevealController swipeRevealController, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        swipeRevealController.attachToContentWithTouch(function1);
    }

    public final void attachToContentWithTouch(final Function1<? super LongPressTouch, Unit> onLongPress) {
        this.contentView.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.trae.common.widget.SwipeRevealController$$ExternalSyntheticLambda2
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean attachToContentWithTouch$lambda$6;
                attachToContentWithTouch$lambda$6 = SwipeRevealController.attachToContentWithTouch$lambda$6(SwipeRevealController.this, view, motionEvent);
                return attachToContentWithTouch$lambda$6;
            }
        });
        this.contentView.setOnLongClickListener(onLongPress != null ? new View.OnLongClickListener() { // from class: com.bytedance.trae.common.widget.SwipeRevealController$$ExternalSyntheticLambda3
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean attachToContentWithTouch$lambda$8$lambda$7;
                attachToContentWithTouch$lambda$8$lambda$7 = SwipeRevealController.attachToContentWithTouch$lambda$8$lambda$7(SwipeRevealController.this, onLongPress, view);
                return attachToContentWithTouch$lambda$8$lambda$7;
            }
        } : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean attachToContentWithTouch$lambda$6(SwipeRevealController swipeRevealController, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNull(motionEvent);
        return swipeRevealController.handleTouch(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean attachToContentWithTouch$lambda$8$lambda$7(SwipeRevealController swipeRevealController, Function1 function1, View view) {
        if (swipeRevealController.getCanTriggerLongPress()) {
            function1.invoke(swipeRevealController.currentLongPressTouch());
            return true;
        }
        swipeRevealController.cancelPendingLongPress();
        return true;
    }

    public final boolean handleTouch(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int actionMasked = event.getActionMasked();
        if (actionMasked == 0) {
            this.lastTouchRawX = event.getRawX();
            this.lastTouchRawY = event.getRawY();
            cancelAnimator(true);
            this.state.onDown(event.getRawX(), event.getRawY());
            ViewParent parent = this.contentView.getParent();
            if (parent == null) {
                return false;
            }
            parent.requestDisallowInterceptTouchEvent(false);
            return false;
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                SwipeRevealGestureState.MoveResult onMove = this.state.onMove(event.getRawX(), event.getRawY(), revealWidth());
                if (onMove.getDragStarted()) {
                    this.actionsView.setVisibility(0);
                    this.onDragStarted.invoke();
                    ViewParent parent2 = this.contentView.getParent();
                    if (parent2 != null) {
                        parent2.requestDisallowInterceptTouchEvent(true);
                    }
                    cancelPendingLongPress();
                }
                if (onMove.isDragging()) {
                    this.actionsView.setVisibility(0);
                    this.contentView.setTranslationX(onMove.getTranslationX());
                    cancelPendingLongPress();
                }
                return onMove.isDragging();
            }
            if (actionMasked != 3) {
                return this.state.getIsDragging();
            }
        }
        SwipeRevealGestureState.ReleaseResult onRelease = this.state.onRelease(revealWidth());
        if (onRelease.getWasDragging()) {
            cancelPendingLongPress();
            animateTo(onRelease.getTargetTranslationX(), onRelease.getShouldOpen());
        }
        ViewParent parent3 = this.contentView.getParent();
        if (parent3 != null) {
            parent3.requestDisallowInterceptTouchEvent(false);
        }
        clearLastTouchRaw();
        return onRelease.getWasDragging();
    }

    private final LongPressTouch currentLongPressTouch() {
        if (!Float.isNaN(this.lastTouchRawX) && !Float.isNaN(this.lastTouchRawY)) {
            return new LongPressTouch(this.lastTouchRawX, this.lastTouchRawY);
        }
        this.contentView.getLocationOnScreen(new int[2]);
        return new LongPressTouch(r0[0] + (this.contentView.getWidth() / 2.0f), r0[1] + (this.contentView.getHeight() / 2.0f));
    }

    private final void clearLastTouchRaw() {
        this.lastTouchRawX = Float.NaN;
        this.lastTouchRawY = Float.NaN;
    }

    private final void cancelPendingLongPress() {
        this.contentView.cancelLongPress();
        this.contentView.setPressed(false);
        this.contentView.jumpDrawablesToCurrentState();
        this.onCancelPendingLongPress.invoke();
    }

    public final void animateOpen() {
        this.state.setOpen(revealWidth());
        this.actionsView.setVisibility(0);
        animateTo(this.state.getTranslationX(), true);
    }

    public final void animateClose() {
        this.state.setClosed();
        animateTo(0.0f, false);
    }

    public final void reset() {
        cancelAnimator$default(this, false, 1, null);
        this.state.setClosed();
        this.contentView.setTranslationX(0.0f);
        this.actionsView.setVisibility(this.closedActionsVisibility);
        this.onClosed.invoke();
    }

    private final void animateTo(final float targetTranslationX, final boolean shouldOpen) {
        cancelAnimator$default(this, false, 1, null);
        this.animationTargetTranslationX = targetTranslationX;
        this.animationTargetShouldOpen = shouldOpen;
        if (shouldOpen) {
            this.actionsView.setVisibility(0);
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.contentView.getTranslationX(), targetTranslationX);
        ofFloat.setDuration(this.animationDurationMs);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.trae.common.widget.SwipeRevealController$$ExternalSyntheticLambda1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SwipeRevealController.animateTo$lambda$10$lambda$9(SwipeRevealController.this, valueAnimator);
            }
        });
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.trae.common.widget.SwipeRevealController$animateTo$1$2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                SwipeRevealController.this.settleAnimationTarget(targetTranslationX, shouldOpen);
                SwipeRevealController.this.animator = null;
            }
        });
        this.animator = ofFloat;
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateTo$lambda$10$lambda$9(SwipeRevealController swipeRevealController, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        View view = swipeRevealController.contentView;
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        view.setTranslationX(((Float) animatedValue).floatValue());
    }

    static /* synthetic */ void cancelAnimator$default(SwipeRevealController swipeRevealController, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        swipeRevealController.cancelAnimator(z);
    }

    private final void cancelAnimator(boolean settleToTarget) {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator == null) {
            return;
        }
        valueAnimator.removeAllUpdateListeners();
        valueAnimator.removeAllListeners();
        valueAnimator.cancel();
        this.animator = null;
        if (settleToTarget) {
            settleAnimationTarget(this.animationTargetTranslationX, this.animationTargetShouldOpen);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void settleAnimationTarget(float targetTranslationX, boolean shouldOpen) {
        this.contentView.setTranslationX(targetTranslationX);
        if (shouldOpen) {
            this.actionsView.setVisibility(0);
            this.onOpened.invoke();
        } else {
            this.actionsView.setVisibility(this.closedActionsVisibility);
            this.onClosed.invoke();
        }
    }

    private final float revealWidth() {
        int measureActionsWidth;
        Integer valueOf = Integer.valueOf(this.actionsView.getWidth());
        if (!(valueOf.intValue() > 0)) {
            valueOf = null;
        }
        if (valueOf != null) {
            measureActionsWidth = valueOf.intValue();
        } else {
            Integer valueOf2 = Integer.valueOf(this.actionsView.getMeasuredWidth());
            Integer num = valueOf2.intValue() > 0 ? valueOf2 : null;
            if (num != null) {
                measureActionsWidth = num.intValue();
            } else {
                measureActionsWidth = measureActionsWidth();
            }
        }
        return Math.max(0.0f, measureActionsWidth);
    }

    private final int measureActionsWidth() {
        int makeMeasureSpec;
        if (this.actionsView.getHeight() > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.actionsView.getHeight(), 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        this.actionsView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
        return this.actionsView.getMeasuredWidth();
    }
}
