package com.bytedance.networkstackapplib;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Process;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class TTNetworkStackAPI {
    public static final String CHECK_SERVER_ADDR = "8.8.8.8";
    public static final int ERROR_SDK_VERSION_NOT_SUPPORT = -99;
    public static final int MAX_CHECK_NETWORK_TIMEOUT = 100;
    public static final int NET_CAP_ERROR_NEED_CONTEXT = 3;
    public static final int NET_CAP_INVALIDATED = 1;
    public static final int NET_CAP_PARTAL = 2;
    public static final int NET_CAP_VALIDATED = 0;
    public static final int TYPE_ERROR_DENY_BY_FIREWALL = -2;
    public static final int TYPE_ERROR_NO_DEFAULT_ROUTE = -1;
    public static final int TYPE_ERROR_TOO_BUSY = -101;
    public static final int TYPE_ERROR_TRY_AGAIN = -100;
    public static final int TYPE_NO_ERROR = 0;
    private Context mContext;
    private NetworkQualityCollect mNqc;
    private int mCheckErrorType = 0;
    private boolean mIsCheckingNetwork = false;
    private final Object mCheckNetworkLock = new Object();
    private boolean mDebugLog = false;
    ConnectivityManager mCm = null;

    public TTNetworkStackAPI(Context context) {
        this.mContext = null;
        this.mNqc = null;
        this.mContext = context;
        this.mNqc = NetworkQualityCollect.getInstance(context);
    }

    public void setDebugLogFeature(boolean z) {
        this.mDebugLog = z;
    }

    public boolean getDebugLogFeature() {
        return this.mDebugLog;
    }

    public int getNetworkCap(Context context) {
        try {
            if (this.mCm == null) {
                this.mCm = (ConnectivityManager) context.getSystemService("connectivity");
            }
            Network activeNetwork = this.mCm.getActiveNetwork();
            NetworkCapabilities networkCapabilities = this.mCm.getNetworkCapabilities(activeNetwork);
            if (activeNetwork != null && networkCapabilities != null) {
                if (this.mDebugLog) {
                    System.out.println("TTNetworkStackAPI nc portal = " + networkCapabilities.hasCapability(17));
                    System.out.println("TTNetworkStackAPI nc validated = " + networkCapabilities.hasCapability(16));
                }
                if (networkCapabilities.hasCapability(16)) {
                    return 0;
                }
                if (networkCapabilities.hasCapability(17)) {
                    return 2;
                }
            }
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }

    public int getSpecalNetworkError() {
        int i;
        if (this.mDebugLog) {
            System.out.println("TTNetworkStackAPI:getSpecalNetworkError, caller pid = " + Process.myPid() + ", tid = " + Process.myTid());
        }
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.mCheckNetworkLock) {
            if (this.mIsCheckingNetwork) {
                return -100;
            }
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            new Thread(new Runnable() { // from class: com.bytedance.networkstackapplib.TTNetworkStackAPI.1
                /* JADX WARN: Removed duplicated region for block: B:29:0x006e A[Catch: all -> 0x0034, TryCatch #2 {all -> 0x0034, blocks: (B:2:0x0000, B:3:0x0006, B:7:0x0014, B:14:0x0033, B:19:0x0037, B:20:0x0041, B:27:0x0066, B:29:0x006e, B:30:0x0086, B:35:0x0090, B:37:0x0044, B:39:0x004c, B:26:0x0065, B:23:0x0057, B:25:0x005f), top: B:1:0x0000, inners: #1, #3 }] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    try {
                        try {
                            synchronized (TTNetworkStackAPI.this.mCheckNetworkLock) {
                                TTNetworkStackAPI.this.mIsCheckingNetwork = true;
                                TTNetworkStackAPI.this.mCheckErrorType = 0;
                            }
                            DatagramSocket datagramSocket = new DatagramSocket();
                            byte[] randonData = TTNetworkStackUtils.getRandonData(10);
                            datagramSocket.send(new DatagramPacket(randonData, randonData.length, InetAddress.getByName(TTNetworkStackAPI.CHECK_SERVER_ADDR), 53));
                        } catch (Exception e) {
                            String message = e.getMessage();
                            synchronized (TTNetworkStackAPI.this.mCheckNetworkLock) {
                                if (message != null) {
                                    try {
                                        if (message.contains("EPERM")) {
                                            TTNetworkStackAPI.this.mCheckErrorType = -2;
                                            if (TTNetworkStackAPI.this.mDebugLog) {
                                                System.out.println("TTNetworkStackAPI:  getSpecalNetworkError Exception =  " + e);
                                            }
                                            e.printStackTrace();
                                        }
                                    } catch (Throwable th) {
                                        throw th;
                                    }
                                }
                                if (message != null && message.contains("ENETUNREACH")) {
                                    TTNetworkStackAPI.this.mCheckErrorType = -1;
                                }
                                if (TTNetworkStackAPI.this.mDebugLog) {
                                }
                                e.printStackTrace();
                            }
                        }
                    } finally {
                        countDownLatch.countDown();
                    }
                }
            }).start();
            try {
                countDownLatch.await(100L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                System.out.println("TTNetworkStackAPI: InterruptedException happen. " + e);
                e.printStackTrace();
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (this.mDebugLog) {
                System.out.println("TTNetworkStackAPI: getSpecalNetworkError costTime = " + currentTimeMillis2);
            }
            if (currentTimeMillis2 >= 100) {
                return -101;
            }
            synchronized (this.mCheckNetworkLock) {
                this.mIsCheckingNetwork = false;
                i = this.mCheckErrorType;
            }
            return i;
        }
    }

    public int getDataLevel() {
        return this.mNqc.getDataLevel();
    }

    public int getWifiLevel() {
        return this.mNqc.getWifiLevel();
    }

    public String getDataType() {
        return this.mNqc.getDataType();
    }

    public int getSimNetworkType() {
        return this.mNqc.mSimNetworkType;
    }

    public String getNetworkType() {
        return this.mNqc.getNetworkType();
    }

    public boolean is5G() {
        return this.mNqc.is5G();
    }
}
