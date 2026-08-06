package com.ss.android.deviceregister;

import android.app.Activity;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: classes7.dex */
public final class AActivity extends Activity {
    public void com_ss_android_deviceregister_AActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // android.app.Activity
    protected void onStop() {
        com_ss_android_deviceregister_AActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_ss_android_deviceregister_AActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(AActivity aActivity) {
        aActivity.com_ss_android_deviceregister_AActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                aActivity.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
