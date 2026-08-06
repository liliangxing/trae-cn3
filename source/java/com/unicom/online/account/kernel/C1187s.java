package com.unicom.online.account.kernel;

import android.content.Context;
import android.net.Network;
import android.text.TextUtils;
import com.ss.alive.monitor.services.interfaze.IAssociationStartMonitorEventService;
import com.ss.android.http.legacy.protocol.HTTP;
import com.ss.android.pushmanager.PushCommonConstants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import org.json.JSONObject;

/* renamed from: com.unicom.online.account.kernel.s */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1187s {

    /* renamed from: a */
    public static boolean f306a;

    /* renamed from: c */
    private static final HostnameVerifier f307c = new HostnameVerifier() { // from class: com.unicom.online.account.kernel.s.1
        @Override // javax.net.ssl.HostnameVerifier
        public final boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    };

    /* renamed from: b */
    private boolean f308b = false;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0056 A[Catch: all -> 0x0166, Exception -> 0x0168, TryCatch #7 {Exception -> 0x0168, all -> 0x0166, blocks: (B:15:0x004f, B:17:0x0056, B:18:0x005d, B:67:0x0060), top: B:14:0x004f }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c4 A[Catch: Exception -> 0x0164, all -> 0x01a0, TryCatch #0 {all -> 0x01a0, blocks: (B:21:0x0066, B:23:0x00c4, B:25:0x00d2, B:35:0x00f9, B:37:0x0105, B:39:0x010d, B:43:0x0117, B:47:0x0121, B:51:0x013f, B:56:0x016a, B:58:0x016d), top: B:14:0x004f }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0060 A[Catch: all -> 0x0166, Exception -> 0x0168, TRY_LEAVE, TryCatch #7 {Exception -> 0x0168, all -> 0x0166, blocks: (B:15:0x004f, B:17:0x0056, B:18:0x005d, B:67:0x0060), top: B:14:0x004f }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String m551a(Context context, String str, Object obj) {
        String str2;
        ?? r5;
        HttpURLConnection httpURLConnection;
        int responseCode;
        URL url;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            url = new URL(str);
            str2 = url.getHost();
        } catch (MalformedURLException e) {
            e = e;
            str2 = str;
        }
        try {
            url.getPort();
        } catch (MalformedURLException e2) {
            e = e2;
            e.printStackTrace();
            if (str2.contains("10010.com")) {
            }
            if (C1166ab.m458c().equalsIgnoreCase("99166000000000000224")) {
            }
            r5 = 0;
            try {
                URL url2 = new URL(str);
                httpURLConnection = (HttpURLConnection) (obj == null ? ((Network) obj).openConnection(url2) : url2.openConnection());
                try {
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setDoOutput(false);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setInstanceFollowRedirects(false);
                    httpURLConnection.setReadTimeout(10000);
                    httpURLConnection.setConnectTimeout(10000);
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.addRequestProperty(HTTP.CONN_DIRECTIVE, PushCommonConstants.VALUE_CLOSE);
                    httpURLConnection.connect();
                    C1165aa.m448b("connect cost:" + (System.currentTimeMillis() - currentTimeMillis));
                    long currentTimeMillis2 = System.currentTimeMillis();
                    responseCode = httpURLConnection.getResponseCode();
                    C1165aa.m448b("response cost:" + (System.currentTimeMillis() - currentTimeMillis2));
                    if (responseCode != 200) {
                    }
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(MonitorConstants.CODE, 10024);
                        jSONObject.put(IAssociationStartMonitorEventService.KEY_MSG, "http异常" + e.getMessage());
                        jSONObject.put("data", str2);
                        String jSONObject2 = jSONObject.toString();
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return jSONObject2;
                    } catch (Exception unused) {
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return null;
                    }
                }
            } catch (Throwable th) {
                th = th;
                r5 = str;
                if (r5 != 0) {
                    r5.disconnect();
                }
                throw th;
            }
        }
        if (str2.contains("10010.com")) {
            str = str + C1167ac.m493g();
        }
        if (C1166ab.m458c().equalsIgnoreCase("99166000000000000224")) {
            C1165aa.m448b(str2);
        } else {
            C1165aa.m448b(str);
        }
        r5 = 0;
        try {
            URL url22 = new URL(str);
            httpURLConnection = (HttpURLConnection) (obj == null ? ((Network) obj).openConnection(url22) : url22.openConnection());
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(false);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.addRequestProperty(HTTP.CONN_DIRECTIVE, PushCommonConstants.VALUE_CLOSE);
            httpURLConnection.connect();
            C1165aa.m448b("connect cost:" + (System.currentTimeMillis() - currentTimeMillis));
            long currentTimeMillis22 = System.currentTimeMillis();
            responseCode = httpURLConnection.getResponseCode();
            C1165aa.m448b("response cost:" + (System.currentTimeMillis() - currentTimeMillis22));
            if (responseCode != 200) {
                String m552a = m552a(httpURLConnection.getInputStream());
                if (!TextUtils.isEmpty(m552a)) {
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return m552a;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(MonitorConstants.CODE, 410012);
                jSONObject3.put(IAssociationStartMonitorEventService.KEY_MSG, "410012");
                jSONObject3.put("data", str2);
                String jSONObject4 = jSONObject3.toString();
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return jSONObject4;
            }
            if (responseCode != 302) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put(MonitorConstants.CODE, 410010);
                jSONObject5.put(IAssociationStartMonitorEventService.KEY_MSG, "http ".concat(String.valueOf(responseCode)));
                jSONObject5.put("data", str2);
                String jSONObject6 = jSONObject5.toString();
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return jSONObject6;
            }
            String headerField = httpURLConnection.getHeaderField("Location");
            if (TextUtils.isEmpty(headerField)) {
                JSONObject jSONObject7 = new JSONObject();
                jSONObject7.put(MonitorConstants.CODE, 410013);
                jSONObject7.put(IAssociationStartMonitorEventService.KEY_MSG, "无跳转地址");
                jSONObject7.put("data", str2);
                String jSONObject8 = jSONObject7.toString();
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return jSONObject8;
            }
            if (headerField.startsWith("https")) {
                String m554a = m554a(context, headerField, null, obj);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return m554a;
            }
            String m551a = m551a(context, headerField, obj);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return m551a;
        } catch (Exception e4) {
            e = e4;
            httpURLConnection = null;
        } catch (Throwable th2) {
            th = th2;
            if (r5 != 0) {
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0047 A[Catch: Exception -> 0x004a, TRY_LEAVE, TryCatch #2 {Exception -> 0x004a, blocks: (B:40:0x0042, B:35:0x0047), top: B:39:0x0042 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0042 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String m552a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    String str = new String(byteArrayOutputStream.toByteArray());
                    try {
                        byteArrayOutputStream.close();
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    } catch (Exception unused) {
                    }
                    return str;
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception unused2) {
                            return null;
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception unused3) {
                        throw th;
                    }
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            byteArrayOutputStream = null;
        } catch (Throwable th3) {
            byteArrayOutputStream = null;
            th = th3;
            if (byteArrayOutputStream != null) {
            }
            if (inputStream != null) {
            }
            throw th;
        }
    }

    /* renamed from: a */
    private static String m553a(String str) {
        return str.contains(Constants.COLON_SEPARATOR) ? "[" + str + "]" : str;
    }

    /* renamed from: a */
    public final String m554a(Context context, String str, HashMap<String, String> hashMap, Object obj) {
        String str2;
        String str3 = str;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            str2 = new URL(str3).getHost();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            str2 = "";
        }
        String str4 = str2;
        if (str4.contains(C1174f.m524e()) && f306a && !TextUtils.isEmpty(C1166ab.f226a)) {
            str3 = str3.replaceFirst(C1174f.m524e(), m553a(C1166ab.f226a));
        }
        C1165aa.m448b("\n■★■★■★■★■★■★■★■★■★■\n requestGetHttps() requestUrl - >" + str3.substring(0, 25) + "...\n ...\n iRetry = " + C1167ac.m490e() + "■★■★■★■★■★■★■★■★■★■\n");
        try {
            URL url = new URL(str3);
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) (obj != null ? ((Network) obj).openConnection(url) : url.openConnection());
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setDoOutput(false);
            httpsURLConnection.setUseCaches(false);
            httpsURLConnection.setInstanceFollowRedirects(false);
            httpsURLConnection.setReadTimeout(10000);
            httpsURLConnection.setConnectTimeout(10000);
            httpsURLConnection.setRequestMethod("GET");
            httpsURLConnection.setHostnameVerifier(f307c);
            httpsURLConnection.setInstanceFollowRedirects(true);
            HttpURLConnection.setFollowRedirects(true);
            if (hashMap != null) {
                for (String str5 : hashMap.keySet()) {
                    httpsURLConnection.setRequestProperty(str5, hashMap.get(str5));
                }
            }
            httpsURLConnection.addRequestProperty(HTTP.CONN_DIRECTIVE, PushCommonConstants.VALUE_CLOSE);
            C1165aa.m448b("TAG\thttpsURLConnection.connect();\n");
            httpsURLConnection.connect();
            C1165aa.m448b("connect cost:" + (System.currentTimeMillis() - currentTimeMillis));
            long currentTimeMillis2 = System.currentTimeMillis();
            int responseCode = httpsURLConnection.getResponseCode();
            C1165aa.m448b("\n■★■★■★■★■★■★■★■★■★■\n requestGetHttps() statusCode - >" + responseCode + "\n ■★■★■★■★■★■★■★■★■★■\n");
            C1165aa.m448b("response cost:" + (System.currentTimeMillis() - currentTimeMillis2));
            if (responseCode == 200) {
                String m552a = m552a(httpsURLConnection.getInputStream());
                if (!TextUtils.isEmpty(m552a)) {
                    return m552a;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(MonitorConstants.CODE, 410012);
                jSONObject.put(IAssociationStartMonitorEventService.KEY_MSG, "410012");
                jSONObject.put("data", str4);
                return jSONObject.toString();
            }
            if (responseCode != 302) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(MonitorConstants.CODE, 410010);
                jSONObject2.put(IAssociationStartMonitorEventService.KEY_MSG, "https ".concat(String.valueOf(responseCode)));
                jSONObject2.put("data", str4);
                return jSONObject2.toString();
            }
            String headerField = httpsURLConnection.getHeaderField("Location");
            C1165aa.m448b("redirectUrl is ".concat(String.valueOf(headerField)));
            C1165aa.m448b("System.currentTimeMillis() is " + System.currentTimeMillis());
            if (!TextUtils.isEmpty(headerField)) {
                return headerField.startsWith("https") ? m554a(context, headerField, null, obj) : m551a(context, headerField, obj);
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(MonitorConstants.CODE, 410013);
            jSONObject3.put(IAssociationStartMonitorEventService.KEY_MSG, "无跳转地址");
            jSONObject3.put("data", str4);
            return jSONObject3.toString();
        } catch (Exception e2) {
            int m492f = C1167ac.m492f();
            C1165aa.m448b("\n■★■★■★■★■★■★■★■★■★■\n iRetry = >" + m492f + " \n   e-->" + e2 + "\n ■★■★■★■★■★■★■★■★■★■\n");
            e2.printStackTrace();
            String message = e2.getMessage();
            if (message == null || m492f <= 0) {
                try {
                    C1165aa.m448b("catch (Exception e) is  ".concat(String.valueOf(e2)));
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put(MonitorConstants.CODE, 410011);
                    jSONObject4.put(IAssociationStartMonitorEventService.KEY_MSG, "https异常 : ".concat(String.valueOf(message)));
                    jSONObject4.put("data", "requestUrl->".concat(String.valueOf(str3)));
                    return jSONObject4.toString();
                } catch (Exception unused) {
                    return null;
                }
            }
            if (message.contains("resolve host") && str4.contains(C1174f.m524e())) {
                C1165aa.m448b("resolve host error: retry->" + m492f + "e_getMessage=" + message);
                this.f308b = true;
                if (!TextUtils.isEmpty(C1166ab.f226a)) {
                    str3 = str3.replaceFirst(C1174f.m524e(), m553a(C1166ab.f226a));
                }
                return m554a(context, str3, hashMap, obj);
            }
            if (message.contains("Failed to connect")) {
                C1165aa.m448b("Failed to connect error: retry->" + m492f + "e_getMessage=" + message);
                return m554a(context, str3, hashMap, obj);
            }
            C1165aa.m448b("other  error: retry->" + m492f + "e_getMessage=" + message);
            return m554a(context, str3, hashMap, obj);
        }
    }
}
