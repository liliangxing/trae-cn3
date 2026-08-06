package com.cmic.sso.sdk.p003c.p004a;

import android.text.TextUtils;
import com.bytedance.webx.event.EventManager;
import com.cmic.sso.sdk.C0088a;
import com.cmic.sso.sdk.C0104b;
import com.cmic.sso.sdk.p003c.C0120c;
import com.cmic.sso.sdk.p003c.C0125d;
import com.cmic.sso.sdk.p003c.p005b.AbstractC0118g;
import com.cmic.sso.sdk.p003c.p005b.C0116e;
import com.cmic.sso.sdk.p003c.p005b.C0119h;
import com.cmic.sso.sdk.p003c.p006c.C0122b;
import com.cmic.sso.sdk.p003c.p006c.C0123c;
import com.cmic.sso.sdk.p003c.p007d.C0126a;
import com.cmic.sso.sdk.p003c.p007d.C0127b;
import com.cmic.sso.sdk.p003c.p007d.InterfaceC0128c;
import com.cmic.sso.sdk.p009e.C0133c;
import com.lynx.tasm.animation.AnimationConstant;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: ConnectionInterceptor.java */
/* renamed from: com.cmic.sso.sdk.c.a.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0107a implements InterfaceC0108b {

    /* renamed from: a */
    private static C0120c f169a;

    /* JADX WARN: Can't wrap try/catch for region: R(33:1|(2:2|3)|(2:135|(29:137|8|(1:10)(1:134)|11|12|(3:14|(5:17|18|19|20|15)|72)|74|(1:(1:81)(1:82))|83|(1:85)|86|87|(3:89|90|91)(1:129)|92|93|94|95|96|97|(2:98|(1:100)(1:101))|102|103|(1:105)|106|(1:108)(1:117)|109|(2:115|116)|46|47))|7|8|(0)(0)|11|12|(0)|74|(2:76|(0)(0))|83|(0)|86|87|(0)(0)|92|93|94|95|96|97|(3:98|(0)(0)|100)|102|103|(0)|106|(0)(0)|109|(1:111)|115|116|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x01c9, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x01cf, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x01d0, code lost:
    
        r13 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x01cb, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x01cc, code lost:
    
        r13 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x01df, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x01e0, code lost:
    
        r18 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x01da, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x01db, code lost:
    
        r18 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x021f, code lost:
    
        r2 = 200050;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x024c, code lost:
    
        r12.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x026a, code lost:
    
        r6 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x026d, code lost:
    
        r6 = r10.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0223, code lost:
    
        r2 = 102102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x029e, code lost:
    
        r12.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x02bc, code lost:
    
        r6 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x02da, code lost:
    
        r21.mo187a(com.cmic.sso.sdk.p003c.p007d.C0126a.m277a(r15));
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x02bf, code lost:
    
        r6 = r10.toString();
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0163 A[Catch: Exception -> 0x01c9, all -> 0x0295, LOOP:1: B:98:0x015d->B:100:0x0163, LOOP_END, TryCatch #5 {all -> 0x0295, blocks: (B:24:0x01f4, B:27:0x0226, B:29:0x022b, B:31:0x0233, B:33:0x023b, B:97:0x015b, B:98:0x015d, B:100:0x0163, B:102:0x0171), top: B:2:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0171 A[EDGE_INSN: B:101:0x0171->B:102:0x0171 BREAK  A[LOOP:1: B:98:0x015d->B:100:0x0163], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0066 A[Catch: all -> 0x01e4, Exception -> 0x01ed, TryCatch #9 {Exception -> 0x01ed, all -> 0x01e4, blocks: (B:3:0x0031, B:5:0x0046, B:8:0x0060, B:10:0x0066, B:134:0x0077, B:135:0x004a, B:137:0x0054), top: B:2:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0077 A[Catch: all -> 0x01e4, Exception -> 0x01ed, TRY_LEAVE, TryCatch #9 {Exception -> 0x01ed, all -> 0x01e4, blocks: (B:3:0x0031, B:5:0x0046, B:8:0x0060, B:10:0x0066, B:134:0x0077, B:135:0x004a, B:137:0x0054), top: B:2:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0089 A[Catch: all -> 0x01da, Exception -> 0x01df, TryCatch #11 {Exception -> 0x01df, all -> 0x01da, blocks: (B:12:0x0083, B:14:0x0089, B:15:0x0091, B:17:0x0097), top: B:11:0x0083 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x022b A[Catch: all -> 0x0295, TryCatch #5 {all -> 0x0295, blocks: (B:24:0x01f4, B:27:0x0226, B:29:0x022b, B:31:0x0233, B:33:0x023b, B:97:0x015b, B:98:0x015d, B:100:0x0163, B:102:0x0171), top: B:2:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00bf A[Catch: all -> 0x01d6, Exception -> 0x01d8, TryCatch #8 {Exception -> 0x01d8, all -> 0x01d6, blocks: (B:20:0x00a5, B:74:0x00af, B:76:0x00b5, B:78:0x00b9, B:81:0x00bf, B:82:0x00fd, B:83:0x0107, B:85:0x0129, B:86:0x0132, B:89:0x013d), top: B:19:0x00a5 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00fd A[Catch: all -> 0x01d6, Exception -> 0x01d8, TryCatch #8 {Exception -> 0x01d8, all -> 0x01d6, blocks: (B:20:0x00a5, B:74:0x00af, B:76:0x00b5, B:78:0x00b9, B:81:0x00bf, B:82:0x00fd, B:83:0x0107, B:85:0x0129, B:86:0x0132, B:89:0x013d), top: B:19:0x00a5 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0129 A[Catch: all -> 0x01d6, Exception -> 0x01d8, TryCatch #8 {Exception -> 0x01d8, all -> 0x01d6, blocks: (B:20:0x00a5, B:74:0x00af, B:76:0x00b5, B:78:0x00b9, B:81:0x00bf, B:82:0x00fd, B:83:0x0107, B:85:0x0129, B:86:0x0132, B:89:0x013d), top: B:19:0x00a5 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x013d A[Catch: all -> 0x01d6, Exception -> 0x01d8, TRY_ENTER, TRY_LEAVE, TryCatch #8 {Exception -> 0x01d8, all -> 0x01d6, blocks: (B:20:0x00a5, B:74:0x00af, B:76:0x00b5, B:78:0x00b9, B:81:0x00bf, B:82:0x00fd, B:83:0x0107, B:85:0x0129, B:86:0x0132, B:89:0x013d), top: B:19:0x00a5 }] */
    @Override // com.cmic.sso.sdk.p003c.p004a.InterfaceC0108b
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mo183a(C0123c c0123c, InterfaceC0128c interfaceC0128c, C0088a c0088a) {
        String str;
        OutputStream outputStream;
        HttpURLConnection httpURLConnection;
        int i;
        String sb;
        InputStream inputStream;
        int i2;
        String sb2;
        String m262a;
        URL url;
        final String host;
        AbstractC0118g m276k;
        boolean z;
        Map<String, String> m268c;
        String m270e;
        byte[] bArr;
        int read;
        String str2 = "";
        C0133c.m328b("ConnectionInterceptor", "请求地址: " + c0123c.m262a());
        StringBuilder sb3 = new StringBuilder();
        try {
            try {
                m262a = c0123c.m262a();
                url = new URL(m262a);
                host = url.getHost();
                m276k = c0123c.m276k();
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
            str = "";
            outputStream = null;
            httpURLConnection = null;
        } catch (Throwable th2) {
            th = th2;
            str = "";
            outputStream = null;
            httpURLConnection = null;
        }
        if ((m276k instanceof C0119h) || (m276k instanceof C0116e)) {
            String m67b = c0088a.m67b("remote_ip");
            if (!TextUtils.isEmpty(m67b)) {
                url = new URL(m262a.replaceFirst(host, m67b));
                z = true;
                if (c0123c.m273h() == null) {
                    C0133c.m328b("ConnectionInterceptor", "开始wifi下取号");
                    httpURLConnection = (HttpURLConnection) c0123c.m273h().openConnection(url);
                } else {
                    C0133c.m328b("ConnectionInterceptor", "使用当前网络环境发送请求");
                    httpURLConnection = (HttpURLConnection) url.openConnection();
                }
                m268c = c0123c.m268c();
                if (m268c != null) {
                    for (String str3 : m268c.keySet()) {
                        str = str2;
                        try {
                            httpURLConnection.addRequestProperty(str3, m268c.get(str3));
                            str2 = str;
                        } catch (Exception e2) {
                            e = e2;
                            outputStream = null;
                            inputStream = null;
                            e.printStackTrace();
                            C0133c.m326a("ConnectionInterceptor", "请求失败: " + c0123c.m262a());
                            c0088a.m55a().f278a.add(e);
                            if (e instanceof EOFException) {
                            }
                            i = i2;
                            if (e instanceof UnknownHostException) {
                            }
                            m181a(outputStream);
                            m181a(inputStream);
                            if (httpURLConnection != null) {
                            }
                            C0133c.m328b("ConnectionInterceptor", "responseCode: " + i);
                            StringBuilder sb4 = new StringBuilder("responseResult: ");
                            if (TextUtils.isEmpty(sb3)) {
                            }
                            C0133c.m328b("ConnectionInterceptor", sb4.append(sb2).toString());
                            if (i != 200) {
                            }
                            interfaceC0128c.mo188a((C0127b) null);
                            return;
                        } catch (Throwable th3) {
                            th = th3;
                            outputStream = null;
                            Closeable closeable = null;
                            i = -1;
                            m181a(outputStream);
                            m181a(closeable);
                            if (httpURLConnection != null) {
                            }
                            C0133c.m328b("ConnectionInterceptor", "responseCode: " + i);
                            StringBuilder sb5 = new StringBuilder("responseResult: ");
                            if (TextUtils.isEmpty(sb3)) {
                            }
                            C0133c.m328b("ConnectionInterceptor", sb5.append(sb).toString());
                            if (i != 200) {
                            }
                            interfaceC0128c.mo188a((C0127b) null);
                            throw th;
                        }
                    }
                }
                str = str2;
                if ((httpURLConnection instanceof HttpsURLConnection) && ((m276k instanceof C0119h) || (m276k instanceof C0116e))) {
                    if (!z) {
                        C0133c.m328b("ConnectionInterceptor", "host = " + host);
                        httpURLConnection.setRequestProperty("Host", host);
                        C0133c.m328b("ConnectionInterceptor", "need sni handle");
                        ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(new C0125d((HttpsURLConnection) httpURLConnection, c0123c.m273h(), c0088a));
                        ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(new HostnameVerifier() { // from class: com.cmic.sso.sdk.c.a.a.1
                            @Override // javax.net.ssl.HostnameVerifier
                            public boolean verify(String str4, SSLSession sSLSession) {
                                return HttpsURLConnection.getDefaultHostnameVerifier().verify(host, sSLSession);
                            }
                        });
                    } else {
                        ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(m182a(m276k, c0088a));
                    }
                }
                httpURLConnection.setDoInput(true);
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.setConnectTimeout(EventManager.REGION_IN_OUT_ADJUST);
                httpURLConnection.setReadTimeout(EventManager.REGION_IN_OUT_ADJUST);
                httpURLConnection.setDefaultUseCaches(false);
                m270e = c0123c.m270e();
                httpURLConnection.setRequestMethod(m270e);
                httpURLConnection.setDoOutput(true);
                if (c0123c instanceof C0122b) {
                    httpURLConnection.connect();
                    ((C0122b) c0123c).m260a(c0088a);
                }
                if (m270e.endsWith("POST")) {
                    outputStream = null;
                } else {
                    outputStream = httpURLConnection.getOutputStream();
                    try {
                        outputStream.write(c0123c.m269d().getBytes("utf-8"));
                        outputStream.flush();
                    } catch (Exception e3) {
                        e = e3;
                        inputStream = null;
                        e.printStackTrace();
                        C0133c.m326a("ConnectionInterceptor", "请求失败: " + c0123c.m262a());
                        c0088a.m55a().f278a.add(e);
                        if (e instanceof EOFException) {
                        }
                        i = i2;
                        if (e instanceof UnknownHostException) {
                            c0088a.m60a("remote_ip", m180a());
                        }
                        m181a(outputStream);
                        m181a(inputStream);
                        if (httpURLConnection != null) {
                        }
                        C0133c.m328b("ConnectionInterceptor", "responseCode: " + i);
                        StringBuilder sb42 = new StringBuilder("responseResult: ");
                        if (TextUtils.isEmpty(sb3)) {
                        }
                        C0133c.m328b("ConnectionInterceptor", sb42.append(sb2).toString());
                        if (i != 200) {
                        }
                        interfaceC0128c.mo188a((C0127b) null);
                        return;
                    } catch (Throwable th4) {
                        th = th4;
                        Closeable closeable2 = null;
                        i = -1;
                        m181a(outputStream);
                        m181a(closeable2);
                        if (httpURLConnection != null) {
                        }
                        C0133c.m328b("ConnectionInterceptor", "responseCode: " + i);
                        StringBuilder sb52 = new StringBuilder("responseResult: ");
                        if (TextUtils.isEmpty(sb3)) {
                        }
                        C0133c.m328b("ConnectionInterceptor", sb52.append(sb).toString());
                        if (i != 200) {
                        }
                        interfaceC0128c.mo188a((C0127b) null);
                        throw th;
                    }
                }
                i = httpURLConnection.getResponseCode();
                inputStream = httpURLConnection.getInputStream();
                bArr = new byte[AnimationConstant.PROP_BOTTOM];
                while (true) {
                    read = inputStream.read(bArr);
                    if (read > 0) {
                        break;
                    } else {
                        sb3.append(new String(bArr, 0, read, "utf-8"));
                    }
                }
                C0127b c0127b = new C0127b(i, httpURLConnection.getHeaderFields(), sb3.toString());
                m181a(outputStream);
                m181a(inputStream);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                C0133c.m328b("ConnectionInterceptor", "responseCode: " + i);
                C0133c.m328b("ConnectionInterceptor", "responseResult: " + (!TextUtils.isEmpty(sb3) ? str : sb3.toString()));
                if (i != 200 || i == 301 || i == 302) {
                    interfaceC0128c.mo188a(c0127b);
                }
                interfaceC0128c.mo187a(C0126a.m277a(i));
                return;
            }
        }
        z = false;
        if (c0123c.m273h() == null) {
        }
        m268c = c0123c.m268c();
        if (m268c != null) {
        }
        str = str2;
        if (httpURLConnection instanceof HttpsURLConnection) {
            if (!z) {
            }
        }
        httpURLConnection.setDoInput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setConnectTimeout(EventManager.REGION_IN_OUT_ADJUST);
        httpURLConnection.setReadTimeout(EventManager.REGION_IN_OUT_ADJUST);
        httpURLConnection.setDefaultUseCaches(false);
        m270e = c0123c.m270e();
        httpURLConnection.setRequestMethod(m270e);
        httpURLConnection.setDoOutput(true);
        if (c0123c instanceof C0122b) {
        }
        if (m270e.endsWith("POST")) {
        }
        i = httpURLConnection.getResponseCode();
        inputStream = httpURLConnection.getInputStream();
        bArr = new byte[AnimationConstant.PROP_BOTTOM];
        while (true) {
            read = inputStream.read(bArr);
            if (read > 0) {
            }
            sb3.append(new String(bArr, 0, read, "utf-8"));
        }
        C0127b c0127b2 = new C0127b(i, httpURLConnection.getHeaderFields(), sb3.toString());
        m181a(outputStream);
        m181a(inputStream);
        if (httpURLConnection != null) {
        }
        C0133c.m328b("ConnectionInterceptor", "responseCode: " + i);
        C0133c.m328b("ConnectionInterceptor", "responseResult: " + (!TextUtils.isEmpty(sb3) ? str : sb3.toString()));
        if (i != 200) {
        }
        interfaceC0128c.mo188a(c0127b2);
    }

    /* renamed from: a */
    private void m181a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private String m180a() {
        return C0104b.f161a[0] + "." + C0104b.f161a[2] + "." + C0104b.f161a[4] + "." + C0104b.f161a[6];
    }

    /* renamed from: a */
    public synchronized SSLSocketFactory m182a(AbstractC0118g abstractC0118g, C0088a c0088a) {
        if (abstractC0118g instanceof C0116e) {
            C0120c c0120c = new C0120c(HttpsURLConnection.getDefaultSSLSocketFactory(), c0088a);
            if (f169a == null) {
                f169a = c0120c;
            }
            return c0120c;
        }
        if (f169a == null) {
            f169a = new C0120c(HttpsURLConnection.getDefaultSSLSocketFactory(), c0088a);
        }
        return f169a;
    }
}
