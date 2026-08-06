package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/* renamed from: com.huawei.secure.android.common.ssl.util.h */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1305h {

    /* renamed from: b */
    private static final String f2212b = "X509CertificateUtil";

    /* renamed from: c */
    public static final String f2213c = "hmsrootcas.bks";

    /* renamed from: d */
    public static final String f2214d = "";

    /* renamed from: e */
    public static final String f2215e = "bks";

    /* renamed from: f */
    public static final String f2216f = "052root";

    /* renamed from: g */
    private static final String f2217g = "hmsincas.bks";

    /* renamed from: h */
    private static final String f2218h = "huawei cbg application integration ca";

    /* renamed from: a */
    private Context f2219a;

    public C1305h(Context context) {
        this.f2219a = context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* renamed from: a */
    public X509Certificate m2423a(String str, String str2) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        X509Certificate x509Certificate = null;
        try {
            try {
                KeyStore keyStore = KeyStore.getInstance(f2215e);
                inputStream = this.f2219a.getAssets().open(str);
                try {
                    inputStream.reset();
                    keyStore.load(inputStream, "".toCharArray());
                    x509Certificate = (X509Certificate) keyStore.getCertificate(str2);
                    str = inputStream;
                } catch (IOException e) {
                    e = e;
                    C1302e.m2407b(f2212b, "loadBksCA: exception : " + e.getMessage());
                    str = inputStream;
                    AbstractC1301d.m2398a((InputStream) str);
                    return x509Certificate;
                } catch (KeyStoreException e2) {
                    e = e2;
                    C1302e.m2407b(f2212b, "loadBksCA: exception : " + e.getMessage());
                    str = inputStream;
                    AbstractC1301d.m2398a((InputStream) str);
                    return x509Certificate;
                } catch (NoSuchAlgorithmException e3) {
                    e = e3;
                    C1302e.m2407b(f2212b, "loadBksCA: exception : " + e.getMessage());
                    str = inputStream;
                    AbstractC1301d.m2398a((InputStream) str);
                    return x509Certificate;
                } catch (CertificateException e4) {
                    e = e4;
                    C1302e.m2407b(f2212b, "loadBksCA: exception : " + e.getMessage());
                    str = inputStream;
                    AbstractC1301d.m2398a((InputStream) str);
                    return x509Certificate;
                }
            } catch (Throwable th) {
                th = th;
                inputStream2 = str;
                AbstractC1301d.m2398a(inputStream2);
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            inputStream = null;
            C1302e.m2407b(f2212b, "loadBksCA: exception : " + e.getMessage());
            str = inputStream;
            AbstractC1301d.m2398a((InputStream) str);
            return x509Certificate;
        } catch (KeyStoreException e6) {
            e = e6;
            inputStream = null;
            C1302e.m2407b(f2212b, "loadBksCA: exception : " + e.getMessage());
            str = inputStream;
            AbstractC1301d.m2398a((InputStream) str);
            return x509Certificate;
        } catch (NoSuchAlgorithmException e7) {
            e = e7;
            inputStream = null;
            C1302e.m2407b(f2212b, "loadBksCA: exception : " + e.getMessage());
            str = inputStream;
            AbstractC1301d.m2398a((InputStream) str);
            return x509Certificate;
        } catch (CertificateException e8) {
            e = e8;
            inputStream = null;
            C1302e.m2407b(f2212b, "loadBksCA: exception : " + e.getMessage());
            str = inputStream;
            AbstractC1301d.m2398a((InputStream) str);
            return x509Certificate;
        } catch (Throwable th2) {
            th = th2;
            AbstractC1301d.m2398a(inputStream2);
            throw th;
        }
        AbstractC1301d.m2398a((InputStream) str);
        return x509Certificate;
    }

    /* renamed from: b */
    public X509Certificate m2424b() {
        return m2423a("hmsrootcas.bks", f2216f);
    }

    /* renamed from: a */
    public X509Certificate m2422a() {
        return m2423a(f2217g, f2218h);
    }
}
