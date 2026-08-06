package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.C1299b;
import com.huawei.secure.android.common.ssl.util.C1302e;
import com.huawei.secure.android.common.ssl.util.C1305h;
import com.huawei.secure.android.common.ssl.util.ContextUtil;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.X509TrustManager;

/* renamed from: com.huawei.secure.android.common.ssl.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1295c implements X509TrustManager {

    /* renamed from: c */
    private static final String f2168c = "WebViewX509TrustManger";

    /* renamed from: a */
    private X509Certificate f2169a;

    /* renamed from: b */
    private List<X509TrustManager> f2170b = new ArrayList();

    public C1295c(Context context) {
        if (context != null) {
            ContextUtil.setContext(context);
            X509Certificate m2424b = new C1305h(context).m2424b();
            this.f2169a = m2424b;
            if (m2424b == null) {
                throw new NullPointerException("WebViewX509TrustManger cannot get cbg root ca");
            }
            return;
        }
        throw new NullPointerException("WebViewX509TrustManger context is null");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        C1302e.m2408c(f2168c, "checkClientTrusted");
        if (!this.f2170b.isEmpty()) {
            this.f2170b.get(0).checkClientTrusted(x509CertificateArr, str);
            return;
        }
        throw new CertificateException("checkClientTrusted CertificateException");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        C1302e.m2408c(f2168c, "checkServerTrusted");
        boolean z = false;
        for (int i = 0; i < x509CertificateArr.length; i++) {
            C1302e.m2405a(f2168c, "checkServerTrusted " + i + " : " + x509CertificateArr[i].getIssuerDN().getName());
        }
        X509Certificate[] x509CertificateArr2 = new X509Certificate[x509CertificateArr.length];
        for (int i2 = 0; i2 < x509CertificateArr.length; i2++) {
            x509CertificateArr2[i2] = x509CertificateArr[(x509CertificateArr.length - 1) - i2];
        }
        CertificateException e = new CertificateException("CBG root CA CertificateException");
        try {
            z = C1299b.m2382a(this.f2169a, x509CertificateArr2);
        } catch (InvalidKeyException e2) {
            C1302e.m2407b(f2168c, "checkServerTrusted InvalidKeyException: " + e2.getMessage());
        } catch (NoSuchAlgorithmException e3) {
            C1302e.m2407b(f2168c, "checkServerTrusted NoSuchAlgorithmException: " + e3.getMessage());
        } catch (NoSuchProviderException e4) {
            C1302e.m2407b(f2168c, "checkServerTrusted NoSuchProviderException: " + e4.getMessage());
        } catch (SignatureException e5) {
            C1302e.m2407b(f2168c, "checkServerTrusted SignatureException: " + e5.getMessage());
        } catch (CertificateException e6) {
            e = e6;
            C1302e.m2407b(f2168c, "checkServerTrusted CertificateException: " + e.getMessage());
        }
        if (!z) {
            throw e;
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        try {
            ArrayList arrayList = new ArrayList();
            Iterator<X509TrustManager> it = this.f2170b.iterator();
            while (it.hasNext()) {
                arrayList.addAll(Arrays.asList(it.next().getAcceptedIssuers()));
            }
            return (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
        } catch (Exception e) {
            C1302e.m2407b(f2168c, "getAcceptedIssuers exception : " + e.getMessage());
            return new X509Certificate[0];
        }
    }
}
