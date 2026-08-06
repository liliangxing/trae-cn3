package com.bytedance.sdk.account.platform.onekey.carrier;

import android.os.Bundle;
import com.bytedance.sdk.account.platform.api.IOnekeyLoginService;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.bytedance.sdk.account.platform.onekey.CarrierCacheInfoHelper;
import com.bytedance.sdk.account.platform.onekey.CommonUtils;
import com.bytedance.sdk.account.platform.onekey.NetworkTypeHelper;
import com.bytedance.sdk.account.platform.onekey.OnekeyDataHelper;
import com.bytedance.sdk.account.platform.onekey.OnekeyLoginConfig;
import com.bytedance.sdk.account.platform.onekey.OnekeyResponseCallable;
import com.bytedance.sdk.account.platform.onekey.OnekeySettingManager;
import com.cmic.sso.sdk.auth.AuthnHelper;
import com.cmic.sso.sdk.auth.TokenListener;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class ChinaMobileService extends AbsCarrier {
    private final AuthnHelper mAuthHelper;
    private final OnekeyLoginConfig.CMSettingConfig mCMSettingConfig;

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.AbsCarrier
    protected String settingKey() {
        return OnekeySettingManager.KEY_CM_CONFIG;
    }

    public ChinaMobileService(IServiceContainer iServiceContainer, OnekeyLoginConfig.CMSettingConfig cMSettingConfig) {
        super(iServiceContainer);
        this.mCMSettingConfig = cMSettingConfig;
        this.mAuthHelper = AuthnHelper.getInstance(iServiceContainer.getApplicationContext());
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.ICarrierService
    public void getPhoneInfo(final String str, final String str2, final int i, boolean z, final AuthorizeCallback authorizeCallback) {
        if (this.mCMSettingConfig == null) {
            if (authorizeCallback != null) {
                authorizeCallback.onError(OnekeyDataHelper.getErrorResponse(OnekeyLoginConstants.ErrorCode.ERROR_SDK_INIT, OnekeyLoginConstants.ErrorMsg.ERROR_SDK_INIT_MSG, "mobile", i, 1, null));
            }
            onEvent(OnekeyDataHelper.GET_PHONE_EVENT, OnekeyDataHelper.generateMonitorJson(getContext(), false, OnekeyLoginConstants.ErrorCode.ERROR_SDK_INIT, OnekeyLoginConstants.ErrorMsg.ERROR_SDK_INIT_MSG, 0L, null, OnekeyDataHelper.CM_EVENT_CARRIER, str, str2, i, authorizeCallback));
            return;
        }
        if (!isEnable()) {
            postCarrierDisableError("mobile", str, str2, i, OnekeyDataHelper.GET_PHONE_EVENT, 1, authorizeCallback);
            return;
        }
        boolean isMobileEnabled = NetworkTypeHelper.isMobileEnabled(i);
        if (needDataMobile(false) && !isMobileEnabled) {
            postDataMobileDisableError("mobile", str, str2, i, authorizeCallback);
            return;
        }
        if (needReadPhonePermission() && !CommonUtils.hasPermission(getContext(), "android.permission.READ_PHONE_STATE")) {
            postNoPermissionError(str, str2, i, OnekeyDataHelper.GET_PHONE_EVENT, 1, authorizeCallback);
            return;
        }
        onEvent(OnekeyDataHelper.GET_PHONE_SEND_EVENT, OnekeyDataHelper.getMonitorJson(getContext(), OnekeyDataHelper.CM_EVENT_CARRIER, str, str2, i, authorizeCallback));
        final long currentTimeMillis = System.currentTimeMillis();
        try {
            this.mAuthHelper.setOverTime(getTimeout(str));
            this.mAuthHelper.getPhoneInfo(this.mCMSettingConfig.mCMAppId, this.mCMSettingConfig.mCMAppKey, new TokenListener() { // from class: com.bytedance.sdk.account.platform.onekey.carrier.ChinaMobileService.1
                public void onGetTokenComplete(JSONObject jSONObject) {
                    String str3;
                    String str4;
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    if (jSONObject == null) {
                        str3 = OnekeyLoginConstants.ErrorCode.ERROR_CODE_UNKNOW;
                        str4 = "invalid_response";
                    } else {
                        if (jSONObject.has(OnekeyLoginConstants.CM_KEY_PRE_PHONE_SCRIP)) {
                            String optString = jSONObject.optString(OnekeyLoginConstants.CM_KEY_PRE_PHONE_SCRIP);
                            int optInt = jSONObject.optInt("scripExpiresIn");
                            MobileCarrierCacheInfo cacheInfoNotNull = ChinaMobileService.this.getCacheInfoNotNull();
                            cacheInfoNotNull.setMaskPhone(optString);
                            cacheInfoNotNull.setScripExpiresTime(System.currentTimeMillis() + (optInt * 1000));
                            cacheInfoNotNull.setPhoneInfoRawResult(jSONObject.toString());
                            CarrierCacheInfoHelper.INSTANCE.saveCarrierCacheInfo(cacheInfoNotNull);
                            ChinaMobileService.this.sendOneKeySuccessMessage(new OnekeyResponseCallable<>(authorizeCallback, cacheInfoNotNull.parseToPhoneInfoResponse()));
                            ChinaMobileService chinaMobileService = ChinaMobileService.this;
                            chinaMobileService.onEvent(OnekeyDataHelper.GET_PHONE_EVENT, OnekeyDataHelper.generateMonitorJson(chinaMobileService.getContext(), true, null, null, currentTimeMillis2, null, OnekeyDataHelper.CM_EVENT_CARRIER, str, str2, i, authorizeCallback));
                            return;
                        }
                        str3 = jSONObject.optString("resultCode");
                        str4 = jSONObject.optString(OnekeyLoginConstants.CM_RESULT_DESC);
                    }
                    ChinaMobileService.this.postLoginErrorResponse(str3, str4, null, "mobile", str, str2, i, 1, System.currentTimeMillis() - currentTimeMillis, jSONObject, authorizeCallback);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            postLoginErrorResponse(OnekeyLoginConstants.ErrorCode.ERROR_CODE_UNKNOW, e.getMessage(), null, "mobile", str, str2, i, 1, System.currentTimeMillis() - currentTimeMillis, null, authorizeCallback);
        }
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.ICarrierService
    public void getAuthToken(final int i, final AuthorizeCallback authorizeCallback) {
        if (!isEnable()) {
            postCarrierDisableError("mobile", null, null, i, OnekeyDataHelper.GET_TOKEN_EVENT, 2, authorizeCallback);
            return;
        }
        if (needReadPhonePermission() && !CommonUtils.hasPermission(getContext(), "android.permission.READ_PHONE_STATE")) {
            postNoPermissionError(null, null, i, OnekeyDataHelper.GET_TOKEN_EVENT, 2, authorizeCallback);
            return;
        }
        if (this.mCMSettingConfig == null) {
            if (authorizeCallback != null) {
                authorizeCallback.onError(OnekeyDataHelper.getErrorResponse(OnekeyLoginConstants.ErrorCode.ERROR_SDK_INIT, OnekeyLoginConstants.ErrorMsg.ERROR_SDK_INIT_MSG, "mobile", i, 2, null));
            }
            onEvent(OnekeyDataHelper.GET_TOKEN_EVENT, OnekeyDataHelper.generateMonitorJson(getContext(), false, OnekeyLoginConstants.ErrorCode.ERROR_SDK_INIT, OnekeyLoginConstants.ErrorMsg.ERROR_SDK_INIT_MSG, 0L, null, OnekeyDataHelper.CM_EVENT_CARRIER, null, null, i, authorizeCallback));
            return;
        }
        onEvent(OnekeyDataHelper.GET_TOKEN_SEND_EVENT, OnekeyDataHelper.getMonitorJson(getContext(), OnekeyDataHelper.CM_EVENT_CARRIER, null, null, i, authorizeCallback));
        final long currentTimeMillis = System.currentTimeMillis();
        try {
            this.mAuthHelper.setOverTime(getTimeout(null));
            this.mAuthHelper.loginAuth(this.mCMSettingConfig.mCMAppId, this.mCMSettingConfig.mCMAppKey, new TokenListener() { // from class: com.bytedance.sdk.account.platform.onekey.carrier.ChinaMobileService.2
                public void onGetTokenComplete(JSONObject jSONObject) {
                    String str;
                    String str2;
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    if (jSONObject == null) {
                        str = OnekeyLoginConstants.ErrorCode.ERROR_CODE_UNKNOW;
                    } else if (OnekeyLoginConstants.CM_RESULT_SUCCESS.equals(jSONObject.optString("resultCode"))) {
                        if (jSONObject.has("token")) {
                            String optString = jSONObject.optString(OnekeyLoginConstants.CM_KEY_PRE_PHONE_SCRIP);
                            String optString2 = jSONObject.optString("token");
                            String optString3 = jSONObject.optString("authType");
                            String optString4 = jSONObject.optString("openId");
                            String optString5 = jSONObject.optString("authTypeDes");
                            int optInt = jSONObject.optInt("scripExpiresIn");
                            int optInt2 = jSONObject.optInt(OnekeyLoginConstants.CM_KEY_TOKEN_EXPIRES_IN);
                            Bundle bundle = new Bundle();
                            bundle.putString(IOnekeyLoginService.ResponseConstants.SECURITY_PHONE, optString);
                            bundle.putString("access_token", optString2);
                            bundle.putString(IOnekeyLoginService.ResponseConstants.NET_TYPE, "mobile");
                            bundle.putString(IOnekeyLoginService.ResponseConstants.CARRIER_FROM, "mobile");
                            bundle.putString("openId", optString4);
                            bundle.putString("authType", optString3);
                            bundle.putString("authTypeDes", optString5);
                            bundle.putString("scripExpiresIn", String.valueOf(optInt));
                            bundle.putString("expires_in", String.valueOf(optInt2));
                            bundle.putString(IOnekeyLoginService.ResponseConstants.TOKEN_EXPIRES_TIME, String.valueOf(System.currentTimeMillis() + (optInt2 * 1000)));
                            bundle.putString(IOnekeyLoginService.ResponseConstants.RAW_RESULT, jSONObject.toString());
                            bundle.putString("carrier_app_id", ChinaMobileService.this.mCMSettingConfig.mCMAppId);
                            MobileCarrierCacheInfo cacheInfoNotNull = ChinaMobileService.this.getCacheInfoNotNull();
                            cacheInfoNotNull.setMaskPhone(optString);
                            cacheInfoNotNull.setScripExpiresTime(System.currentTimeMillis() + (optInt * 1000));
                            CarrierCacheInfoHelper.INSTANCE.saveCarrierCacheInfo(cacheInfoNotNull);
                            ChinaMobileService.this.sendOneKeySuccessMessage(new OnekeyResponseCallable<>(authorizeCallback, bundle));
                            ChinaMobileService chinaMobileService = ChinaMobileService.this;
                            chinaMobileService.onEvent(OnekeyDataHelper.GET_TOKEN_EVENT, OnekeyDataHelper.generateMonitorJson(chinaMobileService.getContext(), true, null, null, currentTimeMillis2, null, OnekeyDataHelper.CM_EVENT_CARRIER, null, null, i, authorizeCallback));
                            return;
                        }
                        str = jSONObject.optString("resultCode");
                    } else {
                        str2 = "unknown";
                        str = jSONObject.optString("resultCode");
                        ChinaMobileService.this.postLoginErrorResponse(str, str2, null, "mobile", null, null, i, 2, System.currentTimeMillis() - currentTimeMillis, jSONObject, authorizeCallback);
                    }
                    str2 = "invalid_response";
                    ChinaMobileService.this.postLoginErrorResponse(str, str2, null, "mobile", null, null, i, 2, System.currentTimeMillis() - currentTimeMillis, jSONObject, authorizeCallback);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            postLoginErrorResponse(OnekeyLoginConstants.ErrorCode.ERROR_CODE_UNKNOW, e.getMessage(), null, "mobile", null, null, i, 2, System.currentTimeMillis() - currentTimeMillis, null, authorizeCallback);
        }
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.ICarrierService
    public void getValidateToken(final int i, final AuthorizeCallback authorizeCallback) {
        if (!isEnable()) {
            postCarrierDisableError("mobile", null, null, i, OnekeyDataHelper.GET_VALIDATE_TOKEN_EVENT, 2, authorizeCallback);
            return;
        }
        if (needReadPhonePermission() && !CommonUtils.hasPermission(getContext(), "android.permission.READ_PHONE_STATE")) {
            postNoPermissionError(null, null, i, OnekeyDataHelper.GET_VALIDATE_TOKEN_EVENT, 2, authorizeCallback);
            return;
        }
        if (this.mCMSettingConfig == null) {
            if (authorizeCallback != null && !this.isCancel) {
                authorizeCallback.onError(OnekeyDataHelper.getErrorResponse(OnekeyLoginConstants.ErrorCode.ERROR_SDK_INIT, OnekeyLoginConstants.ErrorMsg.ERROR_SDK_INIT_MSG, "mobile", i, 2, null));
            }
            onEvent(OnekeyDataHelper.GET_VALIDATE_TOKEN_EVENT, OnekeyDataHelper.generateMonitorJson(getContext(), false, OnekeyLoginConstants.ErrorCode.ERROR_SDK_INIT, OnekeyLoginConstants.ErrorMsg.ERROR_SDK_INIT_MSG, 0L, null, OnekeyDataHelper.CM_EVENT_CARRIER, null, null, i, authorizeCallback));
            return;
        }
        onEvent(OnekeyDataHelper.GET_VALIDATE_TOKEN_SEND_EVENT, OnekeyDataHelper.getMonitorJson(getContext(), OnekeyDataHelper.CM_EVENT_CARRIER, null, null, i, authorizeCallback));
        final long currentTimeMillis = System.currentTimeMillis();
        try {
            this.mAuthHelper.setOverTime(getTimeout(null));
            this.mAuthHelper.mobileAuth(this.mCMSettingConfig.mCMAppId, this.mCMSettingConfig.mCMAppKey, new TokenListener() { // from class: com.bytedance.sdk.account.platform.onekey.carrier.ChinaMobileService.3
                public void onGetTokenComplete(JSONObject jSONObject) {
                    String str;
                    String str2;
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    if (jSONObject == null) {
                        str = OnekeyLoginConstants.ErrorCode.ERROR_CODE_UNKNOW;
                    } else if (OnekeyLoginConstants.CM_RESULT_SUCCESS.equals(jSONObject.optString("resultCode"))) {
                        if (jSONObject.has("token")) {
                            String optString = jSONObject.optString("token");
                            String optString2 = jSONObject.optString("authType");
                            String optString3 = jSONObject.optString("authTypeDes");
                            int optInt = jSONObject.optInt("scripExpiresIn");
                            int optInt2 = jSONObject.optInt(OnekeyLoginConstants.CM_KEY_TOKEN_EXPIRES_IN);
                            Bundle bundle = new Bundle();
                            bundle.putString("access_token", optString);
                            bundle.putString(IOnekeyLoginService.ResponseConstants.NET_TYPE, "mobile");
                            bundle.putString(IOnekeyLoginService.ResponseConstants.CARRIER_FROM, "mobile");
                            bundle.putString("authType", optString2);
                            bundle.putString("authTypeDes", optString3);
                            bundle.putString("scripExpiresIn", String.valueOf(optInt));
                            bundle.putString("expires_in", String.valueOf(optInt2));
                            bundle.putString(IOnekeyLoginService.ResponseConstants.TOKEN_EXPIRES_TIME, String.valueOf(System.currentTimeMillis() + (optInt2 * 1000)));
                            bundle.putString(IOnekeyLoginService.ResponseConstants.RAW_RESULT, jSONObject.toString());
                            bundle.putString("carrier_app_id", ChinaMobileService.this.mCMSettingConfig.mCMAppId);
                            AbsCarrierCacheInfo carrierCacheInfo = CarrierCacheInfoHelper.INSTANCE.getCarrierCacheInfo(NetworkTypeHelper.getDefaultDataSubscriptionId(ChinaMobileService.this.getContext()));
                            if (carrierCacheInfo instanceof MobileCarrierCacheInfo) {
                                MobileCarrierCacheInfo mobileCarrierCacheInfo = (MobileCarrierCacheInfo) carrierCacheInfo;
                                mobileCarrierCacheInfo.setScripExpiresTime(System.currentTimeMillis() + (optInt * 1000));
                                CarrierCacheInfoHelper.INSTANCE.saveCarrierCacheInfo(mobileCarrierCacheInfo);
                            }
                            ChinaMobileService.this.sendOneKeySuccessMessage(new OnekeyResponseCallable<>(authorizeCallback, bundle));
                            ChinaMobileService chinaMobileService = ChinaMobileService.this;
                            chinaMobileService.onEvent(OnekeyDataHelper.GET_VALIDATE_TOKEN_EVENT, OnekeyDataHelper.generateMonitorJson(chinaMobileService.getContext(), true, null, null, currentTimeMillis2, null, OnekeyDataHelper.CM_EVENT_CARRIER, null, null, i, authorizeCallback));
                            return;
                        }
                        str = jSONObject.optString("resultCode");
                    } else {
                        str2 = "unknown";
                        str = jSONObject.optString("resultCode");
                        ChinaMobileService.this.postLoginErrorResponse(str, str2, null, "mobile", null, null, i, 2, System.currentTimeMillis() - currentTimeMillis, jSONObject, authorizeCallback);
                    }
                    str2 = "invalid_response";
                    ChinaMobileService.this.postLoginErrorResponse(str, str2, null, "mobile", null, null, i, 2, System.currentTimeMillis() - currentTimeMillis, jSONObject, authorizeCallback);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            postLoginErrorResponse(OnekeyLoginConstants.ErrorCode.ERROR_CODE_UNKNOW, e.getMessage(), null, "mobile", null, null, i, 2, System.currentTimeMillis() - currentTimeMillis, null, authorizeCallback);
        }
    }

    protected MobileCarrierCacheInfo getCacheInfoNotNull() {
        int defaultDataSubscriptionId = NetworkTypeHelper.getDefaultDataSubscriptionId(getContext());
        AbsCarrierCacheInfo carrierCacheInfo = CarrierCacheInfoHelper.INSTANCE.getCarrierCacheInfo(defaultDataSubscriptionId);
        if (carrierCacheInfo instanceof MobileCarrierCacheInfo) {
            return (MobileCarrierCacheInfo) carrierCacheInfo;
        }
        return new MobileCarrierCacheInfo(defaultDataSubscriptionId);
    }

    private void postNoPermissionError(String str, String str2, int i, String str3, int i2, AuthorizeCallback authorizeCallback) {
        if (authorizeCallback != null && !this.isCancel) {
            authorizeCallback.onError(getErrorResponse(OnekeyLoginConstants.ErrorCode.ERROR_NO_PHONE_STATE_PERMISSON, OnekeyLoginConstants.ErrorMsg.ERROR_NO_PHONE_STATE_PERMISSON_MSG, "mobile", i, i2));
        }
        onEvent(str3, OnekeyDataHelper.generateMonitorJson(getContext(), false, OnekeyLoginConstants.ErrorCode.ERROR_NO_PHONE_STATE_PERMISSON, OnekeyLoginConstants.ErrorMsg.ERROR_NO_PHONE_STATE_PERMISSON_MSG, 0L, null, "mobile", str, str2, i, authorizeCallback));
    }
}
