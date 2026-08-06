package com.xiaomi.mipush.sdk;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.C1696l;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class NotificationClickedActivity extends Activity {

    /* renamed from: a */
    private BroadcastReceiver f808a;

    /* renamed from: a */
    private Handler f809a;

    /* renamed from: com_xiaomi_mipush_sdk_NotificationClickedActivity__onStop$___twin___ */
    public void m1199xc73edaf8() {
        super.onStop();
    }

    @Override // android.app.Activity
    protected void onStop() {
        m1198x25d203(this);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.height = 1;
        attributes.width = 1;
        attributes.gravity = 8388659;
        window.setAttributes(attributes);
        Handler handler = new Handler();
        this.f809a = handler;
        handler.postDelayed(new Runnable() { // from class: com.xiaomi.mipush.sdk.NotificationClickedActivity.1
            @Override // java.lang.Runnable
            public void run() {
                AbstractC1417b.m1105e("clicked activity finish by timeout.");
                NotificationClickedActivity.this.finish();
            }
        }, 3000L);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_clicked_activity_finish");
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.xiaomi.mipush.sdk.NotificationClickedActivity.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                AbstractC1417b.m1098b("clicked activity finish by normal.");
                NotificationClickedActivity.this.finish();
            }
        };
        this.f808a = broadcastReceiver;
        try {
            C1696l.m3449a(this, broadcastReceiver, intentFilter, C1444c.m1262a(this), null, 4);
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        m1197a(getIntent());
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f809a.removeCallbacksAndMessages(null);
        try {
            m1196x6f7979a2(this, this.f808a);
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    private void m1197a(Intent intent) {
        try {
            if (intent != null) {
                Intent intent2 = (Intent) intent.getParcelableExtra("mipush_serviceIntent");
                if (intent2 != null) {
                    intent2.setComponent(new ComponentName(getPackageName(), "com.xiaomi.mipush.sdk.PushMessageHandler"));
                    intent2.putExtra("is_clicked_activity_call", true);
                    AbstractC1417b.m1090a("PushClickedActivity", "clicked activity start service.");
                    startService(intent2);
                } else {
                    AbstractC1417b.m1104d("PushClickedActivity", "clicked activity start service, newIntent is null");
                }
            } else {
                AbstractC1417b.m1104d("PushClickedActivity", "clicked activity start service, missing intent");
            }
        } catch (Exception e) {
            AbstractC1417b.m1093a(e);
        }
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_xiaomi_mipush_sdk_NotificationClickedActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m1198x25d203(NotificationClickedActivity notificationClickedActivity) {
        notificationClickedActivity.m1199xc73edaf8();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                notificationClickedActivity.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }

    @Proxy("unregisterReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    /* renamed from: INVOKEVIRTUAL_com_xiaomi_mipush_sdk_NotificationClickedActivity_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver */
    public static void m1196x6f7979a2(NotificationClickedActivity notificationClickedActivity, BroadcastReceiver broadcastReceiver) {
        ReceiverRegisterLancet.loge(broadcastReceiver, false);
        notificationClickedActivity.unregisterReceiver(broadcastReceiver);
    }
}
