package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util;

import com.bytedance.common.utility.Logger;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public class Ipv6ConnectionManager {
    private static final String TAG = "Ipv6ConnectionManager";
    private static String mIPv6ProbeAddress = "2001:4860:4860::8888";
    private static AtomicBoolean mIsIpv6GloballyReachable = new AtomicBoolean(false);

    public static void detectIpv6Reachable() {
        if (Logger.debug()) {
            Logger.d(TAG, "detectIpv6Reachable");
        }
        mIsIpv6GloballyReachable.set(isGloballyIpv6Reachable());
    }

    private static boolean isGloballyIpv6Reachable() {
        boolean z = false;
        DatagramSocket datagramSocket = null;
        try {
            DatagramSocket datagramSocket2 = new DatagramSocket();
            try {
                datagramSocket2.connect(new InetSocketAddress(mIPv6ProbeAddress, 53));
                InetAddress localAddress = datagramSocket2.getLocalAddress();
                if (localAddress instanceof Inet6Address) {
                    boolean z2 = !localAddress.isLinkLocalAddress();
                    if (!localAddress.getHostAddress().startsWith("2001:0000")) {
                        z = z2;
                    }
                }
                datagramSocket2.close();
            } catch (IOException unused) {
                datagramSocket = datagramSocket2;
                if (datagramSocket != null) {
                    datagramSocket.close();
                }
                return z;
            } catch (Throwable th) {
                th = th;
                datagramSocket = datagramSocket2;
                if (datagramSocket != null) {
                    datagramSocket.close();
                }
                throw th;
            }
        } catch (IOException unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
        return z;
    }

    public static AtomicBoolean getIpv6GloballyReachable() {
        return mIsIpv6GloballyReachable;
    }
}
