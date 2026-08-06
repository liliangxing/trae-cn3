package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public class MediaPlayerConfig {
    public boolean autoPlay;
    public long callbackOnProgressInterval;
    public int playCount;
    public int startPos;
    public boolean syncProgressToRecordFrame;
    public AudioMixingType type;

    public MediaPlayerConfig() {
        this.type = AudioMixingType.AUDIO_MIXING_TYPE_PLAYOUT_AND_PUBLISH;
        this.playCount = 1;
        this.startPos = 0;
        this.callbackOnProgressInterval = 0L;
        this.syncProgressToRecordFrame = false;
        this.autoPlay = true;
    }

    public MediaPlayerConfig(AudioMixingType type, int playCount) {
        this(type, playCount, 0, true, 0L, false);
    }

    public MediaPlayerConfig(AudioMixingType type, int playCount, int startPos, boolean autoPlay, long progressInterval, boolean syncProgressToRecordFrame) {
        AudioMixingType audioMixingType = AudioMixingType.AUDIO_MIXING_TYPE_PLAYOUT_AND_PUBLISH;
        this.type = type;
        this.playCount = playCount;
        this.startPos = startPos;
        this.autoPlay = autoPlay;
        this.syncProgressToRecordFrame = syncProgressToRecordFrame;
        this.callbackOnProgressInterval = progressInterval;
    }

    public String toString() {
        return "MediaPlayerConfig{type='" + this.type + "', playCount='" + this.playCount + "', startPos='" + this.startPos + "', autoPlay='" + this.autoPlay + "', syncProgressToRecordFrame='" + this.syncProgressToRecordFrame + "', callbackOnProgressInterval='" + this.callbackOnProgressInterval + "'}";
    }
}
