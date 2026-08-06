package com.ss.ttm.player;

import android.media.MediaCodecInfo;
import android.os.Build;
import com.ss.ttm.utils.AVLogger;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes7.dex */
public class MediaCodecHelper {
    private static final int LEVEL_HIGH = 2;
    private static final int LEVEL_LITE = 0;
    private static final int LEVEL_MIDIUM = 1;
    private static final String TAG = "MediaCodecHelper";
    private static final List<String> amlogicDecoderPrefixes;
    private static final List<String> exynosDecoderPrefixes;
    private static final List<String> kirinDecoderPrefixes;
    private static final List<String> qualcommDecoderPrefixes;

    static {
        LinkedList linkedList = new LinkedList();
        qualcommDecoderPrefixes = linkedList;
        linkedList.add("omx.qcom");
        linkedList.add("c2.qti");
        LinkedList linkedList2 = new LinkedList();
        kirinDecoderPrefixes = linkedList2;
        linkedList2.add("omx.hisi");
        linkedList2.add("c2.hisi");
        LinkedList linkedList3 = new LinkedList();
        exynosDecoderPrefixes = linkedList3;
        linkedList3.add("omx.exynos");
        linkedList3.add("c2.exynos");
        LinkedList linkedList4 = new LinkedList();
        amlogicDecoderPrefixes = linkedList4;
        linkedList4.add("omx.amlogic");
        linkedList4.add("c2.amlogic");
    }

    private static boolean isDecoderInList(List<String> decoderList, String decoderName) {
        for (String str : decoderList) {
            if (decoderName.length() >= str.length() && decoderName.substring(0, str.length()).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public static void setMaxOperatingRate(AJMediaFormat mediaFormat) {
        if (mediaFormat != null) {
            mediaFormat.setInteger("operating-rate", 32767);
            AVLogger.d(TAG, "set Max OperatingRate");
        }
    }

    public static void setOperatingRateBeforeOpen(AJMediaFormat mediaFormat, int rate) {
        if (mediaFormat == null || rate < 0) {
            return;
        }
        mediaFormat.setInteger("operating-rate", rate);
        AVLogger.d(TAG, "set OperatingRate, rate:" + rate);
    }

    public static void setPriority(AJMediaFormat mediaFormat, int priority) {
        if (mediaFormat == null || priority < 0 || priority > 1) {
            return;
        }
        mediaFormat.setInteger("priority", priority);
        AVLogger.d(TAG, "set Priority:" + priority);
    }

    public static void setupVpp(AJMediaFormat mediaFormat, int level, String decoderName) {
        if (mediaFormat == null || !isDecoderInList(qualcommDecoderPrefixes, decoderName) || Build.VERSION.SDK_INT < 26) {
            return;
        }
        mediaFormat.setString("vendor.qti-ext-vpp.mode", "HQV_MODE_MANUAL");
        if (level == 0 || level == 1) {
            mediaFormat.setInteger("vendor.qti-ext-vpp-cade.cade-level", level == 0 ? 10 : 20);
            mediaFormat.setInteger("vendor.qti-ext-vpp-aie.ltm-sat-gain", 65);
            mediaFormat.setInteger("vendor.qti-ext-vpp-aie.ltm-sat-offset", 60);
            mediaFormat.setInteger("vendor.qti-ext-vpp-aie.ltm-ace-str", 50);
        } else {
            if (level != 2) {
                return;
            }
            mediaFormat.setInteger("vendor.qti-ext-vpp-cade.cade-level", 15);
            mediaFormat.setInteger("vendor.qti-ext-vpp-aie.ltm-sat-gain", 70);
            mediaFormat.setInteger("vendor.qti-ext-vpp-aie.ltm-sat-offset", 70);
            mediaFormat.setInteger("vendor.qti-ext-vpp-aie.ltm-ace-str", 50);
        }
        mediaFormat.setInteger("vendor.qti-ext-vpp-aie.ltm-ace-brightness-low", 20);
        mediaFormat.setInteger("vendor.qti-ext-vpp-aie.ltm-ace-brightness-high", 20);
        AVLogger.d(TAG, "set vpp, level:" + level);
    }

    public static void debugEffect(AJMediaFormat mediaFormat, String decoderName) {
        if (mediaFormat == null || !isDecoderInList(qualcommDecoderPrefixes, decoderName) || Build.VERSION.SDK_INT < 26) {
            return;
        }
        mediaFormat.setInteger("vendor.qti-ext-vpp-demo.process-percent", 50);
        AVLogger.d(TAG, "mediaformat = " + mediaFormat.toString());
    }

    public static void setHisiFrequence(AJMediaFormat mediaFormat, int value, String decoderName) {
        if (mediaFormat == null || !isDecoderInList(kirinDecoderPrefixes, decoderName) || value < 0 || value > 2 || Build.VERSION.SDK_INT < 26) {
            return;
        }
        mediaFormat.setInteger("vendor.hisi-ext-frequence-request-video-dec.video-scene-for-frequence-req", value);
        AVLogger.d(TAG, "set Hisi frequence, value:" + value);
    }

    public static void setImportance(AJMediaFormat mediaFormat, int value) {
        if (mediaFormat == null || value < 0 || Build.VERSION.SDK_INT < 35) {
            return;
        }
        mediaFormat.setInteger("importance", value);
        AVLogger.d(TAG, "set importance, value:" + value);
    }

    public static void disableAllowFrameDrop(AJMediaFormat mediaFormat) {
        if (mediaFormat == null || Build.VERSION.SDK_INT < 31) {
            return;
        }
        mediaFormat.setInteger("allow-frame-drop", 0);
        AVLogger.d(TAG, "disable allow frame drop");
    }

    public static void setQcomOrder(AJMediaFormat mediaFormat, String decoderName) {
        if (mediaFormat == null || !isDecoderInList(qualcommDecoderPrefixes, decoderName) || Build.VERSION.SDK_INT < 26) {
            return;
        }
        mediaFormat.setInteger("vendor.qti-ext-dec-picture-order.enable", 1);
        AVLogger.d(TAG, "set Qcom order");
    }

    public static void setQcomSliceDeliveryMode(AJMediaFormat mediaFormat, String decoderName) {
        if (mediaFormat == null || !isDecoderInList(qualcommDecoderPrefixes, decoderName) || Build.VERSION.SDK_INT < 26) {
            return;
        }
        mediaFormat.setFeatureEnabled("vendor.qti-ext-dec-slice-delivery-mode.value", true);
        AVLogger.d(TAG, "set Qcom slice delivery mode");
    }

    public static void setQcomTimestampReorder(AJMediaFormat mediaFormat, String decoderName) {
        if (mediaFormat == null || !isDecoderInList(qualcommDecoderPrefixes, decoderName) || Build.VERSION.SDK_INT < 26) {
            return;
        }
        mediaFormat.setFeatureEnabled("vendor.qti-ext-dec-timestamp-reorder.value", true);
        AVLogger.d(TAG, "set Qcom timestamp reorder");
    }

    public static void setQcomCpuAffinityMask(AJMediaFormat mediaFormat, int value, String decoderName) {
        if (mediaFormat == null || !isDecoderInList(qualcommDecoderPrefixes, decoderName) || Build.VERSION.SDK_INT < 26) {
            return;
        }
        mediaFormat.setInteger("vendor.qti-ext-cpu-affinity-set-mask.value", value);
        AVLogger.d(TAG, "set Qcom cpu affinity mask, value:" + value);
    }

    public static void setQcomEarlyNotifyValue(AJMediaFormat mediaFormat, int value, String decoderName) {
        if (mediaFormat == null || !isDecoderInList(qualcommDecoderPrefixes, decoderName) || Build.VERSION.SDK_INT < 26) {
            return;
        }
        mediaFormat.setInteger("vendor.qti-ext-dec-early-notify.value", value);
        AVLogger.d(TAG, "set Qcom early notify, value:" + value);
    }

    public static boolean decoderSupportsAndroidRLowLatency(MediaCodecInfo decoderInfo, String mimeType) {
        if (Build.VERSION.SDK_INT < 30) {
            return false;
        }
        try {
            if (!decoderInfo.getCapabilitiesForType(mimeType).isFeatureSupported("low-latency")) {
                return false;
            }
            AVLogger.d(TAG, "Low latency decoding mode supported (FEATURE_LowLatency)");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void setHisiLowLatency(AJMediaFormat mediaFormat, String decoderName) {
        if (mediaFormat == null || !isDecoderInList(kirinDecoderPrefixes, decoderName) || Build.VERSION.SDK_INT < 26) {
            return;
        }
        mediaFormat.setInteger("vendor.hisi-ext-low-latency-video-dec.video-scene-for-low-latency-req", 1);
        mediaFormat.setInteger("vendor.hisi-ext-low-latency-video-dec.video-scene-for-low-latency-rdy", -1);
        AVLogger.d(TAG, "enable hisi lowlatency");
    }

    public static void setLowLatency(AJMediaFormat mediaFormat, MediaCodecInfo decoderInfo, int enableLowLatency) {
        if (mediaFormat == null) {
            return;
        }
        mediaFormat.setInteger("low-latency", 1);
        if ((enableLowLatency & 1) > 0 && decoderSupportsAndroidRLowLatency(decoderInfo, mediaFormat.getString("mime"))) {
            AVLogger.d(TAG, "support Android R Low-latency");
            return;
        }
        if ((enableLowLatency & 2) > 0) {
            mediaFormat.setInteger("vdec-lowlatency", 1);
        }
        if ((enableLowLatency & 4) <= 0 || Build.VERSION.SDK_INT < 26) {
            return;
        }
        if (isDecoderInList(qualcommDecoderPrefixes, decoderInfo.getName())) {
            mediaFormat.setInteger("vendor.qti-ext-dec-low-latency.enable", 1);
        } else if (isDecoderInList(exynosDecoderPrefixes, decoderInfo.getName())) {
            mediaFormat.setInteger("vendor.rtc-ext-dec-low-latency.enable", 1);
        } else if (isDecoderInList(amlogicDecoderPrefixes, decoderInfo.getName())) {
            mediaFormat.setInteger("vendor.low-latency.enable", 1);
        }
    }
}
