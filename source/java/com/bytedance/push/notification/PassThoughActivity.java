package com.bytedance.push.notification;

import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PassThoughActivity extends PushActivity {
    /* renamed from: com_bytedance_push_notification_PassThoughActivity__onStop$___twin___ */
    public void m255x4fbfa61f() {
        super.onStop();
    }

    @Override // com.bytedance.push.notification.PushActivity
    protected boolean isPassThough() {
        return true;
    }

    @Override // android.app.Activity
    protected void onStop() {
        m254x1d6dc33c(this);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_bytedance_push_notification_PassThoughActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m254x1d6dc33c(PassThoughActivity passThoughActivity) {
        passThoughActivity.m255x4fbfa61f();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                passThoughActivity.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
