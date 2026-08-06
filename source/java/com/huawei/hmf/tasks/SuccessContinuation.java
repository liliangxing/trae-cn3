package com.huawei.hmf.tasks;

/* loaded from: classes6.dex */
public interface SuccessContinuation<TResult, TContinuationResult> {
    Task<TContinuationResult> then(TResult tresult) throws Exception;
}
