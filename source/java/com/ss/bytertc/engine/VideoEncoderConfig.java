package com.ss.bytertc.engine;

import com.lynx.canvas.camera.CameraSize;
import com.ss.ttm.player.MediaPlayer;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes7.dex */
public class VideoEncoderConfig {
    public EncoderPreference encodePreference;
    public int frameRate;
    public int height;
    public int maxBitrate;
    public int minBitrate;
    public int width;
    public static final VideoDimensions VD_120x120 = new VideoDimensions(120, 120);
    public static final VideoDimensions VD_160x120 = new VideoDimensions(160, 120);
    public static final VideoDimensions VD_180x180 = new VideoDimensions(180, 180);
    public static final VideoDimensions VD_240x180 = new VideoDimensions(240, 180);
    public static final VideoDimensions VD_320x180 = new VideoDimensions(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME, 180);
    public static final VideoDimensions VD_240x240 = new VideoDimensions(240, 240);
    public static final VideoDimensions VD_320x240 = new VideoDimensions(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME, 240);
    public static final VideoDimensions VD_424x240 = new VideoDimensions(424, 240);
    public static final VideoDimensions VD_360x360 = new VideoDimensions(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL);
    public static final VideoDimensions VD_480x360 = new VideoDimensions(480, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL);
    public static final VideoDimensions VD_640x360 = new VideoDimensions(640, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL);
    public static final VideoDimensions VD_480x480 = new VideoDimensions(480, 480);
    public static final VideoDimensions VD_640x480 = new VideoDimensions(640, 480);
    public static final VideoDimensions VD_840x480 = new VideoDimensions(MediaPlayer.MEDIA_PLAYER_OPTION_RTM_DATA_ICE_CONNECT_START_TIME, 480);
    public static final VideoDimensions VD_960x540 = new VideoDimensions(MediaPlayer.MEDIA_PLAYER_OPTION_SET_SESSIONID, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HW_ERR_REASON);
    public static final VideoDimensions VD_960x720 = new VideoDimensions(MediaPlayer.MEDIA_PLAYER_OPTION_SET_SESSIONID, 720);
    public static final VideoDimensions VD_1280x720 = new VideoDimensions(CameraSize.highHeight, 720);
    public static final VideoDimensions VD_1920x1080 = new VideoDimensions(1920, 1080);
    public static final VideoDimensions VD_2540x1440 = new VideoDimensions(2540, 1440);
    public static final VideoDimensions VD_3840x2160 = new VideoDimensions(3840, 2160);

    public boolean isValid() {
        return true;
    }

    /* loaded from: classes7.dex */
    public enum CodecMode {
        CODEC_MODE_AUTO(0),
        CODEC_MODE_HARDWARE(1),
        CODEC_MODE_SOFTWARE(2);

        private int value;

        CodecMode(int v) {
            this.value = v;
        }

        public static CodecMode convertFromInt(int v) {
            return values()[v];
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: classes7.dex */
    public enum VideoCodecType {
        CODEC_TYPE_AUTO(0),
        CODEC_TYPE_H264(1),
        CODEC_TYPE_BYTEVC1(2);

        private int value;

        VideoCodecType(int v) {
            this.value = v;
        }

        public static VideoCodecType convertFromInt(int v) {
            return values()[v];
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: classes7.dex */
    public enum EncoderPreference {
        DISABLED(0),
        MAINTAIN_FRAMERATE(1),
        MAINTAIN_QUALITY(2),
        AUTO(3);

        private int value;

        EncoderPreference(int v) {
            this.value = v;
        }

        public static EncoderPreference convertFromInt(int v) {
            return values()[v];
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: classes7.dex */
    public static class VideoDimensions {
        public int height;
        public int width;

        public VideoDimensions(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public VideoDimensions() {
            this.width = 0;
            this.height = 0;
        }
    }

    /* loaded from: classes7.dex */
    public enum FrameRate {
        FRAME_RATE_FPS_1(1),
        FRAME_RATE_FPS_7(7),
        FRAME_RATE_FPS_10(10),
        FRAME_RATE_FPS_15(15),
        FRAME_RATE_FPS_24(24),
        FRAME_RATE_FPS_30(30),
        FRAME_RATE_FPS_60(60);

        private int value;

        FrameRate(int v) {
            this.value = v;
        }

        public int getValue() {
            return this.value;
        }
    }

    private static VideoEncoderConfig create(int width, int height, int frameRate, int maxBitrate, int minBitrate) {
        return new VideoEncoderConfig(width, height, frameRate, maxBitrate, minBitrate);
    }

    public VideoEncoderConfig() {
        this.maxBitrate = -1;
        this.minBitrate = 0;
        this.encodePreference = EncoderPreference.MAINTAIN_FRAMERATE;
    }

    public VideoEncoderConfig(int width, int height, int frameRate, int maxBitrate, int minBitrate) {
        this.maxBitrate = -1;
        this.minBitrate = 0;
        this.encodePreference = EncoderPreference.MAINTAIN_FRAMERATE;
        this.width = width;
        this.height = height;
        this.frameRate = frameRate;
        this.maxBitrate = maxBitrate;
        this.minBitrate = minBitrate;
    }

    public VideoEncoderConfig(int width, int height, int frameRate, int maxBitrate, int minBitrate, int codecName, int codecMode, int encodePrefer) {
        this.maxBitrate = -1;
        this.minBitrate = 0;
        this.encodePreference = EncoderPreference.MAINTAIN_FRAMERATE;
        this.width = width;
        this.height = height;
        this.frameRate = frameRate;
        this.maxBitrate = maxBitrate;
        this.minBitrate = minBitrate;
        this.encodePreference = EncoderPreference.convertFromInt(encodePrefer);
    }

    public String toString() {
        return "VideoEncoderConfig{width=" + this.width + "height=" + this.height + ", frameRate=" + this.frameRate + ", maxBitrate=" + this.maxBitrate + ", minBitrate=" + this.minBitrate + ", encodePreference=" + this.encodePreference + AbstractJsonLexerKt.END_OBJ;
    }
}
