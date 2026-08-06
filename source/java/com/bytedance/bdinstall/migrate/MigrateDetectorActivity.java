package com.bytedance.bdinstall.migrate;

import android.app.Activity;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: classes3.dex */
public final class MigrateDetectorActivity extends Activity {
    public void com_bytedance_bdinstall_migrate_MigrateDetectorActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // android.app.Activity
    protected void onStop() {
        com_bytedance_bdinstall_migrate_MigrateDetectorActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_bytedance_bdinstall_migrate_MigrateDetectorActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(MigrateDetectorActivity migrateDetectorActivity) {
        migrateDetectorActivity.com_bytedance_bdinstall_migrate_MigrateDetectorActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                migrateDetectorActivity.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
