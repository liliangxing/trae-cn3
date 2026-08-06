package com.huawei.hms.activity;

import android.app.Activity;
import android.os.Bundle;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.huawei.hms.utils.ResourceLoaderUtil;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: classes6.dex */
public class EnableServiceActivity extends Activity {
    public void com_huawei_hms_activity_EnableServiceActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        if (ResourceLoaderUtil.getmContext() == null) {
            ResourceLoaderUtil.setmContext(getApplicationContext());
        }
        setContentView(ResourceLoaderUtil.getLayoutId("activity_endisable_service"));
    }

    @Override // android.app.Activity
    protected void onStop() {
        com_huawei_hms_activity_EnableServiceActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_huawei_hms_activity_EnableServiceActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(EnableServiceActivity enableServiceActivity) {
        enableServiceActivity.com_huawei_hms_activity_EnableServiceActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                enableServiceActivity.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
