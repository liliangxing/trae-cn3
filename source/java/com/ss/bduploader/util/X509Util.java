package com.ss.bduploader.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.http.X509TrustManagerExtensions;
import android.os.Build;
import android.util.Log;
import android.util.Pair;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class X509Util {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String OID_ANY_EKU = "2.5.29.37.0";
    private static final String OID_SERVER_GATED_MICROSOFT = "1.3.6.1.4.1.311.10.3.3";
    private static final String OID_SERVER_GATED_NETSCAPE = "2.16.840.1.113730.4.1";
    private static final String OID_TLS_SERVER_AUTH = "1.3.6.1.5.5.7.3.1";
    private static final String TAG = "X509Util";
    private static CertificateFactory sCertificateFactory;
    private static X509TrustManagerImplementation sDefaultTrustManager;
    private static boolean sDisableNativeCodeForTest;
    private static boolean sLoadedSystemKeyStore;
    private static File sSystemCertificateDirectory;
    private static KeyStore sSystemKeyStore;
    private static Set<Pair<X500Principal, PublicKey>> sSystemTrustAnchorCache;
    private static KeyStore sTestKeyStore;
    private static X509TrustManagerImplementation sTestTrustManager;
    private static TrustStorageListener sTrustStorageListener;
    private static final Object sLock = new Object();
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface X509TrustManagerImplementation {
        List<X509Certificate> checkServerTrusted(X509Certificate[] x509CertificateArr, String str, String str2) throws CertificateException;
    }

    private static void ensureInitialized() throws CertificateException, KeyStoreException, NoSuchAlgorithmException {
        synchronized (sLock) {
            ensureInitializedLocked();
        }
    }

    private static void ensureInitializedLocked() throws CertificateException, KeyStoreException, NoSuchAlgorithmException {
        if (sCertificateFactory == null) {
            sCertificateFactory = CertificateFactory.getInstance("X.509");
        }
        if (sDefaultTrustManager == null) {
            sDefaultTrustManager = createTrustManager(null);
        }
        if (!sLoadedSystemKeyStore) {
            try {
                KeyStore keyStore = KeyStore.getInstance("AndroidCAStore");
                sSystemKeyStore = keyStore;
                try {
                    keyStore.load(null);
                } catch (IOException unused) {
                }
                sSystemCertificateDirectory = new File(System.getenv("ANDROID_ROOT") + "/etc/security/cacerts");
            } catch (KeyStoreException unused2) {
            }
            sLoadedSystemKeyStore = true;
        }
        if (sSystemTrustAnchorCache == null) {
            sSystemTrustAnchorCache = new HashSet();
        }
        if (sTestKeyStore == null) {
            KeyStore keyStore2 = KeyStore.getInstance(KeyStore.getDefaultType());
            sTestKeyStore = keyStore2;
            try {
                keyStore2.load(null);
            } catch (IOException unused3) {
            }
        }
        if (sTestTrustManager == null) {
            sTestTrustManager = createTrustManager(sTestKeyStore);
        }
        if (sTrustStorageListener == null) {
            sTrustStorageListener = new TrustStorageListener();
            IntentFilter intentFilter = new IntentFilter();
            if (Build.VERSION.SDK_INT >= 26) {
                intentFilter.addAction("android.security.action.KEYCHAIN_CHANGED");
                intentFilter.addAction("android.security.action.KEY_ACCESS_CHANGED");
                intentFilter.addAction("android.security.action.TRUST_STORE_CHANGED");
            } else {
                intentFilter.addAction("android.security.STORAGE_CHANGED");
            }
            m167x6e386675(NetUtils.getApplicationContext(), sTrustStorageListener, intentFilter);
        }
    }

    private static X509TrustManagerImplementation createTrustManager(KeyStore keyStore) throws KeyStoreException, NoSuchAlgorithmException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(keyStore);
        for (TrustManager trustManager : trustManagerFactory.getTrustManagers()) {
            if (trustManager instanceof X509TrustManager) {
                try {
                    return new X509TrustManagerJellyBean((X509TrustManager) trustManager);
                } catch (IllegalArgumentException e) {
                    Log.e(TAG, "Error creating trust manager (" + trustManager.getClass().getName() + "): " + e);
                }
            }
        }
        Log.e(TAG, "Could not find suitable trust manager");
        return null;
    }

    private static void reloadTestTrustManager() throws KeyStoreException, NoSuchAlgorithmException {
        sTestTrustManager = createTrustManager(sTestKeyStore);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void reloadDefaultTrustManager() throws KeyStoreException, NoSuchAlgorithmException, CertificateException {
        synchronized (sLock) {
            sDefaultTrustManager = null;
            sSystemTrustAnchorCache = null;
            ensureInitializedLocked();
        }
    }

    public static X509Certificate createCertificateFromBytes(byte[] bArr) throws CertificateException, KeyStoreException, NoSuchAlgorithmException {
        ensureInitialized();
        return (X509Certificate) sCertificateFactory.generateCertificate(new ByteArrayInputStream(bArr));
    }

    public static void addTestRootCertificate(byte[] bArr) throws CertificateException, KeyStoreException, NoSuchAlgorithmException {
        ensureInitialized();
        X509Certificate createCertificateFromBytes = createCertificateFromBytes(bArr);
        synchronized (sLock) {
            sTestKeyStore.setCertificateEntry("root_cert_" + Integer.toString(sTestKeyStore.size()), createCertificateFromBytes);
            reloadTestTrustManager();
        }
    }

    public static void clearTestRootCertificates() throws NoSuchAlgorithmException, CertificateException, KeyStoreException {
        ensureInitialized();
        synchronized (sLock) {
            try {
                sTestKeyStore.load(null);
                reloadTestTrustManager();
            } catch (IOException unused) {
            }
        }
    }

    private static String hashPrincipal(X500Principal x500Principal) throws NoSuchAlgorithmException {
        byte[] digest = MessageDigest.getInstance("MD5").digest(x500Principal.getEncoded());
        char[] cArr = new char[8];
        for (int i = 0; i < 4; i++) {
            int i2 = i * 2;
            char[] cArr2 = HEX_DIGITS;
            byte b = digest[3 - i];
            cArr[i2] = cArr2[(b >> 4) & 15];
            cArr[i2 + 1] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    private static boolean isKnownRoot(X509Certificate x509Certificate) throws NoSuchAlgorithmException, KeyStoreException {
        if (sSystemKeyStore == null) {
            return false;
        }
        Pair<X500Principal, PublicKey> pair = new Pair<>(x509Certificate.getSubjectX500Principal(), x509Certificate.getPublicKey());
        if (sSystemTrustAnchorCache.contains(pair)) {
            return true;
        }
        String hashPrincipal = hashPrincipal(x509Certificate.getSubjectX500Principal());
        int i = 0;
        while (true) {
            String str = hashPrincipal + '.' + i;
            if (!new File(sSystemCertificateDirectory, str).exists()) {
                return false;
            }
            Certificate certificate = sSystemKeyStore.getCertificate("system:" + str);
            if (certificate != null) {
                if (!(certificate instanceof X509Certificate)) {
                    Log.e(TAG, "Anchor " + str + " not an X509Certificate: " + certificate.getClass().getName());
                } else {
                    X509Certificate x509Certificate2 = (X509Certificate) certificate;
                    if (x509Certificate.getSubjectX500Principal().equals(x509Certificate2.getSubjectX500Principal()) && x509Certificate.getPublicKey().equals(x509Certificate2.getPublicKey())) {
                        sSystemTrustAnchorCache.add(pair);
                        return true;
                    }
                }
            }
            i++;
        }
    }

    static boolean verifyKeyUsage(X509Certificate x509Certificate) throws CertificateException {
        try {
            List<String> extendedKeyUsage = x509Certificate.getExtendedKeyUsage();
            if (extendedKeyUsage == null) {
                return true;
            }
            for (String str : extendedKeyUsage) {
                if (str.equals(OID_TLS_SERVER_AUTH) || str.equals(OID_ANY_EKU) || str.equals(OID_SERVER_GATED_NETSCAPE) || str.equals(OID_SERVER_GATED_MICROSOFT)) {
                    return true;
                }
            }
            return false;
        } catch (NullPointerException unused) {
            return false;
        }
    }

    public static AndroidCertVerifyResult verifyServerCertificates(byte[][] bArr, String str, String str2) throws KeyStoreException, NoSuchAlgorithmException {
        List<X509Certificate> checkServerTrusted;
        if (bArr != null && bArr.length != 0 && bArr[0] != null) {
            try {
                ensureInitialized();
                ArrayList arrayList = new ArrayList();
                try {
                    arrayList.add(createCertificateFromBytes(bArr[0]));
                    for (int i = 1; i < bArr.length; i++) {
                        try {
                            arrayList.add(createCertificateFromBytes(bArr[i]));
                        } catch (CertificateException unused) {
                            Log.w(TAG, "intermediate " + i + " failed parsing");
                        }
                    }
                    X509Certificate[] x509CertificateArr = (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
                    try {
                        x509CertificateArr[0].checkValidity();
                        if (!verifyKeyUsage(x509CertificateArr[0])) {
                            return new AndroidCertVerifyResult(-6);
                        }
                        synchronized (sLock) {
                            X509TrustManagerImplementation x509TrustManagerImplementation = sDefaultTrustManager;
                            if (x509TrustManagerImplementation == null) {
                                return new AndroidCertVerifyResult(-1);
                            }
                            try {
                                checkServerTrusted = x509TrustManagerImplementation.checkServerTrusted(x509CertificateArr, str, str2);
                            } catch (CertificateException e) {
                                try {
                                    checkServerTrusted = sTestTrustManager.checkServerTrusted(x509CertificateArr, str, str2);
                                } catch (CertificateException unused2) {
                                    Log.i(TAG, "Failed to validate the certificate chain, error: " + e.getMessage());
                                    return new AndroidCertVerifyResult(-2);
                                }
                            }
                            return new AndroidCertVerifyResult(0, checkServerTrusted.size() > 0 ? isKnownRoot(checkServerTrusted.get(checkServerTrusted.size() - 1)) : false, checkServerTrusted);
                        }
                    } catch (CertificateExpiredException unused3) {
                        return new AndroidCertVerifyResult(-3);
                    } catch (CertificateNotYetValidException unused4) {
                        return new AndroidCertVerifyResult(-4);
                    } catch (CertificateException unused5) {
                        return new AndroidCertVerifyResult(-1);
                    }
                } catch (CertificateException unused6) {
                    return new AndroidCertVerifyResult(-5);
                }
            } catch (CertificateException unused7) {
                return new AndroidCertVerifyResult(-1);
            }
        }
        throw new IllegalArgumentException("Expected non-null and non-empty certificate chain passed as |certChain|. |certChain|=" + Arrays.deepToString(bArr));
    }

    public static void setDisableNativeCodeForTest(boolean z) {
        sDisableNativeCodeForTest = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static final class X509TrustManagerJellyBean implements X509TrustManagerImplementation {
        private final X509TrustManagerExtensions mTrustManagerExtensions;

        public X509TrustManagerJellyBean(X509TrustManager x509TrustManager) {
            this.mTrustManagerExtensions = new X509TrustManagerExtensions(x509TrustManager);
        }

        @Override // com.ss.bduploader.util.X509Util.X509TrustManagerImplementation
        public List<X509Certificate> checkServerTrusted(X509Certificate[] x509CertificateArr, String str, String str2) throws CertificateException {
            return this.mTrustManagerExtensions.checkServerTrusted(x509CertificateArr, str, str2);
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private static final class X509TrustManagerIceCreamSandwich implements X509TrustManagerImplementation {
        private final X509TrustManager mTrustManager;

        public X509TrustManagerIceCreamSandwich(X509TrustManager x509TrustManager) {
            this.mTrustManager = x509TrustManager;
        }

        @Override // com.ss.bduploader.util.X509Util.X509TrustManagerImplementation
        public List<X509Certificate> checkServerTrusted(X509Certificate[] x509CertificateArr, String str, String str2) throws CertificateException {
            this.mTrustManager.checkServerTrusted(x509CertificateArr, str);
            return Collections.emptyList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static final class TrustStorageListener extends BroadcastReceiver {
        private TrustStorageListener() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean equals;
            if (Build.VERSION.SDK_INT >= 26) {
                equals = true;
                if (!"android.security.action.KEYCHAIN_CHANGED".equals(intent.getAction()) && !"android.security.action.TRUST_STORE_CHANGED".equals(intent.getAction()) && (!"android.security.action.KEY_ACCESS_CHANGED".equals(intent.getAction()) || intent.getBooleanExtra("android.security.extra.KEY_ACCESSIBLE", false))) {
                    equals = false;
                }
            } else {
                equals = "android.security.STORAGE_CHANGED".equals(intent.getAction());
            }
            if (equals) {
                try {
                    X509Util.reloadDefaultTrustManager();
                } catch (KeyStoreException e) {
                    Log.e(X509Util.TAG, "Unable to reload the default TrustManager", e);
                } catch (NoSuchAlgorithmException e2) {
                    Log.e(X509Util.TAG, "Unable to reload the default TrustManager", e2);
                } catch (CertificateException e3) {
                    Log.e(X509Util.TAG, "Unable to reload the default TrustManager", e3);
                }
            }
        }
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    /* renamed from: INVOKEVIRTUAL_com_ss_bduploader_util_X509Util_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m167x6e386675(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        }
        try {
            if (ReceiverRegisterCrashOptimizer.doRegisterHandler()) {
                ReceiverRegisterLancet.initHandler();
                Context context2 = context;
                return context.registerReceiver(broadcastReceiver, intentFilter, null, ReceiverRegisterLancet.sReceiverHandler);
            }
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null && ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(intentFilter)) {
                ReceiverRegisterLancet.initProxyHandler();
                Context context3 = context;
                return ContextCompat.registerReceiver(context, broadcastReceiver, intentFilter, (String) null, ReceiverRegisterLancet.sProxyHandler, 2);
            }
            return context.registerReceiver(broadcastReceiver, intentFilter);
        } catch (Exception e) {
            if (!ReceiverRegisterCrashOptimizer.fixedOpen()) {
                throw e;
            }
            return ReceiverRegisterCrashOptimizer.registerReceiver(broadcastReceiver, intentFilter);
        }
    }
}
