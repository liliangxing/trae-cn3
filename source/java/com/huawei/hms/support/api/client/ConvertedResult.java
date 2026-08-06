package com.huawei.hms.support.api.client;

import com.huawei.hms.support.api.client.Result;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public abstract class ConvertedResult<R extends Result> {
    public abstract <S extends Result> ConvertedResult<S> convertResult(ResultConvert<? super R, ? extends S> resultConvert);

    public abstract void finalExec(ResultCallbacks<? super R> resultCallbacks);
}
