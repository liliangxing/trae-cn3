package com.ss.bytertc.engine.audio;

import com.ss.bytertc.engine.data.PositionInfo;

/* loaded from: classes7.dex */
public interface ISpatialAudio {
    void disableRemoteOrientation();

    void enableSpatialAudio(boolean enable);

    int removeAllRemotePosition();

    int removeRemotePosition(String uid);

    int updateRemotePosition(String uid, PositionInfo positionInfo);

    int updateSelfPosition(PositionInfo positionInfo);
}
