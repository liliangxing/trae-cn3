package cn.com.chinatelecom.account.api.p009d;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import androidx.webkit.ProxyConfig;
import cn.com.chinatelecom.account.api.CtAuth;
import cn.com.chinatelecom.account.api.p008c.C0683c;
import cn.com.chinatelecom.account.api.p010e.C0697d;
import cn.com.chinatelecom.account.api.p010e.C0700g;
import coil3.network.internal.Utils_commonKt;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

/* renamed from: cn.com.chinatelecom.account.api.d.f */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public abstract class AbstractC0691f implements InterfaceC0690e {

    /* renamed from: b */
    private static final String f220b = "f";

    /* renamed from: a */
    protected Context f221a;

    public AbstractC0691f(Context context) {
        this.f221a = context;
    }

    /* renamed from: a */
    public static void m249a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager.getNetworkInfo(5).getState().compareTo(NetworkInfo.State.CONNECTED) == 0) {
                ((Boolean) Class.forName("android.net.ConnectivityManager").getMethod("requestRouteToHost", Integer.TYPE, Integer.TYPE).invoke(connectivityManager, 5, Integer.valueOf(C0683c.m221a(C0683c.m224b(str))))).booleanValue();
            }
        } catch (Throwable th) {
            CtAuth.warn(f220b, "http doPost > requestUrlToRoute error", th);
        }
    }

    /* renamed from: b */
    private boolean m250b() {
        return C0700g.m343c(this.f221a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public boolean m251a() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public boolean m252a(String str) {
        return str.startsWith(ProxyConfig.MATCH_HTTPS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public boolean m253a(boolean z, String str) {
        return z && str != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public HttpURLConnection m254d(String str, String str2, int i, C0692g c0692g) {
        URL url = new URL(str);
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((c0692g.f222a == null || !m251a()) ? url.openConnection() : c0692g.f222a.openConnection(url));
        httpURLConnection.setRequestProperty("accept", "*/*");
        if (i == 0) {
            httpURLConnection.setRequestMethod(Utils_commonKt.HTTP_METHOD_GET);
        } else {
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
        }
        httpURLConnection.setConnectTimeout(c0692g.m256a());
        httpURLConnection.setReadTimeout(c0692g.m257b());
        httpURLConnection.setUseCaches(false);
        if (!m250b() && !m251a()) {
            httpURLConnection.setInstanceFollowRedirects(false);
        }
        httpURLConnection.addRequestProperty("Accept-Charset", UrlUtils.UTF_8);
        httpURLConnection.addRequestProperty("reqId", c0692g.f225d);
        httpURLConnection.addRequestProperty("deviceId", C0697d.m297a(this.f221a));
        if (TextUtils.isEmpty(str2)) {
            httpURLConnection.connect();
        } else {
            DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(httpURLConnection.getOutputStream()));
            dataOutputStream.write(str2.getBytes(UrlUtils.UTF_8));
            dataOutputStream.flush();
            dataOutputStream.close();
        }
        return httpURLConnection;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: e */
    public HttpsURLConnection m255e(String str, String str2, int i, C0692g c0692g) {
        URL url = new URL(str);
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) ((c0692g.f222a == null || !m251a()) ? url.openConnection() : c0692g.f222a.openConnection(url));
        httpsURLConnection.setRequestProperty("accept", "*/*");
        if (i == 0) {
            httpsURLConnection.setRequestMethod(Utils_commonKt.HTTP_METHOD_GET);
        } else {
            httpsURLConnection.setRequestMethod("POST");
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setDoInput(true);
        }
        httpsURLConnection.setConnectTimeout(c0692g.m256a());
        httpsURLConnection.setReadTimeout(c0692g.m257b());
        httpsURLConnection.setUseCaches(false);
        if (!m250b() && !m251a()) {
            httpsURLConnection.setInstanceFollowRedirects(false);
        }
        httpsURLConnection.addRequestProperty("Accept-Charset", UrlUtils.UTF_8);
        httpsURLConnection.addRequestProperty("reqId", c0692g.f225d);
        httpsURLConnection.addRequestProperty("deviceId", C0697d.m297a(this.f221a));
        if (c0692g.f230i != null && !c0692g.f230i.isEmpty()) {
            for (Map.Entry<String, String> entry : c0692g.f230i.entrySet()) {
                httpsURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        if (TextUtils.isEmpty(str2)) {
            httpsURLConnection.connect();
        } else {
            DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(httpsURLConnection.getOutputStream()));
            dataOutputStream.write(str2.getBytes(UrlUtils.UTF_8));
            dataOutputStream.flush();
            dataOutputStream.close();
        }
        return httpsURLConnection;
    }
}
