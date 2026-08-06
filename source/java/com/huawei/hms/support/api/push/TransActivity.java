package com.huawei.hms.support.api.push;

import android.app.Activity;
import android.os.Bundle;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.huawei.android.hms.push.R;
import com.huawei.hms.push.t;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: classes6.dex */
public class TransActivity extends Activity {
    public void com_huawei_hms_support_api_push_TransActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.hwpush_trans_activity);
        getWindow().addFlags(67108864);
        t.a(this, getIntent());
        finish();
    }

    @Override // android.app.Activity
    protected void onStop() {
        com_huawei_hms_support_api_push_TransActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_huawei_hms_support_api_push_TransActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(TransActivity transActivity) {
        transActivity.com_huawei_hms_support_api_push_TransActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                transActivity.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
