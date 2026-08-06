package com.hihonor.push.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;

/* renamed from: com.hihonor.push.sdk.g0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class ServiceConnectionC0926g0 implements ServiceConnection {

    /* renamed from: a */
    public Messenger f718a;

    /* renamed from: b */
    public Bundle f719b;

    /* renamed from: c */
    public Context f720c;

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Log.i("MessengerSrvConnection", "onServiceConnected");
        this.f718a = new Messenger(iBinder);
        Message obtain = Message.obtain();
        obtain.setData(this.f719b);
        try {
            this.f718a.send(obtain);
        } catch (Exception e) {
            String str = "message sending failed. " + e.getMessage();
        }
        Log.i("MessengerSrvConnection", "start unbind service.");
        try {
            this.f720c.unbindService(this);
            Log.i("MessengerSrvConnection", "unbind service end.");
        } catch (Exception unused) {
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Log.i("MessengerSrvConnection", "onServiceDisconnected");
        this.f718a = null;
        this.f719b = null;
        this.f720c = null;
    }
}
