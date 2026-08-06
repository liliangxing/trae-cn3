package com.ss.bytertc.engine.live;

import com.ss.bytertc.engine.data.HumanOrientation;
import com.ss.bytertc.engine.data.Position;

/* loaded from: classes7.dex */
public class MixedStreamSpatialAudioConfig {
    public boolean enableSpatialRender = false;
    public Position audienceSpatialPosition = new Position();
    public HumanOrientation audienceSpatialOrientation = new HumanOrientation();

    public MixedStreamSpatialAudioConfig setAudienceSpatialPosition(float x, float y, float z) {
        this.audienceSpatialPosition.x = x;
        this.audienceSpatialPosition.y = y;
        this.audienceSpatialPosition.z = z;
        return this;
    }
}
