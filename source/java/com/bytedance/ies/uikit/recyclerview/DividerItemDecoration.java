package com.bytedance.ies.uikit.recyclerview;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.common.utility.UIUtils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class DividerItemDecoration extends RecyclerView.ItemDecoration {
    private static final int[] ATTRS = {R.attr.listDivider};
    public static final int HORIZONTAL_LIST = 0;
    public static final int VERTICAL_LIST = 1;
    protected Drawable mDivider;
    private boolean mDrawFirstChildTopLine;
    private boolean mDrawLastChildBottomLine;
    private int mFirstOffset;
    private int mOrientation;

    public DividerItemDecoration(Context context, int i, int i2) {
        this(context, i, i2, false);
    }

    public DividerItemDecoration(Context context, int i, int i2, boolean z) {
        this(context, i, i2, z, true);
    }

    public DividerItemDecoration(Context context, int i, int i2, boolean z, boolean z2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(ATTRS);
        this.mDivider = context.getResources().getDrawable(i2);
        obtainStyledAttributes.recycle();
        setOrientation(i);
        this.mDrawFirstChildTopLine = z;
        this.mDrawLastChildBottomLine = z2;
    }

    public void setOrientation(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation");
        }
        this.mOrientation = i;
    }

    public void setFirstOffset(int i) {
        this.mFirstOffset = i;
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        if (this.mOrientation == 1) {
            drawVertical(canvas, recyclerView);
        } else {
            drawHorizontal(canvas, recyclerView);
        }
    }

    public void drawVertical(Canvas canvas, RecyclerView recyclerView) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        if (!this.mDrawLastChildBottomLine) {
            childCount--;
        }
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            this.mDivider.setBounds(paddingLeft, childAt.getBottom() + childAt.getLayoutParams().bottomMargin, width, (this.mDivider.getIntrinsicHeight() + r5) - 1);
            this.mDivider.draw(canvas);
        }
        if (this.mDrawFirstChildTopLine) {
            View childAt2 = recyclerView.getChildAt(0);
            if (recyclerView.getChildPosition(childAt2) == 0) {
                int top = childAt2.getTop() - childAt2.getLayoutParams().topMargin;
                this.mDivider.setBounds(paddingLeft, (top - this.mDivider.getIntrinsicHeight()) + 1, width, top);
                this.mDivider.draw(canvas);
            }
        }
    }

    public void drawHorizontal(Canvas canvas, RecyclerView recyclerView) {
        int paddingTop = recyclerView.getPaddingTop();
        int height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
        int childCount = recyclerView.getChildCount();
        if (!this.mDrawLastChildBottomLine) {
            childCount--;
        }
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            int right = childAt.getRight() + childAt.getLayoutParams().rightMargin;
            this.mDivider.setBounds(right, paddingTop, this.mDivider.getIntrinsicHeight() + right, height);
            this.mDivider.draw(canvas);
        }
        if (this.mDrawFirstChildTopLine) {
            View childAt2 = recyclerView.getChildAt(0);
            if (recyclerView.getChildPosition(childAt2) == 0) {
                this.mDivider.setBounds(childAt2.getLeft() - childAt2.getLayoutParams().leftMargin, paddingTop, this.mDivider.getIntrinsicHeight() + paddingTop, height);
                this.mDivider.draw(canvas);
            }
        }
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int intrinsicHeight = (this.mDrawFirstChildTopLine && childAdapterPosition == 0) ? this.mDivider.getIntrinsicHeight() : 0;
        if (this.mOrientation == 1) {
            if (childAdapterPosition == 0) {
                intrinsicHeight += (int) UIUtils.dip2Px(recyclerView.getContext(), this.mFirstOffset);
            }
            rect.set(0, intrinsicHeight, 0, this.mDivider.getIntrinsicHeight());
            return;
        }
        rect.set(0, intrinsicHeight, this.mDivider.getIntrinsicWidth(), 0);
    }
}
