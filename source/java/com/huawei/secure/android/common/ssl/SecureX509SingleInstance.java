package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.BksUtil;
import com.huawei.secure.android.common.ssl.util.C1302e;
import com.huawei.secure.android.common.ssl.util.ContextUtil;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class SecureX509SingleInstance {

    /* renamed from: a */
    private static final String f2136a = "SecureX509SingleInstance";

    /* renamed from: b */
    private static volatile SecureX509TrustManager f2137b;

    private SecureX509SingleInstance() {
    }

    public static SecureX509TrustManager getInstance(Context context) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
        InputStream inputStream;
        long currentTimeMillis = System.currentTimeMillis();
        if (context != null) {
            ContextUtil.setContext(context);
            if (f2137b == null) {
                synchronized (SecureX509SingleInstance.class) {
                    if (f2137b == null) {
                        try {
                            inputStream = BksUtil.getFilesBksIS(context);
                        } catch (RuntimeException unused) {
                            C1302e.m2407b(f2136a, "get files bks error");
                            inputStream = null;
                        }
                        if (inputStream == null) {
                            C1302e.m2408c(f2136a, "get assets bks");
                            inputStream = context.getAssets().open("hmsrootcas.bks");
                        } else {
                            C1302e.m2408c(f2136a, "get files bks");
                        }
                        f2137b = new SecureX509TrustManager(inputStream, "");
                    }
                }
            }
            C1302e.m2405a(f2136a, "SecureX509TrustManager getInstance: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            return f2137b;
        }
        throw new NullPointerException("context is null");
    }

    @Deprecated
    public static void updateBks(InputStream inputStream) {
        String str = f2136a;
        C1302e.m2408c(str, "update bks");
        long currentTimeMillis = System.currentTimeMillis();
        if (inputStream != null && f2137b != null) {
            f2137b = new SecureX509TrustManager(inputStream, "");
            SecureSSLSocketFactory.m2334a(f2137b);
            SecureApacheSSLSocketFactory.m2331a(f2137b);
        }
        C1302e.m2408c(str, "SecureX509TrustManager update bks cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    public static void updateBks(InputStream inputStream, SecureRandom secureRandom) {
        String str = f2136a;
        C1302e.m2408c(str, "update bks");
        long currentTimeMillis = System.currentTimeMillis();
        if (inputStream != null && f2137b != null) {
            f2137b = new SecureX509TrustManager(inputStream, "");
            SecureSSLSocketFactory.m2335a(f2137b, secureRandom);
            SecureApacheSSLSocketFactory.m2332a(f2137b, secureRandom);
        }
        C1302e.m2408c(str, "SecureX509TrustManager update bks cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }
}
