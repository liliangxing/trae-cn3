package com.bytedance.tobshadow.bdtracker;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.open.aweme.core.net.OpenNetMethod;
import com.bytedance.sdk.xbridge.cn.runtime.utils.XBridgeAPIRequestUtils;
import com.bytedance.tobshadow.applog.InitConfig;
import com.bytedance.tobshadow.applog.UriConfig;
import com.bytedance.tobshadow.applog.log.IAppLogLogger;
import com.bytedance.tobshadow.applog.log.LogUtils;
import com.bytedance.tobshadow.applog.network.INetworkClient;
import com.bytedance.tobshadow.applog.network.INetworkClientV2;
import com.bytedance.tobshadow.applog.network.RangersHttpException;
import com.bytedance.tobshadow.applog.network.RangersHttpTimeoutException;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.y3 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0555y3 implements INetworkClient {

    /* renamed from: a */
    public final C0444i4 f1258a;

    public C0555y3(C0444i4 c0444i4) {
        this.f1258a = c0444i4;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(28:63|(4:66|67|(4:70|(4:75|76|77|78)|79|68)|82)|86|(4:87|88|89|90)|(4:(3:93|94|(31:96|97|98|99|100|101|102|(1:104)|105|(1:107)(1:(2:316|317)(7:306|307|308|309|310|311|312))|(3:111|(4:114|(7:119|120|121|122|123|124|126)(3:146|147|148)|127|112)|150)|152|153|154|(6:156|157|158|159|160|161)(1:300)|(2:163|(1:165)(1:292))(1:293)|(1:291)(4:169|170|171|172)|173|174|175|176|177|178|179|(1:(22:182|(1:184)(1:239)|185|186|(2:187|(1:189)(1:190))|191|192|193|194|(3:200|(2:203|201)|204)|205|206|207|208|(2:216|217)|222|223|224|225|226|227|228)(21:240|241|242|(1:244)(1:271)|245|246|247|248|249|(2:250|(1:252)(1:253))|254|256|257|258|259|260|224|225|226|227|228))(4:276|277|278|279)|274|275|232|132|133|(2:135|(2:137|138)(2:139|140))(2:141|142)))|132|133|(0)(0))|329|(0)|105|(0)(0)|(4:109|111|(1:112)|150)|152|153|154|(0)(0)|(0)(0)|(1:167)|291|173|174|175|176|177|178|179|(0)(0)|274|275|232) */
    /* JADX WARN: Can't wrap try/catch for region: R(34:63|(4:66|67|(4:70|(4:75|76|77|78)|79|68)|82)|86|87|88|89|90|(3:93|94|(31:96|97|98|99|100|101|102|(1:104)|105|(1:107)(1:(2:316|317)(7:306|307|308|309|310|311|312))|(3:111|(4:114|(7:119|120|121|122|123|124|126)(3:146|147|148)|127|112)|150)|152|153|154|(6:156|157|158|159|160|161)(1:300)|(2:163|(1:165)(1:292))(1:293)|(1:291)(4:169|170|171|172)|173|174|175|176|177|178|179|(1:(22:182|(1:184)(1:239)|185|186|(2:187|(1:189)(1:190))|191|192|193|194|(3:200|(2:203|201)|204)|205|206|207|208|(2:216|217)|222|223|224|225|226|227|228)(21:240|241|242|(1:244)(1:271)|245|246|247|248|249|(2:250|(1:252)(1:253))|254|256|257|258|259|260|224|225|226|227|228))(4:276|277|278|279)|274|275|232|132|133|(2:135|(2:137|138)(2:139|140))(2:141|142)))|329|(0)|105|(0)(0)|(4:109|111|(1:112)|150)|152|153|154|(0)(0)|(0)(0)|(1:167)|291|173|174|175|176|177|178|179|(0)(0)|274|275|232|132|133|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:282:0x04d5, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:283:0x04d6, code lost:
    
        r17 = r35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:285:0x04d9, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:286:0x04da, code lost:
    
        r17 = r35;
        r13 = 11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:302:0x04e7, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:303:0x04e8, code lost:
    
        r13 = 11;
        r29 = "Send request failed";
        r18 = "Request timeout";
        r28 = r17;
        r27 = r25;
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01f6 A[Catch: all -> 0x01fd, TRY_ENTER, TryCatch #16 {all -> 0x01fd, blocks: (B:99:0x01d2, B:104:0x01f6, B:107:0x020b, B:109:0x0221, B:111:0x0227, B:112:0x022f, B:114:0x0235, B:116:0x0247, B:147:0x0253, B:119:0x0263, B:121:0x026a), top: B:98:0x01d2 }] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x020b A[Catch: all -> 0x01fd, TRY_LEAVE, TryCatch #16 {all -> 0x01fd, blocks: (B:99:0x01d2, B:104:0x01f6, B:107:0x020b, B:109:0x0221, B:111:0x0227, B:112:0x022f, B:114:0x0235, B:116:0x0247, B:147:0x0253, B:119:0x0263, B:121:0x026a), top: B:98:0x01d2 }] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0235 A[Catch: all -> 0x01fd, TryCatch #16 {all -> 0x01fd, blocks: (B:99:0x01d2, B:104:0x01f6, B:107:0x020b, B:109:0x0221, B:111:0x0227, B:112:0x022f, B:114:0x0235, B:116:0x0247, B:147:0x0253, B:119:0x0263, B:121:0x026a), top: B:98:0x01d2 }] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0565 A[Catch: all -> 0x0593, TRY_LEAVE, TryCatch #21 {all -> 0x0593, blocks: (B:133:0x054a, B:135:0x0565, B:139:0x0588, B:140:0x058f, B:141:0x0590, B:142:0x0592), top: B:132:0x054a }] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0590 A[Catch: all -> 0x0593, TryCatch #21 {all -> 0x0593, blocks: (B:133:0x054a, B:135:0x0565, B:139:0x0588, B:140:0x058f, B:141:0x0590, B:142:0x0592), top: B:132:0x054a }] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x02cd A[Catch: all -> 0x02df, TryCatch #28 {all -> 0x02df, blocks: (B:161:0x02a7, B:163:0x02cd, B:165:0x02d3, B:167:0x02e8, B:169:0x02eb, B:292:0x02da), top: B:160:0x02a7 }] */
    /* JADX WARN: Removed duplicated region for block: B:181:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x04b9  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ff  */
    @Override // com.bytedance.tobshadow.applog.network.INetworkClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] execute(byte b, String str, JSONObject jSONObject, Map<String, String> map, byte b2, boolean z, int i) {
        byte[] bArr;
        String str2;
        String str3;
        String str4;
        int i2;
        HttpURLConnection httpURLConnection;
        BufferedReader bufferedReader;
        InputStream inputStream;
        DataOutputStream dataOutputStream;
        HttpURLConnection httpURLConnection2;
        URL url;
        String str5;
        byte[] bArr2;
        String str6;
        boolean z2;
        HttpURLConnection httpURLConnection3;
        String str7;
        String str8;
        int i3;
        byte[] bArr3;
        HttpURLConnection httpURLConnection4;
        DataOutputStream dataOutputStream2;
        int responseCode;
        InputStream gZIPInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        HttpURLConnection httpURLConnection5;
        byte[] byteArray;
        byte[] bArr4;
        List<String> list;
        SSLSocketFactory sslSocketFactory;
        int i4;
        byte[] bArr5;
        int i5;
        C0444i4 c0444i4 = this.f1258a;
        InitConfig initConfig = c0444i4.f668b.getInitConfig();
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        byte[] bArr6 = null;
        byteArrayOutputStream2 = null;
        byteArrayOutputStream2 = null;
        byteArrayOutputStream2 = null;
        byteArrayOutputStream2 = null;
        if (initConfig != null && initConfig.getNetworkClientV2() != null) {
            c0444i4.f668b.f764D.debug(11, "httpRequestInner use custom network client v2", str);
            c0444i4.f668b.f764D.debug(11, "Start request http use network client v2 url: {}", str);
            byte[] bArr7 = new byte[0];
            try {
                URL url2 = new URL(str);
                InitConfig initConfig2 = c0444i4.f668b.getInitConfig();
                if (jSONObject != null) {
                    String jSONObject2 = jSONObject.toString();
                    bArr5 = z ? c0444i4.f669c.m586b(jSONObject2) : jSONObject2.getBytes("UTF-8");
                } else {
                    bArr5 = null;
                }
                INetworkClientV2.RequestType requestType = INetworkClientV2.RequestType.REQUEST_FINDER;
                if (url2.getPath().contains(UriConfig.PATH_AB)) {
                    requestType = INetworkClientV2.RequestType.REQUEST_AB;
                } else if (url2.getPath().contains(UriConfig.PATH_ALINK_ATTRIBUTION) || url2.getPath().contains(UriConfig.PATH_ALINK_QUERY)) {
                    requestType = INetworkClientV2.RequestType.REQUEST_TRACER;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("request_type", requestType);
                if (initConfig2 != null) {
                    i5 = 1;
                    try {
                        bArr6 = initConfig2.getNetworkClientV2().execute(b == 0 ? INetworkClientV2.RequestMethod.METHOD_GET : INetworkClientV2.RequestMethod.METHOD_POST, url2, bArr5, map, hashMap);
                    } catch (Throwable th) {
                        th = th;
                        i4 = 11;
                        c0444i4.f668b.f764D.error(i4, "Send request failed", th, new Object[0]);
                        c0444i4.f668b.m522b().mo639a(th, "httpRequestInner");
                        if (!(th instanceof RangersHttpException)) {
                            throw th;
                        }
                        if (th instanceof SocketTimeoutException) {
                            throw new RangersHttpTimeoutException("Request timeout");
                        }
                        return bArr7;
                    }
                } else {
                    i5 = 1;
                }
                try {
                    IAppLogLogger iAppLogLogger = c0444i4.f668b.f764D;
                    Object[] objArr = new Object[i5];
                    objArr[0] = str;
                    i4 = 11;
                    try {
                        iAppLogLogger.debug(11, "End request http use network client v2 url: {}", objArr);
                        return bArr6;
                    } catch (Throwable th2) {
                        th = th2;
                        bArr7 = bArr6;
                        c0444i4.f668b.f764D.error(i4, "Send request failed", th, new Object[0]);
                        c0444i4.f668b.m522b().mo639a(th, "httpRequestInner");
                        if (!(th instanceof RangersHttpException)) {
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    i4 = 11;
                }
            } catch (Throwable th4) {
                th = th4;
                i4 = 11;
            }
        } else {
            c0444i4.f668b.f764D.debug(11, "Start request http url: {}", str);
            if (c0444i4.f668b.m525c() && map != null) {
                try {
                    Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry<String, String> next = it.next();
                        if (!TextUtils.isEmpty(next.getKey()) && !TextUtils.isEmpty(next.getValue())) {
                            Iterator<Map.Entry<String, String>> it2 = it;
                            c0444i4.f668b.f764D.debug(11, "http headers key:" + next.getKey() + " value:" + next.getValue(), new Object[0]);
                            it = it2;
                        }
                    }
                } catch (Throwable th5) {
                    c0444i4.f668b.m522b().mo639a(th5, "httpRequestInner header");
                }
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long currentTimeMillis = System.currentTimeMillis();
            String uuid = UUID.randomUUID().toString();
            byte[] bArr8 = new byte[0];
            try {
                url = new URL(str);
                httpURLConnection = (HttpURLConnection) url.openConnection();
                try {
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Throwable th7) {
                th = th7;
                bArr = bArr8;
                str2 = "httpRequestInner";
                str3 = "Send request failed";
                str4 = "Request timeout";
                i2 = 11;
                httpURLConnection = null;
            }
            try {
                if ((httpURLConnection instanceof HttpsURLConnection) && initConfig != null) {
                    try {
                        sslSocketFactory = initConfig.getSslSocketFactory();
                    } catch (Throwable th8) {
                        th = th8;
                        bArr = bArr8;
                        str2 = "httpRequestInner";
                        str3 = "Send request failed";
                        str4 = "Request timeout";
                        i2 = 11;
                        httpURLConnection2 = httpURLConnection;
                        dataOutputStream = null;
                        inputStream = null;
                        bufferedReader = null;
                        c0444i4.f668b.f764D.error(i2, str3, th, new Object[0]);
                        c0444i4.f668b.m522b().mo639a(th, str2);
                        if (th instanceof RangersHttpException) {
                        }
                    }
                    if (sslSocketFactory != null) {
                        ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sslSocketFactory);
                        str5 = "UTF-8";
                        bArr2 = bArr8;
                        str6 = "httpRequestInner";
                        z2 = true;
                        try {
                        } catch (Throwable th9) {
                            th = th9;
                            str3 = "Send request failed";
                            str4 = "Request timeout";
                            str2 = str6;
                            bArr = bArr2;
                            i2 = 11;
                            httpURLConnection2 = httpURLConnection;
                            dataOutputStream = null;
                            inputStream = null;
                            bufferedReader = null;
                            c0444i4.f668b.f764D.error(i2, str3, th, new Object[0]);
                            c0444i4.f668b.m522b().mo639a(th, str2);
                            if (th instanceof RangersHttpException) {
                            }
                        }
                        try {
                            c0444i4.f668b.f764D.debug(11, "use sslSocketFactory: {}", sslSocketFactory);
                            if (i > 0) {
                                httpURLConnection.setConnectTimeout(i);
                                httpURLConnection.setReadTimeout(i);
                            }
                            boolean z3 = z2;
                            if (b != 0) {
                                httpURLConnection.setDoOutput(false);
                                httpURLConnection.setRequestMethod(OpenNetMethod.GET);
                            } else if (b != z3) {
                                str3 = "Send request failed";
                                str4 = "Request timeout";
                                str2 = str6;
                                bArr = bArr2;
                                i2 = 11;
                                try {
                                    c0444i4.f668b.f764D.warn(11, "Unknown method", new Object[0]);
                                    C0411e.m356a((Closeable) null);
                                    C0411e.m356a((Closeable) null);
                                    C0411e.m356a((Closeable) null);
                                    C0411e.m356a((Closeable) null);
                                    return null;
                                } catch (Throwable th10) {
                                    th = th10;
                                    httpURLConnection = httpURLConnection;
                                    httpURLConnection2 = httpURLConnection;
                                    dataOutputStream = null;
                                    inputStream = null;
                                    bufferedReader = null;
                                    c0444i4.f668b.f764D.error(i2, str3, th, new Object[0]);
                                    c0444i4.f668b.m522b().mo639a(th, str2);
                                    if (th instanceof RangersHttpException) {
                                    }
                                }
                            } else {
                                try {
                                    httpURLConnection.setDoOutput(z3);
                                    httpURLConnection.setRequestMethod(OpenNetMethod.POST);
                                } catch (Throwable th11) {
                                    th = th11;
                                    str3 = "Send request failed";
                                    str4 = "Request timeout";
                                    str2 = str6;
                                    bArr = bArr2;
                                    i2 = 11;
                                    httpURLConnection2 = httpURLConnection;
                                    dataOutputStream = null;
                                    inputStream = null;
                                    bufferedReader = null;
                                    c0444i4.f668b.f764D.error(i2, str3, th, new Object[0]);
                                    c0444i4.f668b.m522b().mo639a(th, str2);
                                    if (th instanceof RangersHttpException) {
                                    }
                                }
                            }
                            if (map != null && !map.isEmpty()) {
                                for (Map.Entry<String, String> entry : map.entrySet()) {
                                    if (TextUtils.isEmpty(entry.getKey()) || TextUtils.isEmpty(entry.getValue())) {
                                        try {
                                            c0444i4.f668b.f764D.error(11, "Header key is empty", new Object[0]);
                                        } catch (Throwable th12) {
                                            th = th12;
                                            i2 = 11;
                                            str3 = "Send request failed";
                                            str4 = "Request timeout";
                                            str2 = str6;
                                            bArr = bArr2;
                                            httpURLConnection2 = httpURLConnection;
                                            dataOutputStream = null;
                                            inputStream = null;
                                            bufferedReader = null;
                                            c0444i4.f668b.f764D.error(i2, str3, th, new Object[0]);
                                            c0444i4.f668b.m522b().mo639a(th, str2);
                                            if (th instanceof RangersHttpException) {
                                            }
                                        }
                                    } else {
                                        httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
                                    }
                                }
                            }
                            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
                            if (LogUtils.isDisabled()) {
                                try {
                                    str4 = "Request timeout";
                                    httpURLConnection3 = httpURLConnection;
                                    str7 = str5;
                                    bArr = bArr2;
                                    str3 = "Send request failed";
                                    str2 = str6;
                                    str8 = XBridgeAPIRequestUtils.X_TT_LOG_ID;
                                    i3 = z3 ? 1 : 0;
                                } catch (Throwable th13) {
                                    th = th13;
                                    str3 = "Send request failed";
                                    str4 = "Request timeout";
                                    str2 = str6;
                                    bArr = bArr2;
                                    i2 = 11;
                                    httpURLConnection2 = httpURLConnection;
                                    dataOutputStream = null;
                                    inputStream = null;
                                    bufferedReader = null;
                                    c0444i4.f668b.f764D.error(i2, str3, th, new Object[0]);
                                    c0444i4.f668b.m522b().mo639a(th, str2);
                                    if (th instanceof RangersHttpException) {
                                    }
                                }
                                try {
                                    LogUtils.sendJsonFetcher("do_request_begin", new C0451j4(c0444i4, httpURLConnection, uuid, str, jSONObject, b, currentTimeMillis));
                                } catch (Throwable th14) {
                                    th = th14;
                                    httpURLConnection = httpURLConnection3;
                                    i2 = 11;
                                    httpURLConnection2 = httpURLConnection;
                                    dataOutputStream = null;
                                    inputStream = null;
                                    bufferedReader = null;
                                    c0444i4.f668b.f764D.error(i2, str3, th, new Object[0]);
                                    c0444i4.f668b.m522b().mo639a(th, str2);
                                    if (th instanceof RangersHttpException) {
                                    }
                                }
                            } else {
                                httpURLConnection3 = httpURLConnection;
                                str3 = "Send request failed";
                                str4 = "Request timeout";
                                str2 = str6;
                                str7 = str5;
                                bArr = bArr2;
                                str8 = XBridgeAPIRequestUtils.X_TT_LOG_ID;
                                i3 = z3 ? 1 : 0;
                            }
                            if (jSONObject == null) {
                                String jSONObject3 = jSONObject.toString();
                                bArr3 = z ? c0444i4.f669c.m586b(jSONObject3) : jSONObject3.getBytes(str7);
                            } else {
                                bArr3 = null;
                            }
                            if (bArr3 != null || bArr3.length <= 0) {
                                dataOutputStream = null;
                            } else {
                                dataOutputStream2 = new DataOutputStream(httpURLConnection3.getOutputStream());
                                try {
                                    dataOutputStream2.write(bArr3);
                                    dataOutputStream2.flush();
                                    dataOutputStream = dataOutputStream2;
                                } catch (Throwable th15) {
                                    th = th15;
                                    httpURLConnection4 = httpURLConnection3;
                                    i2 = 11;
                                }
                            }
                            responseCode = httpURLConnection3.getResponseCode();
                            long currentTimeMillis2 = System.currentTimeMillis();
                            IAppLogLogger iAppLogLogger2 = c0444i4.f668b.f764D;
                            Object[] objArr2 = new Object[2];
                            objArr2[0] = Integer.valueOf(responseCode);
                            objArr2[i3] = httpURLConnection3.getResponseMessage();
                            i2 = 11;
                            iAppLogLogger2.debug(11, "http response:{} message:{}", objArr2);
                            C0547x2.m747a(c0444i4.f668b.getMonitor(), url, elapsedRealtime, responseCode, httpURLConnection3.getResponseMessage());
                            if (responseCode == 200) {
                                httpURLConnection4 = httpURLConnection3;
                                try {
                                    c0444i4.m468a(uuid, responseCode, null, httpURLConnection4.getResponseMessage(), currentTimeMillis2, httpURLConnection4);
                                    throw new RangersHttpException(responseCode, httpURLConnection4.getResponseMessage());
                                } catch (Throwable th16) {
                                    th = th16;
                                }
                            } else if (b2 == 0) {
                                InputStream inputStream2 = httpURLConnection3.getInputStream();
                                BufferedReader bufferedReader2 = "gzip".equalsIgnoreCase(httpURLConnection3.getContentEncoding()) ? new BufferedReader(new InputStreamReader(new GZIPInputStream(inputStream2))) : new BufferedReader(new InputStreamReader(inputStream2));
                                try {
                                    StringBuilder sb = new StringBuilder(inputStream2.available());
                                    while (true) {
                                        String readLine = bufferedReader2.readLine();
                                        if (readLine == null) {
                                            break;
                                        }
                                        sb.append(readLine).append("\n");
                                    }
                                    IAppLogLogger iAppLogLogger3 = c0444i4.f668b.f764D;
                                    Object[] objArr3 = new Object[i3];
                                    objArr3[0] = sb.toString();
                                    iAppLogLogger3.debug(11, "http responseBody: {}", objArr3);
                                    JSONObject jSONObject4 = new JSONObject(sb.toString());
                                    Map<String, List<String>> headerFields = httpURLConnection3.getHeaderFields();
                                    StringBuilder sb2 = new StringBuilder();
                                    if (headerFields != null && headerFields.containsKey("Set-Cookie") && (list = headerFields.get("Set-Cookie")) != null) {
                                        Iterator<String> it3 = list.iterator();
                                        while (it3.hasNext()) {
                                            sb2.append(it3.next()).append(";");
                                        }
                                    }
                                    jSONObject4.put("Set-Cookie", sb2.toString());
                                    httpURLConnection2 = httpURLConnection3;
                                    try {
                                        String str9 = str8;
                                        String optString = c0444i4.m467a(httpURLConnection2).optString(str9);
                                        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(str) && str.contains(UriConfig.PATH_REGISTER) && !C0421f2.m399e(jSONObject4)) {
                                            try {
                                                jSONObject4.put(str9, optString);
                                            } catch (JSONException e) {
                                                c0444i4.f668b.f764D.error("parseResponseLogId failed", e, new Object[0]);
                                                c0444i4.f668b.m522b().mo639a(e, "parseResponseLogId");
                                            }
                                        }
                                        bArr4 = jSONObject4.toString().getBytes(str7);
                                        bufferedReader = bufferedReader2;
                                        inputStream = null;
                                        httpURLConnection4 = httpURLConnection2;
                                        try {
                                            c0444i4.m468a(uuid, responseCode, bArr4, null, currentTimeMillis2, httpURLConnection2);
                                            C0411e.m356a((Closeable) dataOutputStream);
                                            C0411e.m356a((Closeable) bufferedReader);
                                            C0411e.m356a((Closeable) inputStream);
                                            C0411e.m356a((Closeable) byteArrayOutputStream2);
                                            return bArr4;
                                        } catch (Throwable th17) {
                                            th = th17;
                                            bArr = bArr4;
                                        }
                                    } catch (Throwable th18) {
                                        th = th18;
                                        bufferedReader = bufferedReader2;
                                        inputStream = null;
                                        c0444i4.f668b.f764D.error(i2, str3, th, new Object[0]);
                                        c0444i4.f668b.m522b().mo639a(th, str2);
                                        if (th instanceof RangersHttpException) {
                                        }
                                    }
                                } catch (Throwable th19) {
                                    th = th19;
                                    httpURLConnection2 = httpURLConnection3;
                                }
                            } else {
                                httpURLConnection2 = httpURLConnection3;
                                try {
                                    InputStream inputStream3 = httpURLConnection2.getInputStream();
                                    gZIPInputStream = "gzip".equalsIgnoreCase(httpURLConnection2.getContentEncoding()) ? new GZIPInputStream(inputStream3) : inputStream3;
                                    try {
                                        byteArrayOutputStream = new ByteArrayOutputStream();
                                        try {
                                            byte[] bArr9 = new byte[1024];
                                            while (true) {
                                                int read = gZIPInputStream.read(bArr9);
                                                if (read == -1) {
                                                    break;
                                                }
                                                byteArrayOutputStream.write(bArr9, 0, read);
                                            }
                                            byteArray = byteArrayOutputStream.toByteArray();
                                        } catch (Throwable th20) {
                                            th = th20;
                                            httpURLConnection5 = httpURLConnection2;
                                            inputStream = gZIPInputStream;
                                        }
                                    } catch (Throwable th21) {
                                        th = th21;
                                        httpURLConnection4 = httpURLConnection2;
                                        inputStream = gZIPInputStream;
                                        bufferedReader = null;
                                    }
                                } catch (Throwable th22) {
                                    th = th22;
                                    httpURLConnection4 = httpURLConnection2;
                                }
                                try {
                                    IAppLogLogger iAppLogLogger4 = c0444i4.f668b.f764D;
                                    Object[] objArr4 = new Object[i3];
                                    objArr4[0] = Integer.valueOf(byteArray.length);
                                    iAppLogLogger4.debug(11, "http responseBody byte length: {}", objArr4);
                                    inputStream = gZIPInputStream;
                                    bArr4 = byteArray;
                                    bufferedReader = null;
                                    byteArrayOutputStream2 = byteArrayOutputStream;
                                    httpURLConnection4 = httpURLConnection2;
                                    c0444i4.m468a(uuid, responseCode, bArr4, null, currentTimeMillis2, httpURLConnection2);
                                    C0411e.m356a((Closeable) dataOutputStream);
                                    C0411e.m356a((Closeable) bufferedReader);
                                    C0411e.m356a((Closeable) inputStream);
                                    C0411e.m356a((Closeable) byteArrayOutputStream2);
                                    return bArr4;
                                } catch (Throwable th23) {
                                    th = th23;
                                    httpURLConnection5 = httpURLConnection2;
                                    inputStream = gZIPInputStream;
                                    bArr = byteArray;
                                    bufferedReader = null;
                                    httpURLConnection2 = httpURLConnection5;
                                    byteArrayOutputStream2 = byteArrayOutputStream;
                                    c0444i4.f668b.f764D.error(i2, str3, th, new Object[0]);
                                    c0444i4.f668b.m522b().mo639a(th, str2);
                                    if (th instanceof RangersHttpException) {
                                    }
                                }
                            }
                            dataOutputStream2 = dataOutputStream;
                            dataOutputStream = dataOutputStream2;
                            inputStream = null;
                            bufferedReader = null;
                            httpURLConnection2 = httpURLConnection4;
                        } catch (Throwable th24) {
                            th = th24;
                            i2 = 11;
                            str3 = "Send request failed";
                            str4 = "Request timeout";
                            str2 = str6;
                            bArr = bArr2;
                            httpURLConnection2 = httpURLConnection;
                            dataOutputStream = null;
                            inputStream = null;
                            bufferedReader = null;
                            c0444i4.f668b.f764D.error(i2, str3, th, new Object[0]);
                            c0444i4.f668b.m522b().mo639a(th, str2);
                            if (th instanceof RangersHttpException) {
                            }
                        }
                        c0444i4.f668b.f764D.error(i2, str3, th, new Object[0]);
                        c0444i4.f668b.m522b().mo639a(th, str2);
                        if (th instanceof RangersHttpException) {
                            throw th;
                        }
                        c0444i4.m468a(uuid, -1, null, th.getMessage(), System.currentTimeMillis(), httpURLConnection2);
                        if (th instanceof SocketTimeoutException) {
                            throw new RangersHttpTimeoutException(str4);
                        }
                        C0411e.m356a((Closeable) dataOutputStream);
                        C0411e.m356a((Closeable) bufferedReader);
                        C0411e.m356a((Closeable) inputStream);
                        C0411e.m356a((Closeable) byteArrayOutputStream2);
                        return bArr;
                    }
                }
                c0444i4.f668b.f764D.error(i2, str3, th, new Object[0]);
                c0444i4.f668b.m522b().mo639a(th, str2);
                if (th instanceof RangersHttpException) {
                }
            } catch (Throwable th25) {
                C0411e.m356a((Closeable) dataOutputStream);
                C0411e.m356a((Closeable) bufferedReader);
                C0411e.m356a((Closeable) inputStream);
                C0411e.m356a((Closeable) byteArrayOutputStream2);
                throw th25;
            }
            str5 = "UTF-8";
            bArr2 = bArr8;
            str6 = "httpRequestInner";
            z2 = true;
            if (i > 0) {
            }
            boolean z32 = z2;
            if (b != 0) {
            }
            if (map != null) {
                while (r1.hasNext()) {
                }
            }
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
            if (LogUtils.isDisabled()) {
            }
            if (jSONObject == null) {
            }
            if (bArr3 != null) {
            }
            dataOutputStream = null;
            responseCode = httpURLConnection3.getResponseCode();
            long currentTimeMillis22 = System.currentTimeMillis();
            IAppLogLogger iAppLogLogger22 = c0444i4.f668b.f764D;
            Object[] objArr22 = new Object[2];
            objArr22[0] = Integer.valueOf(responseCode);
            objArr22[i3] = httpURLConnection3.getResponseMessage();
            i2 = 11;
            iAppLogLogger22.debug(11, "http response:{} message:{}", objArr22);
            C0547x2.m747a(c0444i4.f668b.getMonitor(), url, elapsedRealtime, responseCode, httpURLConnection3.getResponseMessage());
            if (responseCode == 200) {
            }
            dataOutputStream2 = dataOutputStream;
            dataOutputStream = dataOutputStream2;
            inputStream = null;
            bufferedReader = null;
            httpURLConnection2 = httpURLConnection4;
        }
    }
}
