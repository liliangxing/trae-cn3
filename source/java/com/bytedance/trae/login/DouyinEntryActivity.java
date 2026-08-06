package com.bytedance.trae.login;

import android.app.Activity;
import com.bytedance.sdk.account.platform.douyin.BaseDouyinEntryActivity;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import kotlin.Metadata;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* compiled from: DouyinEntryActivity.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/trae/login/DouyinEntryActivity;", "Lcom/bytedance/sdk/account/platform/douyin/BaseDouyinEntryActivity;", "<init>", "()V", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class DouyinEntryActivity extends BaseDouyinEntryActivity {
    public void com_bytedance_trae_login_DouyinEntryActivity__onStop$___twin___() {
        super.onStop();
    }

    protected void onStop() {
        m377x277b70ec(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_bytedance_trae_login_DouyinEntryActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m377x277b70ec(DouyinEntryActivity douyinEntryActivity) {
        douyinEntryActivity.com_bytedance_trae_login_DouyinEntryActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                ((Activity) douyinEntryActivity).getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
