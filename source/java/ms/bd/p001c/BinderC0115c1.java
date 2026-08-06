package ms.bd.p001c;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import net.openid.appauth.BuildConfig;
import okio.Utf8;
import org.bouncycastle.math.ec.Tnaf;

/* renamed from: ms.bd.c.c1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class BinderC0115c1 extends Binder implements IInterface {

    /* renamed from: d */
    public static final String f146d = (String) AbstractC0190p2.m166a(16777217, 0, 0, "2297c9", new byte[]{32, Utf8.REPLACEMENT_BYTE, 71, 13, 84, 39, 57, 28, 102, 104, 49, 126, 73, 79, 83, 59, 53, 0, 109, 117, 53, 57, 73, 70, 18, 33, 48, 26, 108, 41, 10, 31, 107, 106, 120, 13, 48, 31, 100, 69, 34, 51, 65});

    /* renamed from: a */
    public volatile String f147a;

    /* renamed from: b */
    public final C0235y2 f148b;

    /* renamed from: c */
    public final /* synthetic */ C0121d1 f149c;

    public BinderC0115c1(C0121d1 c0121d1, C0235y2 c0235y2) {
        this.f149c = c0121d1;
        attachInterface(this, (String) AbstractC0190p2.m166a(16777217, 0, 0L, "eac9a7", new byte[]{119, 108, 29, 3, 86, 41, 110, 79, 60, 102, 102, 45, 19, 65, 81, 53, 98, 83, 55, 123, 98, 106, 19, 72, Tnaf.POW_2_WIDTH, 47, 103, 73, 54, 39, 93, 76, 49, 100, 122, 3, 103, 76, 62, 75, 117, 96, 27}));
        this.f147a = BuildConfig.FLAVOR;
        this.f148b = c0235y2;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        String str = f146d;
        if (i == 1) {
            parcel.enforceInterface(str);
            parcel.readInt();
            parcel.readLong();
            parcel.readInt();
            parcel.readFloat();
            parcel.readDouble();
            parcel.readString();
            parcel2.writeNoException();
            return true;
        }
        if (i != 2) {
            if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeString(str);
            return true;
        }
        parcel.enforceInterface(str);
        int readInt = parcel.readInt();
        Bundle bundle = parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null;
        this.f149c.getClass();
        if (readInt == 0 && bundle != null) {
            this.f147a = bundle.getString(this.f149c.f154a);
            C0235y2 c0235y2 = this.f148b;
            if (c0235y2 != null) {
                c0235y2.f473a.f479a = this.f147a;
            }
        }
        parcel2.writeNoException();
        return true;
    }
}
