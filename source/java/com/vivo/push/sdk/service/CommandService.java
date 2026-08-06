package com.vivo.push.sdk.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.vivo.push.sdk.C1353a;
import com.vivo.push.util.C1393t;
import com.vivo.push.util.ContextDelegate;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class CommandService extends Service {
    @Override // android.app.Service
    public void onCreate() {
        C1393t.m1046c("CommandService", getClass().getSimpleName() + " -- oncreate " + getPackageName());
        super.onCreate();
        C1353a.m908a().m579a(ContextDelegate.getContext(getApplicationContext()));
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        C1393t.m1046c("CommandService", getClass().getSimpleName() + " -- onStartCommand " + getPackageName());
        if (intent == null) {
            stopSelf();
            return 2;
        }
        if (!mo913a(intent.getAction())) {
            C1393t.m1034a("CommandService", getPackageName() + " receive invalid action " + intent.getAction());
            stopSelf();
            return 2;
        }
        try {
            C1353a.m908a().m911a(getClass().getName());
            C1353a.m908a().m910a(intent);
        } catch (Exception e) {
            C1393t.m1035a("CommandService", "onStartCommand -- error", e);
        }
        stopSelf();
        return 2;
    }

    /* renamed from: a */
    protected boolean mo913a(String str) {
        return "com.vivo.pushservice.action.RECEIVE".equals(str);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        C1393t.m1046c("CommandService", "onBind initSuc: ");
        return null;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}
