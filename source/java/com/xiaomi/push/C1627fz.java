package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.service.C1750ah;
import com.xiaomi.push.service.XMPushService;
import java.io.File;

/* renamed from: com.xiaomi.push.fz */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1627fz implements XMPushService.InterfaceC1735n {

    /* renamed from: a */
    private static boolean f1876a;

    /* renamed from: a */
    private int f1877a;

    /* renamed from: a */
    private Context f1878a;

    /* renamed from: b */
    private boolean f1879b;

    public C1627fz(Context context) {
        this.f1878a = context;
    }

    @Override // com.xiaomi.push.service.XMPushService.InterfaceC1735n
    /* renamed from: a */
    public void mo2675a() {
        m2671a(this.f1878a);
        if (this.f1879b && m2673a()) {
            AbstractC1417b.m1089a("TinyData TinyDataCacheProcessor.pingFollowUpAction ts:" + System.currentTimeMillis());
            InterfaceC1632gd m2708a = C1631gc.m2707a(this.f1878a).m2708a();
            if (!m2674a(m2708a)) {
                AbstractC1417b.m1089a("TinyData TinyDataCacheProcessor.pingFollowUpAction !canUpload(uploader) ts:" + System.currentTimeMillis());
            } else {
                f1876a = true;
                C1629ga.m2698a(this.f1878a, m2708a);
            }
        }
    }

    /* renamed from: a */
    private void m2671a(Context context) {
        this.f1879b = C1750ah.m3674a(context).m3686a(EnumC1638gj.TinyDataUploadSwitch.m2760a(), true);
        int m3678a = C1750ah.m3674a(context).m3678a(EnumC1638gj.TinyDataUploadFrequency.m2760a(), 7200);
        this.f1877a = m3678a;
        this.f1877a = Math.max(60, m3678a);
    }

    /* renamed from: a */
    private boolean m2673a() {
        return Math.abs((System.currentTimeMillis() / 1000) - this.f1878a.getSharedPreferences("mipush_extra", 4).getLong("last_tiny_data_upload_timestamp", -1L)) > ((long) this.f1877a);
    }

    /* renamed from: a */
    private boolean m2674a(InterfaceC1632gd interfaceC1632gd) {
        if (!C1486at.m1545a(this.f1878a) || interfaceC1632gd == null || TextUtils.isEmpty(m2670a(this.f1878a.getPackageName())) || !new File(this.f1878a.getFilesDir(), "tiny_data.data").exists() || f1876a) {
            return false;
        }
        return !C1750ah.m3674a(this.f1878a).m3686a(EnumC1638gj.ScreenOnOrChargingTinyDataUploadSwitch.m2760a(), false) || C1682i.m3385a(this.f1878a) || C1682i.m3391b(this.f1878a);
    }

    /* renamed from: a */
    private String m2670a(String str) {
        return "com.xiaomi.xmsf".equals(str) ? "1000271" : this.f1878a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
    }

    /* renamed from: a */
    public static void m2672a(boolean z) {
        f1876a = z;
    }
}
