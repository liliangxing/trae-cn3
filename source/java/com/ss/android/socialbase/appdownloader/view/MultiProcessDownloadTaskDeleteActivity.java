package com.ss.android.socialbase.appdownloader.view;

import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class MultiProcessDownloadTaskDeleteActivity extends DownloadTaskDeleteActivity {
    /* renamed from: com_ss_android_socialbase_appdownloader_view_MultiProcessDownloadTaskDeleteActivity__onStop$___twin___ */
    public void m120x584baffd() {
        super.onStop();
    }

    @Override // android.app.Activity
    protected void onStop() {
        m119x9872c1e(this);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_ss_android_socialbase_appdownloader_view_MultiProcessDownloadTaskDeleteActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m119x9872c1e(MultiProcessDownloadTaskDeleteActivity multiProcessDownloadTaskDeleteActivity) {
        multiProcessDownloadTaskDeleteActivity.m120x584baffd();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                multiProcessDownloadTaskDeleteActivity.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
