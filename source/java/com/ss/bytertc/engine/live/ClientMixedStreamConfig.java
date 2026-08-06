package com.ss.bytertc.engine.live;

/* loaded from: classes7.dex */
public class ClientMixedStreamConfig {
    public boolean useAudioMixer = true;
    public MixedStreamClientMixVideoFormat videoFormat = MixedStreamClientMixVideoFormat.MIXED_STREAM_CLIENT_MIX_VIDEO_FORMAT_YUV_I420;

    public boolean getClientMixedStreamConfigUseAudioMixer() {
        return this.useAudioMixer;
    }

    public int getClientMixedStreamConfigVideoFormat() {
        return this.videoFormat.getValue();
    }
}
