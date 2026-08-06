package com.bytedance.ies.uikit.scrollview;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import java.util.Locale;

/* loaded from: classes4.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private static final int[] ATTRS = {R.attr.textSize, R.attr.textColor};
    private int currentPosition;
    private float currentPositionOffset;
    private LinearLayout.LayoutParams defaultTabLayoutParams;
    public ViewPager.OnPageChangeListener delegatePageListener;
    private int dividerColor;
    private int dividerPadding;
    private Paint dividerPaint;
    private int dividerWidth;
    private LinearLayout.LayoutParams expandedTabLayoutParams;
    private int indicatorColor;
    private int indicatorHeight;
    private int lastScrollX;
    private Locale locale;
    private boolean mHighlightTitle;
    private boolean overlayIndicator;
    private final PageListener pageListener;
    private ViewPager pager;
    private Paint rectPaint;
    private int scrollOffset;
    private boolean shouldExpand;
    private int tabBackgroundResId;
    private int tabCount;
    private int tabPadding;
    private int tabTextColor;
    private int tabTextSize;
    private Typeface tabTypeface;
    private int tabTypefaceStyle;
    private LinearLayout tabsContainer;
    private boolean textAllCaps;
    private int underlineColor;
    private int underlineHeight;

    /* loaded from: classes4.dex */
    public interface IconTabProvider {
        int getPageIconResId(int i);
    }

    /* loaded from: classes4.dex */
    public interface TextTabProvider {
        View getTextTabView(int i, ViewGroup viewGroup);

        TextView getTextViewInTab(View view);

        void onTabClick(int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pageListener = new PageListener();
        this.currentPosition = 0;
        this.currentPositionOffset = 0.0f;
        this.indicatorColor = -10066330;
        this.underlineColor = 436207616;
        this.dividerColor = 436207616;
        this.shouldExpand = false;
        this.textAllCaps = true;
        this.mHighlightTitle = false;
        this.overlayIndicator = false;
        this.scrollOffset = 52;
        this.indicatorHeight = 8;
        this.underlineHeight = 2;
        this.dividerPadding = 12;
        this.tabPadding = 24;
        this.dividerWidth = 1;
        this.tabTextSize = 12;
        this.tabTextColor = -10066330;
        this.tabTypeface = null;
        this.tabTypefaceStyle = 0;
        this.lastScrollX = 0;
        this.tabBackgroundResId = com.bytedance.ugc.uikit.R.drawable.background_tab;
        setFillViewport(true);
        setWillNotDraw(false);
        LinearLayout linearLayout = new LinearLayout(context);
        this.tabsContainer = linearLayout;
        linearLayout.setOrientation(0);
        this.tabsContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.tabsContainer);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.scrollOffset = (int) TypedValue.applyDimension(1, this.scrollOffset, displayMetrics);
        this.indicatorHeight = (int) TypedValue.applyDimension(1, this.indicatorHeight, displayMetrics);
        this.underlineHeight = (int) TypedValue.applyDimension(1, this.underlineHeight, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.dividerWidth = (int) TypedValue.applyDimension(1, this.dividerWidth, displayMetrics);
        this.tabTextSize = (int) TypedValue.applyDimension(2, this.tabTextSize, displayMetrics);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ATTRS);
        this.tabTextSize = obtainStyledAttributes.getDimensionPixelSize(0, this.tabTextSize);
        this.tabTextColor = obtainStyledAttributes.getColor(1, this.tabTextColor);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, com.bytedance.ugc.uikit.R.styleable.PagerSlidingTabStrip);
        this.indicatorColor = obtainStyledAttributes2.getColor(com.bytedance.ugc.uikit.R.styleable.PagerSlidingTabStrip_pstsIndicatorColor, this.indicatorColor);
        this.underlineColor = obtainStyledAttributes2.getColor(com.bytedance.ugc.uikit.R.styleable.PagerSlidingTabStrip_pstsUnderlineColor, this.underlineColor);
        this.dividerColor = obtainStyledAttributes2.getColor(com.bytedance.ugc.uikit.R.styleable.PagerSlidingTabStrip_pstsDividerColor, this.dividerColor);
        this.indicatorHeight = obtainStyledAttributes2.getDimensionPixelSize(com.bytedance.ugc.uikit.R.styleable.PagerSlidingTabStrip_pstsIndicatorHeight, this.indicatorHeight);
        this.underlineHeight = obtainStyledAttributes2.getDimensionPixelSize(com.bytedance.ugc.uikit.R.styleable.PagerSlidingTabStrip_pstsUnderlineHeight, this.underlineHeight);
        this.dividerPadding = obtainStyledAttributes2.getDimensionPixelSize(com.bytedance.ugc.uikit.R.styleable.PagerSlidingTabStrip_pstsDividerPadding, this.dividerPadding);
        this.tabPadding = obtainStyledAttributes2.getDimensionPixelSize(com.bytedance.ugc.uikit.R.styleable.PagerSlidingTabStrip_pstsTabPaddingLeftRight, this.tabPadding);
        this.tabBackgroundResId = obtainStyledAttributes2.getResourceId(com.bytedance.ugc.uikit.R.styleable.PagerSlidingTabStrip_pstsTabBackground, this.tabBackgroundResId);
        this.shouldExpand = obtainStyledAttributes2.getBoolean(com.bytedance.ugc.uikit.R.styleable.PagerSlidingTabStrip_pstsShouldExpand, this.shouldExpand);
        this.scrollOffset = obtainStyledAttributes2.getDimensionPixelSize(com.bytedance.ugc.uikit.R.styleable.PagerSlidingTabStrip_pstsScrollOffset, this.scrollOffset);
        this.textAllCaps = obtainStyledAttributes2.getBoolean(com.bytedance.ugc.uikit.R.styleable.PagerSlidingTabStrip_pstsTextAllCaps, this.textAllCaps);
        obtainStyledAttributes2.recycle();
        Paint paint = new Paint();
        this.rectPaint = paint;
        paint.setAntiAlias(true);
        this.rectPaint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.dividerPaint = paint2;
        paint2.setAntiAlias(true);
        this.dividerPaint.setStrokeWidth(this.dividerWidth);
        this.defaultTabLayoutParams = new LinearLayout.LayoutParams(-2, -1);
        this.expandedTabLayoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.pager = viewPager;
        if (viewPager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        viewPager.setOnPageChangeListener(this.pageListener);
        notifyDataSetChanged();
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.delegatePageListener = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        this.tabsContainer.removeAllViews();
        this.tabCount = this.pager.getAdapter().getCount();
        for (int i = 0; i < this.tabCount; i++) {
            if (this.pager.getAdapter() instanceof IconTabProvider) {
                addIconTab(i, ((IconTabProvider) this.pager.getAdapter()).getPageIconResId(i));
            } else {
                addTextTab(i, this.pager.getAdapter().getPageTitle(i).toString());
            }
        }
        updateTabStyles();
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.ies.uikit.scrollview.PagerSlidingTabStrip.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                PagerSlidingTabStrip.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                PagerSlidingTabStrip pagerSlidingTabStrip = PagerSlidingTabStrip.this;
                pagerSlidingTabStrip.currentPosition = pagerSlidingTabStrip.pager.getCurrentItem();
                PagerSlidingTabStrip pagerSlidingTabStrip2 = PagerSlidingTabStrip.this;
                pagerSlidingTabStrip2.scrollToChild(pagerSlidingTabStrip2.currentPosition, 0);
            }
        });
    }

    private void addTextTab(int i, String str) {
        View view;
        TextView textView = null;
        if (this.pager.getAdapter() instanceof TextTabProvider) {
            TextTabProvider textTabProvider = (TextTabProvider) this.pager.getAdapter();
            view = textTabProvider.getTextTabView(i, this.tabsContainer);
            if (view != null) {
                textView = textTabProvider.getTextViewInTab(view);
            }
        } else {
            view = null;
        }
        if (textView == null) {
            textView = new TextView(getContext());
            view = textView;
        }
        textView.setText(str);
        textView.setGravity(17);
        textView.setSingleLine();
        addTab(i, view);
    }

    private void addIconTab(int i, int i2) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        addTab(i, imageButton);
    }

    private void addTab(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.ies.uikit.scrollview.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!(PagerSlidingTabStrip.this.pager.getAdapter() instanceof TextTabProvider) || PagerSlidingTabStrip.this.pager.getCurrentItem() != i) {
                    PagerSlidingTabStrip.this.pager.setCurrentItem(i);
                } else {
                    ((TextTabProvider) PagerSlidingTabStrip.this.pager.getAdapter()).onTabClick(i);
                }
            }
        });
        int i2 = this.tabPadding;
        view.setPadding(i2, 0, i2, 0);
        this.tabsContainer.addView(view, i, this.shouldExpand ? this.expandedTabLayoutParams : this.defaultTabLayoutParams);
    }

    private void updateTabStyles() {
        int currentItem = this.pager.getCurrentItem();
        for (int i = 0; i < this.tabCount; i++) {
            View childAt = this.tabsContainer.getChildAt(i);
            childAt.setBackgroundResource(this.tabBackgroundResId);
            TextView textViewInTab = this.pager.getAdapter() instanceof TextTabProvider ? ((TextTabProvider) this.pager.getAdapter()).getTextViewInTab(childAt) : null;
            if (textViewInTab == null && (childAt instanceof TextView)) {
                textViewInTab = (TextView) childAt;
            }
            if (textViewInTab != null) {
                textViewInTab.setTextSize(0, this.tabTextSize);
                textViewInTab.setTypeface(this.tabTypeface, this.tabTypefaceStyle);
                if (currentItem == i && this.mHighlightTitle) {
                    textViewInTab.setTextColor(this.indicatorColor);
                } else {
                    textViewInTab.setTextColor(this.tabTextColor);
                }
                if (this.textAllCaps) {
                    textViewInTab.setAllCaps(true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabTitleColor() {
        int currentItem = this.pager.getCurrentItem();
        for (int i = 0; i < this.tabCount; i++) {
            View childAt = this.tabsContainer.getChildAt(i);
            TextView textViewInTab = this.pager.getAdapter() instanceof TextTabProvider ? ((TextTabProvider) this.pager.getAdapter()).getTextViewInTab(childAt) : null;
            if (textViewInTab == null && (childAt instanceof TextView)) {
                textViewInTab = (TextView) childAt;
            }
            if (textViewInTab != null) {
                if (currentItem == i && this.mHighlightTitle) {
                    textViewInTab.setTextColor(this.indicatorColor);
                } else {
                    textViewInTab.setTextColor(this.tabTextColor);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.tabCount == 0) {
            return;
        }
        int left = this.tabsContainer.getChildAt(i).getLeft() + i2;
        if (i > 0 || i2 > 0) {
            left -= this.scrollOffset;
        }
        if (left != this.lastScrollX) {
            this.lastScrollX = left;
            scrollTo(left, 0);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (isInEditMode() || this.tabCount == 0) {
            return;
        }
        int height = getHeight();
        if (this.overlayIndicator) {
            this.rectPaint.setColor(this.underlineColor);
            canvas.drawRect(0.0f, height - this.underlineHeight, this.tabsContainer.getWidth(), height, this.rectPaint);
        }
        this.rectPaint.setColor(this.indicatorColor);
        View childAt = this.tabsContainer.getChildAt(this.currentPosition);
        float left = childAt.getLeft();
        float right = childAt.getRight();
        if (this.currentPositionOffset > 0.0f && (i = this.currentPosition) < this.tabCount - 1) {
            View childAt2 = this.tabsContainer.getChildAt(i + 1);
            float left2 = childAt2.getLeft();
            float right2 = childAt2.getRight();
            float f = this.currentPositionOffset;
            left = (left2 * f) + ((1.0f - f) * left);
            right = (right2 * f) + ((1.0f - f) * right);
        }
        float f2 = height;
        canvas.drawRect(left, height - this.indicatorHeight, right, f2, this.rectPaint);
        if (!this.overlayIndicator) {
            this.rectPaint.setColor(this.underlineColor);
            canvas.drawRect(0.0f, height - this.underlineHeight, this.tabsContainer.getWidth(), f2, this.rectPaint);
        }
        this.dividerPaint.setColor(this.dividerColor);
        for (int i2 = 0; i2 < this.tabCount - 1; i2++) {
            View childAt3 = this.tabsContainer.getChildAt(i2);
            canvas.drawLine(childAt3.getRight(), this.dividerPadding, childAt3.getRight(), height - this.dividerPadding, this.dividerPaint);
        }
    }

    /* loaded from: classes4.dex */
    private class PageListener implements ViewPager.OnPageChangeListener {
        private PageListener() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            PagerSlidingTabStrip.this.currentPosition = i;
            PagerSlidingTabStrip.this.currentPositionOffset = f;
            PagerSlidingTabStrip.this.scrollToChild(i, (int) (r0.tabsContainer.getChildAt(i).getWidth() * f));
            PagerSlidingTabStrip.this.invalidate();
            if (PagerSlidingTabStrip.this.delegatePageListener != null) {
                PagerSlidingTabStrip.this.delegatePageListener.onPageScrolled(i, f, i2);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (i == 0) {
                PagerSlidingTabStrip pagerSlidingTabStrip = PagerSlidingTabStrip.this;
                pagerSlidingTabStrip.scrollToChild(pagerSlidingTabStrip.pager.getCurrentItem(), 0);
            }
            if (PagerSlidingTabStrip.this.delegatePageListener != null) {
                PagerSlidingTabStrip.this.delegatePageListener.onPageScrollStateChanged(i);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.mHighlightTitle) {
                PagerSlidingTabStrip.this.updateTabTitleColor();
            }
            if (PagerSlidingTabStrip.this.delegatePageListener != null) {
                PagerSlidingTabStrip.this.delegatePageListener.onPageSelected(i);
            }
        }
    }

    public void setIndicatorColor(int i) {
        this.indicatorColor = i;
        invalidate();
    }

    public void setIndicatorColorResource(int i) {
        this.indicatorColor = getResources().getColor(i);
        invalidate();
    }

    public int getIndicatorColor() {
        return this.indicatorColor;
    }

    public void setIndicatorHeight(int i) {
        this.indicatorHeight = i;
        invalidate();
    }

    public int getIndicatorHeight() {
        return this.indicatorHeight;
    }

    public void setUnderlineColor(int i) {
        this.underlineColor = i;
        invalidate();
    }

    public void setUnderlineColorResource(int i) {
        this.underlineColor = getResources().getColor(i);
        invalidate();
    }

    public int getUnderlineColor() {
        return this.underlineColor;
    }

    public void setDividerColor(int i) {
        this.dividerColor = i;
        invalidate();
    }

    public void setDividerColorResource(int i) {
        this.dividerColor = getResources().getColor(i);
        invalidate();
    }

    public int getDividerColor() {
        return this.dividerColor;
    }

    public void setUnderlineHeight(int i) {
        this.underlineHeight = i;
        invalidate();
    }

    public int getUnderlineHeight() {
        return this.underlineHeight;
    }

    public void setDividerPadding(int i) {
        this.dividerPadding = i;
        invalidate();
    }

    public int getDividerPadding() {
        return this.dividerPadding;
    }

    public void setScrollOffset(int i) {
        this.scrollOffset = i;
        invalidate();
    }

    public int getScrollOffset() {
        return this.scrollOffset;
    }

    public void setShouldExpand(boolean z) {
        this.shouldExpand = z;
        requestLayout();
    }

    public boolean getShouldExpand() {
        return this.shouldExpand;
    }

    public void setHighlightTitle(boolean z) {
        this.mHighlightTitle = z;
    }

    public boolean getHighlightTitle() {
        return this.mHighlightTitle;
    }

    public void setOverlayIndicator(boolean z) {
        this.overlayIndicator = z;
    }

    public boolean isTextAllCaps() {
        return this.textAllCaps;
    }

    public void setAllCaps(boolean z) {
        this.textAllCaps = z;
    }

    public void setTextSize(int i) {
        this.tabTextSize = i;
        updateTabStyles();
    }

    public int getTextSize() {
        return this.tabTextSize;
    }

    public void setTextColor(int i) {
        this.tabTextColor = i;
        updateTabStyles();
    }

    public void setTextColorResource(int i) {
        this.tabTextColor = getResources().getColor(i);
        updateTabStyles();
    }

    public int getTextColor() {
        return this.tabTextColor;
    }

    public void setTypeface(Typeface typeface, int i) {
        this.tabTypeface = typeface;
        this.tabTypefaceStyle = i;
        updateTabStyles();
    }

    public void setTabBackground(int i) {
        this.tabBackgroundResId = i;
    }

    public int getTabBackground() {
        return this.tabBackgroundResId;
    }

    public void setTabPaddingLeftRight(int i) {
        this.tabPadding = i;
        updateTabStyles();
    }

    public int getTabPaddingLeftRight() {
        return this.tabPadding;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.currentPosition = savedState.currentPosition;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.currentPosition = this.currentPosition;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.bytedance.ies.uikit.scrollview.PagerSlidingTabStrip.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int currentPosition;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.currentPosition = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.currentPosition);
        }
    }
}
