package com.ss.bytertc.ktv;

import com.ss.bytertc.ktv.data.DownloadResult;
import com.ss.bytertc.ktv.data.HotMusicInfo;
import com.ss.bytertc.ktv.data.KTVErrorCode;
import com.ss.bytertc.ktv.data.MusicInfo;

/* loaded from: classes7.dex */
public abstract class IKTVManagerEventHandler {
    public abstract void onClearCacheResult(KTVErrorCode errorCode);

    public abstract void onDownloadFailed(int downloadId, KTVErrorCode errorCode);

    public abstract void onDownloadMusicProgress(int downloadId, int downloadProgress);

    public abstract void onDownloadSuccess(int downloadId, DownloadResult result);

    public abstract void onHotMusicResult(HotMusicInfo[] hotMusics, KTVErrorCode errorCode);

    public abstract void onMusicDetailResult(MusicInfo musicInfo, KTVErrorCode errorCode);

    public abstract void onMusicListResult(MusicInfo[] musicInfos, int totalSize, KTVErrorCode errorCode);

    public abstract void onSearchMusicResult(MusicInfo[] musicInfos, int totalSize, KTVErrorCode errorCode);
}
