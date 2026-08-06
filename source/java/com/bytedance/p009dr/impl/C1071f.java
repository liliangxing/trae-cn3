package com.bytedance.p009dr.impl;

import android.os.IBinder;
import android.os.Parcel;
import android.util.Pair;
import com.bytedance.p009dr.aidl.InterfaceC1063j;
import com.bytedance.tobshadow.bdtracker.j;

/* renamed from: com.bytedance.dr.impl.f */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class C1071f implements j.b<InterfaceC1063j, Pair<String, Boolean>> {
    public C1071f(C1070e c1070e) {
    }

    /* renamed from: a */
    public Object m269a(IBinder iBinder) {
        return InterfaceC1063j.a.m257a(iBinder);
    }

    /* renamed from: a */
    public Object m270a(Object obj) {
        InterfaceC1063j interfaceC1063j = (InterfaceC1063j) obj;
        if (interfaceC1063j == null) {
            return null;
        }
        InterfaceC1063j.a.C1203a c1203a = (InterfaceC1063j.a.C1203a) interfaceC1063j;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            c1203a.f166a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            String readString = obtain2.readString();
            obtain2.recycle();
            obtain.recycle();
            obtain = Parcel.obtain();
            obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                c1203a.f166a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                boolean z = obtain2.readInt() != 0;
                obtain2.recycle();
                obtain.recycle();
                return new Pair(readString, Boolean.valueOf(z));
            } finally {
            }
        } finally {
        }
    }
}
