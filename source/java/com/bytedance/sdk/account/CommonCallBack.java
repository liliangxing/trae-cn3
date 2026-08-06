package com.bytedance.sdk.account;

import com.bytedance.sdk.account.api.call.AbsApiCall;
import com.bytedance.sdk.account.api.call.BaseApiResponse;

/* loaded from: classes5.dex */
public abstract class CommonCallBack<T extends BaseApiResponse> extends AbsApiCall<T> {
    @Deprecated
    public String getCaptchaInfo(T t) {
        return null;
    }

    @Deprecated
    public boolean needShowCaptcha(T t) {
        return false;
    }

    @Deprecated
    public boolean needShowPicCaptcha(T t) {
        return false;
    }

    @Deprecated
    public boolean needShowSecureCaptcha(T t) {
        return false;
    }

    public abstract void onError(T t, int i);

    @Deprecated
    public void onNeedCaptcha(T t, String str) {
    }

    @Deprecated
    public void onNeedSecureCaptcha(T t) {
    }

    public abstract void onSuccess(T t);

    @Override // com.bytedance.sdk.account.api.call.AbsApiCall
    public void onResponse(T t) {
        if (t.success) {
            onSuccess(t);
            return;
        }
        if (needShowCaptcha(t)) {
            if (needShowPicCaptcha(t)) {
                onNeedCaptcha(t, getCaptchaInfo(t));
                return;
            } else {
                onError(t, t.error);
                return;
            }
        }
        onError(t, t.error);
    }
}
