package com.bytedance.ies.uikit.viewpager;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public abstract class FragmentPagerAdapter extends PagerAdapter {
    private static final boolean DEBUG = false;
    private static final String TAG = "FragmentPagerAdapter";
    protected FragmentTransaction mCurTransaction = null;
    private Fragment mCurrentPrimaryItem = null;
    protected final FragmentManager mFragmentManager;

    public abstract Fragment getItem(int i);

    public long getItemId(int i) {
        return i;
    }

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }

    public Parcelable saveState() {
        return null;
    }

    public void startUpdate(ViewGroup viewGroup) {
    }

    public FragmentPagerAdapter(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.beginTransaction();
        }
        getItemId(i);
        String makeFragmentName = makeFragmentName(viewGroup.getId(), i);
        Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName);
        if (findFragmentByTag != null) {
            this.mCurTransaction.attach(findFragmentByTag);
        } else {
            findFragmentByTag = getItem(i);
            this.mCurTransaction.add(viewGroup.getId(), findFragmentByTag, makeFragmentName);
        }
        if (findFragmentByTag != this.mCurrentPrimaryItem) {
            findFragmentByTag.setMenuVisibility(false);
            findFragmentByTag.setUserVisibleHint(false);
        }
        return findFragmentByTag;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.beginTransaction();
        }
        this.mCurTransaction.detach((Fragment) obj);
    }

    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.mCurrentPrimaryItem;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                this.mCurrentPrimaryItem.setUserVisibleHint(false);
            }
            if (fragment != null) {
                fragment.setMenuVisibility(true);
                fragment.setUserVisibleHint(true);
            }
            this.mCurrentPrimaryItem = fragment;
        }
    }

    public void finishUpdate(ViewGroup viewGroup) {
        FragmentTransaction fragmentTransaction = this.mCurTransaction;
        if (fragmentTransaction != null) {
            try {
                fragmentTransaction.commitAllowingStateLoss();
                this.mCurTransaction = null;
                this.mFragmentManager.executePendingTransactions();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isViewFromObject(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    protected String makeFragmentName(int i, int i2) {
        return "android:switcher:" + i + ":" + makeFragmentTag(i2);
    }

    protected String makeFragmentTag(int i) {
        return String.valueOf(getItemId(i));
    }
}
