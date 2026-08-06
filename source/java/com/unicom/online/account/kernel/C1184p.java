package com.unicom.online.account.kernel;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.deviceregister.base.RegistrationHeaderHelper;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import com.ss.android.update.UpdateDialogNewBase;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import javax.crypto.Cipher;
import org.json.JSONObject;

/* renamed from: com.unicom.online.account.kernel.p */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1184p {

    /* renamed from: b */
    public C1185q f291b;

    /* renamed from: c */
    private ExecutorService f292c = Executors.newSingleThreadExecutor();

    /* renamed from: a */
    public ScheduledExecutorService f290a = Executors.newScheduledThreadPool(1);

    /* renamed from: a */
    static String m544a(Context context) {
        String m474a;
        String m534a;
        String str;
        String str2 = "";
        try {
            String m458c = C1166ab.m458c();
            String sb = new StringBuilder().append(System.currentTimeMillis()).toString();
            String m556a = C1189u.m556a();
            String packageName = context.getPackageName();
            String m480b = C1167ac.m480b(1);
            String m479b = C1167ac.m479b();
            String substring = m479b.substring(0, 16);
            String substring2 = m479b.substring(16, 32);
            C1165aa.m448b("privateIp is ".concat(String.valueOf(m480b)));
            if (C1189u.f311a) {
                str = "3.1";
                m474a = C1176h.m534a(C1179k.m538a(m480b.getBytes("Utf-8"), substring.getBytes(), substring2.getBytes()));
                m534a = C1176h.m534a(C1179k.m537a(m479b.getBytes(), C1177i.m536a("045C5DD4890819CEB16B0A66ED62B2FFA29B08F3CBF344A52A3A100ECB271BBEF3A9BC3743E753CA16EF238A1E55B72E95659A70425064D506B48F8EE3442786F7")));
            } else {
                m474a = C1167ac.m474a(m480b, substring, substring2);
                PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(C1176h.m535b("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCVc1ecjpc5k7TkabF935iQONDZ0/E5XWPVv9FEsI59XTRW0+BCMK1MODRSWMvHFrPMh9ZilnRr7qXuAKCBEynQEghmpIVvMYhFu48FAI9bKfkI5lKuQK+tc4X0+zTbNrpedNoKXK4C7dDjTETBH6prwWE9j5WsAf0gbjUbIs3FxwIDAQAB")));
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(1, generatePublic);
                m534a = C1176h.m534a(cipher.doFinal(m479b.getBytes()));
                str = "2.1";
            }
            String m471a = C1189u.f313c.equalsIgnoreCase("sm3") ? C1167ac.m471a(context, context.getPackageName()) : C1167ac.m472a(context, context.getPackageName(), C1189u.f313c);
            String m455b = C1166ab.m455b();
            if (!TextUtils.isEmpty(m455b)) {
                m455b = "0";
            }
            String replaceAll = (m471a + UpdateDialogNewBase.TYPE + m458c + UpdateDialogNewBase.TYPE + str + "\njson\n" + m455b + UpdateDialogNewBase.TYPE + packageName + UpdateDialogNewBase.TYPE + m474a + UpdateDialogNewBase.TYPE + m556a + UpdateDialogNewBase.TYPE + m534a + UpdateDialogNewBase.TYPE + sb).replaceAll(UpdateDialogNewBase.TYPE, "");
            String m486c = C1189u.f311a ? C1167ac.m486c(replaceAll) : C1167ac.m473a(replaceAll);
            String m533a = C1176h.m533a(m474a);
            String m533a2 = C1176h.m533a(m534a);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("androidMd5", m471a);
            jSONObject.put("apiKey", m458c);
            jSONObject.put("apiVersion", str);
            jSONObject.put("format", "json");
            jSONObject.put("operator", m455b);
            jSONObject.put("packName", packageName);
            jSONObject.put("privateIp", m533a);
            jSONObject.put("sdkVersion", m556a);
            jSONObject.put("secretKey", m533a2);
            jSONObject.put("timeStamp", sb);
            jSONObject.put("sign", m486c);
            str2 = jSONObject.toString();
            C1165aa.m448b("getPreCheckParam_CU_Oath: param ok  \n");
            return str2;
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m545a(C1184p c1184p) {
        try {
            ScheduledExecutorService scheduledExecutorService = c1184p.f290a;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
                c1184p.f290a = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public final void m546a(final Context context, final int i, final Object obj, final InterfaceC1186r interfaceC1186r) {
        synchronized (this) {
            try {
                this.f292c.submit(new Runnable() { // from class: com.unicom.online.account.kernel.p.4
                    /* JADX WARN: Removed duplicated region for block: B:15:0x0084 A[Catch: Exception -> 0x0096, TryCatch #1 {Exception -> 0x0096, blocks: (B:2:0x0000, B:11:0x0038, B:13:0x007e, B:15:0x0084, B:18:0x0090, B:24:0x007b, B:25:0x0017, B:26:0x0015, B:21:0x006d), top: B:1:0x0000, inners: #0 }] */
                    /* JADX WARN: Removed duplicated region for block: B:18:0x0090 A[Catch: Exception -> 0x0096, TRY_LEAVE, TryCatch #1 {Exception -> 0x0096, blocks: (B:2:0x0000, B:11:0x0038, B:13:0x007e, B:15:0x0084, B:18:0x0090, B:24:0x007b, B:25:0x0017, B:26:0x0015, B:21:0x006d), top: B:1:0x0000, inners: #0 }] */
                    /* JADX WARN: Removed duplicated region for block: B:20:0x006d A[EXC_TOP_SPLITTER, SYNTHETIC] */
                    @Override // java.lang.Runnable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final void run() {
                        String m554a;
                        try {
                            String str = "";
                            C1189u.f311a = false;
                            int i2 = i;
                            if (i2 == 2 || i2 == 3) {
                                C1189u.f311a = true;
                            } else if (i2 != 4 && i2 != 5) {
                                C1187s c1187s = new C1187s();
                                Context context2 = context;
                                HashMap<String, String> hashMap = new HashMap<>();
                                hashMap.put("user-agent", "Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 %sSafari/533.1");
                                hashMap.put("netType", "2");
                                hashMap.put(RegistrationHeaderHelper.KEY_OS, RomUtils.OS_ANDROID);
                                hashMap.put("Accept", "*/*");
                                m554a = c1187s.m554a(context2, str, hashMap, obj);
                                if (C1166ab.m466g() == 1) {
                                    try {
                                        C1191w.m564a().m570b();
                                        C1165aa.m448b("\n  WIFI + 流量 \n call releaseNetwork() \n");
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                                if (TextUtils.isEmpty(m554a)) {
                                    interfaceC1186r.mo547a(1, m554a);
                                    return;
                                } else {
                                    interfaceC1186r.mo547a(410022, "网络请求响应为空");
                                    return;
                                }
                            }
                            str = C1166ab.m452a() + C1193y.m572a(C1184p.m544a(context), "&");
                            C1187s c1187s2 = new C1187s();
                            Context context22 = context;
                            HashMap<String, String> hashMap2 = new HashMap<>();
                            hashMap2.put("user-agent", "Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 %sSafari/533.1");
                            hashMap2.put("netType", "2");
                            hashMap2.put(RegistrationHeaderHelper.KEY_OS, RomUtils.OS_ANDROID);
                            hashMap2.put("Accept", "*/*");
                            m554a = c1187s2.m554a(context22, str, hashMap2, obj);
                            if (C1166ab.m466g() == 1) {
                            }
                            if (TextUtils.isEmpty(m554a)) {
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                });
            } catch (Exception e) {
                interfaceC1186r.mo547a(410009, "410009" + e.getMessage());
            }
        }
    }
}
