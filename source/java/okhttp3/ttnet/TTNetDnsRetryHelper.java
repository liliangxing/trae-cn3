package okhttp3.ttnet;

import android.text.TextUtils;
import java.util.concurrent.CopyOnWriteArrayList;
import okhttp3.Request;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public class TTNetDnsRetryHelper {
    private static volatile TTNetDnsRetryHelper sInstance;
    private final CopyOnWriteArrayList<String> mRetryForceHttpDnsHostList = new CopyOnWriteArrayList<>();

    public static TTNetDnsRetryHelper inst() {
        if (sInstance == null) {
            synchronized (TTNetDnsRetryHelper.class) {
                if (sInstance == null) {
                    sInstance = new TTNetDnsRetryHelper();
                }
            }
        }
        return sInstance;
    }

    public void setForceHttpDns(Request request, boolean z) {
        if (request == null || request.url() == null || TextUtils.isEmpty(request.url().host())) {
            return;
        }
        String host = request.url().host();
        if (z) {
            this.mRetryForceHttpDnsHostList.add(host);
        } else {
            this.mRetryForceHttpDnsHostList.remove(host);
        }
    }

    public boolean checkForceHttpDns(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.mRetryForceHttpDnsHostList.contains(str);
    }
}
