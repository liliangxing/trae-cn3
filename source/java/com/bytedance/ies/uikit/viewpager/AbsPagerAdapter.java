package com.bytedance.ies.uikit.viewpager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import java.util.LinkedList;

/* loaded from: classes4.dex */
public abstract class AbsPagerAdapter extends PagerAdapter {
    protected final Context mContext;
    protected final LayoutInflater mInflater;
    protected final LinkedList<View> mScrapViews = new LinkedList<>();

    protected abstract View getView(int i, View view, ViewGroup viewGroup);

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void unbindView(View view) {
    }

    public AbsPagerAdapter(Context context, LayoutInflater layoutInflater) {
        this.mInflater = layoutInflater;
        this.mContext = context;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View view = getView(i, !this.mScrapViews.isEmpty() ? this.mScrapViews.removeFirst() : null, viewGroup);
        viewGroup.addView(view);
        return view;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (obj == null) {
            return;
        }
        View view = (View) obj;
        viewGroup.removeView(view);
        this.mScrapViews.add(view);
        unbindView(view);
    }
}
