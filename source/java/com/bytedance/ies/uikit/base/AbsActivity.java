package com.bytedance.ies.uikit.base;

import android.R;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakContainer;
import com.bytedance.ies.uikit.base.AppHooks;
import com.bytedance.ies.uikit.layout.SafeViewLayout;
import com.bytedance.ies.uikit.statusbar.WindowTintManager;
import com.bytedance.ies.uikit.util.SafeViewManager;
import com.bytedance.ugc.uikit.C1158R;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public abstract class AbsActivity extends AppCompatActivity implements IComponent {
    public static final String ACTION_EXIT_APP = "com.ss.android.common.app.action.exit_app";
    private static final String KEY = "abs_Activity_Key";
    private static final int SYSTEM_UI_FLAG_LIGHT_STATUS_BAR = 8192;
    private static volatile int sActivityId;
    private boolean mDisableOptimizeViewHierarchy;
    private BroadcastReceiver mExitAppReceiver;
    private String mKey;
    protected WindowTintManager mTintManager;
    private static Set<String> sActivitySet = new HashSet();
    private static WeakContainer<AbsActivity> sFinishedActivityContainer = new WeakContainer<>();
    protected static int mStartNum = 0;
    protected boolean mStatusActive = false;
    protected boolean mStatusDestroyed = false;
    private WeakContainer<LifeCycleMonitor> mMonitors = new WeakContainer<>();
    private long mDestoryTime = 0;

    protected boolean enableInitHook() {
        return true;
    }

    public boolean enableMobClick() {
        return true;
    }

    public int getRootViewId() {
        return 0;
    }

    public int getStatusBarBgColor() {
        return WindowTintManager.DEFAULT_TINT_COLOR;
    }

    public int getWindowsFlags() {
        return 0;
    }

    protected boolean useImmerseMode() {
        return true;
    }

    protected void requestDisableOptimizeViewHierarchy() {
        this.mDisableOptimizeViewHierarchy = true;
    }

    public void onSupportContentChanged() {
        View findViewById;
        super.onSupportContentChanged();
        if (this.mDisableOptimizeViewHierarchy || (findViewById = findViewById(C1158R.id.action_bar_root)) == null) {
            return;
        }
        ViewParent parent = findViewById.getParent();
        if (FrameLayout.class.isInstance(parent)) {
            View findViewById2 = findViewById(R.id.content);
            if (FrameLayout.class.isInstance(findViewById2)) {
                FrameLayout frameLayout = (FrameLayout) findViewById2;
                if (frameLayout.getChildCount() != 1) {
                    return;
                }
                View childAt = frameLayout.getChildAt(0);
                frameLayout.removeAllViews();
                FrameLayout frameLayout2 = (FrameLayout) parent;
                frameLayout2.addView(childAt);
                findViewById2.setId(-1);
                frameLayout2.setId(R.id.content);
            }
        }
    }

    public static String getAliveActivitiesString() {
        Set<String> set = sActivitySet;
        if (set != null && !set.isEmpty()) {
            try {
                StringBuilder sb = new StringBuilder();
                int i = 0;
                for (String str : sActivitySet) {
                    if (i < sActivitySet.size() - 1) {
                        sb.append(str).append("|");
                    } else {
                        sb.append(str);
                    }
                    i++;
                }
                return sb.toString();
            } catch (Throwable unused) {
            }
        }
        return "";
    }

    public static String getFinishedActivitiesString() {
        WeakContainer<AbsActivity> weakContainer = sFinishedActivityContainer;
        if (weakContainer != null && !weakContainer.isEmpty()) {
            try {
                StringBuilder sb = new StringBuilder();
                Iterator it = sFinishedActivityContainer.iterator();
                int i = 0;
                while (it.hasNext()) {
                    AbsActivity absActivity = (AbsActivity) it.next();
                    if (absActivity != null && !sActivitySet.contains(absActivity.mKey) && absActivity.isFinishing()) {
                        if (i < sFinishedActivityContainer.size() - 1) {
                            sb.append(absActivity.mKey).append("|");
                        } else {
                            sb.append(absActivity.mKey);
                        }
                    }
                    i++;
                }
                return sb.toString();
            } catch (Throwable unused) {
            }
        }
        return "";
    }

    public static void onActivityCreate(AbsActivity absActivity) {
        if (absActivity != null) {
            try {
                sFinishedActivityContainer.add(absActivity);
                sActivitySet.add(absActivity.mKey);
            } catch (Throwable unused) {
            }
        }
    }

    public static void onActivityDestroy(AbsActivity absActivity) {
        if (absActivity != null) {
            try {
                sActivitySet.remove(absActivity.mKey);
            } catch (Throwable unused) {
            }
        }
    }

    public void registerLifeCycleMonitor(LifeCycleMonitor lifeCycleMonitor) {
        this.mMonitors.add(lifeCycleMonitor);
    }

    public void unregisterLifeCycleMonitor(LifeCycleMonitor lifeCycleMonitor) {
        this.mMonitors.remove(lifeCycleMonitor);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null && bundle.containsKey(KEY)) {
            this.mKey = bundle.getString(KEY);
        } else {
            StringBuilder append = new StringBuilder().append(getClass().getCanonicalName()).append("@");
            int i = sActivityId;
            sActivityId = i + 1;
            this.mKey = append.append(i).toString();
        }
        AppHooks.InitHook initHook = AppHooks.getInitHook();
        if (initHook != null && enableInitHook()) {
            initHook.tryInit(this);
        }
        this.mExitAppReceiver = new BroadcastReceiver() { // from class: com.bytedance.ies.uikit.base.AbsActivity.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (AbsActivity.this.isFinishing()) {
                    return;
                }
                AbsActivity.this.finish();
            }
        };
        LocalBroadcastManager.getInstance(this).registerReceiver(this.mExitAppReceiver, new IntentFilter(ACTION_EXIT_APP));
        onActivityCreate(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setContentView(int i) {
        if (SafeViewManager.SafeViewSetting) {
            try {
                onSetContentView(LayoutInflater.from(this).inflate(i, (ViewGroup) null));
            } catch (InflateException unused) {
                super.setContentView(i);
            }
        } else {
            super.setContentView(i);
        }
        if (useImmerseMode()) {
            setStatusBarColor();
        }
    }

    public void setContentView(View view) {
        if (SafeViewManager.SafeViewSetting) {
            onSetContentView(view);
        } else {
            super.setContentView(view);
        }
        if (useImmerseMode()) {
            setStatusBarColor();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onSetContentView(View view) {
        SafeViewLayout safeViewLayout = new SafeViewLayout(this);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        safeViewLayout.setPadding(0, 0, 0, 0);
        safeViewLayout.setLayoutParams(layoutParams);
        super.setContentView(safeViewLayout, new ViewGroup.LayoutParams(-1, -1));
        safeViewLayout.addView(view, -1, -1);
    }

    protected int getStatusBarColor() {
        return getResources().getColor(C1158R.color.colorPrimaryStatusBar);
    }

    protected void setStatusBarColor() {
        getWindow().setStatusBarColor(getStatusBarColor());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            bundle.putString(KEY, this.mKey);
            bundle.putBoolean("WORKAROUND_FOR_BUG_19917_KEY", true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        if (bundle == null || !bundle.containsKey(KEY)) {
            return;
        }
        this.mKey = bundle.getString(KEY);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onResume() {
        super.onResume();
        this.mStatusActive = true;
        AppHooks.ActivityLifeCycleHook activityHook = AppHooks.getActivityHook();
        if (activityHook != null) {
            activityHook.onActivityResumed(this);
        }
        if (this.mMonitors.isEmpty()) {
            return;
        }
        Iterator it = this.mMonitors.iterator();
        while (it.hasNext()) {
            LifeCycleMonitor lifeCycleMonitor = (LifeCycleMonitor) it.next();
            if (lifeCycleMonitor != null) {
                lifeCycleMonitor.onResume();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStart() {
        AppHooks.AppBackgroundHook appBackgroundHook;
        super.onStart();
        if (mStartNum == 0 && (appBackgroundHook = AppHooks.getAppBackgroundHook()) != null) {
            appBackgroundHook.onAppBackgoundSwitch(false);
        }
        mStartNum++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStop() {
        AppHooks.AppBackgroundHook appBackgroundHook;
        super.onStop();
        int i = mStartNum - 1;
        mStartNum = i;
        if (i == 0 && (appBackgroundHook = AppHooks.getAppBackgroundHook()) != null) {
            appBackgroundHook.onAppBackgoundSwitch(true);
        }
        this.mStatusActive = false;
        if (this.mMonitors.isEmpty()) {
            return;
        }
        Iterator it = this.mMonitors.iterator();
        while (it.hasNext()) {
            LifeCycleMonitor lifeCycleMonitor = (LifeCycleMonitor) it.next();
            if (lifeCycleMonitor != null) {
                lifeCycleMonitor.onStop();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onPause() {
        super.onPause();
        this.mStatusActive = false;
        AppHooks.ActivityLifeCycleHook activityHook = AppHooks.getActivityHook();
        if (activityHook != null) {
            activityHook.onActivityPaused(this);
        }
        if (this.mMonitors.isEmpty()) {
            return;
        }
        Iterator it = this.mMonitors.iterator();
        while (it.hasNext()) {
            LifeCycleMonitor lifeCycleMonitor = (LifeCycleMonitor) it.next();
            if (lifeCycleMonitor != null) {
                lifeCycleMonitor.onPause();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onDestroy() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.mExitAppReceiver);
        super.onDestroy();
        this.mDestoryTime = System.currentTimeMillis();
        this.mStatusDestroyed = true;
        if (!this.mMonitors.isEmpty()) {
            Iterator it = this.mMonitors.iterator();
            while (it.hasNext()) {
                LifeCycleMonitor lifeCycleMonitor = (LifeCycleMonitor) it.next();
                if (lifeCycleMonitor != null) {
                    lifeCycleMonitor.onDestroy();
                }
            }
            this.mMonitors.clear();
        }
        onActivityDestroy(this);
        if (Logger.debug()) {
            Logger.d("SS_OOM", "onDestroy FinishedActivities = " + getFinishedActivitiesString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int i, int i2, Intent intent) {
        AppHooks.ActivityResultHook activityResultHook = AppHooks.getActivityResultHook();
        if (activityResultHook == null || !activityResultHook.onActivityResult(this, i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.bytedance.ies.uikit.base.IComponent
    public boolean isActive() {
        return this.mStatusActive;
    }

    @Override // com.bytedance.ies.uikit.base.IComponent
    public boolean isViewValid() {
        return !this.mStatusDestroyed;
    }

    public boolean isDestroyed2() {
        return this.mStatusDestroyed;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void immersionWindow(View view, boolean z) {
        Window window = getWindow();
        window.clearFlags(67108864);
        int windowsFlags = getWindowsFlags();
        int statusBarBgColor = getStatusBarBgColor();
        window.getDecorView().setSystemUiVisibility((z ? 0 : 8192) | 1280);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(getResources().getColor(R.color.transparent));
        WindowTintManager windowTintManager = new WindowTintManager(this, view, windowsFlags);
        this.mTintManager = windowTintManager;
        windowTintManager.setTintColor(statusBarBgColor);
        this.mTintManager.setStatusBarTintEnabled(true);
        this.mTintManager.setNavigationBarTintEnabled(false);
    }

    public void initImmersion(View view, boolean z) {
        if (view == null && getRootViewId() > 0) {
            view = findViewById(getRootViewId());
        }
        if (view != null && getRootViewId() >= 0) {
            immersionWindow(view, z);
        } else if (getRootViewId() == -1) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(getStatusBarBgColor());
        }
    }

    public void setStatusBarBgColor(int i) {
        this.mTintManager.setStatusBarTintColor(i);
    }

    public WindowTintManager getTintManager() {
        return this.mTintManager;
    }
}
