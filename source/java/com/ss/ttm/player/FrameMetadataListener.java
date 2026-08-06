package com.ss.ttm.player;

import java.nio.ByteBuffer;
import java.util.Map;

/* loaded from: classes7.dex */
public interface FrameMetadataListener {
    default void didReceivePacket(int streamType, long dts, long pts, Map<Integer, String> packetInfo) {
    }

    void frameDTSNotify(int streamType, long dts, long pts);

    default void onAbrDecisionInfo(long offsetTime, String decisionInfo) {
    }

    void onFrameAboutToBeRendered(int type, long pts, long wallClockTime, Map<Integer, String> frameData);

    default void receiveBinarySei(ByteBuffer buffer) {
    }

    void updateFrameTerminatedDTS(int streamType, long dts, long pts);

    default void willRenderFrame(int streamType, long dts, long pts, String frameInfo) {
    }
}
