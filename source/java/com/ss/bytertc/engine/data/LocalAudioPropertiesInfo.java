package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public class LocalAudioPropertiesInfo {
    public AudioPropertiesInfo audioPropertiesInfo;
    public StreamIndex streamIndex;

    public LocalAudioPropertiesInfo(StreamIndex streamIndex, AudioPropertiesInfo audioPropertiesInfo) {
        this.streamIndex = streamIndex;
        this.audioPropertiesInfo = audioPropertiesInfo;
    }

    public String toString() {
        return "LocalAudioPropertiesInfo{streamIndex='" + this.streamIndex + "'audioPropertiesInfo='" + this.audioPropertiesInfo.toString() + "'}";
    }

    private static LocalAudioPropertiesInfo create(int streamIndex, int linearVolume, int nonlinearVolume, float[] spectrum, int vad, double voicePitch) {
        AudioPropertiesInfo audioPropertiesInfo = new AudioPropertiesInfo(linearVolume, nonlinearVolume, spectrum, vad);
        audioPropertiesInfo.voicePitch = voicePitch;
        return new LocalAudioPropertiesInfo(StreamIndex.fromId(streamIndex), audioPropertiesInfo);
    }
}
