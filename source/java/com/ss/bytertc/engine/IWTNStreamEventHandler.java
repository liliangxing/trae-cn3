package com.ss.bytertc.engine;

import com.ss.bytertc.engine.data.DataMessageSourceType;
import com.ss.bytertc.engine.data.VideoFrameInfo;
import com.ss.bytertc.engine.data.WTNSubscribeState;
import com.ss.bytertc.engine.data.WTNSubscribeStateChangeReason;
import com.ss.bytertc.engine.type.RemoteAudioStats;
import com.ss.bytertc.engine.type.RemoteVideoStats;
import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public interface IWTNStreamEventHandler {
    void onWTNAudioSubscribeStateChanged(String streamId, WTNSubscribeState stateCode, WTNSubscribeStateChangeReason reason);

    void onWTNDataMessageReceived(String streamId, ByteBuffer message, DataMessageSourceType sourceType);

    void onWTNFirstRemoteAudioFrame(String streamId);

    void onWTNFirstRemoteVideoFrameDecoded(String streamId, VideoFrameInfo info);

    void onWTNRemoteAudioStats(String streamId, RemoteAudioStats stats);

    void onWTNRemoteVideoStats(String streamId, RemoteVideoStats stats);

    void onWTNSEIMessageReceived(String streamId, int channelId, ByteBuffer message);

    void onWTNVideoSubscribeStateChanged(String streamId, WTNSubscribeState stateCode, WTNSubscribeStateChangeReason reason);
}
