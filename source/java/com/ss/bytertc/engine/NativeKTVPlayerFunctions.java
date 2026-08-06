package com.ss.bytertc.engine;

import com.ss.bytertc.ktv.IKTVPlayerEventHandler;

/* loaded from: classes7.dex */
public class NativeKTVPlayerFunctions {
    public static native void nativePauseMusic(long ktvPlayerPtr, String musicId);

    public static native void nativePlayMusic(long ktvPlayerPtr, String musicId, int tackType, int playType);

    public static native void nativeReleaseKTVPlayerEventHandler(long ktvPlayerEventHandlerPtr);

    public static native void nativeResumeMusic(long ktvPlayerPtr, String musicId);

    public static native void nativeSeekMusic(long ktvPlayerPtr, String musicId, int position);

    public static native void nativeSetMusicPitch(long ktvPlayerPtr, String musicId, int pitch);

    public static native void nativeSetMusicVolume(long ktvPlayerPtr, String musicId, int volume);

    public static native long nativeSetPlayerEventHandler(long ktvPlayerPtr, IKTVPlayerEventHandler playEventHandler);

    public static native void nativeStopMusic(long ktvPlayerPtr, String musicId);

    public static native void nativeSwitchAudioTrackType(long ktvPlayerPtr, String musicId);
}
