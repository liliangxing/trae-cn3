package com.bytedance.sdk.account.platform;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.account.CommonCallBack;
import com.bytedance.sdk.account.api.IBDAccountAPIV3;
import com.bytedance.sdk.account.api.call.UserApiResponse;
import com.bytedance.sdk.account.impl.BDAccountAPIV3Impl;
import com.bytedance.sdk.account.platform.api.IOnekeyLoginService;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;
import com.bytedance.sdk.account.platform.base.OneLoginCallback;
import com.bytedance.sdk.account.platform.base.OnekeyLoginErrorResponse;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class ValidateMobileLoginAdapter extends OnekeyBaseAdapter implements OneLoginCallback {
    protected IBDAccountAPIV3 accountAPI;
    private volatile boolean isCancel;
    private CommonCallBack<UserApiResponse> mCallback;
    private String mFrom;
    private boolean mIsCheckMatchSecretMobile;
    private final String mMobile;
    private String mProviderAppId;
    private String mSecretMobile;
    private String mToken;

    protected abstract void onLoginError(AuthorizeErrorResponse authorizeErrorResponse);

    protected abstract void onLoginSuccess(UserApiResponse userApiResponse);

    @Override // com.bytedance.sdk.account.platform.base.OneLoginCallback
    public JSONObject onSendEvent() {
        return null;
    }

    public ValidateMobileLoginAdapter(Context context, String str) {
        this.mMobile = str;
        this.accountAPI = BDAccountAPIV3Impl.instance();
        this.isCancel = false;
    }

    public ValidateMobileLoginAdapter(Context context, String str, String str2) {
        this(context, str2);
        this.mSecretMobile = str;
        this.mIsCheckMatchSecretMobile = true;
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
    public final void onSuccess(Bundle bundle) {
        if (this.isCancel) {
            return;
        }
        if (this.mIsCheckMatchSecretMobile && checkMismatchSecretMobile()) {
            onLoginError(getErrorResponse());
            return;
        }
        parseData(bundle);
        this.mCallback = new CommonCallBack<UserApiResponse>() { // from class: com.bytedance.sdk.account.platform.ValidateMobileLoginAdapter.1
            @Override // com.bytedance.sdk.account.CommonCallBack
            public void onSuccess(UserApiResponse userApiResponse) {
                ValidateMobileLoginAdapter.this.onLoginSuccess(userApiResponse);
            }

            @Override // com.bytedance.sdk.account.CommonCallBack
            public void onError(UserApiResponse userApiResponse, int i) {
                ValidateMobileLoginAdapter validateMobileLoginAdapter = ValidateMobileLoginAdapter.this;
                validateMobileLoginAdapter.onLoginError(validateMobileLoginAdapter.getErrorResponse(userApiResponse, validateMobileLoginAdapter.mFrom));
            }
        };
        if (this.mExtendInfo == null) {
            this.mExtendInfo = new HashMap();
        }
        this.mExtendInfo.put("provider_app_id", this.mProviderAppId);
        this.accountAPI.quickValidateMobileLogin(this.mSecretMobile, this.mMobile, this.mToken, this.mFrom, this.mExtendInfo, this.mCallback);
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
        CommonCallBack<UserApiResponse> commonCallBack = this.mCallback;
        if (commonCallBack != null) {
            commonCallBack.cancel();
        }
    }

    private boolean checkMismatchSecretMobile() {
        if (TextUtils.isEmpty(this.mSecretMobile) || this.mSecretMobile.length() != 11 || TextUtils.isEmpty(this.mMobile)) {
            return true;
        }
        String substring = this.mSecretMobile.substring(0, 3);
        String substring2 = this.mSecretMobile.substring(7, 11);
        String trim = this.mMobile.trim();
        if (trim.startsWith("+86")) {
            trim = trim.substring(3).trim();
        }
        return (trim.startsWith(substring) && trim.endsWith(substring2)) ? false : true;
    }

    private void parseData(Bundle bundle) {
        this.mToken = bundle.getString("access_token");
        this.mFrom = bundle.getString(IOnekeyLoginService.ResponseConstants.CARRIER_FROM);
        this.mProviderAppId = bundle.getString("carrier_app_id");
    }

    private OnekeyLoginErrorResponse getErrorResponse() {
        OnekeyLoginErrorResponse onekeyLoginErrorResponse = new OnekeyLoginErrorResponse();
        onekeyLoginErrorResponse.error = -1;
        onekeyLoginErrorResponse.errorMsg = "secret mobile mismatch";
        return onekeyLoginErrorResponse;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public OnekeyLoginErrorResponse getErrorResponse(UserApiResponse userApiResponse, String str) {
        OnekeyLoginErrorResponse onekeyLoginErrorResponse = new OnekeyLoginErrorResponse();
        onekeyLoginErrorResponse.netType = str;
        onekeyLoginErrorResponse.errorType = 4;
        onekeyLoginErrorResponse.platformErrorCode = String.valueOf(userApiResponse.error);
        onekeyLoginErrorResponse.platformErrorMsg = userApiResponse.errorMsg;
        onekeyLoginErrorResponse.mDetailErrorCode = userApiResponse.mDetailErrorCode;
        onekeyLoginErrorResponse.mDetailErrorMsg = userApiResponse.mDetailErrorMsg;
        onekeyLoginErrorResponse.error = userApiResponse.error;
        onekeyLoginErrorResponse.errorMsg = userApiResponse.errorMsg;
        if (userApiResponse.result != null) {
            onekeyLoginErrorResponse.rawResult = userApiResponse.result.optJSONObject("data");
        }
        if (userApiResponse.error == 1075) {
            onekeyLoginErrorResponse.mCancelApplyTime = userApiResponse.mCancelApplyTime;
            onekeyLoginErrorResponse.mCancelAvatarUrl = userApiResponse.mCancelAvatarUrl;
            onekeyLoginErrorResponse.mCancelNickName = userApiResponse.mCancelNickName;
            onekeyLoginErrorResponse.mCancelTime = userApiResponse.mCancelTime;
            onekeyLoginErrorResponse.mCancelToken = userApiResponse.mCancelToken;
        }
        return onekeyLoginErrorResponse;
    }
}
