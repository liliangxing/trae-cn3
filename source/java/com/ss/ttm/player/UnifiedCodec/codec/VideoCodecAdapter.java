package com.ss.ttm.player.UnifiedCodec.codec;

import android.media.MediaCodec;
import com.ss.ttm.player.UnifiedCodec.reuse.ReuseHelper;
import com.ss.ttm.player.UnifiedCodec.util.CodecUtils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class VideoCodecAdapter extends ReuseCodecAdapter {
    public VideoCodecAdapter(MediaCodec mediaCodec, FormatWrapper formatWrapper) {
        super(mediaCodec, formatWrapper);
    }

    @Override // com.ss.ttm.player.UnifiedCodec.codec.ReuseCodecAdapter
    public ReuseHelper.ReuseResult canReuse(FormatWrapper formatWrapper) {
        if (ReuseHelper.isSeamlessAdaptationSupported(this, formatWrapper) && formatWrapper.width <= this.mCodecMaxValues.mWidth && formatWrapper.mHeight <= this.mCodecMaxValues.mHeight && CodecUtils.getMaxInputSize(this, formatWrapper) <= this.mCodecMaxValues.mMaxInputSize) {
            if (formatWrapper.initializationDataEquals(this.mFormat)) {
                return ReuseHelper.ReuseResult.CODEC_RESULT_YES_WITHOUT_RECONFIGURATION;
            }
            return ReuseHelper.ReuseResult.CODEC_RESULT_YES_WITH_RECONFIGURATION;
        }
        return ReuseHelper.ReuseResult.CODEC_RESULT_NO;
    }

    @Override // com.ss.ttm.player.UnifiedCodec.codec.ReuseCodecAdapter
    public boolean isNeedRetain() {
        return super.isNeedRetain() && this.mSurface != null && this.mFormat.mRotationDegrees <= 0;
    }

    @Override // com.ss.ttm.player.UnifiedCodec.codec.ReuseCodecAdapter
    public String toString() {
        return "VideoCodecAdapter[" + hashCode() + ']';
    }
}
