package com.ss.bytertc.ktv;

import com.ss.bytertc.engine.BuildConfig;
import com.ss.bytertc.engine.NativeKTVManagerFunctions;
import com.ss.bytertc.engine.handler.KTVManagerEventHandler;
import com.ss.bytertc.engine.utils.LogUtil;
import com.ss.bytertc.ktv.data.DownloadLyricType;
import com.ss.bytertc.ktv.data.MusicFilterType;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class KTVManagerImpl extends IKTVManager {
    private static final String TAG = "KTVManagerImpl";
    private final ReentrantReadWriteLock.ReadLock mJniReadLock;
    private final ReentrantReadWriteLock.WriteLock mJniWriteLock;
    private KTVManagerEventHandler mKTVManagerEventHandler;
    private KTVPlayerImpl mKTVPlayer;
    private long mNativeKTVManager;
    private long mNativeKTVManagerEventHandlerPtr;
    private final ReentrantReadWriteLock mReadWriteLock;

    public KTVManagerImpl(long nativeKTVManager) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.mReadWriteLock = reentrantReadWriteLock;
        this.mJniReadLock = reentrantReadWriteLock.readLock();
        this.mJniWriteLock = reentrantReadWriteLock.writeLock();
        this.mNativeKTVManager = nativeKTVManager;
    }

    @Override // com.ss.bytertc.ktv.IKTVManager
    public void setKTVManagerEventHandler(IKTVManagerEventHandler ktvManagerEventHandler) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeKTVManager == 0) {
                LogUtil.m216e(TAG, "native KTVManagerImpl is invalid, setKTVManagerEventHandler failed.");
                return;
            }
            KTVManagerEventHandler kTVManagerEventHandler = new KTVManagerEventHandler(ktvManagerEventHandler);
            this.mKTVManagerEventHandler = kTVManagerEventHandler;
            long j = this.mNativeKTVManagerEventHandlerPtr;
            this.mNativeKTVManagerEventHandlerPtr = NativeKTVManagerFunctions.nativeSetKTVManagerEventHandler(this.mNativeKTVManager, kTVManagerEventHandler);
            if (j != 0) {
                NativeKTVManagerFunctions.nativeReleaseKTVManagerEventHandler(j);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.ktv.IKTVManager
    public void setMaxCacheSize(int maxCacheSizeMB) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeKTVManager;
            if (j == 0) {
                LogUtil.m216e(TAG, "native KTVManagerImpl is invalid, setMaxCacheSize failed.");
            } else {
                NativeKTVManagerFunctions.nativeSetMaxCacheSize(j, maxCacheSizeMB);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public IKTVManagerEventHandler getHandler() {
        return this.mKTVManagerEventHandler.getKTVHandler();
    }

    @Override // com.ss.bytertc.ktv.IKTVManager
    public void getMusicList(int pageNum, int pageSize, MusicFilterType[] filters) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeKTVManager == 0) {
                LogUtil.m216e(TAG, "native KTVManagerImpl is invalid, getMusicList failed.");
            } else {
                int calculateMusicFilterValue = calculateMusicFilterValue(filters);
                if (calculateMusicFilterValue != -1) {
                    NativeKTVManagerFunctions.nativeGetMusicList(this.mNativeKTVManager, pageNum, pageSize, calculateMusicFilterValue);
                }
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.ktv.IKTVManager
    public void searchMusic(String keyWord, int pageNum, int pageSize, MusicFilterType[] filters) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeKTVManager == 0) {
                LogUtil.m216e(TAG, "native KTVManagerImpl is invalid, searchMusic failed.");
            } else {
                int calculateMusicFilterValue = calculateMusicFilterValue(filters);
                if (calculateMusicFilterValue != -1) {
                    NativeKTVManagerFunctions.nativeSearchMusic(this.mNativeKTVManager, keyWord, pageNum, pageSize, calculateMusicFilterValue);
                }
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.ktv.IKTVManager
    public void getHotMusic(List<String> customHotlistId, MusicFilterType[] filters) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeKTVManager == 0) {
                LogUtil.m216e(TAG, "native KTVManagerImpl is invalid, getHotMusic failed.");
            } else {
                int calculateMusicFilterValue = calculateMusicFilterValue(filters);
                if (calculateMusicFilterValue != -1) {
                    String[] strArr = new String[customHotlistId.size()];
                    customHotlistId.toArray(strArr);
                    NativeKTVManagerFunctions.nativeGetHotMusic(this.mNativeKTVManager, strArr, calculateMusicFilterValue);
                }
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.ktv.IKTVManager
    public void getMusicDetail(String musicId) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeKTVManager;
            if (j == 0) {
                LogUtil.m216e(TAG, "native KTVManagerImpl is invalid, getMusicDetail failed.");
            } else {
                NativeKTVManagerFunctions.nativeGetMusicDetail(j, musicId);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.ktv.IKTVManager
    public int downloadMusic(String musicId) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeKTVManager;
            if (j == 0) {
                LogUtil.m216e(TAG, "native KTVManagerImpl is invalid, downloadMusic failed.");
                this.mJniReadLock.unlock();
                return -1;
            }
            return NativeKTVManagerFunctions.nativeDownloadMusic(j, musicId);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.ktv.IKTVManager
    public int downloadLyric(String musicId, DownloadLyricType lyricType) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeKTVManager;
            if (j == 0) {
                LogUtil.m216e(TAG, "native KTVManagerImpl is invalid, downloadLyric failed.");
                this.mJniReadLock.unlock();
                return -1;
            }
            return NativeKTVManagerFunctions.nativeDownloadLyric(j, musicId, lyricType.value());
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.ktv.IKTVManager
    public int downloadMidi(String musicId) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeKTVManager;
            if (j == 0) {
                LogUtil.m216e(TAG, "native KTVManagerImpl is invalid, downloadMidi failed.");
                this.mJniReadLock.unlock();
                return -1;
            }
            return NativeKTVManagerFunctions.nativeDownloadMidi(j, musicId);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.ktv.IKTVManager
    public void cancelDownload(int downloadId) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeKTVManager == 0) {
                LogUtil.m216e(TAG, "native KTVManagerImpl is invalid, downloadLyric failed.");
            }
            NativeKTVManagerFunctions.nativeCancelDownload(this.mNativeKTVManager, downloadId);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.ktv.IKTVManager
    public void clearCache() {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeKTVManager == 0) {
                LogUtil.m216e(TAG, "native KTVManagerImpl is invalid, clearCache failed.");
            }
            NativeKTVManagerFunctions.nativeClearCache(this.mNativeKTVManager);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.ktv.IKTVManager
    public IKTVPlayer getKTVPlayer() {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeKTVManager == 0) {
                LogUtil.m216e(TAG, "native KTVManagerImpl is invalid, getKTVPlayer failed.");
            }
            KTVPlayerImpl kTVPlayerImpl = this.mKTVPlayer;
            if (kTVPlayerImpl != null) {
                return kTVPlayerImpl;
            }
            long nativeGetKTVPlayer = NativeKTVManagerFunctions.nativeGetKTVPlayer(this.mNativeKTVManager);
            if (nativeGetKTVPlayer == 0) {
                LogUtil.m216e(TAG, "native nativeKTVPlayer is invalid, getKTVPlayer failed.");
                this.mJniReadLock.unlock();
                return null;
            }
            KTVPlayerImpl kTVPlayerImpl2 = new KTVPlayerImpl(nativeGetKTVPlayer);
            this.mKTVPlayer = kTVPlayerImpl2;
            return kTVPlayerImpl2;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void destroy() {
        KTVPlayerImpl kTVPlayerImpl = this.mKTVPlayer;
        if (kTVPlayerImpl != null) {
            kTVPlayerImpl.destroy();
            this.mKTVPlayer = null;
        }
        long j = this.mNativeKTVManagerEventHandlerPtr;
        if (j != 0) {
            NativeKTVManagerFunctions.nativeReleaseKTVManagerEventHandler(j);
            this.mNativeKTVManagerEventHandlerPtr = 0L;
        }
        this.mKTVManagerEventHandler = null;
        this.mJniWriteLock.lock();
        try {
            this.mNativeKTVManager = 0L;
        } finally {
            this.mJniWriteLock.unlock();
        }
    }

    private int calculateMusicFilterValue(MusicFilterType[] filters) {
        int length = filters == null ? 0 : filters.length;
        if (length == 0) {
            return MusicFilterType.NONE.value();
        }
        if (length == 1) {
            return filters[0].value();
        }
        int value = filters[0].value();
        for (MusicFilterType musicFilterType : filters) {
            if (value == MusicFilterType.NONE.value()) {
                if (BuildConfig.DEBUG) {
                    throw new IllegalArgumentException("types contains 'MUSIC_FILTER_TYPE_NONE' and other");
                }
                LogUtil.m216e(TAG, "types contains 'MUSIC_FILTER_TYPE_NONE' and other");
                return -1;
            }
            value |= musicFilterType.value();
        }
        return value;
    }
}
