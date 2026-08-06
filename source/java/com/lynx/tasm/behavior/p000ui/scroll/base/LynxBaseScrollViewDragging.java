package com.lynx.tasm.behavior.p000ui.scroll.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewDragging;
import com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewScroller;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxBaseScrollViewDragging extends LynxBaseScrollViewScrolling implements LynxBaseScrollViewInternal {
    protected final LynxBaseScrollViewDraggingConfig mConfig;
    protected final LynxBaseScrollViewDraggingScrollInfo mScrollInfo;

    @Override // com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewInternal
    public int[] dispatchScroll(int i, int i2, int i3, MotionEvent motionEvent, int[] iArr) {
        return new int[2];
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewInternal
    public View getView() {
        return this;
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewInternal
    public boolean startNestedScroll(int i, int i2) {
        return false;
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewInternal
    public void stopNestedScroll(int i) {
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewInternal
    public boolean isBouncingForwards(int i, int[] iArr) {
        return i > iArr[1];
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewInternal
    public boolean isBouncingBackwards(int i, int[] iArr) {
        return i < iArr[0];
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewInternal
    public boolean isVertical() {
        return this.mIsVertical;
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewInternal
    public int[] getFlingRange(boolean z) {
        int i;
        int i2;
        int scrollOffsetVertically = z ? getScrollOffsetVertically() : getScrollOffsetHorizontally();
        int[] scrollRangeVertically = z ? getScrollRangeVertically() : getScrollRangeHorizontally();
        if (bounces()) {
            int i3 = scrollRangeVertically[0];
            i = scrollOffsetVertically < i3 ? scrollOffsetVertically - 50 : i3 - 300;
        } else {
            i = scrollRangeVertically[0];
        }
        if (bounces()) {
            int i4 = scrollRangeVertically[1];
            i2 = scrollOffsetVertically > i4 ? scrollOffsetVertically + 50 : i4 + 300;
        } else {
            i2 = scrollRangeVertically[1];
        }
        return new int[]{i, i2};
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    static class LynxBaseScrollViewDraggingConfig {
        protected final int maxFlingVelocity;
        protected final int minFlingVelocity;
        protected final int touchSlop;

        public LynxBaseScrollViewDraggingConfig(int i, int i2, int i3) {
            this.touchSlop = i;
            this.minFlingVelocity = i2;
            this.maxFlingVelocity = i3;
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class LynxBaseScrollViewDraggingScrollInfo {
        private int initialMotionX;
        private int initialMotionY;
        private int lastMotionX;
        private int lastMotionY;
        private VelocityTracker velocityTracker;
        private int activePointerId = -1;
        private final int[] scrollConsumed = new int[2];
        private final int[] offsetInWindow = new int[2];
        private final int[] scrollStepConsumed = new int[2];
        private final int[] targetScrollOffset = new int[2];

        public LynxBaseScrollViewDraggingScrollInfo() {
        }
    }

    public LynxBaseScrollViewDragging(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mScrollInfo = new LynxBaseScrollViewDraggingScrollInfo();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mConfig = new LynxBaseScrollViewDraggingConfig(viewConfiguration.getScaledWindowTouchSlop(), viewConfiguration.getScaledMinimumFlingVelocity(), viewConfiguration.getScaledMaximumFlingVelocity());
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.mScrollInfo.velocityTracker == null) {
            this.mScrollInfo.velocityTracker = VelocityTracker.obtain();
        }
        this.mScrollInfo.velocityTracker.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.mScrollInfo.activePointerId = motionEvent.getPointerId(0);
            LynxBaseScrollViewDraggingScrollInfo lynxBaseScrollViewDraggingScrollInfo = this.mScrollInfo;
            lynxBaseScrollViewDraggingScrollInfo.initialMotionX = lynxBaseScrollViewDraggingScrollInfo.lastMotionX = (int) (motionEvent.getX() + 0.5f);
            LynxBaseScrollViewDraggingScrollInfo lynxBaseScrollViewDraggingScrollInfo2 = this.mScrollInfo;
            lynxBaseScrollViewDraggingScrollInfo2.initialMotionY = lynxBaseScrollViewDraggingScrollInfo2.lastMotionY = (int) (motionEvent.getY() + 0.5f);
            if (this.mScrollState == 3 || this.mScrollState == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                tryToUpdateScrollState(1);
            }
            startNestedScroll(getNestedScrollAxis(), 0);
        } else if (actionMasked == 1) {
            this.mScrollInfo.velocityTracker.clear();
            stopNestedScroll(0);
        } else if (actionMasked != 2) {
            if (actionMasked == 3) {
                resetTouch();
                tryToUpdateScrollState(0);
            } else if (actionMasked == 5) {
                this.mScrollInfo.activePointerId = motionEvent.getPointerId(0);
                LynxBaseScrollViewDraggingScrollInfo lynxBaseScrollViewDraggingScrollInfo3 = this.mScrollInfo;
                lynxBaseScrollViewDraggingScrollInfo3.initialMotionX = lynxBaseScrollViewDraggingScrollInfo3.lastMotionX = (int) (motionEvent.getX() + 0.5f);
                LynxBaseScrollViewDraggingScrollInfo lynxBaseScrollViewDraggingScrollInfo4 = this.mScrollInfo;
                lynxBaseScrollViewDraggingScrollInfo4.initialMotionY = lynxBaseScrollViewDraggingScrollInfo4.lastMotionY = (int) (motionEvent.getY() + 0.5f);
            } else if (actionMasked == 6) {
                int actionIndex = motionEvent.getActionIndex();
                if (motionEvent.getPointerId(actionIndex) == this.mScrollInfo.activePointerId) {
                    int i = actionIndex == 0 ? 1 : 0;
                    this.mScrollInfo.activePointerId = motionEvent.getPointerId(i);
                    LynxBaseScrollViewDraggingScrollInfo lynxBaseScrollViewDraggingScrollInfo5 = this.mScrollInfo;
                    lynxBaseScrollViewDraggingScrollInfo5.initialMotionX = lynxBaseScrollViewDraggingScrollInfo5.lastMotionX = (int) (motionEvent.getX(i) + 0.5f);
                    LynxBaseScrollViewDraggingScrollInfo lynxBaseScrollViewDraggingScrollInfo6 = this.mScrollInfo;
                    lynxBaseScrollViewDraggingScrollInfo6.initialMotionY = lynxBaseScrollViewDraggingScrollInfo6.lastMotionY = (int) (motionEvent.getY(i) + 0.5f);
                }
            }
        } else if (this.mScrollInfo.activePointerId != -1) {
            int findPointerIndex = motionEvent.findPointerIndex(this.mScrollInfo.activePointerId);
            if (findPointerIndex < 0) {
                return false;
            }
            int x = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            if (this.mScrollState != 1) {
                int i2 = x - this.mScrollInfo.initialMotionX;
                boolean z = this.mIsVertical && Math.abs(y - this.mScrollInfo.initialMotionY) > this.mConfig.touchSlop && (2 & getNestedScrollAxes()) == 0;
                boolean z2 = !this.mIsVertical && Math.abs(i2) > this.mConfig.touchSlop && (getNestedScrollAxes() & 1) == 0;
                if (z || z2) {
                    this.mScrollInfo.lastMotionX = x;
                    this.mScrollInfo.lastMotionY = y;
                    tryToUpdateScrollState(1);
                }
            }
        }
        return this.mScrollState == 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mScrollInfo.velocityTracker == null) {
            this.mScrollInfo.velocityTracker = VelocityTracker.obtain();
        }
        int actionMasked = motionEvent.getActionMasked();
        boolean z = false;
        if (actionMasked == 0) {
            int[] iArr = this.mScrollInfo.offsetInWindow;
            this.mScrollInfo.offsetInWindow[1] = 0;
            iArr[0] = 0;
            this.mScrollHelper.stopAnimating(false);
            startNestedScroll(getNestedScrollAxis(), 0);
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(this.mScrollInfo.offsetInWindow[0], this.mScrollInfo.offsetInWindow[1]);
        if (actionMasked == 0) {
            this.mScrollInfo.activePointerId = motionEvent.getPointerId(0);
            LynxBaseScrollViewDraggingScrollInfo lynxBaseScrollViewDraggingScrollInfo = this.mScrollInfo;
            lynxBaseScrollViewDraggingScrollInfo.initialMotionX = lynxBaseScrollViewDraggingScrollInfo.lastMotionX = (int) (motionEvent.getX() + 0.5f);
            LynxBaseScrollViewDraggingScrollInfo lynxBaseScrollViewDraggingScrollInfo2 = this.mScrollInfo;
            lynxBaseScrollViewDraggingScrollInfo2.initialMotionY = lynxBaseScrollViewDraggingScrollInfo2.lastMotionY = (int) (motionEvent.getY() + 0.5f);
        } else if (actionMasked == 1) {
            this.mScrollInfo.velocityTracker.addMovement(obtain);
            this.mScrollInfo.velocityTracker.computeCurrentVelocity(1000, this.mConfig.maxFlingVelocity);
            float f = !this.mIsVertical ? -this.mScrollInfo.velocityTracker.getXVelocity(this.mScrollInfo.activePointerId) : 0.0f;
            float f2 = this.mIsVertical ? -this.mScrollInfo.velocityTracker.getYVelocity(this.mScrollInfo.activePointerId) : 0.0f;
            if (((Math.abs(f) < 600.0f) & (!this.mIsVertical)) || (Math.abs(f2) < 600.0f && this.mIsVertical)) {
                if (this.mScrollHelper.tryBouncesBack((LynxBaseScrollViewNestedInternal) this, this.mIsVertical, new LynxBaseScrollViewScroller.ScrollFinishedCallback() { // from class: com.lynx.tasm.behavior.ui.scroll.base.LynxBaseScrollViewDragging.1
                    @Override // com.lynx.tasm.behavior.ui.scroll.base.LynxBaseScrollViewScroller.ScrollFinishedCallback
                    public void finished(boolean z2) {
                        if (z2) {
                            LynxBaseScrollViewDragging.this.tryToUpdateScrollState(0);
                        }
                    }
                })) {
                    tryToUpdateScrollState(3);
                } else {
                    tryToUpdateScrollState(0);
                }
            } else {
                this.mScrollHelper.fling((int) f, (int) f2, new C01272((LynxBaseScrollViewNestedInternal) this));
                tryToUpdateScrollState(3);
            }
            resetTouch();
            z = true;
        } else if (actionMasked != 2) {
            if (actionMasked == 3) {
                resetTouch();
                tryToUpdateScrollState(0);
            } else if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                this.mScrollInfo.activePointerId = motionEvent.getPointerId(actionIndex);
                LynxBaseScrollViewDraggingScrollInfo lynxBaseScrollViewDraggingScrollInfo3 = this.mScrollInfo;
                lynxBaseScrollViewDraggingScrollInfo3.initialMotionX = lynxBaseScrollViewDraggingScrollInfo3.lastMotionX = (int) (motionEvent.getX(actionIndex) + 0.5f);
                LynxBaseScrollViewDraggingScrollInfo lynxBaseScrollViewDraggingScrollInfo4 = this.mScrollInfo;
                lynxBaseScrollViewDraggingScrollInfo4.initialMotionY = lynxBaseScrollViewDraggingScrollInfo4.lastMotionY = (int) (motionEvent.getY(actionIndex) + 0.5f);
            } else if (actionMasked == 6) {
                int actionIndex2 = motionEvent.getActionIndex();
                if (motionEvent.getPointerId(actionIndex2) == this.mScrollInfo.activePointerId) {
                    int i = actionIndex2 == 0 ? 1 : 0;
                    this.mScrollInfo.activePointerId = motionEvent.getPointerId(i);
                    LynxBaseScrollViewDraggingScrollInfo lynxBaseScrollViewDraggingScrollInfo5 = this.mScrollInfo;
                    lynxBaseScrollViewDraggingScrollInfo5.initialMotionX = lynxBaseScrollViewDraggingScrollInfo5.lastMotionX = (int) (motionEvent.getX(i) + 0.5f);
                    LynxBaseScrollViewDraggingScrollInfo lynxBaseScrollViewDraggingScrollInfo6 = this.mScrollInfo;
                    lynxBaseScrollViewDraggingScrollInfo6.initialMotionY = lynxBaseScrollViewDraggingScrollInfo6.lastMotionY = (int) (motionEvent.getY(i) + 0.5f);
                }
            }
        } else if (this.mScrollInfo.activePointerId != -1) {
            int findPointerIndex = motionEvent.findPointerIndex(this.mScrollInfo.activePointerId);
            if (findPointerIndex < 0) {
                return false;
            }
            int x = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            int i2 = this.mScrollInfo.lastMotionX - x;
            int i3 = this.mScrollInfo.lastMotionY - y;
            boolean z2 = this.mScrollState == 1;
            if (!z2) {
                if (this.mIsVertical && Math.abs(i3) > this.mConfig.touchSlop) {
                    i3 = i3 > 0 ? i3 - this.mConfig.touchSlop : i3 + this.mConfig.touchSlop;
                } else if (!this.mIsVertical && Math.abs(i2) > this.mConfig.touchSlop) {
                    i2 = i2 > 0 ? i2 - this.mConfig.touchSlop : i2 + this.mConfig.touchSlop;
                }
                z2 = true;
            }
            int i4 = i3;
            if (z2) {
                if (getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                tryToUpdateScrollState(1);
                int[] iArr2 = {0, 0};
                int[] dispatchScroll = dispatchScroll(this.mIsVertical ? 0 : i2, this.mIsVertical ? i4 : 0, 0, obtain, iArr2);
                obtain.offsetLocation(iArr2[0], iArr2[1]);
                this.mScrollInfo.lastMotionX = x - iArr2[0];
                this.mScrollInfo.lastMotionY = y - iArr2[1];
                int[] iArr3 = this.mScrollInfo.offsetInWindow;
                iArr3[0] = iArr3[0] + iArr2[0];
                int[] iArr4 = this.mScrollInfo.offsetInWindow;
                iArr4[1] = iArr4[1] + iArr2[1];
                if ((this.mIsVertical && dispatchScroll[1] != i4) || (!this.mIsVertical && dispatchScroll[0] != i2)) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
            }
        }
        if (!z) {
            this.mScrollInfo.velocityTracker.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.lynx.tasm.behavior.ui.scroll.base.LynxBaseScrollViewDragging$2 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class C01272 implements LynxBaseScrollViewScroller.ScrollFinishedCallback {
        final /* synthetic */ LynxBaseScrollViewNestedInternal val$scrollView;

        C01272(LynxBaseScrollViewNestedInternal lynxBaseScrollViewNestedInternal) {
            this.val$scrollView = lynxBaseScrollViewNestedInternal;
        }

        @Override // com.lynx.tasm.behavior.ui.scroll.base.LynxBaseScrollViewScroller.ScrollFinishedCallback
        public void finished(boolean z) {
            if (!z || LynxBaseScrollViewDragging.this.mScrollHelper.tryBouncesBack(this.val$scrollView, LynxBaseScrollViewDragging.this.mIsVertical, new LynxBaseScrollViewScroller.ScrollFinishedCallback() { // from class: com.lynx.tasm.behavior.ui.scroll.base.LynxBaseScrollViewDragging$2$$ExternalSyntheticLambda0
                @Override // com.lynx.tasm.behavior.ui.scroll.base.LynxBaseScrollViewScroller.ScrollFinishedCallback
                public final void finished(boolean z2) {
                    LynxBaseScrollViewDragging.C01272.this.m8x9e38f516(z2);
                }
            })) {
                return;
            }
            LynxBaseScrollViewDragging.this.tryToUpdateScrollState(0);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$finished$0$com-lynx-tasm-behavior-ui-scroll-base-LynxBaseScrollViewDragging$2 */
        public /* synthetic */ void m8x9e38f516(boolean z) {
            if (z) {
                LynxBaseScrollViewDragging.this.tryToUpdateScrollState(0);
            }
        }
    }

    private void resetTouch() {
        if (this.mScrollInfo.velocityTracker != null) {
            this.mScrollInfo.velocityTracker.clear();
        }
        getParent().requestDisallowInterceptTouchEvent(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getNestedScrollAxis() {
        return this.mIsVertical ? 2 : 1;
    }
}
