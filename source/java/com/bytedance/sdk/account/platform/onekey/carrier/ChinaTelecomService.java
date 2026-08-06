package com.bytedance.sdk.account.platform.onekey.carrier;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import cn.com.chinatelecom.account.api.CtAuth;
import cn.com.chinatelecom.account.api.CtSetting;
import cn.com.chinatelecom.account.api.ResultListener;
import cn.com.chinatelecom.account.api.TraceLogger;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.bytedance.sdk.account.platform.base.OnekeyLoginErrorResponse;
import com.bytedance.sdk.account.platform.onekey.CarrierCacheInfoHelper;
import com.bytedance.sdk.account.platform.onekey.NetworkTypeHelper;
import com.bytedance.sdk.account.platform.onekey.OnekeyDataHelper;
import com.bytedance.sdk.account.platform.onekey.OnekeyLoginConfig;
import com.bytedance.sdk.account.platform.onekey.OnekeyResponseCallable;
import com.bytedance.sdk.account.platform.onekey.OnekeySettingManager;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class ChinaTelecomService extends AbsCarrier {
    private final OnekeyLoginConfig.CTSettingConfig mCTSettingConfig;

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.AbsCarrier
    protected String settingKey() {
        return OnekeySettingManager.KEY_CT_CONFIG;
    }

    public ChinaTelecomService(IServiceContainer iServiceContainer, OnekeyLoginConfig.CTSettingConfig cTSettingConfig) {
        super(iServiceContainer);
        this.mCTSettingConfig = cTSettingConfig;
        if (cTSettingConfig.isShowLog()) {
            CtAuth.getInstance().init(getContext(), cTSettingConfig.mCTAppKey, cTSettingConfig.mCTAppSecret, new TraceLogger() { // from class: com.bytedance.sdk.account.platform.onekey.carrier.ChinaTelecomService.1
                public void debug(String str, String str2) {
                    Log.d(getTag(str), str2 + "");
                }

                public void info(String str, String str2) {
                    Log.i(getTag(str), str2 + "");
                }

                public void warn(String str, String str2, Throwable th) {
                    Log.w(getTag(str), str2);
                }

                private String getTag(String str) {
                    if (!TextUtils.isEmpty(ChinaTelecomService.this.mCTSettingConfig.getLogTag())) {
                        return ChinaTelecomService.this.mCTSettingConfig.getLogTag();
                    }
                    return str + "";
                }
            });
        } else {
            CtAuth.getInstance().init(getContext(), cTSettingConfig.mCTAppKey, cTSettingConfig.mCTAppSecret, (TraceLogger) null);
        }
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.ICarrierService
    public void getPhoneInfo(String str, String str2, int i, boolean z, AuthorizeCallback authorizeCallback) {
        if (!isEnable()) {
            postCarrierDisableError(OnekeyLoginConstants.TELECOM, str, str2, i, OnekeyDataHelper.GET_PHONE_EVENT, 1, authorizeCallback);
            return;
        }
        boolean isMobileEnabled = NetworkTypeHelper.isMobileEnabled(i);
        if (needDataMobile(true) && !isMobileEnabled) {
            postDataMobileDisableError(OnekeyLoginConstants.TELECOM, str, str2, i, authorizeCallback);
        } else {
            getCtInfo(OnekeyDataHelper.GET_PHONE_EVENT, str, str2, i, authorizeCallback);
        }
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.ICarrierService
    public void getAuthToken(int i, AuthorizeCallback authorizeCallback) {
        if (!isEnable()) {
            postCarrierDisableError(OnekeyLoginConstants.TELECOM, null, null, i, OnekeyDataHelper.GET_TOKEN_EVENT, 2, authorizeCallback);
        } else {
            getCtInfo(OnekeyDataHelper.GET_TOKEN_EVENT, null, null, i, authorizeCallback);
        }
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.ICarrierService
    public void getValidateToken(int i, AuthorizeCallback authorizeCallback) {
        if (!isEnable()) {
            postCarrierDisableError(OnekeyLoginConstants.TELECOM, null, null, i, OnekeyDataHelper.GET_VALIDATE_TOKEN_EVENT, 2, authorizeCallback);
        } else {
            getCtInfo(OnekeyDataHelper.GET_VALIDATE_TOKEN_EVENT, null, null, i, authorizeCallback);
        }
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.AbsCarrier, com.bytedance.sdk.account.platform.onekey.carrier.ICarrierService
    public void cancel() {
        this.isCancel = false;
    }

    protected TelecomCarrierCacheInfo getCacheInfoNotNull() {
        int defaultDataSubscriptionId = NetworkTypeHelper.getDefaultDataSubscriptionId(getContext());
        AbsCarrierCacheInfo carrierCacheInfo = CarrierCacheInfoHelper.INSTANCE.getCarrierCacheInfo(defaultDataSubscriptionId);
        if (carrierCacheInfo instanceof TelecomCarrierCacheInfo) {
            return (TelecomCarrierCacheInfo) carrierCacheInfo;
        }
        return new TelecomCarrierCacheInfo(defaultDataSubscriptionId);
    }

    private void getCtInfo(final String str, final String str2, final String str3, final int i, final AuthorizeCallback authorizeCallback) {
        OnekeyLoginErrorResponse errorResponse;
        if (this.mCTSettingConfig == null) {
            if (authorizeCallback != null) {
                if (str.equals(OnekeyDataHelper.GET_PHONE_EVENT)) {
                    errorResponse = OnekeyDataHelper.getErrorResponse(OnekeyLoginConstants.ErrorCode.ERROR_SDK_INIT, OnekeyLoginConstants.ErrorMsg.ERROR_SDK_INIT_MSG, OnekeyLoginConstants.TELECOM, i, 1, null);
                } else {
                    errorResponse = OnekeyDataHelper.getErrorResponse(OnekeyLoginConstants.ErrorCode.ERROR_SDK_INIT, OnekeyLoginConstants.ErrorMsg.ERROR_SDK_INIT_MSG, OnekeyLoginConstants.TELECOM, i, 2, null);
                }
                authorizeCallback.onError(errorResponse);
            }
            onEvent(str, OnekeyDataHelper.generateMonitorJson(getContext(), false, OnekeyLoginConstants.ErrorCode.ERROR_SDK_INIT, OnekeyLoginConstants.ErrorMsg.ERROR_SDK_INIT_MSG, 0L, null, OnekeyDataHelper.CT_EVENT_CARRIER, str2, str3, i, authorizeCallback));
            return;
        }
        if (str.equals(OnekeyDataHelper.GET_PHONE_EVENT)) {
            onEvent(OnekeyDataHelper.GET_PHONE_SEND_EVENT, OnekeyDataHelper.getMonitorJson(getContext(), OnekeyDataHelper.CT_EVENT_CARRIER, str2, str3, i, authorizeCallback));
        } else if (str.equals(OnekeyDataHelper.GET_VALIDATE_TOKEN_EVENT)) {
            onEvent(OnekeyDataHelper.GET_VALIDATE_TOKEN_SEND_EVENT, OnekeyDataHelper.getMonitorJson(getContext(), OnekeyDataHelper.CT_EVENT_CARRIER, str2, str3, i, authorizeCallback));
        } else {
            onEvent(OnekeyDataHelper.GET_TOKEN_SEND_EVENT, OnekeyDataHelper.getMonitorJson(getContext(), OnekeyDataHelper.CT_EVENT_CARRIER, str2, str3, i, authorizeCallback));
        }
        int timeout = (int) getTimeout(str2);
        final long currentTimeMillis = System.currentTimeMillis();
        try {
            CtAuth.getInstance().requestPreLogin(new CtSetting(timeout, timeout, timeout), new ResultListener() { // from class: com.bytedance.sdk.account.platform.onekey.carrier.ChinaTelecomService.2
                /* JADX WARN: Removed duplicated region for block: B:10:0x0114  */
                /* JADX WARN: Removed duplicated region for block: B:7:0x00f5  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onResult(String str4) {
                    JSONObject jSONObject;
                    String optString;
                    JSONObject jSONObject2;
                    String str5;
                    String optString2;
                    JSONObject jSONObject3;
                    Bundle parseToAuthTokenResponse;
                    String str6 = "unknown";
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    JSONObject jSONObject4 = null;
                    if (!TextUtils.isEmpty(str4)) {
                        try {
                            jSONObject = new JSONObject(str4);
                            try {
                            } catch (Exception e) {
                                e = e;
                                jSONObject4 = jSONObject;
                                e.printStackTrace();
                                optString = str6;
                                str5 = OnekeyLoginConstants.ErrorCode.ERROR_CODE_UNKNOW;
                                optString2 = "";
                                jSONObject2 = jSONObject4;
                                if (OnekeyDataHelper.GET_PHONE_EVENT.equals(str)) {
                                }
                            }
                        } catch (Exception e2) {
                            e = e2;
                        }
                        if (jSONObject.optInt("result") == 0 && (jSONObject3 = (JSONObject) jSONObject.opt("data")) != null && jSONObject3.has("number")) {
                            String optString3 = jSONObject3.optString("number");
                            String optString4 = jSONObject3.optString("accessCode");
                            int optInt = jSONObject3.optInt("expiredTime");
                            TelecomCarrierCacheInfo cacheInfoNotNull = ChinaTelecomService.this.getCacheInfoNotNull();
                            cacheInfoNotNull.setMaskPhone(optString3);
                            cacheInfoNotNull.setPhoneInfoRawResult(jSONObject.toString());
                            cacheInfoNotNull.setAuthToken(optString4);
                            cacheInfoNotNull.setAuthTokenExpireTime(System.currentTimeMillis() + (optInt * 1000));
                            CarrierCacheInfoHelper.INSTANCE.saveCarrierCacheInfo(cacheInfoNotNull);
                            if (str.equals(OnekeyDataHelper.GET_PHONE_EVENT)) {
                                parseToAuthTokenResponse = cacheInfoNotNull.parseToPhoneInfoResponse();
                            } else if (str.equals(OnekeyDataHelper.GET_VALIDATE_TOKEN_EVENT)) {
                                parseToAuthTokenResponse = cacheInfoNotNull.parseToValidateTokenResponse();
                            } else {
                                parseToAuthTokenResponse = cacheInfoNotNull.parseToAuthTokenResponse();
                            }
                            ChinaTelecomService.this.sendOneKeySuccessMessage(new OnekeyResponseCallable<>(authorizeCallback, parseToAuthTokenResponse));
                            ChinaTelecomService chinaTelecomService = ChinaTelecomService.this;
                            chinaTelecomService.onEvent(str, OnekeyDataHelper.generateMonitorJson(chinaTelecomService.getContext(), true, null, null, currentTimeMillis2, null, OnekeyDataHelper.CT_EVENT_CARRIER, str2, str3, i, authorizeCallback));
                            return;
                        }
                        String valueOf = String.valueOf(jSONObject.optInt("result"));
                        optString = jSONObject.optString("msg");
                        jSONObject2 = jSONObject;
                        str5 = valueOf;
                        optString2 = jSONObject.optString("reqId");
                        if (OnekeyDataHelper.GET_PHONE_EVENT.equals(str)) {
                            ChinaTelecomService.this.postLoginErrorResponse(str5, optString, optString2, OnekeyLoginConstants.TELECOM_V2, str2, str3, i, 1, System.currentTimeMillis() - currentTimeMillis, jSONObject2, authorizeCallback);
                            return;
                        } else {
                            ChinaTelecomService.this.postLoginErrorResponse(str5, optString, optString2, OnekeyLoginConstants.TELECOM_V2, str2, str3, i, 2, System.currentTimeMillis() - currentTimeMillis, jSONObject2, authorizeCallback);
                            return;
                        }
                    }
                    str6 = "invalid_response";
                    optString = str6;
                    str5 = OnekeyLoginConstants.ErrorCode.ERROR_CODE_UNKNOW;
                    optString2 = "";
                    jSONObject2 = jSONObject4;
                    if (OnekeyDataHelper.GET_PHONE_EVENT.equals(str)) {
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            if (OnekeyDataHelper.GET_PHONE_EVENT.equals(str)) {
                postLoginErrorResponse(OnekeyLoginConstants.ErrorCode.ERROR_CODE_UNKNOW, e.getMessage(), null, OnekeyLoginConstants.TELECOM_V2, str2, str3, i, 1, System.currentTimeMillis() - currentTimeMillis, null, authorizeCallback);
            } else {
                postLoginErrorResponse(OnekeyLoginConstants.ErrorCode.ERROR_CODE_UNKNOW, e.getMessage(), null, OnekeyLoginConstants.TELECOM_V2, str2, str3, i, 2, System.currentTimeMillis() - currentTimeMillis, null, authorizeCallback);
            }
        }
    }
}
