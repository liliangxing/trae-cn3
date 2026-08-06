package com.ss.bytertc.engine;

import com.ss.bytertc.engine.data.AudioContentTypeConfig;
import com.ss.bytertc.engine.data.AudioEncodeConfig;
import com.ss.bytertc.engine.data.EngineConfig;
import com.ss.bytertc.engine.data.RTCLogConfig;
import com.ss.bytertc.engine.data.StreamIndex;
import com.ss.bytertc.engine.data.StreamPriority;
import com.ss.bytertc.engine.data.VideoFrameData;
import com.ss.bytertc.engine.engineimpl.RTCEngineImpl;
import com.ss.bytertc.engine.handler.IRTCEngineEventHandler;
import com.ss.bytertc.engine.handler.IRTCEngineEventHandlerEx;
import com.ss.bytertc.engine.loader.RTCNativeLibraryLoader;
import com.ss.bytertc.engine.utils.EngineConfigCheck;
import com.ss.bytertc.engine.utils.LogUtil;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class RTCEngineEx extends RTCEngine {
    private static final String TAG = "RtcVideoEx";

    public abstract RTCRoomEx createRTCRoomEx(String roomId);

    public abstract int pushExternalVideoFrame(StreamIndex streamIndex, VideoFrameData frame);

    public abstract int setAudioContentType(StreamIndex streamIndex, AudioContentTypeConfig audioConfig);

    public abstract int setAudioEncodeConfig(StreamIndex streamIndex, AudioEncodeConfig audioConfig);

    public abstract int setAudioSourceVolume(StreamIndex streamIndex, int volume);

    public abstract int setCaptureVolume(int volume);

    public abstract int setLocalStreamPriority(StreamIndex streamIndex, StreamPriority priority);

    public abstract int setRtcVideoEventHandlerEx(IRTCEngineEventHandlerEx engineEventHandler);

    public abstract int setScreenCaptureVolume(int volume);

    public abstract int setVideoCaptureConfig(StreamIndex streamIndex, com.ss.bytertc.engine.video.VideoCaptureConfig videoCaptureConfig);

    public abstract int setVideoEncoderConfig(StreamIndex streamIndex, List<VideoEncoderConfig> videoEncoderConfigs);

    public abstract int setVideoSource(StreamIndex streamIndex, InternalVideoSourceConfig config);

    public abstract int startVideoCapture(StreamIndex streamIndex, String deviceId);

    public abstract int stopVideoCapture(StreamIndex streamIndex);

    public static void setRtcNativeLibraryLoader(RTCNativeLibraryLoader rtcNativeLibraryLoader) {
        LogUtil.m218i(TAG, "set rtc native library loader" + rtcNativeLibraryLoader);
        RTCEngine.setRtcNativeLibraryLoader(rtcNativeLibraryLoader);
    }

    public static synchronized RTCEngineEx createRTCEngineEx(EngineConfig config, IRTCEngineEventHandler handler, IRTCEngineEventHandlerEx handlerEx) {
        synchronized (RTCEngineEx.class) {
            if (EngineConfigCheck.checkValid(config) != 0) {
                LogUtil.m216e(TAG, "createRTCEngineEx: engine config is invalid, error code is " + EngineConfigCheck.checkValid(config));
                return null;
            }
            if (mInstance != null || !RTCEngineImpl.initializeNativeLibs(config.nativeLoadPath)) {
                return null;
            }
            if (mInstanceEx == null) {
                try {
                    mInstanceEx = new RTCEngineImpl(config, handler, handlerEx, true, false);
                } catch (IllegalStateException unused) {
                    return null;
                }
            }
            return mInstanceEx;
        }
    }

    public static synchronized void destroyRTCEngineEx() {
        synchronized (RTCEngineEx.class) {
            if (mInstanceEx != null) {
                mInstanceEx.doDestroy(false);
                mInstanceEx = null;
                mRtcNativeLibraryLoader = null;
                mRtcEglContextChecker = null;
                System.gc();
            }
        }
    }

    public static String getSDKVersion() {
        return !RTCEngineImpl.initializeNativeLibs() ? "" : RTCEngineImpl.getSdkVersion();
    }

    public static int setLogConfig(RTCLogConfig logConfig) {
        if (RTCEngineImpl.initializeNativeLibs()) {
            return RTCEngineImpl.setLogConfig(logConfig);
        }
        return -1;
    }
}
