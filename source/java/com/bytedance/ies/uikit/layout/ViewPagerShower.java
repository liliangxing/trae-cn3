package com.bytedance.ies.uikit.layout;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ugc.uikit.R;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class ViewPagerShower extends LinearLayout {
    private ArrayList<ImageView> mAl;
    private final LinearLayout.LayoutParams mLayoutParams;
    private Drawable mNormalDrawable;
    private int mNow;
    private Drawable mSelectedDrawable;

    public ViewPagerShower(Context context) {
        super(context);
        this.mAl = new ArrayList<>();
        this.mNow = -1;
        this.mLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    }

    public ViewPagerShower(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAl = new ArrayList<>();
        this.mNow = -1;
        this.mLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    }

    public void initDrawable(Drawable drawable, Drawable drawable2) {
        this.mNormalDrawable = drawable;
        this.mSelectedDrawable = drawable2;
    }

    public void initViews(int i, int i2) {
        removeAllViews();
        this.mAl.clear();
        for (int i3 = 0; i3 < i; i3++) {
            ImageView imageView = new ImageView(getContext());
            Drawable drawable = this.mNormalDrawable;
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
            } else {
                imageView.setImageResource(R.drawable.dot_gray);
            }
            if (i3 < i - 1) {
                this.mLayoutParams.setMargins(0, 0, (int) UIUtils.dip2Px(getContext(), 10.0f), 0);
                addView(imageView, this.mLayoutParams);
            } else {
                addView(imageView);
            }
            this.mAl.add(imageView);
        }
        onPageSelect(i2);
    }

    public void onPageSelect(int i) {
        ArrayList<ImageView> arrayList = this.mAl;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        int i2 = this.mNow;
        if (i2 >= 0 && i2 < this.mAl.size()) {
            if (this.mNormalDrawable != null) {
                this.mAl.get(this.mNow).setImageDrawable(this.mNormalDrawable);
            } else {
                this.mAl.get(this.mNow).setImageResource(R.drawable.dot_gray);
            }
        }
        if (i < 0 || i >= this.mAl.size()) {
            return;
        }
        if (this.mSelectedDrawable != null) {
            this.mAl.get(i).setImageDrawable(this.mSelectedDrawable);
        } else {
            this.mAl.get(i).setImageResource(R.drawable.dot_colour);
        }
        this.mNow = i;
    }
}
