package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public class RemoteAudioPropertiesInfo {
    public AudioPropertiesInfo audioPropertiesInfo;
    public RemoteStreamKey streamKey;

    public RemoteAudioPropertiesInfo(RemoteStreamKey streamKey, AudioPropertiesInfo audioPropertiesInfo) {
        this.streamKey = streamKey;
        this.audioPropertiesInfo = audioPropertiesInfo;
    }

    public String toString() {
        return "RemoteAudioPropertiesInfo{user_id='" + this.streamKey.getUserId() + "'room_id='" + this.streamKey.getUserId() + "'stream_index='" + this.streamKey.getStreamIndex() + "'audioPropertiesInfo ['linear_volume='" + this.audioPropertiesInfo.linearVolume + "'nonlinear_volume='" + this.audioPropertiesInfo.nonlinearVolume + "']}";
    }

    private static RemoteAudioPropertiesInfo create(String roomId, String userId, int streamIndex, int linearVolume, int nonlinearVolume, float[] spectrum, int vad) {
        return new RemoteAudioPropertiesInfo(new RemoteStreamKey(roomId, userId, StreamIndex.fromId(streamIndex)), new AudioPropertiesInfo(linearVolume, nonlinearVolume, spectrum, vad));
    }
}
