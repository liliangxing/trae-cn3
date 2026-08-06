package com.bytedance.realx.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.realx.base.NetworkTypeUtils;

/* loaded from: classes4.dex */
public class NetworkChangeReceiver extends BroadcastReceiver {
    private static final int NETWORK_TYPE_DISCONNECTED = 0;
    private static final int NETWORK_TYPE_LAN = 1;
    private static final int NETWORK_TYPE_MOBILE_2G = 3;
    private static final int NETWORK_TYPE_MOBILE_3G = 4;
    private static final int NETWORK_TYPE_MOBILE_4G = 5;
    private static final int NETWORK_TYPE_MOBILE_5G = 6;
    private static final int NETWORK_TYPE_UNKNOWN = -1;
    private static final int NETWORK_TYPE_WIFI = 2;
    private static final String TAG = "NetworkChangeReceiver";
    public static Object threadLock = new Object();
    private Context mContext;
    private final long nativeNetworkReceiver;
    private NetworkTypeThread networkTypeThread;
    private Intent networkChangeIntent = null;
    private NetworkTypeUtils.NetworkType sNetworkType = NetworkTypeUtils.NetworkType.NONE;
    private boolean firstChanged = false;

    private native void nativeSetNetworkType(int type, String extraInfo, long nativeNetworkReceiver);

    /* loaded from: classes4.dex */
    private class NetworkTypeThread extends Thread {
        public boolean keepAlive;

        public NetworkTypeThread(String name) {
            super(name);
            this.keepAlive = true;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                synchronized (NetworkChangeReceiver.threadLock) {
                    if (NetworkChangeReceiver.this.firstChanged) {
                        try {
                            NetworkChangeReceiver.threadLock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (!this.keepAlive) {
                        return;
                    }
                    try {
                        NetworkChangeReceiver.this.getNetworkTypeInternal();
                    } catch (UnsatisfiedLinkError e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }

        public void stopThread() {
            synchronized (NetworkChangeReceiver.threadLock) {
                RXLogging.i(NetworkChangeReceiver.TAG, "stopThread");
                this.keepAlive = false;
                NetworkChangeReceiver.threadLock.notify();
            }
        }
    }

    NetworkChangeReceiver(long nativeNetworkReceiver) {
        RXLogging.i(TAG, "init, nativeNetworkReceiver: " + nativeNetworkReceiver);
        Context applicationContext = ContextUtils.getApplicationContext();
        this.mContext = applicationContext;
        this.nativeNetworkReceiver = nativeNetworkReceiver;
        NetworkTypeUtils.registerReceiver(applicationContext, this);
    }

    public void StartDetect() {
        if (this.networkTypeThread == null) {
            NetworkTypeThread networkTypeThread = new NetworkTypeThread("NetworkTypeThread");
            this.networkTypeThread = networkTypeThread;
            networkTypeThread.start();
        }
    }

    public void StopDetect() {
        NetworkTypeThread networkTypeThread = this.networkTypeThread;
        if (networkTypeThread != null) {
            networkTypeThread.stopThread();
            this.networkTypeThread.interrupt();
            this.networkTypeThread = null;
            NetworkTypeUtils.unregisterReceiver(this.mContext, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getNetworkTypeInternal() {
        NetworkTypeUtils.NetworkType networkType = NetworkTypeUtils.getNetworkType(this.mContext, this.networkChangeIntent);
        this.networkChangeIntent = null;
        RXLogging.i(TAG, "GetNetworkType, networkType： " + networkType);
        if (this.firstChanged && this.sNetworkType == networkType) {
            return;
        }
        this.firstChanged = true;
        nativeSetNetworkType(getConstantNetworkType(networkType), NetworkTypeUtils.getDebugInfo(), this.nativeNetworkReceiver);
        this.sNetworkType = networkType;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        RXLogging.i(TAG, "onReceive, action: " + intent.getAction());
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) || "android.net.wifi.WIFI_STATE_CHANGED".equals(intent.getAction()) || "android.net.wifi.STATE_CHANGE".equals(intent.getAction())) {
            synchronized (threadLock) {
                this.networkChangeIntent = intent;
                threadLock.notify();
            }
        }
    }

    private int getConstantNetworkType(final NetworkTypeUtils.NetworkType sNetworkType) {
        if (sNetworkType.isAvailable()) {
            return getType(sNetworkType);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.realx.base.NetworkChangeReceiver$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$realx$base$NetworkTypeUtils$NetworkType;

        static {
            int[] iArr = new int[NetworkTypeUtils.NetworkType.values().length];
            $SwitchMap$com$bytedance$realx$base$NetworkTypeUtils$NetworkType = iArr;
            try {
                iArr[NetworkTypeUtils.NetworkType.MOBILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bytedance$realx$base$NetworkTypeUtils$NetworkType[NetworkTypeUtils.NetworkType.WIFI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$bytedance$realx$base$NetworkTypeUtils$NetworkType[NetworkTypeUtils.NetworkType.MOBILE_2G.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$bytedance$realx$base$NetworkTypeUtils$NetworkType[NetworkTypeUtils.NetworkType.MOBILE_3G.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$bytedance$realx$base$NetworkTypeUtils$NetworkType[NetworkTypeUtils.NetworkType.MOBILE_4G.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$bytedance$realx$base$NetworkTypeUtils$NetworkType[NetworkTypeUtils.NetworkType.MOBILE_5G.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private int getType(final NetworkTypeUtils.NetworkType networkType) {
        switch (AnonymousClass1.$SwitchMap$com$bytedance$realx$base$NetworkTypeUtils$NetworkType[networkType.ordinal()]) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            default:
                return -1;
        }
    }
}
