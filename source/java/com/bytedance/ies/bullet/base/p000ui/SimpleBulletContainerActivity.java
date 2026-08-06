package com.bytedance.ies.bullet.base.p000ui;

import android.app.Activity;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.p003ui.common.AbsBulletContainerActivity;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import kotlin.Metadata;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* compiled from: SimpleBulletContainerActivity.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ies/bullet/base/ui/SimpleBulletContainerActivity;", "Lcom/bytedance/ies/bullet/ui/common/AbsBulletContainerActivity;", "()V", "getBid", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class SimpleBulletContainerActivity extends AbsBulletContainerActivity {
    /* renamed from: com_bytedance_ies_bullet_base_ui_SimpleBulletContainerActivity__onStop$___twin___ */
    public void m6xa0712a7f() {
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.ies.bullet.p003ui.common.AbsBulletContainerActivity, com.bytedance.ies.uikit.base.AbsActivity
    public void onStop() {
        m5x2f197adc(this);
    }

    @Override // com.bytedance.ies.bullet.p003ui.common.AbsBulletContainerActivity, com.bytedance.ies.bullet.service.base.IRouterAbilityProvider
    public String getBid() {
        String bid;
        BulletContext bulletContext = getBulletContext();
        return (bulletContext == null || (bid = bulletContext.getBid()) == null) ? super.getBid() : bid;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_bytedance_ies_bullet_base_ui_SimpleBulletContainerActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m5x2f197adc(SimpleBulletContainerActivity simpleBulletContainerActivity) {
        simpleBulletContainerActivity.m6xa0712a7f();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                ((Activity) simpleBulletContainerActivity).getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
