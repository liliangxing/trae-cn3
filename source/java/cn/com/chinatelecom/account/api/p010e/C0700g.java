package cn.com.chinatelecom.account.api.p010e;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import cn.com.chinatelecom.account.api.CtAuth;
import cn.com.chinatelecom.account.api.p006a.C0678d;
import coil3.disk.DiskLruCache;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import java.lang.reflect.Method;

/* renamed from: cn.com.chinatelecom.account.api.e.g */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0700g {

    /* renamed from: a */
    public static String f290a = null;

    /* renamed from: b */
    public static String f291b = null;

    /* renamed from: c */
    public static String f292c = null;

    /* renamed from: d */
    public static String f293d = "0";

    /* renamed from: e */
    private static final String[] f294e = {"46000", "46002", "46004", "46007", "46008"};

    /* renamed from: f */
    private static final String[] f295f = {"46003", "46005", "46011"};

    /* renamed from: g */
    private static final String[] f296g = {"46001", "46006", "46009"};

    /* renamed from: a */
    private static int m336a(int i) {
        int i2 = -101;
        if (i != -101) {
            i2 = -1;
            if (i != -1) {
                switch (i) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                    case 16:
                        return 1;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                    case 17:
                        return 2;
                    case 13:
                    case 18:
                    case 19:
                        return 3;
                    case 20:
                        return 4;
                    default:
                        return i;
                }
            }
        }
        return i2;
    }

    /* renamed from: a */
    public static NetworkInfo m337a(Context context) {
        if (context == null) {
            return null;
        }
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
    }

    /* renamed from: a */
    public static String m338a() {
        return f290a;
    }

    /* renamed from: a */
    public static String m339a(Context context, boolean z) {
        String m349h = m349h(context);
        if (m349h != null) {
            for (String str : f295f) {
                if (m349h.equals(str)) {
                    return z ? DiskLruCache.VERSION : "CT";
                }
            }
            for (String str2 : f294e) {
                if (m349h.equals(str2)) {
                    return z ? ExifInterface.GPS_MEASUREMENT_2D : "CM";
                }
            }
            for (String str3 : f296g) {
                if (m349h.equals(str3)) {
                    return z ? ExifInterface.GPS_MEASUREMENT_3D : "CU";
                }
            }
        }
        return z ? "0" : "UN";
    }

    /* renamed from: b */
    public static String m340b() {
        return f291b != null ? "https://open.e.189.cn/openapi/special/getTimeStamp.do".replace(C0678d.m189a(C0695b.f256g), f291b) : "https://open.e.189.cn/openapi/special/getTimeStamp.do";
    }

    /* renamed from: b */
    public static boolean m341b(Context context) {
        NetworkInfo m337a = m337a(context);
        return m337a != null && m337a.isAvailable();
    }

    /* renamed from: c */
    public static String m342c() {
        String str = f292c;
        return str != null ? "https://api-e189.21cn.com/gw/client/accountMsg.do".replace("e189.21cn.com", str) : "https://api-e189.21cn.com/gw/client/accountMsg.do";
    }

    /* renamed from: c */
    public static boolean m343c(Context context) {
        NetworkInfo m337a = m337a(context);
        return m337a != null && m337a.getType() == 0;
    }

    /* renamed from: cn_com_chinatelecom_account_api_e_g_android_telephony_TelephonyManager_getSimOperator */
    private static String m344x64ef2e62(TelephonyManager telephonyManager) {
        HeliosApiHook heliosApiHook = new HeliosApiHook();
        Object[] objArr = new Object[0];
        ExtraInfo extraInfo = new ExtraInfo(false, "()Ljava/lang/String;");
        Result preInvoke = heliosApiHook.preInvoke(102021, "android/telephony/TelephonyManager", "getSimOperator", telephonyManager, objArr, "java.lang.String", extraInfo);
        if (preInvoke.isIntercept()) {
            heliosApiHook.postInvoke(102021, "android/telephony/TelephonyManager", "getSimOperator", telephonyManager, objArr, (Object) null, extraInfo, false);
            return (String) preInvoke.getReturnValue();
        }
        String simOperator = telephonyManager.getSimOperator();
        heliosApiHook.postInvoke(102021, "android/telephony/TelephonyManager", "getSimOperator", telephonyManager, objArr, simOperator, extraInfo, true);
        return simOperator;
    }

    /* renamed from: d */
    public static boolean m345d(Context context) {
        if (context == null) {
            return true;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
        } catch (Throwable th) {
            CtAuth.warn("NetUtil", "isMobileEnable error ", th);
            return true;
        }
    }

    /* renamed from: e */
    public static String m346e(Context context) {
        int m351j = m351j(context);
        return m351j != -101 ? (m351j == -1 || m351j == 0) ? "null" : m351j != 1 ? m351j != 2 ? m351j != 3 ? m351j != 4 ? Integer.toString(m351j) : "5G" : "4G" : "3G" : "2G" : "WIFI";
    }

    /* renamed from: f */
    public static String m347f(Context context) {
        String m346e = m346e(context);
        return (m346e != null && m346e.equals("WIFI") && m345d(context)) ? "BOTH" : m346e;
    }

    /* renamed from: g */
    public static String m348g(Context context) {
        String m347f = m347f(context);
        if (!TextUtils.isEmpty(m347f) && !m347f.equals("null")) {
            if (m347f.equals("2G")) {
                return "10";
            }
            if (m347f.equals("3G")) {
                return "11";
            }
            if (m347f.equals("4G")) {
                return "12";
            }
            if (m347f.equals("5G")) {
                return "16";
            }
            if (m347f.equals("WIFI")) {
                return "13";
            }
            if (m347f.equals("BOTH")) {
                return "14";
            }
        }
        return "15";
    }

    /* renamed from: h */
    public static String m349h(Context context) {
        try {
            String m344x64ef2e62 = m344x64ef2e62((TelephonyManager) context.getSystemService("phone"));
            return !TextUtils.isEmpty(m344x64ef2e62) ? m344x64ef2e62 : "00000";
        } catch (Throwable th) {
            th.printStackTrace();
            return "00000";
        }
    }

    /* renamed from: i */
    public static String m350i(Context context) {
        return m339a(context, true);
    }

    /* renamed from: j */
    private static int m351j(Context context) {
        int i = 0;
        try {
            try {
                NetworkInfo m337a = m337a(context);
                if (m337a != null && m337a.isAvailable() && m337a.isConnected()) {
                    int type = m337a.getType();
                    if (type == 1) {
                        i = -101;
                    } else if (type == 0) {
                        try {
                            i = ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (i == 0) {
                            i = m337a.getSubtype();
                        }
                    }
                } else {
                    i = -1;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (NullPointerException e3) {
            e3.printStackTrace();
        }
        return m336a(i);
    }
}
