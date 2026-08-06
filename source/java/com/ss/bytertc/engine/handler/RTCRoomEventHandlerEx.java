package com.ss.bytertc.engine.handler;

import com.ss.bytertc.engine.RTCRoomImpl;
import com.ss.bytertc.engine.SubscribeConfig;
import com.ss.bytertc.engine.data.AVSyncEvent;
import com.ss.bytertc.engine.data.RemoteStreamKey;
import com.ss.bytertc.engine.data.StreamIndex;
import com.ss.bytertc.engine.data.StreamKey;
import com.ss.bytertc.engine.type.MediaStreamType;
import com.ss.bytertc.engine.type.StreamRemoveReason;
import com.ss.bytertc.engine.utils.LogUtil;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class RTCRoomEventHandlerEx {
    private static final String TAG = "RtcRoomEventHandlerEx";
    private RTCRoomImpl mRtcRoom;

    public RTCRoomEventHandlerEx(RTCRoomImpl roomImpl) {
        this.mRtcRoom = roomImpl;
    }

    public void onUserPublishStream(RemoteStreamKey stream_key, boolean is_screen, int type) {
        LogUtil.m215d(TAG, "onUserPublishStream streamIndex: " + stream_key.getStreamIndex());
        try {
            IRTCRoomEventHandlerEx rtcRoomHandlerEx = this.mRtcRoom.getRtcRoomHandlerEx();
            if (rtcRoomHandlerEx != null) {
                rtcRoomHandlerEx.onUserPublishStream(stream_key, is_screen, MediaStreamType.valueOf(type));
            }
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onUserPublishStream callback catch exception.\n" + e.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0033 A[Catch: Exception -> 0x0023, TRY_LEAVE, TryCatch #0 {Exception -> 0x0023, blocks: (B:16:0x001a, B:4:0x002b, B:6:0x0033, B:3:0x0025), top: B:15:0x001a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onUserUnpublishStream(RemoteStreamKey stream_key, int type, int reason) {
        IRTCRoomEventHandlerEx rtcRoomHandlerEx;
        LogUtil.m215d(TAG, "onUserUnpublishStream streamIndex: " + stream_key.getStreamIndex());
        if (reason >= 0) {
            try {
                if (reason > StreamRemoveReason.STREAM_REMOVE_REASON_PUBLISH_PRIVILEGE_TOKEN_EXPIRED.value()) {
                }
                rtcRoomHandlerEx = this.mRtcRoom.getRtcRoomHandlerEx();
                if (rtcRoomHandlerEx == null) {
                    rtcRoomHandlerEx.onUserUnpublishStream(stream_key, MediaStreamType.valueOf(type), StreamRemoveReason.values()[reason]);
                    return;
                }
                return;
            } catch (Exception e) {
                LogUtil.m215d(TAG, "onUserUnpublishStream callback catch exception.\n" + e.getMessage());
                return;
            }
        }
        LogUtil.m215d(TAG, "onUserUnpublishStream callback reason invalid.\n");
        reason = 0;
        rtcRoomHandlerEx = this.mRtcRoom.getRtcRoomHandlerEx();
        if (rtcRoomHandlerEx == null) {
        }
    }

    public void onStreamStateChanged(StreamKey stream_key, int state, String extra_info) {
        LogUtil.m215d(TAG, "onStreamStateChanged streamIndex: " + stream_key.getStreamIndex());
        try {
            IRTCRoomEventHandlerEx rtcRoomHandlerEx = this.mRtcRoom.getRtcRoomHandlerEx();
            if (rtcRoomHandlerEx != null) {
                rtcRoomHandlerEx.onStreamStateChanged(stream_key, state, extra_info);
            }
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onStreamStateChanged callback catch exception.\n" + e.getMessage());
        }
    }

    public void onStreamPublishSuccess(String uid, StreamIndex streamIndex, boolean isScreen) {
        LogUtil.m215d(TAG, "onStreamPublishSuccess...");
        try {
            IRTCRoomEventHandlerEx rtcRoomHandlerEx = this.mRtcRoom.getRtcRoomHandlerEx();
            if (rtcRoomHandlerEx != null) {
                rtcRoomHandlerEx.onStreamPublishSuccess(uid, streamIndex, isScreen);
            }
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onStreamPublishSuccess callback catch exception.\n" + e.getMessage());
        }
    }

    public void onAVSyncEvent(StreamKey key, AVSyncEvent eventCode) {
        LogUtil.m215d(TAG, "onAVSyncEvent...");
        try {
            IRTCRoomEventHandlerEx rtcRoomHandlerEx = this.mRtcRoom.getRtcRoomHandlerEx();
            if (rtcRoomHandlerEx != null) {
                rtcRoomHandlerEx.onAVSyncEvent(key, eventCode);
            }
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onAVSyncEvent callback catch exception.\n" + e.getMessage());
        }
    }

    public void onStreamSubscribed(int stateCode, String userId, StreamIndex streamIndex, SubscribeConfig info) {
        LogUtil.m215d(TAG, "onStreamSubscribed...");
        try {
            IRTCRoomEventHandlerEx rtcRoomHandlerEx = this.mRtcRoom.getRtcRoomHandlerEx();
            if (rtcRoomHandlerEx != null) {
                rtcRoomHandlerEx.onStreamSubscribed(stateCode, userId, streamIndex, info);
            }
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onStreamSubscribed callback catch exception.\n" + e.getMessage());
        }
    }
}
