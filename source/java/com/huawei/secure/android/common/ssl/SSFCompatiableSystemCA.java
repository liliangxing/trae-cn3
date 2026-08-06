package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.C1298a;
import com.huawei.secure.android.common.ssl.util.C1302e;
import com.huawei.secure.android.common.ssl.util.ContextUtil;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class SSFCompatiableSystemCA extends SSLSocketFactory {

    /* renamed from: i */
    private static final String f2086i = "SSFCompatiableSystemCA";

    /* renamed from: j */
    private static volatile SSFCompatiableSystemCA f2087j;

    /* renamed from: a */
    private SSLContext f2088a;

    /* renamed from: b */
    private SSLSocket f2089b;

    /* renamed from: c */
    private Context f2090c;

    /* renamed from: d */
    private String[] f2091d;

    /* renamed from: e */
    private X509TrustManager f2092e;

    /* renamed from: f */
    private String[] f2093f;

    /* renamed from: g */
    private String[] f2094g;

    /* renamed from: h */
    private String[] f2095h;

    private SSFCompatiableSystemCA(Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, CertificateException, KeyStoreException, IOException, KeyManagementException, NullPointerException {
        this.f2088a = null;
        this.f2089b = null;
        setContext(context);
        setSslContext(SSLUtil.setSSLContext());
        SecureX509TrustManager sSFSecureX509SingleInstance = SSFSecureX509SingleInstance.getInstance(context);
        this.f2092e = sSFSecureX509SingleInstance;
        this.f2088a.init(null, new X509TrustManager[]{sSFSecureX509SingleInstance}, secureRandom);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    /* renamed from: a */
    public static void m2328a(X509TrustManager x509TrustManager) {
        C1302e.m2408c(f2086i, "ssfc update socket factory trust manager");
        long currentTimeMillis = System.currentTimeMillis();
        try {
            f2087j = new SSFCompatiableSystemCA(x509TrustManager);
        } catch (KeyManagementException unused) {
            C1302e.m2407b(f2086i, "KeyManagementException");
        } catch (NoSuchAlgorithmException unused2) {
            C1302e.m2407b(f2086i, "NoSuchAlgorithmException");
        }
        C1302e.m2405a(f2086i, "SSF system ca update: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    @Deprecated
    public static SSFCompatiableSystemCA getInstance(Context context) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        ContextUtil.setContext(context);
        if (f2087j == null) {
            synchronized (SSFCompatiableSystemCA.class) {
                if (f2087j == null) {
                    f2087j = new SSFCompatiableSystemCA(context, (SecureRandom) null);
                }
            }
        }
        if (f2087j.f2090c == null && context != null) {
            f2087j.setContext(context);
        }
        return f2087j;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException {
        C1302e.m2408c(f2086i, "createSocket: host , port");
        Socket createSocket = this.f2088a.getSocketFactory().createSocket(str, i);
        if (createSocket instanceof SSLSocket) {
            m2327a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.f2089b = sSLSocket;
            this.f2091d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public String[] getBlackCiphers() {
        return this.f2093f;
    }

    public X509Certificate[] getChain() {
        X509TrustManager x509TrustManager = this.f2092e;
        return x509TrustManager instanceof SecureX509TrustManager ? ((SecureX509TrustManager) x509TrustManager).getChain() : new X509Certificate[0];
    }

    public Context getContext() {
        return this.f2090c;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    public String[] getProtocols() {
        return this.f2095h;
    }

    public SSLContext getSslContext() {
        return this.f2088a;
    }

    public SSLSocket getSslSocket() {
        return this.f2089b;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        String[] strArr = this.f2091d;
        return strArr != null ? strArr : new String[0];
    }

    public String[] getWhiteCiphers() {
        return this.f2094g;
    }

    public X509TrustManager getX509TrustManager() {
        return this.f2092e;
    }

    public void setBlackCiphers(String[] strArr) {
        this.f2093f = strArr;
    }

    public void setContext(Context context) {
        this.f2090c = context.getApplicationContext();
    }

    public void setProtocols(String[] strArr) {
        this.f2095h = strArr;
    }

    public void setSslContext(SSLContext sSLContext) {
        this.f2088a = sSLContext;
    }

    public void setWhiteCiphers(String[] strArr) {
        this.f2094g = strArr;
    }

    public void setX509TrustManager(X509TrustManager x509TrustManager) {
        this.f2092e = x509TrustManager;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException, UnknownHostException {
        return createSocket(str, i);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        C1302e.m2408c(f2086i, "createSocket: s , host , port , autoClose");
        Socket createSocket = this.f2088a.getSocketFactory().createSocket(socket, str, i, z);
        if (createSocket instanceof SSLSocket) {
            m2327a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.f2089b = sSLSocket;
            this.f2091d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public static SSFCompatiableSystemCA getInstance(Context context, SecureRandom secureRandom) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        ContextUtil.setContext(context);
        if (f2087j == null) {
            synchronized (SSFCompatiableSystemCA.class) {
                if (f2087j == null) {
                    f2087j = new SSFCompatiableSystemCA(context, secureRandom);
                }
            }
        }
        if (f2087j.f2090c == null && context != null) {
            f2087j.setContext(context);
        }
        return f2087j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m2329a(X509TrustManager x509TrustManager, SecureRandom secureRandom) {
        C1302e.m2408c(f2086i, "ssfc update socket factory trust manager");
        long currentTimeMillis = System.currentTimeMillis();
        try {
            f2087j = new SSFCompatiableSystemCA(x509TrustManager, secureRandom);
        } catch (KeyManagementException unused) {
            C1302e.m2407b(f2086i, "KeyManagementException");
        } catch (NoSuchAlgorithmException unused2) {
            C1302e.m2407b(f2086i, "NoSuchAlgorithmException");
        }
        C1302e.m2405a(f2086i, "SSF system ca update: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    @Deprecated
    public SSFCompatiableSystemCA(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.f2088a = null;
        this.f2089b = null;
        this.f2088a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f2088a.init(null, new X509TrustManager[]{x509TrustManager}, null);
    }

    /* renamed from: a */
    private void m2327a(Socket socket) {
        boolean z;
        boolean z2 = false;
        if (C1298a.m2376a(this.f2095h)) {
            z = false;
        } else {
            C1302e.m2408c(f2086i, "set protocols");
            z = SSLUtil.setEnabledProtocols((SSLSocket) socket, this.f2095h);
        }
        if (!C1298a.m2376a(this.f2094g) || !C1298a.m2376a(this.f2093f)) {
            C1302e.m2408c(f2086i, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLUtil.setEnabledProtocols(sSLSocket);
            if (!C1298a.m2376a(this.f2094g)) {
                z2 = SSLUtil.setWhiteListCipherSuites(sSLSocket, this.f2094g);
            } else {
                z2 = SSLUtil.setBlackListCipherSuites(sSLSocket, this.f2093f);
            }
        }
        if (!z) {
            C1302e.m2408c(f2086i, "set default protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket);
        }
        if (z2) {
            return;
        }
        C1302e.m2408c(f2086i, "set default cipher suites");
        SSLUtil.setEnableSafeCipherSuites((SSLSocket) socket);
    }

    public SSFCompatiableSystemCA(X509TrustManager x509TrustManager, SecureRandom secureRandom) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.f2088a = null;
        this.f2089b = null;
        this.f2088a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f2088a.init(null, new X509TrustManager[]{x509TrustManager}, secureRandom);
    }
}
