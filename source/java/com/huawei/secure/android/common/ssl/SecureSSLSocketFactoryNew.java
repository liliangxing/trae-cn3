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

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class SecureSSLSocketFactoryNew extends SSLSocketFactory {

    /* renamed from: i */
    private static final String f2126i = "SSLFNew";

    /* renamed from: j */
    private static volatile SecureSSLSocketFactoryNew f2127j;

    /* renamed from: a */
    protected SSLContext f2128a;

    /* renamed from: b */
    protected SSLSocket f2129b;

    /* renamed from: c */
    protected Context f2130c;

    /* renamed from: d */
    protected String[] f2131d;

    /* renamed from: e */
    protected X509TrustManager f2132e;

    /* renamed from: f */
    protected String[] f2133f;

    /* renamed from: g */
    protected String[] f2134g;

    /* renamed from: h */
    protected String[] f2135h;

    @Deprecated
    public SecureSSLSocketFactoryNew(InputStream inputStream, String str) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        this.f2128a = null;
        this.f2129b = null;
        this.f2128a = SSLUtil.setSSLContext();
        HiCloudX509TrustManager hiCloudX509TrustManager = new HiCloudX509TrustManager(inputStream, str);
        setX509TrustManager(hiCloudX509TrustManager);
        this.f2128a.init(null, new X509TrustManager[]{hiCloudX509TrustManager}, null);
    }

    /* renamed from: a */
    private void m2336a(Socket socket) {
        boolean z;
        boolean z2 = false;
        if (C1298a.m2376a(this.f2135h)) {
            z = false;
        } else {
            C1302e.m2408c(f2126i, "set protocols");
            z = SSLUtil.setEnabledProtocols((SSLSocket) socket, this.f2135h);
        }
        if (!C1298a.m2376a(this.f2134g) || !C1298a.m2376a(this.f2133f)) {
            C1302e.m2408c(f2126i, "set cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLUtil.setEnabledProtocols(sSLSocket);
            if (!C1298a.m2376a(this.f2134g)) {
                z2 = SSLUtil.setWhiteListCipherSuites(sSLSocket, this.f2134g);
            } else {
                z2 = SSLUtil.setBlackListCipherSuites(sSLSocket, this.f2133f);
            }
        }
        if (!z) {
            C1302e.m2408c(f2126i, "set default protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket);
        }
        if (z2) {
            return;
        }
        C1302e.m2408c(f2126i, "set default cipher");
        SSLUtil.setEnableSafeCipherSuites((SSLSocket) socket);
    }

    @Deprecated
    public static SecureSSLSocketFactoryNew getInstance(Context context) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalAccessException, KeyManagementException, IllegalArgumentException {
        long currentTimeMillis = System.currentTimeMillis();
        ContextUtil.setContext(context);
        if (f2127j == null) {
            synchronized (SecureSSLSocketFactoryNew.class) {
                if (f2127j == null) {
                    f2127j = new SecureSSLSocketFactoryNew(context, (SecureRandom) null);
                }
            }
        }
        if (f2127j.f2130c == null && context != null) {
            f2127j.setContext(context);
        }
        C1302e.m2405a(f2126i, "getInstance: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        return f2127j;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException {
        C1302e.m2408c(f2126i, "createSocket: host , port");
        Socket createSocket = this.f2128a.getSocketFactory().createSocket(str, i);
        if (createSocket instanceof SSLSocket) {
            m2336a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.f2129b = sSLSocket;
            this.f2131d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public String[] getBlackCiphers() {
        return this.f2133f;
    }

    public X509Certificate[] getChain() {
        X509TrustManager x509TrustManager = this.f2132e;
        return x509TrustManager instanceof SecureX509TrustManager ? ((SecureX509TrustManager) x509TrustManager).getChain() : new X509Certificate[0];
    }

    public Context getContext() {
        return this.f2130c;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    public String[] getProtocols() {
        return this.f2135h;
    }

    public SSLContext getSslContext() {
        return this.f2128a;
    }

    public SSLSocket getSslSocket() {
        return this.f2129b;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        String[] strArr = this.f2131d;
        return strArr != null ? strArr : new String[0];
    }

    public String[] getWhiteCiphers() {
        return this.f2134g;
    }

    public X509TrustManager getX509TrustManager() {
        return this.f2132e;
    }

    public void setBlackCiphers(String[] strArr) {
        this.f2133f = strArr;
    }

    public void setContext(Context context) {
        this.f2130c = context.getApplicationContext();
    }

    public void setProtocols(String[] strArr) {
        this.f2135h = strArr;
    }

    public void setSslContext(SSLContext sSLContext) {
        this.f2128a = sSLContext;
    }

    public void setWhiteCiphers(String[] strArr) {
        this.f2134g = strArr;
    }

    public void setX509TrustManager(X509TrustManager x509TrustManager) {
        this.f2132e = x509TrustManager;
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
        C1302e.m2408c(f2126i, "createSocket");
        Socket createSocket = this.f2128a.getSocketFactory().createSocket(socket, str, i, z);
        if (createSocket instanceof SSLSocket) {
            m2336a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.f2129b = sSLSocket;
            this.f2131d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public static SecureSSLSocketFactoryNew getInstance(Context context, SecureRandom secureRandom) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalAccessException, KeyManagementException, IllegalArgumentException {
        long currentTimeMillis = System.currentTimeMillis();
        ContextUtil.setContext(context);
        if (f2127j == null) {
            synchronized (SecureSSLSocketFactoryNew.class) {
                if (f2127j == null) {
                    f2127j = new SecureSSLSocketFactoryNew(context, secureRandom);
                }
            }
        }
        if (f2127j.f2130c == null && context != null) {
            f2127j.setContext(context);
        }
        C1302e.m2405a(f2126i, "getInstance: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        return f2127j;
    }

    public SecureSSLSocketFactoryNew(InputStream inputStream, String str, SecureRandom secureRandom) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        this.f2128a = null;
        this.f2129b = null;
        this.f2128a = SSLUtil.setSSLContext();
        HiCloudX509TrustManager hiCloudX509TrustManager = new HiCloudX509TrustManager(inputStream, str);
        setX509TrustManager(hiCloudX509TrustManager);
        this.f2128a.init(null, new X509TrustManager[]{hiCloudX509TrustManager}, secureRandom);
    }

    private SecureSSLSocketFactoryNew(Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, CertificateException, KeyStoreException, IOException, KeyManagementException, NullPointerException {
        this.f2128a = null;
        this.f2129b = null;
        setContext(context);
        setSslContext(SSLUtil.setSSLContext());
        SecureX509TrustManager secureX509SingleInstance = SecureX509SingleInstance.getInstance(context);
        this.f2132e = secureX509SingleInstance;
        this.f2128a.init(null, new X509TrustManager[]{secureX509SingleInstance}, secureRandom);
    }

    @Deprecated
    public SecureSSLSocketFactoryNew(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.f2128a = null;
        this.f2129b = null;
        this.f2128a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f2128a.init(null, new X509TrustManager[]{x509TrustManager}, null);
    }

    public SecureSSLSocketFactoryNew(X509TrustManager x509TrustManager, SecureRandom secureRandom) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.f2128a = null;
        this.f2129b = null;
        this.f2128a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f2128a.init(null, new X509TrustManager[]{x509TrustManager}, secureRandom);
    }
}
