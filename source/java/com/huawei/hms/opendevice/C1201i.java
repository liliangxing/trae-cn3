package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.aaid.encrypt.PushEncrypter;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.support.log.HMSLog;
import java.util.Map;

/* compiled from: PushClientSp.java */
/* renamed from: com.huawei.hms.opendevice.i */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1201i extends PushPreferences {

    /* renamed from: c */
    private static final String f1605c = "i";

    /* renamed from: b */
    private Context f1606b;

    private C1201i(Context context) {
        super(context, "push_client_self_info");
        this.f1606b = context;
    }

    /* renamed from: a */
    public static C1201i m1865a(Context context) {
        return new C1201i(context);
    }

    /* renamed from: b */
    public String m1869b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return m1866a("token_info_v2");
            }
            return m1866a(str);
        } catch (Exception e) {
            HMSLog.m2118e(f1605c, "getSecureData" + e.getMessage());
            return "";
        }
    }

    /* renamed from: c */
    public boolean m1871c(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return removeKey("token_info_v2");
            }
            return removeKey(str);
        } catch (Exception e) {
            HMSLog.m2118e(f1605c, "removeToken" + e.getMessage());
            return false;
        }
    }

    /* renamed from: a */
    public String m1866a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return PushEncrypter.decrypter(this.f1606b, getString(str));
        } catch (Exception e) {
            HMSLog.m2118e(f1605c, "getSecureData" + e.getMessage());
            return "";
        }
    }

    /* renamed from: b */
    public boolean m1870b(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return m1868a("token_info_v2", str2);
            }
            return m1868a(str, str2);
        } catch (Exception e) {
            HMSLog.m2118e(f1605c, "saveSecureData" + e.getMessage());
            return false;
        }
    }

    /* renamed from: a */
    public boolean m1868a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return saveString(str, PushEncrypter.encrypter(this.f1606b, str2));
        } catch (Exception e) {
            HMSLog.m2118e(f1605c, "saveSecureData" + e.getMessage());
            return false;
        }
    }

    /* renamed from: a */
    public void m1867a() {
        Map<String, ?> all = getAll();
        if (all.isEmpty() || all.keySet().isEmpty()) {
            return;
        }
        for (String str : all.keySet()) {
            if (!"push_kit_auto_init_enabled".equals(str) && !"_proxy_init".equals(str)) {
                removeKey(str);
            }
        }
    }
}
