package ms.bd.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: classes8.dex */
public final class h0 extends Handler {
    public final /* synthetic */ k0 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h0(k0 k0Var, Looper looper) {
        super(looper);
        this.a = k0Var;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        j0 j0Var;
        int ordinal = ((i0[]) i0.e.clone())[message.what].ordinal();
        if ((ordinal == 1 || ordinal == 2) && (j0Var = this.a.b) != null) {
            try {
                ((r0) j0Var).a((String) message.obj, message.what);
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }
}
