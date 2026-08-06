package com.bytedance.notification.activity;

import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: classes4.dex */
public class SmpBannerActivity extends BannerActivity {
    public void com_bytedance_notification_activity_SmpBannerActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // android.app.Activity
    protected void onStop() {
        com_bytedance_notification_activity_SmpBannerActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_bytedance_notification_activity_SmpBannerActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(SmpBannerActivity smpBannerActivity) {
        smpBannerActivity.com_bytedance_notification_activity_SmpBannerActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                smpBannerActivity.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
