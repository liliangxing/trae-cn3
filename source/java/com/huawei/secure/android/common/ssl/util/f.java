package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.content.pm.PackageManager;
import com.lynx.tasm.LynxError;

/* loaded from: classes6.dex */
public class f {
    private static final String a = "f";

    public static String a(String str) {
        Context contextUtil = ContextUtil.getInstance();
        if (contextUtil == null) {
            return "";
        }
        try {
            return contextUtil.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.b(a, "getVersion NameNotFoundException : " + e.getMessage());
            return "";
        } catch (Exception e2) {
            e.b(a, "getVersion: " + e2.getMessage());
            return "";
        } catch (Throwable unused) {
            e.b(a, LynxError.LYNX_THROWABLE);
            return "";
        }
    }

    public static int b(String str) {
        Context contextUtil = ContextUtil.getInstance();
        if (contextUtil == null) {
            return 0;
        }
        try {
            return contextUtil.getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            e.b(a, "getVersion NameNotFoundException");
            return 0;
        } catch (Exception e) {
            e.b(a, "getVersion: " + e.getMessage());
            return 0;
        }
    }
}
