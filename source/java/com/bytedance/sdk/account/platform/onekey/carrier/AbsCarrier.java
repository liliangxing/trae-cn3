package com.bytedance.sdk.account.platform.onekey.carrier;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.bytedance.sdk.account.platform.base.OnekeyLoginErrorResponse;
import com.bytedance.sdk.account.platform.onekey.OnekeyDataHelper;
import com.bytedance.sdk.account.platform.onekey.OnekeyLoginConfig;
import com.bytedance.sdk.account.platform.onekey.OnekeyResponseCallable;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class AbsCarrier implements ICarrierService {
    protected boolean isCancel;
    private final IServiceContainer mContainer;

    private String getMonitorEvent(int i) {
        return i != 1 ? (i == 2 || i == 3) ? OnekeyDataHelper.GET_TOKEN_EVENT : "" : OnekeyDataHelper.GET_PHONE_EVENT;
    }

    protected void notifyTimeout(OnekeyResponseCallable<?> onekeyResponseCallable) {
    }

    protected abstract String settingKey();

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbsCarrier(IServiceContainer iServiceContainer) {
        this.mContainer = iServiceContainer;
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.ICarrierService
    public void cancel() {
        this.isCancel = false;
    }

    private Handler getHandler() {
        IServiceContainer iServiceContainer = this.mContainer;
        if (iServiceContainer == null) {
            return null;
        }
        return iServiceContainer.getHandler();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clearTimer() {
        Handler handler = getHandler();
        if (handler == null) {
            return;
        }
        handler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startTimer(long j, final OnekeyResponseCallable<?> onekeyResponseCallable) {
        Handler handler = getHandler();
        if (handler == null) {
            return;
        }
        handler.postDelayed(new Runnable() { // from class: com.bytedance.sdk.account.platform.onekey.carrier.AbsCarrier.1
            @Override // java.lang.Runnable
            public void run() {
                AbsCarrier.this.notifyTimeout(onekeyResponseCallable);
            }
        }, j);
    }

    protected void sendOneKeyFailedMessage(final OnekeyResponseCallable<?> onekeyResponseCallable) {
        Handler handler;
        if (this.isCancel || onekeyResponseCallable == null || (handler = getHandler()) == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.bytedance.sdk.account.platform.onekey.carrier.AbsCarrier.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                if (onekeyResponseCallable.mCallback == null || !(onekeyResponseCallable.response instanceof OnekeyLoginErrorResponse)) {
                    return;
                }
                onekeyResponseCallable.mCallback.onError((OnekeyLoginErrorResponse) onekeyResponseCallable.response);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendOneKeySuccessMessage(final OnekeyResponseCallable<?> onekeyResponseCallable) {
        Handler handler;
        if (this.isCancel || onekeyResponseCallable == null || (handler = getHandler()) == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.bytedance.sdk.account.platform.onekey.carrier.AbsCarrier.3
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                AuthorizeCallback authorizeCallback = onekeyResponseCallable.mCallback;
                if (authorizeCallback != null) {
                    if (onekeyResponseCallable.response instanceof Bundle) {
                        authorizeCallback.onSuccess((Bundle) onekeyResponseCallable.response);
                    } else {
                        authorizeCallback.onError(new AuthorizeErrorResponse(OnekeyLoginConstants.ErrorCode.ERROR_CODE_UNKNOW, "unknown"));
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context getContext() {
        IServiceContainer iServiceContainer = this.mContainer;
        if (iServiceContainer != null) {
            return iServiceContainer.getApplicationContext();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isEnable() {
        IServiceContainer iServiceContainer = this.mContainer;
        if (iServiceContainer != null) {
            return iServiceContainer.getSetting().isEnable(settingKey());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean needDataMobile(boolean z) {
        IServiceContainer iServiceContainer = this.mContainer;
        if (iServiceContainer != null) {
            return iServiceContainer.getSetting().needDataMobile(settingKey(), z);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean needReadPhonePermission() {
        IServiceContainer iServiceContainer = this.mContainer;
        if (iServiceContainer != null) {
            return iServiceContainer.getSetting().needReadPhonePermission(settingKey());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long getTimeout(String str) {
        IServiceContainer iServiceContainer = this.mContainer;
        return iServiceContainer != null ? iServiceContainer.getSetting().getSceneTimeOut(str, settingKey()) : OnekeyLoginConfig.OVER_TIME;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onEvent(String str, JSONObject jSONObject) {
        IServiceContainer iServiceContainer = this.mContainer;
        if (iServiceContainer != null) {
            iServiceContainer.onEvent(str, jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public OnekeyLoginErrorResponse getErrorResponse(String str, String str2, String str3, int i, int i2) {
        OnekeyLoginErrorResponse onekeyLoginErrorResponse = new OnekeyLoginErrorResponse();
        onekeyLoginErrorResponse.netType = str3;
        onekeyLoginErrorResponse.netStatus = i;
        onekeyLoginErrorResponse.platformErrorCode = str;
        onekeyLoginErrorResponse.platformErrorMsg = str2;
        onekeyLoginErrorResponse.errorType = i2;
        onekeyLoginErrorResponse.rawResult = null;
        return onekeyLoginErrorResponse;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void postCarrierDisableError(String str, String str2, String str3, int i, String str4, int i2, AuthorizeCallback authorizeCallback) {
        if (authorizeCallback != null && !this.isCancel) {
            authorizeCallback.onError(getErrorResponse(OnekeyLoginConstants.ErrorCode.ERROR_CARRIER_DISABLED, OnekeyLoginConstants.ErrorMsg.ERROR_CARRIER_DISABLED_MSG, str, i, i2));
        }
        onEvent(str4, OnekeyDataHelper.generateMonitorJson(getContext(), false, OnekeyLoginConstants.ErrorCode.ERROR_CARRIER_DISABLED, OnekeyLoginConstants.ErrorMsg.ERROR_CARRIER_DISABLED_MSG, 0L, null, str, str2, str3, i, authorizeCallback));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void postDataMobileDisableError(String str, String str2, String str3, int i, AuthorizeCallback authorizeCallback) {
        if (authorizeCallback != null && !this.isCancel) {
            authorizeCallback.onError(getErrorResponse(OnekeyLoginConstants.ErrorCode.ERROR_CARRIER_DATA_MOBILE_DISABLED, OnekeyLoginConstants.ErrorMsg.ERROR_CARRIER_DATA_MOBILE_DISABLED_MSG, str, i, 1));
        }
        onEvent(OnekeyDataHelper.GET_PHONE_EVENT, OnekeyDataHelper.generateMonitorJson(getContext(), false, OnekeyLoginConstants.ErrorCode.ERROR_CARRIER_DATA_MOBILE_DISABLED, OnekeyLoginConstants.ErrorMsg.ERROR_CARRIER_DATA_MOBILE_DISABLED_MSG, 0L, null, str, str2, str3, i, authorizeCallback));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void postLoginErrorResponse(String str, String str2, String str3, String str4, String str5, String str6, int i, int i2, long j, JSONObject jSONObject, AuthorizeCallback authorizeCallback) {
        sendOneKeyFailedMessage(new OnekeyResponseCallable<>(authorizeCallback, OnekeyDataHelper.getErrorResponse(str, str2, str4, i, i2, jSONObject)));
        onEvent(getMonitorEvent(i2), OnekeyDataHelper.generateMonitorJson(getContext(), false, str, str2, j, str3, OnekeyDataHelper.getCarrierEvent(str4), str5, str6, i, authorizeCallback));
    }
}
