package com.bytedance.push.redbadge;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.common.push.ActivityLifecycleAdapter;
import com.bytedance.common.push.ActivityLifecycleObserver;
import com.bytedance.common.push.ThreadPlus;
import com.bytedance.push.interfaze.IPushRedbadgeManager;
import com.bytedance.push.settings.PushOnlineSettings;
import com.bytedance.push.settings.SettingsManager;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PushRedbadgeManager implements IPushRedbadgeManager {
    private final Application.ActivityLifecycleCallbacks mActivityLifecycleCallbacks = new ActivityLifecycleAdapter() { // from class: com.bytedance.push.redbadge.PushRedbadgeManager.1
        public void onActivityStarted(Activity activity) {
            if (ActivityLifecycleObserver.getIns().isBackGround()) {
                PushRedbadgeManager.this.removeRedbadge();
            }
        }
    };
    private final Context mContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void removeRedbadge() {
        ThreadPlus.submitRunnable(new Runnable() { // from class: com.bytedance.push.redbadge.PushRedbadgeManager.2
            @Override // java.lang.Runnable
            public void run() {
                PushOnlineSettings pushOnlineSettings = (PushOnlineSettings) SettingsManager.obtain(PushRedbadgeManager.this.mContext, PushOnlineSettings.class);
                if (pushOnlineSettings == null || !pushOnlineSettings.enableRedbadgeAutoDismiss()) {
                    return;
                }
                PushServiceManager.get().getIRedBadgeExternalService().removeCount(PushRedbadgeManager.this.mContext);
            }
        });
    }

    public PushRedbadgeManager(Context context) {
        this.mContext = context;
    }

    @Override // com.bytedance.push.interfaze.IPushRedbadgeManager
    public void init() {
        ActivityLifecycleObserver.getIns().addActivityLifeCycleListener(this.mActivityLifecycleCallbacks);
        if (ActivityLifecycleObserver.getIns().isBackGround()) {
            return;
        }
        removeRedbadge();
    }

    @Override // com.bytedance.push.interfaze.IPushRedbadgeManager
    public void onReceivePushRedbadge(int i) {
        PushOnlineSettings pushOnlineSettings;
        if (!ActivityLifecycleObserver.getIns().isBackGround() || (pushOnlineSettings = (PushOnlineSettings) SettingsManager.obtain(this.mContext, PushOnlineSettings.class)) == null || !pushOnlineSettings.enablePassThroughRedbadgeShow() || i <= 0) {
            return;
        }
        PushServiceManager.get().getIRedBadgeExternalService().applyCount(this.mContext, i);
    }
}
