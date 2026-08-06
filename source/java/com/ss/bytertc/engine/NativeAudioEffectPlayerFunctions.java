package com.ss.bytertc.engine;

import com.ss.bytertc.engine.handler.RTCAudioEffectPlayerEventHandler;

/* loaded from: classes7.dex */
public class NativeAudioEffectPlayerFunctions {
    public static native int nativeGetDuration(long audioEffectPlayerPtr, int effectId);

    public static native int nativeGetPosition(long audioEffectPlayerPtr, int effectId);

    public static native int nativeGetVolume(long audioEffectPlayerPtr, int effectId);

    public static native int nativePause(long audioEffectPlayerPtr, int effectId);

    public static native int nativePauseAll(long audioEffectPlayerPtr);

    public static native int nativePreload(long audioEffectPlayerPtr, int effectId, String filePath);

    public static native int nativeResume(long audioEffectPlayerPtr, int effectId);

    public static native int nativeResumeAll(long audioEffectPlayerPtr);

    public static native int nativeSetEventHandler(long audioEffectPlayerPtr, long rtcEngine, RTCAudioEffectPlayerEventHandler handler);

    public static native int nativeSetPosition(long audioEffectPlayerPtr, int effectId, int pos);

    public static native int nativeSetVolume(long audioEffectPlayerPtr, int effectId, int volume);

    public static native int nativeSetVolumeAll(long audioEffectPlayerPtr, int volume);

    public static native int nativeStart(long audioEffectPlayerPtr, int effectId, String filePath, int type, int playCount, int startPos, int pitch);

    public static native int nativeStop(long audioEffectPlayerPtr, int effectId);

    public static native int nativeStopAll(long audioEffectPlayerPtr);

    public static native int nativeUnload(long audioEffectPlayerPtr, int effectId);

    public static native int nativeUnloadAll(long audioEffectPlayerPtr);
}
