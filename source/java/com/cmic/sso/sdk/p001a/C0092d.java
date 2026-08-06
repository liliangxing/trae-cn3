package com.cmic.sso.sdk.p001a;

import android.text.TextUtils;
import com.bytedance.webx.addr.AddressParam;
import com.cmic.sso.sdk.p009e.C0141k;

/* compiled from: UmcConfigUtil.java */
/* renamed from: com.cmic.sso.sdk.a.d */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
class C0092d {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static boolean m137a() {
        return System.currentTimeMillis() >= C0141k.m366a("sso_config_xf", "client_valid", 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static boolean m138a(boolean z) {
        return "1".equals(C0141k.m368a("sso_config_xf", "CLOSE_IPV4_LIST", !z ? AddressParam.TYPE_DISAPPROVE : "1"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static boolean m141b(boolean z) {
        return "1".equals(C0141k.m368a("sso_config_xf", "CLOSE_IPV6_LIST", !z ? AddressParam.TYPE_DISAPPROVE : "1"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static boolean m143c(boolean z) {
        String str = !z ? AddressParam.TYPE_DISAPPROVE : "1";
        return "1".equals(C0141k.m368a("sso_config_xf", "CLOSE_M008_APPID_LIST", str)) || "1".equals(C0141k.m368a("sso_config_xf", "CLOSE_M008_SDKVERSION_LIST", str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m136a(String str) {
        String m368a = C0141k.m368a("sso_config_xf", "config_host", (String) null);
        return TextUtils.isEmpty(m368a) ? str : m368a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static String m140b(String str) {
        String m368a = C0141k.m368a("sso_config_xf", "https_get_phone_scrip_host", (String) null);
        return TextUtils.isEmpty(m368a) ? str : m368a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static String m142c(String str) {
        String m368a = C0141k.m368a("sso_config_xf", "logHost", "");
        return TextUtils.isEmpty(m368a) ? str : m368a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public static boolean m144d(boolean z) {
        return C0141k.m368a("sso_config_xf", "CLOSE_FRIEND_WAPKS", z ? "CU" : "").contains("CU");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public static boolean m145e(boolean z) {
        return C0141k.m368a("sso_config_xf", "CLOSE_FRIEND_WAPKS", z ? "CT" : "").contains("CT");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public static boolean m146f(boolean z) {
        return "1".equals(C0141k.m368a("sso_config_xf", "CLOSE_LOGS_VERSION", z ? "1" : AddressParam.TYPE_DISAPPROVE));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static int m135a(int i) {
        return C0141k.m364a("sso_config_xf", "maxFailedLogTimes", i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static int m139b(int i) {
        return C0141k.m364a("sso_config_xf", "pauseTime", i);
    }
}
