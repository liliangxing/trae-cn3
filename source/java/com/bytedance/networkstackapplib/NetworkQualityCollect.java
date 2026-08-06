package com.bytedance.networkstackapplib;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: classes4.dex */
public class NetworkQualityCollect {
    private static final int BEST_RSSI_LEVEL = 4;
    private static final int MAX_RSSI = -55;
    private static final int MIN_RSSI = -88;
    private static NetworkQualityCollect sInstance;
    private static final Object sLock = new Object();

    /* renamed from: cm, reason: collision with root package name */
    private ConnectivityManager f1106cm;
    private Context mContext;
    private TelephonyManager tm;
    private WifiManager wm;
    public int mSimNetworkType = -1;
    private String mGSMType = NetworkStackConstant.ERR_NOT_REGISTERED;
    private String mNetworkType = NetworkStackConstant.ERR_NOT_REGISTERED;
    private int mDataLevel = -1;
    private int mWifiLevel = -1;
    private boolean is5GAvailable = false;
    private final Object mGSMTypeUpdateLock = new Object();
    private final Object mGSMLevelLock = new Object();
    private final Object mNetworkTypeUpdateLock = new Object();
    private final Object mWifiLevelUpdateLock = new Object();
    private final Object mServiveStateUpdateLock = new Object();
    private MyPhoneStateChange mPhoneStateListener = null;
    private MyBroadcastReceiver mBroadcastReceiver = null;
    private int lastDataSim = -1;
    private Handler myHandler = null;

    public static String getNetworkTypeName(int i) {
        switch (i) {
            case 1:
                return "GPRS";
            case 2:
                return "EDGE";
            case 3:
                return "UMTS";
            case 4:
                return "CDMA";
            case 5:
                return "CDMA - EvDo rev. 0";
            case 6:
                return "CDMA - EvDo rev. A";
            case 7:
                return "CDMA - 1xRTT";
            case 8:
                return "HSDPA";
            case 9:
                return "HSUPA";
            case 10:
                return "HSPA";
            case 11:
                return "iDEN";
            case 12:
                return "CDMA - EvDo rev. B";
            case 13:
                return "LTE";
            case 14:
                return "CDMA - eHRPD";
            case 15:
                return "HSPA+";
            case 16:
                return "GSM";
            case 17:
                return "TD_SCDMA";
            case 18:
                return "IWLAN";
            case 19:
                return "LTE_CA";
            case 20:
                return "NR";
            default:
                return "UNKNOWN";
        }
    }

    private NetworkQualityCollect(Context context) {
        this.mContext = null;
        this.tm = null;
        this.f1106cm = null;
        this.wm = null;
        try {
            this.mContext = context;
            this.tm = (TelephonyManager) context.getSystemService("phone");
            this.f1106cm = (ConnectivityManager) this.mContext.getSystemService("connectivity");
            this.wm = (WifiManager) this.mContext.getApplicationContext().getSystemService("wifi");
            initForRegister();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isServiceStateFiveGAvailable(String str) {
        if (str == null) {
            return false;
        }
        synchronized (this.mServiveStateUpdateLock) {
            this.is5GAvailable = false;
            if (!TextUtils.isEmpty(str) && (str.contains("nrState=NOT_RESTRICTED") || str.contains("nrState=CONNECTED"))) {
                this.is5GAvailable = true;
            }
        }
        return this.is5GAvailable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class MyPhoneStateChange extends PhoneStateListener {
        MyPhoneStateChange() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onDataConnectionStateChanged(int i, int i2) {
            super.onDataConnectionStateChanged(i, i2);
            synchronized (NetworkQualityCollect.this.mGSMTypeUpdateLock) {
                try {
                    NetworkQualityCollect.this.mSimNetworkType = i2;
                    NetworkQualityCollect.this.mGSMType = NetworkQualityCollect.getNetworkTypeName(i2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // android.telephony.PhoneStateListener
        public void onServiceStateChanged(ServiceState serviceState) {
            super.onServiceStateChanged(serviceState);
            try {
                NetworkQualityCollect.this.isServiceStateFiveGAvailable(serviceState.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            super.onSignalStrengthsChanged(signalStrength);
            synchronized (NetworkQualityCollect.this.mGSMLevelLock) {
                try {
                    NetworkQualityCollect.this.mDataLevel = signalStrength.getLevel();
                } finally {
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    class MyBroadcastReceiver extends BroadcastReceiver {
        MyBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                    NetworkInfo activeNetworkInfo = NetworkQualityCollect.this.f1106cm.getActiveNetworkInfo();
                    synchronized (NetworkQualityCollect.this.mNetworkTypeUpdateLock) {
                        if (activeNetworkInfo == null) {
                            try {
                                NetworkQualityCollect.this.mNetworkType = NetworkStackConstant.ERR_DISCONNECTED;
                            } finally {
                            }
                        }
                        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                            NetworkQualityCollect.this.mNetworkType = NetworkStackConstant.ERR_DISCONNECTED;
                        } else {
                            NetworkQualityCollect.this.listenDataSim();
                            NetworkQualityCollect.this.mNetworkType = activeNetworkInfo.getTypeName();
                        }
                    }
                    if (NetworkStackConstant.ERR_DISCONNECTED.equals(NetworkQualityCollect.this.mNetworkType)) {
                        synchronized (NetworkQualityCollect.this.mWifiLevelUpdateLock) {
                            NetworkQualityCollect.this.mWifiLevel = -1;
                        }
                        return;
                    }
                    return;
                }
                if ("android.net.wifi.RSSI_CHANGED".equals(intent.getAction())) {
                    synchronized (NetworkQualityCollect.this.mWifiLevelUpdateLock) {
                        int intExtra = intent.getIntExtra("newRssi", -70);
                        NetworkQualityCollect networkQualityCollect = NetworkQualityCollect.this;
                        networkQualityCollect.mWifiLevel = networkQualityCollect.calculateWifiSignalLevel(intExtra);
                    }
                    return;
                }
                return;
            } catch (Exception e) {
                e.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int calculateWifiSignalLevel(int i) {
        if (i <= MIN_RSSI) {
            return 0;
        }
        if (i >= MAX_RSSI) {
            return 4;
        }
        return ((i - MIN_RSSI) * 4) / 33;
    }

    public static NetworkQualityCollect getInstance(Context context) {
        synchronized (sLock) {
            if (sInstance == null) {
                sInstance = new NetworkQualityCollect(context);
            }
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean listenDataSim() {
        try {
            int defaultDataSubscriptionId = SubscriptionManager.getDefaultDataSubscriptionId();
            if (this.lastDataSim == defaultDataSubscriptionId) {
                return true;
            }
            TelephonyManager createForSubscriptionId = this.tm.createForSubscriptionId(defaultDataSubscriptionId);
            this.tm = createForSubscriptionId;
            createForSubscriptionId.listen(this.mPhoneStateListener, 321);
            this.lastDataSim = defaultDataSubscriptionId;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void initForRegister() {
        HandlerThread handlerThread = new HandlerThread("listener_thread");
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper()) { // from class: com.bytedance.networkstackapplib.NetworkQualityCollect.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message == null) {
                    return;
                }
                super.handleMessage(message);
                NetworkQualityCollect.this.mPhoneStateListener = new MyPhoneStateChange();
                NetworkQualityCollect.this.mBroadcastReceiver = new MyBroadcastReceiver();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.wifi.RSSI_CHANGED");
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                INVOKEVIRTUAL_com_bytedance_networkstackapplib_NetworkQualityCollect$1_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(NetworkQualityCollect.this.mContext, NetworkQualityCollect.this.mBroadcastReceiver, intentFilter);
                NetworkQualityCollect.this.listenDataSim();
            }

            @Proxy("registerReceiver")
            @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
            @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
            public static Intent INVOKEVIRTUAL_com_bytedance_networkstackapplib_NetworkQualityCollect$1_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
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
                        return ContextCompat.registerReceiver(context, broadcastReceiver, intentFilter, null, ReceiverRegisterLancet.sProxyHandler, 2);
                    }
                    return context.registerReceiver(broadcastReceiver, intentFilter);
                } catch (Exception e) {
                    if (!ReceiverRegisterCrashOptimizer.fixedOpen()) {
                        throw e;
                    }
                    return ReceiverRegisterCrashOptimizer.registerReceiver(broadcastReceiver, intentFilter);
                }
            }
        };
        this.myHandler = handler;
        handler.sendEmptyMessage(0);
    }

    public void stopAllWork() {
        try {
            this.tm.listen(this.mPhoneStateListener, 0);
            INVOKEVIRTUAL_com_bytedance_networkstackapplib_NetworkQualityCollect_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(this.mContext, this.mBroadcastReceiver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getDataLevel() {
        int i;
        synchronized (this.mGSMLevelLock) {
            i = this.mDataLevel;
        }
        return i;
    }

    public int getWifiLevel() {
        int i;
        WifiInfo connectionInfo;
        try {
            synchronized (this.mWifiLevelUpdateLock) {
                if ("WIFI".equals(this.mNetworkType) && this.mWifiLevel == -1 && (connectionInfo = this.wm.getConnectionInfo()) != null) {
                    this.mWifiLevel = calculateWifiSignalLevel(connectionInfo.getRssi());
                }
                i = this.mWifiLevel;
            }
            return i;
        } catch (Throwable unused) {
            return -2;
        }
    }

    public String getDataType() {
        String str;
        synchronized (this.mGSMTypeUpdateLock) {
            str = this.mGSMType;
        }
        return str;
    }

    public String getNetworkType() {
        String str;
        synchronized (this.mNetworkTypeUpdateLock) {
            str = this.mNetworkType;
        }
        return str;
    }

    public boolean is5G() {
        return this.is5GAvailable || "NR".equals(this.mGSMType);
    }

    public String toString() {
        return "NetworkQualityCollect{mGSMType='" + this.mGSMType + "', mNetworkType='" + this.mNetworkType + "', mDataLevel=" + this.mDataLevel + ", mWifiLevel=" + this.mWifiLevel + ", lastDataSim=" + this.lastDataSim + ", getIpAvailableType=" + TTNetworkStackUtils.getIpAvailableType(this.mContext) + AbstractJsonLexerKt.END_OBJ;
    }

    @Proxy("unregisterReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    public static void INVOKEVIRTUAL_com_bytedance_networkstackapplib_NetworkQualityCollect_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(Context context, BroadcastReceiver broadcastReceiver) {
        ReceiverRegisterLancet.loge(broadcastReceiver, false);
        context.unregisterReceiver(broadcastReceiver);
    }
}
