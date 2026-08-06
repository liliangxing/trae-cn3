package com.vivo.push.sdk.service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.push.settings.SettingsManager;
import com.bytedance.push.utils.Logger;
import com.p025vv.VvPushAdapter;
import com.ss.android.message.PushThreadHandlerManager;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.pushmanager.setting.PushSetting;
import com.vivo.push.sdk.C1353a;
import com.vivo.push.util.C1393t;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class CommandClientService extends CommandService {
    public static final String NEED_KILL_SMP = "need_kill_smp";
    public static final String SMP_PID = "smp_pid";
    private final String TAG = "CommandClientService";

    @Override // com.vivo.push.sdk.service.CommandService, android.app.Service
    public IBinder onBind(Intent intent) {
        Logger.d("CommandClientService", "CommandClientService.onBind: intent is " + intent.toString());
        if (ToolUtils.isMainProcess(this)) {
            handleIntent(intent);
        }
        return super.onBind(intent);
    }

    private void handleIntent(Intent intent) {
        if (intent != null) {
            Logger.d("CommandClientService", "CommandClientService.handleIntent: intent is " + intent.toString());
            ComponentName component = intent.getComponent();
            if (component != null) {
                Logger.d("CommandClientService", "CommandClientService.handleIntent: component is " + component.toString());
            }
            if (ToolUtils.isSmpProcess(this)) {
                SettingsManager.allowReadSettingsOnSmp = true;
                boolean hasTryRegistered = VvPushAdapter.hasTryRegistered();
                Logger.d("CommandClientService", "[CommandClientService.onStartCommand]hasTryRegistered:" + hasTryRegistered);
                if (!hasTryRegistered) {
                    Logger.d("CommandClientService", "CommandClientService.handleIntent: redirect to main process ");
                    ComponentName componentName = new ComponentName(getPackageName(), MainCommandClientService.class.getName());
                    Logger.d("CommandClientService", "CommandClientService.onStartCommand: main process component is " + componentName.toString());
                    intent.setComponent(componentName);
                    Logger.d("CommandClientService", "hasWaked:" + PushServiceManager.get().getIAllianceService().hasWaked());
                    try {
                        Logger.d("CommandClientService", "startService result: " + (startService(intent) != null));
                    } catch (Throwable th) {
                        Logger.d("CommandClientService", "startService failed , try bind : " + th.getMessage());
                        Logger.d("CommandClientService", "bindService result:" + bindService(intent, new ServiceConnection() { // from class: com.vivo.push.sdk.service.CommandClientService.1
                            @Override // android.content.ServiceConnection
                            public void onServiceConnected(ComponentName componentName2, IBinder iBinder) {
                                Logger.d("CommandClientService", "CommandClientService: onServiceConnected for MainCommandClientService ");
                            }

                            @Override // android.content.ServiceConnection
                            public void onServiceDisconnected(ComponentName componentName2) {
                                Logger.d("CommandClientService", "CommandClientService: onServiceDisconnected for MainCommandClientService ");
                            }
                        }, 1));
                    }
                    PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.vivo.push.sdk.service.CommandClientService.2
                        @Override // java.lang.Runnable
                        public void run() {
                            boolean killSmpAfterVvPush = PushSetting.getInstance().getPushOnLineSettings().killSmpAfterVvPush();
                            Logger.d("CommandClientService", "killSmpAfterVvPush:" + killSmpAfterVvPush);
                            if (killSmpAfterVvPush) {
                                PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.vivo.push.sdk.service.CommandClientService.2.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        ToolUtils.killSelf();
                                    }
                                }, 10000L);
                            }
                        }
                    });
                    return;
                }
                Logger.d("CommandClientService", "CommandClientService.onStartCommand: execute callback on smp process ");
            }
            C1393t.m1046c("CommandService", getClass().getSimpleName() + " -- onStartCommand " + getPackageName());
            if (!mo913a(intent.getAction())) {
                C1393t.m1034a("CommandService", getPackageName() + " receive invalid action " + intent.getAction());
                return;
            }
            try {
                C1353a.m908a().m911a(getClass().getName());
                C1353a.m908a().m910a(intent);
            } catch (Exception e) {
                C1393t.m1035a("CommandService", "onStartCommand -- error", e);
            }
        }
    }

    @Override // com.vivo.push.sdk.service.CommandService, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        Logger.d("CommandClientService", "CommandClientService.onStartCommand: intent is " + intent);
        handleIntent(intent);
        stopSelf();
        return 2;
    }

    @Override // com.vivo.push.sdk.service.CommandService
    /* renamed from: a */
    protected final boolean mo913a(String str) {
        return "com.vivo.pushclient.action.RECEIVE".equals(str);
    }
}
