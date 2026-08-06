package com.bytedance.framwork.core.sdklib.apm6;

import com.bytedance.apm6.util.ListUtils;
import com.bytedance.apm6.util.constant.ReportConsts;
import com.bytedance.framwork.core.sdklib.apm6.safety.Logger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes2.dex */
public class LogReportController {
    public static final String COLLECT_PATH = "/monitor/collect/batch/";
    private static final long FIVE_MINUTES = 300000;
    private static final int LAST_STOP_INTERVAL = 1800000;
    private static final int MINUTE_IN_MILLIS = 60000;
    private static final long[] RETRY_INTERVALS = {120000, 300000, 600000, 1800000, 3600000};
    private static final int SECOND_IN_MILLIS = 1000;
    private static final int SECOND_STOP_INTERVAL = 300000;
    private static final int SHORT_BASE_DELAY = 15;
    private static final int SHORT_DELAY_FIFTH = 300000;
    private static final int SHORT_DELAY_FIRST = 30000;
    private static final int SHORT_DELAY_FOURTH = 240000;
    private static final int SHORT_DELAY_SECOND = 60000;
    private static final int SHORT_DELAY_THIRD = 120000;
    private static final long SIXTY_MINUTES = 3600000;
    private static final long TEN_MINUTES = 600000;
    private static final int THIRD_STOP_INTERVAL = 900000;
    private static final long THIRTY_MINUTES = 1800000;
    private static final long TWO_MINUTES = 120000;
    private volatile boolean collectLogSwitch;
    private volatile int delayTime;
    private final ConcurrentHashMap<String, Boolean> encryptMap;
    private volatile boolean isEncrypt;
    private volatile int netFailCount;
    private List<String> reportUrlList;
    private volatile int shortFailCount;
    private volatile int shortStopInterval;
    private AtomicLong startDropDataTime;
    private volatile boolean stopCollect;
    private AtomicLong stopCollectLogTime;
    private volatile int stopInterval;

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getMaxRetryCount() {
        return 5L;
    }

    private LogReportController() {
        this.shortFailCount = 0;
        this.collectLogSwitch = true;
        this.encryptMap = new ConcurrentHashMap<>();
        this.isEncrypt = true;
        this.stopCollectLogTime = new AtomicLong(0L);
        this.startDropDataTime = new AtomicLong();
    }

    public static LogReportController getInstance() {
        return InnerHolder.instance;
    }

    public void setReportUrlList(String str, List<String> list) {
        if (ListUtils.isEmpty(list) || !ListUtils.isEmpty(this.reportUrlList)) {
            return;
        }
        this.reportUrlList = convertReportUrl(list);
    }

    public void setEncrypt(String str, boolean z) {
        boolean z2;
        this.encryptMap.put(str, Boolean.valueOf(z));
        Iterator<Boolean> it = this.encryptMap.values().iterator();
        while (true) {
            if (!it.hasNext()) {
                z2 = false;
                break;
            } else if (it.next().booleanValue()) {
                z2 = true;
                break;
            }
        }
        this.isEncrypt = z2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void longBackOff() {
        if (this.netFailCount == 0) {
            this.netFailCount = 1;
            this.stopInterval = 300000;
        } else if (this.netFailCount == 1) {
            this.netFailCount = 2;
            this.stopInterval = 900000;
        } else if (this.netFailCount == 2) {
            this.netFailCount = 3;
            this.stopInterval = 1800000;
        } else {
            this.netFailCount = 4;
            this.stopInterval = 1800000;
        }
        if (SDKContext.isDebugMode()) {
            Logger.d(Constants.TAG, "longBackOff:" + this.stopInterval + " netFailCount:" + this.netFailCount);
        }
        setCollectDelay();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void shortBackOff() {
        if (this.shortFailCount == 0) {
            this.shortFailCount = 1;
            this.shortStopInterval = 30000;
        } else if (this.shortFailCount == 1) {
            this.shortFailCount = 2;
            this.shortStopInterval = 60000;
        } else if (this.shortFailCount == 2) {
            this.shortFailCount = 3;
            this.shortStopInterval = SHORT_DELAY_THIRD;
        } else if (this.shortFailCount == 3) {
            this.shortFailCount = 4;
            this.shortStopInterval = SHORT_DELAY_FOURTH;
        } else {
            this.shortFailCount = 5;
            this.shortStopInterval = 300000;
        }
        if (SDKContext.isDebugMode()) {
            Logger.d(Constants.TAG, "shortStopInterval:" + this.shortStopInterval + " shortFailCount:" + this.shortFailCount);
        }
        setCollectDelay();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getRetryInterval(int i) {
        int i2 = i - 1;
        if (i2 < 0) {
            return 0L;
        }
        long[] jArr = RETRY_INTERVALS;
        if (i2 >= jArr.length) {
            return jArr[jArr.length - 1];
        }
        return jArr[i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void restore() {
        this.collectLogSwitch = true;
        this.stopCollect = false;
        this.netFailCount = 0;
        this.stopInterval = 0;
        this.shortFailCount = 0;
        this.shortStopInterval = 0;
        this.delayTime = 0;
        this.startDropDataTime.set(0L);
        this.stopCollectLogTime.set(0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isReportLogEnable() {
        return this.collectLogSwitch || System.currentTimeMillis() - this.stopCollectLogTime.get() > getDelayTime();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dropData() {
        longBackOff();
        this.stopCollect = true;
        this.startDropDataTime.set(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void recoveryFromDropData() {
        this.stopCollect = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isStopCollect() {
        if (this.stopCollect) {
            return System.currentTimeMillis() - this.startDropDataTime.get() <= getDelayTime();
        }
        return this.stopCollect;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void delayReport(long j) {
        this.delayTime = (int) (j * 1000);
        setCollectDelay();
    }

    private void setCollectDelay() {
        this.collectLogSwitch = false;
        this.stopCollectLogTime.set(System.currentTimeMillis());
    }

    private long getDelayTime() {
        long j = this.stopInterval > this.shortStopInterval ? this.stopInterval : this.shortStopInterval;
        return j > ((long) this.delayTime) ? j : this.delayTime;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<String> getReportList() {
        if (ListUtils.isEmpty(this.reportUrlList)) {
            return ReportConsts.DEFAULT_LOG_REPORT;
        }
        return this.reportUrlList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isEncrypt() {
        return this.isEncrypt;
    }

    private static List<String> convertReportUrl(List<String> list) {
        LinkedList linkedList = new LinkedList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            try {
                linkedList.add(("https://" + new URL(it.next()).getHost()) + "/monitor/collect/batch/");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return linkedList;
    }

    /* loaded from: classes2.dex */
    static class InnerHolder {
        static LogReportController instance = new LogReportController();

        InnerHolder() {
        }
    }
}
