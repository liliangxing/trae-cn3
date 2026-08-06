package com.ss.bytertc.ktv;

import com.ss.bytertc.ktv.data.DownloadLyricType;
import com.ss.bytertc.ktv.data.MusicFilterType;
import java.util.List;

/* loaded from: classes7.dex */
public abstract class IKTVManager {
    public abstract void cancelDownload(int downloadId);

    public abstract void clearCache();

    public abstract int downloadLyric(String musicId, DownloadLyricType lyricType);

    public abstract int downloadMidi(String musicId);

    public abstract int downloadMusic(String musicId);

    public abstract void getHotMusic(List<String> customHotlistId, MusicFilterType[] filters);

    public abstract IKTVPlayer getKTVPlayer();

    public abstract void getMusicDetail(String musicId);

    public abstract void getMusicList(int pageNum, int pageSize, MusicFilterType[] filters);

    public abstract void searchMusic(String keyWord, int pageNum, int pageSize, MusicFilterType[] filters);

    public abstract void setKTVManagerEventHandler(IKTVManagerEventHandler ktvManagerEventHandler);

    public abstract void setMaxCacheSize(int maxCacheSizeMB);
}
