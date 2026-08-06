package com.bytedance.p009dr.impl;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.p009dr.OaidApi;
import com.bytedance.tobshadow.applog.log.LoggerImpl;
import com.bytedance.tobshadow.bdtracker.j;
import com.bytedance.tobshadow.bdtracker.r5;

/* renamed from: com.bytedance.dr.impl.e */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class C1070e implements OaidApi {

    /* renamed from: b */
    public static final com.bytedance.tobshadow.bdtracker.b<Boolean> f174b = new a();

    /* renamed from: a */
    public String f175a;

    /* renamed from: com.bytedance.dr.impl.e$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class a extends com.bytedance.tobshadow.bdtracker.b<Boolean> {
        /* renamed from: a */
        public Object m268a(Object[] objArr) {
            Context context = (Context) objArr[0];
            return Boolean.valueOf((r5.a(context, "com.huawei.hwid") || r5.a(context, "com.huawei.hwid.tv")) ? true : r5.a(context, "com.huawei.hms"));
        }
    }

    /* renamed from: com.bytedance.dr.impl.e$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class b extends OaidApi.C1053a {

        /* renamed from: c */
        public long f176c = 0;
    }

    /* renamed from: a */
    public static boolean m267a(Context context) {
        if (context == null) {
            return false;
        }
        return ((Boolean) f174b.b(new Object[]{context})).booleanValue();
    }

    @Override // com.bytedance.p009dr.OaidApi
    public String getName() {
        return "Huawei";
    }

    @Override // com.bytedance.p009dr.OaidApi
    public OaidApi.C1053a getOaid(Context context) {
        String string;
        String string2;
        b bVar = new b();
        int i = 0;
        try {
            string = Settings.Global.getString(context.getContentResolver(), "pps_oaid");
            string2 = Settings.Global.getString(context.getContentResolver(), "pps_track_limit");
        } catch (Throwable th) {
            LoggerImpl.global().error(1, "getOaid failed", th, new Object[0]);
        }
        if (!TextUtils.isEmpty(string)) {
            bVar.f153a = string;
            bVar.f154b = Boolean.parseBoolean(string2);
            bVar.f176c = 202003021704L;
            return bVar;
        }
        Pair pair = TextUtils.isEmpty(this.f175a) ? null : (Pair) new j(context, new Intent("com.uodis.opendevice.OPENIDS_SERVICE").setPackage(this.f175a), new C1071f(this)).a();
        if (pair != null) {
            bVar.f153a = (String) pair.first;
            bVar.f154b = ((Boolean) pair.second).booleanValue();
            try {
                PackageInfo a2 = r5.a(context, this.f175a, 0);
                if (a2 != null) {
                    i = a2.versionCode;
                }
            } catch (Throwable th2) {
                LoggerImpl.global().error(1, "getHwIdVersionCode failed", th2, new Object[0]);
            }
            bVar.f176c = i;
        }
        return bVar;
    }

    @Override // com.bytedance.p009dr.OaidApi
    public boolean support(Context context) {
        if (context == null) {
            return false;
        }
        String str = "com.huawei.hwid";
        if (!r5.a(context, "com.huawei.hwid")) {
            str = "com.huawei.hwid.tv";
            if (!r5.a(context, "com.huawei.hwid.tv")) {
                this.f175a = "com.huawei.hms";
                return r5.a(context, "com.huawei.hms");
            }
        }
        this.f175a = str;
        return true;
    }
}
