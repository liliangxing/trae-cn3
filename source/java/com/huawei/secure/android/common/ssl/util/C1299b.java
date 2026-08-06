package com.huawei.secure.android.common.ssl.util;

import android.net.http.SslCertificate;
import java.io.ByteArrayInputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/* renamed from: com.huawei.secure.android.common.ssl.util.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1299b {

    /* renamed from: a */
    private static final String f2200a = "b";

    /* renamed from: b */
    private static final int f2201b = 5;

    /* renamed from: a */
    public static X509Certificate m2378a(String str) {
        try {
            return (X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(str.getBytes()));
        } catch (CertificateException e) {
            C1302e.m2407b(f2200a, "generateX509FromStr: CertificateException" + e.getMessage());
            return null;
        }
    }

    /* renamed from: b */
    public static boolean m2386b(X509Certificate[] x509CertificateArr) {
        Date date = new Date();
        for (X509Certificate x509Certificate : x509CertificateArr) {
            try {
                x509Certificate.checkValidity(date);
            } catch (CertificateExpiredException e) {
                e = e;
                C1302e.m2407b(f2200a, "verifyCertificateDate: exception : " + e.getMessage());
                return false;
            } catch (CertificateNotYetValidException e2) {
                e = e2;
                C1302e.m2407b(f2200a, "verifyCertificateDate: exception : " + e.getMessage());
                return false;
            } catch (Exception e3) {
                C1302e.m2407b(f2200a, "verifyCertificateDate : exception : " + e3.getMessage());
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m2383a(X509Certificate x509Certificate, X509Certificate[] x509CertificateArr, X509CRL x509crl, String str) throws NoSuchAlgorithmException, CertificateException, NoSuchProviderException, InvalidKeyException, SignatureException {
        return !m2382a(x509Certificate, x509CertificateArr) && !m2385a(x509CertificateArr, x509crl) && m2380a(x509CertificateArr[x509CertificateArr.length - 1], str) && m2386b(x509CertificateArr);
    }

    /* renamed from: a */
    public static boolean m2385a(X509Certificate[] x509CertificateArr, X509CRL x509crl) {
        ArrayList arrayList = new ArrayList();
        for (X509Certificate x509Certificate : x509CertificateArr) {
            arrayList.add(x509Certificate.getSerialNumber());
        }
        if (x509crl == null) {
            return true;
        }
        try {
            Set<? extends X509CRLEntry> revokedCertificates = x509crl.getRevokedCertificates();
            if (revokedCertificates != null && !revokedCertificates.isEmpty()) {
                Iterator<? extends X509CRLEntry> it = revokedCertificates.iterator();
                while (it.hasNext()) {
                    if (arrayList.contains(it.next().getSerialNumber())) {
                        C1302e.m2407b(f2200a, "verify: certificate revoked");
                        return false;
                    }
                }
            }
            return true;
        } catch (Exception e) {
            C1302e.m2407b(f2200a, "verify: revoked verify exception : " + e.getMessage());
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m2380a(X509Certificate x509Certificate, String str) {
        if (str.equals(x509Certificate.getSubjectDN().getName())) {
            return true;
        }
        C1302e.m2407b(f2200a, "verify: subject name is error");
        return false;
    }

    /* renamed from: a */
    public static boolean m2381a(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        try {
            x509Certificate2.verify(x509Certificate.getPublicKey());
            if (m2386b(new X509Certificate[]{x509Certificate, x509Certificate2})) {
                return true;
            }
            C1302e.m2407b(f2200a, "verify: date not right");
            return false;
        } catch (InvalidKeyException e) {
            C1302e.m2407b(f2200a, "verify: publickey InvalidKeyException " + e.getMessage());
            return false;
        } catch (NoSuchAlgorithmException e2) {
            C1302e.m2407b(f2200a, "verify: publickey NoSuchAlgorithmException " + e2.getMessage());
            return false;
        } catch (NoSuchProviderException e3) {
            C1302e.m2407b(f2200a, "verify: publickey NoSuchProviderException " + e3.getMessage());
            return false;
        } catch (SignatureException e4) {
            C1302e.m2407b(f2200a, "verify: publickey SignatureException " + e4.getMessage());
            return false;
        } catch (CertificateException e5) {
            C1302e.m2407b(f2200a, "verify: publickey CertificateException " + e5.getMessage());
            return false;
        } catch (Exception e6) {
            C1302e.m2407b(f2200a, "verify: Exception " + e6.getMessage());
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m2382a(X509Certificate x509Certificate, X509Certificate[] x509CertificateArr) throws NoSuchProviderException, CertificateException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Principal principal = null;
        int i = 0;
        while (i < x509CertificateArr.length) {
            X509Certificate x509Certificate2 = x509CertificateArr[i];
            Principal issuerDN = x509Certificate2.getIssuerDN();
            Principal subjectDN = x509Certificate2.getSubjectDN();
            if (principal != null) {
                if (issuerDN.equals(principal)) {
                    x509CertificateArr[i].verify(x509CertificateArr[i - 1].getPublicKey());
                } else {
                    C1302e.m2407b(f2200a, "verify: principalIssuer not match");
                    return false;
                }
            }
            i++;
            principal = subjectDN;
        }
        return m2381a(x509Certificate, x509CertificateArr[0]) && m2386b(x509CertificateArr) && m2379a(x509Certificate) && m2384a(x509CertificateArr);
    }

    /* renamed from: a */
    public static X509Certificate m2377a(SslCertificate sslCertificate) {
        byte[] byteArray = SslCertificate.saveState(sslCertificate).getByteArray("x509-certificate");
        if (byteArray != null) {
            try {
                return (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(byteArray));
            } catch (CertificateException e) {
                C1302e.m2406a(f2200a, "exception", e);
            }
        }
        return null;
    }

    /* renamed from: a */
    public static boolean m2384a(X509Certificate[] x509CertificateArr) {
        for (int i = 0; i < x509CertificateArr.length - 1; i++) {
            if (!m2379a(x509CertificateArr[i])) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m2379a(X509Certificate x509Certificate) {
        if (x509Certificate == null || x509Certificate.getBasicConstraints() == -1) {
            return false;
        }
        return x509Certificate.getKeyUsage()[5];
    }
}
