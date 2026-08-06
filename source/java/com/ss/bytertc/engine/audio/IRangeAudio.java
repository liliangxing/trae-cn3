package com.ss.bytertc.engine.audio;

import com.ss.bytertc.engine.data.Position;
import com.ss.bytertc.engine.data.ReceiveRange;
import com.ss.bytertc.engine.type.AttenuationType;
import java.util.List;

/* loaded from: classes7.dex */
public interface IRangeAudio {
    void enableRangeAudio(boolean enable);

    int setAttenuationModel(AttenuationType type, float coefficient);

    void setNoAttenuationFlags(List<String> flags);

    int updatePosition(Position pos);

    int updateReceiveRange(ReceiveRange range);
}
