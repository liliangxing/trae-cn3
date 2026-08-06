package com.ss.bytertc.engine.handler;

import com.ss.bytertc.engine.InternalRTCStats;
import com.ss.bytertc.engine.RTSRoomImpl;
import com.ss.bytertc.engine.UserInfo;
import com.ss.bytertc.engine.type.RTCRoomStats;
import com.ss.bytertc.engine.utils.LogUtil;
import java.nio.ByteBuffer;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class RTCRoomEventHandlerRts {
    private static final String TAG = "RtcRoomEventHandlerRts";
    private RTSRoomImpl mRtcRoom;

    public RTCRoomEventHandlerRts(RTSRoomImpl roomImpl) {
        this.mRtcRoom = roomImpl;
    }

    public static ByteBuffer allocateDirectByteBuffer(int capacity) {
        return ByteBuffer.allocateDirect(capacity);
    }

    public void onRoomMessageReceived(String uid, String message, long msgid) {
        IRTSRoomEventHandler rtcRoomHandlerRts;
        LogUtil.m215d(TAG, "onRoomMessageReceived: " + message);
        try {
            RTSRoomImpl rTSRoomImpl = this.mRtcRoom;
            if (rTSRoomImpl == null || (rtcRoomHandlerRts = rTSRoomImpl.getRtcRoomHandlerRts()) == null) {
                return;
            }
            rtcRoomHandlerRts.onRoomMessageReceived(uid, message);
            rtcRoomHandlerRts.onRoomMessageReceived(msgid, uid, message);
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onRoomMessageReceived callback catch exception.\n" + e.getMessage());
        }
    }

    public void onRoomBinaryMessageReceived(String uid, ByteBuffer message, long msgid) {
        IRTSRoomEventHandler rtcRoomHandlerRts;
        LogUtil.m215d(TAG, "onRoomBinaryMessageReceived, length: " + message.capacity());
        try {
            RTSRoomImpl rTSRoomImpl = this.mRtcRoom;
            if (rTSRoomImpl == null || (rtcRoomHandlerRts = rTSRoomImpl.getRtcRoomHandlerRts()) == null) {
                return;
            }
            rtcRoomHandlerRts.onRoomBinaryMessageReceived(uid, message.duplicate());
            rtcRoomHandlerRts.onRoomBinaryMessageReceived(msgid, uid, message);
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onRoomBinaryMessageReceived callback catch exception.\n" + e.getMessage());
        }
    }

    public void onUserMessageReceived(String uid, String message, long msgid) {
        IRTSRoomEventHandler rtcRoomHandlerRts;
        LogUtil.m215d(TAG, "onUserMessageReceived: uid:" + uid + "message" + message);
        try {
            RTSRoomImpl rTSRoomImpl = this.mRtcRoom;
            if (rTSRoomImpl == null || (rtcRoomHandlerRts = rTSRoomImpl.getRtcRoomHandlerRts()) == null) {
                return;
            }
            rtcRoomHandlerRts.onUserMessageReceived(uid, message);
            rtcRoomHandlerRts.onUserMessageReceived(msgid, uid, message);
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onUserMessageReceived callback catch exception.\n" + e.getMessage());
        }
    }

    public void onUserBinaryMessageReceived(String uid, ByteBuffer message, long msgid) {
        IRTSRoomEventHandler rtcRoomHandlerRts;
        LogUtil.m215d(TAG, "onUserBinaryMessageReceived: uid:" + uid + "binary message length" + message.capacity());
        try {
            RTSRoomImpl rTSRoomImpl = this.mRtcRoom;
            if (rTSRoomImpl == null || (rtcRoomHandlerRts = rTSRoomImpl.getRtcRoomHandlerRts()) == null) {
                return;
            }
            rtcRoomHandlerRts.onUserBinaryMessageReceived(uid, message.duplicate());
            rtcRoomHandlerRts.onUserBinaryMessageReceived(msgid, uid, message);
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onUserBinaryMessageReceived callback catch exception.\n" + e.getMessage());
        }
    }

    public void onUserMessageSendResult(long msgid, int error) {
        IRTSRoomEventHandler rtcRoomHandlerRts;
        LogUtil.m215d(TAG, "onUserMessageSendResult...");
        try {
            RTSRoomImpl rTSRoomImpl = this.mRtcRoom;
            if (rTSRoomImpl == null || (rtcRoomHandlerRts = rTSRoomImpl.getRtcRoomHandlerRts()) == null) {
                return;
            }
            rtcRoomHandlerRts.onUserMessageSendResult(msgid, error);
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onUserMessageSendResult callback catch exception.\n" + e.getMessage());
        }
    }

    public void onRoomMessageSendResult(long msgid, int error) {
        IRTSRoomEventHandler rtcRoomHandlerRts;
        LogUtil.m215d(TAG, "onRoomMessageSendResult...");
        try {
            RTSRoomImpl rTSRoomImpl = this.mRtcRoom;
            if (rTSRoomImpl == null || (rtcRoomHandlerRts = rTSRoomImpl.getRtcRoomHandlerRts()) == null) {
                return;
            }
            rtcRoomHandlerRts.onRoomMessageSendResult(msgid, error);
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onRoomMessageSendResult callback catch exception.\n" + e.getMessage());
        }
    }

    public void onRoomStateChanged(String roomId, String uid, int state, String extraInfo) {
        IRTSRoomEventHandler rtcRoomHandlerRts;
        LogUtil.m215d(TAG, "onRoomStateChanged...");
        try {
            RTSRoomImpl rTSRoomImpl = this.mRtcRoom;
            if (rTSRoomImpl == null || (rtcRoomHandlerRts = rTSRoomImpl.getRtcRoomHandlerRts()) == null) {
                return;
            }
            rtcRoomHandlerRts.onRoomStateChanged(roomId, uid, state, extraInfo);
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onRoomStateChanged callback catch exception.\n" + e.getMessage());
        }
    }

    public void onLeaveRoom(InternalRTCStats stats) {
        IRTSRoomEventHandler rtcRoomHandlerRts;
        LogUtil.m215d(TAG, "onLeaveRoom...");
        try {
            RTSRoomImpl rTSRoomImpl = this.mRtcRoom;
            if (rTSRoomImpl == null || (rtcRoomHandlerRts = rTSRoomImpl.getRtcRoomHandlerRts()) == null) {
                return;
            }
            rtcRoomHandlerRts.onLeaveRoom(new RTCRoomStats(stats));
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onLeaveRoom callback catch exception.\n" + e.getMessage());
        }
    }

    public void onUserJoined(UserInfo userInfo) {
        IRTSRoomEventHandler rtcRoomHandlerRts;
        LogUtil.m215d(TAG, "onUserJoined... uid: " + userInfo.getUid() + ", extraInfo: " + userInfo.getExtraInfo());
        try {
            RTSRoomImpl rTSRoomImpl = this.mRtcRoom;
            if (rTSRoomImpl == null || (rtcRoomHandlerRts = rTSRoomImpl.getRtcRoomHandlerRts()) == null) {
                return;
            }
            rtcRoomHandlerRts.onUserJoined(userInfo);
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onUserJoined callback catch exception.\n" + e.getMessage());
        }
    }

    public void onUserLeave(String uid, int reason) {
        IRTSRoomEventHandler rtcRoomHandlerRts;
        LogUtil.m215d(TAG, "onUserLeave... uid: " + uid + ", reason: " + reason);
        try {
            RTSRoomImpl rTSRoomImpl = this.mRtcRoom;
            if (rTSRoomImpl == null || (rtcRoomHandlerRts = rTSRoomImpl.getRtcRoomHandlerRts()) == null) {
                return;
            }
            rtcRoomHandlerRts.onUserLeave(uid, reason);
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onUserLeave callback catch exception.\n" + e.getMessage());
        }
    }
}
