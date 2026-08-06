package com.bytedance.common.push.interfaze;

import com.bytedance.common.model.Result;

/* loaded from: classes3.dex */
public class ApiResponse<T> {
    public T response;
    public Result result;

    public ApiResponse(T t, Result result) {
        this.response = t;
        this.result = result;
    }
}
