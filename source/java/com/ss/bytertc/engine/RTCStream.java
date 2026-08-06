package com.ss.bytertc.engine;

import com.ss.bytertc.engine.data.StreamIndex;
import java.util.Arrays;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes7.dex */
public class RTCStream {
    public boolean hasAudio;
    public boolean hasVideo;
    public boolean isScreen;
    public StreamIndex streamIndex;
    public String userId;
    public List<VideoStreamDescription> videoStreamDescriptions;

    public RTCStream() {
    }

    public RTCStream(String userId, StreamIndex streamIndex, boolean isScreen, boolean hasVideo, boolean hasAudio, List<VideoStreamDescription> videoStreamDescriptions) {
        this.userId = userId;
        this.streamIndex = streamIndex;
        this.isScreen = isScreen;
        this.hasVideo = hasVideo;
        this.hasAudio = hasAudio;
        this.videoStreamDescriptions = videoStreamDescriptions;
    }

    public String toString() {
        return "RTCStream{ userId='" + this.userId + "', isScreen=" + this.isScreen + ", hasVideo=" + this.hasVideo + ", hasAudio=" + this.hasAudio + ", videoStreamDescriptions=" + this.videoStreamDescriptions + AbstractJsonLexerKt.END_OBJ;
    }

    private static RTCStream create(String userId, StreamIndex streamIndex, boolean isScreen, boolean hasVideo, boolean hasAudio) {
        return new RTCStream(userId, streamIndex, isScreen, hasVideo, hasAudio, null);
    }

    private static RTCStream createWithStreamDescriptions(String userId, StreamIndex streamIndex, boolean isScreen, boolean hasVideo, boolean hasAudio, VideoStreamDescription[] videoStreamDescriptions) {
        return new RTCStream(userId, streamIndex, isScreen, hasVideo, hasAudio, Arrays.asList(videoStreamDescriptions));
    }
}
