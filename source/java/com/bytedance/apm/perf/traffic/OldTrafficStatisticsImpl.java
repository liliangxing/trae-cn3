package com.bytedance.apm.perf.traffic;

import android.os.Process;
import android.text.TextUtils;
import com.bytedance.apm.util.ListUtils;
import com.bytedance.monitor.util.IoUtil;
import com.bytedance.platform.godzilla.common.Constant;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public class OldTrafficStatisticsImpl implements ITrafficStatistics {
    private File mProcFile;
    private List<String> mFileDataList = new CopyOnWriteArrayList();
    private long mLastReadTs = -1;
    private volatile long mWifiBackBytes = 0;
    private volatile long mMobileBackBytes = 0;
    private volatile long mWifiFrontBytes = 0;
    private volatile long mMobileFrontBytes = 0;
    private volatile long mWifiBackPackets = 0;
    private volatile long mMobileBackPackets = 0;
    private volatile long mWifiFrontPackets = 0;
    private volatile long mMobileFrontPackets = 0;

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public void onStatusChange(boolean z) {
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public void init() {
        this.mProcFile = new File("/proc/net/xt_qtaguid/stats");
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public long getMobileBytes() {
        return getMobileBackBytes() + getMobileFrontBytes();
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public long getWifiBytes() {
        return getWifiBackBytes() + getWifiFrontBytes();
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public long getBackBytes() {
        return getMobileBackBytes() + getWifiBackBytes();
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public long getBackPackets() {
        updateNetData();
        return this.mMobileBackPackets + this.mWifiBackPackets;
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public long getFrontBytes() {
        return getMobileFrontBytes() + getWifiFrontBytes();
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

    private void updateNetData() {
        int i;
        long j;
        long j2;
        OldTrafficStatisticsImpl oldTrafficStatisticsImpl = this;
        if (System.currentTimeMillis() - oldTrafficStatisticsImpl.mLastReadTs < 1000) {
            return;
        }
        oldTrafficStatisticsImpl.mLastReadTs = System.currentTimeMillis();
        int myUid = Process.myUid();
        readFile2List();
        if (ListUtils.isEmpty(oldTrafficStatisticsImpl.mFileDataList)) {
            return;
        }
        Iterator<String> it = oldTrafficStatisticsImpl.mFileDataList.iterator();
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        long j6 = 0;
        long j7 = 0;
        long j8 = 0;
        long j9 = 0;
        long j10 = 0;
        while (it.hasNext()) {
            Iterator<String> it2 = it;
            long j11 = j9;
            String[] split = it.next().split(" ");
            try {
            } catch (Exception unused) {
                i = myUid;
                j = j4;
            }
            if (TextUtils.equals(split[3], "uid_tag_int")) {
                oldTrafficStatisticsImpl = this;
                it = it2;
                j9 = j11;
            } else {
                if (myUid == Integer.parseInt(split[3])) {
                    long parseLong = Long.parseLong(split[5]);
                    long parseLong2 = Long.parseLong(split[6]);
                    long parseLong3 = Long.parseLong(split[7]);
                    long parseLong4 = Long.parseLong(split[8]);
                    i = myUid;
                    if (Long.valueOf(split[4]).longValue() == 1) {
                        j = j4;
                        try {
                            if (split[1].startsWith("rmnet_data")) {
                                j7 += parseLong3 + parseLong;
                                j8 += parseLong4 + parseLong2;
                            } else if (split[1].startsWith("wlan")) {
                                j6 += parseLong3 + parseLong;
                                j3 += parseLong4 + parseLong2;
                            }
                        } catch (Exception unused2) {
                        }
                    } else {
                        j = j4;
                    }
                    if (Long.valueOf(split[4]).longValue() == 0) {
                        if (split[1].startsWith("rmnet_data")) {
                            j5 += parseLong3 + parseLong;
                            j9 = j11 + parseLong4 + parseLong2;
                            j4 = j;
                            oldTrafficStatisticsImpl = this;
                            it = it2;
                            myUid = i;
                        } else {
                            j2 = j11;
                            if (split[1].startsWith("wlan")) {
                                long j12 = j + parseLong3 + parseLong;
                                j10 += parseLong4 + parseLong2;
                                j9 = j2;
                                j4 = j12;
                                oldTrafficStatisticsImpl = this;
                                it = it2;
                                myUid = i;
                            }
                            j9 = j2;
                            j4 = j;
                            oldTrafficStatisticsImpl = this;
                            it = it2;
                            myUid = i;
                        }
                    }
                    j2 = j11;
                    j9 = j2;
                    j4 = j;
                    oldTrafficStatisticsImpl = this;
                    it = it2;
                    myUid = i;
                } else {
                    i = myUid;
                    j = j4;
                }
                j2 = j11;
                j9 = j2;
                j4 = j;
                oldTrafficStatisticsImpl = this;
                it = it2;
                myUid = i;
            }
        }
        oldTrafficStatisticsImpl.mWifiBackBytes = j4;
        oldTrafficStatisticsImpl.mMobileBackBytes = j5;
        oldTrafficStatisticsImpl.mWifiFrontBytes = j6;
        oldTrafficStatisticsImpl.mMobileFrontBytes = j7;
        oldTrafficStatisticsImpl.mWifiBackPackets = j10;
        oldTrafficStatisticsImpl.mMobileBackPackets = j9;
        oldTrafficStatisticsImpl.mWifiFrontPackets = j3;
        oldTrafficStatisticsImpl.mMobileFrontPackets = j8;
    }

    private void readFile2List() {
        BufferedReader bufferedReader;
        Throwable th;
        if (this.mProcFile == null) {
            return;
        }
        try {
            ArrayList arrayList = new ArrayList();
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(this.mProcFile), Constant.CHARSET_UTF_8));
            int i = 1;
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    if (i >= 0) {
                        arrayList.add(readLine);
                    }
                    i++;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        th.printStackTrace();
                    } finally {
                        IoUtil.safeClose(bufferedReader);
                    }
                }
            }
            this.mFileDataList.clear();
            this.mFileDataList.addAll(arrayList);
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }
}
