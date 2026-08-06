package ms.bd.p001c;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Parcel;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.io.encoding.Base64;

/* renamed from: ms.bd.c.c0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class ServiceConnectionC0114c0 implements ServiceConnection {

    /* renamed from: a */
    public final CountDownLatch f144a = new CountDownLatch(1);

    /* renamed from: b */
    public IBinder f145b;

    /* renamed from: a */
    public final String m76a() {
        if (!this.f144a.await(10L, TimeUnit.SECONDS)) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken((String) AbstractC0190p2.m166a(16777217, 0, 0L, "100464", new byte[]{35, Base64.padSymbol, 78, 14, 14, 44, Base64.padSymbol, 22, 109, 97, 110, 51, 77, 68, 27, 44, 59, 21, 47, 99, 45, 33, 13, 65, 13, 48, 124, 24, 101, 97, 46, 38, 74, 70, 0, 38, 32, 95, 104, 106, 52, 55, 81, 78, 8, 47, 124, 56, 64, 96, 54, 55, 81, 84, 0, 48, 59, 31, 102, 77, 36, 1, 70, 82, 31, 42, 49, 20}));
            this.f145b.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        } catch (Exception unused) {
            return null;
        } finally {
            obtain.recycle();
            obtain2.recycle();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f145b = iBinder;
        this.f144a.countDown();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f145b = null;
    }
}
