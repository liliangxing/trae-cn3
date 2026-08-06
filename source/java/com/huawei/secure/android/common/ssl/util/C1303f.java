package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.content.pm.PackageManager;
import com.lynx.tasm.LynxError;

/* renamed from: com.huawei.secure.android.common.ssl.util.f */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1303f {

    /* renamed from: a */
    private static final String f2209a = "f";

    /* renamed from: a */
    public static String m2411a(String str) {
        Context contextUtil = ContextUtil.getInstance();
        if (contextUtil == null) {
            return "";
        }
        try {
            return contextUtil.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            C1302e.m2407b(f2209a, "getVersion NameNotFoundException : " + e.getMessage());
            return "";
        } catch (Exception e2) {
            C1302e.m2407b(f2209a, "getVersion: " + e2.getMessage());
            return "";
        } catch (Throwable unused) {
            C1302e.m2407b(f2209a, LynxError.LYNX_THROWABLE);
            return "";
        }
    }

    /* renamed from: b */
    public static int m2412b(String str) {
        Context contextUtil = ContextUtil.getInstance();
        if (contextUtil == null) {
            return 0;
        }
        try {
            return contextUtil.getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            C1302e.m2407b(f2209a, "getVersion NameNotFoundException");
            return 0;
        } catch (Exception e) {
            C1302e.m2407b(f2209a, "getVersion: " + e.getMessage());
            return 0;
        }
    }
}
