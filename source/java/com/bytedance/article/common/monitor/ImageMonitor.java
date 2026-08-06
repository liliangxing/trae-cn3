package com.bytedance.article.common.monitor;

import com.bytedance.apm.ApmContext;
import org.json.JSONObject;

@Deprecated
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ImageMonitor {
    private ImageMonitor() {
    }

    public static ImageMonitor getInstance() {
        return Holder.sInstance;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    private static class Holder {
        private static final ImageMonitor sInstance = new ImageMonitor();

        private Holder() {
        }
    }

    public void monitorImageSample(String str, int i, String str2, long j, JSONObject jSONObject) {
        if (ApmContext.isDebugMode()) {
            throw new RuntimeException("ImageMonitor has not worked, please use ByteFresco or ByteGlide");
        }
    }
}
