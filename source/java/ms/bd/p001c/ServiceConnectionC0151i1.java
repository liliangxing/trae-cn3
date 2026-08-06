package ms.bd.p001c;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* renamed from: ms.bd.c.i1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class ServiceConnectionC0151i1 implements ServiceConnection {

    /* renamed from: a */
    public final /* synthetic */ C0157j1 f190a;

    public ServiceConnectionC0151i1(C0157j1 c0157j1) {
        this.f190a = c0157j1;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f190a.f197b = new C0163k1(iBinder);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
