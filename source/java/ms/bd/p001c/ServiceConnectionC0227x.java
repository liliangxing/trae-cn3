package ms.bd.p001c;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* renamed from: ms.bd.c.x */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class ServiceConnectionC0227x implements ServiceConnection {

    /* renamed from: a */
    public final /* synthetic */ C0232y f452a;

    public ServiceConnectionC0227x(C0232y c0232y) {
        this.f452a = c0232y;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.f452a.f468c.put(iBinder);
        } catch (Exception unused) {
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
