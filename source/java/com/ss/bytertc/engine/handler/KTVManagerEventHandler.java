package com.ss.bytertc.engine.handler;

import com.ss.bytertc.engine.utils.LogUtil;
import com.ss.bytertc.ktv.IKTVManagerEventHandler;
import com.ss.bytertc.ktv.data.DownloadResult;
import com.ss.bytertc.ktv.data.HotMusicInfo;
import com.ss.bytertc.ktv.data.KTVErrorCode;
import com.ss.bytertc.ktv.data.MusicInfo;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class KTVManagerEventHandler extends IKTVManagerEventHandler {
    private static final String TAG = "KTVManagerEventHandler";
    private final IKTVManagerEventHandler mHandler;

    public KTVManagerEventHandler(IKTVManagerEventHandler handler) {
        this.mHandler = handler;
    }

    public IKTVManagerEventHandler getKTVHandler() {
        return this.mHandler;
    }

    @Override // com.ss.bytertc.ktv.IKTVManagerEventHandler
    public void onMusicListResult(MusicInfo[] musicInfos, int totalSize, KTVErrorCode errorCode) {
        LogUtil.m215d(TAG, "onMusicListResult...errorCode: " + errorCode + ",totalSize:" + totalSize + ",musicsLen:" + musicInfos.length);
        try {
            IKTVManagerEventHandler iKTVManagerEventHandler = this.mHandler;
            if (iKTVManagerEventHandler != null) {
                iKTVManagerEventHandler.onMusicListResult(musicInfos, totalSize, errorCode);
            }
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onMusicListResult callback catch exception.\n" + e.getMessage());
        }
    }

    @Override // com.ss.bytertc.ktv.IKTVManagerEventHandler
    public void onSearchMusicResult(MusicInfo[] musicInfos, int totalSize, KTVErrorCode errorCode) {
        LogUtil.m215d(TAG, "onSearchMusicResult...errorCode: " + errorCode + ",totalSize:" + totalSize + ",musicsLen:" + musicInfos.length);
        try {
            IKTVManagerEventHandler iKTVManagerEventHandler = this.mHandler;
            if (iKTVManagerEventHandler != null) {
                iKTVManagerEventHandler.onSearchMusicResult(musicInfos, totalSize, errorCode);
            }
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onSearchMusicResult callback catch exception.\n" + e.getMessage());
        }
    }

    @Override // com.ss.bytertc.ktv.IKTVManagerEventHandler
    public void onHotMusicResult(HotMusicInfo[] hotLists, KTVErrorCode errorCode) {
        LogUtil.m215d(TAG, "onHotMusicResult...errorCode: " + errorCode + ",musicsLen:" + hotLists.length);
        try {
            IKTVManagerEventHandler iKTVManagerEventHandler = this.mHandler;
            if (iKTVManagerEventHandler != null) {
                iKTVManagerEventHandler.onHotMusicResult(hotLists, errorCode);
            }
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onHotMusicResult callback catch exception.\n" + e.getMessage());
        }
    }

    @Override // com.ss.bytertc.ktv.IKTVManagerEventHandler
    public void onMusicDetailResult(MusicInfo musicInfo, KTVErrorCode errorCode) {
        LogUtil.m215d(TAG, "onMusicDetailResult...errorCode: " + errorCode + ",music:" + musicInfo);
        try {
            IKTVManagerEventHandler iKTVManagerEventHandler = this.mHandler;
            if (iKTVManagerEventHandler != null) {
                iKTVManagerEventHandler.onMusicDetailResult(musicInfo, errorCode);
            }
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onMusicDetailResult callback catch exception.\n" + e.getMessage());
        }
    }

    @Override // com.ss.bytertc.ktv.IKTVManagerEventHandler
    public void onDownloadSuccess(int downloadId, DownloadResult result) {
        LogUtil.m215d(TAG, "onDownloadSuccess...downloadId: " + downloadId + ",result:" + result);
        try {
            IKTVManagerEventHandler iKTVManagerEventHandler = this.mHandler;
            if (iKTVManagerEventHandler != null) {
                iKTVManagerEventHandler.onDownloadSuccess(downloadId, result);
            }
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onDownloadSuccess callback catch exception.\n" + e.getMessage());
        }
    }

    @Override // com.ss.bytertc.ktv.IKTVManagerEventHandler
    public void onDownloadFailed(int downloadId, KTVErrorCode errorCode) {
        LogUtil.m215d(TAG, "onDownloadFailed...downloadId: " + downloadId + ",errorCode:" + errorCode);
        try {
            IKTVManagerEventHandler iKTVManagerEventHandler = this.mHandler;
            if (iKTVManagerEventHandler != null) {
                iKTVManagerEventHandler.onDownloadFailed(downloadId, errorCode);
            }
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onDownloadFailed callback catch exception.\n" + e.getMessage());
        }
    }

    @Override // com.ss.bytertc.ktv.IKTVManagerEventHandler
    public void onDownloadMusicProgress(int downloadId, int downloadProgress) {
        LogUtil.m215d(TAG, "onDownloadMusicProgress...downloadId: " + downloadId + ",downloadProgress:" + downloadProgress);
        try {
            IKTVManagerEventHandler iKTVManagerEventHandler = this.mHandler;
            if (iKTVManagerEventHandler != null) {
                iKTVManagerEventHandler.onDownloadMusicProgress(downloadId, downloadProgress);
            }
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onDownloadMusicProgress callback catch exception.\n" + e.getMessage());
        }
    }

    @Override // com.ss.bytertc.ktv.IKTVManagerEventHandler
    public void onClearCacheResult(KTVErrorCode errorCode) {
        LogUtil.m215d(TAG, "onClearCacheResult...errorCode: " + errorCode);
        try {
            IKTVManagerEventHandler iKTVManagerEventHandler = this.mHandler;
            if (iKTVManagerEventHandler != null) {
                iKTVManagerEventHandler.onClearCacheResult(errorCode);
            }
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onClearCacheResult callback catch exception.\n" + e.getMessage());
        }
    }
}
