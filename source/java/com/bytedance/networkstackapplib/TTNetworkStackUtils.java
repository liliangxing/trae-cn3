package com.bytedance.networkstackapplib;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.ProxyInfo;
import android.os.Build;
import com.ss.bduploader.UploadKeys;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.UUID;

/* loaded from: classes4.dex */
public class TTNetworkStackUtils {
    public static long BAD_DNS_QUERY_TIME = 5000;
    private static InetAddress[] addr;

    public static byte[] getRandonData(int i) {
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) ((System.currentTimeMillis() % (i2 + 100)) + 1);
        }
        return bArr;
    }

    public static String getIpAvailableType(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            LinkProperties linkProperties = connectivityManager.getLinkProperties(connectivityManager.getActiveNetwork());
            if (linkProperties == null) {
                return "EmptyLp";
            }
            Class<?> cls = Class.forName("android.net.LinkProperties");
            boolean z = false;
            Method declaredMethod = cls.getDeclaredMethod("hasIpv4Address", new Class[0]);
            Method declaredMethod2 = cls.getDeclaredMethod("hasIpv4DefaultRoute", new Class[0]);
            Method declaredMethod3 = cls.getDeclaredMethod("hasGlobalIpv6Address", new Class[0]);
            Method declaredMethod4 = cls.getDeclaredMethod("hasIpv6DefaultRoute", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod2.setAccessible(true);
            declaredMethod3.setAccessible(true);
            declaredMethod4.setAccessible(true);
            boolean z2 = ((Boolean) declaredMethod.invoke(linkProperties, new Object[0])).booleanValue() && ((Boolean) declaredMethod2.invoke(linkProperties, new Object[0])).booleanValue();
            if (((Boolean) declaredMethod3.invoke(linkProperties, new Object[0])).booleanValue()) {
                if (((Boolean) declaredMethod4.invoke(linkProperties, new Object[0])).booleanValue()) {
                    z = true;
                }
            }
            return (z2 && z) ? "Ipv4Ipv6" : (!z2 || z) ? (z2 || !z) ? "NoV4V6" : "Ipv6Only" : "Ipv4Only";
        } catch (Exception e) {
            e.printStackTrace();
            return "UNKNOWN";
        }
    }

    public static String getProbeDnsName() {
        try {
            return UUID.randomUUID().toString().substring(0, 8) + "-dnsotls-ds.metric.gstatic.com";
        } catch (Exception e) {
            e.printStackTrace();
            return "aabbccdd-dnsotls-ds.metric.gstatic.com";
        }
    }

    public static long getDnsProbeTime(int i) {
        try {
            final String probeDnsName = getProbeDnsName();
            return new MyTimeoutTask().startTask(i, new Runnable() { // from class: com.bytedance.networkstackapplib.TTNetworkStackUtils.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        InetAddress.getAllByName(probeDnsName);
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static long getDnsAndTcpProbeTime(int i) {
        final boolean[] zArr = {false};
        long j = 0;
        try {
            final String probeDnsName = getProbeDnsName();
            j = new MyTimeoutTask().startTwoTasksNeedOneFinished(i, new Runnable() { // from class: com.bytedance.networkstackapplib.TTNetworkStackUtils.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        InetAddress.getAllByName(probeDnsName);
                    } catch (UnknownHostException e) {
                        zArr[0] = true;
                        e.printStackTrace();
                    }
                }
            }, new Runnable() { // from class: com.bytedance.networkstackapplib.TTNetworkStackUtils.3
                @Override // java.lang.Runnable
                public void run() {
                    Socket socket = new Socket();
                    try {
                        try {
                            try {
                                socket.connect(new InetSocketAddress(InetAddress.getByName("www.toutiao.com"), UploadKeys.KeyIsGetVideoMeta));
                                socket.close();
                            } catch (Exception e) {
                                zArr[0] = true;
                                e.printStackTrace();
                                socket.close();
                            }
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    } catch (Throwable th) {
                        try {
                            socket.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                        throw th;
                    }
                }
            });
            return zArr[0] ? i + 1 : j;
        } catch (Exception e) {
            e.printStackTrace();
            return j;
        }
    }

    public static int checkLinkProxy(Context context) {
        boolean z;
        boolean z2;
        long currentTimeMillis;
        long currentTimeMillis2;
        final ProxyInfo proxyInfo = getProxyInfo(context);
        if (proxyInfo == null) {
            return 1;
        }
        final int[] iArr = {0, 0};
        try {
            final URL url = new URL("https://search3-search-hl.toutiaoapi.com/search/");
            long currentTimeMillis3 = System.currentTimeMillis();
            new MyTimeoutTask().startTask(3000, new Runnable() { // from class: com.bytedance.networkstackapplib.TTNetworkStackUtils.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        iArr[0] = ((HttpURLConnection) url.openConnection(Proxy.NO_PROXY)).getResponseCode();
                        System.out.println("respCode[0] = " + iArr[0]);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            int i = iArr[0];
            z2 = i >= 200 && i < 500;
            try {
                currentTimeMillis = System.currentTimeMillis() - currentTimeMillis3;
                currentTimeMillis2 = System.currentTimeMillis();
                new MyTimeoutTask().startTask(3000, new Runnable() { // from class: com.bytedance.networkstackapplib.TTNetworkStackUtils.5
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            iArr[1] = ((HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(proxyInfo.getHost(), proxyInfo.getPort())))).getResponseCode();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                int i2 = iArr[1];
                z = i2 >= 200 && i2 < 500;
            } catch (Exception e) {
                e = e;
                z = false;
            }
        } catch (Exception e2) {
            e = e2;
            z = false;
            z2 = false;
        }
        try {
            long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis2;
            System.out.println("checkLinkProxy code1=" + iArr[0] + ",cost1=" + currentTimeMillis + ",code2=" + iArr[1] + ",cost2=" + currentTimeMillis4);
            if (z && z2 && currentTimeMillis4 > currentTimeMillis * 2) {
                System.out.println("checkLinkProxy maybe you can cancel Proxy.");
                return 0;
            }
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            if (z2) {
            }
            return 1;
        }
        if (z2 || z) {
            return 1;
        }
        System.out.println("TTNetworkStackUtils you must cancel Proxy.");
        return 0;
    }

    public static ProxyInfo getProxyInfo(Context context) {
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getDefaultProxy();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static long checkPrivateDns(Context context) {
        LinkProperties linkProperties;
        System.out.println("TTNetworkStackUtils checkPrivateDns current version = " + Build.VERSION.SDK_INT);
        if (Build.VERSION.SDK_INT < 28) {
            System.out.println("TTNetworkStackUtils checkPrivateDns return by android current version not support");
            return 0L;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null || (linkProperties = connectivityManager.getLinkProperties(activeNetwork)) == null || linkProperties.getPrivateDnsServerName() == null) {
            return 1L;
        }
        System.currentTimeMillis();
        try {
            addr = null;
            long startTask = new MyTimeoutTask().startTask(5000, new Runnable() { // from class: com.bytedance.networkstackapplib.TTNetworkStackUtils.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        System.out.println("TTNetworkStackUtils getAllByName start run.");
                        String probeDnsName = TTNetworkStackUtils.getProbeDnsName();
                        InetAddress[] unused = TTNetworkStackUtils.addr = InetAddress.getAllByName(probeDnsName);
                        System.out.println("TTNetworkStackUtils getAllByName end run. addr = " + TTNetworkStackUtils.addr.length + ",hostName=" + probeDnsName);
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    }
                }
            });
            System.out.println("phph MyTimeoutTask costtime = " + startTask);
            InetAddress[] inetAddressArr = addr;
            if (inetAddressArr == null || inetAddressArr.length == 0) {
                startTask += BAD_DNS_QUERY_TIME;
            }
            if (startTask < 10) {
                return 2L;
            }
            return startTask;
        } catch (Exception e) {
            e.printStackTrace();
            return 1L;
        }
    }

    public static Network getMobileNetwok(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            for (Network network : connectivityManager.getAllNetworks()) {
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
                if (networkCapabilities.hasTransport(0) && networkCapabilities.hasCapability(12)) {
                    return network;
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
