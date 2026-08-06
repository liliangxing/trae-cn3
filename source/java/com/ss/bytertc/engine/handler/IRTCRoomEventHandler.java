package com.ss.bytertc.engine.handler;

import com.ss.bytertc.engine.RTCStream;
import com.ss.bytertc.engine.SubscribeConfig;
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
import java.nio.ByteBuffer;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class IRTCRoomEventHandler {
    public void onAVSyncEvent(String roomId, String uid, AVSyncEvent eventCode) {
    }

    public void onAVSyncStateChange(AVSyncState state) {
    }

    public void onAudioPublishStateChanged(String roomId, String uid, PublishState state, PublishStateChangeReason reason) {
    }

    public void onAudioStreamBanned(String uid, boolean banned) {
    }

    public void onAudioSubscribeStateChanged(String roomId, String uid, SubscribeState state, SubscribeStateChangeReason reason) {
    }

    public void onControlMessageSendResult(long msgid, ControlMessageSendResult error) {
    }

    public void onForwardStreamEvent(ForwardStreamEventInfo[] eventInfos) {
    }

    public void onForwardStreamStateChanged(ForwardStreamStateInfo[] stateInfos) {
    }

    public void onLeaveRoom(RTCRoomStats stats) {
    }

    public void onLocalStreamStats(LocalStreamStats stats) {
    }

    public void onNetworkQuality(NetworkQualityStats localQuality, NetworkQualityStats[] remoteQualities) {
    }

    public void onPublishPrivilegeTokenWillExpire() {
    }

    public void onRemoteStreamStats(RemoteStreamStats stats) {
    }

    public void onRoomBinaryMessageReceived(long msgid, String uid, ByteBuffer message) {
    }

    public void onRoomBinaryMessageReceived(String uid, ByteBuffer message) {
    }

    public void onRoomEvent(String roomId, String uid, RoomEvent state, RoomEventInfo info) {
    }

    public void onRoomExtraInfoUpdate(String key, String value, String lastUpdateUserId, long lastUpdateTimeMs) {
    }

    public void onRoomMessageReceived(long msgid, String uid, String message) {
    }

    public void onRoomMessageReceived(String uid, String message) {
    }

    public void onRoomMessageSendResult(long msgid, int error) {
    }

    public void onRoomStateChanged(String roomId, String uid, int state, String extraInfo) {
    }

    public void onRoomStateChangedWithReason(String roomId, String uid, RoomState state, RoomStateChangeReason reason) {
    }

    public void onRoomStats(RTCRoomStats stats) {
    }

    @Deprecated
    public void onRoomWarning(int warn) {
    }

    public void onScreenAudioPublishStateChanged(String roomId, String uid, PublishState state, PublishStateChangeReason reason) {
    }

    public void onScreenAudioSubscribeStateChanged(String roomId, String uid, SubscribeState state, SubscribeStateChangeReason reason) {
    }

    public void onScreenVideoPublishStateChanged(String roomId, String uid, PublishState state, PublishStateChangeReason reason) {
    }

    public void onScreenVideoSubscribeStateChanged(String roomId, String uid, SubscribeState state, SubscribeStateChangeReason reason) {
    }

    public void onSetRoomExtraInfoResult(long taskId, SetRoomExtraInfoResult result) {
    }

    @Deprecated
    public void onStreamAdd(RTCStream stream) {
    }

    public void onStreamPublishSuccess(String uid, boolean isScreen) {
    }

    @Deprecated
    public void onStreamRemove(RTCStream stream, StreamRemoveReason reason) {
    }

    public void onStreamStateChanged(String roomId, String uid, int state, String extraInfo) {
    }

    public void onStreamSubscribed(int stateCode, String userId, SubscribeConfig info) {
    }

    public void onSubscribePrivilegeTokenWillExpire() {
    }

    public void onSubtitleMessageReceived(SubtitleMessage[] subtitles) {
    }

    public void onSubtitleStateChanged(SubtitleState state, SubtitleErrorCode errorCode, String errorMessage) {
    }

    public void onTokenWillExpire() {
    }

    public void onUserBinaryMessageReceived(long msgid, String uid, ByteBuffer message) {
    }

    public void onUserBinaryMessageReceived(String uid, ByteBuffer message) {
    }

    public void onUserJoined(UserInfo userInfo) {
    }

    public void onUserLeave(String uid, int reason, String extraInfo) {
    }

    public void onUserMessageReceived(long msgid, String uid, String message) {
    }

    public void onUserMessageReceived(String uid, String message) {
    }

    public void onUserMessageSendResult(long msgid, int error) {
    }

    public void onUserPublishScreen(String uid, MediaStreamType type) {
    }

    public void onUserPublishScreenAudio(String roomId, String uid, boolean isPublish) {
    }

    public void onUserPublishScreenVideo(String roomId, String uid, boolean isPublish) {
    }

    public void onUserPublishStream(String uid, MediaStreamType type) {
    }

    public void onUserPublishStreamAudio(String roomId, String uid, boolean isPublish) {
    }

    public void onUserPublishStreamVideo(String roomId, String uid, boolean isPublish) {
    }

    public void onUserUnpublishScreen(String uid, MediaStreamType type, StreamRemoveReason reason) {
    }

    public void onUserUnpublishStream(String uid, MediaStreamType type, StreamRemoveReason reason) {
    }

    public void onUserVisibilityChanged(boolean currentUserVisibility, UserVisibilityChangeError errorCode) {
    }

    public void onVideoPublishStateChanged(String roomId, String uid, PublishState state, PublishStateChangeReason reason) {
    }

    public void onVideoStreamBanned(String uid, boolean banned) {
    }

    public void onVideoSubscribeStateChanged(String roomId, String uid, SubscribeState state, SubscribeStateChangeReason reason) {
    }
}
