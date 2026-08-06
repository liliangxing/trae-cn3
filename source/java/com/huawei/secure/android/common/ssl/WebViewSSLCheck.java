package com.huawei.secure.android.common.ssl;

import android.content.Context;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import com.huawei.secure.android.common.ssl.WebViewSSLCheckThread;
import com.huawei.secure.android.common.ssl.util.C1299b;
import com.huawei.secure.android.common.ssl.util.C1302e;
import com.huawei.secure.android.common.ssl.util.C1305h;
import java.security.cert.X509Certificate;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class WebViewSSLCheck {

    /* renamed from: a */
    private static final String f2146a = "WebViewSSLCheck";

    public static void checkServerCertificateNew(SslErrorHandler sslErrorHandler, SslError sslError, Context context) {
        checkServerCertificateNew(sslErrorHandler, sslError, null, context, null);
    }

    public static void checkServerCertificateNew(SslErrorHandler sslErrorHandler, SslError sslError, String str, Context context, WebViewSSLCheckThread.Callback callback) {
        String str2 = f2146a;
        C1302e.m2408c(str2, " error type : " + sslError.getPrimaryError() + " , cn is : " + sslError.getCertificate().getIssuedTo().getCName());
        X509Certificate m2377a = C1299b.m2377a(sslError.getCertificate());
        X509Certificate m2422a = new C1305h(context).m2422a();
        C1302e.m2405a(str2, "checkServerCertificateNew: error certificate is : " + m2377a);
        if (C1299b.m2381a(m2422a, m2377a)) {
            C1302e.m2408c(str2, "checkServerCertificateNew: proceed");
            if (callback != null) {
                callback.onProceed(context, str);
                return;
            } else {
                sslErrorHandler.proceed();
                return;
            }
        }
        C1302e.m2407b(str2, "checkServerCertificateNew: cancel");
        if (callback != null) {
            callback.onCancel(context, str);
        } else {
            sslErrorHandler.cancel();
        }
    }

    public static boolean checkServerCertificateNew(X509Certificate x509Certificate, SslError sslError) {
        return C1299b.m2381a(x509Certificate, C1299b.m2377a(sslError.getCertificate()));
    }

    public static boolean checkServerCertificateNew(String str, SslError sslError) {
        return checkServerCertificateNew(C1299b.m2378a(str), sslError);
    }
}
