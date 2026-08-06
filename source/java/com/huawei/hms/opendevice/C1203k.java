package com.huawei.hms.opendevice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: RemoteService.java */
/* renamed from: com.huawei.hms.opendevice.k */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1203k {

    /* renamed from: a */
    private ServiceConnection f1607a;

    /* renamed from: b */
    private Messenger f1608b = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RemoteService.java */
    /* renamed from: com.huawei.hms.opendevice.k$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class a implements ServiceConnection {

        /* renamed from: a */
        final /* synthetic */ Bundle f1609a;

        /* renamed from: b */
        final /* synthetic */ Context f1610b;

        a(Bundle bundle, Context context) {
            this.f1609a = bundle;
            this.f1610b = context;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            HMSLog.m2120i("RemoteService", "remote service onConnected");
            C1203k.this.f1608b = new Messenger(iBinder);
            Message obtain = Message.obtain();
            obtain.setData(this.f1609a);
            try {
                C1203k.this.f1608b.send(obtain);
            } catch (RemoteException unused) {
                HMSLog.m2120i("RemoteService", "remote service message send failed");
            }
            HMSLog.m2120i("RemoteService", "remote service unbindservice");
            this.f1610b.unbindService(C1203k.this.f1607a);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            HMSLog.m2120i("RemoteService", "remote service onDisconnected");
            C1203k.this.f1608b = null;
        }
    }

    /* renamed from: a */
    public boolean m1876a(Context context, Bundle bundle, Intent intent) {
        Context applicationContext = context.getApplicationContext();
        this.f1607a = new a(bundle, applicationContext);
        HMSLog.m2120i("RemoteService", "remote service bind service start");
        return applicationContext.bindService(intent, this.f1607a, 1);
    }
}
