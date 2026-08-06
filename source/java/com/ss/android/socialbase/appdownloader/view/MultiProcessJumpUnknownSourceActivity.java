package com.ss.android.socialbase.appdownloader.view;

import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: classes7.dex */
public class MultiProcessJumpUnknownSourceActivity extends JumpUnknownSourceActivity {
    public void com_ss_android_socialbase_appdownloader_view_MultiProcessJumpUnknownSourceActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // android.app.Activity
    protected void onStop() {
        com_ss_android_socialbase_appdownloader_view_MultiProcessJumpUnknownSourceActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_ss_android_socialbase_appdownloader_view_MultiProcessJumpUnknownSourceActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(MultiProcessJumpUnknownSourceActivity multiProcessJumpUnknownSourceActivity) {
        multiProcessJumpUnknownSourceActivity.com_ss_android_socialbase_appdownloader_view_MultiProcessJumpUnknownSourceActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                multiProcessJumpUnknownSourceActivity.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
