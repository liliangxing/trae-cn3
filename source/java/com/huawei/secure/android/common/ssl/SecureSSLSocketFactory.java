package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.C1298a;
import com.huawei.secure.android.common.ssl.util.C1302e;
import com.huawei.secure.android.common.ssl.util.ContextUtil;
import java.io.IOException;
import java.io.InputStream;
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
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;

@Deprecated
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class SecureSSLSocketFactory extends SSLSocketFactory {

    @Deprecated
    public static final X509HostnameVerifier BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = new BrowserCompatHostnameVerifier();

    @Deprecated
    public static final X509HostnameVerifier STRICT_HOSTNAME_VERIFIER = new StrictHostnameVerifier();

    /* renamed from: i */
    private static final String f2116i = "SecureSSLSocketFactory";

    /* renamed from: j */
    private static volatile SecureSSLSocketFactory f2117j = null;

    /* renamed from: a */
    private SSLContext f2118a;

    /* renamed from: b */
    private SSLSocket f2119b;

    /* renamed from: c */
    private Context f2120c;

    /* renamed from: d */
    private String[] f2121d;

    /* renamed from: e */
    private X509TrustManager f2122e;

    /* renamed from: f */
    private String[] f2123f;

    /* renamed from: g */
    private String[] f2124g;

    /* renamed from: h */
    private String[] f2125h;

    @Deprecated
    public SecureSSLSocketFactory(InputStream inputStream, String str) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        this.f2118a = null;
        this.f2119b = null;
        this.f2118a = SSLUtil.setSSLContext();
        HiCloudX509TrustManager hiCloudX509TrustManager = new HiCloudX509TrustManager(inputStream, str);
        setX509TrustManager(hiCloudX509TrustManager);
        this.f2118a.init(null, new X509TrustManager[]{hiCloudX509TrustManager}, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    /* renamed from: a */
    public static void m2334a(X509TrustManager x509TrustManager) {
        C1302e.m2408c(f2116i, "ssf update socket factory trust manager");
        long currentTimeMillis = System.currentTimeMillis();
        try {
            f2117j = new SecureSSLSocketFactory(x509TrustManager);
        } catch (KeyManagementException unused) {
            C1302e.m2407b(f2116i, "KeyManagementException");
        } catch (NoSuchAlgorithmException unused2) {
            C1302e.m2407b(f2116i, "NoSuchAlgorithmException");
        }
        C1302e.m2405a(f2116i, "update: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    @Deprecated
    public static SecureSSLSocketFactory getInstance(Context context) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalAccessException, KeyManagementException, IllegalArgumentException {
        long currentTimeMillis = System.currentTimeMillis();
        ContextUtil.setContext(context);
        if (f2117j == null) {
            synchronized (SecureSSLSocketFactory.class) {
                if (f2117j == null) {
                    f2117j = new SecureSSLSocketFactory(context, (SecureRandom) null);
                }
            }
        }
        if (f2117j.f2120c == null && context != null) {
            f2117j.setContext(context);
        }
        C1302e.m2405a(f2116i, "getInstance: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        return f2117j;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException {
        C1302e.m2408c(f2116i, "createSocket: host , port");
        Socket createSocket = this.f2118a.getSocketFactory().createSocket(str, i);
        if (createSocket instanceof SSLSocket) {
            m2333a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.f2119b = sSLSocket;
            this.f2121d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public String[] getBlackCiphers() {
        return this.f2123f;
    }

    public X509Certificate[] getChain() {
        X509TrustManager x509TrustManager = this.f2122e;
        return x509TrustManager instanceof SecureX509TrustManager ? ((SecureX509TrustManager) x509TrustManager).getChain() : new X509Certificate[0];
    }

    public Context getContext() {
        return this.f2120c;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    public String[] getProtocols() {
        return this.f2125h;
    }

    public SSLContext getSslContext() {
        return this.f2118a;
    }

    public SSLSocket getSslSocket() {
        return this.f2119b;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        String[] strArr = this.f2121d;
        return strArr != null ? strArr : new String[0];
    }

    public String[] getWhiteCiphers() {
        return this.f2124g;
    }

    public X509TrustManager getX509TrustManager() {
        return this.f2122e;
    }

    public void setBlackCiphers(String[] strArr) {
        this.f2123f = strArr;
    }

    public void setContext(Context context) {
        this.f2120c = context.getApplicationContext();
    }

    public void setProtocols(String[] strArr) {
        this.f2125h = strArr;
    }

    public void setSslContext(SSLContext sSLContext) {
        this.f2118a = sSLContext;
    }

    public void setWhiteCiphers(String[] strArr) {
        this.f2124g = strArr;
    }

    public void setX509TrustManager(X509TrustManager x509TrustManager) {
        this.f2122e = x509TrustManager;
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
        C1302e.m2408c(f2116i, "createSocket s host port autoClose");
        Socket createSocket = this.f2118a.getSocketFactory().createSocket(socket, str, i, z);
        if (createSocket instanceof SSLSocket) {
            m2333a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.f2119b = sSLSocket;
            this.f2121d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m2335a(X509TrustManager x509TrustManager, SecureRandom secureRandom) {
        C1302e.m2408c(f2116i, "ssf update socket factory trust manager");
        long currentTimeMillis = System.currentTimeMillis();
        try {
            f2117j = new SecureSSLSocketFactory(x509TrustManager, secureRandom);
        } catch (KeyManagementException unused) {
            C1302e.m2407b(f2116i, "KeyManagementException");
        } catch (NoSuchAlgorithmException unused2) {
            C1302e.m2407b(f2116i, "NoSuchAlgorithmException");
        }
        C1302e.m2405a(f2116i, "update: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    public static SecureSSLSocketFactory getInstance(Context context, SecureRandom secureRandom) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalAccessException, KeyManagementException, IllegalArgumentException {
        long currentTimeMillis = System.currentTimeMillis();
        ContextUtil.setContext(context);
        if (f2117j == null) {
            synchronized (SecureSSLSocketFactory.class) {
                if (f2117j == null) {
                    f2117j = new SecureSSLSocketFactory(context, secureRandom);
                }
            }
        }
        if (f2117j.f2120c == null && context != null) {
            f2117j.setContext(context);
        }
        C1302e.m2405a(f2116i, "getInstance: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        return f2117j;
    }

    public SecureSSLSocketFactory(InputStream inputStream, String str, SecureRandom secureRandom) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        this.f2118a = null;
        this.f2119b = null;
        this.f2118a = SSLUtil.setSSLContext();
        HiCloudX509TrustManager hiCloudX509TrustManager = new HiCloudX509TrustManager(inputStream, str);
        setX509TrustManager(hiCloudX509TrustManager);
        this.f2118a.init(null, new X509TrustManager[]{hiCloudX509TrustManager}, secureRandom);
    }

    /* renamed from: a */
    private void m2333a(Socket socket) {
        boolean z;
        boolean z2 = false;
        if (C1298a.m2376a(this.f2125h)) {
            z = false;
        } else {
            C1302e.m2408c(f2116i, "set protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket, this.f2125h);
            z = true;
        }
        if (!C1298a.m2376a(this.f2124g) || !C1298a.m2376a(this.f2123f)) {
            C1302e.m2408c(f2116i, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLUtil.setEnabledProtocols(sSLSocket);
            if (!C1298a.m2376a(this.f2124g)) {
                z2 = SSLUtil.setWhiteListCipherSuites(sSLSocket, this.f2124g);
            } else {
                z2 = SSLUtil.setBlackListCipherSuites(sSLSocket, this.f2123f);
            }
        }
        if (!z) {
            C1302e.m2408c(f2116i, "set default protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket);
        }
        if (z2) {
            return;
        }
        C1302e.m2408c(f2116i, "set default cipher suites");
        SSLUtil.setEnableSafeCipherSuites((SSLSocket) socket);
    }

    private SecureSSLSocketFactory(Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, CertificateException, KeyStoreException, IOException, KeyManagementException, NullPointerException {
        this.f2118a = null;
        this.f2119b = null;
        setContext(context);
        setSslContext(SSLUtil.setSSLContext());
        SecureX509TrustManager secureX509SingleInstance = SecureX509SingleInstance.getInstance(context);
        this.f2122e = secureX509SingleInstance;
        this.f2118a.init(null, new X509TrustManager[]{secureX509SingleInstance}, secureRandom);
    }

    @Deprecated
    public SecureSSLSocketFactory(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.f2118a = null;
        this.f2119b = null;
        this.f2118a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f2118a.init(null, new X509TrustManager[]{x509TrustManager}, null);
    }

    public SecureSSLSocketFactory(X509TrustManager x509TrustManager, SecureRandom secureRandom) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.f2118a = null;
        this.f2119b = null;
        this.f2118a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f2118a.init(null, new X509TrustManager[]{x509TrustManager}, secureRandom);
    }
}
