package ms.bd.p001c;

import android.os.HandlerThread;
import android.os.Message;

/* renamed from: ms.bd.c.k0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class C0162k0 {

    /* renamed from: c */
    public static volatile C0162k0 f204c;

    /* renamed from: a */
    public final HandlerC0144h0 f205a;

    /* renamed from: b */
    public InterfaceC0156j0 f206b;

    static {
        f204c = null;
    }

    public C0162k0() {
        HandlerThread handlerThread = new HandlerThread((String) AbstractC0190p2.m166a(16777217, 0, 0L, "6a8263", new byte[]{3, 122, 102, 85, 14, 21, 32, 69, 124, 103}));
        handlerThread.start();
        this.f205a = new HandlerC0144h0(this, handlerThread.getLooper());
    }

    /* renamed from: a */
    public static C0162k0 m134a() {
        if (f204c == null) {
            synchronized (C0162k0.class) {
                if (f204c == null) {
                    f204c = new C0162k0();
                }
            }
        }
        return f204c;
    }

    /* renamed from: a */
    public final boolean m135a(EnumC0150i0 enumC0150i0, String str) {
        HandlerC0144h0 handlerC0144h0 = this.f205a;
        if (handlerC0144h0 == null) {
            return false;
        }
        if (enumC0150i0 == EnumC0150i0.f187d) {
            handlerC0144h0.removeMessages(enumC0150i0.f189a);
            return true;
        }
        Message message = new Message();
        message.what = enumC0150i0.ordinal();
        message.obj = str;
        return this.f205a.sendMessage(message);
    }
}
