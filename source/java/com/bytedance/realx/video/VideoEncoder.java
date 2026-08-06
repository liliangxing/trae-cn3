package com.bytedance.realx.video;

import com.bytedance.realx.video.EglBase;
import com.bytedance.realx.video.EglBase14;
import com.bytedance.realx.video.memory.RXVideoFrameInterface;

/* loaded from: classes4.dex */
public interface VideoEncoder {

    /* loaded from: classes4.dex */
    public interface Callback {
        void onEncodedEvent(EncodeEvent event);

        void onEncodedFrame(EncodedImage frame, CodecSpecificInfo info);
    }

    VideoCodecStatus encode(RXVideoFrameInterface frame, boolean keyFrameRequested);

    VideoCodecStatus initEncode(Settings settings, Callback encodeCallback);

    VideoCodecStatus release();

    VideoCodecStatus requestKeyFrame();

    VideoCodecStatus setPrivateParam(String key, String value);

    VideoCodecStatus setRateAllocation(int bitrateBitps, int framerateFps);

    /* loaded from: classes4.dex */
    public enum ScaleMode {
        AUTO(0),
        STRETCH(1),
        FIT_WITH_CROPPING(2),
        FIT_WITH_FILLING(3);

        private int value;

        ScaleMode(int value) {
            this.value = value;
        }

        static ScaleMode fromValue(int value) {
            if (value == 0) {
                return AUTO;
            }
            if (value == 1) {
                return STRETCH;
            }
            if (value == 2) {
                return FIT_WITH_CROPPING;
            }
            if (value == 3) {
                return FIT_WITH_FILLING;
            }
            return AUTO;
        }
    }

    /* loaded from: classes4.dex */
    public enum BitrateMode {
        AUTO(0),
        VBR(1),
        CBR(2);

        private int value;

        BitrateMode(int value) {
            this.value = value;
        }

        static BitrateMode fromValue(int value) {
            if (value == 0) {
                return AUTO;
            }
            if (value == 1) {
                return VBR;
            }
            if (value == 2) {
                return CBR;
            }
            return AUTO;
        }
    }

    /* loaded from: classes4.dex */
    public enum EncodeMode {
        COMMON(0),
        CLOUD_GAME(1),
        CONFERENCE(2),
        LIVE(3);

        private int value;

        EncodeMode(int value) {
            this.value = value;
        }

        static EncodeMode fromValue(int value) {
            if (value == 1) {
                return CLOUD_GAME;
            }
            if (value == 2) {
                return CONFERENCE;
            }
            if (value == 3) {
                return LIVE;
            }
            return COMMON;
        }
    }

    /* loaded from: classes4.dex */
    public enum EncodeEvent {
        UNKNOWN(0),
        RESET(1);

        private int value;

        EncodeEvent(int value) {
            this.value = value;
        }

        public int getEventValue() {
            return this.value;
        }

        static EncodeEvent fromValue(int value) {
            if (value == 1) {
                return RESET;
            }
            return UNKNOWN;
        }
    }

    /* loaded from: classes4.dex */
    public static class Settings {
        public final int bFrameNum;
        public final BitrateMode bitrateMode;
        public final boolean closeSetProfile;
        public final boolean enableAlignment;
        public final boolean enableAsyncMode;
        public final boolean enableQpSetting;
        public final EncodeMode encodeMode;
        public final int height;
        public final boolean isStatisticsEnabled;
        public final int matrixId;
        public final int maxIQp;
        public final int maxQp;
        public final int minIQp;
        public final int minQp;
        public final int primaryId;
        public final int rangeId;
        public final ScaleMode scaleMode;
        public final EglBase14.Context sharedContext;
        public int targetBps;
        public final int targetFps;
        public final int targetKeyFrameIntervalMs;
        public final int temporalLayerNum;
        public final int transferId;
        public final boolean useSurfaceMode;
        public final int width;

        public Settings(int width, int height, int scaleModeValue, int targetBps, int targetFps, int primaryId, int transferId, int matrixId, int rangeId, int maxQp, int minQp, int maxIQp, int minIQp, boolean enableQpSetting, int temporalLayerNum, int bitrateModeValue, int targetKeyFrameIntervalMs, boolean closeSetProfile, boolean useSurfaceMode, boolean enableAlignment, int encodeMode, int bFrameNum, EglBase.Context sharedContext, boolean enableAsyncMode, boolean isStatisticsEnabled) {
            this.width = width;
            this.height = height;
            this.scaleMode = ScaleMode.fromValue(scaleModeValue);
            this.targetBps = targetBps;
            this.targetFps = targetFps;
            this.primaryId = primaryId;
            this.transferId = transferId;
            this.matrixId = matrixId;
            this.rangeId = rangeId;
            this.maxQp = maxQp;
            this.minQp = minQp;
            this.temporalLayerNum = temporalLayerNum;
            this.bitrateMode = BitrateMode.fromValue(bitrateModeValue);
            this.targetKeyFrameIntervalMs = targetKeyFrameIntervalMs;
            this.closeSetProfile = closeSetProfile;
            this.useSurfaceMode = useSurfaceMode;
            this.enableAlignment = enableAlignment;
            this.maxIQp = maxIQp;
            this.minIQp = minIQp;
            this.bFrameNum = bFrameNum;
            this.enableQpSetting = enableQpSetting;
            this.encodeMode = EncodeMode.fromValue(encodeMode);
            if (sharedContext instanceof EglBase14.Context) {
                this.sharedContext = (EglBase14.Context) sharedContext;
            } else {
                this.sharedContext = null;
            }
            this.enableAsyncMode = enableAsyncMode;
            this.isStatisticsEnabled = isStatisticsEnabled;
        }
    }

    /* loaded from: classes4.dex */
    public static class CodecSpecificInfo {
        public RXVideoCodecStandard codec_standard;

        public CodecSpecificInfo(RXVideoCodecStandard standard) {
            this.codec_standard = standard;
        }
    }

    /* loaded from: classes4.dex */
    public static class ScalingSettings {
        public static final ScalingSettings OFF = new ScalingSettings();
        public final Integer high;
        public final Integer low;
        public final boolean on;

        public ScalingSettings(int low, int high) {
            this.on = true;
            this.low = Integer.valueOf(low);
            this.high = Integer.valueOf(high);
        }

        private ScalingSettings() {
            this.on = false;
            this.low = null;
            this.high = null;
        }

        @Deprecated
        public ScalingSettings(boolean on) {
            this.on = on;
            this.low = null;
            this.high = null;
        }

        @Deprecated
        public ScalingSettings(boolean on, int low, int high) {
            this.on = on;
            this.low = Integer.valueOf(low);
            this.high = Integer.valueOf(high);
        }

        public String toString() {
            return this.on ? "[ " + this.low + ", " + this.high + " ]" : "OFF";
        }
    }
}
