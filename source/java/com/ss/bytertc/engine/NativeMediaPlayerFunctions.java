package com.ss.bytertc.engine;

import com.ss.bytertc.engine.handler.RTCMediaPlayerAudioFrameObserver;
import com.ss.bytertc.engine.handler.RTCMediaPlayerCustomSourceProvider;
import com.ss.bytertc.engine.handler.RTCMediaPlayerEventHandler;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class NativeMediaPlayerFunctions {
    public static native void nativeDestory(long mediaPlayerPtr);

    public static native int nativeGetAudioTrackCount(long mediaPlayerPtr);

    public static native int nativeGetPlaybackDuration(long mediaPlayerPtr);

    public static native int nativeGetPosition(long mediaPlayerPtr);

    public static native int nativeGetState(long mediaPlayerPtr);

    public static native int nativeGetTotalDuration(long mediaPlayerPtr);

    public static native int nativeGetVolume(long mediaPlayerPtr, int type);

    public static native int nativeOpen(long mediaPlayerPtr, String filePath, int type, int playCount, int startPos, boolean autoPlay, long callbackProgressInterval, boolean syncProgressToRecordFrame);

    public static native int nativeOpenWithCustomSource(long mediaPlayerPtr, int sourceMode, int sourceType, RTCMediaPlayerCustomSourceProvider provider, int mixingType, int playCount, int startPos, boolean autoPlay, long callbackProgressInterval, boolean syncProgressToRecordFrame);

    public static native int nativePause(long mediaPlayerPtr);

    public static native int nativePushExternalAudioFrame(long mediaPlayerPtr, byte[] audioFrame, int samples, int sampleRate, int channel);

    public static native int nativeRegisterAudioFrameObserver(long mediaPlayerPtr, RTCMediaPlayerAudioFrameObserver observer);

    public static native int nativeResume(long mediaPlayerPtr);

    public static native int nativeSelectAudioTrack(long mediaPlayerPtr, int index);

    public static native int nativeSetAudioDualMonoMode(long mediaPlayerPtr, int mode);

    public static native int nativeSetAudioPitch(long mediaPlayerPtr, int pitch);

    public static native int nativeSetEventHandler(long mediaPlayerPtr, RTCMediaPlayerEventHandler handler);

    public static native int nativeSetLoudness(long mediaPlayerPtr, float loudness);

    public static native int nativeSetPlaybackSpeed(long mediaPlayerPtr, int speed);

    public static native int nativeSetPosition(long mediaPlayerPtr, int position);

    public static native int nativeSetProgressInterval(long mediaPlayerPtr, long interval);

    public static native int nativeSetVolume(long mediaPlayerPtr, int volume, int type);

    public static native int nativeStart(long mediaPlayerPtr);

    public static native int nativeStop(long mediaPlayerPtr);
}
