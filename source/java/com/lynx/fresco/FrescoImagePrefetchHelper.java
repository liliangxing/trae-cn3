package com.lynx.fresco;

import android.graphics.Bitmap;
import android.net.Uri;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.lynx.tasm.ui.image.ImageUtils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class FrescoImagePrefetchHelper {
    public static final String PRIORITY_HIGH = "high";
    public static final String PRIORITY_LOW = "low";

    public static DataSource<Void> prefetchImageToBitmapCache(String str, Bitmap.Config config, Object obj) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        Uri parse = Uri.parse(str);
        if (parse.getScheme() == null) {
            return null;
        }
        return Fresco.getImagePipeline().prefetchToBitmapCache(ImageUtils.getImageRequestBuilder(parse, config, false).build(), obj);
    }
}
