package com.ss.bytertc.engine.handler;

import com.ss.bytertc.engine.UserInfo;
import com.ss.bytertc.engine.type.RTCRoomStats;
import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public abstract class IRTSRoomEventHandler {
    public void onLeaveRoom(RTCRoomStats stats) {
    }

    public void onRoomBinaryMessageReceived(long msgid, String uid, ByteBuffer message) {
    }

    public void onRoomBinaryMessageReceived(String uid, ByteBuffer message) {
    }

    public void onRoomMessageReceived(long msgid, String uid, String message) {
    }

    public void onRoomMessageReceived(String uid, String message) {
    }

    public void onRoomMessageSendResult(long msgid, int error) {
    }

    public void onRoomStateChanged(String roomId, String uid, int state, String extraInfo) {
    }

    public void onUserBinaryMessageReceived(long msgid, String uid, ByteBuffer message) {
    }

    public void onUserBinaryMessageReceived(String uid, ByteBuffer message) {
    }

    public void onUserJoined(UserInfo userInfo) {
    }

    public void onUserLeave(String uid, int reason) {
    }

    public void onUserMessageReceived(long msgid, String uid, String message) {
    }

    public void onUserMessageReceived(String uid, String message) {
    }

    public void onUserMessageSendResult(long msgid, int error) {
    }
}
