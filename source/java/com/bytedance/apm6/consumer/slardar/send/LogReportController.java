package com.bytedance.apm6.consumer.slardar.send;

import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.consumer.slardar.config.SlardarHandlerConfig;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.util.ListUtils;
import com.bytedance.apm6.util.log.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes3.dex */
public class LogReportController {
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
    private SlardarHandlerConfig config;
    private volatile int delayTime;
    private List<String> exceptionUrlList;
    private volatile int netFailCount;
    private List<String> reportUrlList;
    private volatile int shortFailCount;
    private volatile int shortStopInterval;
    private AtomicLong startDropDataTime;
    private volatile boolean stopCollect;
    private AtomicLong stopCollectLogTime;
    private volatile int stopInterval;
    private List<String> traceUrlList;

    private LogReportController() {
        this.shortFailCount = 0;
        this.collectLogSwitch = true;
        this.reportUrlList = new ArrayList();
        this.traceUrlList = new ArrayList();
        this.exceptionUrlList = new ArrayList();
        this.stopCollectLogTime = new AtomicLong(0L);
        this.startDropDataTime = new AtomicLong();
    }

    public static LogReportController getInstance() {
        return InnerHolder.instance;
    }

    public void updateConfig(SlardarHandlerConfig slardarHandlerConfig) {
        this.config = slardarHandlerConfig;
    }

    public void setDefaultReportUrlList(List<String> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.reportUrlList.clear();
        this.reportUrlList.addAll(list);
    }

    public void setDefaultExceptionUrlList(List<String> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.exceptionUrlList.clear();
        this.exceptionUrlList.addAll(list);
    }

    public void setTraceReportUrlList(List<String> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.traceUrlList.clear();
        this.traceUrlList.addAll(list);
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
        if (ApmContext.isDebugMode()) {
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
        if (ApmContext.isDebugMode()) {
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
        SlardarHandlerConfig slardarHandlerConfig = this.config;
        if (slardarHandlerConfig != null && !ListUtils.isEmpty(slardarHandlerConfig.getReportUrlList())) {
            return this.config.getReportUrlList();
        }
        return this.reportUrlList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<String> getTraceUrlList() {
        SlardarHandlerConfig slardarHandlerConfig = this.config;
        if (slardarHandlerConfig != null && !ListUtils.isEmpty(slardarHandlerConfig.getTraceReportUrl())) {
            return this.config.getTraceReportUrl();
        }
        return this.traceUrlList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<String> getExceptionUrlList() {
        SlardarHandlerConfig slardarHandlerConfig = this.config;
        if (slardarHandlerConfig != null && !ListUtils.isEmpty(slardarHandlerConfig.getExceptionUrl())) {
            return this.config.getExceptionUrl();
        }
        return this.exceptionUrlList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isEncrypt() {
        SlardarHandlerConfig slardarHandlerConfig = this.config;
        if (slardarHandlerConfig != null) {
            return slardarHandlerConfig.isEncrypt();
        }
        return true;
    }

    /* loaded from: classes3.dex */
    static class InnerHolder {
        static LogReportController instance = new LogReportController();

        InnerHolder() {
        }
    }
}
