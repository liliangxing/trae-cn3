package ms.bd.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.ss.ttm.player.MediaPlayer;

/* loaded from: classes8.dex */
public final class z implements IInterface {
    public final IBinder a;

    public z(IBinder iBinder) {
        this.a = iBinder;
    }

    public final String a() {
        String str;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "543294", new byte[]{39, 57, 77, 8, 4, 54, 56, 91, 110, 107, 38, 120, 109, 85, 7, 10, 50, 60, 108, 118, 33, 36, 70, 71, 5, 38}));
        } catch (Throwable unused) {
        }
        try {
            this.a.transact(3, obtain, obtain2, 0);
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
        return this.a;
    }
}
