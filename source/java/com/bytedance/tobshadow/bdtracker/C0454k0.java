package com.bytedance.tobshadow.bdtracker;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.tobshadow.applog.IActiveCustomParamsCallback;
import com.bytedance.tobshadow.applog.Level;
import com.bytedance.tobshadow.applog.UriConfig;
import com.bytedance.tobshadow.applog.util.SensitiveUtils;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.k0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0454k0 extends AbstractC0461l0 {
    public C0454k0(C0475n0 c0475n0) {
        super(c0475n0);
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x0234  */
    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0461l0
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean mo485c() {
        String str;
        JSONObject m465a;
        Map<String, String> params;
        C0421f2 c0421f2 = this.f734e.f839i;
        boolean z = false;
        if (c0421f2.m426i() != 0) {
            UriConfig m554e = this.f734e.m554e();
            JSONObject m420f = c0421f2.m420f();
            if (m420f != null) {
                String m501a = this.f735f.f781j.m501a(c0421f2.m420f(), m554e.getActiveUri(), true, Level.L0);
                C0444i4 c0444i4 = this.f735f.f782k;
                c0444i4.f668b.f764D.debug(11, "Start to active to uri:{} with request:{}...", m501a, m420f);
                StringBuilder sb = new StringBuilder(m501a);
                C0458k4 c0458k4 = c0444i4.f668b.f781j;
                String str2 = null;
                C0444i4.m460a(sb, "google_aid", (String) c0458k4.m500a(m420f, "google_aid", (String) null, (Class<String>) String.class));
                float rawOffset = (TimeZone.getDefault().getRawOffset() * 1.0f) / 3600000.0f;
                if (rawOffset < -12.0f) {
                    rawOffset = -12.0f;
                }
                if (rawOffset > 12.0f) {
                    rawOffset = 12.0f;
                }
                C0444i4.m460a(sb, "timezone", rawOffset + "");
                IActiveCustomParamsCallback activeCustomParams = c0444i4.f668b.getActiveCustomParams();
                if (activeCustomParams != null && (params = activeCustomParams.getParams()) != null && !params.isEmpty()) {
                    for (Map.Entry<String, String> entry : params.entrySet()) {
                        if (entry != null) {
                            String key = entry.getKey();
                            String value = entry.getValue();
                            if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                                C0444i4.m460a(sb, "custom_" + key, value);
                            }
                        }
                    }
                }
                String str3 = (String) c0458k4.m500a(m420f, "real_package_name", (String) null, (Class<String>) String.class);
                if (!TextUtils.isEmpty(str3)) {
                    C0444i4.m460a(sb, "package", (String) c0458k4.m500a(m420f, "package", (String) null, (Class<String>) String.class));
                    C0444i4.m460a(sb, "real_package_name", str3);
                }
                C0444i4.m460a(sb, "carrier", (String) c0458k4.m500a(m420f, "carrier", (String) null, (Class<String>) String.class));
                C0444i4.m460a(sb, "sim_region", (String) c0458k4.m500a(m420f, "sim_region", (String) null, (Class<String>) String.class));
                C0444i4.m460a(sb, "app_version_minor", (String) c0458k4.m500a(m420f, "app_version_minor", (String) null, (Class<String>) String.class));
                SensitiveUtils.addSensitiveParamsForUrlQuery(c0458k4, sb, m420f);
                String m303a = C0404d.m303a((JSONObject) c0458k4.m500a(m420f, "oaid", (String) null, (Class<String>) JSONObject.class));
                if (TextUtils.isEmpty(m303a)) {
                    c0444i4.f668b.f764D.warn(11, "active oaid is empty", new Object[0]);
                } else {
                    C0444i4.m460a(sb, "oaid", m303a);
                }
                C0444i4.m460a(sb, "click_id", (String) c0458k4.m500a(m420f, "click_id", (String) null, (Class<String>) String.class));
                C0444i4.m460a(sb, "click_id_nature", (String) c0458k4.m500a(m420f, "click_id_nature", (String) null, (Class<String>) String.class));
                C0444i4.m460a(sb, "client_tun", (String) c0458k4.m500a(m420f, "client_tun", (String) null, (Class<String>) String.class));
                C0444i4.m460a(sb, "client_anpi", (String) c0458k4.m500a(m420f, "client_anpi", (String) null, (Class<String>) String.class));
                String sb2 = sb.toString();
                String m720a = C0536v5.m720a();
                try {
                    if (!TextUtils.isEmpty("req_id") && !TextUtils.isEmpty(m720a)) {
                        sb2 = Uri.parse(sb2).buildUpon().appendQueryParameter("req_id", m720a).build().toString();
                    }
                } catch (Throwable th) {
                    c0444i4.f668b.f764D.error(11, "addQuery", th, new Object[0]);
                }
                try {
                    str = new String(c0444i4.f668b.getNetClient().execute((byte) 0, c0444i4.f669c.m585a(sb2), null, c0444i4.m464a(), (byte) 0, true, 60000));
                } catch (Exception e) {
                    e = e;
                }
                try {
                    c0444i4.f668b.f764D.debug(11, "request active success: {}", str);
                } catch (Exception e2) {
                    e = e2;
                    str2 = str;
                    c0444i4.f668b.f764D.error(11, "request active error", e, new Object[0]);
                    c0444i4.f668b.m522b().mo639a(e, "active");
                    str = str2;
                    m465a = c0444i4.m465a(str);
                    if (m465a != null) {
                        z = true;
                    }
                    if (z) {
                    }
                    return z;
                }
                m465a = c0444i4.m465a(str);
                if (m465a != null && "success".equals(m465a.optString("message", ""))) {
                    z = true;
                }
            } else {
                this.f734e.f834d.f764D.error("Device header is null", new Object[0]);
            }
        }
        if (z) {
            this.f733d = true;
        }
        return z;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0461l0
    /* renamed from: d */
    public String mo486d() {
        return "Activator";
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0461l0
    /* renamed from: e */
    public long[] mo487e() {
        return C0496q0.f934g;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0461l0
    /* renamed from: f */
    public boolean mo488f() {
        return true;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0461l0
    /* renamed from: g */
    public long mo489g() {
        return 3600000L;
    }
}
