package com.bytedance.dr.impl;

import android.os.IBinder;
import android.os.Parcel;
import android.util.Pair;
import com.bytedance.dr.aidl.j;
import com.bytedance.tobshadow.bdtracker.j;

/* loaded from: classes3.dex */
public class f implements j.b<com.bytedance.dr.aidl.j, Pair<String, Boolean>> {
    public f(e eVar) {
    }

    @Override // com.bytedance.tobshadow.bdtracker.j.b
    public com.bytedance.dr.aidl.j a(IBinder iBinder) {
        return j.a.a(iBinder);
    }

    @Override // com.bytedance.tobshadow.bdtracker.j.b
    public Pair<String, Boolean> a(com.bytedance.dr.aidl.j jVar) {
        com.bytedance.dr.aidl.j jVar2 = jVar;
        if (jVar2 == null) {
            return null;
        }
        j.a.C0073a c0073a = (j.a.C0073a) jVar2;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            c0073a.a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            String readString = obtain2.readString();
            obtain2.recycle();
            obtain.recycle();
            obtain = Parcel.obtain();
            obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                c0073a.a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                boolean z = obtain2.readInt() != 0;
                obtain2.recycle();
                obtain.recycle();
                return new Pair<>(readString, Boolean.valueOf(z));
            } finally {
            }
        } finally {
        }
    }
}
