package com.bytedance.retrofit2;

import java.net.URL;
import javax.annotation.Nullable;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class HttpException extends RuntimeException {
    private final int code;
    private final String message;
    private final transient SsResponse<?> response;

    private static String getMessage(SsResponse<?> ssResponse) {
        Utils.checkNotNull(ssResponse, "response == null");
        String path = (ssResponse.getRetrofitMetrics() == null || ssResponse.getRetrofitMetrics().url == null) ? "" : ssResponse.getRetrofitMetrics().url.getPath();
        if ("".equals(path) && ssResponse.raw() != null) {
            try {
                path = new URL(ssResponse.raw().getUrl()).getPath();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "Path is " + path + " HTTP " + ssResponse.code() + " " + ssResponse.message();
    }

    public HttpException(SsResponse<?> ssResponse) {
        super(getMessage(ssResponse));
        this.code = ssResponse.code();
        this.message = ssResponse.message();
        this.response = ssResponse;
    }

    public int code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    @Nullable
    public SsResponse<?> response() {
        return this.response;
    }
}
