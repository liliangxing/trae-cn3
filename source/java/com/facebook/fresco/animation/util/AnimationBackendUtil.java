package com.facebook.fresco.animation.util;

import com.facebook.imagepipeline.core.ImagePipelineFactory;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class AnimationBackendUtil {
    public static boolean isUseIndividualCacheForCurrentAnimHeifRequest(boolean z) {
        return ImagePipelineFactory.getInstance().isAnimatedHeifIndividualCacheEnabled() || (z && ImagePipelineFactory.getInstance().isAnimatedHeifIndividualCacheForImageRequestEnabled());
    }
}
