package com.ss.ttm.player.UnifiedCodec.util;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import com.ss.ttm.player.UnifiedCodec.codec.FormatWrapper;
import com.ss.ttm.player.UnifiedCodec.codec.ReuseCodecAdapter;
import com.ss.ttm.utils.Util;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Locale;

/* loaded from: classes7.dex */
public final class CodecUtils {
    public static final String CSD_0 = "csd-0";
    public static final String CSD_1 = "csd-1";
    public static final String CSD_2 = "csd-2";
    public static final String[] CSD_INDEX_ARRAY = {CSD_0, CSD_1, CSD_2};
    private static final int HEVC_MAX_INPUT_SIZE_THRESHOLD = 2097152;
    public static final int NO_VALUE = -1;
    public static final String TAG = "CodecUtils";
    private static boolean sDeviceNeedsSetOutputSurfaceWorkaround;
    private static boolean sEvaluatedDeviceNeedsSetOutputSurfaceWorkaround;

    public static boolean codecNeedsSetOutputSurfaceWorkaround() {
        return false;
    }

    public static int ceilDivide(int i, int i2) {
        return ((i + i2) - 1) / i2;
    }

    public static String getCodeName(MediaCodec mediaCodec) {
        return mediaCodec.getName();
    }

    public static int getCodecMaxInputSize(String mime, int width, int height) {
        return getCodecMaxInputSize(mime, width, height, false);
    }

    public static ArrayList<byte[]> getCsdBuffers(MediaFormat mediaFormat) {
        ArrayList<byte[]> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            String[] strArr = CSD_INDEX_ARRAY;
            if (i >= strArr.length) {
                return arrayList;
            }
            ByteBuffer byteBuffer = mediaFormat.getByteBuffer(strArr[i]);
            if (byteBuffer != null) {
                arrayList.add(byteBuffer.array());
            }
            i++;
        }
    }

    public static int getMaxInputSize(ReuseCodecAdapter reuseCodecAdapter, FormatWrapper formatWrapper) {
        if (formatWrapper.mMaxInputSize == -1) {
            return getCodecMaxInputSize(formatWrapper.mSampleMimeType, formatWrapper.width, formatWrapper.mHeight, reuseCodecAdapter.mSecure);
        }
        int i = 0;
        for (int i2 = 0; i2 < formatWrapper.mInitializationData.size(); i2++) {
            i += formatWrapper.mInitializationData.get(i2).length;
        }
        return formatWrapper.mMaxInputSize + i;
    }

    public static boolean isAdaptive(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return isAdaptiveV19(codecCapabilities);
    }

    private static boolean isAdaptiveV19(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("adaptive-playback");
    }

    public static boolean isSecure(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return isSecureV21(codecCapabilities);
    }

    private static boolean isSecureV21(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    public static boolean isVideo(String codec) {
        return codec.contains("video");
    }

    private static int getMaxSampleSize(int pixelCount, int minCompressionRatio) {
        return (pixelCount * 3) / (minCompressionRatio * 2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int getCodecMaxInputSize(String sampleMimeType, int width, int height, boolean secure) {
        char c;
        sampleMimeType.hashCode();
        switch (sampleMimeType.hashCode()) {
            case -1664118616:
                if (sampleMimeType.equals(MimeTypes.VIDEO_H263)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1662735862:
                if (sampleMimeType.equals(MimeTypes.VIDEO_AV1)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1662541442:
                if (sampleMimeType.equals(MimeTypes.VIDEO_H265)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1187890754:
                if (sampleMimeType.equals(MimeTypes.VIDEO_MP4V)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1331836730:
                if (sampleMimeType.equals("video/avc")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 1599127256:
                if (sampleMimeType.equals(MimeTypes.VIDEO_VP8)) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 1599127257:
                if (sampleMimeType.equals(MimeTypes.VIDEO_VP9)) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 3:
            case 5:
                return getMaxSampleSize(width * height, 2);
            case 2:
                return Math.max(2097152, getMaxSampleSize(width * height, 2));
            case 4:
                if ("BRAVIA 4K 2015".equals(Util.MODEL) || ("Amazon".equals(Util.MANUFACTURER) && ("KFSOWI".equals(Util.MODEL) || ("AFTS".equals(Util.MODEL) && secure)))) {
                    return -1;
                }
                return getMaxSampleSize(ceilDivide(width, 16) * ceilDivide(height, 16) * 16 * 16, 2);
            case 6:
                return getMaxSampleSize(width * height, 4);
            default:
                return -1;
        }
    }

    public static boolean isVideo(MediaFormat mediaFormat) {
        return isVideo(mediaFormat.getString("mime"));
    }

    public static String getMimeType(String mimeorName) {
        if (mimeorName.isEmpty()) {
            return null;
        }
        String lowerCase = mimeorName.toLowerCase(Locale.US);
        if (lowerCase.contains("hevc") || lowerCase.contains("265")) {
            return MimeTypes.VIDEO_H265;
        }
        if (lowerCase.contains("avc") || lowerCase.contains("264")) {
            return "video/avc";
        }
        return null;
    }
}
