package com.bytedance.retrofit2.rxjava2.adapter;

import com.bytedance.retrofit2.SsResponse;
import javax.annotation.Nullable;

/* loaded from: classes4.dex */
public final class Result<T> {

    @Nullable
    private final Throwable error;

    @Nullable
    private final SsResponse<T> response;

    public static <T> Result<T> error(Throwable th) {
        if (th == null) {
            throw new NullPointerException("error == null");
        }
        return new Result<>(null, th);
    }

    public static <T> Result<T> response(SsResponse<T> ssResponse) {
        if (ssResponse == null) {
            throw new NullPointerException("response == null");
        }
        return new Result<>(ssResponse, null);
    }

    private Result(@Nullable SsResponse<T> ssResponse, @Nullable Throwable th) {
        this.response = ssResponse;
        this.error = th;
    }

    @Nullable
    public SsResponse<T> response() {
        return this.response;
    }

    @Nullable
    public Throwable error() {
        return this.error;
    }

    public boolean isError() {
        return this.error != null;
    }
}
