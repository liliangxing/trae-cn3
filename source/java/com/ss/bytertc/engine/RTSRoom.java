package com.ss.bytertc.engine;

import com.ss.bytertc.engine.handler.IRTSRoomEventHandler;
import com.ss.bytertc.engine.type.MessageConfig;

/* loaded from: classes7.dex */
public abstract class RTSRoom {
    public abstract void destroy();

    public abstract int joinRTSRoom(String token, UserInfo userInfo);

    public abstract int leaveRoom();

    public abstract long sendRoomBinaryMessage(byte[] buffer);

    public abstract long sendRoomMessage(String messageStr);

    public abstract long sendUserBinaryMessage(String userId, byte[] buffer, MessageConfig config);

    public abstract long sendUserMessage(String userId, String messageStr, MessageConfig config);

    public abstract int setRTSRoomEventHandler(IRTSRoomEventHandler rtcRoomEventHandler);

    public abstract int updateToken(String token);
}
