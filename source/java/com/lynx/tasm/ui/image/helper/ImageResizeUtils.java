package com.lynx.tasm.ui.image.helper;

import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.lynx.tasm.ui.image.ImageResizeMethod;

/* loaded from: classes7.dex */
public class ImageResizeUtils {
    public static ResizeOptions getResizeOptions(int i, int i2, int i3, int i4) {
        if (i3 <= 0 || i4 <= 0 || Math.abs(i - i3) > 1 || Math.abs(i2 - i4) > 1) {
            return new ResizeOptions(i, i2);
        }
        return new ResizeOptions(i3, i4);
    }

    public static boolean shouldResize(ImageSource imageSource, ImageResizeMethod imageResizeMethod) {
        if (imageSource == null) {
            return false;
        }
        return imageResizeMethod == ImageResizeMethod.AUTO ? UriUtil.isLocalContentUri(imageSource.getUri()) || UriUtil.isLocalFileUri(imageSource.getUri()) : imageResizeMethod == ImageResizeMethod.RESIZE;
    }
}
