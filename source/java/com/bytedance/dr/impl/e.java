package com.bytedance.dr.impl;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.dr.OaidApi;
import com.bytedance.tobshadow.applog.log.LoggerImpl;
import com.bytedance.tobshadow.bdtracker.r5;
import com.huawei.hms.common.PackageConstants;

/* loaded from: classes3.dex */
public final class e implements OaidApi {
    public static final com.bytedance.tobshadow.bdtracker.b<Boolean> b = new a();
    public String a;

    /* loaded from: classes3.dex */
    public static class a extends com.bytedance.tobshadow.bdtracker.b<Boolean> {
        @Override // com.bytedance.tobshadow.bdtracker.b
        public Boolean a(Object[] objArr) {
            Context context = (Context) objArr[0];
            return Boolean.valueOf((r5.a(context, "com.huawei.hwid") || r5.a(context, "com.huawei.hwid.tv")) ? true : r5.a(context, PackageConstants.SERVICES_PACKAGE_ALL_SCENE));
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends OaidApi.a {
        public long c = 0;
    }

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        return b.b(context).booleanValue();
    }

    @Override // com.bytedance.dr.OaidApi
    public String getName() {
        return "Huawei";
    }

    @Override // com.bytedance.dr.OaidApi
    public OaidApi.a getOaid(Context context) {
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
            bVar.a = string;
            bVar.b = Boolean.parseBoolean(string2);
            bVar.c = 202003021704L;
            return bVar;
        }
        Pair pair = TextUtils.isEmpty(this.a) ? null : (Pair) new com.bytedance.tobshadow.bdtracker.j(context, new Intent("com.uodis.opendevice.OPENIDS_SERVICE").setPackage(this.a), new f(this)).a();
        if (pair != null) {
            bVar.a = (String) pair.first;
            bVar.b = ((Boolean) pair.second).booleanValue();
            try {
                PackageInfo a2 = r5.a(context, this.a, 0);
                if (a2 != null) {
                    i = a2.versionCode;
                }
            } catch (Throwable th2) {
                LoggerImpl.global().error(1, "getHwIdVersionCode failed", th2, new Object[0]);
            }
            bVar.c = i;
        }
        return bVar;
    }

    @Override // com.bytedance.dr.OaidApi
    public boolean support(Context context) {
        if (context == null) {
            return false;
        }
        String str = "com.huawei.hwid";
        if (!r5.a(context, "com.huawei.hwid")) {
            str = "com.huawei.hwid.tv";
            if (!r5.a(context, "com.huawei.hwid.tv")) {
                this.a = PackageConstants.SERVICES_PACKAGE_ALL_SCENE;
                return r5.a(context, PackageConstants.SERVICES_PACKAGE_ALL_SCENE);
            }
        }
        this.a = str;
        return true;
    }
}
