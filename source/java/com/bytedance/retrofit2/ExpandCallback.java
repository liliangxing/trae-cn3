package com.bytedance.retrofit2;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface ExpandCallback<T> extends Callback<T> {
    void onAsyncPreRequest(RequestBuilder requestBuilder);

    void onAsyncResponse(Call<T> call, SsResponse<T> ssResponse);
}
