package com.bytedance.bdinstall.sensitive;

import android.media.MediaDrm;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.ExecutorUtil;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.Utils;
import com.bytedance.bdinstall.util.LocalConstants;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class DefaultSensitiveInterceptor extends AbsSensitiveInterceptor {
    private InstallOptions options;

    private static String com_bytedance_bdinstall_sensitive_DefaultSensitiveInterceptor_android_net_wifi_WifiInfo_getMacAddress(WifiInfo wifiInfo) {
        HeliosApiHook heliosApiHook = new HeliosApiHook();
        Object[] objArr = new Object[0];
        ExtraInfo extraInfo = new ExtraInfo(false, "()Ljava/lang/String;");
        Result preInvoke = heliosApiHook.preInvoke(101700, "android/net/wifi/WifiInfo", "getMacAddress", wifiInfo, objArr, "java.lang.String", extraInfo);
        if (preInvoke.isIntercept()) {
            heliosApiHook.postInvoke(101700, "android/net/wifi/WifiInfo", "getMacAddress", wifiInfo, objArr, null, extraInfo, false);
            return (String) preInvoke.getReturnValue();
        }
        String macAddress = wifiInfo.getMacAddress();
        heliosApiHook.postInvoke(101700, "android/net/wifi/WifiInfo", "getMacAddress", wifiInfo, objArr, macAddress, extraInfo, true);
        return macAddress;
    }

    private static String com_bytedance_bdinstall_sensitive_DefaultSensitiveInterceptor_android_telephony_TelephonyManager_getDeviceId(TelephonyManager telephonyManager) {
        HeliosApiHook heliosApiHook = new HeliosApiHook();
        Object[] objArr = new Object[0];
        ExtraInfo extraInfo = new ExtraInfo(false, "()Ljava/lang/String;");
        Result preInvoke = heliosApiHook.preInvoke(101600, "android/telephony/TelephonyManager", "getDeviceId", telephonyManager, objArr, "java.lang.String", extraInfo);
        if (preInvoke.isIntercept()) {
            heliosApiHook.postInvoke(101600, "android/telephony/TelephonyManager", "getDeviceId", telephonyManager, objArr, null, extraInfo, false);
            return (String) preInvoke.getReturnValue();
        }
        String deviceId = telephonyManager.getDeviceId();
        heliosApiHook.postInvoke(101600, "android/telephony/TelephonyManager", "getDeviceId", telephonyManager, objArr, deviceId, extraInfo, true);
        return deviceId;
    }

    private static String com_bytedance_bdinstall_sensitive_DefaultSensitiveInterceptor_android_telephony_TelephonyManager_getImei(TelephonyManager telephonyManager, int i) {
        HeliosApiHook heliosApiHook = new HeliosApiHook();
        Object[] objArr = {Integer.valueOf(i)};
        ExtraInfo extraInfo = new ExtraInfo(false, "(I)Ljava/lang/String;");
        Result preInvoke = heliosApiHook.preInvoke(101601, "android/telephony/TelephonyManager", "getImei", telephonyManager, objArr, "java.lang.String", extraInfo);
        if (preInvoke.isIntercept()) {
            heliosApiHook.postInvoke(101601, "android/telephony/TelephonyManager", "getImei", telephonyManager, objArr, null, extraInfo, false);
            return (String) preInvoke.getReturnValue();
        }
        String imei = telephonyManager.getImei(i);
        heliosApiHook.postInvoke(101601, "android/telephony/TelephonyManager", "getImei", telephonyManager, objArr, imei, extraInfo, true);
        return imei;
    }

    private static byte[] com_bytedance_bdinstall_sensitive_DefaultSensitiveInterceptor_java_net_NetworkInterface_getHardwareAddress(NetworkInterface networkInterface) {
        HeliosApiHook heliosApiHook = new HeliosApiHook();
        Object[] objArr = new Object[0];
        ExtraInfo extraInfo = new ExtraInfo(false, "()[B");
        Result preInvoke = heliosApiHook.preInvoke(101701, "java/net/NetworkInterface", "getHardwareAddress", networkInterface, objArr, "byte[]", extraInfo);
        if (preInvoke.isIntercept()) {
            heliosApiHook.postInvoke(101701, "java/net/NetworkInterface", "getHardwareAddress", networkInterface, objArr, null, extraInfo, false);
            return (byte[]) preInvoke.getReturnValue();
        }
        byte[] hardwareAddress = networkInterface.getHardwareAddress();
        heliosApiHook.postInvoke(101701, "java/net/NetworkInterface", "getHardwareAddress", networkInterface, objArr, hardwareAddress, extraInfo, true);
        return hardwareAddress;
    }

    public void setOptions(InstallOptions installOptions) {
        this.options = installOptions;
    }

    public InstallOptions getOptions() {
        return this.options;
    }

    @Override // com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    public String getSerial() {
        return (Build.VERSION.SDK_INT < 26 || this.options.getContext().getApplicationInfo().targetSdkVersion < 26) ? "" : Build.getSerial();
    }

    @Override // com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    public String getImeiByIndex(int i) {
        return com_bytedance_bdinstall_sensitive_DefaultSensitiveInterceptor_android_telephony_TelephonyManager_getImei(this.options.getTelephonyManager(), i);
    }

    @Override // com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    public String getMeidByIndex(int i) {
        return this.options.getTelephonyManager().getMeid(i);
    }

    @Override // com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    public WifiInfo getConnectionInfo() {
        return ((WifiManager) this.options.getContext().getApplicationContext().getSystemService("wifi")).getConnectionInfo();
    }

    @Override // com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    public String getSSID(WifiInfo wifiInfo) {
        return wifiInfo != null ? wifiInfo.getSSID() : "";
    }

    @Override // com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    public String getMacAddress(WifiInfo wifiInfo) {
        return wifiInfo != null ? com_bytedance_bdinstall_sensitive_DefaultSensitiveInterceptor_android_net_wifi_WifiInfo_getMacAddress(wifiInfo) : "";
    }

    @Override // com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    public byte[] getHardwareAddress(NetworkInterface networkInterface) {
        if (networkInterface != null) {
            try {
                return com_bytedance_bdinstall_sensitive_DefaultSensitiveInterceptor_java_net_NetworkInterface_getHardwareAddress(networkInterface);
            } catch (SocketException e) {
                e.printStackTrace();
            }
        }
        return new byte[0];
    }

    @Override // com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    public Enumeration<NetworkInterface> getNetworkInterfaces() {
        try {
            return NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    public List<SubscriptionInfo> getActiveSubscriptionInfoList() {
        return SubscriptionManager.from(this.options.getContext()).getActiveSubscriptionInfoList();
    }

    @Override // com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    public String getIccId(SubscriptionInfo subscriptionInfo) {
        return subscriptionInfo.getIccId();
    }

    @Override // com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    public String getDeviceId() {
        return com_bytedance_bdinstall_sensitive_DefaultSensitiveInterceptor_android_telephony_TelephonyManager_getDeviceId(this.options.getTelephonyManager());
    }

    @Override // com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    public String getSimSerialNumber() {
        try {
            return this.options.getTelephonyManager().getSimSerialNumber();
        } catch (SecurityException unused) {
            DrLog.d("getSSN , no permission, ignore");
            return "";
        }
    }

    @Override // com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    public String getNetworkOperator() {
        return this.options.getTelephonyManager().getNetworkOperator();
    }

    @Override // com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    public String getNetworkOperatorName() {
        return this.options.getTelephonyManager().getNetworkOperatorName();
    }

    @Override // com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    public String getSimCountryIso() {
        return this.options.getTelephonyManager().getSimCountryIso();
    }

    @Override // com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    public String getCountry() {
        return Locale.getDefault().getCountry();
    }

    public String getMediaId() {
        return doGetMediaId();
    }

    private String doGetMediaId() {
        if (TextUtils.isEmpty(LocalConstants.getCommonSp(this.options.getContext(), this.options).getString("device_id", ""))) {
            DrLog.d("sdk not start. media id return null. ");
            return "";
        }
        try {
            return (String) ExecutorUtil.submitToFirstIOExecutor(new Callable<String>() { // from class: com.bytedance.bdinstall.sensitive.DefaultSensitiveInterceptor.1
                /* JADX WARN: Removed duplicated region for block: B:47:0x0064  */
                /* JADX WARN: Removed duplicated region for block: B:54:0x006f  */
                @Override // java.util.concurrent.Callable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public String call() throws Exception {
                    MediaDrm mediaDrm;
                    Throwable th;
                    Exception e;
                    try {
                        mediaDrm = new MediaDrm(new UUID(-1301668207276963122L, -6645017420763422227L));
                        try {
                            try {
                                String bytesToHex = Utils.bytesToHex(mediaDrm.getPropertyByteArray("deviceUniqueId"));
                                if (Build.VERSION.SDK_INT >= 28) {
                                    try {
                                        mediaDrm.close();
                                    } catch (Exception e2) {
                                        e2.printStackTrace();
                                    }
                                } else {
                                    try {
                                        mediaDrm.release();
                                    } catch (Exception e3) {
                                        e3.printStackTrace();
                                    }
                                }
                                return bytesToHex;
                            } catch (Exception e4) {
                                e = e4;
                                e.printStackTrace();
                                if (Build.VERSION.SDK_INT >= 28) {
                                    if (mediaDrm == null) {
                                        return "";
                                    }
                                    try {
                                        mediaDrm.close();
                                        return "";
                                    } catch (Exception e5) {
                                        e5.printStackTrace();
                                        return "";
                                    }
                                }
                                if (mediaDrm == null) {
                                    return "";
                                }
                                try {
                                    mediaDrm.release();
                                    return "";
                                } catch (Exception e6) {
                                    e6.printStackTrace();
                                    return "";
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (Build.VERSION.SDK_INT < 28) {
                                if (mediaDrm != null) {
                                    try {
                                        mediaDrm.close();
                                    } catch (Exception e7) {
                                        e7.printStackTrace();
                                    }
                                }
                            } else if (mediaDrm != null) {
                                try {
                                    mediaDrm.release();
                                } catch (Exception e8) {
                                    e8.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e9) {
                        mediaDrm = null;
                        e = e9;
                    } catch (Throwable th3) {
                        mediaDrm = null;
                        th = th3;
                        if (Build.VERSION.SDK_INT < 28) {
                        }
                        throw th;
                    }
                }
            }).get(100L, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            DrLog.e("media id get error", e);
            return "";
        }
    }
}
