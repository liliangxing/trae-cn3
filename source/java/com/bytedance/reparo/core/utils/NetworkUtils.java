package com.bytedance.reparo.core.utils;

import com.bytedance.reparo.core.common.utils.DigestUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class NetworkUtils {
    private static volatile NetworkUtils sInstance;
    private final OkHttpClient mClient = new OkHttpClient.Builder().connectTimeout(2, TimeUnit.SECONDS).readTimeout(2, TimeUnit.SECONDS).writeTimeout(2, TimeUnit.SECONDS).build();

    private NetworkUtils() {
    }

    public void sign(Request.Builder builder, String str, String str2, String str3) {
        String currentFormatDate = getCurrentFormatDate();
        String sha256HMAC = NetworkSignUtils.sha256HMAC(currentFormatDate, str3);
        builder.addHeader("Authorization", "HMAC-SHA256 Credential=" + str2 + ",SignedHeaders=" + ("X-Mars-Date".toLowerCase() + ";") + ",Signature=" + NetworkSignUtils.sha256HMAC(("X-Mars-Date".toLowerCase() + ":" + currentFormatDate.replaceAll("\\s", "") + "\n") + DigestUtils.md5Hex(str), sha256HMAC));
        builder.addHeader("X-mars-date", currentFormatDate);
    }

    public static NetworkUtils getInstance() {
        if (sInstance == null) {
            synchronized (NetworkUtils.class) {
                if (sInstance == null) {
                    sInstance = new NetworkUtils();
                }
            }
        }
        return sInstance;
    }

    public OkHttpClient getClient() {
        return this.mClient;
    }

    private String getCurrentFormatDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat.format(new Date());
    }
}
