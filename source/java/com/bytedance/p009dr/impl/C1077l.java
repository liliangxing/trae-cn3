package com.bytedance.p009dr.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.os.Parcel;
import android.text.TextUtils;
import com.bytedance.p009dr.OaidApi;
import com.bytedance.p009dr.aidl.InterfaceC1061h;
import com.bytedance.tobshadow.applog.log.LoggerImpl;
import com.bytedance.tobshadow.bdtracker.j;
import com.bytedance.tobshadow.bdtracker.r5;
import java.security.MessageDigest;

/* renamed from: com.bytedance.dr.impl.l */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class C1077l implements OaidApi {

    /* renamed from: a */
    public final OaidApi f182a;

    /* renamed from: b */
    public com.bytedance.tobshadow.bdtracker.b<Boolean> f183b = new a(this);

    /* renamed from: com.bytedance.dr.impl.l$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public class a extends com.bytedance.tobshadow.bdtracker.b<Boolean> {
        public a(C1077l c1077l) {
        }

        /* renamed from: a */
        public Object m279a(Object[] objArr) {
            try {
                PackageInfo a = r5.a((Context) objArr[0], "com.heytap.openid", 0);
                if (a == null) {
                    LoggerImpl.global().warn("Oaid#OnePlusOaidImpl pi == null ", new Object[0]);
                    return false;
                }
                long longVersionCode = Build.VERSION.SDK_INT >= 28 ? a.getLongVersionCode() : a.versionCode;
                LoggerImpl.global().debug("Oaid#OnePlusOaidImpl versionCode -> " + longVersionCode, new Object[0]);
                return Boolean.valueOf(longVersionCode >= 1);
            } catch (Throwable th) {
                LoggerImpl.global().error(1, "Oaid#Get package:{} info failed", th, new Object[]{"com.heytap.openid"});
                return false;
            }
        }
    }

    /* renamed from: com.bytedance.dr.impl.l$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public class b implements j.b<InterfaceC1061h, String> {

        /* renamed from: a */
        public final /* synthetic */ Context f184a;

        /* renamed from: b */
        public final /* synthetic */ long f185b;

        public b(Context context, long j) {
            this.f184a = context;
            this.f185b = j;
        }

        /* renamed from: a */
        public Object m280a(IBinder iBinder) {
            return InterfaceC1061h.a.m253a(iBinder);
        }

        /* renamed from: a */
        public Object m281a(Object obj) {
            InterfaceC1061h interfaceC1061h = (InterfaceC1061h) obj;
            if (interfaceC1061h != null) {
                String m278a = C1077l.this.m278a(this.f184a);
                LoggerImpl.global().debug(com.bytedance.tobshadow.bdtracker.a.a("Oaid#OnePlusOaidImpl fetchResult sign -> ", m278a), new Object[0]);
                if (!TextUtils.isEmpty(m278a)) {
                    LoggerImpl.global().debug(com.bytedance.tobshadow.bdtracker.a.a("Oaid#OnePlusOaidImpl fetchResult finish -> ").append(System.currentTimeMillis() - this.f185b).toString(), new Object[0]);
                    String packageName = this.f184a.getPackageName();
                    InterfaceC1061h.a.C1201a c1201a = (InterfaceC1061h.a.C1201a) interfaceC1061h;
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                        obtain.writeString(packageName);
                        obtain.writeString(m278a);
                        obtain.writeString("OUID");
                        c1201a.f163a.transact(1, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }
            return null;
        }
    }

    public C1077l(OaidApi oaidApi) {
        this.f182a = oaidApi;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0032 A[Catch: all -> 0x0059, TryCatch #1 {all -> 0x0059, blocks: (B:11:0x002a, B:13:0x0032, B:15:0x003f, B:17:0x0054), top: B:10:0x002a }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String m278a(Context context) {
        Signature[] signatureArr;
        MessageDigest messageDigest;
        PackageInfo a2;
        try {
            a2 = r5.a(context, context.getPackageName(), 64);
        } catch (Throwable th) {
            LoggerImpl.global().error(1, "getPackageInfo failed", th, new Object[0]);
        }
        if (a2 != null) {
            signatureArr = a2.signatures;
            if (signatureArr != null && signatureArr.length > 0) {
                byte[] byteArray = signatureArr[0].toByteArray();
                try {
                    messageDigest = MessageDigest.getInstance("SHA1");
                    if (messageDigest != null) {
                        byte[] digest = messageDigest.digest(byteArray);
                        StringBuilder sb = new StringBuilder();
                        for (byte b2 : digest) {
                            sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
                        }
                        return sb.toString();
                    }
                } catch (Throwable th2) {
                    LoggerImpl.global().error(1, "Sign package info failed", th2, new Object[0]);
                }
            }
            return null;
        }
        signatureArr = null;
        if (signatureArr != null) {
            byte[] byteArray2 = signatureArr[0].toByteArray();
            messageDigest = MessageDigest.getInstance("SHA1");
            if (messageDigest != null) {
            }
        }
        return null;
    }

    @Override // com.bytedance.p009dr.OaidApi
    public String getName() {
        return (this.f182a == null || ((Boolean) this.f183b.b(new Object[0])).booleanValue()) ? "OnePlus/Oppo" : this.f182a.getName();
    }

    @Override // com.bytedance.p009dr.OaidApi
    public OaidApi.C1053a getOaid(Context context) {
        if (this.f182a != null && !((Boolean) this.f183b.b(new Object[0])).booleanValue()) {
            return this.f182a.getOaid(context);
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        long currentTimeMillis = System.currentTimeMillis();
        LoggerImpl.global().debug("Oaid#OnePlusOaidImpl getOaid start -> ", new Object[0]);
        String str = (String) new j(context, intent, new b(context, currentTimeMillis)).a();
        OaidApi.C1053a c1053a = new OaidApi.C1053a();
        c1053a.f153a = str;
        return c1053a;
    }

    @Override // com.bytedance.p009dr.OaidApi
    public boolean support(Context context) {
        if (context == null) {
            return false;
        }
        Boolean bool = (Boolean) this.f183b.b(new Object[]{context});
        LoggerImpl.global().debug("Oaid#OnePlusOaidImpl originSupport -> " + bool, new Object[0]);
        if (this.f182a == null || bool.booleanValue()) {
            return bool.booleanValue();
        }
        LoggerImpl.global().debug(com.bytedance.tobshadow.bdtracker.a.a("Oaid#OnePlusOaidImpl mCallback.support(context) -> ").append(this.f182a.support(context)).toString(), new Object[0]);
        return this.f182a.support(context);
    }
}
