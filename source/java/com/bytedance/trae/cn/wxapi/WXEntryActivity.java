package com.bytedance.trae.cn.wxapi;

import android.app.Activity;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.bytedance.ug.sdk.share.channel.wechat.view.BaseWXEntryActivity;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class WXEntryActivity extends BaseWXEntryActivity {
    public void com_bytedance_trae_cn_wxapi_WXEntryActivity__onStop$___twin___() {
        super.onStop();
    }

    protected void onStop() {
        m808x815e1971(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_bytedance_trae_cn_wxapi_WXEntryActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m808x815e1971(WXEntryActivity wXEntryActivity) {
        wXEntryActivity.com_bytedance_trae_cn_wxapi_WXEntryActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                ((Activity) wXEntryActivity).getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
