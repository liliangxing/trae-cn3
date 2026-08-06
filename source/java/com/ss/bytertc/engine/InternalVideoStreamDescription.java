package com.ss.bytertc.engine;

import com.ss.bytertc.engine.VideoStreamDescription;

/* loaded from: classes7.dex */
public class InternalVideoStreamDescription {
    public VideoEncoderPreference encodePreference;
    public int frameRate;
    public int height;
    public int maxKbps;
    public int minKbps;
    public int width;

    /* loaded from: classes7.dex */
    public enum VideoCodecMode {
        VIDEO_CODEC_MODE_AUTO(0),
        VIDEO_CODEC_MODE_HARDWARE(1),
        VIDEO_CODEC_MODE_SOFTWARE(2);

        private int value;

        VideoCodecMode(int v) {
            this.value = v;
        }

        public int getIntValue() {
            return this.value;
        }
    }

    /* loaded from: classes7.dex */
    public enum VideoCodecType {
        VIDEO_CODEC_TYPE_AUTO(0),
        VIDEO_CODEC_TYPE_H264(1),
        VIDEO_CODEC_TYPE_BYTEVC1(2);

        private int value;

        VideoCodecType(int v) {
            this.value = v;
        }

        public int getIntValue() {
            return this.value;
        }
    }

    /* loaded from: classes7.dex */
    public enum VideoEncoderPreference {
        VIDEO_ENCODER_PREFERENCE_DISABLED(0),
        VIDEO_ENCODER_PREFERENCE_MAINTAIN_FRAMERATE(1),
        VIDEO_ENCODER_PREFERENCE_MAINTAIN_QUALITY(2),
        VIDEO_ENCODER_PREFERENCE_BALANCE(3);

        private int value;

        VideoEncoderPreference(int v) {
            this.value = v;
        }

        public int getIntValue() {
            return this.value;
        }
    }

    public InternalVideoStreamDescription(VideoStreamDescription videoStreamDescription) {
        this.minKbps = 0;
        this.encodePreference = VideoEncoderPreference.VIDEO_ENCODER_PREFERENCE_MAINTAIN_FRAMERATE;
        this.width = ((Integer) videoStreamDescription.videoSize.first).intValue();
        this.height = ((Integer) videoStreamDescription.videoSize.second).intValue();
        this.frameRate = videoStreamDescription.frameRate;
        this.maxKbps = videoStreamDescription.maxKbps;
        this.minKbps = videoStreamDescription.minKbps;
        this.encodePreference = ConvertEnumValue(videoStreamDescription.encodePreference);
    }

    private VideoCodecMode ConvertEnumValue(VideoStreamDescription.CodecMode codecMode) {
        VideoCodecMode videoCodecMode = VideoCodecMode.VIDEO_CODEC_MODE_AUTO;
        int i = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$VideoStreamDescription$CodecMode[codecMode.ordinal()];
        if (i == 1) {
            return VideoCodecMode.VIDEO_CODEC_MODE_AUTO;
        }
        if (i == 2) {
            return VideoCodecMode.VIDEO_CODEC_MODE_HARDWARE;
        }
        if (i == 3) {
            return VideoCodecMode.VIDEO_CODEC_MODE_SOFTWARE;
        }
        return VideoCodecMode.VIDEO_CODEC_MODE_AUTO;
    }

    private VideoCodecType ConvertEnumValue(VideoStreamDescription.VideoCodecType codecName) {
        VideoCodecType videoCodecType = VideoCodecType.VIDEO_CODEC_TYPE_AUTO;
        int i = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$VideoStreamDescription$VideoCodecType[codecName.ordinal()];
        if (i == 1) {
            return VideoCodecType.VIDEO_CODEC_TYPE_AUTO;
        }
        if (i == 2) {
            return VideoCodecType.VIDEO_CODEC_TYPE_H264;
        }
        if (i == 3) {
            return VideoCodecType.VIDEO_CODEC_TYPE_BYTEVC1;
        }
        return VideoCodecType.VIDEO_CODEC_TYPE_AUTO;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.ss.bytertc.engine.InternalVideoStreamDescription$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$VideoStreamDescription$CodecMode;
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$VideoStreamDescription$EncoderPreference;
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$VideoStreamDescription$VideoCodecType;

        static {
            int[] iArr = new int[VideoStreamDescription.EncoderPreference.values().length];
            $SwitchMap$com$ss$bytertc$engine$VideoStreamDescription$EncoderPreference = iArr;
            try {
                iArr[VideoStreamDescription.EncoderPreference.Disabled.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$VideoStreamDescription$EncoderPreference[VideoStreamDescription.EncoderPreference.MaintainFramerate.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$VideoStreamDescription$EncoderPreference[VideoStreamDescription.EncoderPreference.MaintainQuality.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$VideoStreamDescription$EncoderPreference[VideoStreamDescription.EncoderPreference.Balance.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[VideoStreamDescription.VideoCodecType.values().length];
            $SwitchMap$com$ss$bytertc$engine$VideoStreamDescription$VideoCodecType = iArr2;
            try {
                iArr2[VideoStreamDescription.VideoCodecType.CODEC_TYPE_AUTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$VideoStreamDescription$VideoCodecType[VideoStreamDescription.VideoCodecType.CODEC_TYPE_H264.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$VideoStreamDescription$VideoCodecType[VideoStreamDescription.VideoCodecType.CODEC_TYPE_BYTEVC1.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[VideoStreamDescription.CodecMode.values().length];
            $SwitchMap$com$ss$bytertc$engine$VideoStreamDescription$CodecMode = iArr3;
            try {
                iArr3[VideoStreamDescription.CodecMode.CODEC_MODE_AUTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$VideoStreamDescription$CodecMode[VideoStreamDescription.CodecMode.CODEC_MODE_HARDWARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$VideoStreamDescription$CodecMode[VideoStreamDescription.CodecMode.CODEC_MODE_SOFTWARE.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    private VideoEncoderPreference ConvertEnumValue(VideoStreamDescription.EncoderPreference encodePreference) {
        VideoEncoderPreference videoEncoderPreference = VideoEncoderPreference.VIDEO_ENCODER_PREFERENCE_MAINTAIN_FRAMERATE;
        int i = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$VideoStreamDescription$EncoderPreference[encodePreference.ordinal()];
        if (i == 1) {
            return VideoEncoderPreference.VIDEO_ENCODER_PREFERENCE_DISABLED;
        }
        if (i == 2) {
            return VideoEncoderPreference.VIDEO_ENCODER_PREFERENCE_MAINTAIN_FRAMERATE;
        }
        if (i != 3) {
            return i != 4 ? videoEncoderPreference : VideoEncoderPreference.VIDEO_ENCODER_PREFERENCE_BALANCE;
        }
        return VideoEncoderPreference.VIDEO_ENCODER_PREFERENCE_MAINTAIN_QUALITY;
    }

    int getWidth() {
        return this.width;
    }

    int getHeight() {
        return this.height;
    }

    int getFrameRate() {
        return this.frameRate;
    }

    int getMaxKBps() {
        return this.maxKbps;
    }

    int getMinKBps() {
        return this.minKbps;
    }

    VideoEncoderPreference getEncoderPreference() {
        return this.encodePreference;
    }
}
