package com.bytedance.retrofit2;

import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.mime.TypedInput;
import java.util.List;

/* loaded from: classes4.dex */
public final class SsResponse<T> {
    private final T body;
    private final TypedInput errorBody;
    private final Response rawResponse;
    private RetrofitMetrics retrofitMetrics;

    public static <T> SsResponse<T> success(T t, Response response) {
        if (response == null) {
            throw new NullPointerException("rawResponse == null");
        }
        if (!response.isSuccessful()) {
            throw new IllegalArgumentException("rawResponse must be successful response");
        }
        return new SsResponse<>(response, t, null);
    }

    public static <T> SsResponse<T> error(TypedInput typedInput, Response response) {
        if (typedInput == null) {
            throw new NullPointerException("body == null");
        }
        if (response == null) {
            throw new NullPointerException("rawResponse == null");
        }
        if (response.isSuccessful()) {
            throw new IllegalArgumentException("rawResponse should not be successful response");
        }
        return new SsResponse<>(response, null, typedInput);
    }

    private SsResponse(Response response, T t, TypedInput typedInput) {
        this.rawResponse = response;
        this.body = t;
        this.errorBody = typedInput;
    }

    public RetrofitMetrics getRetrofitMetrics() {
        return this.retrofitMetrics;
    }

    public void setRetrofitMetrics(RetrofitMetrics retrofitMetrics) {
        this.retrofitMetrics = retrofitMetrics;
    }

    public Response raw() {
        return this.rawResponse;
    }

    public int code() {
        return this.rawResponse.getStatus();
    }

    public List<Header> headers() {
        return this.rawResponse.getHeaders();
    }

    public boolean isSuccessful() {
        return this.rawResponse.isSuccessful();
    }

    public T body() {
        return this.body;
    }

    public TypedInput errorBody() {
        return this.errorBody;
    }

    public String message() {
        return this.rawResponse.message();
    }
}
