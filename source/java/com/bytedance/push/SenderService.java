package com.bytedance.push;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.android.service.manager.push.trace.PushTraceSceneType;
import com.bytedance.common.push.ThreadPlus;
import com.bytedance.push.interfaze.ISenderService;
import com.bytedance.push.settings.IDataChangedListener;
import com.bytedance.push.settings.LocalFrequencySettings;
import com.bytedance.push.settings.LocalSettings;
import com.bytedance.push.settings.SettingsManager;
import com.bytedance.push.task.UpdateSenderTask;
import com.bytedance.push.third.PushChannelHelper;
import com.bytedance.push.third.PushManager;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.AppProvider;
import com.ss.android.message.NotifyService;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.pushmanager.app.MessageAppHooks;
import com.ss.android.pushmanager.setting.PushSetting;
import com.ss.android.ug.bus.UgBusFramework;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SenderService implements ISenderService {
    private final String TAG = "SenderService";
    private Map<Integer, Boolean> mPushRegisteredMap = new ConcurrentHashMap();
    private UpdateSenderTask mUpdateSenderTask = new UpdateSenderTask(this);

    @Override // com.bytedance.push.interfaze.ISenderService
    public boolean registerAllSender(Context context) {
        boolean registerAliPush = registerAliPush(context);
        if (PushSetting.getInstance().isPushNotifyEnable()) {
            Iterator it = PushChannelHelper.inst(context).getChannels().iterator();
            while (it.hasNext()) {
                registerAliPush |= tryConfigPush(context, ((Integer) it.next()).intValue());
            }
            tryStartPushProcess(context.getApplicationContext());
        } else {
            unRegisterAllThirdPush(context);
        }
        return registerAliPush;
    }

    @Override // com.bytedance.push.interfaze.ISenderService
    public void tryUpdateSender(final boolean z) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            ThreadPlus.submitRunnable(new Runnable() { // from class: com.bytedance.push.SenderService.1
                @Override // java.lang.Runnable
                public void run() {
                    SenderService.this.mUpdateSenderTask.runTasks(z);
                }
            });
        } else {
            this.mUpdateSenderTask.runTasks(z);
        }
    }

    @Override // com.bytedance.push.interfaze.ISenderService
    public void registerSenderInPushServiceProcess() {
        Application app = AppProvider.getApp();
        registerAliPushOnChannelProcess(app);
        registerAliPushObserver(app);
    }

    private void registerAliPushObserver(final Context context) {
        try {
            ((LocalSettings) SettingsManager.obtain(context, LocalSettings.class)).registerValChanged(context, "ali_push_type", "integer", new IDataChangedListener() { // from class: com.bytedance.push.SenderService.2
                @Override // com.bytedance.push.settings.IDataChangedListener
                public void onChange() {
                    SenderService.this.registerAliPushOnChannelProcess(context);
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerAliPushOnChannelProcess(Context context) {
        int aliPushType = PushSetting.getInstance().getAliPushType();
        if (aliPushType > -1) {
            Logger.m273i("registerAliPush: aliPushType = " + aliPushType);
            if (PushManager.inst().needDisableChannelInvoke(context, aliPushType)) {
                return;
            }
            registerPush(context, aliPushType);
        }
    }

    private boolean registerAliPush(Context context) {
        int i;
        boolean z = false;
        try {
            if (PushChannelHelper.isServerSupportChannel(PushChannelHelper.inst(context).getTryRegisterChannelId())) {
                if (Logger.debug()) {
                    Logger.m268d("PushStart", "registerUmPush process = " + ToolUtils.getCurProcessName(context));
                }
                i = PushChannelHelper.inst(context).getTryRegisterChannelId();
                z = tryConfigPush(context, PushChannelHelper.inst(context).getTryRegisterChannelId());
            } else {
                i = -1;
            }
            PushSetting.getInstance().setAliPushType(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return z;
    }

    private boolean tryConfigPush(Context context, int i) {
        if (context == null || PushSetting.getInstance().isShutPushNotifyEnable()) {
            return false;
        }
        Context applicationContext = context.getApplicationContext();
        if (!PushChannelHelper.isServerSupportChannel(i) || !isPushAvailable(applicationContext, i) || PushManager.inst().needDisableChannelInvoke(applicationContext, i)) {
            return false;
        }
        synchronized (this) {
            Boolean bool = this.mPushRegisteredMap.get(Integer.valueOf(i));
            if (bool != null && bool.booleanValue()) {
                return true;
            }
            this.mPushRegisteredMap.put(Integer.valueOf(i), true);
            return registerPush(applicationContext, i);
        }
    }

    private boolean isPushAvailable(Context context, int i) {
        if (context == null) {
            return false;
        }
        return PushManager.inst().isPushAvailable(context, i);
    }

    private void unregisterPush(Context context, int i) {
        if (context == null) {
            return;
        }
        PushManager.inst().unregisterPush(context.getApplicationContext(), i);
    }

    private boolean registerPush(Context context, int i) {
        if (!PushChannelHelper.isServerSupportChannel(i) || context == null) {
            return false;
        }
        PushManager.inst().registerPush(context, i);
        return true;
    }

    @Override // com.bytedance.push.interfaze.ISenderService
    public void unRegisterAllThirdPush(Context context) {
        Iterator it = PushChannelHelper.inst(context).getChannels().iterator();
        while (it.hasNext()) {
            unregisterPush(context, ((Integer) it.next()).intValue());
        }
        this.mPushRegisteredMap.clear();
    }

    @Override // com.bytedance.push.interfaze.ISenderService
    public boolean isAllowPushService(int i) {
        return PushChannelHelper.isServerSupportChannel(i);
    }

    @Override // com.bytedance.push.interfaze.ISenderService
    public void setAlias(Context context, String str, int i) {
        PushManager.inst().setAlias(context, str, i);
    }

    @Override // com.bytedance.push.interfaze.ISenderService
    public boolean isSenderChanged(Context context) {
        return !TextUtils.equals(PushChannelHelper.inst(context).buildApplogHeader().toString(), ((LocalFrequencySettings) SettingsManager.obtain(context, LocalFrequencySettings.class)).getSupportSender());
    }

    @Override // com.bytedance.push.interfaze.ISenderService
    public void tryStartPushProcess(final Context context) {
        PushServiceManager.get().getPushTraceExternalService().getTraceScene(PushTraceSceneType.ALLIANCE_WAKEUP).enterNode("try_start_push_process", "try to start the push process");
        boolean z = false;
        boolean z2 = !ToolUtils.isSmpProcess(context) || PushServiceManager.get().getIAllianceService().allowStartOthersProcessFromSmp();
        boolean allowStartNonMainProcess = PushSupporter.get().getProcessManagerService().allowStartNonMainProcess();
        if (z2 && allowStartNonMainProcess) {
            z = true;
        }
        if (z) {
            PushServiceManager.get().getPushTraceExternalService().getTraceScene(PushTraceSceneType.ALLIANCE_WAKEUP).enterNode("start_push_process", "Start the push process");
            Intent intent = new Intent(context, (Class<?>) NotifyService.class);
            try {
                if (UgBusFramework.getService(MessageAppHooks.PushHook.class).needControlFlares()) {
                    try {
                        context.startService(intent);
                    } catch (Throwable unused) {
                    }
                }
                context.bindService(intent, new ServiceConnection() { // from class: com.bytedance.push.SenderService.3
                    @Override // android.content.ServiceConnection
                    public void onServiceDisconnected(ComponentName componentName) {
                    }

                    @Override // android.content.ServiceConnection
                    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                        try {
                            context.unbindService(this);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }, 1);
            } catch (Throwable unused2) {
                Logger.m271e("SenderService", "start NotifyService failure");
            }
        }
    }

    @Override // com.bytedance.push.interfaze.ISenderService
    public void startNonMainProcess(Context context) {
        tryConfigPush(context, 6);
        tryConfigPush(context, 1);
        PushSupporter.get().getSenderService().tryStartPushProcess(context);
    }
}
