package com.bytedance.sdk.account.platform;

import android.text.TextUtils;
import com.bytedance.sdk.account.api.AccountErrorCode;
import com.bytedance.sdk.account.api.call.MobileApiResponse;
import com.bytedance.sdk.account.api.response.LoginByTicketResponse;
import com.bytedance.sdk.account.mobile.query.OneBindMobileQueryObj;
import com.bytedance.sdk.account.mobile.query.OneForceBindMobileQueryObj;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;
import com.bytedance.sdk.account.platform.base.OnekeyLoginErrorResponse;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class OnekeyBaseAdapter {
    protected static final String CARRIER_APP_ID = "carrier_app_id";
    protected Map<String, String> mExtendInfo;

    public void setExtendInfo(Map<String, String> map) {
        this.mExtendInfo = map;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleAuthorizeErrorResponse(AuthorizeErrorResponse authorizeErrorResponse) {
        if (authorizeErrorResponse instanceof OnekeyLoginErrorResponse) {
            OnekeyLoginErrorResponse onekeyLoginErrorResponse = (OnekeyLoginErrorResponse) authorizeErrorResponse;
            int i = onekeyLoginErrorResponse.errorType;
            onekeyLoginErrorResponse.error = i != 1 ? (i == 2 || i == 3) ? -1003 : AccountErrorCode.CommonError.COMMON_UNKNOWN_ERROR : -1002;
            onekeyLoginErrorResponse.mDetailErrorCode = onekeyLoginErrorResponse.error;
            try {
                if (!TextUtils.isEmpty(onekeyLoginErrorResponse.platformErrorCode)) {
                    onekeyLoginErrorResponse.mDetailErrorCode = Integer.parseInt(onekeyLoginErrorResponse.platformErrorCode);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            onekeyLoginErrorResponse.mDetailErrorMsg = authorizeErrorResponse.platformErrorDetail;
        }
    }

    public OnekeyLoginErrorResponse getLoginErrorResponse(LoginByTicketResponse loginByTicketResponse, String str) {
        OnekeyLoginErrorResponse onekeyLoginErrorResponse = new OnekeyLoginErrorResponse();
        onekeyLoginErrorResponse.netType = str;
        onekeyLoginErrorResponse.errorType = 4;
        onekeyLoginErrorResponse.platformErrorCode = String.valueOf(loginByTicketResponse.error);
        onekeyLoginErrorResponse.platformErrorMsg = loginByTicketResponse.errorMsg;
        onekeyLoginErrorResponse.smsCodeKey = loginByTicketResponse.mSmsCodeKey;
        onekeyLoginErrorResponse.mDetailErrorCode = loginByTicketResponse.mDetailErrorCode;
        onekeyLoginErrorResponse.mDetailErrorMsg = loginByTicketResponse.mDetailErrorMsg;
        onekeyLoginErrorResponse.error = loginByTicketResponse.error;
        onekeyLoginErrorResponse.errorMsg = loginByTicketResponse.errorMsg;
        if (loginByTicketResponse.result != null) {
            onekeyLoginErrorResponse.rawResult = loginByTicketResponse.result.optJSONObject("data");
        }
        if (loginByTicketResponse.error == 1075) {
            onekeyLoginErrorResponse.mCancelApplyTime = loginByTicketResponse.mCancelApplyTime;
            onekeyLoginErrorResponse.mCancelAvatarUrl = loginByTicketResponse.mCancelAvatarUrl;
            onekeyLoginErrorResponse.mCancelNickName = loginByTicketResponse.mCancelNickName;
            onekeyLoginErrorResponse.mCancelTime = loginByTicketResponse.mCancelTime;
            onekeyLoginErrorResponse.mCancelToken = loginByTicketResponse.mCancelToken;
        }
        return onekeyLoginErrorResponse;
    }

    public OnekeyLoginErrorResponse getBindErrorResponse(MobileApiResponse<OneBindMobileQueryObj> mobileApiResponse, String str) {
        OnekeyLoginErrorResponse onekeyLoginErrorResponse = new OnekeyLoginErrorResponse();
        onekeyLoginErrorResponse.netType = str;
        onekeyLoginErrorResponse.errorType = 4;
        onekeyLoginErrorResponse.platformErrorCode = String.valueOf(mobileApiResponse.error);
        onekeyLoginErrorResponse.platformErrorMsg = mobileApiResponse.errorMsg;
        onekeyLoginErrorResponse.mDetailErrorCode = mobileApiResponse.mDetailErrorCode;
        onekeyLoginErrorResponse.mDetailErrorMsg = mobileApiResponse.mDetailErrorMsg;
        onekeyLoginErrorResponse.error = mobileApiResponse.error;
        onekeyLoginErrorResponse.errorMsg = mobileApiResponse.errorMsg;
        if (mobileApiResponse.mobileObj != null) {
            if (mobileApiResponse.mobileObj.jsonResult != null) {
                onekeyLoginErrorResponse.rawResult = mobileApiResponse.mobileObj.jsonResult.optJSONObject("data");
            }
            if (mobileApiResponse.error == 1057) {
                onekeyLoginErrorResponse.mConfirmSwitchBindTips = mobileApiResponse.mobileObj.mConfirmSwitchBindTips;
                onekeyLoginErrorResponse.mConfirmSwitchBindUrl = mobileApiResponse.mobileObj.mConfirmSwitchBindUrl;
            }
        }
        return onekeyLoginErrorResponse;
    }

    public OnekeyLoginErrorResponse getForceBindErrorResponse(MobileApiResponse<OneForceBindMobileQueryObj> mobileApiResponse, String str) {
        OnekeyLoginErrorResponse onekeyLoginErrorResponse = new OnekeyLoginErrorResponse();
        onekeyLoginErrorResponse.netType = str;
        onekeyLoginErrorResponse.errorType = 4;
        onekeyLoginErrorResponse.platformErrorCode = String.valueOf(mobileApiResponse.error);
        onekeyLoginErrorResponse.platformErrorMsg = mobileApiResponse.errorMsg;
        onekeyLoginErrorResponse.mDetailErrorCode = mobileApiResponse.mDetailErrorCode;
        onekeyLoginErrorResponse.mDetailErrorMsg = mobileApiResponse.mDetailErrorMsg;
        onekeyLoginErrorResponse.error = mobileApiResponse.error;
        onekeyLoginErrorResponse.errorMsg = mobileApiResponse.errorMsg;
        if (mobileApiResponse.mobileObj != null) {
            if (mobileApiResponse.mobileObj.mResultCode != null) {
                onekeyLoginErrorResponse.resultCode = mobileApiResponse.mobileObj.mResultCode;
            }
            if (mobileApiResponse.mobileObj.jsonResult != null) {
                onekeyLoginErrorResponse.rawResult = mobileApiResponse.mobileObj.jsonResult.optJSONObject("data");
            }
        }
        return onekeyLoginErrorResponse;
    }
}
