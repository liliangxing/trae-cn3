package com.bytedance.bdinstall;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.telephony.SubscriptionInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.bdinstall.loader.SstLoader;
import com.bytedance.bdinstall.sensitive.DefaultSensitiveInterceptor;
import com.bytedance.bdinstall.util.InstallPmsUtils;
import com.bytedance.bdinstall.util.SystemPropertiesWithCache;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class SstInfoCompat {
    private static ISstInfoProvider sProvider = new DefaultProvider();
    private static final AtomicBoolean isCalled = new AtomicBoolean(false);
    private static volatile String sMeid = null;
    public static final ConcurrentHashMap<String, ISstInfoProvider> sProviderMap = new ConcurrentHashMap<>();

    public static ISstInfoProvider getProvider(String str) {
        ISstInfoProvider iSstInfoProvider = sProviderMap.get(str);
        return iSstInfoProvider != null ? iSstInfoProvider : sProvider;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setSstInfoProvider(String str, ISstInfoProvider iSstInfoProvider) {
        ConcurrentHashMap<String, ISstInfoProvider> concurrentHashMap = sProviderMap;
        if (concurrentHashMap.containsKey(str)) {
            return;
        }
        concurrentHashMap.put(str, iSstInfoProvider);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    private static final class DefaultProvider implements ISstInfoProvider {
        private static final String DEFAULT_MAC_ADDRESS = "02:00:00:00:00:00";

        /* renamed from: tm */
        private TelephonyManager f88tm;

        private DefaultProvider() {
        }

        @Override // com.bytedance.bdinstall.ISstInfoProvider
        public String getDefaultImeiOrMeid(Context context, InstallOptions installOptions) {
            try {
                if (!InstallPmsUtils.checkReadPhoneStatePermission(context) || !SstInfoCompat.isCalled.compareAndSet(false, true)) {
                    if (!SstInfoCompat.isCalled.get()) {
                        return null;
                    }
                    DrLog.m139d("getDefaultImeiOrMeid# get Meid from memory cache： " + SstInfoCompat.sMeid);
                    return SstInfoCompat.sMeid;
                }
                return installOptions.getSensitiveInterceptor().getDeviceId();
            } catch (Exception unused) {
                DrLog.m143v("no get_phone_state permission,getDeviceId return null");
                return null;
            }
        }

        @Override // com.bytedance.bdinstall.ISstInfoProvider
        public String getMac(Context context, InstallOptions installOptions) {
            byte[] hardwareAddress;
            WifiInfo wifiInfo = SstInfoCompat.getWifiInfo(context, installOptions);
            DefaultSensitiveInterceptor sensitiveInterceptor = installOptions.getSensitiveInterceptor();
            String macAddress = sensitiveInterceptor.getMacAddress(wifiInfo);
            if (!DEFAULT_MAC_ADDRESS.equals(macAddress) && !TextUtils.isEmpty(macAddress)) {
                return macAddress;
            }
            try {
                Enumeration<NetworkInterface> networkInterfaces = sensitiveInterceptor.getNetworkInterfaces();
                String networkInterfaceName = getNetworkInterfaceName();
                while (networkInterfaces.hasMoreElements()) {
                    NetworkInterface nextElement = networkInterfaces.nextElement();
                    if (nextElement.getName().equals(networkInterfaceName) && (hardwareAddress = sensitiveInterceptor.getHardwareAddress(nextElement)) != null && hardwareAddress.length != 0) {
                        StringBuilder sb = new StringBuilder();
                        for (byte b : hardwareAddress) {
                            sb.append(String.format("%02X:", Byte.valueOf(b)));
                        }
                        if (sb.length() > 0) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        return sb.toString();
                    }
                }
                return macAddress;
            } catch (Exception e) {
                e.printStackTrace();
                return macAddress;
            }
        }

        private TelephonyManager getTelephonyManager(Context context) {
            if (this.f88tm == null) {
                this.f88tm = (TelephonyManager) context.getSystemService("phone");
            }
            return this.f88tm;
        }

        @Override // com.bytedance.bdinstall.ISstInfoProvider
        public String getMeid(Context context, int i, InstallOptions installOptions) {
            return installOptions.getSensitiveInterceptor().getMeidByIndex(i);
        }

        @Override // com.bytedance.bdinstall.ISstInfoProvider
        public String getImei(Context context, int i, InstallOptions installOptions) {
            return installOptions.getSensitiveInterceptor().getImeiByIndex(i);
        }

        @Override // com.bytedance.bdinstall.ISstInfoProvider
        public String reflectGetDeviceIdWithSlotIndex(Context context, int i) {
            String str = (String) getPhoneInfo(i, "getDeviceId", context);
            DrLog.m139d("getDeviceId  deviceId=" + str);
            return str;
        }

        @Override // com.bytedance.bdinstall.ISstInfoProvider
        public String getSerial(Context context, InstallOptions installOptions) {
            String str;
            DefaultSensitiveInterceptor sensitiveInterceptor = installOptions.getSensitiveInterceptor();
            if (Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26) {
                try {
                    str = sensitiveInterceptor.getSerial();
                } catch (Throwable unused) {
                }
                if (!TextUtils.isEmpty(str) || TextUtils.equals(str, "unknown")) {
                    str = Build.SERIAL;
                }
                return (TextUtils.isEmpty(str) || TextUtils.equals(str, "unknown")) ? "" : str;
            }
            str = null;
            if (!TextUtils.isEmpty(str)) {
            }
            str = Build.SERIAL;
            if (TextUtils.isEmpty(str)) {
                return "";
            }
        }

        @Override // com.bytedance.bdinstall.ISstInfoProvider
        public String[] getSimSerialNumbers(Context context, InstallOptions installOptions) {
            List<SubscriptionInfo> activeSubscriptionInfoList;
            int i;
            DefaultSensitiveInterceptor sensitiveInterceptor = installOptions.getSensitiveInterceptor();
            String[] strArr = null;
            try {
                try {
                    activeSubscriptionInfoList = sensitiveInterceptor.getActiveSubscriptionInfoList();
                } catch (SecurityException unused) {
                    DrLog.m139d("getSSN , no permission, ignore");
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (activeSubscriptionInfoList != null && !activeSubscriptionInfoList.isEmpty()) {
                strArr = new String[activeSubscriptionInfoList.size()];
                for (i = 0; i < activeSubscriptionInfoList.size(); i++) {
                    strArr[i] = sensitiveInterceptor.getIccId(activeSubscriptionInfoList.get(i));
                }
                return strArr;
            }
            return new String[0];
        }

        private static Object getPhoneInfo(int i, String str, Context context) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                Method method = telephonyManager.getClass().getMethod(str, getMethodParamTypes(str));
                if (i >= 0) {
                    return method.invoke(telephonyManager, Integer.valueOf(i));
                }
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                DrLog.m141e(e.getMessage(), e);
                return null;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x001f, code lost:
        
            com.bytedance.bdinstall.DrLog.m139d("length:" + r0.length);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private static Class<?>[] getMethodParamTypes(String str) {
            Class<?>[] clsArr = null;
            try {
                Method[] declaredMethods = TelephonyManager.class.getDeclaredMethods();
                int length = declaredMethods.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    Method method = declaredMethods[i];
                    if (str.equals(method.getName())) {
                        clsArr = method.getParameterTypes();
                        if (clsArr.length >= 1) {
                            break;
                        }
                    }
                    i++;
                }
            } catch (Exception e) {
                e.printStackTrace();
                DrLog.m141e(e.getMessage(), e);
            }
            return clsArr;
        }

        private static String getNetworkInterfaceName() {
            try {
                String str = (String) SystemPropertiesWithCache.get("wifi.interface");
                return TextUtils.isEmpty(str) ? "wlan0" : str;
            } catch (Exception e) {
                e.printStackTrace();
                return "wlan0";
            }
        }

        @Override // com.bytedance.bdinstall.ISstInfoProvider
        public JSONArray getIPV6Address(Context context) {
            JSONArray jSONArray = new JSONArray();
            try {
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (NetworkInterface.getNetworkInterfaces() == null) {
                return new JSONArray();
            }
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                NetworkInterface networkInterface = (NetworkInterface) it.next();
                String name = networkInterface.getName();
                if ("dummy0".equals(name) || "wlan0".equals(name)) {
                    Iterator it2 = Collections.list(networkInterface.getInetAddresses()).iterator();
                    while (it2.hasNext()) {
                        String hostAddress = ((InetAddress) it2.next()).getHostAddress();
                        if (!TextUtils.isEmpty(hostAddress)) {
                            if (!(hostAddress.indexOf(58) < 0)) {
                                int indexOf = hostAddress.indexOf(37);
                                if ("dummy0".equals(name)) {
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("type", SstLoader.KEY_IPV6_TYPE_TUN);
                                    if (indexOf >= 0) {
                                        hostAddress = hostAddress.substring(0, indexOf);
                                    }
                                    jSONObject.put("value", hostAddress.toUpperCase());
                                    jSONArray.put(jSONObject);
                                } else if ("wlan0".equals(name) || "fe80".equalsIgnoreCase(hostAddress.split("::")[0])) {
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put("type", SstLoader.KEY_IPV6_TYPE_ANPI);
                                    if (indexOf >= 0) {
                                        hostAddress = hostAddress.substring(0, indexOf);
                                    }
                                    jSONObject2.put("value", hostAddress.toUpperCase());
                                    jSONArray.put(jSONObject2);
                                }
                            }
                        }
                    }
                }
            }
            return jSONArray;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static WifiInfo getWifiInfo(Context context, InstallOptions installOptions) {
        WifiInfo connectionInfo;
        String ssid;
        if (context == null) {
            return null;
        }
        try {
            DefaultSensitiveInterceptor sensitiveInterceptor = installOptions.getSensitiveInterceptor();
            connectionInfo = sensitiveInterceptor.getConnectionInfo();
            ssid = sensitiveInterceptor.getSSID(connectionInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getNetworkInfo(1).getState() != NetworkInfo.State.CONNECTED || ssid == null) {
            return null;
        }
        return connectionInfo;
    }
}
