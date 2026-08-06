package com.xiaomi.mipush.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.ss.ttm.player.MediaPlayer;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.C1565dr;
import com.xiaomi.push.C1566ds;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.xiaomi.mipush.sdk.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1442a implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a */
    private Set<String> f817a = new HashSet();

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    /* renamed from: a */
    public static void m1220a(Context context) {
        m1219a((Application) context.getApplicationContext());
    }

    /* renamed from: a */
    private static void m1219a(Application application) {
        application.registerActivityLifecycleCallbacks(new C1442a());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        try {
            Intent intent = activity.getIntent();
            if (intent == null) {
                return;
            }
            String stringExtra = intent.getStringExtra("messageId");
            int intExtra = intent.getIntExtra("eventMessageType", -1);
            if (!TextUtils.isEmpty(stringExtra) && intExtra > 0 && !this.f817a.contains(stringExtra)) {
                this.f817a.add(stringExtra);
                if (intExtra == 3000) {
                    C1566ds.m2275a(activity.getApplicationContext()).m2281a(activity.getPackageName(), C1565dr.m2268a(intExtra), stringExtra, MediaPlayer.MEDIA_PLAYER_OPTION_VR_SET_FOV_PREDICTOR_HANDLE, null);
                } else if (intExtra == 1000) {
                    C1566ds.m2275a(activity.getApplicationContext()).m2281a(activity.getPackageName(), C1565dr.m2268a(intExtra), stringExtra, 1008, null);
                }
            }
        } catch (Throwable th) {
            AbstractC1417b.m1103d("An error occurred in onActivityResumed method: " + th);
        }
    }
}
