package com.bytedance.notification.activity;

import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: classes4.dex */
public class PushBannerActivity extends BannerActivity {
    public void com_bytedance_notification_activity_PushBannerActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // android.app.Activity
    protected void onStop() {
        com_bytedance_notification_activity_PushBannerActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_bytedance_notification_activity_PushBannerActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(PushBannerActivity pushBannerActivity) {
        pushBannerActivity.com_bytedance_notification_activity_PushBannerActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                pushBannerActivity.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
