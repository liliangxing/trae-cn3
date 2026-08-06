package com.ss.android.common.applog;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.common.utility.CommonHttpException;
import com.bytedance.common.utility.StringUtils;
import com.ss.android.common.util.TLog;
import com.ss.android.deviceregister.base.AppLogConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DisasterRecovery {
    private static final int LIMIT_MAX_TIMES = 12;
    private static final int SEND_LOG_INTERVAL_MINUTE_DEFAULT = 2;
    private Context mContext;
    private NewDowngradeStrategy mNewDowngradeStrategy = new NewDowngradeStrategy();
    private RatioDowngradeStrategy mRatioDowngradeStrategy = new RatioDowngradeStrategy();

    public DisasterRecovery(Context context) {
        this.mContext = context;
    }

    public void registerUrl(String str) {
        this.mNewDowngradeStrategy.registerUrl(str);
    }

    public boolean isCanSend(String str) {
        return this.mNewDowngradeStrategy.isCanSend(str);
    }

    public void handleException(int i, String[] strArr, Throwable th) {
        this.mNewDowngradeStrategy.handleException(i, strArr, th);
    }

    public void handleSuccess(int i, String[] strArr) {
        this.mNewDowngradeStrategy.handleSuccess(i, strArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class NewDowngradeStrategy {
        private static final long MAX_INTERVAL_DOWN_GRADE = 10800000;
        private static final long MAX_INTERVAL_UP_GRADE = 1800000;
        private final long[][] TABLE_INTERVAL_COUNT;
        private Map<String, DowngradeRecord> mDowngradeMap;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
        public class DowngradeRecord {
            int mContinueSuccSendCount;
            int mHasSendCount;
            long mLastGradeChangeTime;
            long mLastSendTime;
            int mTableIndex;

            DowngradeRecord() {
            }

            void copyMemberValue(DowngradeRecord downgradeRecord) {
                this.mTableIndex = downgradeRecord.mTableIndex;
                this.mHasSendCount = downgradeRecord.mHasSendCount;
                this.mContinueSuccSendCount = downgradeRecord.mContinueSuccSendCount;
                this.mLastSendTime = downgradeRecord.mLastSendTime;
                this.mLastGradeChangeTime = downgradeRecord.mLastGradeChangeTime;
            }
        }

        private NewDowngradeStrategy() {
            this.TABLE_INTERVAL_COUNT = new long[][]{new long[]{120000, 0, 12}, new long[]{120000, 5, 1}, new long[]{240000, 5, 1}, new long[]{480000, 4, 1}, new long[]{960000, 2, 1}};
            this.mDowngradeMap = new HashMap();
        }

        public synchronized void registerUrl(String str) {
            if (!StringUtils.isEmpty(str) && !this.mDowngradeMap.containsKey(str)) {
                DowngradeRecord downgradeRecord = new DowngradeRecord();
                SharedPreferences sharedPreferences = DisasterRecovery.this.mContext.getSharedPreferences(AppLogConstants.getSPName(), 0);
                if (System.currentTimeMillis() - sharedPreferences.getLong(str + "_downgrade_time", 0L) < MAX_INTERVAL_DOWN_GRADE) {
                    downgradeRecord.mTableIndex = sharedPreferences.getInt(str + "_downgrade_index", 0);
                } else {
                    sharedPreferences.edit().remove(str + "_downgrade_time").remove(str + "_downgrade_index").commit();
                }
                this.mDowngradeMap.put(str, downgradeRecord);
            }
        }

        public synchronized boolean isCanSend(String str) {
            if (!StringUtils.isEmpty(str) && this.mDowngradeMap.containsKey(str)) {
                DowngradeRecord downgradeRecord = this.mDowngradeMap.get(str);
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - downgradeRecord.mLastSendTime >= this.TABLE_INTERVAL_COUNT[downgradeRecord.mTableIndex][0]) {
                    downgradeRecord.mHasSendCount = 1;
                    downgradeRecord.mLastSendTime = currentTimeMillis;
                } else {
                    if (downgradeRecord.mHasSendCount >= this.TABLE_INTERVAL_COUNT[downgradeRecord.mTableIndex][2]) {
                        return false;
                    }
                    downgradeRecord.mHasSendCount++;
                }
            }
            return true;
        }

        public synchronized void handleException(int i, String[] strArr, Throwable th) {
            int responseCode;
            if ((th instanceof CommonHttpException) && (responseCode = ((CommonHttpException) th).getResponseCode()) >= 500 && responseCode < 600) {
                String str = strArr[i];
                if (!StringUtils.isEmpty(str) && this.mDowngradeMap.containsKey(str)) {
                    DowngradeRecord downgradeRecord = this.mDowngradeMap.get(str);
                    if (downgradeRecord.mTableIndex < this.TABLE_INTERVAL_COUNT.length - 1) {
                        downgradeRecord.mTableIndex++;
                        downgradeRecord.mHasSendCount = 1;
                        downgradeRecord.mContinueSuccSendCount = 0;
                        long currentTimeMillis = System.currentTimeMillis();
                        downgradeRecord.mLastSendTime = currentTimeMillis;
                        downgradeRecord.mLastGradeChangeTime = currentTimeMillis;
                        SharedPreferences.Editor edit = DisasterRecovery.this.mContext.getSharedPreferences(AppLogConstants.getSPName(), 0).edit();
                        for (String str2 : strArr) {
                            if (!StringUtils.isEmpty(str2) && !str2.equals(str) && this.mDowngradeMap.containsKey(str2)) {
                                DowngradeRecord downgradeRecord2 = this.mDowngradeMap.get(str2);
                                downgradeRecord2.copyMemberValue(downgradeRecord);
                                edit.putLong(str2 + "_downgrade_time", currentTimeMillis);
                                edit.putInt(str2 + "_downgrade_index", downgradeRecord2.mTableIndex);
                            }
                        }
                        edit.putLong(str + "_downgrade_time", currentTimeMillis);
                        edit.putInt(str + "_downgrade_index", downgradeRecord.mTableIndex);
                        edit.commit();
                    } else {
                        downgradeRecord.mContinueSuccSendCount = 0;
                    }
                }
            }
        }

        public synchronized void handleSuccess(int i, String[] strArr) {
            String str = strArr[i];
            if (!StringUtils.isEmpty(str) && this.mDowngradeMap.containsKey(str)) {
                DowngradeRecord downgradeRecord = this.mDowngradeMap.get(str);
                long currentTimeMillis = System.currentTimeMillis();
                if (downgradeRecord.mContinueSuccSendCount < this.TABLE_INTERVAL_COUNT[downgradeRecord.mTableIndex][1] && currentTimeMillis - downgradeRecord.mLastGradeChangeTime <= MAX_INTERVAL_UP_GRADE) {
                    downgradeRecord.mContinueSuccSendCount++;
                }
                if (downgradeRecord.mTableIndex > 0) {
                    downgradeRecord.mTableIndex--;
                    downgradeRecord.mHasSendCount = 1;
                    downgradeRecord.mContinueSuccSendCount = 1;
                    downgradeRecord.mLastSendTime = currentTimeMillis;
                    downgradeRecord.mLastGradeChangeTime = currentTimeMillis;
                    SharedPreferences.Editor edit = DisasterRecovery.this.mContext.getSharedPreferences(AppLogConstants.getSPName(), 0).edit();
                    for (String str2 : strArr) {
                        if (!StringUtils.isEmpty(str2) && !str2.equals(str) && this.mDowngradeMap.containsKey(str2)) {
                            DowngradeRecord downgradeRecord2 = this.mDowngradeMap.get(str2);
                            downgradeRecord2.copyMemberValue(downgradeRecord);
                            edit.putLong(str2 + "_downgrade_time", currentTimeMillis);
                            edit.putInt(str2 + "_downgrade_index", downgradeRecord2.mTableIndex);
                        }
                    }
                    edit.putLong(str + "_downgrade_time", currentTimeMillis);
                    edit.putInt(str + "_downgrade_index", downgradeRecord.mTableIndex);
                    edit.commit();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateRatioDowngradeParams(JSONObject jSONObject) {
        RatioDowngradeStrategy ratioDowngradeStrategy = this.mRatioDowngradeStrategy;
        if (ratioDowngradeStrategy != null) {
            ratioDowngradeStrategy.updateRatioDowngradeParams(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int checkRatioDowngrade(long j) {
        RatioDowngradeStrategy ratioDowngradeStrategy = this.mRatioDowngradeStrategy;
        if (ratioDowngradeStrategy != null) {
            return ratioDowngradeStrategy.checkRatioDowngrade(j);
        }
        return 0;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class RatioDowngradeStrategy {
        private static final int BACK_OFF_DENOMINATOR = 10000;
        private static final String KEY_BACK_OFF_RATIO = "backoff_ratio";
        private static final String KEY_MAX_REQUEST_FREQUENCY = "max_request_frequency";
        private static final int MAX_REQUEST_FREQUENCY_DEFAULT = 6;
        private static final int MIN_REQUEST_FREQUENCY_DEFAULT = 1;
        private static final String TAG = "RatioDowngradeStrategy";
        private int mBackoffRatio = 0;
        private int mMaxRequestFrequency = 6;
        private long mBackoffWindowStartTime = 0;
        private int mBackoffWindowSendCount = 0;

        public RatioDowngradeStrategy() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateRatioDowngradeParams(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            int optInt = jSONObject.optInt(KEY_BACK_OFF_RATIO, 0);
            this.mBackoffRatio = optInt;
            if (optInt < 0 || optInt > 10000) {
                this.mBackoffRatio = 0;
            }
            int i = this.mBackoffRatio > 0 ? 1 : 6;
            int optInt2 = jSONObject.optInt(KEY_MAX_REQUEST_FREQUENCY, i);
            this.mMaxRequestFrequency = optInt2;
            if (optInt2 < 1 || optInt2 > 6) {
                this.mMaxRequestFrequency = i;
            }
            int i2 = this.mBackoffRatio;
            if (i2 > 0 && this.mBackoffWindowStartTime == 0) {
                this.mBackoffWindowStartTime = System.currentTimeMillis();
                this.mBackoffWindowSendCount = 1;
            } else if (i2 == 0) {
                this.mBackoffWindowStartTime = 0L;
                this.mBackoffWindowSendCount = 0;
            }
            TLog.m81w("RatioDowngradeStrategy updateRatioDowngradeParams mBackoffRatio: " + this.mBackoffRatio + ", mMaxRequestFrequency: " + this.mMaxRequestFrequency + ", mBackoffWindowStartTime: " + this.mBackoffWindowStartTime + ", mBackoffWindowSendCount: " + this.mBackoffWindowSendCount);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int checkRatioDowngrade(long j) {
            if (this.mBackoffRatio > 0) {
                if (!AppLog.checkValidInterval(j)) {
                    j = 60000;
                }
                long currentTimeMillis = System.currentTimeMillis();
                long j2 = this.mBackoffWindowStartTime;
                if (currentTimeMillis < j2 + j) {
                    int i = this.mBackoffWindowSendCount;
                    if (i >= this.mMaxRequestFrequency) {
                        return -1;
                    }
                    this.mBackoffWindowSendCount = i + 1;
                } else {
                    this.mBackoffWindowStartTime = j2 + (((currentTimeMillis - j2) / j) * j);
                    this.mBackoffWindowSendCount = 1;
                }
            }
            int i2 = this.mBackoffRatio;
            if (i2 >= 10000) {
                return -1;
            }
            return (i2 <= 0 || i2 >= 10000 || new Random().nextInt(10000) >= this.mBackoffRatio) ? 0 : -1;
        }
    }
}
