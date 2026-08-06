package com.bytedance.lynx.service.image.decoder;

import android.graphics.Movie;
import com.bytedance.lynx.service.image.decoder.GifMetadataDecoder;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.image.CloseableAnimatedImage;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.QualityInfo;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class GifDecoder implements ImageDecoder {
    private final boolean mUseSimpleDecoder;

    public GifDecoder() {
        this(true);
    }

    public GifDecoder(boolean z) {
        this.mUseSimpleDecoder = z;
    }

    public CloseableImage decode(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
        InputStream inputStream = encodedImage.getInputStream();
        try {
            Movie decodeStream = Movie.decodeStream(inputStream);
            MovieDrawer movieDrawer = new MovieDrawer(decodeStream);
            inputStream.reset();
            try {
                try {
                    GifMetadataDecoder create = GifMetadataDecoder.Factory.create(this.mUseSimpleDecoder, decodeStream, inputStream);
                    int frameCount = create.getFrameCount();
                    MovieFrame[] movieFrameArr = new MovieFrame[frameCount];
                    int i2 = 0;
                    int i3 = 0;
                    while (i3 < frameCount) {
                        int frameDurationMs = create.getFrameDurationMs(i3);
                        int i4 = i2 + frameDurationMs;
                        movieFrameArr[i3] = new MovieFrame(movieDrawer, i4, frameDurationMs, decodeStream.width(), decodeStream.height(), create.getFrameDisposal(i3));
                        i3++;
                        i2 = i4;
                    }
                    CloseableAnimatedImage closeableAnimatedImage = new CloseableAnimatedImage(AnimatedImageResult.forAnimatedImage(new MovieAnimatedImage(movieFrameArr, encodedImage.getSize(), decodeStream.duration(), create.getLoopCount())), imageDecodeOptions, encodedImage.getImageFormat());
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                    return closeableAnimatedImage;
                } catch (IOException e) {
                    e = e;
                    throw new RuntimeException("Error while decoding gif", e);
                }
            } catch (Throwable th) {
                th = th;
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
        } catch (Throwable th2) {
            th = th2;
            inputStream.close();
            throw th;
        }
    }
}
