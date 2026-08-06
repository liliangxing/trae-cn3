package com.ss.android.socialbase.downloader.core.module.pcdn;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.core.DownloadSingleResponseHandler;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.AbsDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class PCDNStats {
    private long mCdnDur;
    private long mCdnSize;
    private long mCdnStartTime;
    private int mChunkRetryCount;
    private DownloadInfo mDownloadInfo;
    private long mPcdnDur;
    private long mPcdnSize;
    private long mPcdnStartTime;
    private Map<String, UrlStats> mUrlStats = new LinkedHashMap();
    private int mCdnConcurrentCount = 0;
    private int mPcdnConcurrentCount = 0;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class UrlStats {
        private int mCode;
        private int mConcurrentCount;
        private long mDuration;
        private String mErr;
        private boolean mIsPcdn;
        private int mProtocol;
        private long mSize;
        private long mStartTime;
        private int mTtfb;

        public UrlStats() {
        }

        static /* synthetic */ int access$204(UrlStats urlStats) {
            int i = urlStats.mConcurrentCount + 1;
            urlStats.mConcurrentCount = i;
            return i;
        }

        static /* synthetic */ int access$206(UrlStats urlStats) {
            int i = urlStats.mConcurrentCount - 1;
            urlStats.mConcurrentCount = i;
            return i;
        }
    }

    public PCDNStats(DownloadInfo downloadInfo, int i) {
        this.mDownloadInfo = downloadInfo;
        downloadInfo.setPcdnStats(null);
        this.mChunkRetryCount = i;
    }

    public void beforeDownload(String str, boolean z) {
        synchronized (this) {
            beforeUrlStats(str, z);
            afterTotalStats(z);
        }
    }

    private void beforeUrlStats(String str, boolean z) {
        UrlStats urlStats = this.mUrlStats.get(str);
        if (urlStats == null) {
            urlStats = new UrlStats();
            urlStats.mIsPcdn = z;
        }
        if (urlStats.mStartTime <= 0) {
            urlStats.mStartTime = System.currentTimeMillis();
        }
        UrlStats.access$204(urlStats);
        this.mUrlStats.put(str, urlStats);
    }

    private void afterTotalStats(boolean z) {
        if (z) {
            if (this.mPcdnStartTime <= 0) {
                this.mPcdnStartTime = System.currentTimeMillis();
            }
            this.mPcdnConcurrentCount++;
        } else {
            if (this.mCdnStartTime <= 0) {
                this.mCdnStartTime = System.currentTimeMillis();
            }
            this.mCdnConcurrentCount++;
        }
    }

    public void afterDownload(String str, long j, boolean z, boolean z2, IDownloadHttpConnection iDownloadHttpConnection, DownloadSingleResponseHandler downloadSingleResponseHandler, Throwable th) {
        synchronized (this) {
            long curOffset = downloadSingleResponseHandler != null ? downloadSingleResponseHandler.getCurOffset() - j : 0L;
            long currentTimeMillis = System.currentTimeMillis();
            afterUrlStats(currentTimeMillis, str, iDownloadHttpConnection, th, z2, curOffset);
            afterTotalStats(currentTimeMillis, z, curOffset);
        }
    }

    private void afterUrlStats(long j, String str, IDownloadHttpConnection iDownloadHttpConnection, Throwable th, boolean z, long j2) {
        UrlStats urlStats = this.mUrlStats.get(str);
        if (urlStats.mProtocol == 0 && iDownloadHttpConnection != null && (iDownloadHttpConnection instanceof AbsDownloadHttpConnection)) {
            AbsDownloadHttpConnection absDownloadHttpConnection = (AbsDownloadHttpConnection) iDownloadHttpConnection;
            if (!absDownloadHttpConnection.isOkhttp()) {
                urlStats.mProtocol = 4;
                String requestLog = absDownloadHttpConnection.getRequestLog();
                if (!TextUtils.isEmpty(requestLog)) {
                    try {
                        JSONObject jSONObject = new JSONObject(requestLog);
                        urlStats.mProtocol = jSONObject.optJSONObject("response").optInt("connection_info");
                        urlStats.mTtfb = jSONObject.optJSONObject("timing").optJSONObject("detailed_duration").optInt(MonitorConstants.TTFB);
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
            } else {
                urlStats.mProtocol = 1;
            }
        }
        if (th != null && !z) {
            if (th instanceof BaseException) {
                urlStats.mCode = ((BaseException) th).getErrorCode();
            } else {
                urlStats.mCode = 1000;
            }
            urlStats.mErr = th.toString();
        } else if (iDownloadHttpConnection != null) {
            try {
                urlStats.mCode = iDownloadHttpConnection.getResponseCode();
                urlStats.mErr = "";
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
        }
        UrlStats.access$206(urlStats);
        urlStats.mDuration += j - urlStats.mStartTime;
        if (urlStats.mConcurrentCount == 0) {
            urlStats.mStartTime = 0L;
        } else {
            urlStats.mStartTime = j;
        }
        urlStats.mSize += j2;
        this.mUrlStats.put(str, urlStats);
    }

    private void afterTotalStats(long j, boolean z, long j2) {
        if (z) {
            int i = this.mPcdnConcurrentCount - 1;
            this.mPcdnConcurrentCount = i;
            this.mPcdnSize += j2;
            this.mPcdnDur += j - this.mPcdnStartTime;
            if (i == 0) {
                this.mPcdnStartTime = 0L;
                return;
            } else {
                this.mPcdnStartTime = j;
                return;
            }
        }
        int i2 = this.mCdnConcurrentCount - 1;
        this.mCdnConcurrentCount = i2;
        this.mCdnSize += j2;
        this.mCdnDur += j - this.mCdnStartTime;
        if (i2 == 0) {
            this.mCdnStartTime = 0L;
        } else {
            this.mCdnStartTime = j;
        }
    }

    public void collectPCDNStats() {
        synchronized (this) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(MonitorConstants.PCDN_BUSINESSID, this.mDownloadInfo.getMonitorScene());
                jSONObject.put(MonitorConstants.PCDN_SIZE, this.mPcdnSize);
                jSONObject.put(MonitorConstants.PCDN_DUR, this.mPcdnDur);
                jSONObject.put(MonitorConstants.CDN_SIZE, this.mCdnSize);
                jSONObject.put(MonitorConstants.CDN_DUR, this.mCdnDur);
                jSONObject.put(MonitorConstants.RETRY_TIMES_MAX, this.mChunkRetryCount);
                JSONArray jSONArray = new JSONArray();
                for (Map.Entry<String, UrlStats> entry : this.mUrlStats.entrySet()) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("url", entry.getKey());
                    UrlStats value = entry.getValue();
                    jSONObject2.put(MonitorConstants.IS_PCDN, value.mIsPcdn);
                    jSONObject2.put(MonitorConstants.CODE, value.mCode);
                    jSONObject2.put(MonitorConstants.SIZE, value.mSize);
                    jSONObject2.put("duration", value.mDuration);
                    jSONObject2.put(MonitorConstants.PROTOCOL, value.mProtocol);
                    jSONObject2.put(MonitorConstants.TTFB, value.mTtfb);
                    jSONObject2.put(MonitorConstants.ERR, value.mErr);
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put(MonitorConstants.URLS, jSONArray);
                this.mDownloadInfo.setPcdnStats(jSONObject);
            } finally {
            }
        }
    }
}
