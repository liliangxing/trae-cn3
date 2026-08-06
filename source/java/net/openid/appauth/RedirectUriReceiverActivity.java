package net.openid.appauth;

import android.app.Activity;
import android.os.Bundle;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: classes8.dex */
public class RedirectUriReceiverActivity extends Activity {
    public void net_openid_appauth_RedirectUriReceiverActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // android.app.Activity
    protected void onStop() {
        net_openid_appauth_RedirectUriReceiverActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        startActivity(AuthorizationManagementActivity.createResponseHandlingIntent(this, getIntent().getData()));
        finish();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void net_openid_appauth_RedirectUriReceiverActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(RedirectUriReceiverActivity redirectUriReceiverActivity) {
        redirectUriReceiverActivity.net_openid_appauth_RedirectUriReceiverActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                redirectUriReceiverActivity.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
