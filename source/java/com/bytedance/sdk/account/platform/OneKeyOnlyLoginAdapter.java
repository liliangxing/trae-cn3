package com.bytedance.sdk.account.platform;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.sdk.account.api.IBDAccountAPIV3;
import com.bytedance.sdk.account.api.callback.LoginByTicketCallback;
import com.bytedance.sdk.account.api.response.LoginByTicketResponse;
import com.bytedance.sdk.account.impl.BDAccountAPIV3Impl;
import com.bytedance.sdk.account.platform.api.IOnekeyLoginService;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;
import java.util.HashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class OneKeyOnlyLoginAdapter extends OnekeyBaseAdapter implements IOneKeyOnlyLoginAdapter {
    protected IBDAccountAPIV3 accountAPI = BDAccountAPIV3Impl.instance();
    private volatile boolean isCancel = false;
    private LoginByTicketCallback mCallback;
    private Context mContext;
    private String mFrom;
    private String mProviderAppId;
    private String mToken;

    public OneKeyOnlyLoginAdapter(Context context) {
        this.mContext = context.getApplicationContext();
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
    public final void onSuccess(Bundle bundle) {
        if (this.isCancel) {
            return;
        }
        parseData(bundle);
        this.mCallback = new LoginByTicketCallback() { // from class: com.bytedance.sdk.account.platform.OneKeyOnlyLoginAdapter.1
            @Override // com.bytedance.sdk.account.CommonCallBack
            public void onSuccess(LoginByTicketResponse loginByTicketResponse) {
                OneKeyOnlyLoginAdapter.this.onLoginSuccess(loginByTicketResponse);
            }

            @Override // com.bytedance.sdk.account.CommonCallBack
            public void onError(LoginByTicketResponse loginByTicketResponse, int i) {
                OneKeyOnlyLoginAdapter oneKeyOnlyLoginAdapter = OneKeyOnlyLoginAdapter.this;
                oneKeyOnlyLoginAdapter.onLoginError(oneKeyOnlyLoginAdapter.getLoginErrorResponse(loginByTicketResponse, oneKeyOnlyLoginAdapter.mFrom));
            }
        };
        if (this.mExtendInfo == null) {
            this.mExtendInfo = new HashMap();
        }
        this.mExtendInfo.put("provider_app_id", this.mProviderAppId);
        this.accountAPI.quickAuthLoginOnly(this.mToken, this.mFrom, this.mExtendInfo, this.mCallback);
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
    public final void onError(AuthorizeErrorResponse authorizeErrorResponse) {
        if (this.isCancel) {
            return;
        }
        handleAuthorizeErrorResponse(authorizeErrorResponse);
        onLoginError(authorizeErrorResponse);
    }

    public void cancel() {
        this.isCancel = true;
        LoginByTicketCallback loginByTicketCallback = this.mCallback;
        if (loginByTicketCallback != null) {
            loginByTicketCallback.cancel();
        }
    }

    private void parseData(Bundle bundle) {
        this.mToken = bundle.getString("access_token");
        this.mFrom = bundle.getString(IOnekeyLoginService.ResponseConstants.CARRIER_FROM);
        this.mProviderAppId = bundle.getString("carrier_app_id");
    }
}
