package com.ss.bytertc.engine.handler;

import com.ss.bytertc.engine.RTCRoomImpl;
import com.ss.bytertc.engine.UserInfo;
import com.ss.bytertc.engine.aigc.IRTCRoomEventHandlerAIGC;
import com.ss.bytertc.engine.aigc.StartSessionResult;
import com.ss.bytertc.engine.utils.LogUtil;
import java.nio.ByteBuffer;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class RTCRoomEventHandlerAIGC {
    private static final String TAG = "RTCRoomEventHandlerAIGC";
    private RTCRoomImpl mRtcRoom;

    public RTCRoomEventHandlerAIGC(RTCRoomImpl roomImpl) {
        this.mRtcRoom = roomImpl;
    }

    public static ByteBuffer allocateDirectByteBuffer(int capacity) {
        return ByteBuffer.allocateDirect(capacity);
    }

    public void onStartSessionResult(StartSessionResult result, UserInfo user_info, ByteBuffer message) {
        LogUtil.m215d(TAG, "onStartSessionResult result: " + result + ", uid: " + user_info.getUid() + ", extraInfo: " + user_info.getExtraInfo());
        try {
            IRTCRoomEventHandlerAIGC rtcRoomHandlerAIGC = this.mRtcRoom.getRtcRoomHandlerAIGC();
            if (rtcRoomHandlerAIGC != null) {
                rtcRoomHandlerAIGC.onStartSessionResult(result, user_info, message);
            }
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onStartSessionResult callback catch exception.\n" + e.getMessage());
        }
    }

    public void onStartSessionResultWithErrorCode(StartSessionResult result, int error_code, UserInfo user_info, ByteBuffer message) {
        LogUtil.m215d(TAG, "onStartSessionResultWithErrorCode result: " + result + ", error_code: " + error_code + ", uid: " + user_info.getUid() + ", extraInfo: " + user_info.getExtraInfo());
        try {
            IRTCRoomEventHandlerAIGC rtcRoomHandlerAIGC = this.mRtcRoom.getRtcRoomHandlerAIGC();
            if (rtcRoomHandlerAIGC != null) {
                rtcRoomHandlerAIGC.onStartSessionResultWithErrorCode(result, error_code, user_info, message);
            }
        } catch (Exception e) {
            LogUtil.m215d(TAG, "onStartSessionResultWithErrorCode callback catch exception.\n" + e.getMessage());
        }
    }
}
