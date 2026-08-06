package ms.bd.p001c;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* renamed from: ms.bd.c.b1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class ServiceConnectionC0109b1 implements ServiceConnection {

    /* renamed from: a */
    public final /* synthetic */ C0121d1 f136a;

    public ServiceConnectionC0109b1(C0121d1 c0121d1) {
        this.f136a = c0121d1;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.f136a.f156c.put(iBinder);
        } catch (Exception unused) {
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
