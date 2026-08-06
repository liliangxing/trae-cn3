package com.bytedance.trae.common.widget;

import com.bytedance.forest.model.PreloadConfig;
import com.lynx.animax.monitor.AnimaXMonitorUtil;
import kotlin.Metadata;

/* compiled from: SwipeRevealController.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000  2\u00020\u0001:\u0003\u001e\u001f B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003J\u001e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u0003J\u000e\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0003J\u0006\u0010\u001d\u001a\u00020\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u001e\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\nR\u000e\u0010\u0011\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;", "", "touchSlop", "", "dampingFactor", "<init>", "(FF)V", "value", "", "isDragging", "()Z", "isOpen", "translationX", "getTranslationX", "()F", "canTriggerLongPress", "getCanTriggerLongPress", "startX", "startY", "onDown", "", "rawX", "rawY", "onMove", "Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$MoveResult;", "revealWidth", AnimaXMonitorUtil.TRIGGER_ON_RELEASE, "Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$ReleaseResult;", "setOpen", "setClosed", "MoveResult", "ReleaseResult", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SwipeRevealGestureState {
    private static final float HORIZONTAL_DRAG_RATIO = 1.5f;
    private static final float RELEASE_THRESHOLD_DIVISOR = 3.0f;
    private final float dampingFactor;
    private boolean isDragging;
    private boolean isOpen;
    private float startX;
    private float startY;
    private final float touchSlop;
    private float translationX;

    public SwipeRevealGestureState(float f, float f2) {
        this.touchSlop = f;
        this.dampingFactor = f2;
    }

    /* renamed from: isDragging, reason: from getter */
    public final boolean getIsDragging() {
        return this.isDragging;
    }

    /* renamed from: isOpen, reason: from getter */
    public final boolean getIsOpen() {
        return this.isOpen;
    }

    public final float getTranslationX() {
        return this.translationX;
    }

    public final boolean getCanTriggerLongPress() {
        return (this.isDragging || this.isOpen) ? false : true;
    }

    public final void onDown(float rawX, float rawY) {
        this.startX = rawX;
        this.startY = rawY;
        this.isDragging = false;
    }

    public final MoveResult onMove(float rawX, float rawY, float revealWidth) {
        boolean z;
        float f = rawX - this.startX;
        float f2 = rawY - this.startY;
        float max = Math.max(0.0f, revealWidth);
        if (this.isDragging || Math.abs(f) <= this.touchSlop || Math.abs(f) <= Math.abs(f2) * HORIZONTAL_DRAG_RATIO) {
            z = false;
        } else {
            z = true;
            this.isDragging = true;
        }
        if (this.isDragging) {
            this.translationX = Math.min(0.0f, Math.max(-max, (this.isOpen ? -max : 0.0f) + (f * this.dampingFactor)));
        }
        return new MoveResult(this.isDragging, z, this.translationX);
    }

    public final ReleaseResult onRelease(float revealWidth) {
        boolean z;
        boolean z2 = this.isDragging;
        float max = Math.max(0.0f, revealWidth);
        float f = max / RELEASE_THRESHOLD_DIVISOR;
        if (z2) {
            z = true;
            if (!this.isOpen ? this.translationX >= (-f) : this.translationX > (-max) + f) {
                z = false;
            }
        } else {
            z = this.isOpen;
        }
        this.isDragging = false;
        this.isOpen = z;
        this.translationX = z ? -max : 0.0f;
        return new ReleaseResult(z2, z, this.translationX);
    }

    public final void setOpen(float revealWidth) {
        this.isDragging = false;
        this.isOpen = true;
        this.translationX = -Math.max(0.0f, revealWidth);
    }

    public final void setClosed() {
        this.isDragging = false;
        this.isOpen = false;
        this.translationX = 0.0f;
    }

    /* compiled from: SwipeRevealController.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$MoveResult;", "", "isDragging", "", "dragStarted", "translationX", "", "<init>", "(ZZF)V", "()Z", "getDragStarted", "getTranslationX", "()F", "component1", "component2", "component3", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "common-ui_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class MoveResult {
        private final boolean dragStarted;
        private final boolean isDragging;
        private final float translationX;

        public static /* synthetic */ MoveResult copy$default(MoveResult moveResult, boolean z, boolean z2, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                z = moveResult.isDragging;
            }
            if ((i & 2) != 0) {
                z2 = moveResult.dragStarted;
            }
            if ((i & 4) != 0) {
                f = moveResult.translationX;
            }
            return moveResult.copy(z, z2, f);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsDragging() {
            return this.isDragging;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getDragStarted() {
            return this.dragStarted;
        }

        /* renamed from: component3, reason: from getter */
        public final float getTranslationX() {
            return this.translationX;
        }

        public final MoveResult copy(boolean isDragging, boolean dragStarted, float translationX) {
            return new MoveResult(isDragging, dragStarted, translationX);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MoveResult)) {
                return false;
            }
            MoveResult moveResult = (MoveResult) other;
            return this.isDragging == moveResult.isDragging && this.dragStarted == moveResult.dragStarted && Float.compare(this.translationX, moveResult.translationX) == 0;
        }

        public int hashCode() {
            return (((Boolean.hashCode(this.isDragging) * 31) + Boolean.hashCode(this.dragStarted)) * 31) + Float.hashCode(this.translationX);
        }

        public String toString() {
            return "MoveResult(isDragging=" + this.isDragging + ", dragStarted=" + this.dragStarted + ", translationX=" + this.translationX + ')';
        }

        public MoveResult(boolean z, boolean z2, float f) {
            this.isDragging = z;
            this.dragStarted = z2;
            this.translationX = f;
        }

        public final boolean isDragging() {
            return this.isDragging;
        }

        public final boolean getDragStarted() {
            return this.dragStarted;
        }

        public final float getTranslationX() {
            return this.translationX;
        }
    }

    /* compiled from: SwipeRevealController.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$ReleaseResult;", "", "wasDragging", "", "shouldOpen", "targetTranslationX", "", "<init>", "(ZZF)V", "getWasDragging", "()Z", "getShouldOpen", "getTargetTranslationX", "()F", "component1", "component2", "component3", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "common-ui_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class ReleaseResult {
        private final boolean shouldOpen;
        private final float targetTranslationX;
        private final boolean wasDragging;

        public static /* synthetic */ ReleaseResult copy$default(ReleaseResult releaseResult, boolean z, boolean z2, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                z = releaseResult.wasDragging;
            }
            if ((i & 2) != 0) {
                z2 = releaseResult.shouldOpen;
            }
            if ((i & 4) != 0) {
                f = releaseResult.targetTranslationX;
            }
            return releaseResult.copy(z, z2, f);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getWasDragging() {
            return this.wasDragging;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getShouldOpen() {
            return this.shouldOpen;
        }

        /* renamed from: component3, reason: from getter */
        public final float getTargetTranslationX() {
            return this.targetTranslationX;
        }

        public final ReleaseResult copy(boolean wasDragging, boolean shouldOpen, float targetTranslationX) {
            return new ReleaseResult(wasDragging, shouldOpen, targetTranslationX);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReleaseResult)) {
                return false;
            }
            ReleaseResult releaseResult = (ReleaseResult) other;
            return this.wasDragging == releaseResult.wasDragging && this.shouldOpen == releaseResult.shouldOpen && Float.compare(this.targetTranslationX, releaseResult.targetTranslationX) == 0;
        }

        public int hashCode() {
            return (((Boolean.hashCode(this.wasDragging) * 31) + Boolean.hashCode(this.shouldOpen)) * 31) + Float.hashCode(this.targetTranslationX);
        }

        public String toString() {
            return "ReleaseResult(wasDragging=" + this.wasDragging + ", shouldOpen=" + this.shouldOpen + ", targetTranslationX=" + this.targetTranslationX + ')';
        }

        public ReleaseResult(boolean z, boolean z2, float f) {
            this.wasDragging = z;
            this.shouldOpen = z2;
            this.targetTranslationX = f;
        }

        public final boolean getWasDragging() {
            return this.wasDragging;
        }

        public final boolean getShouldOpen() {
            return this.shouldOpen;
        }

        public final float getTargetTranslationX() {
            return this.targetTranslationX;
        }
    }
}
