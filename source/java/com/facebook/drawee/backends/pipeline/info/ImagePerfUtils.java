package com.facebook.drawee.backends.pipeline.info;

import com.bytedance.trae.im.model.ConfirmInfo;

/* loaded from: classes6.dex */
public class ImagePerfUtils {
    public static String toString(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "unknown" : "error" : ConfirmInfo.STATUS_CANCELED : "success" : "intermediate_available" : "origin_available" : "requested";
    }

    private ImagePerfUtils() {
    }
}
