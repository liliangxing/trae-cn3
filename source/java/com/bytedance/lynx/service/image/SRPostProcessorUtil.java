package com.bytedance.lynx.service.image;

import com.bytedance.fresco.sr.SRPostProcessor;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SRPostProcessorUtil {
    private static volatile SRPostProcessor sSrPostProcessor;

    public static SRPostProcessor getSRPostProcessorInstance() {
        if (sSrPostProcessor == null) {
            sSrPostProcessor = new SRPostProcessor(32768, true);
        }
        return sSrPostProcessor;
    }
}
