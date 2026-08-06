package ms.bd.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.ss.ttm.player.MediaPlayer;
import kotlin.io.encoding.Base64;

/* loaded from: classes8.dex */
public final class z0 implements IInterface {
    public final IBinder a;

    public z0(IBinder iBinder) {
        this.a = iBinder;
    }

    public final String a() {
        String str;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "7b5de8", new byte[]{37, 111, 75, 94, 79, 32, 48, 74, 119, 122, 41, 112, 67, 30, 94, 42, 34, 74, 103, 49, 104, 97, 79, 20, 86, 97, 27, 83, 97, 58, 2, 101, 80, 25, 89, 42, 29, 71, 97, 58, 50, 105, 64, 25, 95, Base64.padSymbol, 7, 70, 118, 34, 47, 99, 67}));
            try {
                this.a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                str = obtain2.readString();
            } catch (Throwable th) {
                th = th;
                obtain.recycle();
                obtain2.recycle();
                th.printStackTrace();
                str = null;
                obtain.recycle();
                obtain2.recycle();
                return str;
            }
        } catch (Throwable th2) {
            th = th2;
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
