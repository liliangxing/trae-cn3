package ms.bd.p001c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* renamed from: ms.bd.c.h0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class HandlerC0144h0 extends Handler {

    /* renamed from: a */
    public final /* synthetic */ C0162k0 f181a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC0144h0(C0162k0 c0162k0, Looper looper) {
        super(looper);
        this.f181a = c0162k0;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        InterfaceC0156j0 interfaceC0156j0;
        int ordinal = ((EnumC0150i0[]) EnumC0150i0.f188e.clone())[message.what].ordinal();
        if ((ordinal == 1 || ordinal == 2) && (interfaceC0156j0 = this.f181a.f206b) != null) {
            try {
                ((C0198r0) interfaceC0156j0).m177a((String) message.obj, message.what);
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }
}
