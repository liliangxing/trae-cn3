package com.xiaomi.push.service;

import android.content.Context;
import android.net.Uri;
import android.provider.Settings;
import com.ss.android.account.model.internal.BDAccountPlatformEntity;
import com.ss.android.deviceregister.utils.RomUtils;
import com.xiaomi.push.C1802w;

/* renamed from: com.xiaomi.push.service.ap */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1758ap {

    /* renamed from: a */
    private static C1758ap f3069a;

    /* renamed from: a */
    private int f3070a = 0;

    /* renamed from: a */
    private Context f3071a;

    /* renamed from: a */
    public static C1758ap m3736a(Context context) {
        if (f3069a == null) {
            f3069a = new C1758ap(context);
        }
        return f3069a;
    }

    private C1758ap(Context context) {
        this.f3071a = context.getApplicationContext();
    }

    /* renamed from: a */
    public boolean m3739a() {
        return C1802w.f3272a.contains("xmsf") || C1802w.f3272a.contains(BDAccountPlatformEntity.PLAT_NAME_XIAOMI) || C1802w.f3272a.contains(RomUtils.MIUI);
    }

    /* renamed from: a */
    public int m3737a() {
        int i = this.f3070a;
        if (i != 0) {
            return i;
        }
        try {
            this.f3070a = Settings.Global.getInt(this.f3071a.getContentResolver(), "device_provisioned", 0);
        } catch (Exception unused) {
        }
        return this.f3070a;
    }

    /* renamed from: a */
    public Uri m3738a() {
        return Settings.Global.getUriFor("device_provisioned");
    }
}
