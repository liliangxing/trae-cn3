package ms.bd.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.ss.ttm.player.MediaPlayer;

/* loaded from: classes8.dex */
public final class q3 implements IInterface {
    public final IBinder a;

    public q3(IBinder iBinder) {
        this.a = iBinder;
    }

    public final String a() {
        String str;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "f3357e", new byte[]{116, 62, 77, 15, 27, 115, 104, 1, 119, 107, 112, Byte.MAX_VALUE, 65, 79, 12, 96, 106, 27, 102, 43, 115, 52, 86, 72, 11, 119, 108, 22, 113, 96, 101, 39, 73, 66, 13, 60, 76, 54, 103, 115, 126, 50, 69, 104, 12, 65, 96, 0, 116, 108, 116, 52}));
            try {
                this.a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                str = obtain2.readString();
            } catch (Throwable th) {
                th = th;
                obtain2.recycle();
                obtain.recycle();
                th.printStackTrace();
                str = null;
                obtain2.recycle();
                obtain.recycle();
                return str;
            }
        } catch (Throwable th2) {
            th = th2;
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
