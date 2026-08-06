package com.ss.bytertc.engine;

import com.ss.bytertc.engine.aigc.IRTCRoomEventHandlerAIGC;
import com.ss.bytertc.engine.audio.IRangeAudio;
import com.ss.bytertc.engine.audio.ISpatialAudio;
import com.ss.bytertc.engine.data.ForwardStreamInfo;
import com.ss.bytertc.engine.data.RemoteVideoConfig;
import com.ss.bytertc.engine.data.ReturnStatus;
import com.ss.bytertc.engine.data.SimulcastStreamType;
import com.ss.bytertc.engine.data.StreamIndex;
import com.ss.bytertc.engine.handler.IRTCRoomEventHandler;
import com.ss.bytertc.engine.handler.IRTCRoomEventHandlerEx;
import com.ss.bytertc.engine.handler.IRTSRoomEventHandler;
import com.ss.bytertc.engine.handler.RTCRoomEventHandler;
import com.ss.bytertc.engine.handler.RTCRoomEventHandlerAIGC;
import com.ss.bytertc.engine.handler.RTCRoomEventHandlerEx;
import com.ss.bytertc.engine.handler.RTCRoomEventHandlerRts;
import com.ss.bytertc.engine.type.AudioSelectionPriority;
import com.ss.bytertc.engine.type.MediaStreamType;
import com.ss.bytertc.engine.type.MessageConfig;
import com.ss.bytertc.engine.type.SubtitleConfig;
import com.ss.bytertc.engine.utils.LogUtil;
import com.ss.bytertc.engine.video.IPanoramicVideo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class RTCRoomImpl extends RTCRoomEx {
    protected static final String TAG = "RtcRoom";
    private final ReentrantReadWriteLock.ReadLock mJniReadLock;
    private final ReentrantReadWriteLock.WriteLock mJniWriteLock;
    protected long mNativeRtcRoom;
    private final ReentrantReadWriteLock mReadWriteLock;
    private String mRoom;
    protected int mRtcRoomCount;
    private RTCRoomEventHandler mRtcRoomEventHandler;
    private RTCRoomEventHandlerEx mRtcRoomEventHandlerEx;
    private RTCRoomEventHandlerRts mRtcRoomEventHandlerRts;
    private IRTCRoomEventHandler mRtcRoomHandler;
    private IRTCRoomEventHandlerEx mRtcRoomHandlerEx;
    private IRTSRoomEventHandler mRtcRoomHandlerRts;
    private String mUser;
    private IRTCRoomEventHandlerAIGC mRtcRoomHandlerAIGC = null;
    private RTCRoomEventHandlerAIGC mRtcRoomEventHandlerAIGC = null;
    private long mNativeRtcRoomEventHandler = 0;
    private long mNativeRtcRoomEventHandlerEx = 0;
    private long mNativeRtcRoomEventHandlerRts = 0;
    private long mNativeRtcRoomEventHandlerAIGC = 0;
    private NativeRangeAudio mRangeAudio = null;
    private NativeSpatialAudio mSpatialAudio = null;
    private NativePanoramicVideo mPanoramicVideo = null;

    public long getNativeHandle() {
        return this.mNativeRtcRoom;
    }

    public String getmRoom() {
        return this.mRoom;
    }

    public String getmUser() {
        return this.mUser;
    }

    public IRTCRoomEventHandler getRtcRoomHandler() {
        return this.mRtcRoomHandler;
    }

    public IRTCRoomEventHandlerEx getRtcRoomHandlerEx() {
        return this.mRtcRoomHandlerEx;
    }

    public void addRtcRoomCount() {
        this.mRtcRoomCount++;
    }

    public IRTSRoomEventHandler getRtcRoomHandlerRts() {
        return this.mRtcRoomHandlerRts;
    }

    public IRTCRoomEventHandlerAIGC getRtcRoomHandlerAIGC() {
        return this.mRtcRoomHandlerAIGC;
    }

    public RTCRoomImpl(String roomId, long nativeRtcRoom) {
        this.mNativeRtcRoom = 0L;
        this.mRtcRoomCount = 0;
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.mReadWriteLock = reentrantReadWriteLock;
        this.mJniReadLock = reentrantReadWriteLock.readLock();
        this.mJniWriteLock = reentrantReadWriteLock.writeLock();
        this.mNativeRtcRoom = nativeRtcRoom;
        this.mRoom = roomId;
        this.mRtcRoomCount = 1;
    }

    public static String getCloudRenderingInfo(String action, String effectInfo) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("action", action);
            jSONObject.put("externalService", "render");
            jSONObject.put("renderMeta", effectInfo);
            return jSONObject.toString();
        } catch (Exception e) {
            LogUtil.m216e(TAG, "getCloudRenderingInfo catch exception , e : " + e.getMessage());
            return null;
        }
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int joinRoom(String token, UserInfo userInfo, boolean userVisibility, RTCRoomConfig roomConfig) {
        int nativeJoinRoomWithRoomConfig;
        LogUtil.m215d(TAG, "joinRoom with token: " + token + ",room" + this.mRoom + " and uid: " + (userInfo == null ? "" : userInfo.getUid()));
        this.mJniReadLock.lock();
        try {
            if (this.mNativeRtcRoom == 0) {
                LogUtil.m216e(TAG, "native room is invalid, joinRoom failed.");
                nativeJoinRoomWithRoomConfig = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else if (userInfo == null) {
                nativeJoinRoomWithRoomConfig = ReturnStatus.RETURN_STATUS_PARAMETER_ERR.value();
            } else if (token == null) {
                nativeJoinRoomWithRoomConfig = ReturnStatus.RETURN_STATUS_PARAMETER_ERR.value();
            } else {
                this.mUser = userInfo.getUid();
                nativeJoinRoomWithRoomConfig = NativeRTCRoomFunctions.nativeJoinRoomWithRoomConfig(this.mNativeRtcRoom, token, userInfo, userVisibility, roomConfig);
            }
            return nativeJoinRoomWithRoomConfig;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int setRTCRoomEventHandler(IRTCRoomEventHandler rtcRoomEventHandler) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeRtcRoom == 0) {
                LogUtil.m216e(TAG, "native room is invalid, setRTCRoomEventHandler failed.");
                return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            }
            this.mRtcRoomHandler = rtcRoomEventHandler;
            RTCRoomEventHandler rTCRoomEventHandler = new RTCRoomEventHandler(this);
            this.mRtcRoomEventHandler = rTCRoomEventHandler;
            long j = this.mNativeRtcRoomEventHandler;
            this.mNativeRtcRoomEventHandler = NativeRTCRoomFunctions.nativeSetRTCRoomEventHandler(this.mNativeRtcRoom, rTCRoomEventHandler);
            if (j != 0) {
                NativeRTCRoomFunctions.nativeReleaseRTCRoomEventHandler(j);
            }
            this.mJniReadLock.unlock();
            return 0;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTSRoom
    public int leaveRoom() {
        int nativeLeaveRoom;
        LogUtil.m215d(TAG, "leaveChannel");
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeRtcRoom;
            if (j == 0) {
                LogUtil.m216e(TAG, "native rtcroom is invalid, leaveChannel failed.");
                nativeLeaveRoom = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                this.mRoom = "";
                this.mUser = "";
                nativeLeaveRoom = NativeRTCRoomFunctions.nativeLeaveRoom(j, "");
            }
            return nativeLeaveRoom;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int leaveRoom(String extra_info) {
        int nativeLeaveRoom;
        LogUtil.m215d(TAG, "leaveChannel");
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeRtcRoom;
            if (j == 0) {
                LogUtil.m216e(TAG, "native rtcroom is invalid, leaveChannel failed.");
                nativeLeaveRoom = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                this.mRoom = "";
                this.mUser = "";
                nativeLeaveRoom = NativeRTCRoomFunctions.nativeLeaveRoom(j, extra_info);
            }
            return nativeLeaveRoom;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int setUserVisibility(boolean enable) {
        int nativeSetUserVisibility;
        LogUtil.m215d(TAG, "setUserVisibility. enable : " + enable);
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeRtcRoom;
            if (j == 0) {
                LogUtil.m216e(TAG, "native engine is invalid, setUserVisibility failed.");
                nativeSetUserVisibility = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSetUserVisibility = NativeRTCRoomFunctions.nativeSetUserVisibility(j, enable);
            }
            return nativeSetUserVisibility;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTSRoom
    public int updateToken(String token) {
        int nativeUpdateToken;
        LogUtil.m215d(TAG, "updateToken. token : " + token);
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeRtcRoom;
            if (j == 0) {
                LogUtil.m216e(TAG, "native rtcroom is invalid, updateToken failed.");
                nativeUpdateToken = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeUpdateToken = NativeRTCRoomFunctions.nativeUpdateToken(j, token);
            }
            return nativeUpdateToken;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTSRoom
    public long sendUserMessage(String uid, String message, MessageConfig config) {
        LogUtil.m215d(TAG, "SendUserMessage. uid : " + uid + ", message" + message);
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeRtcRoom;
            if (j == 0) {
                LogUtil.m216e(TAG, "native rtcroom is invalid, SendUserMessage failed.");
                this.mJniReadLock.unlock();
                return -1L;
            }
            return NativeRTCRoomFunctions.nativeSendUserMessage(j, uid, message, config.value());
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTSRoom
    public long sendUserBinaryMessage(String uid, byte[] buffer, MessageConfig config) {
        LogUtil.m215d(TAG, "SendUserBinaryMessage. uid : " + uid + ", message length:" + buffer.length);
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeRtcRoom;
            if (j == 0) {
                LogUtil.m216e(TAG, "native rtcroom is invalid, SendUserBinaryMessage failed.");
                this.mJniReadLock.unlock();
                return -1L;
            }
            return NativeRTCRoomFunctions.nativeSendUserBinaryMessage(j, uid, buffer, config.value());
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTSRoom
    public long sendRoomMessage(String message) {
        LogUtil.m215d(TAG, "SendRoomMessage ");
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeRtcRoom;
            if (j == 0) {
                LogUtil.m216e(TAG, "native rtcroom is invalid, SendRoomMessage failed.");
                this.mJniReadLock.unlock();
                return -1L;
            }
            return NativeRTCRoomFunctions.nativeSendRoomMessage(j, message);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTSRoom
    public long sendRoomBinaryMessage(byte[] buffer) {
        LogUtil.m215d(TAG, "SendRoomBinaryMessage ");
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeRtcRoom;
            if (j == 0) {
                LogUtil.m216e(TAG, "native rtcroom is invalid, SendRoomBinaryMessage failed.");
                this.mJniReadLock.unlock();
                return -1L;
            }
            return NativeRTCRoomFunctions.nativeSendRoomBinaryMessage(j, buffer);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public long sendControlBinaryMessage(String type, String action, byte[] buffer) {
        LogUtil.m215d(TAG, "sendControlBinaryMessage. type : " + type + ", action : " + action + ", message length:" + buffer.length);
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeRtcRoom;
            if (j == 0) {
                LogUtil.m216e(TAG, "native rtcroom is invalid, sendControlBinaryMessage failed.");
                this.mJniReadLock.unlock();
                return -1L;
            }
            return NativeRTCRoomFunctions.nativeSendControlBinaryMessage(j, type, action, buffer);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int setMultiDeviceAVSync(String audioUserId) {
        int nativeSetMultiDeviceAVSync;
        LogUtil.m215d(TAG, "setMultiDeviceAVSync ");
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeRtcRoom;
            if (j == 0) {
                LogUtil.m216e(TAG, "native rtcroom is invalid, setMultiDeviceAVSync failed.");
                nativeSetMultiDeviceAVSync = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSetMultiDeviceAVSync = NativeRTCRoomFunctions.nativeSetMultiDeviceAVSync(j, audioUserId);
            }
            return nativeSetMultiDeviceAVSync;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int setRemoteSimulcastStreamType(String userId, SimulcastStreamType streamType) {
        int value;
        LogUtil.m215d(TAG, "setRemoteSimulcastStreamType");
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeRtcRoom;
            if (j != 0 && streamType != null) {
                value = NativeRTCRoomFunctions.nativeSetRemoteSimulcastStreamType(j, userId, streamType.value());
                return value;
            }
            LogUtil.m216e(TAG, "native rtcroom is invalid,setRemoteSimulcastStreamType  failed.\"");
            value = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            return value;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int publishStreamVideo(boolean publish) {
        int nativePublishStreamVideo;
        LogUtil.m215d(TAG, "publishStreamVideo");
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeRtcRoom;
            if (j == 0) {
                LogUtil.m216e(TAG, "native rtcroom is invalid,publishStreamVideo failed.\"");
                nativePublishStreamVideo = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativePublishStreamVideo = NativeRTCRoomFunctions.nativePublishStreamVideo(j, publish);
            }
            return nativePublishStreamVideo;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int publishStreamAudio(boolean publish) {
        int nativePublishStreamAudio;
        LogUtil.m215d(TAG, "publishStreamAudio");
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeRtcRoom;
            if (j == 0) {
                LogUtil.m216e(TAG, "native rtcroom is invalid,publishStreamAudio failed.\"");
                nativePublishStreamAudio = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativePublishStreamAudio = NativeRTCRoomFunctions.nativePublishStreamAudio(j, publish);
            }
            return nativePublishStreamAudio;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int publishScreenVideo(boolean publish) {
        int nativePublishScreenVideo;
        LogUtil.m215d(TAG, "publishScreenVideo");
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeRtcRoom;
            if (j == 0) {
                LogUtil.m216e(TAG, "native rtcroom is invalid,publishScreenVideo failed.\"");
                nativePublishScreenVideo = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativePublishScreenVideo = NativeRTCRoomFunctions.nativePublishScreenVideo(j, publish);
            }
            return nativePublishScreenVideo;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int publishScreenAudio(boolean publish) {
        int nativePublishScreenAudio;
        LogUtil.m215d(TAG, "publishScreenAudio");
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeRtcRoom;
            if (j == 0) {
                LogUtil.m216e(TAG, "native rtcroom is invalid,publishScreenAudio failed.\"");
                nativePublishScreenAudio = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativePublishScreenAudio = NativeRTCRoomFunctions.nativePublishScreenAudio(j, publish);
            }
            return nativePublishScreenAudio;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int subscribeStreamVideo(String userId, boolean subscribe) {
        int nativeSubscribeStreamVideo;
        LogUtil.m215d(TAG, "subscribeStreamVideo: userId: " + userId + ", subscribe: " + subscribe);
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeRtcRoom;
            if (j == 0) {
                LogUtil.m216e(TAG, "native rtcroom is invalid, subscribeStreamVideo failed.\"");
                nativeSubscribeStreamVideo = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSubscribeStreamVideo = NativeRTCRoomFunctions.nativeSubscribeStreamVideo(j, userId, subscribe);
            }
            return nativeSubscribeStreamVideo;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int subscribeStreamAudio(String userId, boolean subscribe) {
        int nativeSubscribeStreamAudio;
        LogUtil.m215d(TAG, "subscribeStreamAudio: userId: " + userId + ", subscribe: " + subscribe);
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeRtcRoom;
            if (j == 0) {
                LogUtil.m216e(TAG, "native rtcroom is invalid, subscribeStreamAudio failed.\"");
                nativeSubscribeStreamAudio = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSubscribeStreamAudio = NativeRTCRoomFunctions.nativeSubscribeStreamAudio(j, userId, subscribe);
            }
            return nativeSubscribeStreamAudio;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int subscribeScreenVideo(String userId, boolean subscribe) {
        int nativeSubscribeScreenVideo;
        LogUtil.m215d(TAG, "subscribeScreenVideo: userId: " + userId + ", subscribe: " + subscribe);
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeRtcRoom;
            if (j == 0) {
                LogUtil.m216e(TAG, "native rtcroom is invalid, subscribeScreenVideo failed.\"");
                nativeSubscribeScreenVideo = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSubscribeScreenVideo = NativeRTCRoomFunctions.nativeSubscribeScreenVideo(j, userId, subscribe);
            }
            return nativeSubscribeScreenVideo;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int subscribeScreenAudio(String userId, boolean subscribe) {
        int nativeSubscribeScreenAudio;
        LogUtil.m215d(TAG, "subscribeScreenAudio: userId: " + userId + ", subscribe: " + subscribe);
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeRtcRoom;
            if (j == 0) {
                LogUtil.m216e(TAG, "native rtcroom is invalid, subscribeScreenAudio failed.\"");
                nativeSubscribeScreenAudio = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSubscribeScreenAudio = NativeRTCRoomFunctions.nativeSubscribeScreenAudio(j, userId, subscribe);
            }
            return nativeSubscribeScreenAudio;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int subscribeAllStreamsVideo(boolean subscribe) {
        int nativeSubscribeAllStreamsVideo;
        LogUtil.m215d(TAG, "subscribeAllStreamsVideo, subscribe:" + subscribe);
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeRtcRoom;
            if (j == 0) {
                LogUtil.m216e(TAG, "native engine is invalid, subscribeAllStreamsVideo failed.");
                nativeSubscribeAllStreamsVideo = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSubscribeAllStreamsVideo = NativeRTCRoomFunctions.nativeSubscribeAllStreamsVideo(j, subscribe);
            }
            return nativeSubscribeAllStreamsVideo;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int subscribeAllStreamsAudio(boolean subscribe) {
        int nativeSubscribeAllStreamsAudio;
        LogUtil.m215d(TAG, "subscribeAllStreamsAudio, subscribe:" + subscribe);
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeRtcRoom;
            if (j == 0) {
                LogUtil.m216e(TAG, "native engine is invalid, subscribeAllStreamsAudio failed.");
                nativeSubscribeAllStreamsAudio = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSubscribeAllStreamsAudio = NativeRTCRoomFunctions.nativeSubscribeAllStreamsAudio(j, subscribe);
            }
            return nativeSubscribeAllStreamsAudio;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int enableSubscribeLocalStream(boolean enable) {
        int nativeEnableSubscribeLocalStream;
        LogUtil.m215d(TAG, "enableSubscribeLocalStream: " + enable);
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeRtcRoom;
            if (j == 0) {
                LogUtil.m216e(TAG, "native rtcroom is invalid, EnableSubscribeLocalStream failed.");
                nativeEnableSubscribeLocalStream = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeEnableSubscribeLocalStream = NativeRTCRoomFunctions.nativeEnableSubscribeLocalStream(j, enable);
            }
            return nativeEnableSubscribeLocalStream;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int pauseAllSubscribedStreamVideo() {
        int nativePauseAllSubscribedStreamVideo;
        LogUtil.m215d(TAG, "pauseAllSubscribedStreamVideo...");
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeRtcRoom;
            if (j == 0) {
                LogUtil.m216e(TAG, "native rtcroom is invalid, pauseAllSubscribedStreamVideo failed.");
                nativePauseAllSubscribedStreamVideo = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativePauseAllSubscribedStreamVideo = NativeRTCRoomFunctions.nativePauseAllSubscribedStreamVideo(j);
            }
            return nativePauseAllSubscribedStreamVideo;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int pauseAllSubscribedStreamAudio() {
        int nativePauseAllSubscribedStreamAudio;
        LogUtil.m215d(TAG, "pauseAllSubscribedStreamAudio...");
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeRtcRoom;
            if (j == 0) {
                LogUtil.m216e(TAG, "native rtcroom is invalid, pauseAllSubscribedStreamAudio failed.");
                nativePauseAllSubscribedStreamAudio = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativePauseAllSubscribedStreamAudio = NativeRTCRoomFunctions.nativePauseAllSubscribedStreamAudio(j);
            }
            return nativePauseAllSubscribedStreamAudio;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int resumeAllSubscribedStreamVideo() {
        int nativeResumeAllSubscribedStreamVideo;
        LogUtil.m215d(TAG, "resumeAllSubscribedStreamVideo...");
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeRtcRoom;
            if (j == 0) {
                LogUtil.m216e(TAG, "native rtcroom is invalid, resumeAllSubscribedStreamVideo failed.");
                nativeResumeAllSubscribedStreamVideo = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeResumeAllSubscribedStreamVideo = NativeRTCRoomFunctions.nativeResumeAllSubscribedStreamVideo(j);
            }
            return nativeResumeAllSubscribedStreamVideo;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int resumeAllSubscribedStreamAudio() {
        int nativeResumeAllSubscribedStreamAudio;
        LogUtil.m215d(TAG, "resumeAllSubscribedStreamAudio...");
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeRtcRoom;
            if (j == 0) {
                LogUtil.m216e(TAG, "native rtcroom is invalid, resumeAllSubscribedStreamAudio failed.");
                nativeResumeAllSubscribedStreamAudio = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeResumeAllSubscribedStreamAudio = NativeRTCRoomFunctions.nativeResumeAllSubscribedStreamAudio(j);
            }
            return nativeResumeAllSubscribedStreamAudio;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCRoom, com.ss.bytertc.engine.RTSRoom
    public void destroy() {
        LogUtil.m215d(TAG, "Destroy ");
        this.mJniWriteLock.lock();
        int i = this.mRtcRoomCount - 1;
        this.mRtcRoomCount = i;
        try {
            long j = this.mNativeRtcRoom;
            if (j == 0) {
                LogUtil.m216e(TAG, "native rtcroom is invalid, Destroy failed.");
                return;
            }
            if (i <= 0) {
                this.mNativeRtcRoom = 0L;
            }
            NativeRangeAudio nativeRangeAudio = this.mRangeAudio;
            if (nativeRangeAudio instanceof NativeRangeAudio) {
                NativeRangeAudio nativeRangeAudio2 = nativeRangeAudio;
                nativeRangeAudio.destroy();
            }
            NativeSpatialAudio nativeSpatialAudio = this.mSpatialAudio;
            if (nativeSpatialAudio instanceof NativeSpatialAudio) {
                NativeSpatialAudio nativeSpatialAudio2 = nativeSpatialAudio;
                nativeSpatialAudio.destroy();
            }
            this.mJniWriteLock.unlock();
            NativeRTCRoomFunctions.nativeDestory(j);
            if (this.mRtcRoomCount <= 0) {
                long j2 = this.mNativeRtcRoomEventHandlerEx;
                if (j2 != 0) {
                    NativeRTCRoomFunctions.nativeReleaseRTCRoomEventHandlerEx(j2);
                    this.mNativeRtcRoomEventHandlerEx = 0L;
                }
                long j3 = this.mNativeRtcRoomEventHandler;
                if (j3 != 0) {
                    NativeRTCRoomFunctions.nativeReleaseRTCRoomEventHandler(j3);
                    this.mNativeRtcRoomEventHandler = 0L;
                }
                long j4 = this.mNativeRtcRoomEventHandlerAIGC;
                if (j4 != 0) {
                    NativeRTCRoomFunctions.nativeReleaseRTCRoomEventHandlerAIGC(j4);
                    this.mNativeRtcRoomEventHandlerAIGC = 0L;
                }
            }
        } finally {
            this.mJniWriteLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int startForwardStreamToRooms(List<ForwardStreamInfo> forwardStreamInfos) {
        int nativeStartForwardStreamToRooms;
        this.mJniReadLock.lock();
        try {
            if (this.mNativeRtcRoom == 0) {
                LogUtil.m216e(TAG, "native rtcroom is invalid, startForwardStreamToRooms failed.");
                nativeStartForwardStreamToRooms = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else if (forwardStreamInfos == null) {
                nativeStartForwardStreamToRooms = ReturnStatus.RETURN_STATUS_PARAMETER_ERR.value();
            } else {
                LinkedList linkedList = new LinkedList();
                Iterator<ForwardStreamInfo> it = forwardStreamInfos.iterator();
                while (it.hasNext()) {
                    linkedList.add(new InternalForwardStreamInfo(it.next()));
                }
                nativeStartForwardStreamToRooms = NativeRTCRoomFunctions.nativeStartForwardStreamToRooms(this.mNativeRtcRoom, linkedList);
            }
            return nativeStartForwardStreamToRooms;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int updateForwardStreamToRooms(List<ForwardStreamInfo> forwardStreamInfos) {
        int nativeUpdateForwardStreamToRooms;
        this.mJniReadLock.lock();
        try {
            if (this.mNativeRtcRoom == 0) {
                LogUtil.m216e(TAG, "native rtcroom is invalid, updateForwardStreamToRooms failed.");
                nativeUpdateForwardStreamToRooms = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else if (forwardStreamInfos == null) {
                nativeUpdateForwardStreamToRooms = ReturnStatus.RETURN_STATUS_PARAMETER_ERR.value();
            } else {
                LinkedList linkedList = new LinkedList();
                Iterator<ForwardStreamInfo> it = forwardStreamInfos.iterator();
                while (it.hasNext()) {
                    linkedList.add(new InternalForwardStreamInfo(it.next()));
                }
                nativeUpdateForwardStreamToRooms = NativeRTCRoomFunctions.nativeUpdateForwardStreamToRooms(this.mNativeRtcRoom, linkedList);
            }
            return nativeUpdateForwardStreamToRooms;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int startForwardStreamToRooms(List<ForwardStreamInfo> forwardStreamInfos, String roomGroupId) {
        int nativeStartForwardStreamToRoomsWithRoomGroupId;
        this.mJniReadLock.lock();
        try {
            if (this.mNativeRtcRoom == 0) {
                LogUtil.m216e(TAG, "native rtcroom is invalid, startForwardStreamToRooms WithRoomGroupId failed.");
                nativeStartForwardStreamToRoomsWithRoomGroupId = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else if (forwardStreamInfos == null) {
                nativeStartForwardStreamToRoomsWithRoomGroupId = ReturnStatus.RETURN_STATUS_PARAMETER_ERR.value();
            } else {
                LinkedList linkedList = new LinkedList();
                Iterator<ForwardStreamInfo> it = forwardStreamInfos.iterator();
                while (it.hasNext()) {
                    linkedList.add(new InternalForwardStreamInfo(it.next()));
                }
                nativeStartForwardStreamToRoomsWithRoomGroupId = NativeRTCRoomFunctions.nativeStartForwardStreamToRoomsWithRoomGroupId(this.mNativeRtcRoom, linkedList, roomGroupId);
            }
            return nativeStartForwardStreamToRoomsWithRoomGroupId;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int updateForwardStreamToRooms(List<ForwardStreamInfo> forwardStreamInfos, String roomGroupId) {
        int nativeUpdateForwardStreamToRoomsWithRoomGroupId;
        this.mJniReadLock.lock();
        try {
            if (this.mNativeRtcRoom == 0) {
                LogUtil.m216e(TAG, "native rtcroom is invalid, updateForwardStreamToRooms  WithRoomGroupId failed.");
                nativeUpdateForwardStreamToRoomsWithRoomGroupId = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else if (forwardStreamInfos == null) {
                nativeUpdateForwardStreamToRoomsWithRoomGroupId = ReturnStatus.RETURN_STATUS_PARAMETER_ERR.value();
            } else {
                LinkedList linkedList = new LinkedList();
                Iterator<ForwardStreamInfo> it = forwardStreamInfos.iterator();
                while (it.hasNext()) {
                    linkedList.add(new InternalForwardStreamInfo(it.next()));
                }
                nativeUpdateForwardStreamToRoomsWithRoomGroupId = NativeRTCRoomFunctions.nativeUpdateForwardStreamToRoomsWithRoomGroupId(this.mNativeRtcRoom, linkedList, roomGroupId);
            }
            return nativeUpdateForwardStreamToRoomsWithRoomGroupId;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int stopForwardStreamToRooms() {
        int nativeStopForwardStreamToRooms;
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeRtcRoom;
            if (j == 0) {
                LogUtil.m216e(TAG, "native rtcroom is invalid, stopForwardStreamToRooms failed.");
                nativeStopForwardStreamToRooms = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeStopForwardStreamToRooms = NativeRTCRoomFunctions.nativeStopForwardStreamToRooms(j);
            }
            return nativeStopForwardStreamToRooms;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int pauseForwardStreamToAllRooms() {
        int nativePauseForwardStreamToAllRooms;
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeRtcRoom;
            if (j == 0) {
                LogUtil.m216e(TAG, "native rtcroom is invalid, pauseForwardStreamToAllRooms failed.");
                nativePauseForwardStreamToAllRooms = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativePauseForwardStreamToAllRooms = NativeRTCRoomFunctions.nativePauseForwardStreamToAllRooms(j);
            }
            return nativePauseForwardStreamToAllRooms;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int resumeForwardStreamToAllRooms() {
        int nativeResumeForwardStreamToAllRooms;
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeRtcRoom;
            if (j == 0) {
                LogUtil.m216e(TAG, "native rtcroom is invalid, resumeForwardStreamToAllRooms failed.");
                nativeResumeForwardStreamToAllRooms = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeResumeForwardStreamToAllRooms = NativeRTCRoomFunctions.nativeResumeForwardStreamToAllRooms(j);
            }
            return nativeResumeForwardStreamToAllRooms;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public IRangeAudio getRangeAudio() {
        LogUtil.m215d(TAG, "getRangeAudio...");
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeRtcRoom;
            if (j == 0) {
                LogUtil.m216e(TAG, "native rtcroom is invalid, getRangeAudio failed.");
            } else {
                NativeRangeAudio nativeRangeAudio = this.mRangeAudio;
                if (nativeRangeAudio == null) {
                    long nativeGetRangeAudio = NativeRTCRoomFunctions.nativeGetRangeAudio(j);
                    if (nativeGetRangeAudio == 0) {
                        LogUtil.m216e(TAG, "getRangeAudio failed");
                    } else {
                        nativeRangeAudio = new NativeRangeAudio(nativeGetRangeAudio);
                        this.mRangeAudio = nativeRangeAudio;
                    }
                }
                return nativeRangeAudio;
            }
            return null;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public ISpatialAudio getSpatialAudio() {
        LogUtil.m215d(TAG, "getSpatialAudio...");
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeRtcRoom;
            if (j == 0) {
                LogUtil.m216e(TAG, "native rtcroom is invalid, getSpatialAudio failed.");
            } else {
                NativeSpatialAudio nativeSpatialAudio = this.mSpatialAudio;
                if (nativeSpatialAudio == null) {
                    long nativeGetSpatialAudio = NativeRTCRoomFunctions.nativeGetSpatialAudio(j);
                    if (nativeGetSpatialAudio == 0) {
                        LogUtil.m216e(TAG, "getSpatialAudio failed");
                    } else {
                        nativeSpatialAudio = new NativeSpatialAudio(nativeGetSpatialAudio);
                        this.mSpatialAudio = nativeSpatialAudio;
                    }
                }
                return nativeSpatialAudio;
            }
            return null;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int setRemoteRoomAudioPlaybackVolume(int volume) {
        int nativeSetRemoteRoomAudioPlaybackVolume;
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeRtcRoom;
            if (j == 0) {
                LogUtil.m216e(TAG, "native rtcroom is invalid, setRemoteRoomAudioPlaybackVolume failed.");
                nativeSetRemoteRoomAudioPlaybackVolume = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSetRemoteRoomAudioPlaybackVolume = NativeRTCRoomFunctions.nativeSetRemoteRoomAudioPlaybackVolume(j, volume);
            }
            return nativeSetRemoteRoomAudioPlaybackVolume;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public IPanoramicVideo getPanoramicVideo() {
        LogUtil.m215d(TAG, "getPanoramicVideo...");
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeRtcRoom;
            if (j == 0) {
                LogUtil.m216e(TAG, "native rtcroom is invalid, getPanoramicVideo failed.");
            } else {
                NativePanoramicVideo nativePanoramicVideo = this.mPanoramicVideo;
                if (nativePanoramicVideo == null) {
                    long nativeGetPanoramicVideo = NativeRTCRoomFunctions.nativeGetPanoramicVideo(j);
                    if (nativeGetPanoramicVideo == 0) {
                        LogUtil.m216e(TAG, "getPanoramicVideo failed");
                    } else {
                        nativePanoramicVideo = new NativePanoramicVideo(nativeGetPanoramicVideo);
                        this.mPanoramicVideo = nativePanoramicVideo;
                    }
                }
                return nativePanoramicVideo;
            }
            return null;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int setAudioSelectionConfig(AudioSelectionPriority audioSelectionPriority) {
        int nativeSetAudioSelectionConfig;
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeRtcRoom;
            if (j == 0) {
                LogUtil.m216e(TAG, "native rtcroom is invalid, setAudioSelectionConfig failed.");
                nativeSetAudioSelectionConfig = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSetAudioSelectionConfig = NativeRTCRoomFunctions.nativeSetAudioSelectionConfig(j, audioSelectionPriority.value());
            }
            return nativeSetAudioSelectionConfig;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public long setRoomExtraInfo(String key, String value) {
        this.mJniReadLock.lock();
        if (key == null) {
            this.mJniReadLock.unlock();
            return -2L;
        }
        if (value == null) {
            this.mJniReadLock.unlock();
            return -3L;
        }
        try {
            LogUtil.m215d(TAG, "setRoomExtraInfo,key : " + key + ", value" + value);
            long j = this.mNativeRtcRoom;
            if (j == 0) {
                LogUtil.m216e(TAG, "native rtcroom is invalid, setRoomExtraInfo failed.");
                this.mJniReadLock.unlock();
                return -1L;
            }
            return NativeRTCRoomFunctions.nativeSetRoomExtraInfo(j, key, value);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int startSubtitle(SubtitleConfig subtitleConfig) {
        int value;
        this.mJniReadLock.lock();
        try {
            LogUtil.m215d(TAG, "startSubtitle");
            long j = this.mNativeRtcRoom;
            if (j != 0 && subtitleConfig != null) {
                value = NativeRTCRoomFunctions.nativeStartSubtitle(j, subtitleConfig.mode.value(), subtitleConfig.targetLanguage);
                return value;
            }
            LogUtil.m216e(TAG, "native rtcroom or config is invalid, startSubtitle failed.");
            value = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            return value;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int stopSubtitle() {
        int nativeStopSubtitle;
        this.mJniReadLock.lock();
        try {
            LogUtil.m215d(TAG, "stopSubtitle");
            long j = this.mNativeRtcRoom;
            if (j == 0) {
                LogUtil.m216e(TAG, "native rtcroom is invalid, stopSubtitle failed.");
                nativeStopSubtitle = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeStopSubtitle = NativeRTCRoomFunctions.nativeStopSubtitle(j);
            }
            return nativeStopSubtitle;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public String getRoomId() {
        String nativeGetRoomId;
        LogUtil.m215d(TAG, "getRoomId");
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeRtcRoom;
            if (j == 0) {
                LogUtil.m216e(TAG, "native rtcroom is invalid, getRoomId failed.");
                nativeGetRoomId = "";
            } else {
                nativeGetRoomId = NativeRTCRoomFunctions.nativeGetRoomId(j);
            }
            return nativeGetRoomId;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCRoomEx
    public int publishStream(StreamIndex streamIndex, MediaStreamType type) {
        int nativePublishStreamEx;
        LogUtil.m215d(TAG, "publishStream: " + streamIndex);
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeRtcRoom;
            if (j == 0) {
                LogUtil.m216e(TAG, "native rtcroom is invalid, publishStream failed.\"");
                nativePublishStreamEx = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativePublishStreamEx = NativeRTCRoomFunctions.nativePublishStreamEx(j, streamIndex.value(), type.value);
            }
            return nativePublishStreamEx;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCRoomEx
    public int unpublishStream(StreamIndex streamIndex, MediaStreamType type) {
        int nativeUnpublishStreamEx;
        LogUtil.m215d(TAG, "unpublishStream: " + streamIndex);
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeRtcRoom;
            if (j == 0) {
                LogUtil.m216e(TAG, "native rtcroom is invalid, unpublishStream failed.\"");
                nativeUnpublishStreamEx = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeUnpublishStreamEx = NativeRTCRoomFunctions.nativeUnpublishStreamEx(j, streamIndex.value(), type.value);
            }
            return nativeUnpublishStreamEx;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCRoomEx
    public int subscribeStream(String userId, StreamIndex streamIndex, MediaStreamType type) {
        int nativeSubscribeStreamEx;
        LogUtil.m215d(TAG, "subscribeStream: userId: " + userId + ", streamIndex: " + streamIndex);
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeRtcRoom;
            if (j == 0) {
                LogUtil.m216e(TAG, "native rtcroom is invalid, subscribeStream failed.\"");
                nativeSubscribeStreamEx = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSubscribeStreamEx = NativeRTCRoomFunctions.nativeSubscribeStreamEx(j, userId, streamIndex.value(), type.value);
            }
            return nativeSubscribeStreamEx;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCRoomEx
    public int unsubscribeStream(String userId, StreamIndex streamIndex, MediaStreamType type) {
        int nativeUnsubscribeStreamEx;
        LogUtil.m215d(TAG, "unsubscribeStream: userId: " + userId + ", streamIndex: " + streamIndex);
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeRtcRoom;
            if (j == 0) {
                LogUtil.m216e(TAG, "native rtcroom is invalid, unsubscribeStream failed.\"");
                nativeUnsubscribeStreamEx = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeUnsubscribeStreamEx = NativeRTCRoomFunctions.nativeUnsubscribeStreamEx(j, userId, streamIndex.value(), type.value);
            }
            return nativeUnsubscribeStreamEx;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCRoomEx
    public int setRemoteVideoConfig(String userId, StreamIndex streamIndex, RemoteVideoConfig remoteVideoConfig) {
        int nativeSetRemoteVideoConfigEx;
        LogUtil.m215d(TAG, "setRemoteVideoConfig: userId: " + userId + ", streamIndex: " + streamIndex);
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeRtcRoom;
            if (j == 0) {
                LogUtil.m216e(TAG, "native rtcroom is invalid, setRemoteVideoConfig failed.\"");
                nativeSetRemoteVideoConfigEx = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSetRemoteVideoConfigEx = NativeRTCRoomFunctions.nativeSetRemoteVideoConfigEx(j, userId, streamIndex.value(), remoteVideoConfig.getWidth(), remoteVideoConfig.getHeight(), remoteVideoConfig.getFrameRate());
            }
            return nativeSetRemoteVideoConfigEx;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCRoomEx
    public int setRTCRoomEventHandlerEx(IRTCRoomEventHandlerEx eventHandlerEx) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeRtcRoom == 0) {
                LogUtil.m216e(TAG, "native room is invalid, setRTCRoomEventHandler failed.");
                return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            }
            this.mRtcRoomHandlerEx = eventHandlerEx;
            RTCRoomEventHandlerEx rTCRoomEventHandlerEx = new RTCRoomEventHandlerEx(this);
            this.mRtcRoomEventHandlerEx = rTCRoomEventHandlerEx;
            long j = this.mNativeRtcRoomEventHandlerEx;
            this.mNativeRtcRoomEventHandlerEx = NativeRTCRoomFunctions.nativeSetRTCRoomEventHandlerEx(this.mNativeRtcRoom, rTCRoomEventHandlerEx);
            if (j != 0) {
                NativeRTCRoomFunctions.nativeReleaseRTCRoomEventHandlerEx(j);
            }
            this.mJniReadLock.unlock();
            return 0;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTSRoom
    public int setRTSRoomEventHandler(IRTSRoomEventHandler rtcRoomEventHandler) {
        this.mJniReadLock.lock();
        return 0;
    }

    @Override // com.ss.bytertc.engine.RTSRoom
    public int joinRTSRoom(String token, UserInfo userInfo) {
        LogUtil.m215d(TAG, "joinRoom with token: " + token + ",room" + this.mRoom + " and uid: " + (userInfo == null ? "" : userInfo.getUid()));
        this.mJniReadLock.lock();
        return -1;
    }

    public int setRTCRoomEventHandlerAIGC(IRTCRoomEventHandlerAIGC eventHandlerAIGC) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeRtcRoom == 0) {
                LogUtil.m216e(TAG, "native room is invalid, setRTCRoomEventHandlerAIGC failed.");
                return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            }
            this.mRtcRoomHandlerAIGC = eventHandlerAIGC;
            RTCRoomEventHandlerAIGC rTCRoomEventHandlerAIGC = new RTCRoomEventHandlerAIGC(this);
            this.mRtcRoomEventHandlerAIGC = rTCRoomEventHandlerAIGC;
            long j = this.mNativeRtcRoomEventHandlerAIGC;
            this.mNativeRtcRoomEventHandlerAIGC = NativeRTCRoomFunctions.nativeSetRTCRoomEventHandlerAIGC(this.mNativeRtcRoom, rTCRoomEventHandlerAIGC);
            if (j != 0) {
                NativeRTCRoomFunctions.nativeReleaseRTCRoomEventHandlerAIGC(j);
            }
            this.mJniReadLock.unlock();
            return 0;
        } finally {
            this.mJniReadLock.unlock();
        }
    }
}
