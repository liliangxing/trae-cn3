package com.bytedance.ies.uikit.viewpager;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TabWidget;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class FragmentTabsPagerAdapter extends androidx.fragment.app.FragmentPagerAdapter implements TabHost.OnTabChangeListener, ViewPager.OnPageChangeListener {
    private final Context mContext;
    private final TabHost.OnTabChangeListener mListener;
    private boolean mSmooth;
    private final TabHost mTabHost;
    private final ArrayList<TabInfo> mTabs;
    private final ViewPager mViewPager;

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class TabInfo {
        private final Bundle args;
        private final Class<?> clss;
        Fragment mFragment;
        final String tag;

        TabInfo(String str, Class<?> cls, Bundle bundle) {
            this.tag = str;
            this.clss = cls;
            this.args = bundle;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class DummyTabFactory implements TabHost.TabContentFactory {
        private final Context mContext;

        public DummyTabFactory(Context context) {
            this.mContext = context;
        }

        @Override // android.widget.TabHost.TabContentFactory
        public View createTabContent(String str) {
            View view = new View(this.mContext);
            view.setMinimumWidth(0);
            view.setMinimumHeight(0);
            return view;
        }
    }

    public FragmentTabsPagerAdapter(FragmentActivity fragmentActivity, FragmentManager fragmentManager, TabHost tabHost, ViewPager viewPager, TabHost.OnTabChangeListener onTabChangeListener) {
        super(fragmentManager);
        this.mTabs = new ArrayList<>();
        this.mSmooth = true;
        this.mContext = fragmentActivity;
        this.mTabHost = tabHost;
        this.mViewPager = viewPager;
        tabHost.setOnTabChangedListener(this);
        viewPager.setAdapter(this);
        viewPager.setOnPageChangeListener(this);
        this.mListener = onTabChangeListener;
    }

    public void addTab(TabHost.TabSpec tabSpec, Class<?> cls, Bundle bundle) {
        addTab(tabSpec, cls, bundle, true);
    }

    public void addTab(TabHost.TabSpec tabSpec, Class<?> cls, Bundle bundle, boolean z) {
        tabSpec.setContent(new DummyTabFactory(this.mContext));
        this.mTabs.add(new TabInfo(tabSpec.getTag(), cls, bundle));
        this.mTabHost.addTab(tabSpec);
        if (z) {
            notifyDataSetChanged();
        }
    }

    public Fragment getFragment(int i) {
        if (i < 0 || i >= this.mTabs.size()) {
            return null;
        }
        return this.mTabs.get(i).mFragment;
    }

    public int getCount() {
        return this.mTabs.size();
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        Object instantiateItem = super.instantiateItem(viewGroup, i);
        if (instantiateItem != null && (instantiateItem instanceof Fragment) && i >= 0 && i < this.mTabs.size()) {
            this.mTabs.get(i).mFragment = (Fragment) instantiateItem;
        }
        return instantiateItem;
    }

    public Fragment getItem(int i) {
        TabInfo tabInfo = this.mTabs.get(i);
        return Fragment.instantiate(this.mContext, tabInfo.clss.getName(), tabInfo.args);
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    public void onTabChanged(String str) {
        this.mViewPager.setCurrentItem(this.mTabHost.getCurrentTab(), this.mSmooth);
        TabHost.OnTabChangeListener onTabChangeListener = this.mListener;
        if (onTabChangeListener != null) {
            onTabChangeListener.onTabChanged(str);
        }
    }

    public void onPageSelected(int i) {
        TabWidget tabWidget = this.mTabHost.getTabWidget();
        int descendantFocusability = tabWidget.getDescendantFocusability();
        tabWidget.setDescendantFocusability(393216);
        this.mTabHost.setCurrentTab(i);
        tabWidget.setDescendantFocusability(descendantFocusability);
    }

    public void setSmoothEabled(boolean z) {
        this.mSmooth = z;
    }
}
