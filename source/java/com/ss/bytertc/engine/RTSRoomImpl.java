package com.ss.bytertc.engine;

import com.ss.bytertc.engine.data.ReturnStatus;
import com.ss.bytertc.engine.handler.IRTSRoomEventHandler;
import com.ss.bytertc.engine.handler.RTCRoomEventHandlerRts;
import com.ss.bytertc.engine.type.MessageConfig;
import com.ss.bytertc.engine.utils.LogUtil;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class RTSRoomImpl extends RTSRoom {
    protected static final String TAG = "RTSRoom";
    private final ReentrantReadWriteLock.ReadLock mJniReadLock;
    private final ReentrantReadWriteLock.WriteLock mJniWriteLock;
    protected long mNativeRtcRoom;
    private long mNativeRtcRoomEventHandlerRts = 0;
    private final ReentrantReadWriteLock mReadWriteLock;
    private String mRoom;
    private RTCRoomEventHandlerRts mRtcRoomEventHandlerRts;
    private IRTSRoomEventHandler mRtcRoomHandlerRts;
    private String mUser;

    public long getNativeHandle() {
        return this.mNativeRtcRoom;
    }

    public String getmRoom() {
        return this.mRoom;
    }

    public String getmUser() {
        return this.mUser;
    }

    public IRTSRoomEventHandler getRtcRoomHandlerRts() {
        return this.mRtcRoomHandlerRts;
    }

    public RTSRoomImpl(String roomId, long nativeRtcRoom) {
        this.mNativeRtcRoom = 0L;
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.mReadWriteLock = reentrantReadWriteLock;
        this.mJniReadLock = reentrantReadWriteLock.readLock();
        this.mJniWriteLock = reentrantReadWriteLock.writeLock();
        this.mNativeRtcRoom = nativeRtcRoom;
        this.mRoom = roomId;
    }

    @Override // com.ss.bytertc.engine.RTSRoom
    public int joinRTSRoom(String token, UserInfo userInfo) {
        int nativeJoinRTSRoom;
        LogUtil.m215d(TAG, "joinRoom with token: " + token + ",room" + this.mRoom + " and uid: " + (userInfo == null ? "" : userInfo.getUid()));
        this.mJniReadLock.lock();
        try {
            if (this.mNativeRtcRoom == 0) {
                LogUtil.m216e(TAG, "native room is invalid, joinRoom failed.");
                nativeJoinRTSRoom = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else if (userInfo == null) {
                nativeJoinRTSRoom = ReturnStatus.RETURN_STATUS_PARAMETER_ERR.value();
            } else if (token == null) {
                nativeJoinRTSRoom = ReturnStatus.RETURN_STATUS_PARAMETER_ERR.value();
            } else {
                this.mUser = userInfo.getUid();
                nativeJoinRTSRoom = NativeRTCRoomFunctions.nativeJoinRTSRoom(this.mNativeRtcRoom, token, userInfo);
            }
            return nativeJoinRTSRoom;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTSRoom
    public int leaveRoom() {
        int nativeLeaveRTSRoom;
        LogUtil.m215d(TAG, "leaveChannel");
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeRtcRoom;
            if (j == 0) {
                LogUtil.m216e(TAG, "native rtcroom is invalid, leaveChannel failed.");
                nativeLeaveRTSRoom = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                this.mRoom = "";
                this.mUser = "";
                nativeLeaveRTSRoom = NativeRTCRoomFunctions.nativeLeaveRTSRoom(j);
            }
            return nativeLeaveRTSRoom;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTSRoom
    public int updateToken(String token) {
        int nativeUpdateRTSToken;
        LogUtil.m215d(TAG, "updateToken. token : " + token);
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeRtcRoom;
            if (j == 0) {
                LogUtil.m216e(TAG, "native rtcroom is invalid, updateToken failed.");
                nativeUpdateRTSToken = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeUpdateRTSToken = NativeRTCRoomFunctions.nativeUpdateRTSToken(j, token);
            }
            return nativeUpdateRTSToken;
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
            return NativeRTCRoomFunctions.nativeSendRTSUserMessage(j, uid, message, config.value());
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
            return NativeRTCRoomFunctions.nativeSendRTSUserBinaryMessage(j, uid, buffer, config.value());
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
            return NativeRTCRoomFunctions.nativeSendRTSRoomMessage(j, message);
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
            return NativeRTCRoomFunctions.nativeSendRTSRoomBinaryMessage(j, buffer);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTSRoom
    public void destroy() {
        LogUtil.m215d(TAG, "Destroy ");
        this.mJniWriteLock.lock();
        try {
            long j = this.mNativeRtcRoom;
            if (j == 0) {
                LogUtil.m216e(TAG, "native rtcroom is invalid, Destroy failed.");
                return;
            }
            this.mNativeRtcRoom = 0L;
            this.mJniWriteLock.unlock();
            NativeRTCRoomFunctions.nativeDestroyRTSRoom(j);
            long j2 = this.mNativeRtcRoomEventHandlerRts;
            if (j2 != 0) {
                NativeRTCRoomFunctions.nativeReleaseRTCRoomEventHandlerRts(j2);
                this.mNativeRtcRoomEventHandlerRts = 0L;
            }
        } finally {
            this.mJniWriteLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTSRoom
    public int setRTSRoomEventHandler(IRTSRoomEventHandler rtcRoomEventHandler) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeRtcRoom == 0) {
                LogUtil.m216e(TAG, "native room is invalid, setRTCRoomEventHandler failed.");
                return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            }
            this.mRtcRoomHandlerRts = rtcRoomEventHandler;
            RTCRoomEventHandlerRts rTCRoomEventHandlerRts = new RTCRoomEventHandlerRts(this);
            this.mRtcRoomEventHandlerRts = rTCRoomEventHandlerRts;
            long j = this.mNativeRtcRoomEventHandlerRts;
            this.mNativeRtcRoomEventHandlerRts = NativeRTCRoomFunctions.nativeSetRTCRoomEventHandlerRts(this.mNativeRtcRoom, rTCRoomEventHandlerRts);
            if (j != 0) {
                NativeRTCRoomFunctions.nativeReleaseRTCRoomEventHandlerRts(j);
            }
            this.mJniReadLock.unlock();
            return 0;
        } finally {
            this.mJniReadLock.unlock();
        }
    }
}
