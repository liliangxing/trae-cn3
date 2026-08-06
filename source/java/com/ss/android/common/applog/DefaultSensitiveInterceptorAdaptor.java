package com.ss.android.common.applog;

import android.net.wifi.WifiInfo;
import android.telephony.SubscriptionInfo;
import com.bytedance.bdinstall.sensitive.DefaultSensitiveInterceptor;
import com.ss.android.deviceregister.SensitiveApiCallback;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.List;

/* loaded from: classes7.dex */
public class DefaultSensitiveInterceptorAdaptor extends DefaultSensitiveInterceptor {
    private final SensitiveApiCallback callback;

    public DefaultSensitiveInterceptorAdaptor(SensitiveApiCallback sensitiveApiCallback) {
        this.callback = sensitiveApiCallback;
    }

    @Override // com.bytedance.bdinstall.sensitive.DefaultSensitiveInterceptor, com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    public String getSerial() {
        return this.callback.getSerial();
    }

    @Override // com.bytedance.bdinstall.sensitive.DefaultSensitiveInterceptor, com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    public String getNetworkOperator() {
        return this.callback.getNetworkOperator();
    }

    @Override // com.bytedance.bdinstall.sensitive.DefaultSensitiveInterceptor, com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    public String getNetworkOperatorName() {
        return this.callback.getNetworkOperatorName();
    }

    @Override // com.bytedance.bdinstall.sensitive.DefaultSensitiveInterceptor, com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    public String getSimCountryIso() {
        return this.callback.getSimCountryIso();
    }

    @Override // com.bytedance.bdinstall.sensitive.DefaultSensitiveInterceptor, com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    public String getImeiByIndex(int i) {
        if (i == 0) {
            return this.callback.getImeiBy0();
        }
        return i == 1 ? this.callback.getImeiBy1() : "";
    }

    @Override // com.bytedance.bdinstall.sensitive.DefaultSensitiveInterceptor, com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    public String getMeidByIndex(int i) {
        if (i == 0) {
            return this.callback.getMeidBy0();
        }
        return i == 1 ? this.callback.getMeidBy1() : "";
    }

    @Override // com.bytedance.bdinstall.sensitive.DefaultSensitiveInterceptor, com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    public WifiInfo getConnectionInfo() {
        return this.callback.getConnectionInfo();
    }

    @Override // com.bytedance.bdinstall.sensitive.DefaultSensitiveInterceptor, com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    public String getSSID(WifiInfo wifiInfo) {
        return this.callback.getSSID(wifiInfo);
    }

    @Override // com.bytedance.bdinstall.sensitive.DefaultSensitiveInterceptor, com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    public String getMacAddress(WifiInfo wifiInfo) {
        return this.callback.getMacAddress(wifiInfo);
    }

    @Override // com.bytedance.bdinstall.sensitive.DefaultSensitiveInterceptor, com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    public byte[] getHardwareAddress(NetworkInterface networkInterface) {
        return this.callback.getHardwareAddress(networkInterface);
    }

    @Override // com.bytedance.bdinstall.sensitive.DefaultSensitiveInterceptor, com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    public Enumeration<NetworkInterface> getNetworkInterfaces() {
        return this.callback.getNetworkInterfaces();
    }

    @Override // com.bytedance.bdinstall.sensitive.DefaultSensitiveInterceptor, com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    public List<SubscriptionInfo> getActiveSubscriptionInfoList() {
        return this.callback.getActiveSubscriptionInfoList();
    }

    @Override // com.bytedance.bdinstall.sensitive.DefaultSensitiveInterceptor, com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    public String getIccId(SubscriptionInfo subscriptionInfo) {
        return this.callback.getIccId(subscriptionInfo);
    }

    @Override // com.bytedance.bdinstall.sensitive.DefaultSensitiveInterceptor, com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    public String getDeviceId() {
        return this.callback.getDeviceId();
    }

    @Override // com.bytedance.bdinstall.sensitive.DefaultSensitiveInterceptor, com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    public String getSimSerialNumber() {
        return this.callback.getSimSerialNumber();
    }

    @Override // com.bytedance.bdinstall.sensitive.DefaultSensitiveInterceptor, com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    public String getCountry() {
        return this.callback.getCountry();
    }
}
