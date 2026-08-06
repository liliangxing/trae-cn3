package com.apm.lite.p022j;

import android.text.TextUtils;
import coil3.util.Utils_commonKt;
import com.apm.lite.C0744d;
import com.apm.lite.C0749e;
import com.apm.lite.Npth;
import com.apm.lite.p020h.C0760a;
import com.apm.lite.p023k.C0784g;
import com.apm.lite.p023k.C0788k;
import com.apm.lite.p023k.C0794q;
import com.bytedance.frameworks.baselib.network.http.util.HttpStatus;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.framwork.core.sdkmonitor.MonitorConstants;
import com.bytedance.framwork.core.sdkmonitor.MonitorNetUtil;
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

/* renamed from: com.apm.lite.j.e */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0770e {

    /* renamed from: a */
    public static boolean f533a;

    /* renamed from: b */
    private static InterfaceC0772g f534b;

    /* renamed from: com.apm.lite.j.e$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public enum a {
        NONE(0),
        GZIP(1),
        DEFLATER(2);


        /* renamed from: d */
        final int f539d;

        a(int i) {
            this.f539d = i;
        }
    }

    /* renamed from: com.apm.lite.j.e$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
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


        /* renamed from: l */
        final int f552l;

        b(int i) {
            this.f552l = i;
        }
    }

    /* renamed from: a */
    public static C0776k m688a(long j, String str, byte[] bArr, a aVar, String str2, boolean z) {
        return m689a(j, str, bArr, aVar, str2, z, false);
    }

    /* renamed from: a */
    public static C0776k m689a(long j, String str, byte[] bArr, a aVar, String str2, boolean z, boolean z2) {
        String str3;
        String str4;
        StringBuilder sb;
        if (!Npth.isStopUpload() && str != null) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            int length = bArr.length;
            if (a.GZIP == aVar && length > 128) {
                bArr = m705b(bArr);
                str3 = "gzip";
            } else if (a.DEFLATER != aVar || length <= 128) {
                str3 = null;
            } else {
                bArr = m700a(bArr);
                str3 = "deflate";
            }
            String str5 = str3;
            byte[] bArr2 = bArr;
            if (bArr2 == null) {
                return new C0776k(HttpStatus.SC_ACCEPTED);
            }
            if (!z) {
                return m693a(str, bArr2, str2, str5, "POST", true, false, z2);
            }
            byte[] m777a = C0784g.m777a(bArr2);
            if (m777a != null) {
                if (TextUtils.isEmpty(new URL(str).getQuery())) {
                    str4 = "?";
                    if (!str.endsWith("?")) {
                        sb = new StringBuilder();
                        str = sb.append(str).append(str4).toString();
                    }
                    str = str + "tt_data=a";
                    str2 = "application/octet-stream;tt-data=a";
                    bArr2 = m777a;
                } else {
                    str4 = "&";
                    if (!str.endsWith("&")) {
                        sb = new StringBuilder();
                        str = sb.append(str).append(str4).toString();
                    }
                    str = str + "tt_data=a";
                    str2 = "application/octet-stream;tt-data=a";
                    bArr2 = m777a;
                }
            }
            return m693a(str, bArr2, str2, str5, "POST", true, true, z2);
        }
        return new C0776k(HttpStatus.SC_CREATED);
    }

    /* renamed from: a */
    public static C0776k m690a(String str, String str2, boolean z) {
        return m691a(str, str2, m696a(), z);
    }

    /* renamed from: a */
    public static C0776k m691a(String str, String str2, boolean z, boolean z2) {
        try {
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                return m689a(2097152L, str, str2.getBytes(), a.GZIP, "application/json; charset=utf-8", z, z2);
            }
            return new C0776k(HttpStatus.SC_CREATED);
        } catch (Throwable th) {
            C0794q.m893b(th);
            return new C0776k(HttpStatus.SC_MULTI_STATUS, th);
        }
    }

    /* renamed from: a */
    public static C0776k m692a(String str, String str2, File... fileArr) {
        return m701b(str, str2, fileArr);
    }

    /* renamed from: a */
    private static C0776k m693a(String str, byte[] bArr, String str2, String str3, String str4, boolean z, boolean z2, boolean z3) {
        return m702b(str, bArr, str2, str3, str4, z, z2, z3);
    }

    /* renamed from: a */
    private static String m694a(String str, String str2) {
        StringBuilder append;
        try {
            if (TextUtils.isEmpty(new URL(str).getQuery())) {
                if (!str.endsWith("?")) {
                    append = new StringBuilder().append(str).append("?");
                    str = append.toString();
                }
                return str + str2;
            }
            if (!str.endsWith("&")) {
                append = new StringBuilder().append(str).append("&");
                str = append.toString();
            }
            return str + str2;
        } catch (Throwable unused) {
            return str;
        }
        return str;
    }

    /* renamed from: a */
    private static String m695a(String str, Map map) {
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
                        sb.append("&");
                    }
                    sb.append(m703b(entry.getKey().toString(), UrlUtils.UTF_8));
                    sb.append("=");
                    sb.append(m703b(entry.getValue().toString(), UrlUtils.UTF_8));
                }
            }
            return sb.toString();
        } catch (Exception unused) {
            return str;
        }
    }

    /* renamed from: a */
    public static boolean m696a() {
        return TextUtils.equals(MonitorConstants.MONITOR_FROM_SDK, "app");
    }

    /* renamed from: a */
    public static boolean m697a(String str, String str2, String str3, String str4, List<String> list) {
        if (Npth.isStopUpload()) {
            return false;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(MonitorConstants.KEY_AID, str2);
            String m453b = C0744d.m453b(str2);
            if (!TextUtils.isEmpty(m453b)) {
                hashMap.put("x-auth-token", m453b);
            }
            C0774i c0774i = new C0774i(str, UrlUtils.UTF_8, hashMap, false);
            c0774i.m718a(MonitorConstants.KEY_AID, str2);
            c0774i.m718a("device_id", str3);
            c0774i.m718a("os", "Android");
            c0774i.m718a("process_name", str4);
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                File file = new File(it.next());
                if (file.exists()) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("logtype", "alog");
                    hashMap2.put("scene", "crash");
                    c0774i.m717a(file.getName(), file, hashMap2);
                }
            }
            return new JSONObject(c0774i.m716a()).optInt("errno", -1) == 200;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    private static byte[] m698a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                inputStream.close();
                try {
                    return byteArrayOutputStream.toByteArray();
                } finally {
                    C0788k.m813a(byteArrayOutputStream);
                }
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    /* renamed from: a */
    public static byte[] m699a(String str, Map<String, String> map, byte[] bArr) {
        try {
            return m688a(2097152L, m695a(str, map), bArr, a.GZIP, "application/json; charset=utf-8", false).m733b();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private static byte[] m700a(byte[] bArr) {
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

    /* renamed from: b */
    public static C0776k m701b(String str, String str2, File... fileArr) {
        if (Npth.isStopUpload()) {
            return new C0776k(HttpStatus.SC_CREATED);
        }
        try {
            C0774i c0774i = new C0774i(m694a(str, "have_dump=true".concat(m696a() ? "&encrypt=true" : "")), UrlUtils.UTF_8, true);
            c0774i.m719a("json", str2, true);
            c0774i.m721a(Utils_commonKt.SCHEME_FILE, fileArr);
            try {
                return new C0776k(0, new JSONObject(c0774i.m716a()));
            } catch (JSONException e) {
                return new C0776k(0, e);
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return new C0776k(HttpStatus.SC_MULTI_STATUS);
        }
    }

    /* renamed from: b */
    private static C0776k m702b(String str, byte[] bArr, String str2, String str3, String str4, boolean z, boolean z2, boolean z3) {
        InputStream inputStream;
        byte[] m698a;
        DataOutputStream dataOutputStream;
        HttpURLConnection httpURLConnection = null;
        GZIPInputStream gZIPInputStream = null;
        try {
            InterfaceC0772g interfaceC0772g = f534b;
            if (interfaceC0772g != null) {
                try {
                    str = interfaceC0772g.m712a(str, bArr);
                } catch (Throwable unused) {
                }
            }
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                C0760a.m639a(httpURLConnection2);
                if (z) {
                    httpURLConnection2.setDoOutput(true);
                } else {
                    httpURLConnection2.setDoOutput(false);
                }
                if (str2 != null) {
                    httpURLConnection2.setRequestProperty("Content-Type", str2);
                }
                if (str3 != null) {
                    httpURLConnection2.setRequestProperty(MonitorNetUtil.KEY_CONTENT_ENCODING, str3);
                }
                httpURLConnection2.setRequestProperty("Accept-Encoding", "gzip");
                if (str4 == null) {
                    throw new IllegalArgumentException("request method is not null");
                }
                if (z3) {
                    String m456e = C0744d.m456e();
                    if (!TextUtils.isEmpty(m456e)) {
                        httpURLConnection2.setRequestProperty(MonitorConstants.KEY_AID, m456e);
                        String m453b = C0744d.m453b(m456e);
                        if (!TextUtils.isEmpty(m453b)) {
                            httpURLConnection2.setRequestProperty("x-auth-token", m453b);
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
                            C0788k.m813a(dataOutputStream);
                        } catch (Throwable th) {
                            th = th;
                            C0788k.m813a(dataOutputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        dataOutputStream = null;
                    }
                }
                int responseCode = httpURLConnection2.getResponseCode();
                if (responseCode != 200) {
                    C0776k c0776k = new C0776k(HttpStatus.SC_PARTIAL_CONTENT, "http response code " + responseCode);
                    if (httpURLConnection2 != null) {
                        try {
                            httpURLConnection2.disconnect();
                        } catch (Exception unused2) {
                        }
                    }
                    C0788k.m813a((Closeable) null);
                    return c0776k;
                }
                InputStream inputStream2 = httpURLConnection2.getInputStream();
                try {
                    if ("gzip".equalsIgnoreCase(httpURLConnection2.getContentEncoding())) {
                        try {
                            GZIPInputStream gZIPInputStream2 = new GZIPInputStream(inputStream2);
                            try {
                                m698a = m698a(gZIPInputStream2);
                                C0788k.m813a(gZIPInputStream2);
                            } catch (Throwable th3) {
                                th = th3;
                                gZIPInputStream = gZIPInputStream2;
                                C0788k.m813a(gZIPInputStream);
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    } else {
                        m698a = m698a(inputStream2);
                    }
                    C0776k m706c = m706c(m698a);
                    if (httpURLConnection2 != null) {
                        try {
                            httpURLConnection2.disconnect();
                        } catch (Exception unused3) {
                        }
                    }
                    C0788k.m813a(inputStream2);
                    return m706c;
                } catch (Throwable th5) {
                    httpURLConnection = httpURLConnection2;
                    inputStream = inputStream2;
                    th = th5;
                    try {
                        C0794q.m892a(th);
                        return new C0776k(HttpStatus.SC_MULTI_STATUS, th);
                    } finally {
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Exception unused4) {
                            }
                        }
                        C0788k.m813a(inputStream);
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

    /* renamed from: b */
    private static String m703b(String str, String str2) {
        if (str2 == null) {
            str2 = UrlUtils.UTF_8;
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /* renamed from: b */
    public static boolean m704b() {
        return TextUtils.equals(MonitorConstants.MONITOR_FROM_SDK, "app");
    }

    /* renamed from: b */
    private static byte[] m705b(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        try {
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            try {
                C0794q.m893b(th);
                gZIPOutputStream.close();
                return null;
            } catch (Throwable th2) {
                gZIPOutputStream.close();
                throw th2;
            }
        }
    }

    /* renamed from: c */
    private static C0776k m706c(byte[] bArr) {
        return new C0776k(HttpStatus.SC_NO_CONTENT, bArr);
    }

    /* renamed from: c */
    public static String m707c() {
        return C0749e.m567i().getJavaCrashUploadUrl();
    }

    /* renamed from: d */
    public static String m708d() {
        return C0749e.m567i().getAlogUploadUrl();
    }

    /* renamed from: e */
    public static String m709e() {
        return C0749e.m567i().getLaunchCrashUploadUrl();
    }

    /* renamed from: f */
    public static String m710f() {
        return C0749e.m567i().getNativeCrashUploadUrl();
    }
}
