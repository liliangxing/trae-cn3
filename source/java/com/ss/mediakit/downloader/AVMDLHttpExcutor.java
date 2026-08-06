package com.ss.mediakit.downloader;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import com.ss.mediakit.medialoader.AVMDLDataLoaderConfigure;
import com.ss.mediakit.medialoader.AVMDLLog;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AVMDLHttpExcutor {
    private static final String TAG = "AVMDLHttpExcutor";
    private static OkHttpClient okHttpClient;

    public static synchronized void setOkHttpClient(OkHttpClient okHttpClient2) {
        synchronized (AVMDLHttpExcutor.class) {
            if (okHttpClient == null) {
                okHttpClient = okHttpClient2;
                AVMDLLog.m226d(TAG, "cur client null allow set");
            }
            AVMDLLog.m226d(TAG, "set custom client:" + okHttpClient2);
        }
    }

    private static synchronized OkHttpClient getOkHttpClient() {
        OkHttpClient okHttpClient2;
        long j;
        synchronized (AVMDLHttpExcutor.class) {
            if (okHttpClient == null) {
                AVMDLDataLoaderConfigure config = AVMDLDataLoader.getInstance().getConfig();
                if (config != null) {
                    r3 = config.mOpenTimeOut > 0 ? config.mOpenTimeOut * 1000 : 10000L;
                    j = config.mRWTimeOut > 0 ? config.mRWTimeOut * 1000 : 10000L;
                } else {
                    j = 10000;
                }
                AVMDLLog.m226d(TAG, "connect timeout:" + r3 + " rwtimeout:" + j);
                OkHttpClient.Builder builder = new OkHttpClient.Builder();
                builder.protocols(Collections.singletonList(Protocol.HTTP_1_1));
                builder.connectTimeout(r3, TimeUnit.MILLISECONDS).readTimeout(j, TimeUnit.MILLISECONDS).writeTimeout(j, TimeUnit.MILLISECONDS);
                okHttpClient = builder.build();
            }
            okHttpClient2 = okHttpClient;
        }
        return okHttpClient2;
    }

    public static AVMDLResponse excute(final AVMDLRequest aVMDLRequest, final int i) throws IOException {
        Request.Builder builder = new Request.Builder();
        builder.url(aVMDLRequest.urls[i]);
        builder.method("GET", (RequestBody) null);
        builder.headers(toOkHttpHeaders(aVMDLRequest));
        Call newCall = getOkHttpClient().newCall(builder.build());
        try {
            final long currentTimeMillis = System.currentTimeMillis();
            Response execute = newCall.execute();
            final long currentTimeMillis2 = System.currentTimeMillis();
            aVMDLRequest.mCurlUrlIndex = i;
            AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.downloader.AVMDLHttpExcutor$$ExternalSyntheticLambda0
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    String format;
                    format = String.format(Locale.US, "http open cost time:%d url:%s", Long.valueOf(currentTimeMillis2 - currentTimeMillis), aVMDLRequest.urls[i]);
                    return format;
                }
            });
            return new AVMDLResponse(aVMDLRequest, execute, newCall);
        } catch (Exception e) {
            AVMDLLog.m228e(TAG, "request exception is " + e.getLocalizedMessage());
            throw e;
        }
    }

    private static Headers toOkHttpHeaders(AVMDLRequest aVMDLRequest) {
        Headers.Builder builder = new Headers.Builder();
        if (aVMDLRequest.headers != null) {
            for (Map.Entry<String, String> entry : aVMDLRequest.headers.entrySet()) {
                AVMDLLog.m226d(TAG, "custom header key:" + entry.getKey() + "  value:" + entry.getValue());
                builder.add(entry.getKey(), entry.getValue());
            }
        }
        String buildRangeHeader = buildRangeHeader(aVMDLRequest.reqOff, aVMDLRequest.size);
        if (!TextUtils.isEmpty(buildRangeHeader)) {
            AVMDLLog.m226d(TAG, "range str: " + buildRangeHeader);
            builder.add("Range", buildRangeHeader);
        }
        builder.add(DownloadHelper.ACCEPT_ENCODING, "identity");
        return builder.build();
    }

    public static String buildRangeHeader(long j, long j2) {
        String formRangeStrBySize = formRangeStrBySize(j, j2);
        return TextUtils.isEmpty(formRangeStrBySize) ? "" : "bytes=" + formRangeStrBySize;
    }

    public static String formRangeStrBySize(long j, long j2) {
        return formRangeStrByPos(j, j2 > 0 ? (j2 + j) - 1 : -1L);
    }

    public static String formRangeStrByPos(long j, long j2) {
        if (j >= 0 && j2 > 0) {
            return j + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j2;
        }
        if (j >= 0) {
            return j + Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        }
        return (j >= 0 || j2 <= 0) ? "" : Constants.ACCEPT_TIME_SEPARATOR_SERVER + j2;
    }
}
