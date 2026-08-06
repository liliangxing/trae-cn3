package ms.bd.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.Signature;
import android.os.Looper;
import android.os.Parcel;
import com.ss.ttm.player.MediaPlayer;
import java.security.MessageDigest;
import java.util.concurrent.CountDownLatch;
import kotlin.UByte;
import org.bouncycastle.math.ec.Tnaf;

/* loaded from: classes8.dex */
public final class b3 {
    public final Context a;
    public String b;
    public c3 c;
    public final CountDownLatch d;
    public final a3 e;

    public b3(Context context) {
        this.e = new a3(this);
        this.a = context;
        this.d = new CountDownLatch(1);
    }

    public final void a(y2 y2Var) {
        boolean z;
        if (z2.a(this.a, (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "d5c718", new byte[]{118, 56, 29, 13, 6, 42, 126, 0, 51, 119, 59, 56, 0, 70, 0, 38, 99}))) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                throw new IllegalStateException((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "bc60d7", new byte[]{80, 96, 75, 74, 84, 52, 33, 80, 114, 110, 51, 110, 75, 4, 118, 33, 104, 76, 83, 104, 97, 100, 68, 64}));
            }
            Intent intent = new Intent();
            intent.setComponent(new ComponentName((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "c74c66", new byte[]{113, 58, 74, 89, 1, 36, 121, 2, 100, 35, 60, 58, 87, 18, 7, 40, 100}), (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "e681fa", new byte[]{119, 59, 70, 11, 81, 115, Byte.MAX_VALUE, 3, 104, 113, 58, 59, 91, 64, 87, Byte.MAX_VALUE, 98, 89, 64, 101, 113, 58, 95, 76, 95, 111, 85, 18, 123, 119, 125, 55, 78})));
            intent.setAction((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "d6b2a2", new byte[]{116, 55, 5, 79, 81, 43, 41, 20, 60, 111, 59, 60, 20, 95, 74, 36, 119, 89, 60, 114, 112, 58, 24, 66, Tnaf.POW_2_WIDTH, 10, 87, 50, 29, 93, 92, Tnaf.POW_2_WIDTH, 46, 117, 123, 23, 81, 62, Tnaf.POW_2_WIDTH, 71}));
            try {
            } catch (Throwable unused) {
                z = false;
            }
            if (this.a.bindService(intent, this.e, 1)) {
                try {
                    this.d.await();
                    c3 c3Var = this.c;
                    if (c3Var != null) {
                        y2Var.a.a = a(c3Var, (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "136bcf", new byte[]{15, 4, 108, 50}));
                    }
                } catch (Throwable unused2) {
                    z = true;
                    try {
                    } finally {
                        if (z) {
                            this.a.unbindService(this.e);
                        }
                    }
                }
            }
        }
    }

    public final String a(c3 c3Var, String str) {
        String str2;
        Signature[] signatureArr;
        String str3;
        MessageDigest messageDigest;
        String packageName = this.a.getPackageName();
        if (this.b == null) {
            try {
                signatureArr = this.a.getPackageManager().getPackageInfo(packageName, 64).signatures;
            } catch (Exception unused) {
                signatureArr = null;
            }
            if (signatureArr != null && signatureArr.length > 0) {
                byte[] byteArray = signatureArr[0].toByteArray();
                try {
                    messageDigest = MessageDigest.getInstance((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "766e6a", new byte[]{21, 28, 100, 64}));
                } catch (Exception unused2) {
                }
                if (messageDigest != null) {
                    byte[] digest = messageDigest.digest(byteArray);
                    StringBuilder sb = new StringBuilder();
                    for (byte b : digest) {
                        sb.append(Integer.toHexString((b & UByte.MAX_VALUE) | 256).substring(1, 3));
                    }
                    str3 = sb.toString();
                    this.b = str3;
                }
            }
            str3 = null;
            this.b = str3;
        }
        String str4 = this.b;
        c3Var.getClass();
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            try {
                obtain.writeInterfaceToken((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "f62a41", new byte[]{116, 59, 76, 91, 3, 35, 124, 3, 98, 33, 57, 59, 81, Tnaf.POW_2_WIDTH, 5, 47, 97, 89, 74, 30, 103, 49, 79, 60, 47}));
                obtain.writeString(packageName);
                obtain.writeString(str4);
                obtain.writeString(str);
                c3Var.a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                str2 = obtain2.readString();
            } catch (Exception unused3) {
                str2 = null;
            }
            return str2;
        } finally {
            obtain.recycle();
            obtain2.recycle();
        }
    }
}
