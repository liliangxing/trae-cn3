package com.monitor.cloudmessage.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.RouteInfo;
import android.net.TrafficStats;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.apm.util.NetUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.monitor.cloudmessage.upload.net.CloudMessageUploadService;
import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class NetworkUtils {
    private static long lastTimeRxStamp;
    private static long lastTimeTxStamp;
    private static long lastTotalRxBytes;
    private static long lastTotalTxBytes;

    public static boolean isWifi(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                return 1 == activeNetworkInfo.getType();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isNetworkAvailable(Context context) {
        if (context == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnected();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String getNativeIp() {
        String str = "none";
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                String name = nextElement.getName();
                if (name != null && (TextUtils.equals(name.toLowerCase(), "eth0") || TextUtils.equals(name.toLowerCase(), "wlan0"))) {
                    Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement2 = inetAddresses.nextElement();
                        if ((nextElement2 instanceof Inet4Address) && !nextElement2.isLoopbackAddress()) {
                            str = nextElement2.getHostAddress();
                        }
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static List<String> getLocalDNS(Context context) {
        ArrayList arrayList = new ArrayList();
        if (context != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                for (Network network : connectivityManager.getAllNetworks()) {
                    if (connectivityManager.getNetworkInfo(network).getType() == activeNetworkInfo.getType()) {
                        Iterator<InetAddress> it = connectivityManager.getLinkProperties(network).getDnsServers().iterator();
                        while (it.hasNext()) {
                            arrayList.add(it.next().getHostAddress());
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    public static String getDownloadSpeed(Context context) {
        long totalRxBytes = getTotalRxBytes(context.getApplicationInfo().uid);
        if (totalRxBytes == -1) {
            return "UNSUPPORTED";
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = ((totalRxBytes - lastTotalRxBytes) * 1000) / (currentTimeMillis - lastTimeRxStamp);
        lastTimeRxStamp = currentTimeMillis;
        lastTotalRxBytes = totalRxBytes;
        return String.valueOf(j) + " KB/s";
    }

    public static String getUploadSpeed(Context context) {
        long totalTxBytes = getTotalTxBytes(context.getApplicationInfo().uid);
        if (totalTxBytes == -1) {
            return "UNSUPPORTED";
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = ((totalTxBytes - lastTotalTxBytes) * 1000) / (currentTimeMillis - lastTimeTxStamp);
        lastTimeTxStamp = currentTimeMillis;
        lastTotalTxBytes = totalTxBytes;
        return String.valueOf(j) + " KB/s";
    }

    private static long getTotalRxBytes(int i) {
        return TrafficStats.getTotalRxBytes() / 1024;
    }

    private static long getTotalTxBytes(int i) {
        return TrafficStats.getTotalTxBytes() / 1024;
    }

    public static List<String> getGateway(Context context) {
        ArrayList arrayList = new ArrayList();
        if (context != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                for (Network network : connectivityManager.getAllNetworks()) {
                    if (connectivityManager.getNetworkInfo(network).getType() == activeNetworkInfo.getType()) {
                        Iterator<RouteInfo> it = connectivityManager.getLinkProperties(network).getRoutes().iterator();
                        while (it.hasNext()) {
                            InetAddress gateway = it.next().getGateway();
                            if (gateway != null) {
                                arrayList.add(gateway.getHostAddress());
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    public static List<String> parseDomainName(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            InetAddress[] allByName = InetAddress.getAllByName(str);
            if (allByName != null && allByName.length > 0) {
                for (InetAddress inetAddress : allByName) {
                    arrayList.add(inetAddress.getHostAddress());
                }
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static boolean testGet(String str, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                httpURLConnection = NetUtils.getUrlConnection(str);
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setReadTimeout(30000);
                httpURLConnection.setConnectTimeout(30000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestProperty("Charset", CloudMessageUploadService.ENCODE);
                int responseCode = httpURLConnection.getResponseCode();
                jSONObject2.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, responseCode);
                jSONObject2.put("header", StringUtils.getJsonFromMap(httpURLConnection.getHeaderFields()));
                jSONObject.put(str, jSONObject2);
                boolean z = responseCode == 200;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return z;
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    jSONObject.put(str, e.getMessage());
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return false;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return false;
                }
            }
        } catch (Throwable th) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    public static String getNetworkAccessType(Context context) {
        return getNetworkAccessType(getNetworkType(context));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.monitor.cloudmessage.utils.NetworkUtils$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$monitor$cloudmessage$utils$NetworkUtils$NetworkType;

        static {
            int[] iArr = new int[NetworkType.values().length];
            $SwitchMap$com$monitor$cloudmessage$utils$NetworkUtils$NetworkType = iArr;
            try {
                iArr[NetworkType.WIFI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$monitor$cloudmessage$utils$NetworkUtils$NetworkType[NetworkType.MOBILE_2G.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$monitor$cloudmessage$utils$NetworkUtils$NetworkType[NetworkType.MOBILE_3G.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$monitor$cloudmessage$utils$NetworkUtils$NetworkType[NetworkType.MOBILE_4G.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$monitor$cloudmessage$utils$NetworkUtils$NetworkType[NetworkType.MOBILE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private static String getNetworkAccessType(NetworkType networkType) {
        String str;
        try {
            int i = AnonymousClass1.$SwitchMap$com$monitor$cloudmessage$utils$NetworkUtils$NetworkType[networkType.ordinal()];
            if (i == 1) {
                str = "wifi";
            } else if (i == 2) {
                str = "2g";
            } else if (i == 3) {
                str = "3g";
            } else if (i == 4) {
                str = "4g";
            } else {
                if (i != 5) {
                    return "";
                }
                str = "mobile";
            }
            return str;
        } catch (Exception unused) {
            return "";
        }
    }

    private static NetworkType getNetworkType(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (1 == type) {
                    return NetworkType.WIFI;
                }
                if (type == 0) {
                    switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            return NetworkType.MOBILE_2G;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            return NetworkType.MOBILE_3G;
                        case 13:
                            return NetworkType.MOBILE_4G;
                        default:
                            return NetworkType.MOBILE;
                    }
                }
                return NetworkType.MOBILE;
            }
            return NetworkType.NONE;
        } catch (Throwable unused) {
            return NetworkType.MOBILE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public enum NetworkType {
        NONE(0),
        MOBILE(1),
        MOBILE_2G(2),
        MOBILE_3G(3),
        WIFI(4),
        MOBILE_4G(5);

        final int nativeInt;

        NetworkType(int i) {
            this.nativeInt = i;
        }

        public int getValue() {
            return this.nativeInt;
        }
    }
}
