package com.ss.bytertc.engine;

import com.ss.bytertc.engine.handler.RTCRoomEventHandler;
import com.ss.bytertc.engine.handler.RTCRoomEventHandlerAIGC;
import com.ss.bytertc.engine.handler.RTCRoomEventHandlerEx;
import com.ss.bytertc.engine.handler.RTCRoomEventHandlerRts;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class NativeRTCRoomFunctions {
    public static native int nativeClearAudioCache(long byteRtcRoomPtr);

    public static native void nativeDestory(long byteRtcRoomPtr);

    public static native void nativeDestroyRTSRoom(long byteRtcRoomPtr);

    public static native int nativeEnableAudioCache(long byteRtcRoomPtr, boolean enable);

    public static native int nativeEnableSubscribeLocalStream(long byteRtcRoomPtr, boolean enable);

    public static native long nativeGetPanoramicVideo(long byteRtcRoomPtr);

    public static native long nativeGetRangeAudio(long byteRtcRoomPtr);

    public static native String nativeGetRoomId(long byteRtcRoomPtr);

    public static native long nativeGetSpatialAudio(long byteRtcRoomPtr);

    public static native int nativeJoinRTSRoom(long byteRtcRoomPtr, String token, UserInfo userInfo);

    public static native int nativeJoinRoomWithRoomConfig(long byteRtcRoomPtr, String token, UserInfo userInfo, boolean userVisibility, RTCRoomConfig multiRoomConfig);

    public static native int nativeLeaveRTSRoom(long byteRtcRoomPtr);

    public static native int nativeLeaveRoom(long byteRtcRoomPtr, String extra_info);

    public static native int nativePauseAllSubscribedStreamAudio(long byteRtcRoomPtr);

    public static native int nativePauseAllSubscribedStreamVideo(long byteRtcRoomPtr);

    public static native int nativePauseForwardStreamToAllRooms(long enginePtr);

    public static native int nativePublishScreenAudio(long enginePtr, boolean publish);

    public static native int nativePublishScreenVideo(long enginePtr, boolean publish);

    public static native int nativePublishStreamAudio(long enginePtr, boolean publish);

    public static native int nativePublishStreamEx(long byteRtcRoomPtr, int streamIndex, int type);

    public static native int nativePublishStreamVideo(long enginePtr, boolean publish);

    public static native void nativeReleaseRTCRoomEventHandler(long byteRtcRoomEventHandlerPtr);

    public static native void nativeReleaseRTCRoomEventHandlerAIGC(long byteRtcRoomEventHandlerAIGCPtr);

    public static native void nativeReleaseRTCRoomEventHandlerEx(long byteRtcRoomEventHandlerExPtr);

    public static native void nativeReleaseRTCRoomEventHandlerRts(long byteRtcRoomEventHandlerRtsPtr);

    public static native int nativeResumeAllSubscribedStreamAudio(long byteRtcRoomPtr);

    public static native int nativeResumeAllSubscribedStreamVideo(long byteRtcRoomPtr);

    public static native int nativeResumeForwardStreamToAllRooms(long enginePtr);

    public static native long nativeSendControlBinaryMessage(long byteRtcRoomPtr, String type, String action, byte[] buffer);

    public static native long nativeSendRTSRoomBinaryMessage(long byteRtcRoomPtr, byte[] buffer);

    public static native long nativeSendRTSRoomMessage(long byteRtcRoomPtr, String message);

    public static native long nativeSendRTSUserBinaryMessage(long byteRtcRoomPtr, String uid, byte[] buffer, int config);

    public static native long nativeSendRTSUserMessage(long byteRtcRoomPtr, String uid, String message, int config);

    public static native long nativeSendRoomBinaryMessage(long byteRtcRoomPtr, byte[] buffer);

    public static native long nativeSendRoomMessage(long byteRtcRoomPtr, String message);

    public static native long nativeSendUserBinaryMessage(long byteRtcRoomPtr, String uid, byte[] buffer, int config);

    public static native long nativeSendUserMessage(long byteRtcRoomPtr, String uid, String message, int config);

    public static native int nativeSetAudioSelectionConfig(long byteRtcRoomPtr, int audio_selection_priority);

    public static native int nativeSetMultiDeviceAVSync(long byteRtcRoomPtr, String audioUserId);

    public static native long nativeSetRTCRoomEventHandler(long byteRtcRoomPtr, RTCRoomEventHandler eventHandler);

    public static native long nativeSetRTCRoomEventHandlerAIGC(long byteRtcRoomPtr, RTCRoomEventHandlerAIGC eventHandlerAIGC);

    public static native long nativeSetRTCRoomEventHandlerEx(long byteRtcRoomPtr, RTCRoomEventHandlerEx eventHandlerEx);

    public static native long nativeSetRTCRoomEventHandlerRts(long byteRtcRoomPtr, RTCRoomEventHandlerRts eventHandlerRts);

    public static native int nativeSetRemoteRoomAudioPlaybackVolume(long byteRtcRoomPtr, int volume);

    public static native int nativeSetRemoteSimulcastStreamType(long enginePtr, String userId, int streamType);

    public static native int nativeSetRemoteVideoConfigEx(long byteRtcRoomPtr, String userId, int streamIndex, int width, int height, int framerate);

    public static native long nativeSetRoomExtraInfo(long byteRtcRoomPtr, String key, String value);

    public static native int nativeSetUserVisibility(long enginePtr, boolean enable);

    public static native int nativeStartForwardStreamToRooms(long enginePtr, List<InternalForwardStreamInfo> forwardStreamInfos);

    public static native int nativeStartForwardStreamToRoomsWithRoomGroupId(long enginePtr, List<InternalForwardStreamInfo> forwardStreamInfos, String roomGroupId);

    public static native int nativeStartSession(long byteRtcRoomPtr, String token, UserInfo userInfo, RTCRoomConfig roomConfig, String type, String action, String message, int timeout, boolean joinRoomNeedSdp, String fgConfig);

    public static native int nativeStartSubtitle(long byteRtcRoomPtr, int value, String targetLanguage);

    public static native int nativeStopForwardStreamToRooms(long enginePtr);

    public static native int nativeStopSession(long byteRtcRoomPtr);

    public static native int nativeStopSubtitle(long byteRtcRoomPtr);

    public static native int nativeSubscribeAllStreamsAudio(long enginePtr, boolean subscribe);

    public static native int nativeSubscribeAllStreamsVideo(long enginePtr, boolean subscirbe);

    public static native int nativeSubscribeScreenAudio(long enginePtr, String userId, boolean subscribe);

    public static native int nativeSubscribeScreenVideo(long enginePtr, String userId, boolean subscribe);

    public static native int nativeSubscribeStreamAudio(long enginePtr, String userId, boolean subscribe);

    public static native int nativeSubscribeStreamEx(long byteRtcRoomPtr, String userId, int streamIndex, int type);

    public static native int nativeSubscribeStreamVideo(long enginePtr, String userId, boolean subscribe);

    public static native int nativeUnpublishStreamEx(long byteRtcRoomPtr, int streamIndex, int type);

    public static native int nativeUnsubscribeStreamEx(long byteRtcRoomPtr, String userId, int streamIndex, int type);

    public static native int nativeUpdateForwardStreamToRooms(long enginePtr, List<InternalForwardStreamInfo> forwardStreamInfos);

    public static native int nativeUpdateForwardStreamToRoomsWithRoomGroupId(long enginePtr, List<InternalForwardStreamInfo> forwardStreamInfos, String roomGroupId);

    public static native int nativeUpdateRTSToken(long byteRtcRoomPtr, String token);

    public static native int nativeUpdateToken(long byteRtcRoomPtr, String token);
}
