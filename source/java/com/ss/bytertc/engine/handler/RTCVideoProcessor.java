package com.ss.bytertc.engine.handler;

import com.ss.bytertc.engine.data.StreamIndex;
import com.ss.bytertc.engine.video.IVideoFrame;
import com.ss.bytertc.engine.video.IVideoProcessor;

/* loaded from: classes7.dex */
public class RTCVideoProcessor {
    private IVideoProcessor mProc = null;

    public void dispose() {
    }

    public int registerLocalVideoProcessor(final IVideoProcessor processor) {
        synchronized (this) {
            this.mProc = processor;
        }
        return 0;
    }

    IVideoFrame processVideoFrame(int streamIndex, IVideoFrame frame) {
        synchronized (this) {
            IVideoProcessor iVideoProcessor = this.mProc;
            if (iVideoProcessor == null) {
                return null;
            }
            return iVideoProcessor.processVideoFrame(StreamIndex.fromId(streamIndex), frame);
        }
    }
}
