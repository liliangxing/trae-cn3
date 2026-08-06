package com.bytedance.bdinstall.sensitive;

import android.net.wifi.WifiInfo;
import android.telephony.SubscriptionInfo;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.List;

/* loaded from: classes3.dex */
abstract class AbsSensitiveInterceptor {
    abstract List<SubscriptionInfo> getActiveSubscriptionInfoList();

    abstract WifiInfo getConnectionInfo();

    abstract String getCountry();

    abstract String getDeviceId();

    abstract byte[] getHardwareAddress(NetworkInterface networkInterface);

    abstract String getIccId(SubscriptionInfo subscriptionInfo);

    abstract String getImeiByIndex(int i);

    abstract String getMacAddress(WifiInfo wifiInfo);

    abstract String getMeidByIndex(int i);

    abstract Enumeration<NetworkInterface> getNetworkInterfaces();

    abstract String getNetworkOperator();

    abstract String getNetworkOperatorName();

    abstract String getSSID(WifiInfo wifiInfo);

    abstract String getSerial();

    abstract String getSimCountryIso();

    abstract String getSimSerialNumber();
}
