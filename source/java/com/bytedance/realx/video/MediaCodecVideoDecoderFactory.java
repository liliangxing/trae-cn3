package com.bytedance.realx.video;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import com.bytedance.realx.base.RXLogging;
import com.bytedance.realx.video.EglBase;
import java.util.ArrayList;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
class MediaCodecVideoDecoderFactory {
    private static final String TAG = "MediaCodecVideoDecoderFactory";
    private boolean enableAgfxSurfaceTextureHelper = false;

    MediaCodecVideoDecoderFactory() {
    }

    public static void enableEglLock(boolean enable) {
        RXLogging.m283e(TAG, "MediaCodecVideoDecoderFactory enableEglLock:" + enable);
        EglBase.EglLock.enableEglLock = enable;
    }

    public static VideoDecoder createDecoder(RXVideoCodecDesc codecDesc) {
        RXVideoCodecStandard standard = codecDesc.getStandard();
        MediaCodecInfo findCodecForType = findCodecForType(standard);
        if (findCodecForType == null) {
            return null;
        }
        MediaCodecInfo.CodecCapabilities capabilitiesForType = findCodecForType.getCapabilitiesForType(standard.mimeType());
        for (int i : capabilitiesForType.colorFormats) {
            RXLogging.m287w(TAG, "support codecColorFormat:" + i);
        }
        Integer selectColorFormat = MediaCodecUtils.selectColorFormat(MediaCodecUtils.DECODER_COLOR_FORMATS, capabilitiesForType);
        if (selectColorFormat == null) {
            return null;
        }
        return new AndroidVideoDecoder(new MediaCodecWrapperFactoryImpl(), findCodecForType.getName(), standard, selectColorFormat.intValue());
    }

    public static RXVideoCodecDesc[] getSupportedCodecs() {
        ArrayList arrayList = new ArrayList();
        RXVideoCodecStandard rXVideoCodecStandard = RXVideoCodecStandard.H264;
        MediaCodecInfo findCodecForType = findCodecForType(rXVideoCodecStandard);
        if (findCodecForType != null) {
            if (isH264HighProfileSupported(findCodecForType, rXVideoCodecStandard)) {
                arrayList.add(new RXVideoCodecDesc(rXVideoCodecStandard, RXVideoCodecProfile.ProfileHigh));
            }
            arrayList.add(new RXVideoCodecDesc(rXVideoCodecStandard, RXVideoCodecProfile.ProfileBaseline));
        }
        return (RXVideoCodecDesc[]) arrayList.toArray(new RXVideoCodecDesc[arrayList.size()]);
    }

    private static boolean isSoftwareDecoder(MediaCodecInfo decoderInfo) {
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                return decoderInfo.isSoftwareOnly();
            }
            String name = decoderInfo.getName();
            if (name == null) {
                return false;
            }
            String lowerCase = name.toLowerCase();
            if (lowerCase.startsWith("arc.")) {
                return false;
            }
            return lowerCase.startsWith("omx.google.") || lowerCase.startsWith("omx.ffmpeg.") || (lowerCase.startsWith("omx.sec.") && lowerCase.contains(".sw.")) || lowerCase.startsWith("c2.android.") || lowerCase.equals("omx.qcom.video.decoder.hevcswvdec") || lowerCase.startsWith("c2.google.") || !(lowerCase.startsWith("omx.") || lowerCase.startsWith("c2."));
        } catch (Exception e) {
            RXLogging.m284e(TAG, "check decoder softonly error.", e);
            return false;
        }
    }

    private static MediaCodecInfo findCodecForType(RXVideoCodecStandard type) {
        MediaCodecInfo mediaCodecInfo;
        for (int i = 0; i < MediaCodecList.getCodecCount(); i++) {
            try {
                try {
                    mediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
                } catch (IllegalArgumentException e) {
                    RXLogging.m284e(TAG, "Cannot retrieve decoder codec info", e);
                    mediaCodecInfo = null;
                }
                if (mediaCodecInfo != null && !mediaCodecInfo.isEncoder() && !isSoftwareDecoder(mediaCodecInfo) && isSupportedCodec(mediaCodecInfo, type)) {
                    return mediaCodecInfo;
                }
            } catch (Exception e2) {
                RXLogging.m284e(TAG, "findCodecForType got system error:", e2);
            }
        }
        return null;
    }

    private static boolean isSupportedCodec(MediaCodecInfo info, RXVideoCodecStandard type) {
        info.getName();
        return MediaCodecUtils.codecSupportsType(info, type) && MediaCodecUtils.selectColorFormat(MediaCodecUtils.DECODER_COLOR_FORMATS, info.getCapabilitiesForType(type.mimeType())) != null;
    }

    private static boolean isH264HighProfileSupported(MediaCodecInfo info, RXVideoCodecStandard type) {
        String name = info.getName();
        if (name.startsWith("OMX.qcom.") || name.startsWith("OMX.Exynos.")) {
            return true;
        }
        MediaCodecInfo.CodecCapabilities capabilitiesForType = info.getCapabilitiesForType(type.mimeType());
        for (int i = 0; i < capabilitiesForType.profileLevels.length; i++) {
            if (8 == capabilitiesForType.profileLevels[i].profile) {
                return true;
            }
        }
        return false;
    }
}
