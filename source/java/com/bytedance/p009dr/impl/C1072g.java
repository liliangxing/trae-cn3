package com.bytedance.p009dr.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import com.bytedance.bdinstall.honor.HonorKeys;
import com.bytedance.p009dr.OaidApi;
import com.bytedance.p009dr.aidl.InterfaceC1060g;
import com.bytedance.p009dr.honor.BinderC1064a;
import com.bytedance.p009dr.honor.BinderC1065b;
import com.bytedance.tobshadow.applog.log.LoggerImpl;
import com.bytedance.tobshadow.bdtracker.j;

/* renamed from: com.bytedance.dr.impl.g */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class C1072g extends AbstractC1067b<InterfaceC1060g> {

    /* renamed from: c */
    public final BinderC1064a f177c;

    /* renamed from: d */
    public final BinderC1065b f178d;

    /* renamed from: com.bytedance.dr.impl.g$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public class a implements j.b<InterfaceC1060g, String> {
        public a() {
        }

        /* renamed from: a */
        public Object m271a(IBinder iBinder) {
            return InterfaceC1060g.a.m252a(iBinder);
        }

        /* renamed from: a */
        public Object m272a(Object obj) {
            InterfaceC1060g interfaceC1060g = (InterfaceC1060g) obj;
            if (interfaceC1060g == null) {
                LoggerImpl.global().error("honor# service is null", new Object[0]);
                return null;
            }
            BinderC1064a binderC1064a = C1072g.this.f177c;
            InterfaceC1060g.a.C1200a c1200a = (InterfaceC1060g.a.C1200a) interfaceC1060g;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                obtain.writeStrongBinder(binderC1064a != null ? binderC1064a.asBinder() : null);
                c1200a.f162a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                obtain2.recycle();
                obtain.recycle();
                BinderC1065b binderC1065b = C1072g.this.f178d;
                obtain = Parcel.obtain();
                obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                    obtain.writeStrongBinder(binderC1065b != null ? binderC1065b.asBinder() : null);
                    c1200a.f162a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    obtain2.recycle();
                    obtain.recycle();
                    return "";
                } finally {
                }
            } finally {
            }
        }
    }

    public C1072g() {
        super("com.hihonor.id");
        this.f177c = new BinderC1064a();
        this.f178d = new BinderC1065b();
    }

    @Override // com.bytedance.p009dr.impl.AbstractC1067b
    /* renamed from: a */
    public Intent mo258a(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.hihonor.id.HnOaIdService");
        intent.setPackage("com.hihonor.id");
        return intent;
    }

    @Override // com.bytedance.p009dr.impl.AbstractC1067b
    /* renamed from: a */
    public j.b<InterfaceC1060g, String> mo259a() {
        return new a();
    }

    @Override // com.bytedance.p009dr.OaidApi
    public String getName() {
        return HonorKeys.NAME;
    }

    @Override // com.bytedance.p009dr.impl.AbstractC1067b, com.bytedance.p009dr.OaidApi
    public OaidApi.C1053a getOaid(Context context) {
        new j(context, mo258a(context), mo259a()).a();
        OaidApi.C1053a c1053a = new OaidApi.C1053a();
        c1053a.f153a = this.f177c.f167a;
        c1053a.f154b = this.f178d.f168a;
        LoggerImpl.global().debug(HonorKeys.TAG, new Object[]{com.bytedance.tobshadow.bdtracker.a.a("getOaid ").append(c1053a.f153a).toString()});
        return c1053a;
    }
}
