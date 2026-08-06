package com.bytedance.bdturing.livedetect;

import android.app.Activity;
import android.content.Intent;
import com.bytedance.bdturing.BdTuring;
import com.bytedance.bdturing.C0603R;
import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.livedetect.pty.TuringPTYManager;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class TuringLivePTYActivity extends TuringLiveDetectActivity {
    /* renamed from: com_bytedance_bdturing_livedetect_TuringLivePTYActivity__onStop$___twin___ */
    public void m178x97d642ea() {
        super.onStop();
    }

    protected void onStop() {
        m177xcf0ad951(this);
    }

    public static void startActivity(Activity activity, String str) {
        Intent intent = new Intent(activity, (Class<?>) TuringLivePTYActivity.class);
        intent.putExtra("detail", str);
        activity.startActivity(intent);
    }

    @Override // com.bytedance.bdturing.livedetect.TuringLiveDetectActivity
    protected void initEngine() {
        boolean isPTYReady = TuringPTYManager.getInstance().isPTYReady();
        EventReport.onLivePageCreate(TuringLiveDetectActivity.class.getName(), isPTYReady, this.mRequest);
        if (isPTYReady) {
            initTipsMap();
            createSession();
        } else {
            EventReport.liveDetectError(BdTuring.PTY_INIT_NOT_FINISH, "PTY init not finish:pkg_load=" + TuringPTYManager.getInstance().isPkgLoaded() + ":PTY Env_Available=" + TuringPTYManager.getInstance().isPTYAvailable() + ":appFirstLaunch=" + LiveAuthConfig.isAppFirstLaunch(), this.mRequest);
            showFailDlg(new String[]{getString(C0603R.string.turing_pty_not_ready_title), getString(C0603R.string.turing_pty_not_ready_content)});
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_bytedance_bdturing_livedetect_TuringLivePTYActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m177xcf0ad951(TuringLivePTYActivity turingLivePTYActivity) {
        turingLivePTYActivity.m178x97d642ea();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                ((Activity) turingLivePTYActivity).getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
