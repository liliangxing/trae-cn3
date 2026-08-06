package com.bytedance.apm.trace;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.fragment.app.Fragment;
import com.bytedance.apm.agent.monitor.MonitorTool;
import com.bytedance.apm.agent.tracing.AutoPageTraceHelper;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.trace.mapping.ApmPageLoadMappingTool;
import com.bytedance.services.apm.api.IActivityLifeObserver;
import java.lang.ref.WeakReference;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class PageTimeMonitor implements IActivityLifeObserver {
    private String mCurrentActivityName;
    private long mMaxWaitTime;
    private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    private boolean mSwitchOn;
    private Runnable mWaitViewTimeoutRunnable;
    private long mActivityOnCreateStartTime = -1;
    private Handler mMainHandler = new Handler(Looper.getMainLooper());

    public void onActivityResume(Activity activity) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onBackground(Activity activity) {
    }

    public void onChange(Activity activity, Fragment fragment) {
    }

    public void onFront(Activity activity) {
    }

    public void init(long j, boolean z) {
        this.mMaxWaitTime = j;
        this.mSwitchOn = z;
        ActivityLifeObserver.getInstance().register(this);
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (this.mSwitchOn) {
            try {
                handleAutoPageTraceTime(activity);
            } catch (Exception unused) {
            }
        }
    }

    public void onActivityPause(Activity activity) {
        this.mActivityOnCreateStartTime = 0L;
        try {
            if (this.mOnGlobalLayoutListener != null) {
                activity.getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
                this.mOnGlobalLayoutListener = null;
            }
            Runnable runnable = this.mWaitViewTimeoutRunnable;
            if (runnable != null) {
                this.mMainHandler.removeCallbacks(runnable);
                this.mWaitViewTimeoutRunnable = null;
            }
        } catch (Exception unused) {
        }
    }

    private void handleAutoPageTraceTime(Activity activity) {
        this.mActivityOnCreateStartTime = System.currentTimeMillis();
        String canonicalName = activity.getClass().getCanonicalName();
        this.mCurrentActivityName = canonicalName;
        final Integer queryViewId = ApmPageLoadMappingTool.queryViewId(canonicalName);
        if (queryViewId == null) {
            return;
        }
        final WeakReference weakReference = new WeakReference(activity.getWindow().getDecorView());
        this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.apm.trace.PageTimeMonitor.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                View findViewById;
                if (weakReference.get() != null && (findViewById = ((View) weakReference.get()).findViewById(queryViewId.intValue())) != null && findViewById.getVisibility() == 0 && findViewById.getWidth() > 0) {
                    ViewTreeObserver viewTreeObserver = ((View) weakReference.get()).getViewTreeObserver();
                    if (viewTreeObserver.isAlive() && PageTimeMonitor.this.mOnGlobalLayoutListener != null) {
                        viewTreeObserver.removeOnGlobalLayoutListener(PageTimeMonitor.this.mOnGlobalLayoutListener);
                    }
                    if (PageTimeMonitor.this.mWaitViewTimeoutRunnable != null) {
                        PageTimeMonitor.this.mMainHandler.removeCallbacks(PageTimeMonitor.this.mWaitViewTimeoutRunnable);
                        PageTimeMonitor.this.mWaitViewTimeoutRunnable = null;
                    }
                    PageTimeMonitor.this.mOnGlobalLayoutListener = null;
                    if (PageTimeMonitor.this.mActivityOnCreateStartTime > 0) {
                        long currentTimeMillis = System.currentTimeMillis();
                        long j = currentTimeMillis - PageTimeMonitor.this.mActivityOnCreateStartTime;
                        PageTimeMonitor.this.mActivityOnCreateStartTime = 0L;
                        if (j >= PageTimeMonitor.this.mMaxWaitTime || j <= 0) {
                            return;
                        }
                        AutoPageTraceHelper.reportViewIdStats(currentTimeMillis, PageTimeMonitor.this.mCurrentActivityName);
                        MonitorTool.reportTraceTime(PageTimeMonitor.this.mCurrentActivityName, TraceConfig.KEY_PAGE_LOAD_TO_VIEW_SHOW_TIME, j);
                    }
                }
            }
        };
        ((View) weakReference.get()).getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        Runnable runnable = new Runnable() { // from class: com.bytedance.apm.trace.PageTimeMonitor.2
            @Override // java.lang.Runnable
            public void run() {
                if (PageTimeMonitor.this.mOnGlobalLayoutListener == null || weakReference.get() == null) {
                    return;
                }
                ((View) weakReference.get()).getViewTreeObserver().removeOnGlobalLayoutListener(PageTimeMonitor.this.mOnGlobalLayoutListener);
            }
        };
        this.mWaitViewTimeoutRunnable = runnable;
        this.mMainHandler.postDelayed(runnable, this.mMaxWaitTime);
    }
}
