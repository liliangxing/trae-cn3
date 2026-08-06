package ms.bd.p001c;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import androidx.core.content.ContextCompat;
import com.bytedance.mobsec.metasec.ml.MSConfig;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import kotlin.io.encoding.Base64;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;
import net.openid.appauth.BuildConfig;
import okio.Utf8;
import org.bouncycastle.math.ec.Tnaf;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: ms.bd.c.g2 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public abstract class AbstractC0140g2 {

    /* renamed from: a */
    public static final C0142g4 f177a = new C0142g4();

    /* renamed from: b */
    public static final C0170l2 f178b = new C0170l2();

    /* renamed from: c */
    public static JSONArray f179c = null;

    /* renamed from: a */
    public static String m102a() {
        List list;
        List<AccessibilityServiceInfo> list2;
        Method declaredMethod;
        Context context = C0122d2.f158b.f159a;
        JSONArray jSONArray = new JSONArray();
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService((String) AbstractC0190p2.m166a(16777217, 0, 0L, "dde69a", new byte[]{116, 101, 21, 71, 21, 101, 110, 71, Base64.padSymbol, 106, 124, 114, 15}));
        if (accessibilityManager != null) {
            try {
                list = null;
                try {
                    declaredMethod = accessibilityManager.getClass().getDeclaredMethod((String) AbstractC0190p2.m166a(16777217, 0, 0L, "26862b", new byte[]{36, 49, 95, 107, 3, 102, 37, 22, 101, 106, 38, 48, 106, 65, 14, 112, 34, 4, 96, 100, 42, 56, 66, 86, 20, 70, 52, 5, Byte.MAX_VALUE, 111, 32, 49, 103, 75, 30, 97}), null);
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                list = null;
            }
            if (declaredMethod != null) {
                list2 = (List) declaredMethod.invoke(accessibilityManager, null);
                if (list2 != null || list2.size() == 0) {
                    return jSONArray.toString();
                }
                for (AccessibilityServiceInfo accessibilityServiceInfo : list2) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put((String) AbstractC0190p2.m166a(16777217, 0, 0L, "d022fa", new byte[]{112, 36}), accessibilityServiceInfo.eventTypes);
                        jSONObject.put((String) AbstractC0190p2.m166a(16777217, 0, 0L, "d6e298", new byte[]{124, 48}), accessibilityServiceInfo.getId());
                        jSONArray.put(jSONObject);
                    } catch (Throwable unused3) {
                    }
                }
            }
            list2 = list;
            if (list2 != null) {
            }
            return jSONArray.toString();
        }
        return jSONArray.toString();
    }

    /* renamed from: b */
    public static String m104b() {
        File file = new File(C0122d2.f158b.f159a.getFilesDir(), (String) AbstractC0190p2.m166a(16777217, 0, 0L, "b63976", new byte[]{Base64.padSymbol, 57, 83, 73, 9, 53, 96}));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    /* renamed from: c */
    public static String m105c() {
        Context context = C0122d2.f158b.f159a;
        int i = AbstractC0177n.f246a;
        try {
            if (TextUtils.isEmpty(AbstractC0177n.f247b)) {
                AbstractC0177n.f247b = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString((String) AbstractC0190p2.m166a(16777217, 0, 0L, "898c82", new byte[]{26, 8, 116, 33, 34, 23, 8, 49, 70, 29, 22, 21, 106, 58, 34}));
            }
        } catch (Throwable unused) {
        }
        return AbstractC0177n.f247b;
    }

    /* renamed from: d */
    public static Integer m106d() {
        Context context = C0122d2.f158b.f159a;
        if (AbstractC0177n.f246a <= 0) {
            try {
                AbstractC0177n.f246a = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (Throwable unused) {
            }
        }
        return Integer.valueOf(AbstractC0177n.f246a);
    }

    /* renamed from: e */
    public static String m107e() {
        Context context = C0122d2.f158b.f159a;
        int i = AbstractC0177n.f246a;
        try {
            if (TextUtils.isEmpty(AbstractC0177n.f247b)) {
                AbstractC0177n.f247b = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            }
        } catch (Throwable unused) {
        }
        return AbstractC0177n.f247b;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00c8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Integer m108f() {
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        Context context = C0122d2.f158b.f159a;
        String str = AbstractC0182o.f276a;
        int i = 3;
        int i2 = 255;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            StringBuilder append = new StringBuilder().append(context.getFilesDir().getAbsolutePath()).append((String) AbstractC0190p2.m166a(16777217, 0, 0L, "a7e43b", new byte[]{Utf8.REPLACEMENT_BYTE}));
            String str2 = AbstractC0182o.f276a;
            String sb = append.append(str2).toString();
            File file = new File(sb);
            if (file.exists()) {
                try {
                    file.delete();
                    i2 = 2;
                } catch (Throwable unused) {
                    i2 = 2;
                    inputStream = null;
                    try {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable unused2) {
                            }
                        }
                        if (byteArrayOutputStream2 != null) {
                            try {
                                byteArrayOutputStream2.close();
                            } catch (Throwable unused3) {
                            }
                        }
                        i = i2;
                        return Integer.valueOf(i);
                    } finally {
                    }
                }
            }
            inputStream = context.getResources().getAssets().open(str2);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Throwable unused4) {
            }
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = inputStream.read(bArr, 0, 4096);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                FileOutputStream fileOutputStream = new FileOutputStream(sb);
                fileOutputStream.write(byteArrayOutputStream.toByteArray());
                fileOutputStream.close();
                if (byteArrayOutputStream.size() > 0) {
                    i = new File(sb).exists() ? 0 : i2;
                }
                try {
                    inputStream.close();
                } catch (Throwable unused5) {
                }
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable unused6) {
                }
            } catch (Throwable unused7) {
                byteArrayOutputStream2 = byteArrayOutputStream;
                if (inputStream != null) {
                }
                if (byteArrayOutputStream2 != null) {
                }
                i = i2;
                return Integer.valueOf(i);
            }
        } catch (Throwable unused8) {
        }
        return Integer.valueOf(i);
    }

    /* renamed from: g */
    public static String m109g() {
        double d;
        Context context = C0122d2.f158b.f159a;
        try {
            Class<?> cls = Class.forName(new String(AbstractC0103a1.m69a((String) AbstractC0190p2.m166a(16777217, 0, 0L, "14b551", new byte[]{118, 101, 71, 71, 92, 34, 96, Tnaf.POW_2_WIDTH, 101, 52, 118, 51, 71, 21, 93, 116, 100, 19, 101, 60, 118, 98, 67, 68, 92, Byte.MAX_VALUE, 100, Tnaf.POW_2_WIDTH, 100, 49, 118, 99, 70, 19, 92, 35, 100, 68, 101, 102, 114, 51, 71, 71, 93, 117, 96, Tnaf.POW_2_WIDTH, 102, 53, 118, 48, 70, 22, 92, 115, 101, 71, 102, 53, 119, 100, 71, 71, 92, 112, 100, 76, 101, 102, 118, 99}))));
            Object newInstance = cls.getConstructor(Context.class).newInstance(context);
            Method declaredMethod = cls.getDeclaredMethod(new String(AbstractC0103a1.m69a((String) AbstractC0190p2.m166a(16777217, 0, 0L, "fa60bf", new byte[]{33, 52, 19, 17, 10, 37, 49, 17, 48, 54, 33, 54, 18, 22, 11, 32, 51, 23, 49, 53, 34, 51, 19, 66, 10, 38, 51, 21, 48, 50}))), String.class);
            declaredMethod.setAccessible(true);
            d = ((Double) declaredMethod.invoke(newInstance, new String(AbstractC0103a1.m69a((String) AbstractC0190p2.m166a(16777217, 0, 0L, "015f7a", new byte[]{119, 97, Tnaf.POW_2_WIDTH, 67, 95, 34, 100, 68, 50, 99, 118, 97, 17, 75, 90, 115, 101, 67, 50, 103, 118, 99, Tnaf.POW_2_WIDTH, 67, 94, 37, 101, 73, 51, 98, 118, 106}))))).doubleValue();
        } catch (Throwable unused) {
            d = 0.0d;
        }
        return Integer.toString((int) d);
    }

    /* renamed from: h */
    public static Object m110h() {
        int[] iArr;
        C0176m3 m145a = C0176m3.m145a(C0122d2.f158b.f159a);
        synchronized (m145a) {
            int size = m145a.f245b.size();
            if (size > 0) {
                if (size == 1) {
                    iArr = new int[]{((Integer) m145a.f245b.get(0)).intValue()};
                } else {
                    try {
                        ArrayList arrayList = m145a.f245b;
                        int i = size - 10;
                        if (i <= 0) {
                            i = 0;
                        }
                        List subList = arrayList.subList(i, size);
                        iArr = new int[subList.size()];
                        for (int i2 = 0; i2 < subList.size(); i2++) {
                            iArr[i2] = ((Integer) subList.get(i2)).intValue();
                        }
                    } catch (Throwable unused) {
                    }
                }
                return iArr;
            }
            return new int[0];
        }
    }

    /* renamed from: i */
    public static Integer m111i() {
        Intent m99xa7471fe9 = m99xa7471fe9(C0176m3.m145a(C0122d2.f158b.f159a).f244a, null, new IntentFilter((String) AbstractC0190p2.m166a(16777217, 0, 0L, "45f37d", new byte[]{36, 57, 17, 85, 7, 122, 51, 90, 62, 109, 49, 50, 27, 83, 70, 114, 52, 0, 62, 108, 43, 121, 55, 102, 60, 71, 18, 38, 14, 92, 6, 31, 52, 105, 47, 86, 19})));
        int i = -1;
        if (m99xa7471fe9 != null) {
            int intExtra = m99xa7471fe9.getIntExtra((String) AbstractC0190p2.m166a(16777217, 0, 0L, "741643", new byte[]{53, 34, 67, 86, 30, 55}), -1);
            i = (intExtra == 2 || intExtra == 5) ? 1 : 0;
        }
        return Integer.valueOf(i);
    }

    /* renamed from: j */
    public static String m112j() {
        int i;
        C0176m3 m145a = C0176m3.m145a(C0122d2.f158b.f159a);
        m145a.getClass();
        try {
            synchronized (m145a) {
                i = m145a.m146a();
            }
        } catch (Exception unused) {
            i = -1;
        }
        return BuildConfig.FLAVOR + i;
    }

    /* renamed from: k */
    public static String m113k() {
        String str;
        String str2;
        String str3;
        String sb;
        Context context = C0122d2.f158b.f159a;
        synchronized (AbstractC0208t0.class) {
            String str4 = AbstractC0208t0.f397a;
            try {
                StringBuilder append = new StringBuilder().append(context.getFilesDir().getAbsolutePath()).append((String) AbstractC0190p2.m166a(16777217, 0, 0L, "d52bf0", new byte[]{58}));
                str3 = AbstractC0208t0.f397a;
                sb = append.append(str3).toString();
            } catch (Throwable unused) {
                str = (String) AbstractC0190p2.m166a(16777217, 0, 0L, "d69a8e", new byte[]{37, 15, 22, 84, 89, 79, 66, 47, 75, 20, 69, 0, 99, 58, 41, 73, 59, 86, 54, 12});
            }
            if (!new File(sb).exists() || (str2 = AbstractC0208t0.m192a(sb)) == null || str2.length() <= 0) {
                InputStream open = context.getResources().getAssets().open(str3);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                int i = 4096;
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = open.read(bArr, 0, i);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                    i = 4096;
                }
                FileOutputStream fileOutputStream = new FileOutputStream(sb);
                fileOutputStream.write(byteArrayOutputStream.toByteArray());
                fileOutputStream.close();
                AbstractC0208t0.m192a(((String) AbstractC0190p2.m166a(16777217, 0, 0L, "e0ec6f", new byte[]{119, 58, 27, 24, 13, 49, 49, 70, 99, 115})) + sb);
                str = AbstractC0208t0.m192a(sb);
                if (str == null || str.length() == 0) {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(sb, (String) AbstractC0190p2.m166a(16777217, 0, 0L, "a4abae", new byte[]{98, 33}));
                    randomAccessFile.seek(16L);
                    randomAccessFile.write(new byte[]{2});
                    randomAccessFile.close();
                    str = AbstractC0208t0.m192a(sb);
                }
                if (str != null) {
                    if (str.length() == 0) {
                    }
                    str2 = str;
                }
                str = (String) AbstractC0190p2.m166a(16777217, 0, 0L, "8f2f50", new byte[]{121, 95, 29, 83, 84, 26, 30, 117, 81, 25, 27, 95, 29, 83, 84, 26});
                str2 = str;
            }
        }
        return str2;
    }

    /* renamed from: l */
    public static void m114l() {
        int i;
        int m147b;
        int m146a;
        C0176m3 m145a = C0176m3.m145a(C0122d2.f158b.f159a);
        m145a.getClass();
        try {
            synchronized (m145a) {
                m147b = m145a.m147b();
                m146a = m145a.m146a();
            }
            i = (m147b * 10000) + m146a;
        } catch (Exception unused) {
            i = -10001;
        }
        m145a.f245b.add(Integer.valueOf(i));
        try {
            int size = m145a.f245b.size();
            if (size > 20) {
                ArrayList arrayList = new ArrayList(m145a.f245b.subList(size - 10, size));
                m145a.f245b.clear();
                m145a.f245b = arrayList;
            }
        } catch (Throwable unused2) {
        }
    }

    /* renamed from: m */
    public static String m115m() {
        String str;
        try {
            Locale locale = C0122d2.f158b.f159a.getResources().getConfiguration().locale;
            str = locale.getLanguage() + ((String) AbstractC0190p2.m166a(16777217, 0, 0L, "3e3555", new byte[]{29})) + locale.getCountry();
        } catch (Throwable unused) {
            str = null;
        }
        return AbstractC0112b4.m74a(str);
    }

    /* renamed from: n */
    public static String m116n() {
        JSONArray jSONArray = f179c;
        if (jSONArray != null) {
            return jSONArray.toString();
        }
        try {
            if (AbstractC0177n.m148a() == 1) {
                f179c = new JSONArray();
                DhcpInfo dhcpInfo = ((WifiManager) C0122d2.f158b.f159a.getApplicationContext().getSystemService((String) AbstractC0190p2.m166a(16777217, 0, 0L, "8cd439", new byte[]{62, 104, 17, 73}))).getDhcpInfo();
                f179c.put((dhcpInfo.dns1 & 255) + ((String) AbstractC0190p2.m166a(16777217, 0, 0L, "eb9ec3", new byte[]{58})) + ((dhcpInfo.dns1 >> 8) & 255) + ((String) AbstractC0190p2.m166a(16777217, 0, 0L, "67ffac", new byte[]{105})) + ((dhcpInfo.dns1 >> 16) & 255) + ((String) AbstractC0190p2.m166a(16777217, 0, 0L, "071001", new byte[]{111})) + ((dhcpInfo.dns1 >> 24) & 255));
                f179c.put((dhcpInfo.dns2 & 255) + ((String) AbstractC0190p2.m166a(16777217, 0, 0L, "fe7938", new byte[]{57})) + ((dhcpInfo.dns2 >> 8) & 255) + ((String) AbstractC0190p2.m166a(16777217, 0, 0L, "6a566d", new byte[]{105})) + ((dhcpInfo.dns2 >> 16) & 255) + ((String) AbstractC0190p2.m166a(16777217, 0, 0L, "518d63", new byte[]{106})) + ((dhcpInfo.dns2 >> 24) & 255));
            }
        } catch (Throwable unused) {
        }
        JSONArray jSONArray2 = f179c;
        return jSONArray2 != null ? jSONArray2.toString() : new JSONArray().toString();
    }

    /* renamed from: o */
    public static String m117o() {
        String str;
        try {
            Locale locale = C0122d2.f158b.f159a.getResources().getConfiguration().locale;
            str = locale.getLanguage() + ((String) AbstractC0190p2.m166a(16777217, 0, 0L, "86546c", new byte[]{22})) + locale.getCountry();
        } catch (Throwable unused) {
            str = null;
        }
        return AbstractC0112b4.m74a(str);
    }

    /* renamed from: p */
    public static String m118p() {
        String str = BuildConfig.FLAVOR;
        try {
            if (!AbstractC0159j3.f200a && AbstractC0177n.m148a() == 1) {
                AbstractC0159j3.f200a = true;
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                loop0: while (networkInterfaces.hasMoreElements()) {
                    NetworkInterface nextElement = networkInterfaces.nextElement();
                    Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement2 = inetAddresses.nextElement();
                        String name = nextElement.getName();
                        if (!TextUtils.isEmpty(name) && !nextElement2.isLoopbackAddress() && (nextElement2 instanceof Inet4Address) && name.startsWith("rmnet")) {
                            AbstractC0159j3.f201b = nextElement.getName();
                            str = nextElement.getName();
                            break loop0;
                        }
                    }
                }
            }
            if (!TextUtils.isEmpty(AbstractC0159j3.f201b)) {
                str = AbstractC0159j3.f201b;
            }
        } catch (SocketException e) {
            e.toString();
        }
        return str;
    }

    /* renamed from: q */
    public static String m119q() {
        Throwable th;
        C0106a4 m70a = C0106a4.m70a();
        synchronized (m70a) {
            th = m70a.f130b;
        }
        return th != null ? Arrays.toString(th.getStackTrace()) : BuildConfig.FLAVOR;
    }

    /* renamed from: r */
    public static String m120r() {
        C0181n3 m158a = C0181n3.m158a(C0122d2.f158b.f159a);
        synchronized (m158a) {
            StringBuilder sb = new StringBuilder();
            int size = m158a.f275e.size();
            if (size <= 0) {
                return null;
            }
            try {
                ArrayList arrayList = m158a.f275e;
                int i = size - 50;
                if (i <= 0) {
                    i = 0;
                }
                List<JSONArray> subList = arrayList.subList(i, size);
                if (subList.size() > 0) {
                    for (JSONArray jSONArray : subList) {
                        if (jSONArray != null) {
                            sb.append(jSONArray.get(0).toString());
                            sb.append((String) AbstractC0190p2.m166a(16777217, 0, 0L, "9e30b9", new byte[]{100}));
                            sb.append(jSONArray.get(1).toString());
                            sb.append((String) AbstractC0190p2.m166a(16777217, 0, 0L, "167743", new byte[]{108}));
                            sb.append(jSONArray.get(2).toString());
                            sb.append((String) AbstractC0190p2.m166a(16777217, 0, 0L, "ee5c00", new byte[]{104}));
                        }
                    }
                }
                if (sb.length() > 0) {
                    sb.delete(sb.length() - 1, sb.length());
                }
            } catch (Throwable unused) {
            }
            return sb.toString();
        }
    }

    /* renamed from: s */
    public static void m121s() {
        C0181n3 m158a = C0181n3.m158a(C0122d2.f158b.f159a);
        synchronized (m158a) {
            JSONArray m159a = m158a.m159a();
            if (m159a != null) {
                m158a.f275e.add(m159a);
                try {
                    int size = m158a.f275e.size();
                    if (size > 100) {
                        ArrayList arrayList = new ArrayList(m158a.f275e.subList(size - 50, size));
                        m158a.f275e.clear();
                        m158a.f275e = arrayList;
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* renamed from: t */
    public static Boolean m122t() {
        Context context = C0122d2.f158b.f159a;
        if (context != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService((String) AbstractC0190p2.m166a(16777217, 0, 0L, "334ea0", new byte[]{33, 62, 73, 31, 91, 36, 36, 27, 115, 60, 54, 40}));
                Method declaredMethod = connectivityManager.getClass().getDeclaredMethod((String) AbstractC0190p2.m166a(16777217, 0, 0L, "7b9054", new byte[]{33, 101, 94, 101, 9, 55, Base64.padSymbol, 85, 109, 78, 35, 116, 93, 75, 24, 40, 29, 77, 110, 111}), null);
                declaredMethod.setAccessible(true);
                NetworkInfo networkInfo = (NetworkInfo) declaredMethod.invoke(connectivityManager, null);
                if (networkInfo != null) {
                    Method declaredMethod2 = networkInfo.getClass().getDeclaredMethod((String) AbstractC0190p2.m166a(16777217, 0, 0L, "a98a03", new byte[]{121, 40, 106, 3, 14, 45, 110, 25, 107, Base64.padSymbol, 117}), null);
                    declaredMethod2.setAccessible(true);
                    Boolean bool = (Boolean) declaredMethod2.invoke(networkInfo, null);
                    bool.getClass();
                    return bool;
                }
            } catch (Throwable unused) {
            }
        }
        return Boolean.FALSE;
    }

    /* renamed from: a */
    public static Object m101a(String str) {
        Context context = C0122d2.f158b.f159a;
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        if (str == null || str.isEmpty()) {
            str = packageName;
        }
        Signature[] signatureArr = packageManager.getPackageInfo(str, 64).signatures;
        if (signatureArr == null || signatureArr.length <= 0) {
            return null;
        }
        return signatureArr[0].toByteArray();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x002f. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:274:0x084a A[Catch: Exception -> 0x088a, TryCatch #5 {Exception -> 0x088a, blocks: (B:258:0x0812, B:260:0x0816, B:261:0x081d, B:263:0x0827, B:265:0x082f, B:269:0x083e, B:271:0x0842, B:274:0x084a, B:275:0x084f, B:278:0x0884, B:280:0x083a), top: B:257:0x0812 }] */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0880  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0884 A[Catch: Exception -> 0x088a, TRY_LEAVE, TryCatch #5 {Exception -> 0x088a, blocks: (B:258:0x0812, B:260:0x0816, B:261:0x081d, B:263:0x0827, B:265:0x082f, B:269:0x083e, B:271:0x0842, B:274:0x084a, B:275:0x084f, B:278:0x0884, B:280:0x083a), top: B:257:0x0812 }] */
    /* JADX WARN: Removed duplicated region for block: B:287:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x021c A[Catch: all -> 0x023c, TryCatch #11 {all -> 0x023c, blocks: (B:283:0x01f1, B:288:0x0205, B:289:0x0238, B:291:0x021c), top: B:282:0x01f1 }] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v42, types: [java.util.ArrayList] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object m100a(int i, int i2, long j, String str, Object obj) {
        Object m104b;
        ?? r1;
        boolean isComplianceScene;
        JSONObject m185a;
        JSONObject jSONObject;
        Object obj2;
        Throwable th;
        Object m166a;
        Method method;
        C0229x1 c0229x1;
        Object obj3;
        Bundle bundle;
        int i3;
        if (i == 16777228) {
            m104b = m104b();
        } else if (i == 33554433) {
            f177a.m98b(j);
            m104b = Boolean.TRUE;
        } else if (i != 33554434) {
            boolean z = false;
            int i4 = 0;
            switch (i) {
                case 16777217:
                    Context context = C0122d2.f158b.f159a;
                    ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
                    r1 = applicationInfo.sourceDir;
                    if (r1 == 0) {
                        m104b = applicationInfo.publicSourceDir;
                        break;
                    }
                    break;
                case 16777218:
                    m104b = m101a(str);
                    break;
                case 16777219:
                    m104b = m102a();
                    break;
                default:
                    switch (i) {
                        case 16777221:
                            m104b = AbstractC0132f0.m96a(C0122d2.f158b.f159a);
                            break;
                        case 16777222:
                            m104b = m109g();
                            break;
                        case 16777223:
                            m104b = m108f();
                            break;
                        case 16777224:
                            m104b = m113k();
                            break;
                        case 16777225:
                            m104b = AbstractC0102a0.m68a();
                            break;
                        case 16777226:
                            m104b = m117o();
                            break;
                        default:
                            switch (i) {
                                case 16777232:
                                    m104b = m106d();
                                    break;
                                case 16777233:
                                    m104b = m107e();
                                    break;
                                case 16777234:
                                    m104b = m105c();
                                    break;
                                case 16777235:
                                    m104b = m120r();
                                    break;
                                default:
                                    switch (i) {
                                        case 16777238:
                                            Context context2 = C0122d2.f158b.f159a;
                                            if (context2 != null) {
                                                m104b = context2.getPackageName();
                                                break;
                                            } else {
                                                m104b = BuildConfig.FLAVOR;
                                                break;
                                            }
                                        case 16777239:
                                            m104b = m112j();
                                            break;
                                        case 16777240:
                                            obj2 = null;
                                            m103a(str, (String[]) obj);
                                            m104b = obj2;
                                            break;
                                        case 16777241:
                                            obj2 = null;
                                            m121s();
                                            m104b = obj2;
                                            break;
                                        case 16777242:
                                            m104b = m115m();
                                            break;
                                        case 16777243:
                                            m104b = m118p();
                                            break;
                                        case 16777244:
                                            m104b = m116n();
                                            break;
                                        case 16777245:
                                            m104b = Boolean.FALSE;
                                            TelephonyManager telephonyManager = (TelephonyManager) C0122d2.f158b.f159a.getApplicationContext().getSystemService((String) AbstractC0190p2.m166a(16777217, 0, 0L, "8e4e50", new byte[]{57, 111, 72, 31, 15}));
                                            if (telephonyManager != null && telephonyManager.getSimState() == 5) {
                                                m104b = Boolean.TRUE;
                                                break;
                                            }
                                            break;
                                        case 16777246:
                                            obj2 = null;
                                            m114l();
                                            m104b = obj2;
                                            break;
                                        case 16777247:
                                            m104b = m110h();
                                            break;
                                        case 16777248:
                                            m104b = m111i();
                                            break;
                                        case 16777249:
                                            m104b = Integer.valueOf(C0176m3.m145a(C0122d2.f158b.f159a).m147b());
                                            break;
                                        case 16777250:
                                            m104b = C0122d2.f158b.f159a.getSharedPreferences(str, 0).getString((String) obj, null);
                                            break;
                                        case 16777251:
                                            Context context3 = C0122d2.f158b.f159a;
                                            String[] split = str.split((String) AbstractC0190p2.m166a(16777217, 0, 0L, "59abf3", new byte[]{24, 39}));
                                            String str2 = split[0];
                                            String str3 = split[1];
                                            SharedPreferences.Editor edit = context3.getSharedPreferences(str2, 0).edit();
                                            edit.putString(str3, (String) obj);
                                            edit.commit();
                                            m104b = null;
                                            break;
                                        case 16777252:
                                            m104b = m122t();
                                            break;
                                        case 16777253:
                                            m104b = UUID.randomUUID().toString();
                                            break;
                                        case 16777254:
                                            m104b = m119q();
                                            break;
                                        case 16777255:
                                            C0106a4 m70a = C0106a4.m70a();
                                            synchronized (m70a) {
                                                th = m70a.f130b;
                                            }
                                            if (th != null) {
                                                StackTraceElement[] stackTrace = th.getStackTrace();
                                                if (stackTrace.length >= 4) {
                                                    r1 = new ArrayList();
                                                    int i5 = 1;
                                                    for (int i6 = 4; i5 < i6; i6 = 4) {
                                                        StackTraceElement stackTraceElement = stackTrace[i5];
                                                        if (stackTraceElement != null && !TextUtils.isEmpty(stackTraceElement.getClassName())) {
                                                            Class<?> cls = Class.forName(stackTrace[i5].getClassName());
                                                            C0106a4 m70a2 = C0106a4.m70a();
                                                            String methodName = stackTrace[i5].getMethodName();
                                                            m70a2.getClass();
                                                            ArrayList arrayList = new ArrayList();
                                                            if (!TextUtils.isEmpty(methodName)) {
                                                                for (Method method2 : cls.getDeclaredMethods()) {
                                                                    if (method2 != null && method2.getName().equals(methodName)) {
                                                                        arrayList.add(method2);
                                                                    }
                                                                }
                                                            }
                                                            r1.addAll(arrayList);
                                                        }
                                                        i5++;
                                                    }
                                                    break;
                                                }
                                            }
                                            obj2 = null;
                                            m104b = obj2;
                                            break;
                                        case 16777256:
                                            if (AbstractC0177n.m148a() != 1) {
                                                m166a = AbstractC0190p2.m166a(16777217, 0, 0L, "f20dac", new byte[]{39});
                                            } else {
                                                try {
                                                    AbstractC0123d3.m83a();
                                                } catch (Throwable unused) {
                                                }
                                                if (!TextUtils.isEmpty(null)) {
                                                    throw null;
                                                }
                                                m166a = AbstractC0190p2.m166a(16777217, 0, 0L, "74a71f", new byte[]{118});
                                            }
                                            m104b = (String) m166a;
                                            break;
                                        case 16777257:
                                            try {
                                                method = Class.forName((String) AbstractC0190p2.m166a(16777217, 0, 0L, "04b8e6", new byte[]{34, 57, 28, 2, 88, 56, 39, Tnaf.POW_2_WIDTH, 55, 105, 47, 53, 20, 2, 87, 46, 49, 6, 54, 107, 111, 37, 20, 66, 73, 46, 33, 91, 62, 100, 111, 27, 34, 110})).getMethod((String) AbstractC0190p2.m166a(16777217, 0, 0L, "6ac499", new byte[]{38}), null);
                                            } catch (Throwable unused2) {
                                                break;
                                            }
                                            if (method != null) {
                                                m104b = (Long) method.invoke(null, null);
                                                break;
                                            } else {
                                                obj2 = null;
                                                m104b = obj2;
                                                break;
                                            }
                                        case 16777258:
                                            try {
                                                c0229x1 = AbstractC0224w1.m206a(C0122d2.f158b.f159a, str);
                                            } catch (Throwable th2) {
                                                c0229x1 = new C0229x1(-100, BuildConfig.FLAVOR, BuildConfig.FLAVOR, th2);
                                            }
                                            m104b = c0229x1.m207a();
                                            break;
                                        case 16777259:
                                            try {
                                                if (C0201r3.f371j == null) {
                                                    C0201r3.f371j = new C0201r3();
                                                }
                                                C0201r3 c0201r3 = C0201r3.f371j;
                                                if (c0201r3.f372a <= 0 && c0201r3.f373b <= 0 && c0201r3.f376e <= 0) {
                                                    m185a = null;
                                                    jSONObject = C0221v3.f439e;
                                                    if (jSONObject != null && jSONObject.length() > 0) {
                                                        if (m185a == null) {
                                                            m185a = new JSONObject();
                                                        }
                                                        m185a.put((String) AbstractC0190p2.m166a(16777217, 0, 0L, "c8ef3f", new byte[]{124, 41, 4, 6}), jSONObject);
                                                    }
                                                    if (m185a != null) {
                                                        m104b = BuildConfig.FLAVOR;
                                                        break;
                                                    } else {
                                                        m104b = m185a.toString();
                                                        break;
                                                    }
                                                }
                                                m185a = c0201r3.m185a();
                                                jSONObject = C0221v3.f439e;
                                                if (jSONObject != null) {
                                                    if (m185a == null) {
                                                    }
                                                    m185a.put((String) AbstractC0190p2.m166a(16777217, 0, 0L, "c8ef3f", new byte[]{124, 41, 4, 6}), jSONObject);
                                                }
                                                if (m185a != null) {
                                                }
                                            } catch (Exception unused3) {
                                                m104b = BuildConfig.FLAVOR;
                                                break;
                                            }
                                            break;
                                        case 16777260:
                                            Intent m99xa7471fe9 = m99xa7471fe9(C0176m3.m145a(C0122d2.f158b.f159a).f244a, null, new IntentFilter((String) AbstractC0190p2.m166a(16777217, 0, 0L, "ce3198", new byte[]{115, 105, 68, 87, 9, 38, 100, 10, 107, 111, 102, 98, 78, 81, 72, 46, 99, 80, 107, 110, 124, 41, 98, 100, 50, 27, 69, 118, 91, 94, 81, 79, 97, 107, 33, 10, 68})));
                                            m104b = Integer.valueOf(m99xa7471fe9 == null ? -1 : m99xa7471fe9.getIntExtra((String) AbstractC0190p2.m166a(16777217, 0, 0L, "40011c", new byte[]{45, 55, 66, 73, 26, 124}), -1));
                                            break;
                                        case 16777261:
                                            try {
                                                ConnectivityManager connectivityManager = (ConnectivityManager) C0122d2.f158b.f159a.getSystemService((String) AbstractC0190p2.m166a(16777217, 0, 0L, "867381", new byte[]{42, 59, 74, 73, 2, 37, 47, 30, 112, 106, Base64.padSymbol, 45}));
                                                m104b = (String) (connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork()).hasTransport(4) ? AbstractC0190p2.m166a(16777217, 0, 0L, "96d27d", new byte[]{121}) : AbstractC0190p2.m166a(16777217, 0, 0L, "83a89f", new byte[]{121}));
                                                break;
                                            } catch (Throwable unused4) {
                                                m104b = (String) AbstractC0190p2.m166a(16777217, 0, 0L, "bd6d21", new byte[]{35});
                                                break;
                                            }
                                        case 16777262:
                                            String[] strArr = {(String) AbstractC0190p2.m166a(16777217, 0, 0L, "abb656", new byte[]{Byte.MAX_VALUE, 112, 1, 77}), (String) AbstractC0190p2.m166a(16777217, 0, 0L, "60288f", new byte[]{42, 59, 84, 69}), (String) AbstractC0190p2.m166a(16777217, 0, 0L, "6ea89b", new byte[]{49, 110, 4, 67}), (String) AbstractC0190p2.m166a(16777217, 0, 0L, "0c0f37", new byte[]{44, 100, 74, 8, 25}), (String) AbstractC0190p2.m166a(16777217, 0, 0L, "5c601e", new byte[]{54, 100, 65, 73, 7}), (String) AbstractC0190p2.m166a(16777217, 0, 0L, "7b0c63", new byte[]{62, 105, 66, 24, 4, 45}), (String) AbstractC0190p2.m166a(16777217, 0, 0L, "341038", new byte[]{42, 35, 67, 83, 9, 38}), (String) AbstractC0190p2.m166a(16777217, 0, 0L, "2592d6", new byte[]{44, 57, 79, 86, 87, 52, 34}), (String) AbstractC0190p2.m166a(16777217, 0, 0L, "ab705b", new byte[]{124, 105, 74, 65, 11, 114, 103}), (String) AbstractC0190p2.m166a(16777217, 0, 0L, "557e58", new byte[]{55, 54, 73, 2, 31, 33, 49}), (String) AbstractC0190p2.m166a(16777217, 0, 0L, "d25251", new byte[]{109, 32, 73, 85, 15, 34}), (String) AbstractC0190p2.m166a(16777217, 0, 0L, "bb8621", new byte[]{Base64.padSymbol, 108, 78, 87, 4, 104}), (String) AbstractC0190p2.m166a(16777217, 0, 0L, "704efd", new byte[]{52, 55, 70, 29, 84, 118}), (String) AbstractC0190p2.m166a(16777217, 0, 0L, "f7cbf7", new byte[]{118, 38, 5, 5}), (String) AbstractC0190p2.m166a(16777217, 0, 0L, "9663b6", new byte[]{42, 56, 68, 68, 86, 50, 50, 22, 117, 104}), (String) AbstractC0190p2.m166a(16777217, 0, 0L, "2387ad", new byte[]{46, 52, 66, 87, 75}), (String) AbstractC0190p2.m166a(16777217, 0, 0L, "67dcae", new byte[]{43, 60, 21, 4, 75}), (String) AbstractC0190p2.m166a(16777217, 0, 0L, "f825b2", new byte[]{120, 42, 77, 84, 78}), (String) AbstractC0190p2.m166a(16777217, 0, 0L, "3b7e41", new byte[]{42, 111, 74, 30, 25})};
                                            HashSet hashSet = new HashSet();
                                            try {
                                                Method declaredMethod = Class.forName((String) AbstractC0190p2.m166a(16777217, 0, 0L, "aa5a6d", new byte[]{113, 109, 66, 7, 6, 122, 102, 14, 107, 34, 62, 80, 67, 7, 31, 122, 97, 69, 73, 48, 126, 98, 65, Tnaf.POW_2_WIDTH, 27})).getDeclaredMethod((String) AbstractC0190p2.m166a(16777217, 0, 0L, "3167c8", new byte[]{46, 58, 86, 87, 111, 42, 34, 6, 110, 100, 39, 32}), null);
                                                declaredMethod.setAccessible(true);
                                                String[] strArr2 = (String[]) declaredMethod.invoke(null, null);
                                                if (strArr2 != null) {
                                                    for (String str4 : strArr2) {
                                                        for (int i7 = 0; i7 < 19; i7++) {
                                                            String str5 = strArr[i7];
                                                            if (str4.toLowerCase().contains(str5)) {
                                                                hashSet.add(str5);
                                                            }
                                                        }
                                                    }
                                                }
                                            } catch (Exception unused5) {
                                            }
                                            m104b = hashSet.toString();
                                            break;
                                        case 16777263:
                                            Object[] objArr = (Object[]) obj;
                                            int i8 = (int) j;
                                            String str6 = (String) objArr[0];
                                            String str7 = (String) objArr[1];
                                            if (i8 != 0) {
                                                if (i8 == 1) {
                                                    Class<?> cls2 = Class.forName(str6);
                                                    Field declaredField = cls2.getDeclaredField(str7);
                                                    if (declaredField.getType() == String.class) {
                                                        declaredField.setAccessible(true);
                                                        obj3 = declaredField.get(cls2);
                                                    }
                                                }
                                                m104b = null;
                                                break;
                                            } else {
                                                Class<?> cls3 = Class.forName(str6);
                                                Method declaredMethod2 = cls3.getDeclaredMethod(str7, null);
                                                obj3 = i2 == 1 ? declaredMethod2.invoke(cls3, C0122d2.f158b.f159a) : declaredMethod2.invoke(cls3, null);
                                            }
                                            m104b = (String) obj3;
                                            break;
                                        case 16777264:
                                            m104b = AbstractC0154i4.m131a(C0122d2.f158b.f159a);
                                            break;
                                        case 16777265:
                                            m104b = BuildConfig.FLAVOR;
                                            break;
                                        case 16777266:
                                            JSONObject jSONObject2 = new JSONObject();
                                            try {
                                                HashMap m190a = AbstractC0207t.m190a();
                                                for (String str8 : m190a.keySet()) {
                                                    jSONObject2.put(str8, m190a.get(str8));
                                                }
                                                m104b = jSONObject2.toString();
                                                break;
                                            } catch (Throwable unused6) {
                                                m104b = (String) AbstractC0190p2.m166a(16777217, 0, 0L, "be7c72", new byte[]{104, 122});
                                                break;
                                            }
                                        case 16777267:
                                            try {
                                                i4 = AbstractC0102a0.m67a(C0122d2.f158b.f159a);
                                            } catch (Throwable unused7) {
                                            }
                                            m104b = Integer.valueOf(i4);
                                            break;
                                        case 16777268:
                                            m104b = AbstractC0223w0.m205a();
                                            break;
                                        case 16777269:
                                            m104b = AbstractC0231x3.m209a();
                                            break;
                                        case 16777270:
                                            try {
                                                MSConfig.Builder.IMsComplianceScene iMsComplianceScene = C0215u2.f409b.f410a;
                                                if (iMsComplianceScene != null) {
                                                    try {
                                                        isComplianceScene = iMsComplianceScene.isComplianceScene(str);
                                                    } catch (Throwable unused8) {
                                                    }
                                                    m104b = (String) (!isComplianceScene ? AbstractC0190p2.m166a(16777217, 0, 0L, "123efb", new byte[]{113}) : AbstractC0190p2.m166a(16777217, 0, 0L, "96d9c5", new byte[]{120}));
                                                    break;
                                                }
                                                isComplianceScene = true;
                                                m104b = (String) (!isComplianceScene ? AbstractC0190p2.m166a(16777217, 0, 0L, "123efb", new byte[]{113}) : AbstractC0190p2.m166a(16777217, 0, 0L, "96d9c5", new byte[]{120}));
                                            } catch (Throwable unused9) {
                                                m104b = (String) AbstractC0190p2.m166a(16777217, 0, 0L, "154fd1", new byte[]{113});
                                                break;
                                            }
                                        case 16777271:
                                            m104b = Boolean.valueOf(AbstractC0187p.m164a(str));
                                            break;
                                        case 16777272:
                                            Context context4 = C0122d2.f158b.f159a;
                                            int i9 = AbstractC0145h1.f182a;
                                            PackageManager packageManager = context4.getPackageManager();
                                            if (packageManager != null) {
                                                Iterator<ResolveInfo> it = packageManager.queryIntentActivities(new Intent((String) AbstractC0190p2.m166a(16777217, 0, 0L, "ea60d8", new byte[]{117, 109, 65, 86, 84, 38, 98, 14, 110, 110, 96, 102, 75, 80, 21, 46, 101, 84, 110, 111, 122, 45, 104, 101, 114, 1}), (Uri) null), 128).iterator();
                                                while (it.hasNext()) {
                                                    ActivityInfo activityInfo = it.next().activityInfo;
                                                    if (activityInfo != null && (bundle = activityInfo.applicationInfo.metaData) != null && bundle.get((String) AbstractC0190p2.m166a(16777217, 0, 0L, "0b3e11", new byte[]{57, 112, 79, 2, 11, 34, 62, 74, 108, 35, 36, 114, 83, 24, 1, 40})) != null) {
                                                        z = true;
                                                        m104b = Boolean.valueOf(z);
                                                        break;
                                                    }
                                                }
                                            }
                                            context4.getPackageName();
                                            m104b = Boolean.valueOf(z);
                                            break;
                                        case 16777273:
                                            Context context5 = C0122d2.f158b.f159a;
                                            int i10 = AbstractC0177n.f246a;
                                            try {
                                                if (AbstractC0177n.f248c == null) {
                                                    AbstractC0177n.f248c = String.valueOf(context5.getPackageManager().getApplicationInfo(context5.getPackageName(), 128).metaData.get((String) AbstractC0190p2.m166a(16777217, 0, 0L, "a3b35b", new byte[]{69, 1, 53, 102, 62, 80, 93, 36, 22, 81, 67, 24, 62, 105, 53, 86, 77, 54, 22})));
                                                }
                                                if (AbstractC0177n.f248c == null) {
                                                    AbstractC0177n.f248c = BuildConfig.FLAVOR;
                                                }
                                            } catch (Throwable unused10) {
                                                AbstractC0177n.f248c = BuildConfig.FLAVOR;
                                            }
                                            m104b = AbstractC0177n.f248c;
                                            break;
                                        case 16777274:
                                            m104b = String.valueOf(AbstractC0180n2.f264a);
                                            break;
                                        case 16777275:
                                            m104b = String.valueOf(AbstractC0180n2.f265b);
                                            break;
                                        case 16777276:
                                            m104b = String.valueOf(AbstractC0180n2.f266c);
                                            break;
                                        default:
                                            obj2 = null;
                                            switch (i) {
                                                case 16777278:
                                                    if (AbstractC0204s1.f392a != null) {
                                                        C0189p1 c0189p1 = AbstractC0204s1.f392a;
                                                        C0219v1 c0219v1 = c0189p1.f304b;
                                                        if (c0219v1 == null || !c0219v1.f433e) {
                                                            if (c0189p1.f306d) {
                                                                m104b = c0189p1.f303a.m180b();
                                                                break;
                                                            } else {
                                                                m104b = BuildConfig.FLAVOR;
                                                                break;
                                                            }
                                                        } else {
                                                            C0214u1 c0214u1 = new C0214u1();
                                                            c0214u1.f404b = -2L;
                                                            m104b = c0214u1.toString();
                                                            break;
                                                        }
                                                    } else {
                                                        m104b = BuildConfig.FLAVOR;
                                                        break;
                                                    }
                                                case 16777279:
                                                    int i11 = (int) j;
                                                    if (i2 == 1000) {
                                                        m104b = C0210t2.f400b.m193a(i11, (String) AbstractC0190p2.m166a(16777217, 0, 0L, "39c0c3", new byte[]{35, 107}), str);
                                                        break;
                                                    } else if (i2 == 1005) {
                                                        m104b = C0210t2.f400b.m193a(i11, (String) AbstractC0190p2.m166a(16777217, 0, 0L, "668b49", new byte[]{38, 101}), str);
                                                        break;
                                                    } else if (i2 == 1006) {
                                                        m104b = C0210t2.f400b.m193a(i11, (String) AbstractC0190p2.m166a(16777217, 0, 0L, "fedcbe", new byte[]{118, 53}), str);
                                                        break;
                                                    } else {
                                                        C0210t2 c0210t2 = C0210t2.f400b;
                                                        m104b = (String) AbstractC0190p2.m166a(16777217, 0, 0L, "38c0aa", new byte[]{114});
                                                        break;
                                                    }
                                                case 16777280:
                                                    if (i2 != 0) {
                                                        if (i2 != 1) {
                                                            if (i2 != 2) {
                                                                if (i2 != 3) {
                                                                    if (i2 != 4) {
                                                                        String[] strArr3 = AbstractC0205s2.f394a;
                                                                        break;
                                                                    } else {
                                                                        m104b = Long.valueOf(((C0203s0) AbstractC0205s2.f396c.get((int) j)).f391d);
                                                                        break;
                                                                    }
                                                                } else {
                                                                    i3 = ((C0203s0) AbstractC0205s2.f396c.get((int) j)).f390c;
                                                                }
                                                            } else {
                                                                i3 = ((C0203s0) AbstractC0205s2.f396c.get((int) j)).f389b;
                                                            }
                                                        } else {
                                                            i3 = ((C0203s0) AbstractC0205s2.f396c.get((int) j)).f388a;
                                                        }
                                                        m104b = Integer.valueOf(i3);
                                                        break;
                                                    } else {
                                                        m104b = Integer.valueOf(AbstractC0205s2.f396c.size());
                                                        break;
                                                    }
                                                default:
                                                    return null;
                                            }
                                            m104b = obj2;
                                            break;
                                    }
                                    break;
                            }
                    }
            }
            m104b = r1;
        } else {
            f178b.m98b(j);
            m104b = Boolean.TRUE;
        }
        return m104b;
    }

    /* renamed from: a */
    public static void m103a(String str, String[] strArr) {
        Context context = C0122d2.f158b.f159a;
        if (context == null || str == null || strArr == null || strArr.length % 2 != 0) {
            return;
        }
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        for (int i = 0; i < strArr.length; i += 2) {
            intent.putExtra(strArr[i], strArr[i + 1]);
        }
        context.sendBroadcast(intent);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    /* renamed from: INVOKEVIRTUAL_ms_bd_c_g2_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m99xa7471fe9(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        }
        try {
            if (ReceiverRegisterCrashOptimizer.doRegisterHandler()) {
                ReceiverRegisterLancet.initHandler();
                Context context2 = context;
                return context.registerReceiver(broadcastReceiver, intentFilter, null, ReceiverRegisterLancet.sReceiverHandler);
            }
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null && ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(intentFilter)) {
                ReceiverRegisterLancet.initProxyHandler();
                Context context3 = context;
                return ContextCompat.registerReceiver(context, broadcastReceiver, intentFilter, (String) null, ReceiverRegisterLancet.sProxyHandler, 2);
            }
            return context.registerReceiver(broadcastReceiver, intentFilter);
        } catch (Exception e) {
            if (!ReceiverRegisterCrashOptimizer.fixedOpen()) {
                throw e;
            }
            return ReceiverRegisterCrashOptimizer.registerReceiver(broadcastReceiver, intentFilter);
        }
    }
}
