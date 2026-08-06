package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.C1298a;
import com.huawei.secure.android.common.ssl.util.C1302e;
import com.huawei.secure.android.common.ssl.util.ContextUtil;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class SecureApacheSSLSocketFactory extends SSLSocketFactory {
    public static final X509HostnameVerifier BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = new BrowserCompatHostnameVerifier();
    public static final X509HostnameVerifier STRICT_HOSTNAME_VERIFIER = new StrictHostnameVerifier();

    /* renamed from: i */
    private static final String f2106i = "SecureApacheSSLSocketFactory";

    /* renamed from: j */
    private static volatile SecureApacheSSLSocketFactory f2107j = null;

    /* renamed from: a */
    private SSLContext f2108a;

    /* renamed from: b */
    private SSLSocket f2109b;

    /* renamed from: c */
    private Context f2110c;

    /* renamed from: d */
    private String[] f2111d;

    /* renamed from: e */
    private X509TrustManager f2112e;

    /* renamed from: f */
    private String[] f2113f;

    /* renamed from: g */
    private String[] f2114g;

    /* renamed from: h */
    private String[] f2115h;

    private SecureApacheSSLSocketFactory(KeyStore keyStore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        super(keyStore);
        this.f2109b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    /* renamed from: a */
    public static void m2331a(X509TrustManager x509TrustManager) {
        C1302e.m2408c(f2106i, "sasf update socket factory trust manager");
        try {
            f2107j = new SecureApacheSSLSocketFactory(null, x509TrustManager);
        } catch (IOException unused) {
            C1302e.m2407b(f2106i, "IOException");
        } catch (KeyManagementException unused2) {
            C1302e.m2407b(f2106i, "KeyManagementException");
        } catch (KeyStoreException unused3) {
            C1302e.m2407b(f2106i, "KeyStoreException");
        } catch (NoSuchAlgorithmException unused4) {
            C1302e.m2407b(f2106i, "NoSuchAlgorithmException");
        } catch (UnrecoverableKeyException unused5) {
            C1302e.m2407b(f2106i, "UnrecoverableKeyException");
        } catch (CertificateException unused6) {
            C1302e.m2407b(f2106i, "CertificateException");
        }
    }

    @Deprecated
    public static SecureApacheSSLSocketFactory getInstance(KeyStore keyStore, Context context) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        ContextUtil.setContext(context);
        if (f2107j == null) {
            synchronized (SecureApacheSSLSocketFactory.class) {
                if (f2107j == null) {
                    f2107j = new SecureApacheSSLSocketFactory(keyStore, context, (SecureRandom) null);
                }
            }
        }
        return f2107j;
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.LayeredSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        C1302e.m2408c(f2106i, "createSocket: socket host port autoClose");
        Socket createSocket = this.f2108a.getSocketFactory().createSocket(socket, str, i, z);
        if (createSocket instanceof SSLSocket) {
            m2330a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.f2109b = sSLSocket;
            this.f2111d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public String[] getBlackCiphers() {
        return this.f2113f;
    }

    public X509Certificate[] getChain() {
        X509TrustManager x509TrustManager = this.f2112e;
        return x509TrustManager instanceof SecureX509TrustManager ? ((SecureX509TrustManager) x509TrustManager).getChain() : new X509Certificate[0];
    }

    public Context getContext() {
        return this.f2110c;
    }

    public String[] getProtocols() {
        return this.f2115h;
    }

    public SSLContext getSslContext() {
        return this.f2108a;
    }

    public SSLSocket getSslSocket() {
        return this.f2109b;
    }

    public String[] getSupportedCipherSuites() {
        String[] strArr = this.f2111d;
        return strArr != null ? strArr : new String[0];
    }

    public String[] getWhiteCiphers() {
        return this.f2114g;
    }

    public X509TrustManager getX509TrustManager() {
        return this.f2112e;
    }

    public void setBlackCiphers(String[] strArr) {
        this.f2113f = strArr;
    }

    public void setContext(Context context) {
        this.f2110c = context.getApplicationContext();
    }

    public void setProtocols(String[] strArr) {
        this.f2115h = strArr;
    }

    public void setSslContext(SSLContext sSLContext) {
        this.f2108a = sSLContext;
    }

    public void setSslSocket(SSLSocket sSLSocket) {
        this.f2109b = sSLSocket;
    }

    public void setWhiteCiphers(String[] strArr) {
        this.f2114g = strArr;
    }

    public void setX509TrustManager(X509TrustManager x509TrustManager) {
        this.f2112e = x509TrustManager;
    }

    private SecureApacheSSLSocketFactory(KeyStore keyStore, Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException, NullPointerException {
        super(keyStore);
        this.f2109b = null;
        setContext(context);
        setSslContext(SSLUtil.setSSLContext());
        SecureX509TrustManager secureX509SingleInstance = SecureX509SingleInstance.getInstance(context);
        this.f2112e = secureX509SingleInstance;
        this.f2108a.init(null, new X509TrustManager[]{secureX509SingleInstance}, secureRandom);
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() throws IOException {
        C1302e.m2408c(f2106i, "createSocket: ");
        Socket createSocket = this.f2108a.getSocketFactory().createSocket();
        if (createSocket instanceof SSLSocket) {
            m2330a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.f2109b = sSLSocket;
            this.f2111d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public static SecureApacheSSLSocketFactory getInstance(KeyStore keyStore, Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        ContextUtil.setContext(context);
        if (f2107j == null) {
            synchronized (SecureApacheSSLSocketFactory.class) {
                if (f2107j == null) {
                    f2107j = new SecureApacheSSLSocketFactory(keyStore, context, secureRandom);
                }
            }
        }
        return f2107j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m2332a(X509TrustManager x509TrustManager, SecureRandom secureRandom) {
        C1302e.m2408c(f2106i, "sasf update socket factory trust manager");
        try {
            f2107j = new SecureApacheSSLSocketFactory((KeyStore) null, x509TrustManager, secureRandom);
        } catch (IOException unused) {
            C1302e.m2407b(f2106i, "IOException");
        } catch (KeyManagementException unused2) {
            C1302e.m2407b(f2106i, "KeyManagementException");
        } catch (KeyStoreException unused3) {
            C1302e.m2407b(f2106i, "KeyStoreException");
        } catch (NoSuchAlgorithmException unused4) {
            C1302e.m2407b(f2106i, "NoSuchAlgorithmException");
        } catch (UnrecoverableKeyException unused5) {
            C1302e.m2407b(f2106i, "UnrecoverableKeyException");
        } catch (CertificateException unused6) {
            C1302e.m2407b(f2106i, "CertificateException");
        }
    }

    @Deprecated
    public SecureApacheSSLSocketFactory(KeyStore keyStore, InputStream inputStream, String str) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        super(keyStore);
        this.f2109b = null;
        this.f2108a = SSLUtil.setSSLContext();
        HiCloudX509TrustManager hiCloudX509TrustManager = new HiCloudX509TrustManager(inputStream, str);
        setX509TrustManager(hiCloudX509TrustManager);
        this.f2108a.init(null, new X509TrustManager[]{hiCloudX509TrustManager}, null);
    }

    /* renamed from: a */
    private void m2330a(Socket socket) {
        boolean z;
        boolean z2 = false;
        if (C1298a.m2376a(this.f2115h)) {
            z = false;
        } else {
            C1302e.m2408c(f2106i, "set protocols");
            z = SSLUtil.setEnabledProtocols((SSLSocket) socket, this.f2115h);
        }
        if (!C1298a.m2376a(this.f2114g) || !C1298a.m2376a(this.f2113f)) {
            C1302e.m2408c(f2106i, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLUtil.setEnabledProtocols(sSLSocket);
            if (!C1298a.m2376a(this.f2114g)) {
                z2 = SSLUtil.setWhiteListCipherSuites(sSLSocket, this.f2114g);
            } else {
                z2 = SSLUtil.setBlackListCipherSuites(sSLSocket, this.f2113f);
            }
        }
        if (!z) {
            C1302e.m2408c(f2106i, "set default protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket);
        }
        if (z2) {
            return;
        }
        C1302e.m2408c(f2106i, "set default cipher suites");
        SSLUtil.setEnableSafeCipherSuites((SSLSocket) socket);
    }

    public SecureApacheSSLSocketFactory(KeyStore keyStore, InputStream inputStream, String str, SecureRandom secureRandom) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        super(keyStore);
        this.f2109b = null;
        this.f2108a = SSLUtil.setSSLContext();
        HiCloudX509TrustManager hiCloudX509TrustManager = new HiCloudX509TrustManager(inputStream, str);
        setX509TrustManager(hiCloudX509TrustManager);
        this.f2108a.init(null, new X509TrustManager[]{hiCloudX509TrustManager}, secureRandom);
    }

    @Deprecated
    public SecureApacheSSLSocketFactory(KeyStore keyStore, X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        super(keyStore);
        this.f2109b = null;
        this.f2108a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f2108a.init(null, new X509TrustManager[]{x509TrustManager}, null);
    }

    public SecureApacheSSLSocketFactory(KeyStore keyStore, X509TrustManager x509TrustManager, SecureRandom secureRandom) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        super(keyStore);
        this.f2109b = null;
        this.f2108a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f2108a.init(null, new X509TrustManager[]{x509TrustManager}, secureRandom);
    }
}
