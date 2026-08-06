package com.bytedance.realx.video;

import com.bytedance.realx.video.VideoDecoder;
import com.bytedance.realx.video.memory.RXVideoFrameInterface;

/* loaded from: classes4.dex */
class VideoDecoderWrapper {
    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeOnDecodedFrame(long nativeVideoDecoderWrapper, RXVideoFrameInterface frame);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeOnMediaCodecStatus(long nativeVideoDecoderWrapper, VideoCodecStatus type, String info);

    VideoDecoderWrapper() {
    }

    static VideoDecoder.Callback createDecoderCallback(final long nativeDecoder) {
        return new VideoDecoder.Callback() { // from class: com.bytedance.realx.video.VideoDecoderWrapper.1
            @Override // com.bytedance.realx.video.VideoDecoder.Callback
            public void onDecodedFrame(RXVideoFrameInterface frame) {
                long j = nativeDecoder;
                if (j != 0) {
                    VideoDecoderWrapper.nativeOnDecodedFrame(j, frame);
                }
            }

            @Override // com.bytedance.realx.video.VideoDecoder.Callback
            public void onMediaCodecStatus(VideoCodecStatus type, String info) {
                if (nativeDecoder == 0 || info == null || info.length() == 0) {
                    return;
                }
                VideoDecoderWrapper.nativeOnMediaCodecStatus(nativeDecoder, type, info);
            }
        };
    }
}
