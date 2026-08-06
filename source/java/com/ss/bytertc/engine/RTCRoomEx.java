package com.ss.bytertc.engine;

import com.ss.bytertc.engine.data.RemoteVideoConfig;
import com.ss.bytertc.engine.data.StreamIndex;
import com.ss.bytertc.engine.handler.IRTCRoomEventHandlerEx;
import com.ss.bytertc.engine.type.MediaStreamType;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class RTCRoomEx extends RTCRoom {
    public abstract int publishStream(StreamIndex streamIndex, MediaStreamType type);

    public abstract int setRTCRoomEventHandlerEx(IRTCRoomEventHandlerEx roomEventHandler);

    public abstract int setRemoteVideoConfig(String userId, StreamIndex streamIndex, RemoteVideoConfig remoteVideoConfig);

    public abstract int subscribeStream(String userId, StreamIndex streamIndex, MediaStreamType type);

    public abstract int unpublishStream(StreamIndex streamIndex, MediaStreamType type);

    public abstract int unsubscribeStream(String userId, StreamIndex streamIndex, MediaStreamType type);
}
