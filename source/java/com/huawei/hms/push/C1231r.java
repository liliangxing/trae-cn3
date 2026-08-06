package com.huawei.hms.push;

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
/* renamed from: com.huawei.hms.push.r */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1231r {

    /* renamed from: a */
    private ServiceConnection f1737a;

    /* renamed from: b */
    private Messenger f1738b = null;

    /* compiled from: RemoteService.java */
    /* renamed from: com.huawei.hms.push.r$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    class a implements ServiceConnection {

        /* renamed from: a */
        final /* synthetic */ Bundle f1739a;

        /* renamed from: b */
        final /* synthetic */ Context f1740b;

        a(Bundle bundle, Context context) {
            this.f1739a = bundle;
            this.f1740b = context;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            HMSLog.m2120i("RemoteService", "remote service onConnected");
            C1231r.this.f1738b = new Messenger(iBinder);
            Message obtain = Message.obtain();
            obtain.setData(this.f1739a);
            try {
                C1231r.this.f1738b.send(obtain);
            } catch (RemoteException unused) {
                HMSLog.m2120i("RemoteService", "remote service message send failed");
            }
            HMSLog.m2120i("RemoteService", "remote service unbindservice");
            this.f1740b.unbindService(C1231r.this.f1737a);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            HMSLog.m2120i("RemoteService", "remote service onDisconnected");
            C1231r.this.f1738b = null;
        }
    }

    /* renamed from: a */
    public boolean m2035a(Context context, Bundle bundle, Intent intent) {
        Context applicationContext = context.getApplicationContext();
        this.f1737a = new a(bundle, applicationContext);
        HMSLog.m2120i("RemoteService", "remote service bind service start");
        return applicationContext.bindService(intent, this.f1737a, 1);
    }
}
