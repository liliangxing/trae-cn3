package com.bytedance.sdk.account.platform.onekey;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.account.platform.api.IOnekeyLoginService;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.bytedance.sdk.account.platform.onekey.NetworkTypeHelper;
import com.bytedance.sdk.account.platform.onekey.carrier.AbsCarrierCacheInfo;
import com.bytedance.sdk.account.platform.onekey.carrier.ChinaMobileService;
import com.bytedance.sdk.account.platform.onekey.carrier.ChinaTelecomService;
import com.bytedance.sdk.account.platform.onekey.carrier.ChinaUnionService;
import com.bytedance.sdk.account.platform.onekey.carrier.ICarrierService;
import com.bytedance.sdk.account.platform.onekey.carrier.IServiceContainer;
import com.bytedance.sdk.account.platform.onekey.carrier.UnSupportCarrier;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class OnekeyLoginServiceImpl implements IOnekeyLoginService, IServiceContainer {
    private final Map<String, ICarrierService> carrierServices;
    private ICarrierService currentCarrier;
    private final Context mApplicationContext;
    private final OnekeyLoginConfig mConfig;
    private final Handler mHandler;
    private final IOnekeyMonitor mMonitor;
    private final UnSupportCarrier unSupportCarrier;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OnekeyLoginServiceImpl(Context context, OnekeyLoginConfig onekeyLoginConfig) {
        HashMap hashMap = new HashMap();
        this.carrierServices = hashMap;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mApplicationContext = context.getApplicationContext();
        this.mConfig = onekeyLoginConfig;
        IOnekeyMonitor monitor = onekeyLoginConfig.getMonitor();
        this.mMonitor = monitor;
        this.unSupportCarrier = new UnSupportCarrier(this);
        hashMap.put("mobile", new ChinaMobileService(this, onekeyLoginConfig.getCMSettingConfig()));
        hashMap.put(OnekeyLoginConstants.TELECOM, new ChinaTelecomService(this, onekeyLoginConfig.getCTSettingConfig()));
        hashMap.put(OnekeyLoginConstants.UNICOM, new ChinaUnionService(this, onekeyLoginConfig.getCUSettingConfig()));
        NetworkTypeHelper.setMonitor(monitor);
        NetworkTypeHelper.registerReceiver(context);
    }

    @Override // com.bytedance.sdk.account.platform.api.IOnekeyLoginService
    public String getCarrier() {
        String carrierType = NetworkTypeHelper.getCarrierType(this.mApplicationContext);
        onEvent(OnekeyDataHelper.GET_CARRIER_EVENT, OnekeyDataHelper.generateGetCarrierEvent(this.mApplicationContext, carrierType));
        return carrierType;
    }

    @Override // com.bytedance.sdk.account.platform.api.IOnekeyLoginService
    public int getNetworkStatus() {
        int networkStatus = NetworkTypeHelper.getNetworkStatus(this.mApplicationContext);
        onEvent(OnekeyDataHelper.GET_NETWORK_STATUS_EVENT, OnekeyDataHelper.generateGetNetStatusEvent(this.mApplicationContext, networkStatus));
        return networkStatus;
    }

    @Override // com.bytedance.sdk.account.platform.api.IOnekeyLoginService
    public void getPhoneInfo(AuthorizeCallback authorizeCallback) {
        getPhoneInfo(null, authorizeCallback);
    }

    @Override // com.bytedance.sdk.account.platform.api.IOnekeyLoginService
    public void getPhoneInfo(String str, AuthorizeCallback authorizeCallback) {
        getPhoneInfo(str, false, authorizeCallback);
    }

    @Override // com.bytedance.sdk.account.platform.api.IOnekeyLoginService
    public void getPhoneInfo(String str, boolean z, AuthorizeCallback authorizeCallback) {
        AbsCarrierCacheInfo carrierCacheInfo;
        Bundle parseToPhoneInfoResponse;
        NetworkTypeHelper.NetworkType networkType = NetworkTypeHelper.getNetworkType(getApplicationContext());
        boolean requestAbove4GEnable = getSetting().requestAbove4GEnable();
        String networkAccessType = NetworkTypeHelper.getNetworkAccessType(networkType);
        String carrier = getCarrier();
        int networkStatus = getNetworkStatus();
        if (requestAbove4GEnable && networkType.getValue() < NetworkTypeHelper.NetworkType.WIFI.getValue()) {
            if (authorizeCallback != null) {
                authorizeCallback.onError(OnekeyDataHelper.getErrorResponse(OnekeyLoginConstants.ErrorCode.ERROR_WEAK_NETWORK, OnekeyLoginConstants.ErrorMsg.ERROR_WEAK_NETWORK_MSG, carrier, networkStatus, 1, null));
            }
            onEvent(OnekeyDataHelper.GET_PHONE_EVENT, OnekeyDataHelper.generateMonitorJson(getApplicationContext(), false, OnekeyLoginConstants.ErrorCode.ERROR_WEAK_NETWORK, OnekeyLoginConstants.ErrorMsg.ERROR_WEAK_NETWORK_MSG, 0L, null, OnekeyDataHelper.getCarrierEvent(carrier), str, networkAccessType, networkStatus, authorizeCallback));
        } else {
            if (!z && (carrierCacheInfo = CarrierCacheInfoHelper.INSTANCE.getCarrierCacheInfo(getApplicationContext())) != null && (parseToPhoneInfoResponse = carrierCacheInfo.parseToPhoneInfoResponse()) != null) {
                if (authorizeCallback != null) {
                    authorizeCallback.onSuccess(parseToPhoneInfoResponse);
                }
                onEvent(OnekeyDataHelper.GET_PHONE_EVENT, OnekeyDataHelper.generateMonitorJson(getApplicationContext(), true, null, null, 0L, null, OnekeyDataHelper.getCarrierEvent(carrierCacheInfo.getCarrierFrom()), str, networkAccessType, networkStatus, authorizeCallback));
                return;
            }
            getCarrierService(carrier).getPhoneInfo(str, networkAccessType, networkStatus, z, authorizeCallback);
        }
    }

    @Override // com.bytedance.sdk.account.platform.api.IOnekeyLoginService
    public void getAuthToken(AuthorizeCallback authorizeCallback) {
        Bundle parseToAuthTokenResponse;
        String networkAccessType = NetworkTypeHelper.getNetworkAccessType(NetworkTypeHelper.getNetworkType(getApplicationContext()));
        String carrier = getCarrier();
        int networkStatus = getNetworkStatus();
        AbsCarrierCacheInfo carrierCacheInfo = CarrierCacheInfoHelper.INSTANCE.getCarrierCacheInfo(getApplicationContext());
        if (carrierCacheInfo != null && (parseToAuthTokenResponse = carrierCacheInfo.parseToAuthTokenResponse()) != null) {
            if (authorizeCallback != null) {
                authorizeCallback.onSuccess(parseToAuthTokenResponse);
            }
            onEvent(OnekeyDataHelper.GET_TOKEN_EVENT, OnekeyDataHelper.generateMonitorJson(getApplicationContext(), true, null, null, 0L, null, OnekeyDataHelper.getCarrierEvent(carrier), null, networkAccessType, networkStatus, authorizeCallback));
            return;
        }
        getCarrierService(carrier).getAuthToken(networkStatus, authorizeCallback);
    }

    @Override // com.bytedance.sdk.account.platform.api.IOnekeyLoginService
    public void getValidateToken(AuthorizeCallback authorizeCallback) {
        Bundle parseToValidateTokenResponse;
        String networkAccessType = NetworkTypeHelper.getNetworkAccessType(NetworkTypeHelper.getNetworkType(getApplicationContext()));
        String carrier = getCarrier();
        int networkStatus = getNetworkStatus();
        AbsCarrierCacheInfo carrierCacheInfo = CarrierCacheInfoHelper.INSTANCE.getCarrierCacheInfo(getApplicationContext());
        if (carrierCacheInfo != null && (parseToValidateTokenResponse = carrierCacheInfo.parseToValidateTokenResponse()) != null) {
            if (authorizeCallback != null) {
                authorizeCallback.onSuccess(parseToValidateTokenResponse);
            }
            onEvent(OnekeyDataHelper.GET_VALIDATE_TOKEN_EVENT, OnekeyDataHelper.generateMonitorJson(getApplicationContext(), true, null, null, 0L, null, OnekeyDataHelper.getCarrierEvent(carrier), null, networkAccessType, networkStatus, authorizeCallback));
            return;
        }
        getCarrierService(carrier).getValidateToken(networkStatus, authorizeCallback);
    }

    @Override // com.bytedance.sdk.account.platform.api.IOnekeyLoginService
    public void cancel() {
        ICarrierService iCarrierService = this.currentCarrier;
        if (iCarrierService != null) {
            iCarrierService.cancel();
            this.currentCarrier = null;
        }
    }

    private ICarrierService getCarrierService(String str) {
        ICarrierService iCarrierService = this.carrierServices.get(str);
        this.currentCarrier = iCarrierService;
        if (iCarrierService == null) {
            this.unSupportCarrier.setCarrierType(str);
            this.currentCarrier = this.unSupportCarrier;
        }
        return this.currentCarrier;
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.IServiceContainer
    public Context getApplicationContext() {
        return this.mApplicationContext;
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.IServiceContainer
    public Handler getHandler() {
        return this.mHandler;
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.IServiceContainer
    public OnekeyLoginConfig getConfig() {
        return this.mConfig;
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.IServiceContainer
    public void onEvent(String str, JSONObject jSONObject) {
        IOnekeyMonitor iOnekeyMonitor = this.mMonitor;
        if (iOnekeyMonitor != null) {
            iOnekeyMonitor.onEvent(str, jSONObject);
        }
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.IServiceContainer
    public OnekeySettingManager getSetting() {
        return OnekeySettingManager.instance();
    }

    @Override // com.bytedance.sdk.account.platform.api.IOnekeyLoginService
    public String getCacheMaskPhone() {
        AbsCarrierCacheInfo carrierCacheInfo = CarrierCacheInfoHelper.INSTANCE.getCarrierCacheInfo(getApplicationContext());
        if (carrierCacheInfo != null) {
            return carrierCacheInfo.getMaskPhone();
        }
        return null;
    }
}
