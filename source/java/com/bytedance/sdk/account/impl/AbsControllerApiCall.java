package com.bytedance.sdk.account.impl;

import com.bytedance.sdk.account.api.pool.IApiController;

/* loaded from: classes5.dex */
public abstract class AbsControllerApiCall {
    protected IApiController mJobController;

    /* JADX INFO: Access modifiers changed from: protected */
    public void attachController(IApiController iApiController) {
        this.mJobController = iApiController;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cancelApi() {
        IApiController iApiController = this.mJobController;
        if (iApiController != null) {
            iApiController.cancel();
        }
    }
}
