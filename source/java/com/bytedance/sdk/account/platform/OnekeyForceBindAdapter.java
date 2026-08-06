package com.bytedance.sdk.account.platform;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.sdk.account.api.IBDAccountAPIV3;
import com.bytedance.sdk.account.api.call.MobileApiResponse;
import com.bytedance.sdk.account.impl.BDAccountAPIV3Impl;
import com.bytedance.sdk.account.mobile.query.OneForceBindMobileQueryObj;
import com.bytedance.sdk.account.mobile.thread.call.OneForceBindMobileCallback;
import com.bytedance.sdk.account.platform.api.IOnekeyLoginService;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class OnekeyForceBindAdapter extends OnekeyBaseAdapter implements IOneKeyForceBindAdapter {
    private static final int BIND_LOGIC_TYPE = 1;
    protected IBDAccountAPIV3 accountAPI = BDAccountAPIV3Impl.instance();
    private volatile boolean isCancel = false;
    private OneForceBindMobileCallback mCallback;
    private Context mContext;
    private String mFrom;
    private String mProfileKey;
    private String mProviderAppId;
    private String mToken;

    public OnekeyForceBindAdapter(Context context, String str) {
        this.mContext = context;
        this.mProfileKey = str;
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
    public void onSuccess(Bundle bundle) {
        if (this.isCancel) {
            return;
        }
        parseData(bundle);
        this.mCallback = new OneForceBindMobileCallback() { // from class: com.bytedance.sdk.account.platform.OnekeyForceBindAdapter.1
            @Override // com.bytedance.sdk.account.NeedCaptchaCallBack, com.bytedance.sdk.account.CommonCallBack
            public void onSuccess(MobileApiResponse<OneForceBindMobileQueryObj> mobileApiResponse) {
                OnekeyForceBindAdapter.this.onBindSuccess(mobileApiResponse);
            }

            @Override // com.bytedance.sdk.account.NeedCaptchaCallBack, com.bytedance.sdk.account.CommonCallBack
            public void onError(MobileApiResponse<OneForceBindMobileQueryObj> mobileApiResponse, int i) {
                OnekeyForceBindAdapter onekeyForceBindAdapter = OnekeyForceBindAdapter.this;
                onekeyForceBindAdapter.onBindError(onekeyForceBindAdapter.getForceBindErrorResponse(mobileApiResponse, onekeyForceBindAdapter.mFrom));
            }
        };
        this.accountAPI.oneForceBindLogin(this.mToken, this.mFrom, this.mProfileKey, 1, this.mProviderAppId, this.mExtendInfo, this.mCallback);
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
    public void onError(AuthorizeErrorResponse authorizeErrorResponse) {
        if (this.isCancel) {
            return;
        }
        handleAuthorizeErrorResponse(authorizeErrorResponse);
        onBindError(authorizeErrorResponse);
    }

    public void cancel() {
        this.isCancel = true;
        OneForceBindMobileCallback oneForceBindMobileCallback = this.mCallback;
        if (oneForceBindMobileCallback != null) {
            oneForceBindMobileCallback.cancel();
        }
    }

    private void parseData(Bundle bundle) {
        this.mToken = bundle.getString("access_token");
        this.mFrom = bundle.getString(IOnekeyLoginService.ResponseConstants.CARRIER_FROM);
        this.mProviderAppId = bundle.getString("carrier_app_id");
    }
}
