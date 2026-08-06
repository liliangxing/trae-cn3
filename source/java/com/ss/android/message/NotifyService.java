package com.ss.android.message;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.android.service.manager.push.trace.PushTraceSceneType;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.push.ProcessLifeCycleObserver;
import com.bytedance.push.alive.AliveKeeperProxy;
import com.bytedance.push.third.PushLifeManager;
import com.bytedance.push.utils.Logger;
import com.ss.android.pushmanager.app.MessageAppHooks;
import com.ss.android.ug.bus.UgBusFramework;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class NotifyService extends Service {
    static final int SERVICE_FOREGROUND_ID = 1;
    static final String TAG = "NotifyService";

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        AliveKeeperProxy.inst(getApplicationContext()).doKeepAlive();
        PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.ss.android.message.NotifyService.1
            @Override // java.lang.Runnable
            public void run() {
                NotifyService.this.doOnCreate();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doOnCreate() {
        try {
            PushLifeManager.inst().onNotifyServiceCreate(getApplicationContext());
        } catch (Throwable unused) {
        }
        Logger.d(TAG, "do onCreate end");
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        try {
            PushLifeManager.inst().onNotifyDestroy();
        } catch (Exception e) {
            try {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Logger.d("PushService NotifyService", "onBind");
        onServiceStart(intent);
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        int onStartCommand = super.onStartCommand(intent, i, i2);
        if (Logger.debug()) {
            Logger.d("PushService NotifyService", "onStartCommand");
        }
        onServiceStart(intent);
        MessageAppHooks.PushHook pushHook = (MessageAppHooks.PushHook) UgBusFramework.getService(MessageAppHooks.PushHook.class);
        if (pushHook == null || pushHook.needControlFlares()) {
            return 2;
        }
        return onStartCommand;
    }

    private void onServiceStart(final Intent intent) {
        PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.ss.android.message.NotifyService.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    PushServiceManager.get().getPushTraceExternalService().getTraceScene(PushTraceSceneType.ALLIANCE_WAKEUP).enterNode("push_process_started", "The push process is started");
                    Logger.d(NotifyService.TAG, "onServiceStart");
                    ProcessLifeCycleObserver.getInstance().start(PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mApplication);
                    try {
                        PushLifeManager.inst().onNotifyServiceStart(intent);
                    } catch (Throwable unused) {
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
