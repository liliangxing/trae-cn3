package com.bytedance.ies.uikit.base;

import android.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.ies.uikit.tabhost.FragmentTabHost;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.bytedance.ugc.uikit.C1158R;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public abstract class AbsTabActivity extends AbsActivity {
    protected LayoutInflater mInflater;
    protected FragmentTabHost mTabHost;
    protected TabWidget mTabWidget;
    protected String mPendingTag = null;
    protected Map<String, WeakReference<View>> mIndicatorMap = new HashMap();
    protected final FragmentTabHost.OnTabSwitchListener mTabListener = new FragmentTabHost.OnTabSwitchListener() { // from class: com.bytedance.ies.uikit.base.AbsTabActivity.1
        @Override // com.bytedance.ies.uikit.tabhost.FragmentTabHost.OnTabSwitchListener
        public void onTabSwitched(String str, Fragment fragment, Fragment fragment2) {
            AbsTabActivity.this.handleTabSwitch(str, fragment, fragment2);
        }
    };

    public void com_bytedance_ies_uikit_base_AbsTabActivity__onStop$___twin___() {
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.ies.uikit.base.AbsActivity
    public void onStop() {
        m59xe8237a09(this);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class TabEntry {
        public final Bundle args;
        public final Class<? extends Fragment> clz;
        public final int icon;
        public final String tag;
        public final int title;

        public TabEntry(String str, int i, int i2, Class<? extends Fragment> cls, Bundle bundle) {
            this.tag = str;
            this.title = i;
            this.icon = i2;
            this.clz = cls;
            this.args = bundle;
        }
    }

    protected Fragment getCurrentFragment() {
        FragmentTabHost fragmentTabHost = this.mTabHost;
        if (fragmentTabHost != null) {
            return fragmentTabHost.getCurrentFragment();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void initTab(Bundle bundle, List<TabEntry> list) {
        this.mInflater = LayoutInflater.from(this);
        FragmentTabHost fragmentTabHost = (FragmentTabHost) findViewById(R.id.tabhost);
        this.mTabHost = fragmentTabHost;
        fragmentTabHost.setHideWhenTabChanged(true);
        this.mTabHost.setOnTabSwitchListener(this.mTabListener);
        this.mTabHost.setup(this, getSupportFragmentManager(), C1158R.id.realtabcontent);
        this.mTabWidget = (TabWidget) findViewById(R.id.tabs);
        for (TabEntry tabEntry : list) {
            TabHost.TabSpec newTabSpec = this.mTabHost.newTabSpec(tabEntry.tag);
            View makeIndicator = makeIndicator(tabEntry.tag, tabEntry.title, tabEntry.icon);
            newTabSpec.setIndicator(makeIndicator);
            this.mTabHost.addTab(newTabSpec, tabEntry.clz, tabEntry.args);
            this.mIndicatorMap.put(tabEntry.tag, new WeakReference<>(makeIndicator));
        }
        this.mPendingTag = null;
    }

    protected View getIndicatorView(String str) {
        WeakReference<View> weakReference = this.mIndicatorMap.get(str);
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public String getCurrentTabTag() {
        return this.mTabHost.getCurrentTabTag();
    }

    protected void handleTabSwitch(String str, Fragment fragment, Fragment fragment2) {
        if (fragment2 != null && (fragment2 instanceof ITabFragment)) {
            ((ITabFragment) fragment2).onTabUnSelected();
        }
        if (fragment == null || !(fragment instanceof ITabFragment)) {
            return;
        }
        ((ITabFragment) fragment).onTabSelected();
    }

    protected View makeIndicator(String str, int i, int i2) {
        String string = getString(i);
        View inflate = this.mInflater.inflate(C1158R.layout.tab_indicator, (ViewGroup) this.mTabWidget, false);
        ((TextView) inflate.findViewById(C1158R.id.indicator_title)).setText(string);
        ((ImageView) inflate.findViewById(C1158R.id.indicator_icon)).setImageResource(i2);
        return inflate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_bytedance_ies_uikit_base_AbsTabActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m59xe8237a09(AbsTabActivity absTabActivity) {
        absTabActivity.com_bytedance_ies_uikit_base_AbsTabActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                ((Activity) absTabActivity).getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
