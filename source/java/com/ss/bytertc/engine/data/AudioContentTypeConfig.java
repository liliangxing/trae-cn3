package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public class AudioContentTypeConfig {
    public boolean hasMediaPlayer;
    public boolean hasMic;
    public boolean hasScreenAudio;

    public AudioContentTypeConfig() {
        this.hasMic = false;
        this.hasScreenAudio = false;
        this.hasMediaPlayer = false;
    }

    public AudioContentTypeConfig(boolean hasMic, boolean hasScreenAudio, boolean hasMediaPlayer) {
        this.hasMic = hasMic;
        this.hasScreenAudio = hasScreenAudio;
        this.hasMediaPlayer = hasMediaPlayer;
    }

    public String toString() {
        return "AudioContentTypeConfig{hasMic='" + this.hasMic + "', hasScreenAudio='" + this.hasScreenAudio + "', hasMediaPlayer='" + this.hasMediaPlayer + "'}";
    }
}
