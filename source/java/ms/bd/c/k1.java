package ms.bd.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.ss.ttm.player.MediaPlayer;

/* loaded from: classes8.dex */
public final class k1 implements IInterface {
    public final IBinder a;

    public k1(IBinder iBinder) {
        this.a = iBinder;
    }

    public final String a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            try {
                obtain.writeInterfaceToken((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "b19235", new byte[]{112, 60, 71, 8, 22, 55, 104, 94, 108, 103, 101, 58, 73, 67, 5, 38, 114, 21, 122, 116, 122, 48, 79, 8, 37, 6, 100, 6, 97, 97, 118, 58, 78, 111, 2, 54, 100, 2, 110, 99, 112, 54}));
                try {
                    this.a.transact(1, obtain, obtain2, 0);
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
