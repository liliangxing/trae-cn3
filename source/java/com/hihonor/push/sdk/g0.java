package com.hihonor.push.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;

/* loaded from: classes6.dex */
public class g0 implements ServiceConnection {
    public Messenger a;
    public Bundle b;
    public Context c;

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Log.i("MessengerSrvConnection", "onServiceConnected");
        this.a = new Messenger(iBinder);
        Message obtain = Message.obtain();
        obtain.setData(this.b);
        try {
            this.a.send(obtain);
        } catch (Exception e) {
            String str = "message sending failed. " + e.getMessage();
        }
        Log.i("MessengerSrvConnection", "start unbind service.");
        try {
            this.c.unbindService(this);
            Log.i("MessengerSrvConnection", "unbind service end.");
        } catch (Exception unused) {
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Log.i("MessengerSrvConnection", "onServiceDisconnected");
        this.a = null;
        this.b = null;
        this.c = null;
    }
}
