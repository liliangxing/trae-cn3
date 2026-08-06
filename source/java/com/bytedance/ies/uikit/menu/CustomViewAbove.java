package com.bytedance.ies.uikit.menu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import androidx.core.view.ViewCompat;
import com.bytedance.ies.uikit.menu.SlidingMenu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class CustomViewAbove extends ViewGroup {
    private static final boolean DEBUG = false;
    private static final int INVALID_POINTER = -1;
    private static final int MAX_SETTLE_DURATION = 600;
    private static final String TAG = "CustomViewAbove";
    private static final boolean USE_CACHE = false;
    private static final Interpolator sInterpolator = new Interpolator() { // from class: com.bytedance.ies.uikit.menu.CustomViewAbove.1
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };
    protected int mActivePointerId;
    private SlidingMenu.OnClosedListener mClosedListener;
    private View mContent;
    private int mCurItem;
    private boolean mEnabled;
    private List<View> mIgnoredViews;
    private OnPageChangeListener mInternalPageChangeListener;
    private OnPageChangeListener mOnPageChangeListener;
    private SlidingMenu.OnOpenedListener mOpenedListener;
    private float mScrollX;
    private Scroller mScroller;
    private boolean mScrolling;
    private boolean mScrollingCacheEnabled;
    protected int mTouchMode;
    private CustomViewBehind mViewBehind;

    /* loaded from: classes4.dex */
    public interface OnPageChangeListener {
        void onPageScrolled(int i, float f, int i2);

        void onPageSelected(int i);
    }

    /* loaded from: classes4.dex */
    public static class SimpleOnPageChangeListener implements OnPageChangeListener {
        public void onPageScrollStateChanged(int i) {
        }

        @Override // com.bytedance.ies.uikit.menu.CustomViewAbove.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // com.bytedance.ies.uikit.menu.CustomViewAbove.OnPageChangeListener
        public void onPageSelected(int i) {
        }
    }

    public CustomViewAbove(Context context) {
        this(context, null);
    }

    public CustomViewAbove(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mActivePointerId = -1;
        this.mEnabled = true;
        this.mIgnoredViews = new ArrayList();
        this.mTouchMode = 0;
        this.mScrollX = 0.0f;
        initCustomViewAbove();
    }

    void initCustomViewAbove() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        this.mScroller = new Scroller(getContext(), sInterpolator);
        setInternalPageChangeListener(new SimpleOnPageChangeListener() { // from class: com.bytedance.ies.uikit.menu.CustomViewAbove.2
            @Override // com.bytedance.ies.uikit.menu.CustomViewAbove.SimpleOnPageChangeListener, com.bytedance.ies.uikit.menu.CustomViewAbove.OnPageChangeListener
            public void onPageSelected(int i) {
                if (CustomViewAbove.this.mViewBehind != null) {
                    if (i != 0) {
                        if (i == 1) {
                            CustomViewAbove.this.mViewBehind.setChildrenEnabled(false);
                            return;
                        } else if (i != 2) {
                            return;
                        }
                    }
                    CustomViewAbove.this.mViewBehind.setChildrenEnabled(true);
                }
            }
        });
    }

    public void setCurrentItem(int i) {
        setCurrentItemInternal(i, true, false);
    }

    public void setCurrentItem(int i, boolean z) {
        setCurrentItemInternal(i, z, false);
    }

    public int getCurrentItem() {
        return this.mCurItem;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCurrentItemInternal(int i, boolean z, boolean z2) {
        setCurrentItemInternal(i, z, z2, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCurrentItemInternal(int i, boolean z, boolean z2, int i2) {
        OnPageChangeListener onPageChangeListener;
        OnPageChangeListener onPageChangeListener2;
        if (!z2 && this.mCurItem == i) {
            setScrollingCacheEnabled(false);
            return;
        }
        int menuPage = this.mViewBehind.getMenuPage(i);
        boolean z3 = this.mCurItem != menuPage;
        this.mCurItem = menuPage;
        int destScrollX = getDestScrollX(menuPage);
        if (z3 && (onPageChangeListener2 = this.mOnPageChangeListener) != null) {
            onPageChangeListener2.onPageSelected(menuPage);
        }
        if (z3 && (onPageChangeListener = this.mInternalPageChangeListener) != null) {
            onPageChangeListener.onPageSelected(menuPage);
        }
        if (z) {
            smoothScrollTo(destScrollX, 0, i2);
        } else {
            completeScroll();
            scrollTo(destScrollX, 0);
        }
    }

    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
    }

    public void setOnOpenedListener(SlidingMenu.OnOpenedListener onOpenedListener) {
        this.mOpenedListener = onOpenedListener;
    }

    public void setOnClosedListener(SlidingMenu.OnClosedListener onClosedListener) {
        this.mClosedListener = onClosedListener;
    }

    OnPageChangeListener setInternalPageChangeListener(OnPageChangeListener onPageChangeListener) {
        OnPageChangeListener onPageChangeListener2 = this.mInternalPageChangeListener;
        this.mInternalPageChangeListener = onPageChangeListener;
        return onPageChangeListener2;
    }

    public void addIgnoredView(View view) {
        if (this.mIgnoredViews.contains(view)) {
            return;
        }
        this.mIgnoredViews.add(view);
    }

    public void removeIgnoredView(View view) {
        this.mIgnoredViews.remove(view);
    }

    public void clearIgnoredViews() {
        this.mIgnoredViews.clear();
    }

    float distanceInfluenceForSnapDuration(float f) {
        return (float) Math.sin((float) ((f - 0.5f) * 0.4712389167638204d));
    }

    public int getDestScrollX() {
        return getDestScrollX(this.mCurItem);
    }

    public int getDestScrollX(int i) {
        if (i != 0) {
            if (i == 1) {
                return this.mContent.getLeft();
            }
            if (i != 2) {
                return 0;
            }
        }
        return this.mViewBehind.getMenuLeft(this.mContent, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getLeftBound() {
        return this.mViewBehind.getAbsLeftBound(this.mContent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getRightBound() {
        return this.mViewBehind.getAbsRightBound(this.mContent);
    }

    public int getContentLeft() {
        return this.mContent.getLeft() + this.mContent.getPaddingLeft();
    }

    public boolean isMenuOpen() {
        int i = this.mCurItem;
        return i == 0 || i == 2;
    }

    private boolean isInIgnoredView(MotionEvent motionEvent) {
        Rect rect = new Rect();
        Iterator<View> it = this.mIgnoredViews.iterator();
        while (it.hasNext()) {
            it.next().getHitRect(rect);
            if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return true;
            }
        }
        return false;
    }

    public int getBehindWidth() {
        CustomViewBehind customViewBehind = this.mViewBehind;
        if (customViewBehind == null) {
            return 0;
        }
        return customViewBehind.getBehindWidth();
    }

    public int getChildWidth(int i) {
        if (i == 0) {
            return getBehindWidth();
        }
        if (i != 1) {
            return 0;
        }
        return this.mContent.getWidth();
    }

    public boolean isSlidingEnabled() {
        return this.mEnabled;
    }

    public void setSlidingEnabled(boolean z) {
        this.mEnabled = z;
    }

    void smoothScrollTo(int i, int i2) {
        smoothScrollTo(i, i2, 0);
    }

    void smoothScrollTo(int i, int i2, int i3) {
        int i4;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i5 = i - scrollX;
        int i6 = i2 - scrollY;
        if (i5 == 0 && i6 == 0) {
            completeScroll();
            if (isMenuOpen()) {
                SlidingMenu.OnOpenedListener onOpenedListener = this.mOpenedListener;
                if (onOpenedListener != null) {
                    onOpenedListener.onOpened();
                    return;
                }
                return;
            }
            SlidingMenu.OnClosedListener onClosedListener = this.mClosedListener;
            if (onClosedListener != null) {
                onClosedListener.onClosed();
                return;
            }
            return;
        }
        setScrollingCacheEnabled(true);
        this.mScrolling = true;
        int behindWidth = getBehindWidth();
        float f = behindWidth / 2;
        float distanceInfluenceForSnapDuration = f + (distanceInfluenceForSnapDuration(Math.min(1.0f, (Math.abs(i5) * 1.0f) / behindWidth)) * f);
        int abs = Math.abs(i3);
        if (abs > 0) {
            i4 = Math.round(Math.abs(distanceInfluenceForSnapDuration / abs) * 1000.0f) * 4;
        } else {
            Math.abs(i5);
            i4 = 600;
        }
        this.mScroller.startScroll(scrollX, scrollY, i5, i6, Math.min(i4, 600));
        invalidate();
    }

    public void setContent(View view) {
        View view2 = this.mContent;
        if (view2 != null) {
            removeView(view2);
        }
        this.mContent = view;
        addView(view);
    }

    public View getContent() {
        return this.mContent;
    }

    public void setCustomViewBehind(CustomViewBehind customViewBehind) {
        this.mViewBehind = customViewBehind;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int defaultSize = getDefaultSize(0, i);
        int defaultSize2 = getDefaultSize(0, i2);
        setMeasuredDimension(defaultSize, defaultSize2);
        this.mContent.measure(getChildMeasureSpec(i, 0, defaultSize), getChildMeasureSpec(i2, 0, defaultSize2));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            completeScroll();
            scrollTo(getDestScrollX(this.mCurItem), getScrollY());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mContent.layout(0, 0, i3 - i, i4 - i2);
    }

    public void setAboveOffset(int i) {
        View view = this.mContent;
        view.setPadding(i, view.getPaddingTop(), this.mContent.getPaddingRight(), this.mContent.getPaddingBottom());
    }

    @Override // android.view.View
    public void computeScroll() {
        if (!this.mScroller.isFinished() && this.mScroller.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
                pageScrolled(currX);
            }
            invalidate();
            return;
        }
        completeScroll();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pageScrolled(int i) {
        int width = getWidth();
        int i2 = i / width;
        int i3 = i % width;
        onPageScrolled(i2, i3 / width, i3);
    }

    protected void onPageScrolled(int i, float f, int i2) {
        OnPageChangeListener onPageChangeListener = this.mOnPageChangeListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrolled(i, f, i2);
        }
        OnPageChangeListener onPageChangeListener2 = this.mInternalPageChangeListener;
        if (onPageChangeListener2 != null) {
            onPageChangeListener2.onPageScrolled(i, f, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void completeScroll() {
        if (this.mScrolling) {
            setScrollingCacheEnabled(false);
            this.mScroller.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
            }
            if (isMenuOpen()) {
                SlidingMenu.OnOpenedListener onOpenedListener = this.mOpenedListener;
                if (onOpenedListener != null) {
                    onOpenedListener.onOpened();
                }
            } else {
                SlidingMenu.OnClosedListener onClosedListener = this.mClosedListener;
                if (onClosedListener != null) {
                    onClosedListener.onClosed();
                }
            }
        }
        this.mScrolling = false;
    }

    public void setTouchMode(int i) {
        this.mTouchMode = i;
    }

    public int getTouchMode() {
        return this.mTouchMode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean thisTouchAllowed(MotionEvent motionEvent) {
        int x = (int) (motionEvent.getX() + this.mScrollX);
        if (isMenuOpen()) {
            return this.mViewBehind.menuOpenTouchAllowed(this.mContent, this.mCurItem, x);
        }
        int i = this.mTouchMode;
        if (i == 0) {
            return this.mViewBehind.marginTouchAllowed(this.mContent, x);
        }
        if (i != 1) {
            return false;
        }
        return !isInIgnoredView(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean thisSlideAllowed(float f) {
        if (isMenuOpen()) {
            return this.mViewBehind.menuOpenSlideAllowed(f);
        }
        return this.mViewBehind.menuClosedSlideAllowed(f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean menuTouchInQuickReturn(MotionEvent motionEvent) {
        return this.mViewBehind.menuTouchInQuickReturn(this.mContent, this.mCurItem, motionEvent.getX() + this.mScrollX);
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        super.scrollTo(i, i2);
        this.mScrollX = i;
        if (this.mEnabled) {
            this.mViewBehind.scrollBehindTo(this.mContent, i, i2);
        }
        ((SlidingMenu) getParent()).manageLayers(getPercentOpen());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float getPercentOpen() {
        return Math.abs(this.mScrollX - this.mContent.getLeft()) / getBehindWidth();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.mViewBehind.drawShadow(this.mContent, canvas);
        this.mViewBehind.drawFade(this.mContent, canvas, getPercentOpen());
        this.mViewBehind.drawSelector(this.mContent, canvas, getPercentOpen());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setScrollingCacheEnabled(boolean z) {
        if (this.mScrollingCacheEnabled != z) {
            this.mScrollingCacheEnabled = z;
        }
    }

    protected boolean canScroll(View view, boolean z, int i, int i2, int i3) {
        int i4;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i5 = i2 + scrollX;
                if (i5 >= childAt.getLeft() && i5 < childAt.getRight() && (i4 = i3 + scrollY) >= childAt.getTop() && i4 < childAt.getBottom() && canScroll(childAt, true, i, i5 - childAt.getLeft(), i4 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && ViewCompat.canScrollHorizontally(view, -i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent);
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 21) {
                return arrowScroll(17);
            }
            if (keyCode == 22) {
                return arrowScroll(66);
            }
            if (keyCode == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return arrowScroll(2);
                }
                if (keyEvent.hasModifiers(1)) {
                    return arrowScroll(1);
                }
            }
        }
        return false;
    }

    public boolean arrowScroll(int i) {
        boolean pageLeft;
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        if (findNextFocus == null || findNextFocus == findFocus) {
            if (i == 17 || i == 1) {
                pageLeft = pageLeft();
            } else {
                if (i == 66 || i == 2) {
                    pageLeft = pageRight();
                }
                pageLeft = false;
            }
        } else if (i == 17) {
            pageLeft = findNextFocus.requestFocus();
        } else {
            if (i == 66) {
                if (findFocus != null && findNextFocus.getLeft() <= findFocus.getLeft()) {
                    pageLeft = pageRight();
                } else {
                    pageLeft = findNextFocus.requestFocus();
                }
            }
            pageLeft = false;
        }
        if (pageLeft) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return pageLeft;
    }

    boolean pageLeft() {
        int i = this.mCurItem;
        if (i <= 0) {
            return false;
        }
        setCurrentItem(i - 1, true);
        return true;
    }

    boolean pageRight() {
        int i = this.mCurItem;
        if (i >= 1) {
            return false;
        }
        setCurrentItem(i + 1, true);
        return true;
    }
}
