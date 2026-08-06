package com.bytedance.common.wschannel.app;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.common.wschannel.WsChannelSdk;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public abstract class AbsMessengerService extends Service implements WeakHandler.IHandler {
    protected WeakHandler mHandler;
    private Messenger mMessenger;

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message message) {
    }

    @Override // android.app.Service
    public void onCreate() {
        ThreadPlus.submitRunnable(new Runnable() { // from class: com.bytedance.common.wschannel.app.AbsMessengerService.1
            @Override // java.lang.Runnable
            public void run() {
                AbsMessengerService.this.tryInitInPushProcess();
            }
        });
        Logger.m190d("AbsMessengerService", "onCreate " + this);
        this.mHandler = new WeakHandler(this);
        this.mMessenger = new Messenger(this.mHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryInitInPushProcess() {
        WsChannelSdk.init(getApplication(), null);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Logger.m190d("AbsMessengerService", "onBind " + this);
        return this.mMessenger.getBinder();
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        Logger.m190d("AbsMessengerService", "onUnBind " + this);
        return super.onUnbind(intent);
    }
}
