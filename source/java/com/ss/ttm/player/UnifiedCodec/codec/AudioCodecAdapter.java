package com.ss.ttm.player.UnifiedCodec.codec;

import android.media.MediaCodec;
import com.ss.ttm.player.UnifiedCodec.reuse.ReuseHelper;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class AudioCodecAdapter extends ReuseCodecAdapter {
    public AudioCodecAdapter(MediaCodec mediaCodec, FormatWrapper formatWrapper) {
        super(mediaCodec, formatWrapper);
    }

    @Override // com.ss.ttm.player.UnifiedCodec.codec.ReuseCodecAdapter
    public ReuseHelper.ReuseResult canReuse(FormatWrapper formatWrapper) {
        if (ReuseHelper.isSeamlessAdaptationSupported(this, formatWrapper)) {
            return ReuseHelper.ReuseResult.CODEC_RESULT_YES_WITHOUT_RECONFIGURATION;
        }
        return ReuseHelper.ReuseResult.CODEC_RESULT_NO;
    }

    @Override // com.ss.ttm.player.UnifiedCodec.codec.ReuseCodecAdapter
    public String toString() {
        return "AudioCodecAdapter[" + hashCode() + ']';
    }
}
