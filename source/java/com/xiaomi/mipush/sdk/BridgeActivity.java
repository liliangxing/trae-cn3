package com.xiaomi.mipush.sdk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class BridgeActivity extends Activity {
    public void com_xiaomi_mipush_sdk_BridgeActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // android.app.Activity
    protected void onStop() {
        m1163xc91d0aa0(this);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.height = 1;
        attributes.width = 1;
        attributes.gravity = 51;
        window.setAttributes(attributes);
    }

    @Override // android.app.Activity
    protected void onResume() {
        Intent intent;
        super.onResume();
        try {
            try {
                Intent intent2 = getIntent();
                if (intent2 != null && (intent = (Intent) intent2.getParcelableExtra("mipush_serviceIntent")) != null) {
                    PushMessageHandler.m1203a(getApplicationContext(), intent);
                }
            } catch (Exception e) {
                AbstractC1417b.m1093a(e);
            }
        } finally {
            finish();
        }
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_xiaomi_mipush_sdk_BridgeActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m1163xc91d0aa0(BridgeActivity bridgeActivity) {
        bridgeActivity.com_xiaomi_mipush_sdk_BridgeActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                bridgeActivity.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
