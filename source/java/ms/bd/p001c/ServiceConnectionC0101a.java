package ms.bd.p001c;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* renamed from: ms.bd.c.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class ServiceConnectionC0101a implements ServiceConnection {

    /* renamed from: a */
    public final /* synthetic */ C0107b f126a;

    public ServiceConnectionC0101a(C0107b c0107b) {
        this.f126a = c0107b;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.f126a.f132b.put(iBinder);
        } catch (Exception unused) {
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
