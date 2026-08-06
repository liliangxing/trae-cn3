package com.ss.android.socialbase.downloader.downloader;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class NetworkRetryStrategy {
    private static final String TAG = "NetworkRetryStrategy";
    private int mCurrentRetryCount = 0;
    private int mCurrentPeriodRetryCount = 0;
    private long mCurrentRetryTime = 0;
    private int mCurrentRetryResetCount = 0;
    private int mRetryCountLimit = 0;
    private int mPeriodRetryCountLimit = 0;
    private long mRetryPeriodTime = 0;
    private int mRetryResetCountLimit = 0;
    private int mTotalRetryCount = 0;
    private boolean mEnabled = false;
    private List<Long> delayIntervalMs = new ArrayList();
    private int mDownloadId = 0;

    public NetworkRetryStrategy(DownloadInfo downloadInfo) {
        StringBuilder sb;
        try {
            initInternal(downloadInfo);
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                Logger.taskError(TAG, this.mDownloadId, TAG, "Init Error" + th.toString());
                if (!Logger.debugScene(downloadInfo)) {
                    return;
                } else {
                    sb = new StringBuilder("Init retryCountLimit:");
                }
            } catch (Throwable th2) {
                if (Logger.debugScene(downloadInfo)) {
                    Logger.taskDebug(TAG, downloadInfo, TAG, "Init retryCountLimit:" + this.mRetryCountLimit + " delayIntervalMs:" + this.delayIntervalMs.toString() + " retryPeriodTime:" + this.mRetryPeriodTime + " periodRetryCountLimit:" + this.mPeriodRetryCountLimit + " retryResetCountLimit:" + this.mRetryResetCountLimit);
                }
                throw th2;
            }
        }
        if (Logger.debugScene(downloadInfo)) {
            sb = new StringBuilder("Init retryCountLimit:");
            Logger.taskDebug(TAG, downloadInfo, TAG, sb.append(this.mRetryCountLimit).append(" delayIntervalMs:").append(this.delayIntervalMs.toString()).append(" retryPeriodTime:").append(this.mRetryPeriodTime).append(" periodRetryCountLimit:").append(this.mPeriodRetryCountLimit).append(" retryResetCountLimit:").append(this.mRetryResetCountLimit).toString());
        }
    }

    private void initInternal(DownloadInfo downloadInfo) throws Throwable {
        JSONObject optJSONObject;
        if (downloadInfo != null) {
            int id = downloadInfo.getId();
            this.mDownloadId = id;
            optJSONObject = DownloadSetting.obtain(id).optJSONObject(DownloadSettingKeys.RETRY_STRATEGY);
        } else {
            optJSONObject = DownloadSetting.obtainGlobal().optJSONObject(DownloadSettingKeys.RETRY_STRATEGY);
        }
        if (optJSONObject == null) {
            return;
        }
        int optInt = optJSONObject.optInt("retry_count");
        if (optInt > 0) {
            this.mRetryCountLimit = optInt;
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray(DownloadSettingKeys.RetryStrategy.KEY_DELAY_INTERVAL_MS);
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                long optLong = optJSONArray.optLong(i);
                if (optLong > 0) {
                    this.delayIntervalMs.add(Long.valueOf(optLong));
                }
            }
        }
        long optLong2 = optJSONObject.optLong(DownloadSettingKeys.RetryStrategy.KEY_RETRY_PERIOD_MS);
        if (optLong2 > 0) {
            this.mRetryPeriodTime = optLong2;
        }
        int optInt2 = optJSONObject.optInt(DownloadSettingKeys.RetryStrategy.KEY_RETRY_COUNT_LIMIT_PERIOD);
        if (optInt2 > 0) {
            this.mPeriodRetryCountLimit = optInt2;
        }
        int optInt3 = optJSONObject.optInt(DownloadSettingKeys.RetryStrategy.KEY_RETRY_RESET_COUNT_LIMIT);
        if (optInt3 > 0) {
            this.mRetryResetCountLimit = optInt3;
        }
        if (this.mRetryCountLimit <= 0 || this.mRetryResetCountLimit <= 0) {
            return;
        }
        this.mEnabled = true;
    }

    public void reset() {
        if (resetLimit()) {
            this.mEnabled = false;
            return;
        }
        if (Logger.debug()) {
            Logger.taskDebug(TAG, this.mDownloadId, "reset", "Reset currentRetryResetCount");
        }
        this.mCurrentRetryResetCount++;
        this.mCurrentRetryCount = 0;
    }

    public boolean canRetry(BaseException baseException) {
        if (baseException == null || !this.mEnabled) {
            if (Logger.debug()) {
                Logger.taskDebug(TAG, this.mDownloadId, "canRetry", "Enabled: " + this.mEnabled);
            }
            return false;
        }
        if (Logger.debug()) {
            Logger.taskDebug(TAG, this.mDownloadId, "canRetry", "CurrentRetryCount:" + this.mCurrentRetryCount + " retryCountLimit:" + this.mRetryCountLimit + " error:" + baseException.getErrorCode());
        }
        if (!retryLimit()) {
            return this.mCurrentRetryCount < this.mRetryCountLimit && DownloadUtils.isNetworkError(baseException);
        }
        this.mEnabled = false;
        return false;
    }

    public void doRetry() {
        if (this.mEnabled) {
            delay();
            this.mCurrentRetryCount++;
            this.mCurrentPeriodRetryCount++;
            this.mTotalRetryCount++;
            if (Logger.debug()) {
                Logger.taskDebug(TAG, this.mDownloadId, "doRetry", "CurrentRetryCount:" + this.mCurrentRetryCount + " currentPeriodRetryCount:" + this.mCurrentPeriodRetryCount + " totalRetryCount:" + this.mTotalRetryCount);
            }
        }
    }

    private void delay() {
        long longValue;
        if (this.delayIntervalMs.isEmpty()) {
            return;
        }
        try {
            if (this.mCurrentRetryCount >= this.delayIntervalMs.size()) {
                longValue = this.delayIntervalMs.get(r3.size() - 1).longValue();
            } else {
                longValue = this.delayIntervalMs.get(this.mCurrentRetryCount).longValue();
            }
            if (Logger.debug()) {
                Logger.taskDebug(TAG, this.mDownloadId, "delay", "Sleep:" + longValue);
            }
            Thread.sleep(longValue);
        } catch (Throwable th) {
            Logger.taskError(TAG, this.mDownloadId, "delay", "Error:" + th.toString());
            th.printStackTrace();
        }
    }

    private boolean retryLimit() {
        if (this.mRetryPeriodTime > 0 && this.mPeriodRetryCountLimit > 0) {
            if (this.mCurrentRetryTime == 0) {
                this.mCurrentRetryTime = System.currentTimeMillis();
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.mCurrentRetryTime < this.mRetryPeriodTime) {
                if (this.mCurrentPeriodRetryCount <= this.mPeriodRetryCountLimit) {
                    return false;
                }
                if (!Logger.debug()) {
                    return true;
                }
                Logger.taskDebug(TAG, this.mDownloadId, "retryLimit", "CurrentPeriodRetryCount:" + this.mCurrentPeriodRetryCount + " periodRetryCountLimit:" + this.mPeriodRetryCountLimit + " currentRetryPeriodTime:" + (currentTimeMillis - this.mCurrentRetryTime) + " retryPeriodTime:" + this.mRetryPeriodTime);
                return true;
            }
            this.mCurrentRetryTime = System.currentTimeMillis();
            this.mCurrentPeriodRetryCount = 0;
        }
        return false;
    }

    private boolean resetLimit() {
        int i = this.mRetryResetCountLimit;
        if (i <= 0 || this.mCurrentRetryResetCount < i) {
            return false;
        }
        if (!Logger.debug()) {
            return true;
        }
        Logger.taskDebug(TAG, this.mDownloadId, "resetLimit", "CurrentRetryResetCount:" + this.mCurrentRetryResetCount + " retryResetCountLimit:" + this.mRetryResetCountLimit);
        return true;
    }

    public int getTotalRetryCount() {
        return this.mTotalRetryCount;
    }
}
