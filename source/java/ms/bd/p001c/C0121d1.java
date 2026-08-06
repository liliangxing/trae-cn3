package ms.bd.p001c;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.concurrent.LinkedBlockingQueue;
import okio.Utf8;
import org.bouncycastle.math.ec.Tnaf;

/* renamed from: ms.bd.c.d1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class C0121d1 {

    /* renamed from: b */
    public final Context f155b;

    /* renamed from: a */
    public final String f154a = (String) AbstractC0190p2.m166a(16777217, 0, 0, "4a3723", new byte[]{42, 98, Byte.MAX_VALUE, 74, 9, 27, 49, 76, 99, 96});

    /* renamed from: c */
    public final LinkedBlockingQueue f156c = new LinkedBlockingQueue(1);

    /* renamed from: d */
    public final ServiceConnectionC0109b1 f157d = new ServiceConnectionC0109b1(this);

    public C0121d1(Context context) {
        this.f155b = context;
    }

    /* renamed from: a */
    public final void m82a(C0235y2 c0235y2) {
        InterfaceC0139g1 c0127e1;
        if (C0240z2.m216a(this.f155b, (String) AbstractC0190p2.m166a(16777217, 0, 0L, "4d227d", new byte[]{38, 105, 76, 8, 0, 122, Utf8.REPLACEMENT_BYTE, 74, 109, 109, 55, 40, 72, 66}))) {
            Intent intent = new Intent();
            intent.setAction((String) AbstractC0190p2.m166a(16777217, 0, 0L, "2cee9b", new byte[]{32, 110, 27, 95, 14, 124, 57, 77, 58, 58, 49, 47, 31, 21, 72, 93, Utf8.REPLACEMENT_BYTE, 109, 53, 28, 39, 82, 19, 3, Tnaf.POW_2_WIDTH, 124, 50, 71}));
            intent.setPackage((String) AbstractC0190p2.m166a(16777217, 0, 0L, "d4a8c6", new byte[]{118, 57, 31, 2, 84, 40, 111, 26, 62, 103, 103, 120, 27, 72}));
            if (this.f155b.bindService(intent, this.f157d, 1)) {
                try {
                    IBinder iBinder = (IBinder) this.f156c.take();
                    if (iBinder == null) {
                        String str = AbstractBinderC0133f1.f166a;
                        c0127e1 = null;
                    } else {
                        IInterface queryLocalInterface = iBinder.queryLocalInterface(AbstractBinderC0133f1.f166a);
                        c0127e1 = (queryLocalInterface == null || !(queryLocalInterface instanceof InterfaceC0139g1)) ? new C0127e1(iBinder) : (InterfaceC0139g1) queryLocalInterface;
                    }
                    BinderC0115c1 binderC0115c1 = new BinderC0115c1(this, c0235y2);
                    C0127e1 c0127e12 = (C0127e1) c0127e1;
                    c0127e12.getClass();
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken((String) AbstractC0190p2.m166a(16777217, 0, 0L, "d8925d", new byte[]{118, 53, 71, 8, 2, 122, 111, 22, 102, 109, 103, 116, 73, 74, 5, 102, 99, 10, 109, 112, 99, 51, 73, 67, 68, 124, 102, Tnaf.POW_2_WIDTH, 108, 44, 92, 21, 107, 111, 46, 64, 98, 11, 126, 107, 118, Utf8.REPLACEMENT_BYTE}));
                        obtain.writeStrongBinder(binderC0115c1);
                        c0127e12.f162a.transact(2, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } catch (Exception unused) {
                } finally {
                    this.f155b.unbindService(this.f157d);
                }
            }
        }
    }
}
