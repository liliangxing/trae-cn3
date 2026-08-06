package com.unicom.online.account.kernel;

import android.content.Context;
import android.text.TextUtils;
import java.net.InetAddress;
import java.security.Security;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

/* renamed from: com.unicom.online.account.kernel.f */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1174f {

    /* renamed from: b */
    private static volatile C1174f f248b;

    /* renamed from: a */
    public Context f249a;

    /* renamed from: c */
    private ExecutorService f250c = Executors.newSingleThreadExecutor();

    private C1174f() {
    }

    /* renamed from: a */
    static /* synthetic */ int m511a(int i) {
        return Math.abs(new Random().nextInt() % i);
    }

    /* renamed from: a */
    public static C1174f m513a() {
        if (f248b == null) {
            synchronized (C1174f.class) {
                if (f248b == null) {
                    f248b = new C1174f();
                }
            }
        }
        return f248b;
    }

    /* renamed from: a */
    public static void m514a(InterfaceC1173e interfaceC1173e, String str) {
        C1165aa.m450d(str);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("resultCode", 1);
            jSONObject.put("resultMsg", str);
            jSONObject.put("resultData", "");
            jSONObject.put("seq", "");
            jSONObject.put("operatorType", "CU");
            interfaceC1173e.onResult(jSONObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static boolean m515a(Context context) {
        return C1190v.m558a(context) && C1190v.m560c(context);
    }

    /* renamed from: a */
    public static boolean m516a(String str) {
        if (!str.equalsIgnoreCase("ali.wosms.cn") && !str.equalsIgnoreCase("msv6.wosms.cn") && !str.equalsIgnoreCase("m.zzx.cnklog.com")) {
            return false;
        }
        C1189u.f314d = str;
        return true;
    }

    /* renamed from: a */
    public static boolean m517a(boolean z) {
        C1187s.f306a = z;
        return z;
    }

    /* renamed from: b */
    public static String m518b() {
        return C1189u.m556a();
    }

    /* renamed from: b */
    public static void m519b(Context context) {
        C1190v.m559b(context);
    }

    /* renamed from: b */
    public static void m520b(boolean z) {
        C1165aa.m447a(z);
    }

    /* renamed from: c */
    public static String m521c() {
        return C1189u.m557b();
    }

    /* renamed from: c */
    public static void m522c(Context context) {
        C1190v.m561d(context);
    }

    /* renamed from: d */
    public static String m523d() {
        return Security.getProvider("BC") != null ? new StringBuilder().append(Security.getProvider("BC").getVersion()).toString() : "Security.getProvider(BouncyCastleProvider.PROVIDER_NAME) is null";
    }

    /* renamed from: e */
    public static String m524e() {
        return C1189u.f314d;
    }

    /* renamed from: f */
    public static String m525f() {
        C1189u.f314d = "msv6.wosms.cn";
        return "msv6.wosms.cn";
    }

    /* renamed from: h */
    public static void m526h() {
        C1191w.m564a().m570b();
    }

    /* renamed from: g */
    public final void m527g() {
        this.f250c.submit(new Runnable() { // from class: com.unicom.online.account.kernel.f.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    InetAddress[] allByName = InetAddress.getAllByName(C1174f.m524e());
                    if (allByName != null && allByName.length > 0) {
                        C1166ab.f226a = allByName[C1174f.m511a(allByName.length)].getHostAddress();
                        C1169ae.m499a(C1174f.this.f249a, "auth400", C1176h.m534a(C1166ab.f226a.getBytes()));
                        C1187s.f306a = true;
                    } else {
                        String m497a = C1169ae.m497a(C1174f.this.f249a);
                        if (TextUtils.isEmpty(m497a)) {
                            return;
                        }
                        C1166ab.f226a = m497a;
                    }
                } catch (Exception e) {
                    C1187s.f306a = false;
                    C1174f.m525f();
                    e.printStackTrace();
                }
            }
        });
    }
}
