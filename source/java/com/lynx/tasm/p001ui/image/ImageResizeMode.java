package com.lynx.tasm.p001ui.image;

import com.facebook.drawee.drawable.ScalingUtils;
import com.lynx.tasm.p001ui.image.LynxScalingUtils;
import com.lynx.trace.BuildConfig;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ImageResizeMode {
    public static ScalingUtils.ScaleType toScaleType(String str) {
        if ("aspectFit".equals(str)) {
            return ScalingUtils.ScaleType.FIT_CENTER;
        }
        if ("aspectFill".equals(str)) {
            return ScalingUtils.ScaleType.CENTER_CROP;
        }
        if ("scaleToFill".equals(str)) {
            return ScalingUtils.ScaleType.FIT_XY;
        }
        if ("center".equals(str)) {
            return ScalingUtils.ScaleType.CENTER;
        }
        if (str == null || str.equals(BuildConfig.enable_trace) || str.length() == 0) {
            return defaultValue();
        }
        throw new RuntimeException("Invalid resize mode: '" + str + "'");
    }

    public static ScalingUtils.ScaleType getRealScaleType(ScalingUtils.ScaleType scaleType) {
        if (scaleType == ScalingUtils.ScaleType.FIT_CENTER) {
            return LynxScalingUtils.ScaleType.FIT_CENTER;
        }
        if (scaleType == ScalingUtils.ScaleType.CENTER_CROP) {
            return LynxScalingUtils.ScaleType.CENTER_CROP;
        }
        if (scaleType == ScalingUtils.ScaleType.CENTER) {
            return LynxScalingUtils.ScaleType.CENTER;
        }
        return scaleType == ScalingUtils.ScaleType.FIT_XY ? LynxScalingUtils.ScaleType.FIT_XY : scaleType;
    }

    public static ScalingUtils.ScaleType defaultValue() {
        return ScalingUtils.ScaleType.FIT_XY;
    }
}
