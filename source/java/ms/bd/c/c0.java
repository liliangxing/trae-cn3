package ms.bd.c;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Parcel;
import com.ss.ttm.player.MediaPlayer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.io.encoding.Base64;

/* loaded from: classes8.dex */
public final class c0 implements ServiceConnection {
    public final CountDownLatch a = new CountDownLatch(1);
    public IBinder b;

    public final String a() {
        if (!this.a.await(10L, TimeUnit.SECONDS)) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "100464", new byte[]{35, Base64.padSymbol, 78, 14, 14, 44, Base64.padSymbol, 22, 109, 97, 110, 51, 77, 68, 27, 44, 59, 21, 47, 99, 45, 33, 13, 65, 13, 48, 124, 24, 101, 97, 46, 38, 74, 70, 0, 38, 32, 95, 104, 106, 52, 55, 81, 78, 8, 47, 124, 56, 64, 96, 54, 55, 81, 84, 0, 48, 59, 31, 102, 77, 36, 1, 70, 82, 31, 42, 49, 20}));
            this.b.transact(1, obtain, obtain2, 0);
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
        this.b = iBinder;
        this.a.countDown();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.b = null;
    }
}
