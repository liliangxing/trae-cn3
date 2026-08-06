package ms.bd.c;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.ss.ttm.player.MediaPlayer;
import java.util.concurrent.LinkedBlockingQueue;
import okio.Utf8;
import org.bouncycastle.math.ec.Tnaf;

/* loaded from: classes8.dex */
public final class d1 {
    public final Context b;
    public final String a = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "4a3723", new byte[]{42, 98, Byte.MAX_VALUE, 74, 9, 27, 49, 76, 99, 96});
    public final LinkedBlockingQueue c = new LinkedBlockingQueue(1);
    public final b1 d = new b1(this);

    public d1(Context context) {
        this.b = context;
    }

    public final void a(y2 y2Var) {
        g1 e1Var;
        if (z2.a(this.b, (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "4d227d", new byte[]{38, 105, 76, 8, 0, 122, Utf8.REPLACEMENT_BYTE, 74, 109, 109, 55, 40, 72, 66}))) {
            Intent intent = new Intent();
            intent.setAction((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "2cee9b", new byte[]{32, 110, 27, 95, 14, 124, 57, 77, 58, 58, 49, 47, 31, 21, 72, 93, Utf8.REPLACEMENT_BYTE, 109, 53, 28, 39, 82, 19, 3, Tnaf.POW_2_WIDTH, 124, 50, 71}));
            intent.setPackage((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "d4a8c6", new byte[]{118, 57, 31, 2, 84, 40, 111, 26, 62, 103, 103, 120, 27, 72}));
            if (this.b.bindService(intent, this.d, 1)) {
                try {
                    IBinder iBinder = (IBinder) this.c.take();
                    if (iBinder == null) {
                        String str = f1.a;
                        e1Var = null;
                    } else {
                        IInterface queryLocalInterface = iBinder.queryLocalInterface(f1.a);
                        e1Var = (queryLocalInterface == null || !(queryLocalInterface instanceof g1)) ? new e1(iBinder) : (g1) queryLocalInterface;
                    }
                    c1 c1Var = new c1(this, y2Var);
                    e1 e1Var2 = (e1) e1Var;
                    e1Var2.getClass();
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "d8925d", new byte[]{118, 53, 71, 8, 2, 122, 111, 22, 102, 109, 103, 116, 73, 74, 5, 102, 99, 10, 109, 112, 99, 51, 73, 67, 68, 124, 102, Tnaf.POW_2_WIDTH, 108, 44, 92, 21, 107, 111, 46, 64, 98, 11, 126, 107, 118, Utf8.REPLACEMENT_BYTE}));
                        obtain.writeStrongBinder(c1Var);
                        e1Var2.a.transact(2, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } catch (Exception unused) {
                } finally {
                    this.b.unbindService(this.d);
                }
            }
        }
    }
}
