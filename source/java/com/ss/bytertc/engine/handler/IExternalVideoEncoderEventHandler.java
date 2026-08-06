package com.ss.bytertc.engine.handler;

import com.ss.bytertc.engine.data.StreamIndex;

/* loaded from: classes7.dex */
public abstract class IExternalVideoEncoderEventHandler {
    public abstract void onActiveVideoLayer(StreamIndex streamIndex, int videoIndex, boolean active);

    public abstract void onRateUpdate(StreamIndex streamIndex, int videoIndex, int fps, int bitrateKbps);

    public abstract void onRequestKeyFrame(StreamIndex streamIndex, int videoIndex);

    public abstract void onStart(StreamIndex index);

    public abstract void onStop(StreamIndex index);
}
