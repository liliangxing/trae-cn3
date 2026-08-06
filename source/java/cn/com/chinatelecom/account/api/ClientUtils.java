package cn.com.chinatelecom.account.api;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import cn.com.chinatelecom.account.api.p006a.C0676b;
import cn.com.chinatelecom.account.api.p010e.C0697d;
import cn.com.chinatelecom.account.api.p010e.C0700g;
import java.security.interfaces.RSAPublicKey;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class ClientUtils {
    private static final String TAG = "ClientUtils";
    public static final int TYPE_SDK_API = 0;
    public static final int TYPE_SDK_BIO = 2;
    public static final int TYPE_SDK_HY = 1;
    private static int sdkType;

    public static String enrdata(String str, String str2) {
        try {
            return C0676b.m184a(str, (RSAPublicKey) C0676b.m185a(str2));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getApiVersion() {
        return "3.0";
    }

    public static String getCurrentNetworkType(Context context) {
        return C0700g.m347f(context);
    }

    public static boolean getHealthy(Context context) {
        try {
            return C0697d.m309d(context);
        } catch (Throwable th) {
            CtAuth.warn(TAG, "getHealthy error ：" + th.getMessage(), th);
            return false;
        }
    }

    public static boolean getMacData() {
        try {
            return C0697d.m305c();
        } catch (Throwable th) {
            CtAuth.warn(TAG, "getMacData error ：" + th.getMessage(), th);
            return false;
        }
    }

    public static String getMobileBrand() {
        return Build.BRAND;
    }

    public static String getModel() {
        return Build.MODEL;
    }

    public static boolean getNetSafe(Context context) {
        try {
            return C0697d.m306c(context);
        } catch (Throwable th) {
            CtAuth.warn(TAG, "getNetSafe error ：" + th.getMessage(), th);
            return false;
        }
    }

    public static String getOnlineType(Context context) {
        return C0700g.m348g(context);
    }

    public static String getOperatorType(Context context) {
        return C0700g.m349h(context);
    }

    public static String getOs() {
        return getMobileBrand() + "-" + getModel() + "-A:" + Build.VERSION.RELEASE;
    }

    public static String getPID() {
        String str = "";
        try {
            String str2 = Thread.currentThread().getId() + "" + Process.myPid();
            if (str2.length() <= 6) {
                return "ctacco";
            }
            str = str2.substring(0, 6);
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static int getSdkType() {
        return sdkType;
    }

    public static String getSdkVersion() {
        int i = sdkType;
        return i == 1 ? "SDK-HY-v3.8.12" : i == 2 ? "SDK-BIOM-v3.8.12" : "SDK-API-v3.8.12";
    }

    public static boolean getTimePass(Context context) {
        try {
            if (!C0697d.m304b(context)) {
                if (!C0697d.m308d()) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            CtAuth.warn(TAG, "getTimePass error ：" + th.getMessage(), th);
            return false;
        }
    }

    public static long getTp() {
        return System.currentTimeMillis();
    }

    public static boolean isJY() {
        return true;
    }

    public static boolean objChange(Object obj, String str) {
        try {
            return C0697d.m299a(obj, str);
        } catch (Throwable th) {
            CtAuth.warn(TAG, "objChange error ：" + th.getMessage(), th);
            return false;
        }
    }

    public static void setSdkType(int i) {
        sdkType = i;
    }

    public static String strBuf() {
        try {
            return C0697d.m303b().toString();
        } catch (Throwable th) {
            CtAuth.warn(TAG, "strBuf error ：" + th.getMessage(), th);
            return "";
        }
    }
}
