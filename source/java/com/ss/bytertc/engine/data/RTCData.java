package com.ss.bytertc.engine.data;

import android.util.Pair;
import com.ss.bytertc.engine.VideoStreamDescription;
import com.ss.bytertc.engine.utils.LogUtil;
import com.ss.bytertc.engine.video.VideoEncoderConfiguration;
import com.ss.ttm.player.MediaPlayer;
import java.util.Arrays;

/* loaded from: classes7.dex */
public class RTCData {
    private static final String TAG = "RTCData";
    private VideoEncoderConfiguration.OrientationMode mOrientationMode;
    private VideoStreamDescription[] videoStreamDescriptions = new VideoStreamDescription[1];

    /* loaded from: classes7.dex */
    private static class SingletonHelper {
        private static final RTCData INSTANCE = new RTCData();

        private SingletonHelper() {
        }
    }

    public static RTCData instance() {
        return SingletonHelper.INSTANCE;
    }

    public RTCData() {
        VideoStreamDescription videoStreamDescription = new VideoStreamDescription();
        videoStreamDescription.videoSize = new Pair<>(640, Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL));
        videoStreamDescription.frameRate = 20;
        videoStreamDescription.maxKbps = 600;
        this.videoStreamDescriptions[0] = videoStreamDescription;
        this.mOrientationMode = VideoEncoderConfiguration.OrientationMode.ORIENTATION_MODE_ADAPTIVE;
    }

    public void setVideoStreamDescriptions(VideoStreamDescription[] videoStreamDescriptions) {
        LogUtil.i(TAG, "setVideoStreamDescriptions: " + Arrays.toString(videoStreamDescriptions));
        this.videoStreamDescriptions = videoStreamDescriptions;
    }

    public void setOrientationMode(VideoEncoderConfiguration.OrientationMode orientationMode) {
        this.mOrientationMode = orientationMode;
    }

    public VideoEncoderConfiguration.OrientationMode getOrientationMode() {
        return this.mOrientationMode;
    }

    public VideoStreamDescription[] getVideoStreamDescriptions() {
        return this.videoStreamDescriptions;
    }
}
