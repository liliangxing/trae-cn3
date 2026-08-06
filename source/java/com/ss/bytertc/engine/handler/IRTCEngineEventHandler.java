package com.ss.bytertc.engine.handler;

import com.ss.bytertc.engine.SysStats;
import com.ss.bytertc.engine.data.AudioRoute;
import com.ss.bytertc.engine.data.DeadLockMsg;
import com.ss.bytertc.engine.data.FrameUpdateInfo;
import com.ss.bytertc.engine.data.LocalAudioPropertiesInfo;
import com.ss.bytertc.engine.data.LocalAudioStreamError;
import com.ss.bytertc.engine.data.LocalAudioStreamState;
import com.ss.bytertc.engine.data.MultiLinkEnhancementMode;
import com.ss.bytertc.engine.data.MultiLinkEnhancementState;
import com.ss.bytertc.engine.data.MultiLinkStats;
import com.ss.bytertc.engine.data.RecordingInfo;
import com.ss.bytertc.engine.data.RecordingProgress;
import com.ss.bytertc.engine.data.RemoteAudioPropertiesInfo;
import com.ss.bytertc.engine.data.RemoteAudioState;
import com.ss.bytertc.engine.data.RemoteAudioStateChangeReason;
import com.ss.bytertc.engine.data.RemoteStreamKey;
import com.ss.bytertc.engine.data.StreamIndex;
import com.ss.bytertc.engine.data.StreamSycnInfoConfig;
import com.ss.bytertc.engine.data.VideoDenoiseMode;
import com.ss.bytertc.engine.data.VideoDenoiseModeChangedReason;
import com.ss.bytertc.engine.data.VideoFrameInfo;
import com.ss.bytertc.engine.data.VideoSuperResolutionMode;
import com.ss.bytertc.engine.data.VideoSuperResolutionModeChangedReason;
import com.ss.bytertc.engine.live.MixedStreamTaskErrorCode;
import com.ss.bytertc.engine.live.MixedStreamTaskEvent;
import com.ss.bytertc.engine.live.MixedStreamTaskInfo;
import com.ss.bytertc.engine.live.SingleStreamTaskErrorCode;
import com.ss.bytertc.engine.live.SingleStreamTaskEvent;
import com.ss.bytertc.engine.type.AudioAEDType;
import com.ss.bytertc.engine.type.AudioDeviceType;
import com.ss.bytertc.engine.type.AudioDumpStatus;
import com.ss.bytertc.engine.type.AudioRecordingErrorCode;
import com.ss.bytertc.engine.type.AudioRecordingState;
import com.ss.bytertc.engine.type.AudioVADType;
import com.ss.bytertc.engine.type.EchoTestResult;
import com.ss.bytertc.engine.type.EffectErrorType;
import com.ss.bytertc.engine.type.FirstFramePlayState;
import com.ss.bytertc.engine.type.FirstFrameSendState;
import com.ss.bytertc.engine.type.HardwareEchoDetectionResult;
import com.ss.bytertc.engine.type.LocalProxyError;
import com.ss.bytertc.engine.type.LocalProxyState;
import com.ss.bytertc.engine.type.LocalProxyType;
import com.ss.bytertc.engine.type.LocalVideoStreamError;
import com.ss.bytertc.engine.type.LocalVideoStreamState;
import com.ss.bytertc.engine.type.NetworkDetectionLinkType;
import com.ss.bytertc.engine.type.NetworkDetectionStopReason;
import com.ss.bytertc.engine.type.PerformanceAlarmMode;
import com.ss.bytertc.engine.type.PerformanceAlarmReason;
import com.ss.bytertc.engine.type.PublicStreamErrorCode;
import com.ss.bytertc.engine.type.RecordingErrorCode;
import com.ss.bytertc.engine.type.RecordingState;
import com.ss.bytertc.engine.type.RemoteStreamSwitch;
import com.ss.bytertc.engine.type.RemoteVideoState;
import com.ss.bytertc.engine.type.RemoteVideoStateChangeReason;
import com.ss.bytertc.engine.type.RenderError;
import com.ss.bytertc.engine.type.RtcUser;
import com.ss.bytertc.engine.type.SEIStreamUpdateEvent;
import com.ss.bytertc.engine.type.SourceWantedData;
import com.ss.bytertc.engine.type.VideoDeviceType;
import com.ss.bytertc.engine.utils.LogUtil;
import java.nio.ByteBuffer;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class IRTCEngineEventHandler {
    public void onActiveSpeaker(String roomId, String uid) {
    }

    public void onAudioAEDStateUpdate(AudioAEDType state) {
    }

    public void onAudioDeviceStateChanged(String deviceID, AudioDeviceType deviceType, int deviceState, int deviceError) {
    }

    public void onAudioDeviceWarning(String deviceID, AudioDeviceType deviceType, int deviceWarning) {
    }

    public void onAudioDumpStateChanged(AudioDumpStatus status) {
    }

    public void onAudioFramePlayStateChanged(String roomId, RtcUser user, FirstFramePlayState state) {
    }

    public void onAudioFrameSendStateChanged(String roomId, RtcUser user, FirstFrameSendState state) {
    }

    public void onAudioMixingPlayingProgress(int mixId, long progress) {
    }

    public void onAudioPlaybackDeviceTestVolume(int volume) {
    }

    public void onAudioRecordingStateUpdate(AudioRecordingState state, AudioRecordingErrorCode errorCode) {
    }

    public void onAudioRouteChanged(AudioRoute route) {
    }

    public void onAudioVADStateUpdate(AudioVADType state) {
    }

    public void onCloudProxyConnected(int interval) {
    }

    public void onConnectionStateChanged(int state, int reason) {
    }

    public void onDeadLockError(DeadLockMsg deadLockMsg) {
    }

    public void onEchoTestResult(EchoTestResult result) {
    }

    public void onEffectError(EffectErrorType error, String msg) {
    }

    public void onError(int err) {
    }

    public void onExperimentalCallback(String param) {
    }

    public void onExtensionAccessError(String extensionName, String msg) {
    }

    public void onExternalScreenFrameUpdate(FrameUpdateInfo info) {
    }

    public void onFirstLocalAudioFrame(StreamIndex streamIndex) {
    }

    public void onFirstLocalVideoFrameCaptured(StreamIndex streamIndex, VideoFrameInfo frameInfo) {
    }

    public void onFirstLocalVideoFrameRendered(StreamIndex streamIndex, VideoFrameInfo frameInfo) {
    }

    public void onFirstRemoteAudioFrame(RemoteStreamKey remoteStreamKey) {
    }

    public void onFirstRemoteVideoFrameDecoded(RemoteStreamKey remoteStreamKey, VideoFrameInfo frameInfo) {
    }

    public void onFirstRemoteVideoFrameRendered(RemoteStreamKey remoteStreamKey, VideoFrameInfo frameInfo) {
    }

    public void onGetPeerOnlineStatus(String peerUserId, int status) {
    }

    public void onHardwareEchoDetectionResult(HardwareEchoDetectionResult hardwareEchoDetectionResult) {
    }

    public void onLicenseWillExpire(int days) {
    }

    public void onLocalAudioPropertiesReport(LocalAudioPropertiesInfo[] audioPropertiesInfos) {
    }

    public void onLocalAudioStateChanged(LocalAudioStreamState state, LocalAudioStreamError error) {
    }

    public void onLocalProxyStateChanged(LocalProxyType localProxyType, LocalProxyState localProxyState, LocalProxyError localProxyError) {
    }

    public void onLocalVideoSizeChanged(StreamIndex streamIndex, VideoFrameInfo frameInfo) {
    }

    public void onLocalVideoStateChanged(StreamIndex streamIndex, LocalVideoStreamState state, LocalVideoStreamError error) {
    }

    public void onLogReport(String logType, JSONObject logContent) {
    }

    public void onLoggerMessage(LogUtil.LogLevel level, String msg, Throwable throwable) {
    }

    public void onLoginResult(String uid, int errorCode, int elapsed) {
    }

    public void onLogout(int reason) {
    }

    public void onMixedStreamEvent(MixedStreamTaskInfo info, MixedStreamTaskEvent event, MixedStreamTaskErrorCode error) {
    }

    public void onMultiLinkEnhancementStateChanged(MultiLinkEnhancementState state, MultiLinkEnhancementMode mode) {
    }

    public void onMultiLinkEnhancementStats(MultiLinkStats[] stats) {
    }

    public void onNetworkDetectionResult(NetworkDetectionLinkType type, int quality, int rtt, double lostRate, int bitrate, int jitter) {
    }

    public void onNetworkDetectionStopped(NetworkDetectionStopReason reason) {
    }

    public void onNetworkTimeSynchronized() {
    }

    public void onNetworkTypeChanged(int type) {
    }

    public void onPerformanceAlarms(PerformanceAlarmMode mode, String roomId, PerformanceAlarmReason reason, SourceWantedData data) {
    }

    public void onPushPublicStreamResult(String roomId, String publicStreamId, PublicStreamErrorCode error) {
    }

    public void onRecordingProgressUpdate(StreamIndex type, RecordingProgress progress, RecordingInfo info) {
    }

    public void onRecordingStateUpdate(StreamIndex type, RecordingState state, RecordingErrorCode errorCode, RecordingInfo info) {
    }

    public void onRemoteAudioPropertiesReport(RemoteAudioPropertiesInfo[] audioPropertiesInfos, int totalRemoteVolume) {
    }

    public void onRemoteAudioPropertiesReportEx(RemoteAudioPropertiesInfo[] audioPropertiesInfos) {
    }

    public void onRemoteAudioStateChanged(RemoteStreamKey key, RemoteAudioState state, RemoteAudioStateChangeReason reason) {
    }

    public void onRemoteRenderError(RemoteStreamKey key, RenderError error, String message) {
    }

    public void onRemoteVideoSizeChanged(RemoteStreamKey remoteStreamKey, VideoFrameInfo frameInfo) {
    }

    public void onRemoteVideoStateChanged(RemoteStreamKey streamKey, RemoteVideoState videoState, RemoteVideoStateChangeReason videoStateReason) {
    }

    public void onRemoteVideoSuperResolutionModeChanged(RemoteStreamKey streamKey, VideoSuperResolutionMode mode, VideoSuperResolutionModeChangedReason reason) {
    }

    public void onSEIMessageReceived(RemoteStreamKey remoteStreamKey, ByteBuffer message) {
    }

    public void onSEIStreamUpdate(RemoteStreamKey remoteStreamKey, SEIStreamUpdateEvent event) {
    }

    public void onScreenVideoFramePlayStateChanged(String roomId, RtcUser user, FirstFramePlayState state) {
    }

    public void onScreenVideoFrameSendStateChanged(String roomId, RtcUser user, FirstFrameSendState state) {
    }

    public void onServerMessageSendResult(long msgid, int error, ByteBuffer message) {
    }

    public void onServerParamsSetResult(int error) {
    }

    public void onSimulcastSubscribeFallback(RemoteStreamSwitch event) {
    }

    public void onSingleStreamEvent(String taskId, SingleStreamTaskEvent event, SingleStreamTaskErrorCode error) {
    }

    public void onStreamSyncInfoReceived(RemoteStreamKey streamKey, StreamSycnInfoConfig.SyncInfoStreamType streamType, ByteBuffer data) {
    }

    public void onSysStats(SysStats stats) {
    }

    public void onUserBinaryMessageReceivedOutsideRoom(long msgid, String uid, ByteBuffer message) {
    }

    public void onUserBinaryMessageReceivedOutsideRoom(String uid, ByteBuffer message) {
    }

    public void onUserMessageReceivedOutsideRoom(long msgid, String uid, String message) {
    }

    public void onUserMessageReceivedOutsideRoom(String uid, String message) {
    }

    public void onUserMessageSendResultOutsideRoom(long msgid, int error) {
    }

    public void onUserStartAudioCapture(String roomId, String uid) {
    }

    public void onUserStartVideoCapture(String roomId, String uid) {
    }

    public void onUserStopAudioCapture(String roomId, String uid) {
    }

    public void onUserStopVideoCapture(String roomId, String uid) {
    }

    public void onVideoDenoiseModeChanged(VideoDenoiseMode mode, VideoDenoiseModeChangedReason reason) {
    }

    public void onVideoDeviceStateChanged(String deviceID, VideoDeviceType deviceType, int deviceState, int deviceError) {
    }

    public void onVideoDeviceWarning(String deviceID, VideoDeviceType deviceType, int deviceWarning) {
    }

    public void onVideoFramePlayStateChanged(String roomId, RtcUser user, FirstFramePlayState state) {
    }

    public void onVideoFrameSendStateChanged(String roomId, RtcUser user, FirstFrameSendState state) {
    }

    public void onWarning(int warn) {
    }
}
