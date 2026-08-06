package com.ss.bytertc.engine.meeting;

import android.view.Surface;
import com.ss.bytertc.engine.InternalVideoEncoderConfig;
import com.ss.bytertc.engine.NativeRTCVideoFunctions;
import com.ss.bytertc.engine.RTCEngine;
import com.ss.bytertc.engine.RTCRoom;
import com.ss.bytertc.engine.SubscribeVideoBaseline;
import com.ss.bytertc.engine.VideoEncoderConfig;
import com.ss.bytertc.engine.data.RemoteStreamKey;
import com.ss.bytertc.engine.data.StreamIndex;
import com.ss.bytertc.engine.type.SubscribeMode;
import com.ss.bytertc.engine.utils.LogUtil;
import com.ss.bytertc.engine.video.IAmazingEffect;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class MeetingAdvance {
    protected static final String TAG = "MeetingAdvance";
    private static Method mGetAmazingEffectMethod;
    private static Method mGetNativeMethod;
    private static Method mGetNativeVideoMethod;

    private static long getNativeRoomHandle(RTCRoom room) {
        if (mGetNativeMethod == null) {
            try {
                Class<?> cls = Class.forName("com.ss.bytertc.engine.RTCRoomImpl");
                if (cls != null) {
                    mGetNativeMethod = cls.getMethod("getNativeHandle", new Class[0]);
                }
            } catch (Exception unused) {
                LogUtil.m216e(TAG, "fail to find method getNativeHandle");
            }
        }
        Method method = mGetNativeMethod;
        if (method == null) {
            return 0L;
        }
        try {
            return ((Long) method.invoke(room, new Object[0])).longValue();
        } catch (Exception unused2) {
            LogUtil.m216e(TAG, "fail to invoke method getNativeHandle");
            return 0L;
        }
    }

    private static long getNativeVideoHandle(RTCEngine video) {
        if (mGetNativeVideoMethod == null) {
            try {
                Class<?> cls = Class.forName("com.ss.bytertc.engine.engineimpl.RTCEngineImpl");
                if (cls != null) {
                    mGetNativeVideoMethod = cls.getMethod("getNativeHandle", new Class[0]);
                }
            } catch (Exception unused) {
                LogUtil.m216e(TAG, "fail to find method getNativeHandle");
            }
        }
        Method method = mGetNativeVideoMethod;
        if (method == null) {
            return 0L;
        }
        try {
            return ((Long) method.invoke(video, new Object[0])).longValue();
        } catch (Exception unused2) {
            LogUtil.m216e(TAG, "fail to invoke method getNativeHandle");
            return 0L;
        }
    }

    public static int setPublishChannel(RTCRoom room, String channelName) {
        long nativeRoomHandle = getNativeRoomHandle(room);
        if (nativeRoomHandle == 0) {
            LogUtil.m216e(TAG, "room native handle is invalid, setPublishChannel failed.");
            return -1;
        }
        return NativeRTCVideoFunctions.nativeSetPublishChannel(nativeRoomHandle, channelName);
    }

    public static int setSubscribeChannels(RTCRoom room, String[] channels, boolean enableVolumeRescale) {
        long nativeRoomHandle = getNativeRoomHandle(room);
        if (nativeRoomHandle == 0) {
            LogUtil.m216e(TAG, "room native handle is invalid, setSubscribeChannels failed.");
            return -1;
        }
        return NativeRTCVideoFunctions.nativeSetSubscribeChannels(nativeRoomHandle, channels, enableVolumeRescale);
    }

    public static int enableRescaleAudioVolume(RTCRoom room, boolean enable) {
        long nativeRoomHandle = getNativeRoomHandle(room);
        if (nativeRoomHandle == 0) {
            LogUtil.m216e(TAG, "room native handle is invalid, enableRescaleAudioVolume failed.");
            return -1;
        }
        return NativeRTCVideoFunctions.nativeEenableRescaleAudioVolume(nativeRoomHandle, enable);
    }

    @Deprecated
    public static int setPublishSpecialStream(RTCRoom room, int type) {
        long nativeRoomHandle = getNativeRoomHandle(room);
        if (nativeRoomHandle == 0) {
            LogUtil.m216e(TAG, "room native handle is invalid, setPublishSpecialStream failed.");
            return -1;
        }
        return NativeRTCVideoFunctions.nativeSetPublishSpecialStream(nativeRoomHandle, type);
    }

    public static int setPublishSpecialStream(RTCRoom room, StreamIndex streamIndex, int type) {
        long nativeRoomHandle = getNativeRoomHandle(room);
        if (nativeRoomHandle == 0) {
            LogUtil.m216e(TAG, "room native handle is invalid, setPublishSpecialStream failed.");
            return -1;
        }
        return NativeRTCVideoFunctions.nativeSetPublishSpecialStreamWithStreamIndex(nativeRoomHandle, streamIndex.value(), type);
    }

    public static int setSubscribeSpecialStream(RTCRoom room, int[] types) {
        long nativeRoomHandle = getNativeRoomHandle(room);
        if (nativeRoomHandle == 0) {
            LogUtil.m216e(TAG, "room native handle is invalid, setSubscribeSpecialStream failed.");
            return -1;
        }
        return NativeRTCVideoFunctions.nativeSetSubscribeSpecialStream(nativeRoomHandle, types);
    }

    public static boolean isStreamUnpublished(RTCRoom room, int type) {
        long nativeRoomHandle = getNativeRoomHandle(room);
        if (nativeRoomHandle == 0) {
            LogUtil.m216e(TAG, "room native handle is invalid, isStreamUnpublished failed.");
            return false;
        }
        return NativeRTCVideoFunctions.nativeIsStreamUnpublished(nativeRoomHandle, type);
    }

    public static int setVideoEncoderConfig(RTCEngine video, List<VideoEncoderConfig> channel_solutions, List<VideoEncoderConfig> channel_main_solutions) {
        LogUtil.m215d(TAG, "setVideoEncoderConfig ");
        long nativeVideoHandle = getNativeVideoHandle(video);
        if (nativeVideoHandle == 0) {
            LogUtil.m216e(TAG, "room native handle is invalid, isMuteLocalVideo failed.");
            return -1;
        }
        if (channel_solutions == null) {
            return -1;
        }
        ArrayList arrayList = new ArrayList();
        for (VideoEncoderConfig videoEncoderConfig : channel_solutions) {
            if (!videoEncoderConfig.isValid()) {
                LogUtil.m216e(TAG, "setVideoEncoderConfig with illegal params");
                return -1;
            }
            arrayList.add(new InternalVideoEncoderConfig(videoEncoderConfig));
        }
        if (channel_main_solutions == null) {
            return NativeRTCVideoFunctions.nativeSetVideoEncoderConfigWithMain(nativeVideoHandle, arrayList, null);
        }
        ArrayList arrayList2 = new ArrayList();
        for (VideoEncoderConfig videoEncoderConfig2 : channel_main_solutions) {
            if (!videoEncoderConfig2.isValid()) {
                LogUtil.m216e(TAG, "setVideoEncoderConfig with illegal params");
                return -1;
            }
            arrayList2.add(new InternalVideoEncoderConfig(videoEncoderConfig2));
        }
        return NativeRTCVideoFunctions.nativeSetVideoEncoderConfigWithMain(nativeVideoHandle, arrayList, arrayList2);
    }

    public static int enableSimulcastMode(RTCEngine video, boolean enable) {
        long nativeVideoHandle = getNativeVideoHandle(video);
        if (nativeVideoHandle == 0) {
            LogUtil.m216e(TAG, "video native handle is invalid, enableSimulcastMode failed.");
            return -1;
        }
        return NativeRTCVideoFunctions.nativeEnableSimulcastMode(nativeVideoHandle, enable);
    }

    public static void setSubscribeBaselineData(RTCRoom room, String userId, boolean isScreen, SubscribeVideoBaseline videoBaseline) {
        long nativeRoomHandle = getNativeRoomHandle(room);
        if (nativeRoomHandle == 0) {
            LogUtil.m216e(TAG, "room native handle is invalid, setSubscribeBaselineData failed.");
        } else {
            NativeRTCVideoFunctions.nativeSetSubscribeBaselineData(nativeRoomHandle, userId, isScreen, videoBaseline);
        }
    }

    public static IAmazingEffect getAmazingEffectInterface(RTCEngine video) {
        if (mGetAmazingEffectMethod == null) {
            try {
                Class<?> cls = Class.forName("com.ss.bytertc.engine.engineimpl.RTCEngineImpl");
                if (cls != null) {
                    mGetAmazingEffectMethod = cls.getMethod("getAmazingEffectInterface", new Class[0]);
                }
            } catch (Exception unused) {
                LogUtil.m216e(TAG, "fail to find method getAmazingEffectInterface");
            }
        }
        Method method = mGetAmazingEffectMethod;
        if (method == null) {
            return null;
        }
        try {
            return (IAmazingEffect) method.invoke(video, new Object[0]);
        } catch (Exception unused2) {
            LogUtil.m216e(TAG, "fail to invoke method getAmazingEffectInterface");
            return null;
        }
    }

    public static void setExternalSurface(RTCEngine video, RemoteStreamKey key, Surface externalSurface) {
        long nativeVideoHandle = getNativeVideoHandle(video);
        if (nativeVideoHandle == 0) {
            LogUtil.m216e(TAG, "room native handle is invalid, setExternalSurface failed.");
        } else {
            LogUtil.m218i(TAG, "setExternalSurface, roomId:" + key.roomId + ", userId: " + key.userId + ", index: " + key.streamIndex + ", externalSurface:" + externalSurface);
            NativeRTCVideoFunctions.nativeSetExternalSurface(nativeVideoHandle, key.roomId, key.userId, key.streamIndex.value(), externalSurface);
        }
    }

    public static int getUplinkNetworkBandwidthEstimationStatus(RTCRoom room) {
        long nativeRoomHandle = getNativeRoomHandle(room);
        if (nativeRoomHandle <= 0) {
            LogUtil.m216e(TAG, "room native handle is invalid, getUplinkNetworkBandwidthEstimationStatus failed.");
            return -1;
        }
        return NativeRTCVideoFunctions.nativeGetUplinkNetworkBandwidthEstimationStatus(nativeRoomHandle);
    }

    public static int getDownlinkNetworkBandwidthEstimationStatus(RTCRoom room) {
        long nativeRoomHandle = getNativeRoomHandle(room);
        if (nativeRoomHandle <= 0) {
            LogUtil.m216e(TAG, "room native handle is invalid, getUplinkNetworkBandwidthEstimationStatus failed.");
            return -1;
        }
        return NativeRTCVideoFunctions.nativeGetDownlinkNetworkBandwidthEstimationStatus(nativeRoomHandle);
    }

    public static int enableAutoSubscribe(RTCRoom room, SubscribeMode subModeAudio, SubscribeMode subModeVideo) {
        long nativeRoomHandle = getNativeRoomHandle(room);
        if (nativeRoomHandle <= 0) {
            LogUtil.m216e(TAG, "room native handle is invalid, enableAutoSubscribe failed.");
            return -1;
        }
        return NativeRTCVideoFunctions.nativeEnableAutoSubscribe(nativeRoomHandle, subModeAudio.value(), subModeVideo.value());
    }

    public static void writeLog(String fileName, int lineNum, String apiName, String level, String format) {
        NativeRTCVideoFunctions.nativeWriteLog(fileName, lineNum, apiName, level, format);
    }

    public static void setScreenVideoConfigs(RTCEngine video) {
        long nativeVideoHandle = getNativeVideoHandle(video);
        if (nativeVideoHandle == 0) {
            LogUtil.m216e(TAG, "video native handle is invalid, setScreenVideoConfigs failed.");
        } else {
            NativeRTCVideoFunctions.nativeSetScreenVideoConfigs(nativeVideoHandle);
        }
    }

    public static void resetScreenVideoConfigs(RTCEngine video) {
        long nativeVideoHandle = getNativeVideoHandle(video);
        if (nativeVideoHandle == 0) {
            LogUtil.m216e(TAG, "video native handle is invalid, resetScreenVideoConfigs failed.");
        } else {
            NativeRTCVideoFunctions.nativeResetScreenVideoConfigs(nativeVideoHandle);
        }
    }
}
