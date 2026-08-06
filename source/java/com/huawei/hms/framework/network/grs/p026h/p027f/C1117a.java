package com.huawei.hms.framework.network.grs.p026h.p027f;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.vmsdk.inspector_new.server.websocket.Utf8Charset;
import com.huawei.hms.framework.common.IoUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.p026h.C1112a;
import com.huawei.hms.framework.network.grs.p026h.p028g.C1118a;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

/* renamed from: com.huawei.hms.framework.network.grs.h.f.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1117a {
    /* renamed from: a */
    public static HttpsURLConnection m1377a(String str, Context context, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        URLConnection openConnection = new URL(str).openConnection();
        if (!(openConnection instanceof HttpsURLConnection)) {
            Logger.m1189w("URLConnectionHelper", "urlConnection is not an instance of HttpsURLConnection");
            return null;
        }
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) openConnection;
        try {
            httpsURLConnection.setSSLSocketFactory(C1118a.m1380a(context));
            httpsURLConnection.setHostnameVerifier(C1118a.m1379a());
        } catch (IllegalArgumentException unused) {
            Logger.m1189w("URLConnectionHelper", "init https ssl socket failed.");
        }
        httpsURLConnection.setConnectTimeout(10000);
        httpsURLConnection.setReadTimeout(10000);
        httpsURLConnection.setDoOutput(true);
        httpsURLConnection.setUseCaches(false);
        String m1366b = C1112a.m1366b(context, "NetworkKit-grs", str2);
        Logger.m1180d("URLConnectionHelper", "request to grs server with a User-Agent header is: " + m1366b);
        httpsURLConnection.setRequestProperty("User-Agent", m1366b);
        return httpsURLConnection;
    }

    /* renamed from: a */
    public static void m1378a(HttpsURLConnection httpsURLConnection, String str) {
        OutputStream outputStream;
        String str2;
        if (str == null) {
            str2 = "sendHttpBody: The Body Data is Null";
        } else if (httpsURLConnection == null) {
            str2 = "sendHttpBody: HttpsURLConnection is Null";
        } else {
            try {
                outputStream = httpsURLConnection.getOutputStream();
                try {
                    outputStream.write(str.getBytes(Utf8Charset.NAME));
                    outputStream.flush();
                    IoUtils.closeSecure(outputStream);
                    return;
                } catch (Throwable th) {
                    th = th;
                    IoUtils.closeSecure(outputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                outputStream = null;
            }
        }
        Logger.m1185i("URLConnectionHelper", str2);
    }
}
