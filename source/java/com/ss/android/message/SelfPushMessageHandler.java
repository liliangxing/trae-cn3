package com.ss.android.message;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.ss.android.pushmanager.app.MessageAppHooks;
import com.ss.android.ug.bus.UgBusFramework;

@Deprecated
/* loaded from: classes7.dex */
public class SelfPushMessageHandler extends Service {
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        int onStartCommand = super.onStartCommand(intent, i, i2);
        if (((MessageAppHooks.PushHook) UgBusFramework.getService(MessageAppHooks.PushHook.class)).needControlFlares()) {
            return 2;
        }
        return onStartCommand;
    }
}
