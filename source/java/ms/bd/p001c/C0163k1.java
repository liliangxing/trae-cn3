package ms.bd.p001c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: ms.bd.c.k1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class C0163k1 implements IInterface {

    /* renamed from: a */
    public final IBinder f207a;

    public C0163k1(IBinder iBinder) {
        this.f207a = iBinder;
    }

    /* renamed from: a */
    public final String m136a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            try {
                obtain.writeInterfaceToken((String) AbstractC0190p2.m166a(16777217, 0, 0L, "b19235", new byte[]{112, 60, 71, 8, 22, 55, 104, 94, 108, 103, 101, 58, 73, 67, 5, 38, 114, 21, 122, 116, 122, 48, 79, 8, 37, 6, 100, 6, 97, 97, 118, 58, 78, 111, 2, 54, 100, 2, 110, 99, 112, 54}));
                try {
                    this.f207a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    obtain2.recycle();
                    obtain.recycle();
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                obtain2.recycle();
                obtain.recycle();
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
        } catch (Throwable th2) {
            th = th2;
            obtain2.recycle();
            obtain.recycle();
            throw th;
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return null;
    }
}
