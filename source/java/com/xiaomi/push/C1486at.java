package com.xiaomi.push;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.SystemClock;
import android.text.TextUtils;
import com.lynx.tasm.p001ui.image.ImageDelegate;
import com.ss.android.http.legacy.cookie.InterfaceC0484SM;
import com.ss.android.http.legacy.protocol.HTTP;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;

/* renamed from: com.xiaomi.push.at */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1486at {

    /* renamed from: a */
    private static final AtomicReference<a<C1487au>> f1011a = new AtomicReference<>(m1529a());

    /* renamed from: a */
    public static final Pattern f1012a = Pattern.compile("([^\\s;]+)(.*)");

    /* renamed from: b */
    public static final Pattern f1013b = Pattern.compile("(.*?charset\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);

    /* renamed from: c */
    public static final Pattern f1014c = Pattern.compile("(\\<\\?xml\\s+.*?encoding\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);

    /* renamed from: a */
    public static InputStream m1532a(Context context, URL url, boolean z, String str, String str2) {
        return m1533a(context, url, z, str, str2, null, null);
    }

    /* renamed from: a */
    public static void m1543a() {
        m1546b();
    }

    /* renamed from: b */
    public static void m1546b() {
        f1011a.set(m1529a());
    }

    /* renamed from: a */
    public static Object m1534a(Context context) {
        if (context == null) {
            context = C1702q.m3462a();
        }
        ConnectivityManager.NetworkCallback networkCallback = null;
        if (context == null || C1694j.m3427a(context)) {
            return null;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkRequest build = new NetworkRequest.Builder().build();
            ConnectivityManager.NetworkCallback networkCallback2 = new ConnectivityManager.NetworkCallback() { // from class: com.xiaomi.push.at.1
                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onAvailable(Network network) {
                    super.onAvailable(network);
                    C1486at.m1546b();
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onLost(Network network) {
                    super.onLost(network);
                    C1486at.m1546b();
                }
            };
            try {
                ConnectivityManager.NetworkCallback networkCallback3 = networkCallback2;
                ConnectivityManager.NetworkCallback networkCallback4 = networkCallback3;
                connectivityManager.registerNetworkCallback(build, networkCallback3);
                return networkCallback2;
            } catch (Throwable th) {
                th = th;
                networkCallback = networkCallback2;
                AbstractC1417b.m1089a("exception occurred in adding network callback :" + th);
                return networkCallback;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: a */
    public static void m1544a(Context context, Object obj) {
        if (context == null || obj == null) {
            return;
        }
        try {
            if (obj instanceof ConnectivityManager.NetworkCallback) {
                ((ConnectivityManager) context.getSystemService("connectivity")).unregisterNetworkCallback((ConnectivityManager.NetworkCallback) obj);
            }
        } catch (Throwable th) {
            AbstractC1417b.m1089a("exception occurred in removing network callback :" + th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.xiaomi.push.at$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class a<T> extends FutureTask<T> {

        /* renamed from: a */
        private long f1015a;

        public a(Callable<T> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask, java.util.concurrent.RunnableFuture, java.lang.Runnable
        public void run() {
            this.f1015a = SystemClock.elapsedRealtime();
            super.run();
        }

        /* renamed from: a */
        public boolean m1555a() {
            return C1694j.m3427a(C1702q.m3462a()) || (isDone() && Math.abs(SystemClock.elapsedRealtime() - this.f1015a) > 1800000);
        }
    }

    /* renamed from: a */
    private static a<C1487au> m1529a() {
        return new a<>(new Callable<C1487au>() { // from class: com.xiaomi.push.at.2
            @Override // java.util.concurrent.Callable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public C1487au call() {
                NetworkInfo activeNetworkInfo;
                Context m3462a = C1702q.m3462a();
                if (m3462a == null) {
                    return null;
                }
                try {
                    ConnectivityManager connectivityManager = (ConnectivityManager) m3462a.getSystemService("connectivity");
                    if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                        return null;
                    }
                    return new C1487au(activeNetworkInfo);
                } catch (Exception unused) {
                    return null;
                }
            }
        });
    }

    /* renamed from: a */
    public static C1487au m1530a() {
        AtomicReference<a<C1487au>> atomicReference = f1011a;
        a<C1487au> aVar = atomicReference.get();
        if (aVar != null) {
            try {
                if (aVar.m1555a()) {
                    aVar = m1529a();
                    atomicReference.set(aVar);
                }
                if (!aVar.isDone()) {
                    aVar.run();
                }
                return aVar.get();
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* renamed from: a */
    public static InputStream m1533a(Context context, URL url, boolean z, String str, String str2, Map<String, String> map, c cVar) {
        if (context == null) {
            throw new IllegalArgumentException("context");
        }
        if (url == null) {
            throw new IllegalArgumentException("url");
        }
        URL url2 = !z ? new URL(m1538a(url.toString())) : url;
        try {
            HttpURLConnection.setFollowRedirects(true);
            HttpURLConnection m1541a = m1541a(context, url2);
            m1541a.setConnectTimeout(10000);
            m1541a.setReadTimeout(15000);
            if (!TextUtils.isEmpty(str)) {
                m1541a.setRequestProperty("User-Agent", str);
            }
            if (str2 != null) {
                m1541a.setRequestProperty(InterfaceC0484SM.COOKIE, str2);
            }
            if (map != null) {
                for (String str3 : map.keySet()) {
                    m1541a.setRequestProperty(str3, map.get(str3));
                }
            }
            if (cVar != null && (url.getProtocol().equals(ImageDelegate.HTTP_PREFIX) || url.getProtocol().equals("https"))) {
                cVar.f1017a = m1541a.getResponseCode();
                if (cVar.f1018a == null) {
                    cVar.f1018a = new HashMap();
                }
                int i = 0;
                while (true) {
                    String headerFieldKey = m1541a.getHeaderFieldKey(i);
                    String headerField = m1541a.getHeaderField(i);
                    if (headerFieldKey == null && headerField == null) {
                        break;
                    }
                    if (!TextUtils.isEmpty(headerFieldKey) && !TextUtils.isEmpty(headerField)) {
                        cVar.f1018a.put(headerFieldKey, headerField);
                    }
                    i++;
                }
            }
            return new b(m1541a.getInputStream());
        } catch (IOException e) {
            throw new IOException("IOException:" + e.getClass().getSimpleName());
        } catch (Throwable th) {
            throw new IOException(th.getMessage());
        }
    }

    /* renamed from: a */
    public static String m1536a(Context context, URL url) {
        return m1537a(context, url, false, null, HTTP.UTF_8, null);
    }

    /* renamed from: a */
    public static String m1537a(Context context, URL url, boolean z, String str, String str2, String str3) {
        InputStream inputStream;
        try {
            inputStream = m1532a(context, url, z, str, str3);
            try {
                StringBuilder sb = new StringBuilder(1024);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, str2));
                char[] cArr = new char[4096];
                while (true) {
                    int read = bufferedReader.read(cArr);
                    if (-1 != read) {
                        sb.append(cArr, 0, read);
                    } else {
                        C1801v.m4105a((Closeable) inputStream);
                        return sb.toString();
                    }
                }
            } catch (Throwable th) {
                th = th;
                C1801v.m4105a((Closeable) inputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
    }

    /* renamed from: com.xiaomi.push.at$c */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class c {

        /* renamed from: a */
        public int f1017a;

        /* renamed from: a */
        public Map<String, String> f1018a;

        public String toString() {
            return String.format("resCode = %1$d, headers = %2$s", Integer.valueOf(this.f1017a), this.f1018a.toString());
        }
    }

    /* renamed from: a */
    public static String m1538a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        new String();
        return String.format("%s&key=%s", str, C1492az.m1595a(String.format("%sbe988a6134bc8254465424e5a70ef037", str)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static String m1539a(String str, Map<String, String> map, File file, String str2) {
        if (!file.exists()) {
            return null;
        }
        String name = file.getName();
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setReadTimeout(15000);
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
                httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=*****");
                if (map != null) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                httpURLConnection.setFixedLengthStreamingMode(name.length() + 77 + ((int) file.length()) + str2.length());
                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                dataOutputStream.writeBytes("--*****\r\n");
                dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + str2 + "\";filename=\"" + file.getName() + "\"\r\n");
                dataOutputStream.writeBytes("\r\n");
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        dataOutputStream.write(bArr, 0, read);
                        dataOutputStream.flush();
                    }
                    dataOutputStream.writeBytes("\r\n");
                    dataOutputStream.writeBytes("--");
                    dataOutputStream.writeBytes("*****");
                    dataOutputStream.writeBytes("--");
                    dataOutputStream.writeBytes("\r\n");
                    dataOutputStream.flush();
                    StringBuffer stringBuffer = new StringBuffer();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new b(httpURLConnection.getInputStream())));
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine != null) {
                                stringBuffer.append(readLine);
                            } else {
                                String stringBuffer2 = stringBuffer.toString();
                                C1801v.m4105a((Closeable) fileInputStream);
                                C1801v.m4105a(bufferedReader);
                                return stringBuffer2;
                            }
                        } catch (IOException e) {
                            e = e;
                            throw new IOException("IOException:" + e.getClass().getSimpleName());
                        } catch (Throwable th) {
                            th = th;
                            throw new IOException(th.getMessage());
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                C1801v.m4105a((Closeable) null);
                C1801v.m4105a((Closeable) file);
                throw th3;
            }
        } catch (IOException e3) {
            e = e3;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* renamed from: a */
    public static int m1526a(Context context) {
        C1487au m1530a = m1530a();
        if (m1530a == null) {
            return -1;
        }
        return m1530a.m1557a();
    }

    /* renamed from: a */
    public static HttpURLConnection m1541a(Context context, URL url) {
        return (HttpURLConnection) url.openConnection();
    }

    /* renamed from: com.xiaomi.push.at$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static final class b extends FilterInputStream {

        /* renamed from: a */
        private boolean f1016a;

        public b(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            int read;
            if (!this.f1016a && (read = super.read(bArr, i, i2)) != -1) {
                return read;
            }
            this.f1016a = true;
            return -1;
        }
    }

    /* renamed from: a */
    public static boolean m1545a(Context context) {
        return m1526a(context) >= 0;
    }

    /* renamed from: b */
    public static boolean m1547b(Context context) {
        NetworkCapabilities networkCapabilities;
        boolean hasCapability;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            try {
                networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            } catch (Exception unused) {
            }
            if (networkCapabilities != null) {
                hasCapability = networkCapabilities.hasCapability(16);
                return hasCapability && m1548c(context);
            }
        }
        hasCapability = false;
        if (hasCapability) {
            return false;
        }
    }

    /* renamed from: c */
    public static boolean m1548c(Context context) {
        C1487au m1530a = m1530a();
        return m1530a != null && m1530a.m1561a();
    }

    /* renamed from: d */
    public static boolean m1549d(Context context) {
        C1487au m1530a = m1530a();
        return m1530a != null && 1 == m1530a.m1557a();
    }

    /* renamed from: e */
    public static boolean m1550e(Context context) {
        C1487au m1531a = m1531a(context);
        return m1531a != null && m1531a.m1557a() == 0 && 20 == m1531a.m1562b();
    }

    /* renamed from: f */
    public static boolean m1551f(Context context) {
        C1487au m1531a = m1531a(context);
        return m1531a != null && m1531a.m1557a() == 0 && 13 == m1531a.m1562b();
    }

    /* renamed from: g */
    public static boolean m1552g(Context context) {
        C1487au m1531a = m1531a(context);
        if (m1531a == null || m1531a.m1557a() != 0) {
            return false;
        }
        String m1563b = m1531a.m1563b();
        if (!"TD-SCDMA".equalsIgnoreCase(m1563b) && !"CDMA2000".equalsIgnoreCase(m1563b) && !"WCDMA".equalsIgnoreCase(m1563b)) {
            switch (m1531a.m1562b()) {
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    break;
                case 4:
                case 7:
                case 11:
                case 13:
                default:
                    return false;
            }
        }
        return true;
    }

    /* renamed from: h */
    public static boolean m1553h(Context context) {
        C1487au m1531a = m1531a(context);
        if (m1531a == null || m1531a.m1557a() != 0) {
            return false;
        }
        int m1562b = m1531a.m1562b();
        return m1562b == 1 || m1562b == 2 || m1562b == 4 || m1562b == 7 || m1562b == 11;
    }

    /* renamed from: a */
    public static C1487au m1531a(Context context) {
        return m1530a();
    }

    /* renamed from: a */
    public static String m1535a(Context context) {
        if (m1549d(context)) {
            return "wifi";
        }
        C1487au m1530a = m1530a();
        return m1530a == null ? "" : (m1530a.m1560a() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + m1530a.m1563b()).toLowerCase();
    }

    /* renamed from: a */
    public static C1484ar m1528a(Context context, String str, Map<String, String> map) {
        return m1527a(context, str, "POST", (Map<String, String>) null, m1540a(map));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C1484ar m1527a(Context context, String str, String str2, Map<String, String> map, String str3) {
        boolean z;
        BufferedReader bufferedReader;
        OutputStream outputStream;
        C1484ar c1484ar = new C1484ar();
        try {
            try {
                try {
                    HttpURLConnection m1541a = m1541a(context, m1542a(str));
                    m1541a.setConnectTimeout(10000);
                    m1541a.setReadTimeout(15000);
                    String str4 = str2;
                    if (str2 == 0) {
                        str4 = "GET";
                    }
                    m1541a.setRequestMethod(str4);
                    int i = 0;
                    if (map != null) {
                        z = DownloadHelper.GZIP.equalsIgnoreCase(map.get("Content-Encoding"));
                        for (String str5 : map.keySet()) {
                            m1541a.setRequestProperty(str5, map.get(str5));
                        }
                    } else {
                        z = false;
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        m1541a.setDoOutput(true);
                        byte[] bytes = str3.getBytes();
                        if (z) {
                            outputStream = new GZIPOutputStream(m1541a.getOutputStream());
                        } else {
                            outputStream = m1541a.getOutputStream();
                        }
                        try {
                            outputStream.write(bytes, 0, bytes.length);
                            outputStream.flush();
                            outputStream.close();
                        } catch (IOException e) {
                            e = e;
                            throw new IOException("err while request " + str + Constants.COLON_SEPARATOR + e.getClass().getSimpleName());
                        } catch (Throwable th) {
                            th = th;
                            throw new IOException(th.getMessage());
                        }
                    }
                    c1484ar.f1008a = m1541a.getResponseCode();
                    AbstractC1417b.m1089a("Http POST Response Code: " + c1484ar.f1008a);
                    while (true) {
                        String headerFieldKey = m1541a.getHeaderFieldKey(i);
                        String headerField = m1541a.getHeaderField(i);
                        if (headerFieldKey != null || headerField != null) {
                            c1484ar.f1010a.put(headerFieldKey, headerField);
                            i = i + 1 + 1;
                        } else {
                            try {
                                break;
                            } catch (IOException unused) {
                                bufferedReader = new BufferedReader(new InputStreamReader(new b(m1541a.getErrorStream())));
                            }
                        }
                    }
                    bufferedReader = new BufferedReader(new InputStreamReader(new b(m1541a.getInputStream())));
                } catch (IOException e2) {
                    e = e2;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                StringBuffer stringBuffer = new StringBuffer();
                String property = System.getProperty("line.separator");
                for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                    stringBuffer.append(readLine);
                    stringBuffer.append(property);
                }
                c1484ar.f1009a = stringBuffer.toString();
                bufferedReader.close();
                C1801v.m4105a((Closeable) null);
                C1801v.m4105a((Closeable) null);
                return c1484ar;
            } catch (IOException e3) {
                e = e3;
                throw new IOException("err while request " + str + Constants.COLON_SEPARATOR + e.getClass().getSimpleName());
            } catch (Throwable th3) {
                th = th3;
                throw new IOException(th.getMessage());
            }
        } catch (Throwable th4) {
            C1801v.m4105a((Closeable) null);
            C1801v.m4105a((Closeable) str2);
            throw th4;
        }
    }

    /* renamed from: a */
    public static String m1540a(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                try {
                    stringBuffer.append(URLEncoder.encode(entry.getKey(), HTTP.UTF_8));
                    stringBuffer.append("=");
                    stringBuffer.append(URLEncoder.encode(entry.getValue(), HTTP.UTF_8));
                    stringBuffer.append("&");
                } catch (UnsupportedEncodingException e) {
                    AbstractC1417b.m1089a("Failed to convert from params map to string: " + e);
                    AbstractC1417b.m1089a("map: " + map.toString());
                    return null;
                }
            }
        }
        if (stringBuffer.length() > 0) {
            stringBuffer = stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private static URL m1542a(String str) {
        return new URL(str);
    }
}
