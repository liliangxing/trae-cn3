package com.ss.bytertc.engine.handler;

import com.ss.bytertc.engine.InternalLocalStreamStats;
import com.ss.bytertc.engine.InternalNetworkQualityInfo;
import com.ss.bytertc.engine.InternalRTCStats;
import com.ss.bytertc.engine.InternalRemoteStreamStats;
import com.ss.bytertc.engine.InternalRoomEventInfo;
import com.ss.bytertc.engine.RTCRoomImpl;
import com.ss.bytertc.engine.RTCStream;
import com.ss.bytertc.engine.UserInfo;
import com.ss.bytertc.engine.data.AVSyncEvent;
import com.ss.bytertc.engine.data.AVSyncState;
import com.ss.bytertc.engine.data.ForwardStreamEventInfo;
import com.ss.bytertc.engine.data.ForwardStreamStateInfo;
import com.ss.bytertc.engine.data.PublishState;
import com.ss.bytertc.engine.data.PublishStateChangeReason;
import com.ss.bytertc.engine.data.SubscribeState;
import com.ss.bytertc.engine.data.SubscribeStateChangeReason;
import com.ss.bytertc.engine.type.ControlMessageSendResult;
import com.ss.bytertc.engine.type.LocalStreamStats;
import com.ss.bytertc.engine.type.MediaStreamType;
import com.ss.bytertc.engine.type.NetworkQualityStats;
import com.ss.bytertc.engine.type.RTCRoomStats;
import com.ss.bytertc.engine.type.RemoteStreamStats;
import com.ss.bytertc.engine.type.RoomEvent;
import com.ss.bytertc.engine.type.RoomEventInfo;
import com.ss.bytertc.engine.type.RoomState;
import com.ss.bytertc.engine.type.RoomStateChangeReason;
import com.ss.bytertc.engine.type.SetRoomExtraInfoResult;
import com.ss.bytertc.engine.type.StreamRemoveReason;
import com.ss.bytertc.engine.type.SubtitleErrorCode;
import com.ss.bytertc.engine.type.SubtitleMessage;
import com.ss.bytertc.engine.type.SubtitleState;
import com.ss.bytertc.engine.type.UserVisibilityChangeError;
import com.ss.bytertc.engine.utils.LogUtil;
import java.nio.ByteBuffer;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class RTCRoomEventHandler {
    private static final String TAG = "RtcRoomEventHandler";
    private RTCRoomImpl mRtcRoom;

    public RTCRoomEventHandler(RTCRoomImpl rtcRoom) {
        this.mRtcRoom = rtcRoom;
    }

    public void onRoomStateChangedWithReason(String roomId, String uid, int state, int reason) {
        LogUtil.m215d(TAG, "onRoomStateChangedWithReason...");
        try {
            this.mRtcRoom.getRtcRoomHandler().onRoomStateChangedWithReason(roomId, uid, RoomState.valueOf(state), RoomStateChangeReason.valueOf(reason));
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onRoomStateChanged callback catch exception.\n" + e.getMessage());
        }
    }

    public void onRoomStateChanged(String roomId, String uid, int state, String extraInfo) {
        LogUtil.m215d(TAG, "onRoomStateChanged...");
        try {
            this.mRtcRoom.getRtcRoomHandler().onRoomStateChanged(roomId, uid, state, extraInfo);
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onRoomStateChanged callback catch exception.\n" + e.getMessage());
        }
    }

    public void onStreamStateChanged(String roomId, String uid, int state, String extraInfo) {
        LogUtil.m215d(TAG, "onStreamStateChanged...");
        try {
            this.mRtcRoom.getRtcRoomHandler().onStreamStateChanged(roomId, uid, state, extraInfo);
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onStreamStateChanged callback catch exception.\n" + e.getMessage());
        }
    }

    public void onLeaveRoom(InternalRTCStats stats) {
        LogUtil.m215d(TAG, "onLeaveRoom...");
        try {
            this.mRtcRoom.getRtcRoomHandler().onLeaveRoom(new RTCRoomStats(stats));
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onLeaveRoom callback catch exception.\n" + e.getMessage());
        }
    }

    public void onRoomWarning(int warn) {
        LogUtil.m215d(TAG, "onRoomWarning, warnNum: " + warn);
        try {
            this.mRtcRoom.getRtcRoomHandler().onRoomWarning(warn);
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onRoomWarning callback catch exception.\n" + e.getMessage());
        }
    }

    public void onAVSyncStateChange(AVSyncState state) {
        LogUtil.m215d(TAG, "onAVSyncStateChange: " + state);
        try {
            this.mRtcRoom.getRtcRoomHandler().onAVSyncStateChange(state);
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onAVSyncStateChange callback catch exception.\n" + e.getMessage());
        }
    }

    public void onRoomStats(InternalRTCStats stats) {
        LogUtil.m215d(TAG, "onRtcStats...");
        try {
            this.mRtcRoom.getRtcRoomHandler().onRoomStats(new RTCRoomStats(stats));
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onRtcStats callback catch exception.\n" + e.getMessage());
        }
    }

    public void onRoomEvent(String roomId, String uid, int state, InternalRoomEventInfo info) {
        LogUtil.m215d(TAG, "onRoomEvent...");
        try {
            this.mRtcRoom.getRtcRoomHandler().onRoomEvent(roomId, uid, RoomEvent.valueOf(state), new RoomEventInfo(info));
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onRtcStats callback catch exception.\n" + e.getMessage());
        }
    }

    public void onUserJoined(UserInfo userInfo) {
        LogUtil.m215d(TAG, "onUserJoined... uid: " + userInfo.getUid() + ", extraInfo: " + userInfo.getExtraInfo());
        try {
            this.mRtcRoom.getRtcRoomHandler().onUserJoined(userInfo);
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onUserJoined callback catch exception.\n" + e.getMessage());
        }
    }

    public void onUserLeave(String uid, int reason, String extraInfo) {
        LogUtil.m215d(TAG, "onUserLeave... uid: " + uid + ", reason: " + reason);
        try {
            this.mRtcRoom.getRtcRoomHandler().onUserLeave(uid, reason, extraInfo);
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onUserLeave callback catch exception.\n" + e.getMessage());
        }
    }

    public void onTokenWillExpire() {
        LogUtil.m215d(TAG, "onTokenWillExpire");
        try {
            this.mRtcRoom.getRtcRoomHandler().onTokenWillExpire();
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onTokenWillExpire callback catch exception.\n" + e.getMessage());
        }
    }

    public void onPublishPrivilegeTokenWillExpire() {
        LogUtil.m215d(TAG, "onPublishPrivilegeTokenWillExpire");
        try {
            this.mRtcRoom.getRtcRoomHandler().onPublishPrivilegeTokenWillExpire();
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onPublishPrivilegeTokenWillExpire callback catch exception.\n" + e.getMessage());
        }
    }

    public void onSubscribePrivilegeTokenWillExpire() {
        LogUtil.m215d(TAG, "onSubscribePrivilegeTokenWillExpire");
        try {
            this.mRtcRoom.getRtcRoomHandler().onSubscribePrivilegeTokenWillExpire();
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onSubscribePrivilegeTokenWillExpire callback catch exception.\n" + e.getMessage());
        }
    }

    public void onUserPublishStream(String uid, int type) {
        LogUtil.m215d(TAG, "onUserPublishStream... uid: " + uid + ", type: " + type);
        try {
            this.mRtcRoom.getRtcRoomHandler().onUserPublishStream(uid, MediaStreamType.valueOf(type));
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onUserPublishStream callback catch exception.\n" + e.getMessage());
        }
    }

    public void onUserUnpublishStream(String uid, int type, int reason) {
        LogUtil.m215d(TAG, "onUserUnPublishStream... uid: " + uid + ", type: " + type + ", reasen:" + reason);
        try {
            this.mRtcRoom.getRtcRoomHandler().onUserUnpublishStream(uid, MediaStreamType.valueOf(type), StreamRemoveReason.values()[reason]);
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onUserUnPublishStream callback catch exception.\n" + e.getMessage());
        }
    }

    public void onUserPublishScreen(String uid, int type) {
        LogUtil.m215d(TAG, "onUserPublishScreen... uid: " + uid + ", type: " + type);
        try {
            this.mRtcRoom.getRtcRoomHandler().onUserPublishScreen(uid, MediaStreamType.valueOf(type));
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onUserPublishScreen callback catch exception.\n" + e.getMessage());
        }
    }

    public void onUserUnpublishScreen(String uid, int type, int reason) {
        LogUtil.m215d(TAG, "onUserUnPublishScreen... uid: " + uid + ", type: " + type + ", reasen:" + reason);
        try {
            this.mRtcRoom.getRtcRoomHandler().onUserUnpublishScreen(uid, MediaStreamType.valueOf(type), StreamRemoveReason.values()[reason]);
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onUserUnPublishScreen callback catch exception.\n" + e.getMessage());
        }
    }

    public void onLocalStreamStats(InternalLocalStreamStats stats) {
        LogUtil.m215d(TAG, "onLocalStreamStats...");
        try {
            this.mRtcRoom.getRtcRoomHandler().onLocalStreamStats(new LocalStreamStats(stats));
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onLocalStreamStats callback catch exception.\n" + e.getMessage());
        }
    }

    public void onRemoteStreamStats(InternalRemoteStreamStats stats) {
        LogUtil.m215d(TAG, "onRemoteStreamStats...");
        try {
            this.mRtcRoom.getRtcRoomHandler().onRemoteStreamStats(new RemoteStreamStats(stats));
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onRemoteStreamStats callback catch exception.\n" + e.getMessage());
        }
    }

    public void onStreamRemove(RTCStream bs, int reason) {
        LogUtil.m215d(TAG, "onStreamRemove...uid: " + bs.userId);
        try {
            this.mRtcRoom.getRtcRoomHandler().onStreamRemove(bs, StreamRemoveReason.values()[reason]);
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onStreamRemove callback catch exception.\n" + e.getMessage());
        }
    }

    public void onStreamAdd(RTCStream stream) {
        LogUtil.m215d(TAG, "onStreamAdd...");
        try {
            this.mRtcRoom.getRtcRoomHandler().onStreamAdd(stream);
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onStreamAdd callback catch exception.\n" + e.getMessage());
        }
    }

    public void onStreamPublishSuccess(String uid, boolean isScreen) {
        LogUtil.m215d(TAG, "onStreamPublishSuccess...");
        try {
            this.mRtcRoom.getRtcRoomHandler().onStreamPublishSuccess(uid, isScreen);
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onStreamPublishSuccess callback catch exception.\n" + e.getMessage());
        }
    }

    public void onAVSyncEvent(String roomId, String uid, AVSyncEvent eventCode) {
        LogUtil.m215d(TAG, "onAVSyncEvent...");
        try {
            this.mRtcRoom.getRtcRoomHandler().onAVSyncEvent(roomId, uid, eventCode);
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onAVSyncEvent callback catch exception.\n" + e.getMessage());
        }
    }

    public void onUserPublishStreamVideo(String room_id, String uid, boolean isPublish) {
        LogUtil.m215d(TAG, "onUserPublishStreamVideo");
        try {
            this.mRtcRoom.getRtcRoomHandler().onUserPublishStreamVideo(room_id, uid, isPublish);
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onUserPublishStreamVideo callback catch exception.\n" + e.getMessage());
        }
    }

    public void onUserPublishStreamAudio(String room_id, String uid, boolean isPublish) {
        LogUtil.m215d(TAG, "onUserPublishStreamAudio");
        try {
            this.mRtcRoom.getRtcRoomHandler().onUserPublishStreamAudio(room_id, uid, isPublish);
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onUserPublishStreamAudio callback catch exception.\n" + e.getMessage());
        }
    }

    public void onUserPublishScreenVideo(String room_id, String uid, boolean isPublish) {
        LogUtil.m215d(TAG, "onUserPublishScreenVideo");
        try {
            this.mRtcRoom.getRtcRoomHandler().onUserPublishScreenVideo(room_id, uid, isPublish);
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onUserPublishScreenVideo callback catch exception.\n" + e.getMessage());
        }
    }

    public void onUserPublishScreenAudio(String room_id, String uid, boolean isPublish) {
        LogUtil.m215d(TAG, "onUserPublishScreenAudio");
        try {
            this.mRtcRoom.getRtcRoomHandler().onUserPublishScreenAudio(room_id, uid, isPublish);
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onUserPublishScreenAudio callback catch exception.\n" + e.getMessage());
        }
    }

    public void onRoomMessageReceived(String uid, String message, long msgid) {
        LogUtil.m215d(TAG, "onRoomMessageReceived: " + message);
        try {
            this.mRtcRoom.getRtcRoomHandler().onRoomMessageReceived(uid, message);
            this.mRtcRoom.getRtcRoomHandler().onRoomMessageReceived(msgid, uid, message);
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onRoomMessageReceived callback catch exception.\n" + e.getMessage());
        }
    }

    public void onRoomBinaryMessageReceived(String uid, ByteBuffer message, long msgid) {
        LogUtil.m215d(TAG, "onRoomBinaryMessageReceived, length: " + message.capacity());
        try {
            this.mRtcRoom.getRtcRoomHandler().onRoomBinaryMessageReceived(uid, message.duplicate());
            this.mRtcRoom.getRtcRoomHandler().onRoomBinaryMessageReceived(msgid, uid, message);
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onRoomBinaryMessageReceived callback catch exception.\n" + e.getMessage());
        }
    }

    public void onUserMessageReceived(String uid, String message, long msgid) {
        LogUtil.m215d(TAG, "onUserMessageReceived: uid:" + uid + "message" + message);
        try {
            this.mRtcRoom.getRtcRoomHandler().onUserMessageReceived(uid, message);
            this.mRtcRoom.getRtcRoomHandler().onUserMessageReceived(msgid, uid, message);
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onUserMessageReceived callback catch exception.\n" + e.getMessage());
        }
    }

    public void onUserBinaryMessageReceived(String uid, ByteBuffer message, long msgid) {
        LogUtil.m215d(TAG, "onUserBinaryMessageReceived: uid:" + uid + "binary message length" + message.capacity());
        try {
            this.mRtcRoom.getRtcRoomHandler().onUserBinaryMessageReceived(uid, message.duplicate());
            this.mRtcRoom.getRtcRoomHandler().onUserBinaryMessageReceived(msgid, uid, message);
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onUserBinaryMessageReceived callback catch exception.\n" + e.getMessage());
        }
    }

    public void onUserMessageSendResult(long msgid, int error) {
        LogUtil.m215d(TAG, "onUserMessageSendResult...");
        try {
            this.mRtcRoom.getRtcRoomHandler().onUserMessageSendResult(msgid, error);
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onUserMessageSendResult callback catch exception.\n" + e.getMessage());
        }
    }

    public void onRoomMessageSendResult(long msgid, int error) {
        LogUtil.m215d(TAG, "onRoomMessageSendResult...");
        try {
            this.mRtcRoom.getRtcRoomHandler().onRoomMessageSendResult(msgid, error);
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onRoomMessageSendResult callback catch exception.\n" + e.getMessage());
        }
    }

    public void onControlMessageSendResult(long msgid, int error) {
        LogUtil.m215d(TAG, "onControlMessageSendResult...");
        try {
            this.mRtcRoom.getRtcRoomHandler().onControlMessageSendResult(msgid, ControlMessageSendResult.fromId(error));
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onControlMessageSendResult callback catch exception.\n" + e.getMessage());
        }
    }

    public static ByteBuffer allocateDirectByteBuffer(int capacity) {
        return ByteBuffer.allocateDirect(capacity);
    }

    public void onVideoStreamBanned(String user, boolean banned) {
        LogUtil.m215d(TAG, "onVideoStreamBanned, user: " + user + ", banned: " + (banned ? "true" : "false"));
        try {
            this.mRtcRoom.getRtcRoomHandler().onVideoStreamBanned(user, banned);
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onVideoStreamBanned callback catch exception.\n" + e.getMessage());
        }
    }

    public void onAudioStreamBanned(String user, boolean banned) {
        LogUtil.m215d(TAG, "onAudioStreamBanned, user: " + user + ", banned: " + (banned ? "true" : "false"));
        try {
            this.mRtcRoom.getRtcRoomHandler().onAudioStreamBanned(user, banned);
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onAudioStreamBanned callback catch exception.\n" + e.getMessage());
        }
    }

    public void onVideoPublishStateChanged(String roomId, String uid, PublishState state, PublishStateChangeReason reason) {
        LogUtil.m215d(TAG, "onVideoPublishStateChanged");
        try {
            this.mRtcRoom.getRtcRoomHandler().onVideoPublishStateChanged(roomId, uid, state, reason);
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onVideoPublishStateChanged callback catch exception.\n" + e.getMessage());
        }
    }

    public void onAudioPublishStateChanged(String roomId, String uid, PublishState state, PublishStateChangeReason reason) {
        LogUtil.m215d(TAG, "onAudioPublishStateChanged");
        try {
            this.mRtcRoom.getRtcRoomHandler().onAudioPublishStateChanged(roomId, uid, state, reason);
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onAudioPublishStateChanged callback catch exception.\n" + e.getMessage());
        }
    }

    public void onScreenVideoPublishStateChanged(String roomId, String uid, PublishState state, PublishStateChangeReason reason) {
        LogUtil.m215d(TAG, "onScreenVideoPublishStateChanged");
        try {
            this.mRtcRoom.getRtcRoomHandler().onScreenVideoPublishStateChanged(roomId, uid, state, reason);
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onScreenVideoPublishStateChanged callback catch exception.\n" + e.getMessage());
        }
    }

    public void onScreenAudioPublishStateChanged(String roomId, String uid, PublishState state, PublishStateChangeReason reason) {
        LogUtil.m215d(TAG, "onScreenAudioPublishStateChanged");
        try {
            this.mRtcRoom.getRtcRoomHandler().onScreenAudioPublishStateChanged(roomId, uid, state, reason);
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onScreenAudioPublishStateChanged callback catch exception.\n" + e.getMessage());
        }
    }

    public void onVideoSubscribeStateChanged(String roomId, String uid, SubscribeState state, SubscribeStateChangeReason reason) {
        LogUtil.m215d(TAG, "onVideoSubscribeStateChanged");
        try {
            this.mRtcRoom.getRtcRoomHandler().onVideoSubscribeStateChanged(roomId, uid, state, reason);
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onVideoSubscribeStateChanged callback catch exception.\n" + e.getMessage());
        }
    }

    public void onAudioSubscribeStateChanged(String roomId, String uid, SubscribeState state, SubscribeStateChangeReason reason) {
        LogUtil.m215d(TAG, "onAudioSubscribeStateChanged");
        try {
            this.mRtcRoom.getRtcRoomHandler().onAudioSubscribeStateChanged(roomId, uid, state, reason);
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onAudioSubscribeStateChanged callback catch exception.\n" + e.getMessage());
        }
    }

    public void onScreenVideoSubscribeStateChanged(String roomId, String uid, SubscribeState state, SubscribeStateChangeReason reason) {
        LogUtil.m215d(TAG, "onScreenVideoSubscribeStateChanged");
        try {
            this.mRtcRoom.getRtcRoomHandler().onScreenVideoSubscribeStateChanged(roomId, uid, state, reason);
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onScreenVideoSubscribeStateChanged callback catch exception.\n" + e.getMessage());
        }
    }

    public void onScreenAudioSubscribeStateChanged(String roomId, String uid, SubscribeState state, SubscribeStateChangeReason reason) {
        LogUtil.m215d(TAG, "onScreenAudioSubscribeStateChanged");
        try {
            this.mRtcRoom.getRtcRoomHandler().onScreenAudioSubscribeStateChanged(roomId, uid, state, reason);
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onScreenAudioSubscribeStateChanged callback catch exception.\n" + e.getMessage());
        }
    }

    public void onForwardStreamStateChanged(ForwardStreamStateInfo[] stateInfos) {
        LogUtil.m215d(TAG, "OnForwardStreamStateChanged");
        try {
            this.mRtcRoom.getRtcRoomHandler().onForwardStreamStateChanged(stateInfos);
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onForwardStreamStateChanged callback catch exception.\n" + e.getMessage());
        }
    }

    public void onForwardStreamEvent(ForwardStreamEventInfo[] eventInfos) {
        LogUtil.m215d(TAG, "onForwardStreamEvent");
        try {
            this.mRtcRoom.getRtcRoomHandler().onForwardStreamEvent(eventInfos);
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onForwardStreamEvent callback catch exception.\n" + e.getMessage());
        }
    }

    public void onNetworkQuality(InternalNetworkQualityInfo lQuality, InternalNetworkQualityInfo[] rQualities) {
        LogUtil.m215d(TAG, "Local onNetworkQuality, uid: " + lQuality.uid + ", info: " + lQuality.toString());
        try {
            IRTCRoomEventHandler rtcRoomHandler = this.mRtcRoom.getRtcRoomHandler();
            if (rtcRoomHandler != null) {
                NetworkQualityStats[] networkQualityStatsArr = new NetworkQualityStats[rQualities.length];
                for (int i = 0; i < rQualities.length; i++) {
                    LogUtil.m215d(TAG, "Remote onNetworkQuality, uid: " + rQualities[i].uid + ", info: " + rQualities[i].toString());
                    networkQualityStatsArr[i] = new NetworkQualityStats(rQualities[i]);
                }
                rtcRoomHandler.onNetworkQuality(new NetworkQualityStats(lQuality), networkQualityStatsArr);
            }
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onNetworkQuality callback catch exception.\n" + e.getMessage());
        }
    }

    public void onSetRoomExtraInfoResult(long taskId, int result) {
        LogUtil.m215d(TAG, "onSetRoomExtraInfoResult,result:" + result);
        try {
            this.mRtcRoom.getRtcRoomHandler().onSetRoomExtraInfoResult(taskId, SetRoomExtraInfoResult.fromId(result));
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onSetRoomExtraInfoResult callback catch exception.\n" + e.getMessage());
        }
    }

    public void onRoomExtraInfoUpdate(String key, String value, String lastUpdateUserId, long lastUpdateTimeMs) {
        LogUtil.m215d(TAG, "onRoomExtraInfoUpdate , key:" + key + ",value:" + value);
        try {
            this.mRtcRoom.getRtcRoomHandler().onRoomExtraInfoUpdate(key, value, lastUpdateUserId, lastUpdateTimeMs);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onRoomExtraInfoUpdate callback catch exception.\n" + e.getMessage());
        }
    }

    public void onUserVisibilityChanged(boolean currentUserVisibility, UserVisibilityChangeError errorCode) {
        LogUtil.m215d(TAG, "onUserVisibilityChanged, currentUserVisibility:" + currentUserVisibility + ", errorCode:" + errorCode);
        try {
            this.mRtcRoom.getRtcRoomHandler().onUserVisibilityChanged(currentUserVisibility, errorCode);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onUserVisibilityChanged callback catch exception.\n" + e.getMessage());
        }
    }

    public void onSubtitleStateChanged(int state, int errorCode, String errorMessage) {
        LogUtil.m215d(TAG, "onSubtitleStateChanged, state: " + state + ", errorCode: " + errorCode + ", errorMessage: " + errorMessage);
        try {
            this.mRtcRoom.getRtcRoomHandler().onSubtitleStateChanged(SubtitleState.fromId(state), SubtitleErrorCode.fromId(errorCode), errorMessage);
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onSubtitleStateChanged callback catch exception.\n" + e.getMessage());
        }
    }

    public void onSubtitleMessageReceived(SubtitleMessage[] subtitles) {
        LogUtil.m215d(TAG, "onSubtitleMessageReceived, subtitles length: " + subtitles.length);
        try {
            this.mRtcRoom.getRtcRoomHandler().onSubtitleMessageReceived(subtitles);
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onSubtitleMessageReceived callback catch exception.\n" + e.getMessage());
        }
    }
}
