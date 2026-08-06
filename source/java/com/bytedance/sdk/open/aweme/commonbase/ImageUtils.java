package com.bytedance.sdk.open.aweme.commonbase;

import android.content.Context;
import com.bytedance.sdk.open.aweme.core.OpenImageService;
import com.bytedance.sdk.open.aweme.core.OpenServiceManager;
import com.bytedance.sdk.open.aweme.core.image.LoadImageOptions;

/* loaded from: classes5.dex */
public class ImageUtils {
    public static void loadImage(Context context, LoadImageOptions loadImageOptions) {
        OpenImageService openImageService = (OpenImageService) OpenServiceManager.getInst().getService(OpenImageService.class);
        if (openImageService == null) {
            return;
        }
        openImageService.loadImage(context, loadImageOptions);
    }
}
