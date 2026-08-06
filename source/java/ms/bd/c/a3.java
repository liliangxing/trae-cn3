package ms.bd.c;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* loaded from: classes8.dex */
public final class a3 implements ServiceConnection {
    public final /* synthetic */ b3 a;

    public a3(b3 b3Var) {
        this.a = b3Var;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        b3 b3Var = this.a;
        b3Var.c = new c3(iBinder);
        b3Var.d.countDown();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        b3 b3Var = this.a;
        b3Var.c = null;
        b3Var.d.countDown();
    }
}
