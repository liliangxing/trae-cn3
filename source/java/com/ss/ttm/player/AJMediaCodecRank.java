package com.ss.ttm.player;

import android.media.MediaCodecInfo;
import android.text.TextUtils;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes7.dex */
public class AJMediaCodecRank {
    public static final int RANK_ACCEPTABLE = 70;
    public static final int RANK_CODEC2_ACCEPTABLE = 150;
    public static final int RANK_CODEC2_TESTED = 200;
    public static final int RANK_IMPL_AMBIGUOUS = 40;
    public static final int RANK_LOWLATENCY_ACCEPTABLE = 150;
    public static final int RANK_NO_CAPS = 60;
    public static final int RANK_SOFTWARE = 20;
    public static final int RANK_TESTED = 100;
    private static final String TAG = "AJMediaCodecRank";
    private static Map<String, Integer> mTestHWCodecs;
    public String mCodecType;
    public MediaCodecInfo mMediaCodecInfo;
    public int mRank = 0;

    private static Map<String, Integer> getTestHWcodecs() {
        Map<String, Integer> map = mTestHWCodecs;
        if (map != null) {
            return map;
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        mTestHWCodecs = treeMap;
        treeMap.put("OMX.qcom.video.decoder.avc", 100);
        mTestHWCodecs.put("OMX.qcom.video.decoder.hevc", 100);
        mTestHWCodecs.put("OMX.qcom.video.decoder.hevcswvdec", 20);
        mTestHWCodecs.put("OMX.MTK.VIDEO.DECODER.HEVC", 100);
        mTestHWCodecs.put("OMX.MTK.VIDEO.DECODER.AVC", 100);
        mTestHWCodecs.put("OMX.Nvidia.h264.decode", 100);
        mTestHWCodecs.put("OMX.Intel.hw_vd.h264", 100);
        mTestHWCodecs.put("OMX.Intel.VideoDecoder.AVC", 99);
        mTestHWCodecs.put("OMX.SEC.avc.dec", 100);
        mTestHWCodecs.put("OMX.SEC.AVC.Decoder", 99);
        mTestHWCodecs.put("OMX.SEC.avcdec", 98);
        mTestHWCodecs.put("OMX.SEC.avc.sw.dec", 20);
        mTestHWCodecs.put("OMX.SEC.hevc.sw.dec", 20);
        mTestHWCodecs.put("OMX.Exynos.avc.dec", 100);
        mTestHWCodecs.put("OMX.Exynos.AVC.Decoder", 99);
        mTestHWCodecs.put("OMX.TI.DUCATI1.VIDEO.DECODER", 100);
        mTestHWCodecs.put("OMX.rk.video_decoder.avc", 100);
        mTestHWCodecs.put("OMX.amlogic.avc.decoder.awesome", 100);
        mTestHWCodecs.put("OMX.MARVELL.VIDEO.HW.CODA7542DECODER", 100);
        mTestHWCodecs.put("OMX.brcm.video.h264.hw.decoder", 40);
        mTestHWCodecs.put("OMX.k3.video.decoder.avc", 40);
        mTestHWCodecs.put("OMX.IMG.MSVDX.Decoder.AVC", 100);
        mTestHWCodecs.put("OMX.hisi.video.decoder.avc", 100);
        mTestHWCodecs.put("OMX.hisi.video.decoder.hevc", 100);
        mTestHWCodecs.put("OMX.MARVELL.VIDEO.H264DECODER", 20);
        mTestHWCodecs.put("OMX.sprd.soft.h264.decoder", 20);
        mTestHWCodecs.put("OMX.google.aac.decoder", 100);
        mTestHWCodecs.put("OMX.google.h264.decoder", 70);
        mTestHWCodecs.put("OMX.google.hevc.decoder", 70);
        mTestHWCodecs.put("c2.android.h264.decoder", 70);
        mTestHWCodecs.put("c2.android.hevc.decoder", 70);
        return mTestHWCodecs;
    }

    public static AJMediaCodecRank setupRank(MediaCodecInfo codecInfo, String codecType, int useCodec2) {
        int i;
        if (codecInfo == null) {
            return null;
        }
        String name = codecInfo.getName();
        if (TextUtils.isEmpty(name)) {
            return null;
        }
        Integer num = getTestHWcodecs().get(name);
        if (num != null) {
            i = num.intValue();
        } else {
            try {
                if (codecInfo.getCapabilitiesForType(codecType) != null) {
                    if (TTPlayerConfiger.getValue(48, 0) == 1 || useCodec2 == 1) {
                        if (name.startsWith("c2.")) {
                            i = 150;
                        }
                    }
                    i = 70;
                }
            } catch (Exception unused) {
            }
            i = 60;
        }
        AJMediaCodecRank aJMediaCodecRank = new AJMediaCodecRank();
        aJMediaCodecRank.mMediaCodecInfo = codecInfo;
        aJMediaCodecRank.mCodecType = codecType;
        aJMediaCodecRank.mRank = i;
        return aJMediaCodecRank;
    }
}
