package com.apm.lite.j;

import android.text.TextUtils;
import com.apm.lite.Npth;
import com.apm.lite.k.q;
import com.bytedance.crash.entity.Header;
import com.bytedance.framwork.core.sdkmonitor.MonitorConstants;
import com.huawei.hms.framework.common.ContainerUtils;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.Deflater;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class e {
    public static boolean a;
    private static g b;

    /* loaded from: classes2.dex */
    public enum a {
        NONE(0),
        GZIP(1),
        DEFLATER(2);

        final int d;

        a(int i) {
            this.d = i;
        }
    }

    /* loaded from: classes2.dex */
    public enum b {
        NONE(0),
        MOBILE(1),
        MOBILE_2G(2),
        MOBILE_3G(3),
        WIFI(4),
        MOBILE_4G(5),
        MOBILE_5G(6),
        WIFI_24GHZ(7),
        WIFI_5GHZ(8),
        MOBILE_3G_H(9),
        MOBILE_3G_HP(10);

        final int l;

        b(int i) {
            this.l = i;
        }
    }

    public static k a(long j, String str, byte[] bArr, a aVar, String str2, boolean z) {
        return a(j, str, bArr, aVar, str2, z, false);
    }

    public static k a(long j, String str, byte[] bArr, a aVar, String str2, boolean z, boolean z2) {
        String str3;
        String str4;
        StringBuilder sb;
        if (!Npth.isStopUpload() && str != null) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            int length = bArr.length;
            if (a.GZIP == aVar && length > 128) {
                bArr = b(bArr);
                str3 = "gzip";
            } else if (a.DEFLATER != aVar || length <= 128) {
                str3 = null;
            } else {
                bArr = a(bArr);
                str3 = "deflate";
            }
            String str5 = str3;
            byte[] bArr2 = bArr;
            if (bArr2 == null) {
                return new k(202);
            }
            if (!z) {
                return a(str, bArr2, str2, str5, "POST", true, false, z2);
            }
            byte[] a2 = com.apm.lite.k.g.a(bArr2);
            if (a2 != null) {
                if (TextUtils.isEmpty(new URL(str).getQuery())) {
                    str4 = "?";
                    if (!str.endsWith("?")) {
                        sb = new StringBuilder();
                        str = sb.append(str).append(str4).toString();
                    }
                    str = str + "tt_data=a";
                    str2 = "application/octet-stream;tt-data=a";
                    bArr2 = a2;
                } else {
                    str4 = ContainerUtils.FIELD_DELIMITER;
                    if (!str.endsWith(ContainerUtils.FIELD_DELIMITER)) {
                        sb = new StringBuilder();
                        str = sb.append(str).append(str4).toString();
                    }
                    str = str + "tt_data=a";
                    str2 = "application/octet-stream;tt-data=a";
                    bArr2 = a2;
                }
            }
            return a(str, bArr2, str2, str5, "POST", true, true, z2);
        }
        return new k(201);
    }

    public static k a(String str, String str2, boolean z) {
        return a(str, str2, a(), z);
    }

    public static k a(String str, String str2, boolean z, boolean z2) {
        try {
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                return a(2097152L, str, str2.getBytes(), a.GZIP, "application/json; charset=utf-8", z, z2);
            }
            return new k(201);
        } catch (Throwable th) {
            q.b(th);
            return new k(207, th);
        }
    }

    public static k a(String str, String str2, File... fileArr) {
        return b(str, str2, fileArr);
    }

    private static k a(String str, byte[] bArr, String str2, String str3, String str4, boolean z, boolean z2, boolean z3) {
        return b(str, bArr, str2, str3, str4, z, z2, z3);
    }

    private static String a(String str, String str2) {
        StringBuilder append;
        try {
            if (TextUtils.isEmpty(new URL(str).getQuery())) {
                if (!str.endsWith("?")) {
                    append = new StringBuilder().append(str).append("?");
                    str = append.toString();
                }
                return str + str2;
            }
            if (!str.endsWith(ContainerUtils.FIELD_DELIMITER)) {
                append = new StringBuilder().append(str).append(ContainerUtils.FIELD_DELIMITER);
                str = append.toString();
            }
            return str + str2;
        } catch (Throwable unused) {
            return str;
        }
        return str;
    }

    private static String a(String str, Map map) {
        if (TextUtils.isDigitsOnly(str) || map == null || map.isEmpty()) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        if (!str.contains("?")) {
            sb.append("?");
        }
        try {
            for (Map.Entry entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    if (!sb.toString().endsWith("?")) {
                        sb.append(ContainerUtils.FIELD_DELIMITER);
                    }
                    sb.append(b(entry.getKey().toString(), "UTF-8"));
                    sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb.append(b(entry.getValue().toString(), "UTF-8"));
                }
            }
            return sb.toString();
        } catch (Exception unused) {
            return str;
        }
    }

    public static boolean a() {
        return TextUtils.equals(MonitorConstants.MONITOR_FROM_SDK, "app");
    }

    public static boolean a(String str, String str2, String str3, String str4, List<String> list) {
        if (Npth.isStopUpload()) {
            return false;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("aid", str2);
            String b2 = com.apm.lite.d.b(str2);
            if (!TextUtils.isEmpty(b2)) {
                hashMap.put(Header.KEY_TOKEN, b2);
            }
            i iVar = new i(str, "UTF-8", hashMap, false);
            iVar.a("aid", str2);
            iVar.a("device_id", str3);
            iVar.a("os", "Android");
            iVar.a("process_name", str4);
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                File file = new File(it.next());
                if (file.exists()) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("logtype", CloudControlInf.ALOG);
                    hashMap2.put("scene", "crash");
                    iVar.a(file.getName(), file, hashMap2);
                }
            }
            return new JSONObject(iVar.a()).optInt("errno", -1) == 200;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                inputStream.close();
                try {
                    return byteArrayOutputStream.toByteArray();
                } finally {
                    com.apm.lite.k.k.a(byteArrayOutputStream);
                }
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static byte[] a(String str, Map<String, String> map, byte[] bArr) {
        try {
            return a(2097152L, a(str, map), bArr, a.GZIP, "application/json; charset=utf-8", false).b();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static byte[] a(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        Deflater deflater = new Deflater();
        deflater.setInput(bArr);
        deflater.finish();
        byte[] bArr2 = new byte[8192];
        while (!deflater.finished()) {
            byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
        }
        deflater.end();
        return byteArrayOutputStream.toByteArray();
    }

    public static k b(String str, String str2, File... fileArr) {
        if (Npth.isStopUpload()) {
            return new k(201);
        }
        try {
            i iVar = new i(a(str, "have_dump=true".concat(a() ? "&encrypt=true" : "")), "UTF-8", true);
            iVar.a("json", str2, true);
            iVar.a("file", fileArr);
            try {
                return new k(0, new JSONObject(iVar.a()));
            } catch (JSONException e) {
                return new k(0, e);
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return new k(207);
        }
    }

    private static k b(String str, byte[] bArr, String str2, String str3, String str4, boolean z, boolean z2, boolean z3) {
        InputStream inputStream;
        byte[] a2;
        DataOutputStream dataOutputStream;
        HttpURLConnection httpURLConnection = null;
        GZIPInputStream gZIPInputStream = null;
        try {
            g gVar = b;
            if (gVar != null) {
                try {
                    str = gVar.a(str, bArr);
                } catch (Throwable unused) {
                }
            }
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                com.apm.lite.h.a.a(httpURLConnection2);
                if (z) {
                    httpURLConnection2.setDoOutput(true);
                } else {
                    httpURLConnection2.setDoOutput(false);
                }
                if (str2 != null) {
                    httpURLConnection2.setRequestProperty("Content-Type", str2);
                }
                if (str3 != null) {
                    httpURLConnection2.setRequestProperty("Content-Encoding", str3);
                }
                httpURLConnection2.setRequestProperty("Accept-Encoding", "gzip");
                if (str4 == null) {
                    throw new IllegalArgumentException("request method is not null");
                }
                if (z3) {
                    String e = com.apm.lite.d.e();
                    if (!TextUtils.isEmpty(e)) {
                        httpURLConnection2.setRequestProperty("aid", e);
                        String b2 = com.apm.lite.d.b(e);
                        if (!TextUtils.isEmpty(b2)) {
                            httpURLConnection2.setRequestProperty(Header.KEY_TOKEN, b2);
                        }
                    }
                }
                httpURLConnection2.setRequestMethod(str4);
                if (bArr != null && bArr.length > 0) {
                    try {
                        dataOutputStream = new DataOutputStream(httpURLConnection2.getOutputStream());
                        try {
                            dataOutputStream.write(bArr);
                            dataOutputStream.flush();
                            com.apm.lite.k.k.a(dataOutputStream);
                        } catch (Throwable th) {
                            th = th;
                            com.apm.lite.k.k.a(dataOutputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        dataOutputStream = null;
                    }
                }
                int responseCode = httpURLConnection2.getResponseCode();
                if (responseCode != 200) {
                    k kVar = new k(206, "http response code " + responseCode);
                    if (httpURLConnection2 != null) {
                        try {
                            httpURLConnection2.disconnect();
                        } catch (Exception unused2) {
                        }
                    }
                    com.apm.lite.k.k.a((Closeable) null);
                    return kVar;
                }
                InputStream inputStream2 = httpURLConnection2.getInputStream();
                try {
                    if ("gzip".equalsIgnoreCase(httpURLConnection2.getContentEncoding())) {
                        try {
                            GZIPInputStream gZIPInputStream2 = new GZIPInputStream(inputStream2);
                            try {
                                a2 = a(gZIPInputStream2);
                                com.apm.lite.k.k.a(gZIPInputStream2);
                            } catch (Throwable th3) {
                                th = th3;
                                gZIPInputStream = gZIPInputStream2;
                                com.apm.lite.k.k.a(gZIPInputStream);
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    } else {
                        a2 = a(inputStream2);
                    }
                    k c = c(a2);
                    if (httpURLConnection2 != null) {
                        try {
                            httpURLConnection2.disconnect();
                        } catch (Exception unused3) {
                        }
                    }
                    com.apm.lite.k.k.a(inputStream2);
                    return c;
                } catch (Throwable th5) {
                    httpURLConnection = httpURLConnection2;
                    inputStream = inputStream2;
                    th = th5;
                    try {
                        q.a(th);
                        return new k(207, th);
                    } finally {
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Exception unused4) {
                            }
                        }
                        com.apm.lite.k.k.a(inputStream);
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                httpURLConnection = httpURLConnection2;
                inputStream = null;
            }
        } catch (Throwable th7) {
            th = th7;
            inputStream = null;
        }
    }

    private static String b(String str, String str2) {
        if (str2 == null) {
            str2 = "UTF-8";
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static boolean b() {
        return TextUtils.equals(MonitorConstants.MONITOR_FROM_SDK, "app");
    }

    private static byte[] b(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        try {
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            try {
                q.b(th);
                gZIPOutputStream.close();
                return null;
            } catch (Throwable th2) {
                gZIPOutputStream.close();
                throw th2;
            }
        }
    }

    private static k c(byte[] bArr) {
        return new k(204, bArr);
    }

    public static String c() {
        return com.apm.lite.e.i().getJavaCrashUploadUrl();
    }

    public static String d() {
        return com.apm.lite.e.i().getAlogUploadUrl();
    }

    public static String e() {
        return com.apm.lite.e.i().getLaunchCrashUploadUrl();
    }

    public static String f() {
        return com.apm.lite.e.i().getNativeCrashUploadUrl();
    }
}
