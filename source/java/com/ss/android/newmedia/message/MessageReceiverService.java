package com.ss.android.newmedia.message;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.PowerManager;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.PushThreadHandlerManager;
import com.ss.android.pushmanager.MessageConstants;
import com.ss.android.pushmanager.app.MessageAppHooks;
import com.ss.android.pushmanager.setting.PushSetting;
import com.ss.android.ug.bus.UgBusFramework;
import java.lang.reflect.Field;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class MessageReceiverService extends IntentService implements WeakHandler.IHandler {
    private static final String TAG = "MessageReceiverService";
    private WeakHandler mHandler;
    private Messenger mMessenger;

    public void handleMsg(Message message) {
    }

    public MessageReceiverService() {
        super(TAG);
    }

    @Override // android.app.IntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0030 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0031 A[RETURN] */
    @Override // android.app.IntentService, android.app.Service
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int onStartCommand(final Intent intent, int i, final int i2) {
        int i3;
        try {
            i3 = super.onStartCommand(intent, i, i2);
        } catch (NullPointerException e) {
            e.printStackTrace();
            if (getServiceHandler() == null) {
                PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.ss.android.newmedia.message.MessageReceiverService.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            MessageReceiverService.this.onHandleIntent(intent);
                            MessageReceiverService.this.stopSelf(i2);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }
            i3 = 2;
            if (((MessageAppHooks.PushHook) UgBusFramework.getService(MessageAppHooks.PushHook.class)).needControlFlares()) {
            }
        } catch (Throwable th) {
            th.printStackTrace();
            i3 = 2;
            if (((MessageAppHooks.PushHook) UgBusFramework.getService(MessageAppHooks.PushHook.class)).needControlFlares()) {
            }
        }
        if (((MessageAppHooks.PushHook) UgBusFramework.getService(MessageAppHooks.PushHook.class)).needControlFlares()) {
            return 2;
        }
        return i3;
    }

    private Handler getServiceHandler() {
        try {
            Field declaredField = IntentService.class.getDeclaredField("mServiceHandler");
            declaredField.setAccessible(true);
            return (Handler) declaredField.get(this);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // android.app.IntentService, android.app.Service
    public IBinder onBind(final Intent intent) {
        Logger.d(TAG, "onBind");
        if (intent != null) {
            PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.ss.android.newmedia.message.MessageReceiverService.2
                @Override // java.lang.Runnable
                public void run() {
                    MessageReceiverService.this.onHandleIntent(intent);
                    MessageReceiverService.this.stopSelf();
                }
            });
        }
        return getMessenger().getBinder();
    }

    private Messenger getMessenger() {
        if (this.mMessenger == null) {
            this.mHandler = new WeakHandler(this);
            this.mMessenger = new Messenger((Handler) this.mHandler);
        }
        return this.mMessenger;
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        try {
            onReceive(this, intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    protected void onReceive(Context context, Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        String action = intent.getAction();
        if (action != null) {
            Logger.d(TAG, "action = " + action);
        }
        if (!PushSetting.getInstance().isPushNotifyEnable()) {
            Logger.i(TAG, "notify enable = " + PushSetting.getInstance().isPushNotifyEnable());
            return;
        }
        try {
            if (MessageConstants.MESSAGE_ACTION.equals(action)) {
                String handleMySelfPushIntent = handleMySelfPushIntent(intent);
                if (StringUtils.isEmpty(handleMySelfPushIntent)) {
                    return;
                }
                Logger.d(TAG, "message received, msg is: " + handleMySelfPushIntent);
                PushSupporter.pushHandler().handlePassThroughMsg(handleMySelfPushIntent, 2, (String) null);
                tryWakeupScreen();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void tryWakeupScreen() {
        PowerManager powerManager = (PowerManager) getSystemService("power");
        if (PushSetting.getInstance().isReceiverMessageWakeupScreen()) {
            boolean isInteractive = powerManager.isInteractive();
            Logger.d(TAG, "tryWakeupScreen isScreenOn = " + isInteractive);
            if (isInteractive) {
                return;
            }
            powerManager.newWakeLock(268435462, TAG).acquire(PushSetting.getInstance().getReceiverMessageWakeupScreenTime());
        }
    }

    private String handleMySelfPushIntent(Intent intent) {
        if (intent != null && MessageConstants.MESSAGE_ACTION.equals(intent.getAction())) {
            return intent.getStringExtra(MessageConstants.MESSAGE_KEY_DATA);
        }
        return null;
    }
}
