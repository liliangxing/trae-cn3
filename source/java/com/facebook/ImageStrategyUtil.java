package com.facebook;

import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.utils.ImageCenterStrategy;
import com.ss.ttvideoengine.TTVideoEngine;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class ImageStrategyUtil {
    public void test(String str, Object obj) {
        ImageRequestBuilder.newBuilderWithSource(Uri.parse(""));
        HashMap hashMap = new HashMap();
        hashMap.put("scene_tag", obj);
        TTVideoEngine.getImageStrategyResult(str, hashMap);
    }

    public static void setUseImageCenterStrategy(boolean z) {
        if (z) {
            ImageCenterStrategy.setStrategy(new ImageCenterStrategy() { // from class: com.facebook.ImageStrategyUtil.1
                @Override // com.facebook.imagepipeline.utils.ImageCenterStrategy
                public Map<String, Object> getImageStrategyResult(String str, Map<String, Object> map) {
                    return TTVideoEngine.getImageStrategyResult(str, map);
                }
            });
        } else {
            ImageCenterStrategy.setStrategy(null);
        }
    }
}
