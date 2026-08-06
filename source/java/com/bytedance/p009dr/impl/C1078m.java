package com.bytedance.p009dr.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.text.TextUtils;
import com.bytedance.p009dr.OaidApi;
import com.bytedance.p009dr.aidl.InterfaceC1054a;
import com.bytedance.tobshadow.applog.log.LoggerImpl;
import com.bytedance.tobshadow.bdtracker.j;

/* renamed from: com.bytedance.dr.impl.m */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class C1078m extends AbstractC1067b<InterfaceC1054a> {

    /* renamed from: c */
    public IBinder f187c;

    /* renamed from: com.bytedance.dr.impl.m$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public class a implements j.b<InterfaceC1054a, String> {
        public a(C1078m c1078m) {
        }

        /* renamed from: a */
        public Object m283a(IBinder iBinder) {
            return InterfaceC1054a.a.m241a(iBinder);
        }

        /* renamed from: a */
        public Object m284a(Object obj) {
            InterfaceC1054a interfaceC1054a = (InterfaceC1054a) obj;
            if (interfaceC1054a == null) {
                return null;
            }
            return ((InterfaceC1054a.a.C1195a) interfaceC1054a).m242a();
        }
    }

    public C1078m() {
        super("com.qiku.id");
        this.f187c = null;
    }

    @Override // com.bytedance.p009dr.impl.AbstractC1067b
    /* renamed from: a */
    public Intent mo258a(Context context) {
        Intent intent = new Intent("qiku.service.action.id");
        intent.setPackage("com.qiku.id");
        return intent;
    }

    @Override // com.bytedance.p009dr.impl.AbstractC1067b
    /* renamed from: a */
    public j.b<InterfaceC1054a, String> mo259a() {
        return new a(this);
    }

    /* renamed from: b */
    public boolean m282b() {
        try {
            IBinder iBinder = (IBinder) Class.forName("android.os.ServiceManager").getDeclaredMethod("getService", String.class).invoke(null, "qikuid");
            this.f187c = iBinder;
            if (iBinder == null) {
                return false;
            }
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                this.f187c.transact(2, obtain, obtain2, 0);
                boolean z = obtain2.readInt() == 1;
                obtain.recycle();
                obtain2.recycle();
                return z;
            } catch (Throwable unused) {
                obtain.recycle();
                obtain2.recycle();
                return false;
            }
        } catch (Throwable unused2) {
            LoggerImpl.global().debug("Oaid#Qiku360OaidImpl isOld360OSSupport error", new Object[0]);
            return false;
        }
    }

    @Override // com.bytedance.p009dr.OaidApi
    public String getName() {
        return "qiku360";
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0043  */
    @Override // com.bytedance.p009dr.impl.AbstractC1067b, com.bytedance.p009dr.OaidApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public OaidApi.C1053a getOaid(Context context) {
        String str;
        if (super.support(context)) {
            return super.getOaid(context);
        }
        OaidApi.C1053a c1053a = null;
        if (this.f187c != null) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                this.f187c.transact(4, obtain, obtain2, 0);
                str = obtain2.readString();
                obtain.recycle();
                obtain2.recycle();
            } catch (Throwable unused) {
                obtain.recycle();
                obtain2.recycle();
            }
            if (!TextUtils.isEmpty(str)) {
                c1053a = new OaidApi.C1053a();
                c1053a.f153a = str;
            }
            if (this.f187c != null) {
                Parcel obtain3 = Parcel.obtain();
                Parcel obtain4 = Parcel.obtain();
                try {
                    this.f187c.transact(7, obtain3, obtain4, 0);
                } catch (Throwable unused2) {
                }
                obtain3.recycle();
                obtain4.recycle();
            }
            return c1053a;
        }
        str = null;
        if (!TextUtils.isEmpty(str)) {
        }
        if (this.f187c != null) {
        }
        return c1053a;
    }

    @Override // com.bytedance.p009dr.impl.AbstractC1067b, com.bytedance.p009dr.OaidApi
    public boolean support(Context context) {
        boolean support = super.support(context);
        LoggerImpl.global().debug("Oaid#Qiku360OaidImpl super.support " + support, new Object[0]);
        if (support) {
            return support;
        }
        boolean m282b = m282b();
        LoggerImpl.global().debug("Oaid#Qiku360OaidImpl isOld360OSSupport " + m282b, new Object[0]);
        return m282b;
    }
}
