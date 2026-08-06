package ms.bd.c;

import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes8.dex */
public final class c3 implements IInterface {
    public final IBinder a;

    public c3(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.a;
    }
}
