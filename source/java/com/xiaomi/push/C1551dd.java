package com.xiaomi.push;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;

/* renamed from: com.xiaomi.push.dd */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1551dd implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a */
    private Context f1321a;

    /* renamed from: a */
    private String f1322a;

    /* renamed from: b */
    private String f1323b;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
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

    public C1551dd(Context context, String str) {
        this.f1321a = context;
        this.f1322a = str;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (TextUtils.isEmpty(this.f1323b)) {
            this.f1323b = activity.getLocalClassName();
        }
        this.f1322a = String.valueOf(System.currentTimeMillis() / 1000);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        String localClassName = activity.getLocalClassName();
        if (TextUtils.isEmpty(this.f1322a) || TextUtils.isEmpty(localClassName)) {
            return;
        }
        this.f1323b = "";
        if (!TextUtils.isEmpty("") && !TextUtils.equals(this.f1323b, localClassName)) {
            this.f1322a = "";
            return;
        }
        m2026a(this.f1321a.getPackageName() + "|" + localClassName + Constants.COLON_SEPARATOR + this.f1322a + Constants.ACCEPT_TIME_SEPARATOR_SP + String.valueOf(System.currentTimeMillis() / 1000));
        this.f1322a = "";
        this.f1323b = "";
    }

    /* renamed from: a */
    private void m2026a(String str) {
        C1641gm c1641gm = new C1641gm();
        c1641gm.m2767a(str);
        c1641gm.m2765a(System.currentTimeMillis());
        c1641gm.m2766a(EnumC1635gg.ActivityActiveTimeStamp);
        AbstractC1558dk.m2043a(this.f1321a, c1641gm);
    }
}
