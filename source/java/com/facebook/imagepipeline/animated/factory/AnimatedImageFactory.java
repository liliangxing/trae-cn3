package com.facebook.imagepipeline.animated.factory;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.EncodedImage;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public interface AnimatedImageFactory {
    CloseableImage decodeGif(EncodedImage encodedImage, ImageDecodeOptions imageDecodeOptions, Bitmap.Config config);

    CloseableImage decodeHeif(EncodedImage encodedImage, ImageDecodeOptions imageDecodeOptions, Bitmap.Config config);

    CloseableImage decodeWebP(EncodedImage encodedImage, ImageDecodeOptions imageDecodeOptions, Bitmap.Config config);
}
