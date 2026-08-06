package cn.com.chinatelecom.account.api.p010e;

import android.content.Context;
import cn.com.chinatelecom.account.api.Helper;
import cn.com.chinatelecom.account.api.p006a.C0677c;

/* renamed from: cn.com.chinatelecom.account.api.e.k */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0704k implements InterfaceC0702i {
    @Override // cn.com.chinatelecom.account.api.p010e.InterfaceC0702i
    /* renamed from: a */
    public String mo358a(Context context, long j, String str) {
        return Helper.dnprecobjs(context, j, str);
    }

    @Override // cn.com.chinatelecom.account.api.p010e.InterfaceC0702i
    /* renamed from: a */
    public String mo359a(Context context, String str, String str2, String str3, long j, boolean z, String str4) {
        return Helper.dnepah(context, str, str2, str3, j, false, z, str4);
    }

    @Override // cn.com.chinatelecom.account.api.p010e.InterfaceC0702i
    /* renamed from: a */
    public String mo360a(String str, String str2) {
        try {
            return new String(Helper.dnepmret(C0677c.m188a(str), str2));
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    @Override // cn.com.chinatelecom.account.api.p010e.InterfaceC0702i
    /* renamed from: a */
    public String mo361a(boolean z) {
        return Helper.cepahsul(z);
    }
}
