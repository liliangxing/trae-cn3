package com.bytedance.sdk.account.platform;

import android.os.Bundle;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class AuthorizeAdapter implements AuthorizeCallback {
    private String platform;

    public abstract void onAuthError(AuthorizeErrorResponse authorizeErrorResponse);

    public abstract void onAuthSuccess(Bundle bundle);

    public AuthorizeAdapter(String str) {
        this.platform = str;
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
    public void onSuccess(Bundle bundle) {
        AccountMonitorUtil.platformAuthEvent(this.platform, "auth", 1, null, null, false, null);
        onAuthSuccess(bundle);
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
    public void onError(AuthorizeErrorResponse authorizeErrorResponse) {
        AccountMonitorUtil.platformAuthEvent(this.platform, "auth", 0, authorizeErrorResponse.platformErrorCode, authorizeErrorResponse.platformErrorMsg, authorizeErrorResponse.isCancel, null);
        onAuthError(authorizeErrorResponse);
    }
}
