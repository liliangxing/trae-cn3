package com.ss.bytertc.engine;

import android.view.View;
import com.ss.bytertc.engine.handler.NativeWTNStreamEventHandler;
import com.ss.bytertc.engine.video.IVideoSink;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class NativeWTNStreamFunctions {
    public static native void nativeDestroy(long wtnStreamPtr);

    public static native void nativeEnableWTNRemoteAudioFrameCallback(long wtnStreamPtr, boolean enable);

    public static native int nativeRegisterWTNAudioFrameObserver(long wtnStreamPtr, IWTNAudioFrameObserver wtnAudioFrameObserver);

    public static native int nativeSetWTNRemoteAudioPlaybackVolume(long wtnStreamPtr, String streamId, int volume);

    public static native int nativeSetWTNRemoteVideoCanvas(long wtnStreamPtr, String streamId, View renderView, int renderMode, int background_color, int render_rotation);

    public static native int nativeSetWTNRemoteVideoSink(long wtnStreamPtr, String streamId, IVideoSink videoSink, int requiredPixelFormat, int position, int apply_rotation, int mirror_type);

    public static native int nativeSetWTNStreamEventHandler(long wtnStreamPtr, NativeWTNStreamEventHandler wtnStreamEventHandler);

    public static native int nativeSubscribeWTNAudioStream(long wtnStreamPtr, String streamId, boolean subscribe);

    public static native int nativeSubscribeWTNVideoStream(long wtnStreamPtr, String streamId, boolean subscribe);
}
