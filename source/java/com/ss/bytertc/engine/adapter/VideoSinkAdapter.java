package com.ss.bytertc.engine.adapter;

import com.ss.bytertc.engine.video.IVideoFrame;
import com.ss.bytertc.engine.video.IVideoSink;

/* loaded from: classes7.dex */
public class VideoSinkAdapter implements IVideoSink {
    private IVideoSink mSink;

    public void release() {
    }

    public VideoSinkAdapter(final IVideoSink sink) {
        this.mSink = sink;
    }

    @Override // com.ss.bytertc.engine.video.IVideoSink
    public void onFrame(IVideoFrame frame) {
        IVideoSink iVideoSink = this.mSink;
        if (iVideoSink != null) {
            iVideoSink.onFrame(frame);
        }
    }

    @Override // com.ss.bytertc.engine.video.IVideoSink
    public int getRenderElapse() {
        IVideoSink iVideoSink = this.mSink;
        if (iVideoSink != null) {
            return iVideoSink.getRenderElapse();
        }
        return 0;
    }
}
