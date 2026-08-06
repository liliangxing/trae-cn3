package com.bytedance.realx.video;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.util.Log;
import com.bytedance.realx.base.RXDeviceInfoAndroid;
import com.bytedance.realx.base.RXLogging;
import java.util.ArrayList;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class HardwareVideoEncoderFactory {
    private static final int QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_L_MS = 15000;
    private static final int QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_M_MS = 20000;
    private static final int QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_N_MS = 15000;
    private static final String TAG = "HwVideoEncoderFactory";

    public static VideoEncoder createEncoder(RXVideoCodecDesc codecDesc) {
        RXVideoCodecStandard standard = codecDesc.getStandard();
        MediaCodecInfo findCodecForType = findCodecForType(standard);
        if (findCodecForType == null) {
            return null;
        }
        String name = findCodecForType.getName();
        String mimeType = standard.mimeType();
        Integer selectColorFormat = MediaCodecUtils.selectColorFormat(MediaCodecUtils.TEXTURE_COLOR_FORMATS, findCodecForType.getCapabilitiesForType(mimeType));
        if (selectColorFormat == null) {
            Log.e(TAG, "surfaceColorFormat is null object.");
            return null;
        }
        Integer selectColorFormat2 = MediaCodecUtils.selectColorFormat(name.contains("OMX.hisi.") ? MediaCodecUtils.ENCODER_COLOR_FORMATS_FOR_HISI : MediaCodecUtils.ENCODER_COLOR_FORMATS, findCodecForType.getCapabilitiesForType(mimeType));
        if (selectColorFormat2 == null) {
            Log.e(TAG, "yuvColorFormat is null object.");
            return null;
        }
        return new HardwareVideoEncoder(new MediaCodecWrapperFactoryImpl(), name, codecDesc, selectColorFormat, selectColorFormat2, getKeyFrameIntervalSec(standard), getForcedKeyFrameIntervalMs(standard, name), findCodecForType.getCapabilitiesForType(mimeType));
    }

    public static RXVideoCodecDesc[] getSupportedCodecs() {
        ArrayList arrayList = new ArrayList();
        RXVideoCodecStandard[] rXVideoCodecStandardArr = {RXVideoCodecStandard.ByteVC1, RXVideoCodecStandard.H264, RXVideoCodecStandard.VP8};
        for (int i = 0; i < 3; i++) {
            RXVideoCodecStandard rXVideoCodecStandard = rXVideoCodecStandardArr[i];
            MediaCodecInfo findCodecForType = findCodecForType(rXVideoCodecStandard);
            if (findCodecForType != null) {
                if (rXVideoCodecStandard == RXVideoCodecStandard.ByteVC1 && isSupportedCodec(findCodecForType, rXVideoCodecStandard)) {
                    arrayList.add(new RXVideoCodecDesc(rXVideoCodecStandard, RXVideoCodecProfile.ByteVC1ProfileMain));
                }
                if (rXVideoCodecStandard == RXVideoCodecStandard.H264) {
                    if (isH264HighProfileSupported(findCodecForType)) {
                        arrayList.add(new RXVideoCodecDesc(rXVideoCodecStandard, RXVideoCodecProfile.ProfileHigh));
                    }
                    arrayList.add(new RXVideoCodecDesc(rXVideoCodecStandard, RXVideoCodecProfile.ProfileBaseline));
                }
                if (rXVideoCodecStandard == RXVideoCodecStandard.VP8) {
                    arrayList.add(new RXVideoCodecDesc(rXVideoCodecStandard, RXVideoCodecProfile.VP8ProfileMain));
                }
            }
        }
        return (RXVideoCodecDesc[]) arrayList.toArray(new RXVideoCodecDesc[arrayList.size()]);
    }

    private static MediaCodecInfo findCodecForType(RXVideoCodecStandard type) {
        MediaCodecInfo mediaCodecInfo;
        try {
            int codecCount = MediaCodecList.getCodecCount();
            for (int i = 0; i < codecCount; i++) {
                try {
                    mediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
                } catch (IllegalArgumentException e) {
                    Log.e(TAG, "Cannot retrieve encoder codec info", e);
                    mediaCodecInfo = null;
                }
                if (mediaCodecInfo != null && mediaCodecInfo.isEncoder() && !isSoftwareOnly(mediaCodecInfo) && isSupportedCodec(mediaCodecInfo, type)) {
                    return mediaCodecInfo;
                }
            }
            return null;
        } catch (Exception e2) {
            Log.e(TAG, "Cannot getCodecCount", e2);
            return null;
        }
    }

    private static boolean isSupportedCodec(MediaCodecInfo info, RXVideoCodecStandard type) {
        if (!MediaCodecUtils.codecSupportsType(info, type)) {
            return false;
        }
        try {
            if (MediaCodecUtils.selectColorFormat(MediaCodecUtils.ENCODER_COLOR_FORMATS, info.getCapabilitiesForType(type.mimeType())) == null) {
                return false;
            }
            return isHardwareSupportedInCurrentSdk(info, type);
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.realx.video.HardwareVideoEncoderFactory$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static /* synthetic */ class C07011 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$realx$video$RXVideoCodecStandard;

        static {
            int[] iArr = new int[RXVideoCodecStandard.values().length];
            $SwitchMap$com$bytedance$realx$video$RXVideoCodecStandard = iArr;
            try {
                iArr[RXVideoCodecStandard.H264.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bytedance$realx$video$RXVideoCodecStandard[RXVideoCodecStandard.ByteVC1.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$bytedance$realx$video$RXVideoCodecStandard[RXVideoCodecStandard.VP8.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$bytedance$realx$video$RXVideoCodecStandard[RXVideoCodecStandard.VP9.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private static boolean isHardwareSupportedInCurrentSdk(MediaCodecInfo info, RXVideoCodecStandard type) {
        int i = C07011.$SwitchMap$com$bytedance$realx$video$RXVideoCodecStandard[type.ordinal()];
        if (i == 1) {
            return isHardwareSupportedInCurrentSdkH264(info);
        }
        if (i == 2) {
            return isHardwareSupportedInCurrentSdkByteVC1(info);
        }
        if (i != 3) {
            return false;
        }
        return isHardwareSupportedInCurrentSdkVP8(info);
    }

    private static boolean isHardwareSupportedInCurrentSdkH264(MediaCodecInfo info) {
        String name = info.getName();
        if (name.startsWith("OMX.qcom.") || name.startsWith("OMX.sprd.")) {
            return true;
        }
        name.startsWith("OMX.Exynos.");
        return true;
    }

    private static boolean isHardwareSupportedInCurrentSdkByteVC1(MediaCodecInfo info) {
        String name = info.getName();
        if (name.startsWith("OMX.qcom.")) {
            return true;
        }
        name.startsWith("OMX.Exynos.");
        return true;
    }

    private static boolean isHardwareSupportedInCurrentSdkVP8(MediaCodecInfo info) {
        String name = info.getName();
        if (name.startsWith("OMX.qcom.") || name.startsWith("OMX.Exynos.")) {
            return true;
        }
        name.startsWith("OMX.Intel.");
        return true;
    }

    private static int getKeyFrameIntervalSec(RXVideoCodecStandard type) {
        int i = C07011.$SwitchMap$com$bytedance$realx$video$RXVideoCodecStandard[type.ordinal()];
        if (i == 1 || i == 2) {
            return 720;
        }
        if (i == 3 || i == 4) {
            return 100;
        }
        throw new IllegalArgumentException("Unsupported VideoCodecType " + type);
    }

    private static int getForcedKeyFrameIntervalMs(RXVideoCodecStandard type, String codecName) {
        return (type == RXVideoCodecStandard.VP8 && codecName.startsWith("OMX.qcom.")) ? 15000 : 0;
    }

    private static boolean isH264HighProfileSupported(MediaCodecInfo info) {
        String GetDeviceModel = RXDeviceInfoAndroid.GetDeviceModel();
        String GetDeviceBrand = RXDeviceInfoAndroid.GetDeviceBrand();
        if (RXDeviceInfoAndroid.GetCpuModel().contains("Amlogic")) {
            return false;
        }
        return (GetDeviceModel.equalsIgnoreCase("T730") && GetDeviceBrand.equalsIgnoreCase("VHD")) ? false : true;
    }

    private static boolean isSoftwareOnly(MediaCodecInfo encoderInfo) {
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                return encoderInfo.isSoftwareOnly();
            }
            String name = encoderInfo.getName();
            if (name == null) {
                return false;
            }
            String lowerCase = name.toLowerCase();
            if (lowerCase.startsWith("arc.")) {
                return false;
            }
            return lowerCase.startsWith("omx.google.") || lowerCase.startsWith("omx.ffmpeg.") || (lowerCase.startsWith("omx.sec.") && lowerCase.contains(".sw.")) || lowerCase.startsWith("c2.android.") || lowerCase.startsWith("c2.google.") || !(lowerCase.startsWith("omx.") || lowerCase.startsWith("c2."));
        } catch (Exception e) {
            RXLogging.m284e(TAG, "check encoder softonly error.", e);
            return false;
        }
    }

    public static boolean isBitrateModeSupported(MediaCodecInfo info, RXVideoCodecStandard type, int bitrateMode) {
        MediaCodecInfo.CodecCapabilities capabilitiesForType = info.getCapabilitiesForType(type.mimeType());
        if (capabilitiesForType == null) {
            RXLogging.m283e(TAG, "get capability return null.");
            return false;
        }
        MediaCodecInfo.EncoderCapabilities encoderCapabilities = capabilitiesForType.getEncoderCapabilities();
        if (encoderCapabilities == null) {
            RXLogging.m283e(TAG, "get EncoderCapabilities return null.");
            return false;
        }
        return encoderCapabilities.isBitrateModeSupported(bitrateMode);
    }
}
