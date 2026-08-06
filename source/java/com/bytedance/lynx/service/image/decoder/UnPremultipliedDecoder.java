package com.bytedance.lynx.service.image.decoder;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import com.bytedance.fresco.heif.HeifDecoder;
import com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.QualityInfo;
import java.util.Objects;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class UnPremultipliedDecoder implements ImageDecoder {
    public CloseableImage decode(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
        Bitmap decodeStream;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        options.inPremultiplied = false;
        if (Objects.equals(encodedImage.getImageFormat().getFileExtension(), "heic")) {
            decodeStream = HeifDecoder.sBitmapFactory.decodeStream(encodedImage.getInputStream(), (Rect) null, options);
        } else {
            decodeStream = BitmapFactory.decodeStream(encodedImage.getInputStream(), null, options);
        }
        return new CloseableStaticBitmap(decodeStream, SimpleBitmapReleaser.getInstance(), qualityInfo, encodedImage.getRotationAngle());
    }
}
