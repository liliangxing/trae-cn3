package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.bytedance.vmsdk.inspector_new.server.http.HttpHeaders;
import com.huawei.secure.android.common.ssl.SecureSSLSocketFactory;
import com.huawei.secure.android.common.ssl.hostname.StrictHostnameVerifier;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;

/* renamed from: com.huawei.hms.hatool.w */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public abstract class AbstractC1184w {

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.huawei.hms.hatool.w$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class a extends Exception {
        a(String str) {
            super(str);
        }
    }

    /* renamed from: a */
    public static C1164n0 m1788a(String str, byte[] bArr, Map<String, String> map) {
        return m1789a(str, bArr, map, "POST");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0149  */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.util.Map<java.lang.String, java.lang.String>, java.util.Map] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v18, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v19, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v20, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v21, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v22, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v23, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v24, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v25 */
    /* JADX WARN: Type inference failed for: r8v26 */
    /* JADX WARN: Type inference failed for: r8v27 */
    /* JADX WARN: Type inference failed for: r8v28 */
    /* JADX WARN: Type inference failed for: r8v29 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v30 */
    /* JADX WARN: Type inference failed for: r8v31 */
    /* JADX WARN: Type inference failed for: r8v32 */
    /* JADX WARN: Type inference failed for: r8v33, types: [java.io.OutputStream, java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v11, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v12, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v13, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v14, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v15, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v16, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v17, types: [java.io.Closeable, java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9, types: [java.io.Closeable] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C1164n0 m1789a(String str, byte[] bArr, Map<String, String> map, String str2) {
        HttpURLConnection httpURLConnection;
        ?? r9;
        HttpURLConnection httpURLConnection2;
        HttpURLConnection httpURLConnection3;
        HttpURLConnection httpURLConnection4;
        HttpURLConnection httpURLConnection5;
        HttpURLConnection httpURLConnection6;
        HttpURLConnection httpURLConnection7;
        HttpURLConnection httpURLConnection8;
        if (TextUtils.isEmpty(str)) {
            return new C1164n0(-100, "");
        }
        String str3 = null;
        int i = -102;
        try {
            try {
                httpURLConnection = m1790a(str, bArr.length, (Map<String, String>) map, str2);
                try {
                    if (httpURLConnection == null) {
                        C1164n0 c1164n0 = new C1164n0(-101, "");
                        C1156k1.m1597a((Closeable) null);
                        C1156k1.m1597a((Closeable) null);
                        if (httpURLConnection != null) {
                            C1156k1.m1600a(httpURLConnection);
                        }
                        return c1164n0;
                    }
                    map = httpURLConnection.getOutputStream();
                    try {
                        r9 = new BufferedOutputStream(map);
                        try {
                            try {
                                r9.write(bArr);
                                r9.flush();
                                int responseCode = httpURLConnection.getResponseCode();
                                try {
                                    C1164n0 c1164n02 = new C1164n0(responseCode, m1792b(httpURLConnection));
                                    C1156k1.m1597a((Closeable) r9);
                                    C1156k1.m1597a((Closeable) map);
                                    C1156k1.m1600a(httpURLConnection);
                                    return c1164n02;
                                } catch (SecurityException unused) {
                                    i = responseCode;
                                    httpURLConnection8 = httpURLConnection;
                                    C1182v.m1786f("hmsSdk", "SecurityException with HttpClient. Please check INTERNET permission.");
                                    C1164n0 c1164n03 = new C1164n0(i, "");
                                    C1156k1.m1597a((Closeable) r9);
                                    C1156k1.m1597a((Closeable) map);
                                    if (httpURLConnection8 != null) {
                                        C1156k1.m1600a(httpURLConnection8);
                                    }
                                    return c1164n03;
                                } catch (ConnectException unused2) {
                                    i = responseCode;
                                    httpURLConnection7 = httpURLConnection;
                                    C1182v.m1786f("hmsSdk", "Network is unreachable or Connection refused");
                                    C1164n0 c1164n04 = new C1164n0(i, "");
                                    C1156k1.m1597a((Closeable) r9);
                                    C1156k1.m1597a((Closeable) map);
                                    if (httpURLConnection7 != null) {
                                        C1156k1.m1600a(httpURLConnection7);
                                    }
                                    return c1164n04;
                                } catch (UnknownHostException unused3) {
                                    i = responseCode;
                                    httpURLConnection6 = httpURLConnection;
                                    C1182v.m1786f("hmsSdk", "No address associated with hostname or No network");
                                    C1164n0 c1164n05 = new C1164n0(i, "");
                                    C1156k1.m1597a((Closeable) r9);
                                    C1156k1.m1597a((Closeable) map);
                                    if (httpURLConnection6 != null) {
                                        C1156k1.m1600a(httpURLConnection6);
                                    }
                                    return c1164n05;
                                } catch (SSLHandshakeException unused4) {
                                    i = responseCode;
                                    httpURLConnection5 = httpURLConnection;
                                    C1182v.m1786f("hmsSdk", "Chain validation failed,Certificate expired");
                                    C1164n0 c1164n06 = new C1164n0(i, "");
                                    C1156k1.m1597a((Closeable) r9);
                                    C1156k1.m1597a((Closeable) map);
                                    if (httpURLConnection5 != null) {
                                        C1156k1.m1600a(httpURLConnection5);
                                    }
                                    return c1164n06;
                                } catch (SSLPeerUnverifiedException unused5) {
                                    i = responseCode;
                                    httpURLConnection4 = httpURLConnection;
                                    C1182v.m1786f("hmsSdk", "Certificate has not been verified,Request is restricted!");
                                    C1164n0 c1164n07 = new C1164n0(i, "");
                                    C1156k1.m1597a((Closeable) r9);
                                    C1156k1.m1597a((Closeable) map);
                                    if (httpURLConnection4 != null) {
                                        C1156k1.m1600a(httpURLConnection4);
                                    }
                                    return c1164n07;
                                } catch (IOException unused6) {
                                    i = responseCode;
                                    httpURLConnection3 = httpURLConnection;
                                    C1182v.m1786f("hmsSdk", "events PostRequest(byte[]): IOException occurred.");
                                    C1164n0 c1164n08 = new C1164n0(i, "");
                                    C1156k1.m1597a((Closeable) r9);
                                    C1156k1.m1597a((Closeable) map);
                                    if (httpURLConnection3 != null) {
                                        C1156k1.m1600a(httpURLConnection3);
                                    }
                                    return c1164n08;
                                }
                            } catch (a unused7) {
                                httpURLConnection2 = httpURLConnection;
                                C1182v.m1786f("hmsSdk", "PostRequest(byte[]): No ssl socket factory set!");
                                C1164n0 c1164n09 = new C1164n0(-101, "");
                                C1156k1.m1597a((Closeable) r9);
                                C1156k1.m1597a((Closeable) map);
                                if (httpURLConnection2 != null) {
                                    C1156k1.m1600a(httpURLConnection2);
                                }
                                return c1164n09;
                            } catch (Throwable th) {
                                th = th;
                                C1156k1.m1597a((Closeable) r9);
                                C1156k1.m1597a((Closeable) map);
                                if (httpURLConnection != null) {
                                    C1156k1.m1600a(httpURLConnection);
                                }
                                throw th;
                            }
                        } catch (SecurityException unused8) {
                        } catch (ConnectException unused9) {
                        } catch (UnknownHostException unused10) {
                        } catch (SSLHandshakeException unused11) {
                        } catch (SSLPeerUnverifiedException unused12) {
                        } catch (IOException unused13) {
                        }
                    } catch (a unused14) {
                        r9 = 0;
                        httpURLConnection2 = httpURLConnection;
                        C1182v.m1786f("hmsSdk", "PostRequest(byte[]): No ssl socket factory set!");
                        C1164n0 c1164n092 = new C1164n0(-101, "");
                        C1156k1.m1597a((Closeable) r9);
                        C1156k1.m1597a((Closeable) map);
                        if (httpURLConnection2 != null) {
                        }
                        return c1164n092;
                    } catch (SecurityException unused15) {
                        r9 = 0;
                        httpURLConnection8 = httpURLConnection;
                        C1182v.m1786f("hmsSdk", "SecurityException with HttpClient. Please check INTERNET permission.");
                        C1164n0 c1164n032 = new C1164n0(i, "");
                        C1156k1.m1597a((Closeable) r9);
                        C1156k1.m1597a((Closeable) map);
                        if (httpURLConnection8 != null) {
                        }
                        return c1164n032;
                    } catch (ConnectException unused16) {
                        r9 = 0;
                        httpURLConnection7 = httpURLConnection;
                        C1182v.m1786f("hmsSdk", "Network is unreachable or Connection refused");
                        C1164n0 c1164n042 = new C1164n0(i, "");
                        C1156k1.m1597a((Closeable) r9);
                        C1156k1.m1597a((Closeable) map);
                        if (httpURLConnection7 != null) {
                        }
                        return c1164n042;
                    } catch (UnknownHostException unused17) {
                        r9 = 0;
                        httpURLConnection6 = httpURLConnection;
                        C1182v.m1786f("hmsSdk", "No address associated with hostname or No network");
                        C1164n0 c1164n052 = new C1164n0(i, "");
                        C1156k1.m1597a((Closeable) r9);
                        C1156k1.m1597a((Closeable) map);
                        if (httpURLConnection6 != null) {
                        }
                        return c1164n052;
                    } catch (SSLHandshakeException unused18) {
                        r9 = 0;
                        httpURLConnection5 = httpURLConnection;
                        C1182v.m1786f("hmsSdk", "Chain validation failed,Certificate expired");
                        C1164n0 c1164n062 = new C1164n0(i, "");
                        C1156k1.m1597a((Closeable) r9);
                        C1156k1.m1597a((Closeable) map);
                        if (httpURLConnection5 != null) {
                        }
                        return c1164n062;
                    } catch (SSLPeerUnverifiedException unused19) {
                        r9 = 0;
                        httpURLConnection4 = httpURLConnection;
                        C1182v.m1786f("hmsSdk", "Certificate has not been verified,Request is restricted!");
                        C1164n0 c1164n072 = new C1164n0(i, "");
                        C1156k1.m1597a((Closeable) r9);
                        C1156k1.m1597a((Closeable) map);
                        if (httpURLConnection4 != null) {
                        }
                        return c1164n072;
                    } catch (IOException unused20) {
                        r9 = 0;
                        httpURLConnection3 = httpURLConnection;
                        C1182v.m1786f("hmsSdk", "events PostRequest(byte[]): IOException occurred.");
                        C1164n0 c1164n082 = new C1164n0(i, "");
                        C1156k1.m1597a((Closeable) r9);
                        C1156k1.m1597a((Closeable) map);
                        if (httpURLConnection3 != null) {
                        }
                        return c1164n082;
                    } catch (Throwable th2) {
                        th = th2;
                        r9 = str3;
                        C1156k1.m1597a((Closeable) r9);
                        C1156k1.m1597a((Closeable) map);
                        if (httpURLConnection != null) {
                        }
                        throw th;
                    }
                } catch (a unused21) {
                    map = 0;
                } catch (SecurityException unused22) {
                    map = 0;
                } catch (ConnectException unused23) {
                    map = 0;
                } catch (UnknownHostException unused24) {
                    map = 0;
                } catch (SSLHandshakeException unused25) {
                    map = 0;
                } catch (SSLPeerUnverifiedException unused26) {
                    map = 0;
                } catch (IOException unused27) {
                    map = 0;
                } catch (Throwable th3) {
                    th = th3;
                    map = 0;
                }
            } catch (Throwable th4) {
                th = th4;
                httpURLConnection = null;
                str3 = str2;
            }
        } catch (a unused28) {
            httpURLConnection = null;
            map = 0;
        } catch (SecurityException unused29) {
            httpURLConnection = null;
            map = 0;
        } catch (ConnectException unused30) {
            httpURLConnection = null;
            map = 0;
        } catch (UnknownHostException unused31) {
            httpURLConnection = null;
            map = 0;
        } catch (SSLHandshakeException unused32) {
            httpURLConnection = null;
            map = 0;
        } catch (SSLPeerUnverifiedException unused33) {
            httpURLConnection = null;
            map = 0;
        } catch (IOException unused34) {
            httpURLConnection = null;
            map = 0;
        } catch (Throwable th5) {
            th = th5;
            httpURLConnection = null;
            map = 0;
        }
    }

    /* renamed from: a */
    private static HttpURLConnection m1790a(String str, int i, Map<String, String> map, String str2) {
        if (TextUtils.isEmpty(str)) {
            C1182v.m1778b("hmsSdk", "CreateConnection: invalid urlPath.");
            return null;
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        m1791a(httpURLConnection);
        httpURLConnection.setRequestMethod(str2);
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(15000);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_LENGTH, String.valueOf(i));
        httpURLConnection.setRequestProperty("Connection", "close");
        if (map != null && map.size() >= 1) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key != null && !TextUtils.isEmpty(key)) {
                    httpURLConnection.setRequestProperty(key, entry.getValue());
                }
            }
        }
        return httpURLConnection;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0025  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void m1791a(HttpURLConnection httpURLConnection) {
        String str;
        SecureSSLSocketFactory secureSSLSocketFactory;
        if (httpURLConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            try {
                secureSSLSocketFactory = SecureSSLSocketFactory.getInstance(AbstractC1173q0.m1707i());
            } catch (IOException unused) {
                str = "getSocketFactory(): IO Exception!";
                C1182v.m1786f("hmsSdk", str);
                secureSSLSocketFactory = null;
                if (secureSSLSocketFactory != null) {
                }
            } catch (IllegalAccessException unused2) {
                str = "getSocketFactory(): Illegal Access Exception ";
                C1182v.m1786f("hmsSdk", str);
                secureSSLSocketFactory = null;
                if (secureSSLSocketFactory != null) {
                }
            } catch (KeyStoreException unused3) {
                str = "getSocketFactory(): Key Store exception";
                C1182v.m1786f("hmsSdk", str);
                secureSSLSocketFactory = null;
                if (secureSSLSocketFactory != null) {
                }
            } catch (NoSuchAlgorithmException unused4) {
                str = "getSocketFactory(): Algorithm Exception!";
                C1182v.m1786f("hmsSdk", str);
                secureSSLSocketFactory = null;
                if (secureSSLSocketFactory != null) {
                }
            } catch (GeneralSecurityException unused5) {
                str = "getSocketFactory(): General Security Exception";
                C1182v.m1786f("hmsSdk", str);
                secureSSLSocketFactory = null;
                if (secureSSLSocketFactory != null) {
                }
            }
            if (secureSSLSocketFactory != null) {
                throw new a("No ssl socket factory set");
            }
            httpsURLConnection.setSSLSocketFactory(secureSSLSocketFactory);
            httpsURLConnection.setHostnameVerifier(new StrictHostnameVerifier());
        }
    }

    /* renamed from: b */
    private static String m1792b(HttpURLConnection httpURLConnection) {
        InputStream inputStream = null;
        try {
            try {
                inputStream = httpURLConnection.getInputStream();
                return C1156k1.m1596a(inputStream);
            } catch (IOException unused) {
                C1182v.m1786f("hmsSdk", "When Response Content From Connection inputStream operation exception! " + httpURLConnection.getResponseCode());
                C1156k1.m1597a((Closeable) inputStream);
                return "";
            }
        } finally {
            C1156k1.m1597a((Closeable) inputStream);
        }
    }
}
