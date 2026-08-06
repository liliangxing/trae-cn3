package cn.com.chinatelecom.account.api.p010e;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import coil3.disk.DiskLruCache;
import com.bytedance.framwork.core.sdklib.apm6.downgrade.DowngradeInfo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.UUID;
import java.util.regex.Pattern;

/* renamed from: cn.com.chinatelecom.account.api.e.d */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0697d {

    /* renamed from: a */
    private static final String f258a = "cn.com.chinatelecom.account.api.e.d";

    /* renamed from: b */
    private static String f259b = "";

    /* renamed from: c */
    private static final Pattern f260c = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");

    /* renamed from: d */
    private static String f261d = "";

    /* renamed from: a */
    public static String m296a() {
        String uuid = UUID.randomUUID().toString();
        try {
            uuid = UUID.nameUUIDFromBytes((uuid + System.currentTimeMillis() + Math.random()).getBytes("utf8")).toString();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return !TextUtils.isEmpty(uuid) ? uuid.replace("-", "") : uuid;
    }

    /* renamed from: a */
    public static String m297a(Context context) {
        if (TextUtils.isEmpty(f261d)) {
            String m310e = m310e(context);
            f261d = m310e;
            if (TextUtils.isEmpty(m310e)) {
                String m311f = m311f(context);
                f261d = m311f;
                m298a(context, m311f);
            }
        }
        return f261d;
    }

    /* renamed from: a */
    private static void m298a(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return;
        }
        C0696c.m290a(context, "key_d_i_u", str);
    }

    /* renamed from: a */
    public static boolean m299a(Object obj, String str) {
        Method declaredMethod = obj.getClass().getDeclaredMethod(str, new Class[0]);
        declaredMethod.setAccessible(true);
        return ((Boolean) declaredMethod.invoke(obj, new Object[0])).booleanValue();
    }

    /* renamed from: a */
    public static boolean m300a(String str) {
        return str != null && f260c.matcher(str).matches();
    }

    /* renamed from: b */
    private static String m301b(Context context, String str) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass(C0705l.m372a(new byte[]{13, 2, 8, 30, 3, 5, 8, 66, 3, 31, 66, 28, 30, 3, 28, 9, 30, 24, 5, 9, 31}));
            return (String) loadClass.getMethod("get", String.class).invoke(loadClass, str);
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: b */
    private static String m302b(String str) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] bytes = str.getBytes();
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bytes);
            byte[] digest = messageDigest.digest();
            char[] cArr2 = new char[digest.length * 2];
            int i = 0;
            for (byte b : digest) {
                int i2 = i + 1;
                cArr2[i] = cArr[(b >>> 4) & 15];
                i = i2 + 1;
                cArr2[i2] = cArr[b & 15];
            }
            return new String(cArr2);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: b */
    public static StringBuffer m303b() {
        StringBuffer stringBuffer = new StringBuffer();
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        while (networkInterfaces.hasMoreElements()) {
            NetworkInterface nextElement = networkInterfaces.nextElement();
            String name = nextElement.getName();
            if (name == null || (!name.contains("wlan") && !name.equals("eth0"))) {
                Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement2 = inetAddresses.nextElement();
                    if (!nextElement2.isLoopbackAddress() && !nextElement2.isLinkLocalAddress()) {
                        String hostAddress = nextElement2.getHostAddress();
                        if (!TextUtils.isEmpty(hostAddress)) {
                            if (stringBuffer.length() > 0) {
                                stringBuffer.append(",");
                            }
                            stringBuffer.append(hostAddress);
                        }
                    }
                }
            }
        }
        return stringBuffer;
    }

    /* renamed from: b */
    public static boolean m304b(Context context) {
        String m372a = C0705l.m372a(new byte[]{4, 24, 24, 28, 66, 28, 30, 3, 20, 21, 36, 3, 31, 24});
        String m372a2 = C0705l.m372a(new byte[]{4, 24, 24, 28, 66, 28, 30, 3, 20, 21, 60, 3, 30, 24});
        String property = System.getProperty(m372a);
        String property2 = System.getProperty(m372a2);
        if (property2 == null) {
            property2 = "-1";
        }
        return (TextUtils.isEmpty(property) || Integer.parseInt(property2) == -1) ? false : true;
    }

    /* renamed from: c */
    public static boolean m305c() {
        String m372a = C0705l.m372a(new byte[]{67, 31, 21, 31, 24, 9, 1, 67, 14, 5, 2, 67, 31, 25});
        String m372a2 = C0705l.m372a(new byte[]{67, 31, 21, 31, 24, 9, 1, 67, 20, 14, 5, 2, 67, 31, 25});
        if (new File(m372a).exists() && m307c(m372a)) {
            return true;
        }
        return new File(m372a2).exists() && m307c(m372a2);
    }

    /* renamed from: c */
    public static boolean m306c(Context context) {
        return m312g(context) || m313h(context) || m314i(context);
    }

    /* renamed from: c */
    private static boolean m307c(String str) {
        Process process = null;
        try {
            process = Runtime.getRuntime().exec("ls -l " + str);
            String readLine = new BufferedReader(new InputStreamReader(process.getInputStream())).readLine();
            if (readLine != null && readLine.length() >= 4) {
                char charAt = readLine.charAt(3);
                if (charAt == 's' || charAt == 'x') {
                }
            }
            if (process == null) {
                return false;
            }
            process.destroy();
            return false;
        } finally {
            if (process != null) {
                process.destroy();
            }
        }
    }

    /* renamed from: d */
    public static boolean m308d() {
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        if (networkInterfaces == null) {
            return false;
        }
        while (networkInterfaces.hasMoreElements()) {
            NetworkInterface nextElement = networkInterfaces.nextElement();
            if (nextElement.isUp() && !nextElement.getInterfaceAddresses().isEmpty()) {
                String m372a = C0705l.m372a(new byte[]{24, 25, 2, 92});
                String m372a2 = C0705l.m372a(new byte[]{28, 28, 28, 92});
                if (m372a.equals(nextElement.getName()) || m372a2.equals(nextElement.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x01dc, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x01dd, code lost:
    
        r0.printStackTrace();
     */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean m309d(Context context) {
        Throwable th;
        BufferedReader bufferedReader;
        FileReader fileReader;
        String readLine;
        try {
            String m372a = C0705l.m372a(new byte[]{11, 3, 0, 8, 10, 5, 31, 4});
            String m372a2 = C0705l.m372a(new byte[]{30, 3, 66, 4, 13, 30, 8, 27, 13, 30, 9});
            String m372a3 = C0705l.m372a(new byte[]{30, 3, 66, 7, 9, 30, 2, 9, 0, 66, 29, 9, 1, 25});
            String m372a4 = C0705l.m372a(new byte[]{11, 9, 2, 9, 30, 5, 15});
            String m372a5 = C0705l.m372a(new byte[]{30, 3, 66, 28, 30, 3, 8, 25, 15, 24, 66, 8, 9, 26, 5, 15, 9});
            if (m372a.equals(m301b(context, m372a2)) || DiskLruCache.VERSION.equals(m301b(context, m372a3)) || m372a4.equals(m301b(context, m372a5))) {
                return true;
            }
            String str = Build.BRAND;
            String str2 = Build.DEVICE;
            String str3 = Build.HARDWARE;
            String str4 = Build.MODEL;
            String str5 = Build.PRODUCT;
            String m372a6 = C0705l.m372a(new byte[]{43, 9, 2, 21, 1, 3, 24, 5, 3, 2});
            String m372a7 = C0705l.m372a(new byte[]{11, 9, 2, 9, 30, 5, 15});
            String m372a8 = C0705l.m372a(new byte[]{31, 8, 7});
            if (!Build.MANUFACTURER.contains(m372a6) && !str2.startsWith(m372a7) && !str4.contains(m372a8) && str.compareTo(m372a7) != 0 && str2.compareTo(m372a7) != 0 && str4.compareTo(m372a8) != 0 && str5.compareTo(m372a8) != 0 && str3.compareTo(m372a) != 0) {
                String m372a9 = C0705l.m372a(new byte[]{67, 28, 30, 3, 15, 67, 15, 28, 25, 5, 2, 10, 3});
                String m372a10 = C0705l.m372a(new byte[]{43, 3, 0, 8, 10, 5, 31, 4});
                FileReader fileReader2 = new FileReader(m372a9);
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
                    do {
                        try {
                            readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                try {
                                    fileReader2.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                                return false;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            fileReader = fileReader2;
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            if (fileReader == null) {
                                throw th;
                            }
                            try {
                                fileReader.close();
                                throw th;
                            } catch (IOException e4) {
                                e4.printStackTrace();
                                throw th;
                            }
                        }
                    } while (!readLine.contains(m372a10));
                    bufferedReader2.close();
                    try {
                        fileReader2.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                    return true;
                } catch (Throwable th3) {
                    th = th3;
                    fileReader = fileReader2;
                    bufferedReader = null;
                }
            }
            return true;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            fileReader = null;
        }
    }

    /* renamed from: e */
    private static String m310e(Context context) {
        return C0696c.m295b(context, "key_d_i_u", "");
    }

    /* renamed from: f */
    private static String m311f(Context context) {
        String m302b = m302b(UUID.randomUUID().toString() + DowngradeInfo.SubInfo.FIELD_DEFAULT_RATE);
        return TextUtils.isEmpty(m302b) ? DowngradeInfo.SubInfo.FIELD_DEFAULT_RATE : m302b;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(2:2|3)|(7:5|6|7|(2:9|(1:14)(1:12))|15|(0)|14)|18|6|7|(0)|15|(0)|14) */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0028  */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean m312g(Context context) {
        boolean z;
        boolean z2;
        String m372a = C0705l.m372a(new byte[]{8, 9, 66, 30, 3, 14, 26, 66, 13, 2, 8, 30, 3, 5, 8, 66, 20, 28, 3, 31, 9, 8, 66, 5, 2, 31, 24, 13, 0, 0, 9, 30});
        String m372a2 = C0705l.m372a(new byte[]{15, 3, 1, 66, 31, 13, 25, 30, 5, 7, 66, 31, 25, 14, 31, 24, 30, 13, 24, 9});
        if (context.createPackageContext(m372a, 2) != null) {
            z = true;
            if (context.createPackageContext(m372a2, 2) != null) {
                z2 = true;
                return !z || z2;
            }
            z2 = false;
            if (z) {
            }
        }
        z = false;
        if (context.createPackageContext(m372a2, 2) != null) {
        }
        z2 = false;
        if (z) {
        }
    }

    /* renamed from: h */
    private static boolean m313h(Context context) {
        Throwable th;
        BufferedReader bufferedReader;
        FileReader fileReader;
        try {
            String m372a = C0705l.m372a(new byte[]{67, 28, 30, 3, 15, 67});
            String m372a2 = C0705l.m372a(new byte[]{67, 1, 13, 28, 31});
            String m372a3 = C0705l.m372a(new byte[]{15, 3, 1, 66, 31, 13, 25, 30, 5, 7, 66, 31, 25, 14, 31, 24, 30, 13, 24, 9});
            String m372a4 = C0705l.m372a(new byte[]{52, 28, 3, 31, 9, 8, 46, 30, 5, 8, 11, 9, 66, 6, 13, 30});
            HashSet<String> hashSet = new HashSet();
            fileReader = new FileReader(m372a + Process.myPid() + m372a2);
            try {
                BufferedReader bufferedReader2 = new BufferedReader(fileReader);
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (readLine.endsWith(".so") || readLine.endsWith(".jar")) {
                            hashSet.add(readLine.substring(readLine.lastIndexOf(" ") + 1));
                        }
                    } catch (Throwable th2) {
                        bufferedReader = bufferedReader2;
                        th = th2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        if (fileReader == null) {
                            throw th;
                        }
                        try {
                            fileReader.close();
                            throw th;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            throw th;
                        }
                    }
                }
                for (String str : hashSet) {
                    if (str.contains(m372a3)) {
                        try {
                            bufferedReader2.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        try {
                            fileReader.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                        return true;
                    }
                    if (str.contains(m372a4)) {
                        try {
                            bufferedReader2.close();
                        } catch (Exception e5) {
                            e5.printStackTrace();
                        }
                        try {
                            fileReader.close();
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                        return true;
                    }
                }
                try {
                    bufferedReader2.close();
                } catch (Exception e7) {
                    e7.printStackTrace();
                }
                try {
                    fileReader.close();
                } catch (Exception e8) {
                    e8.printStackTrace();
                }
                return false;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            fileReader = null;
        }
    }

    /* renamed from: i */
    private static boolean m314i(Context context) {
        try {
            throw new Exception("we have exception");
        } catch (Exception e) {
            String m372a = C0705l.m372a(new byte[]{15, 3, 1, 66, 13, 2, 8, 30, 3, 5, 8, 66, 5, 2, 24, 9, 30, 2, 13, 0, 66, 3, 31, 66, 54, 21, 11, 3, 24, 9, 37, 2, 5, 24});
            String m372a2 = C0705l.m372a(new byte[]{8, 9, 66, 30, 3, 14, 26, 66, 13, 2, 8, 30, 3, 5, 8, 66, 20, 28, 3, 31, 9, 8, 66, 52, 28, 3, 31, 9, 8, 46, 30, 5, 8, 11, 9});
            String m372a3 = C0705l.m372a(new byte[]{8, 9, 66, 30, 3, 14, 26, 66, 13, 2, 8, 30, 3, 5, 8, 66, 20, 28, 3, 31, 9, 8, 66, 52, 28, 3, 31, 9, 8, 46, 30, 5, 8, 11, 9});
            String m372a4 = C0705l.m372a(new byte[]{5, 2, 26, 3, 7, 9, 8});
            String m372a5 = C0705l.m372a(new byte[]{1, 13, 5, 2});
            String m372a6 = C0705l.m372a(new byte[]{4, 13, 2, 8, 0, 9, 36, 3, 3, 7, 9, 8, 33, 9, 24, 4, 3, 8});
            String m372a7 = C0705l.m372a(new byte[]{15, 3, 1, 66, 31, 13, 25, 30, 5, 7, 66, 31, 25, 14, 31, 24, 30, 13, 24, 9, 66, 33, 63, 72, 94});
            int i = 0;
            for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                if (stackTraceElement.getClassName().equals(m372a) && (i = i + 1) == 2) {
                    return true;
                }
                if (stackTraceElement.getClassName().equals(m372a7) && stackTraceElement.getMethodName().equals(m372a4)) {
                    return true;
                }
                if (stackTraceElement.getClassName().equals(m372a2) && stackTraceElement.getMethodName().equals(m372a5)) {
                    return true;
                }
                if (stackTraceElement.getClassName().equals(m372a3) && stackTraceElement.getMethodName().equals(m372a6)) {
                    return true;
                }
            }
            return false;
        }
    }
}
