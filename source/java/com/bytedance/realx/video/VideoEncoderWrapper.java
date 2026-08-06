package com.bytedance.realx.video;

import com.bytedance.realx.video.VideoEncoder;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
class VideoEncoderWrapper {
    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeOnEncodedEvent(long nativeVideoEncoderWrapper, int eventType);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeOnEncodedFrame(long nativeVideoEncoderWrapper, ByteBuffer buffer, int encodedWidth, int encodedHeight, int actualWidth, int actualHeight, long captureTimeNs, int frameType, int codec_standard, int svcLayerNum, long compositionTimeUs, int qp);

    VideoEncoderWrapper() {
    }

    static boolean getScalingSettingsOn(VideoEncoder.ScalingSettings scalingSettings) {
        return scalingSettings.on;
    }

    static Integer getScalingSettingsLow(VideoEncoder.ScalingSettings scalingSettings) {
        return scalingSettings.low;
    }

    static Integer getScalingSettingsHigh(VideoEncoder.ScalingSettings scalingSettings) {
        return scalingSettings.high;
    }

    static VideoEncoder.Callback createEncoderCallback(final long nativeEncoder) {
        return new VideoEncoder.Callback() { // from class: com.bytedance.realx.video.VideoEncoderWrapper.1
            @Override // com.bytedance.realx.video.VideoEncoder.Callback
            public void onEncodedFrame(EncodedImage frame, VideoEncoder.CodecSpecificInfo info) {
                VideoEncoderWrapper.nativeOnEncodedFrame(nativeEncoder, frame.buffer, frame.encodedWidth, frame.encodedHeight, frame.actualWidth, frame.actualHeight, frame.captureTimeNs, frame.frameType.getNative(), info.codec_standard.toInt(), frame.svcLayerNum, frame.compositionTimeUs, frame.qp.intValue());
            }

            @Override // com.bytedance.realx.video.VideoEncoder.Callback
            public void onEncodedEvent(VideoEncoder.EncodeEvent event) {
                VideoEncoderWrapper.nativeOnEncodedEvent(nativeEncoder, event.getEventValue());
            }
        };
    }
}
