package com.unicom.online.account.kernel;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import io.noties.markwon.image.CustomImageSizeResolverDef;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import kotlin.UByte;
import org.bouncycastle.crypto.digests.SM3Digest;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public final class ac {
    private static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static int b = 3;

    public static int a(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        try {
            connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
            aa.b("android version:" + Build.VERSION.SDK_INT);
            activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            if (activeNetworkInfo.getType() == 1) {
                if (a(connectivityManager)) {
                    aa.b("Data and WIFI");
                    return 1;
                }
                aa.b("Only WIFI");
                return 2;
            }
            if (activeNetworkInfo.getType() == 0) {
                aa.b("Only Data");
                String extraInfo = activeNetworkInfo.getExtraInfo();
                if (TextUtils.isEmpty(extraInfo)) {
                    return 0;
                }
                ab.d(extraInfo);
                ab.a(ab.e(extraInfo));
                return 0;
            }
            return -1;
        }
        return -1;
    }

    public static String a() {
        return ab.d();
    }

    public static String a(int i) {
        return aa.a(i);
    }

    public static String a(Context context, String str) {
        try {
            return b(b(context, str));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String a(Context context, String str, String str2) {
        try {
            return a(b(context, str), str2.toLowerCase());
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA256");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer("");
            for (int i = 0; i < digest.length; i++) {
                int i2 = digest[i];
                if (i2 < 0) {
                    i2 += 256;
                }
                if (i2 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i2));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String a(String str, String str2, String str3) {
        return g.a(str, str2, str3);
    }

    private static String a(List<String> list) {
        StringBuffer append;
        JSONObject jSONObject = new JSONObject();
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        if (list.size() == 0) {
            return "{\"privateIp\":\"0.0.0.0\"}";
        }
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            String substring = str.substring(0, 3);
            try {
                byte[] address = InetAddress.getByName(str).getAddress();
                if (str != null && str.length() != 0) {
                    if (address.length == 4) {
                        if (!substring.equals("127") && !substring.equals("192")) {
                            append = stringBuffer.append(str);
                        }
                    } else if (!str.contains(CustomImageSizeResolverDef.UNIT_PERCENT) && !"::1".equals(str)) {
                        append = stringBuffer2.append(str);
                    }
                    append.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                }
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
        if (stringBuffer.length() != 0 && '-' == stringBuffer.charAt(stringBuffer.length() - 1)) {
            StringBuffer deleteCharAt = stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            int min = Math.min(stringBuffer2.length(), 5);
            for (int i2 = 0; i2 < min; i2++) {
                jSONObject.put("privateIp", deleteCharAt);
            }
        }
        if (stringBuffer2.length() != 0 && '-' == stringBuffer2.charAt(stringBuffer2.length() - 1)) {
            StringBuffer deleteCharAt2 = stringBuffer2.deleteCharAt(stringBuffer2.length() - 1);
            int min2 = Math.min(stringBuffer2.length(), 5);
            for (int i3 = 0; i3 < min2; i3++) {
                jSONObject.put("privateIp_v6", deleteCharAt2);
            }
        }
        return jSONObject.toString();
    }

    private static String a(byte[] bArr) {
        String str = "";
        for (int i = 0; i < bArr.length; i++) {
            if (i != 0) {
                str = str + Constants.COLON_SEPARATOR;
            }
            String hexString = Integer.toHexString(bArr[i] & UByte.MAX_VALUE);
            if (hexString.length() == 1) {
                str = str + "0";
            }
            str = str + hexString;
        }
        return str;
    }

    private static String a(byte[] bArr, String str) {
        try {
            return a(MessageDigest.getInstance(str).digest(bArr));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static boolean a(ConnectivityManager connectivityManager) {
        try {
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public static String b() {
        ab.c(g.a());
        return ab.d();
    }

    public static String b(int i) {
        int i2;
        if (2 == i) {
            try {
                return a(h());
            } catch (JSONException unused) {
                return "{\"privateIp\":\"0.0.0.0\"}";
            }
        }
        if (ab.c != null) {
            d dVar = ab.c;
            return d.a();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (true) {
                if (!networkInterfaces.hasMoreElements()) {
                    break;
                }
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if (nextElement.getName().toLowerCase().contains("rmnet")) {
                    Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement2 = inetAddresses.nextElement();
                        if (!nextElement2.isLoopbackAddress() && !nextElement2.isLinkLocalAddress() && !nextElement2.isMulticastAddress() && !nextElement2.isAnyLocalAddress()) {
                            if (nextElement2 instanceof Inet4Address) {
                                hashSet.add(nextElement2.getHostAddress());
                            }
                            if (nextElement2 instanceof Inet6Address) {
                                String hostAddress = nextElement2.getHostAddress();
                                if (hostAddress.contains(CustomImageSizeResolverDef.UNIT_PERCENT)) {
                                    hostAddress = hostAddress.substring(0, hostAddress.indexOf(CustomImageSizeResolverDef.UNIT_PERCENT));
                                }
                                hashSet2.add(hostAddress);
                            }
                        }
                    }
                }
            }
            if (hashSet.size() > 0) {
                Object[] array = hashSet.toArray();
                int min = Math.min(array.length, 5);
                for (int i3 = 0; i3 < min; i3++) {
                    sb.append((String) array[i3]);
                    if (i3 < min - 1) {
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    }
                }
                sb3.append("&private_ip=".concat(String.valueOf(sb)));
                jSONObject.put("privateIp", sb.toString());
            }
            if (hashSet2.size() > 0) {
                Object[] array2 = hashSet2.toArray();
                int min2 = Math.min(array2.length, 5);
                for (i2 = 0; i2 < min2; i2++) {
                    sb2.append((String) array2[i2]);
                    if (i2 < min2 - 1) {
                        sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    }
                }
                sb3.append("&private_ip_v6=".concat(String.valueOf(sb2)));
                jSONObject.put("privateIp_v6", sb2.toString());
            }
            return 1 == i ? sb.length() != 0 ? jSONObject.toString() : "{\"privateIp\":\"0.0.0.0\"}" : sb3.toString();
        } catch (Exception unused2) {
            return "{\"privateIp\":\"0.0.0.0\"}";
        }
    }

    public static String b(Context context) {
        try {
            return (String) context.getPackageManager().getApplicationLabel(context.getPackageManager().getApplicationInfo(context.getPackageName(), 0));
        } catch (Exception unused) {
            return "";
        }
    }

    public static String b(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer("");
            for (int i = 0; i < digest.length; i++) {
                int i2 = digest[i];
                if (i2 < 0) {
                    i2 += 256;
                }
                if (i2 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i2));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String b(String str, String str2, String str3) {
        return g.b(str, str2, str3);
    }

    private static String b(byte[] bArr) {
        try {
            SM3Digest sM3Digest = new SM3Digest();
            sM3Digest.update(bArr, 0, bArr.length);
            byte[] bArr2 = new byte[sM3Digest.getDigestSize()];
            sM3Digest.doFinal(bArr2, 0);
            return a(bArr2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static byte[] b(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            if (packageInfo.packageName.equals(str)) {
                return packageInfo.signatures[0].toByteArray();
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String c(String str) {
        SM3Digest sM3Digest = new SM3Digest();
        byte[] bytes = str.getBytes(Charset.forName("UTF-8"));
        sM3Digest.update(bytes, 0, bytes.length);
        byte[] bArr = new byte[sM3Digest.getDigestSize()];
        sM3Digest.doFinal(bArr, 0);
        return m.a(bArr);
    }

    public static void c() {
        aa.a();
    }

    public static int d() {
        b = 3;
        return 3;
    }

    public static int d(String str) {
        try {
            byte[] address = InetAddress.getByName(str).getAddress();
            return (address[0] & UByte.MAX_VALUE) | ((address[3] & UByte.MAX_VALUE) << 24) | ((address[2] & UByte.MAX_VALUE) << 16) | ((address[1] & UByte.MAX_VALUE) << 8);
        } catch (UnknownHostException unused) {
            return -1;
        }
    }

    public static int e() {
        return b;
    }

    public static void e(String str) {
        aa.a(str);
    }

    public static int f() {
        int i = b;
        if (i <= 0 || i > 10) {
            return 0;
        }
        int i2 = i - 1;
        b = i2;
        return i2;
    }

    public static String g() {
        return b(0);
    }

    private static List<String> h() {
        Enumeration<InetAddress> inetAddresses;
        ArrayList arrayList = new ArrayList();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces != null) {
                while (networkInterfaces.hasMoreElements()) {
                    NetworkInterface nextElement = networkInterfaces.nextElement();
                    if (!nextElement.isVirtual() && nextElement.isUp() && (inetAddresses = nextElement.getInetAddresses()) != null) {
                        while (inetAddresses.hasMoreElements()) {
                            InetAddress nextElement2 = inetAddresses.nextElement();
                            if (!nextElement2.isLoopbackAddress() && !nextElement2.isLinkLocalAddress() && !nextElement2.isMulticastAddress() && !nextElement2.isAnyLocalAddress() && nextElement2 != null && ((nextElement2 instanceof Inet4Address) || (nextElement2 instanceof Inet6Address))) {
                                arrayList.add(nextElement2.getHostAddress());
                            }
                        }
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}
