package com.ss.bytertc.engine.handler;

import android.util.Log;
import com.ss.bytertc.engine.InternalLocalStreamStats;
import com.ss.bytertc.engine.InternalRTCUser;
import com.ss.bytertc.engine.InternalRemoteStreamStats;
import com.ss.bytertc.engine.InternalRemoteStreamSwitch;
import com.ss.bytertc.engine.InternalSourceWantedData;
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
import com.ss.bytertc.engine.data.StreamKey;
import com.ss.bytertc.engine.data.StreamSycnInfoConfig;
import com.ss.bytertc.engine.data.VideoDenoiseMode;
import com.ss.bytertc.engine.data.VideoDenoiseModeChangedReason;
import com.ss.bytertc.engine.data.VideoFrameInfo;
import com.ss.bytertc.engine.data.VideoSuperResolutionMode;
import com.ss.bytertc.engine.data.VideoSuperResolutionModeChangedReason;
import com.ss.bytertc.engine.engineimpl.RTCEngineImpl;
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
import com.ss.bytertc.engine.type.LocalStreamStats;
import com.ss.bytertc.engine.type.LocalVideoStreamError;
import com.ss.bytertc.engine.type.LocalVideoStreamState;
import com.ss.bytertc.engine.type.NetworkDetectionLinkType;
import com.ss.bytertc.engine.type.NetworkDetectionStopReason;
import com.ss.bytertc.engine.type.PerformanceAlarmMode;
import com.ss.bytertc.engine.type.PerformanceAlarmReason;
import com.ss.bytertc.engine.type.PublicStreamErrorCode;
import com.ss.bytertc.engine.type.RecordingErrorCode;
import com.ss.bytertc.engine.type.RecordingState;
import com.ss.bytertc.engine.type.RemoteStreamStats;
import com.ss.bytertc.engine.type.RemoteStreamSwitch;
import com.ss.bytertc.engine.type.RemoteVideoState;
import com.ss.bytertc.engine.type.RemoteVideoStateChangeReason;
import com.ss.bytertc.engine.type.RenderError;
import com.ss.bytertc.engine.type.RtcUser;
import com.ss.bytertc.engine.type.SEIStreamUpdateEvent;
import com.ss.bytertc.engine.type.SourceWantedData;
import com.ss.bytertc.engine.type.VideoDeviceType;
import com.ss.bytertc.engine.utils.LogUtil;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class RTCVideoEventHandler {
    private static final String TAG = "RtcVideoEventHandler";
    private static final String WEBRTC_MEDIA_STAT_KEY = "rtc_media_statistics";
    private static final String WEBRTC_MONITOR_TAG = "live_webrtc_monitor_log";
    private static final String WEBRTC_STATISTICS_KEY = "rtc_statistics";
    private static final String WEBRTC_TRANSPORT_STAT_KEY = "rtc_transport_statistics";
    private WeakReference<RTCEngineImpl> mRTCVideoImpl;
    private String mRoom;
    private String mSession;
    private String mUser;
    private State mState = State.IDLE;
    private long mJoinChannelTime = 0;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private enum State {
        IDLE,
        IN_ROOM
    }

    public RTCVideoEventHandler(RTCEngineImpl RTCVideoImpl) {
        this.mRTCVideoImpl = new WeakReference<>(RTCVideoImpl);
    }

    public void setJoinChannelTime(long time) {
        this.mJoinChannelTime = time;
    }

    public void onError(int errorNum) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onError...errorNum: " + errorNum);
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onError(errorNum);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onError callback catch exception.\n" + e.getMessage());
        }
    }

    public void onDeadLockError(DeadLockMsg deadlockMsg) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onDeadLockError...: " + deadlockMsg);
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onDeadLockError(deadlockMsg);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onDeadLockError callback catch exception.\n" + e.getMessage());
        }
    }

    public void onExtensionAccessError(String extensionName, String msg) {
        IRTCEngineEventHandler rtcEngineHandler;
        Log.e(TAG, "onExtensionAccessError...extensionName: " + extensionName + " msg:" + msg);
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onExtensionAccessError(extensionName, msg);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onExtensionAccessError callback catch exception.\n" + e.getMessage());
        }
    }

    public void onWarning(int warnNum) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onWarning, warnNum: " + warnNum);
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onWarning(warnNum);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onWarning callback catch exception.\n" + e.getMessage());
        }
    }

    public void onSysStats(SysStats stats) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onSysStats... " + stats.toString());
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onSysStats(stats);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onSysStats callback catch exception.\n" + e.getMessage());
        }
    }

    public void onUserStartVideoCapture(String roomId, String uid) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onUserStartVideoCapture... uid: " + uid + ", roomId: " + roomId);
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onUserStartVideoCapture(roomId, uid);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onUserStartVideoCapture callback catch exception.\n" + e.getMessage());
        }
    }

    public void onUserStopVideoCapture(String roomId, String uid) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onUserStopVideoCapture... uid: " + uid + ", roomId: " + roomId);
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onUserStopVideoCapture(roomId, uid);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onUserStopVideoCapture callback catch exception.\n" + e.getMessage());
        }
    }

    public void onUserStartAudioCapture(String roomId, String uid) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onUserStartAudioCapture... uid: " + uid + ", roomId: " + roomId);
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onUserStartAudioCapture(roomId, uid);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onUserStartAudioCapture callback catch exception.\n" + e.getMessage());
        }
    }

    public void onUserStopAudioCapture(String roomId, String uid) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onUserStopAudioCapture... uid: " + uid);
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onUserStopAudioCapture(roomId, uid);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onUserStopAudioCapture callback catch exception.\n" + e.getMessage());
        }
    }

    public void onLocalAudioStateChanged(LocalAudioStreamState state, LocalAudioStreamError error) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onLocalAudioStateChanged...");
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onLocalAudioStateChanged(state, error);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onLocalAudioStateChanged callback catch exception.\n" + e.getMessage());
        }
    }

    public void onRemoteAudioStateChanged(RemoteStreamKey key, RemoteAudioState state, RemoteAudioStateChangeReason reason) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onRemoteAudioStateChanged...");
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onRemoteAudioStateChanged(key, state, reason);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onRemoteAudioStateChanged callback catch exception.\n" + e.getMessage());
        }
    }

    public void onLocalVideoStateChanged(StreamIndex index, LocalVideoStreamState state, LocalVideoStreamError error) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onLocalVideoStateChanged...");
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onLocalVideoStateChanged(index, state, error);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onLocalVideoStateChanged callback catch exception.\n" + e.getMessage());
        }
    }

    public void onRemoteVideoStateChanged(RemoteStreamKey streamKey, RemoteVideoState videoState, RemoteVideoStateChangeReason videoStateReason) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onRemoteVideoStateChanged...");
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onRemoteVideoStateChanged(streamKey, videoState, videoStateReason);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onRemoteVideoStateChanged callback catch exception.\n" + e.getMessage());
        }
    }

    public void onRemoteVideoSuperResolutionModeChanged(RemoteStreamKey streamKey, VideoSuperResolutionMode mode, VideoSuperResolutionModeChangedReason reason) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onRemoteVideoSuperResolutionModeChanged...");
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onRemoteVideoSuperResolutionModeChanged(streamKey, mode, reason);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onRemoteVideoSuperResolutionModeChanged callback catch exception.\n" + e.getMessage());
        }
    }

    public void onVideoDenoiseModeChanged(VideoDenoiseMode mode, VideoDenoiseModeChangedReason reason) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onVideoDenoiseModeChanged...");
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onVideoDenoiseModeChanged(mode, reason);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onVideoDenoiseModeChanged callback catch exception.\n" + e.getMessage());
        }
    }

    public void onAudioRouteChanged(AudioRoute device) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onAudioRouteChanged...device: " + device.value());
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onAudioRouteChanged(device);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onAudioRouteChanged callback catch exception.\n" + e.getMessage());
        }
    }

    public void onFirstLocalAudioFrame(StreamIndex streamIndex) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onFirstLocalAudioFrame...streamIndex: " + streamIndex.value());
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onFirstLocalAudioFrame(streamIndex);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onFirstLocalAudioFrame callback catch exception.\n" + e.getMessage());
        }
    }

    public void onFirstRemoteAudioFrame(RemoteStreamKey remoteStreamKey) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onFirstRemoteAudioFrame...uid: " + remoteStreamKey.getUserId() + ", roomid: " + remoteStreamKey.getRoomId() + ", streamIndex: " + remoteStreamKey.getStreamIndex().value());
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onFirstRemoteAudioFrame(remoteStreamKey);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onFirstRemoteAudioFrame callback catch exception.\n" + e.getMessage());
        }
    }

    public void onFirstLocalVideoFrameCaptured(StreamIndex streamIndex, VideoFrameInfo videoFrameInfo) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onFirstLocalVideoFrame...width: " + videoFrameInfo.getWidth() + ", height: " + videoFrameInfo.getHeight());
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onFirstLocalVideoFrameCaptured(streamIndex, videoFrameInfo);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onFirstLocalVideoFrame callback catch exception.\n" + e.getMessage());
        }
    }

    public void onFirstLocalVideoFrameRendered(StreamIndex streamIndex, VideoFrameInfo videoFrameInfo) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onFirstLocalVideoFrameRendered...width: " + videoFrameInfo.getWidth() + ", height: " + videoFrameInfo.getHeight() + ", streamIndex: " + streamIndex);
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onFirstLocalVideoFrameRendered(streamIndex, videoFrameInfo);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onFirstLocalVideoFrameRendered callback catch exception.\n" + e.getMessage());
        }
    }

    public void onFirstRemoteVideoFrameRendered(RemoteStreamKey streamKey, VideoFrameInfo videoFrameInfo) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onFirstRemoteVideoFrameRendered...uid: " + streamKey.getUserId() + ", StreamIndex:" + streamKey.getStreamIndex() + ", width: " + videoFrameInfo.getWidth() + ", height: " + videoFrameInfo.getHeight());
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onFirstRemoteVideoFrameRendered(streamKey, videoFrameInfo);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onFirstRemoteVideoFrameRendered callback catch exception.\n" + e.getMessage());
        }
    }

    public void onFirstRemoteVideoFrameDecoded(RemoteStreamKey streamKey, VideoFrameInfo videoFrameInfo) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onFirstRemoteVideoFrameDecoded...uid: " + streamKey.getUserId() + ", StreamIndex:" + streamKey.getStreamIndex() + ", width: " + videoFrameInfo.getWidth() + ", height: " + videoFrameInfo.getHeight());
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onFirstRemoteVideoFrameDecoded(streamKey, videoFrameInfo);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onFirstRemoteVideoFrameDecoded callback catch exception.\n" + e.getMessage());
        }
    }

    public void onLocalVideoSizeChanged(StreamIndex streamIndex, VideoFrameInfo frameInfo) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onLocalVideoSizeChanged... streamIndex: " + streamIndex + ", frameInfo: " + frameInfo);
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onLocalVideoSizeChanged(streamIndex, frameInfo);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onLocalVideoSizeChanged callback catch exception.\n" + e.getMessage());
        }
    }

    public void onRemoteVideoSizeChanged(RemoteStreamKey streamKey, VideoFrameInfo frameInfo) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onRemoteVideoSizeChanged... RemoteStreamKey: " + streamKey + ", frameInfo: " + frameInfo);
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onRemoteVideoSizeChanged(streamKey, frameInfo);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onRemoteVideoSizeChanged callback catch exception.\n" + e.getMessage());
        }
    }

    public void onLogReport(String logType, String logContent) {
        IRTCEngineEventHandler rtcEngineHandler;
        try {
            if (WEBRTC_MONITOR_TAG.equals(logType)) {
                try {
                    JSONObject jSONObject = new JSONObject(logContent);
                    RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
                    if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                        return;
                    }
                    rtcEngineHandler.onLogReport(logType, jSONObject);
                    return;
                } catch (JSONException e) {
                    LogUtil.m215d(TAG, "onLogReport...parse json catch exception: " + e.getMessage());
                    return;
                }
            }
            LogUtil.m218i(logType, logContent);
        } catch (Exception e2) {
            LogUtil.m216e(TAG, "onLogReport callback catch exception.\n" + e2.getMessage());
        }
    }

    public static ByteBuffer allocateDirectByteBuffer(int capacity) {
        return ByteBuffer.allocateDirect(capacity);
    }

    public void onSEIMessageReceived(RemoteStreamKey key, ByteBuffer msg) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onSEIMessageReceived" + key.getRoomId() + key.getUserId());
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onSEIMessageReceived(key, msg);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onSEIMessageReceived callback catch exception.\n" + e.getMessage());
        }
    }

    public void onSEIStreamUpdate(RemoteStreamKey key, int event) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onSEIStreamUpdate" + key.getRoomId() + key.getUserId());
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onSEIStreamUpdate(key, SEIStreamUpdateEvent.values()[event]);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onSEIStreamUpdate callback catch exception.\n" + e.getMessage());
        }
    }

    public void onLoginResult(String uid, int error_code, int elapsed) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "OnLoginResult: " + uid + error_code + elapsed);
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onLoginResult(uid, error_code, elapsed);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onLoginResult callback catch exception.\n" + e.getMessage());
        }
    }

    public void onLogout(int reason) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onLogout: " + reason);
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onLogout(reason);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onLogout callback catch exception.\n" + e.getMessage());
        }
    }

    public void onServerParamsSetResult(int error) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onServerParamsSetResult: " + error);
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onServerParamsSetResult(error);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onServerParamsSetResult callback catch exception.\n" + e.getMessage());
        }
    }

    public void onGetPeerOnlineStatus(String peerUserId, int status) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onGetPeerOnlineStatus: " + peerUserId + status);
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onGetPeerOnlineStatus(peerUserId, status);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onGetPeerOnlineStatus callback catch exception.\n" + e.getMessage());
        }
    }

    public void onUserMessageReceivedOutsideRoom(String uid, String message, long msgid) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onUserMessageReceivedOutsideRoom: " + uid + message);
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onUserMessageReceivedOutsideRoom(uid, message);
            rtcEngineHandler.onUserMessageReceivedOutsideRoom(msgid, uid, message);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onUserMessageReceivedOutsideRoom callback catch exception.\n" + e.getMessage());
        }
    }

    public void onUserBinaryMessageReceivedOutsideRoom(String uid, ByteBuffer message, long msgid) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onUserBinaryMessageReceivedOutsideRoom: " + uid + message.capacity());
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onUserBinaryMessageReceivedOutsideRoom(uid, message.duplicate());
            rtcEngineHandler.onUserBinaryMessageReceivedOutsideRoom(msgid, uid, message);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onUserBinaryMessageReceivedOutsideRoom callback catch exception.\n" + e.getMessage());
        }
    }

    public void onUserMessageSendResultOutsideRoom(long msgid, int error) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onUserMessageSendResultOutsideRoom: " + msgid + error);
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onUserMessageSendResultOutsideRoom(msgid, error);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onUserMessageSendResultOutsideRoom callback catch exception.\n" + e.getMessage());
        }
    }

    public void onServerMessageSendResult(long msgid, int error, ByteBuffer message) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onServerMessageSendResult: " + msgid + error);
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onServerMessageSendResult(msgid, error, message);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onServerMessageSendResult callback catch exception.\n" + e.getMessage());
        }
    }

    public void onNetworkProbeResult(int type, int quality, int rtt, double lost_rate, int bitrate, int jitter) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onNetworkProbeResult: " + type + Constants.ACCEPT_TIME_SEPARATOR_SP + quality + Constants.ACCEPT_TIME_SEPARATOR_SP + rtt + Constants.ACCEPT_TIME_SEPARATOR_SP + lost_rate + Constants.ACCEPT_TIME_SEPARATOR_SP + bitrate + Constants.ACCEPT_TIME_SEPARATOR_SP + jitter);
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onNetworkDetectionResult(NetworkDetectionLinkType.values()[type], quality, rtt, lost_rate, bitrate, jitter);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onNetworkDetectionResult callback catch exception.\n" + e.getMessage());
        }
    }

    public void onNetworkProbeStopped(int err_code) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onNetworkProbeStopped: " + err_code);
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onNetworkDetectionStopped(NetworkDetectionStopReason.values()[err_code]);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onNetworkDetectionStopped callback catch exception.\n" + e.getMessage());
        }
    }

    public void onConnectionStateChanged(int state) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onConnectionStateChanged, state: " + state);
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onConnectionStateChanged(state, -1);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onConnectionStateChanged callback catch exception.\n" + e.getMessage());
        }
    }

    public void onNetworkTypeChanged(int type) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onNetworkTypeChanged, type: " + type);
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onNetworkTypeChanged(type);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onNetworkTypeChanged callback catch exception.\n" + e.getMessage());
        }
    }

    public void onSimulcastSubscribeFallback(InternalRemoteStreamSwitch event) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onSimulcastSubscribeFallback, uid: " + event.uid + ", before_video_index: " + event.beforeVideoIndex + ", after_video_index: " + event.afterVideoIndex + ", before_enable: " + event.beforeEnable + ", after_enable: " + event.afterEnable + ", reason: " + event.reason);
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onSimulcastSubscribeFallback(new RemoteStreamSwitch(event));
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onNetworkTypeChanged callback catch exception.\n" + e.getMessage());
        }
    }

    public void onPerformanceAlarms(int mode, String roomId, int reason, InternalSourceWantedData data) {
        PerformanceAlarmReason performanceAlarmReason;
        PerformanceAlarmMode performanceAlarmMode;
        LogUtil.m215d(TAG, "onPerformanceAlarms, level: " + reason + ", data: " + data);
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl != null) {
                if (reason == 0) {
                    performanceAlarmReason = PerformanceAlarmReason.BANDWIDTH_FALLBACKED;
                } else if (reason == 1) {
                    performanceAlarmReason = PerformanceAlarmReason.BANDWIDTH_RESUMED;
                } else if (reason == 2) {
                    performanceAlarmReason = PerformanceAlarmReason.PERFORMANCE_FALLBACKED;
                } else if (reason == 3) {
                    performanceAlarmReason = PerformanceAlarmReason.PERFORMANCE_RESUMED;
                } else {
                    performanceAlarmReason = PerformanceAlarmReason.PERFORMANCE_RESUMED;
                }
                IRTCEngineEventHandler rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler();
                if (rtcEngineHandler != null) {
                    if (mode == 0) {
                        performanceAlarmMode = PerformanceAlarmMode.NORMAL;
                    } else {
                        performanceAlarmMode = PerformanceAlarmMode.SIMULCAST;
                    }
                    rtcEngineHandler.onPerformanceAlarms(performanceAlarmMode, roomId, performanceAlarmReason, new SourceWantedData(data));
                }
            }
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onPerformanceAlarms callback catch exception.\n" + e.getMessage());
        }
    }

    public void onAudioDeviceStateChanged(String device_id, AudioDeviceType device_type, int device_state, int device_error) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onAudioDeviceStateChanged, AudioDeviceType: " + device_type + ", device_state: " + device_state);
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onAudioDeviceStateChanged(device_id, device_type, device_state, device_error);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onAudioDeviceStateChanged callback catch exception.\n" + e.getMessage());
        }
    }

    public void onVideoDeviceStateChanged(String device_id, VideoDeviceType device_type, int device_state, int device_error) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onVideoDeviceStateChanged, VideoDeviceType: " + device_type + ", device_state: " + device_state);
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onVideoDeviceStateChanged(device_id, device_type, device_state, device_error);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onVideoDeviceStateChanged callback catch exception.\n" + e.getMessage());
        }
    }

    public void onAudioDeviceWarning(String device_id, AudioDeviceType device_type, int device_warning) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onAudioDeviceWarning, AudioDeviceType: " + device_type + ", device_warning " + device_warning);
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onAudioDeviceWarning(device_id, device_type, device_warning);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onAudioDeviceWarning callback catch exception.\n" + e.getMessage());
        }
    }

    public void onVideoDeviceWarning(String device_id, VideoDeviceType device_type, int device_warning) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onVideoDeviceWarning, VideoDeviceType: " + device_type + ", device_warning " + device_warning);
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onVideoDeviceWarning(device_id, device_type, device_warning);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onVideoDeviceWarning callback catch exception.\n" + e.getMessage());
        }
    }

    public void onAudioFrameSendStateChanged(String roomId, InternalRTCUser user, int index, int state) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onAudioFrameSendStateChanged,  state: " + state);
        FirstFrameSendState firstFrameSendState = FirstFrameSendState.FIRST_FRAME_SEND_STATE_SENDING;
        if (state == 0) {
            firstFrameSendState = FirstFrameSendState.FIRST_FRAME_SEND_STATE_SENDING;
        } else if (state == 1) {
            firstFrameSendState = FirstFrameSendState.FIRST_FRAME_SEND_STATE_SENT;
        } else if (state == 2) {
            firstFrameSendState = FirstFrameSendState.FIRST_FRAME_SEND_STAT_END;
        }
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onAudioFrameSendStateChanged(roomId, new RtcUser(user), firstFrameSendState);
        } catch (Exception unused) {
            LogUtil.m216e(TAG, "onAudioFrameSendStateChanged callback catch exception.\n");
        }
    }

    public void onAudioFrameSendStateChanged(StreamKey streamKey, String metaData, int state) {
        IRTCEngineEventHandlerEx rtcEngineHandlerEx;
        LogUtil.m215d(TAG, "onAudioFrameSendStateChanged,  state: " + state);
        FirstFrameSendState firstFrameSendState = FirstFrameSendState.FIRST_FRAME_SEND_STATE_SENDING;
        if (state == 0) {
            firstFrameSendState = FirstFrameSendState.FIRST_FRAME_SEND_STATE_SENDING;
        } else if (state == 1) {
            firstFrameSendState = FirstFrameSendState.FIRST_FRAME_SEND_STATE_SENT;
        } else if (state == 2) {
            firstFrameSendState = FirstFrameSendState.FIRST_FRAME_SEND_STAT_END;
        }
        RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
        if (rTCEngineImpl == null || (rtcEngineHandlerEx = rTCEngineImpl.getRtcEngineHandlerEx()) == null) {
            return;
        }
        rtcEngineHandlerEx.onAudioFrameSendStateChanged(streamKey, metaData, firstFrameSendState);
    }

    public void onVideoFrameSendStateChanged(String roomId, InternalRTCUser user, int index, int state) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onVideoFrameSendStateChanged, user: " + user + ", state: " + state);
        FirstFrameSendState firstFrameSendState = FirstFrameSendState.FIRST_FRAME_SEND_STATE_SENDING;
        if (state == 0) {
            firstFrameSendState = FirstFrameSendState.FIRST_FRAME_SEND_STATE_SENDING;
        } else if (state == 1) {
            firstFrameSendState = FirstFrameSendState.FIRST_FRAME_SEND_STATE_SENT;
        } else if (state == 2) {
            firstFrameSendState = FirstFrameSendState.FIRST_FRAME_SEND_STAT_END;
        }
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onVideoFrameSendStateChanged(roomId, new RtcUser(user), firstFrameSendState);
        } catch (Exception unused) {
            LogUtil.m216e(TAG, "onVideoFrameSendStateChanged callback catch exception.\n");
        }
    }

    public void onVideoFrameSendStateChanged(StreamKey streamKey, String metaData, int state) {
        IRTCEngineEventHandlerEx rtcEngineHandlerEx;
        LogUtil.m215d(TAG, "onVideoFrameSendStateChanged, user: " + streamKey.getUserId() + ", state: " + state);
        FirstFrameSendState firstFrameSendState = FirstFrameSendState.FIRST_FRAME_SEND_STATE_SENDING;
        if (state == 0) {
            firstFrameSendState = FirstFrameSendState.FIRST_FRAME_SEND_STATE_SENDING;
        } else if (state == 1) {
            firstFrameSendState = FirstFrameSendState.FIRST_FRAME_SEND_STATE_SENT;
        } else if (state == 2) {
            firstFrameSendState = FirstFrameSendState.FIRST_FRAME_SEND_STAT_END;
        }
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandlerEx = rTCEngineImpl.getRtcEngineHandlerEx()) == null) {
                return;
            }
            rtcEngineHandlerEx.onVideoFrameSendStateChanged(streamKey, metaData, firstFrameSendState);
        } catch (Exception unused) {
            LogUtil.m216e(TAG, "onVideoFrameSendStateChanged callback catch exception.\n");
        }
    }

    public void onScreenVideoFrameSendStateChanged(String roomId, InternalRTCUser user, int state) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onScreenVideoFrameSendStateChanged, user: " + user + ", state: " + state);
        FirstFrameSendState firstFrameSendState = FirstFrameSendState.FIRST_FRAME_SEND_STATE_SENDING;
        if (state == 0) {
            firstFrameSendState = FirstFrameSendState.FIRST_FRAME_SEND_STATE_SENDING;
        } else if (state == 1) {
            firstFrameSendState = FirstFrameSendState.FIRST_FRAME_SEND_STATE_SENT;
        } else if (state == 2) {
            firstFrameSendState = FirstFrameSendState.FIRST_FRAME_SEND_STAT_END;
        }
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onScreenVideoFrameSendStateChanged(roomId, new RtcUser(user), firstFrameSendState);
        } catch (Exception unused) {
            LogUtil.m216e(TAG, "onScreenVideoFrameSendStateChanged callback catch exception.\n");
        }
    }

    public void onAudioFramePlayStateChanged(String roomId, InternalRTCUser user, int index, int state) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onAudioFramePlayStateChanged, user: " + user + ", state: " + state);
        FirstFramePlayState firstFramePlayState = FirstFramePlayState.FIRST_FRAME_PLAY_STATE_PLAYING;
        if (state == 0) {
            firstFramePlayState = FirstFramePlayState.FIRST_FRAME_PLAY_STATE_PLAYING;
        } else if (state == 1) {
            firstFramePlayState = FirstFramePlayState.FIRST_FRAME_PLAY_STATE_PLAYED;
        } else if (state == 2) {
            firstFramePlayState = FirstFramePlayState.FIRST_FRAME_PLAY_STATE_END;
        }
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onAudioFramePlayStateChanged(roomId, new RtcUser(user), firstFramePlayState);
        } catch (Exception unused) {
            LogUtil.m216e(TAG, "onAudioFramePlayStateChanged callback catch exception.\n");
        }
    }

    public void onAudioFramePlayStateChanged(StreamKey streamKey, String metaData, int state) {
        IRTCEngineEventHandlerEx rtcEngineHandlerEx;
        LogUtil.m215d(TAG, "onAudioFramePlayStateChanged, user: " + streamKey.getUserId() + ", state: " + state);
        FirstFramePlayState firstFramePlayState = FirstFramePlayState.FIRST_FRAME_PLAY_STATE_PLAYING;
        if (state == 0) {
            firstFramePlayState = FirstFramePlayState.FIRST_FRAME_PLAY_STATE_PLAYING;
        } else if (state == 1) {
            firstFramePlayState = FirstFramePlayState.FIRST_FRAME_PLAY_STATE_PLAYED;
        } else if (state == 2) {
            firstFramePlayState = FirstFramePlayState.FIRST_FRAME_PLAY_STATE_END;
        }
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandlerEx = rTCEngineImpl.getRtcEngineHandlerEx()) == null) {
                return;
            }
            rtcEngineHandlerEx.onAudioFramePlayStateChanged(streamKey, metaData, firstFramePlayState);
        } catch (Exception unused) {
            LogUtil.m216e(TAG, "onAudioFramePlayStateChanged callback catch exception.\n");
        }
    }

    public void onVideoFramePlayStateChanged(String roomId, InternalRTCUser user, int index, int state) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onVideoFramePlayStateChanged, user: " + user + ", state: " + state);
        FirstFramePlayState firstFramePlayState = FirstFramePlayState.FIRST_FRAME_PLAY_STATE_PLAYING;
        if (state == 0) {
            firstFramePlayState = FirstFramePlayState.FIRST_FRAME_PLAY_STATE_PLAYING;
        } else if (state == 1) {
            firstFramePlayState = FirstFramePlayState.FIRST_FRAME_PLAY_STATE_PLAYED;
        } else if (state == 2) {
            firstFramePlayState = FirstFramePlayState.FIRST_FRAME_PLAY_STATE_END;
        }
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onVideoFramePlayStateChanged(roomId, new RtcUser(user), firstFramePlayState);
        } catch (Exception unused) {
            LogUtil.m216e(TAG, "onVideoFramePlayStateChanged callback catch exception.\n");
        }
    }

    public void onVideoFramePlayStateChanged(StreamKey streamKey, String metaData, int state) {
        IRTCEngineEventHandlerEx rtcEngineHandlerEx;
        LogUtil.m215d(TAG, "onVideoFramePlayStateChanged, user: " + streamKey.getUserId() + ", state: " + state);
        FirstFramePlayState firstFramePlayState = FirstFramePlayState.FIRST_FRAME_PLAY_STATE_PLAYING;
        if (state == 0) {
            firstFramePlayState = FirstFramePlayState.FIRST_FRAME_PLAY_STATE_PLAYING;
        } else if (state == 1) {
            firstFramePlayState = FirstFramePlayState.FIRST_FRAME_PLAY_STATE_PLAYED;
        } else if (state == 2) {
            firstFramePlayState = FirstFramePlayState.FIRST_FRAME_PLAY_STATE_END;
        }
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandlerEx = rTCEngineImpl.getRtcEngineHandlerEx()) == null) {
                return;
            }
            rtcEngineHandlerEx.onVideoFramePlayStateChanged(streamKey, metaData, firstFramePlayState);
        } catch (Exception unused) {
            LogUtil.m216e(TAG, "onVideoFramePlayStateChanged callback catch exception.\n");
        }
    }

    public void onScreenVideoFramePlayStateChanged(String roomId, InternalRTCUser user, int state) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onScreenVideoFramePlayStateChanged, user: " + user + ", state: " + state);
        FirstFramePlayState firstFramePlayState = FirstFramePlayState.FIRST_FRAME_PLAY_STATE_PLAYING;
        if (state == 0) {
            firstFramePlayState = FirstFramePlayState.FIRST_FRAME_PLAY_STATE_PLAYING;
        } else if (state == 1) {
            firstFramePlayState = FirstFramePlayState.FIRST_FRAME_PLAY_STATE_PLAYED;
        } else if (state == 2) {
            firstFramePlayState = FirstFramePlayState.FIRST_FRAME_PLAY_STATE_END;
        }
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onScreenVideoFramePlayStateChanged(roomId, new RtcUser(user), firstFramePlayState);
        } catch (Exception unused) {
            LogUtil.m216e(TAG, "onScreenVideoFramePlayStateChanged callback catch exception.\n");
        }
    }

    public void onRecordingStateUpdate(StreamIndex type, int state, int errorCode, RecordingInfo info) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onRecordingStateUpdate, StreamIndex: " + type + ", RecordingState: " + state + ", RecordingErrorCode: " + errorCode + ", info.filePath: " + info.filePath);
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onRecordingStateUpdate(type, RecordingState.fromId(state), RecordingErrorCode.fromId(errorCode), info);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onRecordingStateUpdate callback catch exception.\n" + e.getMessage());
        }
    }

    public void onRecordingProgressUpdate(StreamIndex type, RecordingProgress progress, RecordingInfo info) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onRecordingProgressUpdate, StreamIndex: " + type + ", progress.dur: " + progress.duration + ", progress.fileSize: " + progress.fileSize + ", info.filePath: " + info.filePath);
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onRecordingProgressUpdate(type, progress, info);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onRecordingProgressUpdate callback catch exception.\n" + e.getMessage());
        }
    }

    public void onAudioRecordingStateUpdate(int state, int errorCode) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onAudioRecordingStateUpdate, state: " + state + ", errorCode: " + errorCode);
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onAudioRecordingStateUpdate(AudioRecordingState.fromId(state), AudioRecordingErrorCode.fromId(errorCode));
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onAudioRecordingStateUpdate callback catch exception.\n" + e.getMessage());
        }
    }

    public void onAudioMixingPlayingProgress(int mixId, long progress) {
        IRTCEngineEventHandler rtcEngineHandler;
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onAudioMixingPlayingProgress(mixId, progress);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onAudioMixingPlayingProgress callback catch exception.\n" + e.getMessage());
        }
    }

    public void onLocalAudioPropertiesReport(LocalAudioPropertiesInfo[] audioPropertiesInfos) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onLocalAudioPropertiesReport");
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onLocalAudioPropertiesReport(audioPropertiesInfos);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onLocalAudioPropertiesReport callback catch exception.\n" + e.getMessage());
        }
    }

    public void onAudioVADStateUpdate(AudioVADType state) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onAudioVADStateUpdate");
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onAudioVADStateUpdate(state);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onLocalAudioPropertiesReport callback catch exception.\n" + e.getMessage());
        }
    }

    public void onAudioAEDStateUpdate(AudioAEDType state) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onAudioAEDStateUpdate");
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onAudioAEDStateUpdate(state);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onAudioAEDStateUpdate callback catch exception.\n" + e.getMessage());
        }
    }

    public void onAudioPlaybackDeviceTestVolume(int volume) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onAudioPlaybackDeviceTestVolume");
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onAudioPlaybackDeviceTestVolume(volume);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onAudioPlaybackDeviceTestVolume callback catch exception.\n" + e.getMessage());
        }
    }

    public void onRemoteAudioPropertiesReport(RemoteAudioPropertiesInfo[] audio_properties_infos, int totalRemoteVolume) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onRemoteAudioPropertiesReport");
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onRemoteAudioPropertiesReport(audio_properties_infos, totalRemoteVolume);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onRemoteAudioPropertiesReport callback catch exception.\n" + e.getMessage());
        }
    }

    public void onActiveSpeaker(String roomId, String uid) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onActiveSpeaker");
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onActiveSpeaker(roomId, uid);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onActiveSpeaker callback catch exception.\n" + e.getMessage());
        }
    }

    public void onStreamSyncInfoReceived(RemoteStreamKey streamKey, ByteBuffer data, int streamType) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onStreamSyncInfoReceived");
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onStreamSyncInfoReceived(streamKey, StreamSycnInfoConfig.SyncInfoStreamType.SYNC_INFO_STREAM_TYPE_AUDIO, data);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onStreamSyncInfoReceived callback catch exception.\n" + e.getMessage());
        }
    }

    public void onPushPublicStreamResult(String roomId, String publicStreamId, PublicStreamErrorCode errorCode) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onPushPublicStreamError error(" + errorCode.value() + ") streamId:" + publicStreamId);
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onPushPublicStreamResult(roomId, publicStreamId, errorCode);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onPushPublicStreamError callback catch exception.\n" + e.getMessage());
        }
    }

    public void onCloudProxyConnected(int interval) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onCloudProxyConnected, interval: " + interval);
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onCloudProxyConnected(interval);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onCloudProxyConnected callback catch exception.\n" + e.getMessage());
        }
    }

    public void onEchoTestResult(int errorCode) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onEchoTestResult...error code: " + errorCode);
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            EchoTestResult echoTestResult = EchoTestResult.ECHO_TEST_SUCCESS;
            switch (errorCode) {
                case 1:
                    echoTestResult = EchoTestResult.ECHO_TEST_TIMEOUT;
                    break;
                case 2:
                    echoTestResult = EchoTestResult.ECHO_TEST_INTERVAL_SHORT;
                    break;
                case 3:
                    echoTestResult = EchoTestResult.ECHO_TEST_AUDIO_DEVICE_ERROR;
                    break;
                case 4:
                    echoTestResult = EchoTestResult.ECHO_TEST_VIDEO_DEVICE_ERROR;
                    break;
                case 5:
                    echoTestResult = EchoTestResult.ECHO_TEST_AUDIO_RECEIVE_ERROR;
                    break;
                case 6:
                    echoTestResult = EchoTestResult.ECHO_TEST_VIDEO_RECEIVE_ERROR;
                    break;
                case 7:
                    echoTestResult = EchoTestResult.ECHO_TEST_INTERNAL_ERROR;
                    break;
            }
            rtcEngineHandler.onEchoTestResult(echoTestResult);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onEchoTestResult callback catch exception.\n" + e.getMessage());
        }
    }

    public void onAudioDumpStateChanged(int status) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onAudioDumpStateChanged...status: " + status);
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            AudioDumpStatus audioDumpStatus = AudioDumpStatus.AUDIO_DUMP_START_FAILURE;
            if (status == 0) {
                audioDumpStatus = AudioDumpStatus.AUDIO_DUMP_START_FAILURE;
            } else if (status == 1) {
                audioDumpStatus = AudioDumpStatus.AUDIO_DUMP_START_SUCCESS;
            } else if (status == 2) {
                audioDumpStatus = AudioDumpStatus.AUDIO_DUMP_STOP_FAILURE;
            } else if (status == 3) {
                audioDumpStatus = AudioDumpStatus.AUDIO_DUMP_STOP_SUCCESS;
            } else if (status == 4) {
                audioDumpStatus = AudioDumpStatus.AUDIO_DUMP_RUNNING_FAILURE;
            } else if (status == 5) {
                audioDumpStatus = AudioDumpStatus.AUDIO_DUMP_RUNNING_SUCCESS;
            }
            rtcEngineHandler.onAudioDumpStateChanged(audioDumpStatus);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onAudioDumpStateChanged callback catch exception.\n" + e.getMessage());
        }
    }

    public void onNetworkTimeSynchronized() {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onNetworkTimeSynchronized...");
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onNetworkTimeSynchronized();
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onNetworkTimeSynchronized callback catch exception.\n" + e.getMessage());
        }
    }

    public void onLicenseWillExpire(int days) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onLicenseWillExpire, days: " + days);
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onLicenseWillExpire(days);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onLicenseWillExpire callback catch exception.\n" + e.getMessage());
        }
    }

    public void onHardwareEchoDetectionResult(int code) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onHardwareEchoDetectionResult...result code: " + code);
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            HardwareEchoDetectionResult hardwareEchoDetectionResult = HardwareEchoDetectionResult.HARDWARE_ECHO_RESULT_NORMAL;
            if (code == 0) {
                hardwareEchoDetectionResult = HardwareEchoDetectionResult.HARDWARE_ECHO_RESULT_CANCELED;
            } else if (code == 1) {
                hardwareEchoDetectionResult = HardwareEchoDetectionResult.HARDWARE_ECHO_RESULT_UNKNOWN;
            } else if (code == 3) {
                hardwareEchoDetectionResult = HardwareEchoDetectionResult.HARDWARE_ECHO_RESULT_POOR;
            }
            rtcEngineHandler.onHardwareEchoDetectionResult(hardwareEchoDetectionResult);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onHardwareEchoDetectionResult callback catch exception.\n" + e.getMessage());
        }
    }

    public void onLocalProxyStateChanged(LocalProxyType localProxyType, LocalProxyState localProxyState, LocalProxyError localProxyError) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onLocalProxyStateChanged...: " + localProxyType.value() + ", state: " + localProxyState.value() + ", error: " + localProxyError.value());
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onLocalProxyStateChanged(localProxyType, localProxyState, localProxyError);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onLocalProxyStateChanged callback catch exception.\n" + e.getMessage());
        }
    }

    public void onLocalStreamStats(StreamIndex streamIndex, InternalLocalStreamStats stats) {
        IRTCEngineEventHandlerEx rtcEngineHandlerEx;
        LogUtil.m215d(TAG, "onLocalStreamStats, streamIndex: " + streamIndex);
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandlerEx = rTCEngineImpl.getRtcEngineHandlerEx()) == null) {
                return;
            }
            rtcEngineHandlerEx.onLocalStreamStats(streamIndex, new LocalStreamStats(stats));
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onLocalStreamStats callback catch exception.\n" + e.getMessage());
        }
    }

    public void onRemoteStreamStats(StreamKey streamKey, InternalRemoteStreamStats stats) {
        IRTCEngineEventHandlerEx rtcEngineHandlerEx;
        LogUtil.m215d(TAG, "onRemoteStreamStats, streamIndex: " + streamKey.getStreamIndex());
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandlerEx = rTCEngineImpl.getRtcEngineHandlerEx()) == null) {
                return;
            }
            rtcEngineHandlerEx.onRemoteStreamStats(new StreamKey(streamKey.getRoomId(), streamKey.getUserId(), streamKey.getStreamIndex()), new RemoteStreamStats(stats));
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onRemoteStreamStats callback catch exception.\n" + e.getMessage());
        }
    }

    public void onEffectError(EffectErrorType error, String msg) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onEffectError error: " + error + ", msg: " + msg);
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onEffectError(error, msg);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onEffectError callback catch exception.\n" + e.getMessage());
        }
    }

    public void onRemoteRenderError(RemoteStreamKey key, RenderError error, String message) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onRemoteRenderError, key: " + key.toString() + ", error: ; message: " + message);
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onRemoteRenderError(key, error, message);
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onRemoteRenderError callback catch exception.\n" + e.getMessage());
        }
    }

    public void onExternalScreenFrameUpdate(FrameUpdateInfo info) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onExternalScreenFrameUpdate, info: " + info.toString());
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onExternalScreenFrameUpdate(info);
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onExternalScreenFrameUpdate callback catch exception.\n" + e.getMessage());
        }
    }

    public void onRemoteAudioPropertiesReportEx(RemoteAudioPropertiesInfo[] audio_properties_infos) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onRemoteAudioPropertiesReport");
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onRemoteAudioPropertiesReportEx(audio_properties_infos);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onRemoteAudioPropertiesReport callback catch exception.\n" + e.getMessage());
        }
    }

    public void onMixedStreamEvent(MixedStreamTaskInfo info, MixedStreamTaskEvent event, MixedStreamTaskErrorCode error) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onMixedStreamEvent");
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onMixedStreamEvent(info, event, error);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onMixedStreamEvent callback catch exception.\n" + e.getMessage());
        }
    }

    public void onSingleStreamEvent(String taskId, SingleStreamTaskEvent event, SingleStreamTaskErrorCode error) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onSingleStreamEvent");
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onSingleStreamEvent(taskId, event, error);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onSingleStreamEvent callback catch exception.\n" + e.getMessage());
        }
    }

    public void onExperimentalCallback(String param) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onExperimentalCallback...param: " + param);
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onExperimentalCallback(param);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onExperimentalCallback callback catch exception.\n" + e.getMessage());
        }
    }

    public void onMultiLinkEnhancementStats(MultiLinkStats[] stats) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onMultiLinkStats");
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onMultiLinkEnhancementStats(stats);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onMultiLinkStats callback catch exception.\n" + e.getMessage());
        }
    }

    public void onMultiLinkEnhancementStateChanged(MultiLinkEnhancementState state, MultiLinkEnhancementMode mode) {
        IRTCEngineEventHandler rtcEngineHandler;
        LogUtil.m215d(TAG, "onMultiLinkEnhancementStateChanged");
        try {
            RTCEngineImpl rTCEngineImpl = this.mRTCVideoImpl.get();
            if (rTCEngineImpl == null || (rtcEngineHandler = rTCEngineImpl.getRtcEngineHandler()) == null) {
                return;
            }
            rtcEngineHandler.onMultiLinkEnhancementStateChanged(state, mode);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onMultiLinkEnhancementStateChanged callback catch exception.\n" + e.getMessage());
        }
    }
}
