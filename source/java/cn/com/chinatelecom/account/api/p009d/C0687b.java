package cn.com.chinatelecom.account.api.p009d;

import android.content.Context;
import android.text.TextUtils;
import cn.com.chinatelecom.account.api.CtAuth;
import cn.com.chinatelecom.account.api.p006a.C0678d;
import cn.com.chinatelecom.account.api.p010e.C0694a;
import cn.com.chinatelecom.account.api.p010e.C0699f;
import cn.com.chinatelecom.account.api.p010e.C0700g;
import cn.com.chinatelecom.account.api.p010e.C0703j;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;

/* renamed from: cn.com.chinatelecom.account.api.d.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class C0687b extends AbstractC0691f {

    /* renamed from: b */
    private static final String f210b = "b";

    public C0687b(Context context) {
        super(context);
    }

    @Override // cn.com.chinatelecom.account.api.p009d.InterfaceC0690e
    /* renamed from: a */
    public C0693h mo239a(String str, String str2, int i, C0692g c0692g) {
        return m252a(str) ? m240b(str, str2, i, c0692g) : m241c(str, str2, i, c0692g);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x03cc A[Catch: IOException -> 0x0183, TRY_ENTER, TryCatch #14 {IOException -> 0x0183, blocks: (B:32:0x017f, B:34:0x0187, B:79:0x0220, B:81:0x0225, B:67:0x02b0, B:69:0x02b5, B:56:0x033d, B:58:0x0342, B:45:0x03cc, B:47:0x03d1), top: B:2:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x03d1 A[Catch: IOException -> 0x0183, TRY_LEAVE, TryCatch #14 {IOException -> 0x0183, blocks: (B:32:0x017f, B:34:0x0187, B:79:0x0220, B:81:0x0225, B:67:0x02b0, B:69:0x02b5, B:56:0x033d, B:58:0x0342, B:45:0x03cc, B:47:0x03d1), top: B:2:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x033d A[Catch: IOException -> 0x0183, TRY_ENTER, TryCatch #14 {IOException -> 0x0183, blocks: (B:32:0x017f, B:34:0x0187, B:79:0x0220, B:81:0x0225, B:67:0x02b0, B:69:0x02b5, B:56:0x033d, B:58:0x0342, B:45:0x03cc, B:47:0x03d1), top: B:2:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0342 A[Catch: IOException -> 0x0183, TRY_LEAVE, TryCatch #14 {IOException -> 0x0183, blocks: (B:32:0x017f, B:34:0x0187, B:79:0x0220, B:81:0x0225, B:67:0x02b0, B:69:0x02b5, B:56:0x033d, B:58:0x0342, B:45:0x03cc, B:47:0x03d1), top: B:2:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x02b0 A[Catch: IOException -> 0x0183, TRY_ENTER, TryCatch #14 {IOException -> 0x0183, blocks: (B:32:0x017f, B:34:0x0187, B:79:0x0220, B:81:0x0225, B:67:0x02b0, B:69:0x02b5, B:56:0x033d, B:58:0x0342, B:45:0x03cc, B:47:0x03d1), top: B:2:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02b5 A[Catch: IOException -> 0x0183, TRY_LEAVE, TryCatch #14 {IOException -> 0x0183, blocks: (B:32:0x017f, B:34:0x0187, B:79:0x0220, B:81:0x0225, B:67:0x02b0, B:69:0x02b5, B:56:0x033d, B:58:0x0342, B:45:0x03cc, B:47:0x03d1), top: B:2:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0220 A[Catch: IOException -> 0x0183, TRY_ENTER, TryCatch #14 {IOException -> 0x0183, blocks: (B:32:0x017f, B:34:0x0187, B:79:0x0220, B:81:0x0225, B:67:0x02b0, B:69:0x02b5, B:56:0x033d, B:58:0x0342, B:45:0x03cc, B:47:0x03d1), top: B:2:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0225 A[Catch: IOException -> 0x0183, TRY_LEAVE, TryCatch #14 {IOException -> 0x0183, blocks: (B:32:0x017f, B:34:0x0187, B:79:0x0220, B:81:0x0225, B:67:0x02b0, B:69:0x02b5, B:56:0x033d, B:58:0x0342, B:45:0x03cc, B:47:0x03d1), top: B:2:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x03e2 A[Catch: IOException -> 0x03de, TRY_LEAVE, TryCatch #17 {IOException -> 0x03de, blocks: (B:93:0x03da, B:86:0x03e2), top: B:92:0x03da }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x03da A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C0693h m240b(String str, String str2, int i, C0692g c0692g) {
        BufferedReader bufferedReader;
        boolean z;
        InputStream inputStream;
        C0693h c0693h = new C0693h();
        ?? r5 = 0;
        r5 = null;
        r5 = null;
        r5 = null;
        BufferedReader bufferedReader2 = null;
        r5 = null;
        r5 = null;
        r5 = null;
        r5 = 0;
        BufferedReader bufferedReader3 = null;
        BufferedReader bufferedReader4 = null;
        BufferedReader bufferedReader5 = null;
        try {
            try {
                try {
                    boolean m343c = C0700g.m343c(this.f221a);
                    z = m253a(c0692g.f227f, c0692g.f228g);
                    if (z) {
                        try {
                            str = str.replace(c0692g.f229h, c0692g.f228g);
                        } catch (SocketTimeoutException e) {
                            e = e;
                            inputStream = null;
                            if (!c0692g.f226e && z) {
                                c0693h.f247d = false;
                            }
                            c0693h.f245b = C0703j.m364a(80005, C0678d.m189a(C0703j.f303f) + "-" + c0692g.f224c + "-" + e.getMessage());
                            C0699f.m331a(c0692g.f225d, c0693h.f245b, "SocketTimeoutException : " + e.getMessage());
                            CtAuth.warn(f210b, "STE_" + c0692g.f224c + "_" + e.getMessage(), e);
                            if (bufferedReader3 != null) {
                                bufferedReader3.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return c0693h;
                        } catch (UnknownHostException e2) {
                            e = e2;
                            inputStream = null;
                            if (!c0692g.f226e && z) {
                                c0693h.f247d = false;
                            }
                            c0693h.f245b = C0703j.m364a(80006, C0678d.m189a(C0703j.f304g) + "-" + c0692g.f224c + "-" + e.getMessage());
                            C0699f.m331a(c0692g.f225d, c0693h.f245b, "UnknownHostException : " + e.getMessage());
                            CtAuth.warn(f210b, "UnknownHostException-" + c0692g.f224c + "-" + e.getMessage(), e);
                            if (bufferedReader4 != null) {
                                bufferedReader4.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return c0693h;
                        } catch (IOException e3) {
                            e = e3;
                            inputStream = null;
                            if (!c0692g.f226e && z) {
                                c0693h.f247d = false;
                            }
                            c0693h.f245b = C0703j.m364a(80007, C0678d.m189a(C0703j.f305h) + "-" + c0692g.f224c + "-" + e.getMessage());
                            C0699f.m331a(c0692g.f225d, c0693h.f245b, "IOException : " + e.getMessage());
                            CtAuth.warn(f210b, "IOException-" + c0692g.f224c + "-" + e.getMessage(), e);
                            if (bufferedReader5 != null) {
                                bufferedReader5.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return c0693h;
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = null;
                            try {
                                if (!c0692g.f226e && z) {
                                    c0693h.f247d = false;
                                }
                                c0693h.f245b = C0703j.m364a(80001, C0678d.m189a(C0703j.f299b) + "-" + c0692g.f224c + "-" + th.getMessage());
                                C0699f.m331a(c0692g.f225d, c0693h.f245b, "Throwable : " + th.getMessage());
                                CtAuth.warn(f210b, "Throwable-" + c0692g.f224c + "-" + th.getMessage(), th);
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                if (r5 != 0) {
                                    r5.close();
                                }
                                return c0693h;
                            } catch (Throwable th2) {
                                th = th2;
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e4) {
                                        e4.printStackTrace();
                                        throw th;
                                    }
                                }
                                if (r5 != 0) {
                                    r5.close();
                                }
                                throw th;
                            }
                        }
                    }
                    if (c0692g.f223b > 0 && !m343c && !m251a()) {
                        m249a(this.f221a, str);
                    }
                    HttpsURLConnection e5 = m255e(str, str2, i, c0692g);
                    int responseCode = e5.getResponseCode();
                    if (responseCode == 200) {
                        inputStream = e5.getInputStream();
                        try {
                            StringBuilder sb = new StringBuilder();
                            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                            while (true) {
                                try {
                                    String readLine = bufferedReader.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    sb.append(readLine).append("\n");
                                } catch (SocketTimeoutException e6) {
                                    e = e6;
                                    bufferedReader3 = bufferedReader;
                                    if (!c0692g.f226e) {
                                        c0693h.f247d = false;
                                    }
                                    c0693h.f245b = C0703j.m364a(80005, C0678d.m189a(C0703j.f303f) + "-" + c0692g.f224c + "-" + e.getMessage());
                                    C0699f.m331a(c0692g.f225d, c0693h.f245b, "SocketTimeoutException : " + e.getMessage());
                                    CtAuth.warn(f210b, "STE_" + c0692g.f224c + "_" + e.getMessage(), e);
                                    if (bufferedReader3 != null) {
                                    }
                                    if (inputStream != null) {
                                    }
                                    return c0693h;
                                } catch (UnknownHostException e7) {
                                    e = e7;
                                    bufferedReader4 = bufferedReader;
                                    if (!c0692g.f226e) {
                                        c0693h.f247d = false;
                                    }
                                    c0693h.f245b = C0703j.m364a(80006, C0678d.m189a(C0703j.f304g) + "-" + c0692g.f224c + "-" + e.getMessage());
                                    C0699f.m331a(c0692g.f225d, c0693h.f245b, "UnknownHostException : " + e.getMessage());
                                    CtAuth.warn(f210b, "UnknownHostException-" + c0692g.f224c + "-" + e.getMessage(), e);
                                    if (bufferedReader4 != null) {
                                    }
                                    if (inputStream != null) {
                                    }
                                    return c0693h;
                                } catch (IOException e8) {
                                    e = e8;
                                    bufferedReader5 = bufferedReader;
                                    if (!c0692g.f226e) {
                                        c0693h.f247d = false;
                                    }
                                    c0693h.f245b = C0703j.m364a(80007, C0678d.m189a(C0703j.f305h) + "-" + c0692g.f224c + "-" + e.getMessage());
                                    C0699f.m331a(c0692g.f225d, c0693h.f245b, "IOException : " + e.getMessage());
                                    CtAuth.warn(f210b, "IOException-" + c0692g.f224c + "-" + e.getMessage(), e);
                                    if (bufferedReader5 != null) {
                                    }
                                    if (inputStream != null) {
                                    }
                                    return c0693h;
                                } catch (Throwable th3) {
                                    th = th3;
                                    r5 = inputStream;
                                    if (!c0692g.f226e) {
                                        c0693h.f247d = false;
                                    }
                                    c0693h.f245b = C0703j.m364a(80001, C0678d.m189a(C0703j.f299b) + "-" + c0692g.f224c + "-" + th.getMessage());
                                    C0699f.m331a(c0692g.f225d, c0693h.f245b, "Throwable : " + th.getMessage());
                                    CtAuth.warn(f210b, "Throwable-" + c0692g.f224c + "-" + th.getMessage(), th);
                                    if (bufferedReader != null) {
                                    }
                                    if (r5 != 0) {
                                    }
                                    return c0693h;
                                }
                            }
                            c0693h.f244a = 0;
                            String sb2 = sb.toString();
                            if (!TextUtils.isEmpty(sb2)) {
                                c0693h.f245b = new JSONObject(sb2);
                                C0699f.m331a(c0692g.f225d, c0693h.f245b, null);
                            }
                            C0689d m279a = C0694a.m279a(this.f221a, e5, true);
                            if (m279a != null) {
                                c0693h.f246c = m279a.f216a;
                                C0699f.m328a(c0692g.f225d).m326f(m279a.f218c);
                            }
                            bufferedReader2 = bufferedReader;
                        } catch (SocketTimeoutException e9) {
                            e = e9;
                        } catch (UnknownHostException e10) {
                            e = e10;
                        } catch (IOException e11) {
                            e = e11;
                        } catch (Throwable th4) {
                            th = th4;
                            bufferedReader = null;
                        }
                    } else {
                        if (responseCode != 302) {
                            c0693h.f245b = C0703j.m364a(80002, C0678d.m189a(C0703j.f300c) + "-" + c0692g.f224c + "-code : " + responseCode);
                            String str3 = "response code ：" + responseCode;
                            C0699f.m331a(c0692g.f225d, c0693h.f245b, str3);
                            CtAuth.info(f210b, str3);
                        } else {
                            if (c0692g.f223b < 10) {
                                c0692g.f223b++;
                                c0692g.f227f = false;
                                String headerField = e5.getHeaderField("Location");
                                C0689d m280a = C0694a.m280a(e5);
                                C0699f.m328a(c0692g.f225d).m326f(m280a.f218c);
                                int i2 = (TextUtils.isEmpty(m280a.f219d) || m280a.f219d.equals("0")) ? 0 : 1;
                                CtAuth.info(f210b, "method : " + i2);
                                return mo239a(headerField, null, i2, c0692g);
                            }
                            c0693h.f245b = C0703j.m364a(80001, C0678d.m189a(C0703j.f299b) + "-Redirect more than 10 times");
                            C0699f.m331a(c0692g.f225d, c0693h.f245b, "Redirect more than 10 times");
                        }
                        inputStream = null;
                    }
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (Throwable th5) {
                    th = th5;
                    bufferedReader = null;
                    r5 = str2;
                    if (bufferedReader != null) {
                    }
                    if (r5 != 0) {
                    }
                    throw th;
                }
            } catch (SocketTimeoutException e12) {
                e = e12;
                inputStream = null;
                z = false;
            } catch (UnknownHostException e13) {
                e = e13;
                inputStream = null;
                z = false;
            } catch (IOException e14) {
                e = e14;
                inputStream = null;
                z = false;
            } catch (Throwable th6) {
                th = th6;
                bufferedReader = null;
                z = false;
            }
        } catch (IOException e15) {
            e15.printStackTrace();
        }
        return c0693h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v18, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r11v19, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v21, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v36, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* renamed from: c */
    public C0693h m241c(String str, String str2, int i, C0692g c0692g) {
        BufferedReader bufferedReader;
        InputStream inputStream;
        C0693h c0693h = new C0693h();
        BufferedReader bufferedReader2 = null;
        bufferedReader2 = null;
        bufferedReader2 = null;
        bufferedReader2 = null;
        BufferedReader bufferedReader3 = null;
        bufferedReader2 = null;
        bufferedReader2 = null;
        bufferedReader2 = null;
        InputStream inputStream2 = null;
        try {
            try {
                try {
                    HttpURLConnection d = m254d(str, str2, i, c0692g);
                    int responseCode = d.getResponseCode();
                    int i2 = 0;
                    if (responseCode == 200) {
                        str2 = d.getInputStream();
                        try {
                            StringBuilder sb = new StringBuilder();
                            bufferedReader = new BufferedReader(new InputStreamReader(str2));
                            while (true) {
                                try {
                                    String readLine = bufferedReader.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    sb.append(readLine).append("\n");
                                } catch (SocketTimeoutException e) {
                                    e = e;
                                    bufferedReader2 = bufferedReader;
                                    c0693h.f245b = C0703j.m364a(80005, C0678d.m189a(C0703j.f303f) + "-" + c0692g.f224c + "-" + e.getMessage());
                                    CtAuth.warn(f210b, "SocketTimeoutException-" + c0692g.f224c + "-" + e.getMessage(), e);
                                    C0699f.m331a(c0692g.f225d, c0693h.f245b, "SocketTimeoutException ：" + e.getMessage());
                                    if (bufferedReader2 != null) {
                                        bufferedReader2.close();
                                    }
                                    if (str2 != 0) {
                                        str2.close();
                                    }
                                    return c0693h;
                                } catch (UnknownHostException e2) {
                                    e = e2;
                                    bufferedReader2 = bufferedReader;
                                    c0693h.f245b = C0703j.m364a(80006, C0678d.m189a(C0703j.f304g) + "-" + c0692g.f224c + "-" + e.getMessage());
                                    CtAuth.warn(f210b, "UnknownHostException-" + c0692g.f224c + "-" + e.getMessage(), e);
                                    C0699f.m331a(c0692g.f225d, c0693h.f245b, "UnknownHostException ：" + e.getMessage());
                                    if (bufferedReader2 != null) {
                                        bufferedReader2.close();
                                    }
                                    if (str2 != 0) {
                                        str2.close();
                                    }
                                    return c0693h;
                                } catch (IOException e3) {
                                    e = e3;
                                    bufferedReader2 = bufferedReader;
                                    c0693h.f245b = C0703j.m364a(80007, C0678d.m189a(C0703j.f305h) + "-" + c0692g.f224c + "-" + e.getMessage());
                                    CtAuth.warn(f210b, "IOException-" + c0692g.f224c + "-" + e.getMessage(), e);
                                    C0699f.m331a(c0692g.f225d, c0693h.f245b, "IOException ：" + e.getMessage());
                                    if (bufferedReader2 != null) {
                                        bufferedReader2.close();
                                    }
                                    if (str2 != 0) {
                                        str2.close();
                                    }
                                    return c0693h;
                                } catch (Throwable th) {
                                    th = th;
                                    inputStream2 = str2;
                                    try {
                                        c0693h.f245b = C0703j.m364a(80001, C0678d.m189a(C0703j.f299b) + "-" + c0692g.f224c + "-" + th.getMessage());
                                        CtAuth.warn(f210b, "Throwable-" + c0692g.f224c + "-" + th.getMessage(), th);
                                        C0699f.m331a(c0692g.f225d, c0693h.f245b, "Throwable ：" + th.getMessage());
                                        if (bufferedReader != null) {
                                            bufferedReader.close();
                                        }
                                        if (inputStream2 != null) {
                                            inputStream2.close();
                                        }
                                        return c0693h;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (bufferedReader != null) {
                                            try {
                                                bufferedReader.close();
                                            } catch (IOException e4) {
                                                e4.printStackTrace();
                                                throw th;
                                            }
                                        }
                                        if (inputStream2 != null) {
                                            inputStream2.close();
                                        }
                                        throw th;
                                    }
                                }
                            }
                            c0693h.f244a = 0;
                            String sb2 = sb.toString();
                            if (!TextUtils.isEmpty(sb2)) {
                                c0693h.f245b = new JSONObject(sb2);
                                C0699f.m331a(c0692g.f225d, c0693h.f245b, null);
                            }
                            C0699f.m331a(c0692g.f225d, c0693h.f245b, null);
                            C0689d m279a = C0694a.m279a(this.f221a, d, true);
                            if (m279a != null) {
                                c0693h.f246c = m279a.f216a;
                                C0699f.m328a(c0692g.f225d).m326f(m279a.f218c);
                            }
                            bufferedReader3 = bufferedReader;
                            inputStream = str2;
                        } catch (SocketTimeoutException e5) {
                            e = e5;
                        } catch (UnknownHostException e6) {
                            e = e6;
                        } catch (IOException e7) {
                            e = e7;
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedReader = null;
                        }
                    } else {
                        if (responseCode != 302) {
                            c0693h.f245b = C0703j.m364a(80002, C0678d.m189a(C0703j.f300c) + "-" + c0692g.f224c + "-code : " + responseCode);
                            String str3 = " Http response code :" + responseCode;
                            C0699f.m331a(c0692g.f225d, c0693h.f245b, str3);
                            CtAuth.info(f210b, str3);
                        } else {
                            if (c0692g.f223b < 10) {
                                c0692g.f223b++;
                                c0692g.f227f = false;
                                String headerField = d.getHeaderField("Location");
                                C0689d m280a = C0694a.m280a(d);
                                C0699f.m328a(c0692g.f225d).m326f(m280a.f218c);
                                if (!TextUtils.isEmpty(m280a.f219d) && !m280a.f219d.equals("0")) {
                                    i2 = 1;
                                }
                                CtAuth.info(f210b, " method : " + i2);
                                return mo239a(headerField, null, i2, c0692g);
                            }
                            c0693h.f245b = C0703j.m364a(80001, C0678d.m189a(C0703j.f299b) + "-Redirect more than 10 times");
                            C0699f.m331a(c0692g.f225d, c0693h.f245b, "Redirect more than 10 times");
                        }
                        inputStream = null;
                    }
                    if (bufferedReader3 != null) {
                        bufferedReader3.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (IOException e8) {
                    e8.printStackTrace();
                }
            } catch (SocketTimeoutException e9) {
                e = e9;
                str2 = 0;
            } catch (UnknownHostException e10) {
                e = e10;
                str2 = 0;
            } catch (IOException e11) {
                e = e11;
                str2 = 0;
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
            }
            return c0693h;
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = bufferedReader2;
            inputStream2 = str2;
        }
    }
}
