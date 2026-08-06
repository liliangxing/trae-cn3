package com.bytedance.ies.uikit.tabhost;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class FragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {
    private boolean mAttached;
    private int mContainerId;
    private Context mContext;
    private FragmentManager mFragmentManager;
    private boolean mHideWhenTabChanged;
    private TabInfo mLastTab;
    private boolean mOnTabChangeCalled;
    private TabHost.OnTabChangeListener mOnTabChangeListener;
    private FrameLayout mRealTabContent;
    private OnTabSwitchInterceptListener mTabSwitchInterceptListener;
    private OnTabSwitchListener mTabSwitchListener;
    private final ArrayList<TabInfo> mTabs;
    private boolean mToAll;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface OnTabSwitchInterceptListener {
        boolean dispatchTabChangedBefore();

        boolean interceptLoading(String str, Fragment fragment, Fragment fragment2);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface OnTabSwitchListener {
        void onTabSwitched(String str, Fragment fragment, Fragment fragment2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class TabInfo {
        private Bundle args;
        private final Class<?> clss;
        private Fragment fragment;
        private final String tag;

        TabInfo(String str, Class<?> cls, Bundle bundle) {
            this.tag = str;
            this.clss = cls;
            this.args = bundle;
        }

        public void updateArgs(Bundle bundle) {
            this.args = bundle;
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    static class DummyTabFactory implements TabHost.TabContentFactory {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.bytedance.ies.uikit.tabhost.FragmentTabHost.SavedState.1
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
        String curTab;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.curTab = parcel.readString();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.curTab);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.curTab + "}";
        }
    }

    public FragmentTabHost(Context context) {
        super(context, null);
        this.mToAll = false;
        this.mTabs = new ArrayList<>();
        this.mHideWhenTabChanged = false;
        this.mOnTabChangeCalled = false;
        initFragmentTabHost(context, null);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mToAll = false;
        this.mTabs = new ArrayList<>();
        this.mHideWhenTabChanged = false;
        this.mOnTabChangeCalled = false;
        initFragmentTabHost(context, attributeSet);
    }

    private void initFragmentTabHost(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.inflatedId}, 0, 0);
        this.mContainerId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        Context context = getContext();
        if (context != null && findViewById(R.id.tabs) == null) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
            TabWidget tabWidget = new TabWidget(context);
            tabWidget.setId(R.id.tabs);
            tabWidget.setOrientation(0);
            linearLayout.addView(tabWidget, new LinearLayout.LayoutParams(-1, -2, 0.0f));
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setId(R.id.tabcontent);
            linearLayout.addView(frameLayout, new LinearLayout.LayoutParams(0, 0, 0.0f));
            FrameLayout frameLayout2 = new FrameLayout(context);
            this.mRealTabContent = frameLayout2;
            frameLayout2.setId(this.mContainerId);
            linearLayout.addView(frameLayout2, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        }
    }

    public void setDispatchWindowFocusChangedToAllTab(boolean z) {
        this.mToAll = z;
    }

    public boolean getDispatchWindowFocusChangedToAllTab() {
        return this.mToAll;
    }

    @Override // android.widget.TabHost, android.view.ViewGroup, android.view.View
    public void dispatchWindowFocusChanged(boolean z) {
        if (this.mToAll) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).dispatchWindowFocusChanged(z);
            }
            return;
        }
        super.dispatchWindowFocusChanged(z);
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    public void setup(Context context, FragmentManager fragmentManager) {
        super.setup();
        this.mContext = context;
        this.mFragmentManager = fragmentManager;
        ensureContent();
    }

    public void setup(Context context, FragmentManager fragmentManager, int i) {
        super.setup();
        this.mContext = context;
        this.mFragmentManager = fragmentManager;
        this.mContainerId = i;
        ensureContent();
        this.mRealTabContent.setId(i);
        if (getId() == -1) {
            setId(R.id.tabhost);
        }
    }

    private void ensureContent() {
        if (this.mRealTabContent == null) {
            FrameLayout frameLayout = (FrameLayout) findViewById(this.mContainerId);
            this.mRealTabContent = frameLayout;
            if (frameLayout == null) {
                throw new IllegalStateException("No tab content FrameLayout found for id " + this.mContainerId);
            }
        }
    }

    public Fragment getCurrentFragment() {
        TabInfo tabInfo = this.mLastTab;
        if (tabInfo != null) {
            return tabInfo.fragment;
        }
        return null;
    }

    public void setHideWhenTabChanged(boolean z) {
        if (!this.mOnTabChangeCalled) {
            this.mHideWhenTabChanged = z;
        } else {
            Log.w("FragmentTabHost", "setHideWhenTabChanged after onTabChanged, ignore");
        }
    }

    public void setOnTabSwitchListener(OnTabSwitchListener onTabSwitchListener) {
        this.mTabSwitchListener = onTabSwitchListener;
    }

    public void setTabSwitchInterceptListener(OnTabSwitchInterceptListener onTabSwitchInterceptListener) {
        this.mTabSwitchInterceptListener = onTabSwitchInterceptListener;
    }

    @Override // android.widget.TabHost
    public void setOnTabChangedListener(TabHost.OnTabChangeListener onTabChangeListener) {
        this.mOnTabChangeListener = onTabChangeListener;
    }

    public void setSuperOnTabChangedListener(TabHost.OnTabChangeListener onTabChangeListener) {
        super.setOnTabChangedListener(onTabChangeListener);
    }

    public void addTab(TabHost.TabSpec tabSpec, Class<?> cls, Bundle bundle) {
        tabSpec.setContent(new DummyTabFactory(this.mContext));
        String tag = tabSpec.getTag();
        TabInfo tabInfo = new TabInfo(tag, cls, bundle);
        if (this.mAttached) {
            tabInfo.fragment = this.mFragmentManager.findFragmentByTag(tag);
            if (tabInfo.fragment != null && !tabInfo.fragment.isDetached()) {
                FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
                beginTransaction.detach(tabInfo.fragment);
                beginTransaction.commitAllowingStateLoss();
            }
        }
        this.mTabs.add(tabInfo);
        addTab(tabSpec);
    }

    public void updateTabFragmentArgs(String str, Bundle bundle) {
        Iterator<TabInfo> it = this.mTabs.iterator();
        while (it.hasNext()) {
            TabInfo next = it.next();
            if (next != null && TextUtils.equals(next.tag, str)) {
                next.updateArgs(bundle);
                return;
            }
        }
    }

    public void removeFragment(Class<?> cls) {
        ArrayList<TabInfo> arrayList = this.mTabs;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        Iterator<TabInfo> it = this.mTabs.iterator();
        while (it.hasNext()) {
            TabInfo next = it.next();
            if (next != null && next.clss == cls) {
                if (next.fragment != null) {
                    FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
                    beginTransaction.remove(next.fragment);
                    beginTransaction.commitAllowingStateLoss();
                    this.mFragmentManager.executePendingTransactions();
                    next.fragment = null;
                    return;
                }
                return;
            }
        }
    }

    public void removeTabInfo(Class<?> cls) {
        ArrayList<TabInfo> arrayList = this.mTabs;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        Iterator<TabInfo> it = this.mTabs.iterator();
        while (it.hasNext()) {
            TabInfo next = it.next();
            if (next != null && next.clss == cls) {
                if (next.fragment != null) {
                    FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
                    beginTransaction.remove(next.fragment);
                    beginTransaction.commitAllowingStateLoss();
                    this.mFragmentManager.executePendingTransactions();
                    next.fragment = null;
                }
                it.remove();
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        FragmentTransaction fragmentTransaction = null;
        for (int i = 0; i < this.mTabs.size(); i++) {
            TabInfo tabInfo = this.mTabs.get(i);
            tabInfo.fragment = this.mFragmentManager.findFragmentByTag(tabInfo.tag);
            if (tabInfo.fragment != null && !tabInfo.fragment.isDetached()) {
                if (!tabInfo.tag.equals(currentTabTag)) {
                    if (fragmentTransaction == null) {
                        fragmentTransaction = this.mFragmentManager.beginTransaction();
                    }
                    fragmentTransaction.detach(tabInfo.fragment);
                } else {
                    this.mLastTab = tabInfo;
                }
            }
        }
        this.mAttached = true;
        FragmentTransaction doTabChanged = doTabChanged(currentTabTag, fragmentTransaction);
        if (doTabChanged != null) {
            doTabChanged.commitAllowingStateLoss();
            this.mFragmentManager.executePendingTransactions();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mAttached = false;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.curTab = getCurrentTabTag();
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.curTab);
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    public void onTabChanged(final String str) {
        Fragment fragment = null;
        if (this.mAttached) {
            TabInfo tabInfo = this.mLastTab;
            final Fragment fragment2 = tabInfo != null ? tabInfo.fragment : null;
            final FragmentTransaction doTabChanged = doTabChanged(str, null);
            if (doTabChanged != null) {
                if (this.mTabSwitchInterceptListener != null && !this.mLastTab.fragment.isAdded() && this.mTabSwitchInterceptListener.interceptLoading(str, fragment2, this.mLastTab.fragment)) {
                    Handler handler = getHandler();
                    if (handler != null) {
                        if (this.mTabSwitchInterceptListener.dispatchTabChangedBefore()) {
                            dispatchTabSwitched(str, fragment2);
                        }
                        handler.post(new Runnable() { // from class: com.bytedance.ies.uikit.tabhost.FragmentTabHost.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (FragmentTabHost.this.mFragmentManager.isDestroyed()) {
                                    return;
                                }
                                doTabChanged.commitAllowingStateLoss();
                                FragmentTabHost.this.mFragmentManager.executePendingTransactions();
                                if (FragmentTabHost.this.mTabSwitchInterceptListener.dispatchTabChangedBefore()) {
                                    return;
                                }
                                FragmentTabHost.this.dispatchTabSwitched(str, fragment2);
                            }
                        });
                        return;
                    }
                    return;
                }
                doTabChanged.commitAllowingStateLoss();
                this.mFragmentManager.executePendingTransactions();
            }
            fragment = fragment2;
        }
        dispatchTabSwitched(str, fragment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchTabSwitched(String str, Fragment fragment) {
        TabHost.OnTabChangeListener onTabChangeListener = this.mOnTabChangeListener;
        if (onTabChangeListener != null) {
            onTabChangeListener.onTabChanged(str);
        }
        if (this.mTabSwitchListener != null) {
            TabInfo tabInfo = this.mLastTab;
            Fragment fragment2 = tabInfo != null ? tabInfo.fragment : null;
            if (fragment2 != fragment) {
                this.mTabSwitchListener.onTabSwitched(str, fragment2, fragment);
            }
        }
    }

    private FragmentTransaction doTabChanged(String str, FragmentTransaction fragmentTransaction) {
        this.mOnTabChangeCalled = true;
        TabInfo tabInfo = null;
        for (int i = 0; i < this.mTabs.size(); i++) {
            TabInfo tabInfo2 = this.mTabs.get(i);
            if (tabInfo2.tag.equals(str)) {
                tabInfo = tabInfo2;
            }
        }
        if (tabInfo == null) {
            return null;
        }
        if (this.mLastTab != tabInfo) {
            if (fragmentTransaction == null) {
                fragmentTransaction = this.mFragmentManager.beginTransaction();
            }
            TabInfo tabInfo3 = this.mLastTab;
            if (tabInfo3 != null && tabInfo3.fragment != null) {
                if (this.mHideWhenTabChanged) {
                    fragmentTransaction.hide(this.mLastTab.fragment);
                } else {
                    fragmentTransaction.detach(this.mLastTab.fragment);
                }
            }
            if (tabInfo != null) {
                if (tabInfo.fragment == null) {
                    tabInfo.fragment = Fragment.instantiate(this.mContext, tabInfo.clss.getName(), tabInfo.args);
                    fragmentTransaction.add(this.mContainerId, tabInfo.fragment, tabInfo.tag);
                } else if (this.mHideWhenTabChanged) {
                    if (tabInfo.fragment.isDetached()) {
                        fragmentTransaction.attach(tabInfo.fragment);
                    }
                    fragmentTransaction.show(tabInfo.fragment);
                } else {
                    fragmentTransaction.attach(tabInfo.fragment);
                }
            }
            this.mLastTab = tabInfo;
        }
        return fragmentTransaction;
    }
}
