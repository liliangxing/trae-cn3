package com.ss.ttm.player.UnifiedCodec.reuse;

import android.media.MediaFormat;
import android.text.TextUtils;
import com.ss.ttm.player.UnifiedCodec.MediaCodecManager;
import com.ss.ttm.player.UnifiedCodec.codec.AudioCodecAdapter;
import com.ss.ttm.player.UnifiedCodec.codec.FormatWrapper;
import com.ss.ttm.player.UnifiedCodec.codec.ReuseCodecAdapter;
import com.ss.ttm.player.UnifiedCodec.codec.VideoCodecAdapter;
import com.ss.ttm.player.UnifiedCodec.util.CodecUtils;
import com.ss.ttm.player.UnifiedCodec.util.DeviceUtils;
import com.ss.ttm.player.UnifiedCodec.util.MimeTypes;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class ReuseHelper {
    public static final String TAG = "ReuseHelper";

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public enum AdaptationWorkaroundMode {
        ADAPTATION_WORKAROUND_MODE_NEVER,
        ADAPTATION_WORKAROUND_MODE_SAME_RESOLUTION,
        ADAPTATION_WORKAROUND_MODE_ALWAYS
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public enum ReuseResult {
        CODEC_RESULT_NO,
        CODEC_RESULT_YES_WITH_FLUSH,
        CODEC_RESULT_YES_WITH_RECONFIGURATION,
        CODEC_RESULT_YES_WITHOUT_RECONFIGURATION
    }

    private ReuseHelper() {
    }

    public static AdaptationWorkaroundMode codecAdaptationWorkaroundMode(String name) {
        if (DeviceUtils.SDK_INT <= 25 && "OMX.Exynos.avc.dec.secure".equals(name)) {
            return AdaptationWorkaroundMode.ADAPTATION_WORKAROUND_MODE_ALWAYS;
        }
        if (DeviceUtils.SDK_INT < 24 && (("OMX.Nvidia.h264.decode".equals(name) || "OMX.Nvidia.h264.decode.secure".equals(name)) && ("flounder".equals(DeviceUtils.DEVICE) || "flounder_lte".equals(DeviceUtils.DEVICE) || "grouper".equals(DeviceUtils.DEVICE) || "tilapia".equals(DeviceUtils.DEVICE)))) {
            return AdaptationWorkaroundMode.ADAPTATION_WORKAROUND_MODE_SAME_RESOLUTION;
        }
        return AdaptationWorkaroundMode.ADAPTATION_WORKAROUND_MODE_NEVER;
    }

    public static void initFormatWrapper(FormatWrapper formatWrapper, MediaFormat mediaFormat) {
        ReusePolicy reusePolicy = MediaCodecManager.getInstance().getReusePolicy();
        int max = Math.max(reusePolicy.mInitWidth, formatWrapper.width);
        int max2 = Math.max(reusePolicy.mInitHeight, formatWrapper.mHeight);
        if (reusePolicy.mConfigUseInitFormat) {
            reusePolicy.mInitWidth = max;
            reusePolicy.mInitHeight = max2;
        }
        int max3 = Math.max(0, CodecUtils.getCodecMaxInputSize(formatWrapper.mSampleMimeType, max, max2, false));
        formatWrapper.mMaxWidth = max;
        formatWrapper.mMaxHeight = max2;
        formatWrapper.mMaxInputSize = max3;
        if (max3 > 0) {
            mediaFormat.setInteger("max-input-size", max3);
        }
        if (formatWrapper.isVideo()) {
            mediaFormat.setInteger("max-width", max);
            mediaFormat.setInteger("max-height", max2);
        }
    }

    public static boolean isSeamlessAdaptationSupported(ReuseCodecAdapter codecAdapter, FormatWrapper formatWrapper) {
        return isSeamlessAdaptationSupported(codecAdapter, formatWrapper, false);
    }

    public static boolean isSeamlessAdaptationSupported(ReuseCodecAdapter reuseCodecAdapter, FormatWrapper formatWrapper, boolean isNewFormatComplete) {
        if (reuseCodecAdapter instanceof VideoCodecAdapter) {
            if (TextUtils.equals(reuseCodecAdapter.mFormat.mSampleMimeType, formatWrapper.mSampleMimeType) && reuseCodecAdapter.mFormat.mRotationDegrees == formatWrapper.mRotationDegrees) {
                return reuseCodecAdapter.mAdaptive || (reuseCodecAdapter.mFormat.width == formatWrapper.width && reuseCodecAdapter.mFormat.mHeight == formatWrapper.mHeight);
            }
            return false;
        }
        if (reuseCodecAdapter instanceof AudioCodecAdapter) {
            return TextUtils.equals(MimeTypes.AUDIO_AAC, reuseCodecAdapter.mFormat.mSampleMimeType);
        }
        return true;
    }
}
