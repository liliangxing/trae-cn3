package com.bytedance.reparo.core.load;

import com.bytedance.reparo.core.exception.PatchException;

/* loaded from: classes4.dex */
public class AsyncLoadResult {
    public static AsyncLoadResult EMPTY = new AsyncLoadResult();
    private AsyncLoadResult mOuterResult;

    public void onLoadFailed(PatchException patchException) {
    }

    public void onLoadSuccess() {
    }

    public AsyncLoadResult() {
    }

    public AsyncLoadResult(AsyncLoadResult asyncLoadResult) {
        this.mOuterResult = asyncLoadResult;
    }

    public void success() {
        onLoadSuccess();
        AsyncLoadResult asyncLoadResult = this.mOuterResult;
        if (asyncLoadResult != null) {
            asyncLoadResult.success();
        }
    }

    public void failed(PatchException patchException) {
        onLoadFailed(patchException);
        AsyncLoadResult asyncLoadResult = this.mOuterResult;
        if (asyncLoadResult != null) {
            asyncLoadResult.failed(patchException);
        }
    }
}
