package com.bytedance.sdk.account.platform.onekey.carrier;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.bytedance.sdk.account.platform.base.OnekeyLoginErrorResponse;
import com.bytedance.sdk.account.platform.onekey.CarrierCacheInfoHelper;
import com.bytedance.sdk.account.platform.onekey.NetworkTypeHelper;
import com.bytedance.sdk.account.platform.onekey.OnekeyDataHelper;
import com.bytedance.sdk.account.platform.onekey.OnekeyLoginConfig;
import com.bytedance.sdk.account.platform.onekey.OnekeyResponseCallable;
import com.bytedance.sdk.account.platform.onekey.OnekeySettingManager;
import com.unicom.online.account.shield.ResultListener;
import com.unicom.online.account.shield.UniAccountHelper;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class ChinaUnionService extends AbsCarrier {
    private final OnekeyLoginConfig.CUSettingConfig mCUSettingConfig;
    private boolean mIsCuReqTimeout;

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.AbsCarrier
    protected String settingKey() {
        return OnekeySettingManager.KEY_CU_CONFIG;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static class CuSceneTimeoutResponse {
        private String netType;
        private OnekeyLoginErrorResponse response;
        private String scene;

        private CuSceneTimeoutResponse() {
        }
    }

    public ChinaUnionService(IServiceContainer iServiceContainer, OnekeyLoginConfig.CUSettingConfig cUSettingConfig) {
        super(iServiceContainer);
        this.mCUSettingConfig = cUSettingConfig;
        UniAccountHelper.getInstance().init(getContext(), cUSettingConfig.mCUAppId);
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.ICarrierService
    public void getPhoneInfo(String str, String str2, int i, boolean z, AuthorizeCallback authorizeCallback) {
        this.mIsCuReqTimeout = false;
        this.isCancel = false;
        if (this.mCUSettingConfig == null) {
            if (authorizeCallback != null) {
                authorizeCallback.onError(OnekeyDataHelper.getErrorResponse(OnekeyLoginConstants.ErrorCode.ERROR_SDK_INIT, OnekeyLoginConstants.ErrorMsg.ERROR_SDK_INIT_MSG, OnekeyLoginConstants.UNICOM, i, 1, null));
            }
            onEvent(OnekeyDataHelper.GET_PHONE_EVENT, OnekeyDataHelper.generateMonitorJson(getContext(), false, OnekeyLoginConstants.ErrorCode.ERROR_SDK_INIT, OnekeyLoginConstants.ErrorMsg.ERROR_SDK_INIT_MSG, 0L, null, OnekeyDataHelper.CU_EVENT_CARRIER, str, str2, i, authorizeCallback));
            return;
        }
        if (!isEnable()) {
            postCarrierDisableError(OnekeyLoginConstants.UNICOM, str, str2, i, OnekeyDataHelper.GET_PHONE_EVENT, 1, authorizeCallback);
            return;
        }
        boolean isMobileEnabled = NetworkTypeHelper.isMobileEnabled(i);
        if (needDataMobile(true) && !isMobileEnabled) {
            postDataMobileDisableError(OnekeyLoginConstants.UNICOM, str, str2, i, authorizeCallback);
            return;
        }
        long timeout = getTimeout(str);
        CuSceneTimeoutResponse cuSceneTimeoutResponse = new CuSceneTimeoutResponse();
        cuSceneTimeoutResponse.scene = str;
        cuSceneTimeoutResponse.netType = str2;
        cuSceneTimeoutResponse.response = OnekeyDataHelper.getErrorResponse(OnekeyLoginConstants.ErrorCode.ERROR_CU_REQUEST_TIMEOUT, OnekeyLoginConstants.ErrorMsg.ERROR_CU_REQUEST_TIMEOUT_MSG, OnekeyLoginConstants.UNICOM, i, 3, null);
        startTimer(timeout, new OnekeyResponseCallable<>(authorizeCallback, cuSceneTimeoutResponse));
        onEvent(OnekeyDataHelper.GET_PHONE_SEND_EVENT, OnekeyDataHelper.getMonitorJson(getContext(), OnekeyDataHelper.CU_EVENT_CARRIER, str, str2, i, authorizeCallback));
        getCuPhoneAndAccessCode(OnekeyDataHelper.GET_PHONE_EVENT, (int) timeout, str, str2, i, authorizeCallback);
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.ICarrierService
    public void getAuthToken(int i, AuthorizeCallback authorizeCallback) {
        this.mIsCuReqTimeout = false;
        this.isCancel = false;
        if (!isEnable()) {
            postCarrierDisableError(OnekeyLoginConstants.UNICOM, null, null, i, OnekeyDataHelper.GET_TOKEN_EVENT, 2, authorizeCallback);
            return;
        }
        if (this.isCancel) {
            return;
        }
        if (this.mCUSettingConfig == null) {
            if (authorizeCallback != null) {
                authorizeCallback.onError(OnekeyDataHelper.getErrorResponse(OnekeyLoginConstants.ErrorCode.ERROR_SDK_INIT, OnekeyLoginConstants.ErrorMsg.ERROR_SDK_INIT_MSG, OnekeyLoginConstants.UNICOM, i, 2, null));
            }
            onEvent(OnekeyDataHelper.GET_TOKEN_EVENT, OnekeyDataHelper.generateMonitorJson(getContext(), false, OnekeyLoginConstants.ErrorCode.ERROR_SDK_INIT, OnekeyLoginConstants.ErrorMsg.ERROR_SDK_INIT_MSG, 0L, null, OnekeyDataHelper.CU_EVENT_CARRIER, null, null, i, authorizeCallback));
        } else {
            long timeout = getTimeout(null);
            startTimer(timeout, new OnekeyResponseCallable<>(authorizeCallback, OnekeyDataHelper.getErrorResponse(OnekeyLoginConstants.ErrorCode.ERROR_CU_REQUEST_TIMEOUT, OnekeyLoginConstants.ErrorMsg.ERROR_CU_REQUEST_TIMEOUT_MSG, OnekeyLoginConstants.UNICOM, i, 3, null)));
            onEvent(OnekeyDataHelper.GET_TOKEN_SEND_EVENT, OnekeyDataHelper.getMonitorJson(getContext(), OnekeyDataHelper.CU_EVENT_CARRIER, null, null, i, authorizeCallback));
            getCuPhoneAndAccessCode(OnekeyDataHelper.GET_TOKEN_EVENT, (int) timeout, null, null, i, authorizeCallback);
        }
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.ICarrierService
    public void getValidateToken(int i, AuthorizeCallback authorizeCallback) {
        this.mIsCuReqTimeout = false;
        this.isCancel = false;
        if (!isEnable()) {
            postCarrierDisableError(OnekeyLoginConstants.UNICOM, null, null, i, OnekeyDataHelper.GET_VALIDATE_TOKEN_EVENT, 2, authorizeCallback);
            return;
        }
        System.currentTimeMillis();
        if (this.isCancel) {
            return;
        }
        if (this.mCUSettingConfig == null) {
            if (authorizeCallback != null) {
                authorizeCallback.onError(OnekeyDataHelper.getErrorResponse(OnekeyLoginConstants.ErrorCode.ERROR_SDK_INIT, OnekeyLoginConstants.ErrorMsg.ERROR_SDK_INIT_MSG, OnekeyLoginConstants.UNICOM, i, 2, null));
            }
            onEvent(OnekeyDataHelper.GET_TOKEN_EVENT, OnekeyDataHelper.generateMonitorJson(getContext(), false, OnekeyLoginConstants.ErrorCode.ERROR_SDK_INIT, OnekeyLoginConstants.ErrorMsg.ERROR_SDK_INIT_MSG, 0L, null, OnekeyDataHelper.CU_EVENT_CARRIER, null, null, i, authorizeCallback));
        } else {
            onEvent(OnekeyDataHelper.GET_VALIDATE_TOKEN_SEND_EVENT, OnekeyDataHelper.getMonitorJson(getContext(), OnekeyDataHelper.CU_EVENT_CARRIER, null, null, i, authorizeCallback));
            long timeout = getTimeout(null);
            startTimer(timeout, new OnekeyResponseCallable<>(authorizeCallback, OnekeyDataHelper.getErrorResponse(OnekeyLoginConstants.ErrorCode.ERROR_CU_REQUEST_TIMEOUT, OnekeyLoginConstants.ErrorMsg.ERROR_CU_REQUEST_TIMEOUT_MSG, OnekeyLoginConstants.UNICOM, i, 3, null)));
            onEvent(OnekeyDataHelper.GET_VALIDATE_TOKEN_EVENT, OnekeyDataHelper.getMonitorJson(getContext(), OnekeyDataHelper.CU_EVENT_CARRIER, null, null, i, authorizeCallback));
            getCuPhoneAndAccessCode(OnekeyDataHelper.GET_VALIDATE_TOKEN_EVENT, (int) timeout, null, null, i, authorizeCallback);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.account.platform.onekey.carrier.AbsCarrier
    public void notifyTimeout(OnekeyResponseCallable<?> onekeyResponseCallable) {
        OnekeyLoginErrorResponse onekeyLoginErrorResponse;
        String str;
        String str2;
        this.mIsCuReqTimeout = true;
        if (onekeyResponseCallable == null || onekeyResponseCallable.mCallback == null) {
            return;
        }
        if (onekeyResponseCallable.response instanceof CuSceneTimeoutResponse) {
            onekeyLoginErrorResponse = ((CuSceneTimeoutResponse) onekeyResponseCallable.response).response;
            str = ((CuSceneTimeoutResponse) onekeyResponseCallable.response).scene;
            str2 = ((CuSceneTimeoutResponse) onekeyResponseCallable.response).netType;
        } else {
            if (onekeyResponseCallable.response instanceof OnekeyLoginErrorResponse) {
                onekeyLoginErrorResponse = (OnekeyLoginErrorResponse) onekeyResponseCallable.response;
                str = null;
            } else {
                onekeyLoginErrorResponse = null;
                str = null;
            }
            str2 = str;
        }
        if (onekeyLoginErrorResponse != null) {
            onekeyResponseCallable.mCallback.onError(onekeyLoginErrorResponse);
            onEvent(onekeyLoginErrorResponse.errorType == 1 ? OnekeyDataHelper.GET_PHONE_EVENT : OnekeyDataHelper.GET_TOKEN_EVENT, OnekeyDataHelper.generateMonitorJson(getContext(), false, onekeyLoginErrorResponse.platformErrorCode, onekeyLoginErrorResponse.platformErrorMsg, getTimeout(str), null, OnekeyDataHelper.CU_EVENT_CARRIER, str, str2, onekeyLoginErrorResponse.netStatus, onekeyResponseCallable.mCallback));
        }
    }

    protected UnionCarrierCacheInfo getCacheInfoNotNull() {
        int defaultDataSubscriptionId = NetworkTypeHelper.getDefaultDataSubscriptionId(getContext());
        AbsCarrierCacheInfo carrierCacheInfo = CarrierCacheInfoHelper.INSTANCE.getCarrierCacheInfo(defaultDataSubscriptionId);
        if (carrierCacheInfo instanceof UnionCarrierCacheInfo) {
            return (UnionCarrierCacheInfo) carrierCacheInfo;
        }
        return new UnionCarrierCacheInfo(defaultDataSubscriptionId);
    }

    private void getCuPhoneAndAccessCode(final String str, int i, final String str2, final String str3, final int i2, final AuthorizeCallback authorizeCallback) {
        final long currentTimeMillis = System.currentTimeMillis();
        try {
            UniAccountHelper.getInstance().cuGetToken(i, new ResultListener() { // from class: com.bytedance.sdk.account.platform.onekey.carrier.ChinaUnionService.1
                /* JADX WARN: Removed duplicated region for block: B:10:0x0101  */
                /* JADX WARN: Removed duplicated region for block: B:12:0x0117  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onResult(String str4) {
                    String str5;
                    String str6;
                    JSONObject jSONObject;
                    String str7;
                    String str8;
                    String str9;
                    JSONObject jSONObject2;
                    Bundle parseToAuthTokenResponse;
                    if (ChinaUnionService.this.mIsCuReqTimeout) {
                        return;
                    }
                    ChinaUnionService.this.clearTimer();
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    String str10 = "";
                    JSONObject jSONObject3 = null;
                    if (TextUtils.isEmpty(str4)) {
                        str7 = "";
                        str8 = str7;
                        jSONObject = null;
                        str9 = str8;
                    } else {
                        try {
                            jSONObject2 = new JSONObject(str4);
                        } catch (Exception e) {
                            e = e;
                        }
                        try {
                            String optString = jSONObject2.optString("resultCode");
                            try {
                                str5 = jSONObject2.optString(OnekeyLoginConstants.CU_KEY_RESULT_MSG);
                                try {
                                    str6 = jSONObject2.optString(OnekeyLoginConstants.CU_KEY_SEQ);
                                    try {
                                        JSONObject optJSONObject = jSONObject2.optJSONObject(OnekeyLoginConstants.CU_KEY_RESULT_DATA);
                                        if (optJSONObject != null && optJSONObject.has(OnekeyLoginConstants.CU_KEY_FAKE_MOBILE)) {
                                            String optString2 = optJSONObject.optString(OnekeyLoginConstants.CU_KEY_FAKE_MOBILE);
                                            String optString3 = optJSONObject.optString("accessCode");
                                            long optLong = optJSONObject.optLong(OnekeyLoginConstants.CU_KEY_TOKEN_EXPIRES);
                                            UnionCarrierCacheInfo cacheInfoNotNull = ChinaUnionService.this.getCacheInfoNotNull();
                                            cacheInfoNotNull.setMaskPhone(optString2);
                                            cacheInfoNotNull.setPhoneInfoRawResult(str4);
                                            cacheInfoNotNull.setAuthToken(optString3);
                                            cacheInfoNotNull.setAuthTokenExpireTime(optLong);
                                            CarrierCacheInfoHelper.INSTANCE.saveCarrierCacheInfo(cacheInfoNotNull);
                                            if (str.equals(OnekeyDataHelper.GET_PHONE_EVENT)) {
                                                parseToAuthTokenResponse = cacheInfoNotNull.parseToPhoneInfoResponse();
                                            } else if (str.equals(OnekeyDataHelper.GET_VALIDATE_TOKEN_EVENT)) {
                                                parseToAuthTokenResponse = cacheInfoNotNull.parseToValidateTokenResponse();
                                            } else {
                                                parseToAuthTokenResponse = cacheInfoNotNull.parseToAuthTokenResponse();
                                            }
                                            ChinaUnionService.this.sendOneKeySuccessMessage(new OnekeyResponseCallable<>(authorizeCallback, parseToAuthTokenResponse));
                                            ChinaUnionService chinaUnionService = ChinaUnionService.this;
                                            chinaUnionService.onEvent(str, OnekeyDataHelper.generateMonitorJson(chinaUnionService.getContext(), true, null, null, currentTimeMillis2, null, OnekeyDataHelper.CU_EVENT_CARRIER, str2, str3, i2, authorizeCallback));
                                            return;
                                        }
                                        jSONObject = jSONObject2;
                                        str9 = optString;
                                        str7 = str5;
                                        str8 = str6;
                                    } catch (Exception e2) {
                                        e = e2;
                                        jSONObject3 = jSONObject2;
                                        str10 = optString;
                                        e.printStackTrace();
                                        jSONObject = jSONObject3;
                                        str7 = str5;
                                        str8 = str6;
                                        str9 = str10;
                                        if (OnekeyDataHelper.GET_PHONE_EVENT.equals(str)) {
                                        }
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    jSONObject3 = jSONObject2;
                                    str6 = "";
                                }
                            } catch (Exception e4) {
                                e = e4;
                                jSONObject3 = jSONObject2;
                                str5 = "";
                                str6 = str5;
                            }
                        } catch (Exception e5) {
                            e = e5;
                            jSONObject3 = jSONObject2;
                            str5 = "";
                            str6 = str5;
                            e.printStackTrace();
                            jSONObject = jSONObject3;
                            str7 = str5;
                            str8 = str6;
                            str9 = str10;
                            if (OnekeyDataHelper.GET_PHONE_EVENT.equals(str)) {
                            }
                        }
                    }
                    if (OnekeyDataHelper.GET_PHONE_EVENT.equals(str)) {
                        ChinaUnionService.this.postLoginErrorResponse(str9, str7, str8, OnekeyLoginConstants.UNICOM, str2, str3, i2, 1, currentTimeMillis2, jSONObject, authorizeCallback);
                    } else {
                        ChinaUnionService.this.postLoginErrorResponse(str9, str7, str8, OnekeyLoginConstants.UNICOM, str2, str3, i2, 2, currentTimeMillis2, jSONObject, authorizeCallback);
                    }
                }
            });
        } catch (Exception e) {
            if (OnekeyDataHelper.GET_PHONE_EVENT.equals(str)) {
                postLoginErrorResponse(OnekeyLoginConstants.ErrorCode.ERROR_CODE_UNKNOW, e.getMessage(), null, OnekeyLoginConstants.UNICOM, str2, str3, i2, 1, System.currentTimeMillis() - currentTimeMillis, null, authorizeCallback);
            } else {
                postLoginErrorResponse(OnekeyLoginConstants.ErrorCode.ERROR_CODE_UNKNOW, e.getMessage(), null, OnekeyLoginConstants.UNICOM, str2, str3, i2, 2, System.currentTimeMillis() - currentTimeMillis, null, authorizeCallback);
            }
        }
    }
}
