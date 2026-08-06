package com.lynx.tasm.behavior.p000ui.list;

import android.view.View;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;
import com.lynx.tasm.behavior.p000ui.view.AndroidView;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxSnapHelper {
    private static final int INVALID_INDEX = -1;
    private double mSnapAlignmentFactor;
    public double mSnapAlignmentMillisecondsPerPx;
    private int mSnapAlignmentOffset;
    private LynxSnapHooks mSnapHooks;
    private boolean mIsVertical = true;
    private boolean mIsRtl = false;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface LynxSnapHooks {
        View getChildAtIndex(int i);

        int getChildrenCount();

        int getIndexFromView(View view);

        int getScrollHeight();

        int getScrollWidth();

        int getScrollX();

        int getScrollY();

        View getViewAtPosition(int i);

        int getVirtualChildrenCount();

        void willSnapTo(int i, int i2, int i3, int i4, int i5);
    }

    public LynxSnapHelper(double d, int i, double d2, LynxSnapHooks lynxSnapHooks) {
        this.mSnapAlignmentFactor = d;
        this.mSnapAlignmentOffset = i;
        this.mSnapAlignmentMillisecondsPerPx = d2;
        this.mSnapHooks = lynxSnapHooks;
    }

    private int distanceToItem(View view) {
        int left;
        double scrollX;
        int i;
        if (view instanceof AndroidView) {
            AndroidView androidView = (AndroidView) view;
            if (androidView.getDrawChildHook() instanceof LynxBaseUI) {
                LynxBaseUI lynxBaseUI = (LynxBaseUI) androidView.getDrawChildHook();
                if (this.mIsVertical) {
                    left = (int) (lynxBaseUI.getTop() + (lynxBaseUI.getHeight() * this.mSnapAlignmentFactor) + this.mSnapAlignmentOffset);
                    scrollX = this.mSnapHooks.getScrollY() + (this.mSnapHooks.getScrollHeight() * this.mSnapAlignmentFactor);
                    i = this.mSnapAlignmentOffset;
                } else {
                    left = (int) (lynxBaseUI.getLeft() + (lynxBaseUI.getWidth() * this.mSnapAlignmentFactor) + this.mSnapAlignmentOffset);
                    scrollX = this.mSnapHooks.getScrollX() + (this.mSnapHooks.getScrollWidth() * this.mSnapAlignmentFactor);
                    i = this.mSnapAlignmentOffset;
                }
                return left - ((int) (scrollX + i));
            }
        }
        throw new RuntimeException("A list-item is not an AndroidView, some thing went wrong");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int[] findTargetSnapOffset(int i, int i2, boolean z, boolean z2) {
        double left;
        int i3;
        this.mIsVertical = z;
        this.mIsRtl = z2;
        int[] iArr = {0, 0};
        int findTargetSnapPosition = findTargetSnapPosition(i, i2);
        int scrollY = this.mIsVertical ? this.mSnapHooks.getScrollY() : this.mSnapHooks.getScrollX();
        int i4 = -1;
        if (findTargetSnapPosition != -1 && (findTargetSnapPosition = Math.min(Math.max(findTargetSnapPosition, 0), this.mSnapHooks.getVirtualChildrenCount() - 1)) != -1) {
            View viewAtPosition = this.mSnapHooks.getViewAtPosition(findTargetSnapPosition);
            if (viewAtPosition != null) {
                if (viewAtPosition instanceof AndroidView) {
                    AndroidView androidView = (AndroidView) viewAtPosition;
                    if (androidView.getDrawChildHook() instanceof LynxBaseUI) {
                        LynxBaseUI lynxBaseUI = (LynxBaseUI) androidView.getDrawChildHook();
                        if (this.mIsVertical) {
                            left = lynxBaseUI.getTop() - ((this.mSnapHooks.getScrollHeight() - lynxBaseUI.getHeight()) * this.mSnapAlignmentFactor);
                            i3 = this.mSnapAlignmentOffset;
                        } else {
                            left = lynxBaseUI.getLeft() - ((this.mSnapHooks.getScrollWidth() - lynxBaseUI.getWidth()) * this.mSnapAlignmentFactor);
                            i3 = this.mSnapAlignmentOffset;
                        }
                        scrollY = (int) (left + i3);
                    }
                }
                throw new RuntimeException("The target list-item is not an AndroidView, some thing went wrong");
            }
            if (this.mIsVertical) {
                iArr[0] = scrollY;
            } else {
                iArr[1] = scrollY;
            }
            LynxSnapHooks lynxSnapHooks = this.mSnapHooks;
            lynxSnapHooks.willSnapTo(i4, lynxSnapHooks.getScrollX(), this.mSnapHooks.getScrollY(), iArr[0], iArr[1]);
            return iArr;
        }
        i4 = findTargetSnapPosition;
        if (this.mIsVertical) {
        }
        LynxSnapHooks lynxSnapHooks2 = this.mSnapHooks;
        lynxSnapHooks2.willSnapTo(i4, lynxSnapHooks2.getScrollX(), this.mSnapHooks.getScrollY(), iArr[0], iArr[1]);
        return iArr;
    }

    private int findTargetSnapPosition(int i, int i2) {
        int indexFromView;
        boolean z = false;
        boolean z2 = !this.mIsVertical ? i == 0 : i2 == 0;
        int childrenCount = this.mSnapHooks.getChildrenCount();
        View view = null;
        int i3 = Integer.MAX_VALUE;
        int i4 = Integer.MIN_VALUE;
        View view2 = null;
        for (int i5 = 0; i5 < childrenCount; i5++) {
            View childAtIndex = this.mSnapHooks.getChildAtIndex(i5);
            if (childAtIndex != null) {
                int distanceToItem = distanceToItem(childAtIndex);
                if (distanceToItem <= 0 && distanceToItem > i4) {
                    view2 = childAtIndex;
                    i4 = distanceToItem;
                }
                if (distanceToItem >= 0 && distanceToItem < i3) {
                    view = childAtIndex;
                    i3 = distanceToItem;
                }
            }
        }
        boolean isForwardFling = isForwardFling(i, i2);
        if (z2) {
            if (!isForwardFling || view == null) {
                if (!isForwardFling && view2 != null) {
                    indexFromView = this.mSnapHooks.getIndexFromView(view2);
                }
                indexFromView = -1;
            } else {
                indexFromView = this.mSnapHooks.getIndexFromView(view);
            }
        } else if (view == null || view2 == null) {
            if (view != null) {
                indexFromView = this.mSnapHooks.getIndexFromView(view);
            } else {
                if (view2 != null) {
                    indexFromView = this.mSnapHooks.getIndexFromView(view2);
                }
                indexFromView = -1;
            }
        } else if (Math.abs(i3) < Math.abs(i4)) {
            indexFromView = this.mSnapHooks.getIndexFromView(view);
        } else {
            indexFromView = this.mSnapHooks.getIndexFromView(view2);
        }
        if (indexFromView != -1) {
            return indexFromView;
        }
        if (isForwardFling) {
            view = view2;
        }
        if (view == null) {
            return -1;
        }
        int indexFromView2 = this.mSnapHooks.getIndexFromView(view);
        if (this.mIsVertical || !this.mIsRtl) {
            z = isForwardFling;
        } else if (!isForwardFling) {
            z = true;
        }
        return indexFromView2 + (z ? 1 : -1);
    }

    private boolean isForwardFling(int i, int i2) {
        return this.mIsVertical ? i2 >= 0 : i >= 0;
    }
}
