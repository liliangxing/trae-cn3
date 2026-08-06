package com.ss.bytertc.engine.live;

/* loaded from: classes7.dex */
public enum MixedStreamAudioProfile {
    MIXED_STREAM_AUDIO_PROFILE_LC("LC"),
    MIXED_STREAM_AUDIO_PROFILE_HEV1("HEv1"),
    MIXED_STREAM_AUDIO_PROFILE_HEV2("HEv2");

    private String aacProfile;

    MixedStreamAudioProfile(String value) {
        this.aacProfile = value;
    }

    public String getValue() {
        return this.aacProfile;
    }
}
