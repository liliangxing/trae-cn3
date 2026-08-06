package ms.bd.p001c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: ms.bd.c.z */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class C0237z implements IInterface {

    /* renamed from: a */
    public final IBinder f476a;

    public C0237z(IBinder iBinder) {
        this.f476a = iBinder;
    }

    /* renamed from: a */
    public final String m212a() {
        String str;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken((String) AbstractC0190p2.m166a(16777217, 0, 0L, "543294", new byte[]{39, 57, 77, 8, 4, 54, 56, 91, 110, 107, 38, 120, 109, 85, 7, 10, 50, 60, 108, 118, 33, 36, 70, 71, 5, 38}));
        } catch (Throwable unused) {
        }
        try {
            this.f476a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            str = obtain2.readString();
        } catch (Throwable unused2) {
            obtain2.recycle();
            obtain.recycle();
            str = null;
            obtain2.recycle();
            obtain.recycle();
            return str;
        }
        obtain2.recycle();
        obtain.recycle();
        return str;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f476a;
    }
}
