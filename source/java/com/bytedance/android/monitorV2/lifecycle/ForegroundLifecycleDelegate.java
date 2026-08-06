package com.bytedance.android.monitorV2.lifecycle;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ForegroundLifecycleDelegate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/monitorV2/lifecycle/ForegroundLifecycleDelegate;", "Lcom/bytedance/android/monitorV2/lifecycle/MonitorLifecycleDelegate;", "()V", "activityCount", "", "foregroundManager", "Lcom/bytedance/android/monitorV2/lifecycle/ForegroundImpl;", "appIsBackgrounded", "", "onActivityStarted", "", "activity", "Landroid/app/Activity;", "onActivityStopped", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ForegroundLifecycleDelegate extends MonitorLifecycleDelegate {
    private int activityCount;
    private final ForegroundImpl foregroundManager = MonitorLifecycleManager.INSTANCE.getForegroundManager();

    @Override // com.bytedance.android.monitorV2.lifecycle.MonitorLifecycleDelegate, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activityCount++;
        if (!appIsBackgrounded()) {
            this.foregroundManager.notifyAppForegrounded(activity);
        }
        this.foregroundManager.setApplicationBackgrounded(appIsBackgrounded());
    }

    @Override // com.bytedance.android.monitorV2.lifecycle.MonitorLifecycleDelegate, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activityCount--;
        if (appIsBackgrounded()) {
            this.foregroundManager.notifyAppBackgrounded(activity);
        }
        this.foregroundManager.setApplicationBackgrounded(appIsBackgrounded());
    }

    private final boolean appIsBackgrounded() {
        return this.activityCount <= 0;
    }
}
