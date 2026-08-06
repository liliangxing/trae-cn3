package cn.com.chinatelecom.account.api.e;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.librarian.LibrarianImpl;
import com.xiaomi.mipush.sdk.Constants;
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
import okio.Utf8;

/* loaded from: classes2.dex */
public class d {
    private static final String a = "cn.com.chinatelecom.account.api.e.d";
    private static String b = "";
    private static final Pattern c = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
    private static String d = "";

    public static String a() {
        String uuid = UUID.randomUUID().toString();
        try {
            uuid = UUID.nameUUIDFromBytes((uuid + System.currentTimeMillis() + Math.random()).getBytes("utf8")).toString();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return !TextUtils.isEmpty(uuid) ? uuid.replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "") : uuid;
    }

    public static String a(Context context) {
        if (TextUtils.isEmpty(d)) {
            String e = e(context);
            d = e;
            if (TextUtils.isEmpty(e)) {
                String f = f(context);
                d = f;
                a(context, f);
            }
        }
        return d;
    }

    private static void a(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return;
        }
        c.a(context, "key_d_i_u", str);
    }

    public static boolean a(Object obj, String str) {
        Method declaredMethod = obj.getClass().getDeclaredMethod(str, new Class[0]);
        declaredMethod.setAccessible(true);
        return ((Boolean) declaredMethod.invoke(obj, new Object[0])).booleanValue();
    }

    public static boolean a(String str) {
        return str != null && c.matcher(str).matches();
    }

    private static String b(Context context, String str) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass(l.a(new byte[]{13, 2, 8, 30, 3, 5, 8, 66, 3, 31, 66, 28, 30, 3, 28, 9, 30, 24, 5, 9, 31}));
            return (String) loadClass.getMethod("get", String.class).invoke(loadClass, str);
        } catch (Exception unused) {
            return "";
        }
    }

    private static String b(String str) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] bytes = str.getBytes();
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bytes);
            byte[] digest = messageDigest.digest();
            char[] cArr2 = new char[digest.length * 2];
            int i = 0;
            for (byte b2 : digest) {
                int i2 = i + 1;
                cArr2[i] = cArr[(b2 >>> 4) & 15];
                i = i2 + 1;
                cArr2[i2] = cArr[b2 & 15];
            }
            return new String(cArr2);
        } catch (Exception unused) {
            return null;
        }
    }

    public static StringBuffer b() {
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

    public static boolean b(Context context) {
        String a2 = l.a(new byte[]{4, 24, 24, 28, 66, 28, 30, 3, 20, 21, 36, 3, 31, 24});
        String a3 = l.a(new byte[]{4, 24, 24, 28, 66, 28, 30, 3, 20, 21, 60, 3, 30, 24});
        String property = System.getProperty(a2);
        String property2 = System.getProperty(a3);
        if (property2 == null) {
            property2 = "-1";
        }
        return (TextUtils.isEmpty(property) || Integer.parseInt(property2) == -1) ? false : true;
    }

    public static boolean c() {
        String a2 = l.a(new byte[]{67, 31, 21, 31, 24, 9, 1, 67, 14, 5, 2, 67, 31, 25});
        String a3 = l.a(new byte[]{67, 31, 21, 31, 24, 9, 1, 67, 20, 14, 5, 2, 67, 31, 25});
        if (new File(a2).exists() && c(a2)) {
            return true;
        }
        return new File(a3).exists() && c(a3);
    }

    public static boolean c(Context context) {
        return g(context) || h(context) || i(context);
    }

    private static boolean c(String str) {
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

    public static boolean d() {
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        if (networkInterfaces == null) {
            return false;
        }
        while (networkInterfaces.hasMoreElements()) {
            NetworkInterface nextElement = networkInterfaces.nextElement();
            if (nextElement.isUp() && !nextElement.getInterfaceAddresses().isEmpty()) {
                String a2 = l.a(new byte[]{24, 25, 2, 92});
                String a3 = l.a(new byte[]{28, 28, 28, 92});
                if (a2.equals(nextElement.getName()) || a3.equals(nextElement.getName())) {
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean d(Context context) {
        Throwable th;
        BufferedReader bufferedReader;
        FileReader fileReader;
        String readLine;
        try {
            String a2 = l.a(new byte[]{11, 3, 0, 8, 10, 5, 31, 4});
            String a3 = l.a(new byte[]{30, 3, 66, 4, 13, 30, 8, 27, 13, 30, 9});
            String a4 = l.a(new byte[]{30, 3, 66, 7, 9, 30, 2, 9, 0, 66, 29, 9, 1, 25});
            String a5 = l.a(new byte[]{11, 9, 2, 9, 30, 5, 15});
            String a6 = l.a(new byte[]{30, 3, 66, 28, 30, 3, 8, 25, 15, 24, 66, 8, 9, 26, 5, 15, 9});
            if (a2.equals(b(context, a3)) || "1".equals(b(context, a4)) || a5.equals(b(context, a6))) {
                return true;
            }
            String str = Build.BRAND;
            String str2 = Build.DEVICE;
            String str3 = Build.HARDWARE;
            String str4 = Build.MODEL;
            String str5 = Build.PRODUCT;
            String a7 = l.a(new byte[]{43, 9, 2, 21, 1, 3, 24, 5, 3, 2});
            String a8 = l.a(new byte[]{11, 9, 2, 9, 30, 5, 15});
            String a9 = l.a(new byte[]{31, 8, 7});
            if (!Build.MANUFACTURER.contains(a7) && !str2.startsWith(a8) && !str4.contains(a9) && str.compareTo(a8) != 0 && str2.compareTo(a8) != 0 && str4.compareTo(a9) != 0 && str5.compareTo(a9) != 0 && str3.compareTo(a2) != 0) {
                String a10 = l.a(new byte[]{67, 28, 30, 3, 15, 67, 15, 28, 25, 5, 2, 10, 3});
                String a11 = l.a(new byte[]{43, 3, 0, 8, 10, 5, 31, 4});
                FileReader fileReader2 = new FileReader(a10);
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
                    } while (!readLine.contains(a11));
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

    private static String e(Context context) {
        return c.b(context, "key_d_i_u", "");
    }

    private static String f(Context context) {
        String b2 = b(UUID.randomUUID().toString() + "default");
        return TextUtils.isEmpty(b2) ? "default" : b2;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(2:2|3)|(7:5|6|7|(2:9|(1:14)(1:12))|15|(0)|14)|18|6|7|(0)|15|(0)|14) */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean g(Context context) {
        boolean z;
        boolean z2;
        String a2 = l.a(new byte[]{8, 9, 66, 30, 3, 14, 26, 66, 13, 2, 8, 30, 3, 5, 8, 66, 20, 28, 3, 31, 9, 8, 66, 5, 2, 31, 24, 13, 0, 0, 9, 30});
        String a3 = l.a(new byte[]{15, 3, 1, 66, 31, 13, 25, 30, 5, 7, 66, 31, 25, 14, 31, 24, 30, 13, 24, 9});
        if (context.createPackageContext(a2, 2) != null) {
            z = true;
            if (context.createPackageContext(a3, 2) != null) {
                z2 = true;
                return !z || z2;
            }
            z2 = false;
            if (z) {
            }
        }
        z = false;
        if (context.createPackageContext(a3, 2) != null) {
        }
        z2 = false;
        if (z) {
        }
    }

    private static boolean h(Context context) {
        Throwable th;
        BufferedReader bufferedReader;
        FileReader fileReader;
        try {
            String a2 = l.a(new byte[]{67, 28, 30, 3, 15, 67});
            String a3 = l.a(new byte[]{67, 1, 13, 28, 31});
            String a4 = l.a(new byte[]{15, 3, 1, 66, 31, 13, 25, 30, 5, 7, 66, 31, 25, 14, 31, 24, 30, 13, 24, 9});
            String a5 = l.a(new byte[]{52, 28, 3, 31, 9, 8, 46, 30, 5, 8, 11, 9, 66, 6, 13, 30});
            HashSet<String> hashSet = new HashSet();
            fileReader = new FileReader(a2 + Process.myPid() + a3);
            try {
                BufferedReader bufferedReader2 = new BufferedReader(fileReader);
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (readLine.endsWith(LibrarianImpl.Constants.SO_SUFFIX) || readLine.endsWith(".jar")) {
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
                    if (str.contains(a4)) {
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
                    if (str.contains(a5)) {
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

    private static boolean i(Context context) {
        try {
            throw new Exception("we have exception");
        } catch (Exception e) {
            String a2 = l.a(new byte[]{15, 3, 1, 66, 13, 2, 8, 30, 3, 5, 8, 66, 5, 2, 24, 9, 30, 2, 13, 0, 66, 3, 31, 66, 54, 21, 11, 3, 24, 9, 37, 2, 5, 24});
            String a3 = l.a(new byte[]{8, 9, 66, 30, 3, 14, 26, 66, 13, 2, 8, 30, 3, 5, 8, 66, 20, 28, 3, 31, 9, 8, 66, 52, 28, 3, 31, 9, 8, 46, 30, 5, 8, 11, 9});
            String a4 = l.a(new byte[]{8, 9, 66, 30, 3, 14, 26, 66, 13, 2, 8, 30, 3, 5, 8, 66, 20, 28, 3, 31, 9, 8, 66, 52, 28, 3, 31, 9, 8, 46, 30, 5, 8, 11, 9});
            String a5 = l.a(new byte[]{5, 2, 26, 3, 7, 9, 8});
            String a6 = l.a(new byte[]{1, 13, 5, 2});
            String a7 = l.a(new byte[]{4, 13, 2, 8, 0, 9, 36, 3, 3, 7, 9, 8, 33, 9, 24, 4, 3, 8});
            String a8 = l.a(new byte[]{15, 3, 1, 66, 31, 13, 25, 30, 5, 7, 66, 31, 25, 14, 31, 24, 30, 13, 24, 9, 66, 33, Utf8.REPLACEMENT_BYTE, 72, 94});
            int i = 0;
            for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                if (stackTraceElement.getClassName().equals(a2) && (i = i + 1) == 2) {
                    return true;
                }
                if (stackTraceElement.getClassName().equals(a8) && stackTraceElement.getMethodName().equals(a5)) {
                    return true;
                }
                if (stackTraceElement.getClassName().equals(a3) && stackTraceElement.getMethodName().equals(a6)) {
                    return true;
                }
                if (stackTraceElement.getClassName().equals(a4) && stackTraceElement.getMethodName().equals(a7)) {
                    return true;
                }
            }
            return false;
        }
    }
}
