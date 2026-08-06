package com.bytedance.sdk.account.platform.onekey.carrier;

import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.bytedance.sdk.account.platform.base.OnekeyLoginErrorResponse;
import com.bytedance.sdk.account.platform.onekey.OnekeyDataHelper;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class UnSupportCarrier extends AbsCarrier {
    private String mCarrier;

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.AbsCarrier
    protected String settingKey() {
        return null;
    }

    public UnSupportCarrier(IServiceContainer iServiceContainer) {
        super(iServiceContainer);
    }

    public void setCarrierType(String str) {
        this.mCarrier = str;
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.ICarrierService
    public void getPhoneInfo(String str, String str2, int i, boolean z, AuthorizeCallback authorizeCallback) {
        if (authorizeCallback != null) {
            OnekeyLoginErrorResponse onekeyLoginErrorResponse = new OnekeyLoginErrorResponse();
            onekeyLoginErrorResponse.netType = this.mCarrier;
            onekeyLoginErrorResponse.netStatus = i;
            onekeyLoginErrorResponse.errorType = 1;
            onekeyLoginErrorResponse.platformErrorCode = OnekeyLoginConstants.ErrorCode.ERROR_CODE_NOT_SUPPORT;
            onekeyLoginErrorResponse.platformErrorMsg = OnekeyLoginConstants.ErrorMsg.ERROR_NOT_SUPPORT;
            authorizeCallback.onError(onekeyLoginErrorResponse);
        }
        onEvent(OnekeyDataHelper.GET_PHONE_EVENT, str, str2, i, authorizeCallback);
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.ICarrierService
    public void getAuthToken(int i, AuthorizeCallback authorizeCallback) {
        if (authorizeCallback != null) {
            OnekeyLoginErrorResponse onekeyLoginErrorResponse = new OnekeyLoginErrorResponse();
            onekeyLoginErrorResponse.netType = this.mCarrier;
            onekeyLoginErrorResponse.errorType = 2;
            onekeyLoginErrorResponse.platformErrorCode = OnekeyLoginConstants.ErrorCode.ERROR_CODE_NOT_SUPPORT;
            onekeyLoginErrorResponse.platformErrorMsg = OnekeyLoginConstants.ErrorMsg.ERROR_NOT_SUPPORT;
            authorizeCallback.onError(onekeyLoginErrorResponse);
        }
        onEvent(OnekeyDataHelper.GET_TOKEN_EVENT, "", "", i, authorizeCallback);
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.ICarrierService
    public void getValidateToken(int i, AuthorizeCallback authorizeCallback) {
        if (authorizeCallback != null) {
            OnekeyLoginErrorResponse onekeyLoginErrorResponse = new OnekeyLoginErrorResponse();
            onekeyLoginErrorResponse.netType = this.mCarrier;
            onekeyLoginErrorResponse.errorType = 2;
            onekeyLoginErrorResponse.platformErrorCode = OnekeyLoginConstants.ErrorCode.ERROR_CODE_NOT_SUPPORT;
            onekeyLoginErrorResponse.platformErrorMsg = OnekeyLoginConstants.ErrorMsg.ERROR_NOT_SUPPORT;
            authorizeCallback.onError(onekeyLoginErrorResponse);
        }
        onEvent(OnekeyDataHelper.GET_VALIDATE_TOKEN_EVENT, "", "", i, authorizeCallback);
    }

    private void onEvent(String str, String str2, String str3, int i, AuthorizeCallback authorizeCallback) {
        onEvent(str, OnekeyDataHelper.generateMonitorJson(getContext(), false, OnekeyLoginConstants.ErrorCode.ERROR_CODE_NOT_SUPPORT, OnekeyLoginConstants.ErrorMsg.ERROR_NOT_SUPPORT, 0L, null, this.mCarrier, str2, str3, i, authorizeCallback));
    }
}
