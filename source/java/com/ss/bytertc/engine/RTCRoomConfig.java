package com.ss.bytertc.engine;

import com.ss.bytertc.engine.type.RoomProfile;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes7.dex */
public class RTCRoomConfig {
    public int cacheAudioDataMs;
    public boolean isAutoSubscribeAudio;
    public boolean isAutoSubscribeVideo;
    public boolean isCacheAudioData;
    public boolean isPublishAudio;
    public boolean isPublishVideo;
    public RoomProfile profile;

    public RTCRoomConfig(RoomProfile channelProfile, boolean isPublishAudio, boolean isPublishVideo, boolean isAutoSubscribeAudio, boolean isAutoSubscribeVideo, boolean isCacheAudioData, int cacheAudioDataMs) {
        this.profile = channelProfile;
        this.isPublishAudio = isPublishAudio;
        this.isPublishVideo = isPublishVideo;
        this.isAutoSubscribeAudio = isAutoSubscribeAudio;
        this.isAutoSubscribeVideo = isAutoSubscribeVideo;
        this.isCacheAudioData = isCacheAudioData;
        this.cacheAudioDataMs = cacheAudioDataMs;
    }

    public int getProfile() {
        switch (this.profile) {
            case CLOUD_GAME:
                return 3;
            case GAME:
                return 2;
            case LOW_LATENCY:
                return 4;
            case CHAT_ROOM:
                return 6;
            case INTERACTIVE_PODCAST:
                return 10;
            case CHORUS:
                return 12;
            case GAME_STREAMING:
                return 14;
            case MEETING:
                return 16;
            case MEETING_ROOM:
                return 17;
            case CLASSROOM:
                return 18;
            case CALL:
                return 19;
            case LIVE:
                return 20;
            default:
                return 0;
        }
    }

    public boolean isPublishVideo() {
        return this.isPublishVideo;
    }

    public boolean isPublishAudio() {
        return this.isPublishAudio;
    }

    public boolean isAutoSubscribeAudio() {
        return this.isAutoSubscribeAudio;
    }

    public boolean isAutoSubscribeVideo() {
        return this.isAutoSubscribeVideo;
    }

    public boolean isCacheAudioData() {
        return this.isCacheAudioData;
    }

    public int getCacheAudioDataMs() {
        return this.cacheAudioDataMs;
    }

    public String toString() {
        return "RTCRoomConfig{profile=" + this.profile + ", isPublishAudio=" + this.isPublishAudio + ", isPublishVideo=" + this.isPublishVideo + ", isAutoSubscribeAudio=" + this.isAutoSubscribeAudio + ", isAutoSubscribeVideo=" + this.isAutoSubscribeVideo + ", isCacheAudioData=" + this.isCacheAudioData + ", cacheAudioDataMs=" + this.cacheAudioDataMs + AbstractJsonLexerKt.END_OBJ;
    }
}
