package com.bytedance.apm.perf.traffic;

import android.app.usage.NetworkStats;
import android.app.usage.NetworkStatsManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm6.util.log.Logger;

/* loaded from: classes3.dex */
public class NewTrafficStatisticsImpl implements ITrafficStatistics {
    private static final long FOREVER_TIMESTAMP = 4611686018427387903L;
    private static final long ONE_SECOND_IN_MILLS = 1000;
    private static final String TAG = "NewTrafficStatisticsImp";
    private volatile long[] mMobileNetInfo;
    private NetworkStatsManager mNetworkStatsManager;
    private volatile long[] mWifiNetInfo;
    private boolean initialized = false;
    private volatile long mWifiBackBytes = 0;
    private volatile long mMobileBackBytes = 0;
    private volatile long mWifiFrontBytes = 0;
    private volatile long mMobileFrontBytes = 0;
    private volatile long mWifiBackPackets = 0;
    private volatile long mMobileBackPackets = 0;
    private volatile long mWifiFrontPackets = 0;
    private volatile long mMobileFrontPackets = 0;
    private volatile long mLastCheckTs = -1;
    private volatile boolean mIsFront = true;
    private int sUid = -1;

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public void init() {
        if (AsyncEventManager.getInstance().inWorkThread()) {
            initTrafficData();
        } else {
            AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.perf.traffic.NewTrafficStatisticsImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    NewTrafficStatisticsImpl.this.initTrafficData();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initTrafficData() {
        if (this.initialized) {
            return;
        }
        this.initialized = true;
        this.mWifiNetInfo = getPeriodNetBytesFromNetworkStatsManager(0L, 4611686018427387903L, 1);
        this.mMobileNetInfo = getPeriodNetBytesFromNetworkStatsManager(0L, 4611686018427387903L, 0);
        this.mLastCheckTs = SystemClock.elapsedRealtime();
        if (ApmContext.isDebugMode()) {
            Logger.d(TAG, "initTrafficData: mTotalWifiBytes:" + this.mWifiNetInfo[0] + " mTotalWifiPackets:" + this.mWifiNetInfo[1] + " mTotalMobileBytes:" + this.mMobileNetInfo[0] + " mTotalMobilePackets:" + this.mMobileNetInfo[1]);
        }
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public long getMobileBytes() {
        updateNetData();
        return this.mMobileBackBytes + this.mMobileFrontBytes;
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public long getWifiBytes() {
        updateNetData();
        return this.mWifiBackBytes + this.mWifiFrontBytes;
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public long getBackBytes() {
        updateNetData();
        return this.mMobileBackBytes + this.mWifiBackBytes;
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public long getBackPackets() {
        updateNetData();
        return this.mMobileBackPackets + this.mWifiBackPackets;
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public long getFrontBytes() {
        updateNetData();
        return this.mMobileFrontBytes + this.mWifiFrontBytes;
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public long getFrontPackets() {
        updateNetData();
        return this.mMobileFrontPackets + this.mWifiFrontPackets;
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public long getMobileFrontBytes() {
        updateNetData();
        return this.mMobileFrontBytes;
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public long getMobileBackBytes() {
        updateNetData();
        return this.mMobileBackBytes;
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public long getWifiFrontBytes() {
        updateNetData();
        return this.mWifiFrontBytes;
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public long getWifiBackBytes() {
        updateNetData();
        return this.mWifiBackBytes;
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public long getTotalBytes() {
        return getMobileBytes() + getWifiBytes();
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public void onStatusChange(final boolean z) {
        AsyncEventManager.getInstance().forcePost(new Runnable() { // from class: com.bytedance.apm.perf.traffic.NewTrafficStatisticsImpl.2
            @Override // java.lang.Runnable
            public void run() {
                NewTrafficStatisticsImpl.this.updateNetData();
                NewTrafficStatisticsImpl.this.mIsFront = !z;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateNetData() {
        long j;
        String str;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - this.mLastCheckTs < 1000 || this.mLastCheckTs == -1) {
            return;
        }
        long[] periodNetBytesFromNetworkStatsManager = getPeriodNetBytesFromNetworkStatsManager(0L, 4611686018427387903L, 1);
        long[] periodNetBytesFromNetworkStatsManager2 = getPeriodNetBytesFromNetworkStatsManager(0L, 4611686018427387903L, 0);
        long j2 = periodNetBytesFromNetworkStatsManager2[0] - this.mMobileNetInfo[0];
        long j3 = periodNetBytesFromNetworkStatsManager2[1] - this.mMobileNetInfo[1];
        this.mMobileNetInfo = periodNetBytesFromNetworkStatsManager2;
        long j4 = periodNetBytesFromNetworkStatsManager[0] - this.mWifiNetInfo[0];
        long j5 = periodNetBytesFromNetworkStatsManager[1] - this.mWifiNetInfo[1];
        this.mWifiNetInfo = periodNetBytesFromNetworkStatsManager;
        if (ApmContext.isDebugMode()) {
            j = j2;
            String str2 = "mTotalWifiBytes:" + this.mWifiNetInfo[0] + " mTotalWifiPackets:" + this.mWifiNetInfo[1] + " mTotalMobileBytes:" + this.mMobileNetInfo[0] + " mTotalMobilePackets:" + this.mMobileNetInfo[1];
            str = TAG;
            Logger.d(str, str2);
        } else {
            j = j2;
            str = TAG;
        }
        if (this.mIsFront) {
            this.mMobileFrontBytes += j;
            this.mMobileFrontPackets += j3;
            this.mWifiFrontBytes += j4;
            this.mWifiFrontPackets += j5;
        } else {
            this.mMobileBackBytes += j;
            this.mMobileBackPackets += j3;
            this.mWifiBackBytes += j4;
            this.mWifiBackPackets += j5;
        }
        if (ApmContext.isDebugMode()) {
            Logger.d(str, "periodWifiBytes" + j4 + " periodMobileBytes:" + j + " mMobileBackBytes:" + this.mMobileBackBytes + " mWifiBackBytes:" + this.mWifiBackBytes);
        }
        this.mLastCheckTs = elapsedRealtime;
    }

    private long[] getPeriodNetBytesFromNetworkStatsManager(long j, long j2, int i) {
        NetworkStats networkStats;
        Context context = ApmContext.getContext();
        if (this.mNetworkStatsManager == null) {
            this.mNetworkStatsManager = (NetworkStatsManager) context.getApplicationContext().getSystemService("netstats");
        }
        if (this.mNetworkStatsManager == null) {
            return new long[]{0, 0};
        }
        NetworkStats.Bucket bucket = new NetworkStats.Bucket();
        long j3 = 0;
        try {
            networkStats = this.mNetworkStatsManager.querySummary(i, null, j, j2);
        } catch (Exception e) {
            e.printStackTrace();
            networkStats = null;
        }
        long j4 = 0;
        long j5 = 0;
        long j6 = 0;
        while (networkStats != null && networkStats.hasNextBucket()) {
            networkStats.getNextBucket(bucket);
            if (getAppUid(context) == bucket.getUid()) {
                j3 += bucket.getRxBytes();
                j4 += bucket.getTxBytes();
                j5 += bucket.getRxPackets();
                j6 += bucket.getTxPackets();
            }
        }
        if (networkStats != null) {
            networkStats.close();
        }
        return new long[]{j3 + j4, j5 + j6};
    }

    private int getAppUid(Context context) {
        if (this.sUid == -1) {
            try {
                PackageInfo packageInfo = context.getApplicationContext().getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 128);
                if (packageInfo != null) {
                    this.sUid = packageInfo.applicationInfo.uid;
                }
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        return this.sUid;
    }
}
