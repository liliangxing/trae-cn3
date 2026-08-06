package com.ss.bytertc.engine.video;

import com.ss.bytertc.engine.data.StreamIndex;

/* loaded from: classes7.dex */
public abstract class IVideoProcessor {
    public abstract IVideoFrame processVideoFrame(StreamIndex stream_index, IVideoFrame frame);
}
