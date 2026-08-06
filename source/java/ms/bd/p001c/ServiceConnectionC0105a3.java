package ms.bd.p001c;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* renamed from: ms.bd.c.a3 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class ServiceConnectionC0105a3 implements ServiceConnection {

    /* renamed from: a */
    public final /* synthetic */ C0111b3 f127a;

    public ServiceConnectionC0105a3(C0111b3 c0111b3) {
        this.f127a = c0111b3;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        C0111b3 c0111b3 = this.f127a;
        c0111b3.f139c = new C0117c3(iBinder);
        c0111b3.f140d.countDown();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        C0111b3 c0111b3 = this.f127a;
        c0111b3.f139c = null;
        c0111b3.f140d.countDown();
    }
}
