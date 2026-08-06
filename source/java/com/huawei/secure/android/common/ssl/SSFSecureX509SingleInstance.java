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
public class SSFSecureX509SingleInstance {

    /* renamed from: a */
    private static final String f2096a = "SSFSecureX509SingleInstance";

    /* renamed from: b */
    private static volatile SecureX509TrustManager f2097b;

    private SSFSecureX509SingleInstance() {
    }

    public static SecureX509TrustManager getInstance(Context context) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
        if (context != null) {
            ContextUtil.setContext(context);
            if (f2097b == null) {
                synchronized (SSFSecureX509SingleInstance.class) {
                    if (f2097b == null) {
                        InputStream filesBksIS = BksUtil.getFilesBksIS(context);
                        if (filesBksIS == null) {
                            C1302e.m2408c(f2096a, "get assets bks");
                            filesBksIS = context.getAssets().open("hmsrootcas.bks");
                        } else {
                            C1302e.m2408c(f2096a, "get files bks");
                        }
                        f2097b = new SecureX509TrustManager(filesBksIS, "", true);
                    }
                }
            }
            return f2097b;
        }
        throw new NullPointerException("context is null");
    }

    @Deprecated
    public static void updateBks(InputStream inputStream) {
        String str = f2096a;
        C1302e.m2408c(str, "update bks");
        long currentTimeMillis = System.currentTimeMillis();
        if (inputStream != null && f2097b != null) {
            f2097b = new SecureX509TrustManager(inputStream, "", true);
            C1302e.m2405a(str, "updateBks: new SecureX509TrustManager cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            SSFCompatiableSystemCA.m2328a(f2097b);
            SASFCompatiableSystemCA.m2325a(f2097b);
        }
        C1302e.m2405a(str, "update bks cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    public static void updateBks(InputStream inputStream, SecureRandom secureRandom) {
        String str = f2096a;
        C1302e.m2408c(str, "update bks");
        long currentTimeMillis = System.currentTimeMillis();
        if (inputStream != null && f2097b != null) {
            f2097b = new SecureX509TrustManager(inputStream, "", true);
            C1302e.m2405a(str, "updateBks: new SecureX509TrustManager cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            SSFCompatiableSystemCA.m2329a(f2097b, secureRandom);
            SASFCompatiableSystemCA.m2326a(f2097b, secureRandom);
        }
        C1302e.m2405a(str, "update bks cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }
}
