package com.ss.bytertc.engine;

import com.ss.bytertc.ktv.IKTVManagerEventHandler;

/* loaded from: classes7.dex */
public class NativeKTVManagerFunctions {
    public static native void nativeCancelDownload(long ktvMangerPtr, int downloadId);

    public static native void nativeClearCache(long ktvMangerPtr);

    public static native int nativeDownloadLyric(long ktvMangerPtr, String musicId, int lyricType);

    public static native int nativeDownloadMidi(long ktvMangerPtr, String musicId);

    public static native int nativeDownloadMusic(long ktvMangerPtr, String musicId);

    public static native void nativeGetHotMusic(long ktvMangerPtr, String[] customHotlistId, int musicFilters);

    public static native long nativeGetKTVPlayer(long ktvMangerPtr);

    public static native void nativeGetMusicDetail(long ktvMangerPtr, String musicId);

    public static native void nativeGetMusicList(long ktvMangerPtr, int pageNumber, int pageSize, int musicFilters);

    public static native void nativeReleaseKTVManagerEventHandler(long ktvManagerEventHandlerPtr);

    public static native void nativeSearchMusic(long ktvMangerPtr, String keyWord, int pageNumber, int pageSize, int musicFilters);

    public static native long nativeSetKTVManagerEventHandler(long ktvMangerPtr, IKTVManagerEventHandler ktvManagerEventHandler);

    public static native void nativeSetMaxCacheSize(long ktvMangerPtr, int maxCacheSize);
}
