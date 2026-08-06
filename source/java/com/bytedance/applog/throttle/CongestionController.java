package com.bytedance.applog.throttle;

import com.bytedance.apm.constant.ReportConsts;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.applog.manager.ConfigManager;
import com.bytedance.applog.priority.EventPriorityItem;
import com.bytedance.applog.store.Pack;
import java.lang.reflect.Array;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class CongestionController {
    private static final long MAX_INTERVAL_DOWN_GRADE = 10800000;
    private static final long MAX_INTERVAL_UP_GRADE = 1800000;
    public static final int MAX_REQUEST_FREQUENCY_DEFAULT = 12;
    public static final int MAX_REQUEST_FREQUENCY_OTEHERS = 60;
    public static final int MAX_REQUEST_FREQUENCY_REALTIME = Integer.MAX_VALUE;
    protected static final long[][] TABLE_CONGESTION_DEFAULT = {new long[]{60000, 0, 12}, new long[]{120000, 5, 1}, new long[]{ReportConsts.SHORT_DELAY_FOURTH, 5, 1}, new long[]{480000, 4, 1}, new long[]{960000, 2, 1}};
    private static int defaultMaxFrequency = -1;
    private boolean enabled = true;
    private ConfigManager mConfig;
    private long[][] mCongestionTable;
    private int mContinueSuccSendCount;
    private EventPriorityItem mEventPriorityItem;
    private int mHasSendCount;
    private float mHasSendPackCount;
    private long mLastGradeChangeTime;
    private long mLastSendTime;
    private String mPrefix;
    private int mTableIndex;

    public static void setDefaultMaxFrequency(int i) {
        if (i > 0) {
            defaultMaxFrequency = i;
        }
    }

    public CongestionController(String str, ConfigManager configManager, EventPriorityItem eventPriorityItem) {
        this.mConfig = configManager;
        this.mPrefix = str;
        this.mEventPriorityItem = eventPriorityItem;
        init();
    }

    protected void init() {
        this.mTableIndex = 0;
        if (System.currentTimeMillis() - this.mConfig.getStatSp().getLong(this.mPrefix + "downgrade_time", 0L) < MAX_INTERVAL_DOWN_GRADE) {
            this.mTableIndex = this.mConfig.getStatSp().getInt(this.mPrefix + "downgrade_index", 0);
        } else {
            this.mConfig.getStatSp().edit().remove(this.mPrefix + "downgrade_time").remove(this.mPrefix + "downgrade_index").apply();
        }
        long[][] jArr = TABLE_CONGESTION_DEFAULT;
        this.mCongestionTable = (long[][]) Array.newInstance((Class<?>) Long.TYPE, jArr.length, jArr[0].length);
        int i = 0;
        while (true) {
            long[][] jArr2 = TABLE_CONGESTION_DEFAULT;
            if (i >= jArr2.length) {
                break;
            }
            long[] jArr3 = jArr2[i];
            System.arraycopy(jArr3, 0, this.mCongestionTable[i], 0, jArr3.length);
            i++;
        }
        int i2 = defaultMaxFrequency;
        if (i2 > 0) {
            this.mCongestionTable[0][2] = i2;
        }
        EventPriorityItem eventPriorityItem = this.mEventPriorityItem;
        if (eventPriorityItem == null) {
            return;
        }
        int priority = eventPriorityItem.getPriority();
        if (priority == 0) {
            this.mCongestionTable[0][2] = 2147483647L;
        } else if (-1 != priority) {
            this.mCongestionTable[0][2] = 60;
        }
        long eventInterval = this.mEventPriorityItem.getEventInterval();
        if (eventInterval <= 0) {
            return;
        }
        int i3 = 1;
        while (true) {
            long[][] jArr4 = this.mCongestionTable;
            if (i3 >= jArr4.length) {
                return;
            }
            if (i3 == 1) {
                jArr4[i3][0] = 2 * eventInterval;
            } else {
                jArr4[i3][0] = jArr4[i3 - 1][0] * 2;
            }
            i3++;
        }
    }

    public boolean isCanSend() {
        if (!enable()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.mLastSendTime;
        long[] jArr = this.mCongestionTable[this.mTableIndex];
        if (j >= jArr[0]) {
            this.mHasSendCount = 1;
            this.mLastSendTime = currentTimeMillis;
        } else {
            int i = this.mHasSendCount;
            if (i < jArr[2]) {
                this.mHasSendCount = i + 1;
            } else {
                LoggerImpl.global().warn("Congestion forbidden send by mTableIndex={}, mLastSendTime={}, mHasSendCount={}", Integer.valueOf(this.mTableIndex), Long.valueOf(this.mLastSendTime), Integer.valueOf(this.mHasSendCount));
                return false;
            }
        }
        return true;
    }

    public boolean isCanSend(Pack pack) {
        if (!enable() || pack == null) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        int totalEventCount = pack.getTotalEventCount() > 0 ? pack.getTotalEventCount() : 200;
        float f = totalEventCount >= 200 ? 1.0f : totalEventCount / 200.0f;
        long j = currentTimeMillis - this.mLastSendTime;
        long[] jArr = this.mCongestionTable[this.mTableIndex];
        if (j >= jArr[0]) {
            this.mHasSendPackCount = f;
            this.mLastSendTime = currentTimeMillis;
        } else {
            float f2 = this.mHasSendPackCount;
            if (f2 < ((float) jArr[2])) {
                this.mHasSendPackCount = f2 + f;
            } else {
                LoggerImpl.global().warn("Congestion forbidden send by mTableIndex={}, mLastSendTime={}, mHasSendCount={}", Integer.valueOf(this.mTableIndex), Long.valueOf(this.mLastSendTime), Float.valueOf(this.mHasSendPackCount));
                return false;
            }
        }
        return true;
    }

    public void handleException() {
        if (enable()) {
            if (this.mTableIndex < this.mCongestionTable.length - 1) {
                downgrade();
            } else {
                this.mContinueSuccSendCount = 0;
            }
        }
    }

    public void handleSuccess() {
        if (enable()) {
            long currentTimeMillis = System.currentTimeMillis();
            int i = this.mContinueSuccSendCount;
            long j = i;
            long[][] jArr = this.mCongestionTable;
            int i2 = this.mTableIndex;
            if (j < jArr[i2][1] && currentTimeMillis - this.mLastGradeChangeTime <= 1800000) {
                this.mContinueSuccSendCount = i + 1;
            } else if (i2 > 0) {
                upgrade();
            }
        }
    }

    private void upgrade() {
        long currentTimeMillis = System.currentTimeMillis();
        this.mTableIndex--;
        this.mHasSendCount = 1;
        this.mHasSendPackCount = 1.0f;
        this.mContinueSuccSendCount = 1;
        this.mLastSendTime = currentTimeMillis;
        this.mLastGradeChangeTime = currentTimeMillis;
        this.mConfig.getStatSp().edit().putLong(this.mPrefix + "downgrade_time", currentTimeMillis).putInt(this.mPrefix + "downgrade_index", this.mTableIndex).apply();
    }

    private void downgrade() {
        long currentTimeMillis = System.currentTimeMillis();
        this.mTableIndex++;
        this.mHasSendCount = 1;
        this.mHasSendPackCount = 1.0f;
        this.mContinueSuccSendCount = 0;
        this.mLastSendTime = currentTimeMillis;
        this.mLastGradeChangeTime = currentTimeMillis;
        this.mConfig.getStatSp().edit().putLong(this.mPrefix + "downgrade_time", currentTimeMillis).putInt(this.mPrefix + "downgrade_index", this.mTableIndex).apply();
    }

    private boolean enable() {
        return this.enabled && this.mConfig.getInitConfig().isCongestionControlEnable();
    }

    public void updateMaxRequestFrequency(int i) {
        this.mCongestionTable[0][2] = i;
    }

    public void setEnable(boolean z) {
        this.enabled = z;
    }

    public String toString() {
        return "mPrefix=" + this.mPrefix + ", mTableIndex=" + this.mTableIndex + ", mHasSendCount=" + this.mHasSendCount + ", mHasSendPackCount=" + this.mHasSendPackCount + ", mContinueSuccSendCount=" + this.mContinueSuccSendCount + ", mLastSendTime=" + this.mLastSendTime;
    }
}
