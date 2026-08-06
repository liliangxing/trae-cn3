package com.ss.android.socialbase.downloader.core.module;

import com.ss.android.socialbase.downloader.constants.RunStatus;
import com.ss.android.socialbase.downloader.downloader.DownloadStatusHandler;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy;
import com.ss.android.socialbase.downloader.downloader.NetworkRetryStrategy;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;

/* loaded from: classes7.dex */
public class DownloadCommonParams {
    public IDownloadCache mDownloadCache;
    public DownloadInfo mDownloadInfo;
    public DownloadTask mDownloadTask;
    public String mExistTargetFileName;
    public String mExistTargetFilePath;
    public NetworkFailoverStrategy mFailoverStrategy;
    public boolean mNeedCheckIfModified;
    public NetworkRetryStrategy mRetryStrategy;
    public DownloadSetting mSetting;
    public DownloadStatusHandler mStatusHandler;
    public RunStatus mRunStatus = RunStatus.RUN_STATUS_NONE;
    public volatile boolean mIsAlive = true;
    public boolean mEnableSegmentDownload = true;
    public boolean mHasRunNetworkModule = false;
}
