package com.ttnet.org.chromium.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.net.RouteInfo;
import android.net.TrafficStats;
import android.net.TransportInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import com.ttnet.org.chromium.base.ApiCompatibilityUtils;
import com.ttnet.org.chromium.base.CollectionUtil;
import com.ttnet.org.chromium.base.ContextUtils;
import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.compat.ApiHelperForM;
import com.ttnet.org.chromium.base.compat.ApiHelperForN;
import com.ttnet.org.chromium.base.compat.ApiHelperForP;
import com.ttnet.org.chromium.base.compat.ApiHelperForQ;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketImpl;
import java.net.URLConnection;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: Access modifiers changed from: package-private */
@MainDex
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AndroidNetworkLibrary {
    private static final String TAG = "AndroidNetworkLibrary";
    private static Boolean sHaveAccessLocationState;
    private static Boolean sHaveAccessNetworkState;
    private static Boolean sHaveAccessWifiState;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface Natives {
        void onCellularAlwaysUp(boolean z, int i);
    }

    /* renamed from: com_ttnet_org_chromium_net_AndroidNetworkLibrary_android_telephony_TelephonyManager_getSimOperator */
    private static String m434x485c93c5(TelephonyManager telephonyManager) {
        HeliosApiHook heliosApiHook = new HeliosApiHook();
        Object[] objArr = new Object[0];
        ExtraInfo extraInfo = new ExtraInfo(false, "()Ljava/lang/String;");
        Result preInvoke = heliosApiHook.preInvoke(102021, "android/telephony/TelephonyManager", "getSimOperator", telephonyManager, objArr, "java.lang.String", extraInfo);
        if (preInvoke.isIntercept()) {
            heliosApiHook.postInvoke(102021, "android/telephony/TelephonyManager", "getSimOperator", telephonyManager, objArr, (Object) null, extraInfo, false);
            return (String) preInvoke.getReturnValue();
        }
        String simOperator = telephonyManager.getSimOperator();
        heliosApiHook.postInvoke(102021, "android/telephony/TelephonyManager", "getSimOperator", telephonyManager, objArr, simOperator, extraInfo, true);
        return simOperator;
    }

    public static String getWifiSSID() {
        return "";
    }

    AndroidNetworkLibrary() {
    }

    public static String getMimeTypeFromExtension(String str) {
        return URLConnection.guessContentTypeFromName("foo." + str);
    }

    public static boolean haveOnlyLoopbackAddresses() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces == null) {
                return false;
            }
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                try {
                    if (nextElement.isUp() && !nextElement.isLoopback()) {
                        return false;
                    }
                } catch (SocketException unused) {
                }
            }
            return true;
        } catch (Exception e) {
            Log.w(TAG, "could not get network interfaces: " + e);
            return false;
        }
    }

    public static AndroidCertVerifyResult verifyServerCertificates(byte[][] bArr, String str, String str2) {
        try {
            return X509Util.verifyServerCertificates(bArr, str, str2);
        } catch (IllegalArgumentException unused) {
            return new AndroidCertVerifyResult(-1);
        } catch (KeyStoreException unused2) {
            return new AndroidCertVerifyResult(-1);
        } catch (NoSuchAlgorithmException unused3) {
            return new AndroidCertVerifyResult(-1);
        }
    }

    public static void addTestRootCertificate(byte[] bArr) throws CertificateException, KeyStoreException, NoSuchAlgorithmException {
        X509Util.addTestRootCertificate(bArr);
    }

    public static void clearTestRootCertificates() throws NoSuchAlgorithmException, CertificateException, KeyStoreException {
        X509Util.clearTestRootCertificates();
    }

    private static boolean getIsCaptivePortal() {
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        ConnectivityManager connectivityManager = (ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity");
        return (connectivityManager == null || (activeNetwork = ApiHelperForM.getActiveNetwork(connectivityManager)) == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null || !networkCapabilities.hasCapability(17)) ? false : true;
    }

    private static WifiInfo getWifiInfo() {
        TransportInfo transportInfo;
        if (haveAccessWifiState()) {
            if (Build.VERSION.SDK_INT >= 31) {
                ConnectivityManager connectivityManager = (ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity");
                for (Network network : connectivityManager.getAllNetworks()) {
                    NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
                    if (networkCapabilities != null && networkCapabilities.hasTransport(1) && (transportInfo = ApiHelperForQ.getTransportInfo(networkCapabilities)) != null && (transportInfo instanceof WifiInfo)) {
                        return (WifiInfo) transportInfo;
                    }
                }
                return null;
            }
            return ((WifiManager) ContextUtils.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        }
        Intent m433x6d66dea8 = m433x6d66dea8(ContextUtils.getApplicationContext(), null, new IntentFilter("android.net.wifi.STATE_CHANGE"));
        if (m433x6d66dea8 != null) {
            return (WifiInfo) m433x6d66dea8.getParcelableExtra("wifiInfo");
        }
        return null;
    }

    public static void setWifiEnabled(boolean z) {
        ((WifiManager) ContextUtils.getApplicationContext().getSystemService("wifi")).setWifiEnabled(z);
    }

    public static int getWifiSignalLevel(int i) {
        int intExtra;
        int calculateSignalLevel;
        if (ContextUtils.getApplicationContext() == null || ContextUtils.getApplicationContext().getContentResolver() == null) {
            return -1;
        }
        if (TTAppSecurityManager.getInstance().isTTPRestrictionEnabled()) {
            intExtra = TTAppSecurityManager.getInstance().getWifiRssi();
        } else if (haveAccessWifiState()) {
            WifiInfo wifiInfo = getWifiInfo();
            if (wifiInfo == null) {
                return -1;
            }
            intExtra = wifiInfo.getRssi();
        } else {
            try {
                Intent m433x6d66dea8 = m433x6d66dea8(ContextUtils.getApplicationContext(), null, new IntentFilter("android.net.wifi.RSSI_CHANGED"));
                if (m433x6d66dea8 == null) {
                    return -1;
                }
                intExtra = m433x6d66dea8.getIntExtra("newRssi", Integer.MIN_VALUE);
            } catch (IllegalArgumentException unused) {
            }
        }
        if (intExtra != Integer.MIN_VALUE && (calculateSignalLevel = WifiManager.calculateSignalLevel(intExtra, i)) >= 0 && calculateSignalLevel < i) {
            return calculateSignalLevel;
        }
        return -1;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class NetworkSecurityPolicyProxy {
        private static NetworkSecurityPolicyProxy sInstance = new NetworkSecurityPolicyProxy();

        public static NetworkSecurityPolicyProxy getInstance() {
            return sInstance;
        }

        public static void setInstanceForTesting(NetworkSecurityPolicyProxy networkSecurityPolicyProxy) {
            sInstance = networkSecurityPolicyProxy;
        }

        public boolean isCleartextTrafficPermitted(String str) {
            return ApiHelperForN.isCleartextTrafficPermitted(str);
        }

        public boolean isCleartextTrafficPermitted() {
            return ApiHelperForM.isCleartextTrafficPermitted();
        }
    }

    private static boolean isCleartextPermitted(String str) {
        try {
            return NetworkSecurityPolicyProxy.getInstance().isCleartextTrafficPermitted(str);
        } catch (IllegalArgumentException unused) {
            return NetworkSecurityPolicyProxy.getInstance().isCleartextTrafficPermitted();
        }
    }

    private static boolean haveAccessNetworkState() {
        if (sHaveAccessNetworkState == null) {
            sHaveAccessNetworkState = Boolean.valueOf(hasPermission(ContextUtils.getApplicationContext(), "android.permission.ACCESS_NETWORK_STATE"));
        }
        return sHaveAccessNetworkState.booleanValue();
    }

    private static boolean haveAccessWifiState() {
        if (sHaveAccessWifiState == null) {
            sHaveAccessWifiState = Boolean.valueOf(hasPermission(ContextUtils.getApplicationContext(), "android.permission.ACCESS_WIFI_STATE"));
        }
        return sHaveAccessWifiState.booleanValue();
    }

    private static boolean haveAccessLocationState() {
        if (sHaveAccessLocationState == null) {
            if (Build.VERSION.SDK_INT >= 29) {
                sHaveAccessLocationState = Boolean.valueOf(hasPermission(ContextUtils.getApplicationContext(), "android.permission.ACCESS_FINE_LOCATION"));
            } else {
                sHaveAccessLocationState = Boolean.valueOf(hasPermission(ContextUtils.getApplicationContext(), "android.permission.ACCESS_COARSE_LOCATION") || hasPermission(ContextUtils.getApplicationContext(), "android.permission.ACCESS_FINE_LOCATION"));
            }
        }
        return sHaveAccessLocationState.booleanValue();
    }

    private static boolean hasPermission(Context context, String str) {
        return ApiCompatibilityUtils.checkPermission(context, str, Process.myPid(), Process.myUid()) == 0;
    }

    public static DnsStatus getDnsStatusForNetwork(long j) {
        try {
            return getDnsStatus(Network.fromNetworkHandle(j));
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static DnsStatus getCurrentDnsStatus() {
        return getDnsStatus(null);
    }

    public static DnsStatus getDnsStatus(Network network) {
        ConnectivityManager connectivityManager;
        if (!haveAccessNetworkState() || (connectivityManager = (ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity")) == null) {
            return null;
        }
        if (network == null) {
            network = ApiHelperForM.getActiveNetwork(connectivityManager);
        }
        if (network == null) {
            return null;
        }
        try {
            LinkProperties linkProperties = connectivityManager.getLinkProperties(network);
            if (linkProperties == null) {
                return null;
            }
            List<InetAddress> dnsServers = linkProperties.getDnsServers();
            String domains = linkProperties.getDomains();
            if (Build.VERSION.SDK_INT >= 28) {
                return new DnsStatus(dnsServers, ApiHelperForP.isPrivateDnsActive(linkProperties), ApiHelperForP.getPrivateDnsServerName(linkProperties), domains);
            }
            return new DnsStatus(dnsServers, false, "", domains);
        } catch (RuntimeException unused) {
            return null;
        }
    }

    private static boolean reportBadDefaultNetwork() {
        ConnectivityManager connectivityManager = (ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        ApiHelperForM.reportNetworkConnectivity(connectivityManager, null, false);
        return true;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private static class SetFileDescriptor {
        private static final Method sFileDescriptorSetInt;

        private SetFileDescriptor() {
        }

        static {
            try {
                sFileDescriptorSetInt = FileDescriptor.class.getMethod("setInt$", Integer.TYPE);
            } catch (NoSuchMethodException | SecurityException e) {
                throw new RuntimeException("Unable to get FileDescriptor.setInt$", e);
            }
        }

        public static FileDescriptor createWithFd(int i) {
            try {
                FileDescriptor fileDescriptor = new FileDescriptor();
                sFileDescriptorSetInt.invoke(fileDescriptor, Integer.valueOf(i));
                return fileDescriptor;
            } catch (IllegalAccessException e) {
                throw new RuntimeException("FileDescriptor.setInt$() failed", e);
            } catch (InvocationTargetException e2) {
                throw new RuntimeException("FileDescriptor.setInt$() failed", e2);
            }
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private static class SocketFd extends Socket {

        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
        private static class SocketImplFd extends SocketImpl {
            @Override // java.net.SocketImpl
            protected void close() {
            }

            @Override // java.net.SocketImpl
            protected void create(boolean z) {
            }

            SocketImplFd(FileDescriptor fileDescriptor) {
                this.fd = fileDescriptor;
            }

            @Override // java.net.SocketImpl
            protected void accept(SocketImpl socketImpl) {
                throw new RuntimeException("accept not implemented");
            }

            @Override // java.net.SocketImpl
            protected int available() {
                throw new RuntimeException("accept not implemented");
            }

            @Override // java.net.SocketImpl
            protected void bind(InetAddress inetAddress, int i) {
                throw new RuntimeException("accept not implemented");
            }

            @Override // java.net.SocketImpl
            protected void connect(InetAddress inetAddress, int i) {
                throw new RuntimeException("connect not implemented");
            }

            @Override // java.net.SocketImpl
            protected void connect(SocketAddress socketAddress, int i) {
                throw new RuntimeException("connect not implemented");
            }

            @Override // java.net.SocketImpl
            protected void connect(String str, int i) {
                throw new RuntimeException("connect not implemented");
            }

            @Override // java.net.SocketImpl
            protected InputStream getInputStream() {
                throw new RuntimeException("getInputStream not implemented");
            }

            @Override // java.net.SocketImpl
            protected OutputStream getOutputStream() {
                throw new RuntimeException("getOutputStream not implemented");
            }

            @Override // java.net.SocketImpl
            protected void listen(int i) {
                throw new RuntimeException("listen not implemented");
            }

            @Override // java.net.SocketImpl
            protected void sendUrgentData(int i) {
                throw new RuntimeException("sendUrgentData not implemented");
            }

            @Override // java.net.SocketOptions
            public Object getOption(int i) {
                throw new RuntimeException("getOption not implemented");
            }

            @Override // java.net.SocketOptions
            public void setOption(int i, Object obj) {
                throw new RuntimeException("setOption not implemented");
            }
        }

        SocketFd(FileDescriptor fileDescriptor) throws IOException {
            super(new SocketImplFd(fileDescriptor));
        }
    }

    private static void alwaysUpCellularOnThreadPool() {
        final ConnectivityManager connectivityManager = (ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager == null) {
            AndroidNetworkLibraryJni.get().onCellularAlwaysUp(false, 7);
            return;
        }
        try {
            connectivityManager.requestNetwork(new NetworkRequest.Builder().addCapability(12).addTransportType(0).build(), new ConnectivityManager.NetworkCallback() { // from class: com.ttnet.org.chromium.net.AndroidNetworkLibrary.1
                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onAvailable(Network network) {
                    NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
                    if (networkCapabilities != null && networkCapabilities.hasTransport(0) && networkCapabilities.hasCapability(12)) {
                        AndroidNetworkLibraryJni.get().onCellularAlwaysUp(true, -1);
                    } else {
                        AndroidNetworkLibraryJni.get().onCellularAlwaysUp(false, 8);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            AndroidNetworkLibraryJni.get().onCellularAlwaysUp(false, 9);
        }
    }

    public static int[] getDhcpInfo() {
        DhcpInfo dhcpInfo;
        if (TTAppSecurityManager.getInstance().isUserPrivacyRestrictionEnabled()) {
            return new int[0];
        }
        try {
            WifiManager wifiManager = (WifiManager) ContextUtils.getApplicationContext().getSystemService("wifi");
            if (wifiManager != null && (dhcpInfo = wifiManager.getDhcpInfo()) != null) {
                return new int[]{dhcpInfo.ipAddress, dhcpInfo.gateway};
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return new int[0];
    }

    public static String[][] getAllRouteInfo() {
        if (!haveAccessNetworkState()) {
            return null;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity");
            if (connectivityManager == null) {
                return null;
            }
            Network[] allNetworks = connectivityManager.getAllNetworks();
            ArrayList arrayList = new ArrayList();
            for (Network network : allNetworks) {
                LinkProperties linkProperties = connectivityManager.getLinkProperties(network);
                if (linkProperties != null) {
                    for (RouteInfo routeInfo : linkProperties.getRoutes()) {
                        String[] strArr = new String[4];
                        if (routeInfo.getDestination() != null) {
                            strArr[0] = routeInfo.getDestination().getAddress().getHostAddress();
                            strArr[1] = Integer.toString(routeInfo.getDestination().getPrefixLength());
                        }
                        if (routeInfo.getGateway() != null) {
                            strArr[2] = routeInfo.getGateway().getHostAddress();
                        }
                        strArr[3] = routeInfo.getInterface();
                        arrayList.add(strArr);
                    }
                }
            }
            return (String[][]) arrayList.toArray((String[][]) Array.newInstance((Class<?>) String.class, 0, 0));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static String getNetworkOperator() {
        if (TTAppSecurityManager.getInstance().isTTPRestrictionEnabled()) {
            return TTAppSecurityManager.getInstance().getNetworkOperator();
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) ContextUtils.getApplicationContext().getSystemService("phone");
            return telephonyManager == null ? "" : telephonyManager.getNetworkOperator();
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    private static String getSimOperator() {
        if (TTAppSecurityManager.getInstance().isTTPRestrictionEnabled()) {
            return TTAppSecurityManager.getInstance().getSimOperator();
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) ContextUtils.getApplicationContext().getSystemService("phone");
            return telephonyManager == null ? "" : m434x485c93c5(telephonyManager);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    private static boolean checkIsVpnOn() {
        ConnectivityManager connectivityManager = (ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        Network[] allNetworks = connectivityManager.getAllNetworks();
        for (int i = 0; i < allNetworks.length; i++) {
            if (connectivityManager.getNetworkInfo(allNetworks[i]).isConnected() && connectivityManager.getNetworkCapabilities(allNetworks[i]).hasTransport(4)) {
                return true;
            }
        }
        return false;
    }

    public static int getCurrentAccessPointChannel() {
        if (TTAppSecurityManager.getInstance().isTTPRestrictionEnabled()) {
            return frequencyToChannel(TTAppSecurityManager.getInstance().getWifiFrequency());
        }
        WifiInfo wifiInfo = getWifiInfo();
        if (wifiInfo == null) {
            return -1;
        }
        return frequencyToChannel(wifiInfo.getFrequency());
    }

    public static int[] getAllAccessPointChannels() {
        if (!haveAccessLocationState() || !haveAccessWifiState()) {
            return new int[0];
        }
        WifiManager wifiManager = (WifiManager) ContextUtils.getApplicationContext().getSystemService("wifi");
        if (wifiManager == null) {
            return new int[0];
        }
        List<ScanResult> scanResults = wifiManager.getScanResults();
        if (scanResults == null || scanResults.isEmpty()) {
            return new int[0];
        }
        ArrayList arrayList = new ArrayList();
        Iterator<ScanResult> it = scanResults.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(frequencyToChannel(it.next().frequency)));
        }
        return CollectionUtil.integerListToIntArray(arrayList);
    }

    private static int frequencyToChannel(int i) {
        if (i == 2484) {
            return 14;
        }
        if (i < 2484) {
            return (i - 2407) / 5;
        }
        if (i >= 4910 && i <= 4980) {
            return (i + AVMDLDataLoader.AVMDLErrorIsInvalidRequestInfo) / 5;
        }
        if (i < 5925) {
            return (i + AVMDLDataLoader.AVMDLErrorIsInvalidFileWrite) / 5;
        }
        if (i == 5935) {
            return 2;
        }
        if (i <= 45000) {
            return (i - 5950) / 5;
        }
        if (i < 58320 || i > 70200) {
            return -1;
        }
        return (i - 56160) / 2160;
    }

    private static void tagSocket(int i, int i2, int i3) throws IOException {
        int threadStatsTag = TrafficStats.getThreadStatsTag();
        if (i3 != threadStatsTag) {
            TrafficStats.setThreadStatsTag(i3);
        }
        if (i2 != -1) {
            ThreadStatsUid.set(i2);
        }
        ParcelFileDescriptor adoptFd = ParcelFileDescriptor.adoptFd(i);
        SocketFd socketFd = new SocketFd(adoptFd.getFileDescriptor());
        TrafficStats.tagSocket(socketFd);
        socketFd.close();
        if (adoptFd != null) {
            adoptFd.detachFd();
        }
        if (i3 != threadStatsTag) {
            TrafficStats.setThreadStatsTag(threadStatsTag);
        }
        if (i2 != -1) {
            ThreadStatsUid.clear();
        }
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    /* renamed from: INVOKEVIRTUAL_com_ttnet_org_chromium_net_AndroidNetworkLibrary_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m433x6d66dea8(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        }
        try {
            if (ReceiverRegisterCrashOptimizer.doRegisterHandler()) {
                ReceiverRegisterLancet.initHandler();
                Context context2 = context;
                return context.registerReceiver(broadcastReceiver, intentFilter, null, ReceiverRegisterLancet.sReceiverHandler);
            }
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null && ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(intentFilter)) {
                ReceiverRegisterLancet.initProxyHandler();
                Context context3 = context;
                return ContextCompat.registerReceiver(context, broadcastReceiver, intentFilter, (String) null, ReceiverRegisterLancet.sProxyHandler, 2);
            }
            return context.registerReceiver(broadcastReceiver, intentFilter);
        } catch (Exception e) {
            if (!ReceiverRegisterCrashOptimizer.fixedOpen()) {
                throw e;
            }
            return ReceiverRegisterCrashOptimizer.registerReceiver(broadcastReceiver, intentFilter);
        }
    }
}
