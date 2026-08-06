package ms.bd.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.ss.ttm.player.MediaPlayer;
import org.bouncycastle.math.ec.Tnaf;

/* loaded from: classes8.dex */
public final class c implements IInterface {
    public final IBinder a;

    public c(IBinder iBinder) {
        this.a = iBinder;
    }

    public final String a() {
        String str;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "79bfa5", new byte[]{37, 52, 28, 92, 95, 49, 33, 11, 125, 59, 53, 58, 95, 33, 75, 50, 36, 20, 54, 59, 35, 53, 5, 19, 76, 59, Tnaf.POW_2_WIDTH, 49, 23, 120, 15, 31, 24, 22, Byte.MAX_VALUE, 43, 48, 20, 26, 56, 50, 62, 3, 20, 95, 33, 49}));
        } catch (Throwable unused) {
        }
        try {
            this.a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            str = obtain2.readString();
        } catch (Throwable unused2) {
            obtain.recycle();
            obtain2.recycle();
            str = null;
            obtain.recycle();
            obtain2.recycle();
            return str;
        }
        obtain.recycle();
        obtain2.recycle();
        return str;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.a;
    }
}
