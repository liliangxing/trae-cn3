package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.C1298a;
import com.huawei.secure.android.common.ssl.util.C1302e;
import com.huawei.secure.android.common.ssl.util.ContextUtil;
import java.io.IOException;
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
import org.apache.http.conn.ssl.SSLSocketFactory;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class SASFCompatiableSystemCA extends SSLSocketFactory {

    /* renamed from: i */
    private static final String f2076i = "SASFCompatiableSystemCA";

    /* renamed from: j */
    private static volatile SASFCompatiableSystemCA f2077j;

    /* renamed from: a */
    private SSLContext f2078a;

    /* renamed from: b */
    private SSLSocket f2079b;

    /* renamed from: c */
    private Context f2080c;

    /* renamed from: d */
    private String[] f2081d;

    /* renamed from: e */
    private X509TrustManager f2082e;

    /* renamed from: f */
    private String[] f2083f;

    /* renamed from: g */
    private String[] f2084g;

    /* renamed from: h */
    private String[] f2085h;

    private SASFCompatiableSystemCA(KeyStore keyStore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        super(keyStore);
        this.f2079b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    /* renamed from: a */
    public static void m2325a(X509TrustManager x509TrustManager) {
        C1302e.m2408c(f2076i, "sasfc update socket factory trust manager");
        long currentTimeMillis = System.currentTimeMillis();
        try {
            f2077j = new SASFCompatiableSystemCA(null, x509TrustManager);
        } catch (KeyManagementException unused) {
            C1302e.m2407b(f2076i, "KeyManagementException");
        } catch (KeyStoreException unused2) {
            C1302e.m2407b(f2076i, "KeyStoreException");
        } catch (NoSuchAlgorithmException unused3) {
            C1302e.m2407b(f2076i, "NoSuchAlgorithmException");
        } catch (UnrecoverableKeyException unused4) {
            C1302e.m2407b(f2076i, "UnrecoverableKeyException");
        }
        C1302e.m2405a(f2076i, "sasf system ca update: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    @Deprecated
    public static SASFCompatiableSystemCA getInstance(KeyStore keyStore, Context context) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        ContextUtil.setContext(context);
        if (f2077j == null) {
            synchronized (SecureApacheSSLSocketFactory.class) {
                if (f2077j == null) {
                    f2077j = new SASFCompatiableSystemCA(keyStore, context, (SecureRandom) null);
                }
            }
        }
        return f2077j;
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.LayeredSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        C1302e.m2408c(f2076i, "createSocket: socket host port autoClose");
        Socket createSocket = this.f2078a.getSocketFactory().createSocket(socket, str, i, z);
        if (createSocket instanceof SSLSocket) {
            m2324a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.f2079b = sSLSocket;
            this.f2081d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public String[] getBlackCiphers() {
        return this.f2083f;
    }

    public X509Certificate[] getChain() {
        X509TrustManager x509TrustManager = this.f2082e;
        return x509TrustManager instanceof SecureX509TrustManager ? ((SecureX509TrustManager) x509TrustManager).getChain() : new X509Certificate[0];
    }

    public Context getContext() {
        return this.f2080c;
    }

    public String[] getProtocols() {
        return this.f2085h;
    }

    public SSLContext getSslContext() {
        return this.f2078a;
    }

    public SSLSocket getSslSocket() {
        return this.f2079b;
    }

    public String[] getSupportedCipherSuites() {
        String[] strArr = this.f2081d;
        return strArr != null ? strArr : new String[0];
    }

    public String[] getWhiteCiphers() {
        return this.f2084g;
    }

    public X509TrustManager getX509TrustManager() {
        return this.f2082e;
    }

    public void setBlackCiphers(String[] strArr) {
        this.f2083f = strArr;
    }

    public void setContext(Context context) {
        this.f2080c = context.getApplicationContext();
    }

    public void setProtocols(String[] strArr) {
        this.f2085h = strArr;
    }

    public void setSslContext(SSLContext sSLContext) {
        this.f2078a = sSLContext;
    }

    public void setSslSocket(SSLSocket sSLSocket) {
        this.f2079b = sSLSocket;
    }

    public void setWhiteCiphers(String[] strArr) {
        this.f2084g = strArr;
    }

    public void setX509TrustManager(X509TrustManager x509TrustManager) {
        this.f2082e = x509TrustManager;
    }

    private SASFCompatiableSystemCA(KeyStore keyStore, Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException, NullPointerException {
        super(keyStore);
        this.f2079b = null;
        setContext(context);
        setSslContext(SSLUtil.setSSLContext());
        SecureX509TrustManager sSFSecureX509SingleInstance = SSFSecureX509SingleInstance.getInstance(context);
        this.f2082e = sSFSecureX509SingleInstance;
        this.f2078a.init(null, new X509TrustManager[]{sSFSecureX509SingleInstance}, secureRandom);
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() throws IOException {
        C1302e.m2408c(f2076i, "createSocket: ");
        Socket createSocket = this.f2078a.getSocketFactory().createSocket();
        if (createSocket instanceof SSLSocket) {
            m2324a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.f2079b = sSLSocket;
            this.f2081d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public static SASFCompatiableSystemCA getInstance(KeyStore keyStore, Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        ContextUtil.setContext(context);
        if (f2077j == null) {
            synchronized (SecureApacheSSLSocketFactory.class) {
                if (f2077j == null) {
                    f2077j = new SASFCompatiableSystemCA(keyStore, context, secureRandom);
                }
            }
        }
        return f2077j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m2326a(X509TrustManager x509TrustManager, SecureRandom secureRandom) {
        C1302e.m2408c(f2076i, "sasfc update socket factory trust manager");
        long currentTimeMillis = System.currentTimeMillis();
        try {
            f2077j = new SASFCompatiableSystemCA((KeyStore) null, x509TrustManager, secureRandom);
        } catch (KeyManagementException unused) {
            C1302e.m2407b(f2076i, "KeyManagementException");
        } catch (KeyStoreException unused2) {
            C1302e.m2407b(f2076i, "KeyStoreException");
        } catch (NoSuchAlgorithmException unused3) {
            C1302e.m2407b(f2076i, "NoSuchAlgorithmException");
        } catch (UnrecoverableKeyException unused4) {
            C1302e.m2407b(f2076i, "UnrecoverableKeyException");
        }
        C1302e.m2405a(f2076i, "sasf system ca update: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    @Deprecated
    public SASFCompatiableSystemCA(KeyStore keyStore, X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException, UnrecoverableKeyException, KeyStoreException {
        super(keyStore);
        this.f2079b = null;
        this.f2078a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f2078a.init(null, new X509TrustManager[]{x509TrustManager}, null);
    }

    /* renamed from: a */
    private void m2324a(Socket socket) {
        boolean z;
        boolean z2 = false;
        if (C1298a.m2376a(this.f2085h)) {
            z = false;
        } else {
            C1302e.m2408c(f2076i, "set protocols");
            z = SSLUtil.setEnabledProtocols((SSLSocket) socket, this.f2085h);
        }
        if (!C1298a.m2376a(this.f2084g) || !C1298a.m2376a(this.f2083f)) {
            C1302e.m2408c(f2076i, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLUtil.setEnabledProtocols(sSLSocket);
            if (!C1298a.m2376a(this.f2084g)) {
                z2 = SSLUtil.setWhiteListCipherSuites(sSLSocket, this.f2084g);
            } else {
                z2 = SSLUtil.setBlackListCipherSuites(sSLSocket, this.f2083f);
            }
        }
        if (!z) {
            C1302e.m2408c(f2076i, "set default protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket);
        }
        if (z2) {
            return;
        }
        C1302e.m2408c(f2076i, "set default cipher suites");
        SSLUtil.setEnableSafeCipherSuites((SSLSocket) socket);
    }

    public SASFCompatiableSystemCA(KeyStore keyStore, X509TrustManager x509TrustManager, SecureRandom secureRandom) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException, UnrecoverableKeyException, KeyStoreException {
        super(keyStore);
        this.f2079b = null;
        this.f2078a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f2078a.init(null, new X509TrustManager[]{x509TrustManager}, secureRandom);
    }
}
