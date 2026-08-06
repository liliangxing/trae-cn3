package com.bytedance.retrofit2.rxjava2.adapter;

import com.bytedance.retrofit2.SsResponse;
import javax.annotation.Nullable;

@Deprecated
/* loaded from: classes4.dex */
public final class HttpException extends RuntimeException {
    private final int code;
    private final transient SsResponse<?> response;

    private static String getMessage(SsResponse<?> ssResponse) {
        checkNotNull(ssResponse, "response == null");
        return "HTTP " + ssResponse.code();
    }

    public HttpException(SsResponse<?> ssResponse) {
        super(getMessage(ssResponse));
        this.code = ssResponse.code();
        this.response = ssResponse;
    }

    public int code() {
        return this.code;
    }

    public SsResponse<?> response() {
        return this.response;
    }

    private static <T> T checkNotNull(@Nullable T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }
}
