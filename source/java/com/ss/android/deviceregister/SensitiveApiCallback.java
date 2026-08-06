package com.ss.android.deviceregister;

import android.net.wifi.WifiInfo;
import android.telephony.SubscriptionInfo;
import android.util.Pair;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.List;

/* loaded from: classes7.dex */
public interface SensitiveApiCallback {
    List<SubscriptionInfo> getActiveSubscriptionInfoList();

    WifiInfo getConnectionInfo();

    String getCountry();

    String getDeviceId();

    Pair<String, Boolean> getGaid();

    byte[] getHardwareAddress(NetworkInterface networkInterface);

    String getIccId(SubscriptionInfo subscriptionInfo);

    String getImeiBy0();

    String getImeiBy1();

    String getMacAddress(WifiInfo wifiInfo);

    String getMeidBy0();

    String getMeidBy1();

    Enumeration<NetworkInterface> getNetworkInterfaces();

    String getNetworkOperator();

    String getNetworkOperatorName();

    String getSSID(WifiInfo wifiInfo);

    String getSerial();

    String getSimCountryIso();

    String getSimSerialNumber();
}
