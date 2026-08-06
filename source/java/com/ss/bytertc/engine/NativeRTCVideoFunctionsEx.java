package com.ss.bytertc.engine;

import android.content.Context;
import com.bytedance.realx.video.EglBase;
import com.ss.bytertc.engine.data.VideoFrameData;
import com.ss.bytertc.engine.handler.RTCVideoEventHandler;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class NativeRTCVideoFunctionsEx {
    public static native long nativeCreateRTCVideoEx(Context context, String appId, RTCVideoEventHandler eventHandler, String parameters, EglBase.Context eglBaseCtx, String nativeLoadPath);

    public static native void nativeDestroyRTCVideoEx(long enginePtr);

    public static native int nativePushExternalVideoFrame(long enginePtr, int streamIndex, VideoFrameData vfd);

    public static native int nativeSetAudioContentType(long enginePtr, int streamIndex, boolean hasMic, boolean hasScreenAudio, boolean hasMediaPlayer);

    public static native int nativeSetAudioEncodeConfig(long enginePtr, int streamIndex, int codecType, int encMode, int channelNum, int encBitrate, int useDtx, int useInbandfec, int sampleRate, int packetSize);

    public static native int nativeSetAudioSourceVolume(long enginePtr, int streamIndex, int volume);

    public static native int nativeSetCaptureVolume(long enginePtr, int volume);

    public static native int nativeSetLocalStreamPriority(long enginePtr, int streamIndex, int priority);

    public static native int nativeSetScreenCaptureVolume(long enginePtr, int volume);

    public static native int nativeSetVideoCaptureConfig(long enginePtr, int streamIndex, InternalVideoCaptureConfig videoCaptureConfig);

    public static native int nativeSetVideoEncoderConfig(long enginePtr, int streamIndex, List<InternalVideoEncoderConfig> internalVideoStreamDescriptionList);

    public static native int nativeSetVideoSource(long enginePtr, int streamIndex, int sourceType, int sourceCategory);

    public static native int nativeStartVideoCapture(long enginePtr, int streamIndex, String deviceId);

    public static native int nativeStopVideoCapture(long enginePtr, int streamIndex);
}
